package com.facebook.react.uimanager;

import com.facebook.yoga.YogaValue;
import com.facebook.yoga.b;
import com.facebook.yoga.c;
import com.facebook.yoga.e;
import com.facebook.yoga.f;
import com.facebook.yoga.g;
import com.facebook.yoga.h;
import com.facebook.yoga.k;
import com.facebook.yoga.l;
import com.facebook.yoga.m;
import com.facebook.yoga.n;
import com.facebook.yoga.q;
import com.facebook.yoga.r;
import com.facebook.yoga.s;
import com.facebook.yoga.t;
import com.facebook.yoga.v;
import java.util.ArrayList;
import java.util.Arrays;
import p5.a;

public class u0 implements t0 {

    /* renamed from: x  reason: collision with root package name */
    private static final c f3931x = w0.a();

    /* renamed from: a  reason: collision with root package name */
    private int f3932a;

    /* renamed from: b  reason: collision with root package name */
    private String f3933b;

    /* renamed from: c  reason: collision with root package name */
    private int f3934c;

    /* renamed from: d  reason: collision with root package name */
    private e1 f3935d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3936e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3937f = true;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList f3938g;

    /* renamed from: h  reason: collision with root package name */
    private u0 f3939h;

    /* renamed from: i  reason: collision with root package name */
    private u0 f3940i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3941j;

    /* renamed from: k  reason: collision with root package name */
    private int f3942k = 0;

    /* renamed from: l  reason: collision with root package name */
    private u0 f3943l;

    /* renamed from: m  reason: collision with root package name */
    private ArrayList f3944m;

    /* renamed from: n  reason: collision with root package name */
    private int f3945n;

    /* renamed from: o  reason: collision with root package name */
    private int f3946o;

    /* renamed from: p  reason: collision with root package name */
    private int f3947p;

    /* renamed from: q  reason: collision with root package name */
    private int f3948q;

    /* renamed from: r  reason: collision with root package name */
    private final c1 f3949r;

    /* renamed from: s  reason: collision with root package name */
    private final float[] f3950s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean[] f3951t;

    /* renamed from: u  reason: collision with root package name */
    private q f3952u;

    /* renamed from: v  reason: collision with root package name */
    private Integer f3953v;

    /* renamed from: w  reason: collision with root package name */
    private Integer f3954w;

    public u0() {
        float[] fArr = new float[9];
        this.f3950s = fArr;
        this.f3951t = new boolean[9];
        this.f3949r = new c1(0.0f);
        if (!t()) {
            q qVar = (q) n2.a().acquire();
            qVar = qVar == null ? r.a(f3931x) : qVar;
            this.f3952u = qVar;
            qVar.setData(this);
            Arrays.fill(fArr, Float.NaN);
            return;
        }
        this.f3952u = null;
    }

    private int m0() {
        b0 G = G();
        if (G == b0.NONE) {
            return this.f3942k;
        }
        if (G == b0.LEAF) {
            return this.f3942k + 1;
        }
        return 1;
    }

    private void t1(int i10) {
        if (G() != b0.PARENT) {
            u0 l02 = getParent();
            while (l02 != null) {
                l02.f3942k += i10;
                if (l02.G() != b0.PARENT) {
                    l02 = l02.getParent();
                } else {
                    return;
                }
            }
        }
    }

    private void u1() {
        for (int i10 = 0; i10 <= 8; i10++) {
            if (i10 == 0 || i10 == 2 || i10 == 4 || i10 == 5) {
                if (e.a(this.f3950s[i10]) && e.a(this.f3950s[6]) && e.a(this.f3950s[8])) {
                    this.f3952u.setPadding(h.b(i10), this.f3949r.b(i10));
                }
            } else if (i10 == 1 || i10 == 3) {
                if (e.a(this.f3950s[i10]) && e.a(this.f3950s[7]) && e.a(this.f3950s[8])) {
                    this.f3952u.setPadding(h.b(i10), this.f3949r.b(i10));
                }
            } else if (e.a(this.f3950s[i10])) {
                this.f3952u.setPadding(h.b(i10), this.f3949r.b(i10));
            }
            if (this.f3951t[i10]) {
                this.f3952u.setPaddingPercent(h.b(i10), this.f3950s[i10]);
            } else {
                this.f3952u.setPadding(h.b(i10), this.f3950s[i10]);
            }
        }
    }

