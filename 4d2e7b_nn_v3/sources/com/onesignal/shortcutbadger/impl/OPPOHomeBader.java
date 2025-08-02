package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import ra.a;
import ra.b;

public class OPPOHomeBader implements a {

    /* renamed from: a  reason: collision with root package name */
    private int f11053a = -1;

    private void c(Context context, int i10) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i10);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
        } catch (Throwable unused) {
            throw new b("Unable to execute Badge By Content Provider");
        }
    }

    public List a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    public void b(Context context, ComponentName componentName, int i10) {
        if (this.f11053a != i10) {
            this.f11053a = i10;
            c(context, i10);
        }
    }
}
