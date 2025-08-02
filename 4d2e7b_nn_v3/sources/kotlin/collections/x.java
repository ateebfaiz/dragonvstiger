package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.jvm.internal.m;

class x extends w {
    public static void x(List list) {
        m.f(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void y(List list, Comparator comparator) {
        m.f(list, "<this>");
        m.f(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
