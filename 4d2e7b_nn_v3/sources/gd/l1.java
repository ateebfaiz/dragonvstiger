package gd;

import dd.b;
import dd.c;
import dd.d;
import dd.f;

public class l1 extends f.a {
    public l1(c cVar, d dVar, d dVar2) {
        this(cVar, dVar, dVar2, false);
    }

    public f a(f fVar) {
        d dVar;
        d dVar2;
        d dVar3;
        d dVar4;
        d dVar5;
        d dVar6;
        d dVar7;
        if (o()) {
            return fVar;
        }
        if (fVar.o()) {
            return this;
        }
        c g10 = g();
        d dVar8 = this.f155b;
        d j10 = fVar.j();
        if (!dVar8.h()) {
            d dVar9 = this.f156c;
            d dVar10 = this.f157d[0];
            d k10 = fVar.k();
            d n10 = fVar.n(0);
            boolean g11 = dVar10.g();
            if (!g11) {
                dVar2 = j10.i(dVar10);
                dVar = k10.i(dVar10);
            } else {
                dVar2 = j10;
                dVar = k10;
            }
            boolean g12 = n10.g();
            if (!g12) {
                dVar8 = dVar8.i(n10);
                dVar3 = dVar9.i(n10);
            } else {
                dVar3 = dVar9;
            }
            d a10 = dVar3.a(dVar);
            d a11 = dVar8.a(dVar2);
            if (!a11.h()) {
                if (j10.h()) {
                    f s10 = s();
                    d l10 = s10.l();
                    d m10 = s10.m();
                    d d10 = m10.a(k10).d(l10);
                    dVar5 = d10.n().a(d10).a(l10).a(g10.k());
                    if (dVar5.h()) {
                        return new l1(g10, dVar5, g10.l().m(), this.f158e);
                    }
                    d a12 = d10.i(l10.a(dVar5)).a(dVar5).a(m10).d(dVar5).a(dVar5);
                    dVar6 = g10.j(b.f122b);
                    dVar4 = a12;
                } else {
                    d n11 = a11.n();
                    d i10 = a10.i(dVar8);
                    d i11 = a10.i(dVar2);
                    d i12 = i10.i(i11);
                    if (i12.h()) {
                        return new l1(g10, i12, g10.l().m(), this.f158e);
                    }
                    d i13 = a10.i(n11);
                    if (!g12) {
                        dVar7 = i13.i(n10);
                    } else {
                        dVar7 = i13;
                    }
                    d o10 = i11.a(n11).o(dVar7, dVar9.a(dVar10));
                    if (!g11) {
                        dVar7 = dVar7.i(dVar10);
                    }
                    dVar5 = i12;
                    dVar4 = o10;
                    dVar6 = dVar7;
                }
                return new l1(g10, dVar5, dVar4, new d[]{dVar6}, this.f158e);
            } else if (a10.h()) {
                return w();
            } else {
                return g10.q();
            }
        } else if (j10.h()) {
            return g10.q();
        } else {
            return fVar.a(this);
        }
    }

    public d m() {
        d dVar = this.f155b;
        d dVar2 = this.f156c;
        if (o() || dVar.h()) {
            return dVar2;
        }
        d i10 = dVar2.a(dVar).i(dVar);
        d dVar3 = this.f157d[0];
        if (!dVar3.g()) {
            return i10.d(dVar3);
        }
        return i10;
    }

    public f r() {
        if (o()) {
            return this;
        }
        d dVar = this.f155b;
        if (dVar.h()) {
            return this;
        }
        d dVar2 = this.f156c;
        d dVar3 = this.f157d[0];
        return new l1(this.f154a, dVar, dVar2.a(dVar3), new d[]{dVar3}, this.f158e);
    }

    public f w() {
        d dVar;
        d dVar2;
        d dVar3;
        if (o()) {
            return this;
        }
        c g10 = g();
        d dVar4 = this.f155b;
        if (dVar4.h()) {
            return g10.q();
        }
        d dVar5 = this.f156c;
        d dVar6 = this.f157d[0];
        boolean g11 = dVar6.g();
        if (g11) {
            dVar = dVar5;
        } else {
            dVar = dVar5.i(dVar6);
        }
        if (g11) {
            dVar2 = dVar6;
        } else {
            dVar2 = dVar6.n();
        }
        d k10 = g10.k();
        if (!g11) {
            k10 = k10.i(dVar2);
        }
        d a10 = dVar5.n().a(dVar).a(k10);
        if (a10.h()) {
            return new l1(g10, a10, g10.l().m(), this.f158e);
        }
        d n10 = a10.n();
        if (g11) {
            dVar3 = a10;
        } else {
            dVar3 = a10.i(dVar2);
        }
        if (!g11) {
            dVar4 = dVar4.i(dVar6);
        }
        return new l1(g10, n10, dVar4.o(a10, dVar).a(n10).a(dVar3), new d[]{dVar3}, this.f158e);
    }

    public l1(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    l1(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
