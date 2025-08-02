package com.shopify.reactnative.flash_list;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.k1;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.Comparator;
import kotlin.jvm.internal.m;

public final class AutoLayoutView extends ReactViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private final a f11346a = new a();

    /* renamed from: b  reason: collision with root package name */
    private boolean f11347b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11348c;

    /* renamed from: d  reason: collision with root package name */
    private double f11349d = 1.0d;

    public static final class a implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return nb.a.a(Integer.valueOf(((c) obj).getIndex()), Integer.valueOf(((c) obj2).getIndex()));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AutoLayoutView(Context context) {
        super(context);
        m.f(context, "context");
    }

    private final View getFooter() {
        ViewGroup viewGroup;
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof c) && ((c) childAt).getIndex() == -1) {
                return childAt;
            }
        }
        return null;
    }

    private final int getFooterDiff() {
        int bottom;
        int top;
        int i10;
        if (getChildCount() == 0) {
            this.f11346a.i(0);
        } else if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            a aVar = this.f11346a;
            if (aVar.e()) {
                i10 = childAt.getRight();
            } else {
                i10 = childAt.getBottom();
            }
            aVar.i(i10);
        }
        if (this.f11346a.e()) {
            bottom = getRight();
            top = getLeft();
        } else {
            bottom = getBottom();
            top = getTop();
        }
        return this.f11346a.f() - (bottom - top);
    }

    private final View getParentScrollView() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof ScrollView) || (parent instanceof HorizontalScrollView)) {
                return (View) parent;
            }
        }
        return null;
    }

    private final void p() {
        Context context = getContext();
        m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        e c10 = k1.c((ReactContext) context, getId());
        if (c10 != null) {
            Context context2 = getContext();
            m.d(context2, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
            c10.c(new b(k1.e((ReactContext) context2), getId(), ((double) this.f11346a.d()) / this.f11349d, ((double) this.f11346a.c()) / this.f11349d));
        }
    }

    private final void q() {
        View view;
        View parentScrollView = getParentScrollView();
        if (!this.f11348c && parentScrollView != null) {
            if (this.f11346a.e()) {
                if (getRight() > parentScrollView.getWidth()) {
                    return;
                }
            } else if (getBottom() > parentScrollView.getHeight()) {
                return;
            }
            ViewParent parent = getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
            View footer = getFooter();
            int footerDiff = getFooterDiff();
            if (footerDiff != 0 && footer != null && view != null) {
                if (this.f11346a.e()) {
                    footer.offsetLeftAndRight(footerDiff);
                    setRight(getRight() + footerDiff);
                    view.setRight(view.getRight() + footerDiff);
                    return;
                }
                footer.offsetTopAndBottom(footerDiff);
                setBottom(getBottom() + footerDiff);
                view.setBottom(view.getBottom() + footerDiff);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.shopify.reactnative.flash_list.c[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void r() {
        /*
            r6 = this;
            int r0 = r6.getChildCount()
            r1 = 1
            if (r0 <= r1) goto L_0x004c
            boolean r0 = r6.f11348c
            if (r0 != 0) goto L_0x004c
            int r0 = r6.getChildCount()
            com.shopify.reactnative.flash_list.c[] r2 = new com.shopify.reactnative.flash_list.c[r0]
            r3 = 0
        L_0x0012:
            if (r3 >= r0) goto L_0x0029
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof com.shopify.reactnative.flash_list.c
            if (r5 == 0) goto L_0x0021
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x0012
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "CellRendererComponent outer view should always be CellContainer. Learn more here: https://shopify.github.io/flash-list/docs/usage#cellrenderercomponent."
            r0.<init>(r1)
            throw r0
        L_0x0029:
            if (r0 <= r1) goto L_0x0033
            com.shopify.reactnative.flash_list.AutoLayoutView$a r0 = new com.shopify.reactnative.flash_list.AutoLayoutView$a
            r0.<init>()
            kotlin.collections.j.q(r2, r0)
        L_0x0033:
            com.shopify.reactnative.flash_list.a r0 = r6.f11346a
            boolean r1 = r0.e()
            if (r1 == 0) goto L_0x0040
            int r1 = r6.getLeft()
            goto L_0x0044
        L_0x0040:
            int r1 = r6.getTop()
        L_0x0044:
            r0.j(r1)
            com.shopify.reactnative.flash_list.a r0 = r6.f11346a
            r0.a(r2)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopify.reactnative.flash_list.AutoLayoutView.r():void");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        m.f(canvas, "canvas");
        r();
        q();
        super.dispatchDraw(canvas);
        View parentScrollView = getParentScrollView();
        if (this.f11347b && parentScrollView != null) {
            if (this.f11346a.e()) {
                i10 = parentScrollView.getWidth();
            } else {
                i10 = parentScrollView.getHeight();
            }
            if (this.f11346a.e()) {
                i11 = parentScrollView.getScrollX();
            } else {
                i11 = parentScrollView.getScrollY();
            }
            if (this.f11346a.e()) {
                i12 = getLeft();
            } else {
                i12 = getTop();
            }
            if (this.f11346a.e()) {
                i13 = getRight();
            } else {
                i13 = getBottom();
            }
            this.f11346a.b(i11, Math.max(i12 - i11, 0), Math.max((i10 + i11) - i13, 0));
            p();
        }
    }

    public final a getAlShadow() {
        return this.f11346a;
    }

    public final boolean getDisableAutoLayout() {
        return this.f11348c;
    }

    public final boolean getEnableInstrumentation() {
        return this.f11347b;
    }

    public final double getPixelDensity() {
        return this.f11349d;
    }

    public final void setDisableAutoLayout(boolean z10) {
        this.f11348c = z10;
    }

    public final void setEnableInstrumentation(boolean z10) {
        this.f11347b = z10;
    }

    public final void setPixelDensity(double d10) {
        this.f11349d = d10;
    }
}
