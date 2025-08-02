package kotlin.jvm.internal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import vb.n;
import vb.o;
import wb.a;
import wb.b;
import wb.c;
import wb.d;
import wb.e;

public abstract class c0 {
    public static Collection a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            o(obj, "kotlin.collections.MutableCollection");
        }
        return f(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof a) && !(obj instanceof c)) {
            o(obj, "kotlin.collections.MutableIterable");
        }
        return g(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof a) && !(obj instanceof d)) {
            o(obj, "kotlin.collections.MutableList");
        }
        return h(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof a) && !(obj instanceof e)) {
            o(obj, "kotlin.collections.MutableMap");
        }
        return i(obj);
    }

    public static Object e(Object obj, int i10) {
        if (obj != null && !k(obj, i10)) {
            o(obj, "kotlin.jvm.functions.Function" + i10);
        }
        return obj;
    }

    public static Collection f(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e10) {
            throw n(e10);
        }
    }

    public static Iterable g(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e10) {
            throw n(e10);
        }
    }

    public static List h(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e10) {
            throw n(e10);
        }
    }

    public static Map i(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e10) {
            throw n(e10);
        }
    }

    public static int j(Object obj) {
        if (obj instanceof h) {
            return ((h) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof n) {
            return 3;
        }
        if (obj instanceof o) {
            return 4;
        }
        return -1;
    }

    public static boolean k(Object obj, int i10) {
        if (!(obj instanceof kotlin.d) || j(obj) != i10) {
            return false;
        }
        return true;
    }

    public static boolean l(Object obj) {
        if (!(obj instanceof Map) || ((obj instanceof a) && !(obj instanceof e))) {
            return false;
        }
        return true;
    }

    private static Throwable m(Throwable th) {
        return m.m(th, c0.class.getName());
    }

    public static ClassCastException n(ClassCastException classCastException) {
        throw ((ClassCastException) m(classCastException));
    }

    public static void o(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        p(str2 + " cannot be cast to " + str);
    }

    public static void p(String str) {
        throw n(new ClassCastException(str));
    }
}
