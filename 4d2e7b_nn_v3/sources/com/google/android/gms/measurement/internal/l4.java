package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzft;

final class l4 {

    /* renamed from: a  reason: collision with root package name */
    private zzft f7616a;

    /* renamed from: b  reason: collision with root package name */
    private Long f7617b;

    /* renamed from: c  reason: collision with root package name */
    private long f7618c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ b f7619d;

    /* synthetic */ l4(b bVar, zzv zzv) {
        this.f7619d = bVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f6, code lost:
        if (r8 == null) goto L_0x009d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzft a(java.lang.String r14, com.google.android.gms.internal.measurement.zzft r15) {
        /*
            r13 = this;
            java.lang.String r0 = r15.zzh()
            java.util.List r1 = r15.zzi()
            com.google.android.gms.measurement.internal.b r2 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            r2.zzu()
            java.lang.String r2 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkv.zzC(r15, r2)
            r6 = r3
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x0226
            java.lang.String r3 = "_ep"
            boolean r3 = r0.equals(r3)
            r4 = 0
            if (r3 == 0) goto L_0x01da
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            com.google.android.gms.measurement.internal.b r0 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r0 = r0.zzf
            r0.zzu()
            java.lang.String r0 = "_en"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzkv.zzC(r15, r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r7 = 0
            if (r3 == 0) goto L_0x004f
            com.google.android.gms.measurement.internal.b r14 = r13.f7619d
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r15 = "Extra parameter without an event name. eventId"
            r14.zzb(r15, r6)
            return r7
        L_0x004f:
            com.google.android.gms.internal.measurement.zzft r3 = r13.f7616a
            if (r3 == 0) goto L_0x0065
            java.lang.Long r3 = r13.f7617b
            if (r3 == 0) goto L_0x0065
            long r8 = r6.longValue()
            java.lang.Long r3 = r13.f7617b
            long r10 = r3.longValue()
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x0120
        L_0x0065:
            com.google.android.gms.measurement.internal.b r3 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r3 = r3.zzf
            com.google.android.gms.measurement.internal.f r3 = r3.zzi()
            r3.zzg()
            r3.zzW()
            android.database.sqlite.SQLiteDatabase r8 = r3.zzh()     // Catch:{ SQLiteException -> 0x00e4, all -> 0x00e1 }
            java.lang.String r9 = r6.toString()     // Catch:{ SQLiteException -> 0x00e4, all -> 0x00e1 }
            java.lang.String[] r9 = new java.lang.String[]{r14, r9}     // Catch:{ SQLiteException -> 0x00e4, all -> 0x00e1 }
            java.lang.String r10 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            android.database.Cursor r8 = r8.rawQuery(r10, r9)     // Catch:{ SQLiteException -> 0x00e4, all -> 0x00e1 }
            boolean r9 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x00a1 }
            if (r9 != 0) goto L_0x00a3
            com.google.android.gms.measurement.internal.zzfr r9 = r3.zzt     // Catch:{ SQLiteException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzay()     // Catch:{ SQLiteException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzj()     // Catch:{ SQLiteException -> 0x00a1 }
            java.lang.String r10 = "Main event not found"
            r9.zza(r10)     // Catch:{ SQLiteException -> 0x00a1 }
        L_0x009a:
            r8.close()
        L_0x009d:
            r3 = r7
            goto L_0x00f9
        L_0x009f:
            r14 = move-exception
            goto L_0x00de
        L_0x00a1:
            r9 = move-exception
            goto L_0x00e7
        L_0x00a3:
            r9 = 0
            byte[] r9 = r8.getBlob(r9)     // Catch:{ SQLiteException -> 0x00a1 }
            r10 = 1
            long r10 = r8.getLong(r10)     // Catch:{ SQLiteException -> 0x00a1 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteException -> 0x00a1 }
            com.google.android.gms.internal.measurement.zzfs r11 = com.google.android.gms.internal.measurement.zzft.zze()     // Catch:{ IOException -> 0x00c9 }
            com.google.android.gms.internal.measurement.zzll r9 = com.google.android.gms.measurement.internal.zzkv.zzl(r11, r9)     // Catch:{ IOException -> 0x00c9 }
            com.google.android.gms.internal.measurement.zzfs r9 = (com.google.android.gms.internal.measurement.zzfs) r9     // Catch:{ IOException -> 0x00c9 }
            com.google.android.gms.internal.measurement.zzkf r9 = r9.zzaC()     // Catch:{ IOException -> 0x00c9 }
            com.google.android.gms.internal.measurement.zzft r9 = (com.google.android.gms.internal.measurement.zzft) r9     // Catch:{ IOException -> 0x00c9 }
            android.util.Pair r3 = android.util.Pair.create(r9, r10)     // Catch:{ SQLiteException -> 0x00a1 }
            r8.close()
            goto L_0x00f9
        L_0x00c9:
            r9 = move-exception
            com.google.android.gms.measurement.internal.zzfr r10 = r3.zzt     // Catch:{ SQLiteException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzay()     // Catch:{ SQLiteException -> 0x00a1 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzd()     // Catch:{ SQLiteException -> 0x00a1 }
            java.lang.String r11 = "Failed to merge main event. appId, eventId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzeh.zzn(r14)     // Catch:{ SQLiteException -> 0x00a1 }
            r10.zzd(r11, r12, r6, r9)     // Catch:{ SQLiteException -> 0x00a1 }
            goto L_0x009a
        L_0x00de:
            r7 = r8
            goto L_0x01d4
        L_0x00e1:
            r14 = move-exception
            goto L_0x01d4
        L_0x00e4:
            r8 = move-exception
            r9 = r8
            r8 = r7
        L_0x00e7:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x009f }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x009f }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x009f }
            java.lang.String r10 = "Error selecting main event"
            r3.zzb(r10, r9)     // Catch:{ all -> 0x009f }
            if (r8 == 0) goto L_0x009d
            goto L_0x009a
        L_0x00f9:
            if (r3 == 0) goto L_0x01c2
            java.lang.Object r8 = r3.first
            if (r8 != 0) goto L_0x0101
            goto L_0x01c2
        L_0x0101:
            com.google.android.gms.internal.measurement.zzft r8 = (com.google.android.gms.internal.measurement.zzft) r8
            r13.f7616a = r8
            java.lang.Object r3 = r3.second
            java.lang.Long r3 = (java.lang.Long) r3
            long r7 = r3.longValue()
            r13.f7618c = r7
            com.google.android.gms.measurement.internal.b r3 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r3 = r3.zzf
            r3.zzu()
            com.google.android.gms.internal.measurement.zzft r3 = r13.f7616a
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzkv.zzC(r3, r2)
            java.lang.Long r2 = (java.lang.Long) r2
            r13.f7617b = r2
        L_0x0120:
            long r2 = r13.f7618c
            r7 = -1
            long r2 = r2 + r7
            r13.f7618c = r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0164
            com.google.android.gms.measurement.internal.b r2 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            com.google.android.gms.measurement.internal.f r2 = r2.zzi()
            r2.zzg()
            com.google.android.gms.measurement.internal.zzfr r3 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzj()
            java.lang.String r4 = "Clearing complex main event info. appId"
            r3.zzb(r4, r14)
            android.database.sqlite.SQLiteDatabase r3 = r2.zzh()     // Catch:{ SQLiteException -> 0x0153 }
            java.lang.String[] r14 = new java.lang.String[]{r14}     // Catch:{ SQLiteException -> 0x0153 }
            java.lang.String r4 = "delete from main_event_params where app_id=?"
            r3.execSQL(r4, r14)     // Catch:{ SQLiteException -> 0x0153 }
            goto L_0x0174
        L_0x0153:
            r14 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r3 = "Error clearing complex main event"
            r2.zzb(r3, r14)
            goto L_0x0174
        L_0x0164:
            com.google.android.gms.measurement.internal.b r2 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            com.google.android.gms.measurement.internal.f r4 = r2.zzi()
            long r7 = r13.f7618c
            com.google.android.gms.internal.measurement.zzft r9 = r13.f7616a
            r5 = r14
            r4.i(r5, r6, r7, r9)
        L_0x0174:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.measurement.zzft r2 = r13.f7616a
            java.util.List r2 = r2.zzi()
            java.util.Iterator r2 = r2.iterator()
        L_0x0183:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01a4
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfx r3 = (com.google.android.gms.internal.measurement.zzfx) r3
            com.google.android.gms.measurement.internal.b r4 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r4 = r4.zzf
            r4.zzu()
            java.lang.String r4 = r3.zzg()
            com.google.android.gms.internal.measurement.zzfx r4 = com.google.android.gms.measurement.internal.zzkv.zzB(r15, r4)
            if (r4 != 0) goto L_0x0183
            r14.add(r3)
            goto L_0x0183
        L_0x01a4:
            boolean r2 = r14.isEmpty()
            if (r2 != 0) goto L_0x01b0
            r14.addAll(r1)
            r1 = r14
            goto L_0x0226
        L_0x01b0:
            com.google.android.gms.measurement.internal.b r14 = r13.f7619d
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r2 = "No unique parameters in main event. eventName"
            r14.zzb(r2, r0)
            goto L_0x0226
        L_0x01c2:
            com.google.android.gms.measurement.internal.b r14 = r13.f7619d
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r15 = "Extra parameter without existing main event. eventName, eventId"
            r14.zzc(r15, r0, r6)
            return r7
        L_0x01d4:
            if (r7 == 0) goto L_0x01d9
            r7.close()
        L_0x01d9:
            throw r14
        L_0x01da:
            r13.f7617b = r6
            r13.f7616a = r15
            com.google.android.gms.measurement.internal.b r2 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            r2.zzu()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = "_epc"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzkv.zzC(r15, r3)
            if (r3 == 0) goto L_0x01f2
            r2 = r3
        L_0x01f2:
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            r13.f7618c = r2
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0210
            com.google.android.gms.measurement.internal.b r14 = r13.f7619d
            com.google.android.gms.measurement.internal.zzfr r14 = r14.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzh()
            java.lang.String r2 = "Complex event with zero extra param count. eventName"
            r14.zzb(r2, r0)
            goto L_0x0226
        L_0x0210:
            com.google.android.gms.measurement.internal.b r2 = r13.f7619d
            com.google.android.gms.measurement.internal.zzkt r2 = r2.zzf
            com.google.android.gms.measurement.internal.f r7 = r2.zzi()
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)
            r9 = r2
            java.lang.Long r9 = (java.lang.Long) r9
            long r10 = r13.f7618c
            r8 = r14
            r12 = r15
            r7.i(r8, r9, r10, r12)
        L_0x0226:
            com.google.android.gms.internal.measurement.zzkb r14 = r15.zzby()
            com.google.android.gms.internal.measurement.zzfs r14 = (com.google.android.gms.internal.measurement.zzfs) r14
            r14.zzi(r0)
            r14.zzg()
            r14.zzd(r1)
            com.google.android.gms.internal.measurement.zzkf r14 = r14.zzaC()
            com.google.android.gms.internal.measurement.zzft r14 = (com.google.android.gms.internal.measurement.zzft) r14
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.l4.a(java.lang.String, com.google.android.gms.internal.measurement.zzft):com.google.android.gms.internal.measurement.zzft");
    }
}
