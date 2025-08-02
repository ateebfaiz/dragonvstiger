package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;

public final class AFe1sSDK {
    private static final long valueOf = TimeUnit.HOURS.toSeconds(24);
    private final AFe1qSDK AFInAppEventParameterName;
    private final AFc1zSDK AFKeystoreWrapper;

    public AFe1sSDK(AFc1zSDK aFc1zSDK, AFe1qSDK aFe1qSDK) {
        this.AFKeystoreWrapper = aFc1zSDK;
        this.AFInAppEventParameterName = aFe1qSDK;
    }

    public final boolean AFInAppEventType() {
        return Boolean.parseBoolean(this.AFKeystoreWrapper.AFInAppEventType("com.appsflyer.rc.sandbox"));
    }

    public final long AFKeystoreWrapper() {
        String AFInAppEventType = this.AFKeystoreWrapper.AFInAppEventType("com.appsflyer.rc.cache.max-age-fallback");
        if (AFInAppEventType == null) {
            return valueOf;
        }
        try {
            return Long.parseLong(AFInAppEventType);
        } catch (NumberFormatException e10) {
            StringBuilder sb2 = new StringBuilder("Can't read maxAgeFallback from Manifest: ");
            sb2.append(e10.getMessage());
            AFLogger.afErrorLog(sb2.toString(), e10);
            return valueOf;
        }
    }

    public final boolean valueOf() {
        if (this.AFInAppEventParameterName.valueOf == null) {
            AFLogger.afInfoLog("CFG: active config is missing - fetching from CDN");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        AFe1qSDK aFe1qSDK = this.AFInAppEventParameterName;
        if (currentTimeMillis - aFe1qSDK.AFKeystoreWrapper > TimeUnit.SECONDS.toMillis(aFe1qSDK.values)) {
            return true;
        }
        return false;
    }

    public final boolean values() {
        return Boolean.parseBoolean(this.AFKeystoreWrapper.AFInAppEventType("com.appsflyer.rc.staging"));
    }
}
