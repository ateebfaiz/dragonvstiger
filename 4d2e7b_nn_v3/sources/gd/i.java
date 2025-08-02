package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import zd.a;

public class i extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f273h = g.f263i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f274g;

    public i(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f273h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.f274g = h.c(bigInteger);
    }

    public d a(d dVar) {
        int[] c10 = jd.d.c();
        h.a(this.f274g, ((i) dVar).f274g, c10);
        return new i(c10);
    }

    public d b() {
        int[] c10 = jd.d.c();
        h.b(this.f274g, c10);
        return new i(c10);
    }

    public d d(d dVar) {
        int[] c10 = jd.d.c();
        b.d(h.f269a, ((i) dVar).f274g, c10);
        h.d(c10, this.f274g, c10);
        return new i(c10);
    }

    public int e() {
        return f273h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        return jd.d.e(this.f274g, ((i) obj).f274g);
    }

    public d f() {
        int[] c10 = jd.d.c();
        b.d(h.f269a, this.f274g, c10);
        return new i(c10);
    }

    public boolean g() {
        return jd.d.i(this.f274g);
    }

    public boolean h() {
        return jd.d.j(this.f274g);
    }

    public int hashCode() {
        return f273h.hashCode() ^ a.p(this.f274g, 0, 5);
    }

    public d i(d dVar) {
        int[] c10 = jd.d.c();
        h.d(this.f274g, ((i) dVar).f274g, c10);
        return new i(c10);
    }

    public d l() {
        int[] c10 = jd.d.c();
        h.f(this.f274g, c10);
        return new i(c10);
    }

    public d m() {
        int[] iArr = this.f274g;
        if (jd.d.j(iArr) || jd.d.i(iArr)) {
            return this;
        }
        int[] c10 = jd.d.c();
        h.i(iArr, c10);
        h.d(c10, iArr, c10);
        int[] c11 = jd.d.c();
        h.j(c10, 2, c11);
        h.d(c11, c10, c11);
        h.j(c11, 4, c10);
        h.d(c10, c11, c10);
        h.j(c10, 8, c11);
        h.d(c11, c10, c11);
        h.j(c11, 16, c10);
        h.d(c10, c11, c10);
        h.j(c10, 32, c11);
        h.d(c11, c10, c11);
        h.j(c11, 64, c10);
        h.d(c10, c11, c10);
        h.i(c10, c11);
        h.d(c11, iArr, c11);
        h.j(c11, 29, c11);
        h.i(c11, c10);
        if (jd.d.e(iArr, c10)) {
            return new i(c11);
        }
        return null;
    }

    public d n() {
        int[] c10 = jd.d.c();
        h.i(this.f274g, c10);
        return new i(c10);
    }

    public d p(d dVar) {
        int[] c10 = jd.d.c();
        h.k(this.f274g, ((i) dVar).f274g, c10);
        return new i(c10);
    }

    public boolean q() {
        if (jd.d.g(this.f274g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return jd.d.t(this.f274g);
    }

    protected i(int[] iArr) {
        this.f274g = iArr;
    }
}
