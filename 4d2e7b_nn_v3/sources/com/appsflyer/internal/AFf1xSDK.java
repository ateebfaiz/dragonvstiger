package com.appsflyer.internal;

public final class AFf1xSDK extends AFa1sSDK {
    public final AFd1rSDK AFInAppEventType() {
        if (this.afInfoLog == 1) {
            return AFd1rSDK.CONVERSION;
        }
        return AFd1rSDK.LAUNCH;
    }

    public final boolean afRDLog() {
        return true;
    }
}
