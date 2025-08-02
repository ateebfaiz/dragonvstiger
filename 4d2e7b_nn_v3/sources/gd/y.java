package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.f;
import zd.a;

public class y extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f339h = w.f332i;

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f340i = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    /* renamed from: g  reason: collision with root package name */
    protected int[] f341g;

    public y(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f339h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f341g = x.c(bigInteger);
    }

    public d a(d dVar) {
        int[] d10 = f.d();
        x.a(this.f341g, ((y) dVar).f341g, d10);
        return new y(d10);
    }

    public d b() {
        int[] d10 = f.d();
        x.b(this.f341g, d10);
        return new y(d10);
    }

    public d d(d dVar) {
        int[] d10 = f.d();
        b.d(x.f336a, ((y) dVar).f341g, d10);
        x.d(d10, this.f341g, d10);
        return new y(d10);
    }

    public int e() {
        return f339h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        return f.f(this.f341g, ((y) obj).f341g);
    }

    public d f() {
        int[] d10 = f.d();
        b.d(x.f336a, this.f341g, d10);
        return new y(d10);
    }

    public boolean g() {
        return f.j(this.f341g);
    }

    public boolean h() {
        return f.k(this.f341g);
    }

    public int hashCode() {
        return f339h.hashCode() ^ a.p(this.f341g, 0, 7);
    }

    public d i(d dVar) {
        int[] d10 = f.d();
        x.d(this.f341g, ((y) dVar).f341g, d10);
        return new y(d10);
    }

    public d l() {
        int[] d10 = f.d();
        x.f(this.f341g, d10);
        return new y(d10);
    }

    public d m() {
        int[] iArr = this.f341g;
        if (f.k(iArr) || f.j(iArr)) {
            return this;
        }
        int[] d10 = f.d();
        x.i(iArr, d10);
        x.d(d10, iArr, d10);
        x.i(d10, d10);
        x.d(d10, iArr, d10);
        int[] d11 = f.d();
        x.i(d10, d11);
        x.d(d11, iArr, d11);
        int[] d12 = f.d();
        x.j(d11, 4, d12);
        x.d(d12, d11, d12);
        int[] d13 = f.d();
        x.j(d12, 3, d13);
        x.d(d13, d10, d13);
        x.j(d13, 8, d13);
        x.d(d13, d12, d13);
        x.j(d13, 4, d12);
        x.d(d12, d11, d12);
        x.j(d12, 19, d11);
        x.d(d11, d13, d11);
        int[] d14 = f.d();
        x.j(d11, 42, d14);
        x.d(d14, d11, d14);
        x.j(d14, 23, d11);
        x.d(d11, d12, d11);
        x.j(d11, 84, d12);
        x.d(d12, d14, d12);
        x.j(d12, 20, d12);
        x.d(d12, d13, d12);
        x.j(d12, 3, d12);
        x.d(d12, iArr, d12);
        x.j(d12, 2, d12);
        x.d(d12, iArr, d12);
        x.j(d12, 4, d12);
        x.d(d12, d10, d12);
        x.i(d12, d12);
        x.i(d12, d14);
        if (f.f(iArr, d14)) {
            return new y(d12);
        }
        x.d(d12, f340i, d12);
        x.i(d12, d14);
        if (f.f(iArr, d14)) {
            return new y(d12);
        }
        return null;
    }

    public d n() {
        int[] d10 = f.d();
        x.i(this.f341g, d10);
        return new y(d10);
    }

    public d p(d dVar) {
        int[] d10 = f.d();
        x.k(this.f341g, ((y) dVar).f341g, d10);
        return new y(d10);
    }

    public boolean q() {
        if (f.h(this.f341g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return f.t(this.f341g);
    }

    protected y(int[] iArr) {
        this.f341g = iArr;
    }
}
