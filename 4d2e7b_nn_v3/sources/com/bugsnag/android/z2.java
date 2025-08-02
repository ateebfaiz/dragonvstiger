package com.bugsnag.android;

import c1.q;
import com.bugsnag.android.v3;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class z2 extends n {

    /* renamed from: a  reason: collision with root package name */
    private final y2 f19197a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z2(y2 y2Var, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new y2((Map) null, 1, (DefaultConstructorMarker) null) : y2Var);
    }

    private final void i(String str, String str2) {
        if (str2 == null) {
            if (!getObservers$bugsnag_android_core_release().isEmpty()) {
                v3.f fVar = new v3.f(str);
                for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                    onStateChange.onStateChange(fVar);
                }
            }
        } else if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.g gVar = new v3.g(str, str2);
            for (q onStateChange2 : getObservers$bugsnag_android_core_release()) {
                onStateChange2.onStateChange(gVar);
            }
        }
    }

    private final void j(String str, String str2, Object obj) {
        if (obj == null) {
            i(str, str2);
        } else if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.c cVar = new v3.c(str, str2, h().h(str, str2));
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(cVar);
            }
        }
    }

    private final void k(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            if (!getObservers$bugsnag_android_core_release().isEmpty()) {
                v3.c cVar = new v3.c(str, (String) entry.getKey(), h().h(str, (String) entry.getKey()));
                for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                    onStateChange.onStateChange(cVar);
                }
            }
        }
    }

    public void b(String str, String str2, Object obj) {
        this.f19197a.a(str, str2, obj);
        j(str, str2, obj);
    }

    public void c(String str, Map map) {
        this.f19197a.b(str, map);
        k(str, map);
    }

    public void d(String str) {
        this.f19197a.c(str);
        i(str, (String) null);
    }

    public void e(String str, String str2) {
        this.f19197a.d(str, str2);
        i(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof z2) && m.b(this.f19197a, ((z2) obj).f19197a);
    }

    public final z2 f(y2 y2Var) {
        return new z2(y2Var);
    }

    public final void g() {
        Set<Map.Entry> entrySet;
        for (String str : this.f19197a.k().keySet()) {
            Map i10 = this.f19197a.i(str);
            if (!(i10 == null || (entrySet = i10.entrySet()) == null)) {
                for (Map.Entry entry : entrySet) {
                    j(str, (String) entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public final y2 h() {
        return this.f19197a;
    }

    public int hashCode() {
        return this.f19197a.hashCode();
    }

    public String toString() {
        return "MetadataState(metadata=" + this.f19197a + ')';
    }

    public z2(y2 y2Var) {
        this.f19197a = y2Var;
    }
}
