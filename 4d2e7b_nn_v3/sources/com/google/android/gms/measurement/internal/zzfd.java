package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzu;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfd implements Callable {
    public final /* synthetic */ zzfi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfd(zzfi zzfi, String str) {
        this.zza = zzfi;
        this.zzb = str;
    }

    public final Object call() {
        return new zzu("internal.appMetadata", new zzfb(this.zza, this.zzb));
    }
}
