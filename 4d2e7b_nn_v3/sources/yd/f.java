package yd;

public abstract class f {
    public static void a(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 3] = (byte) (i10 >>> 24);
    }

    public static void b(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= 0; i13--) {
            bArr[i11 + i13] = (byte) (i10 >>> (i13 * 8));
        }
    }

    public static byte[] c(int i10) {
        return new byte[]{(byte) i10, (byte) (i10 >>> 8), (byte) (i10 >>> 16), (byte) (i10 >>> 24)};
    }

    public static int d(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static int e(byte[] bArr, int i10) {
        int i11 = i10 + 2;
        int i12 = (bArr[i10 + 1] & 255) << 8;
        return ((bArr[i10 + 3] & 255) << 24) | i12 | (bArr[i10] & 255) | ((bArr[i11] & 255) << 16);
    }

    public static int f(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            i12 |= (bArr[i10 + i13] & 255) << (i13 * 8);
        }
        return i12;
    }
}
