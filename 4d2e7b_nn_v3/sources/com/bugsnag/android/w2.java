package com.bugsnag.android;

import c1.q;
import com.bugsnag.android.v3;
import kotlin.jvm.internal.m;

public final class w2 extends n {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19092a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f19093b;

    private final String b(Integer num) {
        if (num == null) {
            return "None";
        }
        if (num.intValue() == 80) {
            return "Complete";
        }
        if (num.intValue() == 60) {
            return "Moderate";
        }
        if (num.intValue() == 40) {
            return "Background";
        }
        if (num.intValue() == 20) {
            return "UI hidden";
        }
        if (num.intValue() == 15) {
            return "Running critical";
        }
        if (num.intValue() == 10) {
            return "Running low";
        }
        if (num.intValue() == 5) {
            return "Running moderate";
        }
        return "Unknown (" + num + ')';
    }

    public final void c() {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.q qVar = new v3.q(f(), d(), e());
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(qVar);
            }
        }
    }

    public final Integer d() {
        return this.f19093b;
    }

    public final String e() {
        return b(this.f19093b);
    }

    public final boolean f() {
        return this.f19092a;
    }

    public final void g(boolean z10) {
        this.f19092a = z10;
    }

    public final boolean h(Integer num) {
        if (m.b(this.f19093b, num)) {
            return false;
        }
        this.f19093b = num;
        return true;
    }
}
