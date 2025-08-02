package com.sensorsdata.analytics.android.sdk.util;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.sensorsdata.analytics.android.sdk.SALog;

public class DeviceUtils {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056 A[SYNTHETIC, Splitter:B:29:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064 A[SYNTHETIC, Splitter:B:34:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String exec(java.lang.String r5) {
        /*
            java.lang.String r0 = "SA.Exec"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x004a }
            java.lang.Process r5 = r2.exec(r5)     // Catch:{ all -> 0x004a }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x004a }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ all -> 0x004a }
            r2.<init>(r5)     // Catch:{ all -> 0x004a }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x0047 }
            r5.<init>(r2)     // Catch:{ all -> 0x0047 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0028 }
            r3.<init>()     // Catch:{ all -> 0x0028 }
        L_0x001e:
            java.lang.String r4 = r5.readLine()     // Catch:{ all -> 0x0028 }
            if (r4 == 0) goto L_0x002a
            r3.append(r4)     // Catch:{ all -> 0x0028 }
            goto L_0x001e
        L_0x0028:
            r3 = move-exception
            goto L_0x004d
        L_0x002a:
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0028 }
            r5.close()     // Catch:{ all -> 0x0032 }
            goto L_0x003a
        L_0x0032:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x003a:
            r2.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0046
        L_0x003e:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0046:
            return r1
        L_0x0047:
            r3 = move-exception
            r5 = r1
            goto L_0x004d
        L_0x004a:
            r3 = move-exception
            r5 = r1
            r2 = r5
        L_0x004d:
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0071 }
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0071 }
            if (r5 == 0) goto L_0x0062
            r5.close()     // Catch:{ all -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0062:
            if (r2 == 0) goto L_0x0070
            r2.close()     // Catch:{ IOException -> 0x0068 }
            goto L_0x0070
        L_0x0068:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0070:
            return r1
        L_0x0071:
            r1 = move-exception
            if (r5 == 0) goto L_0x0080
            r5.close()     // Catch:{ all -> 0x0078 }
            goto L_0x0080
        L_0x0078:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x0080:
            if (r2 == 0) goto L_0x008e
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008e
        L_0x0086:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            com.sensorsdata.analytics.android.sdk.SALog.i((java.lang.String) r0, (java.lang.String) r5)
        L_0x008e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.util.DeviceUtils.exec(java.lang.String):java.lang.String");
    }

    public static String getBrand() {
        try {
            String str = Build.BRAND;
            if (str != null) {
                return str.trim().toUpperCase();
            }
            return "UNKNOWN";
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "UNKNOWN";
        }
    }

    public static int[] getDeviceSize(Context context) {
        int[] iArr = new int[2];
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            int rotation = defaultDisplay.getRotation();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int i10 = point.x;
            int i11 = point.y;
            iArr[0] = getNaturalWidth(rotation, i10, i11);
            iArr[1] = getNaturalHeight(rotation, i10, i11);
        } catch (Exception unused) {
            if (context.getResources() != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                iArr[0] = displayMetrics.widthPixels;
                iArr[1] = displayMetrics.heightPixels;
            }
        }
        return iArr;
    }

    public static String getHarmonyOSVersion() {
        if (!isHarmonyOs()) {
            return null;
        }
        String prop = getProp("hw_sc.build.platform.version", "");
        if (TextUtils.isEmpty(prop)) {
            return exec(SensorsDataUtils.COMMAND_HARMONYOS_VERSION);
        }
        return prop;
    }

    public static String getManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            if (str != null) {
                return str.trim().toUpperCase();
            }
            return "UNKNOWN";
        } catch (Exception e10) {
            SALog.printStackTrace(e10);
            return "UNKNOWN";
        }
    }

    public static String getModel() {
        String str = Build.MODEL;
        if (TextUtils.isEmpty(str)) {
            return "UNKNOWN";
        }
        return str.trim();
    }

    private static int getNaturalHeight(int i10, int i11, int i12) {
        return (i10 == 0 || i10 == 2) ? i12 : i11;
    }

    private static int getNaturalWidth(int i10, int i11, int i12) {
        return (i10 == 0 || i10 == 2) ? i11 : i12;
    }

    public static String getOS() {
        String str = Build.VERSION.RELEASE;
        if (str == null) {
            return "UNKNOWN";
        }
        return str;
    }

    private static String getProp(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
            if (TextUtils.isEmpty(str3)) {
                return str2;
            }
            return str3;
        } catch (Throwable th) {
            SALog.i("SA.SystemProperties", th.getMessage());
            return str2;
        }
    }

    private static boolean isHarmonyOs() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object invoke = cls.getMethod("getOsBrand", (Class[]) null).invoke(cls, (Object[]) null);
            if (invoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(invoke.toString());
        } catch (Throwable th) {
            SALog.i("SA.HasHarmonyOS", th.getMessage());
            return false;
        }
    }
}
