package t3;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import java.util.Map;
import java.util.concurrent.Executor;
import m4.b;
import s3.a;
import s3.c;
import s3.d;
import y2.g;
import y2.j;
import y2.l;
import y3.a;

public abstract class a implements z3.a, a.C0331a, a.C0354a {

    /* renamed from: w  reason: collision with root package name */
    private static final Map f24070w = g.of("component_tag", "drawee");

    /* renamed from: x  reason: collision with root package name */
    private static final Map f24071x = g.of("origin", "memory_bitmap", "origin_sub", "shortcut");

    /* renamed from: y  reason: collision with root package name */
    private static final Class f24072y = a.class;

    /* renamed from: a  reason: collision with root package name */
    private final c f24073a = c.a();

    /* renamed from: b  reason: collision with root package name */
    private final s3.a f24074b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f24075c;

    /* renamed from: d  reason: collision with root package name */
    private d f24076d;

    /* renamed from: e  reason: collision with root package name */
    private y3.a f24077e;

    /* renamed from: f  reason: collision with root package name */
    protected d f24078f;

    /* renamed from: g  reason: collision with root package name */
    protected m4.d f24079g = new m4.d();

    /* renamed from: h  reason: collision with root package name */
    private z3.c f24080h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f24081i;

    /* renamed from: j  reason: collision with root package name */
    private String f24082j;

    /* renamed from: k  reason: collision with root package name */
    private Object f24083k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24084l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24085m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24086n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24087o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24088p;

    /* renamed from: q  reason: collision with root package name */
    private String f24089q;

    /* renamed from: r  reason: collision with root package name */
    private i3.c f24090r;

    /* renamed from: s  reason: collision with root package name */
    private Object f24091s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f24092t = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f24093u = false;

    /* renamed from: v  reason: collision with root package name */
    protected Drawable f24094v;

    /* renamed from: t3.a$a  reason: collision with other inner class name */
    class C0336a extends i3.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f24095a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f24096b;

        C0336a(String str, boolean z10) {
            this.f24095a = str;
            this.f24096b = z10;
        }

        public void a(i3.c cVar) {
            boolean b10 = cVar.b();
            a.this.N(this.f24095a, cVar, cVar.getProgress(), b10);
        }

        public void e(i3.c cVar) {
            a.this.K(this.f24095a, cVar, cVar.c(), true);
        }

