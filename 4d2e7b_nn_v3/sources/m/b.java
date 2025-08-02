package m;

import d.c;
import d.k;
import j.a;
import java.util.concurrent.atomic.AtomicBoolean;
import w.d;

public class b {

    /* renamed from: j  reason: collision with root package name */
    public static final String f22462j = d.f("");

    /* renamed from: a  reason: collision with root package name */
    public final k f22463a;

    /* renamed from: b  reason: collision with root package name */
    public final c f22464b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f22465c;

    /* renamed from: d  reason: collision with root package name */
    public final String f22466d;

    /* renamed from: e  reason: collision with root package name */
    public d f22467e;

    /* renamed from: f  reason: collision with root package name */
    public e f22468f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f22469g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f22470h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicBoolean f22471i = new AtomicBoolean(false);

    public b(k kVar, c cVar) {
        this.f22463a = kVar;
        this.f22464b = cVar;
        this.f22469g = kVar.o().c();
        this.f22470h = kVar.o().M;
        this.f22465c = new AtomicBoolean(b());
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.f22466d = valueOf;
        d();
        a(valueOf);
    }

    public final void a(String str) {
        this.f22463a.r().h(false);
        this.f22463a.r().e(str);
    }

    public final boolean b() {
        if (this.f22469g || !this.f22470h) {
            return false;
        }
        return true;
    }

    public void c() {
        if (this.f22465c.get() && this.f22471i.compareAndSet(false, true)) {
            this.f22463a.r().h(true);
            a.a().c(new a(this), (long) 1200000);
        }
    }

    public final void d() {
        if (this.f22465c.get()) {
            this.f22467e = new d(this.f22463a, this.f22464b);
            this.f22468f = new e(this.f22463a, this.f22464b);
        }
    }

    public final void e() {
        this.f22467e.d(this.f22466d);
        this.f22468f.a(this.f22466d);
        this.f22463a.r().h(false);
        this.f22471i.set(false);
    }

    public void f() {
        if (this.f22465c.get()) {
            this.f22467e.e();
            this.f22465c.set(false);
        }
    }
}
