package com.geetest.core;

import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

public abstract class b1 extends p0 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f5934a;

    public b1(byte[] bArr, boolean z10) {
        this.f5934a = z10 ? c.a(bArr) : bArr;
    }

    public final boolean a(p0 p0Var) {
        if (!(p0Var instanceof b1)) {
            return false;
        }
        return Arrays.equals(this.f5934a, ((b1) p0Var).f5934a);
    }

    public final boolean g() {
        return false;
    }

    public final int hashCode() {
        return c.c(this.f5934a);
    }

    public String toString() {
        byte[] bArr = this.f5934a;
        int i10 = j3.f6041a;
        int length = bArr.length;
        char[] cArr = new char[length];
        short[] sArr = n3.f6111a;
        int length2 = bArr.length;
        int i11 = 0;
        int i12 = 0;
        loop0:
        while (true) {
            if (i11 >= length2) {
                break;
            }
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 < 0) {
                short s10 = n3.f6111a[b10 & Byte.MAX_VALUE];
                int i14 = s10 >>> 8;
                byte b11 = (byte) s10;
                while (true) {
                    if (b11 < 0) {
                        if (b11 == -2) {
                            break;
                        }
                        if (i14 <= 65535) {
                            if (i12 >= length) {
                                break;
                            }
                            cArr[i12] = (char) i14;
                            i12++;
                        } else if (i12 >= length - 1) {
                            break;
                        } else {
                            int i15 = i12 + 1;
                            cArr[i12] = (char) ((i14 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                            i12 += 2;
                            cArr[i15] = (char) ((i14 & 1023) | Utf8.LOG_SURROGATE_HEADER);
                        }
                        i11 = i13;
                    } else if (i13 >= length2) {
                        break loop0;
                    } else {
                        int i16 = i13 + 1;
                        byte b12 = bArr[i13];
                        i14 = (i14 << 6) | (b12 & Utf8.REPLACEMENT_BYTE);
                        b11 = n3.f6112b[b11 + ((b12 & 255) >>> 4)];
                        i13 = i16;
                    }
                }
            } else if (i12 >= length) {
                break;
            } else {
                cArr[i12] = (char) b10;
                i11 = i13;
                i12++;
            }
        }
        i12 = -1;
        if (i12 >= 0) {
            return new String(cArr, 0, i12);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public final int a(boolean z10) {
        return n0.a(z10, this.f5934a.length);
    }

    public final void a(n0 n0Var, boolean z10) throws IOException {
        n0Var.a(z10, 12, this.f5934a);
    }
}
