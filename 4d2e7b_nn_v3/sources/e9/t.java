package e9;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class t {

    /* renamed from: a  reason: collision with root package name */
    private static Method f12049a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f12050b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f12051c;

    /* renamed from: d  reason: collision with root package name */
    private static int f12052d;

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|7|8|9|(3:11|12|14)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
    static {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "setStatusBarDarkIcon"
            java.lang.Class<android.app.Activity> r3 = android.app.Activity.class
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0012 }
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x0012 }
            java.lang.reflect.Method r4 = r3.getMethod(r2, r4)     // Catch:{ NoSuchMethodException -> 0x0012 }
            f12049a = r4     // Catch:{ NoSuchMethodException -> 0x0012 }
        L_0x0012:
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x001e }
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x001e }
            r1[r0] = r4     // Catch:{ NoSuchMethodException -> 0x001e }
            java.lang.reflect.Method r0 = r3.getMethod(r2, r1)     // Catch:{ NoSuchMethodException -> 0x001e }
            f12050b = r0     // Catch:{ NoSuchMethodException -> 0x001e }
        L_0x001e:
            java.lang.Class<android.view.WindowManager$LayoutParams> r0 = android.view.WindowManager.LayoutParams.class
            java.lang.String r1 = "statusBarColor"
            java.lang.reflect.Field r0 = r0.getField(r1)     // Catch:{ NoSuchFieldException -> 0x0028 }
            f12051c = r0     // Catch:{ NoSuchFieldException -> 0x0028 }
        L_0x0028:
            java.lang.Class<android.view.View> r0 = android.view.View.class
            java.lang.String r1 = "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR"
            java.lang.reflect.Field r0 = r0.getField(r1)     // Catch:{ IllegalAccessException | NoSuchFieldException -> 0x0037 }
            r1 = 0
            int r0 = r0.getInt(r1)     // Catch:{ IllegalAccessException | NoSuchFieldException -> 0x0037 }
            f12052d = r0     // Catch:{ IllegalAccessException | NoSuchFieldException -> 0x0037 }
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.t.<clinit>():void");
    }

    static boolean a(int i10, int i11) {
        if (j(i10) < i11) {
            return true;
        }
        return false;
    }

    static void b(Window window, String str, boolean z10) {
        if (window != null) {
            Class<?> cls = window.getClass();
            try {
                Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                int i10 = cls2.getField(str).getInt(cls2);
                Class cls3 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", new Class[]{cls3, cls3});
                if (z10) {
                    method.invoke(window, new Object[]{Integer.valueOf(i10), Integer.valueOf(i10)});
                    return;
                }
                method.invoke(window, new Object[]{0, Integer.valueOf(i10)});
            } catch (Exception unused) {
            }
        }
    }

    private static void c(Window window, int i10) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f12051c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i10) {
                    f12051c.set(attributes, Integer.valueOf(i10));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void d(Activity activity, int i10) {
        Method method = f12049a;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Integer.valueOf(i10)});
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        } else {
            boolean a10 = a(i10, 50);
            if (f12051c != null) {
                f(activity, a10, a10);
                h(activity.getWindow(), i10);
                return;
            }
            e(activity, a10);
        }
    }

    public static void e(Activity activity, boolean z10) {
        f(activity, z10, true);
    }

    private static void f(Activity activity, boolean z10, boolean z11) {
        Method method = f12050b;
        if (method != null) {
            try {
                method.invoke(activity, new Object[]{Boolean.valueOf(z10)});
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        } else if (z11) {
            i(activity.getWindow(), z10);
        }
    }

    private static void g(View view, boolean z10) {
        int i10;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z10) {
            i10 = f12052d | systemUiVisibility;
        } else {
            i10 = (~f12052d) & systemUiVisibility;
        }
        if (i10 != systemUiVisibility) {
            view.setSystemUiVisibility(i10);
        }
    }

    public static void h(Window window, int i10) {
        try {
            c(window, i10);
            g(window.getDecorView(), true);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void i(Window window, boolean z10) {
        g(window.getDecorView(), z10);
        c(window, 0);
    }

    static int j(int i10) {
        return (((((i10 & 16711680) >> 16) * 38) + (((65280 & i10) >> 8) * 75)) + ((i10 & 255) * 15)) >> 7;
    }
}
