package e9;

import android.text.TextUtils;

public abstract class o {
    public static String a() {
        if (f()) {
            return e("ro.build.version.emui", "");
        }
        return "";
    }

    private static String b() {
        return e("ro.build.display.id", "");
    }

    public static String c() {
        if (j()) {
            return e("ro.build.display.id", "");
        }
        return "";
    }

    public static String d() {
        if (l()) {
            return e("ro.miui.ui.version.name", "");
        }
        return "";
    }

    private static String e(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Class<String> cls2 = String.class;
            return (String) cls.getMethod("get", new Class[]{cls2, cls2}).invoke(cls, new Object[]{str, str2});
        } catch (Exception e10) {
            e10.printStackTrace();
            return str2;
        }
    }

    public static boolean f() {
        return !TextUtils.isEmpty(e("ro.build.version.emui", ""));
    }

    public static boolean g() {
        if (a().contains("EmotionUI_3.0")) {
            return true;
        }
        return false;
    }

    public static boolean h() {
        String a10 = a();
        if ("EmotionUI 3".equals(a10) || a10.contains("EmotionUI_3.1")) {
            return true;
        }
        return false;
    }

    public static boolean i() {
        if (g() || h()) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        return b().toLowerCase().contains("flyme");
    }

    public static boolean k() {
        int i10;
        String c10 = c();
        if (c10.isEmpty()) {
            return false;
        }
        try {
            if (c10.toLowerCase().contains("os")) {
                i10 = Integer.valueOf(c10.substring(9, 10)).intValue();
            } else {
                i10 = Integer.valueOf(c10.substring(6, 7)).intValue();
            }
            if (i10 >= 4) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean l() {
        return !TextUtils.isEmpty(e("ro.miui.ui.version.name", ""));
    }

    public static boolean m() {
        String d10 = d();
        if (d10.isEmpty()) {
            return false;
        }
        try {
            if (Integer.valueOf(d10.substring(1)).intValue() >= 6) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