        public void f(i3.c cVar) {
            boolean b10 = cVar.b();
            boolean d10 = cVar.d();
            float progress = cVar.getProgress();
            Object result = cVar.getResult();
            if (result != null) {
                a.this.M(this.f24095a, cVar, result, progress, b10, this.f24096b, d10);
            } else if (b10) {
                a.this.K(this.f24095a, cVar, new NullPointerException(), true);
            }
        }
    }

    private static class b extends f {
        private b() {
        }

        public static b e(d dVar, d dVar2) {
            if (l5.b.d()) {
                l5.b.a("AbstractDraweeController#createInternal");
            }
            b bVar = new b();
            bVar.b(dVar);
            bVar.b(dVar2);
            if (l5.b.d()) {
                l5.b.b();
            }
            return bVar;
        }
    }

    public a(s3.a aVar, Executor executor, String str, Object obj) {
        this.f24074b = aVar;
        this.f24075c = executor;
        B(str, obj);
    }

    private z3.c A() {
        z3.c cVar = this.f24080h;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException("mSettableDraweeHierarchy is null; Caller context: " + this.f24083k);
    }

    private synchronized void B(String str, Object obj) {
        s3.a aVar;
        try {
            if (l5.b.d()) {
                l5.b.a("AbstractDraweeController#init");
            }
            this.f24073a.b(c.a.ON_INIT_CONTROLLER);
            if (!this.f24092t && (aVar = this.f24074b) != null) {
                aVar.a(this);
            }
            this.f24084l = false;
            this.f24086n = false;
            P();
            this.f24088p = false;
            d dVar = this.f24076d;
            if (dVar != null) {
                dVar.a();
            }
            y3.a aVar2 = this.f24077e;
            if (aVar2 != null) {
                aVar2.a();
                this.f24077e.f(this);
            }
            d dVar2 = this.f24078f;
            if (dVar2 instanceof b) {
                ((b) dVar2).c();
            } else {
                this.f24078f = null;
            }
            z3.c cVar = this.f24080h;
            if (cVar != null) {
                cVar.h();
                this.f24080h.b((Drawable) null);
                this.f24080h = null;
            }
            this.f24081i = null;
            if (z2.a.u(2)) {
                z2.a.y(f24072y, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f24082j, str);
            }
            this.f24082j = str;
            this.f24083k = obj;
            if (l5.b.d()) {
                l5.b.b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private boolean D(String str, i3.c cVar) {
        if (cVar == null && this.f24090r == null) {
            return true;
        }
        if (!str.equals(this.f24082j) || cVar != this.f24090r || !this.f24085m) {
            return false;
        }
        return true;
    }

    private void F(String str, Throwable th) {
        if (z2.a.u(2)) {
            z2.a.z(f24072y, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.f24082j, str, th);
        }
    }

    private void G(String str, Object obj) {
        if (z2.a.u(2)) {
            z2.a.A(f24072y, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.f24082j, str, v(obj), Integer.valueOf(w(obj)));
        }
    }

    private b.a H(i3.c cVar, Object obj, Uri uri) {
        Map map;
        if (cVar == null) {
            map = null;
        } else {
            map = cVar.getExtras();
        }
        return I(map, J(obj), uri);
    }

    private b.a I(Map map, Map map2, Uri uri) {
        PointF pointF;
        String str;
        z3.c cVar = this.f24080h;
        if (cVar instanceof x3.a) {
            x3.a aVar = (x3.a) cVar;
            String valueOf = String.valueOf(aVar.o());
            pointF = aVar.n();
            str = valueOf;
        } else {
            str = null;
            pointF = null;
        }
        return l4.b.a(f24070w, f24071x, map, (Map) null, s(), str, pointF, map2, n(), E(), uri);
    }

    /* access modifiers changed from: private */
    public void K(String str, i3.c cVar, Throwable th, boolean z10) {
        c.a aVar;
        Drawable drawable;
        if (l5.b.d()) {
            l5.b.a("AbstractDraweeController#onFailureInternal");
        }
        if (!D(str, cVar)) {
            F("ignore_old_datasource @ onFailure", th);
            cVar.close();
            if (l5.b.d()) {
                l5.b.b();
                return;
            }
            return;
        }
        c cVar2 = this.f24073a;
        if (z10) {
            aVar = c.a.ON_DATASOURCE_FAILURE;
        } else {
            aVar = c.a.ON_DATASOURCE_FAILURE_INT;
        }
        cVar2.b(aVar);
        if (z10) {
            F("final_failed @ onFailure", th);
            this.f24090r = null;
            this.f24087o = true;
            z3.c cVar3 = this.f24080h;
            if (cVar3 != null) {
                if (this.f24088p && (drawable = this.f24094v) != null) {
                    cVar3.g(drawable, 1.0f, true);
                } else if (f0()) {
                    cVar3.c(th);
                } else {
                    cVar3.d(th);
                }
            }
            S(th, cVar);
        } else {
            F("intermediate_failed @ onFailure", th);
            T(th);
        }
        if (l5.b.d()) {
            l5.b.b();
        }
    }

    /* access modifiers changed from: private */
    public void M(String str, i3.c cVar, Object obj, float f10, boolean z10, boolean z11, boolean z12) {
        c.a aVar;
        Drawable k10;
        Object obj2;
        Drawable drawable;
        try {
            if (l5.b.d()) {
                l5.b.a("AbstractDraweeController#onNewResultInternal");
            }
            if (!D(str, cVar)) {
                G("ignore_old_datasource @ onNewResult", obj);
                Q(obj);
                cVar.close();
                if (l5.b.d()) {
                    l5.b.b();
                    return;
                }
                return;
            }
            c cVar2 = this.f24073a;
            if (z10) {
                aVar = c.a.ON_DATASOURCE_RESULT;
            } else {
                aVar = c.a.ON_DATASOURCE_RESULT_INT;
            }
            cVar2.b(aVar);
            try {
                k10 = k(obj);
                obj2 = this.f24091s;
                drawable = this.f24094v;
                this.f24091s = obj;
                this.f24094v = k10;
                if (z10) {
                    G("set_final_result @ onNewResult", obj);
                    this.f24090r = null;
                    A().g(k10, 1.0f, z11);
                    X(str, obj, cVar);
                } else if (z12) {
                    G("set_temporary_result @ onNewResult", obj);
                    A().g(k10, 1.0f, z11);
                    X(str, obj, cVar);
                } else {
                    G("set_intermediate_result @ onNewResult", obj);
                    A().g(k10, f10, z11);
                    U(str, obj);
                }
                if (!(drawable == null || drawable == k10)) {
                    O(drawable);
                }
                if (!(obj2 == null || obj2 == obj)) {
                    G("release_previous_result @ onNewResult", obj2);
                    Q(obj2);
                }
                if (l5.b.d()) {
                    l5.b.b();
                }
            } catch (Exception e10) {
                G("drawable_failed @ onNewResult", obj);
                Q(obj);
                K(str, cVar, e10, z10);
                if (l5.b.d()) {
                    l5.b.b();
                }
            }
        } catch (Throwable th) {
            if (l5.b.d()) {
                l5.b.b();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void N(String str, i3.c cVar, float f10, boolean z10) {
        if (!D(str, cVar)) {
            F("ignore_old_datasource @ onProgress", (Throwable) null);
            cVar.close();
        } else if (!z10) {
            this.f24080h.e(f10, false);
        }
    }

    private void P() {
        Map map;
        boolean z10 = this.f24085m;
        this.f24085m = false;
        this.f24087o = false;
        i3.c cVar = this.f24090r;
        Map map2 = null;
        if (cVar != null) {
            map = cVar.getExtras();
            this.f24090r.close();
            this.f24090r = null;
        } else {
            map = null;
        }
        Drawable drawable = this.f24094v;
        if (drawable != null) {
            O(drawable);
        }
        if (this.f24089q != null) {
            this.f24089q = null;
        }
        this.f24094v = null;
        Object obj = this.f24091s;
        if (obj != null) {
            Map J = J(x(obj));
            G("release", this.f24091s);
            Q(this.f24091s);
            this.f24091s = null;
            map2 = J;
        }
        if (z10) {
            V(map, map2);
        }
    }

    private void S(Throwable th, i3.c cVar) {
        b.a H = H(cVar, (Object) null, (Uri) null);
        o().i(this.f24082j, th);
        p().j(this.f24082j, th, H);
    }

    private void T(Throwable th) {
        o().p(this.f24082j, th);
        p().m(this.f24082j);
    }

    private void U(String str, Object obj) {
        Object x10 = x(obj);
        o().a(str, x10);
        p().a(str, x10);
    }

    private void V(Map map, Map map2) {
        o().k(this.f24082j);
        p().k(this.f24082j, I(map, map2, (Uri) null));
    }

    private void X(String str, Object obj, i3.c cVar) {
        Object x10 = x(obj);
        o().f(str, x10, l());
        p().h(str, x10, H(cVar, x10, (Uri) null));
    }

    private boolean f0() {
        d dVar;
        if (!this.f24087o || (dVar = this.f24076d) == null || !dVar.e()) {
            return false;
        }
        return true;
    }

    private Rect s() {
        z3.c cVar = this.f24080h;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    /* access modifiers changed from: protected */
    public void C(String str, Object obj) {
        B(str, obj);
        this.f24092t = false;
        this.f24093u = false;
    }

    /* access modifiers changed from: protected */
    public boolean E() {
        return this.f24093u;
    }

    public abstract Map J(Object obj);

    /* access modifiers changed from: protected */
    public void L(String str, Object obj) {
    }

    /* access modifiers changed from: protected */
    public abstract void O(Drawable drawable);

    /* access modifiers changed from: protected */
    public abstract void Q(Object obj);

    public void R(m4.b bVar) {
        this.f24079g.v(bVar);
    }

    /* access modifiers changed from: protected */
    public void W(i3.c cVar, Object obj) {
        o().o(this.f24082j, this.f24083k);
        p().n(this.f24082j, this.f24083k, H(cVar, obj, y()));
    }

    public void Y(String str) {
        this.f24089q = str;
    }

    /* access modifiers changed from: protected */
    public void Z(Drawable drawable) {
        this.f24081i = drawable;
        z3.c cVar = this.f24080h;
        if (cVar != null) {
            cVar.b(drawable);
        }
    }

    public void a() {
        if (l5.b.d()) {
            l5.b.a("AbstractDraweeController#onDetach");
        }
        if (z2.a.u(2)) {
            z2.a.x(f24072y, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f24082j);
        }
        this.f24073a.b(c.a.ON_DETACH_CONTROLLER);
        this.f24084l = false;
        this.f24074b.d(this);
        if (l5.b.d()) {
            l5.b.b();
        }
    }

    public void a0(e eVar) {
    }

    public z3.b b() {
        return this.f24080h;
    }

    /* access modifiers changed from: protected */
    public void b0(y3.a aVar) {
        this.f24077e = aVar;
        if (aVar != null) {
            aVar.f(this);
        }
    }

    public boolean c(MotionEvent motionEvent) {
        if (z2.a.u(2)) {
            z2.a.y(f24072y, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f24082j, motionEvent);
        }
        y3.a aVar = this.f24077e;
        if (aVar == null) {
            return false;
        }
        if (!aVar.b() && !e0()) {
            return false;
        }
        this.f24077e.d(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void c0(boolean z10) {
        this.f24093u = z10;
    }

    public void d() {
        String str;
        if (l5.b.d()) {
            l5.b.a("AbstractDraweeController#onAttach");
        }
        if (z2.a.u(2)) {
            Class cls = f24072y;
            Integer valueOf = Integer.valueOf(System.identityHashCode(this));
            String str2 = this.f24082j;
            if (this.f24085m) {
                str = "request already submitted";
            } else {
                str = "request needs submit";
            }
            z2.a.y(cls, "controller %x %s: onAttach: %s", valueOf, str2, str);
        }
        this.f24073a.b(c.a.ON_ATTACH_CONTROLLER);
        l.g(this.f24080h);
        this.f24074b.a(this);
        this.f24084l = true;
        if (!this.f24085m) {
            g0();
        }
        if (l5.b.d()) {
            l5.b.b();
        }
    }

    /* access modifiers changed from: protected */
    public void d0(boolean z10) {
        this.f24088p = z10;
    }

    public void e(z3.b bVar) {
        c.a aVar;
        if (z2.a.u(2)) {
            z2.a.y(f24072y, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f24082j, bVar);
        }
        c cVar = this.f24073a;
        if (bVar != null) {
            aVar = c.a.ON_SET_HIERARCHY;
        } else {
            aVar = c.a.ON_CLEAR_HIERARCHY;
        }
        cVar.b(aVar);
        if (this.f24085m) {
            this.f24074b.a(this);
            release();
        }
        z3.c cVar2 = this.f24080h;
        if (cVar2 != null) {
            cVar2.b((Drawable) null);
            this.f24080h = null;
        }
        if (bVar != null) {
            l.b(Boolean.valueOf(bVar instanceof z3.c));
            z3.c cVar3 = (z3.c) bVar;
            this.f24080h = cVar3;
            cVar3.b(this.f24081i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean e0() {
        return f0();
    }

    /* access modifiers changed from: protected */
    public void g0() {
        if (l5.b.d()) {
            l5.b.a("AbstractDraweeController#submitRequest");
        }
        Object m10 = m();
        if (m10 != null) {
            if (l5.b.d()) {
                l5.b.a("AbstractDraweeController#submitRequest->cache");
            }
            this.f24090r = null;
            this.f24085m = true;
            this.f24087o = false;
            this.f24073a.b(c.a.ON_SUBMIT_CACHE_HIT);
            W(this.f24090r, x(m10));
            L(this.f24082j, m10);
            M(this.f24082j, this.f24090r, m10, 1.0f, true, true, true);
            if (l5.b.d()) {
                l5.b.b();
            }
            if (l5.b.d()) {
                l5.b.b();
                return;
            }
            return;
        }
        this.f24073a.b(c.a.ON_DATASOURCE_SUBMIT);
        this.f24080h.e(0.0f, true);
        this.f24085m = true;
        this.f24087o = false;
        i3.c r10 = r();
        this.f24090r = r10;
        W(r10, (Object) null);
        if (z2.a.u(2)) {
            z2.a.y(f24072y, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f24082j, Integer.valueOf(System.identityHashCode(this.f24090r)));
        }
        this.f24090r.e(new C0336a(this.f24082j, this.f24090r.a()), this.f24075c);
        if (l5.b.d()) {
            l5.b.b();
        }
    }

    public void i(d dVar) {
        l.g(dVar);
        d dVar2 = this.f24078f;
        if (dVar2 instanceof b) {
            ((b) dVar2).b(dVar);
        } else if (dVar2 != null) {
            this.f24078f = b.e(dVar2, dVar);
        } else {
            this.f24078f = dVar;
        }
    }

    public void j(m4.b bVar) {
        this.f24079g.p(bVar);
    }

    /* access modifiers changed from: protected */
    public abstract Drawable k(Object obj);

    public Animatable l() {
        Drawable drawable = this.f24094v;
        if (drawable instanceof Animatable) {
            return (Animatable) drawable;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract Object m();

    public Object n() {
        return this.f24083k;
    }

    /* access modifiers changed from: protected */
    public d o() {
        d dVar = this.f24078f;
        if (dVar == null) {
            return c.b();
        }
        return dVar;
    }

    public boolean onClick() {
        if (z2.a.u(2)) {
            z2.a.x(f24072y, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.f24082j);
        }
        if (!f0()) {
            return false;
        }
        this.f24076d.b();
        this.f24080h.h();
        g0();
        return true;
    }

    /* access modifiers changed from: protected */
    public m4.b p() {
        return this.f24079g;
    }

    /* access modifiers changed from: protected */
    public Drawable q() {
        return this.f24081i;
    }

    /* access modifiers changed from: protected */
    public abstract i3.c r();

    public void release() {
        this.f24073a.b(c.a.ON_RELEASE_CONTROLLER);
        d dVar = this.f24076d;
        if (dVar != null) {
            dVar.c();
        }
        y3.a aVar = this.f24077e;
        if (aVar != null) {
            aVar.e();
        }
        z3.c cVar = this.f24080h;
        if (cVar != null) {
            cVar.h();
        }
        P();
    }

    /* access modifiers changed from: protected */
    public y3.a t() {
        return this.f24077e;
    }

    public String toString() {
        return j.c(this).c("isAttached", this.f24084l).c("isRequestSubmitted", this.f24085m).c("hasFetchFailed", this.f24087o).a("fetchedImage", w(this.f24091s)).b(DbParams.TABLE_EVENTS, this.f24073a.toString()).toString();
    }

    public String u() {
        return this.f24082j;
    }

    /* access modifiers changed from: protected */
    public String v(Object obj) {
        if (obj != null) {
            return obj.getClass().getSimpleName();
        }
        return "<null>";
    }

    /* access modifiers changed from: protected */
    public abstract int w(Object obj);

    /* access modifiers changed from: protected */
    public abstract Object x(Object obj);

    /* access modifiers changed from: protected */
    public abstract Uri y();

    /* access modifiers changed from: protected */
    public d z() {
        if (this.f24076d == null) {
            this.f24076d = new d();
        }
        return this.f24076d;
    }
}
