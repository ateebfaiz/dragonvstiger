package com.appsflyer;

import androidx.annotation.NonNull;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.share.LinkGenerator;
import java.util.Map;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener, DeepLinkListener, LinkGenerator.ResponseListener {
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[Catch:{ JSONException -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[Catch:{ JSONException -> 0x002b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void values(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002b }
            r0.<init>()     // Catch:{ JSONException -> 0x002b }
            java.lang.String r1 = "status"
            java.lang.String r2 = "failure"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x002b }
            java.lang.String r1 = "data"
            r0.put(r1, r5)     // Catch:{ JSONException -> 0x002b }
            int r5 = r4.hashCode()     // Catch:{ JSONException -> 0x002b }
            r1 = -1390007222(0xffffffffad262c4a, float:-9.445842E-12)
            r2 = 1
            if (r5 == r1) goto L_0x002d
            r1 = 1050716216(0x3ea0a838, float:0.3137834)
            if (r5 == r1) goto L_0x0021
            goto L_0x0037
        L_0x0021:
            java.lang.String r5 = "onInstallConversionFailure"
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x002b }
            if (r4 == 0) goto L_0x0037
            r4 = 0
            goto L_0x0038
        L_0x002b:
            r4 = move-exception
            goto L_0x0045
        L_0x002d:
            java.lang.String r5 = "onAttributionFailure"
            boolean r4 = r4.equals(r5)     // Catch:{ JSONException -> 0x002b }
            if (r4 == 0) goto L_0x0037
            r4 = r2
            goto L_0x0038
        L_0x0037:
            r4 = -1
        L_0x0038:
            if (r4 == 0) goto L_0x0041
            if (r4 == r2) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r3.onAttributionFailureNative(r0)     // Catch:{ JSONException -> 0x002b }
        L_0x0040:
            return
        L_0x0041:
            r3.onInstallConversionFailureNative(r0)     // Catch:{ JSONException -> 0x002b }
            return
        L_0x0045:
            java.lang.String r5 = "2dx error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r5, r4)
            r4.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.AppsFlyer2dXConversionCallback.values(java.lang.String, java.lang.String):void");
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public native void onAppOpenAttributionNative(Object obj);

    public void onAttributionFailure(String str) {
        values("onInstallConversionFailure", str);
    }

    public native void onAttributionFailureNative(Object obj);

    public void onConversionDataFail(String str) {
        values("onAttributionFailure", str);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onDeepLinking(@NonNull DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    public native void onDeepLinkingNative(@NonNull DeepLinkResult deepLinkResult);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);

    public void onResponse(String str) {
        onResponseNative(str);
    }

    public void onResponseError(String str) {
        onResponseErrorNative(str);
    }

    public native void onResponseErrorNative(String str);

    public native void onResponseNative(String str);
}
