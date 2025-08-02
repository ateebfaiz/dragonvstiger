package kotlin.collections;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.m;

class l0 extends k0 {
    public static Map f() {
        e0 e0Var = e0.f639a;
        m.d(e0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return e0Var;
    }

    public static HashMap g(Pair... pairArr) {
        m.f(pairArr, "pairs");
        HashMap hashMap = new HashMap(i0.c(pairArr.length));
        m(hashMap, pairArr);
        return hashMap;
    }

    public static LinkedHashMap h(Pair... pairArr) {
        m.f(pairArr, "pairs");
        return (LinkedHashMap) q(pairArr, new LinkedHashMap(i0.c(pairArr.length)));
    }

    public static Map i(Pair... pairArr) {
        m.f(pairArr, "pairs");
        if (pairArr.length > 0) {
            return q(pairArr, new LinkedHashMap(i0.c(pairArr.length)));
        }
        return i0.f();
    }

    public static Map j(Pair... pairArr) {
        m.f(pairArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(i0.c(pairArr.length));
        m(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final Map k(Map map) {
        m.f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return i0.f();
        }
        if (size != 1) {
            return map;
        }
        return k0.e(map);
    }

    public static final void l(Map map, Iterable iterable) {
        m.f(map, "<this>");
        m.f(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            map.put(pair.a(), pair.b());
        }
    }

    public static final void m(Map map, Pair[] pairArr) {
        m.f(map, "<this>");
        m.f(pairArr, "pairs");
        for (Pair pair : pairArr) {
            map.put(pair.a(), pair.b());
        }
    }

    public static Map n(Iterable iterable) {
        Object next;
        m.f(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return k(o(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i0.f();
        }
        if (size != 1) {
            return o(iterable, new LinkedHashMap(i0.c(collection.size())));
        }
        if (iterable instanceof List) {
            next = ((List) iterable).get(0);
        } else {
            next = iterable.iterator().next();
        }
        return i0.d((Pair) next);
    }

    public static final Map o(Iterable iterable, Map map) {
        m.f(iterable, "<this>");
        m.f(map, FirebaseAnalytics.Param.DESTINATION);
        l(map, iterable);
        return map;
    }

    public static Map p(Map map) {
        m.f(map, "<this>");
        int size = map.size();
        if (size == 0) {
            return i0.f();
        }
        if (size != 1) {
            return i0.r(map);
        }
        return k0.e(map);
    }

    public static final Map q(Pair[] pairArr, Map map) {
        m.f(pairArr, "<this>");
        m.f(map, FirebaseAnalytics.Param.DESTINATION);
        m(map, pairArr);
        return map;
    }

    public static Map r(Map map) {
        m.f(map, "<this>");
        return new LinkedHashMap(map);
    }
}
