package g2;

import android.view.MotionEvent;
import android.view.View;
import h2.f;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.m;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f21664a = new d();

    public static final class a implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        private final h2.a f21665a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference f21666b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference f21667c;

        /* renamed from: d  reason: collision with root package name */
        private final View.OnTouchListener f21668d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f21669e = true;

        public a(h2.a aVar, View view, View view2) {
            m.f(aVar, "mapping");
            m.f(view, "rootView");
            m.f(view2, "hostView");
            this.f21665a = aVar;
            this.f21666b = new WeakReference(view2);
            this.f21667c = new WeakReference(view);
            this.f21668d = f.h(view2);
        }

        public final boolean a() {
            return this.f21669e;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            m.f(view, "view");
            m.f(motionEvent, "motionEvent");
            View view2 = (View) this.f21667c.get();
            View view3 = (View) this.f21666b.get();
            if (!(view2 == null || view3 == null || motionEvent.getAction() != 1)) {
                a.c(this.f21665a, view2, view3);
            }
            View.OnTouchListener onTouchListener = this.f21668d;
            if (onTouchListener == null || !onTouchListener.onTouch(view, motionEvent)) {
                return false;
            }
            return true;
        }
    }

    private d() {
    }

    public static final a a(h2.a aVar, View view, View view2) {
        Class<d> cls = d.class;
        if (v5.a.d(cls)) {
            return null;
        }
        try {
            m.f(aVar, "mapping");
            m.f(view, "rootView");
            m.f(view2, "hostView");
            return new a(aVar, view, view2);
        } catch (Throwable th) {
            v5.a.b(th, cls);
            return null;
        }
    }
}
