package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerProperties;

public final class AFf1rSDK extends AFf1vSDK {
    public AFf1rSDK(@NonNull Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    public final AFd1rSDK AFInAppEventType() {
        return AFd1rSDK.PURCHASE_VALIDATE;
    }

    public final AFa1sSDK AFKeystoreWrapper(String str) {
        String AFInAppEventParameterName = AFb1xSDK.AFInAppEventType().AFInAppEventParameterName((Context) this.AFInAppEventType);
        if (AFInAppEventParameterName != null) {
            str = Uri.parse(str).buildUpon().appendQueryParameter(AppsFlyerProperties.CHANNEL, AFInAppEventParameterName).build().toString();
        }
        return super.AFKeystoreWrapper(str);
    }
}
