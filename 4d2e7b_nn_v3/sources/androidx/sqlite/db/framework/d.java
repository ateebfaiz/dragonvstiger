package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;

class d extends c implements SupportSQLiteStatement {

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteStatement f16516b;

    d(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f16516b = sQLiteStatement;
    }

    public void execute() {
        this.f16516b.execute();
    }

    public long executeInsert() {
        return this.f16516b.executeInsert();
    }

    public int executeUpdateDelete() {
        return this.f16516b.executeUpdateDelete();
    }

    public long simpleQueryForLong() {
        return this.f16516b.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.f16516b.simpleQueryForString();
    }
}
