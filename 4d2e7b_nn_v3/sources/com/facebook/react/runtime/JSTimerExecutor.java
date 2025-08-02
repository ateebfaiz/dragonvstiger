package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.jni.annotations.DoNotStripAny;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.soloader.SoLoader;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import w6.c;

@DoNotStripAny
public final class JSTimerExecutor implements c {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private final HybridData mHybridData;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        SoLoader.t("rninstance");
    }

    public JSTimerExecutor(HybridData hybridData) {
        m.f(hybridData, "mHybridData");
        this.mHybridData = hybridData;
    }

    private final native void callTimers(WritableNativeArray writableNativeArray);

    public void callIdleCallbacks(double d10) {
    }

    public void callTimers(WritableArray writableArray) {
        m.f(writableArray, "timerIDs");
        callTimers((WritableNativeArray) writableArray);
    }

    public void emitTimeDriftWarning(String str) {
        m.f(str, "warningMessage");
    }
}
