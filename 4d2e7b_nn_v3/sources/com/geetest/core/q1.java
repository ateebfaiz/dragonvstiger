package com.geetest.core;

import java.io.IOException;

public class q1 implements v, b3 {

    /* renamed from: a  reason: collision with root package name */
    public final int f6142a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6143b;

    /* renamed from: c  reason: collision with root package name */
    public final x0 f6144c;

    public q1(int i10, int i11, x0 x0Var) {
        this.f6142a = i10;
        this.f6143b = i11;
        this.f6144c = x0Var;
    }

    public p0 b() throws IOException {
        return this.f6144c.a(this.f6142a, this.f6143b);
    }

    public p0 d() {
        try {
            return b();
        } catch (IOException e10) {
            throw new o0(e10.getMessage());
        }
    }
}
