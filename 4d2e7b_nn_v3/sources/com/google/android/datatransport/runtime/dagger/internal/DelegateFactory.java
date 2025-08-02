package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

public final class DelegateFactory<T> implements Factory<T> {
    private Provider delegate;

    public static <T> void setDelegate(Provider provider, Provider provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.delegate == null) {
            delegateFactory.delegate = provider2;
            return;
        }
        throw new IllegalStateException();
    }

    public T get() {
        Provider provider = this.delegate;
        if (provider != null) {
            return provider.get();
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: package-private */
    public Provider getDelegate() {
        return (Provider) Preconditions.checkNotNull(this.delegate);
    }

    @Deprecated
    public void setDelegatedProvider(Provider provider) {
        setDelegate(this, provider);
    }
}
