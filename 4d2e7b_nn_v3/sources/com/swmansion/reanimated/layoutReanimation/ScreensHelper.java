package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

public class ScreensHelper {
    /* JADX WARNING: Incorrect type for immutable var: ssa=android.view.View, code=java.lang.Object, for r3v0, types: [android.view.View] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.View getTabNavigator(java.lang.Object r3) {
        /*
        L_0x0000:
            r0 = 0
            if (r3 == 0) goto L_0x0052
            boolean r1 = isScreenContainer(r3)
            if (r1 == 0) goto L_0x000a
            return r3
        L_0x000a:
            boolean r1 = isScreen(r3)
            if (r1 == 0) goto L_0x0043
            android.view.ViewParent r1 = r3.getParent()
            boolean r1 = isScreensCoordinatorLayout(r1)
            if (r1 == 0) goto L_0x0043
            java.lang.Class r1 = r3.getClass()
            java.lang.String r2 = "getContainer"
            java.lang.reflect.Method r1 = r1.getMethod(r2, r0)     // Catch:{ NoSuchMethodException -> 0x002f, InvocationTargetException -> 0x002d, IllegalAccessException -> 0x002b }
            java.lang.Object r3 = r1.invoke(r3, r0)     // Catch:{ NoSuchMethodException -> 0x002f, InvocationTargetException -> 0x002d, IllegalAccessException -> 0x002b }
            android.view.View r3 = (android.view.View) r3     // Catch:{ NoSuchMethodException -> 0x002f, InvocationTargetException -> 0x002d, IllegalAccessException -> 0x002b }
            goto L_0x0000
        L_0x002b:
            r3 = move-exception
            goto L_0x0030
        L_0x002d:
            r3 = move-exception
            goto L_0x0030
        L_0x002f:
            r3 = move-exception
        L_0x0030:
            java.lang.String r1 = r3.getMessage()
            if (r1 == 0) goto L_0x003b
            java.lang.String r3 = r3.getMessage()
            goto L_0x003d
        L_0x003b:
            java.lang.String r3 = "Unable to invoke the getContainer method"
        L_0x003d:
            java.lang.String r1 = "[Reanimated]"
            android.util.Log.e(r1, r3)
            goto L_0x0052
        L_0x0043:
            android.view.ViewParent r1 = r3.getParent()
            boolean r1 = r1 instanceof android.view.View
            if (r1 == 0) goto L_0x0052
            android.view.ViewParent r3 = r3.getParent()
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0052:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.reanimated.layoutReanimation.ScreensHelper.getTabNavigator(android.view.View):android.view.View");
    }

    public static View getTopScreenForStack(View view) {
        if (isScreenStack(view)) {
            try {
                return (View) view.getClass().getMethod("getTopScreen", (Class[]) null).invoke(view, (Object[]) null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return view;
    }

    private static boolean isInstanceOf(Object obj, String str) {
        if (obj == null || !obj.getClass().getSimpleName().equals(str)) {
            return false;
        }
        return true;
    }

    public static boolean isScreen(Object obj) {
        return isInstanceOf(obj, "Screen");
    }

    public static boolean isScreenContainer(Object obj) {
        return isInstanceOf(obj, "ScreenContainer");
    }

    public static boolean isScreenFragment(Object obj) {
        return isInstanceOf(obj, "ScreenFragment");
    }

    public static boolean isScreenStack(Object obj) {
        return isInstanceOf(obj, "ScreenStack");
    }

    public static boolean isScreensCoordinatorLayout(Object obj) {
        return isInstanceOf(obj, "ScreensCoordinatorLayout");
    }

    public static boolean isViewChildOfScreen(View view, View view2) {
        while (view != null) {
            if (view == view2) {
                return true;
            }
            if (!(view.getParent() instanceof View)) {
                return false;
            }
            view = (View) view.getParent();
        }
        return false;
    }
}
