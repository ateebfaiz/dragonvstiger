package com.geetest.core;

public class v1 extends z {
    public v1(k0 k0Var, f0 f0Var, p0 p0Var, int i10, p0 p0Var2) {
        super(k0Var, f0Var, p0Var, i10, p0Var2);
    }

    public p0 h() {
        return this;
    }

    public p0 i() {
        return this;
    }

    public s0 j() {
        boolean z10;
        w wVar = new w(4);
        k0 k0Var = this.f6221a;
        if (k0Var != null) {
            wVar.a((v) k0Var);
        }
        f0 f0Var = this.f6222b;
        if (f0Var != null) {
            wVar.a((v) f0Var);
        }
        p0 p0Var = this.f6223c;
        if (p0Var != null) {
            wVar.a((v) p0Var.h());
        }
        int i10 = this.f6224d;
        if (i10 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        wVar.a((v) new k2(z10, i10, this.f6225e));
        return new h2(wVar);
    }
}
