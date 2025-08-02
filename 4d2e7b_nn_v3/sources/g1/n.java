package g1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f21604a;

    public static long A(Context context) {
        return B(context).getLong("server_time", 0);
    }

    public static SharedPreferences B(Context context) {
        if (f21604a == null) {
            f21604a = context.getSharedPreferences("com.engagelab.privates.core.prefs", 0);
        }
        return f21604a;
    }

    public static Set C(Context context) {
        return B(context).getStringSet("tcp_address", new LinkedHashSet());
    }

    public static Set D(Context context) {
        return B(context).getStringSet("tcp_address_ssl", new LinkedHashSet());
    }

    public static int E(Context context) {
        return B(context).getInt("tcp_address_ssl_c_v", -1);
    }

    public static Set F(Context context) {
        return B(context).getStringSet("udp_address", new LinkedHashSet());
    }

    public static long G(Context context) {
        return B(context).getLong("user_id", 0);
    }

    public static String a(Context context) {
        return B(context).getString("connect_ssl_crt", "");
    }

    public static void b(Context context, byte b10) {
        B(context).edit().putInt("platform_state", b10).commit();
    }

    public static void c(Context context, int i10) {
        B(context).edit().putInt("connect_ssl_c_v", i10).commit();
    }

    public static void d(Context context, long j10) {
        B(context).edit().putLong("server_time", j10).commit();
    }

    public static void e(Context context, String str) {
        B(context).edit().putString("connect_ssl_crt", str).commit();
    }

    public static void f(Context context, Set set) {
        B(context).edit().putStringSet("http_address", set).commit();
    }

    public static void g(Context context, boolean z10) {
        B(context).edit().putBoolean("connect_state", z10).commit();
    }

    public static int h(Context context) {
        return B(context).getInt("connect_ssl_c_v", -1);
    }

    public static void i(Context context, int i10) {
        B(context).edit().putInt("login_code", i10).commit();
    }

    public static void j(Context context, long j10) {
        B(context).edit().putLong("user_id", j10).commit();
    }

    public static void k(Context context, String str) {
        B(context).edit().putString(HintConstants.AUTOFILL_HINT_PASSWORD, str).commit();
    }

    public static void l(Context context, Set set) {
        B(context).edit().putStringSet("tcp_address", set).commit();
    }

    public static void m(Context context, int i10) {
        B(context).edit().putInt("register_code", i10).commit();
    }

    public static void n(Context context, String str) {
        B(context).edit().putString("registration_id", str).commit();
    }

    public static void o(Context context, Set set) {
        B(context).edit().putStringSet("tcp_address_ssl", set).commit();
    }

    public static boolean p(Context context) {
        return B(context).getBoolean("connect_state", true);
    }

    public static Set q(Context context) {
        return B(context).getStringSet("http_address", new LinkedHashSet());
    }

    public static void r(Context context, int i10) {
        B(context).edit().putInt("seed_id", i10).commit();
    }

    public static void s(Context context, Set set) {
        B(context).edit().putStringSet("udp_address", set).commit();
    }

    public static int t(Context context) {
        return B(context).getInt("login_code", -1);
    }

    public static void u(Context context, int i10) {
        B(context).edit().putInt("tcp_address_ssl_c_v", i10).commit();
    }

    public static String v(Context context) {
        return B(context).getString(HintConstants.AUTOFILL_HINT_PASSWORD, "");
    }

    public static byte w(Context context) {
        return (byte) B(context).getInt("platform_state", 0);
    }

    public static int x(Context context) {
        return B(context).getInt("register_code", -1);
    }

    public static String y(Context context) {
        return B(context).getString("registration_id", "");
    }

    public static int z(Context context) {
        return f21604a.getInt("seed_id", 0);
    }
}
