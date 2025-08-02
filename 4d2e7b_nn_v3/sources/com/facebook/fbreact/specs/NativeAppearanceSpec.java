package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeAppearanceSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Appearance";

    public NativeAppearanceSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void addListener(String str);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract String getColorScheme();

    public String getName() {
        return "Appearance";
    }

    @ReactMethod
    @a
    public abstract void removeListeners(double d10);

    @ReactMethod
    @a
    public void setColorScheme(String str) {
    }
}
