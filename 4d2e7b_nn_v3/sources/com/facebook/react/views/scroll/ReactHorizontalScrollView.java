package com.facebook.react.views.scroll;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.events.m;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.k0;
import com.facebook.react.uimanager.l0;
import com.facebook.react.uimanager.p0;
import com.facebook.react.views.scroll.a;
import com.facebook.react.views.scroll.d;
import com.facebook.react.views.view.e;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u7.b;

public class ReactHorizontalScrollView extends HorizontalScrollView implements k0, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, p0, d.c, d.e, d.a, d.b, d.C0059d {

    /* renamed from: n1  reason: collision with root package name */
    private static boolean f4065n1 = false;

    /* renamed from: o1  reason: collision with root package name */
    private static String f4066o1 = "ReactHorizontalScrollView";

    /* renamed from: p1  reason: collision with root package name */
    private static int f4067p1 = Integer.MIN_VALUE;

    /* renamed from: q1  reason: collision with root package name */
    private static Field f4068q1;

    /* renamed from: r1  reason: collision with root package name */
    private static boolean f4069r1;
    private boolean C;
    private boolean N0 = true;
    private boolean O0 = false;
    private boolean P0 = false;
    /* access modifiers changed from: private */
    public boolean Q0;
    private String R0;
    private Drawable S0;
    private int T0 = 0;
    private boolean U0 = false;
    private int V0 = 0;
    private List W0;
    private boolean X0 = true;
    private boolean Y0 = true;
    private int Z0 = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f4070a = f4067p1;

    /* renamed from: a1  reason: collision with root package name */
    private e f4071a1 = new e(this);

    /* renamed from: b  reason: collision with root package name */
    private final b f4072b = new b();

    /* renamed from: b1  reason: collision with root package name */
    private boolean f4073b1 = false;

    /* renamed from: c  reason: collision with root package name */
    private final OverScroller f4074c;

    /* renamed from: c1  reason: collision with root package name */
    private int f4075c1 = -1;

    /* renamed from: d  reason: collision with root package name */
    private final g f4076d = new g();

    /* renamed from: d1  reason: collision with root package name */
    private int f4077d1 = -1;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f4078e = new Rect();

    /* renamed from: e1  reason: collision with root package name */
    private d1 f4079e1 = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f4080f;

    /* renamed from: f1  reason: collision with root package name */
    private final d.g f4081f1;

    /* renamed from: g  reason: collision with root package name */
    private Rect f4082g;

    /* renamed from: g1  reason: collision with root package name */
    private final ValueAnimator f4083g1 = ObjectAnimator.ofInt(this, "scrollX", new int[]{0, 0});

    /* renamed from: h  reason: collision with root package name */
    private String f4084h = "hidden";

    /* renamed from: h1  reason: collision with root package name */
    private h0 f4085h1 = h0.AUTO;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4086i;

    /* renamed from: i1  reason: collision with root package name */
    private long f4087i1 = 0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f4088j = false;

    /* renamed from: j1  reason: collision with root package name */
    private int f4089j1 = 0;

    /* renamed from: k1  reason: collision with root package name */
    private View f4090k1;

    /* renamed from: l1  reason: collision with root package name */
    private a f4091l1;

    /* renamed from: m1  reason: collision with root package name */
    private final Rect f4092m1 = new Rect();
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Runnable f4093w;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4094a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f4095b = 0;

        a() {
        }

