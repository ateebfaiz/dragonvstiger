package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativePermissionsAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "PermissionsAndroid";

    public NativePermissionsAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void checkPermission(String str, Promise promise);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void requestMultiplePermissions(ReadableArray readableArray, Promise promise);

    @ReactMethod
    @a
    public abstract void requestPermission(String str, Promise promise);

    @ReactMethod
    @a
    public abstract void shouldShowRequestPermissionRationale(String str, Promise promise);
}
