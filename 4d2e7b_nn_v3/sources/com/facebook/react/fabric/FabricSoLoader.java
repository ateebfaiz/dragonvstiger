package com.facebook.react.fabric;

import c8.a;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;

public final class FabricSoLoader {
    public static final FabricSoLoader INSTANCE = new FabricSoLoader();
    private static volatile boolean didInit;

    private FabricSoLoader() {
    }

    public static final void staticInit() {
        if (!didInit) {
            a.c(0, "FabricSoLoader.staticInit::load:fabricjni");
            ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
            SoLoader.t("fabricjni");
            ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
            a.g(0);
            didInit = true;
        }
    }
}
