package com.geetest.core;

import java.io.IOException;

public class l1 extends s0 {
    public l1() {
    }

    public int a(boolean z10) throws IOException {
        int i10 = z10 ? 4 : 3;
        for (v d10 : this.f6170a) {
            i10 += d10.d().a(true);
        }
        return i10;
    }

    public s n() {
        return new g1(j(), 1000);
    }

    public l0 o() {
        l0[] k10 = k();
        return new j1(j1.a(k10), k10, 1000);
    }

    public l1(v vVar) {
        super(vVar);
    }

    public l1(w wVar) {
        super(wVar);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 48, this.f6170a);
    }
}
