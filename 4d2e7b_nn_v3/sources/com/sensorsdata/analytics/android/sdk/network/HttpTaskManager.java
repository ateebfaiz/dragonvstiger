package com.sensorsdata.analytics.android.sdk.network;

import com.sensorsdata.analytics.android.sdk.core.tasks.ThreadNameConstants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class HttpTaskManager {
    private static final int POOL_SIZE = 2;
    private static volatile ExecutorService executor;

    static class ThreadFactoryWithName implements ThreadFactory {
        private final String name;

        ThreadFactoryWithName(String str) {
            this.name = str;
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.name);
        }
    }

    private HttpTaskManager() {
    }

    static void execute(Runnable runnable) {
        getInstance().execute(runnable);
    }

    private static ExecutorService getInstance() {
        if (executor == null) {
            synchronized (HttpTaskManager.class) {
                try {
                    if (executor == null) {
                        executor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactoryWithName(ThreadNameConstants.THREAD_DEEP_LINK_REQUEST));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return executor;
    }
}
