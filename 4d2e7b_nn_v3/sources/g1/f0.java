package g1;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f21589a;

    public static String a(Context context) {
        return z(context).getString("last_lifecycle_session", "");
    }

    public static String b(Context context, int i10) {
        SharedPreferences z10 = z(context);
        return z10.getString("notification_layout_" + i10, "");
    }

    public static Set c(Context context, byte b10) {
        SharedPreferences z10 = z(context);
        return z10.getStringSet("message_id_set_" + b10, new LinkedHashSet());
    }

    public static void d(Context context, byte b10, String str) {
        SharedPreferences.Editor edit = z(context).edit();
        edit.putString("platform_token_" + b10, str).commit();
    }

    public static void e(Context context, byte b10, Set set) {
        SharedPreferences.Editor edit = z(context).edit();
        edit.putStringSet("message_id_set_" + b10, set).commit();
    }

    public static void f(Context context, int i10, String str) {
        SharedPreferences.Editor edit = z(context).edit();
        edit.putString("notification_layout_" + i10, str).commit();
    }

    public static void g(Context context, long j10) {
        z(context).edit().putLong("last_to_background_time", j10).commit();
    }

    public static void h(Context context, String str) {
        z(context).edit().putString("last_lifecycle_session", str).commit();
    }

    public static void i(Context context, Set set) {
        z(context).edit().putStringSet("override_message_id_set", set).commit();
    }

    public static String j(Context context) {
        return z(context).getString("last_lifecycle_session_json", "");
    }

    public static String k(Context context, byte b10) {
        SharedPreferences z10 = z(context);
        return z10.getString("platform_token_" + b10, "");
    }

    public static void l(Context context, int i10) {
        z(context).edit().putInt("notification_badge", i10).commit();
    }

    public static void m(Context context, long j10) {
        z(context).edit().putLong("last_to_foreground_time", j10).commit();
    }

    public static void n(Context context, String str) {
        z(context).edit().putString("last_lifecycle_session_json", str).commit();
    }

    public static void o(Context context, Set set) {
        z(context).edit().putStringSet("revoke_message_id_set", set).commit();
    }

    public static long p(Context context) {
        return z(context).getLong("last_to_background_time", 0);
    }

    public static void q(Context context, int i10) {
        z(context).edit().putInt("notification_count", i10).commit();
    }

    public static void r(Context context, String str) {
        z(context).edit().putString("notification_show_time", str).commit();
    }

    public static int s(Context context) {
        return z(context).getInt("notification_badge", 0);
    }

    public static void t(Context context, String str) {
        z(context).edit().putString("notification_silence_time", str).commit();
    }

    public static int u(Context context) {
        return z(context).getInt("notification_count", 5);
    }

    public static String v(Context context) {
        return z(context).getString("notification_show_time", "");
    }

    public static String w(Context context) {
        return z(context).getString("notification_silence_time", "");
    }

    public static Set x(Context context) {
        return z(context).getStringSet("override_message_id_set", new LinkedHashSet());
    }

    public static Set y(Context context) {
        return z(context).getStringSet("revoke_message_id_set", new LinkedHashSet());
    }

    public static SharedPreferences z(Context context) {
        if (f21589a == null) {
            f21589a = context.getApplicationContext().getSharedPreferences("com.engagelab.privates.push.prefs", 0);
        }
        return f21589a;
    }
}
