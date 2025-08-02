package fd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.g;
import zd.a;

public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f231h = a.f227i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f232g;

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f231h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.f232g = b.d(bigInteger);
    }

    public d a(d dVar) {
        int[] f10 = g.f();
        b.a(this.f232g, ((c) dVar).f232g, f10);
        return new c(f10);
    }

    public d b() {
        int[] f10 = g.f();
        b.b(this.f232g, f10);
        return new c(f10);
    }

    public d d(d dVar) {
        int[] f10 = g.f();
        b.d(b.f229a, ((c) dVar).f232g, f10);
        b.e(f10, this.f232g, f10);
        return new c(f10);
    }

    public int e() {
        return f231h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return g.k(this.f232g, ((c) obj).f232g);
    }

    public d f() {
        int[] f10 = g.f();
        b.d(b.f229a, this.f232g, f10);
        return new c(f10);
    }

    public boolean g() {
        return g.r(this.f232g);
    }

    public boolean h() {
        return g.t(this.f232g);
    }

    public int hashCode() {
        return f231h.hashCode() ^ a.p(this.f232g, 0, 8);
    }

    public d i(d dVar) {
        int[] f10 = g.f();
        b.e(this.f232g, ((c) dVar).f232g, f10);
        return new c(f10);
    }

    public d l() {
        int[] f10 = g.f();
        b.g(this.f232g, f10);
        return new c(f10);
    }

    public d m() {
        int[] iArr = this.f232g;
        if (g.t(iArr) || g.r(iArr)) {
            return this;
        }
        int[] f10 = g.f();
        b.j(iArr, f10);
        b.e(f10, iArr, f10);
        int[] f11 = g.f();
        b.k(f10, 2, f11);
        b.e(f11, f10, f11);
        int[] f12 = g.f();
        b.k(f11, 2, f12);
        b.e(f12, f10, f12);
        b.k(f12, 6, f10);
        b.e(f10, f12, f10);
        int[] f13 = g.f();
        b.k(f10, 12, f13);
        b.e(f13, f10, f13);
        b.k(f13, 6, f10);
        b.e(f10, f12, f10);
        b.j(f10, f12);
        b.e(f12, iArr, f12);
        b.k(f12, 31, f13);
        b.e(f13, f12, f10);
        b.k(f13, 32, f13);
        b.e(f13, f10, f13);
        b.k(f13, 62, f13);
        b.e(f13, f10, f13);
        b.k(f13, 4, f13);
        b.e(f13, f11, f13);
        b.k(f13, 32, f13);
        b.e(f13, iArr, f13);
        b.k(f13, 62, f13);
        b.j(f13, f11);
        if (g.k(iArr, f11)) {
            return new c(f13);
        }
        return null;
    }

    public d n() {
        int[] f10 = g.f();
        b.j(this.f232g, f10);
        return new c(f10);
    }

    public d p(d dVar) {
        int[] f10 = g.f();
        b.m(this.f232g, ((c) dVar).f232g, f10);
        return new c(f10);
    }

    public boolean q() {
        if (g.o(this.f232g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.H(this.f232g);
    }

    protected c(int[] iArr) {
        this.f232g = iArr;
    }
}
