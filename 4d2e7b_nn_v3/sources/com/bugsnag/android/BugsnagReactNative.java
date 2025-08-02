package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

public class BugsnagReactNative extends ReactContextBaseJavaModule {
    private final v impl;

    public BugsnagReactNative(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.impl = new v(reactApplicationContext);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void addFeatureFlag(@NonNull String str, @Nullable String str2) {
        this.impl.a(str, str2);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void addFeatureFlags(@NonNull ReadableArray readableArray) {
        this.impl.b(readableArray);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void addMetadata(@NonNull String str, @Nullable ReadableMap readableMap) {
        this.impl.c(str, readableMap);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void clearFeatureFlag(@NonNull String str) {
        this.impl.d(str);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void clearFeatureFlags() {
        this.impl.e();
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void clearMetadata(@NonNull String str, @Nullable String str2) {
        this.impl.f(str, str2);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap configure(ReadableMap readableMap) {
        return this.impl.g(readableMap);
    }

    @ReactMethod
    public void configureAsync(ReadableMap readableMap, Promise promise) {
        this.impl.h(readableMap, promise);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public boolean dispatch(@NonNull ReadableMap readableMap) {
        return this.impl.i(readableMap);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void dispatchAsync(@NonNull ReadableMap readableMap, @NonNull Promise promise) {
        this.impl.j(readableMap, promise);
    }

    public String getName() {
        return "BugsnagReactNative";
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public WritableMap getPayloadInfo(@NonNull ReadableMap readableMap) {
        return this.impl.l(readableMap);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void getPayloadInfoAsync(@NonNull ReadableMap readableMap, @NonNull Promise promise) {
        this.impl.m(readableMap, promise);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void leaveBreadcrumb(@NonNull ReadableMap readableMap) {
        this.impl.n(readableMap);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void pauseSession() {
        this.impl.p();
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void resumeSession() {
        this.impl.q();
    }

    @ReactMethod
    public void resumeSessionOnStartup() {
        this.impl.r();
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void startSession() {
        this.impl.t();
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void updateCodeBundleId(@Nullable String str) {
        this.impl.u(str);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void updateContext(@Nullable String str) {
        this.impl.v(str);
    }

    /* access modifiers changed from: package-private */
    @ReactMethod
    public void updateUser(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.impl.w(str, str2, str3);
    }
}
