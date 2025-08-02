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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.m;
import com.facebook.react.uimanager.a0;
import com.facebook.react.uimanager.d1;
import com.facebook.react.uimanager.g0;
import com.facebook.react.uimanager.h0;
import com.facebook.react.uimanager.k0;
import com.facebook.react.uimanager.l0;
import com.facebook.react.uimanager.p0;
import com.facebook.react.views.scroll.a;
import com.facebook.react.views.scroll.d;
import com.facebook.react.views.view.e;
import com.google.android.games.paddleboat.GameControllerManager;
import java.lang.reflect.Field;
import java.util.List;
import u7.b;

public class ReactScrollView extends ScrollView implements k0, ViewGroup.OnHierarchyChangeListener, View.OnLayoutChangeListener, p0, d.c, d.e, d.a, d.b, d.C0059d {

    /* renamed from: m1  reason: collision with root package name */
    private static Field f4097m1;

    /* renamed from: n1  reason: collision with root package name */
    private static boolean f4098n1;
    private boolean C;
    private boolean N0 = true;
    private boolean O0 = false;
    /* access modifiers changed from: private */
    public boolean P0;
    private String Q0;
    private boolean R0 = false;
    private Drawable S0;
    private int T0 = 0;
    private boolean U0 = false;
    private int V0 = 0;
    private List W0;
    private boolean X0 = true;
    private boolean Y0 = true;
    private int Z0 = 0;

    /* renamed from: a  reason: collision with root package name */
    private final b f4099a = new b();

    /* renamed from: a1  reason: collision with root package name */
    private View f4100a1;

    /* renamed from: b  reason: collision with root package name */
    private final OverScroller f4101b = getOverScrollerFromParent();

    /* renamed from: b1  reason: collision with root package name */
    private e f4102b1 = new e(this);

    /* renamed from: c  reason: collision with root package name */
    private final g f4103c = new g();

    /* renamed from: c1  reason: collision with root package name */
    private ReadableMap f4104c1 = null;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4105d = new Rect();

    /* renamed from: d1  reason: collision with root package name */
    private int f4106d1 = -1;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f4107e = new Rect();

    /* renamed from: e1  reason: collision with root package name */
    private int f4108e1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f4109f;

    /* renamed from: f1  reason: collision with root package name */
    private d1 f4110f1 = null;

    /* renamed from: g  reason: collision with root package name */
    private Rect f4111g;

    /* renamed from: g1  reason: collision with root package name */
    private final d.g f4112g1 = new d.g(0);

    /* renamed from: h  reason: collision with root package name */
    private String f4113h = "hidden";

    /* renamed from: h1  reason: collision with root package name */
    private final ValueAnimator f4114h1 = ObjectAnimator.ofInt(this, "scrollY", new int[]{0, 0});

    /* renamed from: i  reason: collision with root package name */
    private boolean f4115i;

    /* renamed from: i1  reason: collision with root package name */
    private h0 f4116i1 = h0.AUTO;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f4117j = false;

    /* renamed from: j1  reason: collision with root package name */
    private long f4118j1 = 0;

    /* renamed from: k1  reason: collision with root package name */
    private int f4119k1 = 0;

    /* renamed from: l1  reason: collision with root package name */
    private a f4120l1 = null;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Runnable f4121w;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4122a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f4123b = 0;

        a() {
        }

