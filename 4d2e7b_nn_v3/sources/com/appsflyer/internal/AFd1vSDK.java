package com.appsflyer.internal;

public enum AFd1vSDK {
    API("api"),
    RC("rc"),
    DEFAULT("");
    
    public final String AFKeystoreWrapper;

    private AFd1vSDK(String str) {
        this.AFKeystoreWrapper = str;
    }
}
