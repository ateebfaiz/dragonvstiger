package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.adjust.sdk.Constants;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.zing.zalo.zalosdk.common.Constant;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class AFa1fSDK implements Runnable {
    private static String AFKeystoreWrapper = null;
    @VisibleForTesting
    private static String valueOf = "https://%ssdk-services.%s/validate-android-signature";
    private WeakReference<Context> AFInAppEventParameterName;
    private final Intent AFInAppEventType;
    private String AFLogger;
    private Map<String, String> AFVersionDeclaration;
    private String afDebugLog;
    /* access modifiers changed from: private */
    public String afErrorLog;
    /* access modifiers changed from: private */
    public String afInfoLog;
    /* access modifiers changed from: private */
    public String afRDLog;
    private String values;

    static {
        StringBuilder sb2 = new StringBuilder("https://%svalidate.%s/api/v");
        sb2.append(AFb1xSDK.AFKeystoreWrapper);
        sb2.append("/androidevent?buildnumber=6.10.2&app_id=");
        AFKeystoreWrapper = sb2.toString();
    }

    AFa1fSDK(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map, @Nullable Intent intent) {
        this.AFInAppEventParameterName = new WeakReference<>(context);
        this.values = str;
        this.afDebugLog = str2;
        this.afInfoLog = str4;
        this.afErrorLog = str5;
        this.afRDLog = str6;
        this.AFVersionDeclaration = map;
        this.AFLogger = str3;
        this.AFInAppEventType = intent;
    }

    /* access modifiers changed from: private */
    public static void AFKeystoreWrapper(boolean z10, String str, String str2, String str3, String str4) {
        if (AFb1xSDK.values != null) {
            StringBuilder sb2 = new StringBuilder("Validate callback parameters: ");
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            sb2.append(" ");
            sb2.append(str3);
            AFLogger.afDebugLog(sb2.toString());
            if (z10) {
                AFLogger.afDebugLog("Validate in app purchase success: ".concat(String.valueOf(str4)));
                AFb1xSDK.values.onValidateInApp();
                return;
            }
            AFLogger.afDebugLog("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = AFb1xSDK.values;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }

    private static AFe1zSDK values(Context context, @NonNull AFf1vSDK aFf1vSDK) {
        AFb1xSDK.AFInAppEventType().values(context);
        AFc1vSDK AFKeystoreWrapper2 = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper();
        aFf1vSDK.AFInAppEventParameterName(AFKeystoreWrapper2.values().valueOf.AFInAppEventType("appsFlyerCount", 0));
        AFe1zSDK aFe1zSDK = new AFe1zSDK(aFf1vSDK, AFKeystoreWrapper2);
        AFd1sSDK afDebugLog2 = AFKeystoreWrapper2.afDebugLog();
        afDebugLog2.AFInAppEventType.execute(new Runnable(aFe1zSDK) {
            private /* synthetic */ AFd1pSDK AFInAppEventType;

            {
                this.AFInAppEventType = r2;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r6 = this;
                    com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r0 = r0.afRDLog
                    monitor-enter(r0)
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.Set<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afInfoLog     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0026 }
                    if (r1 == 0) goto L_0x0029
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                    java.lang.String r2 = "QUEUE: tried to add already running task: "
                    r1.<init>(r2)     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    r1.append(r2)     // Catch:{ all -> 0x0026 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0026 }
                    com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0026 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0026 }
                    return
                L_0x0026:
                    r1 = move-exception
                    goto L_0x0190
                L_0x0029:
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0026 }
                    if (r1 != 0) goto L_0x017b
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0026 }
                    if (r1 == 0) goto L_0x0043
                    goto L_0x017b
                L_0x0043:
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    java.util.Set<com.appsflyer.internal.AFd1rSDK> r3 = r2.AFKeystoreWrapper     // Catch:{ all -> 0x0026 }
                    java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0026 }
                L_0x004d:
                    boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0026 }
                    if (r4 == 0) goto L_0x0067
                    java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1rSDK r4 = (com.appsflyer.internal.AFd1rSDK) r4     // Catch:{ all -> 0x0026 }
                    java.util.Set<com.appsflyer.internal.AFd1rSDK> r5 = r1.valueOf     // Catch:{ all -> 0x0026 }
                    boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x0026 }
                    if (r5 == 0) goto L_0x004d
                    java.util.Set<com.appsflyer.internal.AFd1rSDK> r5 = r2.values     // Catch:{ all -> 0x0026 }
                    r5.add(r4)     // Catch:{ all -> 0x0026 }
                    goto L_0x004d
                L_0x0067:
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    boolean r1 = r1.AFKeystoreWrapper((com.appsflyer.internal.AFd1pSDK<?>) r2)     // Catch:{ all -> 0x0026 }
                    if (r1 == 0) goto L_0x007c
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0026 }
                    goto L_0x00a0
                L_0x007c:
                    com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0026 }
                    if (r1 == 0) goto L_0x00a0
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                    java.lang.String r3 = "QUEUE: new task was blocked: "
                    r2.<init>(r3)     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r3 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    r2.append(r3)     // Catch:{ all -> 0x0026 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0026 }
                    com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    r2.AFInAppEventParameterName()     // Catch:{ all -> 0x0026 }
                L_0x00a0:
                    if (r1 == 0) goto L_0x00b3
                    com.appsflyer.internal.AFd1sSDK r2 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r2.afRDLog     // Catch:{ all -> 0x0026 }
                    java.util.List<com.appsflyer.internal.AFd1pSDK<?>> r2 = r2.AFLogger     // Catch:{ all -> 0x0026 }
                    r3.addAll(r2)     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1sSDK r2 = com.appsflyer.internal.AFd1sSDK.this     // Catch:{ all -> 0x0026 }
                    java.util.List<com.appsflyer.internal.AFd1pSDK<?>> r2 = r2.AFLogger     // Catch:{ all -> 0x0026 }
                    r2.clear()     // Catch:{ all -> 0x0026 }
                    goto L_0x00c6
                L_0x00b3:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                    java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                    r2.<init>(r3)     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r3 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    r2.append(r3)     // Catch:{ all -> 0x0026 }
                    java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0026 }
                    com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0026 }
                L_0x00c6:
                    monitor-exit(r0)     // Catch:{ all -> 0x0026 }
                    if (r1 == 0) goto L_0x0167
                    com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                    java.util.Set<com.appsflyer.internal.AFd1rSDK> r0 = r0.valueOf
                    com.appsflyer.internal.AFd1pSDK r1 = r6.AFInAppEventType
                    com.appsflyer.internal.AFd1rSDK r1 = r1.AFInAppEventType
                    r0.add(r1)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "QUEUE: new task added: "
                    r0.<init>(r1)
                    com.appsflyer.internal.AFd1pSDK r1 = r6.AFInAppEventType
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.appsflyer.AFLogger.afDebugLog(r0)
                    com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                    java.util.List<com.appsflyer.internal.AFd1uSDK> r0 = r0.values
                    java.util.Iterator r0 = r0.iterator()
                L_0x00ef:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x00fc
                    java.lang.Object r1 = r0.next()
                    com.appsflyer.internal.AFd1uSDK r1 = (com.appsflyer.internal.AFd1uSDK) r1
                    goto L_0x00ef
                L_0x00fc:
                    com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                    java.util.concurrent.ExecutorService r1 = r0.AFInAppEventParameterName
                    r1.submit(r0)
                    com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.this
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r1 = r0.afRDLog
                    monitor-enter(r1)
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r2 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                    int r2 = r2.size()     // Catch:{ all -> 0x0149 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                    int r3 = r3.size()     // Catch:{ all -> 0x0149 }
                    int r2 = r2 + r3
                    int r2 = r2 + -40
                L_0x0117:
                    if (r2 <= 0) goto L_0x0163
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                    boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0149 }
                    r3 = r3 ^ 1
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r4 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                    boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0149 }
                    r4 = r4 ^ 1
                    if (r4 == 0) goto L_0x0151
                    if (r3 == 0) goto L_0x0151
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                    java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0149 }
                    com.appsflyer.internal.AFd1pSDK r3 = (com.appsflyer.internal.AFd1pSDK) r3     // Catch:{ all -> 0x0149 }
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r4 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                    java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0149 }
                    com.appsflyer.internal.AFd1pSDK r4 = (com.appsflyer.internal.AFd1pSDK) r4     // Catch:{ all -> 0x0149 }
                    int r3 = r3.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0149 }
                    if (r3 <= 0) goto L_0x014b
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                    r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                    goto L_0x0160
                L_0x0149:
                    r0 = move-exception
                    goto L_0x0165
                L_0x014b:
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                    r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                    goto L_0x0160
                L_0x0151:
                    if (r4 == 0) goto L_0x0159
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afRDLog     // Catch:{ all -> 0x0149 }
                    r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                    goto L_0x0160
                L_0x0159:
                    if (r3 == 0) goto L_0x0160
                    java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0149 }
                    r0.AFKeystoreWrapper((java.util.NavigableSet<com.appsflyer.internal.AFd1pSDK<?>>) r3)     // Catch:{ all -> 0x0149 }
                L_0x0160:
                    int r2 = r2 + -1
                    goto L_0x0117
                L_0x0163:
                    monitor-exit(r1)     // Catch:{ all -> 0x0149 }
                    return
                L_0x0165:
                    monitor-exit(r1)
                    throw r0
                L_0x0167:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "QUEUE: tried to add already pending task: "
                    r0.<init>(r1)
                    com.appsflyer.internal.AFd1pSDK r1 = r6.AFInAppEventType
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.appsflyer.AFLogger.afWarnLog(r0)
                    return
                L_0x017b:
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
                    java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                    r1.<init>(r2)     // Catch:{ all -> 0x0026 }
                    com.appsflyer.internal.AFd1pSDK r2 = r6.AFInAppEventType     // Catch:{ all -> 0x0026 }
                    r1.append(r2)     // Catch:{ all -> 0x0026 }
                    java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0026 }
                    com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0026 }
                    monitor-exit(r0)     // Catch:{ all -> 0x0026 }
                    return
                L_0x0190:
                    monitor-exit(r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1sSDK.AnonymousClass3.run():void");
            }
        });
        return aFe1zSDK;
    }

    public final void run() {
        String str = this.values;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            try {
                Context context = this.AFInAppEventParameterName.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.afDebugLog);
                    hashMap.put("sig-data", this.afInfoLog);
                    hashMap.put("signature", this.AFLogger);
                    HashMap hashMap2 = new HashMap(hashMap);
                    Map<String, String> map = this.AFVersionDeclaration;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.format(AFKeystoreWrapper, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
                    sb2.append(context.getPackageName());
                    String obj = sb2.toString();
                    String string = AFb1xSDK.AFKeystoreWrapper(context).getString(Constants.REFERRER, "");
                    AFf1rSDK aFf1rSDK = new AFf1rSDK(context);
                    aFf1rSDK.AFLogger = string;
                    AFb1xSDK AFInAppEventType2 = AFb1xSDK.AFInAppEventType();
                    Map<String, Object> AFInAppEventType3 = AFInAppEventType2.AFInAppEventType((AFa1sSDK) aFf1rSDK);
                    AFInAppEventType3.put(FirebaseAnalytics.Param.PRICE, this.afErrorLog);
                    AFInAppEventType3.put(FirebaseAnalytics.Param.CURRENCY, this.afRDLog);
                    AFInAppEventType3.put("receipt_data", hashMap2);
                    if (map != null) {
                        AFInAppEventType3.put("extra_prms", map);
                    }
                    AFInAppEventType3.putAll(AFInAppEventType2.AFKeystoreWrapper().getLevel().valueOf());
                    values(context, (AFf1rSDK) aFf1rSDK.AFKeystoreWrapper((Map<String, ?>) AFInAppEventType3).AFKeystoreWrapper(obj));
                    hashMap.put("dev_key", this.values);
                    hashMap.put(Constant.PARAM_APP_ID, context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
                    if (string2 != null) {
                        hashMap.put("advertiserId", string2);
                    }
                    AFf1wSDK aFf1wSDK = (AFf1wSDK) new AFf1wSDK().AFKeystoreWrapper((Map<String, ?>) hashMap).AFKeystoreWrapper(String.format(valueOf, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
                    final AFe1zSDK values2 = values(context, aFf1wSDK);
                    aFf1wSDK.values = new AppsFlyerRequestListener() {
                        public final void onError(int i10, @NonNull String str) {
                            AFd1zSDK<Result> aFd1zSDK;
                            if (i10 == RequestError.RESPONSE_CODE_FAILURE && (aFd1zSDK = values2.afErrorLog) != null) {
                                str = aFd1zSDK.toString();
                            }
                            AFa1fSDK.AFKeystoreWrapper(false, AFa1fSDK.this.afInfoLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.afRDLog, str);
                        }

                        public final void onSuccess() {
                            try {
                                JSONObject jSONObject = new JSONObject((String) values2.afErrorLog.getBody());
                                AFLogger.afInfoLog("Validate response ok: ".concat(String.valueOf(jSONObject)));
                                AFa1fSDK.AFKeystoreWrapper(jSONObject.optBoolean(DbParams.KEY_CHANNEL_RESULT), AFa1fSDK.this.afInfoLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.afRDLog, jSONObject.toString());
                            } catch (Exception e10) {
                                AFLogger.afErrorLog("Failed Validate request: ".concat(String.valueOf(e10)), e10);
                                AFa1fSDK.AFKeystoreWrapper(false, AFa1fSDK.this.afInfoLog, AFa1fSDK.this.afErrorLog, AFa1fSDK.this.afRDLog, e10.getMessage());
                            }
                        }
                    };
                }
            } catch (Throwable th) {
                if (AFb1xSDK.values != null) {
                    AFLogger.afErrorLog("Failed Validate request + ex", th);
                    AFKeystoreWrapper(false, this.afInfoLog, this.afErrorLog, this.afRDLog, th.getMessage());
                }
                AFLogger.afErrorLog(th.getMessage(), th);
            }
        }
    }
}
