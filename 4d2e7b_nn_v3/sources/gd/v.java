package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.e;
import jd.m;

public class v extends f.b {
    public v(c cVar, d dVar, d dVar2) {
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
        u uVar = (u) this.f155b;
        u uVar2 = (u) this.f156c;
        u uVar3 = (u) fVar.l();
        u uVar4 = (u) fVar.m();
        u uVar5 = (u) this.f157d[0];
        u uVar6 = (u) fVar.n(0);
        int[] g11 = e.g();
        int[] e10 = e.e();
        int[] e11 = e.e();
        int[] e12 = e.e();
        boolean g12 = uVar5.g();
        if (g12) {
            iArr2 = uVar3.f326g;
            iArr = uVar4.f326g;
        } else {
            t.j(uVar5.f326g, e11);
            t.e(e11, uVar3.f326g, e10);
            t.e(e11, uVar5.f326g, e11);
            t.e(e11, uVar4.f326g, e11);
            iArr2 = e10;
            iArr = e11;
        }
        boolean g13 = uVar6.g();
        if (g13) {
            iArr4 = uVar.f326g;
            iArr3 = uVar2.f326g;
        } else {
            t.j(uVar6.f326g, e12);
            t.e(e12, uVar.f326g, g11);
            t.e(e12, uVar6.f326g, e12);
            t.e(e12, uVar2.f326g, e12);
            iArr4 = g11;
            iArr3 = e12;
        }
        int[] e13 = e.e();
        t.m(iArr4, iArr2, e13);
        t.m(iArr3, iArr, e10);
        if (!e.s(e13)) {
            t.j(e13, e11);
            int[] e14 = e.e();
            t.e(e11, e13, e14);
            t.e(e11, iArr4, e11);
            t.g(e14, e14);
            e.v(iArr3, e14, g11);
            t.i(e.b(e11, e11, e14), e14);
            u uVar7 = new u(e12);
            t.j(e10, uVar7.f326g);
            int[] iArr5 = uVar7.f326g;
            t.m(iArr5, e14, iArr5);
            u uVar8 = new u(e14);
            t.m(e11, uVar7.f326g, uVar8.f326g);
            t.f(uVar8.f326g, e10, g11);
            t.h(g11, uVar8.f326g);
            u uVar9 = new u(e13);
            if (!g12) {
                int[] iArr6 = uVar9.f326g;
                t.e(iArr6, uVar5.f326g, iArr6);
            }
            if (!g13) {
                int[] iArr7 = uVar9.f326g;
                t.e(iArr7, uVar6.f326g, iArr7);
            }
            return new v(g10, uVar7, uVar8, new d[]{uVar9}, this.f158e);
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
        return new v(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        u uVar = (u) this.f156c;
        if (uVar.h()) {
            return g10.q();
        }
        u uVar2 = (u) this.f155b;
        u uVar3 = (u) this.f157d[0];
        int[] e10 = e.e();
        int[] e11 = e.e();
        int[] e12 = e.e();
        t.j(uVar.f326g, e12);
        int[] e13 = e.e();
        t.j(e12, e13);
        boolean g11 = uVar3.g();
        int[] iArr = uVar3.f326g;
        if (!g11) {
            t.j(iArr, e11);
            iArr = e11;
        }
        t.m(uVar2.f326g, iArr, e10);
        t.a(uVar2.f326g, iArr, e11);
        t.e(e11, e10, e11);
        t.i(e.b(e11, e11, e11), e11);
        t.e(e12, uVar2.f326g, e12);
        t.i(m.F(6, e12, 2, 0), e12);
        t.i(m.G(6, e13, 3, 0, e10), e10);
        u uVar4 = new u(e13);
        t.j(e11, uVar4.f326g);
        int[] iArr2 = uVar4.f326g;
        t.m(iArr2, e12, iArr2);
        int[] iArr3 = uVar4.f326g;
        t.m(iArr3, e12, iArr3);
        u uVar5 = new u(e12);
        t.m(e12, uVar4.f326g, uVar5.f326g);
        int[] iArr4 = uVar5.f326g;
        t.e(iArr4, e11, iArr4);
        int[] iArr5 = uVar5.f326g;
        t.m(iArr5, e10, iArr5);
        u uVar6 = new u(e11);
        t.n(uVar.f326g, uVar6.f326g);
        if (!g11) {
            int[] iArr6 = uVar6.f326g;
            t.e(iArr6, uVar3.f326g, iArr6);
        }
        return new v(g10, uVar4, uVar5, new d[]{uVar6}, this.f158e);
    }

    public v(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    v(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
