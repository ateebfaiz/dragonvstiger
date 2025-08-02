package gd;

import dd.d;
import java.math.BigInteger;
import jd.c;
import zd.a;

public class v0 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f330g;

    public v0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f330g = u0.d(bigInteger);
    }

    public d a(d dVar) {
        long[] d10 = c.d();
        u0.a(this.f330g, ((v0) dVar).f330g, d10);
        return new v0(d10);
    }

    public d b() {
        long[] d10 = c.d();
        u0.c(this.f330g, d10);
        return new v0(d10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 113;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        return c.h(this.f330g, ((v0) obj).f330g);
    }

    public d f() {
        long[] d10 = c.d();
        u0.h(this.f330g, d10);
        return new v0(d10);
    }

    public boolean g() {
        return c.n(this.f330g);
    }

    public boolean h() {
        return c.p(this.f330g);
    }

    public int hashCode() {
        return a.q(this.f330g, 0, 2) ^ 113009;
    }

    public d i(d dVar) {
        long[] d10 = c.d();
        u0.i(this.f330g, ((v0) dVar).f330g, d10);
        return new v0(d10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f330g;
        long[] jArr2 = ((v0) dVar).f330g;
        long[] jArr3 = ((v0) dVar2).f330g;
        long[] jArr4 = ((v0) dVar3).f330g;
        long[] f10 = c.f();
        u0.j(jArr, jArr2, f10);
        u0.j(jArr3, jArr4, f10);
        long[] d10 = c.d();
        u0.k(f10, d10);
        return new v0(d10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] d10 = c.d();
        u0.m(this.f330g, d10);
        return new v0(d10);
    }

    public d n() {
        long[] d10 = c.d();
        u0.n(this.f330g, d10);
        return new v0(d10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f330g;
        long[] jArr2 = ((v0) dVar).f330g;
        long[] jArr3 = ((v0) dVar2).f330g;
        long[] f10 = c.f();
        u0.o(jArr, f10);
        u0.j(jArr2, jArr3, f10);
        long[] d10 = c.d();
        u0.k(f10, d10);
        return new v0(d10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f330g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return c.w(this.f330g);
    }

    protected v0(long[] jArr) {
        this.f330g = jArr;
    }
}
