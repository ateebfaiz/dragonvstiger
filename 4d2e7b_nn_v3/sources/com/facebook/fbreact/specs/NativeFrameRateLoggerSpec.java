package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeFrameRateLoggerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "FrameRateLogger";

    public NativeFrameRateLoggerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void beginScroll();

    @ReactMethod
    @a
    public abstract void endScroll();

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void setContext(String str);

    @ReactMethod
    @a
    public abstract void setGlobalOptions(ReadableMap readableMap);
}
