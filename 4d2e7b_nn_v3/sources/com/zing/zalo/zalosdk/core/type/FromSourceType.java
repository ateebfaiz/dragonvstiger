package com.zing.zalo.zalosdk.core.type;

public enum FromSourceType {
    SDK(1),
    ZALO_APP(2);
    
    int code;

    private FromSourceType(int i10) {
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }
}
