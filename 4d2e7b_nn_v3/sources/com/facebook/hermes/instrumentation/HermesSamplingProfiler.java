package com.facebook.hermes.instrumentation;

import com.facebook.soloader.SoLoader;

public abstract class HermesSamplingProfiler {
    static {
        SoLoader.t("jsijniprofiler");
    }

    public static native void disable();

    public static native void dumpSampledTraceToFile(String str);

    public static native void enable();
}
