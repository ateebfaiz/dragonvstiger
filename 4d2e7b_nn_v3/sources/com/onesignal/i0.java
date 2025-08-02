package com.onesignal;

import android.app.Activity;
import com.google.android.gms.stats.CodePackage;
import com.onesignal.PermissionsActivity;
import com.onesignal.e;
import com.onesignal.o3;
import kotlin.jvm.internal.m;

public final class i0 implements PermissionsActivity.c {

    /* renamed from: a  reason: collision with root package name */
    public static final i0 f10676a;

    public static final class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f10677a;

        a(Activity activity) {
            this.f10677a = activity;
        }

        public void a() {
            j0.f10705a.a(this.f10677a);
            h0.n(true, o3.z.PERMISSION_DENIED);
        }

        public void b() {
            h0.n(true, o3.z.PERMISSION_DENIED);
        }
    }

    static {
        i0 i0Var = new i0();
        f10676a = i0Var;
        PermissionsActivity.registerAsCallback(CodePackage.LOCATION, i0Var);
    }

    private i0() {
    }

    private final void c(o3.z zVar) {
        h0.n(true, zVar);
    }

    private final void e() {
        Activity Q = o3.Q();
        if (Q != null) {
            e eVar = e.f10606a;
            String string = Q.getString(o4.f10951c);
            m.e(string, "activity.getString(R.str…ermission_name_for_title)");
            String string2 = Q.getString(o4.f10952d);
            m.e(string2, "activity.getString(R.str…mission_settings_message)");
            eVar.c(Q, string, string2, new a(Q));
        }
    }

    public void a() {
        c(o3.z.PERMISSION_GRANTED);
        h0.p();
    }

    public void b(boolean z10) {
        c(o3.z.PERMISSION_DENIED);
        if (z10) {
            e();
        }
        h0.e();
    }

    public final void d(boolean z10, String str) {
        m.f(str, "androidPermissionString");
        PermissionsActivity.h(z10, CodePackage.LOCATION, str, i0.class);
    }
}
