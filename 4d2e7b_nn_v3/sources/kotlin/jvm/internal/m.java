package kotlin.jvm.internal;

import com.alibaba.pdns.f;
import java.util.Arrays;
import kotlin.w;

public abstract class m {
    public static boolean a(Float f10, float f11) {
        if (f10 == null || f10.floatValue() != f11) {
            return false;
        }
        return true;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != null) {
            return obj.equals(obj2);
        }
        if (obj2 == null) {
            return true;
        }
        return false;
    }

    public static void c(Object obj) {
        if (obj == null) {
            o();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            p(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) l(new NullPointerException(str + " must not be null")));
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            q(str);
        }
    }

    public static int g(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    public static int h(long j10, long j11) {
        int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
        if (i10 < 0) {
            return -1;
        }
        return i10 == 0 ? 0 : 1;
    }

    private static String i(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = m.class.getName();
        int i10 = 0;
        while (!stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        while (stackTrace[i10].getClassName().equals(name)) {
            i10++;
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + f.G + methodName + ", parameter " + str;
    }

    public static void j() {
        r();
    }

    public static void k(int i10, String str) {
        r();
    }

    private static Throwable l(Throwable th) {
        return m(th, m.class.getName());
    }

    static Throwable m(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(stackTrace[i11].getClassName())) {
                i10 = i11;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i10 + 1, length));
        return th;
    }

    public static String n(String str, Object obj) {
        return str + obj;
    }

    public static void o() {
        throw ((NullPointerException) l(new NullPointerException()));
    }

    public static void p(String str) {
        throw ((NullPointerException) l(new NullPointerException(str)));
    }

    private static void q(String str) {
        throw ((NullPointerException) l(new NullPointerException(i(str))));
    }

    public static void r() {
        s("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void s(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void t(String str) {
        throw ((w) l(new w(str)));
    }

    public static void u(String str) {
        t("lateinit property " + str + " has not been initialized");
    }
}
