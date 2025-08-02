package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.g;
import zd.a;

public class g0 extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f265h = e0.f255i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f266g;

    public g0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f265h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f266g = f0.c(bigInteger);
    }

    public d a(d dVar) {
        int[] f10 = g.f();
        f0.a(this.f266g, ((g0) dVar).f266g, f10);
        return new g0(f10);
    }

    public d b() {
        int[] f10 = g.f();
        f0.b(this.f266g, f10);
        return new g0(f10);
    }

    public d d(d dVar) {
        int[] f10 = g.f();
        b.d(f0.f259a, ((g0) dVar).f266g, f10);
        f0.d(f10, this.f266g, f10);
        return new g0(f10);
    }

    public int e() {
        return f265h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        return g.k(this.f266g, ((g0) obj).f266g);
    }

    public d f() {
        int[] f10 = g.f();
        b.d(f0.f259a, this.f266g, f10);
        return new g0(f10);
    }

    public boolean g() {
        return g.r(this.f266g);
    }

    public boolean h() {
        return g.t(this.f266g);
    }

    public int hashCode() {
        return f265h.hashCode() ^ a.p(this.f266g, 0, 8);
    }

    public d i(d dVar) {
        int[] f10 = g.f();
        f0.d(this.f266g, ((g0) dVar).f266g, f10);
        return new g0(f10);
    }

    public d l() {
        int[] f10 = g.f();
        f0.f(this.f266g, f10);
        return new g0(f10);
    }

    public d m() {
        int[] iArr = this.f266g;
        if (g.t(iArr) || g.r(iArr)) {
            return this;
        }
        int[] f10 = g.f();
        f0.i(iArr, f10);
        f0.d(f10, iArr, f10);
        int[] f11 = g.f();
        f0.i(f10, f11);
        f0.d(f11, iArr, f11);
        int[] f12 = g.f();
        f0.j(f11, 3, f12);
        f0.d(f12, f11, f12);
        f0.j(f12, 3, f12);
        f0.d(f12, f11, f12);
        f0.j(f12, 2, f12);
        f0.d(f12, f10, f12);
        int[] f13 = g.f();
        f0.j(f12, 11, f13);
        f0.d(f13, f12, f13);
        f0.j(f13, 22, f12);
        f0.d(f12, f13, f12);
        int[] f14 = g.f();
        f0.j(f12, 44, f14);
        f0.d(f14, f12, f14);
        int[] f15 = g.f();
        f0.j(f14, 88, f15);
        f0.d(f15, f14, f15);
        f0.j(f15, 44, f14);
        f0.d(f14, f12, f14);
        f0.j(f14, 3, f12);
        f0.d(f12, f11, f12);
        f0.j(f12, 23, f12);
        f0.d(f12, f13, f12);
        f0.j(f12, 6, f12);
        f0.d(f12, f10, f12);
        f0.j(f12, 2, f12);
        f0.i(f12, f10);
        if (g.k(iArr, f10)) {
            return new g0(f12);
        }
        return null;
    }

    public d n() {
        int[] f10 = g.f();
        f0.i(this.f266g, f10);
        return new g0(f10);
    }

    public d p(d dVar) {
        int[] f10 = g.f();
        f0.k(this.f266g, ((g0) dVar).f266g, f10);
        return new g0(f10);
    }

    public boolean q() {
        if (g.o(this.f266g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.H(this.f266g);
    }

    protected g0(int[] iArr) {
        this.f266g = iArr;
    }
}
