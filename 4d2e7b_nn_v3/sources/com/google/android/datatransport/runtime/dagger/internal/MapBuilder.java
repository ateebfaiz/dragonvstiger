package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.Map;

public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    private MapBuilder(int i10) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i10);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i10) {
        return new MapBuilder<>(i10);
    }

    public Map<K, V> build() {
        if (this.contributions.size() != 0) {
            return Collections.unmodifiableMap(this.contributions);
        }
        return Collections.emptyMap();
    }

    public MapBuilder<K, V> put(K k10, V v10) {
        this.contributions.put(k10, v10);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }
}
