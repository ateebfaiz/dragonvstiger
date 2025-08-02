package z4;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import c5.e;
import c5.h;
import com.facebook.imagepipeline.producers.d0;
import com.facebook.imagepipeline.producers.x0;
import h5.c0;
import h5.e0;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import m5.d;
import s2.g;
import x4.a0;
import x4.b0;
import x4.k;
import x4.n;
import x4.p;
import x4.q;
import x4.t;
import x4.x;
import y2.o;
import z4.n;

public final class l implements m {
    public static final b M = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static c N = new c();
    private final Set A;
    private final Set B;
    private final boolean C;
    private final g D;
    private final n E;
    private final boolean F;
    private final b5.a G;
    private final x H;
    private final x I;
    private final w2.g J;
    private final x4.a K;
    private final Map L;

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.Config f25044a;

    /* renamed from: b  reason: collision with root package name */
    private final o f25045b;

    /* renamed from: c  reason: collision with root package name */
    private final x.a f25046c;

    /* renamed from: d  reason: collision with root package name */
    private final x.a f25047d;

    /* renamed from: e  reason: collision with root package name */
    private final n.b f25048e;

    /* renamed from: f  reason: collision with root package name */
    private final k f25049f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f25050g;

    /* renamed from: h  reason: collision with root package name */
    private final e f25051h;

    /* renamed from: i  reason: collision with root package name */
    private final h f25052i;

    /* renamed from: j  reason: collision with root package name */
    private final o f25053j;

    /* renamed from: k  reason: collision with root package name */
    private final g f25054k;

    /* renamed from: l  reason: collision with root package name */
    private final t f25055l;

    /* renamed from: m  reason: collision with root package name */
    private final c5.c f25056m;

    /* renamed from: n  reason: collision with root package name */
    private final d f25057n;

    /* renamed from: o  reason: collision with root package name */
    private final o f25058o;

    /* renamed from: p  reason: collision with root package name */
    private final Integer f25059p;

    /* renamed from: q  reason: collision with root package name */
    private final o f25060q;

    /* renamed from: r  reason: collision with root package name */
    private final g f25061r;

    /* renamed from: s  reason: collision with root package name */
    private final b3.d f25062s;

    /* renamed from: t  reason: collision with root package name */
    private final int f25063t;

    /* renamed from: u  reason: collision with root package name */
    private final x0 f25064u;

    /* renamed from: v  reason: collision with root package name */
    private final int f25065v;

    /* renamed from: w  reason: collision with root package name */
    private final w4.d f25066w;

    /* renamed from: x  reason: collision with root package name */
    private final e0 f25067x;

    /* renamed from: y  reason: collision with root package name */
    private final e f25068y;

    /* renamed from: z  reason: collision with root package name */
    private final Set f25069z;

    public static final class a {
        private boolean A = true;
        private g B;
        private h C;
        private int D = -1;
        private final n.a E = new n.a(this);
        private boolean F = true;
        private b5.a G = new b5.b();
        private x H;
        private x I;
        private w2.g J;
        private x4.a K;
        private Map L;

        /* renamed from: a  reason: collision with root package name */
        private Bitmap.Config f25070a;

        /* renamed from: b  reason: collision with root package name */
        private o f25071b;

        /* renamed from: c  reason: collision with root package name */
        private n.b f25072c;

        /* renamed from: d  reason: collision with root package name */
        private x.a f25073d;

        /* renamed from: e  reason: collision with root package name */
        private x.a f25074e;

        /* renamed from: f  reason: collision with root package name */
        private k f25075f;

        /* renamed from: g  reason: collision with root package name */
        private final Context f25076g;

        /* renamed from: h  reason: collision with root package name */
        private e f25077h = e.AUTO;

        /* renamed from: i  reason: collision with root package name */
        private o f25078i;

        /* renamed from: j  reason: collision with root package name */
        private g f25079j;

        /* renamed from: k  reason: collision with root package name */
        private t f25080k;

