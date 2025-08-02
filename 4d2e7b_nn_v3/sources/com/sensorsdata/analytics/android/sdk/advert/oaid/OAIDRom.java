package com.sensorsdata.analytics.android.sdk.advert.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;

public final class OAIDRom {
    private static final String TAG = "SA.OAIDRom";

    private OAIDRom() {
    }

    public static boolean isASUS() {
        if (Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS")) {
            return true;
        }
        return false;
    }

    public static boolean isBlackShark() {
        if (Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
            return true;
        }
        return false;
    }

    public static boolean isCoolpad(Context context) {
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("COOLPAD") || Build.BRAND.equalsIgnoreCase("COOLPAD")) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(sysProperty("ro.build.version.emui", ""));
    }

    public static boolean isHuawei() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase("HUAWEI") || str.equalsIgnoreCase("HONOR")) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isLenovo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase("LENOVO") || str.equalsIgnoreCase("ZUK")) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isMeizu() {
        if (Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME")) {
            return true;
        }
        return false;
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(sysProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isMotolora() {
        if (Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA")) {
            return true;
        }
        return false;
    }

    public static boolean isNubia() {
        if (Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA")) {
            return true;
        }
        return false;
    }

    public static boolean isOnePlus() {
        if (Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS")) {
            return true;
        }
        return false;
    }

    public static boolean isOppo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase("OPPO") || str.equalsIgnoreCase("REALME") || !TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""))) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isSamsung() {
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
            return true;
        }
        return false;
    }

    public static boolean isVivo() {
        if (Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(sysProperty("ro.vivo.os.version", ""))) {
            return true;
        }
        return false;
    }

    public static boolean isXiaomi() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI")) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static boolean isZTE() {
        if (Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE")) {
            return true;
        }
        return false;
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Class<String> cls2 = String.class;
            str3 = (String) cls.getMethod("get", new Class[]{cls2, cls2}).invoke(cls, new Object[]{str, str2});
        } catch (Throwable th) {
            SALog.i(TAG, th);
            str3 = null;
        }
        if (str3 == null) {
            return "";
        }
        return str3;
    }
}
