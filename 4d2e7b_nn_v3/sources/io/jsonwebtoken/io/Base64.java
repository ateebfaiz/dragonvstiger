package io.jsonwebtoken.io;

import java.util.Arrays;
import okio.Utf8;

final class Base64 {
    private static final char[] BASE64URL_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
    private static final int[] BASE64URL_IALPHABET;
    private static final char[] BASE64_ALPHABET;
    private static final int[] BASE64_IALPHABET;
    static final Base64 DEFAULT = new Base64(false);
    private static final int IALPHABET_MAX_INDEX;
    static final Base64 URL_SAFE = new Base64(true);
    private final char[] ALPHABET;
    private final int[] IALPHABET;
    private final boolean urlsafe;

    static {
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        BASE64_ALPHABET = charArray;
        int[] iArr = new int[256];
        BASE64_IALPHABET = iArr;
        int[] iArr2 = new int[256];
        BASE64URL_IALPHABET = iArr2;
        IALPHABET_MAX_INDEX = iArr.length - 1;
        Arrays.fill(iArr, -1);
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        int length = charArray.length;
        for (int i10 = 0; i10 < length; i10++) {
            BASE64_IALPHABET[BASE64_ALPHABET[i10]] = i10;
            BASE64URL_IALPHABET[BASE64URL_ALPHABET[i10]] = i10;
        }
        BASE64_IALPHABET[61] = 0;
        BASE64URL_IALPHABET[61] = 0;
    }

    private Base64(boolean z10) {
        char[] cArr;
        int[] iArr;
        this.urlsafe = z10;
        if (z10) {
            cArr = BASE64URL_ALPHABET;
        } else {
            cArr = BASE64_ALPHABET;
        }
        this.ALPHABET = cArr;
        if (z10) {
            iArr = BASE64URL_IALPHABET;
        } else {
            iArr = BASE64_IALPHABET;
        }
        this.IALPHABET = iArr;
    }

    private int ctoi(char c10) {
        int i10;
        if (c10 > IALPHABET_MAX_INDEX) {
            i10 = -1;
        } else {
            i10 = this.IALPHABET[c10];
        }
        if (i10 >= 0) {
            return i10;
        }
        throw new DecodingException("Illegal " + getName() + " character: '" + c10 + "'");
    }

    private char[] encodeToChar(byte[] bArr, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            i10 = bArr2.length;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return new char[0];
        }
        int i15 = (i10 / 3) * 3;
        int i16 = i10 - i15;
        int i17 = i10 - 1;
        int i18 = ((i17 / 3) + 1) << 2;
        if (z10) {
            i11 = ((i18 - 1) / 76) << 1;
        } else {
            i11 = 0;
        }
        int i19 = i18 + i11;
        if (i16 == 2) {
            i12 = 1;
        } else if (i16 == 1) {
            i12 = 2;
        } else {
            i12 = 0;
        }
        if (this.urlsafe) {
            i13 = i19 - i12;
        } else {
            i13 = i19;
        }
        char[] cArr = new char[i13];
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i20 < i15) {
            int i23 = i20 + 2;
            int i24 = (bArr2[i20 + 1] & 255) << 8;
            i20 += 3;
            byte b10 = i24 | ((bArr2[i20] & 255) << 16) | (bArr2[i23] & 255);
            char[] cArr2 = this.ALPHABET;
            cArr[i21] = cArr2[(b10 >>> 18) & 63];
            cArr[i21 + 1] = cArr2[(b10 >>> 12) & 63];
            cArr[i21 + 2] = cArr2[(b10 >>> 6) & 63];
            int i25 = i21 + 4;
            cArr[i21 + 3] = cArr2[b10 & Utf8.REPLACEMENT_BYTE];
            if (!z10 || (i22 = i22 + 1) != 19 || i25 >= i19 - 2) {
                i21 = i25;
            } else {
                int i26 = i21 + 5;
                cArr[i25] = 13;
                i21 += 6;
                cArr[i26] = 10;
                i22 = 0;
            }
        }
        if (i16 > 0) {
            int i27 = (bArr2[i15] & 255) << 10;
            if (i16 == 2) {
                i14 = (bArr2[i17] & 255) << 2;
            } else {
                i14 = 0;
            }
            int i28 = i27 | i14;
            char[] cArr3 = this.ALPHABET;
            cArr[i19 - 4] = cArr3[i28 >> 12];
            cArr[i19 - 3] = cArr3[(i28 >>> 6) & 63];
            if (i16 == 2) {
                cArr[i19 - 2] = cArr3[i28 & 63];
            } else if (!this.urlsafe) {
                cArr[i19 - 2] = '=';
            }
            if (!this.urlsafe) {
                cArr[i19 - 1] = '=';
            }
        }
        return cArr;
    }

    private String getName() {
        if (this.urlsafe) {
            return "base64url";
        }
        return "base64";
    }

    /* access modifiers changed from: package-private */
    public final byte[] decodeFast(char[] cArr) throws DecodingException {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        char[] cArr2 = cArr;
        if (cArr2 != null) {
            i10 = cArr2.length;
        } else {
            i10 = 0;
        }
        if (i10 == 0) {
            return new byte[0];
        }
        int i15 = i10 - 1;
        int i16 = 0;
        while (i11 < i15 && this.IALPHABET[cArr2[i11]] < 0) {
            i16 = i11 + 1;
        }
        while (i15 > 0 && this.IALPHABET[cArr2[i15]] < 0) {
            i15--;
        }
        if (cArr2[i15] != '=') {
            i12 = 0;
        } else if (cArr2[i15 - 1] == '=') {
            i12 = 2;
        } else {
            i12 = 1;
        }
        int i17 = (i15 - i11) + 1;
        if (i10 > 76) {
            if (cArr2[76] == 13) {
                i14 = i17 / 78;
            } else {
                i14 = 0;
            }
            i13 = i14 << 1;
        } else {
            i13 = 0;
        }
        int i18 = (((i17 - i13) * 6) >> 3) - i12;
        byte[] bArr = new byte[i18];
        int i19 = (i18 / 3) * 3;
        int i20 = 0;
        int i21 = 0;
        while (i20 < i19) {
            int i22 = i11 + 4;
            int ctoi = (ctoi(cArr2[i11 + 1]) << 12) | (ctoi(cArr2[i11]) << 18) | (ctoi(cArr2[i11 + 2]) << 6) | ctoi(cArr2[i11 + 3]);
            bArr[i20] = (byte) (ctoi >> 16);
            int i23 = i20 + 2;
            bArr[i20 + 1] = (byte) (ctoi >> 8);
            i20 += 3;
            bArr[i23] = (byte) ctoi;
            if (i13 <= 0 || (i21 = i21 + 1) != 19) {
                i11 = i22;
            } else {
                i11 += 6;
                i21 = 0;
            }
        }
        if (i20 < i18) {
            int i24 = 0;
            int i25 = 0;
            while (i11 <= i15 - i12) {
                i24 |= ctoi(cArr2[i11]) << (18 - (i25 * 6));
                i25++;
                i11++;
            }
            int i26 = 16;
            while (i20 < i18) {
                bArr[i20] = (byte) (i24 >> i26);
                i26 -= 8;
                i20++;
            }
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final String encodeToString(byte[] bArr, boolean z10) {
        return new String(encodeToChar(bArr, z10));
    }
}
