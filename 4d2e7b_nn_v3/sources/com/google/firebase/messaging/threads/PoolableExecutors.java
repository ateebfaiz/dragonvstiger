package com.google.firebase.messaging.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolableExecutors {
    private static final ExecutorFactory DEFAULT_INSTANCE;
    private static volatile ExecutorFactory instance;

    private static class b implements ExecutorFactory {
        private b() {
        }

        public void executeOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable) {
            new Thread(runnable, str2).start();
        }

        public ScheduledExecutorService newScheduledThreadPool(int i10, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i10));
        }

        public ExecutorService newSingleThreadExecutor(ThreadPriority threadPriority) {
            return newThreadPool(1, threadPriority);
        }

        public ExecutorService newThreadPool(ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        }

        public Future submitOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable) {
            FutureTask futureTask = new FutureTask(runnable, (Object) null);
            new Thread(futureTask, str2).start();
            return futureTask;
        }

        public ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return newThreadPool(1, threadFactory, threadPriority);
        }

        public ExecutorService newThreadPool(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(threadFactory));
        }

        public ScheduledExecutorService newScheduledThreadPool(int i10, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i10, threadFactory));
        }

        public ExecutorService newThreadPool(int i10, ThreadPriority threadPriority) {
            return newThreadPool(i10, Executors.defaultThreadFactory(), threadPriority);
        }

        public ExecutorService newThreadPool(int i10, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i10, i10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        instance = bVar;
    }

    private PoolableExecutors() {
    }

    public static ExecutorFactory factory() {
        return instance;
    }

    static void installExecutorFactory(ExecutorFactory executorFactory) {
        if (instance == DEFAULT_INSTANCE) {
            instance = executorFactory;
            return;
        }
        throw new IllegalStateException("Trying to install an ExecutorFactory twice!");
    }
}
