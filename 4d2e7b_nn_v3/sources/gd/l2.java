package gd;

import dd.d;
import java.math.BigInteger;
import jd.j;
import jd.m;
import zd.a;

public class l2 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f289g;

    public l2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f289g = k2.d(bigInteger);
    }

    public d a(d dVar) {
        long[] a10 = j.a();
        k2.a(this.f289g, ((l2) dVar).f289g, a10);
        return new l2(a10);
    }

    public d b() {
        long[] a10 = j.a();
        k2.c(this.f289g, a10);
        return new l2(a10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 409;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        return j.c(this.f289g, ((l2) obj).f289g);
    }

    public d f() {
        long[] a10 = j.a();
        k2.j(this.f289g, a10);
        return new l2(a10);
    }

    public boolean g() {
        return j.e(this.f289g);
    }

    public boolean h() {
        return j.f(this.f289g);
    }

    public int hashCode() {
        return a.q(this.f289g, 0, 7) ^ 4090087;
    }

    public d i(d dVar) {
        long[] a10 = j.a();
        k2.k(this.f289g, ((l2) dVar).f289g, a10);
        return new l2(a10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f289g;
        long[] jArr2 = ((l2) dVar).f289g;
        long[] jArr3 = ((l2) dVar2).f289g;
        long[] jArr4 = ((l2) dVar3).f289g;
        long[] j10 = m.j(13);
        k2.l(jArr, jArr2, j10);
        k2.l(jArr3, jArr4, j10);
        long[] a10 = j.a();
        k2.m(j10, a10);
        return new l2(a10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] a10 = j.a();
        k2.o(this.f289g, a10);
        return new l2(a10);
    }

    public d n() {
        long[] a10 = j.a();
        k2.p(this.f289g, a10);
        return new l2(a10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f289g;
        long[] jArr2 = ((l2) dVar).f289g;
        long[] jArr3 = ((l2) dVar2).f289g;
        long[] j10 = m.j(13);
        k2.q(jArr, j10);
        k2.l(jArr2, jArr3, j10);
        long[] a10 = j.a();
        k2.m(j10, a10);
        return new l2(a10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f289g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return j.g(this.f289g);
    }

    protected l2(long[] jArr) {
        this.f289g = jArr;
    }
}
