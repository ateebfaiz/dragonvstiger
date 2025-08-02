package com.google.android.gms.internal.measurement;

abstract class w4 {

    /* renamed from: a  reason: collision with root package name */
    private static final t4 f7348a = new u4();

    static {
        if (r4.C() && r4.D()) {
            int i10 = h2.f7184a;
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

    static int b(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        char charAt;
        int length = charSequence.length();
        int i14 = i11 + i10;
        int i15 = 0;
        while (i15 < length && (i13 = i15 + i10) < i14 && (charAt = charSequence.charAt(i15)) < 128) {
            bArr[i13] = (byte) charAt;
            i15++;
        }
        if (i15 == length) {
            return i10 + length;
        }
        int i16 = i10 + i15;
        while (i15 < length) {
            char charAt2 = charSequence.charAt(i15);
            if (charAt2 < 128 && i16 < i14) {
                bArr[i16] = (byte) charAt2;
                i16++;
            } else if (charAt2 < 2048 && i16 <= i14 - 2) {
                int i17 = i16 + 1;
                bArr[i16] = (byte) ((charAt2 >>> 6) | 960);
                i16 += 2;
                bArr[i17] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || charAt2 > 57343) && i16 <= i14 - 3) {
                bArr[i16] = (byte) ((charAt2 >>> 12) | 480);
                int i18 = i16 + 2;
                bArr[i16 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i16 += 3;
                bArr[i18] = (byte) ((charAt2 & '?') | 128);
            } else if (i16 <= i14 - 4) {
                int i19 = i15 + 1;
                if (i19 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i19);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i16] = (byte) ((codePoint >>> 18) | 240);
                        bArr[i16 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i20 = i16 + 3;
                        bArr[i16 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i16 += 4;
                        bArr[i20] = (byte) ((codePoint & 63) | 128);
                        i15 = i19;
                    } else {
                        i15 = i19;
                    }
                }
                throw new v4(i15 - 1, length);
            } else if (charAt2 < 55296 || charAt2 > 57343 || ((i12 = i15 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i16);
            } else {
                throw new v4(i15, length);
            }
            i15++;
        }
        return i16;
    }

    static int c(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                int length2 = charSequence.length();
                while (i11 < length2) {
                    char charAt2 = charSequence.charAt(i11);
                    if (charAt2 < 2048) {
                        i10 += (127 - charAt2) >>> 31;
                    } else {
                        i10 += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i11) >= 65536) {
                                i11++;
                            } else {
                                throw new v4(i11, length2);
                            }
                        }
                    }
                    i11++;
                }
                i12 += i10;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i12) + 4294967296L));
    }

    static String d(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        if ((i10 | i11 | ((length - i10) - i11)) >= 0) {
            int i12 = i10 + i11;
            char[] cArr = new char[i11];
            int i13 = 0;
            while (r13 < i12) {
                byte b10 = bArr[r13];
                if (!s4.d(b10)) {
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
                if (s4.d(b11)) {
                    cArr[i14] = (char) b11;
                    i14++;
                    r13 = i15;
                    while (r13 < i12) {
                        byte b12 = bArr[r13];
                        if (!s4.d(b12)) {
                            break;
                        }
                        r13++;
                        cArr[i14] = (char) b12;
                        i14++;
                    }
                } else if (b11 < -32) {
                    if (i15 < i12) {
                        r13 += 2;
                        s4.c(b11, bArr[i15], cArr, i14);
                        i14++;
                    } else {
                        throw zzkp.zzc();
                    }
                } else if (b11 < -16) {
                    if (i15 < i12 - 1) {
                        int i16 = r13 + 2;
                        r13 += 3;
                        s4.b(b11, bArr[i15], bArr[i16], cArr, i14);
                        i14++;
                    } else {
                        throw zzkp.zzc();
                    }
                } else if (i15 < i12 - 2) {
                    int i17 = r13 + 2;
                    int i18 = r13 + 3;
                    r13 += 4;
                    s4.a(b11, bArr[i15], bArr[i17], bArr[i18], cArr, i14);
                    i14 += 2;
                } else {
                    throw zzkp.zzc();
                }
            }
            return new String(cArr, 0, i14);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i10), Integer.valueOf(i11)}));
    }

    static boolean e(byte[] bArr) {
        return f7348a.b(bArr, 0, bArr.length);
    }

    static boolean f(byte[] bArr, int i10, int i11) {
        return f7348a.b(bArr, i10, i11);
    }
}
