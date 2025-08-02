package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.m;

public final class CustomTabActivity$onActivityResult$closeReceiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CustomTabActivity f19502a;

    CustomTabActivity$onActivityResult$closeReceiver$1(CustomTabActivity customTabActivity) {
        this.f19502a = customTabActivity;
    }

    public void onReceive(Context context, Intent intent) {
        m.f(context, "context");
        m.f(intent, "intent");
        this.f19502a.finish();
    }
}
