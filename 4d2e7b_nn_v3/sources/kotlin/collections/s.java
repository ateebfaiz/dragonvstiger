package kotlin.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.m;
import mb.b;

class s {
    public static List a(List list) {
        m.f(list, "builder");
        return ((b) list).l();
    }

    public static final Object[] b(Object[] objArr, boolean z10) {
        m.f(objArr, "<this>");
        Class<Object[]> cls = Object[].class;
        if (z10 && m.b(objArr.getClass(), cls)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, cls);
        m.e(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static List c() {
        return new b();
    }

    public static List d(int i10) {
        return new b(i10);
    }

    public static List e(Object obj) {
        List singletonList = Collections.singletonList(obj);
        m.e(singletonList, "singletonList(...)");
        return singletonList;
    }

    public static Object[] f(int i10, Object[] objArr) {
        m.f(objArr, "array");
        if (i10 < objArr.length) {
            objArr[i10] = null;
        }
        return objArr;
    }
}
