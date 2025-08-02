package com.onesignal;

import java.io.File;

abstract class p4 {
    static boolean a() {
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        int i10 = 0;
        while (i10 < 8) {
            try {
                if (new File(strArr[i10] + "su").exists()) {
                    return true;
                }
                i10++;
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
