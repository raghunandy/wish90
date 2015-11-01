/**
   Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.cache;

import android.content.Context;

import leona.gygafun.wish90.data.cache.serializer.JsonSerializer;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.exception.UserNotFoundException;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

/**
 * {@link UserCache} implementation.
 */
@Singleton
public class UserCacheImpl implements UserCache {

    private static final String SETTINGS_FILE_NAME = "leona.gygafun.wish90.android10.SETTINGS";
    private static final String SETTINGS_KEY_LAST_CACHE_UPDATE = "last_cache_update";

    private static final String DEFAULT_FILE_NAME = "user_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;

    private final Context context;
    private final File cacheDir;
    private final JsonSerializer serializer;
    private final FileManager fileManager;
    private final ThreadExecutor threadExecutor;

    /**
     * Constructor of the class {@link UserCacheImpl}.
     *
     * @param context A
     * @param userCacheSerializer {@link JsonSerializer} for object serialization.
     * @param fileManager {@link FileManager} for saving serialized objects to the file system.
     */
    @Inject
    public UserCacheImpl(Context context, JsonSerializer userCacheSerializer,
                         FileManager fileManager, ThreadExecutor executor) {
        if (context == null || userCacheSerializer == null || fileManager == null || executor == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        this.context = context.getApplicationContext();
        this.cacheDir = this.context.getCacheDir();
        this.serializer = userCacheSerializer;
        this.fileManager = fileManager;
        this.threadExecutor = executor;
    }

    @Override
    public synchronized Observable<UserEntity> get(final int userId) {
        return Observable.create(new Observable.OnSubscribe<UserEntity>() {
            @Override
            public void call(Subscriber<? super UserEntity> subscriber) {
                File userEntityFile = UserCacheImpl.this.buildFile(userId);
                String fileContent = UserCacheImpl.this.fileManager.readFileContent(userEntityFile);
                UserEntity userEntity = UserCacheImpl.this.serializer.deserialize(fileContent);

                if (userEntity != null) {
                    subscriber.onNext(userEntity);
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new UserNotFoundException());
                }
            }
        });
    }

    @Override
    public synchronized void put(UserEntity userEntity) {
        if (userEntity != null) {
            File userEntitiyFile = this.buildFile(userEntity.getUserID());
            if (!isCached(userEntity.getUserID())) {
                String jsonString = this.serializer.serialize(userEntity);
                this.executeAsynchronously(new CacheWriter(this.fileManager, userEntitiyFile,
                        jsonString));
                setLastCacheUpdateTimeMillis();
            }
        }
    }

    @Override
    public boolean isCached(int userId) {
        File userEntitiyFile = this.buildFile(userId);
        return this.fileManager.exists(userEntitiyFile);
    }

    @Override
    public boolean isExpired() {
        long currentTime = System.currentTimeMillis();
        long lastUpdateTime = this.getLastCacheUpdateTimeMillis();

        boolean expired = ((currentTime - lastUpdateTime) > EXPIRATION_TIME);

        if (expired) {
            this.evictAll();
        }

        return expired;
    }

    @Override
    public synchronized void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
    }

    /**
     * Build a file, used to be inserted in the disk cache.
     *
     * @param userId The id user to build the file.
     * @return A valid file.
     */
    private File buildFile(int userId) {
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(DEFAULT_FILE_NAME);
        fileNameBuilder.append(userId);

        return new File(fileNameBuilder.toString());
    }

    /**
     * Set in millis, the last time the cache was accessed.
     */
    private void setLastCacheUpdateTimeMillis() {
        long currentMillis = System.currentTimeMillis();
        this.fileManager.writeToPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE, currentMillis);
    }

    /**
     * Get in millis, the last time the cache was accessed.
     */
    private long getLastCacheUpdateTimeMillis() {
        return this.fileManager.getFromPreferences(this.context, SETTINGS_FILE_NAME,
                SETTINGS_KEY_LAST_CACHE_UPDATE);
    }

    /**
     * Executes a {@link Runnable} in another Thread.
     *
     * @param runnable {@link Runnable} to execute
     */
    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

    /**
     * {@link Runnable} class for writing to disk.
     */
    private static class CacheWriter implements Runnable {
        private final FileManager fileManager;
        private final File fileToWrite;
        private final String fileContent;

        CacheWriter(FileManager fileManager, File fileToWrite, String fileContent) {
            this.fileManager = fileManager;
            this.fileToWrite = fileToWrite;
            this.fileContent = fileContent;
        }

        @Override
        public void run() {
            this.fileManager.writeToFile(fileToWrite, fileContent);
        }
    }

    /**
     * {@link Runnable} class for evicting all the cached files
     */
    private static class CacheEvictor implements Runnable {
        private final FileManager fileManager;
        private final File cacheDir;

        CacheEvictor(FileManager fileManager, File cacheDir) {
            this.fileManager = fileManager;
            this.cacheDir = cacheDir;
        }

        @Override
        public void run() {
            this.fileManager.clearDirectory(this.cacheDir);
        }
    }
}
