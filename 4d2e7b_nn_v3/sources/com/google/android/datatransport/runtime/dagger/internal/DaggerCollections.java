package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    private DaggerCollections() {
    }

    private static int calculateInitialCapacity(int i10) {
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((((float) i10) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static boolean hasDuplicates(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        if (list.size() != new HashSet(list).size()) {
            return true;
        }
        return false;
    }

    static <T> HashSet<T> newHashSetWithExpectedSize(int i10) {
        return new HashSet<>(calculateInitialCapacity(i10));
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i10) {
        return new LinkedHashMap<>(calculateInitialCapacity(i10));
    }

    public static <T> List<T> presizedList(int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i10);
    }
}
