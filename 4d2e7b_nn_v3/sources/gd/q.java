package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.e;
import zd.a;

public class q extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f308h = o.f299i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f309g;

    public q(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f308h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f309g = p.c(bigInteger);
    }

    public d a(d dVar) {
        int[] e10 = e.e();
        p.a(this.f309g, ((q) dVar).f309g, e10);
        return new q(e10);
    }

    public d b() {
        int[] e10 = e.e();
        p.b(this.f309g, e10);
        return new q(e10);
    }

    public d d(d dVar) {
        int[] e10 = e.e();
        b.d(p.f304a, ((q) dVar).f309g, e10);
        p.d(e10, this.f309g, e10);
        return new q(e10);
    }

    public int e() {
        return f308h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        return e.j(this.f309g, ((q) obj).f309g);
    }

    public d f() {
        int[] e10 = e.e();
        b.d(p.f304a, this.f309g, e10);
        return new q(e10);
    }

    public boolean g() {
        return e.q(this.f309g);
    }

    public boolean h() {
        return e.s(this.f309g);
    }

    public int hashCode() {
        return f308h.hashCode() ^ a.p(this.f309g, 0, 6);
    }

    public d i(d dVar) {
        int[] e10 = e.e();
        p.d(this.f309g, ((q) dVar).f309g, e10);
        return new q(e10);
    }

    public d l() {
        int[] e10 = e.e();
        p.f(this.f309g, e10);
        return new q(e10);
    }

    public d m() {
        int[] iArr = this.f309g;
        if (e.s(iArr) || e.q(iArr)) {
            return this;
        }
        int[] e10 = e.e();
        p.i(iArr, e10);
        p.d(e10, iArr, e10);
        int[] e11 = e.e();
        p.i(e10, e11);
        p.d(e11, iArr, e11);
        int[] e12 = e.e();
        p.j(e11, 3, e12);
        p.d(e12, e11, e12);
        p.j(e12, 2, e12);
        p.d(e12, e10, e12);
        p.j(e12, 8, e10);
        p.d(e10, e12, e10);
        p.j(e10, 3, e12);
        p.d(e12, e11, e12);
        int[] e13 = e.e();
        p.j(e12, 16, e13);
        p.d(e13, e10, e13);
        p.j(e13, 35, e10);
        p.d(e10, e13, e10);
        p.j(e10, 70, e13);
        p.d(e13, e10, e13);
        p.j(e13, 19, e10);
        p.d(e10, e12, e10);
        p.j(e10, 20, e10);
        p.d(e10, e12, e10);
        p.j(e10, 4, e10);
        p.d(e10, e11, e10);
        p.j(e10, 6, e10);
        p.d(e10, e11, e10);
        p.i(e10, e10);
        p.i(e10, e11);
        if (e.j(iArr, e11)) {
            return new q(e10);
        }
        return null;
    }

    public d n() {
        int[] e10 = e.e();
        p.i(this.f309g, e10);
        return new q(e10);
    }

    public d p(d dVar) {
        int[] e10 = e.e();
        p.k(this.f309g, ((q) dVar).f309g, e10);
        return new q(e10);
    }

    public boolean q() {
        if (e.n(this.f309g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return e.F(this.f309g);
    }

    protected q(int[] iArr) {
        this.f309g = iArr;
    }
}
