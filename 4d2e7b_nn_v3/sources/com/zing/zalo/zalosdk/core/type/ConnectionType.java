package com.zing.zalo.zalosdk.core.type;

public enum ConnectionType {
    MOBILE(1),
    WIFI(2);
    
    int code;

    private ConnectionType(int i10) {
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }
}
