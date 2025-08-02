package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzea extends z {
    private final o zza;
    private boolean zzb;

    zzea(zzfr zzfr) {
        super(zzfr);
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        this.zza = new o(this, zzau, "google_app_measurement_local.db");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cf A[SYNTHETIC, Splitter:B:51:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0128 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0128 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0128 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzq(int r17, byte[] r18) {
        /*
            r16 = this;
            r1 = r16
            r16.zzg()
            boolean r0 = r1.zzb
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r17)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r18
            r3.put(r0, r4)
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            r0.zzf()
            r4 = 5
            r5 = r2
            r6 = r4
        L_0x0028:
            if (r5 >= r4) goto L_0x0139
            r7 = 1
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r16.zzh()     // Catch:{ SQLiteFullException -> 0x010c, SQLiteDatabaseLockedException -> 0x00fa, SQLiteException -> 0x00cb, all -> 0x00c7 }
            if (r9 != 0) goto L_0x003e
            r1.zzb = r7     // Catch:{ SQLiteFullException -> 0x003b, SQLiteDatabaseLockedException -> 0x00fb, SQLiteException -> 0x0038 }
            return r2
        L_0x0035:
            r0 = move-exception
            goto L_0x012e
        L_0x0038:
            r0 = move-exception
            goto L_0x00c3
        L_0x003b:
            r0 = move-exception
            goto L_0x00c5
        L_0x003e:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x003b, SQLiteDatabaseLockedException -> 0x00fb, SQLiteException -> 0x0038 }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r8)     // Catch:{ SQLiteFullException -> 0x003b, SQLiteDatabaseLockedException -> 0x00fb, SQLiteException -> 0x0038 }
            r11 = 0
            if (r10 == 0) goto L_0x005c
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            if (r0 == 0) goto L_0x005c
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            goto L_0x005c
        L_0x0056:
            r0 = move-exception
            goto L_0x00ba
        L_0x0058:
            r0 = move-exception
            goto L_0x00bd
        L_0x005a:
            r0 = move-exception
            goto L_0x00c1
        L_0x005c:
            r13 = 100000(0x186a0, double:4.94066E-319)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            java.lang.String r13 = "messages"
            if (r0 < 0) goto L_0x00a7
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            java.lang.String r14 = "Data loss, local db full"
            r0.zza(r14)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            r14 = 100001(0x186a1, double:4.9407E-319)
            long r14 = r14 - r11
            java.lang.String r0 = java.lang.Long.toString(r14)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            java.lang.String r11 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            int r0 = r9.delete(r13, r11, r0)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            long r11 = (long) r0     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            int r0 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            java.lang.String r4 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            java.lang.Long r7 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            long r14 = r14 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            r0.zzd(r4, r2, r7, r11)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
        L_0x00a7:
            r9.insertOrThrow(r13, r8, r3)     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x005a, SQLiteDatabaseLockedException -> 0x00bf, SQLiteException -> 0x0058, all -> 0x0056 }
            if (r10 == 0) goto L_0x00b5
            r10.close()
        L_0x00b5:
            r9.close()
            r2 = 1
            return r2
        L_0x00ba:
            r8 = r10
            goto L_0x012e
        L_0x00bd:
            r8 = r9
            goto L_0x00cd
        L_0x00bf:
            r8 = r10
            goto L_0x00fb
        L_0x00c1:
            r8 = r9
            goto L_0x010e
        L_0x00c3:
            r10 = r8
            goto L_0x00bd
        L_0x00c5:
            r10 = r8
            goto L_0x00c1
        L_0x00c7:
            r0 = move-exception
            r9 = r8
            goto L_0x012e
        L_0x00cb:
            r0 = move-exception
            r10 = r8
        L_0x00cd:
            if (r8 == 0) goto L_0x00db
            boolean r2 = r8.inTransaction()     // Catch:{ all -> 0x00d9 }
            if (r2 == 0) goto L_0x00db
            r8.endTransaction()     // Catch:{ all -> 0x00d9 }
            goto L_0x00db
        L_0x00d9:
            r0 = move-exception
            goto L_0x00f8
        L_0x00db:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x00d9 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00d9 }
            if (r10 == 0) goto L_0x00f2
            r10.close()
        L_0x00f2:
            if (r8 == 0) goto L_0x0128
        L_0x00f4:
            r8.close()
            goto L_0x0128
        L_0x00f8:
            r9 = r8
            goto L_0x00ba
        L_0x00fa:
            r9 = r8
        L_0x00fb:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0035 }
            int r6 = r6 + 20
            if (r8 == 0) goto L_0x0106
            r8.close()
        L_0x0106:
            if (r9 == 0) goto L_0x0128
            r9.close()
            goto L_0x0128
        L_0x010c:
            r0 = move-exception
            r10 = r8
        L_0x010e:
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzay()     // Catch:{ all -> 0x00d9 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd()     // Catch:{ all -> 0x00d9 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x00d9 }
            r2 = 1
            r1.zzb = r2     // Catch:{ all -> 0x00d9 }
            if (r10 == 0) goto L_0x0125
            r10.close()
        L_0x0125:
            if (r8 == 0) goto L_0x0128
            goto L_0x00f4
        L_0x0128:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0028
        L_0x012e:
            if (r8 == 0) goto L_0x0133
            r8.close()
        L_0x0133:
            if (r9 == 0) goto L_0x0138
            r9.close()
        L_0x0138:
            throw r0
        L_0x0139:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzj()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzq(int, byte[]):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean zzf() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzb = true;
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:100|101|102|103) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:85|86|87|88) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:72|73|74|75|204) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        r1.zzt.zzay().zzd().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x0167 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x00fc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x012e */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01fa A[SYNTHETIC, Splitter:B:139:0x01fa] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0214 A[SYNTHETIC, Splitter:B:157:0x0214] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0204 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0266 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0266 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0266 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzi(int r23) {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "Error reading entries from local database"
            java.lang.String r3 = "rowid"
            r22.zzg()
            boolean r0 = r1.zzb
            r4 = 0
            if (r0 == 0) goto L_0x000f
            return r4
        L_0x000f:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            boolean r0 = r22.zzl()
            if (r0 == 0) goto L_0x0285
            r6 = 5
            r7 = 0
            r9 = r6
            r8 = r7
        L_0x001e:
            if (r8 >= r6) goto L_0x0275
            r10 = 1
            android.database.sqlite.SQLiteDatabase r15 = r22.zzh()     // Catch:{ SQLiteFullException -> 0x024c, SQLiteDatabaseLockedException -> 0x0239, SQLiteException -> 0x020f, all -> 0x020b }
            if (r15 != 0) goto L_0x0039
            r1.zzb = r10     // Catch:{ SQLiteFullException -> 0x0035, SQLiteDatabaseLockedException -> 0x0032, SQLiteException -> 0x002e, all -> 0x002a }
            return r4
        L_0x002a:
            r0 = move-exception
            r14 = r15
            goto L_0x01e6
        L_0x002e:
            r0 = move-exception
            r14 = r15
            goto L_0x0205
        L_0x0032:
            r14 = r15
            goto L_0x0207
        L_0x0035:
            r0 = move-exception
            r14 = r15
            goto L_0x0209
        L_0x0039:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0035, SQLiteDatabaseLockedException -> 0x0032, SQLiteException -> 0x002e, all -> 0x002a }
            java.lang.String r0 = "3"
            java.lang.String r12 = "messages"
            java.lang.String[] r13 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01f5 }
            java.lang.String r14 = "type=?"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x01f5 }
            java.lang.String r18 = "rowid desc"
            java.lang.String r19 = "1"
            r16 = 0
            r17 = 0
            r11 = r15
            r23 = r15
            r15 = r0
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ all -> 0x01f1 }
            boolean r0 = r11.moveToFirst()     // Catch:{ all -> 0x007d }
            r20 = -1
            if (r0 == 0) goto L_0x0082
            long r12 = r11.getLong(r7)     // Catch:{ all -> 0x007d }
            r11.close()     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            goto L_0x0087
        L_0x006a:
            r0 = move-exception
            r14 = r23
            goto L_0x01e6
        L_0x006f:
            r0 = move-exception
            r14 = r23
            goto L_0x0205
        L_0x0074:
            r14 = r23
            goto L_0x0207
        L_0x0078:
            r0 = move-exception
            r14 = r23
            goto L_0x0209
        L_0x007d:
            r0 = move-exception
            r14 = r23
            goto L_0x01f8
        L_0x0082:
            r11.close()     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            r12 = r20
        L_0x0087:
            int r0 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            r11[r7] = r12     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            r14 = r0
            r15 = r11
            goto L_0x009a
        L_0x0098:
            r14 = r4
            r15 = r14
        L_0x009a:
            java.lang.String r0 = "type"
            java.lang.String r11 = "entry"
            java.lang.String[] r13 = new java.lang.String[]{r3, r0, r11}     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            java.lang.String r12 = "messages"
            java.lang.String r18 = "rowid asc"
            r0 = 100
            java.lang.String r19 = java.lang.Integer.toString(r0)     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
            r16 = 0
            r17 = 0
            r11 = r23
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ SQLiteFullException -> 0x0078, SQLiteDatabaseLockedException -> 0x0074, SQLiteException -> 0x006f, all -> 0x006a }
        L_0x00b6:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            if (r0 == 0) goto L_0x01aa
            long r20 = r11.getLong(r7)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            int r0 = r11.getInt(r10)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            r12 = 2
            byte[] r13 = r11.getBlob(r12)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            if (r0 != 0) goto L_0x0113
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x00fc }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x00fc }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x00fc }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzaw> r0 = com.google.android.gms.measurement.internal.zzaw.CREATOR     // Catch:{ ParseException -> 0x00fc }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x00fc }
            com.google.android.gms.measurement.internal.zzaw r0 = (com.google.android.gms.measurement.internal.zzaw) r0     // Catch:{ ParseException -> 0x00fc }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            if (r0 == 0) goto L_0x00b6
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x00b6
        L_0x00e7:
            r0 = move-exception
            r14 = r23
            goto L_0x01e5
        L_0x00ec:
            r0 = move-exception
            r14 = r23
            goto L_0x01e9
        L_0x00f1:
            r14 = r23
            goto L_0x01eb
        L_0x00f5:
            r0 = move-exception
            r14 = r23
            goto L_0x01ee
        L_0x00fa:
            r0 = move-exception
            goto L_0x010f
        L_0x00fc:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x00fa }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x00fa }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x00fa }
            java.lang.String r13 = "Failed to load event from local database"
            r0.zza(r13)     // Catch:{ all -> 0x00fa }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x00b6
        L_0x010f:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            throw r0     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
        L_0x0113:
            if (r0 != r10) goto L_0x014c
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x012e }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x012e }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x012e }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkw> r0 = com.google.android.gms.measurement.internal.zzkw.CREATOR     // Catch:{ ParseException -> 0x012e }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x012e }
            com.google.android.gms.measurement.internal.zzkw r0 = (com.google.android.gms.measurement.internal.zzkw) r0     // Catch:{ ParseException -> 0x012e }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x0141
        L_0x012c:
            r0 = move-exception
            goto L_0x0148
        L_0x012e:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x012c }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x012c }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.zza(r13)     // Catch:{ all -> 0x012c }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            r0 = r4
        L_0x0141:
            if (r0 == 0) goto L_0x00b6
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x00b6
        L_0x0148:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            throw r0     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
        L_0x014c:
            if (r0 != r12) goto L_0x0185
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            int r0 = r13.length     // Catch:{ ParseException -> 0x0167 }
            r12.unmarshall(r13, r7, r0)     // Catch:{ ParseException -> 0x0167 }
            r12.setDataPosition(r7)     // Catch:{ ParseException -> 0x0167 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzac> r0 = com.google.android.gms.measurement.internal.zzac.CREATOR     // Catch:{ ParseException -> 0x0167 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ ParseException -> 0x0167 }
            com.google.android.gms.measurement.internal.zzac r0 = (com.google.android.gms.measurement.internal.zzac) r0     // Catch:{ ParseException -> 0x0167 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x017a
        L_0x0165:
            r0 = move-exception
            goto L_0x0181
        L_0x0167:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ all -> 0x0165 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ all -> 0x0165 }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r0.zza(r13)     // Catch:{ all -> 0x0165 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            r0 = r4
        L_0x017a:
            if (r0 == 0) goto L_0x00b6
            r5.add(r0)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x00b6
        L_0x0181:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            throw r0     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
        L_0x0185:
            r12 = 3
            if (r0 != r12) goto L_0x0199
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            java.lang.String r12 = "Skipping app launch break"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x00b6
        L_0x0199:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            java.lang.String r12 = "Unknown record type in local database"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            goto L_0x00b6
        L_0x01aa:
            java.lang.String r0 = java.lang.Long.toString(r20)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x00f1, SQLiteException -> 0x00ec, all -> 0x00e7 }
            java.lang.String r12 = "messages"
            java.lang.String r13 = "rowid <= ?"
            r14 = r23
            int r0 = r14.delete(r12, r13, r0)     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            int r12 = r5.size()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            if (r0 >= r12) goto L_0x01d8
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzd()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            java.lang.String r12 = "Fewer entries removed from local database than expected"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            goto L_0x01d8
        L_0x01d2:
            r0 = move-exception
            goto L_0x01e5
        L_0x01d4:
            r0 = move-exception
            goto L_0x01e9
        L_0x01d6:
            r0 = move-exception
            goto L_0x01ee
        L_0x01d8:
            r14.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            r14.endTransaction()     // Catch:{ SQLiteFullException -> 0x01d6, SQLiteDatabaseLockedException -> 0x01eb, SQLiteException -> 0x01d4, all -> 0x01d2 }
            r11.close()
            r14.close()
            return r5
        L_0x01e5:
            r4 = r11
        L_0x01e6:
            r15 = r14
            goto L_0x026a
        L_0x01e9:
            r15 = r14
            goto L_0x0212
        L_0x01eb:
            r15 = r14
            goto L_0x023b
        L_0x01ee:
            r15 = r14
            goto L_0x024f
        L_0x01f1:
            r0 = move-exception
            r14 = r23
            goto L_0x01f7
        L_0x01f5:
            r0 = move-exception
            r14 = r15
        L_0x01f7:
            r11 = r4
        L_0x01f8:
            if (r11 == 0) goto L_0x0204
            r11.close()     // Catch:{ SQLiteFullException -> 0x0202, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x0200, all -> 0x01fe }
            goto L_0x0204
        L_0x01fe:
            r0 = move-exception
            goto L_0x01e6
        L_0x0200:
            r0 = move-exception
            goto L_0x0205
        L_0x0202:
            r0 = move-exception
            goto L_0x0209
        L_0x0204:
            throw r0     // Catch:{ SQLiteFullException -> 0x0202, SQLiteDatabaseLockedException -> 0x0207, SQLiteException -> 0x0200, all -> 0x01fe }
        L_0x0205:
            r11 = r4
            goto L_0x01e9
        L_0x0207:
            r11 = r4
            goto L_0x01eb
        L_0x0209:
            r11 = r4
            goto L_0x01ee
        L_0x020b:
            r0 = move-exception
            r15 = r4
            goto L_0x026a
        L_0x020f:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x0212:
            if (r15 == 0) goto L_0x0220
            boolean r12 = r15.inTransaction()     // Catch:{ all -> 0x021e }
            if (r12 == 0) goto L_0x0220
            r15.endTransaction()     // Catch:{ all -> 0x021e }
            goto L_0x0220
        L_0x021e:
            r0 = move-exception
            goto L_0x0237
        L_0x0220:
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzt     // Catch:{ all -> 0x021e }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ all -> 0x021e }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ all -> 0x021e }
            r12.zzb(r2, r0)     // Catch:{ all -> 0x021e }
            r1.zzb = r10     // Catch:{ all -> 0x021e }
            if (r11 == 0) goto L_0x0234
            r11.close()
        L_0x0234:
            if (r15 == 0) goto L_0x0266
            goto L_0x0248
        L_0x0237:
            r4 = r11
            goto L_0x026a
        L_0x0239:
            r11 = r4
            r15 = r11
        L_0x023b:
            long r12 = (long) r9
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x021e }
            int r9 = r9 + 20
            if (r11 == 0) goto L_0x0246
            r11.close()
        L_0x0246:
            if (r15 == 0) goto L_0x0266
        L_0x0248:
            r15.close()
            goto L_0x0266
        L_0x024c:
            r0 = move-exception
            r11 = r4
            r15 = r11
        L_0x024f:
            com.google.android.gms.measurement.internal.zzfr r12 = r1.zzt     // Catch:{ all -> 0x021e }
            com.google.android.gms.measurement.internal.zzeh r12 = r12.zzay()     // Catch:{ all -> 0x021e }
            com.google.android.gms.measurement.internal.zzef r12 = r12.zzd()     // Catch:{ all -> 0x021e }
            r12.zzb(r2, r0)     // Catch:{ all -> 0x021e }
            r1.zzb = r10     // Catch:{ all -> 0x021e }
            if (r11 == 0) goto L_0x0263
            r11.close()
        L_0x0263:
            if (r15 == 0) goto L_0x0266
            goto L_0x0248
        L_0x0266:
            int r8 = r8 + 1
            goto L_0x001e
        L_0x026a:
            if (r4 == 0) goto L_0x026f
            r4.close()
        L_0x026f:
            if (r15 == 0) goto L_0x0274
            r15.close()
        L_0x0274:
            throw r0
        L_0x0275:
            com.google.android.gms.measurement.internal.zzfr r0 = r1.zzt
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzay()
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzk()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.zza(r2)
            return r4
        L_0x0285:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzi(int):java.util.List");
    }

    @WorkerThread
    public final void zzj() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh != null && (delete = zzh.delete("messages", (String) null, (String[]) null)) > 0) {
                this.zzt.zzay().zzj().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            this.zzt.zzay().zzd().zzb("Error resetting local analytics data. error", e10);
        }
    }

    @WorkerThread
    public final boolean zzk() {
        return zzq(3, new byte[0]);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean zzl() {
        Context zzau = this.zzt.zzau();
        this.zzt.zzf();
        return zzau.getDatabasePath("google_app_measurement_local.db").exists();
    }

    @WorkerThread
    public final boolean zzm() {
        zzg();
        if (!this.zzb && zzl()) {
            int i10 = 5;
            int i11 = 0;
            while (i11 < 5) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzh = zzh();
                    if (zzh == null) {
                        this.zzb = true;
                        return false;
                    }
                    zzh.beginTransaction();
                    zzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzh.setTransactionSuccessful();
                    zzh.endTransaction();
                    zzh.close();
                    return true;
                } catch (SQLiteFullException e10) {
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e10);
                    this.zzb = true;
                    if (sQLiteDatabase == null) {
                        i11++;
                    }
                    sQLiteDatabase.close();
                    i11++;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i10);
                    i10 += 20;
                    if (sQLiteDatabase == null) {
                        i11++;
                    }
                    sQLiteDatabase.close();
                    i11++;
                } catch (SQLiteException e11) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.zzt.zzay().zzd().zzb("Error deleting app launch break from local database", e11);
                    this.zzb = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                        i11++;
                    } else {
                        i11++;
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
            this.zzt.zzay().zzk().zza("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean zzn(zzac zzac) {
        byte[] zzan = this.zzt.zzv().zzan(zzac);
        if (zzan.length <= 131072) {
            return zzq(2, zzan);
        }
        this.zzt.zzay().zzh().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzo(zzaw zzaw) {
        Parcel obtain = Parcel.obtain();
        zzax.zza(zzaw, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(0, marshall);
        }
        this.zzt.zzay().zzh().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzp(zzkw zzkw) {
        Parcel obtain = Parcel.obtain();
        zzkx.zza(zzkw, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzq(1, marshall);
        }
        this.zzt.zzay().zzh().zza("User property too long for local database. Sending directly to service");
        return false;
    }
}
