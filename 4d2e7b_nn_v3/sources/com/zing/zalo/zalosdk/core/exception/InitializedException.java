package com.zing.zalo.zalosdk.core.exception;

public class InitializedException extends RuntimeException {
    public InitializedException() {
        super("Missing call ZingAnalyticsManager.getInstance().init(application, appID) in Application ");
    }

    public InitializedException(String str) {
        super(str);
    }
}
