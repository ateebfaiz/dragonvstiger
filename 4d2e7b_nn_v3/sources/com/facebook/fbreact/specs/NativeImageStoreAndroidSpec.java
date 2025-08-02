package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeImageStoreAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ImageStoreManager";

    public NativeImageStoreAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void getBase64ForTag(String str, Callback callback, Callback callback2);

    public String getName() {
        return "ImageStoreManager";
    }
}