        /* renamed from: l  reason: collision with root package name */
        private c5.c f25081l;

        /* renamed from: m  reason: collision with root package name */
        private o f25082m;

        /* renamed from: n  reason: collision with root package name */
        private d f25083n;

        /* renamed from: o  reason: collision with root package name */
        private Integer f25084o;

        /* renamed from: p  reason: collision with root package name */
        private o f25085p;

        /* renamed from: q  reason: collision with root package name */
        private g f25086q;

        /* renamed from: r  reason: collision with root package name */
        private b3.d f25087r;

        /* renamed from: s  reason: collision with root package name */
        private Integer f25088s;

        /* renamed from: t  reason: collision with root package name */
        private x0 f25089t;

        /* renamed from: u  reason: collision with root package name */
        private w4.d f25090u;

        /* renamed from: v  reason: collision with root package name */
        private e0 f25091v;

        /* renamed from: w  reason: collision with root package name */
        private e f25092w;

        /* renamed from: x  reason: collision with root package name */
        private Set f25093x;

        /* renamed from: y  reason: collision with root package name */
        private Set f25094y;

        /* renamed from: z  reason: collision with root package name */
        private Set f25095z;

        public a(Context context) {
            m.f(context, "context");
            this.f25076g = context;
        }

        public final d A() {
            return this.f25083n;
        }

        public final Integer B() {
            return this.f25084o;
        }

        public final g C() {
            return this.f25086q;
        }

        public final Integer D() {
            return this.f25088s;
        }

        public final b3.d E() {
            return this.f25087r;
        }

        public final x0 F() {
            return this.f25089t;
        }

        public final w4.d G() {
            return this.f25090u;
        }

        public final e0 H() {
            return this.f25091v;
        }

        public final e I() {
            return this.f25092w;
        }

        public final Set J() {
            return this.f25094y;
        }

        public final Set K() {
            return this.f25093x;
        }

        public final boolean L() {
            return this.A;
        }

        public final w2.g M() {
            return this.J;
        }

        public final g N() {
            return this.B;
        }

        public final o O() {
            return this.f25085p;
        }

        public final a P(boolean z10) {
            if (z10) {
                Q(e.ALWAYS);
            } else {
                Q(e.AUTO);
            }
            return this;
        }

        public final a Q(e eVar) {
            m.f(eVar, "downsampleMode");
            this.f25077h = eVar;
            return this;
        }

        public final a R(x0 x0Var) {
            this.f25089t = x0Var;
            return this;
        }

        public final a S(Set set) {
            this.f25093x = set;
            return this;
        }

        public final l a() {
            return new l(this, (DefaultConstructorMarker) null);
        }

        public final Bitmap.Config b() {
            return this.f25070a;
        }

        public final x c() {
            return this.H;
        }

        public final n.b d() {
            return this.f25072c;
        }

        public final x4.a e() {
            return this.K;
        }

        public final o f() {
            return this.f25071b;
        }

        public final x.a g() {
            return this.f25073d;
        }

        public final k h() {
            return this.f25075f;
        }

        public final t2.a i() {
            return null;
        }

        public final b5.a j() {
            return this.G;
        }

        public final Context k() {
            return this.f25076g;
        }

        public final Set l() {
            return this.f25095z;
        }

        public final boolean m() {
            return this.F;
        }

        public final e n() {
            return this.f25077h;
        }

        public final Map o() {
            return this.L;
        }

        public final o p() {
            return this.f25082m;
        }

        public final x q() {
            return this.I;
        }

        public final o r() {
            return this.f25078i;
        }

        public final x.a s() {
            return this.f25074e;
        }

        public final g t() {
            return this.f25079j;
        }

        public final n.a u() {
            return this.E;
        }

        public final h v() {
            return this.C;
        }

        public final int w() {
            return this.D;
        }

        public final t x() {
            return this.f25080k;
        }

        public final c5.c y() {
            return this.f25081l;
        }

