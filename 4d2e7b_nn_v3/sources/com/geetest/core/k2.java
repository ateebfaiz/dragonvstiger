package com.geetest.core;

import java.io.IOException;

public class k2 extends z0 {
    public k2(boolean z10, int i10, v vVar) {
        super(z10, i10, vVar);
    }

    public int a(boolean z10) throws IOException {
        p0 h10 = this.f6229d.d().h();
        boolean l10 = l();
        int a10 = h10.a(l10);
        if (l10) {
            a10 += n0.a(a10);
        }
        return a10 + (z10 ? n0.b(this.f6228c) : 0);
    }

    public s0 c(p0 p0Var) {
        return new h2((v) p0Var);
    }

    public boolean g() {
        if (l() || this.f6229d.d().h().g()) {
            return true;
        }
        return false;
    }

    public p0 h() {
        return this;
    }

    public p0 i() {
        return this;
    }

    public k2(int i10, int i11, int i12, v vVar) {
        super(i10, i11, i12, vVar);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        p0 h10 = this.f6229d.d().h();
        boolean l10 = l();
        if (z10) {
            int i10 = this.f6227b;
            if (l10 || h10.g()) {
                i10 |= 32;
            }
            n0Var.a(true, i10, this.f6228c);
        }
        if (l10) {
            n0Var.c(h10.a(true));
        }
        h10.a(n0Var.a(), l10);
    }
}
