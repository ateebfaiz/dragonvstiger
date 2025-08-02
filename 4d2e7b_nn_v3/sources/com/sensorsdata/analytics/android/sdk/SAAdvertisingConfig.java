package com.sensorsdata.analytics.android.sdk;

import com.sensorsdata.analytics.android.sdk.encrypt.SecreteKey;
import java.util.List;

public class SAAdvertisingConfig {
    private boolean enableRemarketing = false;
    public List<String> eventNames;
    public SecreteKey secreteKey;
    public String serverUrl;
    private String wakeupUrl;

    public SAAdvertisingConfig(String str, List<String> list, SecreteKey secreteKey2) {
        this.secreteKey = secreteKey2;
        this.serverUrl = str;
        this.eventNames = list;
    }

    public SAAdvertisingConfig enableRemarketing() {
        this.enableRemarketing = true;
        return this;
    }

    public String getWakeupUrl() {
        return this.wakeupUrl;
    }

    public boolean isEnableRemarketing() {
        return this.enableRemarketing;
    }

    public SAAdvertisingConfig setWakeupUrl(String str) {
        this.wakeupUrl = str;
        return this;
    }

    public SAAdvertisingConfig() {
    }
}
