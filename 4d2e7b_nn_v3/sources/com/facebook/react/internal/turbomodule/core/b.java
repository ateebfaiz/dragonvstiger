package com.facebook.react.internal.turbomodule.core;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;

public final /* synthetic */ class b implements TurboModuleManager.ModuleProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TurboModuleManagerDelegate f3185a;

    public /* synthetic */ b(TurboModuleManagerDelegate turboModuleManagerDelegate) {
        this.f3185a = turboModuleManagerDelegate;
    }

    public final NativeModule getModule(String str) {
        return TurboModuleManager.lambda$new$1(this.f3185a, str);
    }
}
