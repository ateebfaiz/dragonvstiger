package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import k6.e;
import s6.a;
import w6.c;

@a(name = "Timing")
public final class TimingModule extends NativeTimingSpec implements c {
    private final JavaTimerManager mJavaTimerManager;

    public TimingModule(ReactApplicationContext reactApplicationContext, e eVar) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new JavaTimerManager(reactApplicationContext, this, a.h(), eVar);
    }

    public void callIdleCallbacks(double d10) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).callIdleCallbacks(d10);
        }
    }

    public void callTimers(WritableArray writableArray) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).callTimers(writableArray);
        }
    }

    public void createTimer(double d10, double d11, double d12, boolean z10) {
        this.mJavaTimerManager.s((int) d10, (int) d11, d12, z10);
    }

    public void deleteTimer(double d10) {
        this.mJavaTimerManager.deleteTimer((int) d10);
    }

    public void emitTimeDriftWarning(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).emitTimeDriftWarning(str);
        }
    }

    public boolean hasActiveTimersInRange(long j10) {
        return this.mJavaTimerManager.t(j10);
    }

    public void initialize() {
        r6.c.e(getReactApplicationContext()).c(this.mJavaTimerManager);
    }

    public void invalidate() {
        r6.c.e(getReactApplicationContext()).i(this.mJavaTimerManager);
        this.mJavaTimerManager.x();
    }

    public void setSendIdleEvents(boolean z10) {
        this.mJavaTimerManager.setSendIdleEvents(z10);
    }
}
