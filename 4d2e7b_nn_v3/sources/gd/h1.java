package gd;

import dd.d;
import java.math.BigInteger;
import jd.e;
import zd.a;

public class h1 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f272g;

    public h1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f272g = g1.d(bigInteger);
    }

    public d a(d dVar) {
        long[] f10 = e.f();
        g1.a(this.f272g, ((h1) dVar).f272g, f10);
        return new h1(f10);
    }

    public d b() {
        long[] f10 = e.f();
        g1.c(this.f272g, f10);
        return new h1(f10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 163;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        return e.k(this.f272g, ((h1) obj).f272g);
    }

    public d f() {
        long[] f10 = e.f();
        g1.i(this.f272g, f10);
        return new h1(f10);
    }

    public boolean g() {
        return e.r(this.f272g);
    }

    public boolean h() {
        return e.t(this.f272g);
    }

    public int hashCode() {
        return a.q(this.f272g, 0, 3) ^ 163763;
    }

    public d i(d dVar) {
        long[] f10 = e.f();
        g1.j(this.f272g, ((h1) dVar).f272g, f10);
        return new h1(f10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f272g;
        long[] jArr2 = ((h1) dVar).f272g;
        long[] jArr3 = ((h1) dVar2).f272g;
        long[] jArr4 = ((h1) dVar3).f272g;
        long[] h10 = e.h();
        g1.k(jArr, jArr2, h10);
        g1.k(jArr3, jArr4, h10);
        long[] f10 = e.f();
        g1.l(h10, f10);
        return new h1(f10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] f10 = e.f();
        g1.n(this.f272g, f10);
        return new h1(f10);
    }

    public d n() {
        long[] f10 = e.f();
        g1.o(this.f272g, f10);
        return new h1(f10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f272g;
        long[] jArr2 = ((h1) dVar).f272g;
        long[] jArr3 = ((h1) dVar2).f272g;
        long[] h10 = e.h();
        g1.p(jArr, h10);
        g1.k(jArr2, jArr3, h10);
        long[] f10 = e.f();
        g1.l(h10, f10);
        return new h1(f10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f272g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return e.G(this.f272g);
    }

    protected h1(long[] jArr) {
        this.f272g = jArr;
    }
}
