package com.swmansion.reanimated;

import com.facebook.react.bridge.ReactApplicationContext;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReanimatedModule f11445a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f11446b;

    public /* synthetic */ i(ReanimatedModule reanimatedModule, ReactApplicationContext reactApplicationContext) {
        this.f11445a = reanimatedModule;
        this.f11446b = reactApplicationContext;
    }

    public final void run() {
        this.f11445a.lambda$initialize$4(this.f11446b);
    }
}
