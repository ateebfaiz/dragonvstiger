package com.onesignal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.m;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final j0 f10705a = new j0();

    private j0() {
    }

    public final void a(Context context) {
        m.f(context, "context");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse(m.n("package:", context.getPackageName())));
        context.startActivity(intent);
    }
}
