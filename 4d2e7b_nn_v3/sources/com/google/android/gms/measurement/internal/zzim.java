package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzim extends z {
    @VisibleForTesting
    protected zzie zza;
    private volatile zzie zzb;
    private volatile zzie zzc;
    private final Map zzd = new ConcurrentHashMap();
    @GuardedBy("activityLock")
    private Activity zze;
    @GuardedBy("activityLock")
    private volatile boolean zzf;
    private volatile zzie zzg;
    /* access modifiers changed from: private */
    public zzie zzh;
    @GuardedBy("activityLock")
    private boolean zzi;
    private final Object zzj = new Object();

    public zzim(zzfr zzfr) {
        super(zzfr);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzA(zzie zzie, zzie zzie2, long j10, boolean z10, Bundle bundle) {
        boolean z11;
        Bundle bundle2;
        String str;
        long j11;
        long j12;
        zzie zzie3 = zzie;
        zzie zzie4 = zzie2;
        long j13 = j10;
        Bundle bundle3 = bundle;
        zzg();
        boolean z12 = false;
        if (zzie4 == null || zzie4.zzc != zzie3.zzc || !zzif.zza(zzie4.zzb, zzie3.zzb) || !zzif.zza(zzie4.zza, zzie3.zza)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 && this.zza != null) {
            z12 = true;
        }
        if (z11) {
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            zzlb.zzK(zzie3, bundle4, true);
            if (zzie4 != null) {
                String str2 = zzie4.zza;
                if (str2 != null) {
                    bundle4.putString("_pn", str2);
                }
                String str3 = zzie4.zzb;
                if (str3 != null) {
                    bundle4.putString("_pc", str3);
                }
                bundle4.putLong("_pi", zzie4.zzc);
            }
            if (z12) {
                p3 p3Var = this.zzt.zzu().zzb;
                long j14 = j13 - p3Var.f7671b;
                p3Var.f7671b = j13;
                if (j14 > 0) {
                    this.zzt.zzv().zzI(bundle4, j14);
                }
            }
            if (!this.zzt.zzf().zzu()) {
                bundle4.putLong("_mst", 1);
            }
            if (true != zzie3.zze) {
                str = "auto";
            } else {
                str = "app";
            }
            String str4 = str;
            long currentTimeMillis = this.zzt.zzav().currentTimeMillis();
            if (zzie3.zze) {
                j12 = currentTimeMillis;
                long j15 = zzie3.zzf;
                if (j15 != 0) {
                    j11 = j15;
                    this.zzt.zzq().zzH(str4, "_vs", j11, bundle4);
                }
            } else {
                j12 = currentTimeMillis;
            }
            j11 = j12;
            this.zzt.zzq().zzH(str4, "_vs", j11, bundle4);
        }
        if (z12) {
            zzB(this.zza, true, j13);
        }
        this.zza = zzie3;
        if (zzie3.zze) {
            this.zzh = zzie3;
        }
        this.zzt.zzt().zzG(zzie3);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzB(zzie zzie, boolean z10, long j10) {
        boolean z11;
        this.zzt.zzd().zzf(this.zzt.zzav().elapsedRealtime());
        if (zzie == null || !zzie.zzd) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.zzt.zzu().zzb.d(z11, z10, j10) && zzie != null) {
            zzie.zzd = false;
        }
    }

    static /* bridge */ /* synthetic */ void zzp(zzim zzim, Bundle bundle, zzie zzie, zzie zzie2, long j10) {
        bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
        bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        zzim.zzA(zzie, zzie2, j10, true, zzim.zzt.zzv().zzy((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List) null, false));
    }

    @MainThread
    private final zzie zzy(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity);
        zzie zzie = (zzie) this.zzd.get(activity);
        if (zzie == null) {
            zzie zzie2 = new zzie((String) null, zzl(activity.getClass(), "Activity"), this.zzt.zzv().zzq());
            this.zzd.put(activity, zzie2);
            zzie = zzie2;
        }
        if (this.zzg != null) {
            return this.zzg;
        }
        return zzie;
    }

    @MainThread
    private final void zzz(Activity activity, zzie zzie, boolean z10) {
        zzie zzie2;
        zzie zzie3;
        String str;
        zzie zzie4 = zzie;
        if (this.zzb == null) {
            zzie2 = this.zzc;
        } else {
            zzie2 = this.zzb;
        }
        zzie zzie5 = zzie2;
        if (zzie4.zzb == null) {
            if (activity != null) {
                str = zzl(activity.getClass(), "Activity");
            } else {
                str = null;
            }
            zzie3 = new zzie(zzie4.zza, str, zzie4.zzc, zzie4.zze, zzie4.zzf);
        } else {
            zzie3 = zzie4;
        }
        this.zzc = this.zzb;
        this.zzb = zzie3;
        this.zzt.zzaz().zzp(new d2(this, zzie3, zzie5, this.zzt.zzav().elapsedRealtime(), z10));
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    public final zzie zzi() {
        return this.zzb;
    }

    @WorkerThread
    public final zzie zzj(boolean z10) {
        zza();
        zzg();
        if (!z10) {
            return this.zza;
        }
        zzie zzie = this.zza;
        if (zzie != null) {
            return zzie;
        }
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzl(Class cls, String str) {
        String str2;
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return "Activity";
        }
        String[] split = canonicalName.split("\\.");
        int length = split.length;
        if (length > 0) {
            str2 = split[length - 1];
        } else {
            str2 = "";
        }
        int length2 = str2.length();
        this.zzt.zzf();
        if (length2 <= 100) {
            return str2;
        }
        this.zzt.zzf();
        return str2.substring(0, 100);
    }

    @MainThread
    public final void zzr(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (this.zzt.zzf().zzu() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzie(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    @MainThread
    public final void zzs(Activity activity) {
        synchronized (this.zzj) {
            try {
                if (activity == this.zze) {
                    this.zze = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (this.zzt.zzf().zzu()) {
            this.zzd.remove(activity);
        }
    }

    @MainThread
    public final void zzt(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = this.zzt.zzav().elapsedRealtime();
        if (!this.zzt.zzf().zzu()) {
            this.zzb = null;
            this.zzt.zzaz().zzp(new f2(this, elapsedRealtime));
            return;
        }
        zzie zzy = zzy(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        this.zzt.zzaz().zzp(new g2(this, zzy, elapsedRealtime));
    }

    @MainThread
    public final void zzu(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (this.zzt.zzf().zzu()) {
                    this.zzg = null;
                    this.zzt.zzaz().zzp(new h2(this));
                }
            }
        }
        if (!this.zzt.zzf().zzu()) {
            this.zzb = this.zzg;
            this.zzt.zzaz().zzp(new e2(this));
            return;
        }
        zzz(activity, zzy(activity), false);
        zzd zzd2 = this.zzt.zzd();
        zzd2.zzt.zzaz().zzp(new l(zzd2, zzd2.zzt.zzav().elapsedRealtime()));
    }

    @MainThread
    public final void zzv(Activity activity, Bundle bundle) {
        zzie zzie;
        if (this.zzt.zzf().zzu() && bundle != null && (zzie = (zzie) this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzie.zzc);
            bundle2.putString("name", zzie.zza);
            bundle2.putString("referrer_name", zzie.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r5.length() <= 100) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b4, code lost:
        if (r6.length() <= 100) goto L_0x00cf;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzw(@androidx.annotation.NonNull android.app.Activity r4, @androidx.annotation.Size(max = 36, min = 1) java.lang.String r5, @androidx.annotation.Size(max = 36, min = 1) java.lang.String r6) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzu()
            if (r0 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r4.zza(r5)
            return
        L_0x001c:
            com.google.android.gms.measurement.internal.zzie r0 = r3.zzb
            if (r0 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called while no activity active"
            r4.zza(r5)
            return
        L_0x0030:
            java.util.Map r1 = r3.zzd
            java.lang.Object r1 = r1.get(r4)
            if (r1 != 0) goto L_0x0048
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r4.zza(r5)
            return
        L_0x0048:
            if (r6 != 0) goto L_0x0054
            java.lang.Class r6 = r4.getClass()
            java.lang.String r1 = "Activity"
            java.lang.String r6 = r3.zzl(r6, r1)
        L_0x0054:
            java.lang.String r1 = r0.zzb
            boolean r1 = com.google.android.gms.measurement.internal.zzif.zza(r1, r6)
            java.lang.String r0 = r0.zza
            boolean r0 = com.google.android.gms.measurement.internal.zzif.zza(r0, r5)
            if (r1 == 0) goto L_0x0075
            if (r0 != 0) goto L_0x0065
            goto L_0x0075
        L_0x0065:
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzl()
            java.lang.String r5 = "setCurrentScreen cannot be called with the same class and name"
            r4.zza(r5)
            return
        L_0x0075:
            r0 = 100
            if (r5 == 0) goto L_0x00a3
            int r1 = r5.length()
            if (r1 <= 0) goto L_0x008b
            com.google.android.gms.measurement.internal.zzfr r1 = r3.zzt
            r1.zzf()
            int r1 = r5.length()
            if (r1 > r0) goto L_0x008b
            goto L_0x00a3
        L_0x008b:
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzl()
            int r5 = r5.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid screen name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00a3:
            if (r6 == 0) goto L_0x00cf
            int r1 = r6.length()
            if (r1 <= 0) goto L_0x00b7
            com.google.android.gms.measurement.internal.zzfr r1 = r3.zzt
            r1.zzf()
            int r1 = r6.length()
            if (r1 > r0) goto L_0x00b7
            goto L_0x00cf
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzl()
            int r5 = r6.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "Invalid class name length in setCurrentScreen. Length"
            r4.zzb(r6, r5)
            return
        L_0x00cf:
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            if (r5 != 0) goto L_0x00de
            java.lang.String r1 = "null"
            goto L_0x00df
        L_0x00de:
            r1 = r5
        L_0x00df:
            java.lang.String r2 = "Setting current screen to name, class"
            r0.zzc(r2, r1, r6)
            com.google.android.gms.measurement.internal.zzie r0 = new com.google.android.gms.measurement.internal.zzie
            com.google.android.gms.measurement.internal.zzfr r1 = r3.zzt
            com.google.android.gms.measurement.internal.zzlb r1 = r1.zzv()
            long r1 = r1.zzq()
            r0.<init>(r5, r6, r1)
            java.util.Map r5 = r3.zzd
            r5.put(r4, r0)
            r5 = 1
            r3.zzz(r4, r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzim.zzw(android.app.Activity, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r2 > 100) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        if (r4 > 100) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c4, code lost:
        r0 = r12.zzt.zzay().zzj();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ce, code lost:
        if (r3 != null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d0, code lost:
        r1 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d3, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        if (r4 != null) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d6, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d9, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00da, code lost:
        r0.zzc("Logging screen view with name, class", r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e1, code lost:
        if (r12.zzb != null) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e3, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e6, code lost:
        r0 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e8, code lost:
        r2 = new com.google.android.gms.measurement.internal.zzie(r3, r4, r12.zzt.zzv().zzq(), true, r14);
        r12.zzb = r2;
        r12.zzc = r0;
        r12.zzg = r2;
        r12.zzt.zzaz().zzp(new com.google.android.gms.measurement.internal.c2(r12, r13, r2, r0, r12.zzt.zzav().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x001b
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzt     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r13 = move-exception
            goto L_0x011e
        L_0x001b:
            java.lang.String r1 = "screen_name"
            java.lang.String r3 = r13.getString(r1)     // Catch:{ all -> 0x0018 }
            r1 = 100
            if (r3 == 0) goto L_0x004f
            int r2 = r3.length()     // Catch:{ all -> 0x0018 }
            if (r2 <= 0) goto L_0x0036
            int r2 = r3.length()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzfr r4 = r12.zzt     // Catch:{ all -> 0x0018 }
            r4.zzf()     // Catch:{ all -> 0x0018 }
            if (r2 <= r1) goto L_0x004f
        L_0x0036:
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzt     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x0018 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0018 }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x004f:
            java.lang.String r2 = "screen_class"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x0081
            int r4 = r2.length()     // Catch:{ all -> 0x0018 }
            if (r4 <= 0) goto L_0x0068
            int r4 = r2.length()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzfr r5 = r12.zzt     // Catch:{ all -> 0x0018 }
            r5.zzf()     // Catch:{ all -> 0x0018 }
            if (r4 <= r1) goto L_0x0081
        L_0x0068:
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzt     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x0018 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0018 }
            r13.zzb(r14, r15)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x0081:
            if (r2 != 0) goto L_0x0096
            android.app.Activity r1 = r12.zze     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0093
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.zzl(r1, r2)     // Catch:{ all -> 0x0018 }
        L_0x0091:
            r4 = r1
            goto L_0x0097
        L_0x0093:
            java.lang.String r1 = "Activity"
            goto L_0x0091
        L_0x0096:
            r4 = r2
        L_0x0097:
            com.google.android.gms.measurement.internal.zzie r1 = r12.zzb     // Catch:{ all -> 0x0018 }
            boolean r2 = r12.zzf     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x00c3
            if (r1 == 0) goto L_0x00c3
            r2 = 0
            r12.zzf = r2     // Catch:{ all -> 0x0018 }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x0018 }
            boolean r2 = com.google.android.gms.measurement.internal.zzif.zza(r2, r4)     // Catch:{ all -> 0x0018 }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x0018 }
            boolean r1 = com.google.android.gms.measurement.internal.zzif.zza(r1, r3)     // Catch:{ all -> 0x0018 }
            if (r2 == 0) goto L_0x00c3
            if (r1 == 0) goto L_0x00c3
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzt     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            return
        L_0x00c3:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzfr r0 = r12.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            if (r3 != 0) goto L_0x00d3
            java.lang.String r1 = "null"
            goto L_0x00d4
        L_0x00d3:
            r1 = r3
        L_0x00d4:
            if (r4 != 0) goto L_0x00d9
            java.lang.String r2 = "null"
            goto L_0x00da
        L_0x00d9:
            r2 = r4
        L_0x00da:
            java.lang.String r5 = "Logging screen view with name, class"
            r0.zzc(r5, r1, r2)
            com.google.android.gms.measurement.internal.zzie r0 = r12.zzb
            if (r0 != 0) goto L_0x00e6
            com.google.android.gms.measurement.internal.zzie r0 = r12.zzc
            goto L_0x00e8
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzie r0 = r12.zzb
        L_0x00e8:
            com.google.android.gms.measurement.internal.zzie r1 = new com.google.android.gms.measurement.internal.zzie
            com.google.android.gms.measurement.internal.zzfr r2 = r12.zzt
            com.google.android.gms.measurement.internal.zzlb r2 = r2.zzv()
            long r5 = r2.zzq()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r1
            r12.zzc = r0
            r12.zzg = r1
            com.google.android.gms.measurement.internal.zzfr r14 = r12.zzt
            com.google.android.gms.common.util.Clock r14 = r14.zzav()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzfr r14 = r12.zzt
            com.google.android.gms.measurement.internal.zzfo r14 = r14.zzaz()
            com.google.android.gms.measurement.internal.c2 r15 = new com.google.android.gms.measurement.internal.c2
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.zzp(r15)
            return
        L_0x011e:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzim.zzx(android.os.Bundle, long):void");
    }
}
