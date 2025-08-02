package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzcf;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzjm extends z {
    /* access modifiers changed from: private */
    public final zzjl zza;
    /* access modifiers changed from: private */
    public zzdx zzb;
    private volatile Boolean zzc;
    private final h zzd;
    private final r3 zze;
    private final List zzf = new ArrayList();
    private final h zzg;

    protected zzjm(zzfr zzfr) {
        super(zzfr);
        this.zze = new r3(zzfr.zzav());
        this.zza = new zzjl(this);
        this.zzd = new r2(this, zzfr);
        this.zzg = new t2(this, zzfr);
    }

    @WorkerThread
    private final zzq zzO(boolean z10) {
        Pair zza2;
        this.zzt.zzaw();
        zzdy zzh = this.zzt.zzh();
        String str = null;
        if (z10) {
            zzeh zzay = this.zzt.zzay();
            if (!(zzay.zzt.zzm().f7769b == null || (zza2 = zzay.zzt.zzm().f7769b.zza()) == null || zza2 == x.f7767w)) {
                str = String.valueOf(zza2.second) + ":" + ((String) zza2.first);
            }
        }
        return zzh.zzj(str);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzP() {
        zzg();
        this.zzt.zzay().zzj().zzb("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (RuntimeException e10) {
                this.zzt.zzay().zzd().zzb("Task exception while flushing queue", e10);
            }
        }
        this.zzf.clear();
        this.zzg.b();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzQ() {
        zzg();
        this.zze.b();
        h hVar = this.zzd;
        this.zzt.zzf();
        hVar.d(((Long) zzdu.zzI.zza((Object) null)).longValue());
    }

    @WorkerThread
    private final void zzR(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzL()) {
            runnable.run();
            return;
        }
        int size = this.zzf.size();
        this.zzt.zzf();
        if (((long) size) >= 1000) {
            this.zzt.zzay().zzd().zza("Discarding data. Max runnable queue size reached");
            return;
        }
        this.zzf.add(runnable);
        this.zzg.d(60000);
        zzr();
    }

    private final boolean zzS() {
        this.zzt.zzaw();
        return true;
    }

    static /* bridge */ /* synthetic */ void zzo(zzjm zzjm, ComponentName componentName) {
        zzjm.zzg();
        if (zzjm.zzb != null) {
            zzjm.zzb = null;
            zzjm.zzt.zzay().zzj().zzb("Disconnected from device MeasurementService", componentName);
            zzjm.zzg();
            zzjm.zzr();
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzA(zzaw zzaw, String str) {
        Preconditions.checkNotNull(zzaw);
        zzg();
        zza();
        zzS();
        zzR(new x2(this, true, zzO(true), this.zzt.zzi().zzo(zzaw), zzaw, str));
    }

    @WorkerThread
    public final void zzB(zzcf zzcf, zzaw zzaw, String str) {
        zzg();
        zza();
        if (this.zzt.zzv().zzo(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            this.zzt.zzay().zzk().zza("Not bundling data. Service unavailable or out of date");
            this.zzt.zzv().zzS(zzcf, new byte[0]);
            return;
        }
        zzR(new s2(this, zzaw, str, zzcf));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzC() {
        zzg();
        zza();
        zzq zzO = zzO(false);
        zzS();
        this.zzt.zzi().zzj();
        zzR(new l2(this, zzO));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzD(zzdx zzdx, AbstractSafeParcelable abstractSafeParcelable, zzq zzq) {
        int i10;
        zzg();
        zza();
        zzS();
        this.zzt.zzf();
        int i11 = 100;
        int i12 = 0;
        while (i12 < 1001 && i11 == 100) {
            ArrayList arrayList = new ArrayList();
            List zzi = this.zzt.zzi().zzi(100);
            if (zzi != null) {
                arrayList.addAll(zzi);
                i10 = zzi.size();
            } else {
                i10 = 0;
            }
            if (abstractSafeParcelable != null && i10 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            int size = arrayList.size();
            for (int i13 = 0; i13 < size; i13++) {
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) arrayList.get(i13);
                if (abstractSafeParcelable2 instanceof zzaw) {
                    try {
                        zzdx.zzk((zzaw) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e10) {
                        this.zzt.zzay().zzd().zzb("Failed to send event to the service", e10);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkw) {
                    try {
                        zzdx.zzt((zzkw) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e11) {
                        this.zzt.zzay().zzd().zzb("Failed to send user property to the service", e11);
                    }
                } else if (abstractSafeParcelable2 instanceof zzac) {
                    try {
                        zzdx.zzn((zzac) abstractSafeParcelable2, zzq);
                    } catch (RemoteException e12) {
                        this.zzt.zzay().zzd().zzb("Failed to send conditional user property to the service", e12);
                    }
                } else {
                    this.zzt.zzay().zzd().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i12++;
            i11 = i10;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzE(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        zzg();
        zza();
        this.zzt.zzaw();
        zzR(new y2(this, true, zzO(true), this.zzt.zzi().zzn(zzac), new zzac(zzac), zzac));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzF(boolean z10) {
        zzg();
        zza();
        if (z10) {
            zzS();
            this.zzt.zzi().zzj();
        }
        if (zzM()) {
            zzR(new w2(this, zzO(false)));
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzG(zzie zzie) {
        zzg();
        zza();
        zzR(new p2(this, zzie));
    }

    @WorkerThread
    public final void zzH(Bundle bundle) {
        zzg();
        zza();
        zzR(new q2(this, zzO(false), bundle));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzI() {
        zzg();
        zza();
        zzR(new u2(this, zzO(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zzJ(zzdx zzdx) {
        zzg();
        Preconditions.checkNotNull(zzdx);
        this.zzb = zzdx;
        zzQ();
        zzP();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzK(zzkw zzkw) {
        zzg();
        zza();
        zzS();
        zzR(new j2(this, zzO(true), this.zzt.zzi().zzp(zzkw), zzkw));
    }

    @WorkerThread
    public final boolean zzL() {
        zzg();
        zza();
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzM() {
        zzg();
        zza();
        if (!zzN() || this.zzt.zzv().zzm() >= ((Integer) zzdu.zzaf.zza((Object) null)).intValue()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012c  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzN() {
        /*
            r7 = this;
            r7.zzg()
            r7.zza()
            java.lang.Boolean r0 = r7.zzc
            if (r0 != 0) goto L_0x014c
            r7.zzg()
            r7.zza()
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.x r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r1 = r0.a()
            java.lang.String r2 = "use_service"
            boolean r1 = r1.contains(r2)
            r3 = 0
            if (r1 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r0 = r0.a()
            boolean r0 = r0.getBoolean(r2, r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x0034:
            r1 = 1
            if (r0 == 0) goto L_0x003f
            boolean r4 = r0.booleanValue()
            if (r4 == 0) goto L_0x003f
            goto L_0x0146
        L_0x003f:
            com.google.android.gms.measurement.internal.zzfr r4 = r7.zzt
            r4.zzaw()
            com.google.android.gms.measurement.internal.zzfr r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzdy r4 = r4.zzh()
            int r4 = r4.zzh()
            if (r4 != r1) goto L_0x0053
        L_0x0050:
            r3 = r1
            goto L_0x010e
        L_0x0053:
            com.google.android.gms.measurement.internal.zzfr r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzj()
            java.lang.String r5 = "Checking service availability"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzfr r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzlb r4 = r4.zzv()
            r5 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r4 = r4.zzo(r5)
            if (r4 == 0) goto L_0x00fd
            if (r4 == r1) goto L_0x00ed
            r5 = 2
            if (r4 == r5) goto L_0x00c7
            r0 = 3
            if (r4 == r0) goto L_0x00b7
            r0 = 9
            if (r4 == r0) goto L_0x00a7
            r0 = 18
            if (r4 == r0) goto L_0x0097
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r4 = "Unexpected service status"
            r0.zzb(r4, r1)
        L_0x0094:
            r1 = r3
            goto L_0x010e
        L_0x0097:
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r3 = "Service updating"
            r0.zza(r3)
            goto L_0x0050
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x0094
        L_0x00b7:
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
            goto L_0x0094
        L_0x00c7:
            com.google.android.gms.measurement.internal.zzfr r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzc()
            java.lang.String r5 = "Service container out of date"
            r4.zza(r5)
            com.google.android.gms.measurement.internal.zzfr r4 = r7.zzt
            com.google.android.gms.measurement.internal.zzlb r4 = r4.zzv()
            int r4 = r4.zzm()
            r5 = 17443(0x4423, float:2.4443E-41)
            if (r4 >= r5) goto L_0x00e5
            goto L_0x010e
        L_0x00e5:
            if (r0 != 0) goto L_0x00e8
            goto L_0x00e9
        L_0x00e8:
            r1 = r3
        L_0x00e9:
            r6 = r3
            r3 = r1
            r1 = r6
            goto L_0x010e
        L_0x00ed:
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            java.lang.String r4 = "Service missing"
            r0.zza(r4)
            goto L_0x010e
        L_0x00fd:
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            java.lang.String r3 = "Service available"
            r0.zza(r3)
            goto L_0x0050
        L_0x010e:
            if (r3 != 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            boolean r0 = r0.zzx()
            if (r0 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r1)
            goto L_0x0145
        L_0x012c:
            if (r1 == 0) goto L_0x0145
            com.google.android.gms.measurement.internal.zzfr r0 = r7.zzt
            com.google.android.gms.measurement.internal.x r0 = r0.zzm()
            r0.zzg()
            android.content.SharedPreferences r0 = r0.a()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r2, r3)
            r0.apply()
        L_0x0145:
            r1 = r3
        L_0x0146:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r7.zzc = r0
        L_0x014c:
            java.lang.Boolean r0 = r7.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjm.zzN():boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzj() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzq() {
        zzg();
        zza();
        zzq zzO = zzO(true);
        this.zzt.zzi().zzk();
        zzR(new o2(this, zzO));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzr() {
        zzg();
        zza();
        if (!zzL()) {
            if (zzN()) {
                this.zza.zzc();
            } else if (!this.zzt.zzf().zzx()) {
                this.zzt.zzaw();
                List<ResolveInfo> queryIntentServices = this.zzt.zzau().getPackageManager().queryIntentServices(new Intent().setClassName(this.zzt.zzau(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                    this.zzt.zzay().zzd().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                    return;
                }
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                Context zzau = this.zzt.zzau();
                this.zzt.zzaw();
                intent.setComponent(new ComponentName(zzau, "com.google.android.gms.measurement.AppMeasurementService"));
                this.zza.zzb(intent);
            }
        }
    }

    @WorkerThread
    public final void zzs() {
        zzg();
        zza();
        this.zza.zzd();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzt.zzau(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    @WorkerThread
    public final void zzt(zzcf zzcf) {
        zzg();
        zza();
        zzR(new n2(this, zzO(false), zzcf));
    }

    @WorkerThread
    public final void zzu(AtomicReference atomicReference) {
        zzg();
        zza();
        zzR(new m2(this, atomicReference, zzO(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzv(zzcf zzcf, String str, String str2) {
        zzg();
        zza();
        zzR(new a3(this, str, str2, zzO(false), zzcf));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzw(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zza();
        zzR(new z2(this, atomicReference, (String) null, str2, str3, zzO(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzx(AtomicReference atomicReference, boolean z10) {
        zzg();
        zza();
        zzR(new k2(this, atomicReference, zzO(false), z10));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzy(zzcf zzcf, String str, String str2, boolean z10) {
        zzg();
        zza();
        zzR(new i2(this, str, str2, zzO(false), z10, zzcf));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzz(AtomicReference atomicReference, String str, String str2, String str3, boolean z10) {
        zzg();
        zza();
        zzR(new b3(this, atomicReference, (String) null, str2, str3, zzO(false), z10));
    }
}
