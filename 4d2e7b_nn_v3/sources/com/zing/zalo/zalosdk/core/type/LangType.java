package com.zing.zalo.zalosdk.core.type;

public enum LangType {
    VN(1),
    EN(2),
    MY(3);
    
    int code;

    private LangType(int i10) {
        this.code = i10;
    }

    public int getCode() {
        return this.code;
    }

    public String getCountryCode() {
        int i10 = this.code;
        if (i10 == 1) {
            return "vi";
        }
        if (i10 == 2) {
            return "en";
        }
        return "my";
    }
}
