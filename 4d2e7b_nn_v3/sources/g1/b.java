package g1;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f21573a;

    public static String a(Context context) {
        return e(context).getString("platform_token_fail", "");
    }

    public static void b(Context context, int i10) {
        e(context).edit().putInt("platform_token_fail_from", i10).commit();
    }

    public static void c(Context context, String str) {
        e(context).edit().putString("platform_token_fail", str).commit();
    }

    public static int d(Context context) {
        return e(context).getInt("platform_token_fail_from", 0);
    }

    public static SharedPreferences e(Context context) {
        if (f21573a == null) {
            f21573a = context.getApplicationContext().getSharedPreferences("com.engagelab.privates.push.prefs.platform", 0);
        }
        return f21573a;
    }
}
