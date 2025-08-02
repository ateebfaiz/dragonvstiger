package com.appsflyer.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;

public final class AFc1zSDK {
    private static String AFInAppEventParameterName = "233";
    public final AFc1sSDK AFKeystoreWrapper;
    public final AFc1ySDK valueOf;
    private Bundle values = null;

    public AFc1zSDK(AFc1sSDK aFc1sSDK, AFc1ySDK aFc1ySDK) {
        this.AFKeystoreWrapper = aFc1sSDK;
        this.valueOf = aFc1ySDK;
    }

    public static String values() {
        return AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
    }

    @Nullable
    public final String AFInAppEventType(String str) {
        Object obj;
        try {
            if (this.values == null) {
                this.values = this.AFKeystoreWrapper.AFKeystoreWrapper.getPackageManager().getApplicationInfo(this.AFKeystoreWrapper.AFKeystoreWrapper.getPackageName(), 128).metaData;
            }
            Bundle bundle = this.values;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable th) {
            StringBuilder sb2 = new StringBuilder("Could not load manifest metadata!");
            sb2.append(th.getMessage());
            AFLogger.afErrorLog(sb2.toString(), th);
            return null;
        }
    }

    public final boolean valueOf(String str) {
        String AFInAppEventType = AFInAppEventType(str);
        if (AFInAppEventType != null) {
            return Boolean.parseBoolean(AFInAppEventType);
        }
        return false;
    }

    @Nullable
    public static String valueOf() {
        StringBuilder sb2 = new StringBuilder("version: 6.10.2 (build ");
        sb2.append(AFInAppEventParameterName);
        sb2.append(")");
        return sb2.toString();
    }

    public final String AFInAppEventType() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.CHANNEL);
        if (string == null) {
            string = AFInAppEventType("CHANNEL");
        }
        if (string == null || !string.equals("")) {
            return string;
        }
        return null;
    }
}
