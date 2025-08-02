package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class AFd1aSDK extends AFe1zSDK {
    @NonNull
    private final AFf1jSDK AFLogger$LogLevel;
    @NonNull
    private final AFe1jSDK AFVersionDeclaration;
    @NonNull
    private final AppsFlyerProperties AppsFlyer2dXConversionCallback = AppsFlyerProperties.getInstance();
    public Map<String, Object> afErrorLogForExcManagerOnly;
    @NonNull
    private final AFc1ySDK getLevel;
    @NonNull
    private final AFb1rSDK init;

    /* renamed from: com.appsflyer.internal.AFd1aSDK$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] valueOf;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.internal.AFf1kSDK$AFa1wSDK[] r0 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                valueOf = r0
                com.appsflyer.internal.AFf1kSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = valueOf     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFf1kSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1aSDK.AnonymousClass1.<clinit>():void");
        }
    }

    public AFd1aSDK(@NonNull AFa1sSDK aFa1sSDK, @NonNull AFc1vSDK aFc1vSDK) {
        super(aFa1sSDK, aFc1vSDK);
        this.AFLogger$LogLevel = aFc1vSDK.AFVersionDeclaration();
        this.getLevel = aFc1vSDK.afInfoLog();
        this.AFVersionDeclaration = aFc1vSDK.AFLogger();
        this.init = aFc1vSDK.afRDLog();
        this.AFKeystoreWrapper.add(AFd1rSDK.RESOLVE_ESP);
        this.AFKeystoreWrapper.add(AFd1rSDK.DLSDK);
    }

    public final void values() {
        super.values();
        AFe1jSDK aFe1jSDK = this.AFVersionDeclaration;
        int i10 = this.afRDLog.afInfoLog;
        long currentTimeMillis = System.currentTimeMillis();
        if (i10 == 1) {
            long j10 = aFe1jSDK.afDebugLog;
            if (j10 != 0) {
                aFe1jSDK.valueOf.put("net", Long.valueOf(currentTimeMillis - j10));
                aFe1jSDK.values.valueOf("first_launch", new JSONObject(aFe1jSDK.valueOf).toString());
                return;
            }
            AFLogger.afInfoLog("Metrics: launch start ts is missing");
        }
    }

    /* access modifiers changed from: protected */
    public final void values(AFa1sSDK aFa1sSDK) {
        super.values(aFa1sSDK);
        int i10 = aFa1sSDK.afInfoLog;
        this.AFVersionDeclaration.AFInAppEventType(i10);
        Map map = (Map) aFa1sSDK.AFKeystoreWrapper().get("meta");
        if (map == null) {
            map = new HashMap();
            aFa1sSDK.AFKeystoreWrapper().put("meta", map);
        }
        AFb1cSDK AFInAppEventType = this.init.AFInAppEventType();
        if (AFInAppEventType != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("cdn_token", AFInAppEventType.values);
            String str = AFInAppEventType.AFInAppEventType;
            if (str != null) {
                hashMap.put("c_ver", str);
            }
            long j10 = AFInAppEventType.AFInAppEventParameterName;
            if (j10 > 0) {
                hashMap.put("latency", Long.valueOf(j10));
            }
            long j11 = AFInAppEventType.valueOf;
            if (j11 > 0) {
                hashMap.put("delay", Long.valueOf(j11));
            }
            int i11 = AFInAppEventType.afRDLog;
            if (i11 > 0) {
                hashMap.put("res_code", Integer.valueOf(i11));
            }
            if (AFInAppEventType.afInfoLog != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(AFInAppEventType.afInfoLog.getClass().getSimpleName());
                sb2.append(": ");
                sb2.append(AFInAppEventType.afInfoLog.getMessage());
                hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, sb2.toString());
            }
            AFf1tSDK aFf1tSDK = AFInAppEventType.AFLogger;
            if (aFf1tSDK != null) {
                hashMap.put("sig", aFf1tSDK.toString());
            }
            String str2 = AFInAppEventType.afDebugLog;
            if (str2 != null) {
                hashMap.put("cdn_cache_status", str2);
            }
            map.put("rc", hashMap);
        }
        if (i10 == 1) {
            if (this.AppsFlyer2dXConversionCallback.getBoolean(AppsFlyerProperties.AF_WAITFOR_CUSTOMERID, false)) {
                aFa1sSDK.AFKeystoreWrapper().put("wait_cid", Boolean.toString(true));
            }
            HashMap hashMap2 = new HashMap(this.AFVersionDeclaration.AFInAppEventParameterName);
            this.AFVersionDeclaration.values.valueOf("ddl");
            if (!hashMap2.isEmpty()) {
                map.put("ddl", hashMap2);
            }
            HashMap hashMap3 = new HashMap(this.AFVersionDeclaration.valueOf);
            if (!hashMap3.isEmpty()) {
                map.put("first_launch", hashMap3);
            }
        } else if (i10 == 2) {
            HashMap hashMap4 = new HashMap(this.AFVersionDeclaration.valueOf);
            if (!hashMap4.isEmpty()) {
                map.put("first_launch", hashMap4);
            }
            this.AFVersionDeclaration.values.valueOf("first_launch");
        }
        if (map.isEmpty()) {
            aFa1sSDK.AFKeystoreWrapper().remove("meta");
        }
        if (i10 <= 2) {
            ArrayList arrayList = new ArrayList();
            for (AFf1kSDK aFf1kSDK : this.AFLogger$LogLevel.AFInAppEventParameterName()) {
                boolean z10 = aFf1kSDK instanceof AFf1pSDK;
                int i12 = AnonymousClass1.valueOf[aFf1kSDK.afRDLog.ordinal()];
                if (i12 == 1) {
                    if (z10) {
                        aFa1sSDK.AFKeystoreWrapper("rfr", ((AFf1pSDK) aFf1kSDK).AFKeystoreWrapper);
                        this.getLevel.AFInAppEventType(AppsFlyerProperties.NEW_REFERRER_SENT, true);
                    }
                    arrayList.add(aFf1kSDK.AFInAppEventType);
                } else if (i12 == 2 && i10 == 2 && !z10) {
                    HashMap hashMap5 = new HashMap();
                    hashMap5.put("source", aFf1kSDK.valueOf);
                    hashMap5.put("response", "TIMEOUT");
                    hashMap5.put("type", aFf1kSDK.AFLogger);
                    arrayList.add(hashMap5);
                }
            }
            if (!arrayList.isEmpty()) {
                aFa1sSDK.AFKeystoreWrapper("referrers", arrayList);
            }
            Map<String, Object> map2 = this.afErrorLogForExcManagerOnly;
            if (map2 != null) {
                aFa1sSDK.AFKeystoreWrapper("fb_ddl", map2);
            }
        }
    }
}
