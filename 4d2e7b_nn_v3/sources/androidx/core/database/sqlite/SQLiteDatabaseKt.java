package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.k;

public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z10, Function1<? super SQLiteDatabase, ? extends T> function1) {
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            k.b(1);
            sQLiteDatabase.endTransaction();
            k.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            k.b(1);
            sQLiteDatabase.endTransaction();
            k.a(1);
        }
    }
}
