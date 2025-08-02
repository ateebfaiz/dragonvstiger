package com.facebook.react.runtime;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.uimanager.events.e;
import com.facebook.react.uimanager.s;
import com.facebook.react.uimanager.t;
import com.facebook.react.uimanager.u;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class ReactSurfaceView extends ReactRootView {

    /* renamed from: a1  reason: collision with root package name */
    private static final a f3417a1 = new a((DefaultConstructorMarker) null);
    private final d1 U0;
    private final u V0 = new u(this);
    private t W0;
    private boolean X0;
    private int Y0;
    private int Z0;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactSurfaceView(Context context, d1 d1Var) {
        super(context);
        m.f(d1Var, "surface");
        this.U0 = d1Var;
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.W0 = new t(this);
        }
    }

    private final Point getViewportOffset() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        iArr[0] = iArr[0] - rect.left;
        iArr[1] = iArr[1] - rect.top;
        return new Point(iArr[0], iArr[1]);
    }

    public void a(View view, MotionEvent motionEvent) {
        t tVar;
        m.f(motionEvent, "ev");
        e h10 = this.U0.h();
        if (h10 != null) {
            this.V0.e(motionEvent, h10);
            if (view != null && (tVar = this.W0) != null) {
                tVar.p(view, motionEvent, h10);
            }
        }
    }

    public void c(View view, MotionEvent motionEvent) {
        m.f(view, "childView");
        m.f(motionEvent, "ev");
        e h10 = this.U0.h();
        if (h10 != null) {
            this.V0.d(motionEvent, h10);
            t tVar = this.W0;
            if (tVar != null) {
                tVar.o();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void f(MotionEvent motionEvent, boolean z10) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (this.W0 != null) {
            e h10 = this.U0.h();
            if (h10 != null) {
                t tVar = this.W0;
                if (tVar != null) {
                    tVar.k(motionEvent, h10, z10);
                    return;
                }
                return;
            }
            z2.a.G("ReactSurfaceView", "Unable to dispatch pointer events to JS as the React instance has not been attached");
        } else if (ReactFeatureFlags.dispatchPointerEvents) {
            z2.a.G("ReactSurfaceView", "Unable to dispatch pointer events to JS before the dispatcher is available");
        }
    }

    /* access modifiers changed from: protected */
    public void g(MotionEvent motionEvent) {
        m.f(motionEvent, NotificationCompat.CATEGORY_EVENT);
        e h10 = this.U0.h();
        if (h10 != null) {
            this.V0.c(motionEvent, h10);
        } else {
            z2.a.G("ReactSurfaceView", "Unable to dispatch touch events to JS as the React instance has not been attached");
        }
    }

    public ReactContext getCurrentReactContext() {
        if (this.U0.n()) {
            return this.U0.k().h0();
        }
        return null;
    }

    public String getJSModuleName() {
        String i10 = this.U0.i();
        m.e(i10, "<get-moduleName>(...)");
        return i10;
    }

    public int getUIManagerType() {
        return 2;
    }

    public boolean h() {
        if (!this.U0.n() || this.U0.k().h0() == null) {
            return false;
        }
        return true;
    }

    public void handleException(Throwable th) {
        m.f(th, "t");
        ReactHostImpl k10 = this.U0.k();
        m.e(k10, "getReactHost(...)");
        String objects = Objects.toString(th.getMessage(), "");
        m.c(objects);
        k10.B0(new s(objects, this, th));
    }

    public boolean i() {
        if (!this.U0.n() || !this.U0.k().D0()) {
            return false;
        }
        return true;
    }

    public boolean n() {
        return this.U0.n();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.X0 && z10) {
            Point viewportOffset = getViewportOffset();
            this.U0.r(this.Y0, this.Z0, viewportOffset.x, viewportOffset.y);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        c8.a.c(0, "ReactSurfaceView.onMeasure");
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int childCount = getChildCount();
            int i14 = 0;
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt = getChildAt(i15);
                i14 = Math.max(i14, childAt.getLeft() + childAt.getMeasuredWidth() + childAt.getPaddingLeft() + childAt.getPaddingRight());
            }
            i12 = i14;
        } else {
            i12 = View.MeasureSpec.getSize(i10);
        }
        int mode2 = View.MeasureSpec.getMode(i11);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int childCount2 = getChildCount();
            int i16 = 0;
            for (int i17 = 0; i17 < childCount2; i17++) {
                View childAt2 = getChildAt(i17);
                i16 = Math.max(i16, childAt2.getTop() + childAt2.getMeasuredHeight() + childAt2.getPaddingTop() + childAt2.getPaddingBottom());
            }
            i13 = i16;
        } else {
            i13 = View.MeasureSpec.getSize(i11);
        }
        setMeasuredDimension(i12, i13);
        this.X0 = true;
        this.Y0 = i10;
        this.Z0 = i11;
        Point viewportOffset = getViewportOffset();
        this.U0.r(i10, i11, viewportOffset.x, viewportOffset.y);
        c8.a.g(0);
    }

    public void requestDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    public void setIsFabric(boolean z10) {
        super.setIsFabric(true);
    }
}
