package androidx.core.content.res;

import java.lang.reflect.Array;

abstract class c {
    public static int[] a(int[] iArr, int i10, int i11) {
        if (i10 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i10)];
            System.arraycopy(iArr, 0, iArr2, 0, i10);
            iArr = iArr2;
        }
        iArr[i10] = i11;
        return iArr;
    }

    public static Object[] b(Object[] objArr, int i10, Object obj) {
        if (i10 + 1 > objArr.length) {
            Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), c(i10));
            System.arraycopy(objArr, 0, objArr2, 0, i10);
            objArr = objArr2;
        }
        objArr[i10] = obj;
        return objArr;
    }

    public static int c(int i10) {
        if (i10 <= 4) {
            return 8;
        }
        return i10 * 2;
    }
}
