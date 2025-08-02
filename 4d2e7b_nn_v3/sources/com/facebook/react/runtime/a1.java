package com.facebook.react.runtime;

import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.runtime.ReactInstance;

public final /* synthetic */ class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactInstance.c f3429a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JavaOnlyMap f3430b;

    public /* synthetic */ a1(ReactInstance.c cVar, JavaOnlyMap javaOnlyMap) {
        this.f3429a = cVar;
        this.f3430b = javaOnlyMap;
    }

    public final void run() {
        this.f3429a.b(this.f3430b);
    }
}
