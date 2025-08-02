package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

class w implements Provider, Deferred {

    /* renamed from: c  reason: collision with root package name */
    private static final Deferred.DeferredHandler f9003c = new t();

    /* renamed from: d  reason: collision with root package name */
    private static final Provider f9004d = new u();

    /* renamed from: a  reason: collision with root package name */
    private Deferred.DeferredHandler f9005a;

    /* renamed from: b  reason: collision with root package name */
    private volatile Provider f9006b;

    private w(Deferred.DeferredHandler deferredHandler, Provider provider) {
        this.f9005a = deferredHandler;
        this.f9006b = provider;
    }

    static w d() {
        return new w(f9003c, f9004d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(Provider provider) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object f() {
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2, Provider provider) {
        deferredHandler.handle(provider);
        deferredHandler2.handle(provider);
    }

    static w h(Provider provider) {
        return new w((Deferred.DeferredHandler) null, provider);
    }

    public Object get() {
        return this.f9006b.get();
    }

    /* access modifiers changed from: package-private */
    public void i(Provider provider) {
        Deferred.DeferredHandler deferredHandler;
        if (this.f9006b == f9004d) {
            synchronized (this) {
                deferredHandler = this.f9005a;
                this.f9005a = null;
                this.f9006b = provider;
            }
            deferredHandler.handle(provider);
            return;
        }
        throw new IllegalStateException("provide() can be called only once.");
    }

    public void whenAvailable(Deferred.DeferredHandler deferredHandler) {
        Provider provider;
        Provider provider2;
        Provider provider3 = this.f9006b;
        Provider provider4 = f9004d;
        if (provider3 != provider4) {
            deferredHandler.handle(provider3);
            return;
        }
        synchronized (this) {
            provider = this.f9006b;
            if (provider != provider4) {
                provider2 = provider;
            } else {
                this.f9005a = new v(this.f9005a, deferredHandler);
                provider2 = null;
            }
        }
        if (provider2 != null) {
            deferredHandler.handle(provider);
        }
    }
}
