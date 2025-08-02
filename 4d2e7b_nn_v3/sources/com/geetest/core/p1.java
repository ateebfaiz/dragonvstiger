package com.geetest.core;

import java.io.IOException;

public class p1 extends z0 {
    public p1(int i10, int i11, int i12, v vVar) {
        super(i10, i11, i12, vVar);
    }

    public int a(boolean z10) throws IOException {
        p0 d10 = this.f6229d.d();
        boolean l10 = l();
        int a10 = d10.a(l10);
        if (l10) {
            a10 += 3;
        }
        return a10 + (z10 ? n0.b(this.f6228c) : 0);
    }

    public s0 c(p0 p0Var) {
        return new l1((v) p0Var);
    }

    public boolean g() {
        if (l() || this.f6229d.d().g()) {
            return true;
        }
        return false;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        p0 d10 = this.f6229d.d();
        boolean l10 = l();
        if (z10) {
            int i10 = this.f6227b;
            if (l10 || d10.g()) {
                i10 |= 32;
            }
            n0Var.a(true, i10, this.f6228c);
        }
        if (l10) {
            n0Var.f6110a.write(128);
            d10.a(n0Var, true);
            n0Var.f6110a.write(0);
            n0Var.f6110a.write(0);
            return;
        }
        d10.a(n0Var, false);
    }
}
