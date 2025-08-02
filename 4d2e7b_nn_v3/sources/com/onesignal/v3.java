package com.onesignal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.onesignal.o3;
import java.util.ArrayList;
import pa.i;

class v3 extends SQLiteOpenHelper implements u3 {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f11088a = new Object();

    /* renamed from: b  reason: collision with root package name */
    protected static final String[] f11089b = {"CREATE INDEX notification_notification_id_idx ON notification(notification_id); ", "CREATE INDEX notification_android_notification_id_idx ON notification(android_notification_id); ", "CREATE INDEX notification_group_id_idx ON notification(group_id); ", "CREATE INDEX notification_collapse_id_idx ON notification(collapse_id); ", "CREATE INDEX notification_created_time_idx ON notification(created_time); ", "CREATE INDEX notification_expire_time_idx ON notification(expire_time); "};

    /* renamed from: c  reason: collision with root package name */
    private static c2 f11090c = new b2();

    /* renamed from: d  reason: collision with root package name */
    private static v3 f11091d;

    /* renamed from: e  reason: collision with root package name */
    private static i f11092e = new i();

    v3(Context context) {
        super(context, "OneSignal.db", (SQLiteDatabase.CursorFactory) null, m());
    }

    private static void A(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (SQLiteException e10) {
            e10.printStackTrace();
        }
    }

    private static void B(SQLiteDatabase sQLiteDatabase) {
        f11092e.b(sQLiteDatabase);
    }

