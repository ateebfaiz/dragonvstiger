package org.cocos2dx.okio;

import java.io.UnsupportedEncodingException;
import okio.Utf8;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f1779a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f1780b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    public static byte[] a(String str) {
        int i10;
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        int i11 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        byte b10 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14++) {
            char charAt = str.charAt(i14);
            if (charAt >= 'A' && charAt <= 'Z') {
                i10 = charAt - 'A';
            } else if (charAt >= 'a' && charAt <= 'z') {
                i10 = charAt - 'G';
            } else if (charAt >= '0' && charAt <= '9') {
                i10 = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i10 = 62;
            } else if (charAt == '/' || charAt == '_') {
                i10 = 63;
            } else {
                if (!(charAt == 10 || charAt == 13 || charAt == ' ' || charAt == 9)) {
                    return null;
                }
            }
            b10 = (b10 << 6) | ((byte) i10);
            i12++;
            if (i12 % 4 == 0) {
                bArr[i13] = (byte) (b10 >> 16);
                int i15 = i13 + 2;
                bArr[i13 + 1] = (byte) (b10 >> 8);
                i13 += 3;
                bArr[i15] = (byte) b10;
            }
        }
        int i16 = i12 % 4;
        if (i16 == 1) {
            return null;
        }
        if (i16 == 2) {
            bArr[i13] = (byte) ((b10 << 12) >> 16);
            i13++;
        } else if (i16 == 3) {
            int i17 = b10 << 6;
            int i18 = i13 + 1;
            bArr[i13] = (byte) (i17 >> 16);
            i13 += 2;
            bArr[i18] = (byte) (i17 >> 8);
        }
        if (i13 == i11) {
            return bArr;
        }
        byte[] bArr2 = new byte[i13];
        System.arraycopy(bArr, 0, bArr2, 0, i13);
        return bArr2;
    }

    public static String b(byte[] bArr) {
        return c(bArr, f1779a);
    }

    private static String c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11 += 3) {
            bArr3[i10] = bArr2[(bArr[i11] & 255) >> 2];
            int i12 = i11 + 1;
            bArr3[i10 + 1] = bArr2[((bArr[i11] & 3) << 4) | ((bArr[i12] & 255) >> 4)];
            int i13 = i10 + 3;
            int i14 = i11 + 2;
            bArr3[i10 + 2] = bArr2[((bArr[i12] & 15) << 2) | ((bArr[i14] & 255) >> 6)];
            i10 += 4;
            bArr3[i13] = bArr2[bArr[i14] & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            bArr3[i10 + 1] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i10 + 2] = 61;
            bArr3[i10 + 3] = 61;
        } else if (length2 == 2) {
            bArr3[i10] = bArr2[(bArr[length] & 255) >> 2];
            int i15 = length + 1;
            bArr3[i10 + 1] = bArr2[((bArr[i15] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i10 + 2] = bArr2[(bArr[i15] & 15) << 2];
            bArr3[i10 + 3] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static String d(byte[] bArr) {
        return c(bArr, f1780b);
    }
}
