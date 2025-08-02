package com.appsflyer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.internal.AFb1ySDK;
import com.appsflyer.internal.AFc1vSDK;
import com.appsflyer.internal.AFc1zSDK;
import com.appsflyer.internal.AFd1sSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

public final class PurchaseHandler {
    @NonNull
    public final AFc1vSDK AFInAppEventParameterName;
    @NonNull
    private final AFc1zSDK AFKeystoreWrapper;
    @NonNull
    public final AFd1sSDK values;

    public interface PurchaseValidationCallback {
        void onFailure(@NonNull Throwable th);

        void onResponse(@NonNull ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(@NonNull AFc1vSDK aFc1vSDK) {
        this.AFInAppEventParameterName = aFc1vSDK;
        this.AFKeystoreWrapper = aFc1vSDK.values();
        this.values = aFc1vSDK.afDebugLog();
    }

    public final boolean values(Map<String, Object> map, @Nullable PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean AFKeystoreWrapper2 = AFb1ySDK.AFKeystoreWrapper(map, strArr, this.AFKeystoreWrapper);
        if (!AFKeystoreWrapper2 && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return AFKeystoreWrapper2;
    }
}