        public void run() {
            if (ReactScrollView.this.f4109f) {
                ReactScrollView.this.f4109f = false;
                this.f4123b = 0;
                ViewCompat.postOnAnimationDelayed(ReactScrollView.this, this, 20);
                return;
            }
            d.q(ReactScrollView.this);
            int i10 = this.f4123b + 1;
            this.f4123b = i10;
            if (i10 >= 3) {
                ReactScrollView.this.f4121w = null;
                if (ReactScrollView.this.P0) {
                    d.h(ReactScrollView.this);
                }
                ReactScrollView.this.n();
                return;
            }
            if (ReactScrollView.this.f4117j && !this.f4122a) {
                this.f4122a = true;
                ReactScrollView.this.q(0);
            }
            ViewCompat.postOnAnimationDelayed(ReactScrollView.this, this, 20);
        }
    }

    public ReactScrollView(Context context, u7.a aVar) {
        super(context);
        setOnHierarchyChangeListener(this);
        setScrollBarStyle(GameControllerManager.DEVICEFLAG_LIGHT_RGB);
        setClipChildren(false);
        this.f4102b1.k("scroll");
        ViewCompat.setAccessibilityDelegate(this, new b());
    }

    private void A(int i10) {
        if (getFlingAnimator().isRunning()) {
            getFlingAnimator().cancel();
        }
        OverScroller overScroller = this.f4101b;
        if (overScroller != null && !overScroller.isFinished()) {
            int currY = this.f4101b.getCurrY();
            boolean computeScrollOffset = this.f4101b.computeScrollOffset();
            this.f4101b.forceFinished(true);
            if (computeScrollOffset) {
                int i11 = i10;
                this.f4101b.fling(getScrollX(), i11, 0, (int) (this.f4101b.getCurrVelocity() * Math.signum((float) (this.f4101b.getFinalY() - this.f4101b.getStartY()))), 0, 0, 0, Integer.MAX_VALUE);
                return;
            }
            scrollTo(getScrollX(), i10 + (this.f4101b.getCurrX() - currY));
        }
    }

    private void B(View view) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private void F(int i10, int i11) {
        if (w()) {
            this.f4106d1 = -1;
            this.f4108e1 = -1;
            return;
        }
        this.f4106d1 = i10;
        this.f4108e1 = i11;
    }

    private void G(int i10) {
        double snapInterval = (double) getSnapInterval();
        double k10 = (double) d.k(this, getScrollY(), getReactScrollViewScrollState().b().y, i10);
        double d10 = k10 / snapInterval;
        int floor = (int) Math.floor(d10);
        int ceil = (int) Math.ceil(d10);
        int round = (int) Math.round(d10);
        int round2 = (int) Math.round(((double) z(i10)) / snapInterval);
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
            this.f4109f = true;
            c(getScrollX(), (int) d11);
        }
    }

    private void H(int i10) {
        getReactScrollViewScrollState().m(i10);
        d.i(this);
    }

    private View getContentView() {
        return getChildAt(0);
    }

    private int getMaxScrollY() {
        int i10;
        View view = this.f4100a1;
        if (view == null) {
            i10 = 0;
        } else {
            i10 = view.getHeight();
        }
        return Math.max(0, i10 - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
    }

    @Nullable
    private OverScroller getOverScrollerFromParent() {
        if (!f4098n1) {
            f4098n1 = true;
            try {
                Field declaredField = ScrollView.class.getDeclaredField("mScroller");
                f4097m1 = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                z2.a.G("ReactNative", "Failed to get mScroller field for ScrollView! This app will exhibit the bounce-back scrolling bug :(");
            }
        }
        Field field = f4097m1;
        if (field == null) {
            return null;
        }
        try {
            Object obj = field.get(this);
            if (obj instanceof OverScroller) {
                return (OverScroller) obj;
            }
            z2.a.G("ReactNative", "Failed to cast mScroller field in ScrollView (probably due to OEM changes to AOSP)! This app will exhibit the bounce-back scrolling bug :(");
            return null;
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Failed to get mScroller from ScrollView!", e10);
        }
    }

    private int getSnapInterval() {
        int i10 = this.V0;
        if (i10 != 0) {
            return i10;
        }
        return getHeight();
    }

    private void l() {
        Runnable runnable = this.f4121w;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f4121w = null;
            getFlingAnimator().cancel();
        }
    }

    private int m(int i10) {
        if (Build.VERSION.SDK_INT != 28) {
            return i10;
        }
        float signum = Math.signum(this.f4099a.b());
        if (signum == 0.0f) {
            signum = Math.signum((float) i10);
        }
        return (int) (((float) Math.abs(i10)) * signum);
    }

    /* access modifiers changed from: private */
    public void n() {
        if (y()) {
            p5.a.c((Object) null);
            p5.a.c(this.Q0);
            throw null;
        }
    }

    private void o() {
        if (y()) {
            p5.a.c((Object) null);
            p5.a.c(this.Q0);
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(int r28) {
        /*
            r27 = this;
            r0 = r27
            int r1 = r27.getChildCount()
            if (r1 > 0) goto L_0x0009
            return
        L_0x0009:
            int r1 = r0.V0
            if (r1 != 0) goto L_0x0019
            java.util.List r1 = r0.W0
            if (r1 != 0) goto L_0x0019
            int r1 = r0.Z0
            if (r1 != 0) goto L_0x0019
            r27.G(r28)
            return
        L_0x0019:
            android.animation.ValueAnimator r1 = r27.getFlingAnimator()
            android.animation.ValueAnimator r2 = r0.f4114h1
            r3 = 1
            r4 = 0
            if (r1 == r2) goto L_0x0025
            r1 = r3
            goto L_0x0026
        L_0x0025:
            r1 = r4
        L_0x0026:
            int r2 = r27.getMaxScrollY()
            int r5 = r27.z(r28)
            boolean r6 = r0.U0
            if (r6 == 0) goto L_0x0036
            int r5 = r27.getScrollY()
        L_0x0036:
            int r6 = r27.getHeight()
            int r7 = r27.getPaddingBottom()
            int r6 = r6 - r7
            int r7 = r27.getPaddingTop()
            int r6 = r6 - r7
            java.util.List r7 = r0.W0
            r8 = 2
            if (r7 == 0) goto L_0x0090
            java.lang.Object r7 = r7.get(r4)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.util.List r9 = r0.W0
            int r10 = r9.size()
            int r10 = r10 - r3
            java.lang.Object r9 = r9.get(r10)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r12 = r2
            r10 = r4
            r11 = r10
        L_0x0067:
            java.util.List r13 = r0.W0
            int r13 = r13.size()
            if (r10 >= r13) goto L_0x015a
            java.util.List r13 = r0.W0
            java.lang.Object r13 = r13.get(r10)
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r13 > r5) goto L_0x0084
            int r14 = r5 - r13
            int r15 = r5 - r11
            if (r14 >= r15) goto L_0x0084
            r11 = r13
        L_0x0084:
            if (r13 < r5) goto L_0x008d
            int r14 = r13 - r5
            int r15 = r12 - r5
            if (r14 >= r15) goto L_0x008d
            r12 = r13
        L_0x008d:
            int r10 = r10 + 1
            goto L_0x0067
        L_0x0090:
            int r7 = r0.Z0
            if (r7 == 0) goto L_0x013f
            int r9 = r0.V0
            if (r9 <= 0) goto L_0x00c4
            double r10 = (double) r5
            double r12 = (double) r9
            double r10 = r10 / r12
            double r12 = java.lang.Math.floor(r10)
            int r9 = r0.V0
            double r14 = (double) r9
            double r12 = r12 * r14
            int r12 = (int) r12
            int r7 = r0.s(r7, r12, r9, r6)
            int r7 = java.lang.Math.max(r7, r4)
            int r9 = r0.Z0
            double r10 = java.lang.Math.ceil(r10)
            int r12 = r0.V0
            double r13 = (double) r12
            double r10 = r10 * r13
            int r10 = (int) r10
            int r9 = r0.s(r9, r10, r12, r6)
            int r12 = java.lang.Math.min(r9, r2)
            r9 = r2
            r11 = r7
        L_0x00c1:
            r7 = r4
            goto L_0x015a
        L_0x00c4:
            android.view.View r7 = r27.getContentView()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r11 = r2
            r12 = r11
            r9 = r4
            r10 = r9
            r13 = r10
        L_0x00cf:
            int r14 = r7.getChildCount()
            if (r9 >= r14) goto L_0x0135
            android.view.View r14 = r7.getChildAt(r9)
            int r15 = r0.Z0
            if (r15 == r3) goto L_0x0113
            if (r15 == r8) goto L_0x0107
            r3 = 3
            if (r15 != r3) goto L_0x00ee
            int r3 = r14.getTop()
            int r14 = r14.getHeight()
            int r14 = r6 - r14
        L_0x00ec:
            int r3 = r3 - r14
            goto L_0x0117
        L_0x00ee:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid SnapToAlignment value: "
            r2.append(r3)
            int r3 = r0.Z0
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0107:
            int r3 = r14.getTop()
            int r14 = r14.getHeight()
            int r14 = r6 - r14
            int r14 = r14 / r8
            goto L_0x00ec
        L_0x0113:
            int r3 = r14.getTop()
        L_0x0117:
            if (r3 > r5) goto L_0x0120
            int r14 = r5 - r3
            int r15 = r5 - r10
            if (r14 >= r15) goto L_0x0120
            r10 = r3
        L_0x0120:
            if (r3 < r5) goto L_0x0129
            int r14 = r3 - r5
            int r15 = r12 - r5
            if (r14 >= r15) goto L_0x0129
            r12 = r3
        L_0x0129:
            int r11 = java.lang.Math.min(r11, r3)
            int r13 = java.lang.Math.max(r13, r3)
            int r9 = r9 + 1
            r3 = 1
            goto L_0x00cf
        L_0x0135:
            int r11 = java.lang.Math.max(r10, r11)
            int r12 = java.lang.Math.min(r12, r13)
            r9 = r2
            goto L_0x00c1
        L_0x013f:
            int r3 = r27.getSnapInterval()
            double r9 = (double) r3
            double r11 = (double) r5
            double r11 = r11 / r9
            double r13 = java.lang.Math.floor(r11)
            double r13 = r13 * r9
            int r3 = (int) r13
            double r11 = java.lang.Math.ceil(r11)
            double r11 = r11 * r9
            int r7 = (int) r11
            int r12 = java.lang.Math.min(r7, r2)
            r9 = r2
            r11 = r3
            goto L_0x00c1
        L_0x015a:
            int r3 = r5 - r11
            int r10 = java.lang.Math.abs(r3)
            int r13 = r12 - r5
            int r14 = java.lang.Math.abs(r13)
            if (r10 >= r14) goto L_0x016a
            r10 = r11
            goto L_0x016b
        L_0x016a:
            r10 = r12
        L_0x016b:
            boolean r14 = r0.Y0
            if (r14 != 0) goto L_0x017c
            if (r5 < r9) goto L_0x017c
            int r3 = r27.getScrollY()
            if (r3 < r9) goto L_0x0178
            goto L_0x0188
        L_0x0178:
            r3 = r28
            r5 = r9
            goto L_0x01b0
        L_0x017c:
            boolean r9 = r0.X0
            if (r9 != 0) goto L_0x018f
            if (r5 > r7) goto L_0x018f
            int r3 = r27.getScrollY()
            if (r3 > r7) goto L_0x018b
        L_0x0188:
            r3 = r28
            goto L_0x01b0
        L_0x018b:
            r3 = r28
            r5 = r7
            goto L_0x01b0
        L_0x018f:
            r14 = 4621819117588971520(0x4024000000000000, double:10.0)
            if (r28 <= 0) goto L_0x019f
            if (r1 != 0) goto L_0x019b
            double r9 = (double) r13
            double r9 = r9 * r14
            int r3 = (int) r9
            int r3 = r28 + r3
            goto L_0x019d
        L_0x019b:
            r3 = r28
        L_0x019d:
            r5 = r12
            goto L_0x01b0
        L_0x019f:
            if (r28 >= 0) goto L_0x01ad
            if (r1 != 0) goto L_0x01a9
            double r9 = (double) r3
            double r9 = r9 * r14
            int r3 = (int) r9
            int r3 = r28 - r3
            goto L_0x01ab
        L_0x01a9:
            r3 = r28
        L_0x01ab:
            r5 = r11
            goto L_0x01b0
        L_0x01ad:
            r3 = r28
            r5 = r10
        L_0x01b0:
            int r5 = java.lang.Math.max(r4, r5)
            int r5 = java.lang.Math.min(r5, r2)
            if (r1 != 0) goto L_0x01f6
            android.widget.OverScroller r1 = r0.f4101b
            if (r1 != 0) goto L_0x01bf
            goto L_0x01f6
        L_0x01bf:
            r7 = 1
            r0.f4109f = r7
            int r17 = r27.getScrollX()
            int r18 = r27.getScrollY()
            if (r3 == 0) goto L_0x01cf
        L_0x01cc:
            r20 = r3
            goto L_0x01d6
        L_0x01cf:
            int r3 = r27.getScrollY()
            int r3 = r5 - r3
            goto L_0x01cc
        L_0x01d6:
            if (r5 == 0) goto L_0x01de
            if (r5 != r2) goto L_0x01db
            goto L_0x01de
        L_0x01db:
            r26 = r4
            goto L_0x01e1
        L_0x01de:
            int r4 = r6 / 2
            goto L_0x01db
        L_0x01e1:
            r19 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r16 = r1
            r23 = r5
            r24 = r5
            r16.fling(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r27.postInvalidateOnAnimation()
            goto L_0x01fd
        L_0x01f6:
            int r1 = r27.getScrollX()
            r0.c(r1, r5)
        L_0x01fd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.scroll.ReactScrollView.q(int):void");
    }

    private int s(int i10, int i11, int i12, int i13) {
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

    private int t(View view) {
        view.getDrawingRect(this.f4105d);
        offsetDescendantRectToMyCoords(view, this.f4105d);
        return computeScrollDeltaToGetChildRectOnScreen(this.f4105d);
    }

    private void v(int i10, int i11) {
        if (this.f4121w == null) {
            if (this.P0) {
                o();
                d.g(this, i10, i11);
            }
            this.f4109f = false;
            a aVar = new a();
            this.f4121w = aVar;
            ViewCompat.postOnAnimationDelayed(this, aVar, 20);
        }
    }

    private boolean w() {
        View contentView = getContentView();
        if (contentView == null || contentView.getWidth() == 0 || contentView.getHeight() == 0) {
            return false;
        }
        return true;
    }

    private boolean y() {
        return false;
    }

    private int z(int i10) {
        if (getFlingAnimator() == this.f4114h1) {
            return d.n(this, 0, i10, 0, getMaxScrollY()).y;
        }
        return r(i10) + d.k(this, getScrollY(), getReactScrollViewScrollState().b().y, i10);
    }

    public void C(int i10, float f10, float f11) {
        this.f4102b1.f(i10, f10, f11);
    }

    public void D(float f10, int i10) {
        this.f4102b1.h(f10, i10);
    }

    public void E(int i10, float f10) {
        this.f4102b1.j(i10, f10);
    }

    public void a(int i10, int i11) {
        this.f4114h1.cancel();
        this.f4114h1.setDuration((long) d.j(getContext())).setIntValues(new int[]{i10, i11});
        this.f4114h1.start();
    }

    public void b(int i10, int i11) {
        scrollTo(i10, i11);
        A(i11);
    }

    public void c(int i10, int i11) {
        d.p(this, i10, i11);
        F(i10, i11);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (!h0.c(this.f4116i1)) {
            return false;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public void draw(Canvas canvas) {
        if (this.T0 != 0) {
            View contentView = getContentView();
            if (!(this.S0 == null || contentView == null || contentView.getBottom() >= getHeight())) {
                this.S0.setBounds(0, contentView.getBottom(), getWidth(), getHeight());
                this.S0.draw(canvas);
            }
        }
        super.draw(canvas);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.N0 || (keyCode != 19 && keyCode != 20)) {
            return super.executeKeyEvent(keyEvent);
        }
        return false;
    }

    public void fling(int i10) {
        int m10 = m(i10);
        if (this.f4117j) {
            q(m10);
        } else if (this.f4101b != null) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.f4101b.fling(getScrollX(), getScrollY(), 0, m10, 0, 0, 0, Integer.MAX_VALUE, 0, height / 2);
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            super.fling(m10);
        }
        v(0, m10);
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    public void getClippingRect(Rect rect) {
        rect.set((Rect) p5.a.c(this.f4111g));
    }

    @NonNull
    public ValueAnimator getFlingAnimator() {
        return this.f4114h1;
    }

    public long getLastScrollDispatchTime() {
        return this.f4118j1;
    }

    @Nullable
    public String getOverflow() {
        return this.f4113h;
    }

    public Rect getOverflowInset() {
        return this.f4107e;
    }

    public h0 getPointerEvents() {
        return this.f4116i1;
    }

    public d.g getReactScrollViewScrollState() {
        return this.f4112g1;
    }

    public boolean getRemoveClippedSubviews() {
        return this.C;
    }

    public boolean getScrollEnabled() {
        return this.N0;
    }

    public int getScrollEventThrottle() {
        return this.f4119k1;
    }

    @Nullable
    public d1 getStateWrapper() {
        return this.f4110f1;
    }

    public void k() {
        OverScroller overScroller = this.f4101b;
        if (overScroller != null && !overScroller.isFinished()) {
            this.f4101b.abortAnimation();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.C) {
            updateClippingRect();
        }
        a aVar = this.f4120l1;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void onChildViewAdded(View view, View view2) {
        this.f4100a1 = view2;
        view2.addOnLayoutChangeListener(this);
    }

    public void onChildViewRemoved(View view, View view2) {
        View view3 = this.f4100a1;
        if (view3 != null) {
            view3.removeOnLayoutChangeListener(this);
            this.f4100a1 = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f4120l1;
        if (aVar != null) {
            aVar.g();
        }
    }

    public void onDraw(Canvas canvas) {
        this.f4102b1.d(canvas);
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String str = (String) getTag(m.f20860q);
        if (str != null) {
            accessibilityNodeInfo.setViewIdResourceName(str);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.N0) {
            return false;
        }
        if (!h0.c(this.f4116i1)) {
            return true;
        }
        try {
            if (super.onInterceptTouchEvent(motionEvent)) {
                u(motionEvent);
                return true;
            }
        } catch (IllegalArgumentException e10) {
            z2.a.H("ReactNative", "Error intercepting touch event.", e10);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (w()) {
            int i14 = this.f4106d1;
            if (i14 == -1) {
                i14 = getScrollX();
            }
            int i15 = this.f4108e1;
            if (i15 == -1) {
                i15 = getScrollY();
            }
            scrollTo(i14, i15);
        }
        d.a(this);
    }

    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int maxScrollY;
        if (this.f4100a1 != null) {
            a aVar = this.f4120l1;
            if (aVar != null) {
                aVar.h();
            }
            if (isShown() && w() && getScrollY() > (maxScrollY = getMaxScrollY())) {
                scrollTo(getScrollX(), maxScrollY);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        a0.a(i10, i11);
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i10, int i11, boolean z10, boolean z11) {
        int maxScrollY;
        OverScroller overScroller = this.f4101b;
        if (!(overScroller == null || this.f4100a1 == null || overScroller.isFinished() || this.f4101b.getCurrY() == this.f4101b.getFinalY() || i11 < (maxScrollY = getMaxScrollY()))) {
            this.f4101b.abortAnimation();
            i11 = maxScrollY;
        }
        super.onOverScrolled(i10, i11, z10, z11);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        this.f4109f = true;
        if (this.f4099a.c(i10, i11)) {
            if (this.C) {
                updateClippingRect();
            }
            if (!this.O0) {
                this.O0 = true;
                d.s(this, this.f4099a.a(), this.f4099a.b(), this.R0);
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
        if (!this.N0 || !h0.b(this.f4116i1)) {
            return false;
        }
        this.f4103c.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 && this.f4115i) {
            d.q(this);
            float b10 = this.f4103c.b();
            float c10 = this.f4103c.c();
            d.c(this, b10, c10);
            com.facebook.react.uimanager.events.m.a(this, motionEvent);
            this.f4115i = false;
            v(Math.round(b10), Math.round(c10));
        }
        if (actionMasked == 0) {
            l();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        awakenScrollBars();
    }

    public int r(int i10) {
        return d.n(this, 0, i10, 0, getMaxScrollY()).y;
    }

    public void requestChildFocus(View view, View view2) {
        if (view2 != null) {
            B(view2);
        }
        super.requestChildFocus(view, view2);
    }

    public void scrollTo(int i10, int i11) {
        super.scrollTo(i10, i11);
        d.q(this);
        F(i10, i11);
    }

    public void setBackgroundColor(int i10) {
        this.f4102b1.e(i10);
    }

    public void setBorderRadius(float f10) {
        this.f4102b1.g(f10);
    }

    public void setBorderStyle(@Nullable String str) {
        this.f4102b1.i(str);
    }

    public void setContentOffset(ReadableMap readableMap) {
        double d10;
        ReadableMap readableMap2 = this.f4104c1;
        if (readableMap2 == null || !readableMap2.equals(readableMap)) {
            this.f4104c1 = readableMap;
            if (readableMap != null) {
                double d11 = 0.0d;
                if (readableMap.hasKey("x")) {
                    d10 = readableMap.getDouble("x");
                } else {
                    d10 = 0.0d;
                }
                if (readableMap.hasKey("y")) {
                    d11 = readableMap.getDouble("y");
                }
                scrollTo((int) g0.c(d10), (int) g0.c(d11));
                return;
            }
            scrollTo(0, 0);
        }
    }

    public void setDecelerationRate(float f10) {
        getReactScrollViewScrollState().i(f10);
        OverScroller overScroller = this.f4101b;
        if (overScroller != null) {
            overScroller.setFriction(1.0f - f10);
        }
    }

    public void setDisableIntervalMomentum(boolean z10) {
        this.U0 = z10;
    }

    public void setEnableSyncOnScroll(boolean z10) {
        this.R0 = z10;
    }

    public void setEndFillColor(int i10) {
        if (i10 != this.T0) {
            this.T0 = i10;
            this.S0 = new ColorDrawable(this.T0);
        }
    }

    public void setLastScrollDispatchTime(long j10) {
        this.f4118j1 = j10;
    }

    public void setMaintainVisibleContentPosition(@Nullable a.b bVar) {
        a aVar;
        if (bVar != null && this.f4120l1 == null) {
            a aVar2 = new a(this, false);
            this.f4120l1 = aVar2;
            aVar2.f();
        } else if (bVar == null && (aVar = this.f4120l1) != null) {
            aVar.g();
            this.f4120l1 = null;
        }
        a aVar3 = this.f4120l1;
        if (aVar3 != null) {
            aVar3.e(bVar);
        }
    }

    public void setOverflow(@Nullable String str) {
        this.f4113h = str;
        e eVar = this.f4102b1;
        if (str == null) {
            str = "scroll";
        }
        eVar.k(str);
    }

    public void setOverflowInset(int i10, int i11, int i12, int i13) {
        this.f4107e.set(i10, i11, i12, i13);
    }

    public void setPagingEnabled(boolean z10) {
        this.f4117j = z10;
    }

    public void setPointerEvents(h0 h0Var) {
        this.f4116i1 = h0Var;
    }

    public void setRemoveClippedSubviews(boolean z10) {
        if (z10 && this.f4111g == null) {
            this.f4111g = new Rect();
        }
        this.C = z10;
        updateClippingRect();
    }

    public void setScrollAwayTopPaddingEnabledUnstable(int i10) {
        int childCount = getChildCount();
        boolean z10 = true;
        if (childCount > 1) {
            z10 = false;
        }
        p5.a.b(z10, "React Native ScrollView should not have more than one child, it should have exactly 1 child; a content View");
        if (childCount > 0) {
            for (int i11 = 0; i11 < childCount; i11++) {
                getChildAt(i11).setTranslationY((float) i10);
            }
            setPadding(0, 0, 0, i10);
        }
        H(i10);
        setRemoveClippedSubviews(this.C);
    }

    public void setScrollEnabled(boolean z10) {
        this.N0 = z10;
    }

    public void setScrollEventThrottle(int i10) {
        this.f4119k1 = i10;
    }

    public void setScrollPerfTag(@Nullable String str) {
        this.Q0 = str;
    }

    public void setSendMomentumEvents(boolean z10) {
        this.P0 = z10;
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
        this.f4110f1 = d1Var;
    }

    /* access modifiers changed from: protected */
    public void u(MotionEvent motionEvent) {
        com.facebook.react.uimanager.events.m.b(this, motionEvent);
        d.b(this);
        this.f4115i = true;
        o();
        getFlingAnimator().cancel();
    }

    public void updateClippingRect() {
        if (this.C) {
            p5.a.c(this.f4111g);
            l0.a(this, this.f4111g);
            View contentView = getContentView();
            if (contentView instanceof k0) {
                ((k0) contentView).updateClippingRect();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean x(View view) {
        int t10 = t(view);
        view.getDrawingRect(this.f4105d);
        if (t10 == 0 || Math.abs(t10) >= this.f4105d.width()) {
            return false;
        }
        return true;
    }
}
