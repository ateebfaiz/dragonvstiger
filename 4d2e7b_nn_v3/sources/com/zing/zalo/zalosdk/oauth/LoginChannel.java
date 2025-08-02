package com.zing.zalo.zalosdk.oauth;

public enum LoginChannel {
    GUEST("GUEST"),
    ZALO("ZALO"),
    FACEBOOK("FACEBOOK"),
    GOOGLE("GOOGLE"),
    ZINGME("ZINGME");
    
    private final String name;

    private LoginChannel(String str) {
        this.name = str;
    }

    public boolean equalsName(String str) {
        if (str == null) {
            return false;
        }
        return this.name.equals(str);
    }

    public String toString() {
        return this.name;
    }
}
