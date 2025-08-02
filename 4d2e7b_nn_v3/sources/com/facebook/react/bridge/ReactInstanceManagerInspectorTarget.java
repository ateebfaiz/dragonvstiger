package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import java.util.concurrent.Executor;

public class ReactInstanceManagerInspectorTarget implements AutoCloseable {
    private final HybridData mHybridData;

    public interface TargetDelegate {
        void onReload();

        void onSetPausedInDebuggerMessage(String str);
    }

    static {
        ReactBridge.staticInit();
    }

    public ReactInstanceManagerInspectorTarget(TargetDelegate targetDelegate) {
        this.mHybridData = initHybrid(new Executor() {
            public void execute(Runnable runnable) {
                if (UiThreadUtil.isOnUiThread()) {
                    runnable.run();
                } else {
                    UiThreadUtil.runOnUiThread(runnable);
                }
            }
        }, targetDelegate);
    }

    private native HybridData initHybrid(Executor executor, TargetDelegate targetDelegate);

    public void close() {
        this.mHybridData.resetNative();
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return this.mHybridData.isValid();
    }

    public native void sendDebuggerResumeCommand();
}
