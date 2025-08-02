package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class e1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5962a;

    public e1(byte[] bArr, boolean z10) {
        this.f5962a = z10 ? c.a(bArr) : bArr;
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f5962a.length);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f5962a);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 21, this.f5962a);
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof e1)) {
            return false;
        }
        return Arrays.equals(this.f5962a, ((e1) p0Var).f5962a);
    }
}
