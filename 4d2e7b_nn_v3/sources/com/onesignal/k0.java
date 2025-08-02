package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.google.android.games.paddleboat.GameControllerManager;
import kotlin.jvm.internal.m;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public static final k0 f10736a = new k0();

    private k0() {
    }

    public final void a(Context context) {
        m.f(context, "context");
        Intent intent = new Intent();
        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        intent.addFlags(GameControllerManager.DEVICEFLAG_VIBRATION_DUAL_MOTOR);
        intent.putExtra("app_package", context.getPackageName());
        ApplicationInfo a10 = j.f10703a.a(context);
        if (a10 != null) {
            intent.putExtra("app_uid", a10.uid);
        }
        intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        context.startActivity(intent);
    }
}
