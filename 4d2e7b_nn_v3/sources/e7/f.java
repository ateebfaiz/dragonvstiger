package e7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public class f implements l6.a {

    /* renamed from: i  reason: collision with root package name */
    public static final Executor f11923i = d.f11922b;

    /* renamed from: j  reason: collision with root package name */
    public static final Executor f11924j = d.f11921a;

    /* renamed from: k  reason: collision with root package name */
    private static f f11925k = new f((Object) null);

    /* renamed from: l  reason: collision with root package name */
    private static f f11926l = new f((Object) Boolean.TRUE);

    /* renamed from: m  reason: collision with root package name */
    private static f f11927m = new f((Object) Boolean.FALSE);

    /* renamed from: n  reason: collision with root package name */
    private static f f11928n = new f(true);

    /* renamed from: a  reason: collision with root package name */
    private final Object f11929a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f11930b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11931c;

    /* renamed from: d  reason: collision with root package name */
    private Object f11932d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f11933e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11934f;

    /* renamed from: g  reason: collision with root package name */
    private h f11935g;

    /* renamed from: h  reason: collision with root package name */
    private List f11936h = new ArrayList();

    class a implements a {
        a() {
        }

        /* renamed from: b */
        public f a(f fVar) {
            if (fVar.q()) {
                return f.e();
            }
            if (fVar.s()) {
                return f.l(fVar.n());
            }
            return f.m((Object) null);
        }
    }

    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f11938a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callable f11939b;

        b(g gVar, Callable callable) {
            this.f11938a = gVar;
            this.f11939b = callable;
        }

        public void run() {
            try {
                this.f11938a.d(this.f11939b.call());
            } catch (CancellationException unused) {
                this.f11938a.b();
            } catch (Exception e10) {
                this.f11938a.c(e10);
            }
        }
    }

    class c implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f11940a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f11941b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Executor f11942c;

        c(g gVar, a aVar, Executor executor) {
            this.f11940a = gVar;
            this.f11941b = aVar;
            this.f11942c = executor;
        }

        /* renamed from: b */
        public Void a(f fVar) {
            f.g(this.f11940a, this.f11941b, fVar, this.f11942c);
            return null;
        }
    }

    class d implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f11944a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f11945b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Executor f11946c;

        d(g gVar, a aVar, Executor executor) {
            this.f11944a = gVar;
            this.f11945b = aVar;
            this.f11946c = executor;
        }

        /* renamed from: b */
        public Void a(f fVar) {
            f.f(this.f11944a, this.f11945b, fVar, this.f11946c);
            return null;
        }
    }

    class e implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f11948a;

        e(a aVar) {
            this.f11948a = aVar;
        }

        /* renamed from: b */
        public f a(f fVar) {
            if (fVar.s()) {
                return f.l(fVar.n());
            }
            if (fVar.q()) {
                return f.e();
            }
            return fVar.h(this.f11948a);
        }
    }

    /* renamed from: e7.f$f  reason: collision with other inner class name */
    class C0135f implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f11950a;

        C0135f(a aVar) {
            this.f11950a = aVar;
        }

        /* renamed from: b */
        public f a(f fVar) {
            if (fVar.s()) {
                return f.l(fVar.n());
            }
            if (fVar.q()) {
                return f.e();
            }
            return fVar.j(this.f11950a);
        }
    }

    class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f11952a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f11953b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f11954c;

        g(a aVar, f fVar, g gVar) {
            this.f11952a = aVar;
            this.f11953b = fVar;
            this.f11954c = gVar;
        }

        public void run() {
            try {
                this.f11954c.d(this.f11952a.a(this.f11953b));
            } catch (CancellationException unused) {
                this.f11954c.b();
            } catch (Exception e10) {
                this.f11954c.c(e10);
            }
        }
    }

    class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f11955a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f11956b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f11957c;

        class a implements a {
            a() {
            }

            /* renamed from: b */
            public Void a(f fVar) {
                if (fVar.q()) {
                    h.this.f11957c.b();
                    return null;
                } else if (fVar.s()) {
                    h.this.f11957c.c(fVar.n());
                    return null;
                } else {
                    h.this.f11957c.d(fVar.o());
                    return null;
                }
            }
        }

        h(a aVar, f fVar, g gVar) {
            this.f11955a = aVar;
            this.f11956b = fVar;
            this.f11957c = gVar;
        }

        public void run() {
            try {
                f fVar = (f) this.f11955a.a(this.f11956b);
                if (fVar == null) {
                    this.f11957c.d((Object) null);
                } else {
                    fVar.h(new a());
                }
            } catch (CancellationException unused) {
                this.f11957c.b();
            } catch (Exception e10) {
                this.f11957c.c(e10);
            }
        }
    }

    public interface i {
    }

    f() {
    }

    public static f c(Callable callable) {
        return d(callable, f11923i);
    }

    public static f d(Callable callable, Executor executor) {
        g gVar = new g();
        try {
            executor.execute(new b(gVar, callable));
        } catch (Exception e10) {
            gVar.c(new b(e10));
        }
        return gVar.a();
    }

    public static f e() {
        return f11928n;
    }

    /* access modifiers changed from: private */
    public static void f(g gVar, a aVar, f fVar, Executor executor) {
        try {
            executor.execute(new h(aVar, fVar, gVar));
        } catch (Exception e10) {
            gVar.c(new b(e10));
        }
    }

    /* access modifiers changed from: private */
    public static void g(g gVar, a aVar, f fVar, Executor executor) {
        try {
            executor.execute(new g(aVar, fVar, gVar));
        } catch (Exception e10) {
            gVar.c(new b(e10));
        }
    }

    public static f l(Exception exc) {
        g gVar = new g();
        gVar.c(exc);
        return gVar.a();
    }

    public static f m(Object obj) {
        if (obj == null) {
            return f11925k;
        }
        if (!(obj instanceof Boolean)) {
            g gVar = new g();
            gVar.d(obj);
            return gVar.a();
        } else if (((Boolean) obj).booleanValue()) {
            return f11926l;
        } else {
            return f11927m;
        }
    }

    public static i p() {
        return null;
    }

    private void w() {
        synchronized (this.f11929a) {
            for (a a10 : this.f11936h) {
                try {
                    a10.a(this);
                } catch (RuntimeException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new RuntimeException(e11);
                }
            }
            this.f11936h = null;
        }
    }

    public f h(a aVar) {
        return i(aVar, f11923i);
    }

    public f i(a aVar, Executor executor) {
        boolean r10;
        g gVar = new g();
        synchronized (this.f11929a) {
            try {
                r10 = r();
                if (!r10) {
                    this.f11936h.add(new c(gVar, aVar, executor));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (r10) {
            g(gVar, aVar, this, executor);
        }
        return gVar.a();
    }

    public f j(a aVar) {
        return k(aVar, f11923i);
    }

    public f k(a aVar, Executor executor) {
        boolean r10;
        g gVar = new g();
        synchronized (this.f11929a) {
            try {
                r10 = r();
                if (!r10) {
                    this.f11936h.add(new d(gVar, aVar, executor));
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (r10) {
            f(gVar, aVar, this, executor);
        }
        return gVar.a();
    }

    public Exception n() {
        Exception exc;
        synchronized (this.f11929a) {
            try {
                if (this.f11933e != null) {
                    this.f11934f = true;
                }
                exc = this.f11933e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return exc;
    }

    public Object o() {
        Object obj;
        synchronized (this.f11929a) {
            obj = this.f11932d;
        }
        return obj;
    }

    public boolean q() {
        boolean z10;
        synchronized (this.f11929a) {
            z10 = this.f11931c;
        }
        return z10;
    }

    public boolean r() {
        boolean z10;
        synchronized (this.f11929a) {
            z10 = this.f11930b;
        }
        return z10;
    }

    public boolean s() {
        boolean z10;
        synchronized (this.f11929a) {
            if (n() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public f t() {
        return j(new a());
    }

    public f u(a aVar, Executor executor) {
        return k(new e(aVar), executor);
    }

    public f v(a aVar, Executor executor) {
        return k(new C0135f(aVar), executor);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        synchronized (this.f11929a) {
            try {
                if (this.f11930b) {
                    return false;
                }
                this.f11930b = true;
                this.f11931c = true;
                this.f11929a.notifyAll();
                w();
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
    public boolean y(java.lang.Exception r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f11929a
            monitor-enter(r0)
            boolean r1 = r3.f11930b     // Catch:{ all -> 0x000a }
            r2 = 0
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r2
        L_0x000a:
            r4 = move-exception
            goto L_0x0024
        L_0x000c:
            r1 = 1
            r3.f11930b = r1     // Catch:{ all -> 0x000a }
            r3.f11933e = r4     // Catch:{ all -> 0x000a }
            r3.f11934f = r2     // Catch:{ all -> 0x000a }
            java.lang.Object r4 = r3.f11929a     // Catch:{ all -> 0x000a }
            r4.notifyAll()     // Catch:{ all -> 0x000a }
            r3.w()     // Catch:{ all -> 0x000a }
            boolean r4 = r3.f11934f     // Catch:{ all -> 0x000a }
            if (r4 != 0) goto L_0x0022
            p()     // Catch:{ all -> 0x000a }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            return r1
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x000a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e7.f.y(java.lang.Exception):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean z(Object obj) {
        synchronized (this.f11929a) {
            try {
                if (this.f11930b) {
                    return false;
                }
                this.f11930b = true;
                this.f11932d = obj;
                this.f11929a.notifyAll();
                w();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private f(Object obj) {
        z(obj);
    }

    private f(boolean z10) {
        if (z10) {
            x();
        } else {
            z((Object) null);
        }
    }
}
