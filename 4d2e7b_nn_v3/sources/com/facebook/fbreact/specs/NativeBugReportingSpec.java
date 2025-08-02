package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeBugReportingSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "BugReporting";

    public NativeBugReportingSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void setExtraData(ReadableMap readableMap, ReadableMap readableMap2);

    @ReactMethod
    @a
    public abstract void startReportAProblemFlow();
}
