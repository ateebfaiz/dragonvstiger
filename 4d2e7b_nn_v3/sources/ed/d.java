package ed;

import dd.c;
import dd.f;
import jd.g;

public class d extends f.b {
    public d(c cVar, dd.d dVar, dd.d dVar2) {
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
        c cVar = (c) this.f155b;
        c cVar2 = (c) this.f156c;
        c cVar3 = (c) this.f157d[0];
        c cVar4 = (c) fVar.l();
        c cVar5 = (c) fVar.m();
        c cVar6 = (c) fVar.n(0);
        int[] h10 = g.h();
        int[] f10 = g.f();
        int[] f11 = g.f();
        int[] f12 = g.f();
        boolean g11 = cVar3.g();
        if (g11) {
            iArr2 = cVar4.f226g;
            iArr = cVar5.f226g;
        } else {
            b.j(cVar3.f226g, f11);
            b.e(f11, cVar4.f226g, f10);
            b.e(f11, cVar3.f226g, f11);
            b.e(f11, cVar5.f226g, f11);
            iArr2 = f10;
            iArr = f11;
        }
        boolean g12 = cVar6.g();
        if (g12) {
            iArr4 = cVar.f226g;
            iArr3 = cVar2.f226g;
        } else {
            b.j(cVar6.f226g, f12);
            b.e(f12, cVar.f226g, h10);
            b.e(f12, cVar6.f226g, f12);
            b.e(f12, cVar2.f226g, f12);
            iArr4 = h10;
            iArr3 = f12;
        }
        int[] f13 = g.f();
        b.n(iArr4, iArr2, f13);
        b.n(iArr3, iArr, f10);
        if (!g.t(f13)) {
            int[] f14 = g.f();
            b.j(f13, f14);
            int[] f15 = g.f();
            b.e(f14, f13, f15);
            b.e(f14, iArr4, f11);
            b.g(f15, f15);
            g.w(iArr3, f15, h10);
            b.i(g.b(f11, f11, f15), f15);
            c cVar7 = new c(f12);
            b.j(f10, cVar7.f226g);
            int[] iArr5 = cVar7.f226g;
            b.n(iArr5, f15, iArr5);
            c cVar8 = new c(f15);
            b.n(f11, cVar7.f226g, cVar8.f226g);
            b.f(cVar8.f226g, f10, h10);
            b.h(h10, cVar8.f226g);
            c cVar9 = new c(f13);
            if (!g11) {
                int[] iArr6 = cVar9.f226g;
                b.e(iArr6, cVar3.f226g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = cVar9.f226g;
                b.e(iArr7, cVar6.f226g, iArr7);
            }
            if (!g11 || !g12) {
                f14 = null;
            }
            return new d(g10, cVar7, cVar8, new dd.d[]{cVar9, x(cVar9, f14)}, this.f158e);
        } else if (g.t(f10)) {
            return w();
        } else {
            return g10.q();
        }
    }

    public dd.d n(int i10) {
        if (i10 == 1) {
            return y();
        }
        return super.n(i10);
    }

    public f r() {
        if (o()) {
            return this;
        }
        return new d(g(), this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        if (this.f156c.h()) {
            return g10.q();
        }
        return z(true);
    }

    /* access modifiers changed from: protected */
    public c x(c cVar, int[] iArr) {
        c cVar2 = (c) g().k();
        if (cVar.g()) {
            return cVar2;
        }
        c cVar3 = new c();
        if (iArr == null) {
            iArr = cVar3.f226g;
            b.j(cVar.f226g, iArr);
        }
        b.j(iArr, cVar3.f226g);
        int[] iArr2 = cVar3.f226g;
        b.e(iArr2, cVar2.f226g, iArr2);
        return cVar3;
    }

    /* access modifiers changed from: protected */
    public c y() {
        dd.d[] dVarArr = this.f157d;
        c cVar = (c) dVarArr[1];
        if (cVar != null) {
            return cVar;
        }
        c x10 = x((c) dVarArr[0], (int[]) null);
        dVarArr[1] = x10;
        return x10;
    }

    /* access modifiers changed from: protected */
    public d z(boolean z10) {
        c cVar;
        c cVar2 = (c) this.f155b;
        c cVar3 = (c) this.f156c;
        c cVar4 = (c) this.f157d[0];
        c y10 = y();
        int[] f10 = g.f();
        b.j(cVar2.f226g, f10);
        b.i(g.b(f10, f10, f10) + g.d(y10.f226g, f10), f10);
        int[] f11 = g.f();
        b.o(cVar3.f226g, f11);
        int[] f12 = g.f();
        b.e(f11, cVar3.f226g, f12);
        int[] f13 = g.f();
        b.e(f12, cVar2.f226g, f13);
        b.o(f13, f13);
        int[] f14 = g.f();
        b.j(f12, f14);
        b.o(f14, f14);
        c cVar5 = new c(f12);
        b.j(f10, cVar5.f226g);
        int[] iArr = cVar5.f226g;
        b.n(iArr, f13, iArr);
        int[] iArr2 = cVar5.f226g;
        b.n(iArr2, f13, iArr2);
        c cVar6 = new c(f13);
        b.n(f13, cVar5.f226g, cVar6.f226g);
        int[] iArr3 = cVar6.f226g;
        b.e(iArr3, f10, iArr3);
        int[] iArr4 = cVar6.f226g;
        b.n(iArr4, f14, iArr4);
        c cVar7 = new c(f11);
        if (!g.r(cVar4.f226g)) {
            int[] iArr5 = cVar7.f226g;
            b.e(iArr5, cVar4.f226g, iArr5);
        }
        if (z10) {
            cVar = new c(f14);
            int[] iArr6 = cVar.f226g;
            b.e(iArr6, y10.f226g, iArr6);
            int[] iArr7 = cVar.f226g;
            b.o(iArr7, iArr7);
        } else {
            cVar = null;
        }
        return new d(g(), cVar5, cVar6, new dd.d[]{cVar7, cVar}, this.f158e);
    }

    public d(c cVar, dd.d dVar, dd.d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    d(c cVar, dd.d dVar, dd.d dVar2, dd.d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
