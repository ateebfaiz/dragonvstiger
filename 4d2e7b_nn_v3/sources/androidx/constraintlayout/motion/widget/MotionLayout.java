package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown = true;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime = 0;
    /* access modifiers changed from: private */
    public int mBeginState = -1;
    private RectF mBoundsCheck = new RectF();
    int mCurrentState = -1;
    int mDebugPath = 0;
    private c mDecelerateLogic = new c();
    private DesignTool mDesignTool;
    d mDevModeDraw;
    /* access modifiers changed from: private */
    public int mEndState = -1;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList = new HashMap<>();
    private int mFrames = 0;
    int mHeightMeasureMode;
    private boolean mInLayout = false;
    boolean mInTransition = false;
    boolean mIndirectTransition = false;
    private boolean mInteractionEnabled = true;
    Interpolator mInterpolator;
    boolean mIsAnimating = false;
    private boolean mKeepAnimating = false;
    private KeyCache mKeyCache = new KeyCache();
    private long mLastDrawTime = -1;
    private float mLastFps = 0.0f;
    /* access modifiers changed from: private */
    public int mLastHeightMeasureSpec = 0;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity = 0.0f;
    /* access modifiers changed from: private */
    public int mLastWidthMeasureSpec = 0;
    private float mListenerPosition = 0.0f;
    private int mListenerState = 0;
    protected boolean mMeasureDuringTransition = false;
    e mModel = new e();
    private boolean mNeedsFireTransitionCompleted = false;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers = null;
    private ArrayList<MotionHelper> mOnShowHelpers = null;
    float mPostInterpolationPosition;
    private View mRegionView = null;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private g mStateCache;
    private StopLogic mStopLogic = new StopLogic();
    private boolean mTemporalInterpolator = false;
    ArrayList<Integer> mTransitionCompleted = new ArrayList<>();
    private float mTransitionDuration = 1.0f;
    float mTransitionGoalPosition = 0.0f;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition = 0.0f;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners = null;
    float mTransitionPosition = 0.0f;
    h mTransitionState = h.UNDEFINED;
    boolean mUndergoingMotion = false;
    int mWidthMeasureMode;

    protected interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i10);

        void computeCurrentVelocity(int i10, float f10);

        float getXVelocity();

        float getXVelocity(int i10);

        float getYVelocity();

        float getYVelocity(int i10);

        void recycle();
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i10, int i11, float f10);

        void onTransitionCompleted(MotionLayout motionLayout, int i10);

        void onTransitionStarted(MotionLayout motionLayout, int i10, int i11);

        void onTransitionTrigger(MotionLayout motionLayout, int i10, boolean z10, float f10);
    }

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f14565a;

        a(View view) {
            this.f14565a = view;
        }

        public void run() {
            this.f14565a.setNestedScrollingEnabled(true);
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14567a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$h[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.h.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14567a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14567a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14567a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14567a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$h r1 = androidx.constraintlayout.motion.widget.MotionLayout.h.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.b.<clinit>():void");
        }
    }

    class c extends MotionInterpolator {

        /* renamed from: a  reason: collision with root package name */
        float f14568a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f14569b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f14570c;

        c() {
        }

        public void a(float f10, float f11, float f12) {
            this.f14568a = f10;
            this.f14569b = f11;
            this.f14570c = f12;
        }

        public float getInterpolation(float f10) {
            float f11;
            float f12;
            float f13 = this.f14568a;
            if (f13 > 0.0f) {
                float f14 = this.f14570c;
                if (f13 / f14 < f10) {
                    f10 = f13 / f14;
                }
                MotionLayout.this.mLastVelocity = f13 - (f14 * f10);
                f11 = (f13 * f10) - (((f14 * f10) * f10) / 2.0f);
                f12 = this.f14569b;
            } else {
                float f15 = this.f14570c;
                if ((-f13) / f15 < f10) {
                    f10 = (-f13) / f15;
                }
                MotionLayout.this.mLastVelocity = (f15 * f10) + f13;
                f11 = (f13 * f10) + (((f15 * f10) * f10) / 2.0f);
                f12 = this.f14569b;
            }
            return f11 + f12;
        }

        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    private class d {

        /* renamed from: a  reason: collision with root package name */
        float[] f14572a;

        /* renamed from: b  reason: collision with root package name */
        int[] f14573b;

        /* renamed from: c  reason: collision with root package name */
        float[] f14574c;

        /* renamed from: d  reason: collision with root package name */
        Path f14575d;

        /* renamed from: e  reason: collision with root package name */
        Paint f14576e;

        /* renamed from: f  reason: collision with root package name */
        Paint f14577f;

        /* renamed from: g  reason: collision with root package name */
        Paint f14578g;

        /* renamed from: h  reason: collision with root package name */
        Paint f14579h;

        /* renamed from: i  reason: collision with root package name */
        Paint f14580i;

        /* renamed from: j  reason: collision with root package name */
        private float[] f14581j;

        /* renamed from: k  reason: collision with root package name */
        final int f14582k = -21965;

        /* renamed from: l  reason: collision with root package name */
        final int f14583l = -2067046;

        /* renamed from: m  reason: collision with root package name */
        final int f14584m = -13391360;

        /* renamed from: n  reason: collision with root package name */
        final int f14585n = 1996488704;

        /* renamed from: o  reason: collision with root package name */
        final int f14586o = 10;

        /* renamed from: p  reason: collision with root package name */
        DashPathEffect f14587p;

        /* renamed from: q  reason: collision with root package name */
        int f14588q;

        /* renamed from: r  reason: collision with root package name */
        Rect f14589r = new Rect();

        /* renamed from: s  reason: collision with root package name */
        boolean f14590s = false;

        /* renamed from: t  reason: collision with root package name */
        int f14591t = 1;

        public d() {
            Paint paint = new Paint();
            this.f14576e = paint;
            paint.setAntiAlias(true);
            this.f14576e.setColor(-21965);
            this.f14576e.setStrokeWidth(2.0f);
            Paint paint2 = this.f14576e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f14577f = paint3;
            paint3.setAntiAlias(true);
            this.f14577f.setColor(-2067046);
            this.f14577f.setStrokeWidth(2.0f);
            this.f14577f.setStyle(style);
            Paint paint4 = new Paint();
            this.f14578g = paint4;
            paint4.setAntiAlias(true);
            this.f14578g.setColor(-13391360);
            this.f14578g.setStrokeWidth(2.0f);
            this.f14578g.setStyle(style);
            Paint paint5 = new Paint();
            this.f14579h = paint5;
            paint5.setAntiAlias(true);
            this.f14579h.setColor(-13391360);
            this.f14579h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f14581j = new float[8];
            Paint paint6 = new Paint();
            this.f14580i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f14587p = dashPathEffect;
            this.f14578g.setPathEffect(dashPathEffect);
            this.f14574c = new float[100];
            this.f14573b = new int[50];
            if (this.f14590s) {
                this.f14576e.setStrokeWidth(8.0f);
                this.f14580i.setStrokeWidth(8.0f);
                this.f14577f.setStrokeWidth(8.0f);
                this.f14591t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f14572a, this.f14576e);
        }

        private void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i10 = 0; i10 < this.f14588q; i10++) {
                int i11 = this.f14573b[i10];
                if (i11 == 1) {
                    z10 = true;
                }
                if (i11 == 2) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f14572a;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[fArr.length - 2];
            float f13 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f10, f12), Math.max(f11, f13), Math.max(f10, f12), Math.max(f11, f13), this.f14578g);
            canvas.drawLine(Math.min(f10, f12), Math.min(f11, f13), Math.min(f10, f12), Math.max(f11, f13), this.f14578g);
        }

        private void f(Canvas canvas, float f10, float f11) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f14572a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float min = Math.min(f12, f14);
            float max = Math.max(f13, f15);
            float min2 = f10 - Math.min(f12, f14);
            float max2 = Math.max(f13, f15) - f11;
            String str = "" + (((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f14 - f12))) + 0.5d))) / 100.0f);
            l(str, this.f14579h);
            canvas2.drawText(str, ((min2 / 2.0f) - ((float) (this.f14589r.width() / 2))) + min, f11 - 20.0f, this.f14579h);
            canvas.drawLine(f10, f11, Math.min(f12, f14), f11, this.f14578g);
            String str2 = "" + (((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f15 - f13))) + 0.5d))) / 100.0f);
            l(str2, this.f14579h);
            canvas2.drawText(str2, f10 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.f14589r.height() / 2))), this.f14579h);
            canvas.drawLine(f10, f11, f10, Math.max(f13, f15), this.f14578g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f14572a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f14578g);
        }

        private void h(Canvas canvas, float f10, float f11) {
            float[] fArr = this.f14572a;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[fArr.length - 2];
            float f15 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f12 - f14), (double) (f13 - f15));
            float f16 = f14 - f12;
            float f17 = f15 - f13;
            float f18 = (((f10 - f12) * f16) + ((f11 - f13) * f17)) / (hypot * hypot);
            float f19 = f12 + (f16 * f18);
            float f20 = f13 + (f18 * f17);
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f19, f20);
            float hypot2 = (float) Math.hypot((double) (f19 - f10), (double) (f20 - f11));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            l(str, this.f14579h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.f14589r.width() / 2)), -20.0f, this.f14579h);
            canvas.drawLine(f10, f11, f19, f20, this.f14578g);
        }

        private void i(Canvas canvas, float f10, float f11, int i10, int i11) {
            Canvas canvas2 = canvas;
            String str = "" + (((float) ((int) (((double) (((f10 - ((float) (i10 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i10)))) + 0.5d))) / 100.0f);
            l(str, this.f14579h);
            canvas2.drawText(str, ((f10 / 2.0f) - ((float) (this.f14589r.width() / 2))) + 0.0f, f11 - 20.0f, this.f14579h);
            canvas.drawLine(f10, f11, Math.min(0.0f, 1.0f), f11, this.f14578g);
            String str2 = "" + (((float) ((int) (((double) (((f11 - ((float) (i11 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i11)))) + 0.5d))) / 100.0f);
            l(str2, this.f14579h);
            canvas2.drawText(str2, f10 + 5.0f, 0.0f - ((f11 / 2.0f) - ((float) (this.f14589r.height() / 2))), this.f14579h);
            canvas.drawLine(f10, f11, f10, Math.max(0.0f, 1.0f), this.f14578g);
        }

        private void j(Canvas canvas, MotionController motionController) {
            this.f14575d.reset();
            for (int i10 = 0; i10 <= 50; i10++) {
                motionController.buildRect(((float) i10) / ((float) 50), this.f14581j, 0);
                Path path = this.f14575d;
                float[] fArr = this.f14581j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f14575d;
                float[] fArr2 = this.f14581j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f14575d;
                float[] fArr3 = this.f14581j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f14575d;
                float[] fArr4 = this.f14581j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f14575d.close();
            }
            this.f14576e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f14575d, this.f14576e);
            canvas.translate(-2.0f, -2.0f);
            this.f14576e.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawPath(this.f14575d, this.f14576e);
        }

        private void k(Canvas canvas, int i10, int i11, MotionController motionController) {
            int i12;
            int i13;
            float f10;
            float f11;
            int i14;
            Canvas canvas2 = canvas;
            int i15 = i10;
            MotionController motionController2 = motionController;
            View view = motionController2.mView;
            if (view != null) {
                i13 = view.getWidth();
                i12 = motionController2.mView.getHeight();
            } else {
                i13 = 0;
                i12 = 0;
            }
            for (int i16 = 1; i16 < i11 - 1; i16++) {
                if (i15 != 4 || this.f14573b[i16 - 1] != 0) {
                    float[] fArr = this.f14574c;
                    int i17 = i16 * 2;
                    float f12 = fArr[i17];
                    float f13 = fArr[i17 + 1];
                    this.f14575d.reset();
                    this.f14575d.moveTo(f12, f13 + 10.0f);
                    this.f14575d.lineTo(f12 + 10.0f, f13);
                    this.f14575d.lineTo(f12, f13 - 10.0f);
                    this.f14575d.lineTo(f12 - 10.0f, f13);
                    this.f14575d.close();
                    int i18 = i16 - 1;
                    motionController2.getKeyFrame(i18);
                    if (i15 == 4) {
                        int i19 = this.f14573b[i18];
                        if (i19 == 1) {
                            h(canvas2, f12 - 0.0f, f13 - 0.0f);
                        } else if (i19 == 2) {
                            f(canvas2, f12 - 0.0f, f13 - 0.0f);
                        } else if (i19 == 3) {
                            i14 = 3;
                            f11 = f13;
                            f10 = f12;
                            i(canvas, f12 - 0.0f, f13 - 0.0f, i13, i12);
                            canvas2.drawPath(this.f14575d, this.f14580i);
                        }
                        i14 = 3;
                        f11 = f13;
                        f10 = f12;
                        canvas2.drawPath(this.f14575d, this.f14580i);
                    } else {
                        i14 = 3;
                        f11 = f13;
                        f10 = f12;
                    }
                    if (i15 == 2) {
                        h(canvas2, f10 - 0.0f, f11 - 0.0f);
                    }
                    if (i15 == i14) {
                        f(canvas2, f10 - 0.0f, f11 - 0.0f);
                    }
                    if (i15 == 6) {
                        i(canvas, f10 - 0.0f, f11 - 0.0f, i13, i12);
                    }
                    canvas2.drawPath(this.f14575d, this.f14580i);
                }
            }
            float[] fArr2 = this.f14572a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f14577f);
                float[] fArr3 = this.f14572a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f14577f);
            }
        }

        public void a(Canvas canvas, HashMap hashMap, int i10, int i11) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i11 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f14579h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f14576e);
                }
                for (MotionController motionController : hashMap.values()) {
                    int drawPath = motionController.getDrawPath();
                    if (i11 > 0 && drawPath == 0) {
                        drawPath = 1;
                    }
                    if (drawPath != 0) {
                        this.f14588q = motionController.buildKeyFrames(this.f14574c, this.f14573b);
                        if (drawPath >= 1) {
                            int i12 = i10 / 16;
                            float[] fArr = this.f14572a;
                            if (fArr == null || fArr.length != i12 * 2) {
                                this.f14572a = new float[(i12 * 2)];
                                this.f14575d = new Path();
                            }
                            int i13 = this.f14591t;
                            canvas.translate((float) i13, (float) i13);
                            this.f14576e.setColor(1996488704);
                            this.f14580i.setColor(1996488704);
                            this.f14577f.setColor(1996488704);
                            this.f14578g.setColor(1996488704);
                            motionController.buildPath(this.f14572a, i12);
                            b(canvas, drawPath, this.f14588q, motionController);
                            this.f14576e.setColor(-21965);
                            this.f14577f.setColor(-2067046);
                            this.f14580i.setColor(-2067046);
                            this.f14578g.setColor(-13391360);
                            int i14 = this.f14591t;
                            canvas.translate((float) (-i14), (float) (-i14));
                            b(canvas, drawPath, this.f14588q, motionController);
                            if (drawPath == 5) {
                                j(canvas, motionController);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        public void b(Canvas canvas, int i10, int i11, MotionController motionController) {
            if (i10 == 4) {
                d(canvas);
            }
            if (i10 == 2) {
                g(canvas);
            }
            if (i10 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i10, i11, motionController);
        }

        /* access modifiers changed from: package-private */
        public void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f14589r);
        }
    }

    class e {

        /* renamed from: a  reason: collision with root package name */
        ConstraintWidgetContainer f14593a = new ConstraintWidgetContainer();

        /* renamed from: b  reason: collision with root package name */
        ConstraintWidgetContainer f14594b = new ConstraintWidgetContainer();

        /* renamed from: c  reason: collision with root package name */
        ConstraintSet f14595c = null;

        /* renamed from: d  reason: collision with root package name */
        ConstraintSet f14596d = null;

        /* renamed from: e  reason: collision with root package name */
        int f14597e;

        /* renamed from: f  reason: collision with root package name */
        int f14598f;

        e() {
        }

        private void i(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    Helper helper = (Helper) next3;
                    ((ConstraintHelper) next3.getCompanionWidget()).updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        public void a() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = MotionLayout.this.getChildAt(i10);
                MotionLayout.this.mFrameArrayList.put(childAt, new MotionController(childAt));
            }
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt2 = MotionLayout.this.getChildAt(i11);
                MotionController motionController = MotionLayout.this.mFrameArrayList.get(childAt2);
                if (motionController != null) {
                    if (this.f14595c != null) {
                        ConstraintWidget c10 = c(this.f14593a, childAt2);
                        if (c10 != null) {
                            motionController.setStartState(c10, this.f14595c);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.f14596d != null) {
                        ConstraintWidget c11 = c(this.f14594b, childAt2);
                        if (c11 != null) {
                            motionController.setEndState(c11, this.f14596d);
                        } else if (MotionLayout.this.mDebugPath != 0) {
                            Log.e(MotionLayout.TAG, Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap hashMap = new HashMap();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof androidx.constraintlayout.solver.widgets.Barrier) {
                    constraintWidget = new androidx.constraintlayout.solver.widgets.Barrier();
                } else if (next instanceof Guideline) {
                    constraintWidget = new Guideline();
                } else if (next instanceof Flow) {
                    constraintWidget = new Flow();
                } else if (next instanceof Helper) {
                    constraintWidget = new HelperWidget();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                constraintWidgetContainer2.add(constraintWidget);
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                ((ConstraintWidget) hashMap.get(next2)).copy(next2, hashMap);
            }
        }

        /* access modifiers changed from: package-private */
        public ConstraintWidget c(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            for (int i10 = 0; i10 < size; i10++) {
                ConstraintWidget constraintWidget = children.get(i10);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void d(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f14595c = constraintSet;
            this.f14596d = constraintSet2;
            this.f14593a = new ConstraintWidgetContainer();
            this.f14594b = new ConstraintWidgetContainer();
            this.f14593a.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.f14594b.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.f14593a.removeAllChildren();
            this.f14594b.removeAllChildren();
            b(MotionLayout.this.mLayoutWidget, this.f14593a);
            b(MotionLayout.this.mLayoutWidget, this.f14594b);
            if (((double) MotionLayout.this.mTransitionLastPosition) > 0.5d) {
                if (constraintSet != null) {
                    i(this.f14593a, constraintSet);
                }
                i(this.f14594b, constraintSet2);
            } else {
                i(this.f14594b, constraintSet2);
                if (constraintSet != null) {
                    i(this.f14593a, constraintSet);
                }
            }
            this.f14593a.setRtl(MotionLayout.this.isRtl());
            this.f14593a.updateHierarchy();
            this.f14594b.setRtl(MotionLayout.this.isRtl());
            this.f14594b.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.f14593a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer2.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    this.f14594b.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    ConstraintWidgetContainer constraintWidgetContainer3 = this.f14593a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    constraintWidgetContainer3.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    this.f14594b.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            }
        }

        public boolean e(int i10, int i11) {
            if (i10 == this.f14597e && i11 == this.f14598f) {
                return false;
            }
            return true;
        }

        public void f(int i10, int i11) {
            boolean z10;
            boolean z11;
            int mode = View.MeasureSpec.getMode(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.mWidthMeasureMode = mode;
            motionLayout.mHeightMeasureMode = mode2;
            int optimizationLevel = motionLayout.getOptimizationLevel();
            MotionLayout motionLayout2 = MotionLayout.this;
            if (motionLayout2.mCurrentState == motionLayout2.getStartState()) {
                MotionLayout.this.resolveSystem(this.f14594b, optimizationLevel, i10, i11);
                if (this.f14595c != null) {
                    MotionLayout.this.resolveSystem(this.f14593a, optimizationLevel, i10, i11);
                }
            } else {
                if (this.f14595c != null) {
                    MotionLayout.this.resolveSystem(this.f14593a, optimizationLevel, i10, i11);
                }
                MotionLayout.this.resolveSystem(this.f14594b, optimizationLevel, i10, i11);
            }
            boolean z12 = true;
            if (!((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824)) {
                MotionLayout motionLayout3 = MotionLayout.this;
                motionLayout3.mWidthMeasureMode = mode;
                motionLayout3.mHeightMeasureMode = mode2;
                if (motionLayout3.mCurrentState == motionLayout3.getStartState()) {
                    MotionLayout.this.resolveSystem(this.f14594b, optimizationLevel, i10, i11);
                    if (this.f14595c != null) {
                        MotionLayout.this.resolveSystem(this.f14593a, optimizationLevel, i10, i11);
                    }
                } else {
                    if (this.f14595c != null) {
                        MotionLayout.this.resolveSystem(this.f14593a, optimizationLevel, i10, i11);
                    }
                    MotionLayout.this.resolveSystem(this.f14594b, optimizationLevel, i10, i11);
                }
                MotionLayout.this.mStartWrapWidth = this.f14593a.getWidth();
                MotionLayout.this.mStartWrapHeight = this.f14593a.getHeight();
                MotionLayout.this.mEndWrapWidth = this.f14594b.getWidth();
                MotionLayout.this.mEndWrapHeight = this.f14594b.getHeight();
                MotionLayout motionLayout4 = MotionLayout.this;
                if (motionLayout4.mStartWrapWidth == motionLayout4.mEndWrapWidth && motionLayout4.mStartWrapHeight == motionLayout4.mEndWrapHeight) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                motionLayout4.mMeasureDuringTransition = z11;
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            int i12 = motionLayout5.mStartWrapWidth;
            int i13 = motionLayout5.mStartWrapHeight;
            int i14 = motionLayout5.mWidthMeasureMode;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                i12 = (int) (((float) i12) + (motionLayout5.mPostInterpolationPosition * ((float) (motionLayout5.mEndWrapWidth - i12))));
            }
            int i15 = motionLayout5.mHeightMeasureMode;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                i13 = (int) (((float) i13) + (motionLayout5.mPostInterpolationPosition * ((float) (motionLayout5.mEndWrapHeight - i13))));
            }
            if (this.f14593a.isWidthMeasuredTooSmall() || this.f14594b.isWidthMeasuredTooSmall()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!this.f14593a.isHeightMeasuredTooSmall() && !this.f14594b.isHeightMeasuredTooSmall()) {
                z12 = false;
            }
            MotionLayout.this.resolveMeasuredDimension(i10, i11, i12, i13, z10, z12);
        }

        public void g() {
            f(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void h(int i10, int i11) {
            this.f14597e = i10;
            this.f14598f = i11;
        }
    }

    private static class f implements MotionTracker {

        /* renamed from: b  reason: collision with root package name */
        private static f f14600b = new f();

        /* renamed from: a  reason: collision with root package name */
        VelocityTracker f14601a;

        private f() {
        }

        public static f a() {
            f14600b.f14601a = VelocityTracker.obtain();
            return f14600b;
        }

        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f14601a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public void clear() {
            this.f14601a.clear();
        }

        public void computeCurrentVelocity(int i10) {
            this.f14601a.computeCurrentVelocity(i10);
        }

        public float getXVelocity() {
            return this.f14601a.getXVelocity();
        }

        public float getYVelocity() {
            return this.f14601a.getYVelocity();
        }

        public void recycle() {
            this.f14601a.recycle();
            this.f14601a = null;
        }

        public void computeCurrentVelocity(int i10, float f10) {
            this.f14601a.computeCurrentVelocity(i10, f10);
        }

        public float getXVelocity(int i10) {
            return this.f14601a.getXVelocity(i10);
        }

        public float getYVelocity(int i10) {
            return getYVelocity(i10);
        }
    }

    class g {

        /* renamed from: a  reason: collision with root package name */
        float f14602a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f14603b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f14604c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f14605d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f14606e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f14607f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f14608g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f14609h = "motion.EndState";

        g() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i10 = this.f14604c;
            if (!(i10 == -1 && this.f14605d == -1)) {
                if (i10 == -1) {
                    MotionLayout.this.transitionToState(this.f14605d);
                } else {
                    int i11 = this.f14605d;
                    if (i11 == -1) {
                        MotionLayout.this.setState(i10, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i10, i11);
                    }
                }
                MotionLayout.this.setState(h.SETUP);
            }
            if (!Float.isNaN(this.f14603b)) {
                MotionLayout.this.setProgress(this.f14602a, this.f14603b);
                this.f14602a = Float.NaN;
                this.f14603b = Float.NaN;
                this.f14604c = -1;
                this.f14605d = -1;
            } else if (!Float.isNaN(this.f14602a)) {
                MotionLayout.this.setProgress(this.f14602a);
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f14602a);
            bundle.putFloat("motion.velocity", this.f14603b);
            bundle.putInt("motion.StartState", this.f14604c);
            bundle.putInt("motion.EndState", this.f14605d);
            return bundle;
        }

        public void c() {
            this.f14605d = MotionLayout.this.mEndState;
            this.f14604c = MotionLayout.this.mBeginState;
            this.f14603b = MotionLayout.this.getVelocity();
            this.f14602a = MotionLayout.this.getProgress();
        }

        public void d(int i10) {
            this.f14605d = i10;
        }

        public void e(float f10) {
            this.f14602a = f10;
        }

        public void f(int i10) {
            this.f14604c = i10;
        }

        public void g(Bundle bundle) {
            this.f14602a = bundle.getFloat("motion.progress");
            this.f14603b = bundle.getFloat("motion.velocity");
            this.f14604c = bundle.getInt("motion.StartState");
            this.f14605d = bundle.getInt("motion.EndState");
        }

        public void h(float f10) {
            this.f14603b = f10;
        }
    }

    enum h {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        init((AttributeSet) null);
    }

    private void checkStructure() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int startId = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        checkStructure(startId, motionScene2.getConstraintSet(motionScene2.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.mScene.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            if (next == this.mScene.mCurrentTransition) {
                Log.v(TAG, "CHECK: CURRENT");
            }
            checkStructure(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            String name = Debug.getName(getContext(), startConstraintSetId);
            String name2 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e(TAG, "CHECK: two transitions with the same start and end " + name + "->" + name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e(TAG, "CHECK: you can't have reverse transitions" + name + "->" + name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.mScene.getConstraintSet(startConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetStart " + name);
            }
            if (this.mScene.getConstraintSet(endConstraintSetId) == null) {
                Log.e(TAG, " no such constraintSetEnd " + name);
            }
        }
    }

    private void computeCurrentPositions() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.setStartCurrentState(childAt);
            }
        }
    }

    private void debugPos() {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            Log.v(TAG, " " + Debug.getLocation() + " " + Debug.getName(this) + " " + Debug.getName(getContext(), this.mCurrentState) + " " + Debug.getName(childAt) + childAt.getLeft() + " " + childAt.getTop());
        }
    }

    private void evaluateLayout() {
        float f10;
        boolean z10;
        float signum = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.mInterpolator;
        if (!(interpolator instanceof StopLogic)) {
            f10 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
        } else {
            f10 = 0.0f;
        }
        float f11 = this.mTransitionLastPosition + f10;
        if (this.mTransitionInstantly) {
            f11 = this.mTransitionGoalPosition;
        }
        int i10 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
        if ((i10 <= 0 || f11 < this.mTransitionGoalPosition) && (signum > 0.0f || f11 > this.mTransitionGoalPosition)) {
            z10 = false;
        } else {
            f11 = this.mTransitionGoalPosition;
            z10 = true;
        }
        if (interpolator != null && !z10) {
            if (this.mTemporalInterpolator) {
                f11 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
            } else {
                f11 = interpolator.getInterpolation(f11);
            }
        }
        if ((i10 > 0 && f11 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f11 <= this.mTransitionGoalPosition)) {
            f11 = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f11;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            MotionController motionController = this.mFrameArrayList.get(childAt);
            if (motionController != null) {
                motionController.interpolate(childAt, f11, nanoTime2, this.mKeyCache);
            }
        }
        if (this.mMeasureDuringTransition) {
            requestLayout();
        }
    }

    private void fireTransitionChange() {
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerPosition != this.mTransitionPosition) {
            if (this.mListenerState != -1) {
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }
                }
                this.mIsAnimating = true;
            }
            this.mListenerState = -1;
            float f10 = this.mTransitionPosition;
            this.mListenerPosition = f10;
            TransitionListener transitionListener2 = this.mTransitionListener;
            if (transitionListener2 != null) {
                transitionListener2.onTransitionChange(this, this.mBeginState, this.mEndState, f10);
            }
            ArrayList<TransitionListener> arrayList3 = this.mTransitionListeners;
            if (arrayList3 != null) {
                Iterator<TransitionListener> it2 = arrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                }
            }
            this.mIsAnimating = true;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int i10, int i11) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionStarted(this, i10, i11);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionStarted(motionLayout, i10, i11);
            }
        }
    }

    private boolean handlesTouchEvent(float f10, float f11, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (handlesTouchEvent(((float) view.getLeft()) + f10, ((float) view.getTop()) + f11, viewGroup.getChildAt(i10), motionEvent)) {
                    return true;
                }
            }
        }
        this.mBoundsCheck.set(((float) view.getLeft()) + f10, ((float) view.getTop()) + f11, f10 + ((float) view.getRight()), f11 + ((float) view.getBottom()));
        if (motionEvent.getAction() == 0) {
            if (!this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) || !view.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        } else if (view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    private void init(AttributeSet attributeSet) {
        MotionScene motionScene;
        int i10;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.mInTransition = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z10 = obtainStyledAttributes.getBoolean(index, z10);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.mDebugPath == 0) {
                        if (obtainStyledAttributes.getBoolean(index, false)) {
                            i10 = 2;
                        } else {
                            i10 = 0;
                        }
                        this.mDebugPath = i10;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.mDebugPath = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.mScene == null) {
                Log.e(TAG, "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            checkStructure();
        }
        if (this.mCurrentState == -1 && (motionScene = this.mScene) != null) {
            this.mCurrentState = motionScene.getStartId();
            this.mBeginState = this.mScene.getStartId();
            this.mEndState = this.mScene.getEndId();
        }
    }

    private void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            if (motionScene.autoTransition(this, this.mCurrentState)) {
                requestLayout();
                return;
            }
            int i10 = this.mCurrentState;
            if (i10 != -1) {
                this.mScene.addOnClickListeners(this, i10);
            }
            if (this.mScene.supportTouch()) {
                this.mScene.setupTouch();
            }
        }
    }

    private void processTransitionCompleted() {
        ArrayList<TransitionListener> arrayList;
        if (this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) {
            this.mIsAnimating = false;
            Iterator<Integer> it = this.mTransitionCompleted.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                TransitionListener transitionListener = this.mTransitionListener;
                if (transitionListener != null) {
                    transitionListener.onTransitionCompleted(this, next.intValue());
                }
                ArrayList<TransitionListener> arrayList2 = this.mTransitionListeners;
                if (arrayList2 != null) {
                    Iterator<TransitionListener> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().onTransitionCompleted(this, next.intValue());
                    }
                }
            }
            this.mTransitionCompleted.clear();
        }
    }

    /* access modifiers changed from: private */
    public void setupMotionViews() {
        float f10;
        float f11;
        int childCount = getChildCount();
        this.mModel.a();
        boolean z10 = true;
        this.mInTransition = true;
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.mScene.gatPathMotionArc();
        int i10 = 0;
        if (gatPathMotionArc != -1) {
            for (int i11 = 0; i11 < childCount; i11++) {
                MotionController motionController = this.mFrameArrayList.get(getChildAt(i11));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
            }
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i12));
            if (motionController2 != null) {
                this.mScene.getKeyFrames(motionController2);
                motionController2.setup(width, height, this.mTransitionDuration, getNanoTime());
            }
        }
        float staggered = this.mScene.getStaggered();
        if (staggered != 0.0f) {
            if (((double) staggered) >= 0.0d) {
                z10 = false;
            }
            float abs = Math.abs(staggered);
            float f12 = -3.4028235E38f;
            float f13 = Float.MAX_VALUE;
            float f14 = -3.4028235E38f;
            float f15 = Float.MAX_VALUE;
            for (int i13 = 0; i13 < childCount; i13++) {
                MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i13));
                if (!Float.isNaN(motionController3.mMotionStagger)) {
                    for (int i14 = 0; i14 < childCount; i14++) {
                        MotionController motionController4 = this.mFrameArrayList.get(getChildAt(i14));
                        if (!Float.isNaN(motionController4.mMotionStagger)) {
                            f13 = Math.min(f13, motionController4.mMotionStagger);
                            f12 = Math.max(f12, motionController4.mMotionStagger);
                        }
                    }
                    while (i10 < childCount) {
                        MotionController motionController5 = this.mFrameArrayList.get(getChildAt(i10));
                        if (!Float.isNaN(motionController5.mMotionStagger)) {
                            motionController5.mStaggerScale = 1.0f / (1.0f - abs);
                            if (z10) {
                                motionController5.mStaggerOffset = abs - (((f12 - motionController5.mMotionStagger) / (f12 - f13)) * abs);
                            } else {
                                motionController5.mStaggerOffset = abs - (((motionController5.mMotionStagger - f13) * abs) / (f12 - f13));
                            }
                        }
                        i10++;
                    }
                    return;
                }
                float finalX = motionController3.getFinalX();
                float finalY = motionController3.getFinalY();
                if (z10) {
                    f11 = finalY - finalX;
                } else {
                    f11 = finalY + finalX;
                }
                f15 = Math.min(f15, f11);
                f14 = Math.max(f14, f11);
            }
            while (i10 < childCount) {
                MotionController motionController6 = this.mFrameArrayList.get(getChildAt(i10));
                float finalX2 = motionController6.getFinalX();
                float finalY2 = motionController6.getFinalY();
                if (z10) {
                    f10 = finalY2 - finalX2;
                } else {
                    f10 = finalY2 + finalX2;
                }
                motionController6.mStaggerScale = 1.0f / (1.0f - abs);
                motionController6.mStaggerOffset = abs - (((f10 - f15) * abs) / (f14 - f15));
                i10++;
            }
        }
    }

    private static boolean willJump(float f10, float f11, float f12) {
        if (f10 > 0.0f) {
            float f13 = f10 / f12;
            return f11 + ((f10 * f13) - (((f12 * f13) * f13) / 2.0f)) > 1.0f;
        }
        float f14 = (-f10) / f12;
        return f11 + ((f10 * f14) + (((f12 * f14) * f14) / 2.0f)) < 0.0f;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList<>();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    /* access modifiers changed from: package-private */
    public void animateTo(float f10) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f11 = this.mTransitionLastPosition;
            float f12 = this.mTransitionPosition;
            if (f11 != f12 && this.mTransitionInstantly) {
                this.mTransitionLastPosition = f12;
            }
            float f13 = this.mTransitionLastPosition;
            if (f13 != f10) {
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = f10;
                this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
                setProgress(this.mTransitionGoalPosition);
                this.mInterpolator = this.mScene.getInterpolator();
                this.mTransitionInstantly = false;
                this.mAnimationStartTime = getNanoTime();
                this.mInTransition = true;
                this.mTransitionPosition = f13;
                this.mTransitionLastPosition = f13;
                invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void disableAutoTransition(boolean z10) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.disableAutoTransition(z10);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        String str;
        evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene != null) {
            if ((this.mDebugPath & 1) == 1 && !isInEditMode()) {
                this.mFrames++;
                long nanoTime = getNanoTime();
                long j10 = this.mLastDrawTime;
                if (j10 != -1) {
                    long j11 = nanoTime - j10;
                    if (j11 > 200000000) {
                        this.mLastFps = ((float) ((int) ((((float) this.mFrames) / (((float) j11) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.mFrames = 0;
                        this.mLastDrawTime = nanoTime;
                    }
                } else {
                    this.mLastDrawTime = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ");
                sb2.append(Debug.getState(this, this.mEndState));
                sb2.append(" (progress: ");
                sb2.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                sb2.append(" ) state=");
                int i10 = this.mCurrentState;
                if (i10 == -1) {
                    str = "undefined";
                } else {
                    str = Debug.getState(this, i10);
                }
                sb2.append(str);
                String sb3 = sb2.toString();
                paint.setColor(ViewCompat.MEASURED_STATE_MASK);
                canvas.drawText(sb3, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb3, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.mDebugPath > 1) {
                if (this.mDevModeDraw == null) {
                    this.mDevModeDraw = new d();
                }
                this.mDevModeDraw.a(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
            }
        }
    }

    public void enableTransition(int i10, boolean z10) {
        MotionScene.Transition transition = getTransition(i10);
        if (z10) {
            transition.setEnable(true);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (transition == motionScene.mCurrentTransition) {
            Iterator<MotionScene.Transition> it = motionScene.getTransitionsWithState(this.mCurrentState).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.mScene.mCurrentTransition = next;
                    break;
                }
            }
        }
        transition.setEnable(false);
    }

    /* access modifiers changed from: package-private */
    public void evaluate(boolean z10) {
        float f10;
        boolean z11;
        boolean z12;
        int i10;
        int i11;
        float f11;
        if (this.mTransitionLastTime == -1) {
            this.mTransitionLastTime = getNanoTime();
        }
        float f12 = this.mTransitionLastPosition;
        if (f12 > 0.0f && f12 < 1.0f) {
            this.mCurrentState = -1;
        }
        boolean z13 = true;
        boolean z14 = false;
        if (this.mKeepAnimating || (this.mInTransition && (z10 || this.mTransitionGoalPosition != f12))) {
            float signum = Math.signum(this.mTransitionGoalPosition - f12);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.mInterpolator;
            if (!(interpolator instanceof MotionInterpolator)) {
                f10 = ((((float) (nanoTime - this.mTransitionLastTime)) * signum) * 1.0E-9f) / this.mTransitionDuration;
                this.mLastVelocity = f10;
            } else {
                f10 = 0.0f;
            }
            float f13 = this.mTransitionLastPosition + f10;
            if (this.mTransitionInstantly) {
                f13 = this.mTransitionGoalPosition;
            }
            int i12 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i12 <= 0 || f13 < this.mTransitionGoalPosition) && (signum > 0.0f || f13 > this.mTransitionGoalPosition)) {
                z11 = false;
            } else {
                f13 = this.mTransitionGoalPosition;
                this.mInTransition = false;
                z11 = true;
            }
            this.mTransitionLastPosition = f13;
            this.mTransitionPosition = f13;
            this.mTransitionLastTime = nanoTime;
            if (interpolator != null && !z11) {
                if (this.mTemporalInterpolator) {
                    f11 = interpolator.getInterpolation(((float) (nanoTime - this.mAnimationStartTime)) * 1.0E-9f);
                    this.mTransitionLastPosition = f11;
                    this.mTransitionLastTime = nanoTime;
                    Interpolator interpolator2 = this.mInterpolator;
                    if (interpolator2 instanceof MotionInterpolator) {
                        float velocity = ((MotionInterpolator) interpolator2).getVelocity();
                        this.mLastVelocity = velocity;
                        if (Math.abs(velocity) * this.mTransitionDuration <= EPSILON) {
                            this.mInTransition = false;
                        }
                        if (velocity > 0.0f && f11 >= 1.0f) {
                            this.mTransitionLastPosition = 1.0f;
                            this.mInTransition = false;
                            f11 = 1.0f;
                        }
                        if (velocity < 0.0f && f11 <= 0.0f) {
                            this.mTransitionLastPosition = 0.0f;
                            this.mInTransition = false;
                            f13 = 0.0f;
                        }
                    }
                } else {
                    f11 = interpolator.getInterpolation(f13);
                    Interpolator interpolator3 = this.mInterpolator;
                    if (interpolator3 instanceof MotionInterpolator) {
                        this.mLastVelocity = ((MotionInterpolator) interpolator3).getVelocity();
                    } else {
                        this.mLastVelocity = ((interpolator3.getInterpolation(f13 + f10) - f11) * signum) / f10;
                    }
                }
                f13 = f11;
            }
            if (Math.abs(this.mLastVelocity) > EPSILON) {
                setState(h.MOVING);
            }
            if ((i12 > 0 && f13 >= this.mTransitionGoalPosition) || (signum <= 0.0f && f13 <= this.mTransitionGoalPosition)) {
                f13 = this.mTransitionGoalPosition;
                this.mInTransition = false;
            }
            int i13 = (f13 > 1.0f ? 1 : (f13 == 1.0f ? 0 : -1));
            if (i13 >= 0 || f13 <= 0.0f) {
                this.mInTransition = false;
                setState(h.FINISHED);
            }
            int childCount = getChildCount();
            this.mKeepAnimating = false;
            long nanoTime2 = getNanoTime();
            this.mPostInterpolationPosition = f13;
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = getChildAt(i14);
                MotionController motionController = this.mFrameArrayList.get(childAt);
                if (motionController != null) {
                    this.mKeepAnimating = motionController.interpolate(childAt, f13, nanoTime2, this.mKeyCache) | this.mKeepAnimating;
                }
            }
            if ((i12 <= 0 || f13 < this.mTransitionGoalPosition) && (signum > 0.0f || f13 > this.mTransitionGoalPosition)) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!this.mKeepAnimating && !this.mInTransition && z12) {
                setState(h.FINISHED);
            }
            if (this.mMeasureDuringTransition) {
                requestLayout();
            }
            this.mKeepAnimating = (!z12) | this.mKeepAnimating;
            if (!(f13 > 0.0f || (i11 = this.mBeginState) == -1 || this.mCurrentState == i11)) {
                this.mCurrentState = i11;
                this.mScene.getConstraintSet(i11).applyCustomAttributes(this);
                setState(h.FINISHED);
                z14 = true;
            }
            if (((double) f13) >= 1.0d && this.mCurrentState != (i10 = this.mEndState)) {
                this.mCurrentState = i10;
                this.mScene.getConstraintSet(i10).applyCustomAttributes(this);
                setState(h.FINISHED);
                z14 = true;
            }
            if (this.mKeepAnimating || this.mInTransition) {
                invalidate();
            } else if ((i12 > 0 && i13 == 0) || (signum < 0.0f && f13 == 0.0f)) {
                setState(h.FINISHED);
            }
            if ((!this.mKeepAnimating && this.mInTransition && i12 > 0 && i13 == 0) || (signum < 0.0f && f13 == 0.0f)) {
                onNewStateAttachHandlers();
            }
        }
        float f14 = this.mTransitionLastPosition;
        if (f14 >= 1.0f) {
            int i15 = this.mCurrentState;
            int i16 = this.mEndState;
            if (i15 == i16) {
                z13 = z14;
            }
            this.mCurrentState = i16;
        } else {
            if (f14 <= 0.0f) {
                int i17 = this.mCurrentState;
                int i18 = this.mBeginState;
                if (i17 == i18) {
                    z13 = z14;
                }
                this.mCurrentState = i18;
            }
            this.mNeedsFireTransitionCompleted |= z14;
            if (z14 && !this.mInLayout) {
                requestLayout();
            }
            this.mTransitionPosition = this.mTransitionLastPosition;
        }
        z14 = z13;
        this.mNeedsFireTransitionCompleted |= z14;
        requestLayout();
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    /* access modifiers changed from: protected */
    public void fireTransitionCompleted() {
        int i10;
        ArrayList<TransitionListener> arrayList;
        if ((this.mTransitionListener != null || ((arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty())) && this.mListenerState == -1) {
            this.mListenerState = this.mCurrentState;
            if (!this.mTransitionCompleted.isEmpty()) {
                ArrayList<Integer> arrayList2 = this.mTransitionCompleted;
                i10 = arrayList2.get(arrayList2.size() - 1).intValue();
            } else {
                i10 = -1;
            }
            int i11 = this.mCurrentState;
            if (!(i10 == i11 || i11 == -1)) {
                this.mTransitionCompleted.add(Integer.valueOf(i11));
            }
        }
        processTransitionCompleted();
    }

    public void fireTrigger(int i10, boolean z10, float f10) {
        TransitionListener transitionListener = this.mTransitionListener;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i10, z10, f10);
        }
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) {
            Iterator<TransitionListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i10, z10, f10);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void getAnchorDpDt(int i10, float f10, float f11, float f12, float[] fArr) {
        String str;
        HashMap<View, MotionController> hashMap = this.mFrameArrayList;
        View viewById = getViewById(i10);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.getDpDt(f10, f11, f12, fArr);
            float y10 = viewById.getY();
            this.lastPos = f10;
            this.lastY = y10;
            return;
        }
        if (viewById == null) {
            str = "" + i10;
        } else {
            str = viewById.getContext().getResources().getResourceName(i10);
        }
        Log.w(TAG, "WARNING could not find view id " + str);
    }

    public ConstraintSet getConstraintSet(int i10) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(i10);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    /* access modifiers changed from: package-private */
    public String getConstraintSetNames(int i10) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i10);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean z10) {
        int i10;
        if (z10) {
            i10 = 2;
        } else {
            i10 = 1;
        }
        this.mDebugPath = i10;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool == null) {
            this.mDesignTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int i10) {
        return this.mScene.getTransitionById(i10);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new g();
        }
        this.mStateCache.c();
        return this.mStateCache.b();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mTransitionDuration = ((float) motionScene.getDuration()) / 1000.0f;
        }
        return (long) (this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f10, float f11, float[] fArr, int i10) {
        float f12;
        float f13 = this.mLastVelocity;
        float f14 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            float signum = Math.signum(this.mTransitionGoalPosition - f14);
            float interpolation = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + EPSILON);
            f12 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f13 = (signum * ((interpolation - f12) / EPSILON)) / this.mTransitionDuration;
        } else {
            f12 = f14;
        }
        Interpolator interpolator = this.mInterpolator;
        if (interpolator instanceof MotionInterpolator) {
            f13 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.mFrameArrayList.get(view);
        if ((i10 & 1) == 0) {
            motionController.getPostLayoutDvDp(f12, view.getWidth(), view.getHeight(), f10, f11, fArr);
        } else {
            motionController.getDpDt(f12, f10, f11, fArr);
        }
        if (i10 < 2) {
            fArr[0] = fArr[0] * f13;
            fArr[1] = fArr[1] * f13;
        }
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public void loadLayoutDescription(int i10) {
        if (i10 != 0) {
            try {
                this.mScene = new MotionScene(getContext(), this, i10);
                if (isAttachedToWindow()) {
                    this.mScene.readFallback(this);
                    this.mModel.d(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                    rebuildScene();
                    this.mScene.setRtl(isRtl());
                }
            } catch (Exception e10) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e10);
            }
        } else {
            this.mScene = null;
        }
    }

    /* access modifiers changed from: package-private */
    public int lookUpConstraintId(String str) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    /* access modifiers changed from: protected */
    public MotionTracker obtainVelocityTracker() {
        return f.a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i10;
        super.onAttachedToWindow();
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (i10 = this.mCurrentState) == -1)) {
            ConstraintSet constraintSet = motionScene.getConstraintSet(i10);
            this.mScene.readFallback(this);
            if (constraintSet != null) {
                constraintSet.applyTo(this);
            }
            this.mBeginState = this.mCurrentState;
        }
        onNewStateAttachHandlers();
        g gVar = this.mStateCache;
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionScene.Transition transition;
        d touchResponse;
        int k10;
        RectF j10;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && this.mInteractionEnabled && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled() && (touchResponse = transition.getTouchResponse()) != null && ((motionEvent.getAction() != 0 || (j10 = touchResponse.j(this, new RectF())) == null || j10.contains(motionEvent.getX(), motionEvent.getY())) && (k10 = touchResponse.k()) != -1)) {
            View view = this.mRegionView;
            if (view == null || view.getId() != k10) {
                this.mRegionView = findViewById(k10);
            }
            View view2 = this.mRegionView;
            if (view2 != null) {
                this.mBoundsCheck.set((float) view2.getLeft(), (float) this.mRegionView.getTop(), (float) this.mRegionView.getRight(), (float) this.mRegionView.getBottom());
                if (this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY()) && !handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.mInLayout = true;
        try {
            if (this.mScene == null) {
                super.onLayout(z10, i10, i11, i12, i13);
                return;
            }
            int i14 = i12 - i10;
            int i15 = i13 - i11;
            if (!(this.mLastLayoutWidth == i14 && this.mLastLayoutHeight == i15)) {
                rebuildScene();
                evaluate(true);
            }
            this.mLastLayoutWidth = i14;
            this.mLastLayoutHeight = i15;
            this.mOldWidth = i14;
            this.mOldHeight = i15;
            this.mInLayout = false;
        } finally {
            this.mInLayout = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        boolean z10;
        if (this.mScene == null) {
            super.onMeasure(i10, i11);
            return;
        }
        boolean z11 = false;
        if (this.mLastWidthMeasureSpec == i10 && this.mLastHeightMeasureSpec == i11) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            onNewStateAttachHandlers();
            processTransitionCompleted();
            z10 = true;
        }
        if (this.mDirtyHierarchy) {
            z10 = true;
        }
        this.mLastWidthMeasureSpec = i10;
        this.mLastHeightMeasureSpec = i11;
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if ((z10 || this.mModel.e(startId, endId)) && this.mBeginState != -1) {
            super.onMeasure(i10, i11);
            this.mModel.d(this.mLayoutWidget, this.mScene.getConstraintSet(startId), this.mScene.getConstraintSet(endId));
            this.mModel.g();
            this.mModel.h(startId, endId);
        } else {
            z11 = true;
        }
        if (this.mMeasureDuringTransition || z11) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop;
            int i12 = this.mWidthMeasureMode;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                int i13 = this.mStartWrapWidth;
                width = (int) (((float) i13) + (this.mPostInterpolationPosition * ((float) (this.mEndWrapWidth - i13))));
                requestLayout();
            }
            int i14 = this.mHeightMeasureMode;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                int i15 = this.mStartWrapHeight;
                height = (int) (((float) i15) + (this.mPostInterpolationPosition * ((float) (this.mEndWrapHeight - i15))));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        evaluateLayout();
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        MotionScene.Transition transition;
        d touchResponse;
        int k10;
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (transition = motionScene.mCurrentTransition) != null && transition.isEnabled()) {
            MotionScene.Transition transition2 = this.mScene.mCurrentTransition;
            if (transition2 == null || !transition2.isEnabled() || (touchResponse = transition2.getTouchResponse()) == null || (k10 = touchResponse.k()) == -1 || view.getId() == k10) {
                MotionScene motionScene2 = this.mScene;
                if (motionScene2 != null && motionScene2.getMoveWhenScrollAtTop()) {
                    float f10 = this.mTransitionPosition;
                    if ((f10 == 1.0f || f10 == 0.0f) && view.canScrollVertically(-1)) {
                        return;
                    }
                }
                if (!(transition2.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().d() & 1) == 0)) {
                    float progressDirection = this.mScene.getProgressDirection((float) i10, (float) i11);
                    float f11 = this.mTransitionLastPosition;
                    if ((f11 <= 0.0f && progressDirection < 0.0f) || (f11 >= 1.0f && progressDirection > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new a(view));
                        return;
                    }
                }
                float f12 = this.mTransitionPosition;
                long nanoTime = getNanoTime();
                float f13 = (float) i10;
                this.mScrollTargetDX = f13;
                float f14 = (float) i11;
                this.mScrollTargetDY = f14;
                this.mScrollTargetDT = (float) (((double) (nanoTime - this.mScrollTargetTime)) * 1.0E-9d);
                this.mScrollTargetTime = nanoTime;
                this.mScene.processScrollMove(f13, f14);
                if (f12 != this.mTransitionPosition) {
                    iArr[0] = i10;
                    iArr[1] = i11;
                }
                evaluate(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mUndergoingMotion = true;
                }
            }
        }
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
    }

    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
    }

    public void onRtlPropertiesChanged(int i10) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        MotionScene.Transition transition;
        MotionScene motionScene = this.mScene;
        if (motionScene == null || (transition = motionScene.mCurrentTransition) == null || transition.getTouchResponse() == null || (this.mScene.mCurrentTransition.getTouchResponse().d() & 2) != 0) {
            return false;
        }
        return true;
    }

    public void onStopNestedScroll(View view, int i10) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            float f10 = this.mScrollTargetDX;
            float f11 = this.mScrollTargetDT;
            motionScene.processScrollUp(f10 / f11, this.mScrollTargetDY / f11);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null || !this.mInteractionEnabled || !motionScene.supportTouch()) {
            return super.onTouchEvent(motionEvent);
        }
        MotionScene.Transition transition = this.mScene.mCurrentTransition;
        if (transition != null && !transition.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, getCurrentState(), this);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.mTransitionListeners == null) {
                this.mTransitionListeners = new ArrayList<>();
            }
            this.mTransitionListeners.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.mOnShowHelpers == null) {
                    this.mOnShowHelpers = new ArrayList<>();
                }
                this.mOnShowHelpers.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.mOnHideHelpers == null) {
                    this.mOnHideHelpers = new ArrayList<>();
                }
                this.mOnHideHelpers.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.mOnHideHelpers;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    /* access modifiers changed from: protected */
    public void parseLayoutDescription(int i10) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e(TAG, "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.g();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(transitionListener);
    }

    public void requestLayout() {
        MotionScene motionScene;
        MotionScene.Transition transition;
        if (this.mMeasureDuringTransition || this.mCurrentState != -1 || (motionScene = this.mScene) == null || (transition = motionScene.mCurrentTransition) == null || transition.getLayoutDuringTransition() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i10) {
        this.mDebugPath = i10;
        invalidate();
    }

    public void setInteractionEnabled(boolean z10) {
        this.mInteractionEnabled = z10;
    }

    public void setInterpolatedProgress(float f10) {
        if (this.mScene != null) {
            setState(h.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f10));
                return;
            }
        }
        setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mOnHideHelpers.get(i10).setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.mOnShowHelpers.get(i10).setProgress(f10);
            }
        }
    }

    public void setProgress(float f10, float f11) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new g();
            }
            this.mStateCache.e(f10);
            this.mStateCache.h(f11);
            return;
        }
        setProgress(f10);
        setState(h.MOVING);
        this.mLastVelocity = f11;
        animateTo(1.0f);
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    /* access modifiers changed from: package-private */
    public void setState(h hVar) {
        h hVar2 = h.FINISHED;
        if (hVar != hVar2 || this.mCurrentState != -1) {
            h hVar3 = this.mTransitionState;
            this.mTransitionState = hVar;
            h hVar4 = h.MOVING;
            if (hVar3 == hVar4 && hVar == hVar4) {
                fireTransitionChange();
            }
            int i10 = b.f14567a[hVar3.ordinal()];
            if (i10 == 1 || i10 == 2) {
                if (hVar == hVar4) {
                    fireTransitionChange();
                }
                if (hVar == hVar2) {
                    fireTransitionCompleted();
                }
            } else if (i10 == 3 && hVar == hVar2) {
                fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int i10, int i11) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new g();
            }
            this.mStateCache.f(i10);
            this.mStateCache.d(i11);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            this.mBeginState = i10;
            this.mEndState = i11;
            motionScene.setTransition(i10, i11);
            this.mModel.d(this.mLayoutWidget, this.mScene.getConstraintSet(i10), this.mScene.getConstraintSet(i11));
            rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            transitionToStart();
        }
    }

    public void setTransitionDuration(int i10) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e(TAG, "MotionScene not defined");
        } else {
            motionScene.setDuration(i10);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new g();
        }
        this.mStateCache.g(bundle);
        if (isAttachedToWindow()) {
            this.mStateCache.a();
        }
    }

    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.mBeginState) + "->" + Debug.getName(context, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int i10, float f10, float f11) {
        if (this.mScene != null && this.mTransitionLastPosition != f10) {
            this.mTemporalInterpolator = true;
            this.mAnimationStartTime = getNanoTime();
            float duration = ((float) this.mScene.getDuration()) / 1000.0f;
            this.mTransitionDuration = duration;
            this.mTransitionGoalPosition = f10;
            this.mInTransition = true;
            if (i10 == 0 || i10 == 1 || i10 == 2) {
                if (i10 == 1) {
                    f10 = 0.0f;
                } else if (i10 == 2) {
                    f10 = 1.0f;
                }
                this.mStopLogic.config(this.mTransitionLastPosition, f10, f11, duration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                int i11 = this.mCurrentState;
                this.mTransitionGoalPosition = f10;
                this.mCurrentState = i11;
                this.mInterpolator = this.mStopLogic;
            } else if (i10 == 4) {
                this.mDecelerateLogic.a(f11, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
            } else if (i10 == 5) {
                if (willJump(f11, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                    this.mDecelerateLogic.a(f11, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                    this.mInterpolator = this.mDecelerateLogic;
                } else {
                    this.mStopLogic.config(this.mTransitionLastPosition, f10, f11, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                    this.mLastVelocity = 0.0f;
                    int i12 = this.mCurrentState;
                    this.mTransitionGoalPosition = f10;
                    this.mCurrentState = i12;
                    this.mInterpolator = this.mStopLogic;
                }
            }
            this.mTransitionInstantly = false;
            this.mAnimationStartTime = getNanoTime();
            invalidate();
        }
    }

    public void transitionToEnd() {
        animateTo(1.0f);
    }

    public void transitionToStart() {
        animateTo(0.0f);
    }

    public void transitionToState(int i10) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new g();
            }
            this.mStateCache.d(i10);
            return;
        }
        transitionToState(i10, -1, -1);
    }

    public void updateState(int i10, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(i10, constraintSet);
        }
        updateState();
        if (this.mCurrentState == i10) {
            constraintSet.applyTo(this);
        }
    }

    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (!(!this.mUndergoingMotion && i10 == 0 && i11 == 0)) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
        }
        this.mUndergoingMotion = false;
    }

    public void transitionToState(int i10, int i11, int i12) {
        StateSet stateSet;
        int convertToConstraintSet;
        MotionScene motionScene = this.mScene;
        if (!(motionScene == null || (stateSet = motionScene.mStateSet) == null || (convertToConstraintSet = stateSet.convertToConstraintSet(this.mCurrentState, i10, (float) i11, (float) i12)) == -1)) {
            i10 = convertToConstraintSet;
        }
        int i13 = this.mCurrentState;
        if (i13 != i10) {
            if (this.mBeginState == i10) {
                animateTo(0.0f);
            } else if (this.mEndState == i10) {
                animateTo(1.0f);
            } else {
                this.mEndState = i10;
                if (i13 != -1) {
                    setTransition(i13, i10);
                    animateTo(1.0f);
                    this.mTransitionLastPosition = 0.0f;
                    transitionToEnd();
                    return;
                }
                this.mTemporalInterpolator = false;
                this.mTransitionGoalPosition = 1.0f;
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mTransitionLastTime = getNanoTime();
                this.mAnimationStartTime = getNanoTime();
                this.mTransitionInstantly = false;
                this.mInterpolator = null;
                this.mTransitionDuration = ((float) this.mScene.getDuration()) / 1000.0f;
                this.mBeginState = -1;
                this.mScene.setTransition(-1, this.mEndState);
                this.mScene.getStartId();
                int childCount = getChildCount();
                this.mFrameArrayList.clear();
                for (int i14 = 0; i14 < childCount; i14++) {
                    View childAt = getChildAt(i14);
                    this.mFrameArrayList.put(childAt, new MotionController(childAt));
                }
                this.mInTransition = true;
                this.mModel.d(this.mLayoutWidget, (ConstraintSet) null, this.mScene.getConstraintSet(i10));
                rebuildScene();
                this.mModel.a();
                computeCurrentPositions();
                int width = getWidth();
                int height = getHeight();
                for (int i15 = 0; i15 < childCount; i15++) {
                    MotionController motionController = this.mFrameArrayList.get(getChildAt(i15));
                    this.mScene.getKeyFrames(motionController);
                    motionController.setup(width, height, this.mTransitionDuration, getNanoTime());
                }
                float staggered = this.mScene.getStaggered();
                if (staggered != 0.0f) {
                    float f10 = Float.MAX_VALUE;
                    float f11 = -3.4028235E38f;
                    for (int i16 = 0; i16 < childCount; i16++) {
                        MotionController motionController2 = this.mFrameArrayList.get(getChildAt(i16));
                        float finalY = motionController2.getFinalY() + motionController2.getFinalX();
                        f10 = Math.min(f10, finalY);
                        f11 = Math.max(f11, finalY);
                    }
                    for (int i17 = 0; i17 < childCount; i17++) {
                        MotionController motionController3 = this.mFrameArrayList.get(getChildAt(i17));
                        float finalX = motionController3.getFinalX();
                        float finalY2 = motionController3.getFinalY();
                        motionController3.mStaggerScale = 1.0f / (1.0f - staggered);
                        motionController3.mStaggerOffset = staggered - ((((finalX + finalY2) - f10) * staggered) / (f11 - f10));
                    }
                }
                this.mTransitionPosition = 0.0f;
                this.mTransitionLastPosition = 0.0f;
                this.mInTransition = true;
                invalidate();
            }
        }
    }

    public void updateState() {
        this.mModel.d(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        rebuildScene();
    }

    public void setProgress(float f10) {
        if (!isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new g();
            }
            this.mStateCache.e(f10);
            return;
        }
        if (f10 <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                setState(h.FINISHED);
            }
        } else if (f10 >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                setState(h.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            setState(h.MOVING);
        }
        if (this.mScene != null) {
            this.mTransitionInstantly = true;
            this.mTransitionGoalPosition = f10;
            this.mTransitionPosition = f10;
            this.mTransitionLastTime = -1;
            this.mAnimationStartTime = -1;
            this.mInterpolator = null;
            this.mInTransition = true;
            invalidate();
        }
    }

    public void setState(int i10, int i11, int i12) {
        setState(h.SETUP);
        this.mCurrentState = i10;
        this.mBeginState = -1;
        this.mEndState = -1;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.updateConstraints(i10, (float) i11, (float) i12);
            return;
        }
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.getConstraintSet(i10).applyTo(this);
        }
    }

    public void setTransition(int i10) {
        float f10;
        if (this.mScene != null) {
            MotionScene.Transition transition = getTransition(i10);
            this.mBeginState = transition.getStartConstraintSetId();
            this.mEndState = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.mStateCache == null) {
                    this.mStateCache = new g();
                }
                this.mStateCache.f(this.mBeginState);
                this.mStateCache.d(this.mEndState);
                return;
            }
            int i11 = this.mCurrentState;
            float f11 = 0.0f;
            if (i11 == this.mBeginState) {
                f10 = 0.0f;
            } else {
                f10 = i11 == this.mEndState ? 1.0f : Float.NaN;
            }
            this.mScene.setTransition(transition);
            this.mModel.d(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            rebuildScene();
            if (!Float.isNaN(f10)) {
                f11 = f10;
            }
            this.mTransitionLastPosition = f11;
            if (Float.isNaN(f10)) {
                Log.v(TAG, Debug.getLocation() + " transitionToStart ");
                transitionToStart();
                return;
            }
            setProgress(f10);
        }
    }

    private void checkStructure(int i10, ConstraintSet constraintSet) {
        String name = Debug.getName(getContext(), i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w(TAG, "CHECK: " + name + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.getConstraint(id2) == null) {
                Log.w(TAG, "CHECK: " + name + " NO CONSTRAINTS for " + Debug.getName(childAt));
            }
        }
        int[] knownIds = constraintSet.getKnownIds();
        for (int i12 = 0; i12 < knownIds.length; i12++) {
            int i13 = knownIds[i12];
            String name2 = Debug.getName(getContext(), i13);
            if (findViewById(knownIds[i12]) == null) {
                Log.w(TAG, "CHECK: " + name + " NO View matches id " + name2);
            }
            if (constraintSet.getHeight(i13) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i13) == -1) {
                Log.w(TAG, "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        setState(h.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        this.mTransitionLastTime = transition.isTransitionFlag(1) ? -1 : getNanoTime();
        int startId = this.mScene.getStartId();
        int endId = this.mScene.getEndId();
        if (startId != this.mBeginState || endId != this.mEndState) {
            this.mBeginState = startId;
            this.mEndState = endId;
            this.mScene.setTransition(startId, endId);
            this.mModel.d(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
            this.mModel.h(this.mBeginState, this.mEndState);
            this.mModel.g();
            rebuildScene();
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    private void checkStructure(MotionScene.Transition transition) {
        Log.v(TAG, "CHECK: transition = " + transition.debugString(getContext()));
        Log.v(TAG, "CHECK: transition.setDuration = " + transition.getDuration());
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e(TAG, "CHECK: start and end constraint set should not be the same!");
        }
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(attributeSet);
    }
}
