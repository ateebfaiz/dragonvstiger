package com.reactnativepagerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.uimanager.g0;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f11342a = new f();

    private f() {
    }

    private final void i(View view) {
        view.post(new d(view));
    }

    /* access modifiers changed from: private */
    public static final void j(View view) {
        m.f(view, "$view");
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* access modifiers changed from: private */
    public static final void p(NestedScrollableHost nestedScrollableHost) {
        m.f(nestedScrollableHost, "$host");
        nestedScrollableHost.setDidSetInitialIndex(true);
    }

    /* access modifiers changed from: private */
    public static final void v(int i10, ViewPager2 viewPager2, View view, float f10) {
        m.f(viewPager2, "$pager");
        m.f(view, "page");
        float f11 = ((float) i10) * f10;
        if (viewPager2.getOrientation() == 0) {
            if (viewPager2.getLayoutDirection() == 1) {
                f11 = -f11;
            }
            view.setTranslationX(f11);
            return;
        }
        view.setTranslationY(f11);
    }

    public final void d(NestedScrollableHost nestedScrollableHost, View view, int i10) {
        Integer initialIndex;
        m.f(nestedScrollableHost, "host");
        if (view != null) {
            ViewPager2 g10 = g(nestedScrollableHost);
            g gVar = (g) g10.getAdapter();
            if (gVar != null) {
                gVar.a(view, i10);
            }
            if (g10.getCurrentItem() == i10) {
                i(g10);
            }
            if (!nestedScrollableHost.getDidSetInitialIndex() && (initialIndex = nestedScrollableHost.getInitialIndex()) != null && initialIndex.intValue() == i10) {
                nestedScrollableHost.setDidSetInitialIndex(true);
                n(g10, i10, false);
            }
        }
    }

    public final View e(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "parent");
        g gVar = (g) g(nestedScrollableHost).getAdapter();
        m.c(gVar);
        return gVar.b(i10);
    }

    public final int f(NestedScrollableHost nestedScrollableHost) {
        m.f(nestedScrollableHost, "parent");
        RecyclerView.Adapter adapter = g(nestedScrollableHost).getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public final ViewPager2 g(NestedScrollableHost nestedScrollableHost) {
        m.f(nestedScrollableHost, "view");
        if (nestedScrollableHost.getChildAt(0) instanceof ViewPager2) {
            View childAt = nestedScrollableHost.getChildAt(0);
            m.d(childAt, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
            return (ViewPager2) childAt;
        }
        throw new ClassNotFoundException("Could not retrieve ViewPager2 instance");
    }

    public final boolean h() {
        return true;
    }

    public final void k(NestedScrollableHost nestedScrollableHost) {
        m.f(nestedScrollableHost, "parent");
        ViewPager2 g10 = g(nestedScrollableHost);
        g10.setUserInputEnabled(false);
        g gVar = (g) g10.getAdapter();
        if (gVar != null) {
            gVar.e();
        }
    }

    public final void l(NestedScrollableHost nestedScrollableHost, View view) {
        m.f(nestedScrollableHost, "parent");
        m.f(view, "view");
        ViewPager2 g10 = g(nestedScrollableHost);
        g gVar = (g) g10.getAdapter();
        if (gVar != null) {
            gVar.f(view);
        }
        i(g10);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(com.reactnativepagerview.NestedScrollableHost r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.m.f(r6, r0)
            androidx.viewpager2.widget.ViewPager2 r6 = r5.g(r6)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r6.getAdapter()
            com.reactnativepagerview.g r0 = (com.reactnativepagerview.g) r0
            r1 = 0
            if (r0 == 0) goto L_0x0017
            android.view.View r2 = r0.b(r7)
            goto L_0x0018
        L_0x0017:
            r2 = r1
        L_0x0018:
            if (r2 == 0) goto L_0x0030
            android.view.ViewParent r3 = r2.getParent()
            if (r3 == 0) goto L_0x0030
            android.view.ViewParent r3 = r2.getParent()
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x002b
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L_0x002b:
            if (r1 == 0) goto L_0x0030
            r1.removeView(r2)
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.g(r7)
        L_0x0035:
            r5.i(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.f.m(com.reactnativepagerview.NestedScrollableHost, int):void");
    }

    public final void n(ViewPager2 viewPager2, int i10, boolean z10) {
        m.f(viewPager2, "view");
        i(viewPager2);
        viewPager2.setCurrentItem(i10, z10);
    }

    public final void o(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "host");
        ViewPager2 g10 = g(nestedScrollableHost);
        if (nestedScrollableHost.getInitialIndex() == null) {
            nestedScrollableHost.setInitialIndex(Integer.valueOf(i10));
            g10.post(new e(nestedScrollableHost));
        }
    }

    public final void q(NestedScrollableHost nestedScrollableHost, String str) {
        m.f(nestedScrollableHost, "host");
        m.f(str, "value");
        ViewPager2 g10 = g(nestedScrollableHost);
        if (m.b(str, "rtl")) {
            g10.setLayoutDirection(1);
        } else {
            g10.setLayoutDirection(0);
        }
    }

    public final void r(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "host");
        g(nestedScrollableHost).setOffscreenPageLimit(i10);
    }

    public final void s(NestedScrollableHost nestedScrollableHost, String str) {
        m.f(nestedScrollableHost, "host");
        m.f(str, "value");
        g(nestedScrollableHost).setOrientation(m.b(str, "vertical") ? 1 : 0);
    }

    public final void t(NestedScrollableHost nestedScrollableHost, String str) {
        m.f(nestedScrollableHost, "host");
        m.f(str, "value");
        View childAt = g(nestedScrollableHost).getChildAt(0);
        if (m.b(str, "never")) {
            childAt.setOverScrollMode(2);
        } else if (m.b(str, "always")) {
            childAt.setOverScrollMode(0);
        } else {
            childAt.setOverScrollMode(1);
        }
    }

    public final void u(NestedScrollableHost nestedScrollableHost, int i10) {
        m.f(nestedScrollableHost, "host");
        ViewPager2 g10 = g(nestedScrollableHost);
        g10.setPageTransformer(new c((int) g0.c((double) i10), g10));
    }

    public final void w(NestedScrollableHost nestedScrollableHost, boolean z10) {
        m.f(nestedScrollableHost, "host");
        g(nestedScrollableHost).setUserInputEnabled(z10);
    }
}
