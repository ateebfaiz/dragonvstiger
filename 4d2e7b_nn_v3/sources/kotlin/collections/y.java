package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

class y extends x {
    public static boolean A(Collection collection, Object[] objArr) {
        m.f(collection, "<this>");
        m.f(objArr, "elements");
        return collection.addAll(j.c(objArr));
    }

    public static final Collection B(Iterable iterable) {
        m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            iterable = r.w0(iterable);
        }
        return (Collection) iterable;
    }

    private static final boolean C(Iterable iterable, Function1 function1, boolean z10) {
        Iterator it = iterable.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            if (((Boolean) function1.invoke(it.next())).booleanValue() == z10) {
                it.remove();
                z11 = true;
            }
        }
        return z11;
    }

    private static final boolean D(List list, Function1 function1, boolean z10) {
        if (!(list instanceof RandomAccess)) {
            m.d(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return C(c0.b(list), function1, z10);
        }
        g0 e10 = new IntRange(0, r.n(list)).iterator();
        int i10 = 0;
        while (e10.hasNext()) {
            int nextInt = e10.nextInt();
            Object obj = list.get(nextInt);
            if (((Boolean) function1.invoke(obj)).booleanValue() != z10) {
                if (i10 != nextInt) {
                    list.set(i10, obj);
                }
                i10++;
            }
        }
        if (i10 >= list.size()) {
            return false;
        }
        int n10 = r.n(list);
        if (i10 > n10) {
            return true;
        }
        while (true) {
            list.remove(n10);
            if (n10 == i10) {
                return true;
            }
            n10--;
        }
    }

    public static boolean E(List list, Function1 function1) {
        m.f(list, "<this>");
        m.f(function1, "predicate");
        return D(list, function1, true);
    }

    public static Object F(List list) {
        m.f(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(r.n(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final boolean G(Collection collection, Iterable iterable) {
        m.f(collection, "<this>");
        m.f(iterable, "elements");
        return collection.retainAll(B(iterable));
    }

    public static boolean z(Collection collection, Iterable iterable) {
        m.f(collection, "<this>");
        m.f(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z10 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z10 = true;
            }
        }
        return z10;
    }
}
