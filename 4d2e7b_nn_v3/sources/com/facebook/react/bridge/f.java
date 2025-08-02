package com.facebook.react.bridge;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CatalystInstanceImpl f2893a;

    public /* synthetic */ f(CatalystInstanceImpl catalystInstanceImpl) {
        this.f2893a = catalystInstanceImpl;
    }

    public final void run() {
        this.f2893a.lambda$incrementPendingJSCalls$4();
    }
}
