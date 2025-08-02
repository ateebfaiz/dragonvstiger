package com.facebook.react;

import com.facebook.jni.HybridData;
import com.facebook.react.internal.turbomodule.core.TurboModuleManagerDelegate;
import d6.a;

@Deprecated(since = "CompositeReactPackageTurboModuleManagerDelegate is deprecated and will be deleted in the future. Please use ReactPackage interface or BaseReactPackage instead.")
@a
public class CompositeReactPackageTurboModuleManagerDelegate extends s0 {
    private native void addTurboModuleManagerDelegate(TurboModuleManagerDelegate turboModuleManagerDelegate);

    /* access modifiers changed from: protected */
    public native HybridData initHybrid();
}
