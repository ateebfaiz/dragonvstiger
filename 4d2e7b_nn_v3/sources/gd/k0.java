package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.g;
import zd.a;

public class k0 extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f283h = i0.f275i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f284g;

    public k0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f283h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f284g = j0.d(bigInteger);
    }

    public d a(d dVar) {
        int[] f10 = g.f();
        j0.a(this.f284g, ((k0) dVar).f284g, f10);
        return new k0(f10);
    }

    public d b() {
        int[] f10 = g.f();
        j0.b(this.f284g, f10);
        return new k0(f10);
    }

    public d d(d dVar) {
        int[] f10 = g.f();
        b.d(j0.f279a, ((k0) dVar).f284g, f10);
        j0.e(f10, this.f284g, f10);
        return new k0(f10);
    }

    public int e() {
        return f283h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        return g.k(this.f284g, ((k0) obj).f284g);
    }

    public d f() {
        int[] f10 = g.f();
        b.d(j0.f279a, this.f284g, f10);
        return new k0(f10);
    }

    public boolean g() {
        return g.r(this.f284g);
    }

    public boolean h() {
        return g.t(this.f284g);
    }

    public int hashCode() {
        return f283h.hashCode() ^ a.p(this.f284g, 0, 8);
    }

    public d i(d dVar) {
        int[] f10 = g.f();
        j0.e(this.f284g, ((k0) dVar).f284g, f10);
        return new k0(f10);
    }

    public d l() {
        int[] f10 = g.f();
        j0.g(this.f284g, f10);
        return new k0(f10);
    }

    public d m() {
        int[] iArr = this.f284g;
        if (g.t(iArr) || g.r(iArr)) {
            return this;
        }
        int[] f10 = g.f();
        int[] f11 = g.f();
        j0.j(iArr, f10);
        j0.e(f10, iArr, f10);
        j0.k(f10, 2, f11);
        j0.e(f11, f10, f11);
        j0.k(f11, 4, f10);
        j0.e(f10, f11, f10);
        j0.k(f10, 8, f11);
        j0.e(f11, f10, f11);
        j0.k(f11, 16, f10);
        j0.e(f10, f11, f10);
        j0.k(f10, 32, f10);
        j0.e(f10, iArr, f10);
        j0.k(f10, 96, f10);
        j0.e(f10, iArr, f10);
        j0.k(f10, 94, f10);
        j0.j(f10, f11);
        if (g.k(iArr, f11)) {
            return new k0(f10);
        }
        return null;
    }

    public d n() {
        int[] f10 = g.f();
        j0.j(this.f284g, f10);
        return new k0(f10);
    }

    public d p(d dVar) {
        int[] f10 = g.f();
        j0.m(this.f284g, ((k0) dVar).f284g, f10);
        return new k0(f10);
    }

    public boolean q() {
        if (g.o(this.f284g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.H(this.f284g);
    }

    protected k0(int[] iArr) {
        this.f284g = iArr;
    }
}
