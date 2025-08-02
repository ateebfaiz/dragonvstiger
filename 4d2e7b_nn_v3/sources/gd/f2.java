package gd;

import dd.d;
import java.math.BigInteger;
import jd.h;
import jd.m;
import zd.a;

public class f2 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f262g;

    public f2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f262g = e2.d(bigInteger);
    }

    public d a(d dVar) {
        long[] a10 = h.a();
        e2.a(this.f262g, ((f2) dVar).f262g, a10);
        return new f2(a10);
    }

    public d b() {
        long[] a10 = h.a();
        e2.c(this.f262g, a10);
        return new f2(a10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 283;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f2)) {
            return false;
        }
        return h.c(this.f262g, ((f2) obj).f262g);
    }

    public d f() {
        long[] a10 = h.a();
        e2.j(this.f262g, a10);
        return new f2(a10);
    }

    public boolean g() {
        return h.e(this.f262g);
    }

    public boolean h() {
        return h.f(this.f262g);
    }

    public int hashCode() {
        return a.q(this.f262g, 0, 5) ^ 2831275;
    }

    public d i(d dVar) {
        long[] a10 = h.a();
        e2.k(this.f262g, ((f2) dVar).f262g, a10);
        return new f2(a10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f262g;
        long[] jArr2 = ((f2) dVar).f262g;
        long[] jArr3 = ((f2) dVar2).f262g;
        long[] jArr4 = ((f2) dVar3).f262g;
        long[] j10 = m.j(9);
        e2.l(jArr, jArr2, j10);
        e2.l(jArr3, jArr4, j10);
        long[] a10 = h.a();
        e2.m(j10, a10);
        return new f2(a10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] a10 = h.a();
        e2.o(this.f262g, a10);
        return new f2(a10);
    }

    public d n() {
        long[] a10 = h.a();
        e2.p(this.f262g, a10);
        return new f2(a10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f262g;
        long[] jArr2 = ((f2) dVar).f262g;
        long[] jArr3 = ((f2) dVar2).f262g;
        long[] j10 = m.j(9);
        e2.q(jArr, j10);
        e2.l(jArr2, jArr3, j10);
        long[] a10 = h.a();
        e2.m(j10, a10);
        return new f2(a10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f262g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return h.g(this.f262g);
    }

    protected f2(long[] jArr) {
        this.f262g = jArr;
    }
}
