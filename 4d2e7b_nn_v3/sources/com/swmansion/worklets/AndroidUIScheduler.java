package com.swmansion.worklets;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class AndroidUIScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final ReactApplicationContext f11692a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f11693b = new AtomicBoolean(true);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f11694c = new a(this);
    @d6.a
    private final HybridData mHybridData = initHybrid();

    class a extends GuardedRunnable {
        a(JSExceptionHandler jSExceptionHandler) {
            super(jSExceptionHandler);
        }

        public void runGuarded() {
            AndroidUIScheduler.this.f11694c.run();
        }
    }

    public AndroidUIScheduler(ReactApplicationContext reactApplicationContext) {
        this.f11692a = reactApplicationContext;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d() {
        synchronized (this.f11693b) {
            try {
                if (this.f11693b.get()) {
                    triggerUI();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private native HybridData initHybrid();

    @d6.a
    private void scheduleTriggerOnUI() {
        UiThreadUtil.runOnUiThread(new a(this.f11692a.getExceptionHandler()));
    }

    public void c() {
        synchronized (this.f11693b) {
            this.f11693b.set(false);
            invalidate();
        }
    }

    public native void invalidate();

    public native void triggerUI();
}
