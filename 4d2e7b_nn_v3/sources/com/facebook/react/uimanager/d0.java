package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.views.view.ReactViewManager;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    private final r1 f3574a;

    /* renamed from: b  reason: collision with root package name */
    private final b1 f3575b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseBooleanArray f3576c = new SparseBooleanArray();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public final t0 f3577a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3578b;

        a(t0 t0Var, int i10) {
            this.f3577a = t0Var;
            this.f3578b = i10;
        }
    }

    public d0(r1 r1Var, b1 b1Var) {
        this.f3574a = r1Var;
        this.f3575b = b1Var;
    }

    private void a(t0 t0Var, t0 t0Var2, int i10) {
        boolean z10;
        boolean z11;
        if (t0Var2.G() != b0.PARENT) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.a(z10);
        for (int i11 = 0; i11 < t0Var2.b(); i11++) {
            t0 a10 = t0Var2.a(i11);
            if (a10.Y() == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            p5.a.a(z11);
            int v10 = t0Var.v();
            if (a10.G() == b0.NONE) {
                d(t0Var, a10, i10);
            } else {
                b(t0Var, a10, i10);
            }
            i10 += t0Var.v() - v10;
        }
    }

    private void b(t0 t0Var, t0 t0Var2, int i10) {
        t0Var.x(t0Var2, i10);
        this.f3574a.G(t0Var.q(), (int[]) null, new a2[]{new a2(t0Var2.q(), i10)}, (int[]) null);
        if (t0Var2.G() != b0.PARENT) {
            a(t0Var, t0Var2, i10 + 1);
        }
    }

    private void c(t0 t0Var, t0 t0Var2, int i10) {
        int u10 = t0Var.u(t0Var.a(i10));
        if (t0Var.G() != b0.PARENT) {
            a s10 = s(t0Var, u10);
            if (s10 != null) {
                t0 t0Var3 = s10.f3577a;
                u10 = s10.f3578b;
                t0Var = t0Var3;
            } else {
                return;
            }
        }
        if (t0Var2.G() != b0.NONE) {
            b(t0Var, t0Var2, u10);
        } else {
            d(t0Var, t0Var2, u10);
        }
    }

    private void d(t0 t0Var, t0 t0Var2, int i10) {
        a(t0Var, t0Var2, i10);
    }

    private void e(t0 t0Var) {
        int q10 = t0Var.q();
        if (!this.f3576c.get(q10)) {
            this.f3576c.put(q10, true);
            t0 parent = t0Var.getParent();
            int R = t0Var.R();
            int D = t0Var.D();
            while (parent != null && parent.G() != b0.PARENT) {
                if (!parent.t()) {
                    R += Math.round(parent.T());
                    D += Math.round(parent.P());
                }
                parent = parent.getParent();
            }
            f(t0Var, R, D);
        }
    }

    private void f(t0 t0Var, int i10, int i11) {
        if (t0Var.G() == b0.NONE || t0Var.Y() == null) {
            for (int i12 = 0; i12 < t0Var.b(); i12++) {
                t0 a10 = t0Var.a(i12);
                int q10 = a10.q();
                if (!this.f3576c.get(q10)) {
                    this.f3576c.put(q10, true);
                    f(a10, a10.R() + i10, a10.D() + i11);
                }
            }
            return;
        }
        this.f3574a.P(t0Var.W().q(), t0Var.q(), i10, i11, t0Var.B(), t0Var.c());
    }

    public static void j(t0 t0Var) {
        t0Var.r();
    }

    private static boolean n(v0 v0Var) {
        if (v0Var == null) {
            return true;
        }
        if (v0Var.c("collapsable") && !v0Var.a("collapsable", true)) {
            return false;
        }
        ReadableMapKeySetIterator keySetIterator = v0Var.f3960a.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            if (!m2.a(v0Var.f3960a, keySetIterator.nextKey())) {
                return false;
            }
        }
        return true;
    }

    private void q(t0 t0Var, boolean z10) {
        if (t0Var.G() != b0.PARENT) {
            for (int b10 = t0Var.b() - 1; b10 >= 0; b10--) {
                q(t0Var.a(b10), z10);
            }
        }
        t0 Y = t0Var.Y();
        if (Y != null) {
            int w10 = Y.w(t0Var);
            Y.S(w10);
            this.f3574a.G(Y.q(), new int[]{w10}, (a2[]) null, z10 ? new int[]{t0Var.q()} : null);
        }
    }

    private void r(t0 t0Var, v0 v0Var) {
        boolean z10;
        t0 parent = t0Var.getParent();
        if (parent == null) {
            t0Var.Z(false);
            return;
        }
        int L = parent.L(t0Var);
        parent.e(L);
        q(t0Var, false);
        t0Var.Z(false);
        this.f3574a.C(t0Var.F(), t0Var.q(), t0Var.M(), v0Var);
        parent.I(t0Var, L);
        c(parent, t0Var, L);
        for (int i10 = 0; i10 < t0Var.b(); i10++) {
            c(t0Var, t0Var.a(i10), i10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Transitioning LayoutOnlyView - tag: ");
        sb2.append(t0Var.q());
        sb2.append(" - rootTag: ");
        sb2.append(t0Var.H());
        sb2.append(" - hasProps: ");
        boolean z11 = true;
        if (v0Var != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        sb2.append(z10);
        sb2.append(" - tagsWithLayout.size: ");
        sb2.append(this.f3576c.size());
        z2.a.p("NativeViewHierarchyOptimizer", sb2.toString());
        if (this.f3576c.size() != 0) {
            z11 = false;
        }
        p5.a.a(z11);
        e(t0Var);
        for (int i11 = 0; i11 < t0Var.b(); i11++) {
            e(t0Var.a(i11));
        }
        this.f3576c.clear();
    }

    private a s(t0 t0Var, int i10) {
        int i11;
        while (t0Var.G() != b0.PARENT) {
            t0 parent = t0Var.getParent();
            if (parent == null) {
                return null;
            }
            if (t0Var.G() == b0.LEAF) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            i10 = i10 + i11 + parent.u(t0Var);
            t0Var = parent;
        }
        return new a(t0Var, i10);
    }

    public void g(t0 t0Var, e1 e1Var, v0 v0Var) {
        boolean z10;
        if (!t0Var.M().equals(ReactViewManager.REACT_CLASS) || !n(v0Var)) {
            z10 = false;
        } else {
            z10 = true;
        }
        t0Var.Z(z10);
        if (t0Var.G() != b0.NONE) {
            this.f3574a.C(e1Var, t0Var.q(), t0Var.M(), v0Var);
        }
    }

    public void h(t0 t0Var) {
        if (t0Var.b0()) {
            r(t0Var, (v0) null);
        }
    }

    public void i(t0 t0Var, int[] iArr, int[] iArr2, a2[] a2VarArr, int[] iArr3) {
        boolean z10;
        for (int i10 : iArr2) {
            int i11 = 0;
            while (true) {
                if (i11 >= iArr3.length) {
                    z10 = false;
                    break;
                } else if (iArr3[i11] == i10) {
                    z10 = true;
                    break;
                } else {
                    i11++;
                }
            }
            q(this.f3575b.c(i10), z10);
        }
        for (a2 a2Var : a2VarArr) {
            c(t0Var, this.f3575b.c(a2Var.f3548a), a2Var.f3549b);
        }
    }

    public void k(t0 t0Var, ReadableArray readableArray) {
        for (int i10 = 0; i10 < readableArray.size(); i10++) {
            c(t0Var, this.f3575b.c(readableArray.getInt(i10)), i10);
        }
    }

    public void l(t0 t0Var) {
        e(t0Var);
    }

    public void m(t0 t0Var, String str, v0 v0Var) {
        if (t0Var.b0() && !n(v0Var)) {
            r(t0Var, v0Var);
        } else if (!t0Var.b0()) {
            this.f3574a.Q(t0Var.q(), str, v0Var);
        }
    }

    public void o() {
        this.f3576c.clear();
    }

    /* access modifiers changed from: package-private */
    public void p(t0 t0Var) {
        this.f3576c.clear();
    }
}
