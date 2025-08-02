package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils;
import org.json.JSONObject;

class EventDataOperation extends DataOperation {
    EventDataOperation(Context context) {
        super(context);
        this.TAG = "EventDataOperation";
    }

    private String[] handleBigException(Uri uri, boolean z10) {
        String str;
        try {
            return queryDataInner(uri, z10, 1);
        } catch (SQLiteBlobTooBigException e10) {
            if (z10) {
                str = "1";
            } else {
                str = "0";
            }
            deleteData(uri, getFirstRowId(uri, str));
            SALog.printStackTrace(e10);
            return null;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ca A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] queryDataInner(android.net.Uri r12, boolean r13, int r14) {
        /*
            r11 = this;
            java.lang.String r0 = "1"
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            r2 = 0
            java.lang.String r3 = "0"
            if (r13 == 0) goto L_0x000d
            r3 = r0
        L_0x000d:
            android.content.ContentResolver r4 = r11.contentResolver     // Catch:{ all -> 0x00b0 }
            java.lang.String r7 = "is_instant_event=?"
            java.lang.String[] r8 = new java.lang.String[]{r3}     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r13.<init>()     // Catch:{ all -> 0x00b0 }
            java.lang.String r3 = "created_at ASC LIMIT "
            r13.append(r3)     // Catch:{ all -> 0x00b0 }
            r13.append(r14)     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = r13.toString()     // Catch:{ all -> 0x00b0 }
            r6 = 0
            r5 = r12
            android.database.Cursor r12 = r4.query(r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00b0 }
            if (r12 == 0) goto L_0x00a8
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r13.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r14 = ","
            java.lang.String r3 = "["
            r13.append(r3)     // Catch:{ all -> 0x0049 }
        L_0x003a:
            boolean r3 = r12.moveToNext()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0092
            boolean r3 = r12.isLast()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x004d
            java.lang.String r14 = "]"
            goto L_0x004d
        L_0x0049:
            r13 = move-exception
            r14 = r2
            goto L_0x00b3
        L_0x004d:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndexOrThrow(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ all -> 0x0049 }
            r1.put(r3)     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "data"
            int r3 = r12.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = r11.parseData(r3)     // Catch:{ Exception -> 0x008d }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x008d }
            if (r4 != 0) goto L_0x003a
            int r4 = r3.length()     // Catch:{ Exception -> 0x008d }
            int r4 = r4 + -1
            r5 = 0
            r13.append(r3, r5, r4)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = ",\"_flush_time\":"
            r13.append(r3)     // Catch:{ Exception -> 0x008d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x008d }
            r13.append(r3)     // Catch:{ Exception -> 0x008d }
            java.lang.String r3 = "}"
            r13.append(r3)     // Catch:{ Exception -> 0x008d }
            r13.append(r14)     // Catch:{ Exception -> 0x008d }
            goto L_0x003a
        L_0x008d:
            r3 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r3)     // Catch:{ all -> 0x0049 }
            goto L_0x003a
        L_0x0092:
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0049 }
            int r14 = r1.length()     // Catch:{ all -> 0x00a1 }
            if (r14 <= 0) goto L_0x00a6
            java.lang.String r14 = r1.toString()     // Catch:{ all -> 0x00a1 }
            goto L_0x00aa
        L_0x00a1:
            r14 = move-exception
            r10 = r14
            r14 = r13
            r13 = r10
            goto L_0x00b3
        L_0x00a6:
            r14 = r2
            goto L_0x00aa
        L_0x00a8:
            r13 = r2
            r14 = r13
        L_0x00aa:
            if (r12 == 0) goto L_0x00c3
            r12.close()
            goto L_0x00c3
        L_0x00b0:
            r13 = move-exception
            r12 = r2
            r14 = r12
        L_0x00b3:
            java.lang.String r1 = r11.TAG     // Catch:{ all -> 0x00cb }
            java.lang.String r13 = r13.getMessage()     // Catch:{ all -> 0x00cb }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x00cb }
            if (r12 == 0) goto L_0x00c1
            r12.close()
        L_0x00c1:
            r13 = r14
            r14 = r2
        L_0x00c3:
            if (r14 == 0) goto L_0x00ca
            java.lang.String[] r12 = new java.lang.String[]{r14, r13, r0}
            return r12
        L_0x00ca:
            return r2
        L_0x00cb:
            r13 = move-exception
            if (r12 == 0) goto L_0x00d1
            r12.close()
        L_0x00d1:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.EventDataOperation.queryDataInner(android.net.Uri, boolean, int):java.lang.String[]");
    }

    /* access modifiers changed from: package-private */
    public void deleteData(Uri uri, String str) {
        super.deleteData(uri, str);
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            int isInstantEvent = InstantEventUtils.isInstantEvent(jSONObject);
            ContentValues contentValues = new ContentValues();
            String jSONObject2 = jSONObject.toString();
            contentValues.put("data", jSONObject2 + "\t" + jSONObject2.hashCode());
            contentValues.put(DbParams.KEY_CREATED_AT, Long.valueOf(System.currentTimeMillis()));
            contentValues.put(DbParams.KEY_IS_INSTANT_EVENT, Integer.valueOf(isInstantEvent));
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Throwable th) {
            SALog.i(this.TAG, th.getMessage());
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public String[] queryData(Uri uri, int i10) {
        return queryData(uri, false, i10);
    }

    /* access modifiers changed from: package-private */
    public String[] queryData(Uri uri, boolean z10, int i10) {
        try {
            return queryDataInner(uri, z10, i10);
        } catch (SQLiteBlobTooBigException e10) {
            SALog.i(this.TAG, "Could not pull records for SensorsData out of database events. SQLiteBlobTooBigException ", (Throwable) e10);
            return handleBigException(uri, z10);
        } catch (SQLiteException e11) {
            SALog.i(this.TAG, "Could not pull records for SensorsData out of database events. Waiting to send.", (Throwable) e11);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, ContentValues contentValues) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return 0;
        }
    }
}
