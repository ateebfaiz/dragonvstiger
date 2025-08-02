package androidx.activity;

import android.view.View;
import android.view.ViewParent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.sequences.h;

public final class ViewTreeOnBackPressedDispatcherOwner {

    static final class a extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final a f13805a = new a();

        a() {
            super(1);
        }

        /* renamed from: a */
        public final View invoke(View view) {
            m.f(view, "it");
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                return (View) parent;
            }
            return null;
        }
    }

    static final class b extends n implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final b f13806a = new b();

        b() {
            super(1);
        }

        /* renamed from: a */
        public final OnBackPressedDispatcherOwner invoke(View view) {
            m.f(view, "it");
            Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
            if (tag instanceof OnBackPressedDispatcherOwner) {
                return (OnBackPressedDispatcherOwner) tag;
            }
            return null;
        }
    }

    public static final OnBackPressedDispatcherOwner get(View view) {
        m.f(view, "<this>");
        return (OnBackPressedDispatcherOwner) h.m(h.r(h.e(view, a.f13805a), b.f13806a));
    }

    public static final void set(View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        m.f(view, "<this>");
        m.f(onBackPressedDispatcherOwner, "onBackPressedDispatcherOwner");
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
