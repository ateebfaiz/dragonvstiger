package com.geetest.core;

import java.io.IOException;

public class n1 extends w0 {
    public n1(w wVar) {
        super(wVar, false);
    }

    public int a(boolean z10) throws IOException {
        int i10 = z10 ? 4 : 3;
        for (v d10 : this.f6201a) {
            i10 += d10.d().a(true);
        }
        return i10;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 49, this.f6201a);
    }
}
