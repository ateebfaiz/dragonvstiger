package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

abstract class DataOperation {
    String TAG = "EventDataOperation";
    ContentResolver contentResolver;
    private final Context mContext;
    private File mDatabaseFile;

    DataOperation(Context context) {
        this.mContext = context;
        this.contentResolver = context.getContentResolver();
    }

    private boolean belowMemThreshold() {
        if (this.mDatabaseFile == null) {
            this.mDatabaseFile = this.mContext.getDatabasePath(DbParams.DATABASE_NAME);
        }
        if (!this.mDatabaseFile.exists() || this.mDatabaseFile.length() < getMaxCacheSize(this.mContext)) {
            return false;
        }
        return true;
    }

    private String buildIds(JSONArray jSONArray) throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                sb2.append(jSONArray.get(i10));
                sb2.append(",");
            }
            sb2.replace(sb2.length() - 1, sb2.length(), "");
        }
        sb2.append(")");
        return sb2.toString();
    }

    private long getMaxCacheSize(Context context) {
        try {
            return SensorsDataAPI.sharedInstance(context).getMaxCacheSize();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return 33554432;
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteData(Uri uri, String str) {
        try {
            if ("DB_DELETE_ALL".equals(str)) {
                SALog.i(this.TAG, "deleteData DB_DELETE_ALL");
                this.contentResolver.delete(uri, (String) null, (String[]) null);
                return;
            }
            this.contentResolver.delete(uri, "_id <= ?", new String[]{str});
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public int deleteDataLowMemory(Uri uri) {
        if (belowMemThreshold()) {
            SALog.i(this.TAG, "There is not enough space left on the device to store events, so will delete 100 oldest events");
            String[] queryData = queryData(uri, 100);
            if (queryData == null) {
                return -2;
            }
            deleteData(uri, queryData[0]);
            if (queryDataCount(uri, 2) <= 0) {
                return -2;
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public String getFirstRowId(Uri uri, String str) {
        Cursor cursor = null;
        try {
            cursor = this.contentResolver.query(uri, new String[]{"_id"}, "is_instant_event=?", new String[]{str}, "created_at ASC LIMIT 1");
            if (cursor != null) {
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                cursor.close();
                return string;
            }
            if (cursor == null) {
                return "";
            }
            cursor.close();
            return "";
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            if (cursor == null) {
                return "";
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract int insertData(Uri uri, ContentValues contentValues);

    /* access modifiers changed from: package-private */
    public abstract int insertData(Uri uri, JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public String parseData(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf("\t");
            if (lastIndexOf > -1) {
                String replaceFirst = str.substring(lastIndexOf).replaceFirst("\t", "");
                str = str.substring(0, lastIndexOf);
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(replaceFirst) || !replaceFirst.equals(String.valueOf(str.hashCode()))) {
                    return "";
                }
            }
            return str;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract String[] queryData(Uri uri, int i10);

    /* access modifiers changed from: package-private */
    public abstract String[] queryData(Uri uri, boolean z10, int i10);

    /* access modifiers changed from: package-private */
    public int queryDataCount(Uri uri, int i10) {
        String[] strArr;
        if (i10 != 0) {
            strArr = i10 != 1 ? null : new String[]{"1"};
        } else {
            strArr = new String[]{"0"};
        }
        String[] strArr2 = strArr;
        if (strArr2 != null) {
            return queryDataCount(uri, new String[]{"_id"}, "is_instant_event=?", strArr2, (String) null);
        }
        return queryDataCount(uri, new String[]{"_id"}, (String) null, (String[]) null, (String) null);
    }

    public void deleteData(Uri uri, JSONArray jSONArray) {
        try {
            String str = this.TAG;
            SALog.i(str, "deleteData ids = " + jSONArray);
            ContentResolver contentResolver2 = this.mContext.getContentResolver();
            contentResolver2.delete(uri, "_id in " + buildIds(jSONArray), (String[]) null);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    /* access modifiers changed from: package-private */
    public int queryDataCount(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursor = null;
        try {
            cursor = this.contentResolver.query(uri, strArr, str, strArr2, str2);
            if (cursor != null) {
                int count = cursor.getCount();
                cursor.close();
                return count;
            }
            if (cursor == null) {
                return 0;
            }
            cursor.close();
            return 0;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            if (cursor == null) {
                return 0;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
