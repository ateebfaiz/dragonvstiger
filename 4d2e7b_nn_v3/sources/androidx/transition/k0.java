package androidx.transition;

import android.view.View;

abstract class k0 extends i0 {

    /* renamed from: g  reason: collision with root package name */
    private static boolean f16689g = true;

    k0() {
    }

    public void e(View view, int i10, int i11, int i12, int i13) {
        if (f16689g) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f16689g = false;
            }
        }
    }
}
