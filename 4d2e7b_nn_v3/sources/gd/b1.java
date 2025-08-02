package gd;

import dd.d;
import java.math.BigInteger;
import jd.e;
import jd.m;
import zd.a;

public class b1 extends d {

    /* renamed from: g  reason: collision with root package name */
    protected long[] f245g;

    public b1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f245g = a1.d(bigInteger);
    }

    public d a(d dVar) {
        long[] f10 = e.f();
        a1.a(this.f245g, ((b1) dVar).f245g, f10);
        return new b1(f10);
    }

    public d b() {
        long[] f10 = e.f();
        a1.c(this.f245g, f10);
        return new b1(f10);
    }

    public d d(d dVar) {
        return i(dVar.f());
    }

    public int e() {
        return 131;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        return e.k(this.f245g, ((b1) obj).f245g);
    }

    public d f() {
        long[] f10 = e.f();
        a1.i(this.f245g, f10);
        return new b1(f10);
    }

    public boolean g() {
        return e.r(this.f245g);
    }

    public boolean h() {
        return e.t(this.f245g);
    }

    public int hashCode() {
        return a.q(this.f245g, 0, 3) ^ 131832;
    }

    public d i(d dVar) {
        long[] f10 = e.f();
        a1.j(this.f245g, ((b1) dVar).f245g, f10);
        return new b1(f10);
    }

    public d j(d dVar, d dVar2, d dVar3) {
        return k(dVar, dVar2, dVar3);
    }

    public d k(d dVar, d dVar2, d dVar3) {
        long[] jArr = this.f245g;
        long[] jArr2 = ((b1) dVar).f245g;
        long[] jArr3 = ((b1) dVar2).f245g;
        long[] jArr4 = ((b1) dVar3).f245g;
        long[] j10 = m.j(5);
        a1.k(jArr, jArr2, j10);
        a1.k(jArr3, jArr4, j10);
        long[] f10 = e.f();
        a1.l(j10, f10);
        return new b1(f10);
    }

    public d l() {
        return this;
    }

    public d m() {
        long[] f10 = e.f();
        a1.n(this.f245g, f10);
        return new b1(f10);
    }

    public d n() {
        long[] f10 = e.f();
        a1.o(this.f245g, f10);
        return new b1(f10);
    }

    public d o(d dVar, d dVar2) {
        long[] jArr = this.f245g;
        long[] jArr2 = ((b1) dVar).f245g;
        long[] jArr3 = ((b1) dVar2).f245g;
        long[] j10 = m.j(5);
        a1.p(jArr, j10);
        a1.k(jArr2, jArr3, j10);
        long[] f10 = e.f();
        a1.l(j10, f10);
        return new b1(f10);
    }

    public d p(d dVar) {
        return a(dVar);
    }

    public boolean q() {
        if ((this.f245g[0] & 1) != 0) {
            return true;
        }
        return false;
    }

    public BigInteger r() {
        return e.G(this.f245g);
    }

    protected b1(long[] jArr) {
        this.f245g = jArr;
    }
}
