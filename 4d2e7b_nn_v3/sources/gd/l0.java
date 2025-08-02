package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.g;
import jd.m;

public class l0 extends f.b {
    public l0(c cVar, d dVar, d dVar2) {
        this(cVar, dVar, dVar2, false);
    }

    public f a(f fVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (o()) {
            return fVar;
        }
        if (fVar.o()) {
            return this;
        }
        if (this == fVar) {
            return w();
        }
        c g10 = g();
        k0 k0Var = (k0) this.f155b;
        k0 k0Var2 = (k0) this.f156c;
        k0 k0Var3 = (k0) fVar.l();
        k0 k0Var4 = (k0) fVar.m();
        k0 k0Var5 = (k0) this.f157d[0];
        k0 k0Var6 = (k0) fVar.n(0);
        int[] h10 = g.h();
        int[] f10 = g.f();
        int[] f11 = g.f();
        int[] f12 = g.f();
        boolean g11 = k0Var5.g();
        if (g11) {
            iArr2 = k0Var3.f284g;
            iArr = k0Var4.f284g;
        } else {
            j0.j(k0Var5.f284g, f11);
            j0.e(f11, k0Var3.f284g, f10);
            j0.e(f11, k0Var5.f284g, f11);
            j0.e(f11, k0Var4.f284g, f11);
            iArr2 = f10;
            iArr = f11;
        }
        boolean g12 = k0Var6.g();
        if (g12) {
            iArr4 = k0Var.f284g;
            iArr3 = k0Var2.f284g;
        } else {
            j0.j(k0Var6.f284g, f12);
            j0.e(f12, k0Var.f284g, h10);
            j0.e(f12, k0Var6.f284g, f12);
            j0.e(f12, k0Var2.f284g, f12);
            iArr4 = h10;
            iArr3 = f12;
        }
        int[] f13 = g.f();
        j0.m(iArr4, iArr2, f13);
        j0.m(iArr3, iArr, f10);
        if (!g.t(f13)) {
            j0.j(f13, f11);
            int[] f14 = g.f();
            j0.e(f11, f13, f14);
            j0.e(f11, iArr4, f11);
            j0.g(f14, f14);
            g.w(iArr3, f14, h10);
            j0.i(g.b(f11, f11, f14), f14);
            k0 k0Var7 = new k0(f12);
            j0.j(f10, k0Var7.f284g);
            int[] iArr5 = k0Var7.f284g;
            j0.m(iArr5, f14, iArr5);
            k0 k0Var8 = new k0(f14);
            j0.m(f11, k0Var7.f284g, k0Var8.f284g);
            j0.f(k0Var8.f284g, f10, h10);
            j0.h(h10, k0Var8.f284g);
            k0 k0Var9 = new k0(f13);
            if (!g11) {
                int[] iArr6 = k0Var9.f284g;
                j0.e(iArr6, k0Var5.f284g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = k0Var9.f284g;
                j0.e(iArr7, k0Var6.f284g, iArr7);
            }
            return new l0(g10, k0Var7, k0Var8, new d[]{k0Var9}, this.f158e);
        } else if (g.t(f10)) {
            return w();
        } else {
            return g10.q();
        }
    }

    public f r() {
        if (o()) {
            return this;
        }
        return new l0(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        k0 k0Var = (k0) this.f156c;
        if (k0Var.h()) {
            return g10.q();
        }
        k0 k0Var2 = (k0) this.f155b;
        k0 k0Var3 = (k0) this.f157d[0];
        int[] f10 = g.f();
        int[] f11 = g.f();
        int[] f12 = g.f();
        j0.j(k0Var.f284g, f12);
        int[] f13 = g.f();
        j0.j(f12, f13);
        boolean g11 = k0Var3.g();
        int[] iArr = k0Var3.f284g;
        if (!g11) {
            j0.j(iArr, f11);
            iArr = f11;
        }
        j0.m(k0Var2.f284g, iArr, f10);
        j0.a(k0Var2.f284g, iArr, f11);
        j0.e(f11, f10, f11);
        j0.i(g.b(f11, f11, f11), f11);
        j0.e(f12, k0Var2.f284g, f12);
        j0.i(m.F(8, f12, 2, 0), f12);
        j0.i(m.G(8, f13, 3, 0, f10), f10);
        k0 k0Var4 = new k0(f13);
        j0.j(f11, k0Var4.f284g);
        int[] iArr2 = k0Var4.f284g;
        j0.m(iArr2, f12, iArr2);
        int[] iArr3 = k0Var4.f284g;
        j0.m(iArr3, f12, iArr3);
        k0 k0Var5 = new k0(f12);
        j0.m(f12, k0Var4.f284g, k0Var5.f284g);
        int[] iArr4 = k0Var5.f284g;
        j0.e(iArr4, f11, iArr4);
        int[] iArr5 = k0Var5.f284g;
        j0.m(iArr5, f10, iArr5);
        k0 k0Var6 = new k0(f11);
        j0.n(k0Var.f284g, k0Var6.f284g);
        if (!g11) {
            int[] iArr6 = k0Var6.f284g;
            j0.e(iArr6, k0Var3.f284g, iArr6);
        }
        return new l0(g10, k0Var4, k0Var5, new d[]{k0Var6}, this.f158e);
    }

    public l0(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    l0(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
