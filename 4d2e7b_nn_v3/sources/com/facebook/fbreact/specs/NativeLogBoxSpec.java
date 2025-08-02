package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeLogBoxSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "LogBox";

    public NativeLogBoxSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "LogBox";
    }

    @ReactMethod
    @a
    public abstract void hide();

    @ReactMethod
    @a
    public abstract void show();
}
