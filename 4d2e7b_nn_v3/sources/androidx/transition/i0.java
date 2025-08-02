package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

abstract class i0 extends e0 {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f16684d = true;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f16685e = true;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f16686f = true;

    i0() {
    }

    public void d(View view, Matrix matrix) {
        if (f16684d) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f16684d = false;
            }
        }
    }

    public void h(View view, Matrix matrix) {
        if (f16685e) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f16685e = false;
            }
        }
    }

    public void i(View view, Matrix matrix) {
        if (f16686f) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f16686f = false;
            }
        }
    }
}
