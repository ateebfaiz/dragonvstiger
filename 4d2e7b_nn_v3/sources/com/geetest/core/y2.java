package com.geetest.core;

import java.io.IOException;

public class y2 extends z0 {
    public y2(boolean z10, int i10, v vVar) {
        super(z10, i10, vVar);
    }

    public int a(boolean z10) throws IOException {
        p0 i10 = this.f6229d.d().i();
        boolean l10 = l();
        int a10 = i10.a(l10);
        if (l10) {
            a10 += n0.a(a10);
        }
        return a10 + (z10 ? n0.b(this.f6228c) : 0);
    }

    public s0 c(p0 p0Var) {
        return new u2((v) p0Var);
    }

    public boolean g() {
        if (l() || this.f6229d.d().i().g()) {
            return true;
        }
        return false;
    }

    public p0 i() {
        return this;
    }

    public y2(int i10, int i11, int i12, v vVar) {
        super(i10, i11, i12, vVar);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        p0 i10 = this.f6229d.d().i();
        boolean l10 = l();
        if (z10) {
            int i11 = this.f6227b;
            if (l10 || i10.g()) {
                i11 |= 32;
            }
            n0Var.a(true, i11, this.f6228c);
        }
        if (l10) {
            n0Var.c(i10.a(true));
        }
        i10.a(n0Var.b(), l10);
    }
}
