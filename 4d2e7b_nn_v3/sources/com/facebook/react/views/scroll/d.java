package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.k1;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.jvm.internal.m;
import kotlin.text.j;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f4139a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final String f4140b = ReactHorizontalScrollView.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f4141c = false;

    /* renamed from: d  reason: collision with root package name */
    private static final Set f4142d = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: e  reason: collision with root package name */
    private static int f4143e = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f4144f;

    public interface a {
        void a(int i10, int i11);

        ValueAnimator getFlingAnimator();
    }

    public interface b {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j10);
    }

    public interface c {
        g getReactScrollViewScrollState();
    }

    /* renamed from: com.facebook.react.views.scroll.d$d  reason: collision with other inner class name */
    public interface C0059d {
        void b(int i10, int i11);

        void c(int i10, int i11);
    }

    public interface e {
        d1 getStateWrapper();
    }

    private static final class f extends OverScroller {

        /* renamed from: a  reason: collision with root package name */
        private int f4145a = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

        public f(Context context) {
            super(context);
        }

        public final int a() {
            super.startScroll(0, 0, 0, 0);
            return this.f4145a;
        }

        public void startScroll(int i10, int i11, int i12, int i13, int i14) {
            this.f4145a = i14;
        }
    }

    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final int f4146a;

        /* renamed from: b  reason: collision with root package name */
        private final Point f4147b = new Point();

        /* renamed from: c  reason: collision with root package name */
        private int f4148c;

        /* renamed from: d  reason: collision with root package name */
        private final Point f4149d = new Point(-1, -1);

        /* renamed from: e  reason: collision with root package name */
        private boolean f4150e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4151f = true;

        /* renamed from: g  reason: collision with root package name */
        private float f4152g = 0.985f;

        public g(int i10) {
            this.f4146a = i10;
        }

        public final float a() {
            return this.f4152g;
        }

        public final Point b() {
            return this.f4147b;
        }

        public final Point c() {
            return this.f4149d;
        }

        public final int d() {
            return this.f4146a;
        }

        public final int e() {
            return this.f4148c;
        }

        public final boolean f() {
            return this.f4150e;
        }

        public final boolean g() {
            return this.f4151f;
        }

        public final void h(boolean z10) {
            this.f4150e = z10;
        }

        public final void i(float f10) {
            this.f4152g = f10;
        }

        public final g j(int i10, int i11) {
            this.f4147b.set(i10, i11);
            return this;
        }

        public final void k(boolean z10) {
            this.f4151f = z10;
        }

        public final g l(int i10, int i11) {
            this.f4149d.set(i10, i11);
            return this;
        }

        public final void m(int i10) {
            this.f4148c = i10;
        }
    }

    public static final class h implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f4153a;

        h(ViewGroup viewGroup) {
            this.f4153a = viewGroup;
        }

        public void onAnimationCancel(Animator animator) {
            m.f(animator, "animator");
            ((c) this.f4153a).getReactScrollViewScrollState().h(true);
        }

        public void onAnimationEnd(Animator animator) {
            m.f(animator, "animator");
            ((c) this.f4153a).getReactScrollViewScrollState().k(true);
            d.q(this.f4153a);
        }

        public void onAnimationRepeat(Animator animator) {
            m.f(animator, "animator");
        }

        public void onAnimationStart(Animator animator) {
            m.f(animator, "animator");
            g reactScrollViewScrollState = ((c) this.f4153a).getReactScrollViewScrollState();
            reactScrollViewScrollState.h(false);
            reactScrollViewScrollState.k(false);
        }
    }

    private d() {
    }

    public static final void a(ViewGroup viewGroup) {
        m.f(viewGroup, "scrollView");
        Iterator it = f4142d.iterator();
        if (it.hasNext()) {
            c.d.a(it.next());
            throw null;
        }
    }

    public static final void b(ViewGroup viewGroup) {
        f4139a.d(viewGroup, f.BEGIN_DRAG);
    }

    public static final void c(ViewGroup viewGroup, float f10, float f11) {
        f(f4139a, viewGroup, f.END_DRAG, f10, f11, false, 16, (Object) null);
    }

    private final void d(ViewGroup viewGroup, f fVar) {
        f(this, viewGroup, fVar, 0.0f, 0.0f, false, 16, (Object) null);
    }

    private final void e(ViewGroup viewGroup, f fVar, float f10, float f11, boolean z10) {
        View childAt;
        ViewGroup viewGroup2 = viewGroup;
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = (b) viewGroup2;
        if (((long) bVar.getScrollEventThrottle()) < Math.max(17, currentTimeMillis - bVar.getLastScrollDispatchTime()) && (childAt = viewGroup2.getChildAt(0)) != null) {
            Iterator it = f4142d.iterator();
            if (!it.hasNext()) {
                Context context = viewGroup.getContext();
                m.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                ReactContext reactContext = (ReactContext) context;
                int e10 = k1.e(reactContext);
                com.facebook.react.uimanager.events.e c10 = k1.c(reactContext, viewGroup.getId());
                if (c10 != null) {
                    c10.c(e.f4154k.a(e10, viewGroup.getId(), fVar, (float) viewGroup.getScrollX(), (float) viewGroup.getScrollY(), f10, f11, childAt.getWidth(), childAt.getHeight(), viewGroup.getWidth(), viewGroup.getHeight(), z10));
                    ((b) viewGroup2).setLastScrollDispatchTime(currentTimeMillis);
                    return;
                }
                return;
            }
            c.d.a(it.next());
            throw null;
        }
    }

    static /* synthetic */ void f(d dVar, ViewGroup viewGroup, f fVar, float f10, float f11, boolean z10, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        dVar.e(viewGroup, fVar, f10, f11, z10);
    }

    public static final void g(ViewGroup viewGroup, int i10, int i11) {
        f(f4139a, viewGroup, f.MOMENTUM_BEGIN, (float) i10, (float) i11, false, 16, (Object) null);
    }

    public static final void h(ViewGroup viewGroup) {
        f4139a.d(viewGroup, f.MOMENTUM_END);
    }

    public static final void i(ViewGroup viewGroup) {
        int i10;
        g reactScrollViewScrollState = ((c) viewGroup).getReactScrollViewScrollState();
        int e10 = reactScrollViewScrollState.e();
        Point c10 = reactScrollViewScrollState.c();
        int i11 = c10.x;
        int i12 = c10.y;
        if (reactScrollViewScrollState.d() == 1) {
            int i13 = 0;
            View childAt = viewGroup.getChildAt(0);
            if (childAt != null) {
                i13 = childAt.getWidth();
            }
            i10 = -((i13 - i11) - viewGroup.getWidth());
        } else {
            i10 = i11;
        }
        if (f4141c) {
            z2.a.s(f4140b, "updateFabricScrollState[%d] scrollX %d scrollY %d fabricScrollX", Integer.valueOf(viewGroup.getId()), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i10));
        }
        d1 stateWrapper = ((e) viewGroup).getStateWrapper();
        if (stateWrapper != null) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putDouble("contentOffsetLeft", (double) g0.b((float) i11));
            writableNativeMap.putDouble("contentOffsetTop", (double) g0.b((float) i12));
            writableNativeMap.putDouble("scrollAwayPaddingTop", (double) g0.b((float) e10));
            stateWrapper.updateState(writableNativeMap);
        }
    }

    public static final int j(Context context) {
        if (!f4144f) {
            f4144f = true;
            try {
                f4143e = new f(context).a();
            } catch (Throwable unused) {
            }
        }
        return f4143e;
    }

    public static final int k(ViewGroup viewGroup, int i10, int i11, int i12) {
        int i13;
        g reactScrollViewScrollState = ((c) viewGroup).getReactScrollViewScrollState();
        boolean z10 = false;
        if (i12 != 0) {
            i13 = i12 / Math.abs(i12);
        } else {
            i13 = 0;
        }
        if (i13 * (i11 - i10) > 0) {
            z10 = true;
        }
        if (!reactScrollViewScrollState.g() || (reactScrollViewScrollState.f() && z10)) {
            return i11;
        }
        return i10;
    }

    public static final int l(String str) {
        if (str == null) {
            return 1;
        }
        int hashCode = str.hashCode();
        if (hashCode != -1414557169) {
            if (hashCode != 3005871) {
                if (hashCode == 104712844 && str.equals("never")) {
                    return 2;
                }
            } else if (str.equals("auto")) {
                return 1;
            }
        } else if (str.equals("always")) {
            return 0;
        }
        z2.a.G("ReactNative", "wrong overScrollMode: " + str);
        return 1;
    }

    public static final int m(String str) {
        if (str == null) {
            return 0;
        }
        if (j.q("start", str, true)) {
            return 1;
        }
        if (j.q("center", str, true)) {
            return 2;
        }
        if (m.b("end", str)) {
            return 3;
        }
        z2.a.G("ReactNative", "wrong snap alignment value: " + str);
        return 0;
    }

    public static final Point n(ViewGroup viewGroup, int i10, int i11, int i12, int i13) {
        g reactScrollViewScrollState = ((c) viewGroup).getReactScrollViewScrollState();
        OverScroller overScroller = new OverScroller(viewGroup.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.a());
        int width = (viewGroup.getWidth() - ViewCompat.getPaddingStart(viewGroup)) - ViewCompat.getPaddingEnd(viewGroup);
        int height = (viewGroup.getHeight() - viewGroup.getPaddingBottom()) - viewGroup.getPaddingTop();
        Point b10 = reactScrollViewScrollState.b();
        int i14 = i10;
        overScroller.fling(k(viewGroup, viewGroup.getScrollX(), b10.x, i10), k(viewGroup, viewGroup.getScrollY(), b10.y, i11), i10, i11, 0, i12, 0, i13, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }

    public static final void p(ViewGroup viewGroup, int i10, int i11) {
        if (f4141c) {
            z2.a.r(f4140b, "smoothScrollTo[%d] x %d y %d", Integer.valueOf(viewGroup.getId()), Integer.valueOf(i10), Integer.valueOf(i11));
        }
        ValueAnimator flingAnimator = ((a) viewGroup).getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            f4139a.o(viewGroup);
        }
        ((c) viewGroup).getReactScrollViewScrollState().j(i10, i11);
        int scrollX = viewGroup.getScrollX();
        int scrollY = viewGroup.getScrollY();
        if (scrollX != i10) {
            ((a) viewGroup).a(scrollX, i10);
        }
        if (scrollY != i11) {
            ((a) viewGroup).a(scrollY, i11);
        }
        f4139a.r(viewGroup, i10, i11);
    }

    public static final void q(ViewGroup viewGroup) {
        f4139a.r(viewGroup, viewGroup.getScrollX(), viewGroup.getScrollY());
    }

    public static final void s(ViewGroup viewGroup, float f10, float f11, boolean z10) {
        q(viewGroup);
        f4139a.e(viewGroup, f.SCROLL, f10, f11, z10);
    }

    public final void o(ViewGroup viewGroup) {
        ((a) viewGroup).getFlingAnimator().addListener(new h(viewGroup));
    }

    public final void r(ViewGroup viewGroup, int i10, int i11) {
        if (f4141c) {
            z2.a.r(f4140b, "updateFabricScrollState[%d] scrollX %d scrollY %d", Integer.valueOf(viewGroup.getId()), Integer.valueOf(i10), Integer.valueOf(i11));
        }
        if (i7.a.a(viewGroup.getId()) != 1) {
            g reactScrollViewScrollState = ((c) viewGroup).getReactScrollViewScrollState();
            if (!reactScrollViewScrollState.c().equals(i10, i11)) {
                reactScrollViewScrollState.l(i10, i11);
                i(viewGroup);
            }
        }
    }
}
