package com.geetest.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.zx.sdk.api.PermissionCallback;
import com.zx.sdk.api.ZXManager;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final k0 f5826a = new k0();

    public static final class a implements PermissionCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f5827a;

        public a(Context context) {
            this.f5827a = context;
        }

        public void onAuthorized() {
            h0.f5812d.a("ZxIdUtils", "ZxID checkPermission: onAuthorized");
            ZXManager.getZXID(new j0(this.f5827a));
        }

        public void onUnauthorized() {
            h0.f5812d.a("ZxIdUtils", "ZxID checkPermission: onUnauthorized");
        }
    }

    public final String a(Context context) {
        m.f(context, "context");
        try {
            Class.forName("com.zx.sdk.api.ZXManager");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gt_zid_sp", 0);
                String string = sharedPreferences.getString("gt_zid", (String) null);
                long j10 = sharedPreferences.getLong("gt_zid_et", 0);
                if (string == null || !(!j.s(string)) || j10 <= 0) {
                    b(context);
                    return "unknown";
                }
                if (j10 - System.currentTimeMillis() < ((long) 86400000)) {
                    b(context);
                }
                return string;
            } catch (Exception e10) {
                e10.printStackTrace();
                return "unknown";
            }
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public final void b(Context context) {
        ZXManager.init(context);
        ZXManager.setDebug(false);
        ZXManager.setEnable(true);
        ZXManager.allowPermissionDialog(false);
        if (context != null) {
            ZXManager.checkPermission((Activity) context, new a(context));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
