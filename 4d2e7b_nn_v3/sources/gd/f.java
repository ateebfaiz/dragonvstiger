package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.m;

public class f extends f.b {
    public f(c cVar, d dVar, d dVar2) {
        this(cVar, dVar, dVar2, false);
    }

    public dd.f a(dd.f fVar) {
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
        m mVar = (m) this.f155b;
        m mVar2 = (m) this.f156c;
        m mVar3 = (m) fVar.l();
        m mVar4 = (m) fVar.m();
        m mVar5 = (m) this.f157d[0];
        m mVar6 = (m) fVar.n(0);
        int[] d10 = jd.d.d();
        int[] c10 = jd.d.c();
        int[] c11 = jd.d.c();
        int[] c12 = jd.d.c();
        boolean g11 = mVar5.g();
        if (g11) {
            iArr2 = mVar3.f291g;
            iArr = mVar4.f291g;
        } else {
            l.i(mVar5.f291g, c11);
            l.d(c11, mVar3.f291g, c10);
            l.d(c11, mVar5.f291g, c11);
            l.d(c11, mVar4.f291g, c11);
            iArr2 = c10;
            iArr = c11;
        }
        boolean g12 = mVar6.g();
        if (g12) {
            iArr4 = mVar.f291g;
            iArr3 = mVar2.f291g;
        } else {
            l.i(mVar6.f291g, c12);
            l.d(c12, mVar.f291g, d10);
            l.d(c12, mVar6.f291g, c12);
            l.d(c12, mVar2.f291g, c12);
            iArr4 = d10;
            iArr3 = c12;
        }
        int[] c13 = jd.d.c();
        l.k(iArr4, iArr2, c13);
        l.k(iArr3, iArr, c10);
        if (!jd.d.j(c13)) {
            l.i(c13, c11);
            int[] c14 = jd.d.c();
            l.d(c11, c13, c14);
            l.d(c11, iArr4, c11);
            l.f(c14, c14);
            jd.d.k(iArr3, c14, d10);
            l.h(jd.d.b(c11, c11, c14), c14);
            m mVar7 = new m(c12);
            l.i(c10, mVar7.f291g);
            int[] iArr5 = mVar7.f291g;
            l.k(iArr5, c14, iArr5);
            m mVar8 = new m(c14);
            l.k(c11, mVar7.f291g, mVar8.f291g);
            l.e(mVar8.f291g, c10, d10);
            l.g(d10, mVar8.f291g);
            m mVar9 = new m(c13);
            if (!g11) {
                int[] iArr6 = mVar9.f291g;
                l.d(iArr6, mVar5.f291g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = mVar9.f291g;
                l.d(iArr7, mVar6.f291g, iArr7);
            }
            return new f(g10, mVar7, mVar8, new d[]{mVar9}, this.f158e);
        } else if (jd.d.j(c10)) {
            return w();
        } else {
            return g10.q();
        }
    }

    public dd.f r() {
        if (o()) {
            return this;
        }
        return new f(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public dd.f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        m mVar = (m) this.f156c;
        if (mVar.h()) {
            return g10.q();
        }
        m mVar2 = (m) this.f155b;
        m mVar3 = (m) this.f157d[0];
        int[] c10 = jd.d.c();
        l.i(mVar.f291g, c10);
        int[] c11 = jd.d.c();
        l.i(c10, c11);
        int[] c12 = jd.d.c();
        l.i(mVar2.f291g, c12);
        l.h(jd.d.b(c12, c12, c12), c12);
        l.d(c10, mVar2.f291g, c10);
        l.h(m.F(5, c10, 2, 0), c10);
        int[] c13 = jd.d.c();
        l.h(m.G(5, c11, 3, 0, c13), c13);
        m mVar4 = new m(c11);
        l.i(c12, mVar4.f291g);
        int[] iArr = mVar4.f291g;
        l.k(iArr, c10, iArr);
        int[] iArr2 = mVar4.f291g;
        l.k(iArr2, c10, iArr2);
        m mVar5 = new m(c10);
        l.k(c10, mVar4.f291g, mVar5.f291g);
        int[] iArr3 = mVar5.f291g;
        l.d(iArr3, c12, iArr3);
        int[] iArr4 = mVar5.f291g;
        l.k(iArr4, c13, iArr4);
        m mVar6 = new m(c12);
        l.l(mVar.f291g, mVar6.f291g);
        if (!mVar3.g()) {
            int[] iArr5 = mVar6.f291g;
            l.d(iArr5, mVar3.f291g, iArr5);
        }
        return new f(g10, mVar4, mVar5, new d[]{mVar6}, this.f158e);
    }

    public f(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    f(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