        public void run() {
            if (ReactHorizontalScrollView.this.f4080f) {
                ReactHorizontalScrollView.this.f4080f = false;
                this.f4095b = 0;
                ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20);
                return;
            }
            d.q(ReactHorizontalScrollView.this);
            int i10 = this.f4095b + 1;
            this.f4095b = i10;
            if (i10 >= 3) {
                ReactHorizontalScrollView.this.f4093w = null;
                if (ReactHorizontalScrollView.this.Q0) {
                    d.h(ReactHorizontalScrollView.this);
                }
                ReactHorizontalScrollView.this.n();
                return;
            }
            if (ReactHorizontalScrollView.this.f4088j && !this.f4094a) {
                this.f4094a = true;
                ReactHorizontalScrollView.this.s(0);
            }
            ViewCompat.postOnAnimationDelayed(ReactHorizontalScrollView.this, this, 20);
        }
    }

    public ReactHorizontalScrollView(Context context, u7.a aVar) {
        super(context);
        ViewCompat.setAccessibilityDelegate(this, new b());
        this.f4074c = getOverScrollerFromParent();
        this.f4081f1 = new d.g(com.facebook.react.modules.i18nmanager.a.f().i(context) ? 1 : 0);
        setOnHierarchyChangeListener(this);
        setClipChildren(false);
        this.f4071a1.k("scroll");
    }

    private boolean B() {
        return false;
    }

    private boolean C(View view) {
        if (v(view) == 0) {
            return true;
        }
        return false;
    }

    private int D(int i10) {
        int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
        if (getFlingAnimator() == this.f4083g1) {
            return d.n(this, i10, 0, max, 0).x;
        }
        return t(i10) + d.k(this, getScrollX(), getReactScrollViewScrollState().b().x, i10);
    }

    private void E(int i10, int i11) {
        if (getFlingAnimator().isRunning()) {
            getFlingAnimator().cancel();
        }
        OverScroller overScroller = this.f4074c;
        if (overScroller != null && !overScroller.isFinished()) {
            int currX = this.f4074c.getCurrX();
            boolean computeScrollOffset = this.f4074c.computeScrollOffset();
            this.f4074c.forceFinished(true);
            if (computeScrollOffset) {
                int i12 = i10;
                this.f4074c.fling(i12, getScrollY(), (int) (this.f4074c.getCurrVelocity() * Math.signum((float) (this.f4074c.getFinalX() - this.f4074c.getStartX()))), 0, 0, i11, 0, 0);
                return;
            }
            scrollTo(i10 + (this.f4074c.getCurrX() - currX), getScrollY());
        }
    }

    private void F(View view) {
        int v10 = v(view);
        if (v10 != 0) {
            scrollBy(v10, 0);
        }
    }

    private void J(int i10, int i11) {
        if (f4065n1) {
            z2.a.r(f4066o1, "setPendingContentOffsets[%d] x %d y %d", Integer.valueOf(getId()), Integer.valueOf(i10), Integer.valueOf(i11));
        }
        if (y()) {
            this.f4075c1 = -1;
            this.f4077d1 = -1;
            return;
        }
        this.f4075c1 = i10;
        this.f4077d1 = i11;
    }

    private void K(int i10) {
        if (f4065n1) {
            z2.a.q(f4066o1, "smoothScrollAndSnap[%d] velocity %d", Integer.valueOf(getId()), Integer.valueOf(i10));
        }
        double snapInterval = (double) getSnapInterval();
        double k10 = (double) d.k(this, getScrollX(), getReactScrollViewScrollState().b().x, i10);
        double d10 = k10 / snapInterval;
        int floor = (int) Math.floor(d10);
        int ceil = (int) Math.ceil(d10);
        int round = (int) Math.round(d10);
        int round2 = (int) Math.round(((double) D(i10)) / snapInterval);
        if (i10 > 0 && ceil == floor) {
            ceil++;
        } else if (i10 < 0 && floor == ceil) {
            floor--;
        }
        if (i10 > 0 && round < ceil && round2 > floor) {
            round = ceil;
        } else if (i10 < 0 && round > floor && round2 < ceil) {
            round = floor;
        }
        double d11 = ((double) round) * snapInterval;
        if (d11 != k10) {
            this.f4080f = true;
            c((int) d11, getScrollY());
        }
    }

    private void L(int i10) {
        int i11;
        if (f4065n1) {
            z2.a.q(f4066o1, "smoothScrollToNextPage[%d] direction %d", Integer.valueOf(getId()), Integer.valueOf(i10));
        }
        int width = getWidth();
        int scrollX = getScrollX();
        int i12 = scrollX / width;
        if (scrollX % width != 0) {
            i12++;
        }
        if (i10 == 17) {
            i11 = i12 - 1;
        } else {
            i11 = i12 + 1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        c(i11 * width, getScrollY());
        x(0, 0);
    }

    private View getContentView() {
        return getChildAt(0);
    }

    @Nullable
    private OverScroller getOverScrollerFromParent() {
        if (!f4069r1) {
            f4069r1 = true;
            try {
                Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
                f4068q1 = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                z2.a.G(f4066o1, "Failed to get mScroller field for HorizontalScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = f4068q1;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            z2.a.G(f4066o1, "Failed to cast mScroller field in HorizontalScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to get mScroller from HorizontalScrollView!", e10);
        }
    }

    private int getSnapInterval() {
        int i10 = this.V0;
        if (i10 != 0) {
            return i10;
        }
        return getWidth();
    }

    private void l(int i10, int i11, int i12, int i13) {
        if (getFlingAnimator().isRunning()) {
            getFlingAnimator().end();
        }
        int i14 = i11 - i10;
        int scrollX = i14 - (i13 - getScrollX());
        scrollTo(scrollX, getScrollY());
        E(scrollX, i14 - getWidth());
    }

    private void m() {
        Runnable runnable = this.f4093w;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f4093w = null;
            getFlingAnimator().cancel();
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (B()) {
            p5.a.c((Object) null);
            p5.a.c(this.R0);
            throw null;
        }
    }

    private void o() {
        if (B()) {
            p5.a.c((Object) null);
            p5.a.c(this.R0);
            throw null;
        }
    }

    private static HorizontalScrollView p(View view, MotionEvent motionEvent) {
        return q(view, motionEvent, true);
    }

    private static HorizontalScrollView q(View view, MotionEvent motionEvent, boolean z10) {
        if (view == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        if (!rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return null;
        }
        if (!z10 && (view instanceof HorizontalScrollView) && ViewCompat.isNestedScrollingEnabled(view) && (view instanceof ReactHorizontalScrollView) && ((ReactHorizontalScrollView) view).N0) {
            return (HorizontalScrollView) view;
        }
        if (view instanceof ViewGroup) {
            int i10 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i10 >= viewGroup.getChildCount()) {
                    break;
                }
                HorizontalScrollView q10 = q(viewGroup.getChildAt(i10), motionEvent, false);
                if (q10 != null) {
                    return q10;
                }
                i10++;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void s(int i10) {
        boolean z10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        OverScroller overScroller;
        int i18;
        int i19;
        if (f4065n1) {
            z2.a.q(f4066o1, "smoothScrollAndSnap[%d] velocityX %d", Integer.valueOf(getId()), Integer.valueOf(i10));
        }
        if (getChildCount() > 0) {
            if (this.V0 == 0 && this.W0 == null && this.Z0 == 0) {
                K(i10);
                return;
            }
            if (getFlingAnimator() != this.f4083g1) {
                z10 = true;
            } else {
                z10 = false;
            }
            int max = Math.max(0, computeHorizontalScrollRange() - getWidth());
            int D = D(i10);
            if (this.U0) {
                D = getScrollX();
            }
            int width = (getWidth() - ViewCompat.getPaddingStart(this)) - ViewCompat.getPaddingEnd(this);
            if (o6.a.d()) {
                i11 = getLayoutDirection();
            } else {
                i11 = this.f4081f1.d();
            }
            if (i11 == 1) {
                D = max - D;
                i12 = -i10;
            } else {
                i12 = i10;
            }
            List list = this.W0;
            if (list == null || list.isEmpty()) {
                int i20 = this.Z0;
                if (i20 != 0) {
                    int i21 = this.V0;
                    if (i21 > 0) {
                        double d10 = ((double) D) / ((double) i21);
                        double floor = Math.floor(d10);
                        int i22 = this.V0;
                        i14 = Math.max(u(i20, (int) (floor * ((double) i22)), i22, width), 0);
                        int i23 = this.Z0;
                        double ceil = Math.ceil(d10);
                        int i24 = this.V0;
                        i13 = Math.min(u(i23, (int) (ceil * ((double) i24)), i24, width), max);
                        i15 = max;
                        i16 = 0;
                    } else {
                        ViewGroup viewGroup = (ViewGroup) getContentView();
                        int i25 = max;
                        int i26 = i25;
                        int i27 = 0;
                        int i28 = 0;
                        for (int i29 = 0; i29 < viewGroup.getChildCount(); i29++) {
                            View childAt = viewGroup.getChildAt(i29);
                            int u10 = u(this.Z0, childAt.getLeft(), childAt.getWidth(), width);
                            if (u10 <= D && D - u10 < D - i27) {
                                i27 = u10;
                            }
                            if (u10 >= D && u10 - D < i26 - D) {
                                i26 = u10;
                            }
                            i25 = Math.min(i25, u10);
                            i28 = Math.max(i28, u10);
                        }
                        int max2 = Math.max(i27, i25);
                        i13 = Math.min(i26, i28);
                        i15 = max;
                        i14 = max2;
                    }
                } else {
                    double snapInterval = (double) getSnapInterval();
                    double d11 = ((double) D) / snapInterval;
                    i14 = (int) (Math.floor(d11) * snapInterval);
                    i13 = Math.min((int) (Math.ceil(d11) * snapInterval), max);
                    i15 = max;
                }
                i16 = 0;
            } else {
                i16 = ((Integer) this.W0.get(0)).intValue();
                List list2 = this.W0;
                i15 = ((Integer) list2.get(list2.size() - 1)).intValue();
                i13 = max;
                i14 = 0;
                for (int i30 = 0; i30 < this.W0.size(); i30++) {
                    int intValue = ((Integer) this.W0.get(i30)).intValue();
                    if (intValue <= D && D - intValue < D - i14) {
                        i14 = intValue;
                    }
                    if (intValue >= D && intValue - D < i13 - D) {
                        i13 = intValue;
                    }
                }
            }
            int i31 = D - i14;
            int i32 = i13 - D;
            if (Math.abs(i31) < Math.abs(i32)) {
                i17 = i14;
            } else {
                i17 = i13;
            }
            int scrollX = getScrollX();
            if (i11 == 1) {
                scrollX = max - scrollX;
            }
            if (this.Y0 || D < i15) {
                if (this.X0 || D > i16) {
                    if (i12 > 0) {
                        if (!z10) {
                            i12 += (int) (((double) i32) * 10.0d);
                        }
                        D = i13;
                    } else if (i12 < 0) {
                        if (!z10) {
                            i12 -= (int) (((double) i31) * 10.0d);
                        }
                        D = i14;
                    } else {
                        D = i17;
                    }
                } else if (scrollX > i16) {
                    D = i16;
                }
            } else if (scrollX < i15) {
                D = i15;
            }
            int min = Math.min(Math.max(0, D), max);
            if (i11 == 1) {
                min = max - min;
                i12 = -i12;
            }
            int i33 = min;
            if (z10 || (overScroller = this.f4074c) == null) {
                c(i33, getScrollY());
                return;
            }
            this.f4080f = true;
            int scrollX2 = getScrollX();
            int scrollY = getScrollY();
            if (i12 != 0) {
                i18 = i12;
            } else {
                i18 = i33 - getScrollX();
            }
            if (i33 == 0 || i33 == max) {
                i19 = width / 2;
            } else {
                i19 = 0;
            }
            overScroller.fling(scrollX2, scrollY, i18, 0, i33, i33, 0, 0, i19, 0);
            postInvalidateOnAnimation();
        }
    }

    private int u(int i10, int i11, int i12, int i13) {
        int i14;
        if (i10 == 1) {
            return i11;
        }
        if (i10 == 2) {
            i14 = (i13 - i12) / 2;
        } else if (i10 == 3) {
            i14 = i13 - i12;
        } else {
            throw new IllegalStateException("Invalid SnapToAlignment value: " + this.Z0);
        }
        return i11 - i14;
    }

    private int v(View view) {
        view.getDrawingRect(this.f4092m1);
        offsetDescendantRectToMyCoords(view, this.f4092m1);
        return computeScrollDeltaToGetChildRectOnScreen(this.f4092m1);
    }

    private void x(int i10, int i11) {
        if (f4065n1) {
            z2.a.r(f4066o1, "handlePostTouchScrolling[%d] velocityX %d velocityY %d", Integer.valueOf(getId()), Integer.valueOf(i10), Integer.valueOf(i11));
        }
        if (this.f4093w == null) {
            if (this.Q0) {
                d.g(this, i10, i11);
            }
            this.f4080f = false;
            a aVar = new a();
            this.f4093w = aVar;
            ViewCompat.postOnAnimationDelayed(this, aVar, 20);
        }
    }

    private boolean y() {
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
            return false;
        }
        return true;
    }

    private boolean z(View view) {
        int v10 = v(view);
        view.getDrawingRect(this.f4092m1);
        if (v10 == 0 || Math.abs(v10) >= this.f4092m1.width() / 2) {
            return false;
        }
        return true;
    }

    public boolean A(View view) {
        int v10 = v(view);
        view.getDrawingRect(this.f4092m1);
        if (v10 == 0 || Math.abs(v10) >= this.f4092m1.width()) {
            return false;
        }
        return true;
    }

    public void G(int i10, float f10, float f11) {
        this.f4071a1.f(i10, f10, f11);
    }

    public void H(float f10, int i10) {
        this.f4071a1.h(f10, i10);
    }

    public void I(int i10, float f10) {
        this.f4071a1.j(i10, f10);
    }

    public void a(int i10, int i11) {
        this.f4083g1.cancel();
        this.f4083g1.setDuration((long) d.j(getContext())).setIntValues(new int[]{i10, i11});
        this.f4083g1.start();
    }

    public void addFocusables(ArrayList arrayList, int i10, int i11) {
        if (!this.f4088j || this.f4073b1) {
            super.addFocusables(arrayList, i10, i11);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        super.addFocusables(arrayList2, i10, i11);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            if (C(view) || A(view) || view.isFocused()) {
                arrayList.add(view);
            }
        }
    }

    public boolean arrowScroll(int i10) {
        if (!this.f4088j) {
            return super.arrowScroll(i10);
        }
        boolean z10 = true;
        this.f4073b1 = true;
        if (getChildCount() > 0) {
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus(), i10);
            View contentView = getContentView();
            if (contentView == null || findNextFocus == null || findNextFocus.getParent() != contentView) {
                L(i10);
            } else {
                if (!C(findNextFocus) && !z(findNextFocus)) {
                    L(i10);
                }
                findNextFocus.requestFocus();
            }
        } else {
            z10 = false;
        }
        this.f4073b1 = false;
        return z10;
    }

    public void b(int i10, int i11) {
        scrollTo(i10, i11);
        E(i10, Integer.MAX_VALUE);
    }

    public void c(int i10, int i11) {
        d.p(this, i10, i11);
        J(i10, i11);
    }

    public boolean canScrollHorizontally(int i10) {
        if (!this.N0 || !super.canScrollHorizontally(i10)) {
            return false;
        }
        return true;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!h0.c(this.f4085h1)) {
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public void draw(Canvas canvas) {
        if (this.T0 != 0) {
            View contentView = getContentView();
            if (!(this.S0 == null || contentView == null || contentView.getRight() >= getWidth())) {
                this.S0.setBounds(contentView.getRight(), 0, getWidth(), getHeight());
                this.S0.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.N0 || (keyCode != 21 && keyCode != 22)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void fling(int i10) {
        if (f4065n1) {
            z2.a.q(f4066o1, "fling[%d] velocityX %d", Integer.valueOf(getId()), Integer.valueOf(i10));
        }
        if (Build.VERSION.SDK_INT == 28) {
            i10 = (int) (((float) Math.abs(i10)) * Math.signum(this.f4072b.a()));
        }
        if (this.f4088j) {
            s(i10);
        } else if (this.f4074c != null) {
            int width = (getWidth() - ViewCompat.getPaddingStart(this)) - ViewCompat.getPaddingEnd(this);
            this.f4074c.fling(getScrollX(), getScrollY(), i10, 0, 0, Integer.MAX_VALUE, 0, 0, width / 2, 0);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            super.fling(i10);
        }
        x(i10, 0);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        rect.set((Rect) p5.a.c(this.f4082g));
    }

    public ValueAnimator getFlingAnimator() {
        return this.f4083g1;
    }

    public long getLastScrollDispatchTime() {
        return this.f4087i1;
    }

    @Nullable
    public String getOverflow() {
        return this.f4084h;
    }

    public Rect getOverflowInset() {
        return this.f4078e;
    }

    public h0 getPointerEvents() {
        return this.f4085h1;
    }

    public d.g getReactScrollViewScrollState() {
        return this.f4081f1;
    }

    public boolean getRemoveClippedSubviews() {
        return this.C;
    }

    public boolean getScrollEnabled() {
        return this.N0;
    }

    public int getScrollEventThrottle() {
        return this.f4089j1;
    }

    @Nullable
    public d1 getStateWrapper() {
        return this.f4079e1;
    }

    public void k() {
        OverScroller overScroller = this.f4074c;
        if (overScroller != null && !overScroller.isFinished()) {
            this.f4074c.abortAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C) {
            updateClippingRect();
        }
        a aVar = this.f4091l1;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void onChildViewAdded(View view, View view2) {
        this.f4090k1 = view2;
        view2.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        View view3 = this.f4090k1;
        if (view3 != null) {
            view3.removeOnLayoutChangeListener(this);
        }
        this.f4090k1 = null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f4091l1;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void onDraw(Canvas canvas) {
        this.f4071a1.d(canvas);
        super.onDraw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.N0) {
            return false;
        }
        if (motionEvent.getAction() == 0 && p(this, motionEvent) != null) {
            return false;
        }
        if (!h0.c(this.f4085h1)) {
            return true;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                w(motionEvent);
                return true;
            }
        } catch (IllegalArgumentException e10) {
            z2.a.H("ReactNative", "Error intercepting touch event.", e10);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        OverScroller overScroller;
        if (f4065n1) {
            z2.a.t(f4066o1, "onLayout[%d] l %d t %d r %d b %d", Integer.valueOf(getId()), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        }
        int i14 = this.f4070a;
        if (!(i14 == f4067p1 || (overScroller = this.f4074c) == null || i14 == overScroller.getFinalX() || this.f4074c.isFinished())) {
            if (f4065n1) {
                z2.a.q(f4066o1, "onLayout[%d] scroll hack enabled: reset to previous scrollX position of %d", Integer.valueOf(getId()), Integer.valueOf(this.f4070a));
            }
            OverScroller overScroller2 = this.f4074c;
            overScroller2.startScroll(this.f4070a, overScroller2.getFinalY(), 0, 0);
            this.f4074c.forceFinished(true);
            this.f4070a = f4067p1;
        }
        if (y()) {
            int i15 = this.f4075c1;
            if (i15 == -1) {
                i15 = getScrollX();
            }
            int i16 = this.f4077d1;
            if (i16 == -1) {
                i16 = getScrollY();
            }
            scrollTo(i15, i16);
        }
        d.a(this);
    }

    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        if (this.f4090k1 != null) {
            if (o6.a.d()) {
                i18 = view.getLayoutDirection();
            } else {
                i18 = this.f4081f1.d();
            }
            if (i18 == 1) {
                l(i10, i12, i14, i16);
                return;
            }
            a aVar = this.f4091l1;
            if (aVar != null) {
                aVar.h();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        OverScroller overScroller;
        a0.a(i10, i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (f4065n1) {
            z2.a.r(f4066o1, "onMeasure[%d] measured width: %d measured height: %d", Integer.valueOf(getId()), Integer.valueOf(size), Integer.valueOf(size2));
        }
        if (getMeasuredHeight() != size2) {
            z10 = true;
        } else {
            z10 = false;
        }
        setMeasuredDimension(size, size2);
        if (z10 && (overScroller = this.f4074c) != null) {
            this.f4070a = overScroller.getCurrX();
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        int max;
        if (f4065n1) {
            z2.a.t(f4066o1, "onOverScrolled[%d] scrollX %d scrollY %d clampedX %b clampedY %b", Integer.valueOf(getId()), Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(z10), Boolean.valueOf(z11));
        }
        OverScroller overScroller = this.f4074c;
        if (overScroller != null && !overScroller.isFinished() && this.f4074c.getCurrX() != this.f4074c.getFinalX() && i10 >= (max = Math.max(computeHorizontalScrollRange() - getWidth(), 0))) {
            this.f4074c.abortAnimation();
            i10 = max;
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        if (f4065n1) {
            z2.a.t(f4066o1, "onScrollChanged[%d] x %d y %d oldx %d oldy %d", Integer.valueOf(getId()), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
        }
        super.onScrollChanged(i10, i11, i12, i13);
        this.f4080f = true;
        if (this.f4072b.c(i10, i11)) {
            if (this.C) {
                updateClippingRect();
            }
            if (!this.O0) {
                this.O0 = true;
                d.s(this, this.f4072b.a(), this.f4072b.b(), this.P0);
                this.O0 = false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (this.C) {
            updateClippingRect();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.N0 || !h0.b(this.f4085h1)) {
            return false;
        }
        this.f4076d.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 && this.f4086i) {
            d.q(this);
            float b10 = this.f4076d.b();
            float c10 = this.f4076d.c();
            d.c(this, b10, c10);
            m.a(this, motionEvent);
            this.f4086i = false;
            x(Math.round(b10), Math.round(c10));
        }
        if (actionMasked == 0) {
            m();
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean pageScroll(int i10) {
        boolean pageScroll = super.pageScroll(i10);
        if (this.f4088j && pageScroll) {
            x(0, 0);
        }
        return pageScroll;
    }

    public void r() {
        awakenScrollBars();
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null && !this.f4088j) {
            F(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void scrollTo(int i10, int i11) {
        if (f4065n1) {
            z2.a.r(f4066o1, "scrollTo[%d] x %d y %d", Integer.valueOf(getId()), Integer.valueOf(i10), Integer.valueOf(i11));
        }
        super.scrollTo(i10, i11);
        d.q(this);
        J(i10, i11);
    }

    public void setBackgroundColor(int i10) {
        this.f4071a1.e(i10);
    }

    public void setBorderRadius(float f10) {
        this.f4071a1.g(f10);
    }

    public void setBorderStyle(@Nullable String str) {
        this.f4071a1.i(str);
    }

    public void setDecelerationRate(float f10) {
        getReactScrollViewScrollState().i(f10);
        OverScroller overScroller = this.f4074c;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f10);
        }
    }

    public void setDisableIntervalMomentum(boolean z10) {
        this.U0 = z10;
    }

    public void setEnableSyncOnScroll(boolean z10) {
        this.P0 = z10;
    }

    public void setEndFillColor(int i10) {
        if (i10 != this.T0) {
            this.T0 = i10;
            this.S0 = new ColorDrawable(this.T0);
        }
    }

    public void setLastScrollDispatchTime(long j10) {
        this.f4087i1 = j10;
    }

    public void setMaintainVisibleContentPosition(@Nullable a.b bVar) {
        a aVar;
        if (bVar != null && this.f4091l1 == null) {
            a aVar2 = new a(this, true);
            this.f4091l1 = aVar2;
            aVar2.f();
        } else if (bVar == null && (aVar = this.f4091l1) != null) {
            aVar.g();
            this.f4091l1 = null;
        }
        a aVar3 = this.f4091l1;
        if (aVar3 != null) {
            aVar3.e(bVar);
        }
    }

    public void setOverflow(@Nullable String str) {
        this.f4084h = str;
        e eVar = this.f4071a1;
        if (str == null) {
            str = "scroll";
        }
        eVar.k(str);
    }

    public void setOverflowInset(int i10, int i11, int i12, int i13) {
        this.f4078e.set(i10, i11, i12, i13);
    }

    public void setPagingEnabled(boolean z10) {
        this.f4088j = z10;
    }

    public void setPointerEvents(h0 h0Var) {
        this.f4085h1 = h0Var;
    }

    public void setRemoveClippedSubviews(boolean z10) {
        if (z10 && this.f4082g == null) {
            this.f4082g = new Rect();
        }
        this.C = z10;
        updateClippingRect();
    }

    public void setScrollEnabled(boolean z10) {
        this.N0 = z10;
    }

    public void setScrollEventThrottle(int i10) {
        this.f4089j1 = i10;
    }

    public void setScrollPerfTag(@Nullable String str) {
        this.R0 = str;
    }

    public void setSendMomentumEvents(boolean z10) {
        this.Q0 = z10;
    }

    public void setSnapInterval(int i10) {
        this.V0 = i10;
    }

    public void setSnapOffsets(@Nullable List<Integer> list) {
        this.W0 = list;
    }

    public void setSnapToAlignment(int i10) {
        this.Z0 = i10;
    }

    public void setSnapToEnd(boolean z10) {
        this.Y0 = z10;
    }

    public void setSnapToStart(boolean z10) {
        this.X0 = z10;
    }

    public void setStateWrapper(d1 d1Var) {
        this.f4079e1 = d1Var;
    }

    public int t(int i10) {
        return d.n(this, i10, 0, Math.max(0, computeHorizontalScrollRange() - getWidth()), 0).x;
    }

    public void updateClippingRect() {
        if (this.C) {
            p5.a.c(this.f4082g);
            l0.a(this, this.f4082g);
            View contentView = getContentView();
            if (contentView instanceof k0) {
                ((k0) contentView).updateClippingRect();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void w(MotionEvent motionEvent) {
        m.b(this, motionEvent);
        d.b(this);
        this.f4086i = true;
        o();
        getFlingAnimator().cancel();
    }
}
