package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import zd.a;

public class m extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f290h = k.f281i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f291g;

    public m(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f290h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.f291g = l.c(bigInteger);
    }

    public d a(d dVar) {
        int[] c10 = jd.d.c();
        l.a(this.f291g, ((m) dVar).f291g, c10);
        return new m(c10);
    }

    public d b() {
        int[] c10 = jd.d.c();
        l.b(this.f291g, c10);
        return new m(c10);
    }

    public d d(d dVar) {
        int[] c10 = jd.d.c();
        b.d(l.f286a, ((m) dVar).f291g, c10);
        l.d(c10, this.f291g, c10);
        return new m(c10);
    }

    public int e() {
        return f290h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        return jd.d.e(this.f291g, ((m) obj).f291g);
    }

    public d f() {
        int[] c10 = jd.d.c();
        b.d(l.f286a, this.f291g, c10);
        return new m(c10);
    }

    public boolean g() {
        return jd.d.i(this.f291g);
    }

    public boolean h() {
        return jd.d.j(this.f291g);
    }

    public int hashCode() {
        return f290h.hashCode() ^ a.p(this.f291g, 0, 5);
    }

    public d i(d dVar) {
        int[] c10 = jd.d.c();
        l.d(this.f291g, ((m) dVar).f291g, c10);
        return new m(c10);
    }

    public d l() {
        int[] c10 = jd.d.c();
        l.f(this.f291g, c10);
        return new m(c10);
    }

    public d m() {
        int[] iArr = this.f291g;
        if (jd.d.j(iArr) || jd.d.i(iArr)) {
            return this;
        }
        int[] c10 = jd.d.c();
        l.i(iArr, c10);
        l.d(c10, iArr, c10);
        int[] c11 = jd.d.c();
        l.i(c10, c11);
        l.d(c11, iArr, c11);
        int[] c12 = jd.d.c();
        l.i(c11, c12);
        l.d(c12, iArr, c12);
        int[] c13 = jd.d.c();
        l.j(c12, 3, c13);
        l.d(c13, c11, c13);
        l.j(c13, 7, c12);
        l.d(c12, c13, c12);
        l.j(c12, 3, c13);
        l.d(c13, c11, c13);
        int[] c14 = jd.d.c();
        l.j(c13, 14, c14);
        l.d(c14, c12, c14);
        l.j(c14, 31, c12);
        l.d(c12, c14, c12);
        l.j(c12, 62, c14);
        l.d(c14, c12, c14);
        l.j(c14, 3, c12);
        l.d(c12, c11, c12);
        l.j(c12, 18, c12);
        l.d(c12, c13, c12);
        l.j(c12, 2, c12);
        l.d(c12, iArr, c12);
        l.j(c12, 3, c12);
        l.d(c12, c10, c12);
        l.j(c12, 6, c12);
        l.d(c12, c11, c12);
        l.j(c12, 2, c12);
        l.d(c12, iArr, c12);
        l.i(c12, c10);
        if (jd.d.e(iArr, c10)) {
            return new m(c12);
        }
        return null;
    }

    public d n() {
        int[] c10 = jd.d.c();
        l.i(this.f291g, c10);
        return new m(c10);
    }

    public d p(d dVar) {
        int[] c10 = jd.d.c();
        l.k(this.f291g, ((m) dVar).f291g, c10);
        return new m(c10);
    }

    public boolean q() {
        if (jd.d.g(this.f291g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return jd.d.t(this.f291g);
    }

    protected m(int[] iArr) {
        this.f291g = iArr;
    }
}
