package com.facebook.react.bridge;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CatalystInstanceImpl f2895a;

    public /* synthetic */ h(CatalystInstanceImpl catalystInstanceImpl) {
        this.f2895a = catalystInstanceImpl;
    }

    public final void run() {
        this.f2895a.lambda$decrementPendingJSCalls$5();
    }
}
