package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

final class b implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzg f8969a;

    public b(zzg zzg) {
        this.f8969a = zzg;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        if (str != null && zzc.zzk(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", str2);
            bundle2.putLong("timestampInMillis", j10);
            bundle2.putBundle("params", bundle);
            this.f8969a.zza.onMessageTriggered(3, bundle2);
        }
    }
}
