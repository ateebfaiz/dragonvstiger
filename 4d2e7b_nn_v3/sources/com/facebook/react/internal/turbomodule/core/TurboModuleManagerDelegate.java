package com.facebook.react.internal.turbomodule.core;

import androidx.annotation.Nullable;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.ArrayList;
import java.util.List;

public abstract class TurboModuleManagerDelegate {
    @a
    private final HybridData mHybridData;

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    protected TurboModuleManagerDelegate() {
        maybeLoadOtherSoLibraries();
        this.mHybridData = initHybrid();
    }

    public List<String> getEagerInitModuleNames() {
        return new ArrayList();
    }

    @Nullable
    public NativeModule getLegacyModule(String str) {
        return null;
    }

    @Nullable
    public abstract TurboModule getModule(String str);

    /* access modifiers changed from: protected */
    public abstract HybridData initHybrid();

    /* access modifiers changed from: protected */
    public synchronized void maybeLoadOtherSoLibraries() {
    }

    public boolean unstable_enableSyncVoidMethods() {
        return false;
    }

    public boolean unstable_isLegacyModuleRegistered(String str) {
        return false;
    }

    public abstract boolean unstable_isModuleRegistered(String str);

    public boolean unstable_shouldEnableLegacyModuleInterop() {
        return false;
    }

    public boolean unstable_shouldRouteTurboModulesThroughLegacyModuleInterop() {
        return false;
    }

    protected TurboModuleManagerDelegate(HybridData hybridData) {
        maybeLoadOtherSoLibraries();
        this.mHybridData = hybridData;
    }
}
