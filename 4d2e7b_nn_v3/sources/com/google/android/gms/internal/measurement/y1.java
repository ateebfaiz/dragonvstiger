package com.google.android.gms.internal.measurement;

import android.util.Log;

final class y1 extends zzib {
    y1(zzhy zzhy, String str, Double d10, boolean z10) {
        super(zzhy, "measurement.test.double_flag", d10, true, (zzia) null);
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid double value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
