package com.facebook.fbreact.specs;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;
import java.util.Map;

public abstract class NativeBlobModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "BlobModule";

    public NativeBlobModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void addNetworkingHandler();

    @ReactMethod
    @a
    public abstract void addWebSocketHandler(double d10);

    @ReactMethod
    @a
    public abstract void createFromParts(ReadableArray readableArray, String str);

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
    public abstract void release(String str);

    @ReactMethod
    @a
    public abstract void removeWebSocketHandler(double d10);

    @ReactMethod
    @a
    public abstract void sendOverSocket(ReadableMap readableMap, double d10);
}
