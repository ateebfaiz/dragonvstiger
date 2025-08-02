package com.zing.zalo.zalosdk.core;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ZTaskExecutor {
    private static ThreadPoolExecutor mExecutor;

    static class MyThreadFactory implements ThreadFactory {
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        public MyThreadFactory(String str) {
            this.namePrefix = "pool-" + str + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.namePrefix + this.threadNumber.getAndIncrement());
            thread.setPriority(10);
            return thread;
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(100));
        mExecutor = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new MyThreadFactory("TaskExecutor"));
        mExecutor.allowCoreThreadTimeOut(true);
    }

    public static void queueRunnable(Runnable runnable) {
        if (mExecutor.getQueue().remainingCapacity() > 0) {
            mExecutor.execute(runnable);
        }
    }
}
