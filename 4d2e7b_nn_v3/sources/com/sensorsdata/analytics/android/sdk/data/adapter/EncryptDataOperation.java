package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import org.json.JSONObject;

class EncryptDataOperation extends DataOperation {
    protected boolean mDbEncrypt = true;

    EncryptDataOperation(Context context) {
        super(context);
    }

    private String decryptValue(String str) {
        String str2 = (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_LOAD_EVENT, str);
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str2;
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
            JSONObject jSONObject2 = (JSONObject) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA, jSONObject);
            if (jSONObject2 != null) {
                jSONObject = jSONObject2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", jSONObject.toString() + "\t" + jSONObject.toString().hashCode());
            contentValues.put(DbParams.KEY_CREATED_AT, Long.valueOf(System.currentTimeMillis()));
            contentValues.put(DbParams.KEY_IS_INSTANT_EVENT, Integer.valueOf(isInstantEvent));
            this.contentResolver.insert(uri, contentValues);
            return 0;
        } catch (Throwable th) {
            SALog.i(this.TAG, th.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public String[] queryData(Uri uri, int i10) {
        return queryData(uri, false, i10);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String[] queryData(android.net.Uri r22, boolean r23, int r24) {
        /*
            r21 = this;
            r1 = r21
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            org.json.JSONArray r5 = new org.json.JSONArray
            r5.<init>()
            java.lang.String r6 = "9"
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            r8.<init>()     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            r9.<init>()     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            java.lang.String r0 = "0"
            java.lang.String r10 = "1"
            if (r23 == 0) goto L_0x001f
            r0 = r10
        L_0x001f:
            android.content.ContentResolver r11 = r1.contentResolver     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            java.lang.String r14 = "is_instant_event=?"
            java.lang.String[] r15 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            r0.<init>()     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            java.lang.String r12 = "created_at ASC LIMIT "
            r0.append(r12)     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            r12 = r24
            r0.append(r12)     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            java.lang.String r16 = r0.toString()     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            r13 = 0
            r12 = r22
            android.database.Cursor r11 = r11.query(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x01cf, all -> 0x01cc }
            if (r11 == 0) goto L_0x01c0
        L_0x0043:
            boolean r0 = r11.moveToNext()     // Catch:{ Exception -> 0x01bc }
            java.lang.String r12 = "pkv"
            java.lang.String r13 = "$"
            java.lang.String r14 = "ekey"
            java.lang.String r15 = "payloads"
            if (r0 == 0) goto L_0x0145
            java.lang.String r0 = "_id"
            int r0 = r11.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r0 = r11.getString(r0)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = "data"
            int r7 = r11.getColumnIndexOrThrow(r7)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = r11.getString(r7)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = r1.parseData(r7)     // Catch:{ Exception -> 0x0091 }
            boolean r17 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0091 }
            if (r17 == 0) goto L_0x0070
            goto L_0x0043
        L_0x0070:
            boolean r17 = com.sensorsdata.analytics.android.sdk.util.JSONUtils.isJson(r7)     // Catch:{ Exception -> 0x0091 }
            if (r17 != 0) goto L_0x0098
            java.lang.String r0 = r1.TAG     // Catch:{ Exception -> 0x0091 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0091 }
            r12.<init>()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r13 = "Error is not json data, v = "
            r12.append(r13)     // Catch:{ Exception -> 0x0091 }
            r12.append(r7)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = r12.toString()     // Catch:{ Exception -> 0x0091 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x0091 }
            goto L_0x0043
        L_0x008d:
            r0 = move-exception
            r7 = r11
            goto L_0x01e8
        L_0x0091:
            r0 = move-exception
            r19 = r6
            r20 = r10
            goto L_0x013d
        L_0x0098:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0091 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x0091 }
            boolean r7 = r2.has(r14)     // Catch:{ Exception -> 0x0091 }
            boolean r18 = r2.has(r15)     // Catch:{ Exception -> 0x0091 }
            if (r18 == 0) goto L_0x00b7
            if (r7 != 0) goto L_0x00b7
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0091 }
            java.lang.String r2 = r2.optString(r15)     // Catch:{ Exception -> 0x0091 }
            java.lang.String r2 = r1.decryptValue(r2)     // Catch:{ Exception -> 0x0091 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0091 }
            r2 = r3
        L_0x00b7:
            if (r7 != 0) goto L_0x00db
            boolean r3 = r1.mDbEncrypt     // Catch:{ Exception -> 0x0091 }
            if (r3 == 0) goto L_0x00db
            com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager r3 = com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager.getInstance()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r7 = "sensors_analytics_module_encrypt"
            java.lang.String r1 = "encryptEventData"
            r19 = r6
            r20 = r10
            r6 = 1
            java.lang.Object[] r10 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x00d9 }
            r6 = 0
            r10[r6] = r2     // Catch:{ Exception -> 0x00d9 }
            java.lang.Object r1 = r3.invokeModuleFunction(r7, r1, r10)     // Catch:{ Exception -> 0x00d9 }
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x00df
            r2 = r1
            goto L_0x00df
        L_0x00d9:
            r0 = move-exception
            goto L_0x013d
        L_0x00db:
            r19 = r6
            r20 = r10
        L_0x00df:
            boolean r1 = r2.has(r14)     // Catch:{ Exception -> 0x00d9 }
            if (r1 == 0) goto L_0x0126
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d9 }
            r1.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r3 = r2.getString(r14)     // Catch:{ Exception -> 0x00d9 }
            r1.append(r3)     // Catch:{ Exception -> 0x00d9 }
            r1.append(r13)     // Catch:{ Exception -> 0x00d9 }
            int r3 = r2.getInt(r12)     // Catch:{ Exception -> 0x00d9 }
            r1.append(r3)     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00d9 }
            boolean r3 = r8.containsKey(r1)     // Catch:{ Exception -> 0x00d9 }
            if (r3 == 0) goto L_0x0113
            java.lang.Object r1 = r8.get(r1)     // Catch:{ Exception -> 0x00d9 }
            org.json.JSONArray r1 = (org.json.JSONArray) r1     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r2 = r2.optString(r15)     // Catch:{ Exception -> 0x00d9 }
            r1.put(r2)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x0122
        L_0x0113:
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x00d9 }
            r3.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.lang.String r2 = r2.optString(r15)     // Catch:{ Exception -> 0x00d9 }
            r3.put(r2)     // Catch:{ Exception -> 0x00d9 }
            r8.put(r1, r3)     // Catch:{ Exception -> 0x00d9 }
        L_0x0122:
            r4.put(r0)     // Catch:{ Exception -> 0x00d9 }
            goto L_0x0135
        L_0x0126:
            java.lang.String r1 = "_flush_time"
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00d9 }
            r2.put(r1, r6)     // Catch:{ Exception -> 0x00d9 }
            r9.put(r2)     // Catch:{ Exception -> 0x00d9 }
            r5.put(r0)     // Catch:{ Exception -> 0x00d9 }
        L_0x0135:
            r1 = r21
            r6 = r19
            r10 = r20
            goto L_0x0043
        L_0x013d:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ Exception -> 0x0141 }
            goto L_0x0135
        L_0x0141:
            r0 = move-exception
        L_0x0142:
            r1 = 0
            goto L_0x01d4
        L_0x0145:
            r19 = r6
            r20 = r10
            int r0 = r8.size()     // Catch:{ Exception -> 0x0141 }
            if (r0 <= 0) goto L_0x01ab
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x0141 }
            r0.<init>()     // Catch:{ Exception -> 0x0141 }
            java.util.Set r1 = r8.keySet()     // Catch:{ Exception -> 0x0141 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0141 }
        L_0x015c:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0141 }
            if (r2 == 0) goto L_0x019e
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0141 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0141 }
            r3.<init>()     // Catch:{ Exception -> 0x0141 }
            int r5 = r2.indexOf(r13)     // Catch:{ Exception -> 0x0141 }
            r6 = 0
            java.lang.String r5 = r2.substring(r6, r5)     // Catch:{ Exception -> 0x0141 }
            r3.put(r14, r5)     // Catch:{ Exception -> 0x0141 }
            int r5 = r2.indexOf(r13)     // Catch:{ Exception -> 0x0141 }
            r7 = 1
            int r5 = r5 + r7
            java.lang.String r5 = r2.substring(r5)     // Catch:{ Exception -> 0x0141 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0141 }
            r3.put(r12, r5)     // Catch:{ Exception -> 0x0141 }
            java.lang.Object r2 = r8.get(r2)     // Catch:{ Exception -> 0x0141 }
            r3.put(r15, r2)     // Catch:{ Exception -> 0x0141 }
            java.lang.String r2 = "flush_time"
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0141 }
            r3.put(r2, r9)     // Catch:{ Exception -> 0x0141 }
            r0.put(r3)     // Catch:{ Exception -> 0x0141 }
            goto L_0x015c
        L_0x019e:
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x0141 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x01a9 }
            r6 = r19
            goto L_0x01c6
        L_0x01a9:
            r0 = move-exception
            goto L_0x01d4
        L_0x01ab:
            int r0 = r9.length()     // Catch:{ Exception -> 0x0141 }
            if (r0 <= 0) goto L_0x01c2
            java.lang.String r1 = r9.toString()     // Catch:{ Exception -> 0x0141 }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x01a9 }
            r6 = r20
            goto L_0x01c6
        L_0x01bc:
            r0 = move-exception
            r19 = r6
            goto L_0x0142
        L_0x01c0:
            r19 = r6
        L_0x01c2:
            r6 = r19
            r0 = 0
            r1 = 0
        L_0x01c6:
            if (r11 == 0) goto L_0x01df
            r11.close()
            goto L_0x01df
        L_0x01cc:
            r0 = move-exception
            r7 = 0
            goto L_0x01e8
        L_0x01cf:
            r0 = move-exception
            r19 = r6
            r1 = 0
            r11 = 0
        L_0x01d4:
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)     // Catch:{ all -> 0x008d }
            if (r11 == 0) goto L_0x01dc
            r11.close()
        L_0x01dc:
            r6 = r19
            r0 = 0
        L_0x01df:
            if (r0 == 0) goto L_0x01e6
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r6}
            return r0
        L_0x01e6:
            r1 = 0
            return r1
        L_0x01e8:
            if (r7 == 0) goto L_0x01ed
            r7.close()
        L_0x01ed:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.data.adapter.EncryptDataOperation.queryData(android.net.Uri, boolean, int):java.lang.String[]");
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
