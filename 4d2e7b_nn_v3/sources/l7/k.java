package l7;

import android.view.View;
import android.view.animation.Animation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class k extends a {

    /* renamed from: f  reason: collision with root package name */
    private static final a f12644f = new a((DefaultConstructorMarker) null);

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: g */
    public Animation b(View view, int i10, int i11, int i12, int i13) {
        boolean z10;
        m.f(view, "view");
        boolean z11 = true;
        if (((int) view.getX()) == i10 && ((int) view.getY()) == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (view.getWidth() == i12 && view.getHeight() == i13) {
            z11 = false;
        }
        if (z10 || z11) {
            return new m(view, i10, i11, i12, i13);
        }
        return null;
    }

    /* renamed from: h */
    public boolean e() {
        if (this.f12614d > 0) {
            return true;
        }
        return false;
    }
}
