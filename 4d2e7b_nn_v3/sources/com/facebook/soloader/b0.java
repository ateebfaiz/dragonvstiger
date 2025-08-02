package com.facebook.soloader;

import android.os.StrictMode;

public class b0 extends a0 {
    public String c() {
        return "SystemLoadWrapperSoSource";
    }

    public int d(String str, int i10, StrictMode.ThreadPolicy threadPolicy) {
        try {
            System.loadLibrary(str.substring(3, str.length() - 3));
            return 1;
        } catch (Exception e10) {
            m.c("SoLoader", "Error loading library: " + str, e10);
            return 0;
        }
    }

    public String toString() {
        return c() + "[" + SysUtil.getClassLoaderLdLoadLibrary() + "]";
    }
}
