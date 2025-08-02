package s1;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23754a = System.getProperty("line.separator");

    public static void a(String str, String str2) {
        if (p1.a.m()) {
            String d10 = d();
            Log.d(d10, "[" + str + "] " + str2);
        }
    }

    public static void b(String str, String str2) {
        String d10 = d();
        Log.e(d10, "[" + str + "] " + str2);
    }

    private static String c() {
        try {
            String name = Thread.currentThread().getName();
            if (TextUtils.isEmpty(name)) {
                return o1.a.a() + "SDK";
            } else if (TextUtils.equals(name, Looper.getMainLooper().getThread().getName())) {
                return o1.a.a() + "MAIN";
            } else if (name.startsWith(o1.a.a())) {
                return name;
            } else {
                return o1.a.a() + name;
            }
        } catch (Throwable unused) {
            return o1.a.a() + "SDK";
        }
    }

    private static String d() {
        return c() + "-E";
    }

    public static void e(String str, String str2) {
        String d10 = d();
        Log.i(d10, "[" + str + "] " + str2);
    }

    public static String f(Bundle bundle) {
        if (bundle == null) {
            return "null";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{ ");
            for (String next : bundle.keySet()) {
                sb2.append(next);
                sb2.append(":");
                sb2.append(bundle.get(next));
                sb2.append(" ");
            }
            sb2.append("}");
            return sb2.toString();
        } catch (Throwable unused) {
            return bundle.toString();
        }
    }

    public static String g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return "null";
        }
        try {
            String jSONObject2 = jSONObject.toString(2);
            return f23754a + jSONObject2;
        } catch (Throwable unused) {
            return jSONObject.toString();
        }
    }

    public static void h(String str, String str2) {
        if (p1.a.m()) {
            String d10 = d();
            Log.w(d10, "[" + str + "] " + str2);
        }
    }
}
