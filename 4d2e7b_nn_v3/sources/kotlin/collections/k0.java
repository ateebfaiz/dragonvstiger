package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.m;
import mb.d;

class k0 extends j0 {
    public static Map a(Map map) {
        m.f(map, "builder");
        return ((d) map).n();
    }

    public static Map b(int i10) {
        return new d(i10);
    }

    public static int c(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((((float) i10) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map d(Pair pair) {
        m.f(pair, "pair");
        Map singletonMap = Collections.singletonMap(pair.c(), pair.d());
        m.e(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final Map e(Map map) {
        m.f(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        m.e(singletonMap, "with(...)");
        return singletonMap;
    }
}
