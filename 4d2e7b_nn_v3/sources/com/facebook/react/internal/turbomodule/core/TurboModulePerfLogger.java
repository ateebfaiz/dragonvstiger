package com.facebook.react.internal.turbomodule.core;

import com.facebook.react.reactperflogger.NativeModulePerfLogger;
import d6.a;

@a
class TurboModulePerfLogger {
    private static NativeModulePerfLogger sNativeModulePerfLogger;

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    TurboModulePerfLogger() {
    }

    public static void enableLogging(NativeModulePerfLogger nativeModulePerfLogger) {
        if (nativeModulePerfLogger != null) {
            sNativeModulePerfLogger = nativeModulePerfLogger;
            jniEnableCppLogging(nativeModulePerfLogger);
        }
    }

    private static native void jniEnableCppLogging(NativeModulePerfLogger nativeModulePerfLogger);

    public static void moduleCreateCacheHit(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.a(str, i10);
        }
    }

    public static void moduleCreateConstructEnd(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.b(str, i10);
        }
    }

    public static void moduleCreateConstructStart(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.c(str, i10);
        }
    }

    public static void moduleCreateEnd(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.d(str, i10);
        }
    }

    public static void moduleCreateFail(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.e(str, i10);
        }
    }

    public static void moduleCreateSetUpEnd(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.f(str, i10);
        }
    }

    public static void moduleCreateSetUpStart(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.g(str, i10);
        }
    }

    public static void moduleCreateStart(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.h(str, i10);
        }
    }

    public static void moduleDataCreateEnd(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.i(str, i10);
        }
    }

    public static void moduleDataCreateStart(String str, int i10) {
        NativeModulePerfLogger nativeModulePerfLogger = sNativeModulePerfLogger;
        if (nativeModulePerfLogger != null) {
            nativeModulePerfLogger.j(str, i10);
        }
    }
}
