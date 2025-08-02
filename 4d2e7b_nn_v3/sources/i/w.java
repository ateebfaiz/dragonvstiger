package i;

import android.util.Base64;
import w.d;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22037a = d.e();

    public static String a(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return new String(b(Base64.decode(str, 2), str2.getBytes("utf-8")), "utf-8");
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        return c(e(d(bArr, false), d(bArr2, false)), true);
    }

    public static byte[] c(int[] iArr, boolean z10) {
        int length = iArr.length << 2;
        if (z10) {
            int i10 = iArr[iArr.length - 1];
            if (i10 > length) {
                return null;
            }
            length = i10;
        }
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = (byte) ((iArr[i11 >>> 2] >>> ((i11 & 3) << 3)) & 255);
        }
        return bArr;
    }

    public static int[] d(byte[] bArr, boolean z10) {
        int i10;
        int[] iArr;
        if ((bArr.length & 3) == 0) {
            i10 = bArr.length >>> 2;
        } else {
            i10 = (bArr.length >>> 2) + 1;
        }
        if (z10) {
            iArr = new int[(i10 + 1)];
            iArr[i10] = bArr.length;
        } else {
            iArr = new int[i10];
        }
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 >>> 2;
            iArr[i12] = iArr[i12] | ((bArr[i11] & 255) << ((i11 & 3) << 3));
        }
        return iArr;
    }

    public static int[] e(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i10 = length - 1;
        if (i10 < 1) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i11 = iArr[i10];
        int i12 = iArr[0];
        for (int i13 = ((52 / length) + 6) * -1640531527; i13 != 0; i13 -= -1640531527) {
            int i14 = (i13 >>> 2) & 3;
            int i15 = i10;
            while (i15 > 0) {
                int i16 = iArr[i15 - 1];
                i12 = iArr[i15] - (((i12 ^ i13) + (i16 ^ iArr2[(i15 & 3) ^ i14])) ^ (((i16 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i16 << 4))));
                iArr[i15] = i12;
                i15--;
            }
            int i17 = iArr[i10];
            i12 = iArr[0] - (((i12 ^ i13) + (iArr2[i14 ^ (i15 & 3)] ^ i17)) ^ (((i17 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i17 << 4))));
            iArr[0] = i12;
        }
        return iArr;
    }

    public static String f(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Base64.encodeToString(g(str.getBytes("utf-8"), str2.getBytes("utf-8")), 2);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static byte[] g(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        return c(h(d(bArr, true), d(bArr2, false)), false);
    }

    public static int[] h(int[] iArr, int[] iArr2) {
        int length = iArr.length;
        int i10 = length - 1;
        if (i10 < 1) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i11 = iArr[i10];
        int i12 = iArr[0];
        int i13 = (52 / length) + 6;
        int i14 = 0;
        while (true) {
            int i15 = i13 - 1;
            if (i13 <= 0) {
                return iArr;
            }
            i14 -= 1640531527;
            int i16 = (i14 >>> 2) & 3;
            int i17 = 0;
            while (i17 < i10) {
                int i18 = i17 + 1;
                int i19 = iArr[i18];
                i11 = ((((i11 >>> 5) ^ (i19 << 2)) + ((i19 >>> 3) ^ (i11 << 4))) ^ ((i19 ^ i14) + (i11 ^ iArr2[(i17 & 3) ^ i16]))) + iArr[i17];
                iArr[i17] = i11;
                i17 = i18;
            }
            int i20 = iArr[0];
            i11 = ((((i11 >>> 5) ^ (i20 << 2)) + ((i20 >>> 3) ^ (i11 << 4))) ^ ((i20 ^ i14) + (i11 ^ iArr2[i16 ^ (i17 & 3)]))) + iArr[i10];
            iArr[i10] = i11;
            i13 = i15;
        }
    }
}
