package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public final class GlideExecutor implements ExecutorService {
    static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;
        private int corePoolSize;
        private int maximumPoolSize;
        private String name;
        private final boolean preventNetworkOperations;
        @NonNull
        private final ThreadFactory threadFactory = new DefaultPriorityThreadFactory();
        private long threadTimeoutMillis;
        @NonNull
        private UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;

        Builder(boolean z10) {
            this.preventNetworkOperations = z10;
        }

        public GlideExecutor build() {
            if (!TextUtils.isEmpty(this.name)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.threadFactory, this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
                if (this.threadTimeoutMillis != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new GlideExecutor(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public Builder setThreadCount(@IntRange(from = 1) int i10) {
            this.corePoolSize = i10;
            this.maximumPoolSize = i10;
            return this;
        }

        public Builder setThreadTimeoutMillis(long j10) {
            this.threadTimeoutMillis = j10;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(@NonNull UncaughtThrowableStrategy uncaughtThrowableStrategy2) {
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy2;
            return this;
        }
    }

    private static final class DefaultPriorityThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;

        private DefaultPriorityThreadFactory() {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable) {
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private final ThreadFactory delegate;
        private final String name;
        final boolean preventNetworkOperations;
        private final AtomicInteger threadNum = new AtomicInteger();
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        DefaultThreadFactory(ThreadFactory threadFactory, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy2, boolean z10) {
            this.delegate = threadFactory;
            this.name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy2;
            this.preventNetworkOperations = z10;
        }

        public Thread newThread(@NonNull final Runnable runnable) {
            Thread newThread = this.delegate.newThread(new Runnable() {
                public void run() {
                    if (DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th);
                    }
                }
            });
            newThread.setName("glide-" + this.name + "-thread-" + this.threadNum.getAndIncrement());
            return newThread;
        }
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() {
            public void handle(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW = new UncaughtThrowableStrategy() {
            public void handle(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        };

        static {
            AnonymousClass2 r02 = new UncaughtThrowableStrategy() {
                public void handle(Throwable th) {
                    if (th != null && Log.isLoggable(GlideExecutor.TAG, 6)) {
                        Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th);
                    }
                }
            };
            LOG = r02;
            DEFAULT = r02;
        }

        void handle(Throwable th);
    }

    @VisibleForTesting
    GlideExecutor(ExecutorService executorService) {
        this.delegate = executorService;
    }

    static int calculateAnimationExecutorThreadCount() {
        if (calculateBestThreadCount() >= 4) {
            return 2;
        }
        return 1;
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount == 0) {
            bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
        }
        return bestThreadCount;
    }

    public static Builder newAnimationBuilder() {
        return new Builder(true).setThreadCount(calculateAnimationExecutorThreadCount()).setName(DEFAULT_ANIMATION_EXECUTOR_NAME);
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName("source");
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(new DefaultPriorityThreadFactory(), DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    public boolean awaitTermination(long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j10, timeUnit);
    }

    public void execute(@NonNull Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return this.delegate.invokeAny(collection);
    }

    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    public void shutdown() {
        this.delegate.shutdown();
    }

    @NonNull
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    public String toString() {
        return this.delegate.toString();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int i10, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newAnimationBuilder().setThreadCount(i10).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j10, timeUnit);
    }

    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j10, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.delegate.invokeAny(collection, j10, timeUnit);
    }

    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t10) {
        return this.delegate.submit(runnable, t10);
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int i10, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setThreadCount(i10).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int i10, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setThreadCount(i10).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.delegate.submit(callable);
    }
}
