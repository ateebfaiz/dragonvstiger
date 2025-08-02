package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfe implements Callable {
    public final /* synthetic */ zzfi zza;

    public /* synthetic */ zzfe(zzfi zzfi) {
        this.zza = zzfi;
    }

    public final Object call() {
        return new zzt(this.zza.zze);
    }
}
