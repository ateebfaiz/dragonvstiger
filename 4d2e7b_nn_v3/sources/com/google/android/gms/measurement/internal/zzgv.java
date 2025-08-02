package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

public final /* synthetic */ class zzgv implements Runnable {
    public final /* synthetic */ zzhx zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzgv(zzhx zzhx, Bundle bundle, long j10) {
        this.zza = zzhx;
        this.zzb = bundle;
        this.zzc = j10;
    }

    public final void run() {
        zzhx zzhx = this.zza;
        Bundle bundle = this.zzb;
        long j10 = this.zzc;
        if (TextUtils.isEmpty(zzhx.zzt.zzh().zzm())) {
            zzhx.zzR(bundle, 0, j10);
        } else {
            zzhx.zzt.zzay().zzl().zza("Using developer consent only; google app id found");
        }
    }
}
