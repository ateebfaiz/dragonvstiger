package com.geetest.core;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class f0 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5972a;

    public f0(byte[] bArr, boolean z10) {
        byte[] bArr2;
        if (!a(bArr)) {
            if (z10) {
                bArr2 = c.a(bArr);
            } else {
                bArr2 = bArr;
            }
            this.f5972a = bArr2;
            b(bArr);
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }

    public static int b(byte[] bArr) {
        int length = bArr.length - 1;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (bArr[i10] != (bArr[i11] >> 7)) {
                break;
            }
            i10 = i11;
        }
        return i10;
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f5972a.length);
    }

    public boolean g() {
        return false;
    }

    public int hashCode() {
        return c.c(this.f5972a);
    }

    public BigInteger j() {
        return new BigInteger(this.f5972a);
    }

    public String toString() {
        return j().toString();
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 2, this.f5972a);
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof f0)) {
            return false;
        }
        return Arrays.equals(this.f5972a, ((f0) p0Var).f5972a);
    }

    public static boolean a(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return true;
        }
        if (length == 1) {
            return false;
        }
        if (bArr[0] != (bArr[1] >> 7) || i3.a("com.geetest.core.asn1.allow_unsafe_integer")) {
            return false;
        }
        return true;
    }
}
