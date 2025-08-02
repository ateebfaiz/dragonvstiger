package com.bugsnag.android;

import c1.q;
import com.bugsnag.android.v3;

public final class m4 extends n {

    /* renamed from: a  reason: collision with root package name */
    private k4 f18858a;

    public m4(k4 k4Var) {
        this.f18858a = k4Var;
    }

    public final void b() {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.s sVar = new v3.s(c());
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(sVar);
            }
        }
    }

    public final k4 c() {
        return this.f18858a;
    }

    public final void d(k4 k4Var) {
        this.f18858a = k4Var;
        b();
    }
}
