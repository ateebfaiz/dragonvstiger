package com.facebook.react.bridge.interop;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.config.ReactFeatureFlags;
import java.util.HashMap;

public class InteropModuleRegistry {
    private final HashMap<Class, Object> supportedModules = new HashMap<>();

    private boolean checkReactFeatureFlagsConditions() {
        if (!ReactFeatureFlags.enableFabricRenderer || !ReactFeatureFlags.unstable_useFabricInterop) {
            return false;
        }
        return true;
    }

    @Nullable
    public <T extends JavaScriptModule> T getInteropModule(Class<T> cls) {
        if (checkReactFeatureFlagsConditions()) {
            return (JavaScriptModule) this.supportedModules.get(cls);
        }
        return null;
    }

    public <T extends JavaScriptModule> void registerInteropModule(Class<T> cls, Object obj) {
        if (checkReactFeatureFlagsConditions()) {
            this.supportedModules.put(cls, obj);
        }
    }

    public <T extends JavaScriptModule> boolean shouldReturnInteropModule(Class<T> cls) {
        if (!checkReactFeatureFlagsConditions() || !this.supportedModules.containsKey(cls)) {
            return false;
        }
        return true;
    }
}
