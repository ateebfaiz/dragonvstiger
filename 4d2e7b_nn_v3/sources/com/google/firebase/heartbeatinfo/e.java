package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class e implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f9115a;

    public /* synthetic */ e(Qualified qualified) {
        this.f9115a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatController.lambda$component$3(this.f9115a, componentContainer);
    }
}
