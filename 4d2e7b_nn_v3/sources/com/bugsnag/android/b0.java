package com.bugsnag.android;

import c1.j;
import c1.q;
import com.bugsnag.android.v3;
import d1.d;

public final class b0 extends n {
    public final void b() {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.h hVar = v3.h.f19054a;
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(hVar);
            }
        }
    }

    public final void c(j jVar, String str, int i10) {
        String str2;
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            String a10 = jVar.a();
            boolean c10 = jVar.l().c();
            String d10 = jVar.d();
            d h10 = jVar.h();
            if (h10 == null) {
                str2 = null;
            } else {
                str2 = (String) h10.a();
            }
            v3.i iVar = new v3.i(a10, c10, d10, str2, jVar.C(), str, i10, jVar.E(), jVar.s());
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(iVar);
            }
        }
    }

    public final void d(String str) {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.r rVar = new v3.r(str);
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(rVar);
            }
        }
    }
}
