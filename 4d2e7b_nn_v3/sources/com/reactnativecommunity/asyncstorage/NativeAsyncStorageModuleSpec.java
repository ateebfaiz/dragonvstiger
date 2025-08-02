package com.reactnativecommunity.asyncstorage;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeAsyncStorageModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeAsyncStorageModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void clear(Callback callback);

    @ReactMethod
    @a
    public abstract void getAllKeys(Callback callback);

    @ReactMethod
    @a
    public abstract void multiGet(ReadableArray readableArray, Callback callback);

    @ReactMethod
    @a
    public abstract void multiMerge(ReadableArray readableArray, Callback callback);

    @ReactMethod
    @a
    public abstract void multiRemove(ReadableArray readableArray, Callback callback);

    @ReactMethod
    @a
    public abstract void multiSet(ReadableArray readableArray, Callback callback);
}
