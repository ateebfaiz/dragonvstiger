package com.google.android.gms.internal.auth;

abstract class t2 {

    /* renamed from: a  reason: collision with root package name */
    private static final r2 f7001a = new s2();

    static {
        if (p2.u() && p2.v()) {
            int i10 = m0.f6950a;
        }
    }

    static /* bridge */ /* synthetic */ int a(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 != 0) {
            if (i12 == 1) {
                byte b11 = bArr[i10];
                if (b10 <= -12 && b11 <= -65) {
                    return b10 ^ (b11 << 8);
                }
            } else if (i12 == 2) {
                byte b12 = bArr[i10];
                byte b13 = bArr[i10 + 1];
                if (b10 <= -12 && b12 <= -65 && b13 <= -65) {
                    return ((b12 << 8) ^ b10) ^ (b13 << 16);
                }
            } else {
                throw new AssertionError();
            }
        } else if (b10 <= -12) {
            return b10;
        }
        return -1;
    }

    static String b(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        if ((i10 | i11 | ((length - i10) - i11)) >= 0) {
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (r13 < i12) {
                byte b10 = bArr[r13];
                if (!q2.d(b10)) {
                    break;
                }
                i10 = r13 + 1;
                cArr[i13] = (char) b10;
                i13++;
            }
            int i14 = i13;
            while (r13 < i12) {
                int i15 = r13 + 1;
                byte b11 = bArr[r13];
                if (q2.d(b11)) {
                    cArr[i14] = (char) b11;
                    i14++;
                    r13 = i15;
                    while (r13 < i12) {
                        byte b12 = bArr[r13];
                        if (!q2.d(b12)) {
                            break;
                        }
                        r13++;
                        cArr[i14] = (char) b12;
                        i14++;
                    }
                } else if (b11 < -32) {
                    if (i15 < i12) {
                        r13 += 2;
                        q2.c(b11, bArr[i15], cArr, i14);
                        i14++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (b11 < -16) {
                    if (i15 < i12 - 1) {
                        int i16 = r13 + 2;
                        r13 += 3;
                        q2.b(b11, bArr[i15], bArr[i16], cArr, i14);
                        i14++;
                    } else {
                        throw zzfa.zzb();
                    }
                } else if (i15 < i12 - 2) {
                    int i17 = r13 + 2;
                    int i18 = r13 + 3;
                    r13 += 4;
                    q2.a(b11, bArr[i15], bArr[i17], bArr[i18], cArr, i14);
                    i14 += 2;
                } else {
                    throw zzfa.zzb();
                }
            }
            return new String(cArr, 0, i14);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    static boolean c(byte[] bArr) {
        return f7001a.b(bArr, 0, bArr.length);
    }

    static boolean d(byte[] bArr, int i10, int i11) {
        return f7001a.b(bArr, i10, i11);
    }
}
