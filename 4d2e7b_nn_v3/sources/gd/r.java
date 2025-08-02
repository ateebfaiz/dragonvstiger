package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.e;
import jd.m;

public class r extends f.b {
    public r(c cVar, d dVar, d dVar2) {
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
        q qVar = (q) this.f155b;
        q qVar2 = (q) this.f156c;
        q qVar3 = (q) fVar.l();
        q qVar4 = (q) fVar.m();
        q qVar5 = (q) this.f157d[0];
        q qVar6 = (q) fVar.n(0);
        int[] g11 = e.g();
        int[] e10 = e.e();
        int[] e11 = e.e();
        int[] e12 = e.e();
        boolean g12 = qVar5.g();
        if (g12) {
            iArr2 = qVar3.f309g;
            iArr = qVar4.f309g;
        } else {
            p.i(qVar5.f309g, e11);
            p.d(e11, qVar3.f309g, e10);
            p.d(e11, qVar5.f309g, e11);
            p.d(e11, qVar4.f309g, e11);
            iArr2 = e10;
            iArr = e11;
        }
        boolean g13 = qVar6.g();
        if (g13) {
            iArr4 = qVar.f309g;
            iArr3 = qVar2.f309g;
        } else {
            p.i(qVar6.f309g, e12);
            p.d(e12, qVar.f309g, g11);
            p.d(e12, qVar6.f309g, e12);
            p.d(e12, qVar2.f309g, e12);
            iArr4 = g11;
            iArr3 = e12;
        }
        int[] e13 = e.e();
        p.k(iArr4, iArr2, e13);
        p.k(iArr3, iArr, e10);
        if (!e.s(e13)) {
            p.i(e13, e11);
            int[] e14 = e.e();
            p.d(e11, e13, e14);
            p.d(e11, iArr4, e11);
            p.f(e14, e14);
            e.v(iArr3, e14, g11);
            p.h(e.b(e11, e11, e14), e14);
            q qVar7 = new q(e12);
            p.i(e10, qVar7.f309g);
            int[] iArr5 = qVar7.f309g;
            p.k(iArr5, e14, iArr5);
            q qVar8 = new q(e14);
            p.k(e11, qVar7.f309g, qVar8.f309g);
            p.e(qVar8.f309g, e10, g11);
            p.g(g11, qVar8.f309g);
            q qVar9 = new q(e13);
            if (!g12) {
                int[] iArr6 = qVar9.f309g;
                p.d(iArr6, qVar5.f309g, iArr6);
            }
            if (!g13) {
                int[] iArr7 = qVar9.f309g;
                p.d(iArr7, qVar6.f309g, iArr7);
            }
            return new r(g10, qVar7, qVar8, new d[]{qVar9}, this.f158e);
        } else if (e.s(e10)) {
            return w();
        } else {
            return g10.q();
        }
    }

    public f r() {
        if (o()) {
            return this;
        }
        return new r(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        q qVar = (q) this.f156c;
        if (qVar.h()) {
            return g10.q();
        }
        q qVar2 = (q) this.f155b;
        q qVar3 = (q) this.f157d[0];
        int[] e10 = e.e();
        p.i(qVar.f309g, e10);
        int[] e11 = e.e();
        p.i(e10, e11);
        int[] e12 = e.e();
        p.i(qVar2.f309g, e12);
        p.h(e.b(e12, e12, e12), e12);
        p.d(e10, qVar2.f309g, e10);
        p.h(m.F(6, e10, 2, 0), e10);
        int[] e13 = e.e();
        p.h(m.G(6, e11, 3, 0, e13), e13);
        q qVar4 = new q(e11);
        p.i(e12, qVar4.f309g);
        int[] iArr = qVar4.f309g;
        p.k(iArr, e10, iArr);
        int[] iArr2 = qVar4.f309g;
        p.k(iArr2, e10, iArr2);
        q qVar5 = new q(e10);
        p.k(e10, qVar4.f309g, qVar5.f309g);
        int[] iArr3 = qVar5.f309g;
        p.d(iArr3, e12, iArr3);
        int[] iArr4 = qVar5.f309g;
        p.k(iArr4, e13, iArr4);
        q qVar6 = new q(e12);
        p.l(qVar.f309g, qVar6.f309g);
        if (!qVar3.g()) {
            int[] iArr5 = qVar6.f309g;
            p.d(iArr5, qVar3.f309g, iArr5);
        }
        return new r(g10, qVar4, qVar5, new d[]{qVar6}, this.f158e);
    }

    public r(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    r(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
