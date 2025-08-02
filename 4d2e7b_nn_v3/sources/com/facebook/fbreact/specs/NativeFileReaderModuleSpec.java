package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeFileReaderModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "FileReaderModule";

    public NativeFileReaderModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void readAsDataURL(ReadableMap readableMap, Promise promise);

    @ReactMethod
    @a
    public abstract void readAsText(ReadableMap readableMap, String str, Promise promise);
}
