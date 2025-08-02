package com.alibaba.pdns.pools;

import android.app.Activity;
import android.os.Looper;
import com.alibaba.pdns.pools.Callback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f18146a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f18147b = "a";

    /* renamed from: com.alibaba.pdns.pools.a$a  reason: collision with other inner class name */
    class C0229a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f18148a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f18149b = new AtomicInteger(0);

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AbstractTask[] f18150c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Callback.b f18151d;

        C0229a(AbstractTask[] abstractTaskArr, Callback.b bVar) {
            this.f18150c = abstractTaskArr;
            this.f18151d = bVar;
            this.f18148a = abstractTaskArr.length;
        }

        public void run() {
            Callback.b bVar;
            if (this.f18149b.incrementAndGet() == this.f18148a && (bVar = this.f18151d) != null) {
                bVar.a();
            }
        }
    }

    class c implements Callback.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AbstractTask[] f18164a;

        c(AbstractTask[] abstractTaskArr) {
            this.f18164a = abstractTaskArr;
        }

        public boolean a() {
            boolean z10 = true;
            for (AbstractTask a10 : this.f18164a) {
                if (!a10.a()) {
                    z10 = false;
                }
            }
            return z10;
        }

        public void b() {
            for (AbstractTask b10 : this.f18164a) {
                b10.b();
            }
        }
    }

    private a() {
    }

    public static d a() {
        if (f18146a == null) {
            synchronized (d.class) {
                try {
                    if (f18146a == null) {
                        f18146a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18146a;
    }

    public void b(Runnable runnable) {
        if (runnable != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnable.run();
            } else {
                e.f18180k.post(runnable);
            }
        }
    }

    public Future<?> c(Runnable runnable) {
        return e.f18181l.b(runnable);
    }

    public void d(Runnable runnable) {
        if (runnable != null) {
            e.f18180k.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        Executors.newCachedThreadPool().execute(runnable);
    }

    public void execute(Runnable runnable) {
        e.f18181l.execute(runnable);
    }

    class b extends e<T> {

        /* renamed from: v  reason: collision with root package name */
        final /* synthetic */ Callback.b f18153v;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ AbstractTask f18154w;

        /* renamed from: x  reason: collision with root package name */
        final /* synthetic */ Runnable f18155x;

        /* renamed from: com.alibaba.pdns.pools.a$b$a  reason: collision with other inner class name */
        class C0230a implements Runnable {
            C0230a() {
            }

            public void run() {
                b bVar = b.this;
                Callback.b bVar2 = bVar.f18153v;
                if (bVar2 != null) {
                    bVar2.a(bVar.f18154w);
                }
            }
        }

        /* renamed from: com.alibaba.pdns.pools.a$b$b  reason: collision with other inner class name */
        class C0231b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Callback.CancelledException f18158a;

            C0231b(Callback.CancelledException cancelledException) {
                this.f18158a = cancelledException;
            }

            public void run() {
                b bVar = b.this;
                Callback.b bVar2 = bVar.f18153v;
                if (bVar2 != null) {
                    bVar2.a(bVar.f18154w, this.f18158a);
                }
            }
        }

        class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Throwable f18160a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f18161b;

            c(Throwable th, boolean z10) {
                this.f18160a = th;
                this.f18161b = z10;
            }

            public void run() {
                b bVar = b.this;
                Callback.b bVar2 = bVar.f18153v;
                if (bVar2 != null) {
                    bVar2.a(bVar.f18154w, this.f18160a, this.f18161b);
                }
            }
        }

        class d implements Runnable {
            d() {
            }

            public void run() {
                b bVar = b.this;
                Callback.b bVar2 = bVar.f18153v;
                if (bVar2 != null) {
                    bVar2.b(bVar.f18154w);
                }
                b.this.f18155x.run();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AbstractTask abstractTask, Callback.b bVar, AbstractTask abstractTask2, Runnable runnable) {
            super(abstractTask);
            this.f18153v = bVar;
            this.f18154w = abstractTask2;
            this.f18155x = runnable;
        }

        /* access modifiers changed from: protected */
        public void a(Object obj) {
            super.a(obj);
            a.this.d(new C0230a());
        }

        /* access modifiers changed from: protected */
        public void j() {
            super.j();
            a.this.d(new d());
        }

        /* access modifiers changed from: protected */
        public void a(Callback.CancelledException cancelledException) {
            super.a(cancelledException);
            a.this.d(new C0231b(cancelledException));
        }

        /* access modifiers changed from: protected */
        public void a(Throwable th, boolean z10) {
            super.a(th, z10);
            a.this.d(new c(th, z10));
        }
    }

    public <T> AbstractTask<T> b(AbstractTask<T> abstractTask) {
        e eVar;
        if (abstractTask instanceof e) {
            eVar = (e) abstractTask;
        } else {
            eVar = new e(abstractTask);
        }
        try {
            eVar.d();
        } catch (Throwable th) {
            com.alibaba.pdns.u.a.b(f18147b, th.getMessage());
        }
        return eVar;
    }

    public void a(Runnable runnable, long j10) {
        if (runnable != null) {
            e.f18180k.postDelayed(runnable, j10);
        }
    }

    public void a(Runnable runnable) {
        e.f18180k.removeCallbacks(runnable);
    }

    public void a(Runnable... runnableArr) {
        if (runnableArr != null && runnableArr.length > 0) {
            for (Runnable a10 : runnableArr) {
                a(a10);
            }
        }
    }

    public ExecutorService b(String str, boolean z10) {
        return f.a(str, z10);
    }

    public <T> AbstractTask<T> a(Activity activity, AbstractTask<T> abstractTask) {
        e eVar;
        if (abstractTask instanceof e) {
            eVar = (e) abstractTask;
        } else {
            eVar = new e(activity, abstractTask);
        }
        try {
            eVar.d();
        } catch (Throwable th) {
            com.alibaba.pdns.u.a.b(f18147b, th.getMessage());
        }
        return eVar;
    }

    public <T> T a(AbstractTask<T> abstractTask) throws Throwable {
        T t10 = null;
        try {
            abstractTask.l();
            abstractTask.k();
            t10 = abstractTask.d();
            abstractTask.a((Object) t10);
        } catch (Callback.CancelledException e10) {
            abstractTask.a(e10);
        } catch (Throwable th) {
            abstractTask.j();
            throw th;
        }
        abstractTask.j();
        return t10;
    }

    public <T extends AbstractTask<?>> Callback.a a(Callback.b<T> bVar, T... tArr) {
        if (tArr == null) {
            com.alibaba.pdns.u.a.e(f18147b, "task must not be null");
            return null;
        }
        C0229a aVar = new C0229a(tArr, bVar);
        for (T t10 : tArr) {
            b(new b(t10, bVar, t10, aVar));
        }
        return new c(tArr);
    }

    public ExecutorService a(int i10, int i11, long j10, String str, boolean z10) {
        return f.a(i10, i11, j10, str, z10);
    }

    public ScheduledExecutorService a(String str, boolean z10) {
        return f.b(str, z10);
    }
}
