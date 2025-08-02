package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public final class zzez {
    final zzfr zza;

    zzez(zzkt zzkt) {
        this.zza = zzkt.zzq();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zzau());
            if (packageManager == null) {
                this.zza.zzay().zzj().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e10) {
            this.zza.zzay().zzj().zzb("Failed to retrieve Play Store version for Install Referrer", e10);
            return false;
        }
    }
}
