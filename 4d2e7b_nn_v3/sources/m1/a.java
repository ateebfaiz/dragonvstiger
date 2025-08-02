package m1;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f22484a;

    public static String a(Context context) {
        return b(context).getString("device_id", "");
    }

    private static SharedPreferences b(Context context) {
        if (f22484a == null) {
            f22484a = context.getSharedPreferences("com.engagelab.privates.common.prefs", 0);
        }
        return f22484a;
    }

    public static void c(Context context, String str) {
        b(context).edit().putString("app_channel", str).commit();
    }

    public static void d(Context context, String str) {
        b(context).edit().putString("app_key", str).commit();
    }

    public static void e(Context context, String str) {
        b(context).edit().putString("device_id", str).commit();
    }

    public static void f(Context context, int i10) {
        b(context).edit().putInt("sdk_version_code", i10).commit();
    }

    public static void g(Context context, String str) {
        b(context).edit().putString("sdk_version_name", str).commit();
    }
}
