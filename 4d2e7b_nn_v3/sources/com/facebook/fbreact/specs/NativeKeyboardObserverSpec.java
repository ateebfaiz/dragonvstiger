package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeKeyboardObserverSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "KeyboardObserver";

    public NativeKeyboardObserverSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void addListener(String str);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void removeListeners(double d10);
}
