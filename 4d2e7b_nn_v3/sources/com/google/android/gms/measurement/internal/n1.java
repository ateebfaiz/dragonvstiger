package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

final class n1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzcf f7639a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzhx f7640b;

    n1(zzhx zzhx, zzcf zzcf) {
        this.f7640b = zzhx;
        this.f7639a = zzcf;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x009b A[SYNTHETIC, Splitter:B:15:0x009b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzhx r0 = r6.f7640b
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzkc r0 = r0.zzu()
            com.google.android.gms.internal.measurement.zzpa.zzc()
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzau
            r3 = 0
            boolean r1 = r1.zzs(r3, r2)
            if (r1 == 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzt
            com.google.android.gms.measurement.internal.x r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzai r1 = r1.c()
            com.google.android.gms.measurement.internal.zzah r2 = com.google.android.gms.measurement.internal.zzah.ANALYTICS_STORAGE
            boolean r1 = r1.zzi(r2)
            if (r1 != 0) goto L_0x003d
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzl()
            java.lang.String r1 = "Analytics storage consent denied; will not get session id"
            r0.zza(r1)
        L_0x003b:
            r0 = r3
            goto L_0x0087
        L_0x003d:
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzt
            com.google.android.gms.measurement.internal.x r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzfr r2 = r0.zzt
            com.google.android.gms.common.util.Clock r2 = r2.zzav()
            long r4 = r2.currentTimeMillis()
            boolean r1 = r1.h(r4)
            if (r1 != 0) goto L_0x003b
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzt
            com.google.android.gms.measurement.internal.x r1 = r1.zzm()
            com.google.android.gms.measurement.internal.zzes r1 = r1.f7781n
            long r1 = r1.zza()
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0066
            goto L_0x003b
        L_0x0066:
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.measurement.internal.x r0 = r0.zzm()
            com.google.android.gms.measurement.internal.zzes r0 = r0.f7781n
            long r0 = r0.zza()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x0087
        L_0x0077:
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzl()
            java.lang.String r1 = "getSessionId has been disabled."
            r0.zza(r1)
            goto L_0x003b
        L_0x0087:
            if (r0 == 0) goto L_0x009b
            com.google.android.gms.measurement.internal.zzhx r1 = r6.f7640b
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzlb r1 = r1.zzv()
            com.google.android.gms.internal.measurement.zzcf r2 = r6.f7639a
            long r3 = r0.longValue()
            r1.zzU(r2, r3)
            return
        L_0x009b:
            com.google.android.gms.internal.measurement.zzcf r0 = r6.f7639a     // Catch:{ RemoteException -> 0x00a1 }
            r0.zze(r3)     // Catch:{ RemoteException -> 0x00a1 }
            return
        L_0x00a1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzhx r1 = r6.f7640b
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzd()
            java.lang.String r2 = "getSessionId failed with exception"
            r1.zzb(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.n1.run():void");
    }
}
