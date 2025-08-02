package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeJSCSamplingProfilerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "JSCSamplingProfiler";

    public NativeJSCSamplingProfilerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void operationComplete(double d10, String str, String str2);
}
