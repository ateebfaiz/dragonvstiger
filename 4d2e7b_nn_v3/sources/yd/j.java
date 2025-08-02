package yd;

public abstract class j {
    public static int a(int i10) {
        int i11 = -1;
        while (i10 != 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static int b(int i10, int i11) {
        while (true) {
            int i12 = i11;
            int i13 = i10;
            i10 = i12;
            if (i10 == 0) {
                return i13;
            }
            i11 = e(i13, i10);
        }
    }

    public static boolean c(int i10) {
        if (i10 == 0) {
            return false;
        }
        int a10 = a(i10) >>> 1;
        int i11 = 2;
        for (int i12 = 0; i12 < a10; i12++) {
            i11 = d(i11, i11, i10);
            if (b(i11 ^ 2, i10) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int d(int i10, int i11, int i12) {
        int e10 = e(i10, i12);
        int e11 = e(i11, i12);
        int i13 = 0;
        if (e11 != 0) {
            int a10 = 1 << a(i12);
            while (e10 != 0) {
                if (((byte) (e10 & 1)) == 1) {
                    i13 ^= e11;
                }
                e10 >>>= 1;
                e11 <<= 1;
                if (e11 >= a10) {
                    e11 ^= i12;
                }
            }
        }
        return i13;
    }

    public static int e(int i10, int i11) {
        if (i11 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (a(i10) >= a(i11)) {
            i10 ^= i11 << (a(i10) - a(i11));
        }
        return i10;
    }
}
