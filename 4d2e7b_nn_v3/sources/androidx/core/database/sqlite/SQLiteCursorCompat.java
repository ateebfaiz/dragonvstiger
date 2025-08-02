package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

public final class SQLiteCursorCompat {

    static class a {
        @DoNotInline
        static void a(SQLiteCursor sQLiteCursor, boolean z10) {
            sQLiteCursor.setFillWindowForwardOnly(z10);
        }
    }

    private SQLiteCursorCompat() {
    }

    public static void setFillWindowForwardOnly(@NonNull SQLiteCursor sQLiteCursor, boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            a.a(sQLiteCursor, z10);
        }
    }
}
