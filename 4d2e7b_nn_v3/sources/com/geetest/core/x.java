package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public class x extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final x[] f6207a = new x[12];

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f6208b;

    public x(byte[] bArr, boolean z10) {
        byte[] bArr2;
        if (f0.a(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        } else if ((bArr[0] & 128) == 0) {
            if (z10) {
                bArr2 = c.a(bArr);
            } else {
                bArr2 = bArr;
            }
            this.f6208b = bArr2;
            f0.b(bArr);
        } else {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
    }

    public int a(boolean z10) {
        return n0.a(z10, this.f6208b.length);
    }

    public boolean g() {
        return false;
    }

    public int hashCode() {
        return c.c(this.f6208b);
    }

    public void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 10, this.f6208b);
    }

    public boolean a(p0 p0Var) {
        if (!(p0Var instanceof x)) {
            return false;
        }
        return Arrays.equals(this.f6208b, ((x) p0Var).f6208b);
    }

    public static x a(byte[] bArr, boolean z10) {
        if (bArr.length > 1) {
            return new x(bArr, z10);
        }
        if (bArr.length != 0) {
            byte b10 = bArr[0] & 255;
            x[] xVarArr = f6207a;
            if (b10 >= xVarArr.length) {
                return new x(bArr, z10);
            }
            x xVar = xVarArr[b10];
            if (xVar != null) {
                return xVar;
            }
            x xVar2 = new x(bArr, z10);
            xVarArr[b10] = xVar2;
            return xVar2;
        }
        throw new IllegalArgumentException("ENUMERATED has zero length");
    }
}
