package com.mah.sdk.crashcatch;

import a.b;

public class JniUtils {
    static {
        System.loadLibrary("mah-crash");
    }

    public static native void exitCrash();

    public static native String getABI();

    public static String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    public static native String getVersion();

    public static native int initCrashLib(int i10, int i11);

    public static void reportCrash(String str, String str2, String str3) {
        b.k().i(str, str2, str3);
    }

    public static native void testCrash();
}
