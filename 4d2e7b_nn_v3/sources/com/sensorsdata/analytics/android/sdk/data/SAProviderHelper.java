package com.sensorsdata.analytics.android.sdk.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;

public class SAProviderHelper {
    private static SAProviderHelper INSTANCE = null;
    private static final String TAG = "SA.ProviderHelper";
    private ContentResolver contentResolver;
    /* access modifiers changed from: private */
    public boolean isDbWritable = true;
    private long mAppStartTime = 0;
    private Context mContext;
    private SQLiteOpenHelper mDbHelper;
    private boolean mIsFlushDataState = false;
    private int mSessionTime = 30000;
    private int startActivityCount = 0;

    interface QueryEventsListener {
        void insert(String str, String str2);
    }

    public interface URI_CODE {
        public static final int ACTIVITY_START_COUNT = 2;
        public static final int APP_EXIT_DATA = 4;
        public static final int APP_PAUSED_TIME = 5;
        public static final int APP_START_TIME = 3;
        public static final int CHANNEL_PERSISTENT = 8;
        public static final int DISABLE_SDK = 11;
        public static final int EVENTS = 1;
        public static final int FIRST_PROCESS_START = 10;
        public static final int FLUSH_DATA = 9;
        public static final int LOGIN_ID = 7;
        public static final int LOGIN_ID_KEY = 14;
        public static final int PUSH_ID_KEY = 15;
        public static final int REMOTE_CONFIG = 12;
        public static final int SESSION_INTERVAL_TIME = 6;
        public static final int USER_IDENTITY_ID = 13;
    }

