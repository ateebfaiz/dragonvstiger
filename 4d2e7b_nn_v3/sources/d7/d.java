package d7;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import p5.a;

public class d {

    /* renamed from: d  reason: collision with root package name */
    private static final String f11879d = "d";

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f11880a;

    /* renamed from: b  reason: collision with root package name */
    private final String f11881b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f11882c;

    public d(Context context) {
        this.f11880a = PreferenceManager.getDefaultSharedPreferences(context);
        this.f11881b = context.getPackageName();
        this.f11882c = context;
    }

    public String a() {
        String string = this.f11880a.getString("debug_http_host", (String) null);
        if (!TextUtils.isEmpty(string)) {
            return (String) a.c(string);
        }
        String f10 = a7.a.f(this.f11882c);
        if (f10.equals("localhost")) {
            String str = f11879d;
            z2.a.G(str, "You seem to be running on device. Run '" + a7.a.a(this.f11882c) + "' to forward the debug server's port to the device.");
        }
        return f10;
    }

    public String b() {
        return this.f11881b;
    }

    public void c(String str) {
        this.f11880a.edit().putString("debug_http_host", str).apply();
    }
}
