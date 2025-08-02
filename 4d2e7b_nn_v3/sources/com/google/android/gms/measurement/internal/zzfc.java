package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfc implements Callable {
    public final /* synthetic */ zzfi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfc(zzfi zzfi, String str) {
        this.zza = zzfi;
        this.zzb = str;
    }

    public final Object call() {
        return new zzn("internal.remoteConfig", new c0(this.zza, this.zzb));
    }
}
