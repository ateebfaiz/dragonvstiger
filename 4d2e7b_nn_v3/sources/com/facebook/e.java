package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import q5.p0;
import q5.q0;

public abstract class e {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f19662d = "e";

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f19663a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalBroadcastManager f19664b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19665c = false;

    private class b extends BroadcastReceiver {
        private b() {
        }

        public void onReceive(Context context, Intent intent) {
            if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
                p0.f0(e.f19662d, "AccessTokenChanged");
                e.this.d((AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN"), (AccessToken) intent.getParcelableExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN"));
            }
        }
    }

    public e() {
        q0.o();
        this.f19663a = new b();
        this.f19664b = LocalBroadcastManager.getInstance(o.f());
        e();
    }

    private void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        this.f19664b.registerReceiver(this.f19663a, intentFilter);
    }

    public boolean c() {
        return this.f19665c;
    }

    /* access modifiers changed from: protected */
    public abstract void d(AccessToken accessToken, AccessToken accessToken2);

    public void e() {
        if (!this.f19665c) {
            b();
            this.f19665c = true;
        }
    }

    public void f() {
        if (this.f19665c) {
            this.f19664b.unregisterReceiver(this.f19663a);
            this.f19665c = false;
        }
    }
}
