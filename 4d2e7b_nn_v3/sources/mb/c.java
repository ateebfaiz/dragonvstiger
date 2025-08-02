package mb;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;

public abstract class c {
    public static final Object[] d(int i10) {
        if (i10 >= 0) {
            return new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final Object[] e(Object[] objArr, int i10) {
        m.f(objArr, "<this>");
        Object[] copyOf = Arrays.copyOf(objArr, i10);
        m.e(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final void f(Object[] objArr, int i10) {
        m.f(objArr, "<this>");
        objArr[i10] = null;
    }

    public static final void g(Object[] objArr, int i10, int i11) {
        m.f(objArr, "<this>");
        while (i10 < i11) {
            f(objArr, i10);
            i10++;
        }
    }

    /* access modifiers changed from: private */
    public static final boolean h(Object[] objArr, int i10, int i11, List list) {
        if (i11 != list.size()) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            if (!m.b(objArr[i10 + i12], list.get(i12))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final int i(Object[] objArr, int i10, int i11) {
        int i12;
        int i13 = 1;
        for (int i14 = 0; i14 < i11; i14++) {
            Object obj = objArr[i10 + i14];
            int i15 = i13 * 31;
            if (obj != null) {
                i12 = obj.hashCode();
            } else {
                i12 = 0;
            }
            i13 = i15 + i12;
        }
        return i13;
    }

    /* access modifiers changed from: private */
    public static final String j(Object[] objArr, int i10, int i11, Collection collection) {
        StringBuilder sb2 = new StringBuilder((i11 * 3) + 2);
        sb2.append("[");
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            Collection collection2 = objArr[i10 + i12];
            if (collection2 == collection) {
                sb2.append("(this Collection)");
            } else {
                sb2.append(collection2);
            }
        }
        sb2.append("]");
        String sb3 = sb2.toString();
        m.e(sb3, "toString(...)");
        return sb3;
    }
}
