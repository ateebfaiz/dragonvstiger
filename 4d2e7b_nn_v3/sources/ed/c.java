package ed;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.g;
import zd.a;

public class c extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f224h = a.f220i;

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f225i = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};

    /* renamed from: g  reason: collision with root package name */
    protected int[] f226g;

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f224h) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.f226g = b.d(bigInteger);
    }

    public d a(d dVar) {
        int[] f10 = g.f();
        b.a(this.f226g, ((c) dVar).f226g, f10);
        return new c(f10);
    }

    public d b() {
        int[] f10 = g.f();
        b.b(this.f226g, f10);
        return new c(f10);
    }

    public d d(d dVar) {
        int[] f10 = g.f();
        b.d(b.f222a, ((c) dVar).f226g, f10);
        b.e(f10, this.f226g, f10);
        return new c(f10);
    }

    public int e() {
        return f224h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return g.k(this.f226g, ((c) obj).f226g);
    }

    public d f() {
        int[] f10 = g.f();
        b.d(b.f222a, this.f226g, f10);
        return new c(f10);
    }

    public boolean g() {
        return g.r(this.f226g);
    }

    public boolean h() {
        return g.t(this.f226g);
    }

    public int hashCode() {
        return f224h.hashCode() ^ a.p(this.f226g, 0, 8);
    }

    public d i(d dVar) {
        int[] f10 = g.f();
        b.e(this.f226g, ((c) dVar).f226g, f10);
        return new c(f10);
    }

    public d l() {
        int[] f10 = g.f();
        b.g(this.f226g, f10);
        return new c(f10);
    }

    public d m() {
        int[] iArr = this.f226g;
        if (g.t(iArr) || g.r(iArr)) {
            return this;
        }
        int[] f10 = g.f();
        b.j(iArr, f10);
        b.e(f10, iArr, f10);
        b.j(f10, f10);
        b.e(f10, iArr, f10);
        int[] f11 = g.f();
        b.j(f10, f11);
        b.e(f11, iArr, f11);
        int[] f12 = g.f();
        b.k(f11, 3, f12);
        b.e(f12, f10, f12);
        b.k(f12, 4, f10);
        b.e(f10, f11, f10);
        b.k(f10, 4, f12);
        b.e(f12, f11, f12);
        b.k(f12, 15, f11);
        b.e(f11, f12, f11);
        b.k(f11, 30, f12);
        b.e(f12, f11, f12);
        b.k(f12, 60, f11);
        b.e(f11, f12, f11);
        b.k(f11, 11, f12);
        b.e(f12, f10, f12);
        b.k(f12, 120, f10);
        b.e(f10, f11, f10);
        b.j(f10, f10);
        b.j(f10, f11);
        if (g.k(iArr, f11)) {
            return new c(f10);
        }
        b.e(f10, f225i, f10);
        b.j(f10, f11);
        if (g.k(iArr, f11)) {
            return new c(f10);
        }
        return null;
    }

    public d n() {
        int[] f10 = g.f();
        b.j(this.f226g, f10);
        return new c(f10);
    }

    public d p(d dVar) {
        int[] f10 = g.f();
        b.n(this.f226g, ((c) dVar).f226g, f10);
        return new c(f10);
    }

    public boolean q() {
        if (g.o(this.f226g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return g.H(this.f226g);
    }

    public c() {
        this.f226g = g.f();
    }

    protected c(int[] iArr) {
        this.f226g = iArr;
    }
}
