package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.runtime.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public final class ViewTreeLifecycleOwner {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15875a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final View invoke(View view) {
            m.f(view, "currentView");
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f15876a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final LifecycleOwner invoke(View view) {
            m.f(view, "viewParent");
            Object tag = view.getTag(R.id.view_tree_lifecycle_owner);
            if (tag instanceof LifecycleOwner) {
                return (LifecycleOwner) tag;
            }
            return null;
        }
    }

    public static final LifecycleOwner get(View view) {
        m.f(view, "<this>");
        return (LifecycleOwner) h.m(h.r(h.e(view, a.f15875a), b.f15876a));
    }

    public static final void set(View view, LifecycleOwner lifecycleOwner) {
        m.f(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
