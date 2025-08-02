package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f14932a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f14933b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f14934c;

    /* renamed from: d  reason: collision with root package name */
    private static final Constructor f14935d;

    /* renamed from: e  reason: collision with root package name */
    private static final LongSparseArray f14936e = new LongSparseArray(3);

    /* renamed from: f  reason: collision with root package name */
    private static final Object f14937f = new Object();

    static {
        Method method;
        Field field;
        Constructor<Typeface> constructor;
        Method method2;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField("native_instance");
            Class cls2 = Long.TYPE;
            Class cls3 = Integer.TYPE;
            method = cls.getDeclaredMethod("nativeCreateFromTypeface", new Class[]{cls2, cls3});
            method.setAccessible(true);
            method2 = cls.getDeclaredMethod("nativeCreateWeightAlias", new Class[]{cls2, cls3});
            method2.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e10) {
            Log.e("WeightTypeface", e10.getClass().getName(), e10);
            field = null;
            method2 = null;
            constructor = null;
            method = null;
        }
        f14932a = field;
        f14933b = method;
        f14934c = method2;
        f14935d = constructor;
    }

    private static Typeface a(long j10) {
        try {
            return (Typeface) f14935d.newInstance(new Object[]{Long.valueOf(j10)});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    static Typeface b(Typeface typeface, int i10, boolean z10) {
        Typeface typeface2;
        if (!d()) {
            return null;
        }
        boolean z11 = (i10 << 1) | z10;
        synchronized (f14937f) {
            try {
                long c10 = c(typeface);
                LongSparseArray longSparseArray = f14936e;
                SparseArray sparseArray = (SparseArray) longSparseArray.get(c10);
                if (sparseArray == null) {
                    sparseArray = new SparseArray(4);
                    longSparseArray.put(c10, sparseArray);
                } else {
                    Typeface typeface3 = (Typeface) sparseArray.get(z11);
                    if (typeface3 != null) {
                        return typeface3;
                    }
                }
                if (z10 == typeface.isItalic()) {
                    typeface2 = a(f(c10, i10));
                } else {
                    typeface2 = a(e(c10, i10, z10));
                }
                sparseArray.put(z11 ? 1 : 0, typeface2);
                return typeface2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long c(Typeface typeface) {
        try {
            return f14932a.getLong(typeface);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static boolean d() {
        if (f14932a != null) {
            return true;
        }
        return false;
    }

    private static long e(long j10, int i10, boolean z10) {
        int i11;
        if (z10) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        try {
            Long l10 = (Long) f14933b.invoke((Object) null, new Object[]{Long.valueOf(j10), Integer.valueOf(i11)});
            l10.longValue();
            return ((Long) f14934c.invoke((Object) null, new Object[]{l10, Integer.valueOf(i10)})).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static long f(long j10, int i10) {
        try {
            return ((Long) f14934c.invoke((Object) null, new Object[]{Long.valueOf(j10), Integer.valueOf(i10)})).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
