package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    public static final int EDGE_TYPE_INSIDE = 0;
    public static final int EDGE_TYPE_INSIDE_EXTEND = 1;
    public static final int EDGE_TYPE_OUTSIDE = 2;
    private static final int HORIZONTAL = 0;
    public static final float NO_MAX = Float.MAX_VALUE;
    public static final float NO_MIN = 0.0f;
    public static final float RELATIVE_UNSPECIFIED = 0.0f;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    private float[] mMaximumEdges = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mMaximumVelocity = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private Runnable mRunnable;
    final a mScroller = new a();
    final View mTarget;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f15283a;

        /* renamed from: b  reason: collision with root package name */
        private int f15284b;

        /* renamed from: c  reason: collision with root package name */
        private float f15285c;

        /* renamed from: d  reason: collision with root package name */
        private float f15286d;

        /* renamed from: e  reason: collision with root package name */
        private long f15287e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f15288f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f15289g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f15290h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f15291i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f15292j;

        /* renamed from: k  reason: collision with root package name */
        private int f15293k;

        a() {
        }

        private float e(long j10) {
            long j11 = this.f15287e;
            if (j10 < j11) {
                return 0.0f;
            }
            long j12 = this.f15291i;
            if (j12 < 0 || j10 < j12) {
                return AutoScrollHelper.constrain(((float) (j10 - j11)) / ((float) this.f15283a), 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f15292j;
            return (1.0f - f10) + (f10 * AutoScrollHelper.constrain(((float) (j10 - j12)) / ((float) this.f15293k), 0.0f, 1.0f));
        }

        private float g(float f10) {
            return (-4.0f * f10 * f10) + (f10 * 4.0f);
        }

        public void a() {
            if (this.f15288f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                this.f15288f = currentAnimationTimeMillis;
                float f10 = ((float) (currentAnimationTimeMillis - this.f15288f)) * g10;
                this.f15289g = (int) (this.f15285c * f10);
                this.f15290h = (int) (f10 * this.f15286d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f15289g;
        }

        public int c() {
            return this.f15290h;
        }

        public int d() {
            float f10 = this.f15285c;
            return (int) (f10 / Math.abs(f10));
        }

        public int f() {
            float f10 = this.f15286d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean h() {
            if (this.f15291i <= 0 || AnimationUtils.currentAnimationTimeMillis() <= this.f15291i + ((long) this.f15293k)) {
                return false;
            }
            return true;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f15293k = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.f15287e), 0, this.f15284b);
            this.f15292j = e(currentAnimationTimeMillis);
            this.f15291i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f15284b = i10;
        }

        public void k(int i10) {
            this.f15283a = i10;
        }

        public void l(float f10, float f11) {
            this.f15285c = f10;
            this.f15286d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f15287e = currentAnimationTimeMillis;
            this.f15291i = -1;
            this.f15288f = currentAnimationTimeMillis;
            this.f15292j = 0.5f;
            this.f15289g = 0;
            this.f15290h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    autoScrollHelper.mScroller.m();
                }
                a aVar = AutoScrollHelper.this.mScroller;
                if (aVar.h() || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    autoScrollHelper2.cancelTargetTouch();
                }
                aVar.a();
                AutoScrollHelper.this.scrollTargetBy(aVar.b(), aVar.c());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
            }
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.mTarget = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (float) ((int) ((1575.0f * f10) + 0.5f));
        setMaximumVelocity(f11, f11);
        float f12 = (float) ((int) ((f10 * 315.0f) + 0.5f));
        setMinimumVelocity(f12, f12);
        setEdgeType(1);
        setMaximumEdges(Float.MAX_VALUE, Float.MAX_VALUE);
        setRelativeEdges(0.2f, 0.2f);
        setRelativeVelocity(1.0f, 1.0f);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int i10, float f10, float f11, float f12) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i10], f11, this.mMaximumEdges[i10], f10);
        int i11 = (edgeValue > 0.0f ? 1 : (edgeValue == 0.0f ? 0 : -1));
        if (i11 == 0) {
            return 0.0f;
        }
        float f13 = this.mRelativeVelocity[i10];
        float f14 = this.mMinimumVelocity[i10];
        float f15 = this.mMaximumVelocity[i10];
        float f16 = f13 * f12;
        if (i11 > 0) {
            return constrain(edgeValue * f16, f14, f15);
        }
        return -constrain((-edgeValue) * f16, f14, f15);
    }

    static float constrain(float f10, float f11, float f12) {
        if (f10 > f12) {
            return f12;
        }
        return f10 < f11 ? f11 : f10;
    }

    private float constrainEdgeValue(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.mEdgeType;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (!this.mAnimating || i10 != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    private float getEdgeValue(float f10, float f11, float f12, float f13) {
        float f14;
        float constrain = constrain(f10 * f11, 0.0f, f12);
        float constrainEdgeValue = constrainEdgeValue(f11 - f13, constrain) - constrainEdgeValue(f13, constrain);
        if (constrainEdgeValue < 0.0f) {
            f14 = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else if (constrainEdgeValue <= 0.0f) {
            return 0.0f;
        } else {
            f14 = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        }
        return constrain(f14, -1.0f, 1.0f);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.i();
        }
    }

    private void startAnimating() {
        int i10;
        if (this.mRunnable == null) {
            this.mRunnable = new b();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed || (i10 = this.mActivationDelay) <= 0) {
            this.mRunnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, (long) i10);
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i10);

    public abstract boolean canTargetScrollVertically(int i10);

    /* access modifiers changed from: package-private */
    public void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public boolean isExclusive() {
        return this.mExclusive;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.mEnabled
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.requestStop()
            goto L_0x0058
        L_0x001a:
            r5.mNeedsCancel = r2
            r5.mAlreadyDelayed = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.mTarget
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.computeTargetVelocity(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.mTarget
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.computeTargetVelocity(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$a r7 = r5.mScroller
            r7.l(r0, r6)
            boolean r6 = r5.mAnimating
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.shouldAnimate()
            if (r6 == 0) goto L_0x0058
            r5.startAnimating()
        L_0x0058:
            boolean r6 = r5.mExclusive
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.mAnimating
            if (r6 == 0) goto L_0x0061
            r1 = r2
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public abstract void scrollTargetBy(int i10, int i11);

    @NonNull
    public AutoScrollHelper setActivationDelay(int i10) {
        this.mActivationDelay = i10;
        return this;
    }

    @NonNull
    public AutoScrollHelper setEdgeType(int i10) {
        this.mEdgeType = i10;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z10) {
        if (this.mEnabled && !z10) {
            requestStop();
        }
        this.mEnabled = z10;
        return this;
    }

    public AutoScrollHelper setExclusive(boolean z10) {
        this.mExclusive = z10;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumEdges(float f10, float f11) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMaximumVelocity(float f10, float f11) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setMinimumVelocity(float f10, float f11) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampDownDuration(int i10) {
        this.mScroller.j(i10);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRampUpDuration(int i10) {
        this.mScroller.k(i10);
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeEdges(float f10, float f11) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    @NonNull
    public AutoScrollHelper setRelativeVelocity(float f10, float f11) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldAnimate() {
        a aVar = this.mScroller;
        int f10 = aVar.f();
        int d10 = aVar.d();
        if ((f10 == 0 || !canTargetScrollVertically(f10)) && (d10 == 0 || !canTargetScrollHorizontally(d10))) {
            return false;
        }
        return true;
    }

    static int constrain(int i10, int i11, int i12) {
        if (i10 > i12) {
            return i12;
        }
        return i10 < i11 ? i11 : i10;
    }
}
