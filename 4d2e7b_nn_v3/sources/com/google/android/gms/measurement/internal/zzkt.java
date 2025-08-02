package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.alibaba.pdns.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcl;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zzox;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.firebase.messaging.Constants;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzkt implements z0 {
    private static volatile zzkt zzb;
    private long zzA;
    private final Map zzB;
    private final Map zzC;
    private zzie zzD;
    private String zzE;
    private final f4 zzF = new a4(this);
    @VisibleForTesting
    long zza;
    private final zzfi zzc;
    private final zzen zzd;
    private f zze;
    private w zzf;
    private zzkf zzg;
    private b zzh;
    private final zzkv zzi;
    private b2 zzj;
    private zzjo zzk;
    private final zzki zzl;
    private zzez zzm;
    /* access modifiers changed from: private */
    public final zzfr zzn;
    private boolean zzo = false;
    private boolean zzp;
    private List zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private FileLock zzw;
    private FileChannel zzx;
    private List zzy;
    private List zzz;

    zzkt(zzku zzku, zzfr zzfr) {
        Preconditions.checkNotNull(zzku);
        this.zzn = zzfr.zzp(zzku.zza, (zzcl) null, (Long) null);
        this.zzA = -1;
        this.zzl = new zzki(this);
        zzkv zzkv = new zzkv(this);
        zzkv.zzX();
        this.zzi = zzkv;
        zzen zzen = new zzen(this);
        zzen.zzX();
        this.zzd = zzen;
        zzfi zzfi = new zzfi(this);
        zzfi.zzX();
        this.zzc = zzfi;
        this.zzB = new HashMap();
        this.zzC = new HashMap();
        zzaz().zzp(new v3(this, zzku));
    }

    @VisibleForTesting
    static final void zzaa(zzfs zzfs, int i10, String str) {
        List zzp2 = zzfs.zzp();
        int i11 = 0;
        while (i11 < zzp2.size()) {
            if (!"_err".equals(((zzfx) zzp2.get(i11)).zzg())) {
                i11++;
            } else {
                return;
            }
        }
        zzfw zze2 = zzfx.zze();
        zze2.zzj("_err");
        zze2.zzi((long) i10);
        zzfw zze3 = zzfx.zze();
        zze3.zzj("_ev");
        zze3.zzk(str);
        zzfs.zzf((zzfx) zze2.zzaC());
        zzfs.zzf((zzfx) zze3.zzaC());
    }

    @VisibleForTesting
    static final void zzab(zzfs zzfs, @NonNull String str) {
        List zzp2 = zzfs.zzp();
        for (int i10 = 0; i10 < zzp2.size(); i10++) {
            if (str.equals(((zzfx) zzp2.get(i10)).zzg())) {
                zzfs.zzh(i10);
                return;
            }
        }
    }

    @WorkerThread
    private final zzq zzac(String str) {
        String str2 = str;
        f fVar = this.zze;
        zzal(fVar);
        c1 D = fVar.D(str2);
        if (D == null || TextUtils.isEmpty(D.g0())) {
            zzay().zzc().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzad = zzad(D);
        if (zzad == null || zzad.booleanValue()) {
            String i02 = D.i0();
            String g02 = D.g0();
            long L = D.L();
            String f02 = D.f0();
            long W = D.W();
            long T = D.T();
            boolean J = D.J();
            String h02 = D.h0();
            D.A();
            return new zzq(str, i02, g02, L, f02, W, T, (String) null, J, false, h02, 0, 0, 0, D.I(), false, D.b0(), D.a0(), D.U(), D.c(), (String) null, zzh(str).zzh(), "", (String) null);
        }
        zzay().zzd().zzb("App version does not match; dropping. appId", zzeh.zzn(str));
        return null;
    }

    @WorkerThread
    private final Boolean zzad(c1 c1Var) {
        try {
            if (c1Var.L() != -2147483648L) {
                if (c1Var.L() == ((long) Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(c1Var.d0(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzau()).getPackageInfo(c1Var.d0(), 0).versionName;
                String g02 = c1Var.g0();
                if (g02 != null && g02.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    private final void zzae() {
        zzaz().zzg();
        if (this.zzt || this.zzu || this.zzv) {
            zzay().zzj().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzt), Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv));
            return;
        }
        zzay().zzj().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    @VisibleForTesting
    private final void zzaf(zzgc zzgc, long j10, boolean z10) {
        String str;
        d4 d4Var;
        String str2;
        if (true != z10) {
            str = "_lte";
        } else {
            str = "_se";
        }
        f fVar = this.zze;
        zzal(fVar);
        d4 J = fVar.J(zzgc.zzap(), str);
        if (J == null || J.f7465e == null) {
            d4Var = new d4(zzgc.zzap(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(j10));
        } else {
            d4Var = new d4(zzgc.zzap(), "auto", str, zzav().currentTimeMillis(), Long.valueOf(((Long) J.f7465e).longValue() + j10));
        }
        zzgl zzd2 = zzgm.zzd();
        zzd2.zzf(str);
        zzd2.zzg(zzav().currentTimeMillis());
        zzd2.zze(((Long) d4Var.f7465e).longValue());
        zzgm zzgm = (zzgm) zzd2.zzaC();
        int zza2 = zzkv.zza(zzgc, str);
        if (zza2 >= 0) {
            zzgc.zzam(zza2, zzgm);
        } else {
            zzgc.zzm(zzgm);
        }
        if (j10 > 0) {
            f fVar2 = this.zze;
            zzal(fVar2);
            fVar2.k(d4Var);
            if (true != z10) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzay().zzj().zzc("Updated engagement user property. scope, value", str2, d4Var.f7465e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0237  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzag() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzfo r1 = r20.zzaz()
            r1.zzg()
            r20.zzB()
            long r1 = r0.zza
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.elapsedRealtime()
            long r5 = r0.zza
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.w r1 = r20.zzm()
            r1.c()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x004c:
            r0.zza = r3
        L_0x004e:
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzn
            boolean r1 = r1.zzM()
            if (r1 == 0) goto L_0x0254
            boolean r1 = r20.zzai()
            if (r1 != 0) goto L_0x005e
            goto L_0x0254
        L_0x005e:
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzz
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.f r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.g()
            r10 = 1
            if (r5 != 0) goto L_0x0093
            com.google.android.gms.measurement.internal.f r5 = r0.zze
            zzal(r5)
            boolean r5 = r5.f()
            if (r5 == 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r10 = 0
        L_0x0093:
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.measurement.internal.zzag r5 = r20.zzg()
            java.lang.String r5 = r5.zzl()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bf
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bf
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzu
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00bf:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzt
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e6
        L_0x00d3:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzs
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e6:
            com.google.android.gms.measurement.internal.zzjo r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzc
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zzjo r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r5 = r5.zzd
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.f r5 = r0.zze
            zzal(r5)
            r17 = r10
            long r9 = r5.z()
            com.google.android.gms.measurement.internal.f r5 = r0.zze
            zzal(r5)
            r18 = r7
            long r6 = r5.A()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0117
        L_0x0114:
            r7 = r3
            goto L_0x018e
        L_0x0117:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r9 = r1 - r9
            long r1 = r1 - r7
            long r1 = java.lang.Math.max(r1, r9)
            long r7 = r5 + r18
            if (r17 == 0) goto L_0x013c
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x013c
            long r7 = java.lang.Math.min(r5, r1)
            long r7 = r7 + r11
        L_0x013c:
            com.google.android.gms.measurement.internal.zzkv r13 = r0.zzi
            zzal(r13)
            boolean r13 = r13.zzw(r1, r11)
            if (r13 != 0) goto L_0x0149
            long r7 = r1 + r11
        L_0x0149:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x018e
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x018e
            r1 = 0
        L_0x0152:
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzB
            r5 = 0
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r6 = 0
            int r2 = java.lang.Math.max(r6, r2)
            r11 = 20
            int r2 = java.lang.Math.min(r11, r2)
            if (r1 >= r2) goto L_0x0114
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzA
            java.lang.Object r2 = r2.zza(r5)
            java.lang.Long r2 = (java.lang.Long) r2
            long r11 = r2.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            r13 = 1
            long r13 = r13 << r1
            long r11 = r11 * r13
            long r7 = r7 + r11
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x018e
            int r1 = r1 + 1
            goto L_0x0152
        L_0x018e:
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0237
            com.google.android.gms.measurement.internal.zzen r1 = r0.zzd
            zzal(r1)
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x021a
            com.google.android.gms.measurement.internal.zzjo r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzb
            long r1 = r1.zza()
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzq
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzkv r9 = r0.zzi
            zzal(r9)
            boolean r9 = r9.zzw(r1, r5)
            if (r9 != 0) goto L_0x01c9
            long r1 = r1 + r5
            long r7 = java.lang.Math.max(r7, r1)
        L_0x01c9:
            com.google.android.gms.measurement.internal.w r1 = r20.zzm()
            r1.c()
            com.google.android.gms.common.util.Clock r1 = r20.zzav()
            long r1 = r1.currentTimeMillis()
            long r7 = r7 - r1
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0200
            r20.zzg()
            com.google.android.gms.measurement.internal.zzdt r1 = com.google.android.gms.measurement.internal.zzdu.zzv
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzjo r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc
            com.google.android.gms.common.util.Clock r2 = r20.zzav()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0200:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zzd(r7)
            return
        L_0x021a:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.w r1 = r20.zzm()
            r1.b()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0237:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.w r1 = r20.zzm()
            r1.c()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        L_0x0254:
            com.google.android.gms.measurement.internal.zzeh r1 = r20.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.w r1 = r20.zzm()
            r1.c()
            com.google.android.gms.measurement.internal.zzkf r1 = r0.zzg
            zzal(r1)
            r1.zza()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzag():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:385:0x0b67, code lost:
        if (r11 > (com.google.android.gms.measurement.internal.zzag.zzA() + r9)) goto L_0x0b69;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03a9 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x046c A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04c2 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0817 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0861 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0884 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x08fb A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x08fe A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x0902 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:316:0x092a A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x0b57 A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0bde A[Catch:{ NumberFormatException -> 0x07dc, all -> 0x00e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0bfa A[Catch:{ SQLiteException -> 0x0c12 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:70:0x01e9=Splitter:B:70:0x01e9, B:423:0x0ce9=Splitter:B:423:0x0ce9} */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzah(java.lang.String r41, long r42) {
        /*
            r40 = this;
            r1 = r40
            java.lang.String r2 = "_npa"
            java.lang.String r3 = "_ai"
            com.google.android.gms.measurement.internal.f r4 = r1.zze
            zzal(r4)
            r4.zzw()
            com.google.android.gms.measurement.internal.b4 r4 = new com.google.android.gms.measurement.internal.b4     // Catch:{ all -> 0x00e9 }
            r12 = 0
            r4.<init>(r1, r12)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f r5 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r5)     // Catch:{ all -> 0x00e9 }
            long r9 = r1.zzA     // Catch:{ all -> 0x00e9 }
            r6 = 0
            r7 = r42
            r11 = r4
            r5.t(r6, r7, r9, r11)     // Catch:{ all -> 0x00e9 }
            java.util.List r5 = r4.f7407c     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x0ce9
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x002e
            goto L_0x0ce9
        L_0x002e:
            com.google.android.gms.internal.measurement.zzgd r5 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgc r5 = (com.google.android.gms.internal.measurement.zzgc) r5     // Catch:{ all -> 0x00e9 }
            r5.zzr()     // Catch:{ all -> 0x00e9 }
            r10 = r12
            r13 = r10
            r8 = 0
            r9 = 0
            r11 = -1
            r14 = -1
            r15 = 0
        L_0x0040:
            java.util.List r12 = r4.f7407c     // Catch:{ all -> 0x00e9 }
            int r12 = r12.size()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "_et"
            java.lang.String r7 = "_fr"
            r16 = r15
            java.lang.String r15 = "_e"
            r17 = r9
            r18 = r10
            if (r8 >= r12) goto L_0x053c
            java.util.List r10 = r4.f7407c     // Catch:{ all -> 0x00e9 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r10 = (com.google.android.gms.internal.measurement.zzft) r10     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkb r10 = r10.zzby()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfs r10 = (com.google.android.gms.internal.measurement.zzfs) r10     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfi r12 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r12)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            r19 = r2
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r12.zzr(r9, r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = "_err"
            if (r2 == 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.zzeh r2 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r15 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzd(r15)     // Catch:{ all -> 0x00e9 }
            r2.zzc(r6, r7, r12)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r2.zzp(r6)     // Catch:{ all -> 0x00e9 }
            if (r2 != 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r2.zzs(r6)     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x00c3
            goto L_0x00ed
        L_0x00c3:
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r9.equals(r2)     // Catch:{ all -> 0x00e9 }
            if (r2 != 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzlb r20 = r40.zzv()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f4 r2 = r1.zzF     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r22 = r6.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.String r24 = "_ev"
            java.lang.String r25 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            r26 = 0
            r23 = 11
            r21 = r2
            r20.zzN(r21, r22, r23, r24, r25, r26)     // Catch:{ all -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r0 = move-exception
            r2 = r0
            goto L_0x0cfb
        L_0x00ed:
            r21 = r3
            r3 = r5
            r7 = r8
            r15 = r16
            r9 = r17
            r10 = r18
            r5 = -1
            goto L_0x0533
        L_0x00fa:
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = com.google.android.gms.measurement.internal.zzgo.zza(r3)     // Catch:{ all -> 0x00e9 }
            boolean r2 = r2.equals(r12)     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x0170
            r10.zzi(r3)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = "Renaming ad_impression to _ai"
            r2.zza(r12)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            java.lang.String r2 = r2.zzq()     // Catch:{ all -> 0x00e9 }
            r12 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r12)     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x0170
            r2 = 0
        L_0x0128:
            int r12 = r10.zza()     // Catch:{ all -> 0x00e9 }
            if (r2 >= r12) goto L_0x0170
            java.lang.String r12 = "ad_platform"
            com.google.android.gms.internal.measurement.zzfx r20 = r10.zzn(r2)     // Catch:{ all -> 0x00e9 }
            r21 = r3
            java.lang.String r3 = r20.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r3 = r12.equals(r3)     // Catch:{ all -> 0x00e9 }
            if (r3 == 0) goto L_0x016b
            com.google.android.gms.internal.measurement.zzfx r3 = r10.zzn(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = r3.zzh()     // Catch:{ all -> 0x00e9 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00e9 }
            if (r3 != 0) goto L_0x016b
            java.lang.String r3 = "admob"
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzh()     // Catch:{ all -> 0x00e9 }
            boolean r3 = r3.equalsIgnoreCase(r12)     // Catch:{ all -> 0x00e9 }
            if (r3 == 0) goto L_0x016b
            com.google.android.gms.measurement.internal.zzeh r3 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzl()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = "AdMob ad impression logged from app. Potentially duplicative."
            r3.zza(r12)     // Catch:{ all -> 0x00e9 }
        L_0x016b:
            int r2 = r2 + 1
            r3 = r21
            goto L_0x0128
        L_0x0170:
            r21 = r3
            com.google.android.gms.measurement.internal.zzfi r2 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r3 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r2.zzq(r3, r12)     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = "_c"
            if (r2 != 0) goto L_0x01e2
            com.google.android.gms.measurement.internal.zzkv r12 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r12)     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)     // Catch:{ all -> 0x00e9 }
            r20 = r8
            int r8 = r12.hashCode()     // Catch:{ all -> 0x00e9 }
            r22 = r11
            r11 = 94660(0x171c4, float:1.32647E-40)
            r23 = r6
            r6 = 2
            if (r8 == r11) goto L_0x01c4
            r11 = 95025(0x17331, float:1.33158E-40)
            if (r8 == r11) goto L_0x01ba
            r11 = 95027(0x17333, float:1.33161E-40)
            if (r8 == r11) goto L_0x01b0
            goto L_0x01ce
        L_0x01b0:
            java.lang.String r8 = "_ui"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x01ce
            r8 = 1
            goto L_0x01cf
        L_0x01ba:
            java.lang.String r8 = "_ug"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x01ce
            r8 = r6
            goto L_0x01cf
        L_0x01c4:
            java.lang.String r8 = "_in"
            boolean r8 = r12.equals(r8)
            if (r8 == 0) goto L_0x01ce
            r8 = 0
            goto L_0x01cf
        L_0x01ce:
            r8 = -1
        L_0x01cf:
            if (r8 == 0) goto L_0x01de
            r11 = 1
            if (r8 == r11) goto L_0x01de
            if (r8 == r6) goto L_0x01de
            r24 = r5
            r25 = r13
            r8 = r14
            r2 = 0
            goto L_0x03a7
        L_0x01de:
            r6 = 0
            r8 = 0
            r11 = 0
            goto L_0x01e9
        L_0x01e2:
            r23 = r6
            r20 = r8
            r22 = r11
            goto L_0x01de
        L_0x01e9:
            int r12 = r10.zza()     // Catch:{ all -> 0x00e9 }
            r24 = r5
            java.lang.String r5 = "_r"
            if (r6 >= r12) goto L_0x024d
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r6)     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r12 = r3.equals(r12)     // Catch:{ all -> 0x00e9 }
            if (r12 == 0) goto L_0x021d
            com.google.android.gms.internal.measurement.zzfx r5 = r10.zzn(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x00e9 }
            r25 = r13
            r12 = 1
            r5.zzi(r12)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x00e9 }
            r10.zzk(r6, r5)     // Catch:{ all -> 0x00e9 }
            r8 = 1
            goto L_0x0246
        L_0x021d:
            r25 = r13
            com.google.android.gms.internal.measurement.zzfx r12 = r10.zzn(r6)     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r5 = r5.equals(r12)     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x0246
            com.google.android.gms.internal.measurement.zzfx r5 = r10.zzn(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzby()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x00e9 }
            r11 = 1
            r5.zzi(r11)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x00e9 }
            r10.zzk(r6, r5)     // Catch:{ all -> 0x00e9 }
            r11 = 1
        L_0x0246:
            int r6 = r6 + 1
            r5 = r24
            r13 = r25
            goto L_0x01e9
        L_0x024d:
            r25 = r13
            if (r8 != 0) goto L_0x027d
            if (r2 == 0) goto L_0x027d
            com.google.android.gms.measurement.internal.zzeh r6 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r13 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzd(r13)     // Catch:{ all -> 0x00e9 }
            r6.zzb(r8, r12)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfw r6 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x00e9 }
            r6.zzj(r3)     // Catch:{ all -> 0x00e9 }
            r12 = 1
            r6.zzi(r12)     // Catch:{ all -> 0x00e9 }
            r10.zze(r6)     // Catch:{ all -> 0x00e9 }
        L_0x027d:
            if (r11 != 0) goto L_0x02a9
            com.google.android.gms.measurement.internal.zzeh r6 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfr r11 = r1.zzn     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzec r11 = r11.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r11.zzd(r12)     // Catch:{ all -> 0x00e9 }
            r6.zzb(r8, r11)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfw r6 = com.google.android.gms.internal.measurement.zzfx.zze()     // Catch:{ all -> 0x00e9 }
            r6.zzj(r5)     // Catch:{ all -> 0x00e9 }
            r11 = 1
            r6.zzi(r11)     // Catch:{ all -> 0x00e9 }
            r10.zze(r6)     // Catch:{ all -> 0x00e9 }
        L_0x02a9:
            com.google.android.gms.measurement.internal.f r6 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r6)     // Catch:{ all -> 0x00e9 }
            long r27 = r40.zza()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r29 = r8.zzx()     // Catch:{ all -> 0x00e9 }
            r33 = 0
            r34 = 1
            r30 = 0
            r31 = 0
            r32 = 0
            r26 = r6
            com.google.android.gms.measurement.internal.zzak r6 = r26.F(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x00e9 }
            long r11 = r6.zze     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzag r6 = r40.zzg()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r8 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x00e9 }
            int r6 = r6.zze(r8, r13)     // Catch:{ all -> 0x00e9 }
            r8 = r14
            long r13 = (long) r6     // Catch:{ all -> 0x00e9 }
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x02e4
            zzab(r10, r5)     // Catch:{ all -> 0x00e9 }
            goto L_0x02e6
        L_0x02e4:
            r16 = 1
        L_0x02e6:
            java.lang.String r5 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            boolean r5 = com.google.android.gms.measurement.internal.zzlb.zzai(r5)     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x03a7
            if (r2 == 0) goto L_0x03a7
            com.google.android.gms.measurement.internal.f r5 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r5)     // Catch:{ all -> 0x00e9 }
            long r27 = r40.zza()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r29 = r6.zzx()     // Catch:{ all -> 0x00e9 }
            r33 = 0
            r34 = 0
            r30 = 0
            r31 = 0
            r32 = 1
            r26 = r5
            com.google.android.gms.measurement.internal.zzak r5 = r26.F(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x00e9 }
            long r5 = r5.zzc     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzag r11 = r40.zzg()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r12 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzm     // Catch:{ all -> 0x00e9 }
            int r11 = r11.zze(r12, r13)     // Catch:{ all -> 0x00e9 }
            long r11 = (long) r11     // Catch:{ all -> 0x00e9 }
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x03a7
            com.google.android.gms.measurement.internal.zzeh r5 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzgd r11 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r11)     // Catch:{ all -> 0x00e9 }
            r5.zzb(r6, r11)     // Catch:{ all -> 0x00e9 }
            r5 = 0
            r6 = 0
            r11 = 0
            r12 = -1
        L_0x0343:
            int r13 = r10.zza()     // Catch:{ all -> 0x00e9 }
            if (r6 >= r13) goto L_0x036d
            com.google.android.gms.internal.measurement.zzfx r13 = r10.zzn(r6)     // Catch:{ all -> 0x00e9 }
            java.lang.String r14 = r13.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r14 = r3.equals(r14)     // Catch:{ all -> 0x00e9 }
            if (r14 == 0) goto L_0x035f
            com.google.android.gms.internal.measurement.zzkb r5 = r13.zzby()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x00e9 }
            r12 = r6
            goto L_0x036a
        L_0x035f:
            java.lang.String r13 = r13.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r13 = r9.equals(r13)     // Catch:{ all -> 0x00e9 }
            if (r13 == 0) goto L_0x036a
            r11 = 1
        L_0x036a:
            int r6 = r6 + 1
            goto L_0x0343
        L_0x036d:
            if (r11 == 0) goto L_0x0376
            if (r5 == 0) goto L_0x0375
            r10.zzh(r12)     // Catch:{ all -> 0x00e9 }
            goto L_0x03a7
        L_0x0375:
            r5 = 0
        L_0x0376:
            if (r5 == 0) goto L_0x0390
            com.google.android.gms.internal.measurement.zzkb r5 = r5.zzau()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfw r5 = (com.google.android.gms.internal.measurement.zzfw) r5     // Catch:{ all -> 0x00e9 }
            r5.zzj(r9)     // Catch:{ all -> 0x00e9 }
            r13 = 10
            r5.zzi(r13)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r5 = r5.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x00e9 }
            r10.zzk(r12, r5)     // Catch:{ all -> 0x00e9 }
            goto L_0x03a7
        L_0x0390:
            com.google.android.gms.measurement.internal.zzeh r5 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x00e9 }
            r5.zzb(r6, r9)     // Catch:{ all -> 0x00e9 }
        L_0x03a7:
            if (r2 == 0) goto L_0x041a
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00e9 }
            java.util.List r5 = r10.zzp()     // Catch:{ all -> 0x00e9 }
            r2.<init>(r5)     // Catch:{ all -> 0x00e9 }
            r5 = 0
            r6 = -1
            r9 = -1
        L_0x03b5:
            int r11 = r2.size()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = "currency"
            java.lang.String r13 = "value"
            if (r5 >= r11) goto L_0x03e5
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r11 = r13.equals(r11)     // Catch:{ all -> 0x00e9 }
            if (r11 == 0) goto L_0x03d1
            r6 = r5
            goto L_0x03e2
        L_0x03d1:
            java.lang.Object r11 = r2.get(r5)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r11.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r11 = r12.equals(r11)     // Catch:{ all -> 0x00e9 }
            if (r11 == 0) goto L_0x03e2
            r9 = r5
        L_0x03e2:
            int r5 = r5 + 1
            goto L_0x03b5
        L_0x03e5:
            r5 = -1
            if (r6 != r5) goto L_0x03ea
            goto L_0x0460
        L_0x03ea:
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x00e9 }
            boolean r5 = r5.zzw()     // Catch:{ all -> 0x00e9 }
            if (r5 != 0) goto L_0x041c
            java.lang.Object r5 = r2.get(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r5 = (com.google.android.gms.internal.measurement.zzfx) r5     // Catch:{ all -> 0x00e9 }
            boolean r5 = r5.zzu()     // Catch:{ all -> 0x00e9 }
            if (r5 != 0) goto L_0x041c
            com.google.android.gms.measurement.internal.zzeh r2 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r2.zza(r5)     // Catch:{ all -> 0x00e9 }
            r10.zzh(r6)     // Catch:{ all -> 0x00e9 }
            zzab(r10, r3)     // Catch:{ all -> 0x00e9 }
            r2 = 18
            zzaa(r10, r2, r13)     // Catch:{ all -> 0x00e9 }
        L_0x041a:
            r5 = -1
            goto L_0x0460
        L_0x041c:
            r5 = -1
            if (r9 != r5) goto L_0x0420
            goto L_0x0448
        L_0x0420:
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r2 = (com.google.android.gms.internal.measurement.zzfx) r2     // Catch:{ all -> 0x00e9 }
            java.lang.String r2 = r2.zzh()     // Catch:{ all -> 0x00e9 }
            int r9 = r2.length()     // Catch:{ all -> 0x00e9 }
            r11 = 3
            if (r9 != r11) goto L_0x0448
            r9 = 0
        L_0x0432:
            int r11 = r2.length()     // Catch:{ all -> 0x00e9 }
            if (r9 >= r11) goto L_0x0460
            int r11 = r2.codePointAt(r9)     // Catch:{ all -> 0x00e9 }
            boolean r13 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x00e9 }
            if (r13 == 0) goto L_0x0448
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x00e9 }
            int r9 = r9 + r11
            goto L_0x0432
        L_0x0448:
            com.google.android.gms.measurement.internal.zzeh r2 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzl()     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r9)     // Catch:{ all -> 0x00e9 }
            r10.zzh(r6)     // Catch:{ all -> 0x00e9 }
            zzab(r10, r3)     // Catch:{ all -> 0x00e9 }
            r2 = 19
            zzaa(r10, r2, r12)     // Catch:{ all -> 0x00e9 }
        L_0x0460:
            java.lang.String r2 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r15.equals(r2)     // Catch:{ all -> 0x00e9 }
            r11 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04c2
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r2 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzkv.zzB(r2, r7)     // Catch:{ all -> 0x00e9 }
            if (r2 != 0) goto L_0x04bd
            if (r25 == 0) goto L_0x04b2
            long r2 = r25.zzc()     // Catch:{ all -> 0x00e9 }
            long r6 = r10.zzc()     // Catch:{ all -> 0x00e9 }
            long r2 = r2 - r6
            long r2 = java.lang.Math.abs(r2)     // Catch:{ all -> 0x00e9 }
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x04b2
            com.google.android.gms.internal.measurement.zzkb r2 = r25.zzau()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x00e9 }
            boolean r3 = r1.zzaj(r10, r2)     // Catch:{ all -> 0x00e9 }
            if (r3 == 0) goto L_0x04a6
            r3 = r24
            r3.zzS(r8, r2)     // Catch:{ all -> 0x00e9 }
            r11 = r22
            r2 = 0
            r13 = 0
            goto L_0x04ad
        L_0x04a6:
            r3 = r24
            r2 = r10
            r11 = r17
            r13 = r25
        L_0x04ad:
            r18 = r2
            r14 = r8
            goto L_0x051d
        L_0x04b2:
            r3 = r24
            r14 = r8
            r18 = r10
            r11 = r17
        L_0x04b9:
            r13 = r25
            goto L_0x051d
        L_0x04bd:
            r3 = r24
        L_0x04bf:
            r7 = r22
            goto L_0x051a
        L_0x04c2:
            r3 = r24
            java.lang.String r2 = "_vs"
            java.lang.String r6 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x04bf
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r2 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r2 = (com.google.android.gms.internal.measurement.zzft) r2     // Catch:{ all -> 0x00e9 }
            r6 = r23
            com.google.android.gms.internal.measurement.zzfx r2 = com.google.android.gms.measurement.internal.zzkv.zzB(r2, r6)     // Catch:{ all -> 0x00e9 }
            if (r2 != 0) goto L_0x04bf
            if (r18 == 0) goto L_0x0513
            long r6 = r18.zzc()     // Catch:{ all -> 0x00e9 }
            long r13 = r10.zzc()     // Catch:{ all -> 0x00e9 }
            long r6 = r6 - r13
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x00e9 }
            int r2 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r2 > 0) goto L_0x0513
            com.google.android.gms.internal.measurement.zzkb r2 = r18.zzau()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfs r2 = (com.google.android.gms.internal.measurement.zzfs) r2     // Catch:{ all -> 0x00e9 }
            boolean r6 = r1.zzaj(r2, r10)     // Catch:{ all -> 0x00e9 }
            if (r6 == 0) goto L_0x050c
            r7 = r22
            r3.zzS(r7, r2)     // Catch:{ all -> 0x00e9 }
            r14 = r8
            r13 = 0
            r18 = 0
            goto L_0x0511
        L_0x050c:
            r7 = r22
            r13 = r10
            r14 = r17
        L_0x0511:
            r11 = r7
            goto L_0x051d
        L_0x0513:
            r7 = r22
            r11 = r7
            r13 = r10
            r14 = r17
            goto L_0x051d
        L_0x051a:
            r11 = r7
            r14 = r8
            goto L_0x04b9
        L_0x051d:
            java.util.List r2 = r4.f7407c     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r6 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r6 = (com.google.android.gms.internal.measurement.zzft) r6     // Catch:{ all -> 0x00e9 }
            r7 = r20
            r2.set(r7, r6)     // Catch:{ all -> 0x00e9 }
            int r9 = r17 + 1
            r3.zzk(r10)     // Catch:{ all -> 0x00e9 }
            r15 = r16
            r10 = r18
        L_0x0533:
            int r8 = r7 + 1
            r5 = r3
            r2 = r19
            r3 = r21
            goto L_0x0040
        L_0x053c:
            r19 = r2
            r3 = r5
            r8 = 0
            r10 = r8
            r5 = r17
            r2 = 0
        L_0x0545:
            if (r2 >= r5) goto L_0x0596
            com.google.android.gms.internal.measurement.zzft r12 = r3.zze(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r13 = r12.zzh()     // Catch:{ all -> 0x00e9 }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x00e9 }
            if (r13 == 0) goto L_0x0569
            com.google.android.gms.measurement.internal.zzkv r13 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r13)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r13 = com.google.android.gms.measurement.internal.zzkv.zzB(r12, r7)     // Catch:{ all -> 0x00e9 }
            if (r13 == 0) goto L_0x0569
            r3.zzA(r2)     // Catch:{ all -> 0x00e9 }
            int r5 = r5 + -1
            int r2 = r2 + -1
        L_0x0567:
            r12 = 1
            goto L_0x0594
        L_0x0569:
            com.google.android.gms.measurement.internal.zzkv r13 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r13)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r12 = com.google.android.gms.measurement.internal.zzkv.zzB(r12, r6)     // Catch:{ all -> 0x00e9 }
            if (r12 == 0) goto L_0x0567
            boolean r13 = r12.zzw()     // Catch:{ all -> 0x00e9 }
            if (r13 == 0) goto L_0x0583
            long r12 = r12.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x00e9 }
            goto L_0x0584
        L_0x0583:
            r12 = 0
        L_0x0584:
            if (r12 == 0) goto L_0x0567
            long r13 = r12.longValue()     // Catch:{ all -> 0x00e9 }
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 <= 0) goto L_0x0567
            long r12 = r12.longValue()     // Catch:{ all -> 0x00e9 }
            long r10 = r10 + r12
            goto L_0x0567
        L_0x0594:
            int r2 = r2 + r12
            goto L_0x0545
        L_0x0596:
            r2 = 0
            r1.zzaf(r3, r10, r2)     // Catch:{ all -> 0x00e9 }
            java.util.List r2 = r3.zzas()     // Catch:{ all -> 0x00e9 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00e9 }
        L_0x05a2:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "_se"
            if (r5 == 0) goto L_0x05c8
            java.lang.String r5 = "_s"
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = r7.zzh()     // Catch:{ all -> 0x00e9 }
            boolean r5 = r5.equals(r7)     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x05a2
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = r3.zzap()     // Catch:{ all -> 0x00e9 }
            r2.a(r5, r6)     // Catch:{ all -> 0x00e9 }
        L_0x05c8:
            java.lang.String r2 = "_sid"
            int r2 = com.google.android.gms.measurement.internal.zzkv.zza(r3, r2)     // Catch:{ all -> 0x00e9 }
            if (r2 < 0) goto L_0x05d5
            r2 = 1
            r1.zzaf(r3, r10, r2)     // Catch:{ all -> 0x00e9 }
            goto L_0x05f5
        L_0x05d5:
            int r2 = com.google.android.gms.measurement.internal.zzkv.zza(r3, r6)     // Catch:{ all -> 0x00e9 }
            if (r2 < 0) goto L_0x05f5
            r3.zzB(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzgd r6 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x00e9 }
            r2.zzb(r5, r6)     // Catch:{ all -> 0x00e9 }
        L_0x05f5:
            com.google.android.gms.measurement.internal.zzkv r2 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "Checking account type status for ad personalization signals"
            r5.zza(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkt r5 = r2.zzf     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfi r5 = r5.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r5)     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = r3.zzap()     // Catch:{ all -> 0x00e9 }
            boolean r5 = r5.zzn(r6)     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x068c
            com.google.android.gms.measurement.internal.zzkt r5 = r2.zzf     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f r5 = r5.zze     // Catch:{ all -> 0x00e9 }
            zzal(r5)     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = r3.zzap()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.c1 r5 = r5.D(r6)     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x068c
            boolean r5 = r5.I()     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x068c
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzaq r5 = r5.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r5 = r5.zze()     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x068c
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzc()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "Turning off ad personalization due to account type"
            r5.zza(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgl r5 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x00e9 }
            r6 = r19
            r5.zzf(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzaq r2 = r2.zzg()     // Catch:{ all -> 0x00e9 }
            long r10 = r2.zza()     // Catch:{ all -> 0x00e9 }
            r5.zzg(r10)     // Catch:{ all -> 0x00e9 }
            r10 = 1
            r5.zze(r10)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r2 = r5.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgm r2 = (com.google.android.gms.internal.measurement.zzgm) r2     // Catch:{ all -> 0x00e9 }
            r5 = 0
        L_0x066e:
            int r7 = r3.zzb()     // Catch:{ all -> 0x00e9 }
            if (r5 >= r7) goto L_0x0689
            com.google.android.gms.internal.measurement.zzgm r7 = r3.zzao(r5)     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = r7.zzf()     // Catch:{ all -> 0x00e9 }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x00e9 }
            if (r7 == 0) goto L_0x0686
            r3.zzam(r5, r2)     // Catch:{ all -> 0x00e9 }
            goto L_0x068c
        L_0x0686:
            int r5 = r5 + 1
            goto L_0x066e
        L_0x0689:
            r3.zzm(r2)     // Catch:{ all -> 0x00e9 }
        L_0x068c:
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.zzai(r5)     // Catch:{ all -> 0x00e9 }
            r5 = -9223372036854775808
            r3.zzQ(r5)     // Catch:{ all -> 0x00e9 }
            r2 = 0
        L_0x069a:
            int r5 = r3.zza()     // Catch:{ all -> 0x00e9 }
            if (r2 >= r5) goto L_0x06cd
            com.google.android.gms.internal.measurement.zzft r5 = r3.zze(r2)     // Catch:{ all -> 0x00e9 }
            long r6 = r5.zzd()     // Catch:{ all -> 0x00e9 }
            long r10 = r3.zzd()     // Catch:{ all -> 0x00e9 }
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x06b7
            long r6 = r5.zzd()     // Catch:{ all -> 0x00e9 }
            r3.zzai(r6)     // Catch:{ all -> 0x00e9 }
        L_0x06b7:
            long r6 = r5.zzd()     // Catch:{ all -> 0x00e9 }
            long r10 = r3.zzc()     // Catch:{ all -> 0x00e9 }
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x06ca
            long r5 = r5.zzd()     // Catch:{ all -> 0x00e9 }
            r3.zzQ(r5)     // Catch:{ all -> 0x00e9 }
        L_0x06ca:
            int r2 = r2 + 1
            goto L_0x069a
        L_0x06cd:
            r3.zzz()     // Catch:{ all -> 0x00e9 }
            r3.zzo()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.b r10 = r1.zzh     // Catch:{ all -> 0x00e9 }
            zzal(r10)     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r3.zzap()     // Catch:{ all -> 0x00e9 }
            java.util.List r12 = r3.zzas()     // Catch:{ all -> 0x00e9 }
            java.util.List r13 = r3.zzat()     // Catch:{ all -> 0x00e9 }
            long r5 = r3.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.Long r14 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00e9 }
            long r5 = r3.zzc()     // Catch:{ all -> 0x00e9 }
            java.lang.Long r15 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00e9 }
            java.util.List r2 = r10.a(r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00e9 }
            r3.zzf(r2)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzag r2 = r40.zzg()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r5 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            boolean r2 = r2.zzw(r5)     // Catch:{ all -> 0x00e9 }
            if (r2 == 0) goto L_0x0a3a
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x00e9 }
            r2.<init>()     // Catch:{ all -> 0x00e9 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00e9 }
            r5.<init>()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzlb r6 = r40.zzv()     // Catch:{ all -> 0x00e9 }
            java.security.SecureRandom r6 = r6.zzG()     // Catch:{ all -> 0x00e9 }
            r7 = 0
        L_0x071e:
            int r10 = r3.zza()     // Catch:{ all -> 0x00e9 }
            if (r7 >= r10) goto L_0x0a01
            com.google.android.gms.internal.measurement.zzft r10 = r3.zze(r7)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkb r10 = r10.zzby()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfs r10 = (com.google.android.gms.internal.measurement.zzfs) r10     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = "_ep"
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = "_efs"
            java.lang.String r13 = "_sr"
            if (r11 == 0) goto L_0x07c0
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r11)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r11 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r14 = "_en"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzkv.zzC(r11, r14)     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00e9 }
            java.lang.Object r14 = r2.get(r11)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r14 = (com.google.android.gms.measurement.internal.i) r14     // Catch:{ all -> 0x00e9 }
            if (r14 != 0) goto L_0x0775
            com.google.android.gms.measurement.internal.f r14 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r14)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r15 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r17 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x00e9 }
            r8 = r17
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r14 = r14.H(r15, r8)     // Catch:{ all -> 0x00e9 }
            if (r14 == 0) goto L_0x0775
            r2.put(r11, r14)     // Catch:{ all -> 0x00e9 }
        L_0x0775:
            if (r14 == 0) goto L_0x07b4
            java.lang.Long r8 = r14.f7545i     // Catch:{ all -> 0x00e9 }
            if (r8 != 0) goto L_0x07b4
            java.lang.Long r8 = r14.f7546j     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x0793
            long r8 = r8.longValue()     // Catch:{ all -> 0x00e9 }
            r17 = 1
            int r8 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r8 <= 0) goto L_0x0793
            com.google.android.gms.measurement.internal.zzkv r8 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r8)     // Catch:{ all -> 0x00e9 }
            java.lang.Long r8 = r14.f7546j     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r13, r8)     // Catch:{ all -> 0x00e9 }
        L_0x0793:
            java.lang.Boolean r8 = r14.f7547k     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x07ab
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x07ab
            com.google.android.gms.measurement.internal.zzkv r8 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r8)     // Catch:{ all -> 0x00e9 }
            r8 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r12, r11)     // Catch:{ all -> 0x00e9 }
        L_0x07ab:
            com.google.android.gms.internal.measurement.zzkf r8 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8     // Catch:{ all -> 0x00e9 }
            r5.add(r8)     // Catch:{ all -> 0x00e9 }
        L_0x07b4:
            r3.zzS(r7, r10)     // Catch:{ all -> 0x00e9 }
        L_0x07b7:
            r22 = r4
            r21 = r6
            r6 = r3
            r3 = 1
            goto L_0x09f6
        L_0x07c0:
            com.google.android.gms.measurement.internal.zzfi r8 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r11 = r8.zza(r9, r11)     // Catch:{ all -> 0x00e9 }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00e9 }
            if (r14 != 0) goto L_0x07f1
            long r8 = java.lang.Long.parseLong(r11)     // Catch:{ NumberFormatException -> 0x07dc }
            goto L_0x07f3
        L_0x07dc:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x00e9 }
            r8.zzc(r14, r9, r11)     // Catch:{ all -> 0x00e9 }
        L_0x07f1:
            r8 = 0
        L_0x07f3:
            com.google.android.gms.measurement.internal.zzlb r11 = r40.zzv()     // Catch:{ all -> 0x00e9 }
            long r14 = r10.zzc()     // Catch:{ all -> 0x00e9 }
            long r14 = r11.zzr(r14, r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r11 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x00e9 }
            r43 = r12
            r17 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x00e9 }
            r17 = r8
            java.lang.String r8 = "_dbg"
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00e9 }
            if (r9 != 0) goto L_0x084b
            java.util.List r9 = r11.zzi()     // Catch:{ all -> 0x00e9 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x00e9 }
        L_0x081f:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x00e9 }
            if (r11 == 0) goto L_0x084b
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11     // Catch:{ all -> 0x00e9 }
            r21 = r9
            java.lang.String r9 = r11.zzg()     // Catch:{ all -> 0x00e9 }
            boolean r9 = r8.equals(r9)     // Catch:{ all -> 0x00e9 }
            if (r9 == 0) goto L_0x0848
            long r8 = r11.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x00e9 }
            boolean r8 = r12.equals(r8)     // Catch:{ all -> 0x00e9 }
            if (r8 != 0) goto L_0x0846
            goto L_0x084b
        L_0x0846:
            r11 = 1
            goto L_0x085f
        L_0x0848:
            r9 = r21
            goto L_0x081f
        L_0x084b:
            com.google.android.gms.measurement.internal.zzfi r8 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            int r8 = r8.zzc(r9, r11)     // Catch:{ all -> 0x00e9 }
            r11 = r8
        L_0x085f:
            if (r11 > 0) goto L_0x0884
            com.google.android.gms.measurement.internal.zzeh r8 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00e9 }
            r8.zzc(r9, r12, r11)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r8 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8     // Catch:{ all -> 0x00e9 }
            r5.add(r8)     // Catch:{ all -> 0x00e9 }
            r3.zzS(r7, r10)     // Catch:{ all -> 0x00e9 }
            goto L_0x07b7
        L_0x0884:
            java.lang.String r8 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r8 = r2.get(r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r8 = (com.google.android.gms.measurement.internal.i) r8     // Catch:{ all -> 0x00e9 }
            if (r8 != 0) goto L_0x08e4
            com.google.android.gms.measurement.internal.f r8 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r8)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r8 = r8.H(r9, r12)     // Catch:{ all -> 0x00e9 }
            if (r8 != 0) goto L_0x08e4
            com.google.android.gms.measurement.internal.zzeh r8 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzgd r12 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x00e9 }
            r21 = r14
            java.lang.String r14 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            r8.zzc(r9, r12, r14)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r8 = new com.google.android.gms.measurement.internal.i     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r9 = r4.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r24 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.String r25 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            long r32 = r10.zzc()     // Catch:{ all -> 0x00e9 }
            r38 = 0
            r39 = 0
            r26 = 1
            r28 = 1
            r30 = 1
            r34 = 0
            r36 = 0
            r37 = 0
            r23 = r8
            r23.<init>(r24, r25, r26, r28, r30, r32, r34, r36, r37, r38, r39)     // Catch:{ all -> 0x00e9 }
            goto L_0x08e6
        L_0x08e4:
            r21 = r14
        L_0x08e6:
            com.google.android.gms.measurement.internal.zzkv r9 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r9 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r9 = (com.google.android.gms.internal.measurement.zzft) r9     // Catch:{ all -> 0x00e9 }
            java.lang.String r12 = "_eid"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzkv.zzC(r9, r12)     // Catch:{ all -> 0x00e9 }
            java.lang.Long r9 = (java.lang.Long) r9     // Catch:{ all -> 0x00e9 }
            if (r9 == 0) goto L_0x08fe
            r12 = 1
        L_0x08fc:
            r14 = 1
            goto L_0x0900
        L_0x08fe:
            r12 = 0
            goto L_0x08fc
        L_0x0900:
            if (r11 != r14) goto L_0x092a
            com.google.android.gms.internal.measurement.zzkf r9 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r9 = (com.google.android.gms.internal.measurement.zzft) r9     // Catch:{ all -> 0x00e9 }
            r5.add(r9)     // Catch:{ all -> 0x00e9 }
            if (r12 == 0) goto L_0x0925
            java.lang.Long r9 = r8.f7545i     // Catch:{ all -> 0x00e9 }
            if (r9 != 0) goto L_0x0919
            java.lang.Long r9 = r8.f7546j     // Catch:{ all -> 0x00e9 }
            if (r9 != 0) goto L_0x0919
            java.lang.Boolean r9 = r8.f7547k     // Catch:{ all -> 0x00e9 }
            if (r9 == 0) goto L_0x0925
        L_0x0919:
            r9 = 0
            com.google.android.gms.measurement.internal.i r8 = r8.a(r9, r9, r9)     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            r2.put(r9, r8)     // Catch:{ all -> 0x00e9 }
        L_0x0925:
            r3.zzS(r7, r10)     // Catch:{ all -> 0x00e9 }
            goto L_0x07b7
        L_0x092a:
            int r14 = r6.nextInt(r11)     // Catch:{ all -> 0x00e9 }
            if (r14 != 0) goto L_0x0967
            com.google.android.gms.measurement.internal.zzkv r9 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r9)     // Catch:{ all -> 0x00e9 }
            long r14 = (long) r11     // Catch:{ all -> 0x00e9 }
            java.lang.Long r9 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r13, r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r11 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r11 = (com.google.android.gms.internal.measurement.zzft) r11     // Catch:{ all -> 0x00e9 }
            r5.add(r11)     // Catch:{ all -> 0x00e9 }
            if (r12 == 0) goto L_0x094d
            r11 = 0
            com.google.android.gms.measurement.internal.i r8 = r8.a(r11, r9, r11)     // Catch:{ all -> 0x00e9 }
        L_0x094d:
            java.lang.String r9 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            long r11 = r10.zzc()     // Catch:{ all -> 0x00e9 }
            r14 = r21
            com.google.android.gms.measurement.internal.i r8 = r8.b(r11, r14)     // Catch:{ all -> 0x00e9 }
            r2.put(r9, r8)     // Catch:{ all -> 0x00e9 }
            r22 = r4
            r21 = r6
            r6 = r3
            r3 = 1
            goto L_0x09f3
        L_0x0967:
            r14 = r21
            r21 = r6
            java.lang.Long r6 = r8.f7544h     // Catch:{ all -> 0x00e9 }
            if (r6 == 0) goto L_0x097c
            long r17 = r6.longValue()     // Catch:{ all -> 0x00e9 }
            r24 = r3
            r22 = r4
            r23 = r7
            r25 = r8
            goto L_0x0992
        L_0x097c:
            com.google.android.gms.measurement.internal.zzlb r6 = r40.zzv()     // Catch:{ all -> 0x00e9 }
            r24 = r3
            r22 = r4
            long r3 = r10.zzb()     // Catch:{ all -> 0x00e9 }
            r23 = r7
            r25 = r8
            r7 = r17
            long r17 = r6.zzr(r3, r7)     // Catch:{ all -> 0x00e9 }
        L_0x0992:
            int r3 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x09e0
            com.google.android.gms.measurement.internal.zzkv r3 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r3)     // Catch:{ all -> 0x00e9 }
            r3 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x00e9 }
            r7 = r43
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r7, r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkv r6 = r1.zzi     // Catch:{ all -> 0x00e9 }
            zzal(r6)     // Catch:{ all -> 0x00e9 }
            long r6 = (long) r11     // Catch:{ all -> 0x00e9 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkv.zzz(r10, r13, r6)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r7 = r10.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzft r7 = (com.google.android.gms.internal.measurement.zzft) r7     // Catch:{ all -> 0x00e9 }
            r5.add(r7)     // Catch:{ all -> 0x00e9 }
            if (r12 == 0) goto L_0x09c9
            java.lang.Boolean r7 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00e9 }
            r11 = r25
            r8 = 0
            com.google.android.gms.measurement.internal.i r6 = r11.a(r8, r6, r7)     // Catch:{ all -> 0x00e9 }
            r8 = r6
            goto L_0x09cc
        L_0x09c9:
            r11 = r25
            r8 = r11
        L_0x09cc:
            java.lang.String r6 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            long r11 = r10.zzc()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r7 = r8.b(r11, r14)     // Catch:{ all -> 0x00e9 }
            r2.put(r6, r7)     // Catch:{ all -> 0x00e9 }
        L_0x09db:
            r7 = r23
            r6 = r24
            goto L_0x09f3
        L_0x09e0:
            r11 = r25
            r3 = 1
            if (r12 == 0) goto L_0x09db
            java.lang.String r6 = r10.zzo()     // Catch:{ all -> 0x00e9 }
            r7 = 0
            com.google.android.gms.measurement.internal.i r8 = r11.a(r9, r7, r7)     // Catch:{ all -> 0x00e9 }
            r2.put(r6, r8)     // Catch:{ all -> 0x00e9 }
            goto L_0x09db
        L_0x09f3:
            r6.zzS(r7, r10)     // Catch:{ all -> 0x00e9 }
        L_0x09f6:
            int r7 = r7 + 1
            r3 = r6
            r6 = r21
            r4 = r22
            r8 = 0
            goto L_0x071e
        L_0x0a01:
            r6 = r3
            r22 = r4
            int r3 = r5.size()     // Catch:{ all -> 0x00e9 }
            int r4 = r6.zza()     // Catch:{ all -> 0x00e9 }
            if (r3 >= r4) goto L_0x0a14
            r6.zzr()     // Catch:{ all -> 0x00e9 }
            r6.zzg(r5)     // Catch:{ all -> 0x00e9 }
        L_0x0a14:
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x00e9 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00e9 }
        L_0x0a1c:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00e9 }
            if (r3 == 0) goto L_0x0a37
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00e9 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f r4 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r4)     // Catch:{ all -> 0x00e9 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.i r3 = (com.google.android.gms.measurement.internal.i) r3     // Catch:{ all -> 0x00e9 }
            r4.d(r3)     // Catch:{ all -> 0x00e9 }
            goto L_0x0a1c
        L_0x0a37:
            r2 = r22
            goto L_0x0a3c
        L_0x0a3a:
            r6 = r3
            r2 = r4
        L_0x0a3c:
            com.google.android.gms.internal.measurement.zzgd r3 = r2.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f r4 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r4)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.c1 r4 = r4.D(r3)     // Catch:{ all -> 0x00e9 }
            if (r4 != 0) goto L_0x0a65
            com.google.android.gms.measurement.internal.zzeh r4 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzgd r7 = r2.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = r7.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x00e9 }
            r4.zzb(r5, r7)     // Catch:{ all -> 0x00e9 }
            goto L_0x0ac1
        L_0x0a65:
            int r5 = r6.zza()     // Catch:{ all -> 0x00e9 }
            if (r5 <= 0) goto L_0x0ac1
            long r7 = r4.X()     // Catch:{ all -> 0x00e9 }
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x0a79
            r6.zzab(r7)     // Catch:{ all -> 0x00e9 }
            goto L_0x0a7c
        L_0x0a79:
            r6.zzv()     // Catch:{ all -> 0x00e9 }
        L_0x0a7c:
            long r9 = r4.Z()     // Catch:{ all -> 0x00e9 }
            r11 = 0
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x0a87
            goto L_0x0a88
        L_0x0a87:
            r7 = r9
        L_0x0a88:
            int r5 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0a90
            r6.zzac(r7)     // Catch:{ all -> 0x00e9 }
            goto L_0x0a93
        L_0x0a90:
            r6.zzw()     // Catch:{ all -> 0x00e9 }
        L_0x0a93:
            r4.e()     // Catch:{ all -> 0x00e9 }
            long r7 = r4.Y()     // Catch:{ all -> 0x00e9 }
            int r5 = (int) r7     // Catch:{ all -> 0x00e9 }
            r6.zzI(r5)     // Catch:{ all -> 0x00e9 }
            long r7 = r6.zzd()     // Catch:{ all -> 0x00e9 }
            r4.C(r7)     // Catch:{ all -> 0x00e9 }
            long r7 = r6.zzc()     // Catch:{ all -> 0x00e9 }
            r4.z(r7)     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = r4.c0()     // Catch:{ all -> 0x00e9 }
            if (r5 == 0) goto L_0x0ab6
            r6.zzW(r5)     // Catch:{ all -> 0x00e9 }
            goto L_0x0ab9
        L_0x0ab6:
            r6.zzs()     // Catch:{ all -> 0x00e9 }
        L_0x0ab9:
            com.google.android.gms.measurement.internal.f r5 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r5)     // Catch:{ all -> 0x00e9 }
            r5.c(r4)     // Catch:{ all -> 0x00e9 }
        L_0x0ac1:
            int r4 = r6.zza()     // Catch:{ all -> 0x00e9 }
            if (r4 <= 0) goto L_0x0c45
            com.google.android.gms.measurement.internal.zzfr r4 = r1.zzn     // Catch:{ all -> 0x00e9 }
            r4.zzaw()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfi r4 = r1.zzc     // Catch:{ all -> 0x00e9 }
            zzal(r4)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r5 = r2.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzff r4 = r4.zze(r5)     // Catch:{ all -> 0x00e9 }
            r7 = -1
            if (r4 == 0) goto L_0x0aee
            boolean r5 = r4.zzs()     // Catch:{ all -> 0x00e9 }
            if (r5 != 0) goto L_0x0ae6
            goto L_0x0aee
        L_0x0ae6:
            long r4 = r4.zzc()     // Catch:{ all -> 0x00e9 }
            r6.zzK(r4)     // Catch:{ all -> 0x00e9 }
            goto L_0x0b15
        L_0x0aee:
            com.google.android.gms.internal.measurement.zzgd r4 = r2.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r4 = r4.zzF()     // Catch:{ all -> 0x00e9 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x00e9 }
            if (r4 == 0) goto L_0x0afe
            r6.zzK(r7)     // Catch:{ all -> 0x00e9 }
            goto L_0x0b15
        L_0x0afe:
            com.google.android.gms.measurement.internal.zzeh r4 = r40.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzgd r9 = r2.f7405a     // Catch:{ all -> 0x00e9 }
            java.lang.String r9 = r9.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x00e9 }
            r4.zzb(r5, r9)     // Catch:{ all -> 0x00e9 }
        L_0x0b15:
            com.google.android.gms.measurement.internal.f r4 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r4)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzkf r5 = r6.zzaC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.measurement.zzgd r5 = (com.google.android.gms.internal.measurement.zzgd) r5     // Catch:{ all -> 0x00e9 }
            r4.zzg()     // Catch:{ all -> 0x00e9 }
            r4.zzW()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x00e9 }
            boolean r6 = r5.zzbe()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.common.internal.Preconditions.checkState(r6)     // Catch:{ all -> 0x00e9 }
            r4.zzz()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.common.util.Clock r6 = r6.zzav()     // Catch:{ all -> 0x00e9 }
            long r9 = r6.currentTimeMillis()     // Catch:{ all -> 0x00e9 }
            long r11 = r5.zzk()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x00e9 }
            r6.zzf()     // Catch:{ all -> 0x00e9 }
            long r13 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x00e9 }
            long r13 = r9 - r13
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x0b69
            long r11 = r5.zzk()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x00e9 }
            r6.zzf()     // Catch:{ all -> 0x00e9 }
            long r13 = com.google.android.gms.measurement.internal.zzag.zzA()     // Catch:{ all -> 0x00e9 }
            long r13 = r13 + r9
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x0b8c
        L_0x0b69:
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            java.lang.String r12 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r12)     // Catch:{ all -> 0x00e9 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x00e9 }
            long r13 = r5.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.Long r10 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x00e9 }
            r6.zzd(r11, r12, r9, r10)     // Catch:{ all -> 0x00e9 }
        L_0x0b8c:
            byte[] r6 = r5.zzbu()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzkt r9 = r4.zzf     // Catch:{ IOException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzkv r9 = r9.zzi     // Catch:{ IOException -> 0x0c2c }
            zzal(r9)     // Catch:{ IOException -> 0x0c2c }
            byte[] r6 = r9.zzy(r6)     // Catch:{ IOException -> 0x0c2c }
            com.google.android.gms.measurement.internal.zzfr r9 = r4.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x00e9 }
            java.lang.String r10 = "Saving bundle, size"
            int r11 = r6.length     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x00e9 }
            r9.zzb(r10, r11)     // Catch:{ all -> 0x00e9 }
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x00e9 }
            r9.<init>()     // Catch:{ all -> 0x00e9 }
            java.lang.String r10 = "app_id"
            java.lang.String r11 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            r9.put(r10, r11)     // Catch:{ all -> 0x00e9 }
            java.lang.String r10 = "bundle_end_timestamp"
            long r11 = r5.zzk()     // Catch:{ all -> 0x00e9 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x00e9 }
            r9.put(r10, r11)     // Catch:{ all -> 0x00e9 }
            java.lang.String r10 = "data"
            r9.put(r10, r6)     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "has_realtime"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r16)     // Catch:{ all -> 0x00e9 }
            r9.put(r6, r10)     // Catch:{ all -> 0x00e9 }
            boolean r6 = r5.zzbk()     // Catch:{ all -> 0x00e9 }
            if (r6 == 0) goto L_0x0beb
            java.lang.String r6 = "retry_count"
            int r10 = r5.zze()     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x00e9 }
            r9.put(r6, r10)     // Catch:{ all -> 0x00e9 }
        L_0x0beb:
            android.database.sqlite.SQLiteDatabase r6 = r4.zzh()     // Catch:{ SQLiteException -> 0x0c12 }
            java.lang.String r10 = "queue"
            r11 = 0
            long r9 = r6.insert(r10, r11, r9)     // Catch:{ SQLiteException -> 0x0c12 }
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0c45
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzt     // Catch:{ SQLiteException -> 0x0c12 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ SQLiteException -> 0x0c12 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ SQLiteException -> 0x0c12 }
            java.lang.String r7 = "Failed to insert bundle (got -1). appId"
            java.lang.String r8 = r5.zzx()     // Catch:{ SQLiteException -> 0x0c12 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)     // Catch:{ SQLiteException -> 0x0c12 }
            r6.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0c12 }
            goto L_0x0c45
        L_0x0c12:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = "Error storing bundle. appId"
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x00e9 }
            r4.zzc(r7, r5, r6)     // Catch:{ all -> 0x00e9 }
            goto L_0x0c45
        L_0x0c2c:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = "Data loss. Failed to serialize bundle. appId"
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x00e9 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x00e9 }
            r4.zzc(r7, r5, r6)     // Catch:{ all -> 0x00e9 }
        L_0x0c45:
            com.google.android.gms.measurement.internal.f r4 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r4)     // Catch:{ all -> 0x00e9 }
            java.util.List r2 = r2.f7406b     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x00e9 }
            r4.zzg()     // Catch:{ all -> 0x00e9 }
            r4.zzW()     // Catch:{ all -> 0x00e9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x00e9 }
            r6 = 0
        L_0x0c5d:
            int r7 = r2.size()     // Catch:{ all -> 0x00e9 }
            if (r6 >= r7) goto L_0x0c7a
            if (r6 == 0) goto L_0x0c6a
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x00e9 }
        L_0x0c6a:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x00e9 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x00e9 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x00e9 }
            r5.append(r7)     // Catch:{ all -> 0x00e9 }
            int r6 = r6 + 1
            goto L_0x0c5d
        L_0x0c7a:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x00e9 }
            android.database.sqlite.SQLiteDatabase r6 = r4.zzh()     // Catch:{ all -> 0x00e9 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e9 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x00e9 }
            int r6 = r2.size()     // Catch:{ all -> 0x00e9 }
            if (r5 == r6) goto L_0x0caf
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00e9 }
            int r2 = r2.size()     // Catch:{ all -> 0x00e9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x00e9 }
            r4.zzc(r6, r5, r2)     // Catch:{ all -> 0x00e9 }
        L_0x0caf:
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ all -> 0x00e9 }
            java.lang.String[] r5 = new java.lang.String[]{r3, r3}     // Catch:{ SQLiteException -> 0x0cc2 }
            java.lang.String r6 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r4.execSQL(r6, r5)     // Catch:{ SQLiteException -> 0x0cc2 }
            goto L_0x0cd7
        L_0x0cc2:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x00e9 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x00e9 }
            r2.zzc(r5, r3, r4)     // Catch:{ all -> 0x00e9 }
        L_0x0cd7:
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            r2.zzC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            r2 = 1
            return r2
        L_0x0ce9:
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x00e9 }
            zzal(r2)     // Catch:{ all -> 0x00e9 }
            r2.zzC()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            r2 = 0
            return r2
        L_0x0cfb:
            com.google.android.gms.measurement.internal.f r3 = r1.zze
            zzal(r3)
            r3.P()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzah(java.lang.String, long):boolean");
    }

    private final boolean zzai() {
        zzaz().zzg();
        zzB();
        f fVar = this.zze;
        zzal(fVar);
        if (fVar.e()) {
            return true;
        }
        f fVar2 = this.zze;
        zzal(fVar2);
        if (!TextUtils.isEmpty(fVar2.zzr())) {
            return true;
        }
        return false;
    }

    private final boolean zzaj(zzfs zzfs, zzfs zzfs2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB2 = zzkv.zzB((zzft) zzfs.zzaC(), "_sc");
        String str2 = null;
        if (zzB2 == null) {
            str = null;
        } else {
            str = zzB2.zzh();
        }
        zzal(this.zzi);
        zzfx zzB3 = zzkv.zzB((zzft) zzfs2.zzaC(), "_pc");
        if (zzB3 != null) {
            str2 = zzB3.zzh();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzfs.zzo()));
        zzal(this.zzi);
        zzfx zzB4 = zzkv.zzB((zzft) zzfs.zzaC(), "_et");
        if (zzB4 == null || !zzB4.zzw() || zzB4.zzd() <= 0) {
            return true;
        }
        long zzd2 = zzB4.zzd();
        zzal(this.zzi);
        zzfx zzB5 = zzkv.zzB((zzft) zzfs2.zzaC(), "_et");
        if (zzB5 != null && zzB5.zzd() > 0) {
            zzd2 += zzB5.zzd();
        }
        zzal(this.zzi);
        zzkv.zzz(zzfs2, "_et", Long.valueOf(zzd2));
        zzal(this.zzi);
        zzkv.zzz(zzfs, "_fr", 1L);
        return true;
    }

    private static final boolean zzak(zzq zzq2) {
        if (!TextUtils.isEmpty(zzq2.zzb) || !TextUtils.isEmpty(zzq2.zzq)) {
            return true;
        }
        return false;
    }

    private static final u3 zzal(u3 u3Var) {
        if (u3Var == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (u3Var.zzY()) {
            return u3Var;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(u3Var.getClass())));
        }
    }

    public static zzkt zzt(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzkt.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzkt((zzku) Preconditions.checkNotNull(new zzku(context)), (zzfr) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzb;
    }

    static /* bridge */ /* synthetic */ void zzy(zzkt zzkt, zzku zzku) {
        zzkt.zzaz().zzg();
        zzkt.zzm = new zzez(zzkt);
        f fVar = new f(zzkt);
        fVar.zzX();
        zzkt.zze = fVar;
        zzkt.zzg().zzq((c) Preconditions.checkNotNull(zzkt.zzc));
        zzjo zzjo = new zzjo(zzkt);
        zzjo.zzX();
        zzkt.zzk = zzjo;
        b bVar = new b(zzkt);
        bVar.zzX();
        zzkt.zzh = bVar;
        b2 b2Var = new b2(zzkt);
        b2Var.zzX();
        zzkt.zzj = b2Var;
        zzkf zzkf = new zzkf(zzkt);
        zzkf.zzX();
        zzkt.zzg = zzkf;
        zzkt.zzf = new w(zzkt);
        if (zzkt.zzr != zzkt.zzs) {
            zzkt.zzay().zzd().zzc("Not all upload components initialized", Integer.valueOf(zzkt.zzr), Integer.valueOf(zzkt.zzs));
        }
        zzkt.zzo = true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzA() {
        zzaz().zzg();
        zzB();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzx;
                zzaz().zzg();
                int i10 = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzay().zzd().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i10 = allocate.getInt();
                        } else if (read != -1) {
                            zzay().zzk().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e10) {
                        zzay().zzd().zzb("Failed to read from channel", e10);
                    }
                }
                int zzi2 = this.zzn.zzh().zzi();
                zzaz().zzg();
                if (i10 > zzi2) {
                    zzay().zzd().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi2));
                } else if (i10 < zzi2) {
                    FileChannel fileChannel2 = this.zzx;
                    zzaz().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzay().zzd().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzi2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzay().zzd().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzay().zzj().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi2));
                            return;
                        } catch (IOException e11) {
                            zzay().zzd().zzb("Failed to write to channel", e11);
                        }
                    }
                    zzay().zzd().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i10), Integer.valueOf(zzi2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzB() {
        if (!this.zzo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzC(String str, zzgc zzgc) {
        int zza2;
        int indexOf;
        zzfi zzfi = this.zzc;
        zzal(zzfi);
        Set zzk2 = zzfi.zzk(str);
        if (zzk2 != null) {
            zzgc.zzi(zzk2);
        }
        zzfi zzfi2 = this.zzc;
        zzal(zzfi2);
        if (zzfi2.zzv(str)) {
            zzgc.zzp();
        }
        zzfi zzfi3 = this.zzc;
        zzal(zzfi3);
        if (zzfi3.zzy(str)) {
            if (zzg().zzs(str, zzdu.zzaq)) {
                String zzar = zzgc.zzar();
                if (!TextUtils.isEmpty(zzar) && (indexOf = zzar.indexOf(f.G)) != -1) {
                    zzgc.zzY(zzar.substring(0, indexOf));
                }
            } else {
                zzgc.zzu();
            }
        }
        zzfi zzfi4 = this.zzc;
        zzal(zzfi4);
        if (zzfi4.zzz(str) && (zza2 = zzkv.zza(zzgc, "_id")) != -1) {
            zzgc.zzB(zza2);
        }
        zzfi zzfi5 = this.zzc;
        zzal(zzfi5);
        if (zzfi5.zzx(str)) {
            zzgc.zzq();
        }
        zzfi zzfi6 = this.zzc;
        zzal(zzfi6);
        if (zzfi6.zzu(str)) {
            zzgc.zzn();
            c4 c4Var = (c4) this.zzC.get(str);
            if (c4Var == null || c4Var.f7446b + zzg().zzi(str, zzdu.zzR) < zzav().elapsedRealtime()) {
                c4Var = new c4(this);
                this.zzC.put(str, c4Var);
            }
            zzgc.zzR(c4Var.f7445a);
        }
        zzfi zzfi7 = this.zzc;
        zzal(zzfi7);
        if (zzfi7.zzw(str)) {
            zzgc.zzy();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzD(c1 c1Var) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2;
        zzaz().zzg();
        if (!TextUtils.isEmpty(c1Var.i0()) || !TextUtils.isEmpty(c1Var.b0())) {
            zzki zzki = this.zzl;
            Uri.Builder builder = new Uri.Builder();
            String i02 = c1Var.i0();
            if (TextUtils.isEmpty(i02)) {
                i02 = c1Var.b0();
            }
            ArrayMap arrayMap3 = null;
            Uri.Builder appendQueryParameter = builder.scheme((String) zzdu.zzd.zza((Object) null)).encodedAuthority((String) zzdu.zze.zza((Object) null)).path("config/app/".concat(String.valueOf(i02))).appendQueryParameter("platform", f.f17924q);
            zzki.zzt.zzf().zzh();
            appendQueryParameter.appendQueryParameter("gmp_version", String.valueOf(74029)).appendQueryParameter("runtime_version", "0");
            String uri = builder.build().toString();
            try {
                String str = (String) Preconditions.checkNotNull(c1Var.d0());
                URL url = new URL(uri);
                zzay().zzj().zzb("Fetching remote configuration", str);
                zzfi zzfi = this.zzc;
                zzal(zzfi);
                zzff zze2 = zzfi.zze(str);
                zzfi zzfi2 = this.zzc;
                zzal(zzfi2);
                String zzh2 = zzfi2.zzh(str);
                if (zze2 != null) {
                    if (!TextUtils.isEmpty(zzh2)) {
                        arrayMap2 = new ArrayMap();
                        arrayMap2.put("If-Modified-Since", zzh2);
                    } else {
                        arrayMap2 = null;
                    }
                    zzox.zzc();
                    if (zzg().zzs((String) null, zzdu.zzao)) {
                        zzfi zzfi3 = this.zzc;
                        zzal(zzfi3);
                        String zzf2 = zzfi3.zzf(str);
                        if (!TextUtils.isEmpty(zzf2)) {
                            if (arrayMap2 == null) {
                                arrayMap2 = new ArrayMap();
                            }
                            arrayMap3 = arrayMap2;
                            arrayMap3.put("If-None-Match", zzf2);
                        }
                    }
                    arrayMap = arrayMap2;
                    this.zzt = true;
                    zzen zzen = this.zzd;
                    zzal(zzen);
                    x3 x3Var = new x3(this);
                    zzen.zzg();
                    zzen.zzW();
                    Preconditions.checkNotNull(url);
                    Preconditions.checkNotNull(x3Var);
                    zzen.zzt.zzaz().zzo(new u(zzen, str, url, (byte[]) null, arrayMap, x3Var));
                }
                arrayMap = arrayMap3;
                this.zzt = true;
                zzen zzen2 = this.zzd;
                zzal(zzen2);
                x3 x3Var2 = new x3(this);
                zzen2.zzg();
                zzen2.zzW();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(x3Var2);
                zzen2.zzt.zzaz().zzo(new u(zzen2, str, url, (byte[]) null, arrayMap, x3Var2));
            } catch (MalformedURLException unused) {
                zzay().zzd().zzc("Failed to parse config URL. Not fetching. appId", zzeh.zzn(c1Var.d0()), uri);
            }
        } else {
            zzI((String) Preconditions.checkNotNull(c1Var.d0()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzE(zzaw zzaw, zzq zzq2) {
        zzaw zzaw2;
        List<zzac> list;
        List<zzac> list2;
        List<zzac> list3;
        String str;
        zzq zzq3 = zzq2;
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq3.zza);
        zzaz().zzg();
        zzB();
        String str2 = zzq3.zza;
        long j10 = zzaw.zzd;
        zzei zzb2 = zzei.zzb(zzaw);
        zzaz().zzg();
        zzie zzie = null;
        if (!(this.zzD == null || (str = this.zzE) == null || !str.equals(str2))) {
            zzie = this.zzD;
        }
        zzlb.zzK(zzie, zzb2.zzd, false);
        zzaw zza2 = zzb2.zza();
        zzal(this.zzi);
        if (zzkv.zzA(zza2, zzq3)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            List list4 = zzq3.zzt;
            if (list4 == null) {
                zzaw2 = zza2;
            } else if (list4.contains(zza2.zza)) {
                Bundle zzc2 = zza2.zzb.zzc();
                zzc2.putLong("ga_safelisted", 1);
                zzaw2 = new zzaw(zza2.zza, new zzau(zzc2), zza2.zzc, zza2.zzd);
            } else {
                zzay().zzc().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zza2.zza, zza2.zzc);
                return;
            }
            f fVar = this.zze;
            zzal(fVar);
            fVar.zzw();
            try {
                f fVar2 = this.zze;
                zzal(fVar2);
                Preconditions.checkNotEmpty(str2);
                fVar2.zzg();
                fVar2.zzW();
                int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
                if (i10 < 0) {
                    fVar2.zzt.zzay().zzk().zzc("Invalid time querying timed out conditional properties", zzeh.zzn(str2), Long.valueOf(j10));
                    list = Collections.emptyList();
                } else {
                    list = fVar2.M("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j10)});
                }
                for (zzac zzac : list) {
                    if (zzac != null) {
                        zzay().zzj().zzd("User property timed out", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb), zzac.zzc.zza());
                        zzaw zzaw3 = zzac.zzg;
                        if (zzaw3 != null) {
                            zzY(new zzaw(zzaw3, j10), zzq3);
                        }
                        f fVar3 = this.zze;
                        zzal(fVar3);
                        fVar3.w(str2, zzac.zzc.zzb);
                    }
                }
                f fVar4 = this.zze;
                zzal(fVar4);
                Preconditions.checkNotEmpty(str2);
                fVar4.zzg();
                fVar4.zzW();
                if (i10 < 0) {
                    fVar4.zzt.zzay().zzk().zzc("Invalid time querying expired conditional properties", zzeh.zzn(str2), Long.valueOf(j10));
                    list2 = Collections.emptyList();
                } else {
                    list2 = fVar4.M("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j10)});
                }
                ArrayList<zzaw> arrayList = new ArrayList<>(list2.size());
                for (zzac zzac2 : list2) {
                    if (zzac2 != null) {
                        zzay().zzj().zzd("User property expired", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                        f fVar5 = this.zze;
                        zzal(fVar5);
                        fVar5.a(str2, zzac2.zzc.zzb);
                        zzaw zzaw4 = zzac2.zzk;
                        if (zzaw4 != null) {
                            arrayList.add(zzaw4);
                        }
                        f fVar6 = this.zze;
                        zzal(fVar6);
                        fVar6.w(str2, zzac2.zzc.zzb);
                    }
                }
                for (zzaw zzaw5 : arrayList) {
                    zzY(new zzaw(zzaw5, j10), zzq3);
                }
                f fVar7 = this.zze;
                zzal(fVar7);
                String str3 = zzaw2.zza;
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str3);
                fVar7.zzg();
                fVar7.zzW();
                if (i10 < 0) {
                    fVar7.zzt.zzay().zzk().zzd("Invalid time querying triggered conditional properties", zzeh.zzn(str2), fVar7.zzt.zzj().zzd(str3), Long.valueOf(j10));
                    list3 = Collections.emptyList();
                } else {
                    list3 = fVar7.M("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j10)});
                }
                ArrayList<zzaw> arrayList2 = new ArrayList<>(list3.size());
                for (zzac zzac3 : list3) {
                    if (zzac3 != null) {
                        zzkw zzkw = zzac3.zzc;
                        d4 d4Var = new d4((String) Preconditions.checkNotNull(zzac3.zza), zzac3.zzb, zzkw.zzb, j10, Preconditions.checkNotNull(zzkw.zza()));
                        f fVar8 = this.zze;
                        zzal(fVar8);
                        if (fVar8.k(d4Var)) {
                            zzay().zzj().zzd("User property triggered", zzac3.zza, this.zzn.zzj().zzf(d4Var.f7463c), d4Var.f7465e);
                        } else {
                            zzay().zzd().zzd("Too many active user properties, ignoring", zzeh.zzn(zzac3.zza), this.zzn.zzj().zzf(d4Var.f7463c), d4Var.f7465e);
                        }
                        zzaw zzaw6 = zzac3.zzi;
                        if (zzaw6 != null) {
                            arrayList2.add(zzaw6);
                        }
                        zzac3.zzc = new zzkw(d4Var);
                        zzac3.zze = true;
                        f fVar9 = this.zze;
                        zzal(fVar9);
                        fVar9.j(zzac3);
                    }
                }
                zzY(zzaw2, zzq3);
                for (zzaw zzaw7 : arrayList2) {
                    zzY(new zzaw(zzaw7, j10), zzq3);
                }
                f fVar10 = this.zze;
                zzal(fVar10);
                fVar10.zzC();
                f fVar11 = this.zze;
                zzal(fVar11);
                fVar11.P();
            } catch (Throwable th) {
                f fVar12 = this.zze;
                zzal(fVar12);
                fVar12.P();
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzF(zzaw zzaw, String str) {
        zzaw zzaw2 = zzaw;
        String str2 = str;
        f fVar = this.zze;
        zzal(fVar);
        c1 D = fVar.D(str2);
        if (D == null || TextUtils.isEmpty(D.g0())) {
            zzay().zzc().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzad = zzad(D);
        if (zzad == null) {
            if (!"_ui".equals(zzaw2.zza)) {
                zzay().zzk().zzb("Could not find package. appId", zzeh.zzn(str));
            }
        } else if (!zzad.booleanValue()) {
            zzay().zzd().zzb("App version does not match; dropping event. appId", zzeh.zzn(str));
            return;
        }
        String i02 = D.i0();
        String g02 = D.g0();
        long L = D.L();
        String f02 = D.f0();
        long W = D.W();
        long T = D.T();
        boolean J = D.J();
        String h02 = D.h0();
        D.A();
        zzq zzq2 = r2;
        zzq zzq3 = new zzq(str, i02, g02, L, f02, W, T, (String) null, J, false, h02, 0, 0, 0, D.I(), false, D.b0(), D.a0(), D.U(), D.c(), (String) null, zzh(str2).zzh(), "", (String) null);
        zzG(zzaw2, zzq2);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzG(zzaw zzaw, zzq zzq2) {
        Preconditions.checkNotEmpty(zzq2.zza);
        zzei zzb2 = zzei.zzb(zzaw);
        zzlb zzv2 = zzv();
        Bundle bundle = zzb2.zzd;
        f fVar = this.zze;
        zzal(fVar);
        zzv2.zzL(bundle, fVar.C(zzq2.zza));
        zzv().zzM(zzb2, zzg().zzd(zzq2.zza));
        zzaw zza2 = zzb2.zza();
        if (Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zza2.zza) && "referrer API v2".equals(zza2.zzb.zzg("_cis"))) {
            String zzg2 = zza2.zzb.zzg("gclid");
            if (!TextUtils.isEmpty(zzg2)) {
                zzW(new zzkw("_lgclid", zza2.zzd, zzg2, "auto"), zzq2);
            }
        }
        zzE(zza2, zzq2);
    }

    /* access modifiers changed from: package-private */
    public final void zzH() {
        this.zzs++;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010c A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0123 A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0140 A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014e A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0170 A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0174 A[Catch:{ all -> 0x0061, all -> 0x0013 }] */
    @androidx.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzI(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.zzfo r0 = r8.zzaz()
            r0.zzg()
            r8.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0016
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r9 = move-exception
            goto L_0x0196
        L_0x0016:
            com.google.android.gms.measurement.internal.zzeh r1 = r8.zzay()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()     // Catch:{ all -> 0x0013 }
            int r2 = r12.length     // Catch:{ all -> 0x0013 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0013 }
            java.lang.String r3 = "onConfigFetched. Response size"
            r1.zzb(r3, r2)     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.f r1 = r8.zze     // Catch:{ all -> 0x0013 }
            zzal(r1)     // Catch:{ all -> 0x0013 }
            r1.zzw()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.f r1 = r8.zze     // Catch:{ all -> 0x0061 }
            zzal(r1)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.c1 r1 = r1.D(r9)     // Catch:{ all -> 0x0061 }
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r10 == r3) goto L_0x0049
            r3 = 204(0xcc, float:2.86E-43)
            if (r10 == r3) goto L_0x0049
            if (r10 != r4) goto L_0x0047
            r10 = r4
            goto L_0x0049
        L_0x0047:
            r3 = r0
            goto L_0x004c
        L_0x0049:
            if (r11 != 0) goto L_0x0047
            r3 = 1
        L_0x004c:
            if (r1 != 0) goto L_0x0064
            com.google.android.gms.measurement.internal.zzeh r10 = r8.zzay()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzk()     // Catch:{ all -> 0x0061 }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzeh.zzn(r9)     // Catch:{ all -> 0x0061 }
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0061 }
            goto L_0x0177
        L_0x0061:
            r9 = move-exception
            goto L_0x018d
        L_0x0064:
            r5 = 404(0x194, float:5.66E-43)
            if (r3 != 0) goto L_0x00c2
            if (r10 != r5) goto L_0x006b
            goto L_0x00c2
        L_0x006b:
            com.google.android.gms.common.util.Clock r12 = r8.zzav()     // Catch:{ all -> 0x0061 }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x0061 }
            r1.u(r12)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.f r12 = r8.zze     // Catch:{ all -> 0x0061 }
            zzal(r12)     // Catch:{ all -> 0x0061 }
            r12.c(r1)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzeh r12 = r8.zzay()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzj()     // Catch:{ all -> 0x0061 }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0061 }
            r12.zzc(r13, r1, r11)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzfi r11 = r8.zzc     // Catch:{ all -> 0x0061 }
            zzal(r11)     // Catch:{ all -> 0x0061 }
            r11.zzl(r9)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzjo r9 = r8.zzk     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzd     // Catch:{ all -> 0x0061 }
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0061 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0061 }
            r9.zzb(r11)     // Catch:{ all -> 0x0061 }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00ae
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00bd
        L_0x00ae:
            com.google.android.gms.measurement.internal.zzjo r9 = r8.zzk     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzes r9 = r9.zzb     // Catch:{ all -> 0x0061 }
            com.google.android.gms.common.util.Clock r10 = r8.zzav()     // Catch:{ all -> 0x0061 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0061 }
            r9.zzb(r10)     // Catch:{ all -> 0x0061 }
        L_0x00bd:
            r8.zzag()     // Catch:{ all -> 0x0061 }
            goto L_0x0177
        L_0x00c2:
            r11 = 0
            if (r13 == 0) goto L_0x00ce
            java.lang.String r3 = "Last-Modified"
            java.lang.Object r3 = r13.get(r3)     // Catch:{ all -> 0x0061 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0061 }
            goto L_0x00cf
        L_0x00ce:
            r3 = r11
        L_0x00cf:
            if (r3 == 0) goto L_0x00de
            boolean r6 = r3.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r6 != 0) goto L_0x00de
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x0061 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0061 }
            goto L_0x00df
        L_0x00de:
            r3 = r11
        L_0x00df:
            com.google.android.gms.internal.measurement.zzox.zzc()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzag r6 = r8.zzg()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzao     // Catch:{ all -> 0x0061 }
            boolean r6 = r6.zzs(r11, r7)     // Catch:{ all -> 0x0061 }
            if (r6 == 0) goto L_0x0109
            if (r13 == 0) goto L_0x00f9
            java.lang.String r6 = "ETag"
            java.lang.Object r13 = r13.get(r6)     // Catch:{ all -> 0x0061 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0061 }
            goto L_0x00fa
        L_0x00f9:
            r13 = r11
        L_0x00fa:
            if (r13 == 0) goto L_0x0109
            boolean r6 = r13.isEmpty()     // Catch:{ all -> 0x0061 }
            if (r6 != 0) goto L_0x0109
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x0061 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0061 }
            goto L_0x010a
        L_0x0109:
            r13 = r11
        L_0x010a:
            if (r10 == r5) goto L_0x0118
            if (r10 != r4) goto L_0x010f
            goto L_0x0118
        L_0x010f:
            com.google.android.gms.measurement.internal.zzfi r11 = r8.zzc     // Catch:{ all -> 0x0061 }
            zzal(r11)     // Catch:{ all -> 0x0061 }
            r11.zzt(r9, r12, r3, r13)     // Catch:{ all -> 0x0061 }
            goto L_0x012b
        L_0x0118:
            com.google.android.gms.measurement.internal.zzfi r12 = r8.zzc     // Catch:{ all -> 0x0061 }
            zzal(r12)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.measurement.zzff r12 = r12.zze(r9)     // Catch:{ all -> 0x0061 }
            if (r12 != 0) goto L_0x012b
            com.google.android.gms.measurement.internal.zzfi r12 = r8.zzc     // Catch:{ all -> 0x0061 }
            zzal(r12)     // Catch:{ all -> 0x0061 }
            r12.zzt(r9, r11, r11, r11)     // Catch:{ all -> 0x0061 }
        L_0x012b:
            com.google.android.gms.common.util.Clock r11 = r8.zzav()     // Catch:{ all -> 0x0061 }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x0061 }
            r1.l(r11)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.f r11 = r8.zze     // Catch:{ all -> 0x0061 }
            zzal(r11)     // Catch:{ all -> 0x0061 }
            r11.c(r1)     // Catch:{ all -> 0x0061 }
            if (r10 != r5) goto L_0x014e
            com.google.android.gms.measurement.internal.zzeh r10 = r8.zzay()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzl()     // Catch:{ all -> 0x0061 }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.zzb(r11, r9)     // Catch:{ all -> 0x0061 }
            goto L_0x015f
        L_0x014e:
            com.google.android.gms.measurement.internal.zzeh r9 = r8.zzay()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ all -> 0x0061 }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0061 }
            r9.zzc(r11, r10, r2)     // Catch:{ all -> 0x0061 }
        L_0x015f:
            com.google.android.gms.measurement.internal.zzen r9 = r8.zzd     // Catch:{ all -> 0x0061 }
            zzal(r9)     // Catch:{ all -> 0x0061 }
            boolean r9 = r9.zza()     // Catch:{ all -> 0x0061 }
            if (r9 == 0) goto L_0x0174
            boolean r9 = r8.zzai()     // Catch:{ all -> 0x0061 }
            if (r9 == 0) goto L_0x0174
            r8.zzX()     // Catch:{ all -> 0x0061 }
            goto L_0x0177
        L_0x0174:
            r8.zzag()     // Catch:{ all -> 0x0061 }
        L_0x0177:
            com.google.android.gms.measurement.internal.f r9 = r8.zze     // Catch:{ all -> 0x0061 }
            zzal(r9)     // Catch:{ all -> 0x0061 }
            r9.zzC()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.measurement.internal.f r9 = r8.zze     // Catch:{ all -> 0x0013 }
            zzal(r9)     // Catch:{ all -> 0x0013 }
            r9.P()     // Catch:{ all -> 0x0013 }
            r8.zzt = r0
            r8.zzae()
            return
        L_0x018d:
            com.google.android.gms.measurement.internal.f r10 = r8.zze     // Catch:{ all -> 0x0013 }
            zzal(r10)     // Catch:{ all -> 0x0013 }
            r10.P()     // Catch:{ all -> 0x0013 }
            throw r9     // Catch:{ all -> 0x0013 }
        L_0x0196:
            r8.zzt = r0
            r8.zzae()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzI(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzJ(boolean z10) {
        zzag();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzK(int i10, Throwable th, byte[] bArr, String str) {
        f fVar;
        zzaz().zzg();
        zzB();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzu = false;
                zzae();
                throw th2;
            }
        }
        List<Long> list = (List) Preconditions.checkNotNull(this.zzy);
        this.zzy = null;
        if (i10 != 200) {
            if (i10 == 204) {
                i10 = 204;
            }
            zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
            this.zzk.zzd.zzb(zzav().currentTimeMillis());
            if (i10 == 503 || i10 == 429) {
                this.zzk.zzb.zzb(zzav().currentTimeMillis());
            }
            f fVar2 = this.zze;
            zzal(fVar2);
            fVar2.Q(list);
            zzag();
            this.zzu = false;
            zzae();
        }
        if (th == null) {
            try {
                this.zzk.zzc.zzb(zzav().currentTimeMillis());
                this.zzk.zzd.zzb(0);
                zzag();
                zzay().zzj().zzc("Successful upload. Got network response. code, size", Integer.valueOf(i10), Integer.valueOf(bArr.length));
                f fVar3 = this.zze;
                zzal(fVar3);
                fVar3.zzw();
                for (Long l10 : list) {
                    try {
                        fVar = this.zze;
                        zzal(fVar);
                        long longValue = l10.longValue();
                        fVar.zzg();
                        fVar.zzW();
                        if (fVar.zzh().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                            throw new SQLiteException("Deleted fewer rows from queue than expected");
                        }
                    } catch (SQLiteException e10) {
                        fVar.zzt.zzay().zzd().zzb("Failed to delete a bundle in a queue table", e10);
                        throw e10;
                    } catch (SQLiteException e11) {
                        List list2 = this.zzz;
                        if (list2 == null || !list2.contains(l10)) {
                            throw e11;
                        }
                    }
                }
                f fVar4 = this.zze;
                zzal(fVar4);
                fVar4.zzC();
                f fVar5 = this.zze;
                zzal(fVar5);
                fVar5.P();
                this.zzz = null;
                zzen zzen = this.zzd;
                zzal(zzen);
                if (!zzen.zza() || !zzai()) {
                    this.zzA = -1;
                    zzag();
                } else {
                    zzX();
                }
                this.zza = 0;
            } catch (SQLiteException e12) {
                zzay().zzd().zzb("Database error while trying to delete uploaded bundles", e12);
                this.zza = zzav().elapsedRealtime();
                zzay().zzj().zzb("Disable upload, time", Long.valueOf(this.zza));
            } catch (Throwable th3) {
                f fVar6 = this.zze;
                zzal(fVar6);
                fVar6.P();
                throw th3;
            }
            this.zzu = false;
            zzae();
        }
        zzay().zzj().zzc("Network upload failed. Will retry later. code, error", Integer.valueOf(i10), th);
        this.zzk.zzd.zzb(zzav().currentTimeMillis());
        this.zzk.zzb.zzb(zzav().currentTimeMillis());
        f fVar22 = this.zze;
        zzal(fVar22);
        fVar22.Q(list);
        zzag();
        this.zzu = false;
        zzae();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03f8 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0424 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0439 A[SYNTHETIC, Splitter:B:145:0x0439] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x04d4 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x04f0 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0551 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0144 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0203 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0207 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0241 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0260 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0267 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0276 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0286 A[Catch:{ NameNotFoundException -> 0x0448, all -> 0x00c5 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzL(com.google.android.gms.measurement.internal.zzq r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "com.android.vending"
            java.lang.String r7 = "_uwa"
            java.lang.String r0 = "app_id=?"
            com.google.android.gms.measurement.internal.zzfo r8 = r26.zzaz()
            r8.zzg()
            r26.zzB()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r8 = zzak(r27)
            if (r8 == 0) goto L_0x0588
            com.google.android.gms.measurement.internal.f r8 = r1.zze
            zzal(r8)
            java.lang.String r9 = r2.zza
            com.google.android.gms.measurement.internal.c1 r8 = r8.D(r9)
            r9 = 0
            if (r8 == 0) goto L_0x005e
            java.lang.String r11 = r8.i0()
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x005e
            java.lang.String r11 = r2.zzb
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x005e
            r8.l(r9)
            com.google.android.gms.measurement.internal.f r11 = r1.zze
            zzal(r11)
            r11.c(r8)
            com.google.android.gms.measurement.internal.zzfi r8 = r1.zzc
            zzal(r8)
            java.lang.String r11 = r2.zza
            r8.zzm(r11)
        L_0x005e:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0066
            r26.zzd(r27)
            return
        L_0x0066:
            long r11 = r2.zzm
            int r8 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0074
            com.google.android.gms.common.util.Clock r8 = r26.zzav()
            long r11 = r8.currentTimeMillis()
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfr r8 = r1.zzn
            com.google.android.gms.measurement.internal.zzaq r8 = r8.zzg()
            r8.zzd()
            int r8 = r2.zzn
            r15 = 1
            if (r8 == 0) goto L_0x009c
            if (r8 == r15) goto L_0x009c
            com.google.android.gms.measurement.internal.zzeh r13 = r26.zzay()
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzk()
            java.lang.String r14 = r2.zza
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzeh.zzn(r14)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Incorrect app type, assuming installed app. appId, appType"
            r13.zzc(r9, r14, r8)
            r8 = 0
        L_0x009c:
            com.google.android.gms.measurement.internal.f r9 = r1.zze
            zzal(r9)
            r9.zzw()
            com.google.android.gms.measurement.internal.f r9 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r9)     // Catch:{ all -> 0x00c5 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x00c5 }
            java.lang.String r13 = "_npa"
            com.google.android.gms.measurement.internal.d4 r9 = r9.J(r10, r13)     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x00c8
            java.lang.String r10 = "auto"
            java.lang.String r13 = r9.f7462b     // Catch:{ all -> 0x00c5 }
            boolean r10 = r10.equals(r13)     // Catch:{ all -> 0x00c5 }
            if (r10 == 0) goto L_0x00be
            goto L_0x00c8
        L_0x00be:
            r21 = r3
            r22 = r4
            r3 = 1
            goto L_0x011a
        L_0x00c5:
            r0 = move-exception
            goto L_0x057f
        L_0x00c8:
            java.lang.Boolean r10 = r2.zzr     // Catch:{ all -> 0x00c5 }
            if (r10 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzkw r10 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_npa"
            java.lang.Boolean r13 = r2.zzr     // Catch:{ all -> 0x00c5 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x00c5 }
            if (r15 == r13) goto L_0x00db
            r19 = 0
            goto L_0x00dd
        L_0x00db:
            r19 = 1
        L_0x00dd:
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x00c5 }
            java.lang.String r20 = "auto"
            r21 = r3
            r22 = r4
            r3 = 1
            r13 = r10
            r15 = r11
            r17 = r19
            r18 = r20
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x00c5 }
            if (r9 == 0) goto L_0x00fe
            java.lang.Object r9 = r9.f7465e     // Catch:{ all -> 0x00c5 }
            java.lang.Long r13 = r10.zzd     // Catch:{ all -> 0x00c5 }
            boolean r9 = r9.equals(r13)     // Catch:{ all -> 0x00c5 }
            if (r9 != 0) goto L_0x011a
        L_0x00fe:
            r1.zzW(r10, r2)     // Catch:{ all -> 0x00c5 }
            goto L_0x011a
        L_0x0102:
            r21 = r3
            r22 = r4
            r3 = 1
            if (r9 == 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzkw r9 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_npa"
            java.lang.String r18 = "auto"
            r17 = 0
            r13 = r9
            r15 = r11
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x00c5 }
            r1.zzP(r9, r2)     // Catch:{ all -> 0x00c5 }
        L_0x011a:
            com.google.android.gms.measurement.internal.f r9 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r9)     // Catch:{ all -> 0x00c5 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x00c5 }
            java.lang.Object r10 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)     // Catch:{ all -> 0x00c5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.c1 r9 = r9.D(r10)     // Catch:{ all -> 0x00c5 }
            r10 = 0
            if (r9 == 0) goto L_0x0203
            com.google.android.gms.measurement.internal.zzlb r13 = r26.zzv()     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = r2.zzb     // Catch:{ all -> 0x00c5 }
            java.lang.String r15 = r9.i0()     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r2.zzq     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = r9.b0()     // Catch:{ all -> 0x00c5 }
            boolean r3 = r13.zzam(r14, r15, r3, r4)     // Catch:{ all -> 0x00c5 }
            if (r3 == 0) goto L_0x0203
            com.google.android.gms.measurement.internal.zzeh r3 = r26.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r9.d0()     // Catch:{ all -> 0x00c5 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r13)     // Catch:{ all -> 0x00c5 }
            r3.zzb(r4, r13)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.f r3 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r3)     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = r9.d0()     // Catch:{ all -> 0x00c5 }
            r3.zzW()     // Catch:{ all -> 0x00c5 }
            r3.zzg()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x00c5 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x01ec }
            java.lang.String[] r13 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x01ec }
            java.lang.String r14 = "events"
            int r14 = r9.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            java.lang.String r15 = "user_attributes"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            java.lang.String r15 = "consent_settings"
            int r15 = r9.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01ec }
            int r14 = r14 + r15
            com.google.android.gms.internal.measurement.zzoi.zzc()     // Catch:{ SQLiteException -> 0x01ec }
            com.google.android.gms.measurement.internal.zzfr r15 = r3.zzt     // Catch:{ SQLiteException -> 0x01ec }
            com.google.android.gms.measurement.internal.zzag r15 = r15.zzf()     // Catch:{ SQLiteException -> 0x01ec }
            r23 = r5
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzat     // Catch:{ SQLiteException -> 0x01d3 }
            boolean r5 = r15.zzs(r10, r5)     // Catch:{ SQLiteException -> 0x01d3 }
            if (r5 == 0) goto L_0x01d5
            java.lang.String r5 = "default_event_params"
            int r0 = r9.delete(r5, r0, r13)     // Catch:{ SQLiteException -> 0x01d3 }
            int r14 = r14 + r0
            goto L_0x01d5
        L_0x01d3:
            r0 = move-exception
            goto L_0x01ef
        L_0x01d5:
            if (r14 <= 0) goto L_0x01ea
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzt     // Catch:{ SQLiteException -> 0x01d3 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x01d3 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x01d3 }
            java.lang.String r5 = "Deleted application data. app, records"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01d3 }
            r0.zzc(r5, r4, r9)     // Catch:{ SQLiteException -> 0x01d3 }
        L_0x01ea:
            r9 = r10
            goto L_0x0205
        L_0x01ec:
            r0 = move-exception
            r23 = r5
        L_0x01ef:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x00c5 }
            java.lang.String r5 = "Error deleting application data. appId, error"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x00c5 }
            r3.zzc(r5, r4, r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x01ea
        L_0x0203:
            r23 = r5
        L_0x0205:
            if (r9 == 0) goto L_0x0260
            long r3 = r9.L()     // Catch:{ all -> 0x00c5 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x0222
            long r3 = r9.L()     // Catch:{ all -> 0x00c5 }
            r24 = r11
            long r10 = r2.zzj     // Catch:{ all -> 0x00c5 }
            int r0 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x0220
            r15 = 1
            goto L_0x0225
        L_0x0220:
            r15 = 0
            goto L_0x0225
        L_0x0222:
            r24 = r11
            goto L_0x0220
        L_0x0225:
            java.lang.String r0 = r9.g0()     // Catch:{ all -> 0x00c5 }
            long r3 = r9.L()     // Catch:{ all -> 0x00c5 }
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x023d
            if (r0 == 0) goto L_0x023d
            java.lang.String r3 = r2.zzc     // Catch:{ all -> 0x00c5 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x00c5 }
            if (r3 != 0) goto L_0x023d
            r3 = 1
            goto L_0x023e
        L_0x023d:
            r3 = 0
        L_0x023e:
            r3 = r3 | r15
            if (r3 == 0) goto L_0x0262
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x00c5 }
            r3.<init>()     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "_pv"
            r3.putString(r4, r0)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzaw r0 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x00c5 }
            r15.<init>(r3)     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_au"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r24
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x00c5 }
            r1.zzE(r0, r2)     // Catch:{ all -> 0x00c5 }
            goto L_0x0262
        L_0x0260:
            r24 = r11
        L_0x0262:
            r26.zzd(r27)     // Catch:{ all -> 0x00c5 }
            if (r8 != 0) goto L_0x0276
            com.google.android.gms.measurement.internal.f r0 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "_f"
            com.google.android.gms.measurement.internal.i r0 = r0.H(r3, r4)     // Catch:{ all -> 0x00c5 }
            r15 = 0
            goto L_0x0284
        L_0x0276:
            com.google.android.gms.measurement.internal.f r0 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = r2.zza     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "_v"
            com.google.android.gms.measurement.internal.i r0 = r0.H(r3, r4)     // Catch:{ all -> 0x00c5 }
            r15 = 1
        L_0x0284:
            if (r0 != 0) goto L_0x0551
            r3 = 3600000(0x36ee80, double:1.7786363E-317)
            long r11 = r24 / r3
            r8 = 1
            long r11 = r11 + r8
            long r11 = r11 * r3
            java.lang.String r3 = "_dac"
            java.lang.String r4 = "_et"
            java.lang.String r8 = "_r"
            java.lang.String r9 = "_c"
            if (r15 != 0) goto L_0x0508
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_fot"
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x00c5 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r24
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x00c5 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfo r0 = r26.zzaz()     // Catch:{ all -> 0x00c5 }
            r0.zzg()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzez r0 = r1.zzm     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x00c5 }
            r10 = r0
            com.google.android.gms.measurement.internal.zzez r10 = (com.google.android.gms.measurement.internal.zzez) r10     // Catch:{ all -> 0x00c5 }
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x02c6
            boolean r11 = r0.isEmpty()     // Catch:{ all -> 0x00c5 }
            if (r11 == 0) goto L_0x02ca
        L_0x02c6:
            r14 = 1
            r15 = 0
            goto L_0x03b7
        L_0x02ca:
            com.google.android.gms.measurement.internal.zzfr r11 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfo r11 = r11.zzaz()     // Catch:{ all -> 0x00c5 }
            r11.zzg()     // Catch:{ all -> 0x00c5 }
            boolean r11 = r10.zza()     // Catch:{ all -> 0x00c5 }
            if (r11 != 0) goto L_0x02ec
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "Install Referrer Reporter is not available"
            r0.zza(r6)     // Catch:{ all -> 0x00c5 }
        L_0x02e8:
            r14 = 1
            r15 = 0
            goto L_0x03c6
        L_0x02ec:
            com.google.android.gms.measurement.internal.zzey r11 = new com.google.android.gms.measurement.internal.zzey     // Catch:{ all -> 0x00c5 }
            r11.<init>(r10, r0)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfo r0 = r0.zzaz()     // Catch:{ all -> 0x00c5 }
            r0.zzg()     // Catch:{ all -> 0x00c5 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x00c5 }
            java.lang.String r12 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r12)     // Catch:{ all -> 0x00c5 }
            android.content.ComponentName r12 = new android.content.ComponentName     // Catch:{ all -> 0x00c5 }
            java.lang.String r13 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r12.<init>(r6, r13)     // Catch:{ all -> 0x00c5 }
            r0.setComponent(r12)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfr r12 = r10.zza     // Catch:{ all -> 0x00c5 }
            android.content.Context r12 = r12.zzau()     // Catch:{ all -> 0x00c5 }
            android.content.pm.PackageManager r12 = r12.getPackageManager()     // Catch:{ all -> 0x00c5 }
            if (r12 != 0) goto L_0x0327
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r6)     // Catch:{ all -> 0x00c5 }
            goto L_0x02e8
        L_0x0327:
            r15 = 0
            java.util.List r12 = r12.queryIntentServices(r0, r15)     // Catch:{ all -> 0x00c5 }
            if (r12 == 0) goto L_0x03a6
            boolean r13 = r12.isEmpty()     // Catch:{ all -> 0x00c5 }
            if (r13 != 0) goto L_0x03a6
            java.lang.Object r12 = r12.get(r15)     // Catch:{ all -> 0x00c5 }
            android.content.pm.ResolveInfo r12 = (android.content.pm.ResolveInfo) r12     // Catch:{ all -> 0x00c5 }
            android.content.pm.ServiceInfo r12 = r12.serviceInfo     // Catch:{ all -> 0x00c5 }
            if (r12 == 0) goto L_0x03a4
            java.lang.String r13 = r12.packageName     // Catch:{ all -> 0x00c5 }
            java.lang.String r12 = r12.name     // Catch:{ all -> 0x00c5 }
            if (r12 == 0) goto L_0x0393
            boolean r6 = r6.equals(r13)     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x0393
            boolean r6 = r10.zza()     // Catch:{ all -> 0x00c5 }
            if (r6 == 0) goto L_0x0393
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00c5 }
            r6.<init>(r0)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x037d }
            com.google.android.gms.measurement.internal.zzfr r12 = r10.zza     // Catch:{ RuntimeException -> 0x037d }
            android.content.Context r12 = r12.zzau()     // Catch:{ RuntimeException -> 0x037d }
            r14 = 1
            boolean r0 = r0.bindService(r12, r6, r11, r14)     // Catch:{ RuntimeException -> 0x037b }
            com.google.android.gms.measurement.internal.zzfr r6 = r10.zza     // Catch:{ RuntimeException -> 0x037b }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ RuntimeException -> 0x037b }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()     // Catch:{ RuntimeException -> 0x037b }
            java.lang.String r11 = "Install Referrer Service is"
            java.lang.String r12 = "available"
            java.lang.String r13 = "not available"
            if (r14 == r0) goto L_0x0377
            r12 = r13
        L_0x0377:
            r6.zzb(r11, r12)     // Catch:{ RuntimeException -> 0x037b }
            goto L_0x03c6
        L_0x037b:
            r0 = move-exception
            goto L_0x037f
        L_0x037d:
            r0 = move-exception
            r14 = 1
        L_0x037f:
            com.google.android.gms.measurement.internal.zzfr r6 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzd()     // Catch:{ all -> 0x00c5 }
            java.lang.String r10 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00c5 }
            r6.zzb(r10, r0)     // Catch:{ all -> 0x00c5 }
            goto L_0x03c6
        L_0x0393:
            r14 = 1
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r6)     // Catch:{ all -> 0x00c5 }
            goto L_0x03c6
        L_0x03a4:
            r14 = 1
            goto L_0x03c6
        L_0x03a6:
            r14 = 1
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzi()     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r6)     // Catch:{ all -> 0x00c5 }
            goto L_0x03c6
        L_0x03b7:
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zza     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzm()     // Catch:{ all -> 0x00c5 }
            java.lang.String r6 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r6)     // Catch:{ all -> 0x00c5 }
        L_0x03c6:
            com.google.android.gms.measurement.internal.zzfo r0 = r26.zzaz()     // Catch:{ all -> 0x00c5 }
            r0.zzg()     // Catch:{ all -> 0x00c5 }
            r26.zzB()     // Catch:{ all -> 0x00c5 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x00c5 }
            r6.<init>()     // Catch:{ all -> 0x00c5 }
            r10 = 1
            r6.putLong(r9, r10)     // Catch:{ all -> 0x00c5 }
            r6.putLong(r8, r10)     // Catch:{ all -> 0x00c5 }
            r8 = 0
            r6.putLong(r7, r8)     // Catch:{ all -> 0x00c5 }
            r12 = r23
            r6.putLong(r12, r8)     // Catch:{ all -> 0x00c5 }
            r13 = r22
            r6.putLong(r13, r8)     // Catch:{ all -> 0x00c5 }
            r5 = r21
            r6.putLong(r5, r8)     // Catch:{ all -> 0x00c5 }
            r6.putLong(r4, r10)     // Catch:{ all -> 0x00c5 }
            boolean r0 = r2.zzp     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x03fb
            r6.putLong(r3, r10)     // Catch:{ all -> 0x00c5 }
        L_0x03fb:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x00c5 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x00c5 }
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.f r0 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r0)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x00c5 }
            r0.zzg()     // Catch:{ all -> 0x00c5 }
            r0.zzW()     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "first_open_count"
            long r8 = r0.y(r3, r4)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x00c5 }
            android.content.Context r0 = r0.zzau()     // Catch:{ all -> 0x00c5 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x00c5 }
            if (r0 != 0) goto L_0x0439
            com.google.android.gms.measurement.internal.zzeh r0 = r26.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x00c5 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x00c5 }
            r0.zzb(r4, r3)     // Catch:{ all -> 0x00c5 }
        L_0x0435:
            r3 = 0
            goto L_0x04ec
        L_0x0439:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x0448 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x0448 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0448 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r15)     // Catch:{ NameNotFoundException -> 0x0448 }
            goto L_0x045b
        L_0x0448:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r4 = r26.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ all -> 0x00c5 }
            java.lang.String r10 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x00c5 }
            r4.zzc(r10, r11, r0)     // Catch:{ all -> 0x00c5 }
            r0 = 0
        L_0x045b:
            if (r0 == 0) goto L_0x04ad
            long r10 = r0.firstInstallTime     // Catch:{ all -> 0x00c5 }
            r17 = 0
            int r4 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r4 == 0) goto L_0x04ad
            long r14 = r0.lastUpdateTime     // Catch:{ all -> 0x00c5 }
            int r0 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x048d
            com.google.android.gms.measurement.internal.zzag r0 = r26.zzg()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzdt r4 = com.google.android.gms.measurement.internal.zzdu.zzab     // Catch:{ all -> 0x00c5 }
            r10 = 0
            boolean r0 = r0.zzs(r10, r4)     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x0487
            r14 = 0
            int r0 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0485
            r14 = 1
            r6.putLong(r7, r14)     // Catch:{ all -> 0x00c5 }
            r8 = 0
        L_0x0485:
            r15 = 0
            goto L_0x048f
        L_0x0487:
            r14 = 1
            r6.putLong(r7, r14)     // Catch:{ all -> 0x00c5 }
            goto L_0x0485
        L_0x048d:
            r10 = 0
            r15 = 1
        L_0x048f:
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_fi"
            r4 = 1
            if (r4 == r15) goto L_0x0499
            r15 = 0
            goto L_0x049b
        L_0x0499:
            r15 = 1
        L_0x049b:
            java.lang.Long r17 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x00c5 }
            java.lang.String r18 = "auto"
            r7 = r13
            r13 = r0
            r11 = 0
            r15 = r24
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x00c5 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x00c5 }
            goto L_0x04b1
        L_0x04ad:
            r7 = r13
            r4 = r14
            r11 = r15
            r10 = 0
        L_0x04b1:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x04c0 }
            android.content.Context r0 = r0.zzau()     // Catch:{ NameNotFoundException -> 0x04c0 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x04c0 }
            android.content.pm.ApplicationInfo r10 = r0.getApplicationInfo(r3, r11)     // Catch:{ NameNotFoundException -> 0x04c0 }
            goto L_0x04d2
        L_0x04c0:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r11 = r26.zzay()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x00c5 }
            java.lang.String r13 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x00c5 }
            r11.zzc(r13, r3, r0)     // Catch:{ all -> 0x00c5 }
        L_0x04d2:
            if (r10 == 0) goto L_0x0435
            int r0 = r10.flags     // Catch:{ all -> 0x00c5 }
            r0 = r0 & r4
            if (r0 == 0) goto L_0x04df
            r3 = 1
            r6.putLong(r7, r3)     // Catch:{ all -> 0x00c5 }
            goto L_0x04e1
        L_0x04df:
            r3 = 1
        L_0x04e1:
            int r0 = r10.flags     // Catch:{ all -> 0x00c5 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0435
            r6.putLong(r5, r3)     // Catch:{ all -> 0x00c5 }
            goto L_0x0435
        L_0x04ec:
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x04f3
            r6.putLong(r12, r8)     // Catch:{ all -> 0x00c5 }
        L_0x04f3:
            com.google.android.gms.measurement.internal.zzaw r0 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x00c5 }
            r15.<init>(r6)     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_f"
            java.lang.String r16 = "auto"
            r13 = r0
            r17 = r24
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x00c5 }
            r1.zzG(r0, r2)     // Catch:{ all -> 0x00c5 }
            goto L_0x056e
        L_0x0508:
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_fvt"
            java.lang.Long r17 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x00c5 }
            java.lang.String r18 = "auto"
            r13 = r0
            r15 = r24
            r13.<init>(r14, r15, r17, r18)     // Catch:{ all -> 0x00c5 }
            r1.zzW(r0, r2)     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzfo r0 = r26.zzaz()     // Catch:{ all -> 0x00c5 }
            r0.zzg()     // Catch:{ all -> 0x00c5 }
            r26.zzB()     // Catch:{ all -> 0x00c5 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00c5 }
            r0.<init>()     // Catch:{ all -> 0x00c5 }
            r5 = 1
            r0.putLong(r9, r5)     // Catch:{ all -> 0x00c5 }
            r0.putLong(r8, r5)     // Catch:{ all -> 0x00c5 }
            r0.putLong(r4, r5)     // Catch:{ all -> 0x00c5 }
            boolean r4 = r2.zzp     // Catch:{ all -> 0x00c5 }
            if (r4 == 0) goto L_0x053c
            r0.putLong(r3, r5)     // Catch:{ all -> 0x00c5 }
        L_0x053c:
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x00c5 }
            r15.<init>(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_v"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r24
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x00c5 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x00c5 }
            goto L_0x056e
        L_0x0551:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x00c5 }
            if (r0 == 0) goto L_0x056e
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00c5 }
            r0.<init>()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzaw r3 = new com.google.android.gms.measurement.internal.zzaw     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.zzau r15 = new com.google.android.gms.measurement.internal.zzau     // Catch:{ all -> 0x00c5 }
            r15.<init>(r0)     // Catch:{ all -> 0x00c5 }
            java.lang.String r14 = "_cd"
            java.lang.String r16 = "auto"
            r13 = r3
            r17 = r24
            r13.<init>(r14, r15, r16, r17)     // Catch:{ all -> 0x00c5 }
            r1.zzG(r3, r2)     // Catch:{ all -> 0x00c5 }
        L_0x056e:
            com.google.android.gms.measurement.internal.f r0 = r1.zze     // Catch:{ all -> 0x00c5 }
            zzal(r0)     // Catch:{ all -> 0x00c5 }
            r0.zzC()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.f r0 = r1.zze
            zzal(r0)
            r0.P()
            return
        L_0x057f:
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            throw r0
        L_0x0588:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzL(com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    public final void zzM() {
        this.zzr++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzN(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzO(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzO(zzac zzac, zzq zzq2) {
        Bundle bundle;
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (zzq2.zzh) {
                f fVar = this.zze;
                zzal(fVar);
                fVar.zzw();
                try {
                    zzd(zzq2);
                    String str = (String) Preconditions.checkNotNull(zzac.zza);
                    f fVar2 = this.zze;
                    zzal(fVar2);
                    zzac E = fVar2.E(str, zzac.zzc.zzb);
                    if (E != null) {
                        zzay().zzc().zzc("Removing conditional user property", zzac.zza, this.zzn.zzj().zzf(zzac.zzc.zzb));
                        f fVar3 = this.zze;
                        zzal(fVar3);
                        fVar3.w(str, zzac.zzc.zzb);
                        if (E.zze) {
                            f fVar4 = this.zze;
                            zzal(fVar4);
                            fVar4.a(str, zzac.zzc.zzb);
                        }
                        zzaw zzaw = zzac.zzk;
                        if (zzaw != null) {
                            zzau zzau = zzaw.zzb;
                            if (zzau != null) {
                                bundle = zzau.zzc();
                            } else {
                                bundle = null;
                            }
                            zzY((zzaw) Preconditions.checkNotNull(zzv().zzz(str, ((zzaw) Preconditions.checkNotNull(zzac.zzk)).zza, bundle, E.zzb, zzac.zzk.zzd, true, true)), zzq2);
                        }
                    } else {
                        zzay().zzk().zzc("Conditional user property doesn't exist", zzeh.zzn(zzac.zza), this.zzn.zzj().zzf(zzac.zzc.zzb));
                    }
                    f fVar5 = this.zze;
                    zzal(fVar5);
                    fVar5.zzC();
                    f fVar6 = this.zze;
                    zzal(fVar6);
                    fVar6.P();
                } catch (Throwable th) {
                    f fVar7 = this.zze;
                    zzal(fVar7);
                    fVar7.P();
                    throw th;
                }
            } else {
                zzd(zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzP(zzkw zzkw, zzq zzq2) {
        long j10;
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
            } else if (!"_npa".equals(zzkw.zzb) || zzq2.zzr == null) {
                zzay().zzc().zzb("Removing user property", this.zzn.zzj().zzf(zzkw.zzb));
                f fVar = this.zze;
                zzal(fVar);
                fVar.zzw();
                try {
                    zzd(zzq2);
                    if ("_id".equals(zzkw.zzb)) {
                        f fVar2 = this.zze;
                        zzal(fVar2);
                        fVar2.a((String) Preconditions.checkNotNull(zzq2.zza), "_lair");
                    }
                    f fVar3 = this.zze;
                    zzal(fVar3);
                    fVar3.a((String) Preconditions.checkNotNull(zzq2.zza), zzkw.zzb);
                    f fVar4 = this.zze;
                    zzal(fVar4);
                    fVar4.zzC();
                    zzay().zzc().zzb("User property removed", this.zzn.zzj().zzf(zzkw.zzb));
                    f fVar5 = this.zze;
                    zzal(fVar5);
                    fVar5.P();
                } catch (Throwable th) {
                    f fVar6 = this.zze;
                    zzal(fVar6);
                    fVar6.P();
                    throw th;
                }
            } else {
                zzay().zzc().zza("Falling back to manifest metadata value for ad personalization");
                long currentTimeMillis = zzav().currentTimeMillis();
                if (true != zzq2.zzr.booleanValue()) {
                    j10 = 0;
                } else {
                    j10 = 1;
                }
                zzW(new zzkw("_npa", currentTimeMillis, Long.valueOf(j10), "auto"), zzq2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzQ(zzq zzq2) {
        if (this.zzy != null) {
            ArrayList arrayList = new ArrayList();
            this.zzz = arrayList;
            arrayList.addAll(this.zzy);
        }
        f fVar = this.zze;
        zzal(fVar);
        String str = (String) Preconditions.checkNotNull(zzq2.zza);
        Preconditions.checkNotEmpty(str);
        fVar.zzg();
        fVar.zzW();
        try {
            SQLiteDatabase zzh2 = fVar.zzh();
            String[] strArr = {str};
            int delete = zzh2.delete("apps", "app_id=?", strArr) + zzh2.delete(DbParams.TABLE_EVENTS, "app_id=?", strArr) + zzh2.delete("user_attributes", "app_id=?", strArr) + zzh2.delete("conditional_properties", "app_id=?", strArr) + zzh2.delete("raw_events", "app_id=?", strArr) + zzh2.delete("raw_events_metadata", "app_id=?", strArr) + zzh2.delete("queue", "app_id=?", strArr) + zzh2.delete("audience_filter_values", "app_id=?", strArr) + zzh2.delete("main_event_params", "app_id=?", strArr) + zzh2.delete("default_event_params", "app_id=?", strArr);
            if (delete > 0) {
                fVar.zzt.zzay().zzj().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            fVar.zzt.zzay().zzd().zzc("Error resetting analytics data. appId, error", zzeh.zzn(str), e10);
        }
        if (zzq2.zzh) {
            zzL(zzq2);
        }
    }

    @WorkerThread
    public final void zzR(String str, zzie zzie) {
        zzaz().zzg();
        String str2 = this.zzE;
        if (str2 == null || str2.equals(str) || zzie != null) {
            this.zzE = str;
            this.zzD = zzie;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzS() {
        zzaz().zzg();
        f fVar = this.zze;
        zzal(fVar);
        fVar.zzz();
        if (this.zzk.zzc.zza() == 0) {
            this.zzk.zzc.zzb(zzav().currentTimeMillis());
        }
        zzag();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzT(zzac zzac) {
        zzq zzac2 = zzac((String) Preconditions.checkNotNull(zzac.zza));
        if (zzac2 != null) {
            zzU(zzac, zzac2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzU(zzac zzac, zzq zzq2) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotEmpty(zzac.zza);
        Preconditions.checkNotNull(zzac.zzb);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zzc.zzb);
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq2.zzh) {
                zzd(zzq2);
                return;
            }
            zzac zzac2 = new zzac(zzac);
            boolean z10 = false;
            zzac2.zze = false;
            f fVar = this.zze;
            zzal(fVar);
            fVar.zzw();
            try {
                f fVar2 = this.zze;
                zzal(fVar2);
                zzac E = fVar2.E((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzc.zzb);
                if (E != null && !E.zzb.equals(zzac2.zzb)) {
                    zzay().zzk().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzb, E.zzb);
                }
                if (E != null && E.zze) {
                    zzac2.zzb = E.zzb;
                    zzac2.zzd = E.zzd;
                    zzac2.zzh = E.zzh;
                    zzac2.zzf = E.zzf;
                    zzac2.zzi = E.zzi;
                    zzac2.zze = true;
                    zzkw zzkw = zzac2.zzc;
                    zzac2.zzc = new zzkw(zzkw.zzb, E.zzc.zzc, zzkw.zza(), E.zzc.zzf);
                } else if (TextUtils.isEmpty(zzac2.zzf)) {
                    zzkw zzkw2 = zzac2.zzc;
                    zzac2.zzc = new zzkw(zzkw2.zzb, zzac2.zzd, zzkw2.zza(), zzac2.zzc.zzf);
                    zzac2.zze = true;
                    z10 = true;
                }
                if (zzac2.zze) {
                    zzkw zzkw3 = zzac2.zzc;
                    d4 d4Var = new d4((String) Preconditions.checkNotNull(zzac2.zza), zzac2.zzb, zzkw3.zzb, zzkw3.zzc, Preconditions.checkNotNull(zzkw3.zza()));
                    f fVar3 = this.zze;
                    zzal(fVar3);
                    if (fVar3.k(d4Var)) {
                        zzay().zzc().zzd("User property updated immediately", zzac2.zza, this.zzn.zzj().zzf(d4Var.f7463c), d4Var.f7465e);
                    } else {
                        zzay().zzd().zzd("(2)Too many active user properties, ignoring", zzeh.zzn(zzac2.zza), this.zzn.zzj().zzf(d4Var.f7463c), d4Var.f7465e);
                    }
                    if (z10 && zzac2.zzi != null) {
                        zzY(new zzaw(zzac2.zzi, zzac2.zzd), zzq2);
                    }
                }
                f fVar4 = this.zze;
                zzal(fVar4);
                if (fVar4.j(zzac2)) {
                    zzay().zzc().zzd("Conditional property added", zzac2.zza, this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                } else {
                    zzay().zzd().zzd("Too many conditional properties, ignoring", zzeh.zzn(zzac2.zza), this.zzn.zzj().zzf(zzac2.zzc.zzb), zzac2.zzc.zza());
                }
                f fVar5 = this.zze;
                zzal(fVar5);
                fVar5.zzC();
                f fVar6 = this.zze;
                zzal(fVar6);
                fVar6.P();
            } catch (Throwable th) {
                f fVar7 = this.zze;
                zzal(fVar7);
                fVar7.P();
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzV(String str, zzai zzai) {
        zzaz().zzg();
        zzB();
        this.zzB.put(str, zzai);
        f fVar = this.zze;
        zzal(fVar);
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzai);
        fVar.zzg();
        fVar.zzW();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constant.PARAM_APP_ID, str);
        contentValues.put("consent_state", zzai.zzh());
        try {
            if (fVar.zzh().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                fVar.zzt.zzay().zzd().zzb("Failed to insert/update consent setting (got -1). appId", zzeh.zzn(str));
            }
        } catch (SQLiteException e10) {
            fVar.zzt.zzay().zzd().zzc("Error storing consent setting. appId, error", zzeh.zzn(str), e10);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzW(zzkw zzkw, zzq zzq2) {
        long j10;
        int i10;
        zzkw zzkw2 = zzkw;
        zzq zzq3 = zzq2;
        zzaz().zzg();
        zzB();
        if (zzak(zzq2)) {
            if (!zzq3.zzh) {
                zzd(zzq3);
                return;
            }
            int zzl2 = zzv().zzl(zzkw2.zzb);
            int i11 = 0;
            if (zzl2 != 0) {
                zzlb zzv2 = zzv();
                String str = zzkw2.zzb;
                zzg();
                String zzD2 = zzv2.zzD(str, 24, true);
                String str2 = zzkw2.zzb;
                if (str2 != null) {
                    i10 = str2.length();
                } else {
                    i10 = 0;
                }
                zzv().zzN(this.zzF, zzq3.zza, zzl2, "_ev", zzD2, i10);
                return;
            }
            int zzd2 = zzv().zzd(zzkw2.zzb, zzkw.zza());
            if (zzd2 != 0) {
                zzlb zzv3 = zzv();
                String str3 = zzkw2.zzb;
                zzg();
                String zzD3 = zzv3.zzD(str3, 24, true);
                Object zza2 = zzkw.zza();
                if (zza2 != null && ((zza2 instanceof String) || (zza2 instanceof CharSequence))) {
                    i11 = zza2.toString().length();
                }
                zzv().zzN(this.zzF, zzq3.zza, zzd2, "_ev", zzD3, i11);
                return;
            }
            Object zzB2 = zzv().zzB(zzkw2.zzb, zzkw.zza());
            if (zzB2 != null) {
                if ("_sid".equals(zzkw2.zzb)) {
                    long j11 = zzkw2.zzc;
                    String str4 = zzkw2.zzf;
                    String str5 = (String) Preconditions.checkNotNull(zzq3.zza);
                    f fVar = this.zze;
                    zzal(fVar);
                    d4 J = fVar.J(str5, "_sno");
                    if (J != null) {
                        Object obj = J.f7465e;
                        if (obj instanceof Long) {
                            j10 = ((Long) obj).longValue();
                            zzW(new zzkw("_sno", j11, Long.valueOf(j10 + 1), str4), zzq3);
                        }
                    }
                    if (J != null) {
                        zzay().zzk().zzb("Retrieved last session number from database does not contain a valid (long) value", J.f7465e);
                    }
                    f fVar2 = this.zze;
                    zzal(fVar2);
                    i H = fVar2.H(str5, "_s");
                    if (H != null) {
                        j10 = H.f7539c;
                        zzay().zzj().zzb("Backfill the session number. Last used session number", Long.valueOf(j10));
                    } else {
                        j10 = 0;
                    }
                    zzW(new zzkw("_sno", j11, Long.valueOf(j10 + 1), str4), zzq3);
                }
                d4 d4Var = new d4((String) Preconditions.checkNotNull(zzq3.zza), (String) Preconditions.checkNotNull(zzkw2.zzf), zzkw2.zzb, zzkw2.zzc, zzB2);
                zzay().zzj().zzc("Setting user property", this.zzn.zzj().zzf(d4Var.f7463c), zzB2);
                f fVar3 = this.zze;
                zzal(fVar3);
                fVar3.zzw();
                try {
                    if ("_id".equals(d4Var.f7463c)) {
                        f fVar4 = this.zze;
                        zzal(fVar4);
                        d4 J2 = fVar4.J(zzq3.zza, "_id");
                        if (J2 != null && !d4Var.f7465e.equals(J2.f7465e)) {
                            f fVar5 = this.zze;
                            zzal(fVar5);
                            fVar5.a(zzq3.zza, "_lair");
                        }
                    }
                    zzd(zzq3);
                    f fVar6 = this.zze;
                    zzal(fVar6);
                    boolean k10 = fVar6.k(d4Var);
                    f fVar7 = this.zze;
                    zzal(fVar7);
                    fVar7.zzC();
                    if (!k10) {
                        zzay().zzd().zzc("Too many unique user properties are set. Ignoring user property", this.zzn.zzj().zzf(d4Var.f7463c), d4Var.f7465e);
                        zzv().zzN(this.zzF, zzq3.zza, 9, (String) null, (String) null, 0);
                    }
                    f fVar8 = this.zze;
                    zzal(fVar8);
                    fVar8.P();
                } catch (Throwable th) {
                    f fVar9 = this.zze;
                    zzal(fVar9);
                    fVar9.P();
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01f3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:?, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x027c, code lost:
        r0 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:?, code lost:
        zzay().zzd().zzc("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzeh.zzn(r6), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:263:0x0572, code lost:
        if (r11 != null) goto L_0x0548;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012e, code lost:
        if (r11 != null) goto L_0x010c;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:234:0x04f1 */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x02a8 A[SYNTHETIC, Splitter:B:164:0x02a8] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02b1 A[Catch:{ all -> 0x027e }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0505 A[Catch:{ all -> 0x027e }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x057b A[Catch:{ all -> 0x027e }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0591 A[SYNTHETIC, Splitter:B:272:0x0591] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0136 A[Catch:{ all -> 0x0034 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzX() {
        /*
            r22 = this;
            r1 = r22
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()
            r0.zzg()
            r22.zzB()
            r2 = 1
            r1.zzv = r2
            r3 = 0
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x027e }
            r0.zzaw()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzn     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzjm r0 = r0.zzt()     // Catch:{ all -> 0x027e }
            java.lang.Boolean r0 = r0.zzj()     // Catch:{ all -> 0x027e }
            if (r0 != 0) goto L_0x0038
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
        L_0x0030:
            r22.zzae()
            return
        L_0x0034:
            r0 = move-exception
            r2 = r3
            goto L_0x0595
        L_0x0038:
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x027e }
            if (r0 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x004e:
            long r4 = r1.zza     // Catch:{ all -> 0x027e }
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x005c
            r22.zzag()     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x005c:
            com.google.android.gms.measurement.internal.zzfo r0 = r22.zzaz()     // Catch:{ all -> 0x027e }
            r0.zzg()     // Catch:{ all -> 0x027e }
            java.util.List r0 = r1.zzy     // Catch:{ all -> 0x027e }
            if (r0 == 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0077:
            com.google.android.gms.measurement.internal.zzen r0 = r1.zzd     // Catch:{ all -> 0x027e }
            zzal(r0)     // Catch:{ all -> 0x027e }
            boolean r0 = r0.zza()     // Catch:{ all -> 0x027e }
            if (r0 != 0) goto L_0x0095
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.zza(r2)     // Catch:{ all -> 0x0034 }
            r22.zzag()     // Catch:{ all -> 0x0034 }
            r1.zzv = r3
            goto L_0x0030
        L_0x0095:
            com.google.android.gms.common.util.Clock r0 = r22.zzav()     // Catch:{ all -> 0x027e }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzP     // Catch:{ all -> 0x027e }
            r9 = 0
            int r0 = r0.zze(r9, r8)     // Catch:{ all -> 0x027e }
            r22.zzg()     // Catch:{ all -> 0x027e }
            long r10 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x027e }
            long r10 = r4 - r10
            r8 = r3
        L_0x00b2:
            if (r8 >= r0) goto L_0x00bd
            boolean r12 = r1.zzah(r9, r10)     // Catch:{ all -> 0x0034 }
            if (r12 == 0) goto L_0x00bd
            int r8 = r8 + 1
            goto L_0x00b2
        L_0x00bd:
            com.google.android.gms.measurement.internal.zzjo r0 = r1.zzk     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzes r0 = r0.zzc     // Catch:{ all -> 0x027e }
            long r10 = r0.zza()     // Catch:{ all -> 0x027e }
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x0034 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ all -> 0x0034 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r4 - r10
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0034 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0034 }
            r0.zzb(r6, r7)     // Catch:{ all -> 0x0034 }
        L_0x00e0:
            com.google.android.gms.measurement.internal.f r0 = r1.zze     // Catch:{ all -> 0x027e }
            zzal(r0)     // Catch:{ all -> 0x027e }
            java.lang.String r6 = r0.zzr()     // Catch:{ all -> 0x027e }
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x027e }
            r7 = -1
            if (r0 != 0) goto L_0x0509
            long r10 = r1.zzA     // Catch:{ all -> 0x027e }
            int r0 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x013a
            com.google.android.gms.measurement.internal.f r10 = r1.zze     // Catch:{ all -> 0x0034 }
            zzal(r10)     // Catch:{ all -> 0x0034 }
            android.database.sqlite.SQLiteDatabase r0 = r10.zzh()     // Catch:{ SQLiteException -> 0x011d, all -> 0x011b }
            java.lang.String r11 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r11, r9)     // Catch:{ SQLiteException -> 0x011d, all -> 0x011b }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0117 }
            if (r0 != 0) goto L_0x0110
        L_0x010c:
            r11.close()     // Catch:{ all -> 0x0034 }
            goto L_0x0131
        L_0x0110:
            long r7 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x0117 }
            goto L_0x010c
        L_0x0115:
            r0 = move-exception
            goto L_0x0119
        L_0x0117:
            r0 = move-exception
            goto L_0x011f
        L_0x0119:
            r9 = r11
            goto L_0x0134
        L_0x011b:
            r0 = move-exception
            goto L_0x0134
        L_0x011d:
            r0 = move-exception
            r11 = r9
        L_0x011f:
            com.google.android.gms.measurement.internal.zzfr r10 = r10.zzt     // Catch:{ all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()     // Catch:{ all -> 0x0115 }
            java.lang.String r12 = "Error querying raw events"
            r10.zzb(r12, r0)     // Catch:{ all -> 0x0115 }
            if (r11 == 0) goto L_0x0131
            goto L_0x010c
        L_0x0131:
            r1.zzA = r7     // Catch:{ all -> 0x0034 }
            goto L_0x013a
        L_0x0134:
            if (r9 == 0) goto L_0x0139
            r9.close()     // Catch:{ all -> 0x0034 }
        L_0x0139:
            throw r0     // Catch:{ all -> 0x0034 }
        L_0x013a:
            com.google.android.gms.measurement.internal.zzag r0 = r22.zzg()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzdt r7 = com.google.android.gms.measurement.internal.zzdu.zzf     // Catch:{ all -> 0x027e }
            int r0 = r0.zze(r6, r7)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzag r7 = r22.zzg()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzg     // Catch:{ all -> 0x027e }
            int r7 = r7.zze(r6, r8)     // Catch:{ all -> 0x027e }
            int r7 = java.lang.Math.max(r3, r7)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.f r8 = r1.zze     // Catch:{ all -> 0x027e }
            zzal(r8)     // Catch:{ all -> 0x027e }
            r8.zzg()     // Catch:{ all -> 0x027e }
            r8.zzW()     // Catch:{ all -> 0x027e }
            if (r0 <= 0) goto L_0x0161
            r10 = r2
            goto L_0x0162
        L_0x0161:
            r10 = r3
        L_0x0162:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x027e }
            if (r7 <= 0) goto L_0x0169
            r10 = r2
            goto L_0x016a
        L_0x0169:
            r10 = r3
        L_0x016a:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)     // Catch:{ all -> 0x027e }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x027e }
            android.database.sqlite.SQLiteDatabase r11 = r8.zzh()     // Catch:{ SQLiteException -> 0x0287, all -> 0x0285 }
            java.lang.String r12 = "rowid"
            java.lang.String r13 = "data"
            java.lang.String r14 = "retry_count"
            java.lang.String[] r13 = new java.lang.String[]{r12, r13, r14}     // Catch:{ SQLiteException -> 0x0287, all -> 0x0285 }
            java.lang.String[] r15 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x0287, all -> 0x0285 }
            java.lang.String r12 = "queue"
            java.lang.String r14 = "app_id=?"
            java.lang.String r18 = "rowid"
            java.lang.String r19 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x0287, all -> 0x0285 }
            r16 = 0
            r17 = 0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteException -> 0x0287, all -> 0x0285 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x01a8 }
            if (r0 != 0) goto L_0x01ad
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x01a8 }
            r11.close()     // Catch:{ all -> 0x0034 }
            r20 = r4
            goto L_0x02ab
        L_0x01a5:
            r0 = move-exception
            goto L_0x0282
        L_0x01a8:
            r0 = move-exception
            r20 = r4
            goto L_0x028f
        L_0x01ad:
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x01a8 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x01a8 }
            r13 = r3
        L_0x01b3:
            long r14 = r11.getLong(r3)     // Catch:{ SQLiteException -> 0x01a8 }
            byte[] r0 = r11.getBlob(r2)     // Catch:{ IOException -> 0x0253 }
            com.google.android.gms.measurement.internal.zzkt r2 = r8.zzf     // Catch:{ IOException -> 0x0253 }
            com.google.android.gms.measurement.internal.zzkv r2 = r2.zzi     // Catch:{ IOException -> 0x0253 }
            zzal(r2)     // Catch:{ IOException -> 0x0253 }
            java.io.ByteArrayInputStream r9 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x023e }
            r9.<init>(r0)     // Catch:{ IOException -> 0x023e }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x023e }
            r0.<init>(r9)     // Catch:{ IOException -> 0x023e }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x023e }
            r3.<init>()     // Catch:{ IOException -> 0x023e }
            r10 = 1024(0x400, float:1.435E-42)
            byte[] r10 = new byte[r10]     // Catch:{ IOException -> 0x023e }
            r20 = r4
        L_0x01d7:
            int r4 = r0.read(r10)     // Catch:{ IOException -> 0x0237 }
            if (r4 > 0) goto L_0x0239
            r0.close()     // Catch:{ IOException -> 0x0237 }
            r9.close()     // Catch:{ IOException -> 0x0237 }
            byte[] r0 = r3.toByteArray()     // Catch:{ IOException -> 0x0237 }
            boolean r2 = r12.isEmpty()     // Catch:{ SQLiteException -> 0x01f3 }
            if (r2 != 0) goto L_0x01f6
            int r2 = r0.length     // Catch:{ SQLiteException -> 0x01f3 }
            int r2 = r2 + r13
            if (r2 <= r7) goto L_0x01f6
            goto L_0x0279
        L_0x01f3:
            r0 = move-exception
            goto L_0x028f
        L_0x01f6:
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzll r2 = com.google.android.gms.measurement.internal.zzkv.zzl(r2, r0)     // Catch:{ IOException -> 0x0222 }
            com.google.android.gms.internal.measurement.zzgc r2 = (com.google.android.gms.internal.measurement.zzgc) r2     // Catch:{ IOException -> 0x0222 }
            r3 = 2
            boolean r4 = r11.isNull(r3)     // Catch:{ SQLiteException -> 0x01f3 }
            if (r4 != 0) goto L_0x020e
            int r4 = r11.getInt(r3)     // Catch:{ SQLiteException -> 0x01f3 }
            r2.zzaf(r4)     // Catch:{ SQLiteException -> 0x01f3 }
        L_0x020e:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x01f3 }
            int r13 = r13 + r0
            com.google.android.gms.internal.measurement.zzkf r0 = r2.zzaC()     // Catch:{ SQLiteException -> 0x01f3 }
            com.google.android.gms.internal.measurement.zzgd r0 = (com.google.android.gms.internal.measurement.zzgd) r0     // Catch:{ SQLiteException -> 0x01f3 }
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteException -> 0x01f3 }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x01f3 }
            r12.add(r0)     // Catch:{ SQLiteException -> 0x01f3 }
            goto L_0x0269
        L_0x0222:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ SQLiteException -> 0x01f3 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x01f3 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x01f3 }
            java.lang.String r3 = "Failed to merge queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x01f3 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x01f3 }
            goto L_0x0269
        L_0x0237:
            r0 = move-exception
            goto L_0x0241
        L_0x0239:
            r5 = 0
            r3.write(r10, r5, r4)     // Catch:{ IOException -> 0x0237 }
            goto L_0x01d7
        L_0x023e:
            r0 = move-exception
            r20 = r4
        L_0x0241:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ IOException -> 0x0251 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ IOException -> 0x0251 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ IOException -> 0x0251 }
            java.lang.String r3 = "Failed to ungzip content"
            r2.zzb(r3, r0)     // Catch:{ IOException -> 0x0251 }
            throw r0     // Catch:{ IOException -> 0x0251 }
        L_0x0251:
            r0 = move-exception
            goto L_0x0256
        L_0x0253:
            r0 = move-exception
            r20 = r4
        L_0x0256:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ SQLiteException -> 0x01f3 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ SQLiteException -> 0x01f3 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ SQLiteException -> 0x01f3 }
            java.lang.String r3 = "Failed to unzip queued bundle. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x01f3 }
            r2.zzc(r3, r4, r0)     // Catch:{ SQLiteException -> 0x01f3 }
        L_0x0269:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x01f3 }
            if (r0 == 0) goto L_0x0279
            if (r13 <= r7) goto L_0x0272
            goto L_0x0279
        L_0x0272:
            r4 = r20
            r2 = 1
            r3 = 0
            r9 = 0
            goto L_0x01b3
        L_0x0279:
            r11.close()     // Catch:{ all -> 0x027e }
            r0 = r12
            goto L_0x02ab
        L_0x027e:
            r0 = move-exception
            r2 = 0
            goto L_0x0595
        L_0x0282:
            r9 = r11
            goto L_0x0503
        L_0x0285:
            r0 = move-exception
            goto L_0x028b
        L_0x0287:
            r0 = move-exception
            r20 = r4
            goto L_0x028e
        L_0x028b:
            r9 = 0
            goto L_0x0503
        L_0x028e:
            r11 = 0
        L_0x028f:
            com.google.android.gms.measurement.internal.zzfr r2 = r8.zzt     // Catch:{ all -> 0x01a5 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x01a5 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x01a5 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x01a5 }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x01a5 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x01a5 }
            if (r11 == 0) goto L_0x02ab
            r11.close()     // Catch:{ all -> 0x027e }
        L_0x02ab:
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x027e }
            if (r2 != 0) goto L_0x04ee
            com.google.android.gms.measurement.internal.zzai r2 = r1.zzh(r6)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzah r3 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x027e }
            boolean r2 = r2.zzi(r3)     // Catch:{ all -> 0x027e }
            if (r2 == 0) goto L_0x0312
            java.util.Iterator r2 = r0.iterator()     // Catch:{ all -> 0x027e }
        L_0x02c1:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x027e }
            if (r3 == 0) goto L_0x02e0
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x027e }
            android.util.Pair r3 = (android.util.Pair) r3     // Catch:{ all -> 0x027e }
            java.lang.Object r3 = r3.first     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgd r3 = (com.google.android.gms.internal.measurement.zzgd) r3     // Catch:{ all -> 0x027e }
            java.lang.String r4 = r3.zzJ()     // Catch:{ all -> 0x027e }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x027e }
            if (r4 != 0) goto L_0x02c1
            java.lang.String r2 = r3.zzJ()     // Catch:{ all -> 0x027e }
            goto L_0x02e1
        L_0x02e0:
            r2 = 0
        L_0x02e1:
            if (r2 == 0) goto L_0x0312
            r3 = 0
        L_0x02e4:
            int r4 = r0.size()     // Catch:{ all -> 0x027e }
            if (r3 >= r4) goto L_0x0312
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x027e }
            android.util.Pair r4 = (android.util.Pair) r4     // Catch:{ all -> 0x027e }
            java.lang.Object r4 = r4.first     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgd r4 = (com.google.android.gms.internal.measurement.zzgd) r4     // Catch:{ all -> 0x027e }
            java.lang.String r5 = r4.zzJ()     // Catch:{ all -> 0x027e }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x027e }
            if (r5 == 0) goto L_0x02ff
            goto L_0x030f
        L_0x02ff:
            java.lang.String r4 = r4.zzJ()     // Catch:{ all -> 0x027e }
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x027e }
            if (r4 != 0) goto L_0x030f
            r4 = 0
            java.util.List r0 = r0.subList(r4, r3)     // Catch:{ all -> 0x027e }
            goto L_0x0312
        L_0x030f:
            int r3 = r3 + 1
            goto L_0x02e4
        L_0x0312:
            com.google.android.gms.internal.measurement.zzga r2 = com.google.android.gms.internal.measurement.zzgb.zza()     // Catch:{ all -> 0x027e }
            int r3 = r0.size()     // Catch:{ all -> 0x027e }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x027e }
            int r5 = r0.size()     // Catch:{ all -> 0x027e }
            r4.<init>(r5)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzag r5 = r22.zzg()     // Catch:{ all -> 0x027e }
            boolean r5 = r5.zzt(r6)     // Catch:{ all -> 0x027e }
            if (r5 == 0) goto L_0x033b
            com.google.android.gms.measurement.internal.zzai r5 = r1.zzh(r6)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzah r7 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x027e }
            boolean r5 = r5.zzi(r7)     // Catch:{ all -> 0x027e }
            if (r5 == 0) goto L_0x033b
            r5 = 1
            goto L_0x033c
        L_0x033b:
            r5 = 0
        L_0x033c:
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r6)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzah r8 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x027e }
            boolean r7 = r7.zzi(r8)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzai r8 = r1.zzh(r6)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x027e }
            boolean r8 = r8.zzi(r9)     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ all -> 0x027e }
            r11 = 0
            boolean r9 = r9.zzs(r11, r10)     // Catch:{ all -> 0x027e }
            if (r9 == 0) goto L_0x036e
            com.google.android.gms.measurement.internal.zzag r9 = r22.zzg()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x027e }
            boolean r9 = r9.zzs(r6, r10)     // Catch:{ all -> 0x027e }
            if (r9 == 0) goto L_0x036e
            r9 = 1
            goto L_0x036f
        L_0x036e:
            r9 = 0
        L_0x036f:
            r10 = 0
        L_0x0370:
            if (r10 >= r3) goto L_0x03ee
            java.lang.Object r11 = r0.get(r10)     // Catch:{ all -> 0x027e }
            android.util.Pair r11 = (android.util.Pair) r11     // Catch:{ all -> 0x027e }
            java.lang.Object r11 = r11.first     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgd r11 = (com.google.android.gms.internal.measurement.zzgd) r11     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzkb r11 = r11.zzby()     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgc r11 = (com.google.android.gms.internal.measurement.zzgc) r11     // Catch:{ all -> 0x027e }
            java.lang.Object r12 = r0.get(r10)     // Catch:{ all -> 0x027e }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x027e }
            java.lang.Object r12 = r12.second     // Catch:{ all -> 0x027e }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x027e }
            r4.add(r12)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzag r12 = r22.zzg()     // Catch:{ all -> 0x027e }
            r12.zzh()     // Catch:{ all -> 0x027e }
            r12 = 74029(0x1212d, double:3.6575E-319)
            r11.zzal(r12)     // Catch:{ all -> 0x027e }
            r12 = r20
            r11.zzak(r12)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x027e }
            r14.zzaw()     // Catch:{ all -> 0x027e }
            r14 = 0
            r11.zzag(r14)     // Catch:{ all -> 0x027e }
            if (r5 != 0) goto L_0x03af
            r11.zzq()     // Catch:{ all -> 0x027e }
        L_0x03af:
            if (r7 != 0) goto L_0x03b7
            r11.zzx()     // Catch:{ all -> 0x027e }
            r11.zzt()     // Catch:{ all -> 0x027e }
        L_0x03b7:
            if (r8 != 0) goto L_0x03bc
            r11.zzn()     // Catch:{ all -> 0x027e }
        L_0x03bc:
            r1.zzC(r6, r11)     // Catch:{ all -> 0x027e }
            if (r9 != 0) goto L_0x03c4
            r11.zzy()     // Catch:{ all -> 0x027e }
        L_0x03c4:
            com.google.android.gms.measurement.internal.zzag r14 = r22.zzg()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzdt r15 = com.google.android.gms.measurement.internal.zzdu.zzT     // Catch:{ all -> 0x027e }
            boolean r14 = r14.zzs(r6, r15)     // Catch:{ all -> 0x027e }
            if (r14 == 0) goto L_0x03e6
            com.google.android.gms.internal.measurement.zzkf r14 = r11.zzaC()     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgd r14 = (com.google.android.gms.internal.measurement.zzgd) r14     // Catch:{ all -> 0x027e }
            byte[] r14 = r14.zzbu()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzkv r15 = r1.zzi     // Catch:{ all -> 0x027e }
            zzal(r15)     // Catch:{ all -> 0x027e }
            long r14 = r15.zzd(r14)     // Catch:{ all -> 0x027e }
            r11.zzJ(r14)     // Catch:{ all -> 0x027e }
        L_0x03e6:
            r2.zza(r11)     // Catch:{ all -> 0x027e }
            int r10 = r10 + 1
            r20 = r12
            goto L_0x0370
        L_0x03ee:
            r12 = r20
            com.google.android.gms.measurement.internal.zzeh r0 = r22.zzay()     // Catch:{ all -> 0x027e }
            java.lang.String r0 = r0.zzq()     // Catch:{ all -> 0x027e }
            r5 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r5)     // Catch:{ all -> 0x027e }
            if (r0 == 0) goto L_0x0410
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzi     // Catch:{ all -> 0x027e }
            zzal(r0)     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzkf r5 = r2.zzaC()     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgb r5 = (com.google.android.gms.internal.measurement.zzgb) r5     // Catch:{ all -> 0x027e }
            java.lang.String r0 = r0.zzm(r5)     // Catch:{ all -> 0x027e }
            r11 = r0
            goto L_0x0411
        L_0x0410:
            r11 = 0
        L_0x0411:
            com.google.android.gms.measurement.internal.zzkv r0 = r1.zzi     // Catch:{ all -> 0x027e }
            zzal(r0)     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzkf r0 = r2.zzaC()     // Catch:{ all -> 0x027e }
            com.google.android.gms.internal.measurement.zzgb r0 = (com.google.android.gms.internal.measurement.zzgb) r0     // Catch:{ all -> 0x027e }
            byte[] r14 = r0.zzbu()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzki r0 = r1.zzl     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzkt r0 = r0.zzf     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzfi r0 = r0.zzc     // Catch:{ all -> 0x027e }
            zzal(r0)     // Catch:{ all -> 0x027e }
            java.lang.String r0 = r0.zzi(r6)     // Catch:{ all -> 0x027e }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x027e }
            if (r5 != 0) goto L_0x0468
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x027e }
            r7 = 0
            java.lang.Object r5 = r5.zza(r7)     // Catch:{ all -> 0x027e }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x027e }
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ all -> 0x027e }
            android.net.Uri$Builder r7 = r5.buildUpon()     // Catch:{ all -> 0x027e }
            java.lang.String r5 = r5.getAuthority()     // Catch:{ all -> 0x027e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x027e }
            r8.<init>()     // Catch:{ all -> 0x027e }
            r8.append(r0)     // Catch:{ all -> 0x027e }
            java.lang.String r0 = "."
            r8.append(r0)     // Catch:{ all -> 0x027e }
            r8.append(r5)     // Catch:{ all -> 0x027e }
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x027e }
            r7.authority(r0)     // Catch:{ all -> 0x027e }
            android.net.Uri r0 = r7.build()     // Catch:{ all -> 0x027e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x027e }
            goto L_0x0471
        L_0x0468:
            com.google.android.gms.measurement.internal.zzdt r0 = com.google.android.gms.measurement.internal.zzdu.zzp     // Catch:{ all -> 0x027e }
            r5 = 0
            java.lang.Object r0 = r0.zza(r5)     // Catch:{ all -> 0x027e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x027e }
        L_0x0471:
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x04f1 }
            r5.<init>(r0)     // Catch:{ MalformedURLException -> 0x04f1 }
            boolean r7 = r4.isEmpty()     // Catch:{ MalformedURLException -> 0x04f1 }
            r8 = 1
            r7 = r7 ^ r8
            com.google.android.gms.common.internal.Preconditions.checkArgument(r7)     // Catch:{ MalformedURLException -> 0x04f1 }
            java.util.List r7 = r1.zzy     // Catch:{ MalformedURLException -> 0x04f1 }
            if (r7 == 0) goto L_0x0491
            com.google.android.gms.measurement.internal.zzeh r4 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd()     // Catch:{ MalformedURLException -> 0x04f1 }
            java.lang.String r7 = "Set uploading progress before finishing the previous upload"
            r4.zza(r7)     // Catch:{ MalformedURLException -> 0x04f1 }
            goto L_0x0498
        L_0x0491:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x04f1 }
            r7.<init>(r4)     // Catch:{ MalformedURLException -> 0x04f1 }
            r1.zzy = r7     // Catch:{ MalformedURLException -> 0x04f1 }
        L_0x0498:
            com.google.android.gms.measurement.internal.zzjo r4 = r1.zzk     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.zzes r4 = r4.zzd     // Catch:{ MalformedURLException -> 0x04f1 }
            r4.zzb(r12)     // Catch:{ MalformedURLException -> 0x04f1 }
            java.lang.String r4 = "?"
            if (r3 <= 0) goto L_0x04ac
            r3 = 0
            com.google.android.gms.internal.measurement.zzgd r2 = r2.zzb(r3)     // Catch:{ MalformedURLException -> 0x04f1 }
            java.lang.String r4 = r2.zzx()     // Catch:{ MalformedURLException -> 0x04f1 }
        L_0x04ac:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()     // Catch:{ MalformedURLException -> 0x04f1 }
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            int r7 = r14.length     // Catch:{ MalformedURLException -> 0x04f1 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x04f1 }
            r2.zzd(r3, r4, r7, r11)     // Catch:{ MalformedURLException -> 0x04f1 }
            r2 = 1
            r1.zzu = r2     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.zzen r11 = r1.zzd     // Catch:{ MalformedURLException -> 0x04f1 }
            zzal(r11)     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.w3 r2 = new com.google.android.gms.measurement.internal.w3     // Catch:{ MalformedURLException -> 0x04f1 }
            r2.<init>(r1, r6)     // Catch:{ MalformedURLException -> 0x04f1 }
            r11.zzg()     // Catch:{ MalformedURLException -> 0x04f1 }
            r11.zzW()     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzt     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.zzfo r3 = r3.zzaz()     // Catch:{ MalformedURLException -> 0x04f1 }
            com.google.android.gms.measurement.internal.u r4 = new com.google.android.gms.measurement.internal.u     // Catch:{ MalformedURLException -> 0x04f1 }
            r15 = 0
            r10 = r4
            r12 = r6
            r13 = r5
            r16 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x04f1 }
            r3.zzo(r4)     // Catch:{ MalformedURLException -> 0x04f1 }
        L_0x04ee:
            r2 = 0
            goto L_0x058b
        L_0x04f1:
            com.google.android.gms.measurement.internal.zzeh r2 = r22.zzay()     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x027e }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ all -> 0x027e }
            r2.zzc(r3, r4, r0)     // Catch:{ all -> 0x027e }
            goto L_0x04ee
        L_0x0503:
            if (r9 == 0) goto L_0x0508
            r9.close()     // Catch:{ all -> 0x027e }
        L_0x0508:
            throw r0     // Catch:{ all -> 0x027e }
        L_0x0509:
            r12 = r4
            r5 = r9
            r1.zzA = r7     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x027e }
            zzal(r2)     // Catch:{ all -> 0x027e }
            r22.zzg()     // Catch:{ all -> 0x027e }
            long r3 = com.google.android.gms.measurement.internal.zzag.zzz()     // Catch:{ all -> 0x027e }
            long r3 = r12 - r3
            r2.zzg()     // Catch:{ all -> 0x027e }
            r2.zzW()     // Catch:{ all -> 0x027e }
            android.database.sqlite.SQLiteDatabase r0 = r2.zzh()     // Catch:{ SQLiteException -> 0x055e, all -> 0x055c }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ SQLiteException -> 0x055e, all -> 0x055c }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x055e, all -> 0x055c }
            java.lang.String r4 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            android.database.Cursor r11 = r0.rawQuery(r4, r3)     // Catch:{ SQLiteException -> 0x055e, all -> 0x055c }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x054f }
            if (r0 != 0) goto L_0x0551
            com.google.android.gms.measurement.internal.zzfr r0 = r2.zzt     // Catch:{ SQLiteException -> 0x054f }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x054f }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()     // Catch:{ SQLiteException -> 0x054f }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r0.zza(r3)     // Catch:{ SQLiteException -> 0x054f }
        L_0x0548:
            r11.close()     // Catch:{ all -> 0x027e }
        L_0x054b:
            r9 = r5
            goto L_0x0575
        L_0x054d:
            r0 = move-exception
            goto L_0x055a
        L_0x054f:
            r0 = move-exception
            goto L_0x0563
        L_0x0551:
            r3 = 0
            java.lang.String r9 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x054f }
            r11.close()     // Catch:{ all -> 0x027e }
            goto L_0x0575
        L_0x055a:
            r9 = r11
            goto L_0x058f
        L_0x055c:
            r0 = move-exception
            goto L_0x0560
        L_0x055e:
            r0 = move-exception
            goto L_0x0562
        L_0x0560:
            r9 = r5
            goto L_0x058f
        L_0x0562:
            r11 = r5
        L_0x0563:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x054d }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x054d }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x054d }
            java.lang.String r3 = "Error selecting expired configs"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x054d }
            if (r11 == 0) goto L_0x054b
            goto L_0x0548
        L_0x0575:
            boolean r0 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x027e }
            if (r0 != 0) goto L_0x04ee
            com.google.android.gms.measurement.internal.f r0 = r1.zze     // Catch:{ all -> 0x027e }
            zzal(r0)     // Catch:{ all -> 0x027e }
            com.google.android.gms.measurement.internal.c1 r0 = r0.D(r9)     // Catch:{ all -> 0x027e }
            if (r0 == 0) goto L_0x04ee
            r1.zzD(r0)     // Catch:{ all -> 0x027e }
            goto L_0x04ee
        L_0x058b:
            r1.zzv = r2
            goto L_0x0030
        L_0x058f:
            if (r9 == 0) goto L_0x0594
            r9.close()     // Catch:{ all -> 0x027e }
        L_0x0594:
            throw r0     // Catch:{ all -> 0x027e }
        L_0x0595:
            r1.zzv = r2
            r22.zzae()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzX():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0919, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0352 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04dc A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0516 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x058f A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x05dc A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x05e9 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x05f6 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x062f A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0640 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0681 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x06c5 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0722 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0726 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x076c A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x07b4 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x07ce A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x085a A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x087a A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x090f A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x09ba A[Catch:{ SQLiteException -> 0x09d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x09d3  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x071c A[EDGE_INSN: B:317:0x071c->B:221:0x071c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x091b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0159 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016c A[SYNTHETIC, Splitter:B:46:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e7 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02ab A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f1 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02f4 A[Catch:{ NumberFormatException -> 0x070a, all -> 0x014b }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(com.google.android.gms.measurement.internal.zzaw r34, com.google.android.gms.measurement.internal.zzq r35) {
        /*
            r33 = this;
            r1 = r33
            r2 = r34
            r3 = r35
            java.lang.String r4 = "metadata_fingerprint"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r35)
            java.lang.String r8 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            long r8 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzfo r10 = r33.zzaz()
            r10.zzg()
            r33.zzB()
            java.lang.String r10 = r3.zza
            com.google.android.gms.measurement.internal.zzkv r11 = r1.zzi
            zzal(r11)
            boolean r11 = com.google.android.gms.measurement.internal.zzkv.zzA(r34, r35)
            if (r11 != 0) goto L_0x0032
            return
        L_0x0032:
            boolean r11 = r3.zzh
            if (r11 == 0) goto L_0x0a65
            com.google.android.gms.measurement.internal.zzfi r11 = r1.zzc
            zzal(r11)
            java.lang.String r12 = r2.zza
            boolean r11 = r11.zzr(r10, r12)
            java.lang.String r15 = "_err"
            r14 = 0
            if (r11 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzeh r3 = r33.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzk()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)
            com.google.android.gms.measurement.internal.zzfr r5 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zzd(r6)
            java.lang.String r6 = "Dropping blocked event. appId"
            r3.zzc(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzp(r10)
            if (r3 != 0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc
            zzal(r3)
            boolean r3 = r3.zzs(r10)
            if (r3 == 0) goto L_0x007a
            goto L_0x0097
        L_0x007a:
            java.lang.String r3 = r2.zza
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzlb r11 = r33.zzv()
            com.google.android.gms.measurement.internal.f4 r12 = r1.zzF
            java.lang.String r2 = r2.zza
            r17 = 0
            r14 = 11
            java.lang.String r15 = "_ev"
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)
            return
        L_0x0097:
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            com.google.android.gms.measurement.internal.c1 r2 = r2.D(r10)
            if (r2 == 0) goto L_0x00de
            long r3 = r2.V()
            long r5 = r2.M()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r33.zzav()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r33.zzg()
            com.google.android.gms.measurement.internal.zzdt r5 = com.google.android.gms.measurement.internal.zzdu.zzy
            java.lang.Object r5 = r5.zza(r14)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzeh r3 = r33.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzc()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzD(r2)
        L_0x00de:
            return
        L_0x00df:
            com.google.android.gms.measurement.internal.zzei r2 = com.google.android.gms.measurement.internal.zzei.zzb(r34)
            com.google.android.gms.measurement.internal.zzlb r11 = r33.zzv()
            com.google.android.gms.measurement.internal.zzag r12 = r33.zzg()
            int r12 = r12.zzd(r10)
            r11.zzM(r2, r12)
            com.google.android.gms.measurement.internal.zzaw r2 = r2.zza()
            com.google.android.gms.measurement.internal.zzeh r11 = r33.zzay()
            java.lang.String r11 = r11.zzq()
            r12 = 2
            boolean r11 = android.util.Log.isLoggable(r11, r12)
            if (r11 == 0) goto L_0x011c
            com.google.android.gms.measurement.internal.zzeh r11 = r33.zzay()
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzj()
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn
            com.google.android.gms.measurement.internal.zzec r12 = r12.zzj()
            java.lang.String r12 = r12.zzc(r2)
            java.lang.String r13 = "Logging event"
            r11.zzb(r13, r12)
        L_0x011c:
            com.google.android.gms.measurement.internal.f r11 = r1.zze
            zzal(r11)
            r11.zzw()
            r1.zzd(r3)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = "ecommerce_purchase"
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x014b }
            java.lang.String r12 = "refund"
            r28 = r8
            if (r11 != 0) goto L_0x0147
            java.lang.String r9 = "purchase"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x014b }
            if (r9 != 0) goto L_0x0147
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x014b }
            if (r9 == 0) goto L_0x0149
        L_0x0147:
            r9 = 1
            goto L_0x014f
        L_0x0149:
            r9 = 0
            goto L_0x014f
        L_0x014b:
            r0 = move-exception
            r2 = r0
            goto L_0x0a5c
        L_0x014f:
            java.lang.String r11 = "_iap"
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r11 = r11.equals(r13)     // Catch:{ all -> 0x014b }
            if (r11 != 0) goto L_0x0160
            if (r9 == 0) goto L_0x015d
            r9 = 1
            goto L_0x0160
        L_0x015d:
            r8 = r15
            goto L_0x02de
        L_0x0160:
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x014b }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.zzg(r13)     // Catch:{ all -> 0x014b }
            java.lang.String r13 = "value"
            if (r9 == 0) goto L_0x01d5
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x014b }
            java.lang.Double r9 = r9.zzd(r13)     // Catch:{ all -> 0x014b }
            double r16 = r9.doubleValue()     // Catch:{ all -> 0x014b }
            r18 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r18
            r20 = 0
            int r9 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r9 != 0) goto L_0x0193
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x014b }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x014b }
            r20 = r15
            long r14 = r9.longValue()     // Catch:{ all -> 0x014b }
            double r13 = (double) r14     // Catch:{ all -> 0x014b }
            double r16 = r13 * r18
            goto L_0x0195
        L_0x0193:
            r20 = r15
        L_0x0195:
            r13 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r9 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x01af
            r13 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r9 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r9 < 0) goto L_0x01af
            long r13 = java.lang.Math.round(r16)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x014b }
            if (r9 == 0) goto L_0x01e1
            long r13 = -r13
            goto L_0x01e1
        L_0x01af:
            com.google.android.gms.measurement.internal.zzeh r2 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            java.lang.Double r5 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x014b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            r2.zzC()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            return
        L_0x01d5:
            r20 = r15
            com.google.android.gms.measurement.internal.zzau r9 = r2.zzb     // Catch:{ all -> 0x014b }
            java.lang.Long r9 = r9.zze(r13)     // Catch:{ all -> 0x014b }
            long r13 = r9.longValue()     // Catch:{ all -> 0x014b }
        L_0x01e1:
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x014b }
            if (r9 != 0) goto L_0x02dc
            java.util.Locale r9 = java.util.Locale.US     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r11.toUpperCase(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = "[A-Z]{3}"
            boolean r11 = r9.matches(r11)     // Catch:{ all -> 0x014b }
            if (r11 == 0) goto L_0x02dc
            java.lang.String r11 = "_ltv_"
            java.lang.String r9 = r11.concat(r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r11 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r11)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.d4 r11 = r11.J(r10, r9)     // Catch:{ all -> 0x014b }
            if (r11 == 0) goto L_0x020c
            java.lang.Object r11 = r11.f7465e     // Catch:{ all -> 0x014b }
            boolean r12 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x014b }
            if (r12 != 0) goto L_0x0210
        L_0x020c:
            r15 = r20
            r8 = 0
            goto L_0x023d
        L_0x0210:
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x014b }
            long r11 = r11.longValue()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.d4 r18 = new com.google.android.gms.measurement.internal.d4     // Catch:{ all -> 0x014b }
            java.lang.String r15 = r2.zzc     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.util.Clock r16 = r33.zzav()     // Catch:{ all -> 0x014b }
            long r16 = r16.currentTimeMillis()     // Catch:{ all -> 0x014b }
            long r11 = r11 + r13
            java.lang.Long r19 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x014b }
            r11 = r18
            r12 = r10
            r14 = 0
            r13 = r15
            r8 = r14
            r15 = 0
            r14 = r9
            r8 = r15
            r9 = r20
            r15 = r16
            r17 = r19
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x014b }
            r8 = r9
        L_0x023a:
            r9 = r18
            goto L_0x02a0
        L_0x023d:
            com.google.android.gms.measurement.internal.f r11 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r11)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzag r12 = r33.zzg()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r8 = com.google.android.gms.measurement.internal.zzdu.zzD     // Catch:{ all -> 0x014b }
            int r8 = r12.zze(r10, r8)     // Catch:{ all -> 0x014b }
            int r8 = r8 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x014b }
            r11.zzg()     // Catch:{ all -> 0x014b }
            r11.zzW()     // Catch:{ all -> 0x014b }
            android.database.sqlite.SQLiteDatabase r12 = r11.zzh()     // Catch:{ SQLiteException -> 0x026e }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x026e }
            java.lang.String[] r8 = new java.lang.String[]{r10, r10, r8}     // Catch:{ SQLiteException -> 0x026e }
            r20 = r15
            java.lang.String r15 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r12.execSQL(r15, r8)     // Catch:{ SQLiteException -> 0x026b }
            goto L_0x0285
        L_0x026b:
            r0 = move-exception
        L_0x026c:
            r8 = r0
            goto L_0x0272
        L_0x026e:
            r0 = move-exception
            r20 = r15
            goto L_0x026c
        L_0x0272:
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzt     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r12 = "Error pruning currencies. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            r11.zzc(r12, r15, r8)     // Catch:{ all -> 0x014b }
        L_0x0285:
            com.google.android.gms.measurement.internal.d4 r18 = new com.google.android.gms.measurement.internal.d4     // Catch:{ all -> 0x014b }
            java.lang.String r8 = r2.zzc     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.util.Clock r11 = r33.zzav()     // Catch:{ all -> 0x014b }
            long r15 = r11.currentTimeMillis()     // Catch:{ all -> 0x014b }
            java.lang.Long r17 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x014b }
            r11 = r18
            r12 = r10
            r13 = r8
            r14 = r9
            r8 = r20
            r11.<init>(r12, r13, r14, r15, r17)     // Catch:{ all -> 0x014b }
            goto L_0x023a
        L_0x02a0:
            com.google.android.gms.measurement.internal.f r11 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r11)     // Catch:{ all -> 0x014b }
            boolean r11 = r11.k(r9)     // Catch:{ all -> 0x014b }
            if (r11 != 0) goto L_0x02de
            com.google.android.gms.measurement.internal.zzeh r11 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r12 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r14 = r1.zzn     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzec r14 = r14.zzj()     // Catch:{ all -> 0x014b }
            java.lang.String r15 = r9.f7463c     // Catch:{ all -> 0x014b }
            java.lang.String r14 = r14.zzf(r15)     // Catch:{ all -> 0x014b }
            java.lang.Object r9 = r9.f7465e     // Catch:{ all -> 0x014b }
            r11.zzd(r12, r13, r14, r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzlb r11 = r33.zzv()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f4 r12 = r1.zzF     // Catch:{ all -> 0x014b }
            r16 = 0
            r17 = 0
            r14 = 9
            r15 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x014b }
            goto L_0x02de
        L_0x02dc:
            r8 = r20
        L_0x02de:
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r9 = com.google.android.gms.measurement.internal.zzlb.zzai(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x014b }
            r33.zzv()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzau r11 = r2.zzb     // Catch:{ all -> 0x014b }
            if (r11 != 0) goto L_0x02f4
            r16 = 0
            goto L_0x0314
        L_0x02f4:
            com.google.android.gms.measurement.internal.j r12 = new com.google.android.gms.measurement.internal.j     // Catch:{ all -> 0x014b }
            r12.<init>(r11)     // Catch:{ all -> 0x014b }
            r16 = 0
        L_0x02fb:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x014b }
            if (r13 == 0) goto L_0x0314
            java.lang.String r13 = r12.next()     // Catch:{ all -> 0x014b }
            java.lang.Object r13 = r11.zzf(r13)     // Catch:{ all -> 0x014b }
            boolean r14 = r13 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x014b }
            if (r14 == 0) goto L_0x02fb
            android.os.Parcelable[] r13 = (android.os.Parcelable[]) r13     // Catch:{ all -> 0x014b }
            int r13 = r13.length     // Catch:{ all -> 0x014b }
            long r13 = (long) r13     // Catch:{ all -> 0x014b }
            long r16 = r16 + r13
            goto L_0x02fb
        L_0x0314:
            r22 = 1
            long r15 = r16 + r22
            com.google.android.gms.measurement.internal.f r11 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r11)     // Catch:{ all -> 0x014b }
            long r12 = r33.zza()     // Catch:{ all -> 0x014b }
            r20 = 0
            r21 = 0
            r17 = 1
            r31 = r4
            r32 = r5
            r4 = 0
            r14 = r10
            r18 = r9
            r19 = r20
            r20 = r8
            com.google.android.gms.measurement.internal.zzak r11 = r11.G(r12, r14, r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x014b }
            long r12 = r11.zzb     // Catch:{ all -> 0x014b }
            r33.zzg()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzj     // Catch:{ all -> 0x014b }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x014b }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x014b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x014b }
            long r14 = (long) r14     // Catch:{ all -> 0x014b }
            long r12 = r12 - r14
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            r15 = 1000(0x3e8, double:4.94E-321)
            if (r14 <= 0) goto L_0x037f
            long r12 = r12 % r15
            int r2 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x036e
            com.google.android.gms.measurement.internal.zzeh r2 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            long r5 = r11.zzb     // Catch:{ all -> 0x014b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x014b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x014b }
        L_0x036e:
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            r2.zzC()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            return
        L_0x037f:
            if (r9 == 0) goto L_0x03dc
            long r12 = r11.zza     // Catch:{ all -> 0x014b }
            r33.zzg()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r14 = com.google.android.gms.measurement.internal.zzdu.zzl     // Catch:{ all -> 0x014b }
            r15 = 0
            java.lang.Object r14 = r14.zza(r15)     // Catch:{ all -> 0x014b }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x014b }
            int r14 = r14.intValue()     // Catch:{ all -> 0x014b }
            long r14 = (long) r14     // Catch:{ all -> 0x014b }
            long r12 = r12 - r14
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 <= 0) goto L_0x03dc
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 % r14
            int r3 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r3 != 0) goto L_0x03b7
            com.google.android.gms.measurement.internal.zzeh r3 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            long r6 = r11.zza     // Catch:{ all -> 0x014b }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x014b }
            r3.zzc(r4, r5, r6)     // Catch:{ all -> 0x014b }
        L_0x03b7:
            com.google.android.gms.measurement.internal.zzlb r11 = r33.zzv()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f4 r12 = r1.zzF     // Catch:{ all -> 0x014b }
            java.lang.String r15 = "_ev"
            java.lang.String r2 = r2.zza     // Catch:{ all -> 0x014b }
            r17 = 0
            r14 = 16
            r13 = r10
            r16 = r2
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            r2.zzC()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            return
        L_0x03dc:
            r12 = 1000000(0xf4240, float:1.401298E-39)
            if (r8 == 0) goto L_0x042c
            long r13 = r11.zzd     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzag r8 = r33.zzg()     // Catch:{ all -> 0x014b }
            java.lang.String r15 = r3.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r4 = com.google.android.gms.measurement.internal.zzdu.zzk     // Catch:{ all -> 0x014b }
            int r4 = r8.zze(r15, r4)     // Catch:{ all -> 0x014b }
            int r4 = java.lang.Math.min(r12, r4)     // Catch:{ all -> 0x014b }
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)     // Catch:{ all -> 0x014b }
            long r4 = (long) r4     // Catch:{ all -> 0x014b }
            long r13 = r13 - r4
            r4 = 0
            int r8 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r8 <= 0) goto L_0x042c
            int r2 = (r13 > r22 ? 1 : (r13 == r22 ? 0 : -1))
            if (r2 != 0) goto L_0x041b
            com.google.android.gms.measurement.internal.zzeh r2 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            long r5 = r11.zzd     // Catch:{ all -> 0x014b }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x014b }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x014b }
        L_0x041b:
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            r2.zzC()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            return
        L_0x042c:
            com.google.android.gms.measurement.internal.zzau r4 = r2.zzb     // Catch:{ all -> 0x014b }
            android.os.Bundle r4 = r4.zzc()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzlb r5 = r33.zzv()     // Catch:{ all -> 0x014b }
            java.lang.String r8 = "_o"
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x014b }
            r5.zzO(r4, r8, r11)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzlb r5 = r33.zzv()     // Catch:{ all -> 0x014b }
            boolean r5 = r5.zzae(r10)     // Catch:{ all -> 0x014b }
            java.lang.String r8 = "_r"
            if (r5 == 0) goto L_0x045d
            com.google.android.gms.measurement.internal.zzlb r5 = r33.zzv()     // Catch:{ all -> 0x014b }
            java.lang.Long r11 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x014b }
            java.lang.String r13 = "_dbg"
            r5.zzO(r4, r13, r11)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzlb r5 = r33.zzv()     // Catch:{ all -> 0x014b }
            r5.zzO(r4, r8, r11)     // Catch:{ all -> 0x014b }
        L_0x045d:
            java.lang.String r5 = "_s"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x014b }
            boolean r5 = r5.equals(r11)     // Catch:{ all -> 0x014b }
            if (r5 == 0) goto L_0x0483
            com.google.android.gms.measurement.internal.f r5 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r5)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.d4 r5 = r5.J(r11, r7)     // Catch:{ all -> 0x014b }
            if (r5 == 0) goto L_0x0483
            java.lang.Object r11 = r5.f7465e     // Catch:{ all -> 0x014b }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x014b }
            if (r11 == 0) goto L_0x0483
            com.google.android.gms.measurement.internal.zzlb r11 = r33.zzv()     // Catch:{ all -> 0x014b }
            java.lang.Object r5 = r5.f7465e     // Catch:{ all -> 0x014b }
            r11.zzO(r4, r7, r5)     // Catch:{ all -> 0x014b }
        L_0x0483:
            com.google.android.gms.measurement.internal.f r5 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r5)     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)     // Catch:{ all -> 0x014b }
            r5.zzg()     // Catch:{ all -> 0x014b }
            r5.zzW()     // Catch:{ all -> 0x014b }
            android.database.sqlite.SQLiteDatabase r7 = r5.zzh()     // Catch:{ SQLiteException -> 0x04bf }
            com.google.android.gms.measurement.internal.zzfr r11 = r5.zzt     // Catch:{ SQLiteException -> 0x04bf }
            com.google.android.gms.measurement.internal.zzag r11 = r11.zzf()     // Catch:{ SQLiteException -> 0x04bf }
            com.google.android.gms.measurement.internal.zzdt r13 = com.google.android.gms.measurement.internal.zzdu.zzo     // Catch:{ SQLiteException -> 0x04bf }
            int r11 = r11.zze(r10, r13)     // Catch:{ SQLiteException -> 0x04bf }
            int r11 = java.lang.Math.min(r12, r11)     // Catch:{ SQLiteException -> 0x04bf }
            r15 = 0
            int r11 = java.lang.Math.max(r15, r11)     // Catch:{ SQLiteException -> 0x04bc }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x04bc }
            java.lang.String[] r11 = new java.lang.String[]{r10, r11}     // Catch:{ SQLiteException -> 0x04bc }
            java.lang.String r12 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            int r5 = r7.delete(r6, r12, r11)     // Catch:{ SQLiteException -> 0x04bc }
            long r11 = (long) r5
        L_0x04b9:
            r13 = 0
            goto L_0x04d8
        L_0x04bc:
            r0 = move-exception
        L_0x04bd:
            r7 = r0
            goto L_0x04c2
        L_0x04bf:
            r0 = move-exception
            r15 = 0
            goto L_0x04bd
        L_0x04c2:
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r11 = "Error deleting over the limit events. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            r5.zzc(r11, r12, r7)     // Catch:{ all -> 0x014b }
            r11 = 0
            goto L_0x04b9
        L_0x04d8:
            int r5 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x04f1
            com.google.android.gms.measurement.internal.zzeh r5 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzk()     // Catch:{ all -> 0x014b }
            java.lang.String r7 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x014b }
            r5.zzc(r7, r13, r11)     // Catch:{ all -> 0x014b }
        L_0x04f1:
            com.google.android.gms.measurement.internal.zzar r5 = new com.google.android.gms.measurement.internal.zzar     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzn     // Catch:{ all -> 0x014b }
            java.lang.String r13 = r2.zzc     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x014b }
            long r2 = r2.zzd     // Catch:{ all -> 0x014b }
            r18 = 0
            r11 = r5
            r14 = r10
            r30 = r15
            r15 = r7
            r16 = r2
            r20 = r4
            r11.<init>((com.google.android.gms.measurement.internal.zzfr) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (long) r16, (long) r18, (android.os.Bundle) r20)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            java.lang.String r3 = r5.zzb     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.i r2 = r2.H(r10, r3)     // Catch:{ all -> 0x014b }
            if (r2 != 0) goto L_0x058f
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            long r2 = r2.B(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzag r4 = r33.zzg()     // Catch:{ all -> 0x014b }
            int r4 = r4.zzb(r10)     // Catch:{ all -> 0x014b }
            long r11 = (long) r4     // Catch:{ all -> 0x014b }
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x0571
            if (r9 == 0) goto L_0x0571
            com.google.android.gms.measurement.internal.zzeh r2 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r6 = r1.zzn     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzec r6 = r6.zzj()     // Catch:{ all -> 0x014b }
            java.lang.String r5 = r5.zzb     // Catch:{ all -> 0x014b }
            java.lang.String r5 = r6.zzd(r5)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzag r6 = r33.zzg()     // Catch:{ all -> 0x014b }
            int r6 = r6.zzb(r10)     // Catch:{ all -> 0x014b }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x014b }
            r2.zzd(r3, r4, r5, r6)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzlb r11 = r33.zzv()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f4 r12 = r1.zzF     // Catch:{ all -> 0x014b }
            r16 = 0
            r17 = 0
            r14 = 8
            r15 = 0
            r13 = r10
            r11.zzN(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            return
        L_0x0571:
            com.google.android.gms.measurement.internal.i r2 = new com.google.android.gms.measurement.internal.i     // Catch:{ all -> 0x014b }
            java.lang.String r13 = r5.zzb     // Catch:{ all -> 0x014b }
            long r3 = r5.zzd     // Catch:{ all -> 0x014b }
            r26 = 0
            r27 = 0
            r14 = 0
            r16 = 0
            r18 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r11 = r2
            r12 = r10
            r20 = r3
            r11.<init>(r12, r13, r14, r16, r18, r20, r22, r24, r25, r26, r27)     // Catch:{ all -> 0x014b }
            goto L_0x059d
        L_0x058f:
            com.google.android.gms.measurement.internal.zzfr r3 = r1.zzn     // Catch:{ all -> 0x014b }
            long r9 = r2.f7542f     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzar r5 = r5.zza(r3, r9)     // Catch:{ all -> 0x014b }
            long r3 = r5.zzd     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.i r2 = r2.c(r3)     // Catch:{ all -> 0x014b }
        L_0x059d:
            com.google.android.gms.measurement.internal.f r3 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r3)     // Catch:{ all -> 0x014b }
            r3.d(r2)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfo r2 = r33.zzaz()     // Catch:{ all -> 0x014b }
            r2.zzg()     // Catch:{ all -> 0x014b }
            r33.zzB()     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r35)     // Catch:{ all -> 0x014b }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x014b }
            java.lang.String r2 = r5.zza     // Catch:{ all -> 0x014b }
            r3 = r35
            java.lang.String r4 = r3.zza     // Catch:{ all -> 0x014b }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x014b }
            com.google.android.gms.internal.measurement.zzgc r2 = com.google.android.gms.internal.measurement.zzgd.zzt()     // Catch:{ all -> 0x014b }
            r4 = 1
            r2.zzad(r4)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = "android"
            r2.zzZ(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x05e1
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x014b }
            r2.zzD(r7)     // Catch:{ all -> 0x014b }
        L_0x05e1:
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x05ee
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x014b }
            r2.zzF(r7)     // Catch:{ all -> 0x014b }
        L_0x05ee:
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x05fb
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x014b }
            r2.zzG(r7)     // Catch:{ all -> 0x014b }
        L_0x05fb:
            com.google.android.gms.internal.measurement.zzpd.zzc()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzag r7 = r33.zzg()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzal     // Catch:{ all -> 0x014b }
            r10 = 0
            boolean r7 = r7.zzs(r10, r9)     // Catch:{ all -> 0x014b }
            if (r7 == 0) goto L_0x0626
            com.google.android.gms.measurement.internal.zzag r7 = r33.zzg()     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzan     // Catch:{ all -> 0x014b }
            boolean r7 = r7.zzs(r9, r10)     // Catch:{ all -> 0x014b }
            if (r7 == 0) goto L_0x0626
            java.lang.String r7 = r3.zzx     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x0626
            java.lang.String r7 = r3.zzx     // Catch:{ all -> 0x014b }
            r2.zzah(r7)     // Catch:{ all -> 0x014b }
        L_0x0626:
            long r9 = r3.zzj     // Catch:{ all -> 0x014b }
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0633
            int r7 = (int) r9     // Catch:{ all -> 0x014b }
            r2.zzH(r7)     // Catch:{ all -> 0x014b }
        L_0x0633:
            long r9 = r3.zze     // Catch:{ all -> 0x014b }
            r2.zzV(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x0645
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x014b }
            r2.zzU(r7)     // Catch:{ all -> 0x014b }
        L_0x0645:
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x014b }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzai r9 = com.google.android.gms.measurement.internal.zzai.zzb(r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzc(r9)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r7.zzh()     // Catch:{ all -> 0x014b }
            r2.zzL(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r2.zzaq()     // Catch:{ all -> 0x014b }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x014b }
            if (r7 == 0) goto L_0x0679
            java.lang.String r7 = r3.zzq     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x0679
            java.lang.String r7 = r3.zzq     // Catch:{ all -> 0x014b }
            r2.zzC(r7)     // Catch:{ all -> 0x014b }
        L_0x0679:
            long r9 = r3.zzf     // Catch:{ all -> 0x014b }
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0684
            r2.zzM(r9)     // Catch:{ all -> 0x014b }
        L_0x0684:
            long r9 = r3.zzs     // Catch:{ all -> 0x014b }
            r2.zzP(r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzkv r7 = r1.zzi     // Catch:{ all -> 0x014b }
            zzal(r7)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzkt r9 = r7.zzf     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r9 = r9.zzn     // Catch:{ all -> 0x014b }
            android.content.Context r9 = r9.zzau()     // Catch:{ all -> 0x014b }
            java.util.Map r9 = com.google.android.gms.measurement.internal.zzdu.zzc(r9)     // Catch:{ all -> 0x014b }
            if (r9 == 0) goto L_0x06a2
            boolean r10 = r9.isEmpty()     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x06a5
        L_0x06a2:
            r14 = 0
            goto L_0x0724
        L_0x06a5:
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ all -> 0x014b }
            r14.<init>()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r10 = com.google.android.gms.measurement.internal.zzdu.zzO     // Catch:{ all -> 0x014b }
            r11 = 0
            java.lang.Object r10 = r10.zza(r11)     // Catch:{ all -> 0x014b }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x014b }
            int r10 = r10.intValue()     // Catch:{ all -> 0x014b }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x014b }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x014b }
        L_0x06bf:
            boolean r11 = r9.hasNext()     // Catch:{ all -> 0x014b }
            if (r11 == 0) goto L_0x071c
            java.lang.Object r11 = r9.next()     // Catch:{ all -> 0x014b }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x014b }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x014b }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x014b }
            java.lang.String r13 = "measurement.id."
            boolean r12 = r12.startsWith(r13)     // Catch:{ all -> 0x014b }
            if (r12 == 0) goto L_0x06bf
            java.lang.Object r11 = r11.getValue()     // Catch:{ NumberFormatException -> 0x070a }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x070a }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x070a }
            if (r11 == 0) goto L_0x06bf
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ NumberFormatException -> 0x070a }
            r14.add(r11)     // Catch:{ NumberFormatException -> 0x070a }
            int r11 = r14.size()     // Catch:{ NumberFormatException -> 0x070a }
            if (r11 < r10) goto L_0x06bf
            com.google.android.gms.measurement.internal.zzfr r11 = r7.zzt     // Catch:{ NumberFormatException -> 0x070a }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()     // Catch:{ NumberFormatException -> 0x070a }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzk()     // Catch:{ NumberFormatException -> 0x070a }
            java.lang.String r12 = "Too many experiment IDs. Number of IDs"
            int r13 = r14.size()     // Catch:{ NumberFormatException -> 0x070a }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ NumberFormatException -> 0x070a }
            r11.zzb(r12, r13)     // Catch:{ NumberFormatException -> 0x070a }
            goto L_0x071c
        L_0x070a:
            r0 = move-exception
            r11 = r0
            com.google.android.gms.measurement.internal.zzfr r12 = r7.zzt     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzk()     // Catch:{ all -> 0x014b }
            java.lang.String r13 = "Experiment ID NumberFormatException"
            r12.zzb(r13, r11)     // Catch:{ all -> 0x014b }
            goto L_0x06bf
        L_0x071c:
            boolean r7 = r14.isEmpty()     // Catch:{ all -> 0x014b }
            if (r7 == 0) goto L_0x0724
            goto L_0x06a2
        L_0x0724:
            if (r14 == 0) goto L_0x0729
            r2.zzh(r14)     // Catch:{ all -> 0x014b }
        L_0x0729:
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x014b }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzai r7 = r1.zzh(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r3.zzv     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzai r9 = com.google.android.gms.measurement.internal.zzai.zzb(r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzai r7 = r7.zzc(r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.AD_STORAGE     // Catch:{ all -> 0x014b }
            boolean r10 = r7.zzi(r9)     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x0775
            boolean r10 = r3.zzo     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x0775
            com.google.android.gms.measurement.internal.zzjo r10 = r1.zzk     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x014b }
            android.util.Pair r10 = r10.zzd(r11, r7)     // Catch:{ all -> 0x014b }
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x014b }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x014b }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x014b }
            if (r11 != 0) goto L_0x0775
            boolean r11 = r3.zzo     // Catch:{ all -> 0x014b }
            if (r11 == 0) goto L_0x0775
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x014b }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x014b }
            r2.zzae(r11)     // Catch:{ all -> 0x014b }
            java.lang.Object r10 = r10.second     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x0775
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x014b }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x014b }
            r2.zzX(r10)     // Catch:{ all -> 0x014b }
        L_0x0775:
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzaq r10 = r10.zzg()     // Catch:{ all -> 0x014b }
            r10.zzu()     // Catch:{ all -> 0x014b }
            java.lang.String r10 = android.os.Build.MODEL     // Catch:{ all -> 0x014b }
            r2.zzN(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzaq r10 = r10.zzg()     // Catch:{ all -> 0x014b }
            r10.zzu()     // Catch:{ all -> 0x014b }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x014b }
            r2.zzY(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzaq r10 = r10.zzg()     // Catch:{ all -> 0x014b }
            long r10 = r10.zzb()     // Catch:{ all -> 0x014b }
            int r10 = (int) r10     // Catch:{ all -> 0x014b }
            r2.zzaj(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzaq r10 = r10.zzg()     // Catch:{ all -> 0x014b }
            java.lang.String r10 = r10.zzc()     // Catch:{ all -> 0x014b }
            r2.zzan(r10)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r10 = r1.zzn     // Catch:{ all -> 0x014b }
            boolean r10 = r10.zzJ()     // Catch:{ all -> 0x014b }
            if (r10 == 0) goto L_0x07c1
            r2.zzap()     // Catch:{ all -> 0x014b }
            r10 = 0
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x014b }
            if (r11 != 0) goto L_0x07c1
            r2.zzO(r10)     // Catch:{ all -> 0x014b }
        L_0x07c1:
            com.google.android.gms.measurement.internal.f r10 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r10)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.c1 r10 = r10.D(r11)     // Catch:{ all -> 0x014b }
            if (r10 != 0) goto L_0x0831
            com.google.android.gms.measurement.internal.c1 r10 = new com.google.android.gms.measurement.internal.c1     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfr r11 = r1.zzn     // Catch:{ all -> 0x014b }
            java.lang.String r12 = r3.zza     // Catch:{ all -> 0x014b }
            r10.<init>(r11, r12)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r1.zzw(r7)     // Catch:{ all -> 0x014b }
            r10.h(r11)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r3.zzk     // Catch:{ all -> 0x014b }
            r10.v(r11)     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r3.zzb     // Catch:{ all -> 0x014b }
            r10.w(r11)     // Catch:{ all -> 0x014b }
            boolean r9 = r7.zzi(r9)     // Catch:{ all -> 0x014b }
            if (r9 == 0) goto L_0x07fb
            com.google.android.gms.measurement.internal.zzjo r9 = r1.zzk     // Catch:{ all -> 0x014b }
            java.lang.String r11 = r3.zza     // Catch:{ all -> 0x014b }
            boolean r12 = r3.zzo     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r9.zzf(r11, r12)     // Catch:{ all -> 0x014b }
            r10.F(r9)     // Catch:{ all -> 0x014b }
        L_0x07fb:
            r11 = 0
            r10.B(r11)     // Catch:{ all -> 0x014b }
            r10.C(r11)     // Catch:{ all -> 0x014b }
            r10.z(r11)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r3.zzc     // Catch:{ all -> 0x014b }
            r10.j(r9)     // Catch:{ all -> 0x014b }
            long r11 = r3.zzj     // Catch:{ all -> 0x014b }
            r10.k(r11)     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r3.zzd     // Catch:{ all -> 0x014b }
            r10.i(r9)     // Catch:{ all -> 0x014b }
            long r11 = r3.zze     // Catch:{ all -> 0x014b }
            r10.x(r11)     // Catch:{ all -> 0x014b }
            long r11 = r3.zzf     // Catch:{ all -> 0x014b }
            r10.s(r11)     // Catch:{ all -> 0x014b }
            boolean r9 = r3.zzh     // Catch:{ all -> 0x014b }
            r10.D(r9)     // Catch:{ all -> 0x014b }
            long r11 = r3.zzs     // Catch:{ all -> 0x014b }
            r10.t(r11)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r9 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r9)     // Catch:{ all -> 0x014b }
            r9.c(r10)     // Catch:{ all -> 0x014b }
        L_0x0831:
            com.google.android.gms.measurement.internal.zzah r9 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE     // Catch:{ all -> 0x014b }
            boolean r7 = r7.zzi(r9)     // Catch:{ all -> 0x014b }
            if (r7 == 0) goto L_0x0850
            java.lang.String r7 = r10.e0()     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x0850
            java.lang.String r7 = r10.e0()     // Catch:{ all -> 0x014b }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x014b }
            r2.zzE(r7)     // Catch:{ all -> 0x014b }
        L_0x0850:
            java.lang.String r7 = r10.h0()     // Catch:{ all -> 0x014b }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x014b }
            if (r7 != 0) goto L_0x0867
            java.lang.String r7 = r10.h0()     // Catch:{ all -> 0x014b }
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x014b }
            r2.zzT(r7)     // Catch:{ all -> 0x014b }
        L_0x0867:
            com.google.android.gms.measurement.internal.f r7 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r7)     // Catch:{ all -> 0x014b }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x014b }
            java.util.List r3 = r7.N(r3)     // Catch:{ all -> 0x014b }
            r13 = r30
        L_0x0874:
            int r7 = r3.size()     // Catch:{ all -> 0x014b }
            if (r13 >= r7) goto L_0x08aa
            com.google.android.gms.internal.measurement.zzgl r7 = com.google.android.gms.internal.measurement.zzgm.zzd()     // Catch:{ all -> 0x014b }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.d4 r9 = (com.google.android.gms.measurement.internal.d4) r9     // Catch:{ all -> 0x014b }
            java.lang.String r9 = r9.f7463c     // Catch:{ all -> 0x014b }
            r7.zzf(r9)     // Catch:{ all -> 0x014b }
            java.lang.Object r9 = r3.get(r13)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.d4 r9 = (com.google.android.gms.measurement.internal.d4) r9     // Catch:{ all -> 0x014b }
            long r9 = r9.f7464d     // Catch:{ all -> 0x014b }
            r7.zzg(r9)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzkv r9 = r1.zzi     // Catch:{ all -> 0x014b }
            zzal(r9)     // Catch:{ all -> 0x014b }
            java.lang.Object r10 = r3.get(r13)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.d4 r10 = (com.google.android.gms.measurement.internal.d4) r10     // Catch:{ all -> 0x014b }
            java.lang.Object r10 = r10.f7465e     // Catch:{ all -> 0x014b }
            r9.zzu(r7, r10)     // Catch:{ all -> 0x014b }
            r2.zzl(r7)     // Catch:{ all -> 0x014b }
            int r13 = r13 + 1
            goto L_0x0874
        L_0x08aa:
            com.google.android.gms.measurement.internal.f r3 = r1.zze     // Catch:{ IOException -> 0x09f4 }
            zzal(r3)     // Catch:{ IOException -> 0x09f4 }
            com.google.android.gms.internal.measurement.zzkf r7 = r2.zzaC()     // Catch:{ IOException -> 0x09f4 }
            com.google.android.gms.internal.measurement.zzgd r7 = (com.google.android.gms.internal.measurement.zzgd) r7     // Catch:{ IOException -> 0x09f4 }
            r3.zzg()     // Catch:{ IOException -> 0x09f4 }
            r3.zzW()     // Catch:{ IOException -> 0x09f4 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ IOException -> 0x09f4 }
            java.lang.String r9 = r7.zzx()     // Catch:{ IOException -> 0x09f4 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)     // Catch:{ IOException -> 0x09f4 }
            byte[] r9 = r7.zzbu()     // Catch:{ IOException -> 0x09f4 }
            com.google.android.gms.measurement.internal.zzkt r10 = r3.zzf     // Catch:{ IOException -> 0x09f4 }
            com.google.android.gms.measurement.internal.zzkv r10 = r10.zzi     // Catch:{ IOException -> 0x09f4 }
            zzal(r10)     // Catch:{ IOException -> 0x09f4 }
            long r10 = r10.zzd(r9)     // Catch:{ IOException -> 0x09f4 }
            android.content.ContentValues r12 = new android.content.ContentValues     // Catch:{ IOException -> 0x09f4 }
            r12.<init>()     // Catch:{ IOException -> 0x09f4 }
            java.lang.String r13 = r7.zzx()     // Catch:{ IOException -> 0x09f4 }
            r14 = r32
            r12.put(r14, r13)     // Catch:{ IOException -> 0x09f4 }
            java.lang.Long r13 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x09f4 }
            r15 = r31
            r12.put(r15, r13)     // Catch:{ IOException -> 0x09f4 }
            java.lang.String r13 = "metadata"
            r12.put(r13, r9)     // Catch:{ IOException -> 0x09f4 }
            android.database.sqlite.SQLiteDatabase r9 = r3.zzh()     // Catch:{ SQLiteException -> 0x09f8 }
            java.lang.String r13 = "raw_events_metadata"
            r4 = 4
            r16 = r2
            r2 = 0
            r9.insertWithOnConflict(r13, r2, r12, r4)     // Catch:{ SQLiteException -> 0x09f1 }
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzau r3 = r5.zzf     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.j r4 = new com.google.android.gms.measurement.internal.j     // Catch:{ all -> 0x014b }
            r4.<init>(r3)     // Catch:{ all -> 0x014b }
        L_0x0909:
            boolean r3 = r4.hasNext()     // Catch:{ all -> 0x014b }
            if (r3 == 0) goto L_0x091b
            java.lang.String r3 = r4.next()     // Catch:{ all -> 0x014b }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x014b }
            if (r3 == 0) goto L_0x0909
        L_0x0919:
            r13 = 1
            goto L_0x095d
        L_0x091b:
            com.google.android.gms.measurement.internal.zzfi r3 = r1.zzc     // Catch:{ all -> 0x014b }
            zzal(r3)     // Catch:{ all -> 0x014b }
            java.lang.String r4 = r5.zza     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r5.zzb     // Catch:{ all -> 0x014b }
            boolean r3 = r3.zzq(r4, r7)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r4 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r4)     // Catch:{ all -> 0x014b }
            long r17 = r33.zza()     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x014b }
            r23 = 0
            r24 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r16 = r4
            r19 = r7
            com.google.android.gms.measurement.internal.zzak r4 = r16.F(r17, r19, r20, r21, r22, r23, r24)     // Catch:{ all -> 0x014b }
            if (r3 == 0) goto L_0x095b
            long r3 = r4.zze     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzag r7 = r33.zzg()     // Catch:{ all -> 0x014b }
            java.lang.String r8 = r5.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzdt r9 = com.google.android.gms.measurement.internal.zzdu.zzn     // Catch:{ all -> 0x014b }
            int r7 = r7.zze(r8, r9)     // Catch:{ all -> 0x014b }
            long r7 = (long) r7     // Catch:{ all -> 0x014b }
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 >= 0) goto L_0x095b
            goto L_0x0919
        L_0x095b:
            r13 = r30
        L_0x095d:
            r2.zzg()     // Catch:{ all -> 0x014b }
            r2.zzW()     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x014b }
            java.lang.String r3 = r5.zza     // Catch:{ all -> 0x014b }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzkt r3 = r2.zzf     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzkv r3 = r3.zzi     // Catch:{ all -> 0x014b }
            zzal(r3)     // Catch:{ all -> 0x014b }
            com.google.android.gms.internal.measurement.zzft r3 = r3.zzj(r5)     // Catch:{ all -> 0x014b }
            byte[] r3 = r3.zzbu()     // Catch:{ all -> 0x014b }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x014b }
            r4.<init>()     // Catch:{ all -> 0x014b }
            java.lang.String r7 = r5.zza     // Catch:{ all -> 0x014b }
            r4.put(r14, r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = "name"
            java.lang.String r8 = r5.zzb     // Catch:{ all -> 0x014b }
            r4.put(r7, r8)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = "timestamp"
            long r8 = r5.zzd     // Catch:{ all -> 0x014b }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x014b }
            r4.put(r7, r8)     // Catch:{ all -> 0x014b }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x014b }
            r4.put(r15, r7)     // Catch:{ all -> 0x014b }
            java.lang.String r7 = "data"
            r4.put(r7, r3)     // Catch:{ all -> 0x014b }
            java.lang.String r3 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)     // Catch:{ all -> 0x014b }
            r4.put(r3, r7)     // Catch:{ all -> 0x014b }
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x09d0 }
            r7 = 0
            long r3 = r3.insert(r6, r7, r4)     // Catch:{ SQLiteException -> 0x09d0 }
            r6 = -1
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x09d3
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzt     // Catch:{ SQLiteException -> 0x09d0 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ SQLiteException -> 0x09d0 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ SQLiteException -> 0x09d0 }
            java.lang.String r4 = "Failed to insert raw event (got -1). appId"
            java.lang.String r6 = r5.zza     // Catch:{ SQLiteException -> 0x09d0 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)     // Catch:{ SQLiteException -> 0x09d0 }
            r3.zzb(r4, r6)     // Catch:{ SQLiteException -> 0x09d0 }
            goto L_0x0a29
        L_0x09d0:
            r0 = move-exception
            r3 = r0
            goto L_0x09d8
        L_0x09d3:
            r3 = 0
            r1.zza = r3     // Catch:{ all -> 0x014b }
            goto L_0x0a29
        L_0x09d8:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r4 = "Error storing raw event. appId"
            java.lang.String r5 = r5.zza     // Catch:{ all -> 0x014b }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x014b }
            r2.zzc(r4, r5, r3)     // Catch:{ all -> 0x014b }
            goto L_0x0a29
        L_0x09ee:
            r0 = move-exception
        L_0x09ef:
            r2 = r0
            goto L_0x0a14
        L_0x09f1:
            r0 = move-exception
        L_0x09f2:
            r2 = r0
            goto L_0x09fc
        L_0x09f4:
            r0 = move-exception
            r16 = r2
            goto L_0x09ef
        L_0x09f8:
            r0 = move-exception
            r16 = r2
            goto L_0x09f2
        L_0x09fc:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ IOException -> 0x09ee }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ IOException -> 0x09ee }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ IOException -> 0x09ee }
            java.lang.String r4 = "Error storing raw event metadata. appId"
            java.lang.String r5 = r7.zzx()     // Catch:{ IOException -> 0x09ee }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ IOException -> 0x09ee }
            r3.zzc(r4, r5, r2)     // Catch:{ IOException -> 0x09ee }
            throw r2     // Catch:{ IOException -> 0x09ee }
        L_0x0a14:
            com.google.android.gms.measurement.internal.zzeh r3 = r33.zzay()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x014b }
            java.lang.String r4 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r5 = r16.zzap()     // Catch:{ all -> 0x014b }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ all -> 0x014b }
            r3.zzc(r4, r5, r2)     // Catch:{ all -> 0x014b }
        L_0x0a29:
            com.google.android.gms.measurement.internal.f r2 = r1.zze     // Catch:{ all -> 0x014b }
            zzal(r2)     // Catch:{ all -> 0x014b }
            r2.zzC()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.f r2 = r1.zze
            zzal(r2)
            r2.P()
            r33.zzag()
            com.google.android.gms.measurement.internal.zzeh r2 = r33.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r28
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0a5c:
            com.google.android.gms.measurement.internal.f r3 = r1.zze
            zzal(r3)
            r3.P()
            throw r2
        L_0x0a65:
            r1.zzd(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkt.zzY(com.google.android.gms.measurement.internal.zzaw, com.google.android.gms.measurement.internal.zzq):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final boolean zzZ() {
        zzaz().zzg();
        FileLock fileLock = this.zzw;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzt.zzf();
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzn.zzau().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzx = channel;
                FileLock tryLock = channel.tryLock();
                this.zzw = tryLock;
                if (tryLock != null) {
                    zzay().zzj().zza("Storage concurrent access okay");
                    return true;
                }
                zzay().zzd().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e10) {
                zzay().zzd().zzb("Failed to acquire storage lock", e10);
                return false;
            } catch (IOException e11) {
                zzay().zzd().zzb("Failed to access storage lock file", e11);
                return false;
            } catch (OverlappingFileLockException e12) {
                zzay().zzk().zzb("Storage lock already acquired", e12);
                return false;
            }
        } else {
            zzay().zzj().zza("Storage concurrent access okay");
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        long currentTimeMillis = zzav().currentTimeMillis();
        zzjo zzjo = this.zzk;
        zzjo.zzW();
        zzjo.zzg();
        long zza2 = zzjo.zze.zza();
        if (zza2 == 0) {
            zza2 = ((long) zzjo.zzt.zzv().zzG().nextInt(86400000)) + 1;
            zzjo.zze.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    public final Context zzau() {
        return this.zzn.zzau();
    }

    public final Clock zzav() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzav();
    }

    public final zzab zzaw() {
        throw null;
    }

    public final zzeh zzay() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzay();
    }

    public final zzfo zzaz() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzaz();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final c1 zzd(zzq zzq2) {
        String str;
        zzaz().zzg();
        zzB();
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        if (!zzq2.zzw.isEmpty()) {
            this.zzC.put(zzq2.zza, new c4(this, zzq2.zzw));
        }
        f fVar = this.zze;
        zzal(fVar);
        c1 D = fVar.D(zzq2.zza);
        zzai zzc2 = zzh(zzq2.zza).zzc(zzai.zzb(zzq2.zzv));
        zzah zzah = zzah.AD_STORAGE;
        if (zzc2.zzi(zzah)) {
            str = this.zzk.zzf(zzq2.zza, zzq2.zzo);
        } else {
            str = "";
        }
        if (D == null) {
            D = new c1(this.zzn, zzq2.zza);
            if (zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
                D.h(zzw(zzc2));
            }
            if (zzc2.zzi(zzah)) {
                D.F(str);
            }
        } else if (zzc2.zzi(zzah) && str != null && !str.equals(D.a())) {
            D.F(str);
            if (zzq2.zzo && !"00000000-0000-0000-0000-000000000000".equals(this.zzk.zzd(zzq2.zza, zzc2).first)) {
                D.h(zzw(zzc2));
                f fVar2 = this.zze;
                zzal(fVar2);
                if (fVar2.J(zzq2.zza, "_id") != null) {
                    f fVar3 = this.zze;
                    zzal(fVar3);
                    if (fVar3.J(zzq2.zza, "_lair") == null) {
                        d4 d4Var = new d4(zzq2.zza, "auto", "_lair", zzav().currentTimeMillis(), 1L);
                        f fVar4 = this.zze;
                        zzal(fVar4);
                        fVar4.k(d4Var);
                    }
                }
            }
        } else if (TextUtils.isEmpty(D.e0()) && zzc2.zzi(zzah.ANALYTICS_STORAGE)) {
            D.h(zzw(zzc2));
        }
        D.w(zzq2.zzb);
        D.f(zzq2.zzq);
        if (!TextUtils.isEmpty(zzq2.zzk)) {
            D.v(zzq2.zzk);
        }
        long j10 = zzq2.zze;
        if (j10 != 0) {
            D.x(j10);
        }
        if (!TextUtils.isEmpty(zzq2.zzc)) {
            D.j(zzq2.zzc);
        }
        D.k(zzq2.zzj);
        String str2 = zzq2.zzd;
        if (str2 != null) {
            D.i(str2);
        }
        D.s(zzq2.zzf);
        D.D(zzq2.zzh);
        if (!TextUtils.isEmpty(zzq2.zzg)) {
            D.y(zzq2.zzg);
        }
        D.g(zzq2.zzo);
        D.E(zzq2.zzr);
        D.t(zzq2.zzs);
        zzpd.zzc();
        if (zzg().zzs((String) null, zzdu.zzal) && zzg().zzs(zzq2.zza, zzdu.zzan)) {
            D.H(zzq2.zzx);
        }
        zznt.zzc();
        if (zzg().zzs((String) null, zzdu.zzaj)) {
            D.G(zzq2.zzt);
        } else {
            zznt.zzc();
            if (zzg().zzs((String) null, zzdu.zzai)) {
                D.G((List) null);
            }
        }
        if (D.K()) {
            f fVar5 = this.zze;
            zzal(fVar5);
            fVar5.c(D);
        }
        return D;
    }

    public final b zzf() {
        b bVar = this.zzh;
        zzal(bVar);
        return bVar;
    }

    public final zzag zzg() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzf();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzai zzh(String str) {
        String str2;
        zzai zzai = zzai.zza;
        zzaz().zzg();
        zzB();
        zzai zzai2 = (zzai) this.zzB.get(str);
        if (zzai2 != null) {
            return zzai2;
        }
        f fVar = this.zze;
        zzal(fVar);
        Preconditions.checkNotNull(str);
        fVar.zzg();
        fVar.zzW();
        Cursor cursor = null;
        try {
            Cursor rawQuery = fVar.zzh().rawQuery("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str});
            if (rawQuery.moveToFirst()) {
                str2 = rawQuery.getString(0);
                rawQuery.close();
            } else {
                rawQuery.close();
                str2 = "G1";
            }
            zzai zzb2 = zzai.zzb(str2);
            zzV(str, zzb2);
            return zzb2;
        } catch (SQLiteException e10) {
            fVar.zzt.zzay().zzd().zzc("Database error", "select consent_state from consent_settings where app_id=? limit 1;", e10);
            throw e10;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final f zzi() {
        f fVar = this.zze;
        zzal(fVar);
        return fVar;
    }

    public final zzec zzj() {
        return this.zzn.zzj();
    }

    public final zzen zzl() {
        zzen zzen = this.zzd;
        zzal(zzen);
        return zzen;
    }

    public final w zzm() {
        w wVar = this.zzf;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzfi zzo() {
        zzfi zzfi = this.zzc;
        zzal(zzfi);
        return zzfi;
    }

    /* access modifiers changed from: package-private */
    public final zzfr zzq() {
        return this.zzn;
    }

    public final b2 zzr() {
        b2 b2Var = this.zzj;
        zzal(b2Var);
        return b2Var;
    }

    public final zzjo zzs() {
        return this.zzk;
    }

    public final zzkv zzu() {
        zzkv zzkv = this.zzi;
        zzal(zzkv);
        return zzkv;
    }

    public final zzlb zzv() {
        return ((zzfr) Preconditions.checkNotNull(this.zzn)).zzv();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzw(zzai zzai) {
        if (!zzai.zzi(zzah.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzv().zzG().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final String zzx(zzq zzq2) {
        try {
            return (String) zzaz().zzh(new y3(this, zzq2)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e10) {
            zzay().zzd().zzc("Failed to get app instance id. appId", zzeh.zzn(zzq2.zza), e10);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzz(Runnable runnable) {
        zzaz().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }
}
