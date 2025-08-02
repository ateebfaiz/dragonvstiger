package com.facebook.react.bridge;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CatalystInstanceImpl f2896a;

    public /* synthetic */ i(CatalystInstanceImpl catalystInstanceImpl) {
        this.f2896a = catalystInstanceImpl;
    }

    public final void run() {
        this.f2896a.mNativeModuleRegistry.onBatchComplete();
    }
}
