package u1;

import java.util.Arrays;
import okio.Utf8;

public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f24261a = {-42, -112, -23, -2, -52, -31, 61, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, 13, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, Byte.MAX_VALUE, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};

    /* renamed from: b  reason: collision with root package name */
    private static int[] f24262b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    private static int a(int i10) {
        byte[] bArr = f24261a;
        return (bArr[i10 & 255] & 255) | ((bArr[(i10 >>> 24) & 255] & 255) << 24) | ((bArr[(i10 >>> 16) & 255] & 255) << 16) | ((bArr[(i10 >>> 8) & 255] & 255) << 8);
    }

    private static int b(int i10) {
        return e(i10, 24) ^ (((e(i10, 2) ^ i10) ^ e(i10, 10)) ^ e(i10, 18));
    }

    private static int c(int i10) {
        return e(i10, 23) ^ (e(i10, 13) ^ i10);
    }

    private static int[] d(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i10 * 4;
            iArr[i10] = (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
        }
        return iArr;
    }

    private static int e(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    private static void f(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
    }

    public static byte[] g(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (!(bArr3 == null || bArr3.length == 16)) {
            bArr3 = null;
        }
        int[] p10 = p(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i10 = 0;
        while (true) {
            int i11 = i10 + 16;
            if (i11 > bArr.length) {
                return n(bArr6);
            }
            System.arraycopy(bArr, i10, bArr4, 0, 16);
            o(bArr4, bArr5, p10);
            if (bArr3 != null) {
                f(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i10, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i10, 16);
            i10 = i11;
        }
    }

    public static byte[] h(byte[] bArr, String str) {
        return g(bArr, l(str), str.substring(0, 16).getBytes("utf-8"));
    }

    public static byte[] i(byte[] bArr, String str, String str2) {
        return g(bArr, l(str), str2.getBytes("utf-8"));
    }

    public static byte[] j(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (!(bArr3 == null || bArr3.length == 16)) {
            bArr3 = null;
        }
        byte[] m10 = m(bArr);
        int[] p10 = p(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[m10.length];
        int i10 = 0;
        while (true) {
            int i11 = i10 + 16;
            if (i11 > m10.length) {
                return bArr5;
            }
            System.arraycopy(m10, i10, bArr4, 0, 16);
            if (bArr3 != null) {
                f(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            o(bArr4, bArr3, p10);
            System.arraycopy(bArr3, 0, bArr5, i10, bArr3.length);
            i10 = i11;
        }
    }

    public static byte[] k(byte[] bArr, String str, String str2) {
        return j(bArr, l(str), str2.getBytes("utf-8"));
    }

    public static byte[] l(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (q(charArray[i11 + 1]) | (q(charArray[i11]) << 4));
        }
        return bArr;
    }

    private static byte[] m(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i10 = 0; i10 < length; i10++) {
            copyOf[bArr.length + i10] = (byte) length;
        }
        return copyOf;
    }

    private static byte[] n(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static void o(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] d10 = d(bArr);
        for (int i10 = 0; i10 < 32; i10 += 4) {
            int b10 = d10[0] ^ b(a(((d10[1] ^ d10[2]) ^ d10[3]) ^ iArr[i10]));
            d10[0] = b10;
            int b11 = b(a((b10 ^ (d10[2] ^ d10[3])) ^ iArr[i10 + 1])) ^ d10[1];
            d10[1] = b11;
            int b12 = b(a((b11 ^ (d10[3] ^ d10[0])) ^ iArr[i10 + 2])) ^ d10[2];
            d10[2] = b12;
            d10[3] = b(a((b12 ^ (d10[1] ^ d10[0])) ^ iArr[i10 + 3])) ^ d10[3];
        }
        for (int i11 = 0; i11 < 16; i11 += 4) {
            int i12 = d10[3 - (i11 / 4)];
            bArr2[i11] = (byte) ((i12 >>> 24) & 255);
            bArr2[i11 + 1] = (byte) ((i12 >>> 16) & 255);
            bArr2[i11 + 2] = (byte) ((i12 >>> 8) & 255);
            bArr2[i11 + 3] = (byte) (i12 & 255);
        }
    }

    public static int[] p(byte[] bArr, boolean z10) {
        int[] d10 = d(bArr);
        d10[0] = d10[0] ^ -1548633402;
        d10[1] = d10[1] ^ 1453994832;
        d10[2] = d10[2] ^ 1736282519;
        d10[3] = d10[3] ^ -1301273892;
        int[] iArr = new int[32];
        for (int i10 = 0; i10 < 32; i10 += 4) {
            int c10 = d10[0] ^ c(a(((d10[1] ^ d10[2]) ^ d10[3]) ^ f24262b[i10]));
            d10[0] = c10;
            iArr[i10] = c10;
            int i11 = i10 + 1;
            int c11 = d10[1] ^ c(a(((d10[2] ^ d10[3]) ^ d10[0]) ^ f24262b[i11]));
            d10[1] = c11;
            iArr[i11] = c11;
            int i12 = i10 + 2;
            int c12 = d10[2] ^ c(a(((d10[3] ^ d10[0]) ^ d10[1]) ^ f24262b[i12]));
            d10[2] = c12;
            iArr[i12] = c12;
            int i13 = i10 + 3;
            int c13 = d10[3] ^ c(a(((d10[0] ^ d10[1]) ^ d10[2]) ^ f24262b[i13]));
            d10[3] = c13;
            iArr[i13] = c13;
        }
        if (z10) {
            for (int i14 = 0; i14 < 16; i14++) {
                int i15 = iArr[i14];
                int i16 = 31 - i14;
                iArr[i14] = iArr[i16];
                iArr[i16] = i15;
            }
        }
        return iArr;
    }

    private static int q(char c10) {
        return (byte) "0123456789abcdef".indexOf(c10);
    }
}
