package zd;

import androidx.core.view.InputDeviceCompat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class a {

    /* renamed from: zd.a$a  reason: collision with other inner class name */
    public static class C0038a implements Iterator {

        /* renamed from: a  reason: collision with root package name */
        private final Object[] f2242a;

        /* renamed from: b  reason: collision with root package name */
        private int f2243b = 0;

        public C0038a(Object[] objArr) {
            this.f2242a = objArr;
        }

        public boolean hasNext() {
            if (this.f2243b < this.f2242a.length) {
                return true;
            }
            return false;
        }

        public Object next() {
            int i10 = this.f2243b;
            Object[] objArr = this.f2242a;
            if (i10 != objArr.length) {
                this.f2243b = i10 + 1;
                return objArr[i10];
            }
            throw new NoSuchElementException("Out of elements: " + this.f2243b);
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 != bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(char[] cArr, char[] cArr2) {
        if (cArr == cArr2) {
            return true;
        }
        if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 != cArr.length; i10++) {
            if (cArr[i10] != cArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(int[] iArr, int[] iArr2) {
        if (iArr == iArr2) {
            return true;
        }
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 != iArr.length; i10++) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(short[] sArr, short[] sArr2) {
        if (sArr == sArr2) {
            return true;
        }
        if (sArr == null || sArr2 == null || sArr.length != sArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 != sArr.length; i10++) {
            if (sArr[i10] != sArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int[] f(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static long[] g(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        long[] jArr2 = new long[jArr.length];
        System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        return jArr2;
    }

    public static short[] h(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        short[] sArr2 = new short[sArr.length];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        return sArr2;
    }

    public static byte[] i(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        } else if (bArr2 != null) {
            return e(bArr2);
        } else {
            return e(bArr);
        }
    }

    public static int[] j(int[] iArr, int i10, int i11) {
        int l10 = l(i10, i11);
        int[] iArr2 = new int[l10];
        if (iArr.length - i10 < l10) {
            System.arraycopy(iArr, i10, iArr2, 0, iArr.length - i10);
        } else {
            System.arraycopy(iArr, i10, iArr2, 0, l10);
        }
        return iArr2;
    }

    public static void k(byte[] bArr, byte b10) {
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr[i10] = b10;
        }
    }

    private static int l(int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 >= 0) {
            return i12;
        }
        StringBuffer stringBuffer = new StringBuffer(i10);
        stringBuffer.append(" > ");
        stringBuffer.append(i11);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static int m(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ bArr[length];
        }
    }

    public static int n(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ cArr[length];
        }
    }

    public static int o(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ iArr[length];
        }
    }

    public static int p(int[] iArr, int i10, int i11) {
        if (iArr == null) {
            return 0;
        }
        int i12 = i11 + 1;
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12;
            }
            i12 = (i12 * InputDeviceCompat.SOURCE_KEYBOARD) ^ iArr[i10 + i11];
        }
    }

    public static int q(long[] jArr, int i10, int i11) {
        if (jArr == null) {
            return 0;
        }
        int i12 = i11 + 1;
        while (true) {
            i11--;
            if (i11 < 0) {
                return i12;
            }
            long j10 = jArr[i10 + i11];
            i12 = (((i12 * InputDeviceCompat.SOURCE_KEYBOARD) ^ ((int) j10)) * InputDeviceCompat.SOURCE_KEYBOARD) ^ ((int) (j10 >>> 32));
        }
    }

    public static int r(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int length = sArr.length;
        int i10 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i10;
            }
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) ^ (sArr[length] & 255);
        }
    }

    public static int s(short[][] sArr) {
        int i10 = 0;
        for (int i11 = 0; i11 != sArr.length; i11++) {
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) + r(sArr[i11]);
        }
        return i10;
    }

    public static int t(short[][][] sArr) {
        int i10 = 0;
        for (int i11 = 0; i11 != sArr.length; i11++) {
            i10 = (i10 * InputDeviceCompat.SOURCE_KEYBOARD) + s(sArr[i11]);
        }
        return i10;
    }

    public static int[] u(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i10 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return iArr2;
            }
            iArr2[length] = iArr[i10];
            i10++;
        }
    }
}
