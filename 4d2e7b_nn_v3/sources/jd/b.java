package jd;

import java.util.Random;

public abstract class b {
    private static int a(int i10) {
        int i11 = 0;
        while ((i10 & 1) == 0) {
            i10 >>>= 1;
            i11++;
        }
        return i11;
    }

    private static void b(int[] iArr, int i10, int[] iArr2, int[] iArr3) {
        if (i10 < 0) {
            m.a(iArr.length, iArr2, iArr, iArr3);
        } else {
            System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
        }
    }

    private static int c(int[] iArr, int[] iArr2, int i10, int[] iArr3, int i11) {
        int i12;
        int M;
        int length = iArr.length;
        int i13 = 0;
        while (true) {
            i12 = iArr2[0];
            if (i12 != 0) {
                break;
            }
            m.B(i10, iArr2, 0);
            i13 += 32;
        }
        int a10 = a(i12);
        if (a10 > 0) {
            m.z(i10, iArr2, a10, 0);
            i13 += a10;
        }
        for (int i14 = 0; i14 < i13; i14++) {
            if ((iArr3[0] & 1) != 0) {
                if (i11 < 0) {
                    M = m.e(length, iArr, iArr3);
                } else {
                    M = m.M(length, iArr, iArr3);
                }
                i11 += M;
            }
            m.y(length, iArr3, i11);
        }
        return i11;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10;
        int length = iArr.length;
        if (!m.v(length, iArr2)) {
            int i11 = 0;
            if (m.u(length, iArr2)) {
                System.arraycopy(iArr2, 0, iArr3, 0, length);
                return;
            }
            int[] h10 = m.h(length, iArr2);
            int[] i12 = m.i(length);
            i12[0] = 1;
            if ((1 & h10[0]) == 0) {
                i10 = c(iArr, h10, length, i12, 0);
            } else {
                i10 = 0;
            }
            if (m.u(length, h10)) {
                b(iArr, i10, i12, iArr3);
                return;
            }
            int[] h11 = m.h(length, iArr);
            int[] i13 = m.i(length);
            int i14 = length;
            while (true) {
                int i15 = i14 - 1;
                if (h10[i15] == 0 && h11[i15] == 0) {
                    i14--;
                } else if (m.p(i14, h10, h11)) {
                    m.M(i14, h11, h10);
                    i10 = c(iArr, h10, i14, i12, i10 + (m.M(length, i13, i12) - i11));
                    if (m.u(i14, h10)) {
                        b(iArr, i10, i12, iArr3);
                        return;
                    }
                } else {
                    m.M(i14, h10, h11);
                    i11 = c(iArr, h11, i14, i13, i11 + (m.M(length, i12, i13) - i10));
                    if (m.u(i14, h11)) {
                        b(iArr, i11, i13, iArr3);
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("'x' cannot be 0");
        }
    }

    public static int[] e(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] i10 = m.i(length);
        int i11 = length - 1;
        int i12 = iArr[i11];
        int i13 = i12 | (i12 >>> 1);
        int i14 = i13 | (i13 >>> 2);
        int i15 = i14 | (i14 >>> 4);
        int i16 = i15 | (i15 >>> 8);
        int i17 = i16 | (i16 >>> 16);
        do {
            for (int i18 = 0; i18 != length; i18++) {
                i10[i18] = random.nextInt();
            }
            i10[i11] = i10[i11] & i17;
        } while (m.p(length, i10, iArr));
        return i10;
    }
}
