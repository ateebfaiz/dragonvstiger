package okio;

import java.util.Arrays;
import kotlin.jvm.internal.m;
import okio.ByteString;

/* renamed from: okio.-Base64  reason: invalid class name */
public final class Base64 {
    private static final byte[] BASE64;
    private static final byte[] BASE64_URL_SAFE;

    static {
        ByteString.Companion companion = ByteString.Companion;
        BASE64 = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        BASE64_URL_SAFE = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    public static final byte[] decodeBase64ToArray(String str) {
        int i10;
        m.f(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == 10 || r5 == 13 || r5 == ' ' || r5 == 9)) {
            length--;
        }
        int i11 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i11];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < length; i15++) {
            char charAt = str.charAt(i15);
            if ('A' <= charAt && 'Z' >= charAt) {
                i10 = charAt - 'A';
            } else if ('a' <= charAt && 'z' >= charAt) {
                i10 = charAt - 'G';
            } else if ('0' <= charAt && '9' >= charAt) {
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
            i13 = (i13 << 6) | i10;
            i12++;
            if (i12 % 4 == 0) {
                bArr[i14] = (byte) (i13 >> 16);
                int i16 = i14 + 2;
                bArr[i14 + 1] = (byte) (i13 >> 8);
                i14 += 3;
                bArr[i16] = (byte) i13;
            }
        }
        int i17 = i12 % 4;
        if (i17 == 1) {
            return null;
        }
        if (i17 == 2) {
            bArr[i14] = (byte) ((i13 << 12) >> 16);
            i14++;
        } else if (i17 == 3) {
            int i18 = i13 << 6;
            int i19 = i14 + 1;
            bArr[i14] = (byte) (i18 >> 16);
            i14 += 2;
            bArr[i19] = (byte) (i18 >> 8);
        }
        if (i14 == i11) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i14);
        m.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    public static final String encodeBase64(byte[] bArr, byte[] bArr2) {
        m.f(bArr, "$this$encodeBase64");
        m.f(bArr2, "map");
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArr[i10];
            int i12 = i10 + 2;
            byte b11 = bArr[i10 + 1];
            i10 += 3;
            byte b12 = bArr[i12];
            bArr3[i11] = bArr2[(b10 & 255) >> 2];
            bArr3[i11 + 1] = bArr2[((b10 & 3) << 4) | ((b11 & 255) >> 4)];
            int i13 = i11 + 3;
            bArr3[i11 + 2] = bArr2[((b11 & 15) << 2) | ((b12 & 255) >> 6)];
            i11 += 4;
            bArr3[i13] = bArr2[b12 & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b13 = bArr[i10];
            bArr3[i11] = bArr2[(b13 & 255) >> 2];
            bArr3[i11 + 1] = bArr2[(b13 & 3) << 4];
            byte b14 = (byte) 61;
            bArr3[i11 + 2] = b14;
            bArr3[i11 + 3] = b14;
        } else if (length2 == 2) {
            int i14 = i10 + 1;
            byte b15 = bArr[i10];
            byte b16 = bArr[i14];
            bArr3[i11] = bArr2[(b15 & 255) >> 2];
            bArr3[i11 + 1] = bArr2[((b15 & 3) << 4) | ((b16 & 255) >> 4)];
            bArr3[i11 + 2] = bArr2[(b16 & 15) << 2];
            bArr3[i11 + 3] = (byte) 61;
        }
        return Platform.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }
}
