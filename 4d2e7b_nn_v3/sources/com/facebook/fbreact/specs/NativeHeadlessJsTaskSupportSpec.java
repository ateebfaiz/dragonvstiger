package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeHeadlessJsTaskSupportSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "HeadlessJsTaskSupport";

    public NativeHeadlessJsTaskSupportSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void notifyTaskFinished(double d10);

    @ReactMethod
    @a
    public abstract void notifyTaskRetry(double d10, Promise promise);
}
