package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f14939a;

    /* renamed from: b  reason: collision with root package name */
    private static final Method f14940b;

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor f14941c;

    /* renamed from: d  reason: collision with root package name */
    private static final LongSparseArray f14942d = new LongSparseArray(3);

    /* renamed from: e  reason: collision with root package name */
    private static final Object f14943e = new Object();

    static {
        Method method;
        Field field;
        Constructor<Typeface> constructor;
        Class<Typeface> cls = Typeface.class;
        try {
            field = cls.getDeclaredField("native_instance");
            Class cls2 = Long.TYPE;
            method = cls.getDeclaredMethod("nativeCreateFromTypefaceWithExactStyle", new Class[]{cls2, Integer.TYPE, Boolean.TYPE});
            method.setAccessible(true);
            constructor = cls.getDeclaredConstructor(new Class[]{cls2});
            constructor.setAccessible(true);
        } catch (NoSuchFieldException | NoSuchMethodException e10) {
            Log.e("WeightTypeface", e10.getClass().getName(), e10);
            field = null;
            constructor = null;
            method = null;
        }
        f14939a = field;
        f14940b = method;
        f14941c = constructor;
    }

    private static Typeface a(long j10) {
        try {
            return (Typeface) f14941c.newInstance(new Object[]{Long.valueOf(j10)});
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    static Typeface b(Typeface typeface, int i10, boolean z10) {
        if (!d()) {
            return null;
        }
        boolean z11 = (i10 << 1) | z10;
        synchronized (f14943e) {
            try {
                long c10 = c(typeface);
                LongSparseArray longSparseArray = f14942d;
                SparseArray sparseArray = (SparseArray) longSparseArray.get(c10);
                if (sparseArray == null) {
                    sparseArray = new SparseArray(4);
                    longSparseArray.put(c10, sparseArray);
                } else {
                    Typeface typeface2 = (Typeface) sparseArray.get(z11);
                    if (typeface2 != null) {
                        return typeface2;
                    }
                }
                Typeface a10 = a(e(c10, i10, z10));
                sparseArray.put(z11 ? 1 : 0, a10);
                return a10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long c(Typeface typeface) {
        try {
            return f14939a.getLong(typeface);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static boolean d() {
        if (f14939a != null) {
            return true;
        }
        return false;
    }

    private static long e(long j10, int i10, boolean z10) {
        try {
            return ((Long) f14940b.invoke((Object) null, new Object[]{Long.valueOf(j10), Integer.valueOf(i10), Boolean.valueOf(z10)})).longValue();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (InvocationTargetException e11) {
            throw new RuntimeException(e11);
        }
    }
}
