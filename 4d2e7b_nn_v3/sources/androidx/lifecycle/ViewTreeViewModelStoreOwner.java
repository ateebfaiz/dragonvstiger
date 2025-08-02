package androidx.lifecycle;

import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.viewmodel.R;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public final class ViewTreeViewModelStoreOwner {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15877a = new a();

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
        public static final b f15878a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final ViewModelStoreOwner invoke(View view) {
            m.f(view, "view");
            Object tag = view.getTag(R.id.view_tree_view_model_store_owner);
            if (tag instanceof ViewModelStoreOwner) {
                return (ViewModelStoreOwner) tag;
            }
            return null;
        }
    }

    public static final ViewModelStoreOwner get(View view) {
        m.f(view, "<this>");
        return (ViewModelStoreOwner) h.m(h.r(h.e(view, a.f15877a), b.f15878a));
    }

    public static final void set(View view, ViewModelStoreOwner viewModelStoreOwner) {
        m.f(view, "<this>");
        view.setTag(R.id.view_tree_view_model_store_owner, viewModelStoreOwner);
    }
}
