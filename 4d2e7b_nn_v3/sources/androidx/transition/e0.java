package androidx.transition;

import android.view.View;

abstract class e0 extends o0 {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16676c = true;

    e0() {
    }

    public void a(View view) {
    }

    public float b(View view) {
        if (f16676c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f16676c = false;
            }
        }
        return view.getAlpha();
    }

    public void c(View view) {
    }

    public void f(View view, float f10) {
        if (f16676c) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f16676c = false;
            }
        }
        view.setAlpha(f10);
    }
}
