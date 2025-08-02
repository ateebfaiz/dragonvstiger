package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.m;
import zd.a;

public class s0 extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f318h = q0.f310i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f319g;

    public s0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f318h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f319g = r0.c(bigInteger);
    }

    public d a(d dVar) {
        int[] i10 = m.i(17);
        r0.a(this.f319g, ((s0) dVar).f319g, i10);
        return new s0(i10);
    }

    public d b() {
        int[] i10 = m.i(17);
        r0.b(this.f319g, i10);
        return new s0(i10);
    }

    public d d(d dVar) {
        int[] i10 = m.i(17);
        b.d(r0.f314a, ((s0) dVar).f319g, i10);
        r0.f(i10, this.f319g, i10);
        return new s0(i10);
    }

    public int e() {
        return f318h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        return m.m(17, this.f319g, ((s0) obj).f319g);
    }

    public d f() {
        int[] i10 = m.i(17);
        b.d(r0.f314a, this.f319g, i10);
        return new s0(i10);
    }

    public boolean g() {
        return m.u(17, this.f319g);
    }

    public boolean h() {
        return m.v(17, this.f319g);
    }

    public int hashCode() {
        return f318h.hashCode() ^ a.p(this.f319g, 0, 17);
    }

    public d i(d dVar) {
        int[] i10 = m.i(17);
        r0.f(this.f319g, ((s0) dVar).f319g, i10);
        return new s0(i10);
    }

    public d l() {
        int[] i10 = m.i(17);
        r0.g(this.f319g, i10);
        return new s0(i10);
    }

    public d m() {
        int[] iArr = this.f319g;
        if (m.v(17, iArr) || m.u(17, iArr)) {
            return this;
        }
        int[] i10 = m.i(17);
        int[] i11 = m.i(17);
        r0.k(iArr, 519, i10);
        r0.j(i10, i11);
        if (m.m(17, iArr, i11)) {
            return new s0(i10);
        }
        return null;
    }

    public d n() {
        int[] i10 = m.i(17);
        r0.j(this.f319g, i10);
        return new s0(i10);
    }

    public d p(d dVar) {
        int[] i10 = m.i(17);
        r0.l(this.f319g, ((s0) dVar).f319g, i10);
        return new s0(i10);
    }

    public boolean q() {
        if (m.o(this.f319g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return m.O(17, this.f319g);
    }

    protected s0(int[] iArr) {
        this.f319g = iArr;
    }
}
