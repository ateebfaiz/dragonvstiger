package i;

import android.content.Context;
import android.content.SharedPreferences;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f22002a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f22003b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedPreferences.Editor f22004c;

    public g(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f22003b = sharedPreferences;
        this.f22004c = sharedPreferences.edit();
        this.f22002a = str2;
    }

    public int a(String str, int i10) {
        try {
            String i11 = i(str);
            if (i11 == null) {
                return i10;
            }
            return Integer.parseInt(i11);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public long b(String str, long j10) {
        try {
            String i10 = i(str);
            if (i10 == null) {
                return j10;
            }
            return Long.parseLong(i10);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    public String c(String str, String str2) {
        String i10 = i(str);
        if (i10 == null) {
            return str2;
        }
        return i10;
    }

    public boolean d(String str, boolean z10) {
        String i10 = i(str);
        if (i10 == null) {
            return z10;
        }
        return Boolean.parseBoolean(i10);
    }

    public boolean e(String str, int i10) {
        return g(str, String.valueOf(i10));
    }

    public boolean f(String str, long j10) {
        return g(str, String.valueOf(j10));
    }

    public boolean g(String str, String str2) {
        String f10 = w.f(str2, this.f22002a);
        if (f10 == null) {
            return false;
        }
        this.f22004c.putString(str, f10);
        return this.f22004c.commit();
    }

    public boolean h(String str, boolean z10) {
        return g(str, String.valueOf(z10));
    }

    public final String i(String str) {
        String string = this.f22003b.getString(str, (String) null);
        if (string == null) {
            return null;
        }
        return w.a(string, this.f22002a);
    }
}
