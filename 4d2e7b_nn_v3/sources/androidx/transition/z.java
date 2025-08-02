package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

class z implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f16729a;

    z(View view) {
        this.f16729a = view.getOverlay();
    }

    public void add(Drawable drawable) {
        this.f16729a.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.f16729a.remove(drawable);
    }
}
