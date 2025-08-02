package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.List;

public abstract class j {
    public static String a() {
        String c10 = c();
        if (!TextUtils.isEmpty(c10)) {
            return c10;
        }
        String b10 = b();
        if (!TextUtils.isEmpty(b10)) {
            return b10;
        }
        return d();
    }

    private static String b() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) p.a().getSystemService("activity");
            if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                if (runningAppProcesses.size() != 0) {
                    int myPid = Process.myPid();
                    for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                        if (next.pid == myPid && (str = next.processName) != null) {
                            return str;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static String c() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    private static String d() {
        try {
            Application a10 = p.a();
            Field field = a10.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(a10);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", (Class[]) null).invoke(obj2, (Object[]) null);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
