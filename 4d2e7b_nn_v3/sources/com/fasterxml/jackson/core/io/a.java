package com.fasterxml.jackson.core.io;

import java.util.Arrays;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected static final char[] f5125a;

    /* renamed from: b  reason: collision with root package name */
    protected static final byte[] f5126b;

    /* renamed from: c  reason: collision with root package name */
    protected static final int[] f5127c;

    /* renamed from: d  reason: collision with root package name */
    protected static final int[] f5128d;

    /* renamed from: e  reason: collision with root package name */
    protected static final int[] f5129e;

    /* renamed from: f  reason: collision with root package name */
    protected static final int[] f5130f;

    /* renamed from: g  reason: collision with root package name */
    protected static final int[] f5131g;

    /* renamed from: h  reason: collision with root package name */
    protected static final int[] f5132h;

    /* renamed from: i  reason: collision with root package name */
    protected static final int[] f5133i;

    /* renamed from: j  reason: collision with root package name */
    protected static final int[] f5134j;

    /* renamed from: com.fasterxml.jackson.core.io.a$a  reason: collision with other inner class name */
    private static class C0069a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0069a f5135b = new C0069a();

        /* renamed from: a  reason: collision with root package name */
        private int[][] f5136a = new int[128][];

        private C0069a() {
        }

        public int[] a(int i10) {
            int[] iArr = this.f5136a[i10];
            if (iArr == null) {
                iArr = Arrays.copyOf(a.f5133i, 128);
                if (iArr[i10] == 0) {
                    iArr[i10] = -1;
                }
                this.f5136a[i10] = iArr;
            }
            return iArr;
        }
    }

    static {
        int i10;
        char[] charArray = "0123456789ABCDEF".toCharArray();
        f5125a = charArray;
        int length = charArray.length;
        f5126b = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            f5126b[i11] = (byte) f5125a[i11];
        }
        int[] iArr = new int[256];
        for (int i12 = 0; i12 < 32; i12++) {
            iArr[i12] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f5127c = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i13 = 128; i13 < 256; i13++) {
            if ((i13 & 224) == 192) {
                i10 = 2;
            } else if ((i13 & 240) == 224) {
                i10 = 3;
            } else if ((i13 & 248) == 240) {
                i10 = 4;
            } else {
                i10 = -1;
            }
            iArr2[i13] = i10;
        }
        f5128d = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i14 = 33; i14 < 256; i14++) {
            if (Character.isJavaIdentifierPart((char) i14)) {
                iArr3[i14] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f5129e = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, 128, 128, 0);
        f5130f = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = f5128d;
        System.arraycopy(iArr6, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        f5131g = iArr5;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, 128, iArr7, 128, 128);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        f5132h = iArr7;
        int[] iArr8 = new int[128];
        for (int i15 = 0; i15 < 32; i15++) {
            iArr8[i15] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        f5133i = iArr8;
        int[] iArr9 = new int[256];
        f5134j = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i16 = 0; i16 < 10; i16++) {
            f5134j[i16 + 48] = i16;
        }
        for (int i17 = 0; i17 < 6; i17++) {
            int[] iArr10 = f5134j;
            int i18 = i17 + 10;
            iArr10[i17 + 97] = i18;
            iArr10[i17 + 65] = i18;
        }
    }

    public static void a(StringBuilder sb2, String str) {
        int[] iArr = f5133i;
        int length = iArr.length;
        int length2 = str.length();
        for (int i10 = 0; i10 < length2; i10++) {
            char charAt = str.charAt(i10);
            if (charAt >= length || iArr[charAt] == 0) {
                sb2.append(charAt);
            } else {
                sb2.append('\\');
                int i11 = iArr[charAt];
                if (i11 < 0) {
                    sb2.append('u');
                    sb2.append('0');
                    sb2.append('0');
                    char[] cArr = f5125a;
                    sb2.append(cArr[charAt >> 4]);
                    sb2.append(cArr[charAt & 15]);
                } else {
                    sb2.append((char) i11);
                }
            }
        }
    }

    public static byte[] b() {
        return (byte[]) f5126b.clone();
    }

    public static char[] c() {
        return (char[]) f5125a.clone();
    }

    public static int[] d() {
        return f5133i;
    }

    public static int[] e(int i10) {
        if (i10 == 34) {
            return f5133i;
        }
        return C0069a.f5135b.a(i10);
    }
}
