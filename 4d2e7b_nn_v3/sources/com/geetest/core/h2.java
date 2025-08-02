package com.geetest.core;

import java.io.IOException;

public class h2 extends s0 {

    /* renamed from: b  reason: collision with root package name */
    public int f6008b = -1;

    public h2(v vVar) {
        super(vVar);
    }

    public int a(boolean z10) throws IOException {
        return n0.a(z10, p());
    }

    public p0 h() {
        return this;
    }

    public p0 i() {
        return this;
    }

    public s n() {
        return new u1(g1.a(j()), false);
    }

    public l0 o() {
        return new d2(j1.a(k()));
    }

    public final int p() throws IOException {
        if (this.f6008b < 0) {
            int i10 = 0;
            for (v d10 : this.f6170a) {
                i10 += d10.d().h().a(true);
            }
            this.f6008b = i10;
        }
        return this.f6008b;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 48);
        f2 a10 = n0Var.a();
        int length = this.f6170a.length;
        int i10 = 0;
        if (this.f6008b >= 0 || length > 16) {
            n0Var.c(p());
            while (i10 < length) {
                this.f6170a[i10].d().h().a(a10, true);
                i10++;
            }
            return;
        }
        p0[] p0VarArr = new p0[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            p0 h10 = this.f6170a[i12].d().h();
            p0VarArr[i12] = h10;
            i11 += h10.a(true);
        }
        this.f6008b = i11;
        n0Var.c(i11);
        while (i10 < length) {
            p0VarArr[i10].a(a10, true);
            i10++;
        }
    }

    public h2(w wVar) {
        super(wVar);
    }

    public h2(v[] vVarArr, boolean z10) {
        super(vVarArr, z10);
    }
}
