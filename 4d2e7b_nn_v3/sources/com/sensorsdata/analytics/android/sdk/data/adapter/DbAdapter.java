package com.sensorsdata.analytics.android.sdk.data.adapter;

import android.content.ContentValues;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentLoader;
import com.sensorsdata.analytics.android.sdk.data.persistent.PersistentRemoteSDKConfig;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DbAdapter {
    private static DbAdapter instance;
    private final DbParams mDbParams;
    private DataOperation mPersistentOperation;
    private DataOperation mTrackEventOperation;

    private DbAdapter(SAContextManager sAContextManager) {
        this.mDbParams = DbParams.getInstance(sAContextManager.getContext().getPackageName());
        SAConfigOptions sAConfigOptions = sAContextManager.getInternalConfigs().saConfigOptions;
        if (sAConfigOptions.isEnableEncrypt()) {
            this.mTrackEventOperation = new EncryptDataOperation(sAContextManager.getContext().getApplicationContext());
        } else if (sAConfigOptions.isTransportEncrypt()) {
            this.mTrackEventOperation = new TransportEncryption(sAContextManager.getContext().getApplicationContext());
        } else {
            this.mTrackEventOperation = new EventDataOperation(sAContextManager.getContext().getApplicationContext());
        }
        this.mPersistentOperation = new PersistentDataOperation(sAContextManager.getContext().getApplicationContext());
    }

    public static String decodeIdentities(String str) {
        if (str == null) {
            return null;
        }
        return Base64Coder.decodeString(str.substring(str.indexOf(":") + 1));
    }

    public static DbAdapter getInstance(SAContextManager sAContextManager) {
        if (instance == null) {
            instance = new DbAdapter(sAContextManager);
        }
        return instance;
    }

    public void addChannelEvent(String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbParams.KEY_CHANNEL_EVENT_NAME, str);
            this.mTrackEventOperation.insertData(this.mDbParams.getChannelPersistentUri(), contentValues);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public int addJSON(JSONObject jSONObject) {
        int insertData = this.mTrackEventOperation.insertData(this.mDbParams.getEventUri(), jSONObject);
        if (insertData == 0) {
            return this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri(), 2);
        }
        return insertData;
    }

    public int cleanupEvents(JSONArray jSONArray, boolean z10) {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), jSONArray);
        return this.mTrackEventOperation.queryDataCount(this.mDbParams.getEventUri(), z10 ? 1 : 0);
    }

    public void commitActivityCount(int i10) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getActivityStartCountUri(), new JSONObject().put("value", i10));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitAppExitData(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppExitDataUri(), new JSONObject().put("value", str));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitAppStartTime(long j10) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getAppStartTimeUri(), new JSONObject().put("value", j10));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitIdentities(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getUserIdentities(), new JSONObject().put("value", "Base64:" + Base64Coder.encodeString(str)));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitLoginId(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdUri(), new JSONObject().put("value", str));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitLoginIdKey(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getLoginIdKeyUri(), new JSONObject().put("value", str));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitPushID(String str, String str2) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getPushIdUri(), new JSONObject().put(DbParams.PUSH_ID_KEY, str).put(DbParams.PUSH_ID_VALUE, str2));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitRemoteConfig(String str) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getRemoteConfigUri(), new JSONObject().put("value", str));
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitSessionIntervalTime(int i10) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSessionTimeUri(), new JSONObject().put("value", i10));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void commitSubProcessFlushState(boolean z10) {
        try {
            this.mPersistentOperation.insertData(this.mDbParams.getSubProcessUri(), new JSONObject().put("value", z10));
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
    }

    public void deleteAllEvents() {
        this.mTrackEventOperation.deleteData(this.mDbParams.getEventUri(), "DB_DELETE_ALL");
    }

    public String[] generateDataString(String str, int i10, boolean z10) {
        try {
            return this.mTrackEventOperation.queryData(this.mDbParams.getEventUri(), z10, i10);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public int getActivityCount() {
        String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getActivityStartCountUri(), 1);
        if (queryData == null || queryData.length <= 0) {
            return 0;
        }
        return Integer.parseInt(queryData[0]);
    }

    public String getAppExitData() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppExitDataUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public long getAppStartTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getAppStartTimeUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return 0;
            }
            return Long.parseLong(queryData[0]);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return 0;
        }
    }

    public String getIdentities() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getUserIdentities(), 1);
            if (queryData == null || queryData.length <= 0) {
                return null;
            }
            return decodeIdentities(queryData[0]);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return null;
        }
    }

    public String getLoginId() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public String getLoginIdKey() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getLoginIdKeyUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public String getPushId(String str) {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getPushIdUri().buildUpon().appendQueryParameter(DbParams.PUSH_ID_KEY, str).build(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public String getRemoteConfig() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getRemoteConfigUri(), 1);
            if (queryData == null || queryData.length <= 0) {
                return "";
            }
            return queryData[0];
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public String getRemoteConfigFromLocal() {
        try {
            PersistentRemoteSDKConfig remoteSDKConfig = PersistentLoader.getInstance().getRemoteSDKConfig();
            if (remoteSDKConfig == null) {
                return "";
            }
            return (String) remoteSDKConfig.get();
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "";
        }
    }

    public int getSessionIntervalTime() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSessionTimeUri(), 1);
            if (queryData != null && queryData.length > 0) {
                return Integer.parseInt(queryData[0]);
            }
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return 0;
    }

    public boolean isFirstChannelEvent(String[] strArr) {
        try {
            if (this.mTrackEventOperation.queryDataCount(this.mDbParams.getChannelPersistentUri(), (String[]) null, "event_name = ? or event_name = ? ", strArr, (String) null) <= 0) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return false;
        }
    }

    public boolean isSubProcessFlushing() {
        try {
            String[] queryData = this.mPersistentOperation.queryData(this.mDbParams.getSubProcessUri(), 1);
            if (queryData == null || queryData.length <= 0 || Integer.parseInt(queryData[0]) == 1) {
                return true;
            }
            return false;
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return true;
    }

    public void removePushId(String str) {
        this.mPersistentOperation.deleteData(this.mDbParams.getPushIdUri(), str);
    }

    public static DbAdapter getInstance() {
        DbAdapter dbAdapter = instance;
        if (dbAdapter != null) {
            return dbAdapter;
        }
        throw new IllegalStateException("The static method getInstance(SAContextManager saContextManager) should be called before calling getInstance()");
    }
}
