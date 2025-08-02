package z2;

import android.util.Log;

public class b implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final b f25008c = new b();

    /* renamed from: a  reason: collision with root package name */
    private String f25009a = "unknown";

    /* renamed from: b  reason: collision with root package name */
    private int f25010b = 5;

    private b() {
    }

    public static b l() {
        return f25008c;
    }

    private static String m(String str, Throwable th) {
        return str + 10 + n(th);
    }

    private static String n(Throwable th) {
        if (th == null) {
            return "";
        }
        return Log.getStackTraceString(th);
    }

    private String o(String str) {
        if (this.f25009a == null) {
            return str;
        }
        return this.f25009a + ":" + str;
    }

    private void p(int i10, String str, String str2) {
        Log.println(i10, o(str), str2);
    }

    private void q(int i10, String str, String str2, Throwable th) {
        Log.println(i10, o(str), m(str2, th));
    }

    public void a(String str, String str2, Throwable th) {
        q(6, str, str2, th);
    }

    public void b(String str, String str2) {
        p(5, str, str2);
    }

    public void c(String str, String str2, Throwable th) {
        q(5, str, str2, th);
    }

    public void d(String str, String str2) {
        p(6, str, str2);
    }

    public void e(String str, String str2) {
        p(2, str, str2);
    }

    public void f(String str, String str2) {
        p(6, str, str2);
    }

    public void g(String str, String str2, Throwable th) {
        q(6, str, str2, th);
    }

    public void h(String str, String str2) {
        p(3, str, str2);
    }

    public void i(String str, String str2, Throwable th) {
        q(3, str, str2, th);
    }

    public boolean j(int i10) {
        if (this.f25010b <= i10) {
            return true;
        }
        return false;
    }

    public void k(String str, String str2) {
        p(4, str, str2);
    }
}
