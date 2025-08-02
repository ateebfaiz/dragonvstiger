package com.geetest.core;

import java.io.IOException;

public class w2 extends w0 {

    /* renamed from: c  reason: collision with root package name */
    public int f6204c = -1;

    public w2() {
    }

    public int a(boolean z10) throws IOException {
        return n0.a(z10, j());
    }

    public p0 i() {
        return this;
    }

    public final int j() throws IOException {
        if (this.f6204c < 0) {
            int i10 = 0;
            for (v d10 : this.f6201a) {
                i10 += d10.d().i().a(true);
            }
            this.f6204c = i10;
        }
        return this.f6204c;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 49);
        t2 b10 = n0Var.b();
        int length = this.f6201a.length;
        int i10 = 0;
        if (this.f6204c >= 0 || length > 16) {
            n0Var.c(j());
            while (i10 < length) {
                b10.a(this.f6201a[i10].d(), true);
                i10++;
            }
            return;
        }
        p0[] p0VarArr = new p0[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            p0 i13 = this.f6201a[i12].d().i();
            p0VarArr[i12] = i13;
            i11 += i13.a(true);
        }
        this.f6204c = i11;
        n0Var.c(i11);
        while (i10 < length) {
            b10.a(p0VarArr[i10], true);
            i10++;
        }
    }

    public w2(w wVar) {
        super(wVar, false);
    }

    public w2(v[] vVarArr, v[] vVarArr2) {
        super(vVarArr, vVarArr2);
    }
}
