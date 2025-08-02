package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import java.util.Map;
import p5.a;

public abstract class BaseJavaModule implements NativeModule {
    public static final String METHOD_TYPE_ASYNC = "async";
    public static final String METHOD_TYPE_PROMISE = "promise";
    public static final String METHOD_TYPE_SYNC = "sync";
    @Nullable
    private final ReactApplicationContext mReactApplicationContext;

    public BaseJavaModule() {
        this((ReactApplicationContext) null);
    }

    public boolean canOverrideExistingModule() {
        return false;
    }

    @Nullable
    public Map<String, Object> getConstants() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final ReactApplicationContext getReactApplicationContext() {
        return (ReactApplicationContext) a.d(this.mReactApplicationContext, "Tried to get ReactApplicationContext even though NativeModule wasn't instantiated with one");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final ReactApplicationContext getReactApplicationContextIfActiveOrWarn() {
        if (this.mReactApplicationContext.hasActiveReactInstance()) {
            return this.mReactApplicationContext;
        }
        ReactSoftExceptionLogger.logSoftException("ReactNative", new RuntimeException("React Native Instance has already disappeared: requested by " + getName()));
        return null;
    }

    public void initialize() {
    }

    public void invalidate() {
    }

    public /* synthetic */ void onCatalystInstanceDestroy() {
        n.b(this);
    }

    public BaseJavaModule(@Nullable ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }
}
