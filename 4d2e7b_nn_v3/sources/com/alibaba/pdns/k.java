package com.alibaba.pdns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final int f17957a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f17958b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    private static final int f17959c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final TimeUnit f17960d;

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f17961e;

    /* renamed from: f  reason: collision with root package name */
    private static final ExecutorService f17962f;

    static class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(false);
            return thread;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f17960d = timeUnit;
        a aVar = new a();
        f17961e = aVar;
        f17962f = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, timeUnit, new SynchronousQueue(), aVar);
    }

    public static ExecutorService a() {
        return f17962f;
    }
}
