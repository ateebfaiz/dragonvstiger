package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.Set;

public final class zzg implements zza {
    /* access modifiers changed from: private */
    public final AnalyticsConnector.AnalyticsConnectorListener zza;
    private final AppMeasurementSdk zzb;
    private final b zzc;

    public zzg(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zza = analyticsConnectorListener;
        this.zzb = appMeasurementSdk;
        b bVar = new b(this);
        this.zzc = bVar;
        appMeasurementSdk.registerOnMeasurementEventListener(bVar);
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zza;
    }

    public final void zzb(Set set) {
    }

    public final void zzc() {
    }
}
