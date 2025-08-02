package com.reactnativecommunity.clipboard;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeClipboardModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public NativeClipboardModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void addListener(String str);

    @ReactMethod
    @a
    public abstract void getImage(Promise promise);

    @ReactMethod
    @a
    public abstract void getImageJPG(Promise promise);

    @ReactMethod
    @a
    public abstract void getImagePNG(Promise promise);

    @ReactMethod
    @a
    public abstract void getString(Promise promise);

    @ReactMethod
    @a
    public abstract void getStrings(Promise promise);

    @ReactMethod
    @a
    public abstract void hasImage(Promise promise);

    @ReactMethod
    @a
    public abstract void hasNumber(Promise promise);

    @ReactMethod
    @a
    public abstract void hasString(Promise promise);

    @ReactMethod
    @a
    public abstract void hasURL(Promise promise);

    @ReactMethod
    @a
    public abstract void hasWebURL(Promise promise);

    @ReactMethod
    @a
    public abstract void removeListener();

    @ReactMethod
    @a
    public abstract void removeListeners(double d10);

    @ReactMethod
    @a
    public abstract void setImage(String str, Promise promise);

    @ReactMethod
    @a
    public abstract void setListener();

    @ReactMethod
    @a
    public abstract void setString(String str);

    @ReactMethod
    @a
    public abstract void setStrings(ReadableArray readableArray);
}
