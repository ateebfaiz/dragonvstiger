package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import kotlin.jvm.internal.m;
import mb.j;

class s0 {
    public static Set a(Set set) {
        m.f(set, "builder");
        return ((j) set).c();
    }

    public static Set b(int i10) {
        return new j(i10);
    }

    public static Set c(Object obj) {
        Set singleton = Collections.singleton(obj);
        m.e(singleton, "singleton(...)");
        return singleton;
    }
}
