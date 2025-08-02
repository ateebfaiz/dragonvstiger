package com.zoontek.rnpermissions;

import android.util.SparseArray;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import kb.d;
import kotlin.jvm.internal.m;
import s6.a;
import w6.h;

@a(name = "RNPermissions")
public final class RNPermissionsModule extends ReactContextBaseJavaModule implements h {
    private final SparseArray<Callback> callbacks = new SparseArray<>();

    public RNPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public final void canScheduleExactAlarms(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.c(reactApplicationContext, promise);
    }

    @ReactMethod
    public final void check(String str, Promise promise) {
        m.f(str, "permission");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.d(reactApplicationContext, str, promise);
    }

    @ReactMethod
    public final void checkLocationAccuracy(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d.f12573a.e(promise);
    }

    @ReactMethod
    public final void checkMultiple(ReadableArray readableArray, Promise promise) {
        m.f(readableArray, "permissions");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.f(reactApplicationContext, readableArray, promise);
    }

    @ReactMethod
    public final void checkNotifications(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.g(reactApplicationContext, promise);
    }

    public String getName() {
        return "RNPermissions";
    }

    public boolean onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        m.f(strArr, "permissions");
        m.f(iArr, "grantResults");
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        return dVar.j(reactApplicationContext, this.callbacks, i10, iArr);
    }

    @ReactMethod
    public final void openPhotoPicker(Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d.f12573a.k(promise);
    }

    @ReactMethod
    public final void openSettings(String str, Promise promise) {
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.l(reactApplicationContext, str, promise);
    }

    @ReactMethod
    public final void request(String str, Promise promise) {
        m.f(str, "permission");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.m(reactApplicationContext, this, this.callbacks, str, promise);
    }

    @ReactMethod
    public final void requestLocationAccuracy(String str, Promise promise) {
        m.f(str, "purposeKey");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d.f12573a.o(promise);
    }

    @ReactMethod
    public final void requestMultiple(ReadableArray readableArray, Promise promise) {
        m.f(readableArray, "permissions");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.p(reactApplicationContext, this, this.callbacks, readableArray, promise);
    }

    @ReactMethod
    public final void requestNotifications(ReadableArray readableArray, Promise promise) {
        m.f(readableArray, "options");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.r(reactApplicationContext, promise);
    }

    @ReactMethod
    public final void shouldShowRequestRationale(String str, Promise promise) {
        m.f(str, "permission");
        m.f(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        d dVar = d.f12573a;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        m.e(reactApplicationContext, "getReactApplicationContext(...)");
        dVar.s(reactApplicationContext, str, promise);
    }
}
