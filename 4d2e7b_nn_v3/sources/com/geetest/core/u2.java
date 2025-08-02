package com.geetest.core;

import java.io.IOException;

public class u2 extends s0 {

    /* renamed from: b  reason: collision with root package name */
    public int f6189b = -1;

    public u2() {
    }

    public int a(boolean z10) throws IOException {
        return n0.a(z10, p());
    }

    public p0 i() {
        return this;
    }

    public s n() {
        return new p2(g1.a(j()), false);
    }

    public l0 o() {
        return new d2(j1.a(k()));
    }

    public final int p() throws IOException {
        if (this.f6189b < 0) {
            int i10 = 0;
            for (v d10 : this.f6170a) {
                i10 += d10.d().i().a(true);
            }
            this.f6189b = i10;
        }
        return this.f6189b;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 48);
        t2 b10 = n0Var.b();
        int length = this.f6170a.length;
        int i10 = 0;
        if (this.f6189b >= 0 || length > 16) {
            n0Var.c(p());
            while (i10 < length) {
                b10.a(this.f6170a[i10].d(), true);
                i10++;
            }
            return;
        }
        p0[] p0VarArr = new p0[length];
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            p0 i13 = this.f6170a[i12].d().i();
            p0VarArr[i12] = i13;
            i11 += i13.a(true);
        }
        this.f6189b = i11;
        n0Var.c(i11);
        while (i10 < length) {
            b10.a(p0VarArr[i10], true);
            i10++;
        }
    }

    public u2(v vVar) {
        super(vVar);
    }

    public u2(w wVar) {
        super(wVar);
    }

    public u2(v[] vVarArr, boolean z10) {
        super(vVarArr, z10);
    }
}
