package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider, Lazy<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider provider;

    private DoubleCheck(Provider provider2) {
        this.provider = provider2;
    }

    public static <P extends Provider, T> Lazy<T> lazy(P p10) {
        if (p10 instanceof Lazy) {
            return (Lazy) p10;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p10));
    }

    public static <P extends Provider, T> Provider provider(P p10) {
        Preconditions.checkNotNull(p10);
        if (p10 instanceof DoubleCheck) {
            return p10;
        }
        return new DoubleCheck(p10);
    }

    public static Object reentrantCheck(Object obj, Object obj2) {
        if (obj == UNINITIALIZED || (obj instanceof MemoizedSentinel) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
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
                        this.instance = reentrantCheck(this.instance, t10);
                        this.provider = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t10;
    }
}
