package gd;

import dd.d;
import java.math.BigInteger;
import jd.g;
import zd.a;

public class v1 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f331g;

    public v1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f331g = u1.d(bigInteger);
    }

    public d a(d dVar) {
        long[] g10 = g.g();
        u1.a(this.f331g, ((v1) dVar).f331g, g10);
        return new v1(g10);
    }

    public d b() {
        long[] g10 = g.g();
        u1.c(this.f331g, g10);
        return new v1(g10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 233;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        return g.l(this.f331g, ((v1) obj).f331g);
    }

    public d f() {
        long[] g10 = g.g();
        u1.j(this.f331g, g10);
        return new v1(g10);
    }

    public boolean g() {
        return g.s(this.f331g);
    }

    public boolean h() {
        return g.u(this.f331g);
    }

    public int hashCode() {
        return a.q(this.f331g, 0, 4) ^ 2330074;
    }

    public d i(d dVar) {
        long[] g10 = g.g();
        u1.k(this.f331g, ((v1) dVar).f331g, g10);
        return new v1(g10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f331g;
        long[] jArr2 = ((v1) dVar).f331g;
        long[] jArr3 = ((v1) dVar2).f331g;
        long[] jArr4 = ((v1) dVar3).f331g;
        long[] i10 = g.i();
        u1.l(jArr, jArr2, i10);
        u1.l(jArr3, jArr4, i10);
        long[] g10 = g.g();
        u1.m(i10, g10);
        return new v1(g10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] g10 = g.g();
        u1.o(this.f331g, g10);
        return new v1(g10);
    }

    public d n() {
        long[] g10 = g.g();
        u1.p(this.f331g, g10);
        return new v1(g10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f331g;
        long[] jArr2 = ((v1) dVar).f331g;
        long[] jArr3 = ((v1) dVar2).f331g;
        long[] i10 = g.i();
        u1.q(jArr, i10);
        u1.l(jArr2, jArr3, i10);
        long[] g10 = g.g();
        u1.m(i10, g10);
        return new v1(g10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f331g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.I(this.f331g);
    }

    protected v1(long[] jArr) {
        this.f331g = jArr;
    }
}
