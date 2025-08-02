package com.facebook.react.uimanager;

import android.view.Choreographer;
import com.facebook.react.bridge.ReactContext;
import kotlin.jvm.internal.m;

public abstract class o implements Choreographer.FrameCallback {
    private final ReactContext reactContext;

    protected o(ReactContext reactContext2) {
        m.f(reactContext2, "reactContext");
        this.reactContext = reactContext2;
    }

    public void doFrame(long j10) {
        try {
            doFrameGuarded(j10);
        } catch (RuntimeException e10) {
            this.reactContext.handleException(e10);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j10);
}
