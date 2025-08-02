package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.f;
import com.fasterxml.jackson.databind.j;
import com.fasterxml.jackson.databind.w;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import k8.h;
import okhttp3.HttpUrl;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final Class f5671a = Object.class;

    /* renamed from: b  reason: collision with root package name */
    private static final Annotation[] f5672b = new Annotation[0];

    /* renamed from: c  reason: collision with root package name */
    private static final a[] f5673c = new a[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Iterator f5674d = Collections.emptyIterator();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Constructor f5675a;

        /* renamed from: b  reason: collision with root package name */
        private transient Annotation[] f5676b;

        /* renamed from: c  reason: collision with root package name */
        private transient Annotation[][] f5677c;

        /* renamed from: d  reason: collision with root package name */
        private int f5678d = -1;

        public a(Constructor constructor) {
            this.f5675a = constructor;
        }

        public Constructor a() {
            return this.f5675a;
        }

        public Annotation[] b() {
            Annotation[] annotationArr = this.f5676b;
            if (annotationArr != null) {
                return annotationArr;
            }
            Annotation[] declaredAnnotations = this.f5675a.getDeclaredAnnotations();
            this.f5676b = declaredAnnotations;
            return declaredAnnotations;
        }

        public Class c() {
            return this.f5675a.getDeclaringClass();
        }

        public int d() {
            int i10 = this.f5678d;
            if (i10 >= 0) {
                return i10;
            }
            int length = this.f5675a.getParameterTypes().length;
            this.f5678d = length;
            return length;
        }

        public Annotation[][] e() {
            Annotation[][] annotationArr = this.f5677c;
            if (annotationArr != null) {
                return annotationArr;
            }
            Annotation[][] parameterAnnotations = this.f5675a.getParameterAnnotations();
            this.f5677c = parameterAnnotations;
            return parameterAnnotations;
        }
    }

    private static class b {

        /* renamed from: e  reason: collision with root package name */
        static final b f5679e = new b();

        /* renamed from: a  reason: collision with root package name */
        private final Field f5680a;

        /* renamed from: b  reason: collision with root package name */
        private final Field f5681b;

        /* renamed from: c  reason: collision with root package name */
        private final String f5682c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5683d;

        private b() {
            String str;
            Field field;
            String str2;
            Class<Class> cls = Class.class;
            Field field2 = null;
            try {
                field = d(EnumSet.class, "elementType", cls);
                str = null;
            } catch (Exception e10) {
                str = e10.toString();
                field = null;
            }
            this.f5680a = field;
            this.f5682c = str;
            try {
                field2 = d(EnumMap.class, "keyType", cls);
                str2 = null;
            } catch (Exception e11) {
                str2 = e11.toString();
            }
            this.f5681b = field2;
            this.f5683d = str2;
        }

        private Object c(Object obj, Field field) {
            try {
                return field.get(obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException(e10);
            }
        }

        private static Field d(Class cls, String str, Class cls2) {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i10 = 0;
            while (i10 < length) {
                Field field = declaredFields[i10];
                if (!str.equals(field.getName()) || field.getType() != cls2) {
                    i10++;
                } else {
                    field.setAccessible(true);
                    return field;
                }
            }
            throw new IllegalStateException(String.format("No field named '%s' in class '%s'", new Object[]{str, cls.getName()}));
        }

        public Class a(EnumMap enumMap) {
            Field field = this.f5681b;
            if (field != null) {
                return (Class) c(enumMap, field);
            }
            throw new IllegalStateException("Cannot figure out type parameter for `EnumMap` (odd JDK platform?), problem: " + this.f5683d);
        }

        public Class b(EnumSet enumSet) {
            Field field = this.f5680a;
            if (field != null) {
                return (Class) c(enumSet, field);
            }
            throw new IllegalStateException("Cannot figure out type parameter for `EnumSet` (odd JDK platform?), problem: " + this.f5682c);
        }
    }

    public static Class A(Class cls) {
        if (!Modifier.isStatic(cls.getModifiers())) {
            try {
                if (E(cls)) {
                    return null;
                }
                return x(cls);
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public static Throwable B(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public static String C(j jVar) {
        if (jVar == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(80);
        sb2.append('`');
        sb2.append(jVar.e());
        sb2.append('`');
        return sb2.toString();
    }

    public static boolean D(Object obj, Class cls) {
        if (obj == null || obj.getClass() != cls) {
            return false;
        }
        return true;
    }

    public static boolean E(Class cls) {
        if (L(cls) || cls.getEnclosingMethod() == null) {
            return false;
        }
        return true;
    }

    public static boolean F(Class cls) {
        if (cls == Void.class || cls == Void.TYPE || cls == h.class) {
            return true;
        }
        return false;
    }

    public static boolean G(Class cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    public static boolean H(Class cls) {
        String name = cls.getName();
        if (name.startsWith("java.") || name.startsWith("javax.")) {
            return true;
        }
        return false;
    }

    public static boolean I(Class cls) {
        if (cls.getAnnotation(k8.a.class) != null) {
            return true;
        }
        return false;
    }

    public static boolean J(Object obj) {
        if (obj == null || I(obj.getClass())) {
            return true;
        }
        return false;
    }

    public static boolean K(Class cls) {
        if (Modifier.isStatic(cls.getModifiers()) || x(cls) == null) {
            return false;
        }
        return true;
    }

    public static boolean L(Class cls) {
        if (cls == f5671a || cls.isPrimitive()) {
            return true;
        }
        return false;
    }

    public static boolean M(Class cls) {
        String name = cls.getName();
        if (name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.")) {
            return true;
        }
        return false;
    }

    public static boolean N(Class cls) {
        Class superclass = cls.getSuperclass();
        if (superclass == null || !"com.android.tools.r8.RecordTag".equals(superclass.getName())) {
            return false;
        }
        return true;
    }

    public static String O(w wVar) {
        if (wVar == null) {
            return "[null]";
        }
        return d(wVar.c());
    }

    public static String P(String str) {
        if (str == null) {
            return "[null]";
        }
        return d(str);
    }

    public static String Q(Class<?> cls) {
        String str;
        if (cls == null) {
            return "[null]";
        }
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            str = cls.getSimpleName();
        } else {
            str = cls.getName();
        }
        if (i10 > 0) {
            StringBuilder sb2 = new StringBuilder(str);
            do {
                sb2.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                i10--;
            } while (i10 > 0);
            str = sb2.toString();
        }
        return e(str);
    }

    public static String R(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static Class S(Class cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    public static void T(Throwable th, String str) {
        W(th);
        U(th);
        throw new IllegalArgumentException(str, th);
    }

    public static Throwable U(Throwable th) {
        if (!(th instanceof Error)) {
            return th;
        }
        throw ((Error) th);
    }

    public static Throwable V(Throwable th) {
        if (!(th instanceof IOException)) {
            return th;
        }
        throw ((IOException) th);
    }

    public static Throwable W(Throwable th) {
        if (!(th instanceof RuntimeException)) {
            return th;
        }
        throw ((RuntimeException) th);
    }

    public static void X(Throwable th, String str) {
        T(B(th), str);
    }

    public static void Y(Class cls, Object obj, String str) {
        if (obj.getClass() != cls) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", new Object[]{obj.getClass().getName(), cls.getName(), str}));
        }
    }

    public static Class Z(Class cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    private static void a(Class cls, Class cls2, Collection collection, boolean z10) {
        if (cls != cls2 && cls != null && cls != Object.class) {
            if (z10) {
                if (!collection.contains(cls)) {
                    collection.add(cls);
                } else {
                    return;
                }
            }
            for (Class a10 : c(cls)) {
                a(a10, cls2, collection, true);
            }
            a(cls.getSuperclass(), cls2, collection, true);
        }
    }

    private static Method[] b(Class cls, Throwable th) {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", new Object[]{cls.getName(), th.getClass().getName(), th.getMessage()}), th);
    }

    private static Class[] c(Class cls) {
        return cls.getInterfaces();
    }

    public static String d(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        sb2.append('\'');
        sb2.append(str);
        sb2.append('\'');
        return sb2.toString();
    }

    public static String e(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 2);
        sb2.append('`');
        sb2.append(str);
        sb2.append('`');
        return sb2.toString();
    }

    public static String f(Class cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static void g(Member member, boolean z10) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            Class<?> declaringClass = member.getDeclaringClass();
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(declaringClass.getModifiers())) {
                if (!z10 || H(declaringClass)) {
                    return;
                }
            }
            accessibleObject.setAccessible(true);
        } catch (SecurityException e10) {
            if (!accessibleObject.isAccessible()) {
                Class<?> declaringClass2 = member.getDeclaringClass();
                throw new IllegalArgumentException("Cannot access " + member + " (from class " + declaringClass2.getName() + "; failed to set access: " + e10.getMessage());
            }
        } catch (RuntimeException e11) {
            if ("InaccessibleObjectException".equals(e11.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format("Failed to call `setAccess()` on %s '%s' (of class %s) due to `%s`, problem: %s", new Object[]{member.getClass().getSimpleName(), member.getName(), Q(member.getDeclaringClass()), e11.getClass().getName(), e11.getMessage()}), e11);
            }
            throw e11;
        }
    }

    public static String h(Object obj) {
        Class<?> cls;
        if (obj == null) {
            return "[null]";
        }
        if (obj instanceof Class) {
            cls = (Class) obj;
        } else {
            cls = obj.getClass();
        }
        return Q(cls);
    }

    public static void i(com.fasterxml.jackson.core.f fVar, Closeable closeable, Exception exc) {
        if (fVar != null) {
            fVar.p(f.b.AUTO_CLOSE_JSON_CONTENT);
            try {
                fVar.close();
            } catch (Exception e10) {
                exc.addSuppressed(e10);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e11) {
                exc.addSuppressed(e11);
            }
        }
        V(exc);
        W(exc);
        throw new RuntimeException(exc);
    }

    public static void j(com.fasterxml.jackson.core.f fVar, Exception exc) {
        fVar.p(f.b.AUTO_CLOSE_JSON_CONTENT);
        try {
            fVar.close();
        } catch (Exception e10) {
            exc.addSuppressed(e10);
        }
        V(exc);
        W(exc);
        throw new RuntimeException(exc);
    }

    public static Object k(Class cls, boolean z10) {
        Constructor o10 = o(cls, z10);
        if (o10 != null) {
            try {
                return o10.newInstance((Object[]) null);
            } catch (Exception e10) {
                X(e10, "Failed to instantiate class " + cls.getName() + ", problem: " + e10.getMessage());
                return null;
            }
        } else {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
    }

    public static Object l(Class cls) {
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Character.TYPE) {
            return 0;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static String m(Throwable th) {
        if (th instanceof c) {
            return ((c) th).b();
        }
        if (!(th instanceof InvocationTargetException) || th.getCause() == null) {
            return th.getMessage();
        }
        return th.getCause().getMessage();
    }

    public static Annotation[] n(Class cls) {
        if (L(cls)) {
            return f5672b;
        }
        return cls.getDeclaredAnnotations();
    }

    public static Constructor o(Class cls, boolean z10) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
            if (z10) {
                g(declaredConstructor, z10);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e10) {
            X(e10, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e10.getMessage());
            return null;
        }
    }

    public static Class p(Class cls) {
        if (cls.getSuperclass() != Enum.class) {
            return cls.getSuperclass();
        }
        return cls;
    }

    public static Class q(Enum enumR) {
        return enumR.getDeclaringClass();
    }

    public static Class r(EnumMap enumMap) {
        if (!enumMap.isEmpty()) {
            return q((Enum) enumMap.keySet().iterator().next());
        }
        return b.f5679e.a(enumMap);
    }

    public static Class s(EnumSet enumSet) {
        if (!enumSet.isEmpty()) {
            return q((Enum) enumSet.iterator().next());
        }
        return b.f5679e.b(enumSet);
    }

    public static List t(Class cls, Class cls2, boolean z10) {
        if (cls == null || cls == cls2 || cls == Object.class) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(8);
        a(cls, cls2, arrayList, z10);
        return arrayList;
    }

    public static List u(Class cls, Class cls2, boolean z10) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z10) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    public static Method[] v(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                return b(cls, e10);
            }
            try {
                return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
            } catch (ClassNotFoundException e11) {
                e10.addSuppressed(e11);
                return b(cls, e10);
            }
        } catch (Throwable th) {
            return b(cls, th);
        }
    }

    public static a[] w(Class cls) {
        if (cls.isInterface() || L(cls)) {
            return f5673c;
        }
        Constructor[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            aVarArr[i10] = new a(declaredConstructors[i10]);
        }
        return aVarArr;
    }

    public static Class x(Class cls) {
        if (L(cls)) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    public static Type[] y(Class cls) {
        return cls.getGenericInterfaces();
    }

    public static Type z(Class cls) {
        return cls.getGenericSuperclass();
    }
}
