package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import java.util.Map;
import org.json.JSONException;

public final class AFe1gSDK extends AFd1pSDK<Void> {
    @Nullable
    private final AFd1zSDK<String> AFLogger;
    private final AFc1ySDK afErrorLog;
    @Nullable
    private final Throwable afInfoLog;

    public AFe1gSDK(AFd1aSDK aFd1aSDK, AFc1ySDK aFc1ySDK) {
        super(AFd1rSDK.GCDSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, "GCD-CHECK");
        this.afInfoLog = aFd1aSDK.afInfoLog();
        this.AFLogger = aFd1aSDK.afErrorLog;
        this.afErrorLog = aFc1ySDK;
    }

    @Nullable
    private Map<String, Object> AFLogger() {
        String values = this.afErrorLog.values("attributionId", (String) null);
        if (values == null) {
            return null;
        }
        try {
            new AFc1eSDK();
            return AFc1eSDK.values(values);
        } catch (JSONException e10) {
            StringBuilder sb2 = new StringBuilder("[GCD] Failed to parse GCD response: ");
            sb2.append(e10.getMessage());
            AFLogger.afErrorLog(sb2.toString(), e10);
            return null;
        }
    }

    @NonNull
    public final AFd1tSDK AFInAppEventType() throws Exception {
        AFLogger.afDebugLog("[GCD-A01] Loading conversion data. Counter: ".concat(String.valueOf(this.afErrorLog.AFInAppEventType("appsFlyerCount", 0))));
        long AFInAppEventParameterName = this.afErrorLog.AFInAppEventParameterName("appsflyerConversionDataCacheExpiration", 0);
        if (AFInAppEventParameterName != 0 && System.currentTimeMillis() - AFInAppEventParameterName > 5184000000L) {
            AFLogger.afDebugLog("[GCD-E02] Cached conversion data expired");
            this.afErrorLog.AFInAppEventType("sixtyDayConversionData", true);
            this.afErrorLog.valueOf("attributionId", (String) null);
            this.afErrorLog.AFInAppEventType("appsflyerConversionDataCacheExpiration", 0);
        }
        Map<String, Object> AFLogger2 = AFLogger();
        if (AFLogger2 != null) {
            try {
                if (!AFLogger2.containsKey("is_first_launch")) {
                    AFLogger2.put("is_first_launch", Boolean.FALSE);
                }
                AFe1oSDK.AFInAppEventParameterName(AFLogger2);
            } catch (Exception e10) {
                StringBuilder sb2 = new StringBuilder("[GCD] Error executing conversion data callback: ");
                sb2.append(e10.getLocalizedMessage());
                AFLogger.afErrorLog(sb2.toString(), e10);
            }
            return AFd1tSDK.SUCCESS;
        }
        try {
            if (this.afInfoLog != null) {
                StringBuilder sb3 = new StringBuilder("Launch exception: ");
                sb3.append(this.afInfoLog.getMessage());
                AFe1oSDK.valueOf(sb3.toString());
                return AFd1tSDK.SUCCESS;
            }
            AFd1zSDK<String> aFd1zSDK = this.AFLogger;
            if (aFd1zSDK != null && !aFd1zSDK.isSuccessful()) {
                StringBuilder sb4 = new StringBuilder("Launch status code: ");
                sb4.append(this.AFLogger.getStatusCode());
                AFe1oSDK.valueOf(sb4.toString());
                return AFd1tSDK.SUCCESS;
            }
            return AFd1tSDK.FAILURE;
        } catch (Exception e11) {
            StringBuilder sb5 = new StringBuilder("[GCD] Error executing conversion data callback: ");
            sb5.append(e11.getLocalizedMessage());
            AFLogger.afErrorLog(sb5.toString(), e11);
        }
    }

    public final boolean AFKeystoreWrapper() {
        return false;
    }

    public final long valueOf() {
        return 1000;
    }
}
