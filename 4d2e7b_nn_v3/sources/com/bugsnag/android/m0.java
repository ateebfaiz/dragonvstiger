package com.bugsnag.android;

import c1.q;
import com.bugsnag.android.v3;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class m0 extends n {

    /* renamed from: c  reason: collision with root package name */
    public static final a f18845c = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private String f18846a;

    /* renamed from: b  reason: collision with root package name */
    private String f18847b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void b() {
        if (!getObservers$bugsnag_android_core_release().isEmpty()) {
            v3.n nVar = new v3.n(c());
            for (q onStateChange : getObservers$bugsnag_android_core_release()) {
                onStateChange.onStateChange(nVar);
            }
        }
    }

    public final String c() {
        String str = this.f18847b;
        if (str == "__BUGSNAG_MANUAL_CONTEXT__") {
            str = null;
        }
        if (str == null) {
            return this.f18846a;
        }
        return str;
    }

    public final void d(String str) {
        if (this.f18847b != "__BUGSNAG_MANUAL_CONTEXT__") {
            this.f18847b = str;
            b();
        }
    }

    public final void e(String str) {
        this.f18846a = str;
        this.f18847b = "__BUGSNAG_MANUAL_CONTEXT__";
        b();
    }
}
