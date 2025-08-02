package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.PurchaseHandler;
import java.util.Map;

public final class AFd1nSDK extends AFd1kSDK {
    public AFd1nSDK(@NonNull Map<String, Object> map, @Nullable PurchaseHandler.PurchaseValidationCallback purchaseValidationCallback, @NonNull AFc1vSDK aFc1vSDK) {
        super(AFd1rSDK.ARS_VALIDATE, new AFd1rSDK[]{AFd1rSDK.RC_CDN}, aFc1vSDK, (String) null, map, purchaseValidationCallback);
        this.AFKeystoreWrapper.add(AFd1rSDK.CONVERSION);
    }

    /* access modifiers changed from: protected */
    public final AFc1jSDK<String> AFInAppEventType(@NonNull String str) {
        return this.AFLogger.AFKeystoreWrapper(afWarnLog(), str);
    }
}
