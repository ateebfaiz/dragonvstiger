package i;

import android.os.Build;
import java.lang.reflect.Method;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static Method f22021a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Method f22022b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Method f22023c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f22024d = false;

    static {
        Class<String> cls = String.class;
        Class<Class> cls2 = Class.class;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                f22021a = cls2.getDeclaredMethod("forName", new Class[]{cls});
                f22022b = cls2.getDeclaredMethod("getMethod", new Class[]{cls, Class[].class});
                f22023c = cls2.getDeclaredMethod("getDeclaredField", new Class[]{cls});
            } catch (NoSuchMethodException e10) {
                e10.getMessage();
            }
        }
    }

    public static Object a(Object obj, String str, Object[] objArr, Class... clsArr) {
        Class<?> cls;
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        if (clsArr != null) {
            return b(cls, str, clsArr).invoke(obj, objArr);
        }
        return b(cls, str, new Class[0]).invoke(obj, (Object[]) null);
    }

    public static Method b(Class cls, String str, Class... clsArr) {
        Method method = f22022b;
        if (method == null) {
            return cls.getMethod(str, clsArr);
        }
        return (Method) method.invoke(cls, new Object[]{str, clsArr});
    }
}
