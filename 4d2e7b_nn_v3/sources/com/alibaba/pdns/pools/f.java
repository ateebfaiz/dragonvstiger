package com.alibaba.pdns.pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class f {

    static class a implements RejectedExecutionHandler {
        a() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            threadPoolExecutor.remove(runnable);
        }
    }

    static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18201b;

        b(String str, boolean z10) {
            this.f18200a = str;
            this.f18201b = z10;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f18200a);
            thread.setDaemon(this.f18201b);
            return thread;
        }
    }

    static class c implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f18202a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f18203b;

        c(String str, boolean z10) {
            this.f18202a = str;
            this.f18203b = z10;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f18202a);
            thread.setDaemon(this.f18203b);
            return thread;
        }
    }

    private static class d implements ThreadFactory {

        /* renamed from: c  reason: collision with root package name */
        private static final String f18204c = "pa_udf_thread_pool_";

        /* renamed from: d  reason: collision with root package name */
        private static AtomicInteger f18205d = new AtomicInteger();

        /* renamed from: a  reason: collision with root package name */
        private String f18206a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f18207b;

        public d(String str, boolean z10) {
            this.f18206a = str;
            this.f18207b = z10;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(f18204c + this.f18206a + "#" + f18205d.getAndIncrement());
            thread.setDaemon(this.f18207b);
            return thread;
        }
    }

    public static ExecutorService a(int i10, int i11, long j10, String str, boolean z10) {
        return new ThreadPoolExecutor(i10, i11, j10, TimeUnit.SECONDS, new LinkedBlockingDeque(), new d(str, z10), new a());
    }

    public static ScheduledExecutorService b(String str, boolean z10) {
        return Executors.newSingleThreadScheduledExecutor(new c(str, z10));
    }

    public static ExecutorService a(String str, boolean z10) {
        return Executors.newSingleThreadExecutor(new b(str, z10));
    }
}
