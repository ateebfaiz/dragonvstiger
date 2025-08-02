package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public class b0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5933a;

    public b0(byte[] bArr) {
        if (bArr.length >= 4) {
            this.f5933a = bArr;
            if (!a(0) || !a(1) || !a(2) || !a(3)) {
                throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
            }
            return;
        }
        throw new IllegalArgumentException("GeneralizedTime string too short");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r3 = r0[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r3) {
        /*
            r2 = this;
            byte[] r0 = r2.f5933a
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
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.core.b0.a(int):boolean");
    }

    public final boolean g() {
        return false;
    }

    public p0 h() {
        return new y1(this.f5933a);
    }

    public int hashCode() {
        return c.c(this.f5933a);
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f5933a.length);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 24, this.f5933a);
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof b0)) {
            return false;
        }
        return Arrays.equals(this.f5933a, ((b0) p0Var).f5933a);
    }
}
