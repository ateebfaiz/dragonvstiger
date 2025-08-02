package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import javax.inject.Provider;
import s6.a;

public class ModuleSpec {
    private static final String TAG = "ModuleSpec";
    @Nullable
    private final String mName;
    private final Provider mProvider;

    private ModuleSpec(Provider provider) {
        this.mProvider = provider;
        this.mName = null;
    }

    public static ModuleSpec nativeModuleSpec(Class<? extends NativeModule> cls, Provider provider) {
        a aVar = (a) cls.getAnnotation(a.class);
        if (aVar != null) {
            return new ModuleSpec(provider, aVar.name());
        }
        z2.a.G(TAG, "Could not find @ReactModule annotation on " + cls.getName() + ". So creating the module eagerly to get the name. Consider adding an annotation to make this Lazy");
        return new ModuleSpec(provider, ((NativeModule) provider.get()).getName());
    }

    public static ModuleSpec viewManagerSpec(Provider provider) {
        return new ModuleSpec(provider);
    }

    @Nullable
    public String getName() {
        return this.mName;
    }

    public Provider getProvider() {
        return this.mProvider;
    }

    private ModuleSpec(Provider provider, String str) {
        this.mProvider = provider;
        this.mName = str;
    }

    public static ModuleSpec nativeModuleSpec(String str, Provider provider) {
        return new ModuleSpec(provider, str);
    }
}
