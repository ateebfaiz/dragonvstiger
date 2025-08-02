package g7;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class a implements b {

    /* renamed from: c  reason: collision with root package name */
    private static final C0139a f12214c = new C0139a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private volatile int f12215a = -1;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f12216b;

    /* renamed from: g7.a$a  reason: collision with other inner class name */
    private static final class C0139a {
        private C0139a() {
        }

        public /* synthetic */ C0139a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void c() {
        ViewParent viewParent = this.f12216b;
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(false);
        }
        this.f12216b = null;
    }

    public boolean a(ViewGroup viewGroup, MotionEvent motionEvent) {
        m.f(viewGroup, "view");
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int i10 = this.f12215a;
        if (i10 == -1 || motionEvent.getAction() == 1 || viewGroup.getId() != i10) {
            return false;
        }
        return true;
    }

    public final void b() {
        this.f12215a = -1;
        c();
    }

    public final void d(int i10, ViewParent viewParent) {
        this.f12215a = i10;
        c();
        if (viewParent != null) {
            viewParent.requestDisallowInterceptTouchEvent(true);
            this.f12216b = viewParent;
        }
    }
}
