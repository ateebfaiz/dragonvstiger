package com.geetest.core;

import java.io.IOException;

public class v2 implements t0 {

    /* renamed from: a  reason: collision with root package name */
    public x0 f6194a;

    public v2(x0 x0Var) {
        this.f6194a = x0Var;
    }

    public p0 b() throws IOException {
        return s2.a(this.f6194a.b());
    }

    public p0 d() {
        try {
            return s2.a(this.f6194a.b());
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }
}
