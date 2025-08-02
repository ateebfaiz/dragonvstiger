package gd;

import dd.d;
import java.math.BigInteger;
import jd.g;
import zd.a;

public class p1 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f307g;

    public p1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f307g = o1.d(bigInteger);
    }

    public d a(d dVar) {
        long[] g10 = g.g();
        o1.a(this.f307g, ((p1) dVar).f307g, g10);
        return new p1(g10);
    }

    public d b() {
        long[] g10 = g.g();
        o1.c(this.f307g, g10);
        return new p1(g10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 193;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        return g.l(this.f307g, ((p1) obj).f307g);
    }

    public d f() {
        long[] g10 = g.g();
        o1.j(this.f307g, g10);
        return new p1(g10);
    }

    public boolean g() {
        return g.s(this.f307g);
    }

    public boolean h() {
        return g.u(this.f307g);
    }

    public int hashCode() {
        return a.q(this.f307g, 0, 4) ^ 1930015;
    }

    public d i(d dVar) {
        long[] g10 = g.g();
        o1.k(this.f307g, ((p1) dVar).f307g, g10);
        return new p1(g10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f307g;
        long[] jArr2 = ((p1) dVar).f307g;
        long[] jArr3 = ((p1) dVar2).f307g;
        long[] jArr4 = ((p1) dVar3).f307g;
        long[] i10 = g.i();
        o1.l(jArr, jArr2, i10);
        o1.l(jArr3, jArr4, i10);
        long[] g10 = g.g();
        o1.m(i10, g10);
        return new p1(g10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] g10 = g.g();
        o1.o(this.f307g, g10);
        return new p1(g10);
    }

    public d n() {
        long[] g10 = g.g();
        o1.p(this.f307g, g10);
        return new p1(g10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f307g;
        long[] jArr2 = ((p1) dVar).f307g;
        long[] jArr3 = ((p1) dVar2).f307g;
        long[] i10 = g.i();
        o1.q(jArr, i10);
        o1.l(jArr2, jArr3, i10);
        long[] g10 = g.g();
        o1.m(i10, g10);
        return new p1(g10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f307g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.I(this.f307g);
    }

    protected p1(long[] jArr) {
        this.f307g = jArr;
    }
}
