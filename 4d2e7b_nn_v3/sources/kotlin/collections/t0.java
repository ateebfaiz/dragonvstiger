package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.m;

class t0 extends s0 {
    public static Set d() {
        return f0.f640a;
    }

    public static HashSet e(Object... objArr) {
        m.f(objArr, "elements");
        return (HashSet) n.U(objArr, new HashSet(i0.c(objArr.length)));
    }

    public static Set f(Object... objArr) {
        m.f(objArr, "elements");
        return (Set) n.U(objArr, new LinkedHashSet(i0.c(objArr.length)));
    }

    public static final Set g(Set set) {
        m.f(set, "<this>");
        int size = set.size();
        if (size == 0) {
            return r0.d();
        }
        if (size != 1) {
            return set;
        }
        return r0.c(set.iterator().next());
    }

    public static Set h(Object... objArr) {
        m.f(objArr, "elements");
        if (objArr.length > 0) {
            return n.Y(objArr);
        }
        return r0.d();
    }
}
