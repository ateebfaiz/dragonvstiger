package ha;

import java.util.Arrays;
import okio.Utf8;

abstract class b {
    private static int a(long j10) {
        int i10 = (int) j10;
        if (((long) i10) == j10) {
            return i10;
        }
        throw new IllegalArgumentException(j10 + " cannot be cast to int without changing its value.");
    }

    static int b(int i10, boolean z10) {
        if (i10 == 0) {
            return 0;
        }
        if (!z10) {
            return (((i10 - 1) / 3) + 1) << 2;
        }
        int i11 = (i10 / 3) << 2;
        int i12 = i10 % 3;
        if (i12 == 0) {
            return i11;
        }
        return i11 + i12 + 1;
    }

    public static byte[] c(String str) {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes(f.f12313a);
        int length = bytes.length;
        byte[] bArr = new byte[a((((long) length) * 6) >> 3)];
        int i10 = 0;
        int i11 = 0;
        while (i10 < bytes.length) {
            int i12 = 0;
            int i13 = 0;
            while (i12 < 4 && i10 < length) {
                int i14 = i10 + 1;
                int d10 = d(bytes[i10]);
                if (d10 >= 0) {
                    i13 |= d10 << (18 - (i12 * 6));
                    i12++;
                }
                i10 = i14;
            }
            if (i12 >= 2) {
                int i15 = i11 + 1;
                bArr[i11] = (byte) (i13 >> 16);
                if (i12 >= 3) {
                    int i16 = i11 + 2;
                    bArr[i15] = (byte) (i13 >> 8);
                    if (i12 >= 4) {
                        i11 += 3;
                        bArr[i16] = (byte) i13;
                    } else {
                        i11 = i16;
                    }
                } else {
                    i11 = i15;
                }
            }
        }
        return Arrays.copyOf(bArr, i11);
    }

    static int d(byte b10) {
        int i10 = i(b10, 64) & j(b10, 91);
        int i11 = i(b10, 96) & j(b10, 123);
        int i12 = i(b10, 47) & j(b10, 58);
        int h10 = h(b10, 45) | h(b10, 43);
        int h11 = h(b10, 47) | h(b10, 95);
        return k(i12, b10 + 4, 0) | k(i10, b10 - 65, 0) | k(i11, b10 - 71, 0) | k(h10, 62, 0) | k(h11, 63, 0) | k(i10 | i11 | i12 | h10 | h11, 0, -1);
    }

    static byte e(int i10) {
        int j10 = j(i10, 26);
        int i11 = i(i10, 25) & j(i10, 52);
        int i12 = i(i10, 51) & j(i10, 62);
        int h10 = h(i10, 62);
        int h11 = h(i10, 63);
        int i13 = i10 + 65;
        int i14 = i10 + 71;
        return (byte) (k(i12, i10 - 4, 0) | k(j10, i13, 0) | k(i11, i14, 0) | k(h10, 43, 0) | k(h11, 47, 0));
    }

    static byte f(int i10) {
        int j10 = j(i10, 26);
        int i11 = i(i10, 25) & j(i10, 52);
        int i12 = i(i10, 51) & j(i10, 62);
        int h10 = h(i10, 62);
        int h11 = h(i10, 63);
        int i13 = i10 + 65;
        int i14 = i10 + 71;
        return (byte) (k(i12, i10 - 4, 0) | k(j10, i13, 0) | k(i11, i14, 0) | k(h10, 45, 0) | k(h11, 95, 0));
    }

    public static String g(byte[] bArr, boolean z10) {
        int i10;
        byte b10;
        int i11 = 0;
        if (bArr != null) {
            i10 = bArr.length;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return "";
        }
        int i12 = (i10 / 3) * 3;
        int b11 = b(i10, z10);
        byte[] bArr2 = new byte[b11];
        int i13 = 0;
        int i14 = 0;
        while (i13 < i12) {
            int i15 = i13 + 2;
            int i16 = (bArr[i13 + 1] & 255) << 8;
            i13 += 3;
            byte b12 = i16 | ((bArr[i13] & 255) << 16) | (bArr[i15] & 255);
            if (z10) {
                bArr2[i14] = f((b12 >>> 18) & 63);
                bArr2[i14 + 1] = f((b12 >>> 12) & 63);
                int i17 = i14 + 3;
                bArr2[i14 + 2] = f((b12 >>> 6) & 63);
                i14 += 4;
                bArr2[i17] = f(b12 & Utf8.REPLACEMENT_BYTE);
            } else {
                bArr2[i14] = e((b12 >>> 18) & 63);
                bArr2[i14 + 1] = e((b12 >>> 12) & 63);
                int i18 = i14 + 3;
                bArr2[i14 + 2] = e((b12 >>> 6) & 63);
                i14 += 4;
                bArr2[i18] = e(b12 & Utf8.REPLACEMENT_BYTE);
            }
        }
        int i19 = i10 - i12;
        if (i19 > 0) {
            int i20 = (bArr[i12] & 255) << 10;
            if (i19 == 2) {
                i11 = (bArr[i10 - 1] & 255) << 2;
            }
            int i21 = i20 | i11;
            if (!z10) {
                bArr2[b11 - 4] = e(i21 >> 12);
                bArr2[b11 - 3] = e((i21 >>> 6) & 63);
                int i22 = b11 - 2;
                if (i19 == 2) {
                    b10 = e(i21 & 63);
                } else {
                    b10 = 61;
                }
                bArr2[i22] = b10;
                bArr2[b11 - 1] = 61;
            } else if (i19 == 2) {
                bArr2[b11 - 3] = f(i21 >> 12);
                bArr2[b11 - 2] = f((i21 >>> 6) & 63);
                bArr2[b11 - 1] = f(i21 & 63);
            } else {
                bArr2[b11 - 2] = f(i21 >> 12);
                bArr2[b11 - 1] = f((i21 >>> 6) & 63);
            }
        }
        return new String(bArr2, f.f12313a);
    }

    static int h(int i10, int i11) {
        int i12 = i10 ^ i11;
        return ((~i12) & (i12 - 1)) >>> 63;
    }

    static int i(int i10, int i11) {
        return (int) ((((long) i11) - ((long) i10)) >>> 63);
    }

    static int j(int i10, int i11) {
        return (int) ((((long) i10) - ((long) i11)) >>> 63);
    }

    static int k(int i10, int i11, int i12) {
        return ((i10 - 1) & (i12 ^ i11)) ^ i11;
    }
}
