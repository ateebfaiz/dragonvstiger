package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.m;
import qb.b;

class c {
    public static void a(Throwable th, Throwable th2) {
        m.f(th, "<this>");
        m.f(th2, "exception");
        if (th != th2) {
            b.f1852a.a(th, th2);
        }
    }

    public static String b(Throwable th) {
        m.f(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        m.e(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