        public final c5.d z() {
            return null;
        }
    }

    public static final class b {
        private b() {
        }

        /* access modifiers changed from: private */
        public final g f(Context context) {
            g gVar;
            if (!l5.b.d()) {
                gVar = g.m(context).n();
            } else {
                l5.b.a("DiskCacheConfig.getDefaultMainDiskCacheConfig");
                try {
                    gVar = g.m(context).n();
                } finally {
                    l5.b.b();
                }
            }
            m.e(gVar, "traceSection(\"DiskCacheC…ontext).build()\n        }");
            return gVar;
        }

        /* access modifiers changed from: private */
        public final d g(a aVar) {
            if (aVar.A() == null || aVar.B() == null) {
                return aVar.A();
            }
            throw new IllegalStateException("You can't define a custom ImageTranscoderFactory and provide an ImageTranscoderType".toString());
        }

        /* access modifiers changed from: private */
        public final int h(a aVar, n nVar) {
            Integer D = aVar.D();
            if (D != null) {
                return D.intValue();
            }
            if (nVar.m() == 2 && Build.VERSION.SDK_INT >= 27) {
                return 2;
            }
            if (nVar.m() == 1) {
                return 1;
            }
            nVar.m();
            return 0;
        }

        /* access modifiers changed from: private */
        public final void j(h3.b bVar, n nVar, h3.a aVar) {
            h3.c.f21891c = bVar;
            nVar.y();
            if (aVar != null) {
                bVar.b(aVar);
            }
        }

        public final c e() {
            return l.N;
        }

        public final a i(Context context) {
            m.f(context, "context");
            return new a(context);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f25096a;

        public final boolean a() {
            return this.f25096a;
        }
    }

    public /* synthetic */ l(a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar);
    }

    public static final c J() {
        return M.e();
    }

    public static final a K(Context context) {
        return M.i(context);
    }

    public boolean A() {
        return this.F;
    }

    public e B() {
        return this.f25051h;
    }

    public t2.a C() {
        return null;
    }

    public o D() {
        return this.f25045b;
    }

    public c5.c E() {
        return this.f25056m;
    }

    public n F() {
        return this.E;
    }

    public o G() {
        return this.f25053j;
    }

    public g H() {
        return this.f25054k;
    }

    public e0 a() {
        return this.f25067x;
    }

    public Set b() {
        return this.A;
    }

    public int c() {
        return this.f25063t;
    }

    public h d() {
        return this.f25052i;
    }

    public b5.a e() {
        return this.G;
    }

    public x4.a f() {
        return this.K;
    }

    public x0 g() {
        return this.f25064u;
    }

    public Context getContext() {
        return this.f25050g;
    }

    public x h() {
        return this.I;
    }

    public g i() {
        return this.f25061r;
    }

    public Set j() {
        return this.f25069z;
    }

    public x.a k() {
        return this.f25047d;
    }

    public k l() {
        return this.f25049f;
    }

    public boolean m() {
        return this.C;
    }

    public x.a n() {
        return this.f25046c;
    }

    public Set o() {
        return this.B;
    }

    public e p() {
        return this.f25068y;
    }

    public Map q() {
        return this.L;
    }

    public g r() {
        return this.D;
    }

    public t s() {
        return this.f25055l;
    }

    public n.b t() {
        return this.f25048e;
    }

    public o u() {
        return this.f25060q;
    }

    public w2.g v() {
        return this.J;
    }

    public Integer w() {
        return this.f25059p;
    }

    public d x() {
        return this.f25057n;
    }

    public b3.d y() {
        return this.f25062s;
    }

    public c5.d z() {
        return null;
    }