    private static void C(SQLiteDatabase sQLiteDatabase) {
        A(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        A(sQLiteDatabase, "CREATE INDEX notification_group_id_idx ON notification(group_id); ");
    }

    private static void E(SQLiteDatabase sQLiteDatabase) {
        A(sQLiteDatabase, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        A(sQLiteDatabase, "UPDATE notification SET expire_time = created_time + 259200;");
        A(sQLiteDatabase, "CREATE INDEX notification_expire_time_idx ON notification(expire_time); ");
    }

    private static void G(SQLiteDatabase sQLiteDatabase) {
        A(sQLiteDatabase, "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_ids TEXT,name TEXT,session TEXT,params TEXT,timestamp TIMESTAMP);");
    }

    private static void H(SQLiteDatabase sQLiteDatabase) {
        A(sQLiteDatabase, "CREATE TABLE cached_unique_outcome_notification (_id INTEGER PRIMARY KEY,notification_id TEXT,name TEXT);");
        B(sQLiteDatabase);
    }

    private static void I(SQLiteDatabase sQLiteDatabase) {
        A(sQLiteDatabase, "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);");
    }

    private void J(SQLiteDatabase sQLiteDatabase) {
        f11092e.c(sQLiteDatabase);
        f11092e.a(sQLiteDatabase);
    }

    private static int m() {
        return 8;
    }

    public static v3 n(Context context) {
        if (f11091d == null) {
            synchronized (f11088a) {
                try {
                    if (f11091d == null) {
                        f11091d = new v3(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f11091d;
    }

    private SQLiteDatabase p() {
        SQLiteDatabase writableDatabase;
        synchronized (f11088a) {
            try {
                writableDatabase = getWritableDatabase();
            } catch (SQLiteCantOpenDatabaseException e10) {
                e = e10;
                throw e;
            } catch (SQLiteDatabaseLockedException e11) {
                e = e11;
                throw e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return writableDatabase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0012 A[Catch:{ SQLiteCantOpenDatabaseException -> 0x000f, SQLiteDatabaseLockedException -> 0x000d, all -> 0x000b }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0018 A[Catch:{ SQLiteCantOpenDatabaseException -> 0x000f, SQLiteDatabaseLockedException -> 0x000d, all -> 0x000b }, LOOP:0: B:3:0x0005->B:17:0x0018, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x001f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.database.sqlite.SQLiteDatabase v() {
        /*
            r5 = this;
            java.lang.Object r0 = f11088a
            monitor-enter(r0)
            r1 = 0
            r2 = 0
        L_0x0005:
            android.database.sqlite.SQLiteDatabase r1 = r5.p()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x000f, SQLiteDatabaseLockedException -> 0x000d }
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            return r1
        L_0x000b:
            r1 = move-exception
            goto L_0x0020
        L_0x000d:
            r3 = move-exception
            goto L_0x0010
        L_0x000f:
            r3 = move-exception
        L_0x0010:
            if (r1 != 0) goto L_0x0013
            r1 = r3
        L_0x0013:
            int r2 = r2 + 1
            r3 = 5
            if (r2 >= r3) goto L_0x001f
            int r3 = r2 * 400
            long r3 = (long) r3     // Catch:{ all -> 0x000b }
            android.os.SystemClock.sleep(r3)     // Catch:{ all -> 0x000b }
            goto L_0x0005
        L_0x001f:
            throw r1     // Catch:{ all -> 0x000b }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x000b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v3.v():android.database.sqlite.SQLiteDatabase");
    }

    private void y(SQLiteDatabase sQLiteDatabase, int i10) {
        if (i10 < 2) {
            C(sQLiteDatabase);
        }
        if (i10 < 3) {
            E(sQLiteDatabase);
        }
        if (i10 < 4) {
            G(sQLiteDatabase);
        }
        if (i10 < 5) {
            H(sQLiteDatabase);
        }
        if (i10 == 5) {
            B(sQLiteDatabase);
        }
        if (i10 < 7) {
            I(sQLiteDatabase);
        }
        if (i10 < 8) {
            J(sQLiteDatabase);
        }
    }

    static StringBuilder z() {
        long b10 = o3.w0().b() / 1000;
        StringBuilder sb2 = new StringBuilder("created_time > " + (b10 - 604800) + " AND " + "dismissed" + " = 0 AND " + "opened" + " = 0 AND " + "is_summary" + " = 0");
        if (o3.k0().l()) {
            sb2.append(" AND expire_time > " + b10);
        }
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b5, code lost:
        if (r2 != null) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r2.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00bb, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c4, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c5, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cc, code lost:
        throw r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x0020, B:23:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(java.lang.String r7, android.content.ContentValues r8, java.lang.String r9, java.lang.String[] r10) {
        /*
            r6 = this;
            r0 = 0
            if (r8 == 0) goto L_0x00cf
            java.lang.String r1 = r8.toString()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x000f
            goto L_0x00cf
        L_0x000f:
            java.lang.Object r1 = f11088a
            monitor-enter(r1)
            android.database.sqlite.SQLiteDatabase r2 = r6.v()     // Catch:{ all -> 0x0025 }
            r2.beginTransaction()     // Catch:{ SQLiteException -> 0x0041, IllegalStateException -> 0x003f }
            int r0 = r2.update(r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0041, IllegalStateException -> 0x003f }
            r2.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0041, IllegalStateException -> 0x003f }
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0032, SQLiteException -> 0x0028 }
            goto L_0x00b3
        L_0x0025:
            r7 = move-exception
            goto L_0x00cd
        L_0x0028:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x002d:
            r8.a(r9, r7)     // Catch:{ all -> 0x0025 }
            goto L_0x00b3
        L_0x0032:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x0037:
            r8.a(r9, r7)     // Catch:{ all -> 0x0025 }
            goto L_0x00b3
        L_0x003c:
            r7 = move-exception
            goto L_0x00b5
        L_0x003f:
            r8 = move-exception
            goto L_0x0043
        L_0x0041:
            r8 = move-exception
            goto L_0x007b
        L_0x0043:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r4.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "Error under update transaction under table: "
            r4.append(r5)     // Catch:{ all -> 0x003c }
            r4.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = " with whereClause: "
            r4.append(r7)     // Catch:{ all -> 0x003c }
            r4.append(r9)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = " and whereArgs: "
            r4.append(r7)     // Catch:{ all -> 0x003c }
            r4.append(r10)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x003c }
            r3.a(r7, r8)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x00b3
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0075, SQLiteException -> 0x006f }
            goto L_0x00b3
        L_0x006f:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x002d
        L_0x0075:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0037
        L_0x007b:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x003c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x003c }
            r4.<init>()     // Catch:{ all -> 0x003c }
            java.lang.String r5 = "Error updating on table: "
            r4.append(r5)     // Catch:{ all -> 0x003c }
            r4.append(r7)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = " with whereClause: "
            r4.append(r7)     // Catch:{ all -> 0x003c }
            r4.append(r9)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = " and whereArgs: "
            r4.append(r7)     // Catch:{ all -> 0x003c }
            r4.append(r10)     // Catch:{ all -> 0x003c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x003c }
            r3.a(r7, r8)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x00b3
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x00ad, SQLiteException -> 0x00a7 }
            goto L_0x00b3
        L_0x00a7:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x002d
        L_0x00ad:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0037
        L_0x00b3:
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            return r0
        L_0x00b5:
            if (r2 == 0) goto L_0x00cc
            r2.endTransaction()     // Catch:{ IllegalStateException -> 0x00c4, SQLiteException -> 0x00bb }
            goto L_0x00cc
        L_0x00bb:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r10 = "Error closing transaction! "
            r9.a(r10, r8)     // Catch:{ all -> 0x0025 }
            goto L_0x00cc
        L_0x00c4:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0025 }
            java.lang.String r10 = "Error closing transaction! "
            r9.a(r10, r8)     // Catch:{ all -> 0x0025 }
        L_0x00cc:
            throw r7     // Catch:{ all -> 0x0025 }
        L_0x00cd:
            monitor-exit(r1)     // Catch:{ all -> 0x0025 }
            throw r7
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v3.a(java.lang.String, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    public Cursor b(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        Cursor query;
        synchronized (f11088a) {
            query = v().query(str, strArr, str2, strArr2, str3, str4, str5, str6);
        }
        return query;
    }

    public Cursor h(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        Cursor query;
        synchronized (f11088a) {
            query = v().query(str, strArr, str2, strArr2, str3, str4, str5);
        }
        return query;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a5, code lost:
        if (r1 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r7 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0010, B:19:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j(java.lang.String r7, java.lang.String r8, java.lang.String[] r9) {
        /*
            r6 = this;
            java.lang.Object r0 = f11088a
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r6.v()     // Catch:{ all -> 0x0015 }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.delete(r7, r8, r9)     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x0022, SQLiteException -> 0x0018 }
            goto L_0x00a3
        L_0x0015:
            r7 = move-exception
            goto L_0x00bd
        L_0x0018:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x001d:
            r8.a(r9, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x00a3
        L_0x0022:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x0027:
            r8.a(r9, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x00a3
        L_0x002c:
            r7 = move-exception
            goto L_0x00a5
        L_0x002f:
            r2 = move-exception
            goto L_0x0033
        L_0x0031:
            r2 = move-exception
            goto L_0x006b
        L_0x0033:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "Error under delete transaction under table: "
            r4.append(r5)     // Catch:{ all -> 0x002c }
            r4.append(r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " with whereClause: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " and whereArgs: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r7, r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00a3
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x0065, SQLiteException -> 0x005f }
            goto L_0x00a3
        L_0x005f:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x001d
        L_0x0065:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0027
        L_0x006b:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "Error deleting on table: "
            r4.append(r5)     // Catch:{ all -> 0x002c }
            r4.append(r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " with whereClause: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " and whereArgs: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r7, r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00a3
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x0097 }
            goto L_0x00a3
        L_0x0097:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x001d
        L_0x009d:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0027
        L_0x00a3:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x00a5:
            if (r1 == 0) goto L_0x00bc
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x00b4, SQLiteException -> 0x00ab }
            goto L_0x00bc
        L_0x00ab:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = "Error closing transaction! "
            r9.a(r1, r8)     // Catch:{ all -> 0x0015 }
            goto L_0x00bc
        L_0x00b4:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = "Error closing transaction! "
            r9.a(r1, r8)     // Catch:{ all -> 0x0015 }
        L_0x00bc:
            throw r7     // Catch:{ all -> 0x0015 }
        L_0x00bd:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v3.j(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a5, code lost:
        if (r1 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r7 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0010, B:19:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(java.lang.String r7, java.lang.String r8, android.content.ContentValues r9) {
        /*
            r6 = this;
            java.lang.Object r0 = f11088a
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r6.v()     // Catch:{ all -> 0x0015 }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.insert(r7, r8, r9)     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x0022, SQLiteException -> 0x0018 }
            goto L_0x00a3
        L_0x0015:
            r7 = move-exception
            goto L_0x00bd
        L_0x0018:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x001d:
            r8.a(r9, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x00a3
        L_0x0022:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x0027:
            r8.a(r9, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x00a3
        L_0x002c:
            r7 = move-exception
            goto L_0x00a5
        L_0x002f:
            r2 = move-exception
            goto L_0x0033
        L_0x0031:
            r2 = move-exception
            goto L_0x006b
        L_0x0033:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "Error under inserting transaction under table: "
            r4.append(r5)     // Catch:{ all -> 0x002c }
            r4.append(r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " with nullColumnHack: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " and values: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r7, r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00a3
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x0065, SQLiteException -> 0x005f }
            goto L_0x00a3
        L_0x005f:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x001d
        L_0x0065:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0027
        L_0x006b:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "Error inserting on table: "
            r4.append(r5)     // Catch:{ all -> 0x002c }
            r4.append(r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " with nullColumnHack: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " and values: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r7, r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00a3
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x0097 }
            goto L_0x00a3
        L_0x0097:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x001d
        L_0x009d:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0027
        L_0x00a3:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x00a5:
            if (r1 == 0) goto L_0x00bc
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x00b4, SQLiteException -> 0x00ab }
            goto L_0x00bc
        L_0x00ab:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = "Error closing transaction! "
            r9.a(r1, r8)     // Catch:{ all -> 0x0015 }
            goto L_0x00bc
        L_0x00b4:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = "Error closing transaction! "
            r9.a(r1, r8)     // Catch:{ all -> 0x0015 }
        L_0x00bc:
            throw r7     // Catch:{ all -> 0x0015 }
        L_0x00bd:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v3.k(java.lang.String, java.lang.String, android.content.ContentValues):void");
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f11088a) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime('%s', 'now')),expire_time TIMESTAMP);");
                sQLiteDatabase.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_influence_type TEXT,iam_influence_type TEXT,notification_ids TEXT,iam_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT);");
                sQLiteDatabase.execSQL("CREATE TABLE cached_unique_outcome (_id INTEGER PRIMARY KEY,channel_influence_id TEXT,channel_type TEXT,name TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);");
                for (String execSQL : f11089b) {
                    sQLiteDatabase.execSQL(execSQL);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Cursor rawQuery;
        o3.a(o3.v.WARN, "SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.");
        synchronized (f11088a) {
            try {
                rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", (String[]) null);
                ArrayList<String> arrayList = new ArrayList<>(rawQuery.getCount());
                while (rawQuery.moveToNext()) {
                    arrayList.add(rawQuery.getString(0));
                }
                for (String str : arrayList) {
                    if (!str.startsWith("sqlite_")) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                    }
                }
                rawQuery.close();
                onCreate(sQLiteDatabase);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        o3.v vVar = o3.v.DEBUG;
        o3.a(vVar, "OneSignal Database onUpgrade from: " + i10 + " to: " + i11);
        synchronized (f11088a) {
            try {
                y(sQLiteDatabase, i10);
            } catch (SQLiteException e10) {
                o3.b(o3.v.ERROR, "Error in upgrade, migration may have already run! Skipping!", e10);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        r7 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        r8 = f11090c;
        r9 = "Error closing transaction! ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a5, code lost:
        if (r1 != null) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r1.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ab, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b4, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        f11090c.a("Error closing transaction! ", r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r7 = e;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x0010, B:19:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w(java.lang.String r7, java.lang.String r8, android.content.ContentValues r9) {
        /*
            r6 = this;
            java.lang.Object r0 = f11088a
            monitor-enter(r0)
            android.database.sqlite.SQLiteDatabase r1 = r6.v()     // Catch:{ all -> 0x0015 }
            r1.beginTransaction()     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.insertOrThrow(r7, r8, r9)     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0031, IllegalStateException -> 0x002f }
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x0022, SQLiteException -> 0x0018 }
            goto L_0x00a3
        L_0x0015:
            r7 = move-exception
            goto L_0x00bd
        L_0x0018:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x001d:
            r8.a(r9, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x00a3
        L_0x0022:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
        L_0x0027:
            r8.a(r9, r7)     // Catch:{ all -> 0x0015 }
            goto L_0x00a3
        L_0x002c:
            r7 = move-exception
            goto L_0x00a5
        L_0x002f:
            r2 = move-exception
            goto L_0x0033
        L_0x0031:
            r2 = move-exception
            goto L_0x006b
        L_0x0033:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "Error under inserting or throw transaction under table: "
            r4.append(r5)     // Catch:{ all -> 0x002c }
            r4.append(r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " with nullColumnHack: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " and values: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r7, r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00a3
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x0065, SQLiteException -> 0x005f }
            goto L_0x00a3
        L_0x005f:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x001d
        L_0x0065:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0027
        L_0x006b:
            com.onesignal.c2 r3 = f11090c     // Catch:{ all -> 0x002c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r4.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = "Error inserting or throw on table: "
            r4.append(r5)     // Catch:{ all -> 0x002c }
            r4.append(r7)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " with nullColumnHack: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r8)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = " and values: "
            r4.append(r7)     // Catch:{ all -> 0x002c }
            r4.append(r9)     // Catch:{ all -> 0x002c }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x002c }
            r3.a(r7, r2)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x00a3
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x009d, SQLiteException -> 0x0097 }
            goto L_0x00a3
        L_0x0097:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x001d
        L_0x009d:
            r7 = move-exception
            com.onesignal.c2 r8 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r9 = "Error closing transaction! "
            goto L_0x0027
        L_0x00a3:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            return
        L_0x00a5:
            if (r1 == 0) goto L_0x00bc
            r1.endTransaction()     // Catch:{ IllegalStateException -> 0x00b4, SQLiteException -> 0x00ab }
            goto L_0x00bc
        L_0x00ab:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = "Error closing transaction! "
            r9.a(r1, r8)     // Catch:{ all -> 0x0015 }
            goto L_0x00bc
        L_0x00b4:
            r8 = move-exception
            com.onesignal.c2 r9 = f11090c     // Catch:{ all -> 0x0015 }
            java.lang.String r1 = "Error closing transaction! "
            r9.a(r1, r8)     // Catch:{ all -> 0x0015 }
        L_0x00bc:
            throw r7     // Catch:{ all -> 0x0015 }
        L_0x00bd:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.v3.w(java.lang.String, java.lang.String, android.content.ContentValues):void");
    }
}
