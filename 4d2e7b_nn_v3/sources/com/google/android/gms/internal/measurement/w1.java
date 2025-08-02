package com.google.android.gms.internal.measurement;

import android.util.Log;

final class w1 extends zzib {
    w1(zzhy zzhy, String str, Long l10, boolean z10) {
        super(zzhy, str, l10, true, (zzia) null);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid long value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
