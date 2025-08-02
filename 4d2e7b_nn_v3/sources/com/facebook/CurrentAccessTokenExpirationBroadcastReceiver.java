package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        m.f(context, "context");
        m.f(intent, "intent");
        if (m.b("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED", intent.getAction()) && o.A()) {
            c.f19600g.e().e();
        }
    }
}
