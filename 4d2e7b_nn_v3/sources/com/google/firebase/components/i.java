package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class i implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f8981a;

    public /* synthetic */ i(ComponentRegistrar componentRegistrar) {
        this.f8981a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.lambda$toProviders$1(this.f8981a);
    }
}
