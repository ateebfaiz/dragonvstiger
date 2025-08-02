package com.google.android.gms.measurement.internal;

import android.net.Uri;

final class x1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f7790a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Uri f7791b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f7792c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f7793d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ y1 f7794e;

    x1(y1 y1Var, boolean z10, Uri uri, String str, String str2) {
        this.f7794e = y1Var;
        this.f7790a = z10;
        this.f7791b = uri;
        this.f7792c = str;
        this.f7793d = str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[SYNTHETIC, Splitter:B:29:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d1 A[Catch:{ RuntimeException -> 0x006d }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d3 A[Catch:{ RuntimeException -> 0x006d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r17 = this;
            r1 = r17
            r0 = 1
            com.google.android.gms.measurement.internal.y1 r2 = r1.f7794e
            boolean r3 = r1.f7790a
            android.net.Uri r4 = r1.f7791b
            java.lang.String r5 = r1.f7792c
            java.lang.String r6 = r1.f7793d
            com.google.android.gms.measurement.internal.zzhx r7 = r2.f7804a
            r7.zzg()
            com.google.android.gms.measurement.internal.zzhx r7 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzlb r7 = r7.zzv()     // Catch:{ RuntimeException -> 0x006d }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ RuntimeException -> 0x006d }
            java.lang.String r9 = "_cis"
            java.lang.String r10 = "Activity created with data 'referrer' without required params"
            java.lang.String r11 = "utm_medium"
            java.lang.String r12 = "utm_source"
            java.lang.String r13 = "utm_campaign"
            r14 = 0
            java.lang.String r15 = "gclid"
            if (r8 == 0) goto L_0x002f
        L_0x002d:
            r7 = r14
            goto L_0x0085
        L_0x002f:
            boolean r8 = r6.contains(r15)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            boolean r8 = r6.contains(r13)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            boolean r8 = r6.contains(r12)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            boolean r8 = r6.contains(r11)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            java.lang.String r8 = "utm_id"
            boolean r8 = r6.contains(r8)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            java.lang.String r8 = "dclid"
            boolean r8 = r6.contains(r8)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            java.lang.String r8 = "srsltid"
            boolean r8 = r6.contains(r8)     // Catch:{ RuntimeException -> 0x006d }
            if (r8 != 0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzc()     // Catch:{ RuntimeException -> 0x006d }
            r7.zza(r10)     // Catch:{ RuntimeException -> 0x006d }
            goto L_0x002d
        L_0x006d:
            r0 = move-exception
            goto L_0x0164
        L_0x0070:
            java.lang.String r8 = "https://google.com/search?"
            java.lang.String r8 = r8.concat(r6)     // Catch:{ RuntimeException -> 0x006d }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ RuntimeException -> 0x006d }
            android.os.Bundle r7 = r7.zzs(r8)     // Catch:{ RuntimeException -> 0x006d }
            if (r7 == 0) goto L_0x0085
            java.lang.String r8 = "referrer"
            r7.putString(r9, r8)     // Catch:{ RuntimeException -> 0x006d }
        L_0x0085:
            java.lang.String r8 = "_cmp"
            if (r3 == 0) goto L_0x00cb
            com.google.android.gms.measurement.internal.zzhx r3 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzlb r3 = r3.zzv()     // Catch:{ RuntimeException -> 0x006d }
            android.os.Bundle r3 = r3.zzs(r4)     // Catch:{ RuntimeException -> 0x006d }
            if (r3 == 0) goto L_0x00cb
            java.lang.String r4 = "intent"
            r3.putString(r9, r4)     // Catch:{ RuntimeException -> 0x006d }
            boolean r4 = r3.containsKey(r15)     // Catch:{ RuntimeException -> 0x006d }
            if (r4 != 0) goto L_0x00bf
            if (r7 == 0) goto L_0x00bf
            boolean r4 = r7.containsKey(r15)     // Catch:{ RuntimeException -> 0x006d }
            if (r4 == 0) goto L_0x00bf
            java.lang.String r4 = r7.getString(r15)     // Catch:{ RuntimeException -> 0x006d }
            java.lang.Object[] r9 = new java.lang.Object[r0]     // Catch:{ RuntimeException -> 0x006d }
            r16 = 0
            r9[r16] = r4     // Catch:{ RuntimeException -> 0x006d }
            java.lang.String r4 = "_cer"
            java.lang.String r0 = "gclid=%s"
            java.lang.String r0 = java.lang.String.format(r0, r9)     // Catch:{ RuntimeException -> 0x006d }
            r3.putString(r4, r0)     // Catch:{ RuntimeException -> 0x006d }
        L_0x00bf:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            r0.zzG(r5, r8, r3)     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb     // Catch:{ RuntimeException -> 0x006d }
            r0.zza(r5, r3)     // Catch:{ RuntimeException -> 0x006d }
        L_0x00cb:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 == 0) goto L_0x00d3
            goto L_0x0153
        L_0x00d3:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x006d }
            java.lang.String r3 = "Activity created with referrer"
            r0.zzb(r3, r6)     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzY     // Catch:{ RuntimeException -> 0x006d }
            boolean r0 = r0.zzs(r14, r3)     // Catch:{ RuntimeException -> 0x006d }
            java.lang.String r3 = "_ldl"
            java.lang.String r4 = "auto"
            if (r0 == 0) goto L_0x011f
            if (r7 == 0) goto L_0x0107
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            r0.zzG(r5, r8, r7)     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb     // Catch:{ RuntimeException -> 0x006d }
            r0.zza(r5, r7)     // Catch:{ RuntimeException -> 0x006d }
            goto L_0x0118
        L_0x0107:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x006d }
            java.lang.String r5 = "Referrer does not contain valid parameters"
            r0.zzb(r5, r6)     // Catch:{ RuntimeException -> 0x006d }
        L_0x0118:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            r5 = 1
            r0.zzW(r4, r3, r14, r5)     // Catch:{ RuntimeException -> 0x006d }
            return
        L_0x011f:
            boolean r0 = r6.contains(r15)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 == 0) goto L_0x0154
            boolean r0 = r6.contains(r13)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 != 0) goto L_0x0147
            boolean r0 = r6.contains(r12)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 != 0) goto L_0x0147
            boolean r0 = r6.contains(r11)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 != 0) goto L_0x0147
            java.lang.String r0 = "utm_term"
            boolean r0 = r6.contains(r0)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 != 0) goto L_0x0147
            java.lang.String r0 = "utm_content"
            boolean r0 = r6.contains(r0)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 == 0) goto L_0x0154
        L_0x0147:
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ RuntimeException -> 0x006d }
            if (r0 != 0) goto L_0x0153
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            r5 = 1
            r0.zzW(r4, r3, r6, r5)     // Catch:{ RuntimeException -> 0x006d }
        L_0x0153:
            return
        L_0x0154:
            com.google.android.gms.measurement.internal.zzhx r0 = r2.f7804a     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ RuntimeException -> 0x006d }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzc()     // Catch:{ RuntimeException -> 0x006d }
            r0.zza(r10)     // Catch:{ RuntimeException -> 0x006d }
            return
        L_0x0164:
            com.google.android.gms.measurement.internal.zzhx r2 = r2.f7804a
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.zzb(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.x1.run():void");
    }
}
