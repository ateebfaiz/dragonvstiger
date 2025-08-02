package j9;

import i9.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a {

    private static class b implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final com.linecorp.linesdk.api.a f12439a;

        /* renamed from: b  reason: collision with root package name */
        private final Map f12440b;

        private boolean a(Method method) {
            Boolean bool = (Boolean) this.f12440b.get(method);
            if (bool != null) {
                return bool.booleanValue();
            }
            String name = method.getName();
            Class[] parameterTypes = method.getParameterTypes();
            Class cls = this.f12439a.getClass();
            while (cls != null) {
                try {
                    if (((c) cls.getDeclaredMethod(name, parameterTypes).getAnnotation(c.class)) != null) {
                        this.f12440b.put(method, Boolean.TRUE);
                        return true;
                    }
                    cls = cls.getSuperclass();
                } catch (NoSuchMethodException unused) {
                }
            }
            this.f12440b.put(method, Boolean.FALSE);
            return false;
        }

        private static boolean b(Object obj) {
            if ((obj instanceof c) && ((c) obj).c().a() == 401) {
                return true;
            }
            return false;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                Object invoke = method.invoke(this.f12439a, objArr);
                if (!a(method) || !b(invoke)) {
                    return invoke;
                }
                c a10 = this.f12439a.a();
                if (a10.g()) {
                    try {
                        return method.invoke(this.f12439a, objArr);
                    } catch (InvocationTargetException e10) {
                        throw e10.getTargetException();
                    }
                } else if (a10.f()) {
                    return a10;
                } else {
                    return invoke;
                }
            } catch (InvocationTargetException e11) {
                throw e11.getTargetException();
            }
        }

        private b(com.linecorp.linesdk.api.a aVar) {
            this.f12439a = aVar;
            this.f12440b = new ConcurrentHashMap(0);
        }
    }

    public static com.linecorp.linesdk.api.a a(com.linecorp.linesdk.api.a aVar) {
        return (com.linecorp.linesdk.api.a) Proxy.newProxyInstance(aVar.getClass().getClassLoader(), new Class[]{com.linecorp.linesdk.api.a.class}, new b(aVar));
    }
}
