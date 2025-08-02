package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

abstract class AbstractMapFactory implements Factory {
    /* access modifiers changed from: private */
    public final Map<Object, Provider> contributingMap;

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider> map;

        Builder(int i10) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i10);
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V, V2> put(K k10, Provider provider) {
            this.map.put(Preconditions.checkNotNull(k10, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V, V2> putAll(Provider provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).getDelegate());
            }
            this.map.putAll(((AbstractMapFactory) provider).contributingMap);
            return this;
        }
    }

    AbstractMapFactory(Map map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<Object, Provider> contributingMap() {
        return this.contributingMap;
    }
}
