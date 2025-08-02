package e9;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import com.alibaba.pdns.f;

public abstract class n {
    private static int a(Context context, int i10) {
        return (int) TypedValue.applyDimension(1, (float) i10, context.getResources().getDisplayMetrics());
    }

    private static DisplayCutout b(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    private static int[] c(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", (Class[]) null).invoke(loadClass, (Object[]) null);
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return iArr;
        }
    }

    public static int d(Activity activity) {
        int i10;
        int x10 = h.x(activity);
        DisplayCutout b10 = b(activity);
        if (Build.VERSION.SDK_INT < 28 || b10 == null) {
            if (j(activity)) {
                i10 = e(activity);
            } else {
                i10 = 0;
            }
            if (g(activity)) {
                i10 = c(activity)[1];
            }
            if (i(activity) && (i10 = a(activity, 32)) < x10) {
                i10 = x10;
            }
            if (!h(activity)) {
                return i10;
            }
            if (80 < x10) {
                return x10;
            }
            return 80;
        } else if (activity.getResources().getConfiguration().orientation == 1) {
            return b10.getSafeInsetTop();
        } else {
            if (b10.getSafeInsetLeft() == 0) {
                return b10.getSafeInsetRight();
            }
            return b10.getSafeInsetLeft();
        }
    }

    private static int e(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", f.f17924q);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean f(Activity activity) {
        if (b(activity) != null) {
            return true;
        }
        return false;
    }

    private static boolean g(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", (Class[]) null).invoke(loadClass, (Object[]) null)).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    private static boolean h(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean i(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{32})).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean j(android.content.Context r6) {
        /*
            r0 = 2
            r1 = 1
            java.lang.String r2 = "Xiaomi"
            java.lang.String r3 = android.os.Build.MANUFACTURER
            boolean r2 = r2.equals(r3)
            r3 = 0
            if (r2 == 0) goto L_0x003e
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r6 = r6.loadClass(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.String r2 = "getInt"
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r3] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            r4[r1] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.reflect.Method r2 = r6.getMethod(r2, r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.String r5 = "ro.miui.notch"
            r0[r3] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            r0[r1] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Object r6 = r2.invoke(r6, r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            int r6 = r6.intValue()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x003e }
            goto L_0x003f
        L_0x003e:
            r6 = r3
        L_0x003f:
            if (r6 != r1) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r1 = r3
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.n.j(android.content.Context):boolean");
    }

    public static boolean k(Activity activity) {
        if (activity == null || (!j(activity) && !g(activity) && !h(activity) && !i(activity) && !f(activity))) {
            return false;
        }
        return true;
    }
}
