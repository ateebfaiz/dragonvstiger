package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.adjust.sdk.Constants;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.AFc1oSDK;
import com.appsflyer.internal.AFf1kSDK;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1oSDK extends AFe1bSDK {
    @VisibleForTesting
    private static String afErrorLogForExcManagerOnly = "https://%sdlsdk.%s/v1.0/android/";
    public static long afWarnLog;
    private final CountDownLatch AFLogger$LogLevel = new CountDownLatch(1);
    private final AFe1nSDK AppsFlyer2dXConversionCallback;
    private final List<AFf1kSDK> getLevel = new ArrayList();
    private final AFc1zSDK init;
    private final ExecutorService onAppOpenAttributionNative;
    private int onAttributionFailureNative;
    private boolean onConversionDataSuccess;
    private final AFb1sSDK onDeepLinkingNative;
    private final AFe1jSDK onInstallConversionDataLoadedNative;
    private final AFf1jSDK onInstallConversionFailureNative;
    private int onResponseErrorNative;
    private int onResponseNative;

    /* renamed from: com.appsflyer.internal.AFb1oSDK$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

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
                AFKeystoreWrapper = r0
                com.appsflyer.internal.AFf1kSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = AFKeystoreWrapper     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.AFf1kSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1kSDK.AFa1wSDK.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1oSDK.AnonymousClass3.<clinit>():void");
        }
    }

    public AFb1oSDK(Context context, AFc1vSDK aFc1vSDK) {
        super((String) null, afErrorLogForExcManagerOnly, Boolean.FALSE, Boolean.TRUE, (Boolean) null, context);
        this.onInstallConversionDataLoadedNative = aFc1vSDK.AFLogger();
        this.init = aFc1vSDK.values();
        this.AppsFlyer2dXConversionCallback = aFc1vSDK.getLevel();
        this.onInstallConversionFailureNative = aFc1vSDK.AFVersionDeclaration();
        this.onAppOpenAttributionNative = aFc1vSDK.AFKeystoreWrapper();
        this.onDeepLinkingNative = aFc1vSDK.afErrorLogForExcManagerOnly();
    }

    private static Map<String, String> AFInAppEventParameterName(AFf1kSDK aFf1kSDK) {
        if (aFf1kSDK.afRDLog != AFf1kSDK.AFa1wSDK.FINISHED) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str = (String) aFf1kSDK.AFInAppEventType.get(Constants.REFERRER);
        if (str == null) {
            return null;
        }
        hashMap.put("source", (String) aFf1kSDK.AFInAppEventType.get("source"));
        hashMap.put("value", str);
        return hashMap;
    }

    private static boolean AFKeystoreWrapper(AFf1kSDK aFf1kSDK) {
        Long l10 = (Long) aFf1kSDK.AFInAppEventType.get("click_ts");
        if (l10 != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l10.longValue()) < TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }

    private boolean AFVersionDeclaration() {
        int i10;
        List list = (List) this.AFKeystoreWrapper.get("referrers");
        if (list != null) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        if (i10 >= this.onResponseNative || this.AFKeystoreWrapper.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void getLevel() {
        String[] strArr;
        boolean z10 = true;
        this.onResponseErrorNative++;
        StringBuilder sb2 = new StringBuilder("[DDL] Preparing request ");
        sb2.append(this.onResponseErrorNative);
        AFLogger.afDebugLog(sb2.toString());
        if (this.onResponseErrorNative == 1) {
            AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
            Map<String, Object> map = this.AFKeystoreWrapper;
            if (this.init.valueOf.AFInAppEventType("appsFlyerCount", 0) != 0) {
                z10 = false;
            }
            map.put("is_first", Boolean.valueOf(z10));
            Map<String, Object> map2 = this.AFKeystoreWrapper;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(Locale.getDefault().getLanguage());
            sb3.append("-");
            sb3.append(Locale.getDefault().getCountry());
            map2.put("lang", sb3.toString());
            this.AFKeystoreWrapper.put("os", Build.VERSION.RELEASE);
            this.AFKeystoreWrapper.put("type", Build.MODEL);
            this.AFKeystoreWrapper.put("request_id", AFb1wSDK.AFKeystoreWrapper(new WeakReference(this.init.AFKeystoreWrapper.AFKeystoreWrapper)));
            AFa1eSDK aFa1eSDK = AFInAppEventType.AFLogger;
            if (!(aFa1eSDK == null || (strArr = aFa1eSDK.AFInAppEventType) == null)) {
                this.AFKeystoreWrapper.put("sharing_filter", strArr);
            }
            Map<String, Object> AFInAppEventType2 = AFInAppEventType(AFa1bSDK.values(this.init.AFKeystoreWrapper.AFKeystoreWrapper, (Map<String, Object>) new HashMap()));
            Map<String, Object> AFInAppEventType3 = AFInAppEventType(AFa1bSDK.valueOf(this.init.AFKeystoreWrapper.AFKeystoreWrapper));
            if (AFInAppEventType2 != null) {
                this.AFKeystoreWrapper.put("gaid", AFInAppEventType2);
            }
            if (AFInAppEventType3 != null) {
                this.AFKeystoreWrapper.put("oaid", AFInAppEventType3);
            }
        }
        Map<String, Object> map3 = this.AFKeystoreWrapper;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        long currentTimeMillis = System.currentTimeMillis();
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        map3.put("timestamp", simpleDateFormat.format(new Date(currentTimeMillis)));
        this.AFKeystoreWrapper.put("request_count", Integer.valueOf(this.onResponseErrorNative));
        ArrayList arrayList = new ArrayList();
        for (AFf1kSDK AFInAppEventParameterName : this.getLevel) {
            Map<String, String> AFInAppEventParameterName2 = AFInAppEventParameterName(AFInAppEventParameterName);
            if (AFInAppEventParameterName2 != null) {
                arrayList.add(AFInAppEventParameterName2);
            }
        }
        if (!arrayList.isEmpty()) {
            this.AFKeystoreWrapper.put("referrers", arrayList);
        }
        AFKeystoreWrapper(onInstallConversionDataLoadedNative());
    }

    @VisibleForTesting
    private String onInstallConversionDataLoadedNative() {
        String str;
        String str2 = this.AppsFlyer2dXConversionCallback.values;
        String packageName = this.init.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName();
        String AFInAppEventType = this.init.AFInAppEventType();
        if (AFInAppEventType == null || AFInAppEventType.trim().isEmpty()) {
            str = "";
        } else {
            str = "-".concat(AFInAppEventType);
        }
        Uri.Builder buildUpon = Uri.parse(String.format(afErrorLogForExcManagerOnly, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).buildUpon();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(packageName);
        sb2.append(str);
        Uri.Builder appendPath = buildUpon.appendPath(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this.AFKeystoreWrapper.get("timestamp"));
        sb3.append(str2);
        return appendPath.appendQueryParameter("af_sig", AFb1ySDK.AFKeystoreWrapper(sb3.toString(), str2)).appendQueryParameter("sdk_version", AFb1xSDK.AFKeystoreWrapper).build().toString();
    }

    static /* synthetic */ void values(AFb1oSDK aFb1oSDK) {
        ArrayList<AFf1kSDK> arrayList = new ArrayList<>();
        for (AFf1kSDK aFf1kSDK : aFb1oSDK.onInstallConversionFailureNative.AFInAppEventParameterName()) {
            if (!(aFf1kSDK == null || aFf1kSDK.afRDLog == AFf1kSDK.AFa1wSDK.NOT_STARTED)) {
                arrayList.add(aFf1kSDK);
            }
        }
        aFb1oSDK.onResponseNative = arrayList.size();
        for (final AFf1kSDK aFf1kSDK2 : arrayList) {
            int i10 = AnonymousClass3.AFKeystoreWrapper[aFf1kSDK2.afRDLog.ordinal()];
            if (i10 == 1) {
                StringBuilder sb2 = new StringBuilder("[DDL] ");
                sb2.append(aFf1kSDK2.AFInAppEventType.get("source"));
                sb2.append(" referrer collected earlier");
                AFLogger.afDebugLog(sb2.toString());
                aFb1oSDK.AFInAppEventType(aFf1kSDK2);
            } else if (i10 == 2) {
                aFf1kSDK2.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        StringBuilder sb2 = new StringBuilder("[DDL] ");
                        sb2.append(aFf1kSDK2.AFInAppEventType.get("source"));
                        sb2.append(" referrer collected via observer");
                        AFLogger.afDebugLog(sb2.toString());
                        AFb1oSDK.this.AFInAppEventType((AFf1kSDK) observable);
                    }
                });
            }
        }
    }

    public final DeepLinkResult afInfoLog() {
        DeepLinkResult.Error error;
        AFLogger.afDebugLog("[DDL] start");
        FutureTask futureTask = new FutureTask(new Callable<DeepLinkResult>() {
            public final /* synthetic */ Object call() throws Exception {
                Application AFInAppEventParameterName2 = AFb1oSDK.this.AFInAppEventType;
                AFb1oSDK.values(AFb1oSDK.this);
                AFb1oSDK.this.getLevel();
                return AFb1oSDK.AFInAppEventParameterName(AFb1oSDK.this, AFInAppEventParameterName2);
            }
        });
        this.onAppOpenAttributionNative.execute(futureTask);
        try {
            DeepLinkResult deepLinkResult = (DeepLinkResult) futureTask.get(afWarnLog, TimeUnit.MILLISECONDS);
            this.onInstallConversionDataLoadedNative.values(deepLinkResult, afWarnLog);
            AFb1nSDK.AFInAppEventType(deepLinkResult);
            return deepLinkResult;
        } catch (InterruptedException | ExecutionException e10) {
            AFLogger.afErrorLog("[DDL] Error occurred", e10, true);
            if (e10.getCause() instanceof IOException) {
                error = DeepLinkResult.Error.NETWORK;
            } else {
                error = DeepLinkResult.Error.UNEXPECTED;
            }
            DeepLinkResult deepLinkResult2 = new DeepLinkResult((DeepLink) null, error);
            this.onInstallConversionDataLoadedNative.values(deepLinkResult2, afWarnLog);
            AFb1nSDK.AFInAppEventType(deepLinkResult2);
            return deepLinkResult2;
        } catch (TimeoutException e11) {
            AFLogger.afErrorLogForExcManagerOnly("[DDL] Timeout", e11);
            StringBuilder sb2 = new StringBuilder("[DDL] Timeout, didn't manage to find deferred deep link after ");
            sb2.append(this.onResponseErrorNative);
            sb2.append(" attempt(s) within ");
            sb2.append(afWarnLog);
            sb2.append(" milliseconds");
            AFLogger.afDebugLog(sb2.toString());
            DeepLinkResult deepLinkResult3 = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.TIMEOUT);
            this.onInstallConversionDataLoadedNative.values(deepLinkResult3, afWarnLog);
            AFb1nSDK.AFInAppEventType(deepLinkResult3);
            return deepLinkResult3;
        }
    }

    /* access modifiers changed from: private */
    public void AFInAppEventType(AFf1kSDK aFf1kSDK) {
        if (AFKeystoreWrapper(aFf1kSDK)) {
            this.getLevel.add(aFf1kSDK);
            this.AFLogger$LogLevel.countDown();
            StringBuilder sb2 = new StringBuilder("[DDL] Added non-organic ");
            sb2.append(aFf1kSDK.getClass().getSimpleName());
            AFLogger.afDebugLog(sb2.toString());
            return;
        }
        int i10 = this.onAttributionFailureNative + 1;
        this.onAttributionFailureNative = i10;
        if (i10 == this.onResponseNative) {
            this.AFLogger$LogLevel.countDown();
        }
    }

    static /* synthetic */ DeepLinkResult AFInAppEventParameterName(AFb1oSDK aFb1oSDK, Context context) throws IOException, JSONException, InterruptedException {
        DeepLink deepLink;
        while (true) {
            AFe1jSDK aFe1jSDK = aFb1oSDK.onInstallConversionDataLoadedNative;
            int i10 = aFb1oSDK.onResponseErrorNative;
            if (i10 <= 0 || i10 > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - start", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i10))));
            } else {
                int i11 = i10 - 1;
                aFe1jSDK.afErrorLog[i11] = System.currentTimeMillis();
                if (i11 == 0) {
                    long j10 = aFe1jSDK.AFLogger;
                    if (j10 != 0) {
                        aFe1jSDK.AFInAppEventParameterName.put("from_fg", Long.valueOf(aFe1jSDK.afErrorLog[i11] - j10));
                        aFe1jSDK.values.valueOf("ddl", new JSONObject(aFe1jSDK.AFInAppEventParameterName).toString());
                    } else {
                        AFLogger.afInfoLog("Metrics: fg ts is missing");
                    }
                }
            }
            HttpURLConnection AFInAppEventType = new AFa1rSDK(aFb1oSDK, aFb1oSDK.onDeepLinkingNative).AFInAppEventType(aFb1oSDK.AppsFlyer2dXConversionCallback.values);
            AFe1jSDK aFe1jSDK2 = aFb1oSDK.onInstallConversionDataLoadedNative;
            int i12 = aFb1oSDK.onResponseErrorNative;
            if (i12 <= 0 || i12 > 2) {
                AFLogger.afErrorLogForExcManagerOnly("Unexpected ddl requestCount - end", new IllegalStateException("Metrics: Unexpected ddl requestCount = ".concat(String.valueOf(i12))));
            } else {
                int i13 = i12 - 1;
                aFe1jSDK2.afRDLog[i13] = System.currentTimeMillis();
                long j11 = aFe1jSDK2.afErrorLog[i13];
                if (j11 != 0) {
                    long[] jArr = aFe1jSDK2.afInfoLog;
                    jArr[i13] = aFe1jSDK2.afRDLog[i13] - j11;
                    aFe1jSDK2.AFInAppEventParameterName.put("net", jArr);
                    aFe1jSDK2.values.valueOf("ddl", new JSONObject(aFe1jSDK2.AFInAppEventParameterName).toString());
                } else {
                    StringBuilder sb2 = new StringBuilder("Metrics: ddlStart[");
                    sb2.append(i13);
                    sb2.append("] ts is missing");
                    AFLogger.afInfoLog(sb2.toString());
                }
            }
            if (AFInAppEventType.getResponseCode() == 200) {
                JSONObject jSONObject = new JSONObject(AFb1xSDK.AFKeystoreWrapper(AFInAppEventType));
                aFb1oSDK.onConversionDataSuccess = jSONObject.optBoolean("is_second_ping", true);
                if (!jSONObject.optBoolean("found")) {
                    deepLink = null;
                } else {
                    deepLink = DeepLink.valueOf(jSONObject.optJSONObject("click_event"));
                    deepLink.values.put("is_deferred", true);
                }
                if (deepLink != null) {
                    return new DeepLinkResult(deepLink, (DeepLinkResult.Error) null);
                }
                if (aFb1oSDK.onResponseErrorNative <= 1 && aFb1oSDK.AFVersionDeclaration() && aFb1oSDK.onConversionDataSuccess) {
                    AFLogger.afDebugLog("[DDL] Waiting for referrers...");
                    aFb1oSDK.AFLogger$LogLevel.await();
                    AFe1jSDK aFe1jSDK3 = aFb1oSDK.onInstallConversionDataLoadedNative;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j12 = aFe1jSDK3.afRDLog[0];
                    if (j12 != 0) {
                        aFe1jSDK3.AFInAppEventParameterName.put("rfr_wait", Long.valueOf(currentTimeMillis - j12));
                        aFe1jSDK3.values.valueOf("ddl", new JSONObject(aFe1jSDK3.AFInAppEventParameterName).toString());
                    } else {
                        AFLogger.afInfoLog("Metrics: ddlEnd[0] ts is missing");
                    }
                    if (aFb1oSDK.onAttributionFailureNative == aFb1oSDK.onResponseNative) {
                        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
                    }
                    aFb1oSDK.getLevel();
                }
            } else {
                StringBuilder sb3 = new StringBuilder("[DDL] Error occurred. Server response code = ");
                sb3.append(AFInAppEventType.getResponseCode());
                AFLogger.afDebugLog(sb3.toString());
                return new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.HTTP_STATUS_CODE);
            }
        }
        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
    }

    public final AFd1rSDK AFInAppEventType() {
        return AFd1rSDK.DLSDK;
    }

    @Nullable
    private Map<String, Object> AFInAppEventType(final AFc1oSDK.AFa1xSDK aFa1xSDK) {
        if (aFa1xSDK == null || aFa1xSDK.AFInAppEventParameterName == null) {
            return null;
        }
        Boolean bool = aFa1xSDK.valueOf;
        if (bool == null || !bool.booleanValue()) {
            return new HashMap<String, Object>() {
                {
                    put("type", "unhashed");
                    put("value", aFa1xSDK.AFInAppEventParameterName);
                }
            };
        }
        return null;
    }
}
