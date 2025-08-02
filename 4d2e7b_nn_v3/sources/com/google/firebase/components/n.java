package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class n implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f8988a;

    public /* synthetic */ n(ComponentRegistrar componentRegistrar) {
        this.f8988a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.f8988a);
    }
}
