package com.facebook.react.uimanager;

import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;

public final class UIConstantsProviderBinding {
    public static final UIConstantsProviderBinding INSTANCE = new UIConstantsProviderBinding();

    public interface ConstantsForViewManagerProvider {
        NativeMap getConstantsForViewManager(String str);
    }

    public interface ConstantsProvider {
        NativeMap getConstants();
    }

    public interface DefaultEventTypesProvider {
        NativeMap getDefaultEventTypes();
    }

    static {
        SoLoader.t("uimanagerjni");
    }

    private UIConstantsProviderBinding() {
    }

    public static final native void install(RuntimeExecutor runtimeExecutor, DefaultEventTypesProvider defaultEventTypesProvider, ConstantsForViewManagerProvider constantsForViewManagerProvider, ConstantsProvider constantsProvider);
}
