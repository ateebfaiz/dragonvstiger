package fd;

import dd.c;
import dd.f;
import jd.g;
import jd.m;

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
        c cVar3 = (c) fVar.l();
        c cVar4 = (c) fVar.m();
        c cVar5 = (c) this.f157d[0];
        c cVar6 = (c) fVar.n(0);
        int[] h10 = g.h();
        int[] f10 = g.f();
        int[] f11 = g.f();
        int[] f12 = g.f();
        boolean g11 = cVar5.g();
        if (g11) {
            iArr2 = cVar3.f232g;
            iArr = cVar4.f232g;
        } else {
            b.j(cVar5.f232g, f11);
            b.e(f11, cVar3.f232g, f10);
            b.e(f11, cVar5.f232g, f11);
            b.e(f11, cVar4.f232g, f11);
            iArr2 = f10;
            iArr = f11;
        }
        boolean g12 = cVar6.g();
        if (g12) {
            iArr4 = cVar.f232g;
            iArr3 = cVar2.f232g;
        } else {
            b.j(cVar6.f232g, f12);
            b.e(f12, cVar.f232g, h10);
            b.e(f12, cVar6.f232g, f12);
            b.e(f12, cVar2.f232g, f12);
            iArr4 = h10;
            iArr3 = f12;
        }
        int[] f13 = g.f();
        b.m(iArr4, iArr2, f13);
        b.m(iArr3, iArr, f10);
        if (!g.t(f13)) {
            b.j(f13, f11);
            int[] f14 = g.f();
            b.e(f11, f13, f14);
            b.e(f11, iArr4, f11);
            b.g(f14, f14);
            g.w(iArr3, f14, h10);
            b.i(g.b(f11, f11, f14), f14);
            c cVar7 = new c(f12);
            b.j(f10, cVar7.f232g);
            int[] iArr5 = cVar7.f232g;
            b.m(iArr5, f14, iArr5);
            c cVar8 = new c(f14);
            b.m(f11, cVar7.f232g, cVar8.f232g);
            b.f(cVar8.f232g, f10, h10);
            b.h(h10, cVar8.f232g);
            c cVar9 = new c(f13);
            if (!g11) {
                int[] iArr6 = cVar9.f232g;
                b.e(iArr6, cVar5.f232g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = cVar9.f232g;
                b.e(iArr7, cVar6.f232g, iArr7);
            }
            return new d(g10, cVar7, cVar8, new dd.d[]{cVar9}, this.f158e);
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
        return new d(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        c cVar = (c) this.f156c;
        if (cVar.h()) {
            return g10.q();
        }
        c cVar2 = (c) this.f155b;
        c cVar3 = (c) this.f157d[0];
        int[] f10 = g.f();
        int[] f11 = g.f();
        int[] f12 = g.f();
        b.j(cVar.f232g, f12);
        int[] f13 = g.f();
        b.j(f12, f13);
        boolean g11 = cVar3.g();
        int[] iArr = cVar3.f232g;
        if (!g11) {
            b.j(iArr, f11);
            iArr = f11;
        }
        b.m(cVar2.f232g, iArr, f10);
        b.a(cVar2.f232g, iArr, f11);
        b.e(f11, f10, f11);
        b.i(g.b(f11, f11, f11), f11);
        b.e(f12, cVar2.f232g, f12);
        b.i(m.F(8, f12, 2, 0), f12);
        b.i(m.G(8, f13, 3, 0, f10), f10);
        c cVar4 = new c(f13);
        b.j(f11, cVar4.f232g);
        int[] iArr2 = cVar4.f232g;
        b.m(iArr2, f12, iArr2);
        int[] iArr3 = cVar4.f232g;
        b.m(iArr3, f12, iArr3);
        c cVar5 = new c(f12);
        b.m(f12, cVar4.f232g, cVar5.f232g);
        int[] iArr4 = cVar5.f232g;
        b.e(iArr4, f11, iArr4);
        int[] iArr5 = cVar5.f232g;
        b.m(iArr5, f10, iArr5);
        c cVar6 = new c(f11);
        b.n(cVar.f232g, cVar6.f232g);
        if (!g11) {
            int[] iArr6 = cVar6.f232g;
            b.e(iArr6, cVar3.f232g, iArr6);
        }
        return new d(g10, cVar4, cVar5, new dd.d[]{cVar6}, this.f158e);
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
