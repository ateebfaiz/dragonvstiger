package gd;

import dd.c;
import dd.d;
import dd.f;
import jd.m;

public class z extends f.b {
    public z(c cVar, d dVar, d dVar2) {
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
        y yVar = (y) this.f155b;
        y yVar2 = (y) this.f156c;
        y yVar3 = (y) fVar.l();
        y yVar4 = (y) fVar.m();
        y yVar5 = (y) this.f157d[0];
        y yVar6 = (y) fVar.n(0);
        int[] e10 = jd.f.e();
        int[] d10 = jd.f.d();
        int[] d11 = jd.f.d();
        int[] d12 = jd.f.d();
        boolean g11 = yVar5.g();
        if (g11) {
            iArr2 = yVar3.f341g;
            iArr = yVar4.f341g;
        } else {
            x.i(yVar5.f341g, d11);
            x.d(d11, yVar3.f341g, d10);
            x.d(d11, yVar5.f341g, d11);
            x.d(d11, yVar4.f341g, d11);
            iArr2 = d10;
            iArr = d11;
        }
        boolean g12 = yVar6.g();
        if (g12) {
            iArr4 = yVar.f341g;
            iArr3 = yVar2.f341g;
        } else {
            x.i(yVar6.f341g, d12);
            x.d(d12, yVar.f341g, e10);
            x.d(d12, yVar6.f341g, d12);
            x.d(d12, yVar2.f341g, d12);
            iArr4 = e10;
            iArr3 = d12;
        }
        int[] d13 = jd.f.d();
        x.k(iArr4, iArr2, d13);
        x.k(iArr3, iArr, d10);
        if (!jd.f.k(d13)) {
            x.i(d13, d11);
            int[] d14 = jd.f.d();
            x.d(d11, d13, d14);
            x.d(d11, iArr4, d11);
            x.f(d14, d14);
            jd.f.l(iArr3, d14, e10);
            x.h(jd.f.b(d11, d11, d14), d14);
            y yVar7 = new y(d12);
            x.i(d10, yVar7.f341g);
            int[] iArr5 = yVar7.f341g;
            x.k(iArr5, d14, iArr5);
            y yVar8 = new y(d14);
            x.k(d11, yVar7.f341g, yVar8.f341g);
            x.e(yVar8.f341g, d10, e10);
            x.g(e10, yVar8.f341g);
            y yVar9 = new y(d13);
            if (!g11) {
                int[] iArr6 = yVar9.f341g;
                x.d(iArr6, yVar5.f341g, iArr6);
            }
            if (!g12) {
                int[] iArr7 = yVar9.f341g;
                x.d(iArr7, yVar6.f341g, iArr7);
            }
            return new z(g10, yVar7, yVar8, new d[]{yVar9}, this.f158e);
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
        return new z(this.f154a, this.f155b, this.f156c.l(), this.f157d, this.f158e);
    }

    public f w() {
        if (o()) {
            return this;
        }
        c g10 = g();
        y yVar = (y) this.f156c;
        if (yVar.h()) {
            return g10.q();
        }
        y yVar2 = (y) this.f155b;
        y yVar3 = (y) this.f157d[0];
        int[] d10 = jd.f.d();
        x.i(yVar.f341g, d10);
        int[] d11 = jd.f.d();
        x.i(d10, d11);
        int[] d12 = jd.f.d();
        x.i(yVar2.f341g, d12);
        x.h(jd.f.b(d12, d12, d12), d12);
        x.d(d10, yVar2.f341g, d10);
        x.h(m.F(7, d10, 2, 0), d10);
        int[] d13 = jd.f.d();
        x.h(m.G(7, d11, 3, 0, d13), d13);
        y yVar4 = new y(d11);
        x.i(d12, yVar4.f341g);
        int[] iArr = yVar4.f341g;
        x.k(iArr, d10, iArr);
        int[] iArr2 = yVar4.f341g;
        x.k(iArr2, d10, iArr2);
        y yVar5 = new y(d10);
        x.k(d10, yVar4.f341g, yVar5.f341g);
        int[] iArr3 = yVar5.f341g;
        x.d(iArr3, d12, iArr3);
        int[] iArr4 = yVar5.f341g;
        x.k(iArr4, d13, iArr4);
        y yVar6 = new y(d12);
        x.l(yVar.f341g, yVar6.f341g);
        if (!yVar3.g()) {
            int[] iArr5 = yVar6.f341g;
            x.d(iArr5, yVar3.f341g, iArr5);
        }
        return new z(g10, yVar4, yVar5, new d[]{yVar6}, this.f158e);
    }

    public z(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    z(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
