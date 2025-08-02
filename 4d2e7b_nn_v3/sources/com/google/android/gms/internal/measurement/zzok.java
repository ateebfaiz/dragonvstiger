package com.google.android.gms.internal.measurement;

public final class zzok implements zzoj {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;
    public static final zzib zzd;
    public static final zzib zze;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zzf("measurement.client.global_params", true);
        zzb = zza2.zzf("measurement.service.global_params_in_payload", true);
        zzc = zza2.zzf("measurement.service.clear_global_params_on_uninstall", true);
        zzd = zza2.zzf("measurement.service.global_params", true);
        zze = zza2.zzd("measurement.id.service.global_params", 0);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zzc.zzb()).booleanValue();
    }
}
