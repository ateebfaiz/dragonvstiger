package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import ra.a;
import ra.b;

public class AdwHomeBadger implements a {
    public List a() {
        return Arrays.asList(new String[]{"org.adw.launcher", "org.adwfreak.launcher"});
    }

    public void b(Context context, ComponentName componentName, int i10) {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", componentName.getPackageName());
        intent.putExtra("CNAME", componentName.getClassName());
        intent.putExtra("COUNT", i10);
        if (sa.a.a(context, intent)) {
            context.sendBroadcast(intent);
            return;
        }
        throw new b("unable to resolve intent: " + intent.toString());
    }
}
