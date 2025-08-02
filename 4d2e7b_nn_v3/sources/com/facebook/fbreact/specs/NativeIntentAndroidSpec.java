package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeIntentAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "IntentAndroid";

    public NativeIntentAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void canOpenURL(String str, Promise promise);

    @ReactMethod
    @a
    public abstract void getInitialURL(Promise promise);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void openSettings(Promise promise);

    @ReactMethod
    @a
    public abstract void openURL(String str, Promise promise);

    @ReactMethod
    @a
    public abstract void sendIntent(String str, ReadableArray readableArray, Promise promise);
}
