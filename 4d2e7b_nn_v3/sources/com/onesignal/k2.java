package com.onesignal;

import android.content.Context;
import kotlin.jvm.internal.m;

public final class k2 {

    /* renamed from: a  reason: collision with root package name */
    public static final k2 f10738a = new k2();

    private k2() {
    }

    public final boolean a(Context context) {
        m.f(context, "context");
        return !m.b("DISABLE", OSUtils.f(context, "com.onesignal.NotificationOpened.DEFAULT"));
    }

    public final boolean b(Context context) {
        m.f(context, "context");
        return OSUtils.g(context, "com.onesignal.suppressLaunchURLs");
    }
}
