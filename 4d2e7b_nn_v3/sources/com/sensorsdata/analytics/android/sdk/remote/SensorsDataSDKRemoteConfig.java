package com.sensorsdata.analytics.android.sdk.remote;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import org.json.JSONArray;
import org.json.JSONObject;

public class SensorsDataSDKRemoteConfig {
    static final int REMOTE_EVENT_TYPE_NO_USE = -1;
    private int autoTrackMode = -1;
    private boolean disableDebugMode = false;
    private boolean disableSDK = false;
    private int effectMode;
    private JSONArray eventBlacklist;
    private int mAutoTrackEventType;
    private SecreteKey mSecretKey;
    private String newVersion;
    private String oldVersion;

    /* access modifiers changed from: package-private */
    public int getAutoTrackEventType() {
        return this.mAutoTrackEventType;
    }

    /* access modifiers changed from: package-private */
    public int getAutoTrackMode() {
        return this.autoTrackMode;
    }

    public int getEffectMode() {
        return this.effectMode;
    }

    public JSONArray getEventBlacklist() {
        return this.eventBlacklist;
    }

    public String getNewVersion() {
        return this.newVersion;
    }

    /* access modifiers changed from: package-private */
    public String getOldVersion() {
        return this.oldVersion;
    }

    public SecreteKey getSecretKey() {
        return this.mSecretKey;
    }

    /* access modifiers changed from: package-private */
    public boolean isAutoTrackEventTypeIgnored(int i10) {
        int i11 = this.autoTrackMode;
        if (i11 == -1) {
            return false;
        }
        if (i11 == 0) {
            return true;
        }
        int i12 = this.mAutoTrackEventType;
        if ((i10 | i12) != i12) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isDisableDebugMode() {
        return this.disableDebugMode;
    }

    /* access modifiers changed from: package-private */
    public boolean isDisableSDK() {
        return this.disableSDK;
    }

    public void setAutoTrackMode(int i10) {
        this.autoTrackMode = i10;
        if (i10 == -1 || i10 == 0) {
            this.mAutoTrackEventType = 0;
            return;
        }
        if ((i10 & 1) == 1) {
            this.mAutoTrackEventType |= 1;
        }
        if ((i10 & 2) == 2) {
            this.mAutoTrackEventType |= 2;
        }
        if ((i10 & 4) == 4) {
            this.mAutoTrackEventType |= 4;
        }
        if ((i10 & 8) == 8) {
            this.mAutoTrackEventType |= 8;
        }
    }

    public void setDisableDebugMode(boolean z10) {
        this.disableDebugMode = z10;
    }

    public void setDisableSDK(boolean z10) {
        this.disableSDK = z10;
    }

    public void setEffectMode(int i10) {
        this.effectMode = i10;
    }

    public void setEventBlacklist(JSONArray jSONArray) {
        this.eventBlacklist = jSONArray;
    }

    public void setNewVersion(String str) {
        this.newVersion = str;
    }

    public void setOldVersion(String str) {
        this.oldVersion = str;
    }

    public void setSecretKey(SecreteKey secreteKey) {
        this.mSecretKey = secreteKey;
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DomainUhfReportModel.ENCRYPTYPE, this.oldVersion);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disableDebugMode", this.disableDebugMode);
            jSONObject2.put("autoTrackMode", this.autoTrackMode);
            jSONObject2.put("disableSDK", this.disableSDK);
            jSONObject2.put("event_blacklist", this.eventBlacklist);
            jSONObject2.put("nv", this.newVersion);
            jSONObject2.put("effect_mode", this.effectMode);
            jSONObject.put("configs", jSONObject2);
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
        }
        return jSONObject;
    }

    public String toString() {
        return "{ v=" + this.oldVersion + ", disableDebugMode=" + this.disableDebugMode + ", disableSDK=" + this.disableSDK + ", autoTrackMode=" + this.autoTrackMode + ", event_blacklist=" + this.eventBlacklist + ", nv=" + this.newVersion + ", effect_mode=" + this.effectMode + "}";
    }
}
