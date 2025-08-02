package com.google.android.gms.internal.measurement;

public final class zzoh implements zzog {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;

    static {
        zzhy zza2 = new zzhy(zzhq.zza("com.google.android.gms.measurement")).zza();
        zza = zza2.zzf("measurement.client.sessions.check_on_reset_and_enable2", true);
        zzb = zza2.zzf("measurement.client.sessions.check_on_startup", true);
        zzc = zza2.zzf("measurement.client.sessions.start_session_before_view_screen", true);
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzb() {
        return ((Boolean) zza.zzb()).booleanValue();
    }
}
