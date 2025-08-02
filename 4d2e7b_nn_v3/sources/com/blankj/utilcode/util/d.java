package com.blankj.utilcode.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

public abstract class d {
    public static void a(Activity activity) {
        b(activity.getWindow());
    }

    public static void b(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) p.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            String[] strArr = {"mLastSrvView", "mCurRootView", "mServedView", "mNextServedView"};
            for (int i10 = 0; i10 < 4; i10++) {
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField(strArr[i10]);
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(inputMethodManager);
                    if (obj instanceof View) {
                        if (((View) obj).getRootView() == window.getDecorView().getRootView()) {
                            declaredField.set(inputMethodManager, (Object) null);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void c() {
        InputMethodManager inputMethodManager = (InputMethodManager) p.a().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }
}
