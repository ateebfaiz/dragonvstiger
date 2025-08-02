package com.zing.zalo.zalosdk.core.type;

public enum PlatformType {
    ANDROID(1),
    IOS(2);
    
    int code;

    private PlatformType(int i10) {
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }
}
