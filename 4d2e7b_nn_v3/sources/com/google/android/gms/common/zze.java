package com.google.android.gms.common;

import java.util.concurrent.Callable;

public final /* synthetic */ class zze implements Callable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ k zzc;

    public /* synthetic */ zze(boolean z10, String str, k kVar) {
        this.zza = z10;
        this.zzb = str;
        this.zzc = kVar;
    }

    public final Object call() {
        return o.d(this.zza, this.zzb, this.zzc);
    }
}
