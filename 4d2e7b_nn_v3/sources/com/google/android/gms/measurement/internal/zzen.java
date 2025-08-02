package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class zzen extends u3 {
    public zzen(zzkt zzkt) {
        super(zzkt);
    }

    public final boolean zza() {
        zzW();
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zzt.zzau().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
