package com.appsflyer.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1bSDK;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class AFa1wSDK implements AFb1bSDK {
    @VisibleForTesting
    private static IntentFilter valueOf = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    @NonNull
    public final AFb1bSDK.AFa1ySDK AFInAppEventType(Context context) {
        String str = null;
        float f10 = 0.0f;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, valueOf);
            if (registerReceiver != null) {
                if (2 == registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1)) {
                    int intExtra = registerReceiver.getIntExtra("plugged", -1);
                    if (intExtra == 1) {
                        str = "ac";
                    } else if (intExtra == 2) {
                        str = "usb";
                    } else if (intExtra != 4) {
                        str = "other";
                    } else {
                        str = "wireless";
                    }
                } else {
                    str = "no";
                }
                int intExtra2 = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
                int intExtra3 = registerReceiver.getIntExtra("scale", -1);
                if (!(-1 == intExtra2 || -1 == intExtra3)) {
                    f10 = (((float) intExtra2) * 100.0f) / ((float) intExtra3);
                }
            }
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("Device that failed to register receiver", th);
        }
        return new AFb1bSDK.AFa1ySDK(f10, str);
    }
}
