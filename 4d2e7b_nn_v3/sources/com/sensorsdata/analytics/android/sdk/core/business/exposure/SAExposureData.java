package com.sensorsdata.analytics.android.sdk.core.business.exposure;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.util.JSONUtils;
import org.json.JSONObject;

public class SAExposureData {
    private String event;
    private SAExposureConfig exposureConfig;
    private final String exposureIdentifier;
    private SAExposureListener exposureListener;
    private JSONObject properties;

    public SAExposureData(String str) {
        this(str, (JSONObject) null, (String) null, (SAExposureConfig) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SAExposureData sAExposureData = (SAExposureData) obj;
        if (!this.exposureConfig.equals(sAExposureData.exposureConfig) || !this.properties.toString().equals(sAExposureData.properties.toString()) || !this.event.equals(sAExposureData.event) || !this.exposureIdentifier.equals(sAExposureData.exposureIdentifier)) {
            return false;
        }
        return true;
    }

    public String getEvent() {
        return this.event;
    }

    public SAExposureConfig getExposureConfig() {
        return this.exposureConfig;
    }

    public SAExposureListener getExposureListener() {
        return this.exposureListener;
    }

    public String getIdentifier() {
        return this.exposureIdentifier;
    }

    public JSONObject getProperties() {
        return this.properties;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setExposureConfig(SAExposureConfig sAExposureConfig) {
        this.exposureConfig = sAExposureConfig;
    }

    public void setExposureListener(SAExposureListener sAExposureListener) {
        this.exposureListener = sAExposureListener;
    }

    public void setProperties(JSONObject jSONObject) {
        try {
            this.properties = JSONUtils.cloneJsonObject(jSONObject);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
    }

    public String toString() {
        return "SAExposureData{exposureConfig=" + this.exposureConfig + ", properties=" + this.properties + ", event='" + this.event + '\'' + ", exposureIdentifier='" + this.exposureIdentifier + '\'' + '}';
    }

    public SAExposureData(String str, JSONObject jSONObject) {
        this(str, jSONObject, (String) null, (SAExposureConfig) null);
    }

    public SAExposureData(String str, String str2) {
        this(str, (JSONObject) null, str2, (SAExposureConfig) null);
    }

    public SAExposureData(String str, JSONObject jSONObject, String str2) {
        this(str, jSONObject, str2, (SAExposureConfig) null);
    }

    public SAExposureData(String str, JSONObject jSONObject, SAExposureConfig sAExposureConfig) {
        this(str, jSONObject, (String) null, sAExposureConfig);
    }

    public SAExposureData(String str, JSONObject jSONObject, String str2, SAExposureConfig sAExposureConfig) {
        this.event = str;
        try {
            this.properties = JSONUtils.cloneJsonObject(jSONObject);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        this.exposureIdentifier = str2;
        this.exposureConfig = sAExposureConfig;
    }
}
