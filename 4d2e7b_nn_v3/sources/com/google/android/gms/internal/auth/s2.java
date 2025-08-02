package com.google.android.gms.internal.auth;

final class s2 extends r2 {
    s2() {
    }

    /* access modifiers changed from: package-private */
    public final int a(int i10, byte[] bArr, int i11, int i12) {
        while (r10 < i12 && bArr[r10] >= 0) {
            i11 = r10 + 1;
        }
        if (r10 >= i12) {
            return 0;
        }
        while (r10 < i12) {
            int i13 = r10 + 1;
            byte b10 = bArr[r10];
            if (b10 < 0) {
                if (b10 < -32) {
                    if (i13 >= i12) {
                        return b10;
                    }
                    if (b10 >= -62) {
                        r10 += 2;
                        if (bArr[i13] > -65) {
                        }
                    }
                } else if (b10 < -16) {
                    if (i13 >= i12 - 1) {
                        return t2.a(bArr, i13, i12);
                    }
                    int i14 = r10 + 2;
                    byte b11 = bArr[i13];
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        r10 += 3;
                        if (bArr[i14] > -65) {
                        }
                    }
                } else if (i13 >= i12 - 2) {
                    return t2.a(bArr, i13, i12);
                } else {
                    int i15 = r10 + 2;
                    byte b12 = bArr[i13];
                    if (b12 <= -65 && (((b10 << 28) + (b12 + 112)) >> 30) == 0) {
                        int i16 = r10 + 3;
                        if (bArr[i15] <= -65) {
                            r10 += 4;
                            if (bArr[i16] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            r10 = i13;
        }
        return 0;
    }
}
