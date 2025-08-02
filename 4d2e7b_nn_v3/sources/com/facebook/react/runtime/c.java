package com.facebook.react.runtime;

import android.content.Context;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.events.j;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import k6.e;
import w6.b;

class c extends ReactApplicationContext implements j {

    /* renamed from: a  reason: collision with root package name */
    private final ReactHostImpl f3436a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference f3437b = new AtomicReference();

    /* renamed from: c  reason: collision with root package name */
    private final String f3438c = getClass().getSimpleName();

    private static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final ReactHostImpl f3439a;

        /* renamed from: b  reason: collision with root package name */
        private final Class f3440b;

        public a(ReactHostImpl reactHostImpl, Class cls) {
            this.f3439a = reactHostImpl;
            this.f3440b = cls;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            WritableNativeArray writableNativeArray;
            if (objArr != null) {
                writableNativeArray = Arguments.fromJavaArgs(objArr);
            } else {
                writableNativeArray = new WritableNativeArray();
            }
            this.f3439a.Z(JavaScriptModuleRegistry.getJSModuleName(this.f3440b), method.getName(), writableNativeArray);
            return null;
        }
    }

    c(Context context, ReactHostImpl reactHostImpl) {
        super(context);
        this.f3436a = reactHostImpl;
        if (ReactFeatureFlags.unstable_useFabricInterop) {
            initializeInteropModules();
        }
    }

    /* access modifiers changed from: package-private */
    public b b() {
        return this.f3436a.i0();
    }

    /* access modifiers changed from: package-private */
    public e c() {
        return this.f3436a.h();
    }

    public void d(String str) {
        this.f3437b.set(str);
    }

    public void destroy() {
    }

    public void emitDeviceEvent(String str, Object obj) {
        this.f3436a.Z("RCTDeviceEventEmitter", "emit", Arguments.fromJavaArgs(new Object[]{str, obj}));
    }

    public CatalystInstance getCatalystInstance() {
        Log.w(this.f3438c, "[WARNING] Bridgeless doesn't support CatalystInstance. Accessing an API that's not part of the new architecture is not encouraged usage.");
        return new BridgelessCatalystInstance(this.f3436a);
    }

    public com.facebook.react.uimanager.events.e getEventDispatcher() {
        return this.f3436a.k0();
    }

    public UIManager getFabricUIManager() {
        return this.f3436a.A0();
    }

    public CallInvokerHolder getJSCallInvokerHolder() {
        return this.f3436a.l0();
    }

    public JavaScriptModule getJSModule(Class cls) {
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        if (interopModuleRegistry != null && interopModuleRegistry.shouldReturnInteropModule(cls)) {
            return this.mInteropModuleRegistry.getInteropModule(cls);
        }
        return (JavaScriptModule) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(this.f3436a, cls));
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.f3436a.m0();
    }

    public NativeModule getNativeModule(Class cls) {
        return this.f3436a.p0(cls);
    }

    public Collection getNativeModules() {
        return this.f3436a.r0();
    }

    public String getSourceURL() {
        return (String) this.f3437b.get();
    }

    public void handleException(Exception exc) {
        this.f3436a.B0(exc);
    }

    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    public boolean hasActiveReactInstance() {
        return this.f3436a.D0();
    }

    public boolean hasCatalystInstance() {
        return false;
    }

    public boolean hasNativeModule(Class cls) {
        return this.f3436a.C0(cls);
    }

    public boolean hasReactInstance() {
        return this.f3436a.D0();
    }

    public boolean isBridgeless() {
        return true;
    }

    public void registerSegment(int i10, String str, Callback callback) {
        this.f3436a.z1(i10, str, callback);
    }

    public NativeModule getNativeModule(String str) {
        return this.f3436a.q0(str);
    }
}
