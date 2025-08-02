package androidx.sqlite.db;

import java.io.Closeable;

public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int i10, byte[] bArr);

    void bindDouble(int i10, double d10);

    void bindLong(int i10, long j10);

    void bindNull(int i10);

    void bindString(int i10, String str);

    void clearBindings();
}
