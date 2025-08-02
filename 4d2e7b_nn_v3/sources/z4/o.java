package z4;

import android.content.Context;
import android.os.Build;
import c5.c;
import com.facebook.imagepipeline.producers.b0;
import com.facebook.imagepipeline.producers.p1;
import com.facebook.imagepipeline.producers.q1;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import l5.b;
import m5.d;
import m5.f;
import m5.h;
import s4.a;
import w4.e;
import x4.j;
import x4.k;
import x4.n;
import x4.r;
import x4.s;
import x4.u;
import x4.v;
import x4.x;
import y2.g;
import y2.l;

public class o {

    /* renamed from: u  reason: collision with root package name */
    private static final Class f25149u = o.class;

    /* renamed from: v  reason: collision with root package name */
    private static o f25150v;

    /* renamed from: w  reason: collision with root package name */
    private static k f25151w;

    /* renamed from: x  reason: collision with root package name */
    private static boolean f25152x;

    /* renamed from: a  reason: collision with root package name */
    private final p1 f25153a;

    /* renamed from: b  reason: collision with root package name */
    private final m f25154b;

    /* renamed from: c  reason: collision with root package name */
    private final a f25155c;

    /* renamed from: d  reason: collision with root package name */
    private n f25156d;

    /* renamed from: e  reason: collision with root package name */
    private u f25157e;

    /* renamed from: f  reason: collision with root package name */
    private n f25158f;

    /* renamed from: g  reason: collision with root package name */
    private u f25159g;

    /* renamed from: h  reason: collision with root package name */
    private j f25160h;

    /* renamed from: i  reason: collision with root package name */
    private s2.n f25161i;

    /* renamed from: j  reason: collision with root package name */
    private c f25162j;

    /* renamed from: k  reason: collision with root package name */
    private d f25163k;

    /* renamed from: l  reason: collision with root package name */
    private s f25164l;

    /* renamed from: m  reason: collision with root package name */
    private t f25165m;

    /* renamed from: n  reason: collision with root package name */
    private j f25166n;

    /* renamed from: o  reason: collision with root package name */
    private s2.n f25167o;

    /* renamed from: p  reason: collision with root package name */
    private Map f25168p;

    /* renamed from: q  reason: collision with root package name */
    private g f25169q;

    /* renamed from: r  reason: collision with root package name */
    private w4.d f25170r;

    /* renamed from: s  reason: collision with root package name */
    private i5.d f25171s;

    /* renamed from: t  reason: collision with root package name */
    private a f25172t;

    public o(m mVar) {
        p1 p1Var;
        if (b.d()) {
            b.a("ImagePipelineConfig()");
        }
        m mVar2 = (m) l.g(mVar);
        this.f25154b = mVar2;
        if (mVar2.F().E()) {
            p1Var = new b0(mVar.H().b());
        } else {
            p1Var = new q1(mVar.H().b());
        }
        this.f25153a = p1Var;
        this.f25155c = new a(mVar.e());
        if (b.d()) {
            b.b();
        }
    }

    private k a() {
        t t10 = t();
        Set j10 = this.f25154b.j();
        Set b10 = this.f25154b.b();
        y2.o u10 = this.f25154b.u();
        u e10 = e();
        u j11 = j();
        j o10 = o();
        j u11 = u();
        k l10 = this.f25154b.l();
        p1 p1Var = this.f25153a;
        y2.o s10 = this.f25154b.F().s();
        y2.o G = this.f25154b.F().G();
        this.f25154b.C();
        return new k(t10, j10, b10, u10, e10, j11, o10, u11, l10, p1Var, s10, G, (t2.a) null, this.f25154b);
    }

    private a c() {
        if (this.f25172t == null) {
            this.f25172t = s4.b.a(q(), this.f25154b.H(), d(), this.f25154b.F().i(), this.f25154b.F().u(), this.f25154b.F().c(), this.f25154b.v());
        }
        return this.f25172t;
    }

