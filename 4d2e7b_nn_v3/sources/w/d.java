package w;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.Locale;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f24415a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static String f24416b = "MAH";

    /* renamed from: c  reason: collision with root package name */
    public static a f24417c = new c();

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static a b() {
        a aVar;
        synchronized (f24415a) {
            aVar = f24417c;
        }
        return aVar;
    }

    public static void c(a aVar) {
        synchronized (f24415a) {
            if (aVar != null) {
                try {
                    f24417c = aVar;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean d(Context context) {
        return false;
    }

    public static String e() {
        return f24416b;
    }

    public static String f(String str) {
        return f24416b;
    }

    public static void g(String str, String str2, Throwable th) {
        a b10 = b();
        b10.b(str, str2 + "\n" + a(th));
    }

    public static void h(String str, String str2) {
        b().b(str, str2);
    }

    public static void i(String str, String str2, Object... objArr) {
        b().b(str, String.format(Locale.US, str2, objArr));
    }

    public static boolean j() {
        return false;
    }

    public static void k(String str, String str2) {
        b().a(str, str2);
    }

    public static void l(String str, String str2, Object... objArr) {
        b().a(str, String.format(Locale.US, str2, objArr));
    }

    public static void m(String str, String str2) {
        b().c(str, str2);
    }
}
