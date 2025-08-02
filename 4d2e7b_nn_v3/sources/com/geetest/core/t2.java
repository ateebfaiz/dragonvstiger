package com.geetest.core;

import java.io.IOException;
import java.io.OutputStream;

public class t2 extends n0 {
    public t2(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(v[] vVarArr) throws IOException {
        for (v d10 : vVarArr) {
            d10.d().i().a(this, true);
        }
    }

    public t2 b() {
        return this;
    }

    public void a(p0 p0Var, boolean z10) throws IOException {
        p0Var.i().a(this, z10);
    }

    public void a(p0[] p0VarArr) throws IOException {
        for (p0 i10 : p0VarArr) {
            i10.i().a(this, true);
        }
    }
}
