package com.facebook.react.runtime;

import java.util.concurrent.Callable;

public final /* synthetic */ class t0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f3513a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f3514b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f3515c;

    public /* synthetic */ t0(ReactHostImpl reactHostImpl, String str, Exception exc) {
        this.f3513a = reactHostImpl;
        this.f3514b = str;
        this.f3515c = exc;
    }

    public final Object call() {
        return this.f3513a.O0(this.f3514b, this.f3515c);
    }
}
