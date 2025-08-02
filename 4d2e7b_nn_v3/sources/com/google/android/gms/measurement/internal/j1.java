package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.zing.zalo.zalosdk.common.Constant;

final class j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f7568a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7569b;

    j1(zzhx zzhx, Bundle bundle) {
        this.f7569b = zzhx;
        this.f7568a = bundle;
    }

    public final void run() {
        zzhx zzhx = this.f7569b;
        Bundle bundle = this.f7568a;
        zzhx.zzg();
        zzhx.zza();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzhx.zzt.zzJ()) {
            zzhx.zzt.zzay().zzj().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(checkNotEmpty, 0, (Object) null, "");
        try {
            zzac zzac = r4;
            zzac zzac2 = new zzac(bundle.getString(Constant.PARAM_APP_ID), "", zzkw, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle.getBoolean("active"), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzaw) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzaw) null, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzhx.zzt.zzv().zzz(bundle.getString(Constant.PARAM_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), "", bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, true));
            zzhx.zzt.zzt().zzE(zzac);
        } catch (IllegalArgumentException unused) {
        }
    }
}
