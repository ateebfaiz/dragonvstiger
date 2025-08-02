package com.blankj.utilcode.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public abstract class c {
    public static String a() {
        return b(p.a().getPackageName());
    }

    public static String b(String str) {
        if (s.i(str)) {
            return "";
        }
        try {
            PackageManager packageManager = p.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo == null) {
                return "";
            }
            return packageInfo.applicationInfo.loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String c() {
        return d(p.a().getPackageName());
    }

    public static String d(String str) {
        if (s.i(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = p.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return "";
            }
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
