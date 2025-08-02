package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class k1 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public x0 f6059a;

    public k1(x0 x0Var) {
        this.f6059a = x0Var;
    }

    public p0 b() throws IOException {
        return new j1(o3.a(new s1(this.f6059a)), (l0[]) null, 1000);
    }

    public InputStream c() {
        return new s1(this.f6059a);
    }

    public p0 d() {
        try {
            return new j1(o3.a(new s1(this.f6059a)), 1000);
        } catch (IOException e10) {
            throw new o0("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }
}
