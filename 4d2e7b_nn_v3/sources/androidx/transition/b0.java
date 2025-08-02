package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

abstract class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static final o0 f16669a;

    /* renamed from: b  reason: collision with root package name */
    static final Property f16670b = new a(Float.class, "translationAlpha");

    /* renamed from: c  reason: collision with root package name */
    static final Property f16671c = new b(Rect.class, "clipBounds");

    static class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(b0.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            b0.h(view, f10.floatValue());
        }
    }

    static class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f16669a = new n0();
        } else {
            f16669a = new m0();
        }
    }

    static void a(View view) {
        f16669a.a(view);
    }

    static a0 b(View view) {
        return new z(view);
    }

    static float c(View view) {
        return f16669a.b(view);
    }

    static q0 d(View view) {
        return new p0(view);
    }

    static void e(View view) {
        f16669a.c(view);
    }

    static void f(View view, Matrix matrix) {
        f16669a.d(view, matrix);
    }

    static void g(View view, int i10, int i11, int i12, int i13) {
        f16669a.e(view, i10, i11, i12, i13);
    }

    static void h(View view, float f10) {
        f16669a.f(view, f10);
    }

    static void i(View view, int i10) {
        f16669a.g(view, i10);
    }

    static void j(View view, Matrix matrix) {
        f16669a.h(view, matrix);
    }

    static void k(View view, Matrix matrix) {
        f16669a.i(view, matrix);
    }
}
