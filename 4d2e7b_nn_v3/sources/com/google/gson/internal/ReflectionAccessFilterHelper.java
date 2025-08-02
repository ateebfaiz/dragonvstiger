package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionAccessFilterHelper {

    private static abstract class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f9383a;

        class a extends b {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Method f9384b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f9384b = method;
            }

            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f9384b.invoke(accessibleObject, new Object[]{obj})).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$b$b  reason: collision with other inner class name */
        class C0109b extends b {
            C0109b() {
                super();
            }

            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x001f  */
        static {
            /*
                boolean r0 = com.google.gson.internal.JavaVersion.isJava9OrLater()
                if (r0 == 0) goto L_0x001c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 0
                r2[r4] = r3     // Catch:{ NoSuchMethodException -> 0x001c }
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x001c }
                com.google.gson.internal.ReflectionAccessFilterHelper$b$a r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$b$a     // Catch:{ NoSuchMethodException -> 0x001c }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x001c }
                goto L_0x001d
            L_0x001c:
                r1 = 0
            L_0x001d:
                if (r1 != 0) goto L_0x0024
                com.google.gson.internal.ReflectionAccessFilterHelper$b$b r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$b$b
                r1.<init>()
            L_0x0024:
                f9383a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ReflectionAccessFilterHelper.b.<clinit>():void");
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    private ReflectionAccessFilterHelper() {
    }

    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return b.f9383a.a(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> list, Class<?> cls) {
        for (ReflectionAccessFilter check : list) {
            ReflectionAccessFilter.FilterResult check2 = check.check(cls);
            if (check2 != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return check2;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean isAndroidType(Class<?> cls) {
        return isAndroidType(cls.getName());
    }

    public static boolean isAnyPlatformType(Class<?> cls) {
        String name = cls.getName();
        if (isAndroidType(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.")) {
            return true;
        }
        return false;
    }

    public static boolean isJavaType(Class<?> cls) {
        return isJavaType(cls.getName());
    }

    private static boolean isAndroidType(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || isJavaType(str);
    }

    private static boolean isJavaType(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }
}
