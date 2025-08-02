package com.swmansion.gesturehandler.react;

import ab.c0;
import ab.t;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.q0;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.jvm.internal.m;
import kotlin.n;

public final class l implements c0 {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11429a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.facebook.react.uimanager.h0[] r0 = com.facebook.react.uimanager.h0.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.facebook.react.uimanager.h0 r1 = com.facebook.react.uimanager.h0.BOX_ONLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.facebook.react.uimanager.h0 r1 = com.facebook.react.uimanager.h0.BOX_NONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.facebook.react.uimanager.h0 r1 = com.facebook.react.uimanager.h0.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.facebook.react.uimanager.h0 r1 = com.facebook.react.uimanager.h0.AUTO     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f11429a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.l.a.<clinit>():void");
        }
    }

    public t a(View view) {
        h0 h0Var;
        m.f(view, "view");
        if (view instanceof q0) {
            h0Var = ((q0) view).getPointerEvents();
            m.c(h0Var);
        } else {
            h0Var = h0.AUTO;
        }
        if (!view.isEnabled()) {
            if (h0Var == h0.AUTO) {
                return t.BOX_NONE;
            }
            if (h0Var == h0.BOX_ONLY) {
                return t.NONE;
            }
        }
        int i10 = a.f11429a[h0Var.ordinal()];
        if (i10 == 1) {
            return t.BOX_ONLY;
        }
        if (i10 == 2) {
            return t.BOX_NONE;
        }
        if (i10 == 3) {
            return t.NONE;
        }
        if (i10 == 4) {
            return t.AUTO;
        }
        throw new n();
    }

    public boolean b(ViewGroup viewGroup) {
        m.f(viewGroup, "view");
        if (viewGroup.getClipChildren()) {
            return true;
        }
        if (viewGroup instanceof ReactScrollView) {
            if (!m.b(((ReactScrollView) viewGroup).getOverflow(), "visible")) {
                return true;
            }
        } else if (viewGroup instanceof ReactHorizontalScrollView) {
            if (!m.b(((ReactHorizontalScrollView) viewGroup).getOverflow(), "visible")) {
                return true;
            }
        } else if (viewGroup instanceof ReactViewGroup) {
            return m.b(((ReactViewGroup) viewGroup).getOverflow(), "hidden");
        }
        return false;
    }

    public View c(ViewGroup viewGroup, int i10) {
        m.f(viewGroup, "parent");
        if (viewGroup instanceof ReactViewGroup) {
            View childAt = viewGroup.getChildAt(((ReactViewGroup) viewGroup).getZIndexMappedChildIndex(i10));
            m.c(childAt);
            return childAt;
        }
        View childAt2 = viewGroup.getChildAt(i10);
        m.e(childAt2, "getChildAt(...)");
        return childAt2;
    }
}
