package com.sensorsdata.analytics.android.sdk.deeplink;

import java.io.Serializable;
import org.json.JSONObject;

public class SADeepLinkObject implements Serializable {
    private long mAppAwakePassedTime;
    private String mChannels;
    private JSONObject mCustomParams;
    private String mParams;
    private boolean success;

    public SADeepLinkObject(String str, JSONObject jSONObject, String str2, boolean z10, long j10) {
        this.mParams = str;
        this.mChannels = str2;
        this.success = z10;
        this.mCustomParams = jSONObject;
        this.mAppAwakePassedTime = j10;
    }

    public long getAppAwakePassedTime() {
        return this.mAppAwakePassedTime;
    }

    public String getChannels() {
        return this.mChannels;
    }

    public JSONObject getCustomParams() {
        return this.mCustomParams;
    }

    public String getParams() {
        return this.mParams;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
