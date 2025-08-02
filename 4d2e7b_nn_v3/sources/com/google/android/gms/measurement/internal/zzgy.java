package com.google.android.gms.measurement.internal;

public final /* synthetic */ class zzgy implements Runnable {
    public final /* synthetic */ zzhx zza;

    public /* synthetic */ zzgy(zzhx zzhx) {
        this.zza = zzhx;
    }

    public final void run() {
        zzhx zzhx = this.zza;
        zzhx.zzg();
        if (!zzhx.zzt.zzm().f7784q.zzb()) {
            long zza2 = zzhx.zzt.zzm().f7785r.zza();
            zzhx.zzt.zzm().f7785r.zzb(1 + zza2);
            zzhx.zzt.zzf();
            if (zza2 >= 5) {
                zzhx.zzt.zzay().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzhx.zzt.zzm().f7784q.zza(true);
                return;
            }
            zzhx.zzt.zzE();
            return;
        }
        zzhx.zzt.zzay().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
