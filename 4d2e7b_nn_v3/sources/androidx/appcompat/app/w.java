package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.DoNotInline;
import java.lang.reflect.Field;

abstract class w {

    /* renamed from: a  reason: collision with root package name */
    private static Field f13982a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f13983b;

    /* renamed from: c  reason: collision with root package name */
    private static Class f13984c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f13985d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f13986e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f13987f;

    /* renamed from: g  reason: collision with root package name */
    private static Field f13988g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f13989h;

    static class a {
        @DoNotInline
        static void a(LongSparseArray longSparseArray) {
            longSparseArray.clear();
        }
    }

    static void a(Resources resources) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 28) {
            if (i10 >= 24) {
                c(resources);
            } else {
                b(resources);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.res.Resources r4) {
        /*
            boolean r0 = f13983b
            java.lang.String r1 = "ResourcesFlusher"
            if (r0 != 0) goto L_0x001d
            r0 = 1
            java.lang.Class<android.content.res.Resources> r2 = android.content.res.Resources.class
            java.lang.String r3 = "mDrawableCache"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0015 }
            f13982a = r2     // Catch:{ NoSuchFieldException -> 0x0015 }
            r2.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0015 }
            goto L_0x001b
        L_0x0015:
            r2 = move-exception
            java.lang.String r3 = "Could not retrieve Resources#mDrawableCache field"
            android.util.Log.e(r1, r3, r2)
        L_0x001b:
            f13983b = r0
        L_0x001d:
            java.lang.reflect.Field r0 = f13982a
            if (r0 == 0) goto L_0x002c
            java.lang.Object r4 = r0.get(r4)     // Catch:{ IllegalAccessException -> 0x0026 }
            goto L_0x002d
        L_0x0026:
            r4 = move-exception
            java.lang.String r0 = "Could not retrieve value from Resources#mDrawableCache"
            android.util.Log.e(r1, r0, r4)
        L_0x002c:
            r4 = 0
        L_0x002d:
            if (r4 != 0) goto L_0x0030
            return
        L_0x0030:
            d(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.w.b(android.content.res.Resources):void");
    }

    private static void c(Resources resources) {
        Object obj;
        if (!f13989h) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f13988g = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e10);
            }
            f13989h = true;
        }
        Field field = f13988g;
        if (field != null) {
            Object obj2 = null;
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e11) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e11);
                obj = null;
            }
            if (obj != null) {
                if (!f13983b) {
                    try {
                        Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                        f13982a = declaredField2;
                        declaredField2.setAccessible(true);
                    } catch (NoSuchFieldException e12) {
                        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e12);
                    }
                    f13983b = true;
                }
                Field field2 = f13982a;
                if (field2 != null) {
                    try {
                        obj2 = field2.get(obj);
                    } catch (IllegalAccessException e13) {
                        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e13);
                    }
                }
                if (obj2 != null) {
                    d(obj2);
                }
            }
        }
    }

    private static void d(Object obj) {
        LongSparseArray longSparseArray;
        if (!f13985d) {
            try {
                f13984c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e10) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e10);
            }
            f13985d = true;
        }
        Class cls = f13984c;
        if (cls != null) {
            if (!f13987f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f13986e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e11) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e11);
                }
                f13987f = true;
            }
            Field field = f13986e;
            if (field != null) {
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e12) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e12);
                    longSparseArray = null;
                }
                if (longSparseArray != null) {
                    a.a(longSparseArray);
                }
            }
        }
    }
}
