package com.google.android.datatransport.runtime.dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory<T> implements Factory<Set<T>> {
    private static final Factory<Set<Object>> EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    private final List<Provider> collectionProviders;
    private final List<Provider> individualProviders;

    public static final class Builder<T> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final List<Provider> collectionProviders;
        private final List<Provider> individualProviders;

        public Builder<T> addCollectionProvider(Provider provider) {
            this.collectionProviders.add(provider);
            return this;
        }

        public Builder<T> addProvider(Provider provider) {
            this.individualProviders.add(provider);
            return this;
        }

        public SetFactory<T> build() {
            return new SetFactory<>(this.individualProviders, this.collectionProviders);
        }

        private Builder(int i10, int i11) {
            this.individualProviders = DaggerCollections.presizedList(i10);
            this.collectionProviders = DaggerCollections.presizedList(i11);
        }
    }

    public static <T> Builder<T> builder(int i10, int i11) {
        return new Builder<>(i10, i11);
    }

    public static <T> Factory<Set<T>> empty() {
        return EMPTY_FACTORY;
    }

    private SetFactory(List<Provider> list, List<Provider> list2) {
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    public Set<T> get() {
        int size = this.individualProviders.size();
        ArrayList arrayList = new ArrayList(this.collectionProviders.size());
        int size2 = this.collectionProviders.size();
        for (int i10 = 0; i10 < size2; i10++) {
            Collection collection = (Collection) this.collectionProviders.get(i10).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet newHashSetWithExpectedSize = DaggerCollections.newHashSetWithExpectedSize(size);
        int size3 = this.individualProviders.size();
        for (int i11 = 0; i11 < size3; i11++) {
            newHashSetWithExpectedSize.add(Preconditions.checkNotNull(this.individualProviders.get(i11).get()));
        }
        int size4 = arrayList.size();
        for (int i12 = 0; i12 < size4; i12++) {
            for (Object checkNotNull : (Collection) arrayList.get(i12)) {
                newHashSetWithExpectedSize.add(Preconditions.checkNotNull(checkNotNull));
            }
        }
        return Collections.unmodifiableSet(newHashSetWithExpectedSize);
    }
}
