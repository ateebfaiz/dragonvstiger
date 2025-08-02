package com.geetest.core;

import java.io.IOException;

public class u1 extends s {
    public u1(byte[] bArr, boolean z10) {
        super(bArr, z10);
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f6169c.length);
    }

    public boolean g() {
        return false;
    }

    public p0 h() {
        return this;
    }

    public p0 i() {
        return this;
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        byte[] bArr = this.f6169c;
        int length = bArr.length;
        int i10 = length - 1;
        byte b10 = bArr[i10];
        byte b11 = (byte) ((255 << (bArr[0] & 255)) & b10);
        if (b10 == b11) {
            n0Var.a(z10, 3, bArr);
            return;
        }
        n0Var.b(z10, 3);
        n0Var.c(length);
        n0Var.f6110a.write(bArr, 0, i10);
        n0Var.f6110a.write(b11);
    }
}
