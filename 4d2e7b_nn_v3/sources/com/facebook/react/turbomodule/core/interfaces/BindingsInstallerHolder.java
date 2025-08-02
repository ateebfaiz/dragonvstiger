package com.facebook.react.turbomodule.core.interfaces;

import com.facebook.jni.HybridData;
import d6.a;
import kotlin.jvm.internal.m;

@a
public final class BindingsInstallerHolder {
    @a
    private final HybridData mHybridData;

    public BindingsInstallerHolder(HybridData hybridData) {
        m.f(hybridData, "mHybridData");
        this.mHybridData = hybridData;
    }
}
