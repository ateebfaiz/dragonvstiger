package com.facebook.react.runtime;

import java.util.concurrent.Callable;

public final /* synthetic */ class v0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f3520a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3521b;

    public /* synthetic */ v0(ReactHostImpl reactHostImpl, String str) {
        this.f3520a = reactHostImpl;
        this.f3521b = str;
    }

    public final Object call() {
        return this.f3520a.o1(this.f3521b);
    }
}
