package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class e2 implements m0 {

    /* renamed from: a  reason: collision with root package name */
    public a3 f5963a;

    public e2(a3 a3Var) {
        this.f5963a = a3Var;
    }

    public p0 b() throws IOException {
        return new d2(this.f5963a.a());
    }

    public InputStream c() {
        return this.f5963a;
    }

    public p0 d() {
        try {
            return new d2(this.f5963a.a());
        } catch (IOException e10) {
            throw new o0("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }
}
