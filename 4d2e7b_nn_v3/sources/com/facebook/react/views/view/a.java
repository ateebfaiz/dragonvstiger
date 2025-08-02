package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f4363a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f4364b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4365c;

    public static void a(Canvas canvas, boolean z10) {
        Method method;
        if (Build.VERSION.SDK_INT < 29) {
            b();
            if (z10) {
                try {
                    Method method2 = f4363a;
                    if (method2 != null) {
                        method2.invoke(canvas, (Object[]) null);
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                    return;
                }
            }
            if (!z10 && (method = f4364b) != null) {
                method.invoke(canvas, (Object[]) null);
            }
        } else if (z10) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }

    private static void b() {
        if (!f4365c) {
            try {
                Class<Canvas> cls = Canvas.class;
                if (Build.VERSION.SDK_INT == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});
                    f4363a = (Method) declaredMethod.invoke(cls, new Object[]{"insertReorderBarrier", new Class[0]});
                    f4364b = (Method) declaredMethod.invoke(cls, new Object[]{"insertInorderBarrier", new Class[0]});
                } else {
                    f4363a = cls.getDeclaredMethod("insertReorderBarrier", (Class[]) null);
                    f4364b = cls.getDeclaredMethod("insertInorderBarrier", (Class[]) null);
                }
                Method method = f4363a;
                if (method == null) {
                    return;
                }
                if (f4364b != null) {
                    method.setAccessible(true);
                    f4364b.setAccessible(true);
                    f4365c = true;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }
}
