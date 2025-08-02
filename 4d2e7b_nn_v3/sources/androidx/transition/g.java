package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class g implements f {

    /* renamed from: b  reason: collision with root package name */
    private static Class f16677b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16678c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f16679d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f16680e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f16681f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f16682g;

    /* renamed from: a  reason: collision with root package name */
    private final View f16683a;

    private g(View view) {
        this.f16683a = view;
    }

    static f b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f16679d;
        if (method != null) {
            try {
                return new g((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
        return null;
    }

    private static void c() {
        if (!f16680e) {
            try {
                d();
                Method declaredMethod = f16677b.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                f16679d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e10);
            }
            f16680e = true;
        }
    }

    private static void d() {
        if (!f16678c) {
            try {
                f16677b = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e10) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e10);
            }
            f16678c = true;
        }
    }

    private static void e() {
        if (!f16682g) {
            try {
                d();
                Method declaredMethod = f16677b.getDeclaredMethod("removeGhost", new Class[]{View.class});
                f16681f = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e10);
            }
            f16682g = true;
        }
    }

    static void f(View view) {
        e();
        Method method = f16681f;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{view});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e10) {
                throw new RuntimeException(e10.getCause());
            }
        }
    }

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i10) {
        this.f16683a.setVisibility(i10);
    }
}
