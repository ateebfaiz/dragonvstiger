package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.zing.zalo.zalosdk.common.Constant;

final class i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f7550a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7551b;

    i1(zzhx zzhx, Bundle bundle) {
        this.f7551b = zzhx;
        this.f7550a = bundle;
    }

    public final void run() {
        zzhx zzhx = this.f7551b;
        Bundle bundle = this.f7550a;
        zzhx.zzg();
        zzhx.zza();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzhx.zzt.zzJ()) {
            zzhx.zzt.zzay().zzj().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(string, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle.get("value"), string2);
        try {
            zzaw zzz = zzhx.zzt.zzv().zzz(bundle.getString(Constant.PARAM_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), string2, 0, true, true);
            zzaw zzz2 = zzhx.zzt.zzv().zzz(bundle.getString(Constant.PARAM_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), string2, 0, true, true);
            zzaw zzz3 = zzhx.zzt.zzv().zzz(bundle.getString(Constant.PARAM_APP_ID), bundle.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), string2, 0, true, true);
            zzhx.zzt.zzt().zzE(new zzac(bundle.getString(Constant.PARAM_APP_ID), string2, zzkw, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzz2, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zzz, bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzz3));
        } catch (IllegalArgumentException unused) {
        }
    }
}
