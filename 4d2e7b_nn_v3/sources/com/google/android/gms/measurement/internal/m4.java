package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzek;

final class m4 extends n4 {

    /* renamed from: g  reason: collision with root package name */
    private final zzek f7634g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ b f7635h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    m4(b bVar, String str, int i10, zzek zzek) {
        super(str, i10);
        this.f7635h = bVar;
        this.f7634g = zzek;
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        return this.f7634g.zzb();
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return this.f7634g.zzo();
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v3, types: [java.lang.Integer] */
    /* JADX WARNING: type inference failed for: r5v16, types: [java.lang.Integer] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03ee  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03f9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(java.lang.Long r16, java.lang.Long r17, com.google.android.gms.internal.measurement.zzft r18, long r19, com.google.android.gms.measurement.internal.i r21, boolean r22) {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.b r1 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzag r1 = r1.zzf()
            java.lang.String r2 = r0.f7645a
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzW
            boolean r1 = r1.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zzek r2 = r0.f7634g
            boolean r2 = r2.zzn()
            if (r2 == 0) goto L_0x0021
            r2 = r21
            long r2 = r2.f7541e
            goto L_0x0023
        L_0x0021:
            r2 = r19
        L_0x0023:
            com.google.android.gms.measurement.internal.b r4 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            java.lang.String r4 = r4.zzq()
            r5 = 2
            boolean r4 = android.util.Log.isLoggable(r4, r5)
            r5 = 0
            if (r4 == 0) goto L_0x0093
            com.google.android.gms.measurement.internal.b r4 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzj()
            int r6 = r0.f7646b
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            com.google.android.gms.internal.measurement.zzek r7 = r0.f7634g
            boolean r7 = r7.zzp()
            if (r7 == 0) goto L_0x005c
            com.google.android.gms.internal.measurement.zzek r7 = r0.f7634g
            int r7 = r7.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x005d
        L_0x005c:
            r7 = r5
        L_0x005d:
            com.google.android.gms.measurement.internal.b r8 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r8 = r8.zzt
            com.google.android.gms.measurement.internal.zzec r8 = r8.zzj()
            com.google.android.gms.internal.measurement.zzek r9 = r0.f7634g
            java.lang.String r9 = r9.zzg()
            java.lang.String r8 = r8.zzd(r9)
            java.lang.String r9 = "Evaluating filter. audience, filter, event"
            r4.zzd(r9, r6, r7, r8)
            com.google.android.gms.measurement.internal.b r4 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r4 = r4.zzt
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzay()
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzj()
            com.google.android.gms.measurement.internal.b r6 = r0.f7635h
            com.google.android.gms.measurement.internal.zzkt r6 = r6.zzf
            com.google.android.gms.measurement.internal.zzkv r6 = r6.zzu()
            com.google.android.gms.internal.measurement.zzek r7 = r0.f7634g
            java.lang.String r6 = r6.zzo(r7)
            java.lang.String r7 = "Filter definition"
            r4.zzb(r7, r6)
        L_0x0093:
            com.google.android.gms.internal.measurement.zzek r4 = r0.f7634g
            boolean r4 = r4.zzp()
            r6 = 0
            if (r4 == 0) goto L_0x043e
            com.google.android.gms.internal.measurement.zzek r4 = r0.f7634g
            int r4 = r4.zzb()
            r7 = 256(0x100, float:3.59E-43)
            if (r4 <= r7) goto L_0x00a8
            goto L_0x043e
        L_0x00a8:
            com.google.android.gms.internal.measurement.zzek r4 = r0.f7634g
            boolean r4 = r4.zzk()
            com.google.android.gms.internal.measurement.zzek r7 = r0.f7634g
            boolean r7 = r7.zzm()
            com.google.android.gms.internal.measurement.zzek r8 = r0.f7634g
            boolean r8 = r8.zzn()
            r9 = 1
            if (r4 != 0) goto L_0x00c1
            if (r7 != 0) goto L_0x00c1
            if (r8 == 0) goto L_0x00c3
        L_0x00c1:
            r4 = r9
            goto L_0x00c4
        L_0x00c3:
            r4 = r6
        L_0x00c4:
            if (r22 == 0) goto L_0x00f2
            if (r4 != 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.b r1 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzj()
            int r2 = r0.f7646b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzek r3 = r0.f7634g
            boolean r3 = r3.zzp()
            if (r3 == 0) goto L_0x00ec
            com.google.android.gms.internal.measurement.zzek r3 = r0.f7634g
            int r3 = r3.zzb()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
        L_0x00ec:
            java.lang.String r3 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zzc(r3, r2, r5)
            return r9
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzek r7 = r0.f7634g
            java.lang.String r8 = r18.zzh()
            boolean r10 = r7.zzo()
            if (r10 == 0) goto L_0x0114
            com.google.android.gms.internal.measurement.zzer r10 = r7.zzf()
            java.lang.Boolean r2 = com.google.android.gms.measurement.internal.n4.h(r2, r10)
            if (r2 != 0) goto L_0x010a
            goto L_0x03e0
        L_0x010a:
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0114
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e0
        L_0x0114:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.List r3 = r7.zzh()
            java.util.Iterator r3 = r3.iterator()
        L_0x0121:
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x015e
            java.lang.Object r10 = r3.next()
            com.google.android.gms.internal.measurement.zzem r10 = (com.google.android.gms.internal.measurement.zzem) r10
            java.lang.String r11 = r10.zze()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            java.lang.String r7 = "null or empty param name in filter. event"
            r2.zzb(r7, r3)
            goto L_0x03e0
        L_0x0156:
            java.lang.String r10 = r10.zze()
            r2.add(r10)
            goto L_0x0121
        L_0x015e:
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            java.util.List r10 = r18.zzi()
            java.util.Iterator r10 = r10.iterator()
        L_0x016b:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x01fe
            java.lang.Object r11 = r10.next()
            com.google.android.gms.internal.measurement.zzfx r11 = (com.google.android.gms.internal.measurement.zzfx) r11
            java.lang.String r12 = r11.zzg()
            boolean r12 = r2.contains(r12)
            if (r12 == 0) goto L_0x016b
            boolean r12 = r11.zzw()
            if (r12 == 0) goto L_0x019f
            java.lang.String r12 = r11.zzg()
            boolean r13 = r11.zzw()
            if (r13 == 0) goto L_0x019a
            long r13 = r11.zzd()
            java.lang.Long r11 = java.lang.Long.valueOf(r13)
            goto L_0x019b
        L_0x019a:
            r11 = r5
        L_0x019b:
            r3.put(r12, r11)
            goto L_0x016b
        L_0x019f:
            boolean r12 = r11.zzu()
            if (r12 == 0) goto L_0x01bd
            java.lang.String r12 = r11.zzg()
            boolean r13 = r11.zzu()
            if (r13 == 0) goto L_0x01b8
            double r13 = r11.zza()
            java.lang.Double r11 = java.lang.Double.valueOf(r13)
            goto L_0x01b9
        L_0x01b8:
            r11 = r5
        L_0x01b9:
            r3.put(r12, r11)
            goto L_0x016b
        L_0x01bd:
            boolean r12 = r11.zzy()
            if (r12 == 0) goto L_0x01cf
            java.lang.String r12 = r11.zzg()
            java.lang.String r11 = r11.zzh()
            r3.put(r12, r11)
            goto L_0x016b
        L_0x01cf:
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r7 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r8 = r11.zzg()
            java.lang.String r7 = r7.zze(r8)
            java.lang.String r8 = "Unknown value for param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e0
        L_0x01fe:
            java.util.List r2 = r7.zzh()
            java.util.Iterator r2 = r2.iterator()
        L_0x0206:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x03de
            java.lang.Object r7 = r2.next()
            com.google.android.gms.internal.measurement.zzem r7 = (com.google.android.gms.internal.measurement.zzem) r7
            boolean r10 = r7.zzh()
            if (r10 == 0) goto L_0x0220
            boolean r10 = r7.zzg()
            if (r10 == 0) goto L_0x0220
            r10 = r9
            goto L_0x0221
        L_0x0220:
            r10 = r6
        L_0x0221:
            java.lang.String r11 = r7.zze()
            boolean r12 = r11.isEmpty()
            if (r12 == 0) goto L_0x024a
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            java.lang.String r7 = "Event has empty param name. event"
            r2.zzb(r7, r3)
            goto L_0x03e0
        L_0x024a:
            java.lang.Object r12 = r3.get(r11)
            boolean r13 = r12 instanceof java.lang.Long
            if (r13 == 0) goto L_0x029f
            boolean r13 = r7.zzi()
            if (r13 != 0) goto L_0x0283
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r7 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "No number filter for long param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e0
        L_0x0283:
            java.lang.Long r12 = (java.lang.Long) r12
            long r11 = r12.longValue()
            com.google.android.gms.internal.measurement.zzer r7 = r7.zzc()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.n4.h(r11, r7)
            if (r7 != 0) goto L_0x0295
            goto L_0x03e0
        L_0x0295:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0206
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e0
        L_0x029f:
            boolean r13 = r12 instanceof java.lang.Double
            if (r13 == 0) goto L_0x02f0
            boolean r13 = r7.zzi()
            if (r13 != 0) goto L_0x02d4
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r7 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "No number filter for double param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e0
        L_0x02d4:
            java.lang.Double r12 = (java.lang.Double) r12
            double r11 = r12.doubleValue()
            com.google.android.gms.internal.measurement.zzer r7 = r7.zzc()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.n4.g(r11, r7)
            if (r7 != 0) goto L_0x02e6
            goto L_0x03e0
        L_0x02e6:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0206
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e0
        L_0x02f0:
            boolean r13 = r12 instanceof java.lang.String
            if (r13 == 0) goto L_0x0386
            boolean r13 = r7.zzk()
            if (r13 == 0) goto L_0x030d
            java.lang.String r12 = (java.lang.String) r12
            com.google.android.gms.internal.measurement.zzey r7 = r7.zzd()
            com.google.android.gms.measurement.internal.b r11 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r11 = r11.zzt
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzay()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.n4.f(r12, r7, r11)
            goto L_0x0323
        L_0x030d:
            boolean r13 = r7.zzi()
            if (r13 == 0) goto L_0x035c
            java.lang.String r12 = (java.lang.String) r12
            boolean r13 = com.google.android.gms.measurement.internal.zzkv.zzx(r12)
            if (r13 == 0) goto L_0x0331
            com.google.android.gms.internal.measurement.zzer r7 = r7.zzc()
            java.lang.Boolean r7 = com.google.android.gms.measurement.internal.n4.i(r12, r7)
        L_0x0323:
            if (r7 != 0) goto L_0x0327
            goto L_0x03e0
        L_0x0327:
            boolean r7 = r7.booleanValue()
            if (r7 != r10) goto L_0x0206
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e0
        L_0x0331:
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r7 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "Invalid param value for number filter. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e0
        L_0x035c:
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r7 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "No filter for String param. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e0
        L_0x0386:
            if (r12 != 0) goto L_0x03b4
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r5 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r5 = r5.zzt
            com.google.android.gms.measurement.internal.zzec r5 = r5.zzj()
            java.lang.String r5 = r5.zze(r11)
            java.lang.String r7 = "Missing param for filter. event, param"
            r2.zzc(r7, r3, r5)
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            goto L_0x03e0
        L_0x03b4:
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzk()
            com.google.android.gms.measurement.internal.b r3 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt
            com.google.android.gms.measurement.internal.zzec r3 = r3.zzj()
            java.lang.String r3 = r3.zzd(r8)
            com.google.android.gms.measurement.internal.b r7 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zze(r11)
            java.lang.String r8 = "Unknown param type. event, param"
            r2.zzc(r8, r3, r7)
            goto L_0x03e0
        L_0x03de:
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
        L_0x03e0:
            com.google.android.gms.measurement.internal.b r2 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            if (r5 != 0) goto L_0x03f1
            java.lang.String r3 = "null"
            goto L_0x03f2
        L_0x03f1:
            r3 = r5
        L_0x03f2:
            java.lang.String r7 = "Event filter result"
            r2.zzb(r7, r3)
            if (r5 != 0) goto L_0x03fa
            return r6
        L_0x03fa:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.f7647c = r2
            boolean r3 = r5.booleanValue()
            if (r3 != 0) goto L_0x0405
            return r9
        L_0x0405:
            r0.f7648d = r2
            if (r4 == 0) goto L_0x043d
            boolean r2 = r18.zzu()
            if (r2 == 0) goto L_0x043d
            long r2 = r18.zzd()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            com.google.android.gms.internal.measurement.zzek r3 = r0.f7634g
            boolean r3 = r3.zzm()
            if (r3 == 0) goto L_0x042f
            if (r1 == 0) goto L_0x042c
            com.google.android.gms.internal.measurement.zzek r1 = r0.f7634g
            boolean r1 = r1.zzo()
            if (r1 != 0) goto L_0x042a
            goto L_0x042c
        L_0x042a:
            r2 = r16
        L_0x042c:
            r0.f7650f = r2
            goto L_0x043d
        L_0x042f:
            if (r1 == 0) goto L_0x043b
            com.google.android.gms.internal.measurement.zzek r1 = r0.f7634g
            boolean r1 = r1.zzo()
            if (r1 == 0) goto L_0x043b
            r2 = r17
        L_0x043b:
            r0.f7649e = r2
        L_0x043d:
            return r9
        L_0x043e:
            com.google.android.gms.measurement.internal.b r1 = r0.f7635h
            com.google.android.gms.measurement.internal.zzfr r1 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzay()
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzk()
            java.lang.String r2 = r0.f7645a
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzeh.zzn(r2)
            com.google.android.gms.internal.measurement.zzek r3 = r0.f7634g
            boolean r3 = r3.zzp()
            if (r3 == 0) goto L_0x0462
            com.google.android.gms.internal.measurement.zzek r3 = r0.f7634g
            int r3 = r3.zzb()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
        L_0x0462:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zzc(r4, r2, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m4.k(java.lang.Long, java.lang.Long, com.google.android.gms.internal.measurement.zzft, long, com.google.android.gms.measurement.internal.i, boolean):boolean");
    }
}
