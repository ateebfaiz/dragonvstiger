package com.horcrux.svg;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeSvgRenderableModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public static final String NAME = "RNSVGRenderableModule";

    public NativeSvgRenderableModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract WritableMap getBBox(Double d10, ReadableMap readableMap);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract WritableMap getCTM(Double d10);

    public String getName() {
        return "RNSVGRenderableModule";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract WritableMap getPointAtLength(Double d10, ReadableMap readableMap);

    @ReactMethod
    @a
    public abstract void getRawResource(String str, Promise promise);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract WritableMap getScreenCTM(Double d10);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract double getTotalLength(Double d10);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract boolean isPointInFill(Double d10, ReadableMap readableMap);

    @ReactMethod(isBlockingSynchronousMethod = true)
    @a
    public abstract boolean isPointInStroke(Double d10, ReadableMap readableMap);
}
