package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.List;
import java.util.Locale;

class a implements SupportSQLiteDatabase {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f16496b = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f16497c = new String[0];

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f16498a;

    /* renamed from: androidx.sqlite.db.framework.a$a  reason: collision with other inner class name */
    class C0214a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SupportSQLiteQuery f16499a;

        C0214a(SupportSQLiteQuery supportSQLiteQuery) {
            this.f16499a = supportSQLiteQuery;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f16499a.bindTo(new c(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SupportSQLiteQuery f16501a;

        b(SupportSQLiteQuery supportSQLiteQuery) {
            this.f16501a = supportSQLiteQuery;
        }

        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f16501a.bindTo(new c(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    a(SQLiteDatabase sQLiteDatabase) {
        this.f16498a = sQLiteDatabase;
    }

    /* access modifiers changed from: package-private */
    public boolean a(SQLiteDatabase sQLiteDatabase) {
        if (this.f16498a == sQLiteDatabase) {
            return true;
        }
        return false;
    }

    public void beginTransaction() {
        this.f16498a.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.f16498a.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        this.f16498a.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        this.f16498a.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void close() {
        this.f16498a.close();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        return new d(this.f16498a.compileStatement(str));
    }

    public int delete(String str, String str2, Object[] objArr) {
        String str3;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DELETE FROM ");
        sb2.append(str);
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " WHERE " + str2;
        }
        sb2.append(str3);
        SupportSQLiteStatement compileStatement = compileStatement(sb2.toString());
        SimpleSQLiteQuery.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    public void disableWriteAheadLogging() {
        this.f16498a.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.f16498a.enableWriteAheadLogging();
    }

    public void endTransaction() {
        this.f16498a.endTransaction();
    }

    public void execSQL(String str) {
        this.f16498a.execSQL(str);
    }

    public List getAttachedDbs() {
        return this.f16498a.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.f16498a.getMaximumSize();
    }

    public long getPageSize() {
        return this.f16498a.getPageSize();
    }

    public String getPath() {
        return this.f16498a.getPath();
    }

    public int getVersion() {
        return this.f16498a.getVersion();
    }

    public boolean inTransaction() {
        return this.f16498a.inTransaction();
    }

    public long insert(String str, int i10, ContentValues contentValues) {
        return this.f16498a.insertWithOnConflict(str, (String) null, contentValues, i10);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.f16498a.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.f16498a.isDbLockedByCurrentThread();
    }

    public boolean isOpen() {
        return this.f16498a.isOpen();
    }

    public boolean isReadOnly() {
        return this.f16498a.isReadOnly();
    }

    public boolean isWriteAheadLoggingEnabled() {
        return this.f16498a.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i10) {
        return this.f16498a.needUpgrade(i10);
    }

    public Cursor query(String str) {
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
    }

    public void setForeignKeyConstraintsEnabled(boolean z10) {
        this.f16498a.setForeignKeyConstraintsEnabled(z10);
    }

    public void setLocale(Locale locale) {
        this.f16498a.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i10) {
        this.f16498a.setMaxSqlCacheSize(i10);
    }

    public long setMaximumSize(long j10) {
        return this.f16498a.setMaximumSize(j10);
    }

    public void setPageSize(long j10) {
        this.f16498a.setPageSize(j10);
    }

    public void setTransactionSuccessful() {
        this.f16498a.setTransactionSuccessful();
    }

    public void setVersion(int i10) {
        this.f16498a.setVersion(i10);
    }

    public int update(String str, int i10, ContentValues contentValues, String str2, Object[] objArr) {
        int i11;
        String str3;
        if (contentValues == null || contentValues.size() == 0) {
            throw new IllegalArgumentException("Empty values");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("UPDATE ");
        sb2.append(f16496b[i10]);
        sb2.append(str);
        sb2.append(" SET ");
        int size = contentValues.size();
        if (objArr == null) {
            i11 = size;
        } else {
            i11 = objArr.length + size;
        }
        Object[] objArr2 = new Object[i11];
        int i12 = 0;
        for (String next : contentValues.keySet()) {
            if (i12 > 0) {
                str3 = ",";
            } else {
                str3 = "";
            }
            sb2.append(str3);
            sb2.append(next);
            objArr2[i12] = contentValues.get(next);
            sb2.append("=?");
            i12++;
        }
        if (objArr != null) {
            for (int i13 = size; i13 < i11; i13++) {
                objArr2[i13] = objArr[i13 - size];
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            sb2.append(" WHERE ");
            sb2.append(str2);
        }
        SupportSQLiteStatement compileStatement = compileStatement(sb2.toString());
        SimpleSQLiteQuery.bind(compileStatement, objArr2);
        return compileStatement.executeUpdateDelete();
    }

    public boolean yieldIfContendedSafely() {
        return this.f16498a.yieldIfContendedSafely();
    }

    public void execSQL(String str, Object[] objArr) {
        this.f16498a.execSQL(str, objArr);
    }

    public Cursor query(String str, Object[] objArr) {
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public boolean yieldIfContendedSafely(long j10) {
        return this.f16498a.yieldIfContendedSafely(j10);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        return this.f16498a.rawQueryWithFactory(new C0214a(supportSQLiteQuery), supportSQLiteQuery.getSql(), f16497c, (String) null);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        return this.f16498a.rawQueryWithFactory(new b(supportSQLiteQuery), supportSQLiteQuery.getSql(), f16497c, (String) null, cancellationSignal);
    }
}
