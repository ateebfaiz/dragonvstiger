package com.botion.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.zx.sdk.api.PermissionCallback;
import com.zx.sdk.api.ZXID;
import com.zx.sdk.api.ZXIDListener;
import com.zx.sdk.api.ZXManager;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class ah {

    /* renamed from: a  reason: collision with root package name */
    public static final ah f18490a = new ah();

    public static final class a implements ZXIDListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f18491a;

        a(Context context) {
            this.f18491a = context;
        }

        public final void onFailed(int i10, String str) {
            m.f(str, NotificationCompat.CATEGORY_MESSAGE);
            af afVar = af.f18475a;
            af.a("ZxIdUtils", "ZxID onFailed code: " + i10 + ", msg: " + str);
        }

        public final void onSuccess(ZXID zxid) {
            m.f(zxid, "zxid");
            af afVar = af.f18475a;
            af.a("ZxIdUtils", "ZxID success: " + zxid.getValue());
            try {
                SharedPreferences.Editor edit = this.f18491a.getSharedPreferences("gt_zid_sp", 0).edit();
                edit.putLong("gt_zid_et", zxid.getExpiredTime());
                edit.putString("gt_zid", zxid.getValue());
                edit.apply();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static final class b implements PermissionCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f18492a;

        b(Context context) {
            this.f18492a = context;
        }

        public final void onAuthorized() {
            af.a("ZxIdUtils", "ZxID checkPermission: onAuthorized");
            ah ahVar = ah.f18490a;
            ZXManager.getZXID(new a(this.f18492a));
        }

        public final void onUnauthorized() {
            af.a("ZxIdUtils", "ZxID checkPermission: onUnauthorized");
        }
    }

    private ah() {
    }

    private static boolean a() {
        try {
            Class.forName("com.zx.sdk.api.ZXManager");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void c(Context context) {
        ZXManager.init(context);
        ZXManager.setDebug(false);
        ZXManager.setEnable(true);
        ZXManager.allowPermissionDialog(false);
        if (context != null) {
            ZXManager.checkPermission((Activity) context, new b(context));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    public static String a(Context context) {
        m.f(context, "context");
        try {
            if (a()) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("gt_zid_sp", 0);
                String string = sharedPreferences.getString("gt_zid", (String) null);
                long j10 = sharedPreferences.getLong("gt_zid_et", 0);
                if (string == null || !(!j.s(string)) || j10 <= 0) {
                    c(context);
                } else {
                    if (j10 - System.currentTimeMillis() < 86400000) {
                        c(context);
                    }
                    return string;
                }
            }
            return "unknown";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "unknown";
        }
    }
}
