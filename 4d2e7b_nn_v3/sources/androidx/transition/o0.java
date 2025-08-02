package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

abstract class o0 {

    /* renamed from: a  reason: collision with root package name */
    private static Field f16703a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f16704b;

    o0() {
    }

    public abstract void a(View view);

    public abstract float b(View view);

    public abstract void c(View view);

    public abstract void d(View view, Matrix matrix);

    public abstract void e(View view, int i10, int i11, int i12, int i13);

    public abstract void f(View view, float f10);

    public void g(View view, int i10) {
        if (!f16704b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f16703a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f16704b = true;
        }
        Field field = f16703a;
        if (field != null) {
            try {
                f16703a.setInt(view, i10 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void h(View view, Matrix matrix);

    public abstract void i(View view, Matrix matrix);
}
