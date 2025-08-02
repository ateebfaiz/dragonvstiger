package androidx.sqlite.db;

import androidx.annotation.Nullable;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    @Nullable
    private final Object[] mBindArgs;
    private final String mQuery;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.mQuery = str;
        this.mBindArgs = objArr;
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i10 = 0;
            while (i10 < length) {
                Object obj = objArr[i10];
                i10++;
                bind(supportSQLiteProgram, i10, obj);
            }
        }
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        bind(supportSQLiteProgram, this.mBindArgs);
    }

    public int getArgCount() {
        Object[] objArr = this.mBindArgs;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public String getSql() {
        return this.mQuery;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, (Object[]) null);
    }

    private static void bind(SupportSQLiteProgram supportSQLiteProgram, int i10, Object obj) {
        if (obj == null) {
            supportSQLiteProgram.bindNull(i10);
        } else if (obj instanceof byte[]) {
            supportSQLiteProgram.bindBlob(i10, (byte[]) obj);
        } else if (obj instanceof Float) {
            supportSQLiteProgram.bindDouble(i10, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            supportSQLiteProgram.bindDouble(i10, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            supportSQLiteProgram.bindLong(i10, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            supportSQLiteProgram.bindLong(i10, (long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            supportSQLiteProgram.bindLong(i10, (long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            supportSQLiteProgram.bindLong(i10, (long) ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            supportSQLiteProgram.bindString(i10, (String) obj);
        } else if (obj instanceof Boolean) {
            supportSQLiteProgram.bindLong(i10, ((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i10 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }
}
