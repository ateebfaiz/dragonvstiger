package yd;

public abstract class d {
    public static int[] a(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static boolean b(int[] iArr, int[] iArr2) {
        boolean z10;
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            if (iArr[length] == iArr2[length]) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 &= z10;
        }
        return z11;
    }
}
