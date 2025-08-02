package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class CursorWindowCompat {

    static class a {
        @DoNotInline
        static CursorWindow a(String str, long j10) {
            return new CursorWindow(str, j10);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.a(str, j10);
        }
        return new CursorWindow(str);
    }
}
