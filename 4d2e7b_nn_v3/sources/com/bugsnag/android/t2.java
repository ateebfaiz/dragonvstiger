package com.bugsnag.android;

import android.content.Context;
import android.os.Bundle;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;
import kotlin.text.j;

public final class t2 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19017a = new a((DefaultConstructorMarker) null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f19018a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final Pattern invoke(String str) {
            return Pattern.compile(str);
        }
    }

    private final Set a(Bundle bundle, String str, Set set) {
        String string = bundle.getString(str);
        if (string == null) {
            return set;
        }
        return h.w(h.q(j.y0(string, new char[]{','}, false, 0, 6, (Object) null), b.f19018a));
    }

    private final Set b(Bundle bundle, String str, Set set) {
        List list;
        String string = bundle.getString(str);
        if (string == null) {
            list = null;
        } else {
            list = j.v0(string, new String[]{","}, false, 0, 6, (Object) null);
        }
        if (list == null) {
            return set;
        }
        return r.A0(list);
    }

    private final void e(f0 f0Var, Bundle bundle) {
        f0Var.d0(bundle.getString("com.bugsnag.android.RELEASE_STAGE", f0Var.A()));
        f0Var.L(bundle.getString("com.bugsnag.android.APP_VERSION", f0Var.c()));
        f0Var.K(bundle.getString("com.bugsnag.android.APP_TYPE", f0Var.b()));
        if (bundle.containsKey("com.bugsnag.android.VERSION_CODE")) {
            f0Var.h0(Integer.valueOf(bundle.getInt("com.bugsnag.android.VERSION_CODE")));
        }
        if (bundle.containsKey("com.bugsnag.android.ENABLED_RELEASE_STAGES")) {
            f0Var.R(b(bundle, "com.bugsnag.android.ENABLED_RELEASE_STAGES", f0Var.k()));
        }
        Set a10 = a(bundle, "com.bugsnag.android.DISCARD_CLASSES", f0Var.h());
        if (a10 == null) {
            a10 = r0.d();
        }
        f0Var.Q(a10);
        Set b10 = b(bundle, "com.bugsnag.android.PROJECT_PACKAGES", r0.d());
        if (b10 == null) {
            b10 = r0.d();
        }
        f0Var.b0(b10);
        Set a11 = a(bundle, "com.bugsnag.android.REDACTED_KEYS", f0Var.z());
        if (a11 == null) {
            a11 = r0.d();
        }
        f0Var.c0(a11);
    }

    private final void f(f0 f0Var, Bundle bundle) {
        f0Var.O(bundle.getBoolean("com.bugsnag.android.AUTO_TRACK_SESSIONS", f0Var.e()));
        f0Var.N(bundle.getBoolean("com.bugsnag.android.AUTO_DETECT_ERRORS", f0Var.d()));
        f0Var.a0(bundle.getBoolean("com.bugsnag.android.PERSIST_USER", f0Var.v()));
        f0Var.T(bundle.getBoolean("com.bugsnag.android.GENERATE_ANONYMOUS_ID", f0Var.m()));
        String string = bundle.getString("com.bugsnag.android.SEND_THREADS");
        if (string != null) {
            f0Var.f0(d4.f18706a.a(string));
        }
    }

    private final void g(f0 f0Var, Bundle bundle) {
        if (bundle.containsKey("com.bugsnag.android.ENDPOINT_NOTIFY")) {
            f0Var.S(new j1(bundle.getString("com.bugsnag.android.ENDPOINT_NOTIFY", f0Var.l().a()), bundle.getString("com.bugsnag.android.ENDPOINT_SESSIONS", f0Var.l().b())));
        }
    }

    public final f0 c(Context context, String str) {
        try {
            return d(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData, str);
        } catch (Exception e10) {
            throw new IllegalStateException("Bugsnag is unable to read config from manifest.", e10);
        }
    }

    public final f0 d(Bundle bundle, String str) {
        if (str == null) {
            if (bundle == null) {
                str = null;
            } else {
                str = bundle.getString("com.bugsnag.android.API_KEY");
            }
        }
        if (str != null) {
            f0 f0Var = new f0(str);
            if (bundle != null) {
                f(f0Var, bundle);
                g(f0Var, bundle);
                e(f0Var, bundle);
                f0Var.W(bundle.getInt("com.bugsnag.android.MAX_BREADCRUMBS", f0Var.p()));
                f0Var.X(bundle.getInt("com.bugsnag.android.MAX_PERSISTED_EVENTS", f0Var.q()));
                f0Var.Y(bundle.getInt("com.bugsnag.android.MAX_PERSISTED_SESSIONS", f0Var.r()));
                f0Var.Z(bundle.getInt("com.bugsnag.android.MAX_REPORTED_THREADS", f0Var.s()));
                f0Var.g0(bundle.getLong("com.bugsnag.android.THREAD_COLLECTION_TIME_LIMIT_MS", f0Var.E()));
                f0Var.U((long) bundle.getInt("com.bugsnag.android.LAUNCH_DURATION_MILLIS", (int) f0Var.n()));
                f0Var.e0(bundle.getBoolean("com.bugsnag.android.SEND_LAUNCH_CRASHES_SYNCHRONOUSLY", f0Var.B()));
                f0Var.M(bundle.getBoolean("com.bugsnag.android.ATTEMPT_DELIVERY_ON_CRASH", f0Var.H()));
            }
            return f0Var;
        }
        throw new IllegalArgumentException("No Bugsnag API key set");
    }
}
