package gd;

import dd.b;
import dd.c;
import dd.d;
import dd.f;
import jd.l;

public class v2 extends f.a {
    public v2(c cVar, d dVar, d dVar2) {
        this(cVar, dVar, dVar2, false);
    }

    public f a(f fVar) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5;
        long[] jArr6;
        r2 r2Var;
        r2 r2Var2;
        r2 r2Var3;
        f fVar2 = fVar;
        if (o()) {
            return fVar2;
        }
        if (fVar.o()) {
            return this;
        }
        c g10 = g();
        r2 r2Var4 = (r2) this.f155b;
        r2 r2Var5 = (r2) fVar.j();
        if (!r2Var4.h()) {
            r2 r2Var6 = (r2) this.f156c;
            r2 r2Var7 = (r2) this.f157d[0];
            r2 r2Var8 = (r2) fVar.k();
            r2 r2Var9 = (r2) fVar2.n(0);
            long[] a10 = l.a();
            long[] a11 = l.a();
            long[] a12 = l.a();
            long[] a13 = l.a();
            if (r2Var7.g()) {
                jArr = null;
            } else {
                jArr = q2.o(r2Var7.f315g);
            }
            if (jArr == null) {
                jArr2 = r2Var5.f315g;
                jArr3 = r2Var8.f315g;
            } else {
                q2.n(r2Var5.f315g, jArr, a11);
                q2.n(r2Var8.f315g, jArr, a13);
                jArr2 = a11;
                jArr3 = a13;
            }
            if (r2Var9.g()) {
                jArr4 = null;
            } else {
                jArr4 = q2.o(r2Var9.f315g);
            }
            if (jArr4 == null) {
                jArr5 = r2Var4.f315g;
                jArr6 = r2Var6.f315g;
            } else {
                q2.n(r2Var4.f315g, jArr4, a10);
                q2.n(r2Var6.f315g, jArr4, a12);
                jArr5 = a10;
                jArr6 = a12;
            }
            q2.b(jArr6, jArr3, a12);
            q2.b(jArr5, jArr2, a13);
            if (!l.f(a13)) {
                if (r2Var5.h()) {
                    f s10 = s();
                    r2 r2Var10 = (r2) s10.l();
                    d m10 = s10.m();
                    d d10 = m10.a(r2Var8).d(r2Var10);
                    r2 r2Var11 = (r2) d10.n().a(d10).a(r2Var10).b();
                    if (r2Var11.h()) {
                        return new v2(g10, r2Var11, u2.f328k, this.f158e);
                    }
                    r2Var3 = (r2) g10.j(b.f122b);
                    r2Var = (r2) d10.i(r2Var10.a(r2Var11)).a(r2Var11).a(m10).d(r2Var11).a(r2Var11);
                    r2Var2 = r2Var11;
                } else {
                    q2.s(a13, a13);
                    long[] o10 = q2.o(a12);
                    q2.n(jArr5, o10, a10);
                    q2.n(jArr2, o10, a11);
                    r2 r2Var12 = new r2(a10);
                    q2.l(a10, a11, r2Var12.f315g);
                    if (r2Var12.h()) {
                        return new v2(g10, r2Var12, u2.f328k, this.f158e);
                    }
                    r2 r2Var13 = new r2(a12);
                    q2.n(a13, o10, r2Var13.f315g);
                    if (jArr4 != null) {
                        long[] jArr7 = r2Var13.f315g;
                        q2.n(jArr7, jArr4, jArr7);
                    }
                    long[] b10 = l.b();
                    q2.b(a11, a13, a13);
                    q2.t(a13, b10);
                    q2.b(r2Var6.f315g, r2Var7.f315g, a13);
                    q2.m(a13, r2Var13.f315g, b10);
                    r2 r2Var14 = new r2(a13);
                    q2.p(b10, r2Var14.f315g);
                    if (jArr != null) {
                        long[] jArr8 = r2Var13.f315g;
                        q2.n(jArr8, jArr, jArr8);
                    }
                    r2Var = r2Var14;
                    r2Var2 = r2Var12;
                    r2Var3 = r2Var13;
                }
                return new v2(g10, r2Var2, r2Var, new d[]{r2Var3}, this.f158e);
            } else if (l.f(a12)) {
                return w();
            } else {
                return g10.q();
            }
        } else if (r2Var5.h()) {
            return g10.q();
        } else {
            return fVar2.a(this);
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
        return new v2(this.f154a, dVar, dVar2.a(dVar3), new d[]{dVar3}, this.f158e);
    }

    public f w() {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        if (o()) {
            return this;
        }
        c g10 = g();
        r2 r2Var = (r2) this.f155b;
        if (r2Var.h()) {
            return g10.q();
        }
        r2 r2Var2 = (r2) this.f156c;
        r2 r2Var3 = (r2) this.f157d[0];
        long[] a10 = l.a();
        long[] a11 = l.a();
        if (r2Var3.g()) {
            jArr = null;
        } else {
            jArr = q2.o(r2Var3.f315g);
        }
        if (jArr == null) {
            jArr2 = r2Var2.f315g;
            jArr3 = r2Var3.f315g;
        } else {
            q2.n(r2Var2.f315g, jArr, a10);
            q2.s(r2Var3.f315g, a11);
            jArr2 = a10;
            jArr3 = a11;
        }
        long[] a12 = l.a();
        q2.s(r2Var2.f315g, a12);
        q2.d(jArr2, jArr3, a12);
        if (l.f(a12)) {
            return new v2(g10, new r2(a12), u2.f328k, this.f158e);
        }
        long[] b10 = l.b();
        q2.m(a12, jArr2, b10);
        r2 r2Var4 = new r2(a10);
        q2.s(a12, r2Var4.f315g);
        r2 r2Var5 = new r2(a12);
        if (jArr != null) {
            long[] jArr5 = r2Var5.f315g;
            q2.l(jArr5, jArr3, jArr5);
        }
        if (jArr == null) {
            jArr4 = r2Var.f315g;
        } else {
            q2.n(r2Var.f315g, jArr, a11);
            jArr4 = a11;
        }
        q2.t(jArr4, b10);
        q2.p(b10, a11);
        q2.d(r2Var4.f315g, r2Var5.f315g, a11);
        r2 r2Var6 = new r2(a11);
        d[] dVarArr = {r2Var5};
        return new v2(g10, r2Var4, r2Var6, dVarArr, this.f158e);
    }

    public v2(c cVar, d dVar, d dVar2, boolean z10) {
        super(cVar, dVar, dVar2);
        if ((dVar == null) == (dVar2 == null)) {
            this.f158e = z10;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    v2(c cVar, d dVar, d dVar2, d[] dVarArr, boolean z10) {
        super(cVar, dVar, dVar2, dVarArr);
        this.f158e = z10;
    }
}
