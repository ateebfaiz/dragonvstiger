package j2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.m;
import v5.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f22204a = new h();

    private h() {
    }

    public static final Class a(String str) {
        Class<h> cls = h.class;
        if (a.d(cls)) {
            return null;
        }
        try {
            m.f(str, "className");
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        } catch (Throwable th) {
            a.b(th, cls);
            return null;
        }
    }

    public static final Method b(Class cls, String str, Class... clsArr) {
        Class<h> cls2 = h.class;
        if (a.d(cls2)) {
            return null;
        }
        try {
            m.f(cls, "clazz");
            m.f(str, "methodName");
            m.f(clsArr, "args");
            try {
                return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (NoSuchMethodException unused) {
                return null;
            }
        } catch (Throwable th) {
            a.b(th, cls2);
            return null;
        }
    }

    public static final Object c(Class cls, Method method, Object obj, Object... objArr) {
        Class<h> cls2 = h.class;
        if (a.d(cls2)) {
            return null;
        }
        try {
            m.f(cls, "clazz");
            m.f(method, FirebaseAnalytics.Param.METHOD);
            m.f(objArr, "args");
            if (obj != null) {
                obj = cls.cast(obj);
            }
            try {
                return method.invoke(obj, Arrays.copyOf(objArr, objArr.length));
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return null;
            }
        } catch (Throwable th) {
            a.b(th, cls2);
            return null;
        }
    }
}
