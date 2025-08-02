package androidx.transition;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private static Method f16672a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f16673b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16674c;

    static void a(Canvas canvas, boolean z10) {
        Method method;
        Class<Canvas> cls = Canvas.class;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            if (z10) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        } else if (i10 != 28) {
            if (!f16674c) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("insertReorderBarrier", (Class[]) null);
                    f16672a = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = cls.getDeclaredMethod("insertInorderBarrier", (Class[]) null);
                    f16673b = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f16674c = true;
            }
            if (z10) {
                try {
                    Method method2 = f16672a;
                    if (method2 != null) {
                        method2.invoke(canvas, (Object[]) null);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e10) {
                    throw new RuntimeException(e10.getCause());
                }
            }
            if (!z10 && (method = f16673b) != null) {
                method.invoke(canvas, (Object[]) null);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
