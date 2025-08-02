package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeClipboardSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Clipboard";

    public NativeClipboardSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "Clipboard";
    }

    @ReactMethod
    @a
    public abstract void getString(Promise promise);

    @ReactMethod
    @a
    public abstract void setString(String str);
}
