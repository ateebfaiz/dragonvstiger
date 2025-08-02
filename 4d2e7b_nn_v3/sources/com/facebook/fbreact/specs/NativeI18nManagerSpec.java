package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.Map;

public abstract class NativeI18nManagerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "I18nManager";

    public NativeI18nManagerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void allowRTL(boolean z10);

    @ReactMethod
    @a
    public abstract void forceRTL(boolean z10);

    @a
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    public String getName() {
        return NAME;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    @a
    public abstract void swapLeftAndRightInRTL(boolean z10);
}
