package com.geetest.core;

import java.io.IOException;

public class i2 extends w0 {

    /* renamed from: c  reason: collision with root package name */
    public int f6017c = -1;

    public i2() {
    }

    public static boolean b(boolean z10) {
        if (z10) {
            return z10;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    public int a(boolean z10) throws IOException {
        return n0.a(z10, j());
    }

    public p0 h() {
        if (this.f6202b != null) {
            return this;
        }
        return super.h();
    }

    public p0 i() {
        return this;
    }

    public final int j() throws IOException {
        if (this.f6017c < 0) {
            int i10 = 0;
            for (v d10 : this.f6201a) {
                i10 += d10.d().h().a(true);
            }
            this.f6017c = i10;
        }
        return this.f6017c;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 49);
        f2 a10 = n0Var.a();
        int length = this.f6201a.length;
        int i10 = 0;
        if (this.f6017c >= 0 || length > 16) {
            n0Var.c(j());
            while (i10 < length) {
                this.f6201a[i10].d().h().a(a10, true);
                i10++;
            }
            return;
        }
        p0[] p0VarArr = new p0[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            p0 h10 = this.f6201a[i12].d().h();
            p0VarArr[i12] = h10;
            i11 += h10.a(true);
        }
        this.f6017c = i11;
        n0Var.c(i11);
        while (i10 < length) {
            p0VarArr[i10].a(a10, true);
            i10++;
        }
    }

    public i2(boolean z10, v[] vVarArr) {
        super(b(z10), vVarArr);
    }
}
