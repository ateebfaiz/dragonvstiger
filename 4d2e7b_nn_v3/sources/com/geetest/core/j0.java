package com.geetest.core;

import java.io.IOException;

public final class j0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final c0 f6038a;

    public j0(c0 c0Var) {
        this.f6038a = c0Var;
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f6038a.f5940b.length);
    }

    public boolean g() {
        return false;
    }

    public p0 h() {
        c0 c0Var = this.f6038a;
        c0Var.getClass();
        if (c0Var == this.f6038a) {
            return this;
        }
        return new j0(c0Var);
    }

    public int hashCode() {
        return ~c.c(this.f6038a.f5940b);
    }

    public p0 i() {
        c0 c0Var = this.f6038a;
        c0Var.getClass();
        if (c0Var == this.f6038a) {
            return this;
        }
        return new j0(c0Var);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.b(z10, 7);
        n0Var.a(false, 25, this.f6038a.f5940b);
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof j0)) {
            return false;
        }
        return this.f6038a.a((p0) ((j0) p0Var).f6038a);
    }
}
