package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class AFe1oSDK {
    public String AFKeystoreWrapper;
    public final WeakReference<Context> valueOf;

    public AFe1oSDK() {
    }

    static void AFInAppEventParameterName(Map<String, Object> map) {
        if (AFb1xSDK.AFInAppEventType != null) {
            StringBuilder sb2 = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
            sb2.append(map.toString());
            AFLogger.afDebugLog(sb2.toString());
            AFb1xSDK.AFInAppEventType.onConversionDataSuccess(map);
        }
    }

    static void valueOf(String str) {
        if (AFb1xSDK.AFInAppEventType != null) {
            AFLogger.afDebugLog("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            AFb1xSDK.AFInAppEventType.onConversionDataFail(str);
        }
    }

    public AFe1oSDK(Context context) {
        this.valueOf = new WeakReference<>(context);
    }
}
