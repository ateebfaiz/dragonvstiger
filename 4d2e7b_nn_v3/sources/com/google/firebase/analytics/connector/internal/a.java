package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

final class a implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zze f8968a;

    public a(zze zze) {
        this.f8968a = zze;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        if (this.f8968a.zza.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(DbParams.TABLE_EVENTS, zzc.zzc(str2));
            this.f8968a.zzb.onMessageTriggered(2, bundle2);
        }
    }
}
