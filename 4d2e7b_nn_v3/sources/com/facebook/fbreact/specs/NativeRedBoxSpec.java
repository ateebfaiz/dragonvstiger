package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeRedBoxSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RedBox";

    public NativeRedBoxSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void dismiss();

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void setExtraData(ReadableMap readableMap, String str);
}
