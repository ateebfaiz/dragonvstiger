package com.geetest.core;

import java.io.IOException;

public class m1 implements t0 {

    /* renamed from: a  reason: collision with root package name */
    public x0 f6075a;

    public m1(x0 x0Var) {
        this.f6075a = x0Var;
    }

    public p0 b() throws IOException {
        return new l1(this.f6075a.b());
    }

    public p0 d() {
        try {
            return new l1(this.f6075a.b());
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }
}
