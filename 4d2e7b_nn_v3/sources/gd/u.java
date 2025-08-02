package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.e;
import zd.a;

public class u extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f325h = s.f316i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f326g;

    public u(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f325h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f326g = t.d(bigInteger);
    }

    public d a(d dVar) {
        int[] e10 = e.e();
        t.a(this.f326g, ((u) dVar).f326g, e10);
        return new u(e10);
    }

    public d b() {
        int[] e10 = e.e();
        t.b(this.f326g, e10);
        return new u(e10);
    }

    public d d(d dVar) {
        int[] e10 = e.e();
        b.d(t.f322a, ((u) dVar).f326g, e10);
        t.e(e10, this.f326g, e10);
        return new u(e10);
    }

    public int e() {
        return f325h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return e.j(this.f326g, ((u) obj).f326g);
    }

    public d f() {
        int[] e10 = e.e();
        b.d(t.f322a, this.f326g, e10);
        return new u(e10);
    }

    public boolean g() {
        return e.q(this.f326g);
    }

    public boolean h() {
        return e.s(this.f326g);
    }

    public int hashCode() {
        return f325h.hashCode() ^ a.p(this.f326g, 0, 6);
    }

    public d i(d dVar) {
        int[] e10 = e.e();
        t.e(this.f326g, ((u) dVar).f326g, e10);
        return new u(e10);
    }

    public d l() {
        int[] e10 = e.e();
        t.g(this.f326g, e10);
        return new u(e10);
    }

    public d m() {
        int[] iArr = this.f326g;
        if (e.s(iArr) || e.q(iArr)) {
            return this;
        }
        int[] e10 = e.e();
        int[] e11 = e.e();
        t.j(iArr, e10);
        t.e(e10, iArr, e10);
        t.k(e10, 2, e11);
        t.e(e11, e10, e11);
        t.k(e11, 4, e10);
        t.e(e10, e11, e10);
        t.k(e10, 8, e11);
        t.e(e11, e10, e11);
        t.k(e11, 16, e10);
        t.e(e10, e11, e10);
        t.k(e10, 32, e11);
        t.e(e11, e10, e11);
        t.k(e11, 64, e10);
        t.e(e10, e11, e10);
        t.k(e10, 62, e10);
        t.j(e10, e11);
        if (e.j(iArr, e11)) {
            return new u(e10);
        }
        return null;
    }

    public d n() {
        int[] e10 = e.e();
        t.j(this.f326g, e10);
        return new u(e10);
    }

    public d p(d dVar) {
        int[] e10 = e.e();
        t.m(this.f326g, ((u) dVar).f326g, e10);
        return new u(e10);
    }

    public boolean q() {
        if (e.n(this.f326g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return e.F(this.f326g);
    }

    protected u(int[] iArr) {
        this.f326g = iArr;
    }
}
