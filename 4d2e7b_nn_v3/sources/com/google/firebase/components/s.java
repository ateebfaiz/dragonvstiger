package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class s implements Provider {

    /* renamed from: a  reason: collision with root package name */
    private volatile Set f8999a = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: b  reason: collision with root package name */
    private volatile Set f9000b = null;

    s(Collection collection) {
        this.f8999a.addAll(collection);
    }

    static s b(Collection collection) {
        return new s((Set) collection);
    }

    private synchronized void d() {
        try {
            for (Provider provider : this.f8999a) {
                this.f9000b.add(provider.get());
            }
            this.f8999a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(Provider provider) {
        try {
            if (this.f9000b == null) {
                this.f8999a.add(provider);
            } else {
                this.f9000b.add(provider.get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: c */
    public Set get() {
        if (this.f9000b == null) {
            synchronized (this) {
                try {
                    if (this.f9000b == null) {
                        this.f9000b = Collections.newSetFromMap(new ConcurrentHashMap());
                        d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Collections.unmodifiableSet(this.f9000b);
    }
}
