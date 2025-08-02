package com.sensorsdata.analytics.android.sdk.plugin.property.impl;

import android.content.Context;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.core.SAContextManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertiesFetcher;
import com.sensorsdata.analytics.android.sdk.plugin.property.beans.SAPropertyFilter;
import com.sensorsdata.analytics.android.sdk.util.AppInfoUtils;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import com.sensorsdata.analytics.android.sdk.util.DeviceUtils;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import com.sensorsdata.analytics.android.sdk.util.NetworkUtils;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import com.sensorsdata.analytics.android.sdk.util.TimeUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class SAPresetPropertyPlugin extends SAPropertyPlugin {
    private final Context mContext;
    private final boolean mDisableAndroidId;
    private final boolean mDisableTrackDeviceId;
    private JSONObject presetProperty;

    public SAPresetPropertyPlugin(SAContextManager sAContextManager) {
        this.mContext = sAContextManager.getContext();
        this.mDisableTrackDeviceId = sAContextManager.getInternalConfigs().isTrackDeviceId;
        this.mDisableAndroidId = sAContextManager.getInternalConfigs().saConfigOptions.isDisableDeviceId();
    }

    private JSONObject getPreset() {
        JSONObject jSONObject = new JSONObject();
        try {
            String harmonyOSVersion = DeviceUtils.getHarmonyOSVersion();
            if (!TextUtils.isEmpty(harmonyOSVersion)) {
                jSONObject.put("$os", "HarmonyOS");
                jSONObject.put("$os_version", harmonyOSVersion);
            } else {
                jSONObject.put("$os", "Android");
                jSONObject.put("$os_version", DeviceUtils.getOS());
            }
            jSONObject.put("$lib", "Android");
            jSONObject.put("$lib_version", SensorsDataAPI.sharedInstance().getSDKVersion());
            jSONObject.put("$manufacturer", DeviceUtils.getManufacturer());
            jSONObject.put("$model", DeviceUtils.getModel());
            jSONObject.put("$brand", DeviceUtils.getBrand());
            jSONObject.put("$app_version", AppInfoUtils.getAppVersionName(this.mContext));
            int[] deviceSize = DeviceUtils.getDeviceSize(this.mContext);
            jSONObject.put("$screen_width", deviceSize[0]);
            jSONObject.put("$screen_height", deviceSize[1]);
            Integer zoneOffset = TimeUtils.getZoneOffset();
            if (zoneOffset != null) {
                jSONObject.put("$timezone_offset", zoneOffset);
            }
            jSONObject.put("$app_id", AppInfoUtils.getProcessName(this.mContext));
            jSONObject.put("$app_name", AppInfoUtils.getAppName(this.mContext));
            String identifier = SensorsDataUtils.getIdentifier(this.mContext);
            if (!this.mDisableTrackDeviceId && !TextUtils.isEmpty(identifier)) {
                if (this.mDisableAndroidId) {
                    jSONObject.put("$anonymization_id", Base64Coder.encodeString(identifier));
                } else {
                    jSONObject.put("$device_id", identifier);
                }
            }
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject;
    }

    public JSONObject getPresetProperties() {
        try {
            if (this.presetProperty == null) {
                this.presetProperty = new JSONObject(getPreset().toString());
            }
            String networkType = NetworkUtils.networkType(this.mContext);
            this.presetProperty.put("$wifi", "WIFI".equals(networkType));
            this.presetProperty.put("$network_type", networkType);
            return new JSONObject(this.presetProperty.toString());
        } catch (JSONException e10) {
            SALog.printStackTrace(e10);
            return new JSONObject();
        }
    }

    public boolean isMatchedWithFilter(SAPropertyFilter sAPropertyFilter) {
        return sAPropertyFilter.getType().isTrack();
    }

    public void properties(SAPropertiesFetcher sAPropertiesFetcher) {
        try {
            JSONObject presetProperties = getPresetProperties();
            if (sAPropertiesFetcher.getProperties().has("$lib_version")) {
                presetProperties.remove("$lib_version");
            }
            if (sAPropertiesFetcher.getProperties().has("$lib")) {
                presetProperties.remove("$lib");
            }
            if (sAPropertiesFetcher.getProperties().has("$app_version")) {
                presetProperties.remove("$app_version");
            }
            JSONUtils.mergeJSONObject(presetProperties, sAPropertiesFetcher.getProperties());
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }
}
