package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.m;

public class d0 extends f.b {
    public d0(c cVar, d dVar, d dVar2) {
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
        c0 c0Var = (c0) this.f155b;
        c0 c0Var2 = (c0) this.f156c;
        c0 c0Var3 = (c0) fVar.l();
        c0 c0Var4 = (c0) fVar.m();
        c0 c0Var5 = (c0) this.f157d[0];
        c0 c0Var6 = (c0) fVar.n(0);
        int[] e10 = jd.f.e();
        int[] d10 = jd.f.d();
        int[] d11 = jd.f.d();
        int[] d12 = jd.f.d();
        boolean g11 = c0Var5.g();
        if (g11) {
            iArr2 = c0Var3.f250g;
            iArr = c0Var4.f250g;
        } else {
            b0.j(c0Var5.f250g, d11);
            b0.e(d11, c0Var3.f250g, d10);
            b0.e(d11, c0Var5.f250g, d11);
            b0.e(d11, c0Var4.f250g, d11);
            iArr2 = d10;
            iArr = d11;
        }
        boolean g12 = c0Var6.g();
        if (g12) {
            iArr4 = c0Var.f250g;
            iArr3 = c0Var2.f250g;
        } else {
            b0.j(c0Var6.f250g, d12);
            b0.e(d12, c0Var.f250g, e10);
            b0.e(d12, c0Var6.f250g, d12);
            b0.e(d12, c0Var2.f250g, d12);
            iArr4 = e10;
            iArr3 = d12;
        }
        int[] d13 = jd.f.d();
        b0.m(iArr4, iArr2, d13);
        b0.m(iArr3, iArr, d10);
        if (!jd.f.k(d13)) {
            b0.j(d13, d11);
            int[] d14 = jd.f.d();
            b0.e(d11, d13, d14);
            b0.e(d11, iArr4, d11);
            b0.g(d14, d14);
            jd.f.l(iArr3, d14, e10);
            b0.i(jd.f.b(d11, d11, d14), d14);
            c0 c0Var7 = new c0(d12);
            b0.j(d10, c0Var7.f250g);
            int[] iArr5 = c0Var7.f250g;
            b0.m(iArr5, d14, iArr5);
            c0 c0Var8 = new c0(d14);
            b0.m(d11, c0Var7.f250g, c0Var8.f250g);
            b0.f(c0Var8.f250g, d10, e10);
            b0.h(e10, c0Var8.f250g);
            c0 c0Var9 = new c0(d13);
            if (!g11) {
                int[] iArr6 = c0Var9.f250g;
                b0.e(iArr6, c0Var5.f250g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = c0Var9.f250g;
                b0.e(iArr7, c0Var6.f250g, iArr7);
            }
            return new d0(g10, c0Var7, c0Var8, new d[]{c0Var9}, this.f158e);
        } else if (jd.f.k(d10)) {
            return w();
        } else {
            return g10.q();
        }
    }

    public f r() {
        if (o()) {
            return this;
        }
        return new d0(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        c0 c0Var = (c0) this.f156c;
        if (c0Var.h()) {
            return g10.q();
        }
        c0 c0Var2 = (c0) this.f155b;
        c0 c0Var3 = (c0) this.f157d[0];
        int[] d10 = jd.f.d();
        int[] d11 = jd.f.d();
        int[] d12 = jd.f.d();
        b0.j(c0Var.f250g, d12);
        int[] d13 = jd.f.d();
        b0.j(d12, d13);
        boolean g11 = c0Var3.g();
        int[] iArr = c0Var3.f250g;
        if (!g11) {
            b0.j(iArr, d11);
            iArr = d11;
        }
        b0.m(c0Var2.f250g, iArr, d10);
        b0.a(c0Var2.f250g, iArr, d11);
        b0.e(d11, d10, d11);
        b0.i(jd.f.b(d11, d11, d11), d11);
        b0.e(d12, c0Var2.f250g, d12);
        b0.i(m.F(7, d12, 2, 0), d12);
        b0.i(m.G(7, d13, 3, 0, d10), d10);
        c0 c0Var4 = new c0(d13);
        b0.j(d11, c0Var4.f250g);
        int[] iArr2 = c0Var4.f250g;
        b0.m(iArr2, d12, iArr2);
        int[] iArr3 = c0Var4.f250g;
        b0.m(iArr3, d12, iArr3);
        c0 c0Var5 = new c0(d12);
        b0.m(d12, c0Var4.f250g, c0Var5.f250g);
        int[] iArr4 = c0Var5.f250g;
        b0.e(iArr4, d11, iArr4);
        int[] iArr5 = c0Var5.f250g;
        b0.m(iArr5, d10, iArr5);
        c0 c0Var6 = new c0(d11);
        b0.n(c0Var.f250g, c0Var6.f250g);
        if (!g11) {
            int[] iArr6 = c0Var6.f250g;
            b0.e(iArr6, c0Var3.f250g, iArr6);
        }
        return new d0(g10, c0Var4, c0Var5, new d[]{c0Var6}, this.f158e);
    }

    public d0(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    d0(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