    public void A(float f10) {
        this.f3952u.setWidth(f10);
    }

    /* renamed from: A0 */
    public u0 e(int i10) {
        ArrayList arrayList = this.f3938g;
        if (arrayList != null) {
            u0 u0Var = (u0) arrayList.remove(i10);
            u0Var.f3939h = null;
            if (this.f3952u != null && !v0()) {
                this.f3952u.removeChildAt(i10);
            }
            x0();
            int m02 = u0Var.m0();
            this.f3942k -= m02;
            t1(-m02);
            return u0Var;
        }
        throw new ArrayIndexOutOfBoundsException("Index " + i10 + " out of bounds: node has no children");
    }

    public int B() {
        return this.f3947p;
    }

    /* renamed from: B0 */
    public final u0 S(int i10) {
        a.c(this.f3944m);
        u0 u0Var = (u0) this.f3944m.remove(i10);
        u0Var.f3943l = null;
        return u0Var;
    }

    public final YogaValue C() {
        return this.f3952u.getWidth();
    }

    public void C0(com.facebook.yoga.a aVar) {
        this.f3952u.setAlignContent(aVar);
    }

    public int D() {
        return this.f3946o;
    }

    public void D0(com.facebook.yoga.a aVar) {
        this.f3952u.setAlignItems(aVar);
    }

    public void E(Object obj) {
    }

    public void E0(com.facebook.yoga.a aVar) {
        this.f3952u.setAlignSelf(aVar);
    }

    public final e1 F() {
        return (e1) a.c(this.f3935d);
    }

    public void F0(b bVar) {
        this.f3952u.setBaselineFunction(bVar);
    }

    public b0 G() {
        if (t() || b0()) {
            return b0.NONE;
        }
        if (o0()) {
            return b0.LEAF;
        }
        return b0.PARENT;
    }

    public void G0(int i10, float f10) {
        this.f3952u.setBorder(h.b(i10), f10);
    }

