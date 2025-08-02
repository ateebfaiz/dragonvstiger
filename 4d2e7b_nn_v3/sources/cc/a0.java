package cc;

import kotlin.jvm.internal.m;

public abstract class a0 {
    public static Object a(Object obj) {
        return obj;
    }

    public static final z b(Object obj) {
        if (obj != c.f59a) {
            m.d(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (z) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        if (obj == c.f59a) {
            return true;
        }
        return false;
    }
}
