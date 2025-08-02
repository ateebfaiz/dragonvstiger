package com.facebook.fbreact.specs;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import d6.a;

public abstract class NativeAnimatedModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "NativeAnimatedModule";

    public NativeAnimatedModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    @a
    public abstract void addAnimatedEventToView(double d10, String str, ReadableMap readableMap);

    @ReactMethod
    @a
    public abstract void addListener(String str);

    @ReactMethod
    @a
    public abstract void connectAnimatedNodeToView(double d10, double d11);

    @ReactMethod
    @a
    public abstract void connectAnimatedNodes(double d10, double d11);

    @ReactMethod
    @a
    public abstract void createAnimatedNode(double d10, ReadableMap readableMap);

    @ReactMethod
    @a
    public abstract void disconnectAnimatedNodeFromView(double d10, double d11);

    @ReactMethod
    @a
    public abstract void disconnectAnimatedNodes(double d10, double d11);

    @ReactMethod
    @a
    public abstract void dropAnimatedNode(double d10);

    @ReactMethod
    @a
    public abstract void extractAnimatedNodeOffset(double d10);

    @ReactMethod
    @a
    public abstract void finishOperationBatch();

    @ReactMethod
    @a
    public abstract void flattenAnimatedNodeOffset(double d10);

    public String getName() {
        return NAME;
    }

    @ReactMethod
    @a
    public abstract void getValue(double d10, Callback callback);

    @ReactMethod
    @a
    public void queueAndExecuteBatchedOperations(ReadableArray readableArray) {
    }

    @ReactMethod
    @a
    public abstract void removeAnimatedEventFromView(double d10, String str, double d11);

    @ReactMethod
    @a
    public abstract void removeListeners(double d10);

    @ReactMethod
    @a
    public abstract void restoreDefaultValues(double d10);

    @ReactMethod
    @a
    public abstract void setAnimatedNodeOffset(double d10, double d11);

    @ReactMethod
    @a
    public abstract void setAnimatedNodeValue(double d10, double d11);

    @ReactMethod
    @a
    public abstract void startAnimatingNode(double d10, double d11, ReadableMap readableMap, Callback callback);

    @ReactMethod
    @a
    public abstract void startListeningToAnimatedNodeValue(double d10);

    @ReactMethod
    @a
    public abstract void startOperationBatch();

    @ReactMethod
    @a
    public abstract void stopAnimation(double d10);

    @ReactMethod
    @a
    public abstract void stopListeningToAnimatedNodeValue(double d10);

    @ReactMethod
    @a
    public void updateAnimatedNodeConfig(double d10, ReadableMap readableMap) {
    }
}
