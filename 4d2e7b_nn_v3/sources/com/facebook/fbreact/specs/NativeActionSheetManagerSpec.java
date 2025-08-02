package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeActionSheetManagerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ActionSheetManager";

    public NativeActionSheetManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public void dismissActionSheet() {
    }

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void showActionSheetWithOptions(ReadableMap readableMap, Callback callback);

    @ReactMethod
    @a
    public abstract void showShareActionSheetWithOptions(ReadableMap readableMap, Callback callback, Callback callback2);
}
