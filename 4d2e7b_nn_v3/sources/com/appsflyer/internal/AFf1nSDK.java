package com.appsflyer.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;

public abstract class AFf1nSDK extends AFf1kSDK {
    public AFf1nSDK(String str, String str2, Runnable runnable) {
        super(str, str2, runnable);
    }

    protected static boolean AFKeystoreWrapper(@NonNull Context context) {
        if (AFb1xSDK.AFInAppEventType().valueOf(AFb1xSDK.AFKeystoreWrapper(context), false) <= 0) {
            return true;
        }
        AFLogger.afRDLog("Install referrer will not load, the counter > 1, ");
        return false;
    }
}
