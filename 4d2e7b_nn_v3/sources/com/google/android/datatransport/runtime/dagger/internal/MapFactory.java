package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

public final class MapFactory<K, V> extends AbstractMapFactory {
    private static final Provider EMPTY = InstanceFactory.create(Collections.emptyMap());

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, V> {
        public MapFactory<K, V> build() {
            return new MapFactory<>(this.map);
        }

        private Builder(int i10) {
            super(i10);
        }

        public Builder<K, V> put(K k10, Provider provider) {
            super.put(k10, provider);
            return this;
        }

        public Builder<K, V> putAll(Provider provider) {
            super.putAll(provider);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder(int i10) {
        return new Builder<>(i10);
    }

    public static <K, V> Provider emptyMapProvider() {
        return EMPTY;
    }

    private MapFactory(Map<K, Provider> map) {
        super(map);
    }

    public Map<K, V> get() {
        LinkedHashMap newLinkedHashMapWithExpectedSize = DaggerCollections.newLinkedHashMapWithExpectedSize(contributingMap().size());
        for (Map.Entry next : contributingMap().entrySet()) {
            newLinkedHashMapWithExpectedSize.put(next.getKey(), ((Provider) next.getValue()).get());
        }
        return Collections.unmodifiableMap(newLinkedHashMapWithExpectedSize);
    }
}
