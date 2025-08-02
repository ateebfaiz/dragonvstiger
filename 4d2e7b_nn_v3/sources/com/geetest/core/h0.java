package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class h0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f6005a;

    public h0(byte[] bArr, boolean z10) {
        this.f6005a = z10 ? c.a(bArr) : bArr;
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f6005a.length);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f6005a);
    }

    public String toString() {
        return j3.a(this.f6005a);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 18, this.f6005a);
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof h0)) {
            return false;
        }
        return Arrays.equals(this.f6005a, ((h0) p0Var).f6005a);
    }
}
