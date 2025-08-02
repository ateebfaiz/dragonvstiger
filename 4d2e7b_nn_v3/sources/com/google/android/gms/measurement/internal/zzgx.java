package com.google.android.gms.measurement.internal;

public final /* synthetic */ class zzgx implements Runnable {
    public final /* synthetic */ zzhx zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzgx(zzhx zzhx, String str) {
        this.zza = zzhx;
        this.zzb = str;
    }

    public final void run() {
        zzhx zzhx = this.zza;
        if (zzhx.zzt.zzh().zzp(this.zzb)) {
            zzhx.zzt.zzh().zzo();
        }
    }
}
