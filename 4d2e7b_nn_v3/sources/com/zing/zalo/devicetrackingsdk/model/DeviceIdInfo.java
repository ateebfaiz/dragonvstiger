package com.zing.zalo.devicetrackingsdk.model;

import java.util.Locale;

public class DeviceIdInfo {
    private String deviceId = "";
    private long deviceIdExpiredTime;

    public String getDeviceId() {
        return this.deviceId;
    }

    public long getDeviceIdExpiredTime() {
        return this.deviceIdExpiredTime;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceIdExpiredTime(long j10) {
        this.deviceIdExpiredTime = j10;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "did: %s, expire: %d", new Object[]{this.deviceId, Long.valueOf(this.deviceIdExpiredTime)});
    }
}
