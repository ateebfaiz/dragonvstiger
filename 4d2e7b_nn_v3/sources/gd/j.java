package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.m;

public class j extends f.b {
    public j(c cVar, d dVar, d dVar2) {
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
        i iVar = (i) this.f155b;
        i iVar2 = (i) this.f156c;
        i iVar3 = (i) fVar.l();
        i iVar4 = (i) fVar.m();
        i iVar5 = (i) this.f157d[0];
        i iVar6 = (i) fVar.n(0);
        int[] d10 = jd.d.d();
        int[] c10 = jd.d.c();
        int[] c11 = jd.d.c();
        int[] c12 = jd.d.c();
        boolean g11 = iVar5.g();
        if (g11) {
            iArr2 = iVar3.f274g;
            iArr = iVar4.f274g;
        } else {
            h.i(iVar5.f274g, c11);
            h.d(c11, iVar3.f274g, c10);
            h.d(c11, iVar5.f274g, c11);
            h.d(c11, iVar4.f274g, c11);
            iArr2 = c10;
            iArr = c11;
        }
        boolean g12 = iVar6.g();
        if (g12) {
            iArr4 = iVar.f274g;
            iArr3 = iVar2.f274g;
        } else {
            h.i(iVar6.f274g, c12);
            h.d(c12, iVar.f274g, d10);
            h.d(c12, iVar6.f274g, c12);
            h.d(c12, iVar2.f274g, c12);
            iArr4 = d10;
            iArr3 = c12;
        }
        int[] c13 = jd.d.c();
        h.k(iArr4, iArr2, c13);
        h.k(iArr3, iArr, c10);
        if (!jd.d.j(c13)) {
            h.i(c13, c11);
            int[] c14 = jd.d.c();
            h.d(c11, c13, c14);
            h.d(c11, iArr4, c11);
            h.f(c14, c14);
            jd.d.k(iArr3, c14, d10);
            h.h(jd.d.b(c11, c11, c14), c14);
            i iVar7 = new i(c12);
            h.i(c10, iVar7.f274g);
            int[] iArr5 = iVar7.f274g;
            h.k(iArr5, c14, iArr5);
            i iVar8 = new i(c14);
            h.k(c11, iVar7.f274g, iVar8.f274g);
            h.e(iVar8.f274g, c10, d10);
            h.g(d10, iVar8.f274g);
            i iVar9 = new i(c13);
            if (!g11) {
                int[] iArr6 = iVar9.f274g;
                h.d(iArr6, iVar5.f274g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = iVar9.f274g;
                h.d(iArr7, iVar6.f274g, iArr7);
            }
            return new j(g10, iVar7, iVar8, new d[]{iVar9}, this.f158e);
        } else if (jd.d.j(c10)) {
            return w();
        } else {
            return g10.q();
        }
    }

    public f r() {
        if (o()) {
            return this;
        }
        return new j(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        i iVar = (i) this.f156c;
        if (iVar.h()) {
            return g10.q();
        }
        i iVar2 = (i) this.f155b;
        i iVar3 = (i) this.f157d[0];
        int[] c10 = jd.d.c();
        int[] c11 = jd.d.c();
        int[] c12 = jd.d.c();
        h.i(iVar.f274g, c12);
        int[] c13 = jd.d.c();
        h.i(c12, c13);
        boolean g11 = iVar3.g();
        int[] iArr = iVar3.f274g;
        if (!g11) {
            h.i(iArr, c11);
            iArr = c11;
        }
        h.k(iVar2.f274g, iArr, c10);
        h.a(iVar2.f274g, iArr, c11);
        h.d(c11, c10, c11);
        h.h(jd.d.b(c11, c11, c11), c11);
        h.d(c12, iVar2.f274g, c12);
        h.h(m.F(5, c12, 2, 0), c12);
        h.h(m.G(5, c13, 3, 0, c10), c10);
        i iVar4 = new i(c13);
        h.i(c11, iVar4.f274g);
        int[] iArr2 = iVar4.f274g;
        h.k(iArr2, c12, iArr2);
        int[] iArr3 = iVar4.f274g;
        h.k(iArr3, c12, iArr3);
        i iVar5 = new i(c12);
        h.k(c12, iVar4.f274g, iVar5.f274g);
        int[] iArr4 = iVar5.f274g;
        h.d(iArr4, c11, iArr4);
        int[] iArr5 = iVar5.f274g;
        h.k(iArr5, c10, iArr5);
        i iVar6 = new i(c11);
        h.l(iVar.f274g, iVar6.f274g);
        if (!g11) {
            int[] iArr6 = iVar6.f274g;
            h.d(iArr6, iVar3.f274g, iArr6);
        }
        return new j(g10, iVar4, iVar5, new d[]{iVar6}, this.f158e);
    }

    public j(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    j(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
