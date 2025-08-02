package k0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class f {

    /* renamed from: i  reason: collision with root package name */
    public static final ExecutorService f22243i = b.a();

    /* renamed from: j  reason: collision with root package name */
    private static final Executor f22244j = b.b();

    /* renamed from: k  reason: collision with root package name */
    public static final Executor f22245k = a.c();

    /* renamed from: l  reason: collision with root package name */
    private static f f22246l = new f((Object) null);

    /* renamed from: m  reason: collision with root package name */
    private static f f22247m = new f((Object) Boolean.TRUE);

    /* renamed from: n  reason: collision with root package name */
    private static f f22248n = new f((Object) Boolean.FALSE);

    /* renamed from: o  reason: collision with root package name */
    private static f f22249o = new f(true);

    /* renamed from: a  reason: collision with root package name */
    private final Object f22250a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f22251b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22252c;

    /* renamed from: d  reason: collision with root package name */
    private Object f22253d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f22254e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22255f;

    /* renamed from: g  reason: collision with root package name */
    private h f22256g;

    /* renamed from: h  reason: collision with root package name */
    private List f22257h = new ArrayList();

    class a implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22258a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f22259b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Executor f22260c;

        a(g gVar, d dVar, Executor executor, c cVar) {
            this.f22258a = gVar;
            this.f22259b = dVar;
            this.f22260c = executor;
        }

        /* renamed from: b */
        public Void a(f fVar) {
            f.d(this.f22258a, this.f22259b, fVar, this.f22260c, (c) null);
            return null;
        }
    }

    static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f22263b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f22264c;

        b(c cVar, g gVar, d dVar, f fVar) {
            this.f22262a = gVar;
            this.f22263b = dVar;
            this.f22264c = fVar;
        }

        public void run() {
            try {
                this.f22262a.d(this.f22263b.a(this.f22264c));
            } catch (CancellationException unused) {
                this.f22262a.b();
            } catch (Exception e10) {
                this.f22262a.c(e10);
            }
        }
    }

    static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f22265a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f22266b;

        c(c cVar, g gVar, Callable callable) {
            this.f22265a = gVar;
            this.f22266b = callable;
        }

        public void run() {
            try {
                this.f22265a.d(this.f22266b.call());
            } catch (CancellationException unused) {
                this.f22265a.b();
            } catch (Exception e10) {
                this.f22265a.c(e10);
            }
        }
    }

    public interface d {
    }

    f() {
    }

    public static f b(Callable callable, Executor executor) {
        return c(callable, executor, (c) null);
    }

    public static f c(Callable callable, Executor executor, c cVar) {
        g gVar = new g();
        try {
            executor.execute(new c(cVar, gVar, callable));
        } catch (Exception e10) {
            gVar.c(new e(e10));
        }
        return gVar.a();
    }

    /* access modifiers changed from: private */
    public static void d(g gVar, d dVar, f fVar, Executor executor, c cVar) {
        try {
            executor.execute(new b(cVar, gVar, dVar, fVar));
        } catch (Exception e10) {
            gVar.c(new e(e10));
        }
    }

    public static f g(Exception exc) {
        g gVar = new g();
        gVar.c(exc);
        return gVar.a();
    }

    public static f h(Object obj) {
        if (obj == null) {
            return f22246l;
        }
        if (!(obj instanceof Boolean)) {
            g gVar = new g();
            gVar.d(obj);
            return gVar.a();
        } else if (((Boolean) obj).booleanValue()) {
            return f22247m;
        } else {
            return f22248n;
        }
    }

    public static d k() {
        return null;
    }

    private void o() {
        synchronized (this.f22250a) {
            for (d a10 : this.f22257h) {
                try {
                    a10.a(this);
                } catch (RuntimeException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new RuntimeException(e11);
                }
            }
            this.f22257h = null;
        }
    }

    public f e(d dVar) {
        return f(dVar, f22244j, (c) null);
    }

    public f f(d dVar, Executor executor, c cVar) {
        boolean m10;
        g gVar = new g();
        synchronized (this.f22250a) {
            try {
                m10 = m();
                if (!m10) {
                    this.f22257h.add(new a(gVar, dVar, executor, cVar));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (m10) {
            d(gVar, dVar, this, executor, cVar);
        }
        return gVar.a();
    }

    public Exception i() {
        Exception exc;
        synchronized (this.f22250a) {
            try {
                if (this.f22254e != null) {
                    this.f22255f = true;
                }
                exc = this.f22254e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return exc;
    }

    public Object j() {
        Object obj;
        synchronized (this.f22250a) {
            obj = this.f22253d;
        }
        return obj;
    }

    public boolean l() {
        boolean z10;
        synchronized (this.f22250a) {
            z10 = this.f22252c;
        }
        return z10;
    }

    public boolean m() {
        boolean z10;
        synchronized (this.f22250a) {
            z10 = this.f22251b;
        }
        return z10;
    }

    public boolean n() {
        boolean z10;
        synchronized (this.f22250a) {
            if (i() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        synchronized (this.f22250a) {
            try {
                if (this.f22251b) {
                    return false;
                }
                this.f22251b = true;
                this.f22252c = true;
                this.f22250a.notifyAll();
                o();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean q(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f22250a
            monitor-enter(r0)
            boolean r1 = r3.f22251b     // Catch:{ all -> 0x000a }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r2
        L_0x000a:
            r4 = move-exception
            goto L_0x0024
        L_0x000c:
            r1 = 1
            r3.f22251b = r1     // Catch:{ all -> 0x000a }
            r3.f22254e = r4     // Catch:{ all -> 0x000a }
            r3.f22255f = r2     // Catch:{ all -> 0x000a }
            java.lang.Object r4 = r3.f22250a     // Catch:{ all -> 0x000a }
            r4.notifyAll()     // Catch:{ all -> 0x000a }
            r3.o()     // Catch:{ all -> 0x000a }
            boolean r4 = r3.f22255f     // Catch:{ all -> 0x000a }
            if (r4 != 0) goto L_0x0022
            k()     // Catch:{ all -> 0x000a }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r1
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.f.q(java.lang.Exception):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean r(Object obj) {
        synchronized (this.f22250a) {
            try {
                if (this.f22251b) {
                    return false;
                }
                this.f22251b = true;
                this.f22253d = obj;
                this.f22250a.notifyAll();
                o();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private f(Object obj) {
        r(obj);
    }

    private f(boolean z10) {
        if (z10) {
            p();
        } else {
            r((Object) null);
        }
    }
}
