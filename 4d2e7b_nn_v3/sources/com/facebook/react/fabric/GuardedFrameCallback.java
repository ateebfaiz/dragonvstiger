package com.facebook.react.fabric;

import android.view.Choreographer;
import com.facebook.react.bridge.JSExceptionHandler;
import kotlin.jvm.internal.m;

public abstract class GuardedFrameCallback implements Choreographer.FrameCallback {
    private final JSExceptionHandler exceptionHandler;

    protected GuardedFrameCallback(JSExceptionHandler jSExceptionHandler) {
        m.f(jSExceptionHandler, "exceptionHandler");
        this.exceptionHandler = jSExceptionHandler;
    }

    public void doFrame(long j10) {
        try {
            doFrameGuarded(j10);
        } catch (RuntimeException e10) {
            this.exceptionHandler.handleException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j10);

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected GuardedFrameCallback(com.facebook.react.bridge.ReactContext r2) {
        /*
            r1 = this;
            java.lang.String r0 = "reactContext"
            kotlin.jvm.internal.m.f(r2, r0)
            com.facebook.react.bridge.JSExceptionHandler r2 = r2.getExceptionHandler()
            java.lang.String r0 = "getExceptionHandler(...)"
            kotlin.jvm.internal.m.e(r2, r0)
            r1.<init>((com.facebook.react.bridge.JSExceptionHandler) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.GuardedFrameCallback.<init>(com.facebook.react.bridge.ReactContext):void");
    }
}
