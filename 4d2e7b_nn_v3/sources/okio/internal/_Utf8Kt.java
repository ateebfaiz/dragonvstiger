package okio.internal;

import java.util.Arrays;
import kotlin.jvm.internal.m;
import okio.Utf8;

public final class _Utf8Kt {
    public static final byte[] commonAsUtf8ToByteArray(String str) {
        int i10;
        int i11;
        char charAt;
        m.f(str, "$this$commonAsUtf8ToByteArray");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i12 = 0;
        while (i10 < length) {
            char charAt2 = str.charAt(i10);
            if (m.g(charAt2, 128) >= 0) {
                int length2 = str.length();
                int i13 = i10;
                while (i10 < length2) {
                    char charAt3 = str.charAt(i10);
                    if (m.g(charAt3, 128) < 0) {
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) charAt3;
                        i10++;
                        while (i10 < length2 && m.g(str.charAt(i10), 128) < 0) {
                            bArr[i14] = (byte) str.charAt(i10);
                            i10++;
                            i14++;
                        }
                        i13 = i14;
                    } else {
                        if (m.g(charAt3, 2048) < 0) {
                            bArr[i13] = (byte) ((charAt3 >> 6) | 192);
                            i13 += 2;
                            bArr[i13 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            bArr[i13] = (byte) ((charAt3 >> 12) | 224);
                            bArr[i13 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i13 += 3;
                            bArr[i13 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (m.g(charAt3, 56319) > 0 || length2 <= (i11 = i10 + 1) || 56320 > (charAt = str.charAt(i11)) || 57343 < charAt) {
                            bArr[i13] = Utf8.REPLACEMENT_BYTE;
                            i10++;
                            i13++;
                        } else {
                            int charAt4 = ((charAt3 << 10) + str.charAt(i11)) - 56613888;
                            bArr[i13] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i13 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i13 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i13 += 4;
                            bArr[i13 + 3] = (byte) ((charAt4 & 63) | 128);
                            i10 += 2;
                        }
                        i10++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i13);
                m.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                return copyOf;
            }
            bArr[i10] = (byte) charAt2;
            i12 = i10 + 1;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        m.e(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        if ((r0[r3] & 192) == 128) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0103, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x0187;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String commonToUtf8String(byte[] r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.String r7 = "$this$commonToUtf8String"
            kotlin.jvm.internal.m.f(r0, r7)
            if (r1 < 0) goto L_0x019b
            int r7 = r0.length
            if (r2 > r7) goto L_0x019b
            if (r1 > r2) goto L_0x019b
            int r7 = r2 - r1
            char[] r7 = new char[r7]
            r9 = 0
        L_0x001b:
            if (r1 >= r2) goto L_0x0194
            byte r10 = r0[r1]
            if (r10 < 0) goto L_0x0038
            char r10 = (char) r10
            int r11 = r9 + 1
            r7[r9] = r10
            int r1 = r1 + r6
        L_0x0027:
            if (r1 >= r2) goto L_0x0035
            byte r9 = r0[r1]
            if (r9 < 0) goto L_0x0035
            int r1 = r1 + r6
            char r9 = (char) r9
            int r10 = r11 + 1
            r7[r11] = r9
            r11 = r10
            goto L_0x0027
        L_0x0035:
            r9 = r11
            goto L_0x0190
        L_0x0038:
            int r11 = r10 >> 5
            r12 = -2
            r13 = 128(0x80, float:1.794E-43)
            r14 = 65533(0xfffd, float:9.1831E-41)
            if (r11 != r12) goto L_0x0074
            int r11 = r1 + 1
            if (r2 > r11) goto L_0x004f
            char r10 = (char) r14
            int r11 = r9 + 1
            r7[r9] = r10
        L_0x004b:
            kotlin.Unit r9 = kotlin.Unit.f12577a
            r9 = r6
            goto L_0x0072
        L_0x004f:
            byte r11 = r0[r11]
            r12 = r11 & 192(0xc0, float:2.69E-43)
            if (r12 != r13) goto L_0x006c
            r11 = r11 ^ 3968(0xf80, float:5.56E-42)
            int r10 = r10 << 6
            r10 = r10 ^ r11
            if (r10 >= r13) goto L_0x0064
            char r10 = (char) r14
            int r11 = r9 + 1
            r7[r9] = r10
        L_0x0061:
            kotlin.Unit r9 = kotlin.Unit.f12577a
            goto L_0x006a
        L_0x0064:
            char r10 = (char) r10
            int r11 = r9 + 1
            r7[r9] = r10
            goto L_0x0061
        L_0x006a:
            r9 = r5
            goto L_0x0072
        L_0x006c:
            char r10 = (char) r14
            int r11 = r9 + 1
            r7[r9] = r10
            goto L_0x004b
        L_0x0072:
            int r1 = r1 + r9
            goto L_0x0035
        L_0x0074:
            int r11 = r10 >> 4
            r15 = 55296(0xd800, float:7.7486E-41)
            r3 = 57343(0xdfff, float:8.0355E-41)
            if (r11 != r12) goto L_0x00e3
            int r11 = r1 + 2
            if (r2 > r11) goto L_0x0097
            char r3 = (char) r14
            int r10 = r9 + 1
            r7[r9] = r3
            kotlin.Unit r3 = kotlin.Unit.f12577a
            int r3 = r1 + 1
            if (r2 <= r3) goto L_0x0095
            byte r3 = r0[r3]
            r3 = r3 & 192(0xc0, float:2.69E-43)
            if (r3 != r13) goto L_0x0095
        L_0x0093:
            r3 = r5
            goto L_0x00df
        L_0x0095:
            r3 = r6
            goto L_0x00df
        L_0x0097:
            int r12 = r1 + 1
            byte r12 = r0[r12]
            r8 = r12 & 192(0xc0, float:2.69E-43)
            if (r8 != r13) goto L_0x00d7
            byte r8 = r0[r11]
            r11 = r8 & 192(0xc0, float:2.69E-43)
            if (r11 != r13) goto L_0x00cf
            r11 = -123008(0xfffffffffffe1f80, float:NaN)
            r8 = r8 ^ r11
            int r11 = r12 << 6
            r8 = r8 ^ r11
            int r10 = r10 << 12
            r8 = r8 ^ r10
            r10 = 2048(0x800, float:2.87E-42)
            if (r8 >= r10) goto L_0x00bc
            char r3 = (char) r14
            int r8 = r9 + 1
            r7[r9] = r3
        L_0x00b8:
            kotlin.Unit r3 = kotlin.Unit.f12577a
            r10 = r8
            goto L_0x00cd
        L_0x00bc:
            if (r15 <= r8) goto L_0x00bf
            goto L_0x00c7
        L_0x00bf:
            if (r3 < r8) goto L_0x00c7
            char r3 = (char) r14
            int r8 = r9 + 1
            r7[r9] = r3
            goto L_0x00b8
        L_0x00c7:
            char r3 = (char) r8
            int r8 = r9 + 1
            r7[r9] = r3
            goto L_0x00b8
        L_0x00cd:
            r3 = r4
            goto L_0x00df
        L_0x00cf:
            char r3 = (char) r14
            int r10 = r9 + 1
            r7[r9] = r3
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0093
        L_0x00d7:
            char r3 = (char) r14
            int r10 = r9 + 1
            r7[r9] = r3
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0095
        L_0x00df:
            int r1 = r1 + r3
            r9 = r10
            goto L_0x0190
        L_0x00e3:
            int r8 = r10 >> 3
            if (r8 != r12) goto L_0x018a
            int r8 = r1 + 3
            if (r2 > r8) goto L_0x010d
            int r3 = r9 + 1
            r7[r9] = r14
            kotlin.Unit r8 = kotlin.Unit.f12577a
            int r8 = r1 + 1
            if (r2 <= r8) goto L_0x010a
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r13) goto L_0x010a
            int r8 = r1 + 2
            if (r2 <= r8) goto L_0x0107
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r13) goto L_0x0107
            goto L_0x0187
        L_0x0107:
            r4 = r5
            goto L_0x0187
        L_0x010a:
            r4 = r6
            goto L_0x0187
        L_0x010d:
            int r11 = r1 + 1
            byte r11 = r0[r11]
            r12 = r11 & 192(0xc0, float:2.69E-43)
            if (r12 != r13) goto L_0x0180
            int r12 = r1 + 2
            byte r12 = r0[r12]
            r4 = r12 & 192(0xc0, float:2.69E-43)
            if (r4 != r13) goto L_0x0179
            byte r4 = r0[r8]
            r8 = r4 & 192(0xc0, float:2.69E-43)
            if (r8 != r13) goto L_0x0171
            r8 = 3678080(0x381f80, float:5.154088E-39)
            r4 = r4 ^ r8
            int r8 = r12 << 6
            r4 = r4 ^ r8
            int r8 = r11 << 12
            r4 = r4 ^ r8
            int r8 = r10 << 18
            r4 = r4 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r4 <= r8) goto L_0x013c
            int r3 = r9 + 1
            r7[r9] = r14
        L_0x0139:
            kotlin.Unit r4 = kotlin.Unit.f12577a
            goto L_0x016f
        L_0x013c:
            if (r15 <= r4) goto L_0x013f
            goto L_0x0146
        L_0x013f:
            if (r3 < r4) goto L_0x0146
            int r3 = r9 + 1
            r7[r9] = r14
            goto L_0x0139
        L_0x0146:
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r4 >= r3) goto L_0x014f
            int r3 = r9 + 1
            r7[r9] = r14
            goto L_0x0139
        L_0x014f:
            if (r4 == r14) goto L_0x0167
            int r3 = r4 >>> 10
            r8 = 55232(0xd7c0, float:7.7397E-41)
            int r3 = r3 + r8
            char r3 = (char) r3
            int r8 = r9 + 1
            r7[r9] = r3
            r3 = r4 & 1023(0x3ff, float:1.434E-42)
            r4 = 56320(0xdc00, float:7.8921E-41)
            int r3 = r3 + r4
            char r3 = (char) r3
            int r9 = r9 + r5
            r7[r8] = r3
            goto L_0x016c
        L_0x0167:
            int r3 = r9 + 1
            r7[r9] = r14
            r9 = r3
        L_0x016c:
            kotlin.Unit r3 = kotlin.Unit.f12577a
            r3 = r9
        L_0x016f:
            r4 = 4
            goto L_0x0187
        L_0x0171:
            int r3 = r9 + 1
            r7[r9] = r14
            kotlin.Unit r4 = kotlin.Unit.f12577a
            r4 = 3
            goto L_0x0187
        L_0x0179:
            int r3 = r9 + 1
            r7[r9] = r14
            kotlin.Unit r4 = kotlin.Unit.f12577a
            goto L_0x0107
        L_0x0180:
            int r3 = r9 + 1
            r7[r9] = r14
            kotlin.Unit r4 = kotlin.Unit.f12577a
            goto L_0x010a
        L_0x0187:
            int r1 = r1 + r4
        L_0x0188:
            r9 = r3
            goto L_0x0190
        L_0x018a:
            int r3 = r9 + 1
            r7[r9] = r14
            int r1 = r1 + r6
            goto L_0x0188
        L_0x0190:
            r3 = 4
            r4 = 3
            goto L_0x001b
        L_0x0194:
            java.lang.String r0 = new java.lang.String
            r1 = 0
            r0.<init>(r7, r1, r9)
            return r0
        L_0x019b:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "size="
            r4.append(r5)
            int r0 = r0.length
            r4.append(r0)
            java.lang.String r0 = " beginIndex="
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " endIndex="
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.commonToUtf8String(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        return commonToUtf8String(bArr, i10, i11);
    }
}
