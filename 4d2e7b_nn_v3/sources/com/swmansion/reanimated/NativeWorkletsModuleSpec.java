package com.swmansion.reanimated;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeWorkletsModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "WorkletsModule";

    public NativeWorkletsModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract boolean installTurboModule(String str);
}
