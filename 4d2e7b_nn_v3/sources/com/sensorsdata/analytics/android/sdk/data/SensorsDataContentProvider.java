package com.sensorsdata.analytics.android.sdk.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;

public class SensorsDataContentProvider extends ContentProvider {
    private static final UriMatcher uriMatcher = new UriMatcher(-1);
    private SAProviderHelper mProviderHelper;

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        try {
            return this.mProviderHelper.bulkInsert(uri, contentValuesArr);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return 0;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        try {
            int match = uriMatcher.match(uri);
            if (1 == match) {
                return this.mProviderHelper.deleteEvents(str, strArr);
            }
            if (match == 15) {
                return this.mProviderHelper.removeSP(uri.getQueryParameter(DbParams.REMOVE_SP_KEY));
            }
            return 0;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return 0;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!(contentValues == null || contentValues.size() == 0)) {
            try {
                int match = uriMatcher.match(uri);
                if (match == 1) {
                    return this.mProviderHelper.insertEvent(uri, contentValues);
                }
                if (match == 8) {
                    return this.mProviderHelper.insertChannelPersistent(uri, contentValues);
                }
                this.mProviderHelper.insertPersistent(match, uri, contentValues);
                return uri;
            } catch (Exception e10) {
                SALog.printStackTrace(e10);
            }
        }
        return uri;
    }

    public boolean onCreate() {
        String str;
        try {
            Context context = getContext();
            if (context == null) {
                return true;
            }
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (UnsupportedOperationException unused) {
                str = "com.sensorsdata.analytics.android.sdk.test";
            }
            SAProviderHelper instance = SAProviderHelper.getInstance(context);
            this.mProviderHelper = instance;
            UriMatcher uriMatcher2 = uriMatcher;
            instance.appendUri(uriMatcher2, str + ".SensorsDataContentProvider");
            return true;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return true;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            int match = uriMatcher.match(uri);
            if (match == 1) {
                return this.mProviderHelper.queryByTable(DbParams.TABLE_EVENTS, strArr, str, strArr2, str2);
            }
            if (match == 8) {
                return this.mProviderHelper.queryByTable(DbParams.TABLE_CHANNEL_PERSISTENT, strArr, str, strArr2, str2);
            }
            return this.mProviderHelper.queryPersistent(match, uri);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
