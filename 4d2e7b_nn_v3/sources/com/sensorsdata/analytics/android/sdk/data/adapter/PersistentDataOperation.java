package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;

class PersistentDataOperation extends DataOperation {
    PersistentDataOperation(Context context) {
        super(context);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a0, code lost:
        switch(r6) {
            case 0: goto L_0x010e;
            case 1: goto L_0x0106;
            case 2: goto L_0x00fa;
            case 3: goto L_0x00ee;
            case 4: goto L_0x00e6;
            case 5: goto L_0x00da;
            case 6: goto L_0x00ce;
            case 7: goto L_0x00c6;
            case 8: goto L_0x00be;
            case 9: goto L_0x00b6;
            case 10: goto L_0x00a5;
            default: goto L_0x00a3;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a3, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY, r1.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_KEY));
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE, r1.optString(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PUSH_ID_VALUE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b6, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_LOGIN_ID_KEY, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00be, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.PERSISTENT_USER_ID, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c6, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.REMOTE_CONFIG, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ce, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_FIRST_PROCESS_START, java.lang.Boolean.valueOf(r1.optBoolean("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00da, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.SUB_PROCESS_FLUSH_DATA, java.lang.Boolean.valueOf(r1.optBoolean("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e6, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.PersistentName.LOGIN_ID, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00ee, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_SESSION_INTERVAL_TIME, java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_APP_START_TIME, java.lang.Long.valueOf(r1.optLong("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0106, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.APP_EXIT_DATA, r1.optString("value"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x010e, code lost:
        r5.put(com.sensorsdata.analytics.android.sdk.data.adapter.DbParams.TABLE_ACTIVITY_START_COUNT, java.lang.Integer.valueOf(r1.optInt("value")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r16.contentResolver.insert(r17, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0122, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int handleInsertUri(android.net.Uri r17, org.json.JSONObject r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "push_value"
            r3 = -1
            if (r0 != 0) goto L_0x000a
            return r3
        L_0x000a:
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0045 }
            r5.<init>()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r6 = r17.getPath()     // Catch:{ Exception -> 0x0045 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0045 }
            if (r7 != 0) goto L_0x0124
            r7 = 1
            java.lang.String r6 = r6.substring(r7)     // Catch:{ Exception -> 0x0045 }
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x0045 }
            java.lang.String r9 = "activity_started_count"
            java.lang.String r10 = "events_login_id"
            java.lang.String r11 = "session_interval_time"
            java.lang.String r12 = "first_process_start"
            java.lang.String r13 = "login_id_key"
            java.lang.String r14 = "user_ids"
            java.lang.String r15 = "app_start_time"
            java.lang.String r7 = "app_exit_data"
            java.lang.String r4 = "sensorsdata_sdk_configuration"
            java.lang.String r3 = "sub_process_flush_data"
            java.lang.String r0 = "push_key"
            switch(r8) {
                case -1437430111: goto L_0x0095;
                case -1436067305: goto L_0x008d;
                case -1173524450: goto L_0x0085;
                case -1109940413: goto L_0x007d;
                case -456824111: goto L_0x0074;
                case -266152892: goto L_0x006b;
                case 791585128: goto L_0x0063;
                case 923005325: goto L_0x005b;
                case 947194773: goto L_0x0053;
                case 1776312250: goto L_0x004a;
                case 1964784692: goto L_0x003d;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x009d
        L_0x003d:
            boolean r6 = r6.equals(r3)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 5
            goto L_0x009e
        L_0x0045:
            r0 = move-exception
            r1 = r16
            goto L_0x0128
        L_0x004a:
            boolean r6 = r6.equals(r0)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 10
            goto L_0x009e
        L_0x0053:
            boolean r6 = r6.equals(r4)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 7
            goto L_0x009e
        L_0x005b:
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 1
            goto L_0x009e
        L_0x0063:
            boolean r6 = r6.equals(r15)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 2
            goto L_0x009e
        L_0x006b:
            boolean r6 = r6.equals(r14)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 8
            goto L_0x009e
        L_0x0074:
            boolean r6 = r6.equals(r13)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 9
            goto L_0x009e
        L_0x007d:
            boolean r6 = r6.equals(r12)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 6
            goto L_0x009e
        L_0x0085:
            boolean r6 = r6.equals(r11)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 3
            goto L_0x009e
        L_0x008d:
            boolean r6 = r6.equals(r10)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 4
            goto L_0x009e
        L_0x0095:
            boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x009d
            r6 = 0
            goto L_0x009e
        L_0x009d:
            r6 = -1
        L_0x009e:
            java.lang.String r8 = "value"
            switch(r6) {
                case 0: goto L_0x010e;
                case 1: goto L_0x0106;
                case 2: goto L_0x00fa;
                case 3: goto L_0x00ee;
                case 4: goto L_0x00e6;
                case 5: goto L_0x00da;
                case 6: goto L_0x00ce;
                case 7: goto L_0x00c6;
                case 8: goto L_0x00be;
                case 9: goto L_0x00b6;
                case 10: goto L_0x00a5;
                default: goto L_0x00a3;
            }
        L_0x00a3:
            r6 = -1
            return r6
        L_0x00a5:
            java.lang.String r3 = r1.optString(r0)     // Catch:{ Exception -> 0x0045 }
            r5.put(r0, r3)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r0 = r1.optString(r2)     // Catch:{ Exception -> 0x0045 }
            r5.put(r2, r0)     // Catch:{ Exception -> 0x0045 }
        L_0x00b3:
            r1 = r16
            goto L_0x011a
        L_0x00b6:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0045 }
            r5.put(r13, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00be:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0045 }
            r5.put(r14, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00c6:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0045 }
            r5.put(r4, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00ce:
            boolean r0 = r1.optBoolean(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0045 }
            r5.put(r12, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00da:
            boolean r0 = r1.optBoolean(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0045 }
            r5.put(r3, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00e6:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0045 }
            r5.put(r10, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00ee:
            long r0 = r1.optLong(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0045 }
            r5.put(r11, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x00fa:
            long r0 = r1.optLong(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0045 }
            r5.put(r15, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x0106:
            java.lang.String r0 = r1.optString(r8)     // Catch:{ Exception -> 0x0045 }
            r5.put(r7, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x010e:
            int r0 = r1.optInt(r8)     // Catch:{ Exception -> 0x0045 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x0045 }
            r5.put(r9, r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x00b3
        L_0x011a:
            android.content.ContentResolver r0 = r1.contentResolver     // Catch:{ Exception -> 0x0122 }
            r2 = r17
            r0.insert(r2, r5)     // Catch:{ Exception -> 0x0122 }
            goto L_0x0126
        L_0x0122:
            r0 = move-exception
            goto L_0x0128
        L_0x0124:
            r1 = r16
        L_0x0126:
            r2 = 0
            goto L_0x012c
        L_0x0128:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            goto L_0x0126
        L_0x012c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation.handleInsertUri(android.net.Uri, org.json.JSONObject):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00df, code lost:
        if (r11 != null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00e1, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00ef, code lost:
        if (r11 != null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00f2, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] handleQueryUri(android.net.Uri r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r11.getPath()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x000f
            return r0
        L_0x000f:
            r2 = 1
            java.lang.String r1 = r1.substring(r2)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            android.content.ContentResolver r3 = r10.contentResolver     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            r7 = 0
            r8 = 0
            r5 = 0
            r6 = 0
            r4 = r11
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00ea, all -> 0x00e5 }
            if (r11 == 0) goto L_0x00df
            int r3 = r11.getCount()     // Catch:{ Exception -> 0x0041 }
            if (r3 <= 0) goto L_0x00df
            r11.moveToNext()     // Catch:{ Exception -> 0x0041 }
            int r3 = r1.hashCode()     // Catch:{ Exception -> 0x0041 }
            r4 = 0
            switch(r3) {
                case -1437430111: goto L_0x00a1;
                case -1436067305: goto L_0x0097;
                case -1173524450: goto L_0x008c;
                case -1109940413: goto L_0x0082;
                case -456824111: goto L_0x0078;
                case -266152892: goto L_0x006e;
                case 791585128: goto L_0x0063;
                case 923005325: goto L_0x0059;
                case 947194773: goto L_0x004f;
                case 1776312250: goto L_0x0044;
                case 1964784692: goto L_0x0034;
                default: goto L_0x0032;
            }     // Catch:{ Exception -> 0x0041 }
        L_0x0032:
            goto L_0x00ab
        L_0x0034:
            java.lang.String r3 = "sub_process_flush_data"
            boolean r1 = r1.equals(r3)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x003e:
            r0 = move-exception
            goto L_0x00f3
        L_0x0041:
            r1 = move-exception
            goto L_0x00ec
        L_0x0044:
            java.lang.String r2 = "push_key"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 8
            goto L_0x00ac
        L_0x004f:
            java.lang.String r2 = "sensorsdata_sdk_configuration"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 5
            goto L_0x00ac
        L_0x0059:
            java.lang.String r2 = "app_exit_data"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 3
            goto L_0x00ac
        L_0x0063:
            java.lang.String r2 = "app_start_time"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 10
            goto L_0x00ac
        L_0x006e:
            java.lang.String r2 = "user_ids"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 6
            goto L_0x00ac
        L_0x0078:
            java.lang.String r2 = "login_id_key"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 7
            goto L_0x00ac
        L_0x0082:
            java.lang.String r2 = "first_process_start"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 2
            goto L_0x00ac
        L_0x008c:
            java.lang.String r2 = "session_interval_time"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 9
            goto L_0x00ac
        L_0x0097:
            java.lang.String r2 = "events_login_id"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = 4
            goto L_0x00ac
        L_0x00a1:
            java.lang.String r2 = "activity_started_count"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0041 }
            if (r1 == 0) goto L_0x00ab
            r2 = r4
            goto L_0x00ac
        L_0x00ab:
            r2 = -1
        L_0x00ac:
            switch(r2) {
                case 0: goto L_0x00cf;
                case 1: goto L_0x00cf;
                case 2: goto L_0x00cf;
                case 3: goto L_0x00c3;
                case 4: goto L_0x00c3;
                case 5: goto L_0x00c3;
                case 6: goto L_0x00c3;
                case 7: goto L_0x00c3;
                case 8: goto L_0x00c3;
                case 9: goto L_0x00b3;
                case 10: goto L_0x00b3;
                default: goto L_0x00af;
            }
        L_0x00af:
            r11.close()
            return r0
        L_0x00b3:
            long r1 = r11.getLong(r4)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0041 }
            java.lang.String[] r0 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0041 }
            r11.close()
            return r0
        L_0x00c3:
            java.lang.String r1 = r11.getString(r4)     // Catch:{ Exception -> 0x0041 }
            java.lang.String[] r0 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0041 }
            r11.close()
            return r0
        L_0x00cf:
            int r1 = r11.getInt(r4)     // Catch:{ Exception -> 0x0041 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0041 }
            java.lang.String[] r0 = new java.lang.String[]{r1}     // Catch:{ Exception -> 0x0041 }
            r11.close()
            return r0
        L_0x00df:
            if (r11 == 0) goto L_0x00f2
        L_0x00e1:
            r11.close()
            goto L_0x00f2
        L_0x00e5:
            r11 = move-exception
            r9 = r0
            r0 = r11
            r11 = r9
            goto L_0x00f3
        L_0x00ea:
            r1 = move-exception
            r11 = r0
        L_0x00ec:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r1)     // Catch:{ all -> 0x003e }
            if (r11 == 0) goto L_0x00f2
            goto L_0x00e1
        L_0x00f2:
            return r0
        L_0x00f3:
            if (r11 == 0) goto L_0x00f8
            r11.close()
        L_0x00f8:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.PersistentDataOperation.handleQueryUri(android.net.Uri):java.lang.String[]");
    }

    /* access modifiers changed from: package-private */
    public void deleteData(Uri uri, String str) {
        this.contentResolver.delete(uri.buildUpon().appendQueryParameter(DbParams.REMOVE_SP_KEY, str).build(), (String) null, (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, JSONObject jSONObject) {
        return handleInsertUri(uri, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public String[] queryData(Uri uri, int i10) {
        return handleQueryUri(uri);
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, ContentValues contentValues) {
        this.contentResolver.insert(uri, contentValues);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public String[] queryData(Uri uri, boolean z10, int i10) {
        return handleQueryUri(uri);
    }
}
