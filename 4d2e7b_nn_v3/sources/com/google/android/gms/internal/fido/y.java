package com.google.android.gms.internal.fido;

import java.util.Comparator;
import java.util.SortedSet;

abstract class y {
    public static boolean a(Comparator comparator, Iterable iterable) {
        Object obj;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            obj = ((SortedSet) iterable).comparator();
            if (obj == null) {
                obj = q.f7085a;
            }
        } else if (!(iterable instanceof x)) {
            return false;
        } else {
            obj = ((x) iterable).comparator();
        }
        return comparator.equals(obj);
    }
}
