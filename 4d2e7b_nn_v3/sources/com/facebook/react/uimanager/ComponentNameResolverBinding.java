package com.facebook.react.uimanager;

import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;

public final class ComponentNameResolverBinding {
    public static final ComponentNameResolverBinding INSTANCE = new ComponentNameResolverBinding();

    static {
        SoLoader.t("uimanagerjni");
    }

    private ComponentNameResolverBinding() {
    }

    public static final native void install(RuntimeExecutor runtimeExecutor, Object obj);
}
