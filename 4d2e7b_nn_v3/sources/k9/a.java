package k9;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import h9.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f12512a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12513b;

    /* renamed from: c  reason: collision with root package name */
    private final b f12514c;

    public a(Context context, String str) {
        this(context.getApplicationContext(), str, c.b());
    }

    private long b(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.valueOf(this.f12514c.a(this.f12512a, str)).longValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private String c(String str) {
        if (str == null) {
            return null;
        }
        return this.f12514c.a(this.f12512a, str);
    }

    private String d(long j10) {
        return this.f12514c.b(this.f12512a, String.valueOf(j10));
    }

    private String e(String str) {
        return this.f12514c.b(this.f12512a, str);
    }

    public void a() {
        this.f12512a.getSharedPreferences(this.f12513b, 0).edit().clear().apply();
    }

    public e f() {
        SharedPreferences sharedPreferences = this.f12512a.getSharedPreferences(this.f12513b, 0);
        try {
            String c10 = c(sharedPreferences.getString("accessToken", (String) null));
            long b10 = b(sharedPreferences.getString("expiresIn", (String) null));
            long b11 = b(sharedPreferences.getString("issuedClientTime", (String) null));
            if (TextUtils.isEmpty(c10) || b10 == -1 || b11 == -1) {
                return null;
            }
            return new e(c10, b10, b11, (String) n9.b.a(c(sharedPreferences.getString("refreshToken", (String) null)), ""));
        } catch (h9.a unused) {
            a();
            return null;
        }
    }

    public void g(e eVar) {
        this.f12512a.getSharedPreferences(this.f12513b, 0).edit().putString("accessToken", e(eVar.a())).putString("expiresIn", d(eVar.b())).putString("issuedClientTime", d(eVar.c())).putString("refreshToken", e(eVar.d())).apply();
    }

    public a(Context context, String str, b bVar) {
        this.f12512a = context;
        this.f12513b = "com.linecorp.linesdk.accesstoken." + str;
        this.f12514c = bVar;
    }
}
