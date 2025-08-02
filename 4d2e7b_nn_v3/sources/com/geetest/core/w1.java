package com.geetest.core;

import java.io.IOException;

public class w1 implements v, b3 {

    /* renamed from: a  reason: collision with root package name */
    public x0 f6203a;

    public w1(x0 x0Var) {
        this.f6203a = x0Var;
    }

    public p0 b() throws IOException {
        try {
            return new r2(new u2(this.f6203a.b()));
        } catch (IllegalArgumentException e10) {
            throw new y(e10.getMessage(), e10);
        }
    }

    public p0 d() {
        try {
            return b();
        } catch (IOException e10) {
            throw new o0("unable to get DER object", e10);
        } catch (IllegalArgumentException e11) {
            throw new o0("unable to get DER object", e11);
        }
    }
}
