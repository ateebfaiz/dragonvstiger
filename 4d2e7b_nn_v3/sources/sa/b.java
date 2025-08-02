package sa;

import android.database.Cursor;

public abstract class b {
    public static void a(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}
