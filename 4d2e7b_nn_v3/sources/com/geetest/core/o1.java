package com.geetest.core;

import java.io.IOException;

public class o1 implements v, b3 {

    /* renamed from: a  reason: collision with root package name */
    public x0 f6118a;

    public o1(x0 x0Var) {
        this.f6118a = x0Var;
    }

    public p0 b() throws IOException {
        return new n1(this.f6118a.b());
    }

    public p0 d() {
        try {
            return new n1(this.f6118a.b());
        } catch (IOException e10) {
            throw new o0(e10.getMessage(), e10);
        }
    }
}
