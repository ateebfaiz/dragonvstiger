package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeImageLoaderAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ImageLoader";

    public NativeImageLoaderAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void abortRequest(double d10);

    public String getName() {
        return "ImageLoader";
    }

    @ReactMethod
    @a
    public abstract void getSize(String str, Promise promise);

    @ReactMethod
    @a
    public abstract void getSizeWithHeaders(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    @a
    public abstract void prefetchImage(String str, double d10, Promise promise);

    @ReactMethod
    @a
    public abstract void queryCache(ReadableArray readableArray, Promise promise);
}
