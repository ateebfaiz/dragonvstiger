package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.business.instantevent.InstantEventUtils;
import com.sensorsdata.analytics.android.sdk.core.mediator.Modules;
import com.sensorsdata.analytics.android.sdk.core.mediator.SAModuleManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransportEncryption extends EncryptDataOperation {
    private Object mSupportTransport = null;

    TransportEncryption(Context context) {
        super(context);
        this.mDbEncrypt = false;
    }

    private String encryptValue(String str) {
        String str2;
        if (isSupportTransport()) {
            str2 = (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_STORE_EVENT, str);
        } else {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return "{\"payloads\": \"" + str2 + "\"}";
    }

    private boolean isSupportTransport() {
        if (this.mSupportTransport == null) {
            this.mSupportTransport = SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_VERIFY_SUPPORT_TRANSPORT, new Object[0]);
        }
        Object obj = this.mSupportTransport;
        if (obj == null || !((Boolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }

    public /* bridge */ /* synthetic */ void deleteData(Uri uri, JSONArray jSONArray) {
        super.deleteData(uri, jSONArray);
    }

    /* access modifiers changed from: package-private */
    public int insertData(Uri uri, JSONObject jSONObject) {
        try {
            if (deleteDataLowMemory(uri) != 0) {
                return -2;
            }
            int isInstantEvent = InstantEventUtils.isInstantEvent(jSONObject);
            ContentValues contentValues = new ContentValues();
            String encryptValue = encryptValue(jSONObject.toString());
            contentValues.put("data", encryptValue + "\t" + encryptValue.hashCode());
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
            String[] queryData = super.queryData(uri, z10, i10);
            if (queryData != null && queryData.length >= 3 && "1".equals(queryData[2]) && isSupportTransport()) {
                String str = queryData[0];
                String str2 = (String) SAModuleManager.getInstance().invokeModuleFunction(Modules.Encrypt.MODULE_NAME, Modules.Encrypt.METHOD_ENCRYPT_EVENT_DATA, queryData[1]);
                try {
                    if (!TextUtils.isEmpty(str2) && str2.contains("payloads")) {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject(str2);
                        jSONObject.put("flush_time", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                        return new String[]{str, jSONArray.toString(), DbParams.GZIP_TRANSPORT_ENCRYPT};
                    }
                } catch (JSONException e10) {
                    SALog.printStackTrace(e10);
                }
            }
            return queryData;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return null;
        }
    }
}
