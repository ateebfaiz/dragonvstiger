package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.PurchaseHandler;
import java.util.Map;
import org.json.JSONObject;

public final class AFd1hSDK extends AFd1kSDK {
    private final AFc1zSDK afRDLog;

    public AFd1hSDK(@NonNull Map<String, Object> map, @Nullable PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.PURCHASE_VALIDATE, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, (String) null, map, purchaseValidationCallback);
        this.afRDLog = aFc1vSDK.values();
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
    }

    /* access modifiers changed from: protected */
    public final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("https://%sviap.%s/api/v1/android/validate_purchase?app_id=", new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()}));
        sb2.append(this.afRDLog.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName());
        String obj = sb2.toString();
        String jSONObject = new JSONObject(afWarnLog()).toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(this);
        sb3.append(": preparing data: ");
        sb3.append(jSONObject);
        AFc1rSDK.AFInAppEventParameterName(sb3.toString());
        this.afInfoLog.AFInAppEventParameterName(obj, jSONObject);
        return this.AFLogger.AFInAppEventParameterName(afWarnLog(), str);
    }

    public final boolean AFKeystoreWrapper() {
        AFd1zSDK<Result> aFd1zSDK = this.afErrorLog;
        if (aFd1zSDK == null || aFd1zSDK.getStatusCode() != 503) {
            return super.AFKeystoreWrapper();
        }
        return true;
    }
}
