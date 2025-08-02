package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.SALog;
import java.util.HashSet;
import java.util.Set;

public class PermissionUtils {
    private static final String TAG = "SA.PermissionUtils";
    private static final Set<String> mPermissionGrantedOnceSet = new HashSet<String>() {
        {
            add("android.permission.ACCESS_WIFI_STATE");
            add("android.permission.ACCESS_NETWORK_STATE");
        }
    };
    private static final Set<String> mPermissionGrantedSet = new HashSet();

    public static boolean checkSelfPermission(Context context, String str) {
        Set<String> set = mPermissionGrantedSet;
        boolean z10 = true;
        if (set.contains(str)) {
            return true;
        }
        if (context.checkSelfPermission(str) != 0) {
            z10 = false;
        }
        if (z10 && mPermissionGrantedOnceSet.contains(str)) {
            set.add(str);
        }
        return z10;
    }

    public static boolean hasReadPhoneStatePermission(Context context) {
        if (Build.VERSION.SDK_INT > 28) {
            if (checkSelfPermission(context, "android.permission.READ_PRECISE_PHONE_STATE")) {
                return true;
            }
            SALog.i(TAG, "Don't have permission android.permission.READ_PRECISE_PHONE_STATE,getDeviceID failed");
            return false;
        } else if (checkSelfPermission(context, "android.permission.READ_PHONE_STATE")) {
            return true;
        } else {
            SALog.i(TAG, "Don't have permission android.permission.READ_PHONE_STATE,getDeviceID failed");
            return false;
        }
    }
}
