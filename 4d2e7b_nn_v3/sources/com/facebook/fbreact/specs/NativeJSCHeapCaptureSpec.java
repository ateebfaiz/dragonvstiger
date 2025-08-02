package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeJSCHeapCaptureSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "JSCHeapCapture";

    public NativeJSCHeapCaptureSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void captureComplete(String str, String str2);

    public String getName() {
        return NAME;
    }
}
