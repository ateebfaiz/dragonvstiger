package com.facebook.react.runtime;

import android.content.res.AssetManager;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeArrayInterface;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import d6.a;
import java.util.Collection;
import kotlin.jvm.internal.m;

@a
public final class BridgelessCatalystInstance implements CatalystInstance {

    /* renamed from: a  reason: collision with root package name */
    private final ReactHostImpl f3361a;

    public BridgelessCatalystInstance(ReactHostImpl reactHostImpl) {
        m.f(reactHostImpl, "reactHost");
        this.f3361a = reactHostImpl;
    }

    public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        m.f(notThreadSafeBridgeIdleDebugListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw new UnsupportedOperationException("Unimplemented method 'addBridgeIdleDebugListener'");
    }

    public void callFunction(String str, String str2, NativeArray nativeArray) {
        m.f(str, "module");
        m.f(str2, FirebaseAnalytics.Param.METHOD);
        throw new UnsupportedOperationException("Unimplemented method 'callFunction'");
    }

    public void destroy() {
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    public void extendNativeModules(NativeModuleRegistry nativeModuleRegistry) {
        m.f(nativeModuleRegistry, "modules");
        throw new UnsupportedOperationException("Unimplemented method 'extendNativeModules'");
    }

    public UIManager getFabricUIManager() {
        throw new UnsupportedOperationException("Unimplemented method 'getFabricUIManager'");
    }

    public CallInvokerHolder getJSCallInvokerHolder() {
        CallInvokerHolder l02 = this.f3361a.l0();
        m.c(l02);
        return l02;
    }

    public JavaScriptModule getJSModule(Class cls) {
        m.f(cls, "jsInterface");
        ReactContext h02 = this.f3361a.h0();
        if (h02 != null) {
            return h02.getJSModule(cls);
        }
        return null;
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        JavaScriptContextHolder m02 = this.f3361a.m0();
        m.c(m02);
        return m02;
    }

    public NativeMethodCallInvokerHolder getNativeMethodCallInvokerHolder() {
        throw new UnsupportedOperationException("Unimplemented method 'getNativeMethodCallInvokerHolder'");
    }

    public NativeModule getNativeModule(Class cls) {
        m.f(cls, "nativeModuleInterface");
        return this.f3361a.p0(cls);
    }

    public Collection getNativeModules() {
        Collection r02 = this.f3361a.r0();
        m.e(r02, "getNativeModules(...)");
        return r02;
    }

    public ReactQueueConfiguration getReactQueueConfiguration() {
        ReactQueueConfiguration y02 = this.f3361a.y0();
        m.c(y02);
        return y02;
    }

    public RuntimeExecutor getRuntimeExecutor() {
        return this.f3361a.z0();
    }

    public RuntimeScheduler getRuntimeScheduler() {
        throw new UnsupportedOperationException("Unimplemented method 'getRuntimeScheduler'");
    }

    public String getSourceURL() {
        throw new UnsupportedOperationException("Unimplemented method 'getSourceURL'");
    }

    public void handleMemoryPressure(int i10) {
        throw new UnsupportedOperationException("Unimplemented method 'handleMemoryPressure'");
    }

    public boolean hasNativeModule(Class cls) {
        m.f(cls, "nativeModuleInterface");
        return this.f3361a.C0(cls);
    }

    public boolean hasRunJSBundle() {
        throw new UnsupportedOperationException("Unimplemented method 'hasRunJSBundle'");
    }

    public void initialize() {
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @a
    public void invokeCallback(int i10, NativeArrayInterface nativeArrayInterface) {
        m.f(nativeArrayInterface, "arguments");
        throw new UnsupportedOperationException("Unimplemented method 'invokeCallback'");
    }

    public boolean isDestroyed() {
        throw new UnsupportedOperationException("Unimplemented method 'isDestroyed'");
    }

    public void loadScriptFromAssets(AssetManager assetManager, String str, boolean z10) {
        m.f(assetManager, "assetManager");
        m.f(str, "assetURL");
        throw new UnsupportedOperationException("Unimplemented method 'loadScriptFromAssets'");
    }

    public void loadScriptFromFile(String str, String str2, boolean z10) {
        m.f(str, "fileName");
        m.f(str2, "sourceURL");
        throw new UnsupportedOperationException("Unimplemented method 'loadScriptFromFile'");
    }

    public void loadSplitBundleFromFile(String str, String str2) {
        m.f(str, "fileName");
        m.f(str2, "sourceURL");
        throw new UnsupportedOperationException("Unimplemented method 'loadSplitBundleFromFile'");
    }

    public void registerSegment(int i10, String str) {
        m.f(str, "path");
        throw new UnsupportedOperationException("Unimplemented method 'registerSegment'");
    }

    public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        m.f(notThreadSafeBridgeIdleDebugListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw new UnsupportedOperationException("Unimplemented method 'removeBridgeIdleDebugListener'");
    }

    public void runJSBundle() {
        throw new UnsupportedOperationException("Unimplemented method 'runJSBundle'");
    }

    public void setFabricUIManager(UIManager uIManager) {
        m.f(uIManager, "fabricUIManager");
        throw new UnsupportedOperationException("Unimplemented method 'setFabricUIManager'");
    }

    public void setGlobalVariable(String str, String str2) {
        m.f(str, "propName");
        m.f(str2, "jsonValue");
        throw new UnsupportedOperationException("Unimplemented method 'setGlobalVariable'");
    }

    public void setSourceURLs(String str, String str2) {
        m.f(str, "deviceURL");
        m.f(str2, "remoteURL");
        throw new UnsupportedOperationException("Unimplemented method 'setSourceURLs'");
    }

    public void setTurboModuleRegistry(TurboModuleRegistry turboModuleRegistry) {
        m.f(turboModuleRegistry, "turboModuleRegistry");
        throw new UnsupportedOperationException("Unimplemented method 'setTurboModuleRegistry'");
    }

    public NativeModule getNativeModule(String str) {
        m.f(str, "moduleName");
        return this.f3361a.q0(str);
    }
}
