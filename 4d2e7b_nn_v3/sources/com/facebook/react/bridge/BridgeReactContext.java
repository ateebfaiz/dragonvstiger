package com.facebook.react.bridge;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import d6.a;
import java.util.Collection;

public class BridgeReactContext extends ReactApplicationContext {
    private static final String EARLY_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.";
    private static final String EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module before CatalystInstance has been set!";
    private static final String LATE_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module after the React instance was destroyed.";
    private static final String LATE_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module after CatalystInstance has been destroyed!";
    private static final String TAG = "BridgeReactContext";
    @Nullable
    private CatalystInstance mCatalystInstance;
    private volatile boolean mDestroyed = false;

    @a
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(@NonNull String str, @Nullable Object obj);
    }

    public BridgeReactContext(Context context) {
        super(context);
    }

    private void raiseCatalystInstanceMissingException() {
        String str;
        if (this.mDestroyed) {
            str = LATE_NATIVE_MODULE_EXCEPTION_MESSAGE;
        } else {
            str = EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE;
        }
        throw new IllegalStateException(str);
    }

    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        this.mDestroyed = true;
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            catalystInstance.destroy();
        }
    }

    public CatalystInstance getCatalystInstance() {
        return (CatalystInstance) p5.a.c(this.mCatalystInstance);
    }

    @Nullable
    public UIManager getFabricUIManager() {
        return this.mCatalystInstance.getFabricUIManager();
    }

    @Nullable
    public CallInvokerHolder getJSCallInvokerHolder() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJSCallInvokerHolder();
        }
        return null;
    }

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        if (this.mCatalystInstance != null) {
            InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
            if (interopModuleRegistry == null || !interopModuleRegistry.shouldReturnInteropModule(cls)) {
                return this.mCatalystInstance.getJSModule(cls);
            }
            return this.mInteropModuleRegistry.getInteropModule(cls);
        } else if (this.mDestroyed) {
            throw new IllegalStateException(LATE_JS_ACCESS_EXCEPTION_MESSAGE);
        } else {
            throw new IllegalStateException(EARLY_JS_ACCESS_EXCEPTION_MESSAGE);
        }
    }

    @f6.a
    @Nullable
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJavaScriptContextHolder();
        }
        return null;
    }

    @Nullable
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModule(cls);
    }

    public Collection<NativeModule> getNativeModules() {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModules();
    }

    @Nullable
    public String getSourceURL() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null) {
            return null;
        }
        return catalystInstance.getSourceURL();
    }

    public void handleException(Exception exc) {
        boolean z10;
        boolean z11;
        CatalystInstance catalystInstance = this.mCatalystInstance;
        boolean z12 = false;
        if (catalystInstance != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || catalystInstance.isDestroyed()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (getJSExceptionHandler() != null) {
            z12 = true;
        }
        if (!z11 || !z12) {
            z2.a.k("ReactNative", "Unable to handle Exception - catalystInstanceVariableExists: " + z10 + " - isCatalystInstanceAlive: " + z11 + " - hasExceptionHandler: " + z12, exc);
            throw new IllegalStateException(exc);
        }
        getJSExceptionHandler().handleException(exc);
    }

    @Deprecated
    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    public boolean hasActiveReactInstance() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance == null || catalystInstance.isDestroyed()) {
            return false;
        }
        return true;
    }

    @Deprecated
    public boolean hasCatalystInstance() {
        if (this.mCatalystInstance != null) {
            return true;
        }
        return false;
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.hasNativeModule(cls);
    }

    public boolean hasReactInstance() {
        if (this.mCatalystInstance != null) {
            return true;
        }
        return false;
    }

    public void initializeWithInstance(CatalystInstance catalystInstance) {
        if (catalystInstance == null) {
            throw new IllegalArgumentException("CatalystInstance cannot be null.");
        } else if (this.mCatalystInstance == null) {
            if (this.mDestroyed) {
                ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot initialize ReactContext after it has been destroyed."));
            }
            this.mCatalystInstance = catalystInstance;
            initializeMessageQueueThreads(catalystInstance.getReactQueueConfiguration());
            initializeInteropModules();
        } else {
            throw new IllegalStateException("ReactContext has been already initialized");
        }
    }

    @Deprecated
    public boolean isBridgeless() {
        return false;
    }

    public void registerSegment(int i10, String str, Callback callback) {
        ((CatalystInstance) p5.a.c(this.mCatalystInstance)).registerSegment(i10, str);
        ((Callback) p5.a.c(callback)).invoke(new Object[0]);
    }

    @Nullable
    public NativeModule getNativeModule(String str) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModule(str);
    }
}
