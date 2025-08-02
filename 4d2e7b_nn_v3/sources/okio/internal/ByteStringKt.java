package okio.internal;

import java.util.Arrays;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.SegmentedByteString;
import okio.Util;

public final class ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            r3 = 1
            int r4 = r0.length
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x0009:
            if (r5 >= r4) goto L_0x01a8
            byte r8 = r0[r5]
            r9 = 65533(0xfffd, float:9.1831E-41)
            r10 = 127(0x7f, float:1.78E-43)
            r11 = 159(0x9f, float:2.23E-43)
            r12 = 31
            r13 = 13
            r14 = 10
            r15 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            if (r8 < 0) goto L_0x0063
            int r17 = r7 + 1
            if (r7 != r1) goto L_0x0025
            return r6
        L_0x0025:
            if (r8 == r14) goto L_0x0033
            if (r8 == r13) goto L_0x0033
            if (r8 < 0) goto L_0x002d
            if (r12 >= r8) goto L_0x0035
        L_0x002d:
            if (r10 <= r8) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            if (r11 < r8) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            if (r8 != r9) goto L_0x0036
        L_0x0035:
            return r16
        L_0x0036:
            if (r8 >= r15) goto L_0x003a
            r7 = r3
            goto L_0x003b
        L_0x003a:
            r7 = 2
        L_0x003b:
            int r6 = r6 + r7
            int r5 = r5 + r3
        L_0x003d:
            r7 = r17
            if (r5 >= r4) goto L_0x0009
            byte r8 = r0[r5]
            if (r8 < 0) goto L_0x0009
            int r5 = r5 + r3
            int r17 = r7 + 1
            if (r7 != r1) goto L_0x004b
            return r6
        L_0x004b:
            if (r8 == r14) goto L_0x0059
            if (r8 == r13) goto L_0x0059
            if (r8 < 0) goto L_0x0053
            if (r12 >= r8) goto L_0x005b
        L_0x0053:
            if (r10 <= r8) goto L_0x0056
            goto L_0x0059
        L_0x0056:
            if (r11 < r8) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            if (r8 != r9) goto L_0x005c
        L_0x005b:
            return r16
        L_0x005c:
            if (r8 >= r15) goto L_0x0060
            r7 = r3
            goto L_0x0061
        L_0x0060:
            r7 = 2
        L_0x0061:
            int r6 = r6 + r7
            goto L_0x003d
        L_0x0063:
            int r2 = r8 >> 5
            r15 = -2
            r9 = 128(0x80, float:1.794E-43)
            if (r2 != r15) goto L_0x00af
            int r2 = r5 + 1
            if (r4 > r2) goto L_0x0072
            if (r7 != r1) goto L_0x0071
            return r6
        L_0x0071:
            return r16
        L_0x0072:
            byte r2 = r0[r2]
            r15 = r2 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x00ab
            r2 = r2 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r8 << 6
            r2 = r2 ^ r8
            if (r2 >= r9) goto L_0x0083
            if (r7 != r1) goto L_0x0082
            return r6
        L_0x0082:
            return r16
        L_0x0083:
            int r8 = r7 + 1
            if (r7 != r1) goto L_0x0088
            return r6
        L_0x0088:
            if (r2 == r14) goto L_0x0096
            if (r2 == r13) goto L_0x0096
            if (r2 < 0) goto L_0x0090
            if (r12 >= r2) goto L_0x009b
        L_0x0090:
            if (r10 <= r2) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            if (r11 < r2) goto L_0x0096
            goto L_0x009b
        L_0x0096:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x009c
        L_0x009b:
            return r16
        L_0x009c:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x00a2
            r2 = r3
            goto L_0x00a3
        L_0x00a2:
            r2 = 2
        L_0x00a3:
            int r6 = r6 + r2
            kotlin.Unit r2 = kotlin.Unit.f12577a
            r2 = 2
            int r5 = r5 + r2
        L_0x00a8:
            r7 = r8
            goto L_0x0009
        L_0x00ab:
            if (r7 != r1) goto L_0x00ae
            return r6
        L_0x00ae:
            return r16
        L_0x00af:
            r2 = 2
            int r11 = r8 >> 4
            r10 = 55296(0xd800, float:7.7486E-41)
            r12 = 57343(0xdfff, float:8.0355E-41)
            if (r11 != r15) goto L_0x011f
            int r11 = r5 + 2
            if (r4 > r11) goto L_0x00c2
            if (r7 != r1) goto L_0x00c1
            return r6
        L_0x00c1:
            return r16
        L_0x00c2:
            int r2 = r5 + 1
            byte r2 = r0[r2]
            r15 = r2 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x011b
            byte r11 = r0[r11]
            r15 = r11 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x0117
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r11
            int r2 = r2 << 6
            r2 = r2 ^ r9
            int r8 = r8 << 12
            r2 = r2 ^ r8
            r8 = 2048(0x800, float:2.87E-42)
            if (r2 >= r8) goto L_0x00e2
            if (r7 != r1) goto L_0x00e1
            return r6
        L_0x00e1:
            return r16
        L_0x00e2:
            if (r10 <= r2) goto L_0x00e5
            goto L_0x00eb
        L_0x00e5:
            if (r12 < r2) goto L_0x00eb
            if (r7 != r1) goto L_0x00ea
            return r6
        L_0x00ea:
            return r16
        L_0x00eb:
            int r8 = r7 + 1
            if (r7 != r1) goto L_0x00f0
            return r6
        L_0x00f0:
            if (r2 == r14) goto L_0x0104
            if (r2 == r13) goto L_0x0104
            if (r2 < 0) goto L_0x00fa
            r7 = 31
            if (r7 >= r2) goto L_0x0109
        L_0x00fa:
            r7 = 127(0x7f, float:1.78E-43)
            if (r7 <= r2) goto L_0x00ff
            goto L_0x0104
        L_0x00ff:
            r7 = 159(0x9f, float:2.23E-43)
            if (r7 < r2) goto L_0x0104
            goto L_0x0109
        L_0x0104:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x010a
        L_0x0109:
            return r16
        L_0x010a:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x0110
            r2 = r3
            goto L_0x0111
        L_0x0110:
            r2 = 2
        L_0x0111:
            int r6 = r6 + r2
            kotlin.Unit r2 = kotlin.Unit.f12577a
            int r5 = r5 + 3
            goto L_0x00a8
        L_0x0117:
            if (r7 != r1) goto L_0x011a
            return r6
        L_0x011a:
            return r16
        L_0x011b:
            if (r7 != r1) goto L_0x011e
            return r6
        L_0x011e:
            return r16
        L_0x011f:
            int r2 = r8 >> 3
            if (r2 != r15) goto L_0x01a4
            int r2 = r5 + 3
            if (r4 > r2) goto L_0x012b
            if (r7 != r1) goto L_0x012a
            return r6
        L_0x012a:
            return r16
        L_0x012b:
            int r11 = r5 + 1
            byte r11 = r0[r11]
            r15 = r11 & 192(0xc0, float:2.69E-43)
            if (r15 != r9) goto L_0x01a0
            r15 = 2
            int r17 = r5 + 2
            byte r15 = r0[r17]
            r13 = r15 & 192(0xc0, float:2.69E-43)
            if (r13 != r9) goto L_0x019c
            byte r2 = r0[r2]
            r13 = r2 & 192(0xc0, float:2.69E-43)
            if (r13 != r9) goto L_0x0198
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r2 = r2 ^ r9
            int r9 = r15 << 6
            r2 = r2 ^ r9
            int r9 = r11 << 12
            r2 = r2 ^ r9
            int r8 = r8 << 18
            r2 = r2 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r2 <= r8) goto L_0x0158
            if (r7 != r1) goto L_0x0157
            return r6
        L_0x0157:
            return r16
        L_0x0158:
            if (r10 <= r2) goto L_0x015d
        L_0x015a:
            r8 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0163
        L_0x015d:
            if (r12 < r2) goto L_0x015a
            if (r7 != r1) goto L_0x0162
            return r6
        L_0x0162:
            return r16
        L_0x0163:
            if (r2 >= r8) goto L_0x0169
            if (r7 != r1) goto L_0x0168
            return r6
        L_0x0168:
            return r16
        L_0x0169:
            int r8 = r7 + 1
            if (r7 != r1) goto L_0x016e
            return r6
        L_0x016e:
            if (r2 == r14) goto L_0x0184
            r7 = 13
            if (r2 == r7) goto L_0x0184
            if (r2 < 0) goto L_0x017a
            r7 = 31
            if (r7 >= r2) goto L_0x0189
        L_0x017a:
            r7 = 127(0x7f, float:1.78E-43)
            if (r7 <= r2) goto L_0x017f
            goto L_0x0184
        L_0x017f:
            r7 = 159(0x9f, float:2.23E-43)
            if (r7 < r2) goto L_0x0184
            goto L_0x0189
        L_0x0184:
            r7 = 65533(0xfffd, float:9.1831E-41)
            if (r2 != r7) goto L_0x018a
        L_0x0189:
            return r16
        L_0x018a:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r2 >= r7) goto L_0x0190
            r2 = r3
            goto L_0x0191
        L_0x0190:
            r2 = 2
        L_0x0191:
            int r6 = r6 + r2
            kotlin.Unit r2 = kotlin.Unit.f12577a
            int r5 = r5 + 4
            goto L_0x00a8
        L_0x0198:
            if (r7 != r1) goto L_0x019b
            return r6
        L_0x019b:
            return r16
        L_0x019c:
            if (r7 != r1) goto L_0x019f
            return r6
        L_0x019f:
            return r16
        L_0x01a0:
            if (r7 != r1) goto L_0x01a3
            return r6
        L_0x01a3:
            return r16
        L_0x01a4:
            if (r7 != r1) goto L_0x01a7
            return r6
        L_0x01a7:
            return r16
        L_0x01a8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    public static final String commonBase64(ByteString byteString) {
        m.f(byteString, "$this$commonBase64");
        return Base64.encodeBase64$default(byteString.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        m.f(byteString, "$this$commonBase64Url");
        return Base64.encodeBase64(byteString.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString byteString, ByteString byteString2) {
        m.f(byteString, "$this$commonCompareTo");
        m.f(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        int i10 = 0;
        while (i10 < min) {
            byte b10 = byteString.getByte(i10) & 255;
            byte b11 = byteString2.getByte(i10) & 255;
            if (b10 == b11) {
                i10++;
            } else if (b10 < b11) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final ByteString commonDecodeBase64(String str) {
        m.f(str, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String str) {
        boolean z10;
        m.f(str, "$this$commonDecodeHex");
        if (str.length() % 2 == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = i10 * 2;
                bArr[i10] = (byte) ((decodeHexDigit(str.charAt(i11)) << 4) + decodeHexDigit(str.charAt(i11 + 1)));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    public static final ByteString commonDigest(ByteString byteString, String str) {
        m.f(byteString, "$this$commonDigest");
        m.f(str, "algorithm");
        HashFunction newHashFunction = HashFunctionKt.newHashFunction(str);
        newHashFunction.update(byteString.getData$okio(), 0, byteString.size());
        return new ByteString(newHashFunction.digest());
    }

    public static final ByteString commonEncodeUtf8(String str) {
        m.f(str, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString byteString2) {
        m.f(byteString, "$this$commonEndsWith");
        m.f(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEquals(ByteString byteString, Object obj) {
        m.f(byteString, "$this$commonEquals");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            if (byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(ByteString byteString, int i10) {
        m.f(byteString, "$this$commonGetByte");
        return byteString.getData$okio()[i10];
    }

    public static final int commonGetSize(ByteString byteString) {
        m.f(byteString, "$this$commonGetSize");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(ByteString byteString) {
        m.f(byteString, "$this$commonHashCode");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final String commonHex(ByteString byteString) {
        m.f(byteString, "$this$commonHex");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        int i10 = 0;
        for (byte b10 : byteString.getData$okio()) {
            int i11 = i10 + 1;
            cArr[i10] = getHEX_DIGIT_CHARS()[(b10 >> 4) & 15];
            i10 += 2;
            cArr[i11] = getHEX_DIGIT_CHARS()[b10 & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(ByteString byteString, byte[] bArr, int i10) {
        m.f(byteString, "$this$commonIndexOf");
        m.f(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i10, 0);
        if (max > length) {
            return -1;
        }
        while (!Util.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        m.f(byteString, "$this$commonInternalArray");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString byteString2, int i10) {
        m.f(byteString, "$this$commonLastIndexOf");
        m.f(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i10);
    }

    public static final ByteString commonOf(byte[] bArr) {
        m.f(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i10, ByteString byteString2, int i11, int i12) {
        m.f(byteString, "$this$commonRangeEquals");
        m.f(byteString2, "other");
        return byteString2.rangeEquals(i11, byteString.getData$okio(), i10, i12);
    }

    public static final ByteString commonSegmentDigest(SegmentedByteString segmentedByteString, String str) {
        m.f(segmentedByteString, "$this$commonSegmentDigest");
        m.f(str, "algorithm");
        HashFunction newHashFunction = HashFunctionKt.newHashFunction(str);
        int length = segmentedByteString.getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = segmentedByteString.getDirectory$okio()[length + i10];
            int i13 = segmentedByteString.getDirectory$okio()[i10];
            newHashFunction.update(segmentedByteString.getSegments$okio()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        return new ByteString(newHashFunction.digest());
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString byteString2) {
        m.f(byteString, "$this$commonStartsWith");
        m.f(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final ByteString commonSubstring(ByteString byteString, int i10, int i11) {
        boolean z10;
        boolean z11;
        m.f(byteString, "$this$commonSubstring");
        boolean z12 = false;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i11 <= byteString.getData$okio().length) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (i11 - i10 >= 0) {
                    z12 = true;
                }
                if (!z12) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i10 == 0 && i11 == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new ByteString(j.h(byteString.getData$okio(), i10, i11));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final ByteString commonToAsciiLowercase(ByteString byteString) {
        byte b10;
        m.f(byteString, "$this$commonToAsciiLowercase");
        int i10 = 0;
        while (i10 < byteString.getData$okio().length) {
            byte b11 = byteString.getData$okio()[i10];
            byte b12 = (byte) 65;
            if (b11 < b12 || b11 > (b10 = (byte) 90)) {
                i10++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString commonToAsciiUppercase(ByteString byteString) {
        byte b10;
        m.f(byteString, "$this$commonToAsciiUppercase");
        int i10 = 0;
        while (i10 < byteString.getData$okio().length) {
            byte b11 = byteString.getData$okio()[i10];
            byte b12 = (byte) 97;
            if (b11 < b12 || b11 > (b10 = (byte) 122)) {
                i10++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b11 - 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final byte[] commonToByteArray(ByteString byteString) {
        m.f(byteString, "$this$commonToByteArray");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        m.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public static final ByteString commonToByteString(byte[] bArr, int i10, int i11) {
        m.f(bArr, "$this$commonToByteString");
        Util.checkOffsetAndCount((long) bArr.length, (long) i10, (long) i11);
        return new ByteString(j.h(bArr, i10, i11 + i10));
    }

    public static final String commonToString(ByteString byteString) {
        boolean z10;
        ByteString byteString2 = byteString;
        m.f(byteString2, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            if (utf8 != null) {
                String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                m.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String z11 = kotlin.text.j.z(kotlin.text.j.z(kotlin.text.j.z(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
                if (access$codePointIndexToCharIndex < utf8.length()) {
                    return "[size=" + byteString.getData$okio().length + " text=" + z11 + "…]";
                }
                return "[text=" + z11 + ']';
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(byteString.getData$okio().length);
            sb2.append(" hex=");
            if (64 <= byteString.getData$okio().length) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                if (64 != byteString.getData$okio().length) {
                    byteString2 = new ByteString(j.h(byteString.getData$okio(), 0, 64));
                }
                sb2.append(byteString2.hex());
                sb2.append("…]");
                return sb2.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
    }

    public static final String commonUtf8(ByteString byteString) {
        m.f(byteString, "$this$commonUtf8");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = Platform.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int i10, int i11) {
        m.f(byteString, "$this$commonWrite");
        m.f(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i10, i11);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c10) {
        if ('0' <= c10 && '9' >= c10) {
            return c10 - '0';
        }
        if ('a' <= c10 && 'f' >= c10) {
            return c10 - 'W';
        }
        if ('A' <= c10 && 'F' >= c10) {
            return c10 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c10);
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] bArr) {
        m.f(byteString, "$this$commonEndsWith");
        m.f(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] bArr, int i10) {
        m.f(byteString, "$this$commonLastIndexOf");
        m.f(bArr, "other");
        for (int min = Math.min(i10, byteString.getData$okio().length - bArr.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i10, byte[] bArr, int i11, int i12) {
        m.f(byteString, "$this$commonRangeEquals");
        m.f(bArr, "other");
        return i10 >= 0 && i10 <= byteString.getData$okio().length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && Util.arrayRangeEquals(byteString.getData$okio(), i10, bArr, i11, i12);
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] bArr) {
        m.f(byteString, "$this$commonStartsWith");
        m.f(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }
}
