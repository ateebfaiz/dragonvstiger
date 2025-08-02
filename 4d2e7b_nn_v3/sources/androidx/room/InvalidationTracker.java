package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    @VisibleForTesting
    static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";
    @VisibleForTesting
    static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    volatile SupportSQLiteStatement mCleanupStatement;
    final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final a mInvalidationLiveDataContainer;
    private b mMultiInstanceInvalidationClient;
    private b mObservedTableTracker;
    @VisibleForTesting
    @SuppressLint({"RestrictedApi"})
    final SafeIterableMap<Observer, c> mObserverMap;
    AtomicBoolean mPendingRefresh;
    @VisibleForTesting
    Runnable mRefreshRunnable;
    @NonNull
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;
    @NonNull
    private Map<String, Set<String>> mViewTables;

    class a implements Runnable {
        a() {
        }

        /* JADX INFO: finally extract failed */
        private Set a() {
            HashSet hashSet = new HashSet();
            Cursor query = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL));
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
            }
            return hashSet;
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x0077  */
        /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.room.RoomDatabase r0 = r0.mDatabase
                java.util.concurrent.locks.Lock r0 = r0.getCloseLock()
                r1 = 0
                r0.lock()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                boolean r2 = r2.ensureInitialization()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                if (r2 != 0) goto L_0x0018
                r0.unlock()
                return
            L_0x0018:
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                java.util.concurrent.atomic.AtomicBoolean r2 = r2.mPendingRefresh     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                r3 = 1
                r4 = 0
                boolean r2 = r2.compareAndSet(r3, r4)     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                if (r2 != 0) goto L_0x0028
                r0.unlock()
                return
            L_0x0028:
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                androidx.room.RoomDatabase r2 = r2.mDatabase     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                boolean r2 = r2.inTransaction()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                if (r2 == 0) goto L_0x0036
                r0.unlock()
                return
            L_0x0036:
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                androidx.room.RoomDatabase r2 = r2.mDatabase     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                boolean r3 = r2.mWriteAheadLoggingEnabled     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                if (r3 == 0) goto L_0x005f
                androidx.sqlite.db.SupportSQLiteOpenHelper r2 = r2.getOpenHelper()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                androidx.sqlite.db.SupportSQLiteDatabase r2 = r2.getWritableDatabase()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                r2.beginTransaction()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                java.util.Set r1 = r5.a()     // Catch:{ all -> 0x005a }
                r2.setTransactionSuccessful()     // Catch:{ all -> 0x005a }
                r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                goto L_0x0063
            L_0x0054:
                r1 = move-exception
                goto L_0x00a1
            L_0x0056:
                r2 = move-exception
                goto L_0x0067
            L_0x0058:
                r2 = move-exception
                goto L_0x0067
            L_0x005a:
                r3 = move-exception
                r2.endTransaction()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
                throw r3     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
            L_0x005f:
                java.util.Set r1 = r5.a()     // Catch:{ IllegalStateException -> 0x0058, SQLiteException -> 0x0056 }
            L_0x0063:
                r0.unlock()
                goto L_0x006f
            L_0x0067:
                java.lang.String r3 = "ROOM"
                java.lang.String r4 = "Cannot run invalidation tracker. Is the db closed?"
                android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x0054 }
                goto L_0x0063
            L_0x006f:
                if (r1 == 0) goto L_0x00a0
                boolean r0 = r1.isEmpty()
                if (r0 != 0) goto L_0x00a0
                androidx.room.InvalidationTracker r0 = androidx.room.InvalidationTracker.this
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$c> r0 = r0.mObserverMap
                monitor-enter(r0)
                androidx.room.InvalidationTracker r2 = androidx.room.InvalidationTracker.this     // Catch:{ all -> 0x009a }
                androidx.arch.core.internal.SafeIterableMap<androidx.room.InvalidationTracker$Observer, androidx.room.InvalidationTracker$c> r2 = r2.mObserverMap     // Catch:{ all -> 0x009a }
                java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x009a }
            L_0x0084:
                boolean r3 = r2.hasNext()     // Catch:{ all -> 0x009a }
                if (r3 == 0) goto L_0x009c
                java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x009a }
                java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x009a }
                java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x009a }
                androidx.room.InvalidationTracker$c r3 = (androidx.room.InvalidationTracker.c) r3     // Catch:{ all -> 0x009a }
                r3.a(r1)     // Catch:{ all -> 0x009a }
                goto L_0x0084
            L_0x009a:
                r1 = move-exception
                goto L_0x009e
            L_0x009c:
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                goto L_0x00a0
            L_0x009e:
                monitor-exit(r0)     // Catch:{ all -> 0x009a }
                throw r1
            L_0x00a0:
                return
            L_0x00a1:
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.a.run():void");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final long[] f16418a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f16419b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f16420c;

        /* renamed from: d  reason: collision with root package name */
        boolean f16421d;

        /* renamed from: e  reason: collision with root package name */
        boolean f16422e;

        b(int i10) {
            long[] jArr = new long[i10];
            this.f16418a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f16419b = zArr;
            this.f16420c = new int[i10];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0042, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int[] a() {
            /*
                r9 = this;
                monitor-enter(r9)
                boolean r0 = r9.f16421d     // Catch:{ all -> 0x002e }
                if (r0 == 0) goto L_0x0041
                boolean r0 = r9.f16422e     // Catch:{ all -> 0x002e }
                if (r0 == 0) goto L_0x000a
                goto L_0x0041
            L_0x000a:
                long[] r0 = r9.f16418a     // Catch:{ all -> 0x002e }
                int r0 = r0.length     // Catch:{ all -> 0x002e }
                r1 = 0
                r2 = r1
            L_0x000f:
                r3 = 1
                if (r2 >= r0) goto L_0x0039
                long[] r4 = r9.f16418a     // Catch:{ all -> 0x002e }
                r5 = r4[r2]     // Catch:{ all -> 0x002e }
                r7 = 0
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                r4 = r3
                goto L_0x001f
            L_0x001e:
                r4 = r1
            L_0x001f:
                boolean[] r5 = r9.f16419b     // Catch:{ all -> 0x002e }
                boolean r6 = r5[r2]     // Catch:{ all -> 0x002e }
                if (r4 == r6) goto L_0x0030
                int[] r6 = r9.f16420c     // Catch:{ all -> 0x002e }
                if (r4 == 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r3 = 2
            L_0x002b:
                r6[r2] = r3     // Catch:{ all -> 0x002e }
                goto L_0x0034
            L_0x002e:
                r0 = move-exception
                goto L_0x0044
            L_0x0030:
                int[] r3 = r9.f16420c     // Catch:{ all -> 0x002e }
                r3[r2] = r1     // Catch:{ all -> 0x002e }
            L_0x0034:
                r5[r2] = r4     // Catch:{ all -> 0x002e }
                int r2 = r2 + 1
                goto L_0x000f
            L_0x0039:
                r9.f16422e = r3     // Catch:{ all -> 0x002e }
                r9.f16421d = r1     // Catch:{ all -> 0x002e }
                int[] r0 = r9.f16420c     // Catch:{ all -> 0x002e }
                monitor-exit(r9)     // Catch:{ all -> 0x002e }
                return r0
            L_0x0041:
                monitor-exit(r9)     // Catch:{ all -> 0x002e }
                r0 = 0
                return r0
            L_0x0044:
                monitor-exit(r9)     // Catch:{ all -> 0x002e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.b.a():int[]");
        }

        /* access modifiers changed from: package-private */
        public boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                try {
                    z10 = false;
                    for (int i10 : iArr) {
                        long[] jArr = this.f16418a;
                        long j10 = jArr[i10];
                        jArr[i10] = 1 + j10;
                        if (j10 == 0) {
                            z10 = true;
                            this.f16421d = true;
                        }
                    }
                } finally {
                }
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                try {
                    z10 = false;
                    for (int i10 : iArr) {
                        long[] jArr = this.f16418a;
                        long j10 = jArr[i10];
                        jArr[i10] = j10 - 1;
                        if (j10 == 1) {
                            z10 = true;
                            this.f16421d = true;
                        }
                    }
                } finally {
                }
            }
            return z10;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            synchronized (this) {
                this.f16422e = false;
            }
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final int[] f16423a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f16424b;

        /* renamed from: c  reason: collision with root package name */
        final Observer f16425c;

        /* renamed from: d  reason: collision with root package name */
        private final Set f16426d;

        c(Observer observer, int[] iArr, String[] strArr) {
            this.f16425c = observer;
            this.f16423a = iArr;
            this.f16424b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.f16426d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f16426d = null;
        }

        /* access modifiers changed from: package-private */
        public void a(Set set) {
            int length = this.f16423a.length;
            Set set2 = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f16423a[i10]))) {
                    if (length == 1) {
                        set2 = this.f16426d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.f16424b[i10]);
                    }
                }
            }
            if (set2 != null) {
                this.f16425c.onInvalidated(set2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            Set set = null;
            if (this.f16424b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    } else if (strArr[i10].equalsIgnoreCase(this.f16424b[0])) {
                        set = this.f16426d;
                        break;
                    } else {
                        i10++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f16424b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i11];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i11++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f16425c.onInvalidated(set);
            }
        }
    }

    static class d extends Observer {

        /* renamed from: a  reason: collision with root package name */
        final InvalidationTracker f16427a;

        /* renamed from: b  reason: collision with root package name */
        final WeakReference f16428b;

        d(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.mTables);
            this.f16427a = invalidationTracker;
            this.f16428b = new WeakReference(observer);
        }

        public void onInvalidated(Set set) {
            Observer observer = (Observer) this.f16428b.get();
            if (observer == null) {
                this.f16427a.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    private static void appendTriggerName(StringBuilder sb2, String str, String str2) {
        sb2.append("`");
        sb2.append("room_table_modification_trigger_");
        sb2.append(str);
        sb2.append("_");
        sb2.append(str2);
        sb2.append("`");
    }

    private String[] resolveViews(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i10) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.mTableNames[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb2, str, str2);
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE ");
            sb2.append(UPDATE_TABLE_NAME);
            sb2.append(" SET ");
            sb2.append(INVALIDATED_COLUMN_NAME);
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append(TABLE_ID_COLUMN_NAME);
            sb2.append(" = ");
            sb2.append(i10);
            sb2.append(" AND ");
            sb2.append(INVALIDATED_COLUMN_NAME);
            sb2.append(" = 0");
            sb2.append("; END");
            supportSQLiteDatabase.execSQL(sb2.toString());
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i10) {
        String str = this.mTableNames[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String appendTriggerName : TRIGGERS) {
            sb2.setLength(0);
            sb2.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb2, str, appendTriggerName);
            supportSQLiteDatabase.execSQL(sb2.toString());
        }
    }

    private String[] validateAndResolveTableNames(String[] strArr) {
        String[] resolveViews = resolveViews(strArr);
        int length = resolveViews.length;
        int i10 = 0;
        while (i10 < length) {
            String str = resolveViews[i10];
            if (this.mTableIdLookup.containsKey(str.toLowerCase(Locale.US))) {
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return resolveViews;
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void addObserver(@NonNull Observer observer) {
        c putIfAbsent;
        String[] resolveViews = resolveViews(observer.mTables);
        int[] iArr = new int[resolveViews.length];
        int length = resolveViews.length;
        int i10 = 0;
        while (i10 < length) {
            Integer num = this.mTableIdLookup.get(resolveViews[i10].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i10] = num.intValue();
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + resolveViews[i10]);
            }
        }
        c cVar = new c(observer, iArr, resolveViews);
        synchronized (this.mObserverMap) {
            putIfAbsent = this.mObserverMap.putIfAbsent(observer, cVar);
        }
        if (putIfAbsent == null && this.mObservedTableTracker.b(iArr)) {
            syncTriggers();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        addObserver(new d(this, observer));
    }

    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        return createLiveData(strArr, false, callable);
    }

    /* access modifiers changed from: package-private */
    public boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.getOpenHelper().getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void internalInit(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            try {
                if (this.mInitialized) {
                    Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                    return;
                }
                supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
                supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
                supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
                syncTriggers(supportSQLiteDatabase);
                this.mCleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
                this.mInitialized = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting(otherwise = 3)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void notifyObserversByTableNames(String... strArr) {
        synchronized (this.mObserverMap) {
            try {
                Iterator<Map.Entry<Observer, c>> it = this.mObserverMap.iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (!((Observer) next.getKey()).isRemote()) {
                        ((c) next.getValue()).b(strArr);
                    }
                }
            } finally {
            }
        }
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true)) {
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void refreshVersionsSync() {
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void removeObserver(@NonNull Observer observer) {
        c remove;
        synchronized (this.mObserverMap) {
            remove = this.mObserverMap.remove(observer);
        }
        if (remove != null && this.mObservedTableTracker.c(remove.f16423a)) {
            syncTriggers();
        }
    }

    /* access modifiers changed from: package-private */
    public void startMultiInstanceInvalidation(Context context, String str) {
        this.mMultiInstanceInvalidationClient = new b(context, str, this, this.mDatabase.getQueryExecutor());
    }

    /* access modifiers changed from: package-private */
    public void stopMultiInstanceInvalidation() {
        b bVar = this.mMultiInstanceInvalidationClient;
        if (bVar != null) {
            bVar.a();
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!supportSQLiteDatabase.inTransaction()) {
            while (true) {
                try {
                    Lock closeLock = this.mDatabase.getCloseLock();
                    closeLock.lock();
                    try {
                        int[] a10 = this.mObservedTableTracker.a();
                        if (a10 == null) {
                            closeLock.unlock();
                            return;
                        }
                        int length = a10.length;
                        supportSQLiteDatabase.beginTransaction();
                        for (int i10 = 0; i10 < length; i10++) {
                            int i11 = a10[i10];
                            if (i11 == 1) {
                                startTrackingTable(supportSQLiteDatabase, i10);
                            } else if (i11 == 2) {
                                stopTrackingTable(supportSQLiteDatabase, i10);
                            }
                        }
                        supportSQLiteDatabase.setTransactionSuccessful();
                        supportSQLiteDatabase.endTransaction();
                        this.mObservedTableTracker.d();
                        closeLock.unlock();
                    } catch (Throwable th) {
                        closeLock.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    return;
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap<>();
        this.mRefreshRunnable = new a();
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new b(strArr.length);
        this.mTableIdLookup = new HashMap<>();
        this.mViewTables = map2;
        this.mInvalidationLiveDataContainer = new a(roomDatabase);
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i10));
            String str2 = map.get(strArr[i10]);
            if (str2 != null) {
                this.mTableNames[i10] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[i10] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.mTableIdLookup;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z10, Callable<T> callable) {
        return this.mInvalidationLiveDataContainer.a(validateAndResolveTableNames(strArr), z10, callable);
    }

    public static abstract class Observer {
        final String[] mTables;

        protected Observer(@NonNull String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.mTables = strArr2;
            strArr2[strArr.length] = str;
        }

        /* access modifiers changed from: package-private */
        public boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);

        public Observer(@NonNull String[] strArr) {
            this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* access modifiers changed from: package-private */
    public void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }
}
