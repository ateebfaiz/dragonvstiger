package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.m;
import zd.a;

public class o0 extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f301h = m0.f292i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f302g;

    public o0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f301h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f302g = n0.e(bigInteger);
    }

    public d a(d dVar) {
        int[] i10 = m.i(12);
        n0.a(this.f302g, ((o0) dVar).f302g, i10);
        return new o0(i10);
    }

    public d b() {
        int[] i10 = m.i(12);
        n0.c(this.f302g, i10);
        return new o0(i10);
    }

    public d d(d dVar) {
        int[] i10 = m.i(12);
        b.d(n0.f296a, ((o0) dVar).f302g, i10);
        n0.f(i10, this.f302g, i10);
        return new o0(i10);
    }

    public int e() {
        return f301h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        return m.m(12, this.f302g, ((o0) obj).f302g);
    }

    public d f() {
        int[] i10 = m.i(12);
        b.d(n0.f296a, this.f302g, i10);
        return new o0(i10);
    }

    public boolean g() {
        return m.u(12, this.f302g);
    }

    public boolean h() {
        return m.v(12, this.f302g);
    }

    public int hashCode() {
        return f301h.hashCode() ^ a.p(this.f302g, 0, 12);
    }

    public d i(d dVar) {
        int[] i10 = m.i(12);
        n0.f(this.f302g, ((o0) dVar).f302g, i10);
        return new o0(i10);
    }

    public d l() {
        int[] i10 = m.i(12);
        n0.g(this.f302g, i10);
        return new o0(i10);
    }

    public d m() {
        int[] iArr = this.f302g;
        if (m.v(12, iArr) || m.u(12, iArr)) {
            return this;
        }
        int[] i10 = m.i(12);
        int[] i11 = m.i(12);
        int[] i12 = m.i(12);
        int[] i13 = m.i(12);
        n0.j(iArr, i10);
        n0.f(i10, iArr, i10);
        n0.k(i10, 2, i11);
        n0.f(i11, i10, i11);
        n0.j(i11, i11);
        n0.f(i11, iArr, i11);
        n0.k(i11, 5, i12);
        n0.f(i12, i11, i12);
        n0.k(i12, 5, i13);
        n0.f(i13, i11, i13);
        n0.k(i13, 15, i11);
        n0.f(i11, i13, i11);
        n0.k(i11, 2, i12);
        n0.f(i10, i12, i10);
        n0.k(i12, 28, i12);
        n0.f(i11, i12, i11);
        n0.k(i11, 60, i12);
        n0.f(i12, i11, i12);
        n0.k(i12, 120, i11);
        n0.f(i11, i12, i11);
        n0.k(i11, 15, i11);
        n0.f(i11, i13, i11);
        n0.k(i11, 33, i11);
        n0.f(i11, i10, i11);
        n0.k(i11, 64, i11);
        n0.f(i11, iArr, i11);
        n0.k(i11, 30, i10);
        n0.j(i10, i11);
        if (m.m(12, iArr, i11)) {
            return new o0(i10);
        }
        return null;
    }

    public d n() {
        int[] i10 = m.i(12);
        n0.j(this.f302g, i10);
        return new o0(i10);
    }

    public d p(d dVar) {
        int[] i10 = m.i(12);
        n0.m(this.f302g, ((o0) dVar).f302g, i10);
        return new o0(i10);
    }

    public boolean q() {
        if (m.o(this.f302g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return m.O(12, this.f302g);
    }

    protected o0(int[] iArr) {
        this.f302g = iArr;
    }
}
