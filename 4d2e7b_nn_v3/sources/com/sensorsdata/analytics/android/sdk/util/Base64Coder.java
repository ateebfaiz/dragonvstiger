package com.sensorsdata.analytics.android.sdk.util;

import com.sensorsdata.analytics.android.sdk.SALog;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

public class Base64Coder {
    public static final String CHARSET_UTF8 = "UTF-8";
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];

    static {
        char c10 = 'A';
        int i10 = 0;
        while (c10 <= 'Z') {
            map1[i10] = c10;
            c10 = (char) (c10 + 1);
            i10++;
        }
        char c11 = 'a';
        while (c11 <= 'z') {
            map1[i10] = c11;
            c11 = (char) (c11 + 1);
            i10++;
        }
        char c12 = '0';
        while (c12 <= '9') {
            map1[i10] = c12;
            c12 = (char) (c12 + 1);
            i10++;
        }
        char[] cArr = map1;
        cArr[i10] = '+';
        cArr[i10 + 1] = '/';
        int i11 = 0;
        while (true) {
            byte[] bArr = map2;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        for (int i12 = 0; i12 < 64; i12++) {
            map2[map1[i12]] = (byte) i12;
        }
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, bArr.length);
    }

    public static String encodeString(String str) {
        try {
            return new String(encode(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public static byte[] decode(char[] cArr) {
        char c10;
        int length = cArr.length;
        if (length % 4 == 0) {
            while (length > 0 && cArr[length - 1] == '=') {
                length--;
            }
            int i10 = (length * 3) / 4;
            byte[] bArr = new byte[i10];
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                char c11 = cArr[i11];
                int i13 = i11 + 2;
                char c12 = cArr[i11 + 1];
                char c13 = 'A';
                if (i13 < length) {
                    i11 += 3;
                    c10 = cArr[i13];
                } else {
                    i11 = i13;
                    c10 = 'A';
                }
                if (i11 < length) {
                    c13 = cArr[i11];
                    i11++;
                }
                if (c11 > 127 || c12 > 127 || c10 > 127 || c13 > 127) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                byte[] bArr2 = map2;
                byte b10 = bArr2[c11];
                byte b11 = bArr2[c12];
                byte b12 = bArr2[c10];
                byte b13 = bArr2[c13];
                if (b10 < 0 || b11 < 0 || b12 < 0 || b13 < 0) {
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
                int i14 = (b10 << 2) | (b11 >>> 4);
                int i15 = ((b11 & 15) << 4) | (b12 >>> 2);
                byte b14 = ((b12 & 3) << 6) | b13;
                int i16 = i12 + 1;
                bArr[i12] = (byte) i14;
                if (i16 < i10) {
                    bArr[i16] = (byte) i15;
                    i16 = i12 + 2;
                }
                if (i16 < i10) {
                    i12 = i16 + 1;
                    bArr[i16] = (byte) b14;
                } else {
                    i12 = i16;
                }
            }
            return bArr;
        }
        throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    }

    public static char[] encode(byte[] bArr, int i10) {
        byte b10;
        int i11;
        int i12;
        byte b11;
        int i13 = ((i10 * 4) + 2) / 3;
        char[] cArr = new char[(((i10 + 2) / 3) * 4)];
        int i14 = 0;
        int i15 = 0;
        while (i14 < i10) {
            int i16 = i14 + 1;
            byte b12 = bArr[i14];
            byte b13 = b12 & 255;
            if (i16 < i10) {
                i11 = i14 + 2;
                b10 = bArr[i16] & 255;
            } else {
                i11 = i16;
                b10 = 0;
            }
            if (i11 < i10) {
                i12 = i11 + 1;
                b11 = bArr[i11] & 255;
            } else {
                i12 = i11;
                b11 = 0;
            }
            int i17 = ((b12 & 3) << 4) | (b10 >>> 4);
            int i18 = ((b10 & 15) << 2) | (b11 >>> 6);
            byte b14 = b11 & Utf8.REPLACEMENT_BYTE;
            char[] cArr2 = map1;
            cArr[i15] = cArr2[b13 >>> 2];
            int i19 = i15 + 2;
            cArr[i15 + 1] = cArr2[i17];
            char c10 = '=';
            cArr[i19] = i19 < i13 ? cArr2[i18] : '=';
            int i20 = i15 + 3;
            if (i20 < i13) {
                c10 = cArr2[b14];
            }
            cArr[i20] = c10;
            i15 += 4;
            i14 = i12;
        }
        return cArr;
    }
}
