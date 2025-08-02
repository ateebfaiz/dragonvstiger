package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract class y {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f16726a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Method f16727b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16728c;

    static int a(ViewGroup viewGroup, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i10);
        }
        if (!f16728c) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{cls2, cls2});
                f16727b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f16728c = true;
        }
        Method method = f16727b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i10)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i10;
    }

    static v b(ViewGroup viewGroup) {
        return new u(viewGroup);
    }

    private static void c(ViewGroup viewGroup, boolean z10) {
        if (f16726a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f16726a = false;
            }
        }
    }

    static void d(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z10);
        } else {
            c(viewGroup, z10);
        }
    }
}
