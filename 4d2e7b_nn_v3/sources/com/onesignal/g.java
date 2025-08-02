package com.onesignal;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

abstract class g {
    static void a(Activity activity, String[] strArr, int i10) {
        activity.requestPermissions(strArr, i10);
    }

    static boolean b(Activity activity, String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }
}
