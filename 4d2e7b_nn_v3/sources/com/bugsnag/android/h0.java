package com.bugsnag.android;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

public final class h0 implements g0 {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectivityManager f18752a;

    /* renamed from: b  reason: collision with root package name */
    private final a f18753b;

    public static final class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Function2 f18754a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f18755b = new AtomicBoolean(false);

        public a(Function2 function2) {
            this.f18754a = function2;
        }

        private final void a(boolean z10) {
            Function2 function2;
            if (this.f18755b.getAndSet(true) && (function2 = this.f18754a) != null) {
                function2.invoke(Boolean.valueOf(z10), j4.f18812a.c());
            }
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            a(true);
        }

        public void onUnavailable() {
            super.onUnavailable();
            a(false);
        }
    }

    public h0(ConnectivityManager connectivityManager, Function2 function2) {
        this.f18752a = connectivityManager;
        this.f18753b = new a(function2);
    }

    public void a() {
        this.f18752a.registerDefaultNetworkCallback(this.f18753b);
    }

    public boolean b() {
        if (this.f18752a.getActiveNetwork() != null) {
            return true;
        }
        return false;
    }

    public String c() {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = this.f18752a.getActiveNetwork();
        if (activeNetwork != null) {
            networkCapabilities = this.f18752a.getNetworkCapabilities(activeNetwork);
        } else {
            networkCapabilities = null;
        }
        if (networkCapabilities == null) {
            return DevicePublicKeyStringDef.NONE;
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return "unknown";
    }
}
