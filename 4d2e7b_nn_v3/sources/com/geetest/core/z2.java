package com.geetest.core;

import java.io.IOException;

public class z2 extends q1 {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f6230d;

    public z2(int i10, int i11, boolean z10, x0 x0Var) {
        super(i10, i11, x0Var);
        this.f6230d = z10;
    }

    public p0 b() throws IOException {
        x0 x0Var = this.f6144c;
        int i10 = this.f6142a;
        int i11 = this.f6143b;
        if (!this.f6230d) {
            return new y2(4, i10, i11, new d2(((a3) x0Var.f6209a).a()));
        }
        return z0.a(i10, i11, x0Var.b());
    }
}
