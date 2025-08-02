package com.google.android.gms.internal.measurement;

public final class zzoq implements zzop {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzd("measurement.id.lifecycle.app_in_background_parameter", 0);
        zzb = zza2.zzf("measurement.lifecycle.app_backgrounded_tracking", true);
        zzc = zza2.zzf("measurement.lifecycle.app_in_background_parameter", false);
        zzd = zza2.zzd("measurement.id.lifecycle.app_backgrounded_tracking", 0);
    }

    public final boolean zza() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
