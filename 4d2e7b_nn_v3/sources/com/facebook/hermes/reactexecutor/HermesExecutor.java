package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;
import p4.a;

public class HermesExecutor extends JavaScriptExecutor {

    /* renamed from: a  reason: collision with root package name */
    private static String f19955a;

    static {
        a();
    }

    HermesExecutor(a aVar, boolean z10, String str) {
        super(initHybridDefaultConfig(z10, str));
    }

    public static void a() {
        if (f19955a == null) {
            SoLoader.t("hermes");
            SoLoader.t("hermes_executor");
            f19955a = "Release";
        }
    }

    private static native HybridData initHybrid(boolean z10, String str, long j10);

    private static native HybridData initHybridDefaultConfig(boolean z10, String str);

    public String getName() {
        return "HermesExecutor" + f19955a;
    }
}
