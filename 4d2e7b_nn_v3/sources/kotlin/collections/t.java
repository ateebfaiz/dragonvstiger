package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import nb.a;

class t extends s {
    public static ArrayList g(Object... objArr) {
        m.f(objArr, "elements");
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new h(objArr, true));
    }

    public static final Collection h(Object[] objArr) {
        m.f(objArr, "<this>");
        return new h(objArr, false);
    }

    public static int i(List list, int i10, int i11, Function1 function1) {
        m.f(list, "<this>");
        m.f(function1, "comparison");
        s(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int intValue = ((Number) function1.invoke(list.get(i13))).intValue();
            if (intValue < 0) {
                i10 = i13 + 1;
            } else if (intValue <= 0) {
                return i13;
            } else {
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static final int j(List list, Comparable comparable, int i10, int i11) {
        m.f(list, "<this>");
        s(list.size(), i10, i11);
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int a10 = a.a((Comparable) list.get(i13), comparable);
            if (a10 < 0) {
                i10 = i13 + 1;
            } else if (a10 <= 0) {
                return i13;
            } else {
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int k(List list, Comparable comparable, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = list.size();
        }
        return j(list, comparable, i10, i11);
    }

    public static List l() {
        return d0.f638a;
    }

    public static IntRange m(Collection collection) {
        m.f(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }

    public static int n(List list) {
        m.f(list, "<this>");
        return list.size() - 1;
    }

    public static List o(Object... objArr) {
        m.f(objArr, "elements");
        if (objArr.length > 0) {
            return j.c(objArr);
        }
        return r.l();
    }

    public static List p(Object... objArr) {
        m.f(objArr, "elements");
        return j.t(objArr);
    }

    public static List q(Object... objArr) {
        m.f(objArr, "elements");
        if (objArr.length == 0) {
            return new ArrayList();
        }
        return new ArrayList(new h(objArr, true));
    }

    public static final List r(List list) {
        m.f(list, "<this>");
        int size = list.size();
        if (size == 0) {
            return r.l();
        }
        if (size != 1) {
            return list;
        }
        return r.e(list.get(0));
    }

    private static final void s(int i10, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException("fromIndex (" + i11 + ") is greater than toIndex (" + i12 + ").");
        } else if (i11 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i11 + ") is less than zero.");
        } else if (i12 > i10) {
            throw new IndexOutOfBoundsException("toIndex (" + i12 + ") is greater than size (" + i10 + ").");
        }
    }

    public static void t() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void u() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
