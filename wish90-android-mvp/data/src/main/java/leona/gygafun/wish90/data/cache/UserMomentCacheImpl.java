/**
   Wish 90: The new age wishing app
 Skeleton Credit: http://fernandocejas.com/2014/09/03/architecting-android-the-clean-way/
 */
package leona.gygafun.wish90.data.cache;

import android.content.Context;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import leona.gygafun.wish90.data.cache.serializer.JsonSerializer;
import leona.gygafun.wish90.data.entity.UserEntity;
import leona.gygafun.wish90.data.entity.UserMomentEntity;
import leona.gygafun.wish90.data.entity.mapper.UserEntityJsonMapper;
import leona.gygafun.wish90.data.exception.UserNotFoundException;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;
import rx.Observable;
import rx.Subscriber;

/**
 * {@link UserCache} implementation.
 */
@Singleton
public class UserMomentCacheImpl extends DefaultFileCacheImpl implements UserMomentCache {


    private static final String DEFAULT_FILE_NAME = "user_";
    private static final long EXPIRATION_TIME = 60 * 10 * 1000;
    private static final String CACHE_SUFFIX = "usermoment";

    private final UserEntityJsonMapper userEntityJsonMapper;
    @Inject
    public UserMomentCacheImpl(Context context, JsonSerializer userCacheSerializer,
                               FileManager fileManager, ThreadExecutor executor,UserEntityJsonMapper userEntityJsonMapper) {

        super(context, userCacheSerializer, fileManager, executor);
        this.userEntityJsonMapper=userEntityJsonMapper;

    }

    @Override
    public synchronized Observable<List<UserMomentEntity>> getAll() {
        return Observable.create(new Observable.OnSubscribe<List<UserMomentEntity>>() {
            @Override
            public void call(Subscriber<? super List<UserMomentEntity>> subscriber) {
                File userEntityFile = UserMomentCacheImpl.this.buildFile(CACHE_SUFFIX);
                String fileContent = UserMomentCacheImpl.this.fileManager.readFileContent(userEntityFile);

                if (fileContent != null) {
                    subscriber.onNext(userEntityJsonMapper.transformUserMomentEntityCollection(
                            fileContent));
                    subscriber.onCompleted();
                } else {
                    subscriber.onError(new UserNotFoundException());
                }
            }
        });
    }

    @Override
    public synchronized void put(UserMomentEntity userEntity) {
        if (userEntity != null) {
            File userEntitiyFile = this.buildFile(CACHE_SUFFIX);
//            if (!isCached(userEntity.getUserID())) {
//                String jsonString = this.serializer.serialize(userEntity);
//                this.executeAsynchronously(new CacheWriter(this.fileManager, userEntitiyFile,
//                        jsonString));
//                setLastCacheUpdateTimeMillis();
//            }
        }
    }

    @Override
    protected String getCacheFileName() {
        return DEFAULT_FILE_NAME;
    }
}
