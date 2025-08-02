package gd;

import dd.d;
import java.math.BigInteger;
import jd.g;
import zd.a;

public class b2 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f246g;

    public b2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f246g = a2.d(bigInteger);
    }

    public d a(d dVar) {
        long[] g10 = g.g();
        a2.a(this.f246g, ((b2) dVar).f246g, g10);
        return new b2(g10);
    }

    public d b() {
        long[] g10 = g.g();
        a2.c(this.f246g, g10);
        return new b2(g10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 239;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b2)) {
            return false;
        }
        return g.l(this.f246g, ((b2) obj).f246g);
    }

    public d f() {
        long[] g10 = g.g();
        a2.j(this.f246g, g10);
        return new b2(g10);
    }

    public boolean g() {
        return g.s(this.f246g);
    }

    public boolean h() {
        return g.u(this.f246g);
    }

    public int hashCode() {
        return a.q(this.f246g, 0, 4) ^ 23900158;
    }

    public d i(d dVar) {
        long[] g10 = g.g();
        a2.k(this.f246g, ((b2) dVar).f246g, g10);
        return new b2(g10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f246g;
        long[] jArr2 = ((b2) dVar).f246g;
        long[] jArr3 = ((b2) dVar2).f246g;
        long[] jArr4 = ((b2) dVar3).f246g;
        long[] i10 = g.i();
        a2.l(jArr, jArr2, i10);
        a2.l(jArr3, jArr4, i10);
        long[] g10 = g.g();
        a2.m(i10, g10);
        return new b2(g10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] g10 = g.g();
        a2.o(this.f246g, g10);
        return new b2(g10);
    }

    public d n() {
        long[] g10 = g.g();
        a2.p(this.f246g, g10);
        return new b2(g10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f246g;
        long[] jArr2 = ((b2) dVar).f246g;
        long[] jArr3 = ((b2) dVar2).f246g;
        long[] i10 = g.i();
        a2.q(jArr, i10);
        a2.l(jArr2, jArr3, i10);
        long[] g10 = g.g();
        a2.m(i10, g10);
        return new b2(g10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f246g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.I(this.f246g);
    }

    protected b2(long[] jArr) {
        this.f246g = jArr;
    }
}
