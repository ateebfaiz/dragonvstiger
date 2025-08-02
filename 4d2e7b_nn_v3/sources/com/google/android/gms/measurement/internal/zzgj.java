package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.common.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class zzgj extends zzdw {
    /* access modifiers changed from: private */
    public final zzkt zza;
    private Boolean zzb;
    private String zzc = null;

    public zzgj(zzkt zzkt, String str) {
        Preconditions.checkNotNull(zzkt);
        this.zza = zzkt;
    }

    private final void zzA(zzaw zzaw, zzq zzq) {
        this.zza.zzA();
        this.zza.zzE(zzaw, zzq);
    }

    @BinderThread
    private final void zzy(zzq zzq, boolean z10) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.zza);
        zzz(zzq.zza, false);
        this.zza.zzv().zzX(zzq.zzb, zzq.zzq);
    }

    @BinderThread
    private final void zzz(String str, boolean z10) {
        boolean z11;
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                try {
                    if (this.zzb == null) {
                        if ("com.google.android.gms".equals(this.zzc) || UidVerifier.isGooglePlayServicesUid(this.zza.zzau(), Binder.getCallingUid()) || GoogleSignatureVerifier.getInstance(this.zza.zzau()).isUidGoogleSigned(Binder.getCallingUid())) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        this.zzb = Boolean.valueOf(z11);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e10) {
                    this.zza.zzay().zzd().zzb("Measurement Service called with invalid calling package. appId", zzeh.zzn(str));
                    throw e10;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzau(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzay().zzd().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzaw zzb(zzaw zzaw, zzq zzq) {
        zzau zzau;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzaw.zza) || (zzau = zzaw.zzb) == null || zzau.zza() == 0)) {
            String zzg = zzaw.zzb.zzg("_cis");
            if ("referrer broadcast".equals(zzg) || "referrer API".equals(zzg)) {
                this.zza.zzay().zzi().zzb("Event has been filtered ", zzaw.toString());
                return new zzaw("_cmpx", zzaw.zzb, zzaw.zzc, zzaw.zzd);
            }
        }
        return zzaw;
    }

    @BinderThread
    public final String zzd(zzq zzq) {
        zzy(zzq, false);
        return this.zza.zzx(zzq);
    }

    @BinderThread
    public final List zze(zzq zzq, boolean z10) {
        zzy(zzq, false);
        String str = zzq.zza;
        Preconditions.checkNotNull(str);
        try {
            List<d4> list = (List) this.zza.zzaz().zzh(new u0(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (d4 d4Var : list) {
                if (!z10) {
                    if (!zzlb.zzah(d4Var.f7463c)) {
                    }
                }
                arrayList.add(new zzkw(d4Var));
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.zza.zzay().zzd().zzc("Failed to get user properties. appId", zzeh.zzn(zzq.zza), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.zza.zzay().zzd().zzc("Failed to get user properties. appId", zzeh.zzn(zzq.zza), e);
            return null;
        }
    }

    @BinderThread
    public final List zzf(String str, String str2, zzq zzq) {
        zzy(zzq, false);
        String str3 = zzq.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaz().zzh(new l0(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzay().zzd().zzb("Failed to get conditional user properties", e10);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        try {
            return (List) this.zza.zzaz().zzh(new m0(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e10) {
            this.zza.zzay().zzd().zzb("Failed to get conditional user properties as", e10);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List zzh(String str, String str2, boolean z10, zzq zzq) {
        zzy(zzq, false);
        String str3 = zzq.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<d4> list = (List) this.zza.zzaz().zzh(new j0(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (d4 d4Var : list) {
                if (!z10) {
                    if (!zzlb.zzah(d4Var.f7463c)) {
                    }
                }
                arrayList.add(new zzkw(d4Var));
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.zza.zzay().zzd().zzc("Failed to query user properties. appId", zzeh.zzn(zzq.zza), e);
            return Collections.emptyList();
        } catch (ExecutionException e11) {
            e = e11;
            this.zza.zzay().zzd().zzc("Failed to query user properties. appId", zzeh.zzn(zzq.zza), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List zzi(String str, String str2, String str3, boolean z10) {
        zzz(str, true);
        try {
            List<d4> list = (List) this.zza.zzaz().zzh(new k0(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (d4 d4Var : list) {
                if (!z10) {
                    if (!zzlb.zzah(d4Var.f7463c)) {
                    }
                }
                arrayList.add(new zzkw(d4Var));
            }
            return arrayList;
        } catch (InterruptedException e10) {
            e = e10;
            this.zza.zzay().zzd().zzc("Failed to get user properties as. appId", zzeh.zzn(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e11) {
            e = e11;
            this.zza.zzay().zzd().zzc("Failed to get user properties as. appId", zzeh.zzn(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zzj(zzq zzq) {
        zzy(zzq, false);
        zzx(new v0(this, zzq));
    }

    @BinderThread
    public final void zzk(zzaw zzaw, zzq zzq) {
        Preconditions.checkNotNull(zzaw);
        zzy(zzq, false);
        zzx(new q0(this, zzaw, zzq));
    }

    @BinderThread
    public final void zzl(zzaw zzaw, String str, String str2) {
        Preconditions.checkNotNull(zzaw);
        Preconditions.checkNotEmpty(str);
        zzz(str, true);
        zzx(new r0(this, zzaw, str));
    }

    @BinderThread
    public final void zzm(zzq zzq) {
        Preconditions.checkNotEmpty(zzq.zza);
        zzz(zzq.zza, false);
        zzx(new n0(this, zzq));
    }

    @BinderThread
    public final void zzn(zzac zzac, zzq zzq) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotNull(zzac.zzc);
        zzy(zzq, false);
        zzac zzac2 = new zzac(zzac);
        zzac2.zza = zzq.zza;
        zzx(new h0(this, zzac2, zzq));
    }

    @BinderThread
    public final void zzo(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zza);
        zzz(zzac.zza, true);
        zzx(new i0(this, new zzac(zzac)));
    }

    @BinderThread
    public final void zzp(zzq zzq) {
        Preconditions.checkNotEmpty(zzq.zza);
        Preconditions.checkNotNull(zzq.zzv);
        p0 p0Var = new p0(this, zzq);
        Preconditions.checkNotNull(p0Var);
        if (this.zza.zzaz().zzs()) {
            p0Var.run();
        } else {
            this.zza.zzaz().zzq(p0Var);
        }
    }

    @BinderThread
    public final void zzq(long j10, String str, String str2, String str3) {
        zzx(new w0(this, str2, str3, str, j10));
    }

    @BinderThread
    public final void zzr(Bundle bundle, zzq zzq) {
        zzy(zzq, false);
        String str = zzq.zza;
        Preconditions.checkNotNull(str);
        zzx(new zzfs(this, str, bundle));
    }

    @BinderThread
    public final void zzs(zzq zzq) {
        zzy(zzq, false);
        zzx(new o0(this, zzq));
    }

    @BinderThread
    public final void zzt(zzkw zzkw, zzq zzq) {
        Preconditions.checkNotNull(zzkw);
        zzy(zzq, false);
        zzx(new t0(this, zzkw, zzq));
    }

    @BinderThread
    public final byte[] zzu(zzaw zzaw, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaw);
        zzz(str, true);
        this.zza.zzay().zzc().zzb("Log and bundle. event", this.zza.zzj().zzd(zzaw.zza));
        long nanoTime = this.zza.zzav().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzaz().zzi(new s0(this, zzaw, str)).get();
            if (bArr == null) {
                this.zza.zzay().zzd().zzb("Log and bundle returned null. appId", zzeh.zzn(str));
                bArr = new byte[0];
            }
            this.zza.zzay().zzc().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzj().zzd(zzaw.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzav().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e10) {
            e = e10;
            this.zza.zzay().zzd().zzd("Failed to log and bundle. appId, event, error", zzeh.zzn(str), this.zza.zzj().zzd(zzaw.zza), e);
            return null;
        } catch (ExecutionException e11) {
            e = e11;
            this.zza.zzay().zzd().zzd("Failed to log and bundle. appId, event, error", zzeh.zzn(str), this.zza.zzj().zzd(zzaw.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv(zzaw zzaw, zzq zzq) {
        zzc zzc2;
        if (!this.zza.zzo().zzo(zzq.zza)) {
            zzA(zzaw, zzq);
            return;
        }
        this.zza.zzay().zzj().zzb("EES config found for", zzq.zza);
        zzfi zzo = this.zza.zzo();
        String str = zzq.zza;
        if (TextUtils.isEmpty(str)) {
            zzc2 = null;
        } else {
            zzc2 = (zzc) zzo.zzd.get(str);
        }
        if (zzc2 != null) {
            try {
                Map zzs = this.zza.zzu().zzs(zzaw.zzb.zzc(), true);
                String zza2 = zzgo.zza(zzaw.zza);
                if (zza2 == null) {
                    zza2 = zzaw.zza;
                }
                if (zzc2.zze(new zzaa(zza2, zzaw.zzd, zzs))) {
                    if (zzc2.zzg()) {
                        this.zza.zzay().zzj().zzb("EES edited event", zzaw.zza);
                        zzA(this.zza.zzu().zzi(zzc2.zza().zzb()), zzq);
                    } else {
                        zzA(zzaw, zzq);
                    }
                    if (zzc2.zzf()) {
                        for (zzaa zzaa : zzc2.zza().zzc()) {
                            this.zza.zzay().zzj().zzb("EES logging created event", zzaa.zzd());
                            zzA(this.zza.zzu().zzi(zzaa), zzq);
                        }
                        return;
                    }
                    return;
                }
            } catch (zzd unused) {
                this.zza.zzay().zzd().zzc("EES error. appId, eventName", zzq.zzb, zzaw.zza);
            }
            this.zza.zzay().zzj().zzb("EES was not applied to event", zzaw.zza);
            zzA(zzaw, zzq);
            return;
        }
        this.zza.zzay().zzj().zzb("EES not loaded for", zzq.zza);
        zzA(zzaw, zzq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(String str, Bundle bundle) {
        f zzi = this.zza.zzi();
        zzi.zzg();
        zzi.zzW();
        byte[] zzbu = zzi.zzf.zzu().zzj(new zzar(zzi.zzt, "", str, "dep", 0, 0, bundle)).zzbu();
        zzi.zzt.zzay().zzj().zzc("Saving default event parameters, appId, data size", zzi.zzt.zzj().zzd(str), Integer.valueOf(zzbu.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, str);
        contentValues.put("parameters", zzbu);
        try {
            if (zzi.zzh().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                zzi.zzt.zzay().zzd().zzb("Failed to insert default event parameters (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e10) {
            zzi.zzt.zzay().zzd().zzc("Error storing default event parameters. appId", zzeh.zzn(str), e10);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzx(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzaz().zzs()) {
            runnable.run();
        } else {
            this.zza.zzaz().zzp(runnable);
        }
    }
}
