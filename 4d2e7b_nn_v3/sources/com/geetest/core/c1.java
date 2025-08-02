package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;

public abstract class c1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f5941a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f5942b;

    public c1(byte[] bArr, boolean z10) {
        this.f5942b = z10 ? c.a(bArr) : bArr;
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f5942b.length);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f5942b);
    }

    public String toString() {
        int i10;
        StringBuffer stringBuffer = new StringBuffer(((n0.a(r0) + r0) * 2) + 3);
        stringBuffer.append("#1C");
        if (r0 < 128) {
            a(stringBuffer, r0);
        } else {
            byte[] bArr = new byte[5];
            int i11 = r0;
            int i12 = 5;
            while (true) {
                i10 = i12 - 1;
                bArr[i10] = (byte) i11;
                i11 >>>= 8;
                if (i11 == 0) {
                    break;
                }
                i12 = i10;
            }
            int i13 = i12 - 2;
            bArr[i13] = (byte) (128 | (5 - i10));
            while (true) {
                int i14 = i13 + 1;
                a(stringBuffer, (int) bArr[i13]);
                if (i14 >= 5) {
                    break;
                }
                i13 = i14;
            }
        }
        for (byte a10 : this.f5942b) {
            a(stringBuffer, (int) a10);
        }
        return stringBuffer.toString();
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 28, this.f5942b);
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof c1)) {
            return false;
        }
        return Arrays.equals(this.f5942b, ((c1) p0Var).f5942b);
    }

    public static void a(StringBuffer stringBuffer, int i10) {
        char[] cArr = f5941a;
        stringBuffer.append(cArr[(i10 >>> 4) & 15]);
        stringBuffer.append(cArr[i10 & 15]);
    }
}
