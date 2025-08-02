package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class ProviderOfLazy<T> implements Provider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider provider;

    private ProviderOfLazy(Provider provider2) {
        this.provider = provider2;
    }

    public static <T> Provider create(Provider provider2) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider2));
    }

    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }
}
