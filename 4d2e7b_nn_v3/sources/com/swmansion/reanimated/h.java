package com.swmansion.reanimated;

import com.facebook.react.uimanager.UIManagerModule;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReanimatedModule f11443a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UIManagerModule f11444b;

    public /* synthetic */ h(ReanimatedModule reanimatedModule, UIManagerModule uIManagerModule) {
        this.f11443a = reanimatedModule;
        this.f11444b = uIManagerModule;
    }

    public final void run() {
        this.f11443a.lambda$initialize$3(this.f11444b);
    }
}
