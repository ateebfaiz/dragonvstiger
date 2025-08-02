package com.facebook.react.bridge;

import android.os.SystemClock;
import c8.a;
import com.facebook.soloader.SoLoader;

public class ReactBridge {
    private static volatile boolean sDidInit;
    private static volatile long sLoadEndTime;
    private static volatile long sLoadStartTime;

    public static long getLoadEndTime() {
        return sLoadEndTime;
    }

    public static long getLoadStartTime() {
        return sLoadStartTime;
    }

    public static boolean isInitialized() {
        return sDidInit;
    }

    public static synchronized void staticInit() {
        synchronized (ReactBridge.class) {
            if (!sDidInit) {
                sLoadStartTime = SystemClock.uptimeMillis();
                a.c(0, "ReactBridge.staticInit::load:reactnativejni");
                ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_START);
                SoLoader.t("reactnativejni");
                ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_SO_FILE_END);
                a.g(0);
                sLoadEndTime = SystemClock.uptimeMillis();
                sDidInit = true;
            }
        }
    }
}
