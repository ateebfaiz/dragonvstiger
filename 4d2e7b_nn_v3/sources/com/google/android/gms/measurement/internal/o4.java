package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzet;

final class o4 extends n4 {

    /* renamed from: g  reason: collision with root package name */
    private final zzet f7662g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ b f7663h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    o4(b bVar, String str, int i10, zzet zzet) {
        super(str, i10);
        this.f7663h = bVar;
        this.f7662g = zzet;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f7662g.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r2v18, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r11, java.lang.Long r12, com.google.android.gms.internal.measurement.zzgm r13, boolean r14) {
        /*
            r10 = this;
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.b r0 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r1 = r10.f7645a
            com.google.android.gms.measurement.internal.zzdt r2 = com.google.android.gms.measurement.internal.zzdu.zzU
            boolean r0 = r0.zzs(r1, r2)
            com.google.android.gms.internal.measurement.zzet r1 = r10.f7662g
            boolean r1 = r1.zzg()
            com.google.android.gms.internal.measurement.zzet r2 = r10.f7662g
            boolean r2 = r2.zzh()
            com.google.android.gms.internal.measurement.zzet r3 = r10.f7662g
            boolean r3 = r3.zzi()
            r4 = 0
            r5 = 1
            if (r1 != 0) goto L_0x002d
            if (r2 != 0) goto L_0x002d
            if (r3 == 0) goto L_0x002f
        L_0x002d:
            r1 = r5
            goto L_0x0030
        L_0x002f:
            r1 = r4
        L_0x0030:
            r2 = 0
            if (r14 == 0) goto L_0x005f
            if (r1 != 0) goto L_0x005f
            com.google.android.gms.measurement.internal.b r11 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzj()
            int r12 = r10.f7646b
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzet r13 = r10.f7662g
            boolean r13 = r13.zzj()
            if (r13 == 0) goto L_0x0059
            com.google.android.gms.internal.measurement.zzet r13 = r10.f7662g
            int r13 = r13.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
        L_0x0059:
            java.lang.String r13 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r11.zzc(r13, r12, r2)
            return r5
        L_0x005f:
            com.google.android.gms.internal.measurement.zzet r6 = r10.f7662g
            com.google.android.gms.internal.measurement.zzem r6 = r6.zzb()
            boolean r7 = r6.zzg()
            boolean r8 = r13.zzr()
            if (r8 == 0) goto L_0x00aa
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0098
            com.google.android.gms.measurement.internal.b r6 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()
            com.google.android.gms.measurement.internal.b r7 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No number filter for long property. property"
            r6.zzb(r8, r7)
            goto L_0x019b
        L_0x0098:
            long r8 = r13.zzb()
            com.google.android.gms.internal.measurement.zzer r2 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.h(r8, r2)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.j(r2, r7)
            goto L_0x019b
        L_0x00aa:
            boolean r8 = r13.zzq()
            if (r8 == 0) goto L_0x00eb
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x00d9
            com.google.android.gms.measurement.internal.b r6 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()
            com.google.android.gms.measurement.internal.b r7 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No number filter for double property. property"
            r6.zzb(r8, r7)
            goto L_0x019b
        L_0x00d9:
            double r8 = r13.zza()
            com.google.android.gms.internal.measurement.zzer r2 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.g(r8, r2)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.j(r2, r7)
            goto L_0x019b
        L_0x00eb:
            boolean r8 = r13.zzt()
            if (r8 == 0) goto L_0x017a
            boolean r8 = r6.zzk()
            if (r8 != 0) goto L_0x0161
            boolean r8 = r6.zzi()
            if (r8 != 0) goto L_0x0120
            com.google.android.gms.measurement.internal.b r6 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()
            com.google.android.gms.measurement.internal.b r7 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "No string or number filter defined. property"
            r6.zzb(r8, r7)
            goto L_0x019b
        L_0x0120:
            java.lang.String r8 = r13.zzg()
            boolean r8 = com.google.android.gms.measurement.internal.zzkv.zzx(r8)
            if (r8 == 0) goto L_0x013b
            java.lang.String r2 = r13.zzg()
            com.google.android.gms.internal.measurement.zzer r6 = r6.zzc()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.i(r2, r6)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.j(r2, r7)
            goto L_0x019b
        L_0x013b:
            com.google.android.gms.measurement.internal.b r6 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()
            com.google.android.gms.measurement.internal.b r7 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = r13.zzg()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            r6.zzc(r9, r7, r8)
            goto L_0x019b
        L_0x0161:
            java.lang.String r2 = r13.zzg()
            com.google.android.gms.internal.measurement.zzey r6 = r6.zzd()
            com.google.android.gms.measurement.internal.b r8 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzt
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzay()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.f(r2, r6, r8)
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.j(r2, r7)
            goto L_0x019b
        L_0x017a:
            com.google.android.gms.measurement.internal.b r6 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzk()
            com.google.android.gms.measurement.internal.b r7 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r8 = r13.zzf()
            java.lang.String r7 = r7.zzf(r8)
            java.lang.String r8 = "User property has no value, property"
            r6.zzb(r8, r7)
        L_0x019b:
            com.google.android.gms.measurement.internal.b r6 = r10.f7663h
            com.google.android.gms.measurement.internal.zzfr r6 = r6.zzt
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzay()
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzj()
            if (r2 != 0) goto L_0x01ac
            java.lang.String r7 = "null"
            goto L_0x01ad
        L_0x01ac:
            r7 = r2
        L_0x01ad:
            java.lang.String r8 = "Property filter result"
            r6.zzb(r8, r7)
            if (r2 != 0) goto L_0x01b5
            return r4
        L_0x01b5:
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r10.f7647c = r4
            if (r3 == 0) goto L_0x01c3
            boolean r3 = r2.booleanValue()
            if (r3 == 0) goto L_0x01c2
            goto L_0x01c3
        L_0x01c2:
            return r5
        L_0x01c3:
            if (r14 == 0) goto L_0x01cd
            com.google.android.gms.internal.measurement.zzet r14 = r10.f7662g
            boolean r14 = r14.zzg()
            if (r14 == 0) goto L_0x01cf
        L_0x01cd:
            r10.f7648d = r2
        L_0x01cf:
            boolean r14 = r2.booleanValue()
            if (r14 == 0) goto L_0x0214
            if (r1 == 0) goto L_0x0214
            boolean r14 = r13.zzs()
            if (r14 == 0) goto L_0x0214
            long r13 = r13.zzc()
            if (r11 == 0) goto L_0x01e7
            long r13 = r11.longValue()
        L_0x01e7:
            if (r0 == 0) goto L_0x01ff
            com.google.android.gms.internal.measurement.zzet r11 = r10.f7662g
            boolean r11 = r11.zzg()
            if (r11 == 0) goto L_0x01ff
            com.google.android.gms.internal.measurement.zzet r11 = r10.f7662g
            boolean r11 = r11.zzh()
            if (r11 != 0) goto L_0x01ff
            if (r12 == 0) goto L_0x01ff
            long r13 = r12.longValue()
        L_0x01ff:
            com.google.android.gms.internal.measurement.zzet r11 = r10.f7662g
            boolean r11 = r11.zzh()
            if (r11 == 0) goto L_0x020e
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f7650f = r11
            goto L_0x0214
        L_0x020e:
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            r10.f7649e = r11
        L_0x0214:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.o4.k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzgm, boolean):boolean");
    }
}
