package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import ra.a;

public class ZukHomeBadger implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f11060a = Uri.parse("content://com.android.badge/badge");

    public List a() {
        return Collections.singletonList("com.zui.launcher");
    }

    public void b(Context context, ComponentName componentName, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("app_badge_count", i10);
        context.getContentResolver().call(this.f11060a, "setAppBadgeCount", (String) null, bundle);
    }
}
