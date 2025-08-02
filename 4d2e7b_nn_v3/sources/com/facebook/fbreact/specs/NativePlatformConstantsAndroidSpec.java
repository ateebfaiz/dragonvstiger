package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.Map;

public abstract class NativePlatformConstantsAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "PlatformConstants";

    public NativePlatformConstantsAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract String getAndroidID();

    @a
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    public String getName() {
        return NAME;
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();
}
