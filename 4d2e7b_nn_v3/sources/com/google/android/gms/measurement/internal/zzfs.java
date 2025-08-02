package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final /* synthetic */ class zzfs implements Runnable {
    public final /* synthetic */ zzgj zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzfs(zzgj zzgj, String str, Bundle bundle) {
        this.zza = zzgj;
        this.zzb = str;
        this.zzc = bundle;
    }

    public final void run() {
        this.zza.zzw(this.zzb, this.zzc);
    }
}
