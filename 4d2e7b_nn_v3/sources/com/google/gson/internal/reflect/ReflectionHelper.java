package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionHelper {
    private static final b RECORD_HELPER;

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
        private final Method f9453a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f9454b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f9455c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f9456d;

        public Method a(Class cls, Field field) {
            try {
                return cls.getMethod(field.getName(), (Class[]) null);
            } catch (ReflectiveOperationException e10) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e10);
            }
        }

        public Constructor b(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f9454b.invoke(cls, (Object[]) null);
                Class[] clsArr = new Class[objArr.length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    clsArr[i10] = (Class) this.f9456d.invoke(objArr[i10], (Object[]) null);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e10) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e10);
            }
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class cls) {
            try {
                Object[] objArr = (Object[]) this.f9454b.invoke(cls, (Object[]) null);
                String[] strArr = new String[objArr.length];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    strArr[i10] = (String) this.f9455c.invoke(objArr[i10], (Object[]) null);
                }
                return strArr;
            } catch (ReflectiveOperationException e10) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e10);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class cls) {
            try {
                return ((Boolean) this.f9453a.invoke(cls, (Object[]) null)).booleanValue();
            } catch (ReflectiveOperationException e10) {
                throw ReflectionHelper.createExceptionForRecordReflectionException(e10);
            }
        }

        private d() {
            super();
            Class<Class> cls = Class.class;
            this.f9453a = cls.getMethod("isRecord", (Class[]) null);
            Method method = cls.getMethod("getRecordComponents", (Class[]) null);
            this.f9454b = method;
            Class<?> componentType = method.getReturnType().getComponentType();
            this.f9455c = componentType.getMethod("getName", (Class[]) null);
            this.f9456d = componentType.getMethod("getType", (Class[]) null);
        }
    }

    static {
        b bVar;
        try {
            bVar = new d();
        } catch (NoSuchMethodException unused) {
            bVar = new c();
        }
        RECORD_HELPER = bVar;
    }

    private ReflectionHelper() {
    }

    private static void appendExecutableParameters(AccessibleObject accessibleObject, StringBuilder sb2) {
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

    public static String constructorToString(Constructor<?> constructor) {
        StringBuilder sb2 = new StringBuilder(constructor.getDeclaringClass().getName());
        appendExecutableParameters(constructor, sb2);
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String fieldToString(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String getAccessibleObjectDescription(AccessibleObject accessibleObject, boolean z10) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + fieldToString((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb2 = new StringBuilder(method.getName());
            appendExecutableParameters(method, sb2);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb2.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + constructorToString((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z10 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method getAccessor(Class<?> cls, Field field) {
        return RECORD_HELPER.a(cls, field);
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> cls) {
        return RECORD_HELPER.b(cls);
    }

    public static String[] getRecordComponentNames(Class<?> cls) {
        return RECORD_HELPER.c(cls);
    }

    public static boolean isRecord(Class<?> cls) {
        return RECORD_HELPER.d(cls);
    }

    public static void makeAccessible(AccessibleObject accessibleObject) throws JsonIOException {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e10) {
            String accessibleObjectDescription = getAccessibleObjectDescription(accessibleObject, false);
            throw new JsonIOException("Failed making " + accessibleObjectDescription + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e10);
        }
    }

    public static String tryMakeAccessible(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e10) {
            return "Failed making constructor '" + constructorToString(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e10.getMessage();
        }
    }
}
