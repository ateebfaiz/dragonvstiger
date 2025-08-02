package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final RoomSQLiteQuery mSourceQuery;

    class a extends InvalidationTracker.Observer {
        a(String[] strArr) {
            super(strArr);
        }

        public void onInvalidated(Set set) {
            LimitOffsetDataSource.this.invalidate();
        }
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z10, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z10, strArr);
    }

    private RoomSQLiteQuery getSQLiteQuery(int i10, int i11) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.mSourceQuery);
        acquire.bindLong(acquire.getArgCount() - 1, (long) i11);
        acquire.bindLong(acquire.getArgCount(), (long) i10);
        return acquire;
    }

    /* access modifiers changed from: protected */
    public abstract List<T> convertRows(Cursor cursor);

    public int countItems() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        acquire.copyArgumentsFrom(this.mSourceQuery);
        Cursor query = this.mDb.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            query.close();
            acquire.release();
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return LimitOffsetDataSource.super.isInvalid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadInitial(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialParams r7, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialCallback<T> r8) {
        /*
            r6 = this;
            java.util.List r0 = java.util.Collections.emptyList()
            androidx.room.RoomDatabase r1 = r6.mDb
            r1.beginTransaction()
            r1 = 0
            int r2 = r6.countItems()     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0035
            int r0 = computeInitialLoadPosition(r7, r2)     // Catch:{ all -> 0x0032 }
            int r7 = computeInitialLoadSize(r7, r0, r2)     // Catch:{ all -> 0x0032 }
            androidx.room.RoomSQLiteQuery r7 = r6.getSQLiteQuery(r0, r7)     // Catch:{ all -> 0x0032 }
            androidx.room.RoomDatabase r3 = r6.mDb     // Catch:{ all -> 0x0030 }
            android.database.Cursor r1 = r3.query(r7)     // Catch:{ all -> 0x0030 }
            java.util.List r3 = r6.convertRows(r1)     // Catch:{ all -> 0x0030 }
            androidx.room.RoomDatabase r4 = r6.mDb     // Catch:{ all -> 0x0030 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0030 }
            r5 = r3
            r3 = r7
            r7 = r0
            r0 = r5
            goto L_0x0037
        L_0x0030:
            r8 = move-exception
            goto L_0x004a
        L_0x0032:
            r8 = move-exception
            r7 = r1
            goto L_0x004a
        L_0x0035:
            r7 = 0
            r3 = r1
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.close()
        L_0x003c:
            androidx.room.RoomDatabase r1 = r6.mDb
            r1.endTransaction()
            if (r3 == 0) goto L_0x0046
            r3.release()
        L_0x0046:
            r8.onResult(r0, r7, r2)
            return
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()
        L_0x004f:
            androidx.room.RoomDatabase r0 = r6.mDb
            r0.endTransaction()
            if (r7 == 0) goto L_0x0059
            r7.release()
        L_0x0059:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.loadInitial(androidx.paging.PositionalDataSource$LoadInitialParams, androidx.paging.PositionalDataSource$LoadInitialCallback):void");
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z10, String... strArr) {
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = z10;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + roomSQLiteQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + roomSQLiteQuery.getSql() + " ) LIMIT ? OFFSET ?";
        a aVar = new a(strArr);
        this.mObserver = aVar;
        roomDatabase.getInvalidationTracker().addWeakObserver(aVar);
    }

    @NonNull
    public List<T> loadRange(int i10, int i11) {
        RoomSQLiteQuery sQLiteQuery = getSQLiteQuery(i10, i11);
        if (this.mInTransaction) {
            this.mDb.beginTransaction();
            Cursor cursor = null;
            try {
                cursor = this.mDb.query(sQLiteQuery);
                List<T> convertRows = convertRows(cursor);
                this.mDb.setTransactionSuccessful();
                return convertRows;
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
                this.mDb.endTransaction();
                sQLiteQuery.release();
            }
        } else {
            Cursor query = this.mDb.query(sQLiteQuery);
            try {
                return convertRows(query);
            } finally {
                query.close();
                sQLiteQuery.release();
            }
        }
    }
}
