package com.geetest.core;

import android.content.Context;

public final class Core {
    static {
        System.loadLibrary("gtcore");
    }

    public static native String getData(Context context);

    public static native String getData(Context context, GeeGuardConfiguration geeGuardConfiguration);
}
