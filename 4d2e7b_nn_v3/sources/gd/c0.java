package gd;

import dd.d;
import java.math.BigInteger;
import jd.b;
import jd.f;
import jd.m;
import zd.a;

public class c0 extends d {

    /* renamed from: h  reason: collision with root package name */
    public static final BigInteger f249h = a0.f236i;

    /* renamed from: g  reason: collision with root package name */
    protected int[] f250g;

    public c0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f249h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f250g = b0.d(bigInteger);
    }

    private static void s(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        b0.e(iArr5, iArr3, iArr7);
        b0.e(iArr7, iArr, iArr7);
        b0.e(iArr4, iArr2, iArr6);
        b0.a(iArr6, iArr7, iArr6);
        b0.e(iArr4, iArr3, iArr7);
        f.c(iArr6, iArr4);
        b0.e(iArr5, iArr2, iArr5);
        b0.a(iArr5, iArr7, iArr5);
        b0.j(iArr5, iArr6);
        b0.e(iArr6, iArr, iArr6);
    }

    private static void t(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        f.c(iArr, iArr4);
        int[] d10 = f.d();
        int[] d11 = f.d();
        for (int i10 = 0; i10 < 7; i10++) {
            f.c(iArr2, d10);
            f.c(iArr3, d11);
            int i11 = 1 << i10;
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                }
                u(iArr2, iArr3, iArr4, iArr5);
            }
            s(iArr, d10, d11, iArr2, iArr3, iArr4, iArr5);
        }
    }

    private static void u(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        b0.e(iArr2, iArr, iArr2);
        b0.n(iArr2, iArr2);
        b0.j(iArr, iArr4);
        b0.a(iArr3, iArr4, iArr);
        b0.e(iArr3, iArr4, iArr3);
        b0.i(m.F(7, iArr3, 2, 0), iArr3);
    }

    private static boolean v(int[] iArr) {
        int[] d10 = f.d();
        int[] d11 = f.d();
        f.c(iArr, d10);
        for (int i10 = 0; i10 < 7; i10++) {
            f.c(d10, d11);
            b0.k(d10, 1 << i10, d10);
            b0.e(d10, d11, d10);
        }
        b0.k(d10, 95, d10);
        return f.j(d10);
    }

    private static boolean w(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] d10 = f.d();
        f.c(iArr2, d10);
        int[] d11 = f.d();
        d11[0] = 1;
        int[] d12 = f.d();
        t(iArr, d10, d11, d12, iArr3);
        int[] d13 = f.d();
        int[] d14 = f.d();
        for (int i10 = 1; i10 < 96; i10++) {
            f.c(d10, d13);
            f.c(d11, d14);
            u(d10, d11, d12, iArr3);
            if (f.k(d10)) {
                b.d(b0.f242a, d14, iArr3);
                b0.e(iArr3, d13, iArr3);
                return true;
            }
        }
        return false;
    }

    public d a(d dVar) {
        int[] d10 = f.d();
        b0.a(this.f250g, ((c0) dVar).f250g, d10);
        return new c0(d10);
    }

    public d b() {
        int[] d10 = f.d();
        b0.b(this.f250g, d10);
        return new c0(d10);
    }

    public d d(d dVar) {
        int[] d10 = f.d();
        b.d(b0.f242a, ((c0) dVar).f250g, d10);
        b0.e(d10, this.f250g, d10);
        return new c0(d10);
    }

    public int e() {
        return f249h.bitLength();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        return f.f(this.f250g, ((c0) obj).f250g);
    }

    public d f() {
        int[] d10 = f.d();
        b.d(b0.f242a, this.f250g, d10);
        return new c0(d10);
    }

    public boolean g() {
        return f.j(this.f250g);
    }

    public boolean h() {
        return f.k(this.f250g);
    }

    public int hashCode() {
        return f249h.hashCode() ^ a.p(this.f250g, 0, 7);
    }

    public d i(d dVar) {
        int[] d10 = f.d();
        b0.e(this.f250g, ((c0) dVar).f250g, d10);
        return new c0(d10);
    }

    public d l() {
        int[] d10 = f.d();
        b0.g(this.f250g, d10);
        return new c0(d10);
    }

    public d m() {
        int[] iArr = this.f250g;
        if (f.k(iArr) || f.j(iArr)) {
            return this;
        }
        int[] d10 = f.d();
        b0.g(iArr, d10);
        int[] e10 = b.e(b0.f242a);
        int[] d11 = f.d();
        if (!v(iArr)) {
            return null;
        }
        while (!w(d10, e10, d11)) {
            b0.b(e10, e10);
        }
        b0.j(d11, e10);
        if (f.f(iArr, e10)) {
            return new c0(d11);
        }
        return null;
    }

    public d n() {
        int[] d10 = f.d();
        b0.j(this.f250g, d10);
        return new c0(d10);
    }

    public d p(d dVar) {
        int[] d10 = f.d();
        b0.m(this.f250g, ((c0) dVar).f250g, d10);
        return new c0(d10);
    }

    public boolean q() {
        if (f.h(this.f250g, 0) == 1) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return f.t(this.f250g);
    }

    protected c0(int[] iArr) {
        this.f250g = iArr;
    }
}
