package com.reactnativecommunity.asyncstorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class k extends SQLiteOpenHelper {

    /* renamed from: d  reason: collision with root package name */
    private static k f11211d;

    /* renamed from: a  reason: collision with root package name */
    private Context f11212a;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f11213b;

    /* renamed from: c  reason: collision with root package name */
    private long f11214c = (j.f11210a.longValue() * 1048576);

    private k(Context context) {
        super(context, "RKStorage", (SQLiteDatabase.CursorFactory) null, 1);
        this.f11212a = context;
    }

    private synchronized boolean j() {
        h();
        return this.f11212a.deleteDatabase("RKStorage");
    }

    public static k n(Context context) {
        if (f11211d == null) {
            f11211d = new k(context.getApplicationContext());
        }
        return f11211d;
    }

    /* access modifiers changed from: package-private */
    public synchronized void a() {
        m().delete("catalystLocalStorage", (String) null, (String[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        throw new java.lang.RuntimeException("Clearing and deleting database RKStorage failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (j() != false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        z2.a.b("ReactNative", "Deleted Local Database RKStorage");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.a()     // Catch:{ Exception -> 0x0012 }
            r2.h()     // Catch:{ Exception -> 0x0012 }
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Cleaned RKStorage"
            z2.a.b(r0, r1)     // Catch:{ Exception -> 0x0012 }
            monitor-exit(r2)
            return
        L_0x0010:
            r0 = move-exception
            goto L_0x0029
        L_0x0012:
            boolean r0 = r2.j()     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Deleted Local Database RKStorage"
            z2.a.b(r0, r1)     // Catch:{ all -> 0x0010 }
            monitor-exit(r2)
            return
        L_0x0021:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = "Clearing and deleting database RKStorage failed"
            r0.<init>(r1)     // Catch:{ all -> 0x0010 }
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x0029:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.k.b():void");
    }

    public synchronized void h() {
        SQLiteDatabase sQLiteDatabase = this.f11213b;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            this.f11213b.close();
            this.f11213b = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:15|16|18|19|20|21|22|35|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0031, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean k() {
        /*
            r5 = this;
            monitor-enter(r5)
            android.database.sqlite.SQLiteDatabase r0 = r5.f11213b     // Catch:{ all -> 0x000e }
            r1 = 1
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0010
            monitor-exit(r5)
            return r1
        L_0x000e:
            r0 = move-exception
            goto L_0x0040
        L_0x0010:
            r0 = 0
            r2 = 0
        L_0x0012:
            r3 = 2
            if (r2 >= r3) goto L_0x0034
            if (r2 <= 0) goto L_0x001d
            r5.j()     // Catch:{ SQLiteException -> 0x001b }
            goto L_0x001d
        L_0x001b:
            r0 = move-exception
            goto L_0x0024
        L_0x001d:
            android.database.sqlite.SQLiteDatabase r3 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x001b }
            r5.f11213b = r3     // Catch:{ SQLiteException -> 0x001b }
            goto L_0x0034
        L_0x0024:
            r3 = 30
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x002a }
            goto L_0x0031
        L_0x002a:
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x000e }
            r3.interrupt()     // Catch:{ all -> 0x000e }
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x0012
        L_0x0034:
            android.database.sqlite.SQLiteDatabase r2 = r5.f11213b     // Catch:{ all -> 0x000e }
            if (r2 == 0) goto L_0x003f
            long r3 = r5.f11214c     // Catch:{ all -> 0x000e }
            r2.setMaximumSize(r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r5)
            return r1
        L_0x003f:
            throw r0     // Catch:{ all -> 0x000e }
        L_0x0040:
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.asyncstorage.k.k():boolean");
    }

    public synchronized SQLiteDatabase m() {
        k();
        return this.f11213b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE catalystLocalStorage (key TEXT PRIMARY KEY, value TEXT NOT NULL)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 != i11) {
            j();
            onCreate(sQLiteDatabase);
        }
    }
}
