package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class v implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f9001a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f9002b;

    public /* synthetic */ v(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2) {
        this.f9001a = deferredHandler;
        this.f9002b = deferredHandler2;
    }

    public final void handle(Provider provider) {
        w.g(this.f9001a, this.f9002b, provider);
    }
}
