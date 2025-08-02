package f1;

import java.util.Arrays;
import okio.Utf8;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f21306a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f21307b = new byte[f21306a.length];

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f21308c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f21309d = new byte[0];

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        f21306a = charArray;
        int[] iArr = new int[256];
        f21308c = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            f21308c[f21306a[i10]] = i10;
        }
        f21308c[61] = 0;
        int i11 = 0;
        while (true) {
            char[] cArr = f21306a;
            if (i11 < cArr.length) {
                f21307b[i11] = (byte) cArr[i11];
                i11++;
            } else {
                return;
            }
        }
    }

    static byte[] a(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = i11 - i10;
        if (i16 == 0) {
            return f21309d;
        }
        int i17 = i11 - 1;
        int i18 = i10;
        while (i12 < i17 && f21308c[bArr[i12] & 255] < 0) {
            i18 = i12 + 1;
        }
        while (i17 > 0 && f21308c[bArr[i17] & 255] < 0) {
            i17--;
        }
        int i19 = 0;
        if (bArr[i17] != 61) {
            i13 = 0;
        } else if (bArr[i17 - 1] == 61) {
            i13 = 2;
        } else {
            i13 = 1;
        }
        int i20 = (i17 - i12) + 1;
        if (i16 > 76) {
            if (bArr[76] == 13) {
                i15 = i20 / 78;
            } else {
                i15 = 0;
            }
            i14 = i15 << 1;
        } else {
            i14 = 0;
        }
        int i21 = (((i20 - i14) * 6) >> 3) - i13;
        byte[] bArr2 = new byte[i21];
        int i22 = (i21 / 3) * 3;
        int i23 = 0;
        int i24 = 0;
        while (i23 < i22) {
            int[] iArr = f21308c;
            int i25 = i12 + 4;
            int i26 = iArr[bArr[i12 + 3]] | (iArr[bArr[i12 + 1]] << 12) | (iArr[bArr[i12]] << 18) | (iArr[bArr[i12 + 2]] << 6);
            bArr2[i23] = (byte) (i26 >> 16);
            int i27 = i23 + 2;
            bArr2[i23 + 1] = (byte) (i26 >> 8);
            i23 += 3;
            bArr2[i27] = (byte) i26;
            if (i14 <= 0 || (i24 = i24 + 1) != 19) {
                i12 = i25;
            } else {
                i12 += 6;
                i24 = 0;
            }
        }
        if (i23 < i21) {
            int i28 = 0;
            while (i12 <= i17 - i13) {
                i19 |= f21308c[bArr[i12]] << (18 - (i28 * 6));
                i28++;
                i12++;
            }
            int i29 = 16;
            while (i23 < i21) {
                bArr2[i23] = (byte) (i19 >> i29);
                i29 -= 8;
                i23++;
            }
        }
        return bArr2;
    }

    static int b(byte[] bArr, byte[] bArr2, int i10) {
        byte b10;
        int length = bArr.length;
        int i11 = (length / 3) * 3;
        int i12 = length - 1;
        int i13 = ((i12 / 3) + 1) << 2;
        int i14 = 0;
        int i15 = i10;
        int i16 = 0;
        while (i16 < i11) {
            int i17 = i16 + 2;
            int i18 = (bArr[i16 + 1] & 255) << 8;
            i16 += 3;
            byte b11 = i18 | ((bArr[i16] & 255) << 16) | (bArr[i17] & 255);
            byte[] bArr3 = f21307b;
            bArr2[i15] = bArr3[(b11 >>> 18) & 63];
            bArr2[i15 + 1] = bArr3[(b11 >>> 12) & 63];
            int i19 = i15 + 3;
            bArr2[i15 + 2] = bArr3[(b11 >>> 6) & 63];
            i15 += 4;
            bArr2[i19] = bArr3[b11 & Utf8.REPLACEMENT_BYTE];
        }
        int i20 = length - i11;
        if (i20 > 0) {
            int i21 = (bArr[i11] & 255) << 10;
            if (i20 == 2) {
                i14 = (bArr[i12] & 255) << 2;
            }
            int i22 = i21 | i14;
            int i23 = i10 + i13;
            byte[] bArr4 = f21307b;
            bArr2[i23 - 4] = bArr4[i22 >> 12];
            bArr2[i23 - 3] = bArr4[(i22 >>> 6) & 63];
            int i24 = i23 - 2;
            if (i20 == 2) {
                b10 = bArr4[i22 & 63];
            } else {
                b10 = 61;
            }
            bArr2[i24] = b10;
            bArr2[i23 - 1] = 61;
        }
        return i13;
    }

    static int c(byte[] bArr, int i10) {
        while (i10 < bArr.length) {
            if (f21308c[bArr[i10] & 255] < 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }
}
