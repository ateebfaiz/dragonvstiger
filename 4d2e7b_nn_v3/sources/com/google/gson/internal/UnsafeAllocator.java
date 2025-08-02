package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = create();

    class a extends UnsafeAllocator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f9389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f9390b;

        a(Method method, Object obj) {
            this.f9389a = method;
            this.f9390b = obj;
        }

        public Object newInstance(Class cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.f9389a.invoke(this.f9390b, new Object[]{cls});
        }
    }

    class b extends UnsafeAllocator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f9391a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f9392b;

        b(Method method, int i10) {
            this.f9391a = method;
            this.f9392b = i10;
        }

        public Object newInstance(Class cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.f9391a.invoke((Object) null, new Object[]{cls, Integer.valueOf(this.f9392b)});
        }
    }

    class c extends UnsafeAllocator {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f9393a;

        c(Method method) {
            this.f9393a = method;
        }

        public Object newInstance(Class cls) {
            UnsafeAllocator.assertInstantiable(cls);
            return this.f9393a.invoke((Object) null, new Object[]{cls, Object.class});
        }
    }

    class d extends UnsafeAllocator {
        d() {
        }

        public Object newInstance(Class cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* access modifiers changed from: private */
    public static void assertInstantiable(Class<?> cls) {
        String checkInstantiable = ConstructorConstructor.checkInstantiable(cls);
        if (checkInstantiable != null) {
            throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + checkInstantiable);
        }
    }

    private static UnsafeAllocator create() {
        Class<ObjectStreamClass> cls = ObjectStreamClass.class;
        Class<Class> cls2 = Class.class;
        try {
            Class<?> cls3 = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls3.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls3.getMethod("allocateInstance", new Class[]{cls2}), declaredField.get((Object) null));
        } catch (Exception unused) {
            try {
                Method declaredMethod = cls.getDeclaredMethod("getConstructorId", new Class[]{cls2});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke((Object) null, new Object[]{Object.class})).intValue();
                Method declaredMethod2 = cls.getDeclaredMethod("newInstance", new Class[]{cls2, Integer.TYPE});
                declaredMethod2.setAccessible(true);
                return new b(declaredMethod2, intValue);
            } catch (Exception unused2) {
                try {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{cls2, cls2});
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                } catch (Exception unused3) {
                    return new d();
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
