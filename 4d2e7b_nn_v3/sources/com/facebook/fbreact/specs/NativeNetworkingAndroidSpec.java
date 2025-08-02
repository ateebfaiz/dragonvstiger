package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeNetworkingAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Networking";

    public NativeNetworkingAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void abortRequest(double d10);

    @ReactMethod
    @a
    public abstract void addListener(String str);

    @ReactMethod
    @a
    public abstract void clearCookies(Callback callback);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void removeListeners(double d10);

    @ReactMethod
    @a
    public abstract void sendRequest(String str, String str2, double d10, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z10, double d11, boolean z11);
}
