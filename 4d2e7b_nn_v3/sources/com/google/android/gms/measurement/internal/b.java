package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

final class b extends u3 {

    /* renamed from: a  reason: collision with root package name */
    private String f7392a;

    /* renamed from: b  reason: collision with root package name */
    private Set f7393b;

    /* renamed from: c  reason: collision with root package name */
    private Map f7394c;

    /* renamed from: d  reason: collision with root package name */
    private Long f7395d;

    /* renamed from: e  reason: collision with root package name */
    private Long f7396e;

    b(zzkt zzkt) {
        super(zzkt);
    }

    private final k4 b(Integer num) {
        if (this.f7394c.containsKey(num)) {
            return (k4) this.f7394c.get(num);
        }
        k4 k4Var = new k4(this, this.f7392a, (zzt) null);
        this.f7394c.put(num, k4Var);
        return k4Var;
    }

    private final boolean c(int i10, int i11) {
        k4 k4Var = (k4) this.f7394c.get(Integer.valueOf(i10));
        if (k4Var == null) {
            return false;
        }
        return k4Var.f7598d.get(i11);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02f0, code lost:
        if (r5 != null) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0787, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0789, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x0793, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x07ab, code lost:
        if (r5 == null) goto L_0x07ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x07b4, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0950, code lost:
        if (r13 == null) goto L_0x0953;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:428:0x0a70, code lost:
        if (r13 != false) goto L_0x0a77;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0172, code lost:
        if (r5 != null) goto L_0x0151;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x044c  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0606  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0787 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:266:0x06f1] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x07b4  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0864  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0959  */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x0a95  */
    /* JADX WARNING: Removed duplicated region for block: B:449:0x0b22  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01ac A[Catch:{ SQLiteException -> 0x01bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01c4 A[SYNTHETIC, Splitter:B:71:0x01c4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List a(java.lang.String r63, java.util.List r64, java.util.List r65, java.lang.Long r66, java.lang.Long r67) {
        /*
            r62 = this;
            r10 = r62
            java.lang.String r11 = "current_results"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r63)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r64)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r65)
            r0 = r63
            r10.f7392a = r0
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r10.f7393b = r0
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            r10.f7394c = r0
            r0 = r66
            r10.f7395d = r0
            r0 = r67
            r10.f7396e = r0
            java.util.Iterator r0 = r64.iterator()
        L_0x002b:
            boolean r1 = r0.hasNext()
            r12 = 0
            r13 = 1
            if (r1 == 0) goto L_0x0047
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzft r1 = (com.google.android.gms.internal.measurement.zzft) r1
            java.lang.String r1 = r1.zzh()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x002b
            r1 = r13
            goto L_0x0048
        L_0x0047:
            r1 = r12
        L_0x0048:
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.f7392a
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzW
            boolean r14 = r0.zzs(r2, r3)
            com.google.android.gms.internal.measurement.zznz.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            java.lang.String r2 = r10.f7392a
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzV
            boolean r15 = r0.zzs(r2, r3)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r2 = r0.zzi()
            java.lang.String r3 = r10.f7392a
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r2.zzh()     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String[] r5 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x009b }
            java.lang.String r6 = "events"
            java.lang.String r7 = "app_id = ?"
            r4.update(r6, r0, r7, r5)     // Catch:{ SQLiteException -> 0x009b }
            goto L_0x00af
        L_0x009b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()
            java.lang.String r4 = "Error resetting session-scoped event counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)
            r2.zzc(r4, r3, r0)
        L_0x00af:
            java.util.Map r0 = java.util.Collections.emptyMap()
            java.lang.String r9 = "Failed to merge filter. appId"
            java.lang.String r8 = "Database error querying filters. appId"
            java.lang.String r7 = "data"
            java.lang.String r6 = "audience_id"
            if (r15 == 0) goto L_0x0154
            if (r14 == 0) goto L_0x0154
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r2 = r0.zzi()
            java.lang.String r3 = r10.f7392a
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            java.lang.String[] r20 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=?"
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0156 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0125 }
            if (r0 == 0) goto L_0x014d
        L_0x00ef:
            byte[] r0 = r5.getBlob(r13)     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.internal.measurement.zzej r13 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x012d }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x012d }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x012d }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x012d }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x012d }
            boolean r13 = r0.zzo()     // Catch:{ SQLiteException -> 0x0125 }
            if (r13 != 0) goto L_0x010a
            goto L_0x013f
        L_0x010a:
            int r13 = r5.getInt(r12)     // Catch:{ SQLiteException -> 0x0125 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ SQLiteException -> 0x0125 }
            java.lang.Object r16 = r4.get(r13)     // Catch:{ SQLiteException -> 0x0125 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x0125 }
            if (r16 != 0) goto L_0x0127
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0125 }
            r12.<init>()     // Catch:{ SQLiteException -> 0x0125 }
            r4.put(r13, r12)     // Catch:{ SQLiteException -> 0x0125 }
            goto L_0x0129
        L_0x0123:
            r0 = move-exception
            goto L_0x0175
        L_0x0125:
            r0 = move-exception
            goto L_0x015d
        L_0x0127:
            r12 = r16
        L_0x0129:
            r12.add(r0)     // Catch:{ SQLiteException -> 0x0125 }
            goto L_0x013f
        L_0x012d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r12 = r2.zzt     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ SQLiteException -> 0x0125 }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ SQLiteException -> 0x0125 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0125 }
            r12.zzc(r9, r13, r0)     // Catch:{ SQLiteException -> 0x0125 }
        L_0x013f:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0125 }
            if (r0 != 0) goto L_0x014a
            r5.close()
            r12 = r4
            goto L_0x017b
        L_0x014a:
            r12 = 0
            r13 = 1
            goto L_0x00ef
        L_0x014d:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0125 }
        L_0x0151:
            r5.close()
        L_0x0154:
            r12 = r0
            goto L_0x017b
        L_0x0156:
            r0 = move-exception
            goto L_0x015a
        L_0x0158:
            r0 = move-exception
            goto L_0x015c
        L_0x015a:
            r5 = 0
            goto L_0x0175
        L_0x015c:
            r5 = 0
        L_0x015d:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x0123 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0123 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0123 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0123 }
            r2.zzc(r8, r3, r0)     // Catch:{ all -> 0x0123 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0123 }
            if (r5 == 0) goto L_0x0154
            goto L_0x0151
        L_0x0175:
            if (r5 == 0) goto L_0x017a
            r5.close()
        L_0x017a:
            throw r0
        L_0x017b:
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r2 = r0.zzi()
            java.lang.String r3 = r10.f7392a
            r2.zzW()
            r2.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            android.database.sqlite.SQLiteDatabase r16 = r2.zzh()
            java.lang.String[] r18 = new java.lang.String[]{r6, r11}     // Catch:{ SQLiteException -> 0x022b, all -> 0x0229 }
            java.lang.String[] r20 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x022b, all -> 0x0229 }
            java.lang.String r17 = "audience_filter_values"
            java.lang.String r19 = "app_id=?"
            r22 = 0
            r23 = 0
            r21 = 0
            android.database.Cursor r4 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x022b, all -> 0x0229 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x01bd }
            if (r0 != 0) goto L_0x01c4
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x01bd }
            r4.close()
            r13 = r0
            r18 = r6
            r19 = r7
            goto L_0x0252
        L_0x01ba:
            r0 = move-exception
            goto L_0x0226
        L_0x01bd:
            r0 = move-exception
            r18 = r6
        L_0x01c0:
            r19 = r7
            goto L_0x0235
        L_0x01c4:
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x01bd }
            r5.<init>()     // Catch:{ SQLiteException -> 0x01bd }
        L_0x01c9:
            r13 = 0
            int r16 = r4.getInt(r13)     // Catch:{ SQLiteException -> 0x01bd }
            r13 = 1
            byte[] r0 = r4.getBlob(r13)     // Catch:{ SQLiteException -> 0x01bd }
            com.google.android.gms.internal.measurement.zzgh r13 = com.google.android.gms.internal.measurement.zzgi.zzf()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r13, r0)     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgh r0 = (com.google.android.gms.internal.measurement.zzgh) r0     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x01f1 }
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0     // Catch:{ IOException -> 0x01f1 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x01bd }
            r5.put(r13, r0)     // Catch:{ SQLiteException -> 0x01bd }
            r17 = r5
            r18 = r6
            r19 = r7
            goto L_0x020f
        L_0x01f1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r13 = r2.zzt     // Catch:{ SQLiteException -> 0x01bd }
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()     // Catch:{ SQLiteException -> 0x01bd }
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzd()     // Catch:{ SQLiteException -> 0x01bd }
            r17 = r5
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            r18 = r6
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0224 }
            r19 = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x0222 }
            r13.zzd(r5, r6, r7, r0)     // Catch:{ SQLiteException -> 0x0222 }
        L_0x020f:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0222 }
            if (r0 != 0) goto L_0x021b
            r4.close()
            r13 = r17
            goto L_0x0252
        L_0x021b:
            r5 = r17
            r6 = r18
            r7 = r19
            goto L_0x01c9
        L_0x0222:
            r0 = move-exception
            goto L_0x0235
        L_0x0224:
            r0 = move-exception
            goto L_0x01c0
        L_0x0226:
            r5 = r4
            goto L_0x0b20
        L_0x0229:
            r0 = move-exception
            goto L_0x0231
        L_0x022b:
            r0 = move-exception
            r18 = r6
            r19 = r7
            goto L_0x0234
        L_0x0231:
            r5 = 0
            goto L_0x0b20
        L_0x0234:
            r4 = 0
        L_0x0235:
            com.google.android.gms.measurement.internal.zzfr r2 = r2.zzt     // Catch:{ all -> 0x01ba }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x01ba }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x01ba }
            java.lang.String r5 = "Database error querying filter results. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x01ba }
            r2.zzc(r5, r3, r0)     // Catch:{ all -> 0x01ba }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x01ba }
            if (r4 == 0) goto L_0x0251
            r4.close()
        L_0x0251:
            r13 = r0
        L_0x0252:
            boolean r0 = r13.isEmpty()
            if (r0 == 0) goto L_0x0260
            r12 = r8
            r13 = r9
            r26 = r18
            r27 = r19
            goto L_0x05fa
        L_0x0260:
            java.util.HashSet r2 = new java.util.HashSet
            java.util.Set r0 = r13.keySet()
            r2.<init>(r0)
            if (r1 == 0) goto L_0x0450
            java.lang.String r1 = r10.f7392a
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r3 = r0.zzi()
            java.lang.String r4 = r10.f7392a
            r3.zzW()
            r3.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r5 = r3.zzh()
            java.lang.String[] r6 = new java.lang.String[]{r4, r4}     // Catch:{ SQLiteException -> 0x02d3, all -> 0x02d1 }
            java.lang.String r7 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            android.database.Cursor r5 = r5.rawQuery(r7, r6)     // Catch:{ SQLiteException -> 0x02d3, all -> 0x02d1 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x02b5 }
            if (r6 == 0) goto L_0x02cc
        L_0x0297:
            r6 = 0
            int r7 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02b5 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch:{ SQLiteException -> 0x02b5 }
            java.lang.Object r7 = r0.get(r6)     // Catch:{ SQLiteException -> 0x02b5 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ SQLiteException -> 0x02b5 }
            if (r7 != 0) goto L_0x02b0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x02b5 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x02b5 }
            r0.put(r6, r7)     // Catch:{ SQLiteException -> 0x02b5 }
        L_0x02b0:
            r6 = 1
            goto L_0x02b7
        L_0x02b2:
            r0 = move-exception
            goto L_0x044a
        L_0x02b5:
            r0 = move-exception
            goto L_0x02d9
        L_0x02b7:
            int r16 = r5.getInt(r6)     // Catch:{ SQLiteException -> 0x02b5 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x02b5 }
            r7.add(r6)     // Catch:{ SQLiteException -> 0x02b5 }
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x02b5 }
            if (r6 != 0) goto L_0x0297
        L_0x02c8:
            r5.close()
            goto L_0x02f3
        L_0x02cc:
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x02b5 }
            goto L_0x02c8
        L_0x02d1:
            r0 = move-exception
            goto L_0x02d5
        L_0x02d3:
            r0 = move-exception
            goto L_0x02d8
        L_0x02d5:
            r5 = 0
            goto L_0x044a
        L_0x02d8:
            r5 = 0
        L_0x02d9:
            com.google.android.gms.measurement.internal.zzfr r3 = r3.zzt     // Catch:{ all -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x02b2 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x02b2 }
            java.lang.String r6 = "Database error querying scoped filters. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r4)     // Catch:{ all -> 0x02b2 }
            r3.zzc(r6, r4, r0)     // Catch:{ all -> 0x02b2 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x02b2 }
            if (r5 == 0) goto L_0x02f3
            goto L_0x02c8
        L_0x02f3:
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L_0x0308
        L_0x0304:
            r20 = r8
            goto L_0x0448
        L_0x0308:
            java.util.Set r3 = r13.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0310:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0304
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            r4.intValue()
            java.lang.Object r5 = r13.get(r4)
            com.google.android.gms.internal.measurement.zzgi r5 = (com.google.android.gms.internal.measurement.zzgi) r5
            java.lang.Object r6 = r0.get(r4)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x0333
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x033b
        L_0x0333:
            r16 = r0
            r17 = r3
            r20 = r8
            goto L_0x0444
        L_0x033b:
            com.google.android.gms.measurement.internal.zzkt r7 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r7 = r7.zzu()
            r16 = r0
            java.util.List r0 = r5.zzk()
            java.util.List r0 = r7.zzq(r0, r6)
            boolean r7 = r0.isEmpty()
            if (r7 != 0) goto L_0x0440
            com.google.android.gms.internal.measurement.zzkb r7 = r5.zzby()
            com.google.android.gms.internal.measurement.zzgh r7 = (com.google.android.gms.internal.measurement.zzgh) r7
            r7.zzf()
            r7.zzb(r0)
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r0 = r0.zzu()
            r17 = r3
            java.util.List r3 = r5.zzn()
            java.util.List r0 = r0.zzq(r3, r6)
            r7.zzh()
            r7.zzd(r0)
            com.google.android.gms.internal.measurement.zzoc.zzc()
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzag r0 = r0.zzf()
            com.google.android.gms.measurement.internal.zzdt r3 = com.google.android.gms.measurement.internal.zzdu.zzas
            r20 = r8
            r8 = 0
            boolean r0 = r0.zzs(r8, r3)
            if (r0 == 0) goto L_0x03f1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r5.zzj()
            java.util.Iterator r3 = r3.iterator()
        L_0x0394:
            boolean r21 = r3.hasNext()
            if (r21 == 0) goto L_0x03b9
            java.lang.Object r21 = r3.next()
            r8 = r21
            com.google.android.gms.internal.measurement.zzfr r8 = (com.google.android.gms.internal.measurement.zzfr) r8
            int r21 = r8.zza()
            r22 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r21)
            boolean r3 = r6.contains(r3)
            if (r3 != 0) goto L_0x03b5
            r0.add(r8)
        L_0x03b5:
            r3 = r22
            r8 = 0
            goto L_0x0394
        L_0x03b9:
            r7.zze()
            r7.zza(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r3 = r5.zzm()
            java.util.Iterator r3 = r3.iterator()
        L_0x03cc:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x03ea
            java.lang.Object r5 = r3.next()
            com.google.android.gms.internal.measurement.zzgk r5 = (com.google.android.gms.internal.measurement.zzgk) r5
            int r8 = r5.zzb()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r6.contains(r8)
            if (r8 != 0) goto L_0x03cc
            r0.add(r5)
            goto L_0x03cc
        L_0x03ea:
            r7.zzg()
            r7.zzc(r0)
            goto L_0x042f
        L_0x03f1:
            r0 = 0
        L_0x03f2:
            int r3 = r5.zza()
            if (r0 >= r3) goto L_0x0410
            com.google.android.gms.internal.measurement.zzfr r3 = r5.zze(r0)
            int r3 = r3.zza()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x040d
            r7.zzi(r0)
        L_0x040d:
            int r0 = r0 + 1
            goto L_0x03f2
        L_0x0410:
            r0 = 0
        L_0x0411:
            int r3 = r5.zzc()
            if (r0 >= r3) goto L_0x042f
            com.google.android.gms.internal.measurement.zzgk r3 = r5.zzi(r0)
            int r3 = r3.zzb()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x042c
            r7.zzj(r0)
        L_0x042c:
            int r0 = r0 + 1
            goto L_0x0411
        L_0x042f:
            com.google.android.gms.internal.measurement.zzkf r0 = r7.zzaC()
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0
            r1.put(r4, r0)
        L_0x0438:
            r0 = r16
            r3 = r17
            r8 = r20
            goto L_0x0310
        L_0x0440:
            r0 = r16
            goto L_0x0310
        L_0x0444:
            r1.put(r4, r5)
            goto L_0x0438
        L_0x0448:
            r0 = r1
            goto L_0x0453
        L_0x044a:
            if (r5 == 0) goto L_0x044f
            r5.close()
        L_0x044f:
            throw r0
        L_0x0450:
            r20 = r8
            r0 = r13
        L_0x0453:
            java.util.Iterator r16 = r2.iterator()
        L_0x0457:
            boolean r1 = r16.hasNext()
            if (r1 == 0) goto L_0x05f3
            java.lang.Object r1 = r16.next()
            r8 = r1
            java.lang.Integer r8 = (java.lang.Integer) r8
            r8.intValue()
            java.lang.Object r1 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzgi r1 = (com.google.android.gms.internal.measurement.zzgi) r1
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            if (r1 == 0) goto L_0x04bb
            int r2 = r1.zza()
            if (r2 != 0) goto L_0x0485
            goto L_0x04bb
        L_0x0485:
            java.util.List r2 = r1.zzj()
            java.util.Iterator r2 = r2.iterator()
        L_0x048d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04bb
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzfr r3 = (com.google.android.gms.internal.measurement.zzfr) r3
            boolean r4 = r3.zzh()
            if (r4 == 0) goto L_0x048d
            int r4 = r3.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r17 = r3.zzg()
            if (r17 == 0) goto L_0x04b6
            long r21 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r21)
            goto L_0x04b7
        L_0x04b6:
            r3 = 0
        L_0x04b7:
            r7.put(r4, r3)
            goto L_0x048d
        L_0x04bb:
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            if (r1 == 0) goto L_0x04c8
            int r2 = r1.zzc()
            if (r2 != 0) goto L_0x04cb
        L_0x04c8:
            r21 = r0
            goto L_0x050d
        L_0x04cb:
            java.util.List r2 = r1.zzm()
            java.util.Iterator r2 = r2.iterator()
        L_0x04d3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x04c8
            java.lang.Object r3 = r2.next()
            com.google.android.gms.internal.measurement.zzgk r3 = (com.google.android.gms.internal.measurement.zzgk) r3
            boolean r17 = r3.zzi()
            if (r17 == 0) goto L_0x04d3
            int r17 = r3.zza()
            if (r17 <= 0) goto L_0x04d3
            int r17 = r3.zzb()
            r21 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            int r17 = r3.zza()
            r22 = r2
            int r2 = r17 + -1
            long r2 = r3.zzc(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r4.put(r0, r2)
            r0 = r21
            r2 = r22
            goto L_0x04d3
        L_0x050d:
            if (r1 == 0) goto L_0x0556
            r0 = 0
        L_0x0510:
            int r2 = r1.zzd()
            int r2 = r2 * 64
            if (r0 >= r2) goto L_0x0556
            java.util.List r2 = r1.zzn()
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzv(r2, r0)
            if (r2 == 0) goto L_0x0548
            com.google.android.gms.measurement.internal.zzfr r2 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzj()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r17 = r9
            java.lang.String r9 = "Filter already evaluated. audience ID, filter ID"
            r2.zzc(r9, r8, r3)
            r6.set(r0)
            java.util.List r2 = r1.zzk()
            boolean r2 = com.google.android.gms.measurement.internal.zzkv.zzv(r2, r0)
            if (r2 == 0) goto L_0x054a
            r5.set(r0)
            goto L_0x0551
        L_0x0548:
            r17 = r9
        L_0x054a:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r7.remove(r2)
        L_0x0551:
            int r0 = r0 + 1
            r9 = r17
            goto L_0x0510
        L_0x0556:
            r17 = r9
            java.lang.Object r0 = r13.get(r8)
            com.google.android.gms.internal.measurement.zzgi r0 = (com.google.android.gms.internal.measurement.zzgi) r0
            if (r15 == 0) goto L_0x05be
            if (r14 == 0) goto L_0x05be
            java.lang.Object r1 = r12.get(r8)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x05be
            java.lang.Long r2 = r10.f7396e
            if (r2 == 0) goto L_0x05be
            java.lang.Long r2 = r10.f7395d
            if (r2 != 0) goto L_0x0573
            goto L_0x05be
        L_0x0573:
            java.util.Iterator r1 = r1.iterator()
        L_0x0577:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x05be
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzek r2 = (com.google.android.gms.internal.measurement.zzek) r2
            int r3 = r2.zzb()
            java.lang.Long r9 = r10.f7396e
            long r22 = r9.longValue()
            r24 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 / r24
            boolean r2 = r2.zzm()
            if (r2 == 0) goto L_0x059f
            java.lang.Long r2 = r10.f7395d
            long r22 = r2.longValue()
            long r22 = r22 / r24
        L_0x059f:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            boolean r3 = r7.containsKey(r2)
            if (r3 == 0) goto L_0x05b0
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            r7.put(r2, r3)
        L_0x05b0:
            boolean r3 = r4.containsKey(r2)
            if (r3 == 0) goto L_0x0577
            java.lang.Long r3 = java.lang.Long.valueOf(r22)
            r4.put(r2, r3)
            goto L_0x0577
        L_0x05be:
            com.google.android.gms.measurement.internal.k4 r9 = new com.google.android.gms.measurement.internal.k4
            java.lang.String r3 = r10.f7392a
            r22 = 0
            r1 = r9
            r2 = r62
            r23 = r4
            r4 = r0
            r26 = r18
            r27 = r19
            r0 = r8
            r18 = r12
            r12 = r20
            r8 = r23
            r63 = r13
            r13 = r17
            r17 = r14
            r14 = r9
            r9 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            java.util.Map r1 = r10.f7394c
            r1.put(r0, r14)
            r9 = r13
            r14 = r17
            r12 = r18
            r0 = r21
            r18 = r26
            r13 = r63
            goto L_0x0457
        L_0x05f3:
            r13 = r9
            r26 = r18
            r27 = r19
            r12 = r20
        L_0x05fa:
            boolean r0 = r64.isEmpty()
            java.lang.String r1 = "Skipping failed audience ID"
            if (r0 == 0) goto L_0x0606
        L_0x0602:
            r24 = r11
            goto L_0x085a
        L_0x0606:
            com.google.android.gms.measurement.internal.l4 r2 = new com.google.android.gms.measurement.internal.l4
            r3 = 0
            r2.<init>(r10, r3)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r5 = r64.iterator()
        L_0x0615:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0602
            java.lang.Object r0 = r5.next()
            com.google.android.gms.internal.measurement.zzft r0 = (com.google.android.gms.internal.measurement.zzft) r0
            java.lang.String r6 = r10.f7392a
            com.google.android.gms.internal.measurement.zzft r6 = r2.a(r6, r0)
            if (r6 == 0) goto L_0x0615
            com.google.android.gms.measurement.internal.zzkt r7 = r10.zzf
            com.google.android.gms.measurement.internal.f r7 = r7.zzi()
            java.lang.String r8 = r10.f7392a
            java.lang.String r9 = r6.zzh()
            java.lang.String r14 = r0.zzh()
            com.google.android.gms.measurement.internal.i r14 = r7.H(r8, r14)
            if (r14 != 0) goto L_0x067e
            com.google.android.gms.measurement.internal.zzfr r14 = r7.zzt
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzk()
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzeh.zzn(r8)
            com.google.android.gms.measurement.internal.zzfr r7 = r7.zzt
            com.google.android.gms.measurement.internal.zzec r7 = r7.zzj()
            java.lang.String r7 = r7.zzd(r9)
            java.lang.String r9 = "Event aggregate wasn't created during raw event logging. appId, event"
            r14.zzc(r9, r15, r7)
            com.google.android.gms.measurement.internal.i r7 = new com.google.android.gms.measurement.internal.i
            r28 = r7
            java.lang.String r30 = r0.zzh()
            long r37 = r0.zzd()
            r43 = 0
            r44 = 0
            r31 = 1
            r33 = 1
            r35 = 1
            r39 = 0
            r41 = 0
            r42 = 0
            r29 = r8
            r28.<init>(r29, r30, r31, r33, r35, r37, r39, r41, r42, r43, r44)
            goto L_0x06b3
        L_0x067e:
            com.google.android.gms.measurement.internal.i r7 = new com.google.android.gms.measurement.internal.i
            r45 = r7
            java.lang.String r0 = r14.f7537a
            r46 = r0
            java.lang.String r0 = r14.f7538b
            r47 = r0
            long r8 = r14.f7539c
            r15 = 1
            long r48 = r8 + r15
            long r8 = r14.f7540d
            long r50 = r8 + r15
            long r8 = r14.f7541e
            long r52 = r8 + r15
            long r8 = r14.f7542f
            r54 = r8
            long r8 = r14.f7543g
            r56 = r8
            java.lang.Long r0 = r14.f7544h
            r58 = r0
            java.lang.Long r0 = r14.f7545i
            r59 = r0
            java.lang.Long r0 = r14.f7546j
            r60 = r0
            java.lang.Boolean r0 = r14.f7547k
            r61 = r0
            r45.<init>(r46, r47, r48, r50, r52, r54, r56, r58, r59, r60, r61)
        L_0x06b3:
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r0 = r0.zzi()
            r0.d(r7)
            long r8 = r7.f7539c
            java.lang.String r14 = r6.zzh()
            java.lang.Object r0 = r4.get(r14)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x07b8
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r15 = r0.zzi()
            java.lang.String r3 = r10.f7392a
            r15.zzW()
            r15.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r63 = r2
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            android.database.sqlite.SQLiteDatabase r16 = r15.zzh()
            r64 = r5
            r24 = r11
            r11 = r26
            r5 = r27
            java.lang.String[] r18 = new java.lang.String[]{r11, r5}     // Catch:{ SQLiteException -> 0x078f, all -> 0x0787 }
            java.lang.String[] r20 = new java.lang.String[]{r3, r14}     // Catch:{ SQLiteException -> 0x078f, all -> 0x0787 }
            java.lang.String r17 = "event_filters"
            java.lang.String r19 = "app_id=? AND event_name=?"
            r22 = 0
            r23 = 0
            r21 = 0
            r27 = r5
            android.database.Cursor r5 = r16.query(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ SQLiteException -> 0x0789, all -> 0x0787 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0781 }
            if (r0 == 0) goto L_0x0775
            r26 = r11
        L_0x0711:
            r11 = 1
            byte[] r0 = r5.getBlob(r11)     // Catch:{ SQLiteException -> 0x074f }
            com.google.android.gms.internal.measurement.zzej r11 = com.google.android.gms.internal.measurement.zzek.zzc()     // Catch:{ IOException -> 0x0753 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r11, r0)     // Catch:{ IOException -> 0x0753 }
            com.google.android.gms.internal.measurement.zzej r0 = (com.google.android.gms.internal.measurement.zzej) r0     // Catch:{ IOException -> 0x0753 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x0753 }
            com.google.android.gms.internal.measurement.zzek r0 = (com.google.android.gms.internal.measurement.zzek) r0     // Catch:{ IOException -> 0x0753 }
            r11 = 0
            int r16 = r5.getInt(r11)     // Catch:{ SQLiteException -> 0x074f }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x074f }
            java.lang.Object r16 = r2.get(r11)     // Catch:{ SQLiteException -> 0x074f }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x074f }
            if (r16 != 0) goto L_0x0747
            r22 = r7
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0745 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0745 }
            r2.put(r11, r7)     // Catch:{ SQLiteException -> 0x0745 }
            goto L_0x074b
        L_0x0742:
            r0 = move-exception
            goto L_0x07b2
        L_0x0745:
            r0 = move-exception
            goto L_0x0796
        L_0x0747:
            r22 = r7
            r7 = r16
        L_0x074b:
            r7.add(r0)     // Catch:{ SQLiteException -> 0x0745 }
            goto L_0x0767
        L_0x074f:
            r0 = move-exception
            r22 = r7
            goto L_0x0796
        L_0x0753:
            r0 = move-exception
            r22 = r7
            com.google.android.gms.measurement.internal.zzfr r7 = r15.zzt     // Catch:{ SQLiteException -> 0x0745 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzay()     // Catch:{ SQLiteException -> 0x0745 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzd()     // Catch:{ SQLiteException -> 0x0745 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ SQLiteException -> 0x0745 }
            r7.zzc(r13, r11, r0)     // Catch:{ SQLiteException -> 0x0745 }
        L_0x0767:
            boolean r0 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0745 }
            if (r0 != 0) goto L_0x0772
            r5.close()
            r0 = r2
            goto L_0x07ae
        L_0x0772:
            r7 = r22
            goto L_0x0711
        L_0x0775:
            r22 = r7
            r26 = r11
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0745 }
        L_0x077d:
            r5.close()
            goto L_0x07ae
        L_0x0781:
            r0 = move-exception
            r22 = r7
            r26 = r11
            goto L_0x0796
        L_0x0787:
            r0 = move-exception
            goto L_0x0793
        L_0x0789:
            r0 = move-exception
        L_0x078a:
            r22 = r7
            r26 = r11
            goto L_0x0795
        L_0x078f:
            r0 = move-exception
            r27 = r5
            goto L_0x078a
        L_0x0793:
            r5 = 0
            goto L_0x07b2
        L_0x0795:
            r5 = 0
        L_0x0796:
            com.google.android.gms.measurement.internal.zzfr r2 = r15.zzt     // Catch:{ all -> 0x0742 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x0742 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x0742 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r3)     // Catch:{ all -> 0x0742 }
            r2.zzc(r12, r3, r0)     // Catch:{ all -> 0x0742 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0742 }
            if (r5 == 0) goto L_0x07ae
            goto L_0x077d
        L_0x07ae:
            r4.put(r14, r0)
            goto L_0x07c0
        L_0x07b2:
            if (r5 == 0) goto L_0x07b7
            r5.close()
        L_0x07b7:
            throw r0
        L_0x07b8:
            r63 = r2
            r64 = r5
            r22 = r7
            r24 = r11
        L_0x07c0:
            java.util.Set r2 = r0.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x07c8:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0851
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r5 = r3.intValue()
            java.util.Set r7 = r10.f7393b
            boolean r7 = r7.contains(r3)
            if (r7 == 0) goto L_0x07ee
            com.google.android.gms.measurement.internal.zzfr r5 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzj()
            r5.zzb(r1, r3)
            goto L_0x07c8
        L_0x07ee:
            java.lang.Object r7 = r0.get(r3)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r11 = 1
        L_0x07f9:
            boolean r14 = r7.hasNext()
            if (r14 == 0) goto L_0x0840
            java.lang.Object r11 = r7.next()
            com.google.android.gms.internal.measurement.zzek r11 = (com.google.android.gms.internal.measurement.zzek) r11
            com.google.android.gms.measurement.internal.m4 r15 = new com.google.android.gms.measurement.internal.m4
            java.lang.String r14 = r10.f7392a
            r15.<init>(r10, r14, r5, r11)
            java.lang.Long r14 = r10.f7395d
            r23 = r0
            java.lang.Long r0 = r10.f7396e
            int r11 = r11.zzb()
            boolean r21 = r10.c(r5, r11)
            r11 = r14
            r14 = r15
            r25 = r2
            r2 = r15
            r15 = r11
            r16 = r0
            r17 = r6
            r18 = r8
            r20 = r22
            boolean r11 = r14.k(r15, r16, r17, r18, r20, r21)
            if (r11 == 0) goto L_0x083a
            com.google.android.gms.measurement.internal.k4 r0 = r10.b(r3)
            r0.c(r2)
            r0 = r23
            r2 = r25
            goto L_0x07f9
        L_0x083a:
            java.util.Set r0 = r10.f7393b
            r0.add(r3)
            goto L_0x0844
        L_0x0840:
            r23 = r0
            r25 = r2
        L_0x0844:
            if (r11 != 0) goto L_0x084b
            java.util.Set r0 = r10.f7393b
            r0.add(r3)
        L_0x084b:
            r0 = r23
            r2 = r25
            goto L_0x07c8
        L_0x0851:
            r2 = r63
            r5 = r64
            r11 = r24
            r3 = 0
            goto L_0x0615
        L_0x085a:
            boolean r0 = r65.isEmpty()
            if (r0 == 0) goto L_0x0864
        L_0x0860:
            r11 = r26
            goto L_0x0a7b
        L_0x0864:
            androidx.collection.ArrayMap r2 = new androidx.collection.ArrayMap
            r2.<init>()
            java.util.Iterator r3 = r65.iterator()
        L_0x086d:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0860
            java.lang.Object r0 = r3.next()
            r4 = r0
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            java.lang.String r5 = r4.zzf()
            java.lang.Object r0 = r2.get(r5)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x095d
            com.google.android.gms.measurement.internal.zzkt r0 = r10.zzf
            com.google.android.gms.measurement.internal.f r6 = r0.zzi()
            java.lang.String r7 = r10.f7392a
            r6.zzW()
            r6.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r13 = r6.zzh()
            r11 = r26
            r9 = r27
            java.lang.String[] r15 = new java.lang.String[]{r11, r9}     // Catch:{ SQLiteException -> 0x0934, all -> 0x0932 }
            java.lang.String[] r17 = new java.lang.String[]{r7, r5}     // Catch:{ SQLiteException -> 0x0934, all -> 0x0932 }
            java.lang.String r14 = "property_filters"
            java.lang.String r16 = "app_id=? AND property_name=?"
            r19 = 0
            r20 = 0
            r18 = 0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x0934, all -> 0x0932 }
            boolean r0 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x08f4 }
            if (r0 == 0) goto L_0x0926
        L_0x08c3:
            r14 = 1
            byte[] r0 = r13.getBlob(r14)     // Catch:{ SQLiteException -> 0x08f4 }
            com.google.android.gms.internal.measurement.zzes r15 = com.google.android.gms.internal.measurement.zzet.zzc()     // Catch:{ IOException -> 0x0900 }
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.measurement.internal.zzkv.zzl(r15, r0)     // Catch:{ IOException -> 0x0900 }
            com.google.android.gms.internal.measurement.zzes r0 = (com.google.android.gms.internal.measurement.zzes) r0     // Catch:{ IOException -> 0x0900 }
            com.google.android.gms.internal.measurement.zzkf r0 = r0.zzaC()     // Catch:{ IOException -> 0x0900 }
            com.google.android.gms.internal.measurement.zzet r0 = (com.google.android.gms.internal.measurement.zzet) r0     // Catch:{ IOException -> 0x0900 }
            r15 = 0
            int r16 = r13.getInt(r15)     // Catch:{ SQLiteException -> 0x08f4 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r16)     // Catch:{ SQLiteException -> 0x08f4 }
            java.lang.Object r16 = r8.get(r14)     // Catch:{ SQLiteException -> 0x08f4 }
            java.util.List r16 = (java.util.List) r16     // Catch:{ SQLiteException -> 0x08f4 }
            if (r16 != 0) goto L_0x08f8
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x08f4 }
            r15.<init>()     // Catch:{ SQLiteException -> 0x08f4 }
            r8.put(r14, r15)     // Catch:{ SQLiteException -> 0x08f4 }
            goto L_0x08fa
        L_0x08f2:
            r0 = move-exception
            goto L_0x0930
        L_0x08f4:
            r0 = move-exception
            r63 = r3
            goto L_0x093b
        L_0x08f8:
            r15 = r16
        L_0x08fa:
            r15.add(r0)     // Catch:{ SQLiteException -> 0x08f4 }
            r63 = r3
            goto L_0x0916
        L_0x0900:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r14 = r6.zzt     // Catch:{ SQLiteException -> 0x08f4 }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzay()     // Catch:{ SQLiteException -> 0x08f4 }
            com.google.android.gms.measurement.internal.zzef r14 = r14.zzd()     // Catch:{ SQLiteException -> 0x08f4 }
            java.lang.String r15 = "Failed to merge filter"
            r63 = r3
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ SQLiteException -> 0x0924 }
            r14.zzc(r15, r3, r0)     // Catch:{ SQLiteException -> 0x0924 }
        L_0x0916:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteException -> 0x0924 }
            if (r0 != 0) goto L_0x0921
            r13.close()
            r0 = r8
            goto L_0x0953
        L_0x0921:
            r3 = r63
            goto L_0x08c3
        L_0x0924:
            r0 = move-exception
            goto L_0x093b
        L_0x0926:
            r63 = r3
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0924 }
        L_0x092c:
            r13.close()
            goto L_0x0953
        L_0x0930:
            r5 = r13
            goto L_0x0957
        L_0x0932:
            r0 = move-exception
            goto L_0x0938
        L_0x0934:
            r0 = move-exception
            r63 = r3
            goto L_0x093a
        L_0x0938:
            r5 = 0
            goto L_0x0957
        L_0x093a:
            r13 = 0
        L_0x093b:
            com.google.android.gms.measurement.internal.zzfr r3 = r6.zzt     // Catch:{ all -> 0x08f2 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()     // Catch:{ all -> 0x08f2 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()     // Catch:{ all -> 0x08f2 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r7)     // Catch:{ all -> 0x08f2 }
            r3.zzc(r12, r6, r0)     // Catch:{ all -> 0x08f2 }
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x08f2 }
            if (r13 == 0) goto L_0x0953
            goto L_0x092c
        L_0x0953:
            r2.put(r5, r0)
            goto L_0x0963
        L_0x0957:
            if (r5 == 0) goto L_0x095c
            r5.close()
        L_0x095c:
            throw r0
        L_0x095d:
            r63 = r3
            r11 = r26
            r9 = r27
        L_0x0963:
            java.util.Set r3 = r0.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x096b:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0990
            java.lang.Object r5 = r3.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r6 = r5.intValue()
            java.util.Set r7 = r10.f7393b
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto L_0x0998
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            r0.zzb(r1, r5)
        L_0x0990:
            r3 = r63
            r27 = r9
            r26 = r11
            goto L_0x086d
        L_0x0998:
            java.lang.Object r7 = r0.get(r5)
            java.util.List r7 = (java.util.List) r7
            java.util.Iterator r7 = r7.iterator()
            r13 = 1
        L_0x09a3:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0a6e
            java.lang.Object r8 = r7.next()
            com.google.android.gms.internal.measurement.zzet r8 = (com.google.android.gms.internal.measurement.zzet) r8
            com.google.android.gms.measurement.internal.zzfr r13 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()
            java.lang.String r13 = r13.zzq()
            r14 = 2
            boolean r13 = android.util.Log.isLoggable(r13, r14)
            if (r13 == 0) goto L_0x0a09
            com.google.android.gms.measurement.internal.zzfr r13 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r13 = r13.zzay()
            com.google.android.gms.measurement.internal.zzef r13 = r13.zzj()
            boolean r14 = r8.zzj()
            if (r14 == 0) goto L_0x09d9
            int r14 = r8.zza()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x09da
        L_0x09d9:
            r14 = 0
        L_0x09da:
            com.google.android.gms.measurement.internal.zzfr r15 = r10.zzt
            com.google.android.gms.measurement.internal.zzec r15 = r15.zzj()
            r64 = r0
            java.lang.String r0 = r8.zze()
            java.lang.String r0 = r15.zzf(r0)
            java.lang.String r15 = "Evaluating filter. audience, filter, property"
            r13.zzd(r15, r5, r14, r0)
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            com.google.android.gms.measurement.internal.zzkt r13 = r10.zzf
            com.google.android.gms.measurement.internal.zzkv r13 = r13.zzu()
            java.lang.String r13 = r13.zzp(r8)
            java.lang.String r14 = "Filter definition"
            r0.zzb(r14, r13)
            goto L_0x0a0b
        L_0x0a09:
            r64 = r0
        L_0x0a0b:
            boolean r0 = r8.zzj()
            if (r0 == 0) goto L_0x0a44
            int r0 = r8.zza()
            r13 = 256(0x100, float:3.59E-43)
            if (r0 <= r13) goto L_0x0a1a
            goto L_0x0a44
        L_0x0a1a:
            com.google.android.gms.measurement.internal.o4 r0 = new com.google.android.gms.measurement.internal.o4
            java.lang.String r13 = r10.f7392a
            r0.<init>(r10, r13, r6, r8)
            java.lang.Long r13 = r10.f7395d
            java.lang.Long r14 = r10.f7396e
            int r8 = r8.zza()
            boolean r8 = r10.c(r6, r8)
            boolean r13 = r0.k(r13, r14, r4, r8)
            if (r13 == 0) goto L_0x0a3e
            com.google.android.gms.measurement.internal.k4 r8 = r10.b(r5)
            r8.c(r0)
            r0 = r64
            goto L_0x09a3
        L_0x0a3e:
            java.util.Set r0 = r10.f7393b
            r0.add(r5)
            goto L_0x0a70
        L_0x0a44:
            com.google.android.gms.measurement.internal.zzfr r0 = r10.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r6 = r10.f7392a
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r6)
            boolean r7 = r8.zzj()
            if (r7 == 0) goto L_0x0a63
            int r7 = r8.zza()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x0a64
        L_0x0a63:
            r7 = 0
        L_0x0a64:
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Invalid property filter ID. appId, id"
            r0.zzc(r8, r6, r7)
            goto L_0x0a72
        L_0x0a6e:
            r64 = r0
        L_0x0a70:
            if (r13 != 0) goto L_0x0a77
        L_0x0a72:
            java.util.Set r0 = r10.f7393b
            r0.add(r5)
        L_0x0a77:
            r0 = r64
            goto L_0x096b
        L_0x0a7b:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Map r0 = r10.f7394c
            java.util.Set r0 = r0.keySet()
            java.util.Set r2 = r10.f7393b
            r0.removeAll(r2)
            java.util.Iterator r2 = r0.iterator()
        L_0x0a8f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0b1f
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = r0.intValue()
            java.util.Map r4 = r10.f7394c
            java.lang.Object r4 = r4.get(r0)
            com.google.android.gms.measurement.internal.k4 r4 = (com.google.android.gms.measurement.internal.k4) r4
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            com.google.android.gms.internal.measurement.zzfp r3 = r4.a(r3)
            r1.add(r3)
            com.google.android.gms.measurement.internal.zzkt r4 = r10.zzf
            com.google.android.gms.measurement.internal.f r4 = r4.zzi()
            java.lang.String r5 = r10.f7392a
            com.google.android.gms.internal.measurement.zzgi r3 = r3.zzd()
            r4.zzW()
            r4.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbu()
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.String r7 = "app_id"
            r6.put(r7, r5)
            r6.put(r11, r0)
            r7 = r24
            r6.put(r7, r3)
            android.database.sqlite.SQLiteDatabase r0 = r4.zzh()     // Catch:{ SQLiteException -> 0x0b09 }
            java.lang.String r3 = "audience_filter_values"
            r8 = 5
            r9 = 0
            long r12 = r0.insertWithOnConflict(r3, r9, r6, r8)     // Catch:{ SQLiteException -> 0x0b07 }
            r14 = -1
            int r0 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r0 != 0) goto L_0x0b04
            com.google.android.gms.measurement.internal.zzfr r0 = r4.zzt     // Catch:{ SQLiteException -> 0x0b07 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteException -> 0x0b07 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteException -> 0x0b07 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)     // Catch:{ SQLiteException -> 0x0b07 }
            r0.zzb(r3, r6)     // Catch:{ SQLiteException -> 0x0b07 }
        L_0x0b04:
            r24 = r7
            goto L_0x0a8f
        L_0x0b07:
            r0 = move-exception
            goto L_0x0b0b
        L_0x0b09:
            r0 = move-exception
            r9 = 0
        L_0x0b0b:
            com.google.android.gms.measurement.internal.zzfr r3 = r4.zzt
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzay()
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd()
            java.lang.String r4 = "Error storing filter results. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzeh.zzn(r5)
            r3.zzc(r4, r5, r0)
            goto L_0x0b04
        L_0x0b1f:
            return r1
        L_0x0b20:
            if (r5 == 0) goto L_0x0b25
            r5.close()
        L_0x0b25:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.b.a(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final boolean zzb() {
        return false;
    }
}
