package com.bugsnag.android;

import android.app.Application;
import android.content.Context;
import c1.i;
import c1.j;
import c1.l;
import c1.m;
import c1.n;
import c1.q;
import c1.s;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class z {
    private final z1 A;

    /* renamed from: a  reason: collision with root package name */
    final j f19158a;

    /* renamed from: b  reason: collision with root package name */
    final z2 f19159b;

    /* renamed from: c  reason: collision with root package name */
    final b2 f19160c;

    /* renamed from: d  reason: collision with root package name */
    private final l f19161d;

    /* renamed from: e  reason: collision with root package name */
    private final m0 f19162e;

    /* renamed from: f  reason: collision with root package name */
    private final y f19163f;

    /* renamed from: g  reason: collision with root package name */
    private final d1.d f19164g;

    /* renamed from: h  reason: collision with root package name */
    private final Map f19165h;

    /* renamed from: i  reason: collision with root package name */
    final Context f19166i;

    /* renamed from: j  reason: collision with root package name */
    final b1 f19167j;

    /* renamed from: k  reason: collision with root package name */
    final j f19168k;

    /* renamed from: l  reason: collision with root package name */
    final BreadcrumbState f19169l;

    /* renamed from: m  reason: collision with root package name */
    final w2 f19170m;

    /* renamed from: n  reason: collision with root package name */
    protected final y1 f19171n;

    /* renamed from: o  reason: collision with root package name */
    final p3 f19172o;

    /* renamed from: p  reason: collision with root package name */
    final SystemBroadcastReceiver f19173p;

    /* renamed from: q  reason: collision with root package name */
    final s2 f19174q;

    /* renamed from: r  reason: collision with root package name */
    final g0 f19175r;

    /* renamed from: s  reason: collision with root package name */
    final s0 f19176s;

    /* renamed from: t  reason: collision with root package name */
    final b0 f19177t;

    /* renamed from: u  reason: collision with root package name */
    j3 f19178u;

    /* renamed from: v  reason: collision with root package name */
    final e3 f19179v;

    /* renamed from: w  reason: collision with root package name */
    final n2 f19180w;

    /* renamed from: x  reason: collision with root package name */
    final o2 f19181x;

    /* renamed from: y  reason: collision with root package name */
    final q2 f19182y;

    /* renamed from: z  reason: collision with root package name */
    final c1.a f19183z;

    class a implements Function2 {
        a() {
        }

        /* renamed from: a */
        public Unit invoke(Boolean bool, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("hasConnection", bool);
            hashMap.put("networkState", str);
            z.this.A("Connectivity changed", BreadcrumbType.STATE, hashMap);
            if (!bool.booleanValue()) {
                return null;
            }
            z.this.f19171n.v();
            z.this.f19172o.d();
            return null;
        }
    }

    class b implements Function2 {
        b() {
        }

        /* renamed from: a */
        public Unit invoke(String str, Map map) {
            z.this.B(str, map, BreadcrumbType.STATE);
            return null;
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            z.this.f19175r.a();
            z zVar = z.this;
            SystemBroadcastReceiver.d(zVar.f19166i, zVar.f19173p, zVar.f19174q);
        }
    }

    class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n2 f19187a;

        d(n2 n2Var) {
            this.f19187a = n2Var;
        }

        public void run() {
            z.this.f19181x.f(this.f19187a);
        }
    }

    class e implements Function2 {
        e() {
        }

        /* renamed from: a */
        public Unit invoke(String str, String str2) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.MessagePayloadKeys.FROM, str);
            hashMap.put("to", str2);
            z.this.A("Orientation changed", BreadcrumbType.STATE, hashMap);
            z.this.f19177t.d(str2);
            return null;
        }
    }

    class f implements Function2 {
        f() {
        }

        /* renamed from: a */
        public Unit invoke(Boolean bool, Integer num) {
            z.this.f19170m.g(Boolean.TRUE.equals(bool));
            if (z.this.f19170m.h(num)) {
                z zVar = z.this;
                zVar.A("Trim Memory", BreadcrumbType.STATE, Collections.singletonMap("trimLevel", zVar.f19170m.e()));
            }
            z.this.f19170m.c();
            return null;
        }
    }

    class g implements Callable {
        g() {
        }

        /* renamed from: a */
        public Boolean call() {
            boolean z10;
            File nativeReportPath = NativeInterface.getNativeReportPath();
            if (nativeReportPath.exists() || nativeReportPath.mkdirs()) {
                z10 = true;
            } else {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    }

    public z(Context context, f0 f0Var) {
        Context context2 = context;
        f0 f0Var2 = f0Var;
        w2 w2Var = new w2();
        this.f19170m = w2Var;
        c1.a aVar = new c1.a();
        this.f19183z = aVar;
        d1.c cVar = new d1.c(context2, aVar);
        Context a10 = cVar.a();
        this.f19166i = a10;
        e3 u10 = f0Var.u();
        this.f19179v = u10;
        i0 i0Var = new i0(a10, new a());
        this.f19175r = i0Var;
        d1.b bVar = new d1.b(cVar, f0Var2, i0Var, aVar);
        j a11 = bVar.a();
        this.f19158a = a11;
        s2 r10 = a11.r();
        this.f19174q = r10;
        if (!(context2 instanceof Application)) {
            r10.g("You should initialize Bugsnag from the onCreate() callback of your Application subclass, as this guarantees errors are captured as early as possible. If a custom Application subclass is not possible in your app then you should suppress this warning by passing the Application context instead: Bugsnag.start(context.getApplicationContext()). For further info see: https://docs.bugsnag.com/platforms/android/#basic-configuration");
        }
        w3 w3Var = new w3(a10, a11, aVar);
        x xVar = new x(a11, f0Var2);
        this.f19177t = xVar.d();
        y c10 = xVar.c();
        this.f19163f = c10;
        this.f19169l = xVar.b();
        this.f19162e = xVar.e();
        this.f19159b = xVar.g();
        this.f19160c = xVar.f();
        d1.f fVar = new d1.f(cVar, aVar);
        y yVar = c10;
        w3 w3Var2 = w3Var;
        i4 i4Var = new i4(bVar, w3Var, this, aVar, yVar);
        s2 s2Var = r10;
        j jVar = a11;
        e3 e3Var = u10;
        d1.c cVar2 = cVar;
        c1.a aVar2 = aVar;
        n0 n0Var = new n0(cVar, bVar, fVar, i4Var, aVar, i0Var, w3Var2.c(), w2Var);
        w3 w3Var3 = w3Var2;
        this.f19164g = w3Var3.i(f0Var.F());
        y1 y1Var = (y1) new t1(cVar2, bVar, n0Var, aVar2, i4Var, fVar, e3Var, yVar).c().get();
        this.f19171n = y1Var;
        this.f19176s = new s0(s2Var, y1Var, jVar, yVar, e3Var, aVar2);
        this.A = new z1(this, s2Var);
        this.f19181x = (o2) w3Var3.e().a();
        this.f19180w = (n2) w3Var3.d().a();
        this.f19182y = i4Var.b();
        this.f19172o = (p3) i4Var.c().get();
        this.f19168k = (j) n0Var.g().get();
        this.f19167j = (b1) n0Var.h().get();
        this.f19178u = new j3(f0Var.x(), jVar, s2Var);
        if (f0Var.D().contains(z3.USAGE)) {
            this.f19161d = new m();
        } else {
            this.f19161d = new n();
        }
        this.f19165h = f0Var2.f18730a.g();
        this.f19173p = new SystemBroadcastReceiver(this, s2Var);
        Y();
    }

    private void C(o1 o1Var) {
        List h10 = o1Var.h();
        if (h10.size() > 0) {
            String b10 = ((k1) h10.get(0)).b();
            String c10 = ((k1) h10.get(0)).c();
            HashMap hashMap = new HashMap();
            hashMap.put("errorClass", b10);
            hashMap.put("message", c10);
            hashMap.put("unhandled", String.valueOf(o1Var.m()));
            hashMap.put("severity", o1Var.k().toString());
            this.f19169l.add(new Breadcrumb(b10, BreadcrumbType.ERROR, hashMap, new Date(), this.f19174q));
        }
    }

    private void D(String str) {
        s2 s2Var = this.f19174q;
        s2Var.a("Invalid null value supplied to client." + str + ", ignoring");
    }

    private void J(n2 n2Var) {
        try {
            this.f19183z.d(s.IO, new d(n2Var));
        } catch (RejectedExecutionException e10) {
            this.f19174q.c("Failed to persist last run info", e10);
        }
    }

    private void L() {
        this.f19166i.registerComponentCallbacks(new a0(this.f19167j, new e(), new f()));
    }

    private boolean W() {
        try {
            return ((Boolean) this.f19183z.e(s.IO, new g()).get()).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private void Y() {
        if (this.f19158a.l().d()) {
            this.A.b();
        }
        NativeInterface.setClient(this);
        this.f19178u.e(this);
        c3 c3Var = c3.f18655a;
        c3Var.g(this.f19178u.b());
        if (this.f19158a.G().contains(z3.USAGE)) {
            c3Var.f(true);
        }
        this.f19171n.z();
        this.f19171n.v();
        this.f19172o.d();
        this.f19161d.a(this.f19165h);
        this.f19163f.l(this.f19161d);
        M();
        L();
        N();
        A("Bugsnag loaded", BreadcrumbType.STATE, new HashMap());
        this.f19174q.d("Bugsnag loaded");
    }

    /* access modifiers changed from: package-private */
    public void A(String str, BreadcrumbType breadcrumbType, Map map) {
        if (!this.f19158a.J(breadcrumbType)) {
            this.f19169l.add(new Breadcrumb(str, breadcrumbType, map, new Date(), this.f19174q));
        }
    }

    public void B(String str, Map map, BreadcrumbType breadcrumbType) {
        if (str == null || breadcrumbType == null || map == null) {
            D("leaveBreadcrumb");
            return;
        }
        this.f19169l.add(new Breadcrumb(str, breadcrumbType, map, new Date(), this.f19174q));
    }

    public void E() {
        this.f19182y.e();
    }

    public void F(Throwable th, h3 h3Var) {
        if (th == null) {
            D("notify");
        } else if (!this.f19158a.O(th)) {
            Throwable th2 = th;
            K(new o1(th2, this.f19158a, q3.h("handledException"), this.f19159b.h(), this.f19160c.g(), this.f19174q), h3Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(o1 o1Var, h3 h3Var) {
        o1Var.v(this.f19159b.h().j());
        l3 i10 = this.f19172o.i();
        if (i10 != null && (this.f19158a.g() || !i10.k())) {
            o1Var.w(i10);
        }
        if (!this.f19163f.h(o1Var, this.f19174q) || (h3Var != null && !h3Var.a(o1Var))) {
            this.f19174q.d("Skipping notification - onError task returned false");
            return;
        }
        C(o1Var);
        this.f19176s.d(o1Var);
    }

    /* access modifiers changed from: package-private */
    public void H(Throwable th, y2 y2Var, String str, String str2) {
        int i10 = 0;
        Throwable th2 = th;
        K(new o1(th2, this.f19158a, q3.i(str, Severity.ERROR, str2), y2.f19153c.b(this.f19159b.h(), y2Var), this.f19160c.g(), this.f19174q), (h3) null);
        n2 n2Var = this.f19180w;
        if (n2Var != null) {
            i10 = n2Var.a();
        }
        boolean d10 = this.f19182y.d();
        if (d10) {
            i10++;
        }
        J(new n2(i10, true, d10));
        this.f19183z.c();
    }

    public void I() {
        this.f19172o.m();
    }

    /* access modifiers changed from: package-private */
    public void K(o1 o1Var, h3 h3Var) {
        o1Var.s(this.f19167j.j(new Date().getTime()));
        o1Var.c("device", this.f19167j.l());
        o1Var.p(this.f19168k.e());
        o1Var.c("app", this.f19168k.f());
        o1Var.q(this.f19169l.copy());
        k4 c10 = ((m4) this.f19164g.get()).c();
        o1Var.y(c10.b(), c10.a(), c10.c());
        o1Var.r(this.f19162e.c());
        o1Var.u(this.f19161d);
        G(o1Var, h3Var);
    }

    /* access modifiers changed from: package-private */
    public void M() {
        Context context = this.f19166i;
        if (context instanceof Application) {
            Application application = (Application) context;
            i.i(application);
            i.f(this.f19172o);
            if (!this.f19158a.J(BreadcrumbType.STATE)) {
                application.registerActivityLifecycleCallbacks(new b(new b()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void N() {
        try {
            this.f19183z.d(s.DEFAULT, new c());
        } catch (RejectedExecutionException e10) {
            this.f19174q.c("Failed to register for system events", e10);
        }
    }

    /* access modifiers changed from: package-private */
    public void O(q qVar) {
        this.f19159b.removeObserver(qVar);
        this.f19169l.removeObserver(qVar);
        this.f19172o.removeObserver(qVar);
        this.f19177t.removeObserver(qVar);
        ((m4) this.f19164g.get()).removeObserver(qVar);
        this.f19162e.removeObserver(qVar);
        this.f19176s.removeObserver(qVar);
        this.f19182y.removeObserver(qVar);
        this.f19170m.removeObserver(qVar);
        this.f19160c.removeObserver(qVar);
    }

    public boolean P() {
        return this.f19172o.o();
    }

    /* access modifiers changed from: package-private */
    public void Q(boolean z10) {
        this.f19178u.f(this, z10);
    }

    /* access modifiers changed from: package-private */
    public void R(boolean z10) {
        this.f19178u.g(this, z10);
        if (z10) {
            this.A.b();
        } else {
            this.A.c();
        }
    }

    /* access modifiers changed from: package-private */
    public void S(String str) {
        k().l(str);
    }

    /* access modifiers changed from: package-private */
    public void T(String str) {
        this.f19168k.m(str);
    }

    public void U(String str) {
        this.f19162e.e(str);
    }

    public void V(String str, String str2, String str3) {
        ((m4) this.f19164g.get()).d(new k4(str, str2, str3));
    }

    /* access modifiers changed from: package-private */
    public void X() {
        int i10;
        if (!W()) {
            this.f19174q.g("Failed to setup NDK directory.");
            return;
        }
        String absolutePath = this.f19181x.c().getAbsolutePath();
        n2 n2Var = this.f19180w;
        if (n2Var != null) {
            i10 = n2Var.a();
        } else {
            i10 = 0;
        }
        this.f19177t.c(this.f19158a, absolutePath, i10);
        a0();
        this.f19177t.b();
    }

    public void Z() {
        this.f19172o.r(false);
    }

    public void a(String str, String str2) {
        if (str != null) {
            this.f19160c.b(str, str2);
        } else {
            D("addFeatureFlag");
        }
    }

    /* access modifiers changed from: package-private */
    public void a0() {
        this.f19159b.g();
        this.f19162e.b();
        ((m4) this.f19164g.get()).b();
        this.f19170m.c();
        this.f19160c.f();
    }

    public void b(String str, String str2, Object obj) {
        if (str == null || str2 == null) {
            D("addMetadata");
        } else {
            this.f19159b.b(str, str2, obj);
        }
    }

    public void c(String str, Map map) {
        if (str == null || map == null) {
            D("addMetadata");
        } else {
            this.f19159b.c(str, map);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(q qVar) {
        this.f19159b.addObserver(qVar);
        this.f19169l.addObserver(qVar);
        this.f19172o.addObserver(qVar);
        this.f19177t.addObserver(qVar);
        ((m4) this.f19164g.get()).addObserver(qVar);
        this.f19162e.addObserver(qVar);
        this.f19176s.addObserver(qVar);
        this.f19182y.addObserver(qVar);
        this.f19170m.addObserver(qVar);
        this.f19160c.addObserver(qVar);
    }

    public void e(h3 h3Var) {
        if (h3Var != null) {
            this.f19163f.a(h3Var);
        } else {
            D("addOnError");
        }
    }

    /* access modifiers changed from: package-private */
    public void f(String str, String str2) {
        this.f19167j.c(str, str2);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        SystemBroadcastReceiver systemBroadcastReceiver = this.f19173p;
        if (systemBroadcastReceiver != null) {
            try {
                l0.g(this.f19166i, systemBroadcastReceiver, this.f19174q);
            } catch (IllegalArgumentException unused) {
                this.f19174q.g("Receiver not registered");
            }
        }
        super.finalize();
    }

    public void g(String str) {
        if (str != null) {
            this.f19160c.c(str);
        } else {
            D("clearFeatureFlag");
        }
    }

    public void h() {
        this.f19160c.d();
    }

    public void i(String str) {
        if (str != null) {
            this.f19159b.d(str);
        } else {
            D("clearMetadata");
        }
    }

    public void j(String str, String str2) {
        if (str == null || str2 == null) {
            D("clearMetadata");
        } else {
            this.f19159b.e(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public j k() {
        return this.f19168k;
    }

    public List l() {
        return this.f19169l.copy();
    }

    /* access modifiers changed from: package-private */
    public j m() {
        return this.f19158a;
    }

    public String n() {
        return this.f19162e.c();
    }

    /* access modifiers changed from: package-private */
    public m0 o() {
        return this.f19162e;
    }

    /* access modifiers changed from: package-private */
    public b1 p() {
        return this.f19167j;
    }

    /* access modifiers changed from: package-private */
    public y1 q() {
        return this.f19171n;
    }

    /* access modifiers changed from: package-private */
    public b2 r() {
        return this.f19160c;
    }

    public n2 s() {
        return this.f19180w;
    }

    /* access modifiers changed from: package-private */
    public s2 t() {
        return this.f19174q;
    }

    /* access modifiers changed from: package-private */
    public Map u() {
        return this.f19159b.h().n();
    }

    /* access modifiers changed from: package-private */
    public z2 v() {
        return this.f19159b;
    }

    /* access modifiers changed from: package-private */
    public e3 w() {
        return this.f19179v;
    }

    /* access modifiers changed from: package-private */
    public i3 x(Class cls) {
        return this.f19178u.a(cls);
    }

    /* access modifiers changed from: package-private */
    public p3 y() {
        return this.f19172o;
    }

    public k4 z() {
        return ((m4) this.f19164g.get()).c();
    }
}
