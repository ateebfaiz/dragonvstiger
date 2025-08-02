package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class d0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5950a;

    public d0(byte[] bArr, boolean z10) {
        this.f5950a = z10 ? c.a(bArr) : bArr;
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f5950a.length);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f5950a);
    }

    public String toString() {
        return j3.a(this.f5950a);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 22, this.f5950a);
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof d0)) {
            return false;
        }
        return Arrays.equals(this.f5950a, ((d0) p0Var).f5950a);
    }
}
