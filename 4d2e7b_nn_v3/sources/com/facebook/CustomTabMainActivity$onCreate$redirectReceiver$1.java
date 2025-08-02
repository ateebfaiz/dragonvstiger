package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public final class CustomTabMainActivity$onCreate$redirectReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CustomTabMainActivity f19505a;

    CustomTabMainActivity$onCreate$redirectReceiver$1(CustomTabMainActivity customTabMainActivity) {
        this.f19505a = customTabMainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        m.f(context, "context");
        m.f(intent, "intent");
        Intent intent2 = new Intent(this.f19505a, CustomTabMainActivity.class);
        intent2.setAction(CustomTabMainActivity.REFRESH_ACTION);
        String str = CustomTabMainActivity.EXTRA_URL;
        intent2.putExtra(str, intent.getStringExtra(str));
        intent2.addFlags(603979776);
        this.f19505a.startActivity(intent2);
    }
}
