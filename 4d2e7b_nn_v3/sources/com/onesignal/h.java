package com.onesignal;

import android.content.Context;
import android.os.Process;
import android.util.Log;

abstract class h {
    static int a(Context context, String str) {
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable unused) {
            Log.e("OneSignal", "checkSelfPermission failed, returning PERMISSION_DENIED");
            return -1;
        }
    }

    static int b(Context context, int i10) {
        return context.getColor(i10);
    }
}
