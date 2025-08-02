package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class AFe1mSDK extends AFd1iSDK<Map<String, Object>> {
    private static final List<String> afRDLog = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    @Nullable
    private Map<String, Object> AFLogger$LogLevel;
    private final AFc1ySDK AFVersionDeclaration;
    @Nullable
    private String AppsFlyer2dXConversionCallback;
    private final AFc1kSDK afErrorLogForExcManagerOnly;
    private final AFe1jSDK afWarnLog;
    private final AFc1zSDK getLevel;

    public AFe1mSDK(@NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.GCDSDK, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, "GCD-FETCH");
        this.afErrorLogForExcManagerOnly = aFc1vSDK.AFInAppEventType();
        this.AFVersionDeclaration = aFc1vSDK.afInfoLog();
        this.afWarnLog = aFc1vSDK.AFLogger();
        this.getLevel = aFc1vSDK.values();
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
        this.AFKeystoreWrapper.add(AFd1rSDK.LAUNCH);
    }

    public final AFc1jSDK<Map<String, Object>> AFInAppEventType(@NonNull String str) {
        String str2;
        String AFInAppEventType = AFb1xSDK.AFInAppEventType(this.AFVersionDeclaration, this.getLevel.AFInAppEventType());
        if (AFInAppEventType != null && !AFInAppEventType.trim().isEmpty()) {
            if (!afRDLog.contains(AFInAppEventType.toLowerCase(Locale.getDefault()))) {
                str2 = "-".concat(AFInAppEventType);
                AFc1jSDK<Map<String, Object>> AFInAppEventType2 = this.afErrorLogForExcManagerOnly.AFInAppEventType(str2, str);
                StringBuilder sb2 = new StringBuilder("[GCD-B01] URL: ");
                sb2.append(AFInAppEventType2.AFKeystoreWrapper.valueOf());
                AFc1rSDK.AFInAppEventParameterName(sb2.toString());
                return AFInAppEventType2;
            }
            AFLogger.afWarnLog(String.format("[GCD] AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", new Object[]{AFInAppEventType}));
        }
        str2 = "";
        AFc1jSDK<Map<String, Object>> AFInAppEventType22 = this.afErrorLogForExcManagerOnly.AFInAppEventType(str2, str);
        StringBuilder sb22 = new StringBuilder("[GCD-B01] URL: ");
        sb22.append(AFInAppEventType22.AFKeystoreWrapper.valueOf());
        AFc1rSDK.AFInAppEventParameterName(sb22.toString());
        return AFInAppEventType22;
    }

    public final boolean AFKeystoreWrapper() {
        return false;
    }

    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    public final boolean afRDLog() {
        return false;
    }

    public final void values() {
        super.values();
        Map<String, Object> map = this.AFLogger$LogLevel;
        String str = this.AppsFlyer2dXConversionCallback;
        if (map != null) {
            AFe1oSDK.AFInAppEventParameterName(map);
        } else if (str == null || str.isEmpty()) {
            AFe1oSDK.valueOf("Unknown error");
        } else {
            AFe1oSDK.valueOf(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e A[Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008d A[Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be A[Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010a A[Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073, all -> 0x0070 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1tSDK AFInAppEventType() throws java.lang.Exception {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "is_first_launch"
            java.lang.String r3 = "af_channel"
            java.lang.String r4 = "af_siteid"
            java.lang.String r5 = "[GCD-A03] Server retrieving attempt finished"
            com.appsflyer.internal.AFe1nSDK r6 = r14.afDebugLog
            boolean r6 = r6.AFInAppEventParameterName()
            if (r6 != 0) goto L_0x0155
            com.appsflyer.internal.AFd1tSDK r6 = com.appsflyer.internal.AFd1tSDK.FAILURE
            r7 = r0
        L_0x0015:
            r8 = 2
            if (r7 > r8) goto L_0x0154
            if (r7 < r8) goto L_0x001c
            r6 = r1
            goto L_0x001d
        L_0x001c:
            r6 = r0
        L_0x001d:
            com.appsflyer.internal.AFe1jSDK r8 = r14.afWarnLog
            long r9 = java.lang.System.currentTimeMillis()
            r8.AFLogger$LogLevel = r9
            com.appsflyer.internal.AFd1tSDK r8 = super.AFInAppEventType()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFd1zSDK<Result> r9 = r14.afErrorLog     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != 0) goto L_0x0036
        L_0x002d:
            com.appsflyer.internal.AFe1jSDK r6 = r14.afWarnLog
            r6.AFInAppEventParameterName((int) r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            goto L_0x0056
        L_0x0036:
            int r10 = r9.getStatusCode()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r11 = 403(0x193, float:5.65E-43)
            if (r10 == r11) goto L_0x0045
            r11 = 500(0x1f4, float:7.0E-43)
            if (r10 < r11) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r11 = r0
            goto L_0x0046
        L_0x0045:
            r11 = r1
        L_0x0046:
            boolean r12 = r9.isSuccessful()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r13 = 404(0x194, float:5.66E-43)
            if (r12 != 0) goto L_0x0079
            if (r10 != r13) goto L_0x0051
            goto L_0x0079
        L_0x0051:
            if (r6 != 0) goto L_0x0059
            if (r11 != 0) goto L_0x002d
            goto L_0x0059
        L_0x0056:
            r6 = r8
            goto L_0x0137
        L_0x0059:
            java.lang.String r8 = "Error connection to server: "
            java.lang.String r9 = java.lang.String.valueOf(r10)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r14.AppsFlyer2dXConversionCallback = r8     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.FAILURE     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
        L_0x0067:
            com.appsflyer.internal.AFe1jSDK r1 = r14.afWarnLog
            r1.AFInAppEventParameterName((int) r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            return r0
        L_0x0070:
            r0 = move-exception
            goto L_0x014b
        L_0x0073:
            r8 = move-exception
            goto L_0x0115
        L_0x0076:
            r0 = move-exception
            goto L_0x0141
        L_0x0079:
            java.lang.Object r8 = r9.getBody()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            int r9 = r9.getStatusCode()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "iscache"
            java.lang.Object r10 = r8.get(r10)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != r13) goto L_0x00a5
            java.lang.String r9 = "error_reason"
            r8.remove(r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = "status_code"
            r8.remove(r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = "af_status"
            java.lang.String r11 = "Organic"
            r8.put(r9, r11)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = "af_message"
            java.lang.String r11 = "organic install"
            r8.put(r9, r11)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
        L_0x00a5:
            if (r10 == 0) goto L_0x00b8
            boolean r9 = r10.booleanValue()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != 0) goto L_0x00b8
            com.appsflyer.internal.AFc1ySDK r9 = r14.AFVersionDeclaration     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "appsflyerConversionDataCacheExpiration"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r9.AFInAppEventType((java.lang.String) r10, (long) r11)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
        L_0x00b8:
            boolean r9 = r8.containsKey(r4)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 == 0) goto L_0x00eb
            boolean r9 = r8.containsKey(r3)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 == 0) goto L_0x00da
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "[Invite] Detected App-Invite via channel: "
            r9.<init>(r10)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.Object r10 = r8.get(r3)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r9.append(r10)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = r9.toString()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            goto L_0x00eb
        L_0x00da:
            java.lang.String r9 = "[CrossPromotion] App was installed via %s's Cross Promotion"
            java.lang.Object r10 = r8.get(r4)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.Object[] r11 = new java.lang.Object[r1]     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r11[r0] = r10     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = java.lang.String.format(r9, r11)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.AFLogger.afDebugLog(r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
        L_0x00eb:
            java.lang.Boolean r9 = java.lang.Boolean.FALSE     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r8.put(r2, r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r9.<init>(r8)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r9 = r9.toString()     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFc1ySDK r10 = r14.AFVersionDeclaration     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r11 = "attributionId"
            r10.valueOf(r11, r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFc1ySDK r9 = r14.AFVersionDeclaration     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            java.lang.String r10 = "sixtyDayConversionData"
            boolean r9 = r9.AFKeystoreWrapper(r10)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            if (r9 != 0) goto L_0x010f
            java.lang.Boolean r9 = java.lang.Boolean.TRUE     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            r8.put(r2, r9)     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
        L_0x010f:
            r14.AFLogger$LogLevel = r8     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            com.appsflyer.internal.AFd1tSDK r0 = com.appsflyer.internal.AFd1tSDK.SUCCESS     // Catch:{ AFd1qSDK -> 0x0076, Exception -> 0x0073 }
            goto L_0x0067
        L_0x0115:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0070 }
            java.lang.String r10 = "[GCD] Error: "
            r9.<init>(r10)     // Catch:{ all -> 0x0070 }
            java.lang.String r10 = r8.getMessage()     // Catch:{ all -> 0x0070 }
            r9.append(r10)     // Catch:{ all -> 0x0070 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0070 }
            com.appsflyer.AFLogger.afErrorLog(r9, r8)     // Catch:{ all -> 0x0070 }
            com.appsflyer.internal.AFd1tSDK r9 = com.appsflyer.internal.AFd1tSDK.FAILURE     // Catch:{ all -> 0x0070 }
            if (r6 != 0) goto L_0x013a
            com.appsflyer.internal.AFe1jSDK r6 = r14.afWarnLog
            r6.AFInAppEventParameterName((int) r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            r6 = r9
        L_0x0137:
            int r7 = r7 + r1
            goto L_0x0015
        L_0x013a:
            java.lang.String r0 = r8.getMessage()     // Catch:{ all -> 0x0070 }
            r14.AppsFlyer2dXConversionCallback = r0     // Catch:{ all -> 0x0070 }
            throw r8     // Catch:{ all -> 0x0070 }
        L_0x0141:
            java.lang.String r1 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0070 }
            java.lang.String r1 = "AppsFlyer dev key is missing"
            r14.AppsFlyer2dXConversionCallback = r1     // Catch:{ all -> 0x0070 }
            throw r0     // Catch:{ all -> 0x0070 }
        L_0x014b:
            com.appsflyer.internal.AFe1jSDK r1 = r14.afWarnLog
            r1.AFInAppEventParameterName((int) r7)
            com.appsflyer.AFLogger.afDebugLog(r5)
            throw r0
        L_0x0154:
            return r6
        L_0x0155:
            java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
            com.appsflyer.AFLogger.afDebugLog(r0)
            java.lang.String r0 = "'isStopTracking' enabled"
            r14.AppsFlyer2dXConversionCallback = r0
            com.appsflyer.internal.AFd1jSDK r0 = new com.appsflyer.internal.AFd1jSDK
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1mSDK.AFInAppEventType():com.appsflyer.internal.AFd1tSDK");
    }
}
