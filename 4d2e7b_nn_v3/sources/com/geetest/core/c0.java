package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class c0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final d1 f5939a = new a(c0.class, 25);

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f5940b;

    public class a extends d1 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        public p0 a(d2 d2Var) {
            return c0.a(d2Var.f6066c);
        }
    }

    public c0(byte[] bArr, boolean z10) {
        if (bArr != null) {
            this.f5940b = z10 ? c.a(bArr) : bArr;
            return;
        }
        throw new NullPointerException("'contents' cannot be null");
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f5940b.length);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f5940b);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 25, this.f5940b);
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof c0)) {
            return false;
        }
        return Arrays.equals(this.f5940b, ((c0) p0Var).f5940b);
    }

    public static c0 a(byte[] bArr) {
        return new z1(bArr, false);
    }
}
