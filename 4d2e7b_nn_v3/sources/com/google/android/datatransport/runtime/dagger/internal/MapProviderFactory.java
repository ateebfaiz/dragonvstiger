package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Map;
import javax.inject.Provider;

public final class MapProviderFactory<K, V> extends AbstractMapFactory implements Lazy<Map<K, Provider>> {

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider> {
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
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

    private MapProviderFactory(Map<K, Provider> map) {
        super(map);
    }

    public Map<K, Provider> get() {
        return contributingMap();
    }
}
