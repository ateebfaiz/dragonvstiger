package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeVibrationSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Vibration";

    public NativeVibrationSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void cancel();

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void vibrate(double d10);

    @ReactMethod
    @a
    public abstract void vibrateByPattern(ReadableArray readableArray, double d10);
}
