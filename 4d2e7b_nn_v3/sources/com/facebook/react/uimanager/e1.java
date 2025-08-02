package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import java.util.Collection;

public class e1 extends ReactContext {

    /* renamed from: a  reason: collision with root package name */
    private final ReactApplicationContext f3580a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3581b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3582c;

    public e1(ReactApplicationContext reactApplicationContext, Context context, String str, int i10) {
        super(context);
        initializeFromOther(reactApplicationContext);
        this.f3580a = reactApplicationContext;
        this.f3581b = str;
        this.f3582c = i10;
    }

    public void addLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.f3580a.addLifecycleEventListener(lifecycleEventListener);
    }

    public ReactApplicationContext b() {
        return this.f3580a;
    }

    public int c() {
        return this.f3582c;
    }

    public void destroy() {
        this.f3580a.destroy();
    }

    public CatalystInstance getCatalystInstance() {
        return this.f3580a.getCatalystInstance();
    }

    public Activity getCurrentActivity() {
        return this.f3580a.getCurrentActivity();
    }

    public UIManager getFabricUIManager() {
        return this.f3580a.getFabricUIManager();
    }

    public CallInvokerHolder getJSCallInvokerHolder() {
        return this.f3580a.getJSCallInvokerHolder();
    }

    public JavaScriptModule getJSModule(Class cls) {
        return this.f3580a.getJSModule(cls);
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.f3580a.getJavaScriptContextHolder();
    }

    public NativeModule getNativeModule(Class cls) {
        return this.f3580a.getNativeModule(cls);
    }

    public Collection getNativeModules() {
        return this.f3580a.getNativeModules();
    }

    public String getSourceURL() {
        return this.f3580a.getSourceURL();
    }

    public void handleException(Exception exc) {
        this.f3580a.handleException(exc);
    }

    public boolean hasActiveCatalystInstance() {
        return this.f3580a.hasActiveCatalystInstance();
    }

    public boolean hasActiveReactInstance() {
        return this.f3580a.hasActiveCatalystInstance();
    }

    public boolean hasCatalystInstance() {
        return this.f3580a.hasCatalystInstance();
    }

    public boolean hasCurrentActivity() {
        return this.f3580a.hasCurrentActivity();
    }

    public boolean hasNativeModule(Class cls) {
        return this.f3580a.hasNativeModule(cls);
    }

    public boolean hasReactInstance() {
        return this.f3580a.hasReactInstance();
    }

    public boolean isBridgeless() {
        return this.f3580a.isBridgeless();
    }

    public void registerSegment(int i10, String str, Callback callback) {
        this.f3580a.registerSegment(i10, str, callback);
    }

    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.f3580a.removeLifecycleEventListener(lifecycleEventListener);
    }

    public NativeModule getNativeModule(String str) {
        return this.f3580a.getNativeModule(str);
    }
}
