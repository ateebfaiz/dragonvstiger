package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.g;
import jd.m;

public class h0 extends f.b {
    public h0(c cVar, d dVar, d dVar2) {
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
        g0 g0Var = (g0) this.f155b;
        g0 g0Var2 = (g0) this.f156c;
        g0 g0Var3 = (g0) fVar.l();
        g0 g0Var4 = (g0) fVar.m();
        g0 g0Var5 = (g0) this.f157d[0];
        g0 g0Var6 = (g0) fVar.n(0);
        int[] h10 = g.h();
        int[] f10 = g.f();
        int[] f11 = g.f();
        int[] f12 = g.f();
        boolean g11 = g0Var5.g();
        if (g11) {
            iArr2 = g0Var3.f266g;
            iArr = g0Var4.f266g;
        } else {
            f0.i(g0Var5.f266g, f11);
            f0.d(f11, g0Var3.f266g, f10);
            f0.d(f11, g0Var5.f266g, f11);
            f0.d(f11, g0Var4.f266g, f11);
            iArr2 = f10;
            iArr = f11;
        }
        boolean g12 = g0Var6.g();
        if (g12) {
            iArr4 = g0Var.f266g;
            iArr3 = g0Var2.f266g;
        } else {
            f0.i(g0Var6.f266g, f12);
            f0.d(f12, g0Var.f266g, h10);
            f0.d(f12, g0Var6.f266g, f12);
            f0.d(f12, g0Var2.f266g, f12);
            iArr4 = h10;
            iArr3 = f12;
        }
        int[] f13 = g.f();
        f0.k(iArr4, iArr2, f13);
        f0.k(iArr3, iArr, f10);
        if (!g.t(f13)) {
            f0.i(f13, f11);
            int[] f14 = g.f();
            f0.d(f11, f13, f14);
            f0.d(f11, iArr4, f11);
            f0.f(f14, f14);
            g.w(iArr3, f14, h10);
            f0.h(g.b(f11, f11, f14), f14);
            g0 g0Var7 = new g0(f12);
            f0.i(f10, g0Var7.f266g);
            int[] iArr5 = g0Var7.f266g;
            f0.k(iArr5, f14, iArr5);
            g0 g0Var8 = new g0(f14);
            f0.k(f11, g0Var7.f266g, g0Var8.f266g);
            f0.e(g0Var8.f266g, f10, h10);
            f0.g(h10, g0Var8.f266g);
            g0 g0Var9 = new g0(f13);
            if (!g11) {
                int[] iArr6 = g0Var9.f266g;
                f0.d(iArr6, g0Var5.f266g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = g0Var9.f266g;
                f0.d(iArr7, g0Var6.f266g, iArr7);
            }
            return new h0(g10, g0Var7, g0Var8, new d[]{g0Var9}, this.f158e);
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
        return new h0(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        g0 g0Var = (g0) this.f156c;
        if (g0Var.h()) {
            return g10.q();
        }
        g0 g0Var2 = (g0) this.f155b;
        g0 g0Var3 = (g0) this.f157d[0];
        int[] f10 = g.f();
        f0.i(g0Var.f266g, f10);
        int[] f11 = g.f();
        f0.i(f10, f11);
        int[] f12 = g.f();
        f0.i(g0Var2.f266g, f12);
        f0.h(g.b(f12, f12, f12), f12);
        f0.d(f10, g0Var2.f266g, f10);
        f0.h(m.F(8, f10, 2, 0), f10);
        int[] f13 = g.f();
        f0.h(m.G(8, f11, 3, 0, f13), f13);
        g0 g0Var4 = new g0(f11);
        f0.i(f12, g0Var4.f266g);
        int[] iArr = g0Var4.f266g;
        f0.k(iArr, f10, iArr);
        int[] iArr2 = g0Var4.f266g;
        f0.k(iArr2, f10, iArr2);
        g0 g0Var5 = new g0(f10);
        f0.k(f10, g0Var4.f266g, g0Var5.f266g);
        int[] iArr3 = g0Var5.f266g;
        f0.d(iArr3, f12, iArr3);
        int[] iArr4 = g0Var5.f266g;
        f0.k(iArr4, f13, iArr4);
        g0 g0Var6 = new g0(f12);
        f0.l(g0Var.f266g, g0Var6.f266g);
        if (!g0Var3.g()) {
            int[] iArr5 = g0Var6.f266g;
            f0.d(iArr5, g0Var3.f266g, iArr5);
        }
        return new h0(g10, g0Var4, g0Var5, new d[]{g0Var6}, this.f158e);
    }

    public h0(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    h0(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
