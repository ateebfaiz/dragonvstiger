package okio;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i10) {
        return (i10 >= 0 && 31 >= i10) || (127 <= i10 && 159 >= i10);
    }

    public static final boolean isUtf8Continuation(byte b10) {
        return (b10 & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i10, int i11, Function1<? super Integer, Unit> function1) {
        m.f(bArr, "$this$process2Utf8Bytes");
        m.f(function1, "yield");
        int i12 = i10 + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i11 <= i12) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i12];
        if ((b11 & 192) == 128) {
            byte b12 = (b11 ^ 3968) ^ (b10 << 6);
            if (b12 < 128) {
                function1.invoke(valueOf);
                return 2;
            }
            function1.invoke(Integer.valueOf(b12));
            return 2;
        }
        function1.invoke(valueOf);
        return 1;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i10, int i11, Function1<? super Integer, Unit> function1) {
        m.f(bArr, "$this$process3Utf8Bytes");
        m.f(function1, "yield");
        int i12 = i10 + 2;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i11 <= i12) {
            function1.invoke(valueOf);
            int i13 = i10 + 1;
            if (i11 <= i13 || (bArr[i13] & 192) != 128) {
                return 1;
            }
            return 2;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        if ((b11 & 192) == 128) {
            byte b12 = bArr[i12];
            if ((b12 & 192) == 128) {
                byte b13 = ((b12 ^ -123008) ^ (b11 << 6)) ^ (b10 << 12);
                if (b13 < 2048) {
                    function1.invoke(valueOf);
                    return 3;
                } else if (55296 <= b13 && 57343 >= b13) {
                    function1.invoke(valueOf);
                    return 3;
                } else {
                    function1.invoke(Integer.valueOf(b13));
                    return 3;
                }
            } else {
                function1.invoke(valueOf);
                return 2;
            }
        } else {
            function1.invoke(valueOf);
            return 1;
        }
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i10, int i11, Function1<? super Integer, Unit> function1) {
        m.f(bArr, "$this$process4Utf8Bytes");
        m.f(function1, "yield");
        int i12 = i10 + 3;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i11 <= i12) {
            function1.invoke(valueOf);
            int i13 = i10 + 1;
            if (i11 <= i13 || (bArr[i13] & 192) != 128) {
                return 1;
            }
            int i14 = i10 + 2;
            if (i11 <= i14 || (bArr[i14] & 192) != 128) {
                return 2;
            }
            return 3;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        if ((b11 & 192) == 128) {
            byte b12 = bArr[i10 + 2];
            if ((b12 & 192) == 128) {
                byte b13 = bArr[i12];
                if ((b13 & 192) == 128) {
                    byte b14 = (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12)) ^ (b10 << 18);
                    if (b14 > 1114111) {
                        function1.invoke(valueOf);
                        return 4;
                    } else if (55296 <= b14 && 57343 >= b14) {
                        function1.invoke(valueOf);
                        return 4;
                    } else if (b14 < 65536) {
                        function1.invoke(valueOf);
                        return 4;
                    } else {
                        function1.invoke(Integer.valueOf(b14));
                        return 4;
                    }
                } else {
                    function1.invoke(valueOf);
                    return 3;
                }
            } else {
                function1.invoke(valueOf);
                return 2;
            }
        } else {
            function1.invoke(valueOf);
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fb, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x00fd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.String r7 = "$this$processUtf16Chars"
            kotlin.jvm.internal.m.f(r0, r7)
            java.lang.String r7 = "yield"
            kotlin.jvm.internal.m.f(r2, r7)
            r7 = r17
        L_0x0016:
            if (r7 >= r1) goto L_0x018f
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x0035
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            int r7 = r7 + r6
        L_0x0025:
            if (r7 >= r1) goto L_0x018c
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x018c
            int r7 = r7 + r6
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x0025
        L_0x0035:
            int r9 = r8 >> 5
            r10 = -2
            r11 = 128(0x80, float:1.794E-43)
            r12 = 65533(0xfffd, float:9.1831E-41)
            if (r9 != r10) goto L_0x006d
            int r9 = r7 + 1
            if (r1 > r9) goto L_0x004f
        L_0x0043:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
        L_0x004d:
            r8 = r6
            goto L_0x006a
        L_0x004f:
            byte r9 = r0[r9]
            r10 = r9 & 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L_0x0043
            r9 = r9 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r8 << 6
            r8 = r8 ^ r9
            if (r8 >= r11) goto L_0x0067
            char r8 = (char) r12
        L_0x005d:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x0069
        L_0x0067:
            char r8 = (char) r8
            goto L_0x005d
        L_0x0069:
            r8 = r5
        L_0x006a:
            int r7 = r7 + r8
            goto L_0x018c
        L_0x006d:
            int r9 = r8 >> 4
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 57343(0xdfff, float:8.0355E-41)
            if (r9 != r10) goto L_0x00d8
            int r9 = r7 + 2
            if (r1 > r9) goto L_0x0090
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x004d
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x004d
        L_0x008f:
            goto L_0x0069
        L_0x0090:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00cc
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00c1
            r11 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r11
            int r10 = r10 << 6
            r9 = r9 ^ r10
            int r8 = r8 << 12
            r8 = r8 ^ r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r8 >= r9) goto L_0x00b7
        L_0x00ac:
            char r8 = (char) r12
        L_0x00ad:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x00bf
        L_0x00b7:
            if (r13 <= r8) goto L_0x00ba
            goto L_0x00bd
        L_0x00ba:
            if (r14 < r8) goto L_0x00bd
            goto L_0x00ac
        L_0x00bd:
            char r8 = (char) r8
            goto L_0x00ad
        L_0x00bf:
            r8 = r4
            goto L_0x006a
        L_0x00c1:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x008f
        L_0x00cc:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x004d
        L_0x00d8:
            int r9 = r8 >> 3
            if (r9 != r10) goto L_0x0184
            int r9 = r7 + 3
            if (r1 > r9) goto L_0x0106
            java.lang.Character r8 = java.lang.Character.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x0103
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x0103
            int r8 = r7 + 2
            if (r1 <= r8) goto L_0x0100
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x0100
        L_0x00fd:
            r3 = r4
            goto L_0x0182
        L_0x0100:
            r3 = r5
            goto L_0x0182
        L_0x0103:
            r3 = r6
            goto L_0x0182
        L_0x0106:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x0178
            int r15 = r7 + 2
            byte r15 = r0[r15]
            r3 = r15 & 192(0xc0, float:2.69E-43)
            if (r3 != r11) goto L_0x016e
            byte r3 = r0[r9]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r11) goto L_0x0164
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r9 = r10 << 12
            r3 = r3 ^ r9
            int r8 = r8 << 18
            r3 = r3 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r8) goto L_0x0138
        L_0x012e:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
        L_0x0135:
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0162
        L_0x0138:
            if (r13 <= r3) goto L_0x013b
            goto L_0x013e
        L_0x013b:
            if (r14 < r3) goto L_0x013e
            goto L_0x012e
        L_0x013e:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r8) goto L_0x0143
            goto L_0x012e
        L_0x0143:
            if (r3 == r12) goto L_0x012e
            int r8 = r3 >>> 10
            r9 = 55232(0xd7c0, float:7.7397E-41)
            int r8 = r8 + r9
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r3 = r3 & 1023(0x3ff, float:1.434E-42)
            r8 = 56320(0xdc00, float:7.8921E-41)
            int r3 = r3 + r8
            char r3 = (char) r3
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r2.invoke(r3)
            goto L_0x0135
        L_0x0162:
            r3 = 4
            goto L_0x0182
        L_0x0164:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x00fd
        L_0x016e:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0100
        L_0x0178:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0103
        L_0x0182:
            int r7 = r7 + r3
            goto L_0x018c
        L_0x0184:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            int r7 = r7 + r6
        L_0x018c:
            r3 = 4
            goto L_0x0016
        L_0x018f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void processUtf8Bytes(String str, int i10, int i11, Function1<? super Byte, Unit> function1) {
        int i12;
        char charAt;
        m.f(str, "$this$processUtf8Bytes");
        m.f(function1, "yield");
        while (i10 < i11) {
            char charAt2 = str.charAt(i10);
            if (m.g(charAt2, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) charAt2));
                i10++;
                while (i10 < i11 && m.g(str.charAt(i10), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i10)));
                    i10++;
                }
            } else {
                if (m.g(charAt2, 2048) < 0) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 > charAt2 || 57343 < charAt2) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> 12) | 224)));
                    function1.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (m.g(charAt2, 56319) > 0 || i11 <= (i12 = i10 + 1) || 56320 > (charAt = str.charAt(i12)) || 57343 < charAt) {
                    function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int charAt3 = ((charAt2 << 10) + str.charAt(i12)) - 56613888;
                    function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i10 += 2;
                }
                i10++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f9, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x00fb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(byte[] r16, int r17, int r18, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.String r7 = "$this$processUtf8CodePoints"
            kotlin.jvm.internal.m.f(r0, r7)
            java.lang.String r7 = "yield"
            kotlin.jvm.internal.m.f(r2, r7)
            r7 = r17
        L_0x0016:
            if (r7 >= r1) goto L_0x0172
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x0033
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.invoke(r8)
            int r7 = r7 + r6
        L_0x0024:
            if (r7 >= r1) goto L_0x016f
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x016f
            int r7 = r7 + r6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.invoke(r8)
            goto L_0x0024
        L_0x0033:
            int r9 = r8 >> 5
            r10 = -2
            r11 = 128(0x80, float:1.794E-43)
            r12 = 65533(0xfffd, float:9.1831E-41)
            if (r9 != r10) goto L_0x006c
            int r9 = r7 + 1
            if (r1 > r9) goto L_0x004c
        L_0x0041:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
        L_0x004a:
            r8 = r6
            goto L_0x0069
        L_0x004c:
            byte r9 = r0[r9]
            r10 = r9 & 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L_0x0041
            r9 = r9 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r8 << 6
            r8 = r8 ^ r9
            if (r8 >= r11) goto L_0x0063
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
        L_0x005d:
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x0068
        L_0x0063:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x005d
        L_0x0068:
            r8 = r5
        L_0x0069:
            int r7 = r7 + r8
            goto L_0x016f
        L_0x006c:
            int r9 = r8 >> 4
            r13 = 55296(0xd800, float:7.7486E-41)
            r14 = 57343(0xdfff, float:8.0355E-41)
            if (r9 != r10) goto L_0x00d6
            int r9 = r7 + 2
            if (r1 > r9) goto L_0x008e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x004a
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x004a
        L_0x008d:
            goto L_0x0068
        L_0x008e:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00cb
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00c1
            r11 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r11
            int r10 = r10 << 6
            r9 = r9 ^ r10
            int r8 = r8 << 12
            r8 = r8 ^ r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r8 >= r9) goto L_0x00b4
        L_0x00aa:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
        L_0x00ae:
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x00bf
        L_0x00b4:
            if (r13 <= r8) goto L_0x00b7
            goto L_0x00ba
        L_0x00b7:
            if (r14 < r8) goto L_0x00ba
            goto L_0x00aa
        L_0x00ba:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00ae
        L_0x00bf:
            r8 = r4
            goto L_0x0069
        L_0x00c1:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x008d
        L_0x00cb:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            goto L_0x004a
        L_0x00d6:
            int r9 = r8 >> 3
            if (r9 != r10) goto L_0x0167
            int r9 = r7 + 3
            if (r1 > r9) goto L_0x0103
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f12577a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x0101
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x0101
            int r8 = r7 + 2
            if (r1 <= r8) goto L_0x00fe
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x00fe
        L_0x00fb:
            r3 = r4
            goto L_0x0165
        L_0x00fe:
            r3 = r5
            goto L_0x0165
        L_0x0101:
            r3 = r6
            goto L_0x0165
        L_0x0103:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x015b
            int r15 = r7 + 2
            byte r15 = r0[r15]
            r3 = r15 & 192(0xc0, float:2.69E-43)
            if (r3 != r11) goto L_0x0151
            byte r3 = r0[r9]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r11) goto L_0x0147
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r9 = r10 << 12
            r3 = r3 ^ r9
            int r8 = r8 << 18
            r3 = r3 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r8) goto L_0x0135
        L_0x012b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
        L_0x012f:
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0145
        L_0x0135:
            if (r13 <= r3) goto L_0x0138
            goto L_0x013b
        L_0x0138:
            if (r14 < r3) goto L_0x013b
            goto L_0x012b
        L_0x013b:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r8) goto L_0x0140
            goto L_0x012b
        L_0x0140:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x012f
        L_0x0145:
            r3 = 4
            goto L_0x0165
        L_0x0147:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x00fb
        L_0x0151:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x00fe
        L_0x015b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f12577a
            goto L_0x0101
        L_0x0165:
            int r7 = r7 + r3
            goto L_0x016f
        L_0x0167:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            int r7 = r7 + r6
        L_0x016f:
            r3 = 4
            goto L_0x0016
        L_0x0172:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, (Object) null);
    }

    public static /* synthetic */ long size$default(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return size(str, i10, i11);
    }

    public static final long size(String str, int i10) {
        return size$default(str, i10, 0, 2, (Object) null);
    }

    public static final long size(String str, int i10, int i11) {
        int i12;
        m.f(str, "$this$utf8Size");
        boolean z10 = true;
        if (i10 >= 0) {
            if (i11 >= i10) {
                if (i11 > str.length()) {
                    z10 = false;
                }
                if (z10) {
                    long j10 = 0;
                    while (i10 < i11) {
                        char charAt = str.charAt(i10);
                        if (charAt < 128) {
                            j10++;
                        } else {
                            if (charAt < 2048) {
                                i12 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i12 = 3;
                            } else {
                                int i13 = i10 + 1;
                                char charAt2 = i13 < i11 ? str.charAt(i13) : 0;
                                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                    j10++;
                                    i10 = i13;
                                } else {
                                    j10 += (long) 4;
                                    i10 += 2;
                                }
                            }
                            j10 += (long) i12;
                        }
                        i10++;
                    }
                    return j10;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        throw new IllegalArgumentException(("beginIndex < 0: " + i10).toString());
    }
}
