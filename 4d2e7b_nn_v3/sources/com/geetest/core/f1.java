package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class f1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5973a;

    public f1(byte[] bArr, boolean z10) {
        this.f5973a = z10 ? c.a(bArr) : bArr;
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f5973a.length);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f5973a);
    }

    public String toString() {
        return j3.a(this.f5973a);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 26, this.f5973a);
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof f1)) {
            return false;
        }
        return Arrays.equals(this.f5973a, ((f1) p0Var).f5973a);
    }
}
