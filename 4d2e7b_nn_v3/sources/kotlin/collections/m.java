package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class m extends l {
    public static List c(Object[] objArr) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        List a10 = o.a(objArr);
        kotlin.jvm.internal.m.e(a10, "asList(...)");
        return a10;
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        kotlin.jvm.internal.m.f(bArr2, FirebaseAnalytics.Param.DESTINATION);
        System.arraycopy(bArr, i11, bArr2, i10, i12 - i11);
        return bArr2;
    }

    public static Object[] e(Object[] objArr, Object[] objArr2, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        kotlin.jvm.internal.m.f(objArr2, FirebaseAnalytics.Param.DESTINATION);
        System.arraycopy(objArr, i11, objArr2, i10, i12 - i11);
        return objArr2;
    }

    public static /* synthetic */ byte[] f(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return j.d(bArr, bArr2, i10, i11, i12);
    }

    public static /* synthetic */ Object[] g(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return j.e(objArr, objArr2, i10, i11, i12);
    }

    public static byte[] h(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        k.b(i11, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.m.e(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static Object[] i(Object[] objArr, int i10, int i11) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        k.b(i11, objArr.length);
        Object[] copyOfRange = Arrays.copyOfRange(objArr, i10, i11);
        kotlin.jvm.internal.m.e(copyOfRange, "copyOfRange(...)");
        return copyOfRange;
    }

    public static void j(int[] iArr, int i10, int i11, int i12) {
        kotlin.jvm.internal.m.f(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    public static void k(Object[] objArr, Object obj, int i10, int i11) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        Arrays.fill(objArr, i10, i11, obj);
    }

    public static /* synthetic */ void l(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        j.j(iArr, i10, i11, i12);
    }

    public static /* synthetic */ void m(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        j.k(objArr, obj, i10, i11);
    }

    public static byte[] n(byte[] bArr, byte[] bArr2) {
        kotlin.jvm.internal.m.f(bArr, "<this>");
        kotlin.jvm.internal.m.f(bArr2, "elements");
        int length = bArr.length;
        int length2 = bArr2.length;
        byte[] copyOf = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(bArr2, 0, copyOf, length, length2);
        kotlin.jvm.internal.m.c(copyOf);
        return copyOf;
    }

    public static Object[] o(Object[] objArr, Object obj) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        int length = objArr.length;
        Object[] copyOf = Arrays.copyOf(objArr, length + 1);
        copyOf[length] = obj;
        kotlin.jvm.internal.m.c(copyOf);
        return copyOf;
    }

    public static void p(Object[] objArr) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        if (objArr.length > 1) {
            Arrays.sort(objArr);
        }
    }

    public static void q(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.m.f(objArr, "<this>");
        kotlin.jvm.internal.m.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
