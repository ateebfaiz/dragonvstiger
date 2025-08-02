package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class k implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f8982a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f8983b;

    public /* synthetic */ k(ComponentRuntime componentRuntime, Component component) {
        this.f8982a = componentRuntime;
        this.f8983b = component;
    }

    public final Object get() {
        return this.f8982a.lambda$discoverComponents$0(this.f8983b);
    }
}
