package com.geetest.core;

import java.io.InputStream;

public abstract class e3 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f5964a;

    /* renamed from: b  reason: collision with root package name */
    public int f5965b;

    public e3(InputStream inputStream, int i10) {
        this.f5964a = inputStream;
        this.f5965b = i10;
    }

    public void a(boolean z10) {
        InputStream inputStream = this.f5964a;
        if (inputStream instanceof c3) {
            c3 c3Var = (c3) inputStream;
            c3Var.f5946f = z10;
            c3Var.a();
        }
    }
}
