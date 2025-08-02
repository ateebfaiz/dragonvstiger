package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import zd.a;

public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f247h = a.f234i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f248g;

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f247h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f248g = b.d(bigInteger);
    }

    public d a(d dVar) {
        int[] c10 = jd.c.c();
        b.a(this.f248g, ((c) dVar).f248g, c10);
        return new c(c10);
    }

    public d b() {
        int[] c10 = jd.c.c();
        b.b(this.f248g, c10);
        return new c(c10);
    }

    public d d(d dVar) {
        int[] c10 = jd.c.c();
        b.d(b.f239a, ((c) dVar).f248g, c10);
        b.e(c10, this.f248g, c10);
        return new c(c10);
    }

    public int e() {
        return f247h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return jd.c.g(this.f248g, ((c) obj).f248g);
    }

    public d f() {
        int[] c10 = jd.c.c();
        b.d(b.f239a, this.f248g, c10);
        return new c(c10);
    }

    public boolean g() {
        return jd.c.m(this.f248g);
    }

    public boolean h() {
        return jd.c.o(this.f248g);
    }

    public int hashCode() {
        return f247h.hashCode() ^ a.p(this.f248g, 0, 4);
    }

    public d i(d dVar) {
        int[] c10 = jd.c.c();
        b.e(this.f248g, ((c) dVar).f248g, c10);
        return new c(c10);
    }

    public d l() {
        int[] c10 = jd.c.c();
        b.g(this.f248g, c10);
        return new c(c10);
    }

    public d m() {
        int[] iArr = this.f248g;
        if (jd.c.o(iArr) || jd.c.m(iArr)) {
            return this;
        }
        int[] c10 = jd.c.c();
        b.j(iArr, c10);
        b.e(c10, iArr, c10);
        int[] c11 = jd.c.c();
        b.k(c10, 2, c11);
        b.e(c11, c10, c11);
        int[] c12 = jd.c.c();
        b.k(c11, 4, c12);
        b.e(c12, c11, c12);
        b.k(c12, 2, c11);
        b.e(c11, c10, c11);
        b.k(c11, 10, c10);
        b.e(c10, c11, c10);
        b.k(c10, 10, c12);
        b.e(c12, c11, c12);
        b.j(c12, c11);
        b.e(c11, iArr, c11);
        b.k(c11, 95, c11);
        b.j(c11, c12);
        if (jd.c.g(iArr, c12)) {
            return new c(c11);
        }
        return null;
    }

    public d n() {
        int[] c10 = jd.c.c();
        b.j(this.f248g, c10);
        return new c(c10);
    }

    public d p(d dVar) {
        int[] c10 = jd.c.c();
        b.m(this.f248g, ((c) dVar).f248g, c10);
        return new c(c10);
    }

    public boolean q() {
        if (jd.c.k(this.f248g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return jd.c.v(this.f248g);
    }

    protected c(int[] iArr) {
        this.f248g = iArr;
    }
}