    private g g() {
        if (this.f25169q == null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : h().entrySet()) {
                hashMap.put((String) entry.getKey(), new j((s2.n) entry.getValue(), this.f25154b.a().i(this.f25154b.c()), this.f25154b.a().j(), this.f25154b.H().e(), this.f25154b.H().d(), this.f25154b.s()));
            }
            this.f25169q = g.a(hashMap);
        }
        return this.f25169q;
    }

    private Map h() {
        if (this.f25168p == null) {
            this.f25168p = new HashMap();
            if (this.f25154b.q() != null) {
                for (Map.Entry entry : this.f25154b.q().entrySet()) {
                    this.f25168p.put((String) entry.getKey(), this.f25154b.d().a((s2.g) entry.getValue()));
                }
            }
        }
        return this.f25168p;
    }

    private c k() {
        c cVar;
        c cVar2;
        if (this.f25162j == null) {
            if (this.f25154b.E() != null) {
                this.f25162j = this.f25154b.E();
            } else {
                a c10 = c();
                if (c10 != null) {
                    cVar = c10.b();
                    cVar2 = c10.c();
                } else {
                    cVar = null;
                    cVar2 = null;
                }
                this.f25154b.z();
                this.f25162j = new c5.b(cVar, cVar2, r());
            }
        }
        return this.f25162j;
    }

    private d m() {
        if (this.f25163k == null) {
            if (this.f25154b.x() == null && this.f25154b.w() == null && this.f25154b.F().H()) {
                this.f25163k = new h(this.f25154b.F().l());
            } else {
                this.f25163k = new f(this.f25154b.F().l(), this.f25154b.F().w(), this.f25154b.x(), this.f25154b.w(), this.f25154b.F().D());
            }
        }
        return this.f25163k;
    }

    public static o n() {
        return (o) l.h(f25150v, "ImagePipelineFactory was not initialized!");
    }

    private s s() {
        if (this.f25164l == null) {
            this.f25164l = this.f25154b.F().o().a(this.f25154b.getContext(), this.f25154b.a().k(), k(), this.f25154b.p(), this.f25154b.B(), this.f25154b.m(), this.f25154b.F().z(), this.f25154b.H(), this.f25154b.a().i(this.f25154b.c()), this.f25154b.a().j(), e(), j(), o(), u(), g(), this.f25154b.l(), q(), this.f25154b.F().f(), this.f25154b.F().e(), this.f25154b.F().d(), this.f25154b.F().l(), f(), this.f25154b.F().k(), this.f25154b.F().t());
        }
        return this.f25164l;
    }

    private t t() {
        boolean z10;
        if (Build.VERSION.SDK_INT < 24 || !this.f25154b.F().v()) {
            z10 = false;
        } else {
            z10 = true;
        }
        boolean z11 = z10;
        if (this.f25165m == null) {
            this.f25165m = new t(this.f25154b.getContext().getApplicationContext().getContentResolver(), s(), this.f25154b.g(), this.f25154b.m(), this.f25154b.F().J(), this.f25153a, this.f25154b.B(), z11, this.f25154b.F().I(), this.f25154b.A(), m(), this.f25154b.F().C(), this.f25154b.F().A(), this.f25154b.F().a(), this.f25154b.o());
        }
        return this.f25165m;
    }

    private j u() {
        if (this.f25166n == null) {
            this.f25166n = new j(v(), this.f25154b.a().i(this.f25154b.c()), this.f25154b.a().j(), this.f25154b.H().e(), this.f25154b.H().d(), this.f25154b.s());
        }
        return this.f25166n;
    }

    public static synchronized void w(Context context) {
        synchronized (o.class) {
            try {
                if (b.d()) {
                    b.a("ImagePipelineFactory#initialize");
                }
                x(l.K(context).a());
                if (b.d()) {
                    b.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void x(m mVar) {
        synchronized (o.class) {
            if (f25150v != null) {
                z2.a.C(f25149u, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
                if (f25152x) {
                    return;
                }
            }
            f25150v = new o(mVar);
        }
    }

    public d5.a b(Context context) {
        a c10 = c();
        if (c10 == null) {
            return null;
        }
        return c10.a(context);
    }

    public n d() {
        if (this.f25156d == null) {
            this.f25156d = this.f25154b.f().a(this.f25154b.D(), this.f25154b.y(), this.f25154b.n(), this.f25154b.F().q(), this.f25154b.F().p(), this.f25154b.t());
        }
        return this.f25156d;
    }

    public u e() {
        if (this.f25157e == null) {
            this.f25157e = v.a(d(), this.f25154b.s());
        }
        return this.f25157e;
    }

    public a f() {
        return this.f25155c;
    }

    public n i() {
        if (this.f25158f == null) {
            this.f25158f = r.a(this.f25154b.G(), this.f25154b.y(), this.f25154b.k());
        }
        return this.f25158f;
    }

    public u j() {
        x xVar;
        if (this.f25159g == null) {
            if (this.f25154b.h() != null) {
                xVar = this.f25154b.h();
            } else {
                xVar = i();
            }
            this.f25159g = s.a(xVar, this.f25154b.s());
        }
        return this.f25159g;
    }

    public k l() {
        if (f25151w == null) {
            f25151w = a();
        }
        return f25151w;
    }

    public j o() {
        if (this.f25160h == null) {
            this.f25160h = new j(p(), this.f25154b.a().i(this.f25154b.c()), this.f25154b.a().j(), this.f25154b.H().e(), this.f25154b.H().d(), this.f25154b.s());
        }
        return this.f25160h;
    }

    public s2.n p() {
        if (this.f25161i == null) {
            this.f25161i = this.f25154b.d().a(this.f25154b.i());
        }
        return this.f25161i;
    }

    public w4.d q() {
        if (this.f25170r == null) {
            this.f25170r = e.a(this.f25154b.a(), r(), f());
        }
        return this.f25170r;
    }

    public i5.d r() {
        if (this.f25171s == null) {
            this.f25171s = i5.e.a(this.f25154b.a(), this.f25154b.F().F(), this.f25154b.F().r(), this.f25154b.F().n());
        }
        return this.f25171s;
    }

    public s2.n v() {
        if (this.f25167o == null) {
            this.f25167o = this.f25154b.d().a(this.f25154b.r());
        }
        return this.f25167o;
    }
}
