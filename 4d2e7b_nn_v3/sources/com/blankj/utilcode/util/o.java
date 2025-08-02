package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.Thread;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f18401a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private static final Map f18402b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Map f18403c = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int f18404d = Runtime.getRuntime().availableProcessors();

    /* renamed from: e  reason: collision with root package name */
    private static final Timer f18405e = new Timer();

    static final class b extends ThreadPoolExecutor {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f18408a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        private a f18409b;

        b(int i10, int i11, long j10, TimeUnit timeUnit, a aVar, ThreadFactory threadFactory) {
            super(i10, i11, j10, timeUnit, aVar, threadFactory);
            b unused = aVar.f18406a = this;
            this.f18409b = aVar;
        }

        /* access modifiers changed from: private */
        public static ExecutorService b(int i10, int i11) {
            int i12 = i10;
            int i13 = i11;
            if (i12 == -8) {
                return new b(o.f18404d + 1, (o.f18404d * 2) + 1, 30, TimeUnit.SECONDS, new a(true), new c("cpu", i13));
            } else if (i12 == -4) {
                return new b((o.f18404d * 2) + 1, (o.f18404d * 2) + 1, 30, TimeUnit.SECONDS, new a(), new c("io", i13));
            } else {
                if (i12 == -2) {
                    return new b(0, 128, 60, TimeUnit.SECONDS, new a(true), new c("cached", i13));
                } else if (i12 == -1) {
                    return new b(1, 1, 0, TimeUnit.MILLISECONDS, new a(), new c("single", i13));
                } else {
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    a aVar = new a();
                    return new b(i10, i10, 0, timeUnit, aVar, new c("fixed(" + i12 + ")", i13));
                }
            }
        }

        /* access modifiers changed from: protected */
        public void afterExecute(Runnable runnable, Throwable th) {
            this.f18408a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public void execute(Runnable runnable) {
            if (!isShutdown()) {
                this.f18408a.incrementAndGet();
                try {
                    super.execute(runnable);
                } catch (RejectedExecutionException unused) {
                    Log.e("ThreadUtils", "This will not happen!");
                    this.f18409b.offer(runnable);
                } catch (Throwable unused2) {
                    this.f18408a.decrementAndGet();
                }
            }
        }
    }

    static final class c extends AtomicLong implements ThreadFactory {

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicInteger f18410d = new AtomicInteger(1);

        /* renamed from: a  reason: collision with root package name */
        private final String f18411a;

        /* renamed from: b  reason: collision with root package name */
        private final int f18412b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f18413c;

        class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            public void run() {
                try {
                    super.run();
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                }
            }
        }

        class b implements Thread.UncaughtExceptionHandler {
            b() {
            }

            public void uncaughtException(Thread thread, Throwable th) {
                System.out.println(th);
            }
        }

        c(String str, int i10) {
            this(str, i10, false);
        }

        public Thread newThread(Runnable runnable) {
            a aVar = new a(runnable, this.f18411a + getAndIncrement());
            aVar.setDaemon(this.f18413c);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.f18412b);
            return aVar;
        }

        c(String str, int i10, boolean z10) {
            this.f18411a = str + "-pool-" + f18410d.getAndIncrement() + "-thread-";
            this.f18412b = i10;
            this.f18413c = z10;
        }
    }

    public static ExecutorService b() {
        return c(-2);
    }

    private static ExecutorService c(int i10) {
        return d(i10, 5);
    }

    private static ExecutorService d(int i10, int i11) {
        ExecutorService executorService;
        Map map = f18402b;
        synchronized (map) {
            try {
                Map map2 = (Map) map.get(Integer.valueOf(i10));
                if (map2 == null) {
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    executorService = b.b(i10, i11);
                    concurrentHashMap.put(Integer.valueOf(i11), executorService);
                    map.put(Integer.valueOf(i10), concurrentHashMap);
                } else {
                    executorService = (ExecutorService) map2.get(Integer.valueOf(i11));
                    if (executorService == null) {
                        executorService = b.b(i10, i11);
                        map2.put(Integer.valueOf(i11), executorService);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static void e(Runnable runnable, long j10) {
        f18401a.postDelayed(runnable, j10);
    }

    private static final class a extends LinkedBlockingQueue {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public volatile b f18406a;

        /* renamed from: b  reason: collision with root package name */
        private int f18407b = Integer.MAX_VALUE;

        a() {
        }

        /* renamed from: c */
        public boolean offer(Runnable runnable) {
            if (this.f18407b > size() || this.f18406a == null || this.f18406a.getPoolSize() >= this.f18406a.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        a(boolean z10) {
            if (z10) {
                this.f18407b = 0;
            }
        }
    }
}
