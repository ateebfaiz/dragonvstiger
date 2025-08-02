package com.appsflyer.internal;

import android.content.Context;
import android.os.Build;
import com.appsflyer.AFLogger;

public class AFe1iSDK {
    public static boolean valueOf(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return context.getPackageManager().isInstantApp();
        }
        try {
            context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
            return true;
        } catch (ClassNotFoundException e10) {
            AFLogger.afErrorLogForExcManagerOnly("InstantAppsRuntime not found", e10, true);
            return false;
        }
    }
}
