package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.m;
import q5.f0;

public class FacebookBroadcastReceiver extends BroadcastReceiver {
    /* access modifiers changed from: protected */
    public void a(String str, String str2, Bundle bundle) {
        m.f(str, "appCallId");
        m.f(str2, "action");
        m.f(bundle, "extras");
    }

    /* access modifiers changed from: protected */
    public void b(String str, String str2, Bundle bundle) {
        m.f(str, "appCallId");
        m.f(str2, "action");
        m.f(bundle, "extras");
    }

    public void onReceive(Context context, Intent intent) {
        m.f(context, "context");
        m.f(intent, "intent");
        String stringExtra = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String stringExtra2 = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        Bundle extras = intent.getExtras();
        if (stringExtra != null && stringExtra2 != null && extras != null) {
            if (f0.D(intent)) {
                a(stringExtra, stringExtra2, extras);
            } else {
                b(stringExtra, stringExtra2, extras);
            }
        }
    }
}
