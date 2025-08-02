package androidx.transition;

import android.view.View;
import android.view.WindowId;

class p0 implements q0 {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f16705a;

    p0(View view) {
        this.f16705a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p0) || !((p0) obj).f16705a.equals(this.f16705a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f16705a.hashCode();
    }
}
