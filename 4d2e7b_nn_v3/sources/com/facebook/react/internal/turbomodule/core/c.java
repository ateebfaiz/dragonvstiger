package com.facebook.react.internal.turbomodule.core;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;

public final /* synthetic */ class c implements TurboModuleManager.ModuleProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TurboModuleManagerDelegate f3186a;

    public /* synthetic */ c(TurboModuleManagerDelegate turboModuleManagerDelegate) {
        this.f3186a = turboModuleManagerDelegate;
    }

    public final NativeModule getModule(String str) {
        return TurboModuleManager.lambda$new$2(this.f3186a, str);
    }
}
