package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.s0;

public final /* synthetic */ class q0 implements s0.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f20912a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ReactApplicationContext f20913b;

    public /* synthetic */ q0(b bVar, ReactApplicationContext reactApplicationContext) {
        this.f20912a = bVar;
        this.f20913b = reactApplicationContext;
    }

    public final NativeModule getModule(String str) {
        return this.f20912a.getModule(str, this.f20913b);
    }
}
