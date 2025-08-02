package com.zing.zalo.devicetrackingsdk;

import android.content.Context;

public class ZPermissionManager {
    public static boolean isPermissionGranted(Context context, String str) {
        try {
            if (context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
