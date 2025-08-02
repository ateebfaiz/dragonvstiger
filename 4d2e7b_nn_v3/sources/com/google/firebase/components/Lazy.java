package com.google.firebase.components;

import androidx.annotation.VisibleForTesting;
import com.google.firebase.inject.Provider;

public class Lazy<T> implements Provider<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    Lazy(T t10) {
        this.instance = t10;
    }

    public T get() {
        T t10 = this.instance;
        T t11 = UNINITIALIZED;
        if (t10 == t11) {
            synchronized (this) {
                try {
                    t10 = this.instance;
                    if (t10 == t11) {
                        t10 = this.provider.get();
                        this.instance = t10;
                        this.provider = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t10;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isInitialized() {
        if (this.instance != UNINITIALIZED) {
            return true;
        }
        return false;
    }

    public Lazy(Provider<T> provider2) {
        this.provider = provider2;
    }
}