    private l(a aVar) {
        int i10;
        x0 x0Var;
        if (l5.b.d()) {
            l5.b.a("ImagePipelineConfig()");
        }
        this.E = aVar.u().a();
        o f10 = aVar.f();
        if (f10 == null) {
            Object systemService = aVar.k().getSystemService("activity");
            if (systemService != null) {
                m.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                f10 = new x4.o((ActivityManager) systemService);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        this.f25045b = f10;
        x.a g10 = aVar.g();
        this.f25046c = g10 == null ? new x4.c() : g10;
        x.a s10 = aVar.s();
        this.f25047d = s10 == null ? new a0() : s10;
        this.f25048e = aVar.d();
        Bitmap.Config b10 = aVar.b();
        this.f25044a = b10 == null ? Bitmap.Config.ARGB_8888 : b10;
        k h10 = aVar.h();
        if (h10 == null) {
            h10 = p.f();
            m.e(h10, "getInstance()");
        }
        this.f25049f = h10;
        Context k10 = aVar.k();
        if (k10 != null) {
            this.f25050g = k10;
            h v10 = aVar.v();
            this.f25052i = v10 == null ? new c(new f()) : v10;
            this.f25051h = aVar.n();
            o r10 = aVar.r();
            this.f25053j = r10 == null ? new q() : r10;
            t x10 = aVar.x();
            if (x10 == null) {
                x10 = b0.o();
                m.e(x10, "getInstance()");
            }
            this.f25055l = x10;
            this.f25056m = aVar.y();
            o p10 = aVar.p();
            if (p10 == null) {
                p10 = y2.p.f24881b;
                m.e(p10, "BOOLEAN_FALSE");
            }
            this.f25058o = p10;
            b bVar = M;
            this.f25057n = bVar.g(aVar);
            this.f25059p = aVar.B();
            o O = aVar.O();
            if (O == null) {
                O = y2.p.f24880a;
                m.e(O, "BOOLEAN_TRUE");
            }
            this.f25060q = O;
            g C2 = aVar.C();
            this.f25061r = C2 == null ? bVar.f(aVar.k()) : C2;
            b3.d E2 = aVar.E();
            if (E2 == null) {
                E2 = b3.e.b();
                m.e(E2, "getInstance()");
            }
            this.f25062s = E2;
            this.f25063t = bVar.h(aVar, F());
            if (aVar.w() < 0) {
                i10 = 30000;
            } else {
                i10 = aVar.w();
            }
            this.f25065v = i10;
            if (!l5.b.d()) {
                x0Var = aVar.F();
                if (x0Var == null) {
                    x0Var = new d0(i10);
                }
            } else {
                l5.b.a("ImagePipelineConfig->mNetworkFetcher");
                try {
                    x0Var = aVar.F();
                    x0Var = x0Var == null ? new d0(i10) : x0Var;
                } finally {
                    l5.b.b();
                }
            }
            this.f25064u = x0Var;
            this.f25066w = aVar.G();
            e0 H2 = aVar.H();
            this.f25067x = H2 == null ? new e0(c0.n().m()) : H2;
            e I2 = aVar.I();
            this.f25068y = I2 == null ? new h() : I2;
            Set K2 = aVar.K();
            this.f25069z = K2 == null ? r0.d() : K2;
            Set J2 = aVar.J();
            this.A = J2 == null ? r0.d() : J2;
            Set l10 = aVar.l();
            this.B = l10 == null ? r0.d() : l10;
            this.C = aVar.L();
            g N2 = aVar.N();
            this.D = N2 == null ? i() : N2;
            aVar.z();
            int e10 = a().e();
            g t10 = aVar.t();
            this.f25054k = t10 == null ? new b(e10) : t10;
            this.F = aVar.m();
            aVar.i();
            this.G = aVar.j();
            this.H = aVar.c();
            x4.a e11 = aVar.e();
            this.K = e11 == null ? new x4.l() : e11;
            this.I = aVar.q();
            this.J = aVar.M();
            this.L = aVar.o();
            h3.b x11 = F().x();
            if (x11 != null) {
                bVar.j(x11, F(), new w4.c(a()));
            }
            if (l5.b.d()) {
                l5.b.b();
                return;
            }
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }
}
