package gd;

import dd.d;
import java.math.BigInteger;
import jd.l;
import zd.a;

public class r2 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f315g;

    public r2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f315g = q2.g(bigInteger);
    }

    public d a(d dVar) {
        long[] a10 = l.a();
        q2.b(this.f315g, ((r2) dVar).f315g, a10);
        return new r2(a10);
    }

    public d b() {
        long[] a10 = l.a();
        q2.f(this.f315g, a10);
        return new r2(a10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 571;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r2)) {
            return false;
        }
        return l.c(this.f315g, ((r2) obj).f315g);
    }

    public d f() {
        long[] a10 = l.a();
        q2.k(this.f315g, a10);
        return new r2(a10);
    }

    public boolean g() {
        return l.e(this.f315g);
    }

    public boolean h() {
        return l.f(this.f315g);
    }

    public int hashCode() {
        return a.q(this.f315g, 0, 9) ^ 5711052;
    }

    public d i(d dVar) {
        long[] a10 = l.a();
        q2.l(this.f315g, ((r2) dVar).f315g, a10);
        return new r2(a10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f315g;
        long[] jArr2 = ((r2) dVar).f315g;
        long[] jArr3 = ((r2) dVar2).f315g;
        long[] jArr4 = ((r2) dVar3).f315g;
        long[] b10 = l.b();
        q2.m(jArr, jArr2, b10);
        q2.m(jArr3, jArr4, b10);
        long[] a10 = l.a();
        q2.p(b10, a10);
        return new r2(a10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] a10 = l.a();
        q2.r(this.f315g, a10);
        return new r2(a10);
    }

    public d n() {
        long[] a10 = l.a();
        q2.s(this.f315g, a10);
        return new r2(a10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f315g;
        long[] jArr2 = ((r2) dVar).f315g;
        long[] jArr3 = ((r2) dVar2).f315g;
        long[] b10 = l.b();
        q2.t(jArr, b10);
        q2.m(jArr2, jArr3, b10);
        long[] a10 = l.a();
        q2.p(b10, a10);
        return new r2(a10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f315g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return l.g(this.f315g);
    }

    protected r2(long[] jArr) {
        this.f315g = jArr;
    }
}
