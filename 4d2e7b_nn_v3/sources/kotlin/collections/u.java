package kotlin.collections;

import java.util.Collection;
import kotlin.jvm.internal.m;

class u extends t {
    public static int v(Iterable iterable, int i10) {
        m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return i10;
    }

    public static final Integer w(Iterable iterable) {
        m.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }
}
