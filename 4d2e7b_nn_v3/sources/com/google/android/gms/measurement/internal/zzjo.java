package com.google.android.gms.measurement.internal;

import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class zzjo extends u3 {
    public final zzes zza;
    public final zzes zzb;
    public final zzes zzc;
    public final zzes zzd;
    public final zzes zze;
    private final Map zzg = new HashMap();

    zzjo(zzkt zzkt) {
        super(zzkt);
        x zzm = this.zzt.zzm();
        zzm.getClass();
        this.zza = new zzes(zzm, "last_delete_stale", 0);
        x zzm2 = this.zzt.zzm();
        zzm2.getClass();
        this.zzb = new zzes(zzm2, "backoff", 0);
        x zzm3 = this.zzt.zzm();
        zzm3.getClass();
        this.zzc = new zzes(zzm3, "last_upload", 0);
        x zzm4 = this.zzt.zzm();
        zzm4.getClass();
        this.zzd = new zzes(zzm4, "last_upload_attempt", 0);
        x zzm5 = this.zzt.zzm();
        zzm5.getClass();
        this.zze = new zzes(zzm5, "midnight_offset", 0);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @Deprecated
    public final Pair zza(String str) {
        h3 h3Var;
        zzg();
        long elapsedRealtime = this.zzt.zzav().elapsedRealtime();
        h3 h3Var2 = (h3) this.zzg.get(str);
        if (h3Var2 != null && elapsedRealtime < h3Var2.f7534c) {
            return new Pair(h3Var2.f7532a, Boolean.valueOf(h3Var2.f7533b));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzi = elapsedRealtime + this.zzt.zzf().zzi(str, zzdu.zza);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzt.zzau());
            if (advertisingIdInfo == null) {
                return new Pair("", Boolean.FALSE);
            }
            String id2 = advertisingIdInfo.getId();
            if (id2 != null) {
                h3Var = new h3(id2, advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
            } else {
                h3Var = new h3("", advertisingIdInfo.isLimitAdTrackingEnabled(), zzi);
            }
            this.zzg.put(str, h3Var);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(h3Var.f7532a, Boolean.valueOf(h3Var.f7533b));
        } catch (Exception e10) {
            this.zzt.zzay().zzc().zzb("Unable to get advertising id", e10);
            h3Var = new h3("", false, zzi);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Pair zzd(String str, zzai zzai) {
        if (zzai.zzi(zzah.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @Deprecated
    public final String zzf(String str, boolean z10) {
        String str2;
        zzg();
        if (z10) {
            str2 = (String) zza(str).first;
        } else {
            str2 = "00000000-0000-0000-0000-000000000000";
        }
        MessageDigest zzF = zzlb.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzF.digest(str2.getBytes()))});
    }
}
