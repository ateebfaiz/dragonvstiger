package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

class z extends y {
    public static List K(List list) {
        m.f(list, "<this>");
        return new p0(list);
    }

    public static List L(List list) {
        m.f(list, "<this>");
        return new o0(list);
    }

    /* access modifiers changed from: private */
    public static final int M(List list, int i10) {
        if (new IntRange(0, r.n(list)).b(i10)) {
            return r.n(list) - i10;
        }
        throw new IndexOutOfBoundsException("Element index " + i10 + " must be in range [" + new IntRange(0, r.n(list)) + "].");
    }

    /* access modifiers changed from: private */
    public static final int N(List list, int i10) {
        return r.n(list) - i10;
    }

    /* access modifiers changed from: private */
    public static final int O(List list, int i10) {
        if (new IntRange(0, list.size()).b(i10)) {
            return list.size() - i10;
        }
        throw new IndexOutOfBoundsException("Position index " + i10 + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
