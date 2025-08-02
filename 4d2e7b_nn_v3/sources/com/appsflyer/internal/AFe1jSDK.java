package com.appsflyer.internal;

import androidx.core.app.NotificationCompat;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class AFe1jSDK {
    public final Map<String, Object> AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    public long AFKeystoreWrapper = 0;
    public long AFLogger = 0;
    public long AFLogger$LogLevel = 0;
    public long afDebugLog = 0;
    public final long[] afErrorLog = new long[2];
    public long afErrorLogForExcManagerOnly;
    public final long[] afInfoLog = new long[2];
    public final long[] afRDLog = new long[2];
    public final Map<String, Object> valueOf;
    public final AFc1ySDK values;

    public AFe1jSDK(AFc1ySDK aFc1ySDK) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.valueOf = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.AFInAppEventParameterName = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
        this.AFInAppEventType = concurrentHashMap3;
        this.values = aFc1ySDK;
        concurrentHashMap.putAll(valueOf("first_launch"));
        concurrentHashMap2.putAll(valueOf("ddl"));
        concurrentHashMap3.putAll(valueOf("gcd"));
        this.afErrorLogForExcManagerOnly = aFc1ySDK.AFInAppEventParameterName("prev_session_dur", 0);
    }

    private Map<String, Object> valueOf(String str) {
        Map<String, Object> emptyMap = Collections.emptyMap();
        String values2 = this.values.values(str, (String) null);
        if (values2 == null) {
            return emptyMap;
        }
        try {
            return AFa1oSDK.AFInAppEventType(new JSONObject(values2));
        } catch (Exception e10) {
            AFLogger.afErrorLog("Error while parsing cached json data", e10, true);
            return emptyMap;
        }
    }

    public final void AFInAppEventParameterName(AFe1fSDK aFe1fSDK) {
        if (AFInAppEventParameterName()) {
            this.valueOf.put("start_with", aFe1fSDK.toString());
            this.values.valueOf("first_launch", new JSONObject(this.valueOf).toString());
        }
    }

    public final void AFInAppEventType(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        this.afDebugLog = currentTimeMillis;
        if (i10 == 1) {
            long j10 = this.AFLogger;
            if (j10 != 0) {
                this.valueOf.put("from_fg", Long.valueOf(currentTimeMillis - j10));
                this.values.valueOf("first_launch", new JSONObject(this.valueOf).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: fg ts is missing");
        }
    }

    public final void AFKeystoreWrapper() {
        this.AFLogger = System.currentTimeMillis();
        if (AFInAppEventParameterName()) {
            long j10 = this.AFKeystoreWrapper;
            if (j10 != 0) {
                this.valueOf.put("init_to_fg", Long.valueOf(this.AFLogger - j10));
                this.values.valueOf("first_launch", new JSONObject(this.valueOf).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: init ts is missing");
        }
    }

    public final void values(DeepLinkResult deepLinkResult, long j10) {
        this.AFInAppEventParameterName.put(NotificationCompat.CATEGORY_STATUS, deepLinkResult.getStatus().toString());
        this.AFInAppEventParameterName.put("timeout_value", Long.valueOf(j10));
        this.values.valueOf("ddl", new JSONObject(this.AFInAppEventParameterName).toString());
    }

    public final void AFInAppEventParameterName(int i10) {
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.AFLogger$LogLevel;
        if (j10 != 0) {
            this.AFInAppEventType.put("net", Long.valueOf(currentTimeMillis - j10));
        } else {
            AFLogger.afInfoLog("Metrics: gcdStart ts is missing");
        }
        this.AFInAppEventType.put("retries", Integer.valueOf(i10));
        this.values.valueOf("gcd", new JSONObject(this.AFInAppEventType).toString());
    }

    public final boolean AFInAppEventParameterName() {
        return this.values.AFInAppEventType("appsFlyerCount", 0) == 0;
    }
}
