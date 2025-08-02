package com.cocos.lib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CocosLocalStorage {
    /* access modifiers changed from: private */
    public static String DATABASE_NAME = "jsb.sqlite";
    private static final int DATABASE_VERSION = 1;
    /* access modifiers changed from: private */
    public static String TABLE_NAME = "data";
    private static final String TAG = "CocosLocalStorage";
    private static SQLiteDatabase mDatabase;
    private static a mDatabaseOpenHelper;
    private static ILocalStorageListener mInitListener;

    public interface ILocalStorageListener {
        void onResult();
    }

    private static class a extends SQLiteOpenHelper {
        a(Context context) {
            super(context, CocosLocalStorage.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + CocosLocalStorage.TABLE_NAME + "(key TEXT PRIMARY KEY,value TEXT);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            Log.w(CocosLocalStorage.TAG, "Upgrading database from version " + i10 + " to " + i11 + ", which will destroy all old data");
        }
    }

    public static void clear() {
        try {
            mDatabase.execSQL("delete from " + TABLE_NAME);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void destroy() {
        SQLiteDatabase sQLiteDatabase = mDatabase;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public static String getItem(String str) {
        String str2 = null;
        try {
            Cursor rawQuery = mDatabase.rawQuery("select value from " + TABLE_NAME + " where key=?", new String[]{str});
            while (true) {
                if (!rawQuery.moveToNext()) {
                    break;
                } else if (str2 != null) {
                    Log.e(TAG, "The key contains more than one value.");
                    break;
                } else {
                    str2 = rawQuery.getString(rawQuery.getColumnIndex("value"));
                }
            }
            rawQuery.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str2;
    }

    public static String getKey(int i10) {
        String str = null;
        try {
            Cursor rawQuery = mDatabase.rawQuery("select key from " + TABLE_NAME + " order by rowid asc", (String[]) null);
            if (i10 >= 0) {
                if (i10 < rawQuery.getCount()) {
                    int i11 = 0;
                    while (true) {
                        if (!rawQuery.moveToNext()) {
                            break;
                        } else if (i11 == i10) {
                            str = rawQuery.getString(rawQuery.getColumnIndex("key"));
                            break;
                        } else {
                            i11++;
                        }
                    }
                    rawQuery.close();
                    return str;
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static int getLength() {
        int i10 = 0;
        try {
            Cursor rawQuery = mDatabase.rawQuery("select count(*) as nums from " + TABLE_NAME, (String[]) null);
            if (rawQuery.moveToNext()) {
                i10 = rawQuery.getInt(rawQuery.getColumnIndex("nums"));
            }
            rawQuery.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return i10;
    }

    public static boolean init(String str, String str2) {
        if (GlobalObject.getContext() == null) {
            return false;
        }
        DATABASE_NAME = str;
        TABLE_NAME = str2;
        a aVar = new a(GlobalObject.getContext());
        mDatabaseOpenHelper = aVar;
        mDatabase = aVar.getWritableDatabase();
        ILocalStorageListener iLocalStorageListener = mInitListener;
        if (iLocalStorageListener == null) {
            return true;
        }
        iLocalStorageListener.onResult();
        return true;
    }

    public static void removeItem(String str) {
        try {
            mDatabase.execSQL("delete from " + TABLE_NAME + " where key=?", new Object[]{str});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void setInitListener(ILocalStorageListener iLocalStorageListener) {
        mInitListener = iLocalStorageListener;
    }

    public static void setItem(String str, String str2) {
        try {
            mDatabase.execSQL("replace into " + TABLE_NAME + "(key,value)values(?,?)", new Object[]{str, str2});
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
