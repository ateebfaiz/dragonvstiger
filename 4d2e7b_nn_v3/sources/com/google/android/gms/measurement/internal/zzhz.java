package com.google.android.gms.measurement.internal;

import java.util.Map;

public final /* synthetic */ class zzhz implements Runnable {
    public final /* synthetic */ a2 zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ Exception zzc;
    public final /* synthetic */ byte[] zzd;
    public final /* synthetic */ Map zze;

    public /* synthetic */ zzhz(a2 a2Var, int i10, Exception exc, byte[] bArr, Map map) {
        this.zza = a2Var;
        this.zzb = i10;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.a(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
