package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;

public final class zzdy extends z {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private final long zzg;
    private List zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn = 0;
    private String zzo = null;

    zzdy(zzfr zzfr, long j10) {
        super(zzfr);
        this.zzg = j10;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x018b A[Catch:{ IllegalStateException -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0194 A[Catch:{ IllegalStateException -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01bf A[Catch:{ IllegalStateException -> 0x01bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x024e  */
    @androidx.annotation.WorkerThread
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            android.content.Context r0 = r0.zzau()
            java.lang.String r0 = r0.getPackageName()
            com.google.android.gms.measurement.internal.zzfr r1 = r11.zzt
            android.content.Context r1 = r1.zzau()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            java.lang.String r4 = ""
            java.lang.String r5 = "unknown"
            java.lang.String r6 = "Unknown"
            if (r1 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r7.zzb(r8, r9)
        L_0x0032:
            r8 = r6
            goto L_0x009b
        L_0x0035:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x003a }
            goto L_0x004d
        L_0x003a:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r7.zzb(r8, r9)
        L_0x004d:
            if (r5 != 0) goto L_0x0052
            java.lang.String r5 = "manual_install"
            goto L_0x005b
        L_0x0052:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x005b
            r5 = r4
        L_0x005b:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.Context r7 = r7.zzau()     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0085 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r3)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r7 == 0) goto L_0x0032
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0085 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0085 }
            if (r9 != 0) goto L_0x007c
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0085 }
            goto L_0x007d
        L_0x007c:
            r8 = r6
        L_0x007d:
            java.lang.String r6 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0082 }
            int r2 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0082 }
            goto L_0x009b
        L_0x0082:
            r7 = r6
            r6 = r8
            goto L_0x0086
        L_0x0085:
            r7 = r6
        L_0x0086:
            com.google.android.gms.measurement.internal.zzfr r8 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzd()
            java.lang.String r9 = "Error retrieving package info. appId, appName"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r8.zzc(r9, r10, r6)
            r8 = r6
            r6 = r7
        L_0x009b:
            r11.zza = r0
            r11.zzd = r5
            r11.zzb = r6
            r11.zzc = r2
            r11.zze = r8
            r5 = 0
            r11.zzf = r5
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt
            java.lang.String r2 = r2.zzw()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r2 != 0) goto L_0x00c6
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt
            java.lang.String r2 = r2.zzx()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00c6
            r2 = r5
            goto L_0x00c7
        L_0x00c6:
            r2 = r3
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzfr r6 = r11.zzt
            int r6 = r6.zza()
            switch(r6) {
                case 0: goto L_0x0151;
                case 1: goto L_0x0141;
                case 2: goto L_0x0131;
                case 3: goto L_0x0121;
                case 4: goto L_0x0111;
                case 5: goto L_0x0101;
                case 6: goto L_0x00f1;
                case 7: goto L_0x00e1;
                default: goto L_0x00d0;
            }
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x0160
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x0160
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzl()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x0160
        L_0x0101:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0111:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0121:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x0160
        L_0x0131:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x0160
        L_0x0141:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzi()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x0160
        L_0x0151:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzj()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x0160:
            r11.zzk = r4
            r11.zzl = r4
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt
            r7.zzaw()
            if (r2 == 0) goto L_0x0173
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt
            java.lang.String r2 = r2.zzw()
            r11.zzl = r2
        L_0x0173:
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01bb }
            android.content.Context r2 = r2.zzau()     // Catch:{ IllegalStateException -> 0x01bb }
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzt     // Catch:{ IllegalStateException -> 0x01bb }
            java.lang.String r7 = r7.zzz()     // Catch:{ IllegalStateException -> 0x01bb }
            java.lang.String r8 = "google_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzid.zzc(r2, r8, r7)     // Catch:{ IllegalStateException -> 0x01bb }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01bb }
            if (r5 == r7) goto L_0x018c
            r4 = r2
        L_0x018c:
            r11.zzk = r4     // Catch:{ IllegalStateException -> 0x01bb }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01bb }
            if (r2 != 0) goto L_0x01bd
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01bb }
            android.content.Context r2 = r2.zzau()     // Catch:{ IllegalStateException -> 0x01bb }
            com.google.android.gms.measurement.internal.zzfr r4 = r11.zzt     // Catch:{ IllegalStateException -> 0x01bb }
            java.lang.String r4 = r4.zzz()     // Catch:{ IllegalStateException -> 0x01bb }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ IllegalStateException -> 0x01bb }
            android.content.res.Resources r5 = r2.getResources()     // Catch:{ IllegalStateException -> 0x01bb }
            boolean r7 = android.text.TextUtils.isEmpty(r4)     // Catch:{ IllegalStateException -> 0x01bb }
            if (r7 != 0) goto L_0x01ae
            goto L_0x01b2
        L_0x01ae:
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzfj.zza(r2)     // Catch:{ IllegalStateException -> 0x01bb }
        L_0x01b2:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzfj.zzb(r2, r5, r4)     // Catch:{ IllegalStateException -> 0x01bb }
            r11.zzl = r2     // Catch:{ IllegalStateException -> 0x01bb }
            goto L_0x01bd
        L_0x01bb:
            r2 = move-exception
            goto L_0x01de
        L_0x01bd:
            if (r6 != 0) goto L_0x01f1
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzt     // Catch:{ IllegalStateException -> 0x01bb }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ IllegalStateException -> 0x01bb }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ IllegalStateException -> 0x01bb }
            java.lang.String r4 = "App measurement enabled for app package, google app id"
            java.lang.String r5 = r11.zza     // Catch:{ IllegalStateException -> 0x01bb }
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01bb }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ IllegalStateException -> 0x01bb }
            if (r6 == 0) goto L_0x01d8
            java.lang.String r6 = r11.zzl     // Catch:{ IllegalStateException -> 0x01bb }
            goto L_0x01da
        L_0x01d8:
            java.lang.String r6 = r11.zzk     // Catch:{ IllegalStateException -> 0x01bb }
        L_0x01da:
            r2.zzc(r4, r5, r6)     // Catch:{ IllegalStateException -> 0x01bb }
            goto L_0x01f1
        L_0x01de:
            com.google.android.gms.measurement.internal.zzfr r4 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()
            java.lang.String r5 = "Fetching Google App Id failed with exception. appId"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzeh.zzn(r0)
            r4.zzc(r5, r0, r2)
        L_0x01f1:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            r0.zzaw()
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzp(r2)
            if (r0 != 0) goto L_0x0208
            goto L_0x023d
        L_0x0208:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x021e
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzl()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r0.zza(r2)
            goto L_0x023f
        L_0x021e:
            java.util.Iterator r2 = r0.iterator()
        L_0x0222:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x023d
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            com.google.android.gms.measurement.internal.zzfr r5 = r11.zzt
            com.google.android.gms.measurement.internal.zzlb r5 = r5.zzv()
            java.lang.String r6 = "safelisted event"
            boolean r4 = r5.zzab(r6, r4)
            if (r4 != 0) goto L_0x0222
            goto L_0x023f
        L_0x023d:
            r11.zzh = r0
        L_0x023f:
            if (r1 == 0) goto L_0x024e
            com.google.android.gms.measurement.internal.zzfr r0 = r11.zzt
            android.content.Context r0 = r0.zzau()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzj = r0
            return
        L_0x024e:
            r11.zzj = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzd():void");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzh() {
        zza();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzi() {
        zza();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x026d  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzq zzj(java.lang.String r37) {
        /*
            r36 = this;
            r1 = r36
            r2 = 1
            r36.zzg()
            com.google.android.gms.measurement.internal.zzq r34 = new com.google.android.gms.measurement.internal.zzq
            java.lang.String r4 = r36.zzl()
            java.lang.String r5 = r36.zzm()
            r36.zza()
            java.lang.String r6 = r1.zzb
            r36.zza()
            int r0 = r1.zzc
            long r7 = (long) r0
            r36.zza()
            java.lang.String r0 = r1.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            java.lang.String r9 = r1.zzd
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            r0.zzh()
            r36.zza()
            r36.zzg()
            long r10 = r1.zzf
            r12 = 0
            int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r3 = 0
            if (r0 != 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzlb r10 = r0.zzv()
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            android.content.Context r0 = r0.zzau()
            com.google.android.gms.measurement.internal.zzfr r11 = r1.zzt
            android.content.Context r11 = r11.zzau()
            java.lang.String r11 = r11.getPackageName()
            r10.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            android.content.pm.PackageManager r14 = r0.getPackageManager()
            java.security.MessageDigest r15 = com.google.android.gms.measurement.internal.zzlb.zzF()
            r16 = -1
            if (r15 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()
            java.lang.String r10 = "Could not get MD5 instance"
            r0.zza(r10)
        L_0x0077:
            r10 = r16
            goto L_0x00d1
        L_0x007a:
            if (r14 == 0) goto L_0x00d0
            boolean r11 = r10.zzag(r0, r11)     // Catch:{ NameNotFoundException -> 0x00ac }
            if (r11 != 0) goto L_0x00be
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x00ac }
            com.google.android.gms.measurement.internal.zzfr r11 = r10.zzt     // Catch:{ NameNotFoundException -> 0x00ac }
            android.content.Context r11 = r11.zzau()     // Catch:{ NameNotFoundException -> 0x00ac }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ NameNotFoundException -> 0x00ac }
            r14 = 64
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r11, r14)     // Catch:{ NameNotFoundException -> 0x00ac }
            android.content.pm.Signature[] r0 = r0.signatures     // Catch:{ NameNotFoundException -> 0x00ac }
            if (r0 == 0) goto L_0x00ae
            int r11 = r0.length     // Catch:{ NameNotFoundException -> 0x00ac }
            if (r11 <= 0) goto L_0x00ae
            r0 = r0[r3]     // Catch:{ NameNotFoundException -> 0x00ac }
            byte[] r0 = r0.toByteArray()     // Catch:{ NameNotFoundException -> 0x00ac }
            byte[] r0 = r15.digest(r0)     // Catch:{ NameNotFoundException -> 0x00ac }
            long r16 = com.google.android.gms.measurement.internal.zzlb.zzp(r0)     // Catch:{ NameNotFoundException -> 0x00ac }
            goto L_0x0077
        L_0x00ac:
            r0 = move-exception
            goto L_0x00c1
        L_0x00ae:
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt     // Catch:{ NameNotFoundException -> 0x00ac }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ NameNotFoundException -> 0x00ac }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ NameNotFoundException -> 0x00ac }
            java.lang.String r11 = "Could not get signatures"
            r0.zza(r11)     // Catch:{ NameNotFoundException -> 0x00ac }
            goto L_0x0077
        L_0x00be:
            r16 = r12
            goto L_0x0077
        L_0x00c1:
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()
            java.lang.String r11 = "Package name not found"
            r10.zzb(r11, r0)
        L_0x00d0:
            r10 = r12
        L_0x00d1:
            r1.zzf = r10
        L_0x00d3:
            r14 = r10
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            boolean r0 = r0.zzJ()
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.x r10 = r10.zzm()
            boolean r10 = r10.f7782o
            r16 = r10 ^ 1
            r36.zzg()
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            boolean r10 = r10.zzJ()
            r11 = 0
            if (r10 != 0) goto L_0x00f4
        L_0x00f0:
            r20 = r11
            goto L_0x0179
        L_0x00f4:
            com.google.android.gms.internal.measurement.zzpj.zzc()
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r10 = r10.zzf()
            com.google.android.gms.measurement.internal.zzdt r12 = com.google.android.gms.measurement.internal.zzdu.zzaa
            boolean r10 = r10.zzs(r11, r12)
            if (r10 == 0) goto L_0x0115
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzj()
            java.lang.String r12 = "Disabled IID for tests."
            r10.zza(r12)
            goto L_0x00f0
        L_0x0115:
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt     // Catch:{ ClassNotFoundException -> 0x0166 }
            android.content.Context r10 = r10.zzau()     // Catch:{ ClassNotFoundException -> 0x0166 }
            java.lang.ClassLoader r10 = r10.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0166 }
            java.lang.String r12 = "com.google.firebase.analytics.FirebaseAnalytics"
            java.lang.Class r10 = r10.loadClass(r12)     // Catch:{ ClassNotFoundException -> 0x0166 }
            if (r10 != 0) goto L_0x0128
            goto L_0x00f0
        L_0x0128:
            java.lang.Class[] r12 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0169 }
            java.lang.Class<android.content.Context> r13 = android.content.Context.class
            r12[r3] = r13     // Catch:{ Exception -> 0x0169 }
            java.lang.String r13 = "getInstance"
            java.lang.reflect.Method r12 = r10.getDeclaredMethod(r13, r12)     // Catch:{ Exception -> 0x0169 }
            com.google.android.gms.measurement.internal.zzfr r13 = r1.zzt     // Catch:{ Exception -> 0x0169 }
            android.content.Context r13 = r13.zzau()     // Catch:{ Exception -> 0x0169 }
            java.lang.Object[] r11 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0169 }
            r11[r3] = r13     // Catch:{ Exception -> 0x0169 }
            r13 = 0
            java.lang.Object r11 = r12.invoke(r13, r11)     // Catch:{ Exception -> 0x0169 }
            if (r11 != 0) goto L_0x0148
            r20 = r13
            goto L_0x0179
        L_0x0148:
            java.lang.String r12 = "getFirebaseInstanceId"
            java.lang.reflect.Method r10 = r10.getDeclaredMethod(r12, r13)     // Catch:{ Exception -> 0x0157 }
            java.lang.Object r10 = r10.invoke(r11, r13)     // Catch:{ Exception -> 0x0157 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x0157 }
            r20 = r10
            goto L_0x0179
        L_0x0157:
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzl()
            java.lang.String r11 = "Failed to retrieve Firebase Instance Id"
            r10.zza(r11)
        L_0x0166:
            r20 = 0
            goto L_0x0179
        L_0x0169:
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzm()
            java.lang.String r11 = "Failed to obtain Firebase Analytics instance"
            r10.zza(r11)
            goto L_0x0166
        L_0x0179:
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.x r11 = r10.zzm()
            com.google.android.gms.measurement.internal.zzes r11 = r11.f7770c
            long r11 = r11.zza()
            r17 = 0
            int r13 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r13 != 0) goto L_0x0190
            long r10 = r10.zzc
            r22 = r10
            goto L_0x0198
        L_0x0190:
            long r2 = r10.zzc
            long r2 = java.lang.Math.min(r2, r11)
            r22 = r2
        L_0x0198:
            r36.zza()
            int r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r3 = r3.zzf()
            boolean r24 = r3.zzr()
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.x r3 = r3.zzm()
            r3.zzg()
            android.content.SharedPreferences r3 = r3.a()
            java.lang.String r10 = "deferred_analytics_collection"
            r11 = 0
            boolean r25 = r3.getBoolean(r10, r11)
            r36.zza()
            java.lang.String r12 = r1.zzl
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r3 = r3.zzf()
            java.lang.String r10 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r3 = r3.zzk(r10)
            if (r3 != 0) goto L_0x01d1
            r26 = 0
            goto L_0x01dd
        L_0x01d1:
            boolean r3 = r3.booleanValue()
            r10 = 1
            r3 = r3 ^ r10
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r26 = r3
        L_0x01dd:
            long r10 = r1.zzg
            java.util.List r13 = r1.zzh
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.x r3 = r3.zzm()
            com.google.android.gms.measurement.internal.zzai r3 = r3.c()
            java.lang.String r31 = r3.zzh()
            java.lang.String r3 = r1.zzi
            if (r3 != 0) goto L_0x0216
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r3 = r3.zzf()
            r27 = r10
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzap
            r11 = 0
            boolean r3 = r3.zzs(r11, r10)
            if (r3 == 0) goto L_0x0211
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.measurement.internal.zzlb r3 = r3.zzv()
            java.lang.String r3 = r3.zzC()
            r1.zzi = r3
            goto L_0x0218
        L_0x0211:
            java.lang.String r3 = ""
            r1.zzi = r3
            goto L_0x0218
        L_0x0216:
            r27 = r10
        L_0x0218:
            java.lang.String r3 = r1.zzi
            com.google.android.gms.internal.measurement.zzpd.zzc()
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r10 = r10.zzf()
            com.google.android.gms.measurement.internal.zzdt r11 = com.google.android.gms.measurement.internal.zzdu.zzam
            r21 = r3
            r3 = 0
            boolean r10 = r10.zzs(r3, r11)
            if (r10 == 0) goto L_0x026d
            r36.zzg()
            long r10 = r1.zzn
            r17 = 0
            int r3 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r3 != 0) goto L_0x023e
            r17 = r12
            r29 = r13
            goto L_0x0261
        L_0x023e:
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzt
            com.google.android.gms.common.util.Clock r3 = r3.zzav()
            long r10 = r3.currentTimeMillis()
            r17 = r12
            r29 = r13
            long r12 = r1.zzn
            long r10 = r10 - r12
            java.lang.String r3 = r1.zzm
            if (r3 == 0) goto L_0x0261
            r12 = 86400000(0x5265c00, double:4.2687272E-316)
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x0261
            java.lang.String r3 = r1.zzo
            if (r3 != 0) goto L_0x0261
            r36.zzo()
        L_0x0261:
            java.lang.String r3 = r1.zzm
            if (r3 != 0) goto L_0x0268
            r36.zzo()
        L_0x0268:
            java.lang.String r3 = r1.zzm
        L_0x026a:
            r33 = r3
            goto L_0x0272
        L_0x026d:
            r17 = r12
            r29 = r13
            goto L_0x026a
        L_0x0272:
            r18 = 0
            r30 = 0
            r10 = 74029(0x1212d, double:3.6575E-319)
            r32 = r21
            r3 = r34
            r35 = r29
            r29 = r17
            r12 = r14
            r14 = r37
            r15 = r0
            r17 = r20
            r20 = r22
            r22 = r2
            r23 = r24
            r24 = r25
            r25 = r29
            r29 = r35
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (java.lang.String) r9, (long) r10, (long) r12, (java.lang.String) r14, (boolean) r15, (boolean) r16, (java.lang.String) r17, (long) r18, (long) r20, (int) r22, (boolean) r23, (boolean) r24, (java.lang.String) r25, (java.lang.Boolean) r26, (long) r27, (java.util.List) r29, (java.lang.String) r30, (java.lang.String) r31, (java.lang.String) r32, (java.lang.String) r33)
            return r34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdy.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzk() {
        zza();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzl() {
        zza();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzm() {
        zzg();
        zza();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final List zzn() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzo() {
        String str;
        String str2;
        zzg();
        if (!this.zzt.zzm().c().zzi(zzah.ANALYTICS_STORAGE)) {
            this.zzt.zzay().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            this.zzt.zzv().zzG().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzef zzc2 = this.zzt.zzay().zzc();
        if (str == null) {
            str2 = "null";
        } else {
            str2 = "not null";
        }
        zzc2.zza(String.format("Resetting session stitching token to %s", new Object[]{str2}));
        this.zzm = str;
        this.zzn = this.zzt.zzav().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzp(String str) {
        String str2 = this.zzo;
        boolean z10 = false;
        if (str2 != null && !str2.equals(str)) {
            z10 = true;
        }
        this.zzo = str;
        return z10;
    }
}
