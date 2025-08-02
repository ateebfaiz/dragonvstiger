package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

public final class j0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18797a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f18798b;

    /* renamed from: c  reason: collision with root package name */
    private final a f18799c;

    private final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Function2 f18800a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f18801b = new AtomicBoolean(false);

        public a(Function2 function2) {
            this.f18800a = function2;
        }

        public void onReceive(Context context, Intent intent) {
            Function2 function2;
            if (this.f18801b.getAndSet(true) && (function2 = this.f18800a) != null) {
                function2.invoke(Boolean.valueOf(j0.this.b()), j0.this.c());
            }
        }
    }

    public j0(Context context, ConnectivityManager connectivityManager, Function2 function2) {
        this.f18797a = context;
        this.f18798b = connectivityManager;
        this.f18799c = new a(function2);
    }

    private final NetworkInfo d() {
        try {
            return this.f18798b.getActiveNetworkInfo();
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public void a() {
        l0.f(this.f18797a, this.f18799c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), (s2) null, 4, (Object) null);
    }

    public boolean b() {
        NetworkInfo d10 = d();
        if (d10 == null) {
            return false;
        }
        return d10.isConnectedOrConnecting();
    }

    public String c() {
        Integer num;
        NetworkInfo d10 = d();
        if (d10 == null) {
            num = null;
        } else {
            num = Integer.valueOf(d10.getType());
        }
        if (num == null) {
            return DevicePublicKeyStringDef.NONE;
        }
        if (num.intValue() == 1) {
            return "wifi";
        }
        if (num.intValue() == 9) {
            return "ethernet";
        }
        return "cellular";
    }
}
