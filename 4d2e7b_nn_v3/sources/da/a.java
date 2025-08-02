package da;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import y9.h;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f11895a;

    private static abstract class b {
        private b() {
        }

        public abstract Method a(Class cls, Field field);

        /* access modifiers changed from: package-private */
        public abstract Constructor b(Class cls);

        /* access modifiers changed from: package-private */
        public abstract String[] c(Class cls);

        /* access modifiers changed from: package-private */
        public abstract boolean d(Class cls);
    }

    private static class c extends b {
        private c() {
            super();
        }

        public Method a(Class cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public Constructor b(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            return false;
        }
    }

    private static class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final Method f11896a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f11897b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f11898c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f11899d;

        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), (Class[]) null);
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f11897b.invoke(cls, (Object[]) null);
                Class[] clsArr = new Class[objArr.length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    clsArr[i10] = (Class) this.f11899d.invoke(objArr[i10], (Object[]) null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f11897b.invoke(cls, (Object[]) null);
                String[] strArr = new String[objArr.length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    strArr[i10] = (String) this.f11898c.invoke(objArr[i10], (Object[]) null);
                }
                return strArr;
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f11896a.invoke(cls, (Object[]) null)).booleanValue();
            } catch (ReflectiveOperationException e10) {
                throw a.d(e10);
            }
        }

        private d() {
            super();
            Class<Class> cls = Class.class;
            this.f11896a = cls.getMethod("isRecord", (Class[]) null);
            Method method = cls.getMethod("getRecordComponents", (Class[]) null);
            this.f11897b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f11898c = componentType.getMethod("getName", (Class[]) null);
            this.f11899d = componentType.getMethod("getType", (Class[]) null);
        }
    }

    static {
        b bVar;
        try {
            bVar = new d();
        } catch (NoSuchMethodException unused) {
            bVar = new c();
        }
        f11895a = bVar;
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb2) {
        Class[] clsArr;
        sb2.append('(');
        if (accessibleObject instanceof Method) {
            clsArr = ((Method) accessibleObject).getParameterTypes();
        } else {
            clsArr = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i10 = 0; i10 < clsArr.length; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(clsArr[i10].getSimpleName());
        }
        sb2.append(')');
    }

    public static String c(Constructor constructor) {
        StringBuilder sb2 = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb2);
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z10) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb2 = new StringBuilder(method.getName());
            b(method, sb2);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb2.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z10 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class cls, Field field) {
        return f11895a.a(cls, field);
    }

    public static Constructor i(Class cls) {
        return f11895a.b(cls);
    }

    public static String[] j(Class cls) {
        return f11895a.c(cls);
    }

    public static boolean k(Class cls) {
        return f11895a.d(cls);
    }

    public static void l(AccessibleObject accessibleObject) {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e10) {
            String g10 = g(accessibleObject, false);
            throw new h("Failed making " + g10 + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e10);
        }
    }

    public static String m(Constructor constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e10) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e10.getMessage();
        }
    }
}
