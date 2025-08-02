package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class z0 extends p0 implements v, b3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f6226a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6227b;

    /* renamed from: c  reason: collision with root package name */
    public final int f6228c;

    /* renamed from: d  reason: collision with root package name */
    public final v f6229d;

    public z0(boolean z10, int i10, v vVar) {
        this(z10, 128, i10, vVar);
    }

    public static p0 a(int i10, int i11, w wVar) {
        if (wVar.f6199c == 1) {
            return new y2(3, i10, i11, wVar.a(0));
        }
        return new y2(4, i10, i11, s2.a(wVar));
    }

    public final p0 b() {
        return this;
    }

    public abstract s0 c(p0 p0Var);

    public p0 h() {
        return new k2(this.f6226a, this.f6227b, this.f6228c, this.f6229d);
    }

    public int hashCode() {
        int i10;
        int i11 = (this.f6227b * 7919) ^ this.f6228c;
        if (l()) {
            i10 = 15;
        } else {
            i10 = 240;
        }
        return (i11 ^ i10) ^ this.f6229d.d().hashCode();
    }

    public p0 i() {
        return new y2(this.f6226a, this.f6227b, this.f6228c, this.f6229d);
    }

    public i0 j() {
        v vVar = this.f6229d;
        if (vVar instanceof i0) {
            return (i0) vVar;
        }
        return vVar.d();
    }

    public int k() {
        return this.f6228c;
    }

    public boolean l() {
        int i10 = this.f6226a;
        if (i10 == 1 || i10 == 3) {
            return true;
        }
        return false;
    }

    public String toString() {
        return c.a(this.f6227b, this.f6228c) + this.f6229d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public z0(boolean z10, int i10, int i11, v vVar) {
        this(z10 ? 1 : 2, i10, i11, vVar);
    }

    public z0(int i10, int i11, int i12, v vVar) {
        if (vVar == null) {
            throw new NullPointerException("'obj' cannot be null");
        } else if (i11 == 0 || (i11 & 192) != i11) {
            throw new IllegalArgumentException("invalid tag class: " + i11);
        } else {
            this.f6226a = i10;
            this.f6227b = i11;
            this.f6228c = i12;
            this.f6229d = vVar;
        }
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) p0Var;
        if (this.f6228c != z0Var.f6228c || this.f6227b != z0Var.f6227b) {
            return false;
        }
        if (this.f6226a != z0Var.f6226a && l() != z0Var.l()) {
            return false;
        }
        p0 d10 = this.f6229d.d();
        p0 d11 = z0Var.f6229d.d();
        if (d10 == d11) {
            return true;
        }
        if (l()) {
            return d10.a(d11);
        }
        try {
            return Arrays.equals(f(), z0Var.f());
        } catch (IOException unused) {
            return false;
        }
    }
}
