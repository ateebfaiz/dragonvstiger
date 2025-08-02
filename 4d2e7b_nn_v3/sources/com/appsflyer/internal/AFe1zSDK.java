package com.appsflyer.internal;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.AFa1ySDK;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.text.j;
import org.json.JSONObject;

public class AFe1zSDK extends AFd1iSDK<String> {
    private static final AFd1rSDK[] getLevel = {AFd1rSDK.DLSDK, AFd1rSDK.ONELINK, AFd1rSDK.MONITORSDK, AFd1rSDK.REGISTER};
    @NonNull
    private final AFc1zSDK AFLogger$LogLevel;
    private final AFd1wSDK AFVersionDeclaration;
    private final AFb1rSDK afErrorLogForExcManagerOnly;
    public final AFa1sSDK afRDLog;
    protected final AFc1ySDK afWarnLog;

    public AFe1zSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1vSDK aFc1vSDK) {
        this(aFa1sSDK, aFc1vSDK, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af A[SYNTHETIC, Splitter:B:29:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb A[Catch:{ NullPointerException -> 0x00b8, all -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFc1jSDK<java.lang.String> AFInAppEventType(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            r2 = 0
            r3 = 1
            java.lang.String r4 = "Unexpected error"
            java.lang.String r5 = "*Non-printing character*"
            java.lang.String r6 = "\\p{C}"
            java.lang.String r7 = "JSON toString of eventParams map returns null"
            java.lang.String r8 = ""
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            r1.values(r0)
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.util.Map r0 = r0.AFKeystoreWrapper()
            java.lang.String r9 = "meta"
            boolean r0 = r0.containsKey(r9)
            if (r0 == 0) goto L_0x003f
            com.appsflyer.internal.AFb1rSDK r0 = r1.afErrorLogForExcManagerOnly     // Catch:{ NullPointerException -> 0x002e }
            com.appsflyer.internal.AFe1qSDK r0 = r0.AFInAppEventParameterName     // Catch:{ NullPointerException -> 0x002e }
            com.appsflyer.internal.AFb1iSDK r0 = r0.valueOf     // Catch:{ NullPointerException -> 0x002e }
            com.appsflyer.internal.AFb1mSDK r0 = r0.AFInAppEventType     // Catch:{ NullPointerException -> 0x002e }
            com.appsflyer.internal.AFb1nSDK r0 = r0.valueOf     // Catch:{ NullPointerException -> 0x002e }
            double r10 = r0.values     // Catch:{ NullPointerException -> 0x002e }
            goto L_0x0030
        L_0x002e:
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x0030:
            boolean r0 = com.appsflyer.internal.AFa1sSDK.values(r10)
            if (r0 == 0) goto L_0x003f
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.util.Map r0 = r0.AFKeystoreWrapper()
            r0.remove(r9)
        L_0x003f:
            com.appsflyer.internal.AFa1sSDK r0 = r1.afRDLog
            java.lang.String r9 = r0.afErrorLog
            java.util.Map r10 = r0.AFKeystoreWrapper()
            r11 = 0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ NullPointerException -> 0x0066, all -> 0x0064 }
            r0.<init>(r10)     // Catch:{ NullPointerException -> 0x0066, all -> 0x0064 }
            java.lang.String r12 = r0.toString()     // Catch:{ NullPointerException -> 0x0066, all -> 0x0064 }
            if (r12 == 0) goto L_0x005e
            java.lang.String r0 = r12.replaceAll(r6, r5)     // Catch:{ NullPointerException -> 0x005c, all -> 0x0059 }
            goto L_0x00d9
        L_0x0059:
            r0 = move-exception
            r11 = r12
            goto L_0x0069
        L_0x005c:
            r0 = move-exception
            goto L_0x0070
        L_0x005e:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x005c, all -> 0x0059 }
            r0.<init>(r7)     // Catch:{ NullPointerException -> 0x005c, all -> 0x0059 }
            throw r0     // Catch:{ NullPointerException -> 0x005c, all -> 0x0059 }
        L_0x0064:
            r0 = move-exception
            goto L_0x0069
        L_0x0066:
            r0 = move-exception
            r12 = r11
            goto L_0x0070
        L_0x0069:
            com.appsflyer.AFLogger.afErrorLog(r4, r0, r3)
            r0 = r8
            r12 = r11
            goto L_0x00d9
        L_0x0070:
            java.lang.String r13 = "JSONObject return null String object. Trying to create AFJsonObject."
            com.appsflyer.AFLogger.afErrorLog(r13, r0, r3)
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ all -> 0x00c1 }
            r0[r2] = r10     // Catch:{ all -> 0x00c1 }
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c1 }
            r15 = 0
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            int r10 = r10 + 36
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00c1 }
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            int r13 = r13 + 72
            int r14 = android.text.TextUtils.getTrimmedLength(r8)     // Catch:{ all -> 0x00c1 }
            r15 = 48063(0xbbbf, float:6.735E-41)
            int r14 = r14 + r15
            char r14 = (char) r14     // Catch:{ all -> 0x00c1 }
            java.lang.Object r10 = com.appsflyer.internal.AFa1vSDK.AFInAppEventParameterName(r10, r13, r14)     // Catch:{ all -> 0x00c1 }
            java.lang.Class r10 = (java.lang.Class) r10     // Catch:{ all -> 0x00c1 }
            java.lang.String r13 = "AFInAppEventType"
            java.lang.Class[] r14 = new java.lang.Class[r3]     // Catch:{ all -> 0x00c1 }
            java.lang.Class<java.util.Map> r15 = java.util.Map.class
            r14[r2] = r15     // Catch:{ all -> 0x00c1 }
            java.lang.reflect.Method r2 = r10.getMethod(r13, r14)     // Catch:{ all -> 0x00c1 }
            java.lang.Object r0 = r2.invoke(r11, r0)     // Catch:{ all -> 0x00c1 }
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00c1 }
            if (r2 == 0) goto L_0x00bb
            java.lang.String r0 = r2.replaceAll(r6, r5)     // Catch:{ NullPointerException -> 0x00b8, all -> 0x00b5 }
            r12 = r2
            goto L_0x00d9
        L_0x00b5:
            r0 = move-exception
            r12 = r2
            goto L_0x00ce
        L_0x00b8:
            r0 = move-exception
            r12 = r2
            goto L_0x00d3
        L_0x00bb:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ NullPointerException -> 0x00b8, all -> 0x00b5 }
            r0.<init>(r7)     // Catch:{ NullPointerException -> 0x00b8, all -> 0x00b5 }
            throw r0     // Catch:{ NullPointerException -> 0x00b8, all -> 0x00b5 }
        L_0x00c1:
            r0 = move-exception
            java.lang.Throwable r2 = r0.getCause()     // Catch:{ NullPointerException -> 0x00cb, all -> 0x00c9 }
            if (r2 == 0) goto L_0x00cd
            throw r2     // Catch:{ NullPointerException -> 0x00cb, all -> 0x00c9 }
        L_0x00c9:
            r0 = move-exception
            goto L_0x00ce
        L_0x00cb:
            r0 = move-exception
            goto L_0x00d3
        L_0x00cd:
            throw r0     // Catch:{ NullPointerException -> 0x00cb, all -> 0x00c9 }
        L_0x00ce:
            com.appsflyer.AFLogger.afErrorLog(r4, r0, r3)
        L_0x00d1:
            r0 = r8
            goto L_0x00d9
        L_0x00d3:
            java.lang.String r2 = "AFJsonObject return null String object."
            com.appsflyer.AFLogger.afErrorLog(r2, r0, r3)
            goto L_0x00d1
        L_0x00d9:
            if (r12 != 0) goto L_0x00dc
            goto L_0x00dd
        L_0x00dc:
            r8 = r12
        L_0x00dd:
            boolean r2 = r0.equals(r8)
            if (r2 != 0) goto L_0x00e9
            java.lang.String r2 = "Payload contains non-printing characters"
            com.appsflyer.AFLogger.afWarnLog(r2)
            goto L_0x00ea
        L_0x00e9:
            r0 = r8
        L_0x00ea:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r3 = ": preparing data: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            com.appsflyer.internal.AFc1rSDK.AFInAppEventParameterName(r2)
            com.appsflyer.internal.AFb1sSDK r2 = r1.afInfoLog
            r2.AFInAppEventParameterName(r9, r0)
            com.appsflyer.internal.AFc1kSDK r0 = r1.AFLogger
            com.appsflyer.internal.AFa1sSDK r2 = r1.afRDLog
            r3 = r18
            com.appsflyer.internal.AFc1jSDK r0 = r0.AFInAppEventParameterName((com.appsflyer.internal.AFa1sSDK) r2, (java.lang.String) r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1zSDK.AFInAppEventType(java.lang.String):com.appsflyer.internal.AFc1jSDK");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final AppsFlyerRequestListener AFLogger() {
        return this.afRDLog.values;
    }

    /* access modifiers changed from: protected */
    public boolean afRDLog() {
        return true;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void values(AFa1sSDK aFa1sSDK) {
        boolean z10;
        AFd1vSDK aFd1vSDK;
        if (aFa1sSDK.AFLogger()) {
            aFa1sSDK.AFKeystoreWrapper((Map<String, ?>) new AFa1ySDK.AFa1xSDK(aFa1sSDK.AFKeystoreWrapper(), this.afDebugLog.valueOf.AFKeystoreWrapper));
        }
        if (aFa1sSDK.afDebugLog()) {
            aFa1sSDK.AFKeystoreWrapper((Map<String, ?>) this.afDebugLog.valueOf());
        }
        Set<AFd1rSDK> set = this.values;
        if (set.contains(AFd1rSDK.LAUNCH) || set.contains(AFd1rSDK.CONVERSION)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (afErrorLog() && z10) {
            aFa1sSDK.AFInAppEventParameterName(this.afWarnLog.AFInAppEventType("appsFlyerCount", 0));
        }
        try {
            if (aFa1sSDK.AFKeystoreWrapper().containsKey("appsflyerKey") && aFa1sSDK.AFLogger()) {
                new AFb1ySDK();
                aFa1sSDK.AFKeystoreWrapper("af_v", AFb1ySDK.values(aFa1sSDK.AFKeystoreWrapper()));
                new AFb1ySDK();
                aFa1sSDK.AFKeystoreWrapper("af_v2", AFb1ySDK.AFInAppEventParameterName(aFa1sSDK.AFKeystoreWrapper()));
            }
        } catch (Throwable th) {
            AFLogger.afErrorLog("QUEUE: failed to update the event, is missing DevKey? Error: ".concat(String.valueOf(th)), th);
        }
        if (aFa1sSDK.afRDLog()) {
            Map<String, Object> AFInAppEventType = AFInAppEventType(aFa1sSDK);
            AFd1wSDK aFd1wSDK = this.AFVersionDeclaration;
            String values = aFd1wSDK.values();
            String AFInAppEventType2 = aFd1wSDK.AFInAppEventType();
            if (AFd1wSDK.AFInAppEventParameterName()) {
                aFd1vSDK = AFd1vSDK.DEFAULT;
            } else {
                aFd1vSDK = AFd1vSDK.API;
            }
            AFd1xSDK aFd1xSDK = new AFd1xSDK(values, AFInAppEventType2, aFd1vSDK);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", aFd1xSDK.valueOf);
            AFd1vSDK aFd1vSDK2 = aFd1xSDK.AFInAppEventParameterName;
            if (aFd1vSDK2 != AFd1vSDK.DEFAULT) {
                jSONObject.put(FirebaseAnalytics.Param.METHOD, aFd1vSDK2.AFKeystoreWrapper);
            }
            String str = aFd1xSDK.values;
            if (str != null && !j.s(str)) {
                jSONObject.put("prefix", aFd1xSDK.values);
            }
            AFInAppEventType.put("host", jSONObject);
        }
        if (this.AFLogger$LogLevel.valueOf("AF_PREINSTALL_DISABLED")) {
            AFInAppEventType(aFa1sSDK).put("preinstall_disabled", Boolean.TRUE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AFe1zSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1vSDK aFc1vSDK, String str) {
        super(aFa1sSDK.AFInAppEventType(), new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, str);
        int i10 = 0;
        this.afRDLog = aFa1sSDK;
        this.AFVersionDeclaration = aFc1vSDK.init();
        this.afWarnLog = aFc1vSDK.afInfoLog();
        this.afErrorLogForExcManagerOnly = aFc1vSDK.afRDLog();
        this.AFLogger$LogLevel = aFc1vSDK.values();
        AFd1rSDK[] aFd1rSDKArr = getLevel;
        int length = aFd1rSDKArr.length;
        while (i10 < length) {
            if (this.AFInAppEventType != aFd1rSDKArr[i10]) {
                i10++;
            } else {
                return;
            }
        }
        int i11 = this.afRDLog.afInfoLog;
        AFd1rSDK aFd1rSDK = this.AFInAppEventType;
        if (i11 <= 0) {
            AFd1rSDK aFd1rSDK2 = AFd1rSDK.CONVERSION;
            if (aFd1rSDK != aFd1rSDK2) {
                this.values.add(aFd1rSDK2);
                return;
            }
            return;
        }
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
    }

    @NonNull
    private static Map<String, Object> AFInAppEventType(AFa1sSDK aFa1sSDK) {
        Map<String, Object> map = (Map) aFa1sSDK.AFKeystoreWrapper().get("meta");
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        aFa1sSDK.AFKeystoreWrapper().put("meta", hashMap);
        return hashMap;
    }
}
