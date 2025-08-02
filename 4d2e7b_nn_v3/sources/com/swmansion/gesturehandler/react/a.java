package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerModule;
import kotlin.jvm.internal.m;

public abstract class a {
    public static final DeviceEventManagerModule.RCTDeviceEventEmitter a(ReactContext reactContext) {
        m.f(reactContext, "<this>");
        JavaScriptModule jSModule = reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        m.e(jSModule, "getJSModule(...)");
        return (DeviceEventManagerModule.RCTDeviceEventEmitter) jSModule;
    }

    public static final UIManagerModule b(ReactContext reactContext) {
        m.f(reactContext, "<this>");
        NativeModule nativeModule = reactContext.getNativeModule(UIManagerModule.class);
        m.c(nativeModule);
        return (UIManagerModule) nativeModule;
    }

    public static final boolean c(Context context) {
        m.f(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        m.d(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        return ((AccessibilityManager) systemService).isTouchExplorationEnabled();
    }
}
