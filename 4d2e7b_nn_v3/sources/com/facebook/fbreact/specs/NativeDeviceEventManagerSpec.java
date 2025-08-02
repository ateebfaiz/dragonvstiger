package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeDeviceEventManagerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DeviceEventManager";

    public NativeDeviceEventManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void invokeDefaultBackPressHandler();
}
