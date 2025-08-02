package gd;

import dd.c;
import dd.f;
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
        int[] e10 = jd.c.e();
        int[] c10 = jd.c.c();
        int[] c11 = jd.c.c();
        int[] c12 = jd.c.c();
        boolean g11 = cVar5.g();
        if (g11) {
            iArr2 = cVar3.f248g;
            iArr = cVar4.f248g;
        } else {
            b.j(cVar5.f248g, c11);
            b.e(c11, cVar3.f248g, c10);
            b.e(c11, cVar5.f248g, c11);
            b.e(c11, cVar4.f248g, c11);
            iArr2 = c10;
            iArr = c11;
        }
        boolean g12 = cVar6.g();
        if (g12) {
            iArr4 = cVar.f248g;
            iArr3 = cVar2.f248g;
        } else {
            b.j(cVar6.f248g, c12);
            b.e(c12, cVar.f248g, e10);
            b.e(c12, cVar6.f248g, c12);
            b.e(c12, cVar2.f248g, c12);
            iArr4 = e10;
            iArr3 = c12;
        }
        int[] c13 = jd.c.c();
        b.m(iArr4, iArr2, c13);
        b.m(iArr3, iArr, c10);
        if (!jd.c.o(c13)) {
            b.j(c13, c11);
            int[] c14 = jd.c.c();
            b.e(c11, c13, c14);
            b.e(c11, iArr4, c11);
            b.g(c14, c14);
            jd.c.q(iArr3, c14, e10);
            b.i(jd.c.b(c11, c11, c14), c14);
            c cVar7 = new c(c12);
            b.j(c10, cVar7.f248g);
            int[] iArr5 = cVar7.f248g;
            b.m(iArr5, c14, iArr5);
            c cVar8 = new c(c14);
            b.m(c11, cVar7.f248g, cVar8.f248g);
            b.f(cVar8.f248g, c10, e10);
            b.h(e10, cVar8.f248g);
            c cVar9 = new c(c13);
            if (!g11) {
                int[] iArr6 = cVar9.f248g;
                b.e(iArr6, cVar5.f248g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = cVar9.f248g;
                b.e(iArr7, cVar6.f248g, iArr7);
            }
            return new d(g10, cVar7, cVar8, new dd.d[]{cVar9}, this.f158e);
        } else if (jd.c.o(c10)) {
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
        int[] c10 = jd.c.c();
        int[] c11 = jd.c.c();
        int[] c12 = jd.c.c();
        b.j(cVar.f248g, c12);
        int[] c13 = jd.c.c();
        b.j(c12, c13);
        boolean g11 = cVar3.g();
        int[] iArr = cVar3.f248g;
        if (!g11) {
            b.j(iArr, c11);
            iArr = c11;
        }
        b.m(cVar2.f248g, iArr, c10);
        b.a(cVar2.f248g, iArr, c11);
        b.e(c11, c10, c11);
        b.i(jd.c.b(c11, c11, c11), c11);
        b.e(c12, cVar2.f248g, c12);
        b.i(m.F(4, c12, 2, 0), c12);
        b.i(m.G(4, c13, 3, 0, c10), c10);
        c cVar4 = new c(c13);
        b.j(c11, cVar4.f248g);
        int[] iArr2 = cVar4.f248g;
        b.m(iArr2, c12, iArr2);
        int[] iArr3 = cVar4.f248g;
        b.m(iArr3, c12, iArr3);
        c cVar5 = new c(c12);
        b.m(c12, cVar4.f248g, cVar5.f248g);
        int[] iArr4 = cVar5.f248g;
        b.e(iArr4, c11, iArr4);
        int[] iArr5 = cVar5.f248g;
        b.m(iArr5, c10, iArr5);
        c cVar6 = new c(c11);
        b.n(cVar.f248g, cVar6.f248g);
        if (!g11) {
            int[] iArr6 = cVar6.f248g;
            b.e(iArr6, cVar3.f248g, iArr6);
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
