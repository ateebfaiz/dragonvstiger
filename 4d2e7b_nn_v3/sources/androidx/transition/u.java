package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class u implements v {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f16725a;

    u(ViewGroup viewGroup) {
        this.f16725a = viewGroup.getOverlay();
    }

    public void a(View view) {
        this.f16725a.add(view);
    }

    public void add(Drawable drawable) {
        this.f16725a.add(drawable);
    }

    public void b(View view) {
        this.f16725a.remove(view);
    }

    public void remove(Drawable drawable) {
        this.f16725a.remove(drawable);
    }
}
