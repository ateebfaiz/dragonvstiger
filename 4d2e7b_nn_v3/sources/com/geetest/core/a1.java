package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public class a1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5900a;

    public a1(byte[] bArr) {
        if (bArr.length >= 2) {
            this.f5900a = bArr;
            if (!a(0) || !a(1)) {
                throw new IllegalArgumentException("illegal characters in UTCTime string");
            }
            return;
        }
        throw new IllegalArgumentException("UTCTime string too short");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r3 = r0[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r3) {
        /*
            r2 = this;
            byte[] r0 = r2.f5900a
            int r1 = r0.length
            if (r1 <= r3) goto L_0x0011
            byte r3 = r0[r3]
            r0 = 48
            if (r3 < r0) goto L_0x0011
            r0 = 57
            if (r3 > r0) goto L_0x0011
            r3 = 1
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.a1.a(int):boolean");
    }

    public final boolean g() {
        return false;
    }

    public int hashCode() {
        return c.c(this.f5900a);
    }

    public String toString() {
        return j3.a(this.f5900a);
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f5900a.length);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 23, this.f5900a);
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof a1)) {
            return false;
        }
        return Arrays.equals(this.f5900a, ((a1) p0Var).f5900a);
    }
}
