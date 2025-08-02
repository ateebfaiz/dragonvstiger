package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeDevToolsSettingsManagerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DevToolsSettingsManager";

    public NativeDevToolsSettingsManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract String getConsolePatchSettings();

    public String getName() {
        return NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public String getProfilingSettings() {
        return null;
    }

    @ReactMethod
    @a
    public abstract void setConsolePatchSettings(String str);

    @ReactMethod
    @a
    public void setProfilingSettings(String str) {
    }
}
