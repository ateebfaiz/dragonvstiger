package com.facebook.react.runtime;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;

class b1 {

    /* renamed from: a  reason: collision with root package name */
    LifecycleState f3434a = LifecycleState.BEFORE_CREATE;

    /* renamed from: b  reason: collision with root package name */
    private final d f3435b;

    b1(d dVar) {
        this.f3435b = dVar;
    }

    public LifecycleState a() {
        return this.f3434a;
    }

    public void b(ReactContext reactContext) {
        if (reactContext != null) {
            LifecycleState lifecycleState = this.f3434a;
            if (lifecycleState == LifecycleState.BEFORE_RESUME) {
                this.f3435b.a("ReactContext.onHostDestroy()");
                reactContext.onHostDestroy();
            } else if (lifecycleState == LifecycleState.RESUMED) {
                this.f3435b.a("ReactContext.onHostPause()");
                reactContext.onHostPause();
                this.f3435b.a("ReactContext.onHostDestroy()");
                reactContext.onHostDestroy();
            }
        }
        this.f3434a = LifecycleState.BEFORE_CREATE;
    }

    public void c(ReactContext reactContext, Activity activity) {
        if (reactContext != null) {
            LifecycleState lifecycleState = this.f3434a;
            if (lifecycleState == LifecycleState.BEFORE_CREATE) {
                this.f3435b.a("ReactContext.onHostResume()");
                reactContext.onHostResume(activity);
                this.f3435b.a("ReactContext.onHostPause()");
                reactContext.onHostPause();
            } else if (lifecycleState == LifecycleState.RESUMED) {
                this.f3435b.a("ReactContext.onHostPause()");
                reactContext.onHostPause();
            }
        }
        this.f3434a = LifecycleState.BEFORE_RESUME;
    }

    public void d(ReactContext reactContext, Activity activity) {
        LifecycleState lifecycleState = this.f3434a;
        LifecycleState lifecycleState2 = LifecycleState.RESUMED;
        if (lifecycleState != lifecycleState2) {
            if (reactContext != null) {
                this.f3435b.a("ReactContext.onHostResume()");
                reactContext.onHostResume(activity);
            }
            this.f3434a = lifecycleState2;
        }
    }

    public void e(ReactContext reactContext, Activity activity) {
        if (this.f3434a == LifecycleState.RESUMED) {
            this.f3435b.a("ReactContext.onHostResume()");
            reactContext.onHostResume(activity);
        }
    }
}
