package com.onesignal;

import android.app.Activity;
import android.os.Build;
import com.onesignal.PermissionsActivity;
import com.onesignal.e;
import com.onesignal.o3;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class b1 implements PermissionsActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public static final b1 f10386a;

    /* renamed from: b  reason: collision with root package name */
    private static final Set f10387b = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10388c;

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f10389d = i.b(b.f10391a);

    public static final class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f10390a;

        a(Activity activity) {
            this.f10390a = activity;
        }

        public void a() {
            k0.f10736a.a(this.f10390a);
            b1.f10388c = true;
        }

        public void b() {
            b1.f10386a.e(false);
        }
    }

    static final class b extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f10391a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final Boolean invoke() {
            boolean z10;
            if (Build.VERSION.SDK_INT <= 32 || OSUtils.o(o3.f10882b) <= 32) {
                z10 = false;
            } else {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    static {
        b1 b1Var = new b1();
        f10386a = b1Var;
        PermissionsActivity.registerAsCallback("NOTIFICATION", b1Var);
    }

    private b1() {
    }

    /* access modifiers changed from: private */
    public final void e(boolean z10) {
        for (o3.a0 a10 : f10387b) {
            a10.a(z10);
        }
        f10387b.clear();
    }

    private final boolean f() {
        return ((Boolean) f10389d.getValue()).booleanValue();
    }

    private final boolean g() {
        return OSUtils.a(o3.f10882b);
    }

    private final boolean j() {
        Activity Q = o3.Q();
        if (Q == null) {
            return false;
        }
        e eVar = e.f10606a;
        String string = Q.getString(o4.f10953e);
        m.e(string, "activity.getString(R.str…ermission_name_for_title)");
        String string2 = Q.getString(o4.f10954f);
        m.e(string2, "activity.getString(R.str…mission_settings_message)");
        eVar.c(Q, string, string2, new a(Q));
        return true;
    }

    public void a() {
        o3.l1();
        e(true);
    }

    public void b(boolean z10) {
        boolean z11;
        if (z10) {
            z11 = j();
        } else {
            z11 = false;
        }
        if (!z11) {
            e(false);
        }
    }

    public final void h() {
        if (f10388c) {
            f10388c = false;
            e(g());
        }
    }

    public final void i(boolean z10, o3.a0 a0Var) {
        if (a0Var != null) {
            f10387b.add(a0Var);
        }
        if (g()) {
            e(true);
        } else if (f()) {
            PermissionsActivity.h(z10, "NOTIFICATION", "android.permission.POST_NOTIFICATIONS", b1.class);
        } else if (z10) {
            j();
        } else {
            e(false);
        }
    }
}
