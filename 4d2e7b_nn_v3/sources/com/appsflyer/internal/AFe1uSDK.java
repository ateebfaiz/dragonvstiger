package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public final class AFe1uSDK extends AFd1iSDK<String> {
    private final Map<String, Object> afRDLog;

    public AFe1uSDK(@NonNull Map<String, Object> map, @NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.MONITORSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, String.valueOf(map.hashCode()));
        this.afRDLog = new HashMap(map);
    }

    /* access modifiers changed from: protected */
    public final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return this.AFLogger.valueOf(this.afRDLog);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afRDLog() {
        return true;
    }
}
