package com.geetest.core;

import java.io.IOException;
import java.io.InputStream;

public class h1 implements t {

    /* renamed from: a  reason: collision with root package name */
    public x0 f6006a;

    /* renamed from: b  reason: collision with root package name */
    public r1 f6007b;

    public h1(x0 x0Var) {
        this.f6006a = x0Var;
    }

    public InputStream a() throws IOException {
        r1 r1Var = new r1(this.f6006a, false);
        this.f6007b = r1Var;
        return r1Var;
    }

    public p0 b() throws IOException {
        r1 r1Var = new r1(this.f6006a, false);
        return new g1(o3.a(r1Var), r1Var.f6155d, 1000);
    }

    public p0 d() {
        try {
            r1 r1Var = new r1(this.f6006a, false);
            return new g1(o3.a(r1Var), r1Var.f6155d, 1000);
        } catch (IOException e10) {
            throw new o0("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }

    public int e() {
        return this.f6007b.f6155d;
    }
}
