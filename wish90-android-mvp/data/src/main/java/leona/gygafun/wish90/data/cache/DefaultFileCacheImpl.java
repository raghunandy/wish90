package leona.gygafun.wish90.data.cache;

import android.content.Context;

import java.io.File;

import leona.gygafun.wish90.data.cache.serializer.JsonSerializer;
import leona.gygafun.wish90.domain.executor.ThreadExecutor;

/**
 * Created by Raghu on 11/14/2015.
 */
public abstract class DefaultFileCacheImpl implements DefaultFileCache {




    protected final Context context;
    protected final File cacheDir;
    protected final JsonSerializer serializer;
    protected final FileManager fileManager;
    protected final ThreadExecutor threadExecutor;


    public DefaultFileCacheImpl(Context context, JsonSerializer userCacheSerializer,
                                FileManager fileManager, ThreadExecutor executor){
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
    public synchronized void evictAll() {
        this.executeAsynchronously(new CacheEvictor(this.fileManager, this.cacheDir));
    }

    /**
     * Build a file, used to be inserted in the disk cache.
     *
     * @param suffix The id suffix to build the file.
     * @return A valid file.
     */
    protected File buildFile(String suffix) {
        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(this.cacheDir.getPath());
        fileNameBuilder.append(File.separator);
        fileNameBuilder.append(getCacheFileName());
        fileNameBuilder.append(suffix);

        return new File(fileNameBuilder.toString());
    }

    protected abstract String getCacheFileName();


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
