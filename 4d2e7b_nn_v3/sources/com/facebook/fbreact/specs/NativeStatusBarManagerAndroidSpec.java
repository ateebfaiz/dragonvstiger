package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.Map;

public abstract class NativeStatusBarManagerAndroidSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "StatusBarManager";

    public NativeStatusBarManagerAndroidSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @a
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }

    public String getName() {
        return "StatusBarManager";
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    @a
    public abstract void setColor(double d10, boolean z10);

    @ReactMethod
    @a
    public abstract void setHidden(boolean z10);

    @ReactMethod
    @a
    public abstract void setStyle(String str);

    @ReactMethod
    @a
    public abstract void setTranslucent(boolean z10);
}
