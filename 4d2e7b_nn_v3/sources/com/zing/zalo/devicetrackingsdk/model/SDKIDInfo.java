package com.zing.zalo.devicetrackingsdk.model;

import java.util.Locale;

public class SDKIDInfo {
    private String privateKey;
    private String sdkId;

    public String getPrivateKey() {
        return this.privateKey;
    }

    public String getSdkId() {
        return this.sdkId;
    }

    public void setPrivateKey(String str) {
        this.privateKey = str;
    }

    public void setSdkId(String str) {
        this.sdkId = str;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "sdkid: %s, privateKey: %s", new Object[]{this.sdkId, this.privateKey});
    }
}
