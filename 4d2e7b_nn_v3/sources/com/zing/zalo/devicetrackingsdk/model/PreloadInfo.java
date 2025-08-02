package com.zing.zalo.devicetrackingsdk.model;

import android.content.Context;
import com.google.firebase.messaging.Constants;
import com.zing.zalo.zalosdk.core.SettingsManager;
import com.zing.zalo.zalosdk.core.helper.AppInfo;
import com.zing.zalo.zalosdk.core.helper.DeviceHelper;
import com.zing.zalo.zalosdk.core.log.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PreloadInfo {
    public Context context;
    public String error;
    public String preload;

    public PreloadInfo(Context context2) {
        this.context = context2;
    }

    private boolean checkingConditionInJsonArray(String str, String str2) {
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (str.contains(jSONArray.optString(i10))) {
                    return true;
                }
            }
        } catch (JSONException unused) {
        }
        return false;
    }

    private boolean isPreloadWithNewCondition() {
        boolean z10;
        try {
            String brandPreloadSetting = SettingsManager.getInstance().getBrandPreloadSetting(this.context);
            String modelPreloadSetting = SettingsManager.getInstance().getModelPreloadSetting(this.context);
            String preloadDefaultSetting = SettingsManager.getInstance().getPreloadDefaultSetting(this.context);
            String lowerCase = AppInfo.getPreloadChannel(this.context).toLowerCase();
            boolean checkingConditionInJsonArray = checkingConditionInJsonArray(DeviceHelper.getBrand().toLowerCase(), brandPreloadSetting);
            boolean checkingConditionInJsonArray2 = checkingConditionInJsonArray(DeviceHelper.getModel().toLowerCase(), modelPreloadSetting);
            boolean checkingConditionInJsonArray3 = checkingConditionInJsonArray(lowerCase, preloadDefaultSetting);
            if (!checkingConditionInJsonArray || (!checkingConditionInJsonArray2 && !checkingConditionInJsonArray3)) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                this.preload = "preload_apk";
            }
            return z10;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean isPreloaded() {
        String str;
        String str2 = this.preload;
        if ((str2 == null || str2.trim().length() <= 0) && (((str = this.error) == null || str.trim().length() <= 0) && !isPreloadWithNewCondition())) {
            return false;
        }
        return true;
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("preload", this.preload);
            jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, this.error);
            jSONObject.put("isPreload", isPreloaded());
        } catch (JSONException e10) {
            Log.e(PreloadInfo.class.getSimpleName(), (Exception) e10);
        }
        return jSONObject;
    }

    public PreloadInfo(Context context2, String str, String str2) {
        this.context = context2;
        this.preload = str;
        this.error = str2;
    }

    public PreloadInfo(String str, String str2) {
        this.preload = str;
        this.error = str2;
    }
}
