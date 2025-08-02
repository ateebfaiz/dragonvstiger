package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.soloader.SoLoader;
import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ReactHostInspectorTarget implements Closeable {
    private static final a Companion = new a((DefaultConstructorMarker) null);
    private final HybridData mHybridData;
    private final ReactHostImpl reactHostImpl;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b implements Executor {
        public void execute(Runnable runnable) {
            m.f(runnable, "command");
            if (UiThreadUtil.isOnUiThread()) {
                runnable.run();
            } else {
                UiThreadUtil.runOnUiThread(runnable);
            }
        }
    }

    static {
        SoLoader.t("rninstance");
    }

    public ReactHostInspectorTarget(ReactHostImpl reactHostImpl2) {
        m.f(reactHostImpl2, "reactHostImpl");
        this.reactHostImpl = reactHostImpl2;
        this.mHybridData = initHybrid(reactHostImpl2, new b());
    }

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid(ReactHostImpl reactHostImpl2, Executor executor);

    public void close() {
        this.mHybridData.resetNative();
    }

    public final boolean isValid() {
        return this.mHybridData.isValid();
    }

    public final native void sendDebuggerResumeCommand();
}
