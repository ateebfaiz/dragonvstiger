package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.jvm.internal.m;
import q5.q0;

public abstract class z {

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f20980a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final LocalBroadcastManager f20981b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20982c;

    private final class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            m.f(context, "context");
            m.f(intent, "intent");
            if (m.b("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED", intent.getAction())) {
                z.this.c((Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_PROFILE"), (Profile) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_PROFILE"));
            }
        }
    }

    public z() {
        q0.o();
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(o.f());
        m.e(instance, "LocalBroadcastManager.ge….getApplicationContext())");
        this.f20981b = instance;
        d();
    }

    private final void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        this.f20981b.registerReceiver(this.f20980a, intentFilter);
    }

    public final boolean b() {
        return this.f20982c;
    }

    /* access modifiers changed from: protected */
    public abstract void c(Profile profile, Profile profile2);

    public final void d() {
        if (!this.f20982c) {
            a();
            this.f20982c = true;
        }
    }

    public final void e() {
        if (this.f20982c) {
            this.f20981b.unregisterReceiver(this.f20980a);
            this.f20982c = false;
        }
    }
}
