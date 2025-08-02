package com.sensorsdata.analytics.android.sdk.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

class SensorsDataDBHelper extends SQLiteOpenHelper {
    private static final String CHANNEL_EVENT_PERSISTENT_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s (%s TEXT PRIMARY KEY, %s INTEGER)", new Object[]{DbParams.TABLE_CHANNEL_PERSISTENT, DbParams.KEY_CHANNEL_EVENT_NAME, DbParams.KEY_CHANNEL_RESULT});
    private static final String CREATE_EVENTS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s (_id INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s INTEGER NOT NULL DEFAULT 0);", new Object[]{DbParams.TABLE_EVENTS, "data", DbParams.KEY_CREATED_AT, DbParams.KEY_IS_INSTANT_EVENT});
    private static final String EVENTS_TIME_INDEX = String.format("CREATE INDEX IF NOT EXISTS time_idx ON %s (%s);", new Object[]{DbParams.TABLE_EVENTS, DbParams.KEY_CREATED_AT});
    private static final String TAG = "SA.SQLiteOpenHelper";

    SensorsDataDBHelper(Context context) {
        super(context, DbParams.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 6);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    private boolean checkColumnExist(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z10 = false;
        ? r12 = 0;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM " + str + " LIMIT 0", r12);
            if (!(rawQuery == null || rawQuery.getColumnIndex(str2) == -1)) {
                z10 = true;
            }
            if (rawQuery != null) {
                try {
                    if (!rawQuery.isClosed()) {
                        rawQuery.close();
                    }
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                }
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            if (r12 != 0) {
                if (!r12.isClosed()) {
                    r12.close();
                }
            }
        } catch (Throwable th) {
            if (r12 != 0) {
                try {
                    if (!r12.isClosed()) {
                        r12.close();
                    }
                } catch (Exception e12) {
                    SALog.printStackTrace(e12);
                }
            }
            throw th;
        }
        return z10;
    }

    private void createTable(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(EVENTS_TIME_INDEX);
        sQLiteDatabase.execSQL(CHANNEL_EVENT_PERSISTENT_TABLE);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        SALog.i(TAG, "Creating a new Sensors Analytics DB");
        createTable(sQLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        SALog.i(TAG, "Upgrading app, replacing Sensors Analytics DB, oldVersion:" + i10 + ", newVersion:" + i11);
        if (i10 < 4) {
            try {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s", new Object[]{DbParams.TABLE_EVENTS}));
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
                return;
            }
        }
        createTable(sQLiteDatabase);
        if (i10 >= 4 && i10 <= 5 && !checkColumnExist(sQLiteDatabase, DbParams.TABLE_EVENTS, DbParams.KEY_IS_INSTANT_EVENT)) {
            sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN  is_instant_event INTEGER NOT NULL DEFAULT 0");
        }
    }
}
