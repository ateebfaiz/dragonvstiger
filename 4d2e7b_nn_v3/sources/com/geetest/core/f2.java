package com.geetest.core;

import java.io.IOException;
import java.io.OutputStream;

public class f2 extends t2 {
    public f2(OutputStream outputStream) {
        super(outputStream);
    }

    public f2 a() {
        return this;
    }

    public void a(v[] vVarArr) throws IOException {
        for (v d10 : vVarArr) {
            d10.d().h().a(this, true);
        }
    }

    public void a(p0 p0Var, boolean z10) throws IOException {
        p0Var.h().a(this, z10);
    }

    public void a(p0[] p0VarArr) throws IOException {
        for (p0 h10 : p0VarArr) {
            h10.h().a(this, true);
        }
    }
}
