package com.bugsnag.android;

import c1.q;
import com.bugsnag.android.v3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class b2 extends n {

    /* renamed from: a  reason: collision with root package name */
    private final c2 f18644a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b2(c2 c2Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new c2() : c2Var);
    }

    public void b(String str, String str2) {
        this.f18644a.a(str, str2);
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.b bVar = new v3.b(str, str2);
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(bVar);
            }
        }
    }

    public void c(String str) {
        this.f18644a.b(str);
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.d dVar = new v3.d(str);
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(dVar);
            }
        }
    }

    public void d() {
        this.f18644a.c();
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.e eVar = v3.e.f19050a;
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(eVar);
            }
        }
    }

    public final b2 e() {
        return new b2(this.f18644a.d());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b2) && m.b(this.f18644a, ((b2) obj).f18644a);
    }

    public final void f() {
        for (a2 a2Var : h()) {
            String str = (String) a2Var.getKey();
            String str2 = (String) a2Var.getValue();
            if (!getObservers$bugsnag_android_core_release().isEmpty()) {
                v3.b bVar = new v3.b(str, str2);
                for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                    onStateChange.onStateChange(bVar);
                }
            }
        }
    }

    public final c2 g() {
        return this.f18644a;
    }

    public final List h() {
        return this.f18644a.e();
    }

    public int hashCode() {
        return this.f18644a.hashCode();
    }

    public String toString() {
        return "FeatureFlagState(featureFlags=" + this.f18644a + ')';
    }

    public b2(c2 c2Var) {
        this.f18644a = c2Var;
    }
}