    private SAProviderHelper(Context context) {
        try {
            this.mDbHelper = new SensorsDataDBHelper(context);
            this.mContext = context.getApplicationContext();
            this.contentResolver = context.getContentResolver();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public static synchronized SAProviderHelper getInstance(Context context) {
        SAProviderHelper sAProviderHelper;
        synchronized (SAProviderHelper.class) {
            try {
                if (INSTANCE == null) {
                    INSTANCE = new SAProviderHelper(context);
                }
                sAProviderHelper = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sAProviderHelper;
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase getWritableDatabase() {
        try {
            if (!isDBExist()) {
                this.mDbHelper.close();
                this.isDbWritable = true;
            }
            return this.mDbHelper.getWritableDatabase();
        } catch (SQLiteException e10) {
            SALog.printStackTrace(e10);
            this.isDbWritable = false;
            return null;
        }
    }

    private boolean isDBExist() {
        return this.mContext.getDatabasePath(DbParams.DATABASE_NAME).exists();
    }

    public void appendUri(UriMatcher uriMatcher, String str) {
        try {
            uriMatcher.addURI(str, DbParams.TABLE_EVENTS, 1);
            uriMatcher.addURI(str, DbParams.TABLE_ACTIVITY_START_COUNT, 2);
            uriMatcher.addURI(str, DbParams.TABLE_APP_START_TIME, 3);
            uriMatcher.addURI(str, DbParams.APP_EXIT_DATA, 4);
            uriMatcher.addURI(str, DbParams.TABLE_SESSION_INTERVAL_TIME, 6);
            uriMatcher.addURI(str, DbParams.PersistentName.LOGIN_ID, 7);
            uriMatcher.addURI(str, DbParams.TABLE_CHANNEL_PERSISTENT, 8);
            uriMatcher.addURI(str, DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA, 9);
            uriMatcher.addURI(str, DbParams.TABLE_FIRST_PROCESS_START, 10);
            uriMatcher.addURI(str, DbParams.TABLE_DATA_DISABLE_SDK, 11);
            uriMatcher.addURI(str, DbParams.PersistentName.REMOTE_CONFIG, 12);
            uriMatcher.addURI(str, DbParams.PersistentName.PERSISTENT_USER_ID, 13);
            uriMatcher.addURI(str, DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY, 14);
            uriMatcher.addURI(str, DbParams.PUSH_ID_KEY, 15);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabase = this.mDbHelper.getWritableDatabase();
            sQLiteDatabase.beginTransaction();
            for (ContentValues insertEvent : contentValuesArr) {
                insertEvent(uri, insertEvent);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
            return r2;
        } catch (SQLiteException e10) {
            SALog.printStackTrace(e10);
            return 0;
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
    }

    public int deleteEvents(String str, String[] strArr) {
        if (!this.isDbWritable) {
            return 0;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.delete(DbParams.TABLE_EVENTS, str, strArr);
            }
        } catch (SQLiteException e10) {
            this.isDbWritable = false;
            SALog.printStackTrace(e10);
        }
        return 0;
    }

    public Uri insertChannelPersistent(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                if (contentValues.containsKey(DbParams.KEY_CHANNEL_EVENT_NAME)) {
                    return ContentUris.withAppendedId(uri, writableDatabase.insertWithOnConflict(DbParams.TABLE_CHANNEL_PERSISTENT, (String) null, contentValues, 5));
                }
            }
            return uri;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return uri;
        }
    }

    public Uri insertEvent(Uri uri, ContentValues contentValues) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null && contentValues.containsKey("data")) {
                if (contentValues.containsKey(DbParams.KEY_CREATED_AT)) {
                    return ContentUris.withAppendedId(uri, writableDatabase.insert(DbParams.TABLE_EVENTS, "_id", contentValues));
                }
            }
            return uri;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return uri;
        }
    }

    public void insertPersistent(int i10, Uri uri, ContentValues contentValues) {
        switch (i10) {
            case 2:
                this.startActivityCount = contentValues.getAsInteger(DbParams.TABLE_ACTIVITY_START_COUNT).intValue();
                return;
            case 3:
                this.mAppStartTime = contentValues.getAsLong(DbParams.TABLE_APP_START_TIME).longValue();
                return;
            case 4:
                PersistentLoader.getInstance().getAppExitDataPst().commit(contentValues.getAsString(DbParams.APP_EXIT_DATA));
                return;
            case 6:
                this.mSessionTime = contentValues.getAsInteger(DbParams.TABLE_SESSION_INTERVAL_TIME).intValue();
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 7:
                PersistentLoader.getInstance().getLoginIdPst().commit(contentValues.getAsString(DbParams.PersistentName.LOGIN_ID));
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 9:
                this.mIsFlushDataState = contentValues.getAsBoolean(DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA).booleanValue();
                return;
            case 12:
                PersistentLoader.getInstance().getRemoteSDKConfig().commit(contentValues.getAsString(DbParams.PersistentName.REMOTE_CONFIG));
                return;
            case 13:
                PersistentLoader.getInstance().getUserIdsPst().commit(contentValues.getAsString(DbParams.PersistentName.PERSISTENT_USER_ID));
                this.contentResolver.notifyChange(uri, (ContentObserver) null);
                return;
            case 14:
                PersistentLoader.getInstance().getLoginIdKeyPst().commit(contentValues.getAsString(DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY));
                return;
            case 15:
                try {
                    SAStoreManager.getInstance().setString(contentValues.getAsString(DbParams.PUSH_ID_KEY), contentValues.getAsString(DbParams.PUSH_ID_VALUE));
                    return;
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                    return;
                }
            default:
                return;
        }
    }

    public void migratingDB(final Context context) {
        try {
            if (!AppInfoUtils.getAppInfoBundle(context).getBoolean("com.sensorsdata.analytics.android.EnableMigratingDB", true)) {
                SALog.i(TAG, "The migrating DB operation is false");
            } else {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            String packageName = context.getPackageName();
                            if (context.getDatabasePath(packageName).exists()) {
                                SALog.i(SAProviderHelper.TAG, "start migratingDB");
                                OldBDatabaseHelper oldBDatabaseHelper = new OldBDatabaseHelper(context, packageName);
                                final SQLiteDatabase access$000 = SAProviderHelper.this.getWritableDatabase();
                                if (access$000 != null) {
                                    final ContentValues contentValues = new ContentValues();
                                    oldBDatabaseHelper.getAllEvents(access$000, new QueryEventsListener() {
                                        public void insert(String str, String str2) {
                                            contentValues.put("data", str);
                                            contentValues.put(DbParams.KEY_CREATED_AT, str2);
                                            access$000.insert(DbParams.TABLE_EVENTS, "_id", contentValues);
                                            contentValues.clear();
                                        }
                                    });
                                }
                            }
                            if (SAProviderHelper.this.isDbWritable) {
                                context.deleteDatabase(packageName);
                            }
                        } catch (Exception e10) {
                            SALog.printStackTrace(e10);
                        }
                    }
                }).start();
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public Cursor queryByTable(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        if (!this.isDbWritable) {
            return null;
        }
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                return writableDatabase.query(str, strArr, str2, strArr2, (String) null, (String) null, str3);
            }
            return null;
        } catch (SQLiteException e10) {
            this.isDbWritable = false;
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public Cursor queryPersistent(int i10, Uri uri) {
        String str;
        String str2 = DbParams.PUSH_ID_KEY;
        switch (i10) {
            case 2:
                Integer valueOf = Integer.valueOf(this.startActivityCount);
                str2 = DbParams.TABLE_ACTIVITY_START_COUNT;
                str = valueOf;
                break;
            case 3:
                Long valueOf2 = Long.valueOf(this.mAppStartTime);
                str2 = DbParams.TABLE_APP_START_TIME;
                str = valueOf2;
                break;
            case 4:
                String str3 = (String) PersistentLoader.getInstance().getAppExitDataPst().get();
                boolean isEmpty = TextUtils.isEmpty(str3);
                String str4 = str3;
                if (isEmpty) {
                    PersistentLoader.getInstance().getAppEndDataPst().remove();
                    str4 = (String) PersistentLoader.getInstance().getAppEndDataPst().get();
                }
                str2 = DbParams.APP_EXIT_DATA;
                str = str4;
                break;
            case 6:
                Integer valueOf3 = Integer.valueOf(this.mSessionTime);
                str2 = DbParams.TABLE_SESSION_INTERVAL_TIME;
                str = valueOf3;
                break;
            case 7:
                Object obj = PersistentLoader.getInstance().getLoginIdPst().get();
                str2 = DbParams.PersistentName.LOGIN_ID;
                str = obj;
                break;
            case 9:
                Integer valueOf4 = Integer.valueOf(this.mIsFlushDataState ? 1 : 0);
                str2 = DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA;
                str = valueOf4;
                break;
            case 12:
                str2 = null;
                str = PersistentLoader.getInstance().getRemoteSDKConfig().get();
                break;
            case 13:
                Object obj2 = PersistentLoader.getInstance().getUserIdsPst().get();
                str2 = DbParams.PersistentName.PERSISTENT_USER_ID;
                str = obj2;
                break;
            case 14:
                Object obj3 = PersistentLoader.getInstance().getLoginIdKeyPst().get();
                str2 = DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY;
                str = obj3;
                break;
            case 15:
                try {
                    str = SAStoreManager.getInstance().getString(uri.getQueryParameter(str2), "");
                    break;
                } catch (Exception e10) {
                    SALog.printStackTrace(e10);
                    return null;
                }
            default:
                str = null;
                str2 = null;
                break;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{str2});
        matrixCursor.addRow(new Object[]{str});
        return matrixCursor;
    }

    public int removeSP(String str) {
        SAStoreManager.getInstance().remove(str);
        return 1;
    }
}
