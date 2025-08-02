package com.alibaba.pdns.pools;

import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private static final int f18166b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f18167c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f18168d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f18169e = 160;

    /* renamed from: f  reason: collision with root package name */
    private static final int f18170f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final AtomicInteger f18171g = new AtomicInteger(0);

    /* renamed from: h  reason: collision with root package name */
    private static final ThreadFactory f18172h = new a();

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<Runnable> f18173i = new C0232b();

    /* renamed from: j  reason: collision with root package name */
    private static final Comparator<Runnable> f18174j = new c();

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f18175a;

    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f18176a = new AtomicInteger(1);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "xTID#" + this.f18176a.getAndIncrement());
        }
    }

    /* renamed from: com.alibaba.pdns.pools.b$b  reason: collision with other inner class name */
    static class C0232b implements Comparator<Runnable> {
        C0232b() {
        }

        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof c) || !(runnable2 instanceof c)) {
                return 0;
            }
            c cVar = (c) runnable;
            c cVar2 = (c) runnable2;
            int ordinal = cVar.f18178b.ordinal() - cVar2.f18178b.ordinal();
            return ordinal == 0 ? (int) (cVar.f18177a - cVar2.f18177a) : ordinal;
        }
    }

    static class c implements Comparator<Runnable> {
        c() {
        }

        public int compare(Runnable runnable, Runnable runnable2) {
            if (!(runnable instanceof c) || !(runnable2 instanceof c)) {
                return 0;
            }
            c cVar = (c) runnable;
            c cVar2 = (c) runnable2;
            int ordinal = cVar.f18178b.ordinal() - cVar2.f18178b.ordinal();
            return ordinal == 0 ? (int) (cVar2.f18177a - cVar.f18177a) : ordinal;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int i10 = availableProcessors * 2;
        f18166b = i10;
        f18167c = i10 + 1;
        f18168d = (availableProcessors * 4) + 1;
    }

    public b(boolean z10) {
        this(f18167c, z10);
    }

    public int a() {
        return this.f18175a.getCorePoolSize();
    }

    public ThreadPoolExecutor b() {
        return this.f18175a;
    }

    public boolean c() {
        if (this.f18175a.getActiveCount() >= this.f18175a.getCorePoolSize()) {
            return true;
        }
        return false;
    }

    public void execute(Runnable runnable) {
        if (runnable instanceof c) {
            ((c) runnable).f18177a = (long) f18171g.getAndIncrement();
        }
        this.f18175a.execute(runnable);
    }

    public b(int i10, boolean z10) {
        this.f18175a = new ThreadPoolExecutor(i10, f18168d, 0, TimeUnit.SECONDS, new PriorityBlockingQueue(f18169e, z10 ? f18173i : f18174j), f18172h, new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public void a(int i10) {
        if (i10 > 0) {
            this.f18175a.setCorePoolSize(i10);
        }
    }

    public Future<?> b(Runnable runnable) {
        if (runnable instanceof c) {
            ((c) runnable).f18177a = (long) f18171g.getAndIncrement();
        }
        return this.f18175a.submit(runnable);
    }
}
