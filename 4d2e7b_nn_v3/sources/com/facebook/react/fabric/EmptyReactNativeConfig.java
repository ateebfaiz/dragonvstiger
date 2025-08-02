package com.facebook.react.fabric;

import com.facebook.jni.HybridData;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class EmptyReactNativeConfig implements ReactNativeConfig {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HybridData mHybridData = initHybrid();

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        FabricSoLoader.staticInit();
    }

    private final native HybridData initHybrid();

    public native boolean getBool(String str);

    public native double getDouble(String str);

    public native long getInt64(String str);

    public native String getString(String str);
}
