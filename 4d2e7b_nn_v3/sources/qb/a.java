package qb;

import java.lang.reflect.Method;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.random.b;
import kotlin.random.c;

public class a {

    /* renamed from: qb.a$a  reason: collision with other inner class name */
    private static final class C0031a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0031a f1849a = new C0031a();

        /* renamed from: b  reason: collision with root package name */
        public static final Method f1850b;

        /* renamed from: c  reason: collision with root package name */
        public static final Method f1851c;

        static {
            Method method;
            Method method2;
            Class<Throwable> cls = Throwable.class;
            Method[] methods = cls.getMethods();
            m.c(methods);
            int length = methods.length;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                method = null;
                if (i11 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i11];
                if (m.b(method2.getName(), "addSuppressed")) {
                    Class[] parameterTypes = method2.getParameterTypes();
                    m.e(parameterTypes, "getParameterTypes(...)");
                    if (m.b(j.Q(parameterTypes), cls)) {
                        break;
                    }
                }
                i11++;
            }
            f1850b = method2;
            int length2 = methods.length;
            while (true) {
                if (i10 >= length2) {
                    break;
                }
                Method method3 = methods[i10];
                if (m.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i10++;
            }
            f1851c = method;
        }

        private C0031a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        m.f(th, "cause");
        m.f(th2, "exception");
        Method method = C0031a.f1850b;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }

    public c b() {
        return new b();
    }
}
