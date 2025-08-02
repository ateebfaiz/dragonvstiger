package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.Map;

public abstract class NativeDeviceInfoSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "DeviceInfo";

    public NativeDeviceInfoSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

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
