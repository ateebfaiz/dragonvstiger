package yd;

import java.lang.reflect.Array;

public abstract class c {
    public static a a(b bVar, i iVar) {
        b bVar2 = bVar;
        i iVar2 = iVar;
        int d10 = bVar.d();
        int i10 = 1 << d10;
        int g10 = iVar.g();
        int[] iArr = new int[2];
        iArr[1] = i10;
        int i11 = 0;
        iArr[0] = g10;
        Class cls = Integer.TYPE;
        int[][] iArr2 = (int[][]) Array.newInstance(cls, iArr);
        int[] iArr3 = new int[2];
        iArr3[1] = i10;
        iArr3[0] = g10;
        int[][] iArr4 = (int[][]) Array.newInstance(cls, iArr3);
        for (int i12 = 0; i12 < i10; i12++) {
            iArr4[0][i12] = bVar2.f(iVar2.e(i12));
        }
        for (int i13 = 1; i13 < g10; i13++) {
            for (int i14 = 0; i14 < i10; i14++) {
                iArr4[i13][i14] = bVar2.h(iArr4[i13 - 1][i14], i14);
            }
        }
        int i15 = 0;
        while (i15 < g10) {
            int i16 = i11;
            while (i16 < i10) {
                for (int i17 = i11; i17 <= i15; i17++) {
                    int[] iArr5 = iArr2[i15];
                    iArr5[i16] = bVar2.a(iArr5[i16], bVar2.h(iArr4[i17][i16], iVar2.f((g10 + i17) - i15)));
                }
                i16++;
                i11 = 0;
            }
            i15++;
            i11 = 0;
        }
        int[] iArr6 = new int[2];
        iArr6[1] = (i10 + 31) >>> 5;
        iArr6[0] = g10 * d10;
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, iArr6);
        for (int i18 = 0; i18 < i10; i18++) {
            int i19 = i18 >>> 5;
            int i20 = 1 << (i18 & 31);
            for (int i21 = 0; i21 < g10; i21++) {
                int i22 = iArr2[i21][i18];
                for (int i23 = 0; i23 < d10; i23++) {
                    if (((i22 >>> i23) & 1) != 0) {
                        int[] iArr8 = iArr7[(((i21 + 1) * d10) - i23) - 1];
                        iArr8[i19] = iArr8[i19] ^ i20;
                    }
                }
            }
        }
        return new a(i10, iArr7);
    }
}
