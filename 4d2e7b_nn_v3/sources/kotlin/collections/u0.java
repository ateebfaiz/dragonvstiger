package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.m;

class u0 extends t0 {
    public static Set i(Set set, Iterable iterable) {
        m.f(set, "<this>");
        m.f(iterable, "elements");
        Collection B = y.B(iterable);
        if (B.isEmpty()) {
            return r.A0(set);
        }
        if (B instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (Object next : set) {
                if (!B.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(B);
        return linkedHashSet2;
    }

    public static Set j(Set set, Iterable iterable) {
        int i10;
        m.f(set, "<this>");
        m.f(iterable, "elements");
        Integer w10 = u.w(iterable);
        if (w10 != null) {
            i10 = set.size() + w10.intValue();
        } else {
            i10 = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(i0.c(i10));
        linkedHashSet.addAll(set);
        r.z(linkedHashSet, iterable);
        return linkedHashSet;
    }
}
