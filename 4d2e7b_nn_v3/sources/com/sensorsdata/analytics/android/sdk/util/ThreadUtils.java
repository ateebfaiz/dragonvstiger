package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadUtils {
    private static final String TAG = "SA.ThreadUtils";
    private static final Map<Integer, Map<Integer, ExecutorService>> TYPE_PRIORITY_POOLS = new HashMap();
    private static final byte TYPE_SINGLE = -1;

    private static final class LinkedBlockingQueueUtil extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        /* access modifiers changed from: private */
        public volatile ThreadPoolExecutorUtil mPool;

        LinkedBlockingQueueUtil() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        public boolean offer(Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        LinkedBlockingQueueUtil(boolean z10) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z10) {
                this.mCapacity = 0;
            }
        }

        LinkedBlockingQueueUtil(int i10) {
            this.mCapacity = i10;
        }
    }

    static final class ThreadPoolExecutorUtil extends ThreadPoolExecutor {
        private final AtomicInteger mSubmittedCount = new AtomicInteger();
        private LinkedBlockingQueueUtil mWorkQueue;

        ThreadPoolExecutorUtil(int i10, int i11, long j10, TimeUnit timeUnit, LinkedBlockingQueueUtil linkedBlockingQueueUtil, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, linkedBlockingQueueUtil, threadFactory);
            ThreadPoolExecutorUtil unused = linkedBlockingQueueUtil.mPool = this;
            this.mWorkQueue = linkedBlockingQueueUtil;
        }

        /* access modifiers changed from: private */
        public static ExecutorService createPool(int i10, int i11) {
            int i12 = i10;
            int i13 = i11;
            if (i12 == -1) {
                return new ThreadPoolExecutorUtil(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueueUtil(), new UtilsThreadFactory("single", i13));
            }
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            LinkedBlockingQueueUtil linkedBlockingQueueUtil = new LinkedBlockingQueueUtil();
            return new ThreadPoolExecutorUtil(i10, i10, 0, timeUnit, linkedBlockingQueueUtil, new UtilsThreadFactory("fixed(" + i12 + ")", i13));
        }

        private int getSubmittedCount() {
            return this.mSubmittedCount.get();
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            this.mSubmittedCount.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public void execute(Runnable runnable) {
            if (!isShutdown()) {
                this.mSubmittedCount.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    SALog.i(ThreadUtils.TAG, "This will not happen!");
                    this.mWorkQueue.offer(runnable);
                } catch (Throwable unused2) {
                    this.mSubmittedCount.decrementAndGet();
                }
            }
        }
    }

    static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        UtilsThreadFactory(String str, int i10) {
            this(str, i10, false);
        }

        public Thread newThread(Runnable runnable) {
            AnonymousClass1 r02 = new Thread(runnable, this.namePrefix + getAndIncrement()) {
                public void run() {
                    try {
                        super.run();
                    } catch (Throwable unused) {
                        SALog.i("ThreadUtils", "Request threw uncaught throwable");
                    }
                }
            };
            r02.setDaemon(this.isDaemon);
            r02.setPriority(this.priority);
            return r02;
        }

        UtilsThreadFactory(String str, int i10, boolean z10) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i10;
            this.isDaemon = z10;
        }
    }

    private static ExecutorService getPoolByTypeAndPriority(int i10) {
        return getPoolByTypeAndPriority(i10, 5);
    }

    public static ExecutorService getSinglePool() {
        return getPoolByTypeAndPriority(-1);
    }

    private static ExecutorService getPoolByTypeAndPriority(int i10, int i11) {
        ExecutorService executorService;
        Map<Integer, Map<Integer, ExecutorService>> map = TYPE_PRIORITY_POOLS;
        synchronized (map) {
            try {
                Map map2 = map.get(Integer.valueOf(i10));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorService = ThreadPoolExecutorUtil.createPool(i10, i11);
                    concurrentHashMap.put(Integer.valueOf(i11), executorService);
                    map.put(Integer.valueOf(i10), concurrentHashMap);
                } else {
                    executorService = (ExecutorService) map2.get(Integer.valueOf(i11));
                    if (executorService == null) {
                        executorService = ThreadPoolExecutorUtil.createPool(i10, i11);
                        map2.put(Integer.valueOf(i11), executorService);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static ExecutorService getSinglePool(int i10) {
        return getPoolByTypeAndPriority(-1, i10);
    }
}
