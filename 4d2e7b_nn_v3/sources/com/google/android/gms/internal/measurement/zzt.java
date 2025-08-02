package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import java.util.List;

public final class zzt extends zzai {
    /* access modifiers changed from: private */
    public final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put("log", new a5(this, false, true));
        this.zze.put(NotificationCompat.GROUP_KEY_SILENT, new y4(this, NotificationCompat.GROUP_KEY_SILENT));
        ((zzai) this.zze.get(NotificationCompat.GROUP_KEY_SILENT)).zzr("log", new a5(this, true, true));
        this.zze.put("unmonitored", new z4(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzr("log", new a5(this, false, false));
    }

    public final zzap zza(zzg zzg, List list) {
        return zzap.zzf;
    }
}
