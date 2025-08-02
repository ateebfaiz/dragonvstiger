package com.facebook.react.runtime;

import com.facebook.react.uimanager.ComponentNameResolver;

public final /* synthetic */ class w0 implements ComponentNameResolver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactInstance f3525a;

    public /* synthetic */ w0(ReactInstance reactInstance) {
        this.f3525a = reactInstance;
    }

    public final String[] getComponentNames() {
        return this.f3525a.t();
    }
}
