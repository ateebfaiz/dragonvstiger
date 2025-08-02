package androidx.transition;

import android.os.Build;
import android.view.View;

class m0 extends k0 {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f16690h = true;

    m0() {
    }

    public void g(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i10);
        } else if (f16690h) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f16690h = false;
            }
        }
    }
}
