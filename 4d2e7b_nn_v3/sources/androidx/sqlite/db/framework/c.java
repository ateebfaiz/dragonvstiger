package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;

class c implements SupportSQLiteProgram {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f16515a;

    c(SQLiteProgram sQLiteProgram) {
        this.f16515a = sQLiteProgram;
    }

    public void bindBlob(int i10, byte[] bArr) {
        this.f16515a.bindBlob(i10, bArr);
    }

    public void bindDouble(int i10, double d10) {
        this.f16515a.bindDouble(i10, d10);
    }

    public void bindLong(int i10, long j10) {
        this.f16515a.bindLong(i10, j10);
    }

    public void bindNull(int i10) {
        this.f16515a.bindNull(i10);
    }

    public void bindString(int i10, String str) {
        this.f16515a.bindString(i10, str);
    }

    public void clearBindings() {
        this.f16515a.clearBindings();
    }

    public void close() {
        this.f16515a.close();
    }
}
