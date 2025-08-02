package com.google.firebase.concurrent;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class x implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.LITE_EXECUTOR.get();
    }
}
