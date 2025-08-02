package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

public final class SingleCheck<T> implements Provider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider provider;

    private SingleCheck(Provider provider2) {
        this.provider = provider2;
    }

    public static <P extends Provider, T> Provider provider(P p10) {
        if ((p10 instanceof SingleCheck) || (p10 instanceof DoubleCheck)) {
            return p10;
        }
        return new SingleCheck((Provider) Preconditions.checkNotNull(p10));
    }

    public T get() {
        T t10 = this.instance;
        if (t10 != UNINITIALIZED) {
            return t10;
        }
        Provider provider2 = this.provider;
        if (provider2 == null) {
            return this.instance;
        }
        T t11 = provider2.get();
        this.instance = t11;
        this.provider = null;
        return t11;
    }
}
