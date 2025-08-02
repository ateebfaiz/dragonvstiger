package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeTimingSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Timing";

    public NativeTimingSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void createTimer(double d10, double d11, double d12, boolean z10);

    @ReactMethod
    @a
    public abstract void deleteTimer(double d10);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void setSendIdleEvents(boolean z10);
}
