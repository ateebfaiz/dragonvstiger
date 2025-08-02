package androidx.savedstate;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public final class ViewTreeSavedStateRegistryOwner {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f16488a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final View invoke(View view) {
            m.f(view, "view");
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f16489a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final SavedStateRegistryOwner invoke(View view) {
            m.f(view, "view");
            Object tag = view.getTag(R.id.view_tree_saved_state_registry_owner);
            if (tag instanceof SavedStateRegistryOwner) {
                return (SavedStateRegistryOwner) tag;
            }
            return null;
        }
    }

    public static final SavedStateRegistryOwner get(View view) {
        m.f(view, "<this>");
        return (SavedStateRegistryOwner) h.m(h.r(h.e(view, a.f16488a), b.f16489a));
    }

    public static final void set(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        m.f(view, "<this>");
        view.setTag(R.id.view_tree_saved_state_registry_owner, savedStateRegistryOwner);
    }
}
