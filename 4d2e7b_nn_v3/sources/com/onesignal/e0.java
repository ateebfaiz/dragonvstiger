package com.onesignal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f10607a;

    /* renamed from: b  reason: collision with root package name */
    private final Class f10608b = NotificationOpenedReceiver.class;

    /* renamed from: c  reason: collision with root package name */
    private final Class f10609c = NotificationOpenedReceiverAndroid22AndOlder.class;

    public e0(Context context) {
        m.f(context, "context");
        this.f10607a = context;
    }

    private final Intent c() {
        return new Intent(this.f10607a, this.f10608b);
    }

    public final PendingIntent a(int i10, Intent intent) {
        m.f(intent, "oneSignalIntent");
        return PendingIntent.getActivity(this.f10607a, i10, intent, 201326592);
    }

    public final Intent b(int i10) {
        Intent addFlags = c().putExtra("androidNotificationId", i10).addFlags(603979776);
        m.e(addFlags, "intent\n            .putE…Y_CLEAR_TOP\n            )");
        return addFlags;
    }
}
