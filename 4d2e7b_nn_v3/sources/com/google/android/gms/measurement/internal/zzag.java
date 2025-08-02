package com.google.android.gms.measurement.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzag extends x0 {
    private Boolean zza;
    private c zzb = zzae.zza;
    private Boolean zzc;

    zzag(zzfr zzfr) {
        super(zzfr);
    }

    public static final long zzA() {
        return ((Long) zzdu.zzC.zza((Object) null)).longValue();
    }

    private final String zzB(String str, String str2) {
        try {
            Class<String> cls = String.class;
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{cls, cls}).invoke((Object) null, new Object[]{str, ""});
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e10) {
            this.zzt.zzay().zzd().zzb("Could not find SystemProperties class", e10);
            return "";
        } catch (NoSuchMethodException e11) {
            this.zzt.zzay().zzd().zzb("Could not find SystemProperties.get() method", e11);
            return "";
        } catch (IllegalAccessException e12) {
            this.zzt.zzay().zzd().zzb("Could not access SystemProperties.get()", e12);
            return "";
        } catch (InvocationTargetException e13) {
            this.zzt.zzay().zzd().zzb("SystemProperties.get() threw an exception", e13);
            return "";
        }
    }

    public static final long zzz() {
        return ((Long) zzdu.zzc.zza((Object) null)).longValue();
    }

    @WorkerThread
    public final double zza(String str, zzdt zzdt) {
        if (str == null) {
            return ((Double) zzdt.zza((Object) null)).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzdt.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Double) zzdt.zza((Object) null)).doubleValue();
        }
        try {
            return ((Double) zzdt.zza(Double.valueOf(Double.parseDouble(zza2)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) zzdt.zza((Object) null)).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb(@Size(min = 1) String str) {
        return zzf(str, zzdu.zzG, 500, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE);
    }

    public final int zzc() {
        zzlb zzv = this.zzt.zzv();
        Boolean zzj = zzv.zzt.zzt().zzj();
        if (zzv.zzm() >= 201500) {
            return 100;
        }
        if (zzj == null || zzj.booleanValue()) {
            return 25;
        }
        return 100;
    }

    public final int zzd(@Size(min = 1) String str) {
        return zzf(str, zzdu.zzH, 25, 100);
    }

    @WorkerThread
    public final int zze(String str, zzdt zzdt) {
        if (str == null) {
            return ((Integer) zzdt.zza((Object) null)).intValue();
        }
        String zza2 = this.zzb.zza(str, zzdt.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Integer) zzdt.zza((Object) null)).intValue();
        }
        try {
            return ((Integer) zzdt.zza(Integer.valueOf(Integer.parseInt(zza2)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) zzdt.zza((Object) null)).intValue();
        }
    }

    @WorkerThread
    public final int zzf(String str, zzdt zzdt, int i10, int i11) {
        return Math.max(Math.min(zze(str, zzdt), i11), i10);
    }

    public final long zzh() {
        this.zzt.zzaw();
        return 74029;
    }

    @WorkerThread
    public final long zzi(String str, zzdt zzdt) {
        if (str == null) {
            return ((Long) zzdt.zza((Object) null)).longValue();
        }
        String zza2 = this.zzb.zza(str, zzdt.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Long) zzdt.zza((Object) null)).longValue();
        }
        try {
            return ((Long) zzdt.zza(Long.valueOf(Long.parseLong(zza2)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) zzdt.zza((Object) null)).longValue();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Bundle zzj() {
        try {
            if (this.zzt.zzau().getPackageManager() == null) {
                this.zzt.zzay().zzd().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(this.zzt.zzau()).getApplicationInfo(this.zzt.zzau().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            this.zzt.zzay().zzd().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            this.zzt.zzay().zzd().zzb("Failed to load metadata: Package name not found", e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzk(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzj = zzj();
        if (zzj == null) {
            this.zzt.zzay().zzd().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzj.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzj.getBoolean(str));
        }
    }

    public final String zzl() {
        return zzB("debug.firebase.analytics.app", "");
    }

    public final String zzm() {
        return zzB("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final String zzn() {
        this.zzt.zzaw();
        return "FA";
    }

    @WorkerThread
    public final String zzo(String str, zzdt zzdt) {
        if (str == null) {
            return (String) zzdt.zza((Object) null);
        }
        return (String) zzdt.zza(this.zzb.zza(str, zzdt.zzb()));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e A[SYNTHETIC, Splitter:B:8:0x002e] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzp(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r4 = "analytics.safelisted_events"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzj()
            r1 = 0
            if (r0 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x001b:
            r4 = r1
            goto L_0x002c
        L_0x001d:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x002c:
            if (r4 == 0) goto L_0x0058
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt     // Catch:{ NotFoundException -> 0x0048 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NotFoundException -> 0x0048 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0048 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0048 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0048 }
            if (r4 != 0) goto L_0x0043
            return r1
        L_0x0043:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0048 }
            return r4
        L_0x0048:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zzb(r2, r4)
        L_0x0058:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzag.zzp(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final void zzq(c cVar) {
        this.zzb = cVar;
    }

    public final boolean zzr() {
        Boolean zzk = zzk("google_analytics_adid_collection_enabled");
        if (zzk == null || zzk.booleanValue()) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzs(String str, zzdt zzdt) {
        if (str == null) {
            return ((Boolean) zzdt.zza((Object) null)).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzdt.zzb());
        if (TextUtils.isEmpty(zza2)) {
            return ((Boolean) zzdt.zza((Object) null)).booleanValue();
        }
        return ((Boolean) zzdt.zza(Boolean.valueOf("1".equals(zza2)))).booleanValue();
    }

    public final boolean zzt(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean zzk = zzk("google_analytics_automatic_screen_reporting_enabled");
        if (zzk == null || zzk.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzv() {
        this.zzt.zzaw();
        Boolean zzk = zzk("firebase_analytics_collection_deactivated");
        if (zzk == null || !zzk.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzw(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzx() {
        if (this.zza == null) {
            Boolean zzk = zzk("app_measurement_lite");
            this.zza = zzk;
            if (zzk == null) {
                this.zza = Boolean.FALSE;
            }
        }
        if (this.zza.booleanValue() || !this.zzt.zzN()) {
            return true;
        }
        return false;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzy() {
        if (this.zzc == null) {
            synchronized (this) {
                try {
                    if (this.zzc == null) {
                        ApplicationInfo applicationInfo = this.zzt.zzau().getApplicationInfo();
                        String myProcessName = ProcessUtils.getMyProcessName();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            boolean z10 = false;
                            if (str != null && str.equals(myProcessName)) {
                                z10 = true;
                            }
                            this.zzc = Boolean.valueOf(z10);
                        }
                        if (this.zzc == null) {
                            this.zzc = Boolean.TRUE;
                            this.zzt.zzay().zzd().zza("My process not in the list of running processes");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.zzc.booleanValue();
    }
}