    public final int H() {
        boolean z10;
        if (this.f3934c != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a(z10);
        return this.f3934c;
    }

    public void H0(float f10) {
        this.f3952u.setGap(l.COLUMN, f10);
    }

    public void I0(float f10) {
        this.f3952u.setGapPercent(l.COLUMN, f10);
    }

    public boolean J(float f10, float f11) {
        if (!n0()) {
            return false;
        }
        float T = T();
        float P = P();
        float f12 = f10 + T;
        int round = Math.round(f12);
        float f13 = f11 + P;
        int round2 = Math.round(f13);
        int round3 = Math.round(f12 + c0());
        int round4 = Math.round(f13 + k());
        int round5 = Math.round(T);
        int round6 = Math.round(P);
        int i10 = round3 - round;
        int i11 = round4 - round2;
        if (round5 == this.f3945n && round6 == this.f3946o && i10 == this.f3947p && i11 == this.f3948q) {
            return false;
        }
        return true;
    }

    public void J0(int i10, float f10) {
        this.f3949r.c(i10, f10);
        u1();
    }

    public final boolean K() {
        return this.f3936e;
    }

    public void K0(g gVar) {
        this.f3952u.setDisplay(gVar);
    }

    public void L0(float f10) {
        this.f3952u.setFlexBasis(f10);
    }

    public final String M() {
        return (String) a.c(this.f3933b);
    }

    public void M0() {
        this.f3952u.setFlexBasisAuto();
    }

    public void N0(float f10) {
        this.f3952u.setFlexBasisPercent(f10);
    }

    public void O(int i10) {
        this.f3932a = i10;
    }

    public void O0(k kVar) {
        this.f3952u.setFlexDirection(kVar);
    }

    public final float P() {
        return this.f3952u.getLayoutY();
    }

    public void P0(v vVar) {
        this.f3952u.setWrap(vVar);
    }

    public void Q(float f10, float f11) {
        this.f3952u.calculateLayout(f10, f11);
    }

    public void Q0(float f10) {
        this.f3952u.setGap(l.ALL, f10);
    }

    public int R() {
        return this.f3945n;
    }

    public void R0(float f10) {
        this.f3952u.setGap(l.ALL, f10);
    }

    public void S0(m mVar) {
        this.f3952u.setJustifyContent(mVar);
    }

    public final float T() {
        return this.f3952u.getLayoutX();
    }

    /* renamed from: T0 */
    public final void N(u0 u0Var) {
        this.f3940i = u0Var;
    }

    public void U0(int i10, float f10) {
        this.f3952u.setMargin(h.b(i10), f10);
    }

    public void V(d0 d0Var) {
    }

    public void V0(int i10) {
        this.f3952u.setMarginAuto(h.b(i10));
    }

    public void W0(int i10, float f10) {
        this.f3952u.setMarginPercent(h.b(i10), f10);
    }

    public void X0(n nVar) {
        this.f3952u.setMeasureFunction(nVar);
    }

    public void Y0(s sVar) {
        this.f3952u.setOverflow(sVar);
    }

    public final void Z(boolean z10) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (getParent() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        a.b(z11, "Must remove from no opt parent first");
        if (this.f3943l == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        a.b(z12, "Must remove from native parent first");
        if (v() == 0) {
            z13 = true;
        }
        a.b(z13, "Must remove all native children first");
        this.f3941j = z10;
    }

    public void Z0(int i10, float f10) {
        this.f3950s[i10] = f10;
        this.f3951t[i10] = false;
        u1();
    }

    public final void a0(v0 v0Var) {
        e2.f(this, v0Var);
        y0();
    }

    public void a1(int i10, float f10) {
        this.f3950s[i10] = f10;
        this.f3951t[i10] = !e.a(f10);
        u1();
    }

    public final int b() {
        ArrayList arrayList = this.f3938g;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final boolean b0() {
        return this.f3941j;
    }

    public void b1(int i10, float f10) {
        this.f3952u.setPosition(h.b(i10), f10);
    }

    public int c() {
        return this.f3948q;
    }

    public final float c0() {
        return this.f3952u.getLayoutWidth();
    }

    public void c1(int i10, float f10) {
        this.f3952u.setPositionPercent(h.b(i10), f10);
    }

    public final void d() {
        this.f3937f = false;
        if (n0()) {
            w0();
        }
    }

    /* renamed from: d0 */
    public void I(u0 u0Var, int i10) {
        if (this.f3938g == null) {
            this.f3938g = new ArrayList(4);
        }
        this.f3938g.add(i10, u0Var);
        u0Var.f3939h = this;
        if (this.f3952u != null && !v0()) {
            q qVar = u0Var.f3952u;
            if (qVar != null) {
                this.f3952u.addChildAt(qVar, i10);
            } else {
                throw new RuntimeException("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '" + u0Var.toString() + "' to a '" + toString() + "')");
            }
        }
        x0();
        int m02 = u0Var.m0();
        this.f3942k += m02;
        t1(m02);
    }

    public void d1(t tVar) {
        this.f3952u.setPositionType(tVar);
    }

    public void dispose() {
        q qVar = this.f3952u;
        if (qVar != null) {
            qVar.reset();
            n2.a().release(this.f3952u);
        }
    }

    /* renamed from: e0 */
    public final void x(u0 u0Var, int i10) {
        boolean z10;
        boolean z11 = false;
        if (G() == b0.PARENT) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a(z10);
        if (u0Var.G() != b0.NONE) {
            z11 = true;
        }
        a.a(z11);
        if (this.f3944m == null) {
            this.f3944m = new ArrayList(4);
        }
        this.f3944m.add(i10, u0Var);
        u0Var.f3943l = this;
    }

    public void e1(float f10) {
        this.f3952u.setGap(l.ROW, f10);
    }

    public void f(float f10) {
        this.f3952u.setHeight(f10);
    }

    /* renamed from: f0 */
    public final u0 a(int i10) {
        ArrayList arrayList = this.f3938g;
        if (arrayList != null) {
            return (u0) arrayList.get(i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index " + i10 + " out of bounds: node has no children");
    }

    public void f1(float f10) {
        this.f3952u.setGapPercent(l.ROW, f10);
    }

    public void g(int i10, int i11) {
        this.f3953v = Integer.valueOf(i10);
        this.f3954w = Integer.valueOf(i11);
    }

    public final f g0() {
        return this.f3952u.getLayoutDirection();
    }

    public void g1(float f10) {
        this.f3952u.setAspectRatio(f10);
    }

    public Integer getHeightMeasureSpec() {
        return this.f3954w;
    }

    public Integer getWidthMeasureSpec() {
        return this.f3953v;
    }

    public void h() {
        if (!t()) {
            this.f3952u.dirty();
        } else if (getParent() != null) {
            getParent().h();
        }
    }

    /* renamed from: h0 */
    public final u0 W() {
        u0 u0Var = this.f3940i;
        if (u0Var != null) {
            return u0Var;
        }
        return Y();
    }

    public void h1() {
        this.f3952u.setHeightAuto();
    }

    public final void i(String str) {
        this.f3933b = str;
    }

    /* renamed from: i0 */
    public final int u(u0 u0Var) {
        int i10 = 0;
        for (int i11 = 0; i11 < b(); i11++) {
            u0 f02 = a(i11);
            if (u0Var == f02) {
                return i10;
            }
            i10 += f02.m0();
        }
        throw new RuntimeException("Child " + u0Var.q() + " was not a child of " + this.f3932a);
    }

    public void i1(float f10) {
        this.f3952u.setHeightPercent(f10);
    }

    public void j(f fVar) {
        this.f3952u.setDirection(fVar);
    }

    /* renamed from: j0 */
    public final u0 Y() {
        return this.f3943l;
    }

    public void j1(float f10) {
        this.f3952u.setMaxHeight(f10);
    }

    public final float k() {
        return this.f3952u.getLayoutHeight();
    }

    public final float k0(int i10) {
        return this.f3952u.getLayoutPadding(h.b(i10));
    }

    public void k1(float f10) {
        this.f3952u.setMaxHeightPercent(f10);
    }

    public final boolean l() {
        if (this.f3937f || n0() || s0()) {
            return true;
        }
        return false;
    }

    /* renamed from: l0 */
    public final u0 getParent() {
        return this.f3939h;
    }

    public void l1(float f10) {
        this.f3952u.setMaxWidth(f10);
    }

    public final YogaValue m() {
        return this.f3952u.getHeight();
    }

    public void m1(float f10) {
        this.f3952u.setMaxWidthPercent(f10);
    }

    public Iterable n() {
        if (u0()) {
            return null;
        }
        return this.f3938g;
    }

    public final boolean n0() {
        q qVar = this.f3952u;
        if (qVar == null || !qVar.hasNewLayout()) {
            return false;
        }
        return true;
    }

    public void n1(float f10) {
        this.f3952u.setMinHeight(f10);
    }

    public void o(float f10, float f11, r1 r1Var, d0 d0Var) {
        boolean z10;
        if (this.f3937f) {
            z0(r1Var);
        }
        if (n0()) {
            float T = T();
            float P = P();
            float f12 = f10 + T;
            int round = Math.round(f12);
            float f13 = f11 + P;
            int round2 = Math.round(f13);
            int round3 = Math.round(f12 + c0());
            int round4 = Math.round(f13 + k());
            int round5 = Math.round(T);
            int round6 = Math.round(P);
            int i10 = round3 - round;
            int i11 = round4 - round2;
            if (round5 == this.f3945n && round6 == this.f3946o && i10 == this.f3947p && i11 == this.f3948q) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f3945n = round5;
            this.f3946o = round6;
            this.f3947p = i10;
            this.f3948q = i11;
            if (!z10) {
                return;
            }
            if (d0Var != null) {
                d0Var.l(this);
                return;
            }
            r1Var.P(getParent().q(), q(), R(), D(), B(), c());
        }
    }

    public boolean o0() {
        return false;
    }

    public void o1(float f10) {
        this.f3952u.setMinHeightPercent(f10);
    }

    public void p() {
        if (b() != 0) {
            int i10 = 0;
            for (int b10 = b() - 1; b10 >= 0; b10--) {
                if (this.f3952u != null && !v0()) {
                    this.f3952u.removeChildAt(b10);
                }
                u0 f02 = a(b10);
                f02.f3939h = null;
                i10 += f02.m0();
                f02.dispose();
            }
            ((ArrayList) a.c(this.f3938g)).clear();
            x0();
            this.f3942k -= i10;
            t1(-i10);
        }
    }

    /* renamed from: p0 */
    public final int L(u0 u0Var) {
        ArrayList arrayList = this.f3938g;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.indexOf(u0Var);
    }

    public void p1(float f10) {
        this.f3952u.setMinWidth(f10);
    }

    public final int q() {
        return this.f3932a;
    }

    /* renamed from: q0 */
    public final int w(u0 u0Var) {
        a.c(this.f3944m);
        return this.f3944m.indexOf(u0Var);
    }

    public void q1(float f10) {
        this.f3952u.setMinWidthPercent(f10);
    }

    public final void r() {
        ArrayList arrayList = this.f3944m;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((u0) this.f3944m.get(size)).f3943l = null;
            }
            this.f3944m.clear();
        }
    }

    /* renamed from: r0 */
    public boolean X(u0 u0Var) {
        for (u0 l02 = getParent(); l02 != null; l02 = l02.getParent()) {
            if (l02 == u0Var) {
                return true;
            }
        }
        return false;
    }

    public void r1() {
        this.f3952u.setWidthAuto();
    }

    public void s() {
        Q(Float.NaN, Float.NaN);
    }

    public final boolean s0() {
        q qVar = this.f3952u;
        if (qVar == null || !qVar.isDirty()) {
            return false;
        }
        return true;
    }

    public void s1(float f10) {
        this.f3952u.setWidthPercent(f10);
    }

    public void setFlex(float f10) {
        this.f3952u.setFlex(f10);
    }

    public void setFlexGrow(float f10) {
        this.f3952u.setFlexGrow(f10);
    }

    public void setFlexShrink(float f10) {
        this.f3952u.setFlexShrink(f10);
    }

    public void setShouldNotifyOnLayout(boolean z10) {
        this.f3936e = z10;
    }

    public boolean t() {
        return false;
    }

    public boolean t0() {
        return this.f3952u.isMeasureDefined();
    }

    public String toString() {
        return "[" + this.f3933b + " " + q() + "]";
    }

    public boolean u0() {
        return false;
    }

    public final int v() {
        ArrayList arrayList = this.f3944m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public boolean v0() {
        return t0();
    }

    public final void w0() {
        q qVar = this.f3952u;
        if (qVar != null) {
            qVar.markLayoutSeen();
        }
    }

    public void x0() {
        if (!this.f3937f) {
            this.f3937f = true;
            u0 l02 = getParent();
            if (l02 != null) {
                l02.x0();
            }
        }
    }

    public final void y(int i10) {
        this.f3934c = i10;
    }

    public void y0() {
    }

    public void z(e1 e1Var) {
        this.f3935d = e1Var;
    }

    public void z0(r1 r1Var) {
    }
}
