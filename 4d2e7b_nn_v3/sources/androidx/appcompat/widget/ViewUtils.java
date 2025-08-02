package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewUtils {
    @ChecksSdkIntAtLeast(api = 27)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static final boolean SDK_LEVEL_SUPPORTS_AUTOSIZE;
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 27) {
            z10 = true;
        } else {
            z10 = false;
        }
        SDK_LEVEL_SUPPORTS_AUTOSIZE = z10;
        try {
            Class<Rect> cls = Rect.class;
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
            sComputeFitSystemWindowsMethod = declaredMethod;
            if (!declaredMethod.isAccessible()) {
                sComputeFitSystemWindowsMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View view, Rect rect, Rect rect2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e10) {
                Log.d(TAG, "Could not invoke computeFitSystemWindows", e10);
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    public static void makeOptionalFitsSystemWindows(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", (Class[]) null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, (Object[]) null);
        } catch (NoSuchMethodException unused) {
            Log.d(TAG, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e10) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e10);
        } catch (IllegalAccessException e11) {
            Log.d(TAG, "Could not invoke makeOptionalFitsSystemWindows", e11);
        }
    }
}
