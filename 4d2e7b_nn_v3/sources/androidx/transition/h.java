package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

abstract class h {
    static f a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return g.b(view, viewGroup, matrix);
        }
        return GhostViewPort.b(view, viewGroup, matrix);
    }

    static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            g.f(view);
        } else {
            GhostViewPort.f(view);
        }
    }
}
