package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.transition.ArcMotion;
import androidx.transition.PathMotion;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.transition.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialContainerTransform extends Transition {
    private static final c DEFAULT_ENTER_THRESHOLDS = new c(new ProgressThresholds(0.0f, 0.25f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.75f), (a) null);
    private static final c DEFAULT_ENTER_THRESHOLDS_ARC = new c(new ProgressThresholds(0.1f, 0.4f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 1.0f), new ProgressThresholds(0.1f, 0.9f), (a) null);
    private static final c DEFAULT_RETURN_THRESHOLDS = new c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 1.0f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.3f, 0.9f), (a) null);
    private static final c DEFAULT_RETURN_THRESHOLDS_ARC = new c(new ProgressThresholds(0.6f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.0f, 0.9f), new ProgressThresholds(0.2f, 0.9f), (a) null);
    private static final float ELEVATION_NOT_SET = -1.0f;
    public static final int FADE_MODE_CROSS = 2;
    public static final int FADE_MODE_IN = 0;
    public static final int FADE_MODE_OUT = 1;
    public static final int FADE_MODE_THROUGH = 3;
    public static final int FIT_MODE_AUTO = 0;
    public static final int FIT_MODE_HEIGHT = 2;
    public static final int FIT_MODE_WIDTH = 1;
    private static final String PROP_BOUNDS = "materialContainerTransition:bounds";
    private static final String PROP_SHAPE_APPEARANCE = "materialContainerTransition:shapeAppearance";
    private static final String TAG = "MaterialContainerTransform";
    public static final int TRANSITION_DIRECTION_AUTO = 0;
    public static final int TRANSITION_DIRECTION_ENTER = 1;
    public static final int TRANSITION_DIRECTION_RETURN = 2;
    private static final String[] TRANSITION_PROPS = {PROP_BOUNDS, PROP_SHAPE_APPEARANCE};
    private boolean appliedThemeValues = false;
    @ColorInt
    private int containerColor = 0;
    private boolean drawDebugEnabled = false;
    @IdRes
    private int drawingViewId = 16908290;
    private boolean elevationShadowEnabled;
    @ColorInt
    private int endContainerColor = 0;
    private float endElevation;
    @Nullable
    private ShapeAppearanceModel endShapeAppearanceModel;
    @Nullable
    private View endView;
    @IdRes
    private int endViewId = -1;
    private int fadeMode = 0;
    @Nullable
    private ProgressThresholds fadeProgressThresholds;
    private int fitMode = 0;
    /* access modifiers changed from: private */
    public boolean holdAtEndEnabled = false;
    private boolean pathMotionCustom = false;
    @Nullable
    private ProgressThresholds scaleMaskProgressThresholds;
    @Nullable
    private ProgressThresholds scaleProgressThresholds;
    @ColorInt
    private int scrimColor = 1375731712;
    @Nullable
    private ProgressThresholds shapeMaskProgressThresholds;
    @ColorInt
    private int startContainerColor = 0;
    private float startElevation;
    @Nullable
    private ShapeAppearanceModel startShapeAppearanceModel;
    @Nullable
    private View startView;
    @IdRes
    private int startViewId = -1;
    private int transitionDirection = 0;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FadeMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FitMode {
    }

    public static class ProgressThresholds {
        /* access modifiers changed from: private */
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float end;
        /* access modifiers changed from: private */
        @FloatRange(from = 0.0d, to = 1.0d)
        public final float start;

        public ProgressThresholds(@FloatRange(from = 0.0d, to = 1.0d) float f10, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
            this.start = f10;
            this.end = f11;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getEnd() {
            return this.end;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getStart() {
            return this.start;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TransitionDirection {
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f8783a;

        a(d dVar) {
            this.f8783a = dVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f8783a.o(valueAnimator.getAnimatedFraction());
        }
    }

    class b extends i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f8785a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f8786b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f8787c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f8788d;

        b(View view, d dVar, View view2, View view3) {
            this.f8785a = view;
            this.f8786b = dVar;
            this.f8787c = view2;
            this.f8788d = view3;
        }

        public void onTransitionEnd(Transition transition) {
            MaterialContainerTransform.this.removeListener(this);
            if (!MaterialContainerTransform.this.holdAtEndEnabled) {
                this.f8787c.setAlpha(1.0f);
                this.f8788d.setAlpha(1.0f);
                ViewUtils.getOverlay(this.f8785a).remove(this.f8786b);
            }
        }

        public void onTransitionStart(Transition transition) {
            ViewUtils.getOverlay(this.f8785a).add(this.f8786b);
            this.f8787c.setAlpha(0.0f);
            this.f8788d.setAlpha(0.0f);
        }
    }

    private static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ProgressThresholds f8790a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ProgressThresholds f8791b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final ProgressThresholds f8792c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final ProgressThresholds f8793d;

        /* synthetic */ c(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4, a aVar) {
            this(progressThresholds, progressThresholds2, progressThresholds3, progressThresholds4);
        }

        private c(ProgressThresholds progressThresholds, ProgressThresholds progressThresholds2, ProgressThresholds progressThresholds3, ProgressThresholds progressThresholds4) {
            this.f8790a = progressThresholds;
            this.f8791b = progressThresholds2;
            this.f8792c = progressThresholds3;
            this.f8793d = progressThresholds4;
        }
    }

    private static final class d extends Drawable {
        private final c A;
        private final a B;
        private final d C;
        private final boolean D;
        private final Paint E;
        private final Path F;
        private c G;
        private f H;
        private RectF I;
        private float J;
        private float K;
        private float L;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final View f8794a;

        /* renamed from: b  reason: collision with root package name */
        private final RectF f8795b;

        /* renamed from: c  reason: collision with root package name */
        private final ShapeAppearanceModel f8796c;

        /* renamed from: d  reason: collision with root package name */
        private final float f8797d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final View f8798e;

        /* renamed from: f  reason: collision with root package name */
        private final RectF f8799f;

        /* renamed from: g  reason: collision with root package name */
        private final ShapeAppearanceModel f8800g;

        /* renamed from: h  reason: collision with root package name */
        private final float f8801h;

        /* renamed from: i  reason: collision with root package name */
        private final Paint f8802i;

        /* renamed from: j  reason: collision with root package name */
        private final Paint f8803j;

        /* renamed from: k  reason: collision with root package name */
        private final Paint f8804k;

        /* renamed from: l  reason: collision with root package name */
        private final Paint f8805l;

        /* renamed from: m  reason: collision with root package name */
        private final Paint f8806m;

        /* renamed from: n  reason: collision with root package name */
        private final g f8807n;

        /* renamed from: o  reason: collision with root package name */
        private final PathMeasure f8808o;

        /* renamed from: p  reason: collision with root package name */
        private final float f8809p;

        /* renamed from: q  reason: collision with root package name */
        private final float[] f8810q;

        /* renamed from: r  reason: collision with root package name */
        private final boolean f8811r;

        /* renamed from: s  reason: collision with root package name */
        private final float f8812s;

        /* renamed from: t  reason: collision with root package name */
        private final float f8813t;

        /* renamed from: u  reason: collision with root package name */
        private final boolean f8814u;

        /* renamed from: v  reason: collision with root package name */
        private final MaterialShapeDrawable f8815v;

        /* renamed from: w  reason: collision with root package name */
        private final RectF f8816w;

        /* renamed from: x  reason: collision with root package name */
        private final RectF f8817x;

        /* renamed from: y  reason: collision with root package name */
        private final RectF f8818y;

        /* renamed from: z  reason: collision with root package name */
        private final RectF f8819z;

        class a implements j.c {
            a() {
            }

            public void a(Canvas canvas) {
                d.this.f8794a.draw(canvas);
            }
        }

        class b implements j.c {
            b() {
            }

            public void a(Canvas canvas) {
                d.this.f8798e.draw(canvas);
            }
        }

        /* synthetic */ d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f10, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f11, int i10, int i11, int i12, int i13, boolean z10, boolean z11, a aVar, d dVar, c cVar, boolean z12, a aVar2) {
            this(pathMotion, view, rectF, shapeAppearanceModel, f10, view2, rectF2, shapeAppearanceModel2, f11, i10, i11, i12, i13, z10, z11, aVar, dVar, cVar, z12);
        }

        private static float d(RectF rectF, float f10) {
            return ((rectF.centerX() / (f10 / 2.0f)) - 1.0f) * 0.3f;
        }

        private static float e(RectF rectF, float f10) {
            return (rectF.centerY() / f10) * 1.5f;
        }

        private void f(Canvas canvas, RectF rectF, Path path, int i10) {
            PointF m10 = m(rectF);
            if (this.L == 0.0f) {
                path.reset();
                path.moveTo(m10.x, m10.y);
                return;
            }
            path.lineTo(m10.x, m10.y);
            this.E.setColor(i10);
            canvas.drawPath(path, this.E);
        }

        private void g(Canvas canvas, RectF rectF, int i10) {
            this.E.setColor(i10);
            canvas.drawRect(rectF, this.E);
        }

        private void h(Canvas canvas) {
            canvas.save();
            canvas.clipPath(this.f8807n.d(), Region.Op.DIFFERENCE);
            if (Build.VERSION.SDK_INT > 28) {
                j(canvas);
            } else {
                i(canvas);
            }
            canvas.restore();
        }

        private void i(Canvas canvas) {
            MaterialShapeDrawable materialShapeDrawable = this.f8815v;
            RectF rectF = this.I;
            materialShapeDrawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            this.f8815v.setElevation(this.J);
            this.f8815v.setShadowVerticalOffset((int) this.K);
            this.f8815v.setShapeAppearanceModel(this.f8807n.c());
            this.f8815v.draw(canvas);
        }

        private void j(Canvas canvas) {
            ShapeAppearanceModel c10 = this.f8807n.c();
            if (c10.isRoundRect(this.I)) {
                float cornerSize = c10.getTopLeftCornerSize().getCornerSize(this.I);
                canvas.drawRoundRect(this.I, cornerSize, cornerSize, this.f8805l);
                return;
            }
            canvas.drawPath(this.f8807n.d(), this.f8805l);
        }

        private void k(Canvas canvas) {
            n(canvas, this.f8804k);
            Rect bounds = getBounds();
            RectF rectF = this.f8818y;
            j.t(canvas, bounds, rectF.left, rectF.top, this.H.f8839b, this.G.f8834b, new b());
        }

        private void l(Canvas canvas) {
            n(canvas, this.f8803j);
            Rect bounds = getBounds();
            RectF rectF = this.f8816w;
            j.t(canvas, bounds, rectF.left, rectF.top, this.H.f8838a, this.G.f8833a, new a());
        }

        private static PointF m(RectF rectF) {
            return new PointF(rectF.centerX(), rectF.top);
        }

        private void n(Canvas canvas, Paint paint) {
            if (paint.getColor() != 0 && paint.getAlpha() > 0) {
                canvas.drawRect(getBounds(), paint);
            }
        }

        /* access modifiers changed from: private */
        public void o(float f10) {
            if (this.L != f10) {
                p(f10);
            }
        }

        private void p(float f10) {
            float f11;
            float f12;
            float f13;
            RectF rectF;
            this.L = f10;
            Paint paint = this.f8806m;
            if (this.f8811r) {
                f11 = j.j(0.0f, 255.0f, f10);
            } else {
                f11 = j.j(255.0f, 0.0f, f10);
            }
            paint.setAlpha((int) f11);
            this.f8808o.getPosTan(this.f8809p * f10, this.f8810q, (float[]) null);
            float[] fArr = this.f8810q;
            float f14 = fArr[0];
            float f15 = fArr[1];
            int i10 = (f10 > 1.0f ? 1 : (f10 == 1.0f ? 0 : -1));
            if (i10 > 0 || f10 < 0.0f) {
                if (i10 > 0) {
                    f13 = (f10 - 1.0f) / 0.00999999f;
                    f12 = 0.99f;
                } else {
                    f12 = 0.01f;
                    f13 = (f10 / 0.01f) * -1.0f;
                }
                this.f8808o.getPosTan(this.f8809p * f12, fArr, (float[]) null);
                float[] fArr2 = this.f8810q;
                f14 += (f14 - fArr2[0]) * f13;
                f15 += (f15 - fArr2[1]) * f13;
            }
            float f16 = f14;
            float f17 = f15;
            float floatValue = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f8791b.start))).floatValue();
            float floatValue2 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f8791b.end))).floatValue();
            f a10 = this.C.a(f10, floatValue, floatValue2, this.f8795b.width(), this.f8795b.height(), this.f8799f.width(), this.f8799f.height());
            this.H = a10;
            RectF rectF2 = this.f8816w;
            float f18 = a10.f8840c;
            rectF2.set(f16 - (f18 / 2.0f), f17, (f18 / 2.0f) + f16, a10.f8841d + f17);
            RectF rectF3 = this.f8818y;
            f fVar = this.H;
            float f19 = fVar.f8842e;
            rectF3.set(f16 - (f19 / 2.0f), f17, f16 + (f19 / 2.0f), fVar.f8843f + f17);
            this.f8817x.set(this.f8816w);
            this.f8819z.set(this.f8818y);
            float floatValue3 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f8792c.start))).floatValue();
            float floatValue4 = ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f8792c.end))).floatValue();
            boolean b10 = this.C.b(this.H);
            if (b10) {
                rectF = this.f8817x;
            } else {
                rectF = this.f8819z;
            }
            float k10 = j.k(0.0f, 1.0f, floatValue3, floatValue4, f10);
            if (!b10) {
                k10 = 1.0f - k10;
            }
            this.C.c(rectF, k10, this.H);
            this.I = new RectF(Math.min(this.f8817x.left, this.f8819z.left), Math.min(this.f8817x.top, this.f8819z.top), Math.max(this.f8817x.right, this.f8819z.right), Math.max(this.f8817x.bottom, this.f8819z.bottom));
            this.f8807n.b(f10, this.f8796c, this.f8800g, this.f8816w, this.f8817x, this.f8819z, this.A.f8793d);
            this.J = j.j(this.f8797d, this.f8801h, f10);
            float d10 = d(this.I, this.f8812s);
            float e10 = e(this.I, this.f8813t);
            float f20 = this.J;
            float f21 = (float) ((int) (e10 * f20));
            this.K = f21;
            this.f8805l.setShadowLayer(f20, (float) ((int) (d10 * f20)), f21, 754974720);
            this.G = this.B.a(f10, ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f8790a.start))).floatValue(), ((Float) Preconditions.checkNotNull(Float.valueOf(this.A.f8790a.end))).floatValue(), 0.35f);
            if (this.f8803j.getColor() != 0) {
                this.f8803j.setAlpha(this.G.f8833a);
            }
            if (this.f8804k.getColor() != 0) {
                this.f8804k.setAlpha(this.G.f8834b);
            }
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            int i10;
            if (this.f8806m.getAlpha() > 0) {
                canvas.drawRect(getBounds(), this.f8806m);
            }
            if (this.D) {
                i10 = canvas.save();
            } else {
                i10 = -1;
            }
            if (this.f8814u && this.J > 0.0f) {
                h(canvas);
            }
            this.f8807n.a(canvas);
            n(canvas, this.f8802i);
            if (this.G.f8835c) {
                l(canvas);
                k(canvas);
            } else {
                k(canvas);
                l(canvas);
            }
            if (this.D) {
                canvas.restoreToCount(i10);
                f(canvas, this.f8816w, this.F, -65281);
                g(canvas, this.f8817x, InputDeviceCompat.SOURCE_ANY);
                g(canvas, this.f8816w, -16711936);
                g(canvas, this.f8819z, -16711681);
                g(canvas, this.f8818y, -16776961);
            }
        }

        public int getOpacity() {
            return -3;
        }

        public void setAlpha(int i10) {
            throw new UnsupportedOperationException("Setting alpha on is not supported");
        }

        public void setColorFilter(ColorFilter colorFilter) {
            throw new UnsupportedOperationException("Setting a color filter is not supported");
        }

        private d(PathMotion pathMotion, View view, RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float f10, View view2, RectF rectF2, ShapeAppearanceModel shapeAppearanceModel2, float f11, int i10, int i11, int i12, int i13, boolean z10, boolean z11, a aVar, d dVar, c cVar, boolean z12) {
            RectF rectF3 = rectF;
            Paint paint = new Paint();
            this.f8802i = paint;
            Paint paint2 = new Paint();
            this.f8803j = paint2;
            Paint paint3 = new Paint();
            this.f8804k = paint3;
            this.f8805l = new Paint();
            Paint paint4 = new Paint();
            this.f8806m = paint4;
            this.f8807n = new g();
            float[] fArr = new float[2];
            this.f8810q = fArr;
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            this.f8815v = materialShapeDrawable;
            Paint paint5 = new Paint();
            this.E = paint5;
            this.F = new Path();
            this.f8794a = view;
            this.f8795b = rectF3;
            this.f8796c = shapeAppearanceModel;
            this.f8797d = f10;
            this.f8798e = view2;
            this.f8799f = rectF2;
            this.f8800g = shapeAppearanceModel2;
            this.f8801h = f11;
            this.f8811r = z10;
            this.f8814u = z11;
            this.B = aVar;
            this.C = dVar;
            this.A = cVar;
            this.D = z12;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.f8812s = (float) displayMetrics.widthPixels;
            this.f8813t = (float) displayMetrics.heightPixels;
            paint.setColor(i10);
            paint2.setColor(i11);
            paint3.setColor(i12);
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(0));
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.setShadowBitmapDrawingEnable(false);
            materialShapeDrawable.setShadowColor(-7829368);
            RectF rectF4 = new RectF(rectF3);
            this.f8816w = rectF4;
            this.f8817x = new RectF(rectF4);
            RectF rectF5 = new RectF(rectF4);
            this.f8818y = rectF5;
            this.f8819z = new RectF(rectF5);
            PointF m10 = m(rectF);
            PointF m11 = m(rectF2);
            PathMotion pathMotion2 = pathMotion;
            PathMeasure pathMeasure = new PathMeasure(pathMotion.getPath(m10.x, m10.y, m11.x, m11.y), false);
            this.f8808o = pathMeasure;
            this.f8809p = pathMeasure.getLength();
            fArr[0] = rectF.centerX();
            fArr[1] = rectF3.top;
            paint4.setStyle(Paint.Style.FILL);
            paint4.setShader(j.c(i13));
            paint5.setStyle(Paint.Style.STROKE);
            paint5.setStrokeWidth(10.0f);
            p(0.0f);
        }
    }

    public MaterialContainerTransform() {
        boolean z10 = false;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28 ? true : z10;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
    }

    private c buildThresholdsGroup(boolean z10) {
        PathMotion pathMotion = getPathMotion();
        if ((pathMotion instanceof ArcMotion) || (pathMotion instanceof MaterialArcMotion)) {
            return getThresholdsOrDefault(z10, DEFAULT_ENTER_THRESHOLDS_ARC, DEFAULT_RETURN_THRESHOLDS_ARC);
        }
        return getThresholdsOrDefault(z10, DEFAULT_ENTER_THRESHOLDS, DEFAULT_RETURN_THRESHOLDS);
    }

    private static RectF calculateDrawableBounds(View view, @Nullable View view2, float f10, float f11) {
        if (view2 == null) {
            return new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        }
        RectF g10 = j.g(view2);
        g10.offset(f10, f11);
        return g10;
    }

    private static ShapeAppearanceModel captureShapeAppearance(@NonNull View view, @NonNull RectF rectF, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        return j.b(getShapeAppearance(view, shapeAppearanceModel), rectF);
    }

    private static void captureValues(@NonNull TransitionValues transitionValues, @Nullable View view, @IdRes int i10, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        RectF rectF;
        if (i10 != -1) {
            transitionValues.view = j.f(transitionValues.view, i10);
        } else if (view != null) {
            transitionValues.view = view;
        } else if (transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view) instanceof View) {
            transitionValues.view.setTag(R.id.mtrl_motion_snapshot_view, (Object) null);
            transitionValues.view = (View) transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view);
        }
        View view2 = transitionValues.view;
        if (ViewCompat.isLaidOut(view2) || view2.getWidth() != 0 || view2.getHeight() != 0) {
            if (view2.getParent() == null) {
                rectF = j.h(view2);
            } else {
                rectF = j.g(view2);
            }
            transitionValues.values.put(PROP_BOUNDS, rectF);
            transitionValues.values.put(PROP_SHAPE_APPEARANCE, captureShapeAppearance(view2, rectF, shapeAppearanceModel));
        }
    }

    private static float getElevationOrDefault(float f10, View view) {
        if (f10 != -1.0f) {
            return f10;
        }
        return ViewCompat.getElevation(view);
    }

    private static ShapeAppearanceModel getShapeAppearance(@NonNull View view, @Nullable ShapeAppearanceModel shapeAppearanceModel) {
        if (shapeAppearanceModel != null) {
            return shapeAppearanceModel;
        }
        if (view.getTag(R.id.mtrl_motion_snapshot_view) instanceof ShapeAppearanceModel) {
            return (ShapeAppearanceModel) view.getTag(R.id.mtrl_motion_snapshot_view);
        }
        Context context = view.getContext();
        int transitionShapeAppearanceResId = getTransitionShapeAppearanceResId(context);
        if (transitionShapeAppearanceResId != -1) {
            return ShapeAppearanceModel.builder(context, transitionShapeAppearanceResId, 0).build();
        }
        if (view instanceof Shapeable) {
            return ((Shapeable) view).getShapeAppearanceModel();
        }
        return ShapeAppearanceModel.builder().build();
    }

    private c getThresholdsOrDefault(boolean z10, c cVar, c cVar2) {
        if (!z10) {
            cVar = cVar2;
        }
        return new c((ProgressThresholds) j.d(this.fadeProgressThresholds, cVar.f8790a), (ProgressThresholds) j.d(this.scaleProgressThresholds, cVar.f8791b), (ProgressThresholds) j.d(this.scaleMaskProgressThresholds, cVar.f8792c), (ProgressThresholds) j.d(this.shapeMaskProgressThresholds, cVar.f8793d), (a) null);
    }

    @StyleRes
    private static int getTransitionShapeAppearanceResId(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private boolean isEntering(@NonNull RectF rectF, @NonNull RectF rectF2) {
        int i10 = this.transitionDirection;
        if (i10 != 0) {
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                return false;
            }
            throw new IllegalArgumentException("Invalid transition direction: " + this.transitionDirection);
        } else if (j.a(rectF2) > j.a(rectF)) {
            return true;
        } else {
            return false;
        }
    }

    private void maybeApplyThemeValues(Context context, boolean z10) {
        int i10;
        j.p(this, context, R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        if (z10) {
            i10 = R.attr.motionDurationLong1;
        } else {
            i10 = R.attr.motionDurationMedium2;
        }
        j.o(this, context, i10);
        if (!this.pathMotionCustom) {
            j.q(this, context, R.attr.motionPath);
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, this.endView, this.endViewId, this.endShapeAppearanceModel);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues, this.startView, this.startViewId, this.startShapeAppearanceModel);
    }

    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        View view;
        View view2;
        View view3;
        TransitionValues transitionValues3 = transitionValues;
        TransitionValues transitionValues4 = transitionValues2;
        if (!(transitionValues3 == null || transitionValues4 == null)) {
            RectF rectF = (RectF) transitionValues3.values.get(PROP_BOUNDS);
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) transitionValues3.values.get(PROP_SHAPE_APPEARANCE);
            if (rectF == null || shapeAppearanceModel == null) {
                Log.w(TAG, "Skipping due to null start bounds. Ensure start view is laid out and measured.");
            } else {
                RectF rectF2 = (RectF) transitionValues4.values.get(PROP_BOUNDS);
                ShapeAppearanceModel shapeAppearanceModel2 = (ShapeAppearanceModel) transitionValues4.values.get(PROP_SHAPE_APPEARANCE);
                if (rectF2 == null || shapeAppearanceModel2 == null) {
                    Log.w(TAG, "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view4 = transitionValues3.view;
                View view5 = transitionValues4.view;
                if (view5.getParent() != null) {
                    view = view5;
                } else {
                    view = view4;
                }
                if (this.drawingViewId == view.getId()) {
                    view2 = (View) view.getParent();
                    view3 = view;
                } else {
                    view2 = j.e(view, this.drawingViewId);
                    view3 = null;
                }
                RectF g10 = j.g(view2);
                float f10 = -g10.left;
                float f11 = -g10.top;
                RectF calculateDrawableBounds = calculateDrawableBounds(view2, view3, f10, f11);
                rectF.offset(f10, f11);
                rectF2.offset(f10, f11);
                boolean isEntering = isEntering(rectF, rectF2);
                if (!this.appliedThemeValues) {
                    maybeApplyThemeValues(view.getContext(), isEntering);
                }
                d dVar = new d(getPathMotion(), view4, rectF, shapeAppearanceModel, getElevationOrDefault(this.startElevation, view4), view5, rectF2, shapeAppearanceModel2, getElevationOrDefault(this.endElevation, view5), this.containerColor, this.startContainerColor, this.endContainerColor, this.scrimColor, isEntering, this.elevationShadowEnabled, b.a(this.fadeMode, isEntering), e.a(this.fitMode, isEntering, rectF, rectF2), buildThresholdsGroup(isEntering), this.drawDebugEnabled, (a) null);
                dVar.setBounds(Math.round(calculateDrawableBounds.left), Math.round(calculateDrawableBounds.top), Math.round(calculateDrawableBounds.right), Math.round(calculateDrawableBounds.bottom));
                ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                ofFloat.addUpdateListener(new a(dVar));
                addListener(new b(view2, dVar, view4, view5));
                return ofFloat;
            }
        }
        return null;
    }

    @ColorInt
    public int getContainerColor() {
        return this.containerColor;
    }

    @IdRes
    public int getDrawingViewId() {
        return this.drawingViewId;
    }

    @ColorInt
    public int getEndContainerColor() {
        return this.endContainerColor;
    }

    public float getEndElevation() {
        return this.endElevation;
    }

    @Nullable
    public ShapeAppearanceModel getEndShapeAppearanceModel() {
        return this.endShapeAppearanceModel;
    }

    @Nullable
    public View getEndView() {
        return this.endView;
    }

    @IdRes
    public int getEndViewId() {
        return this.endViewId;
    }

    public int getFadeMode() {
        return this.fadeMode;
    }

    @Nullable
    public ProgressThresholds getFadeProgressThresholds() {
        return this.fadeProgressThresholds;
    }

    public int getFitMode() {
        return this.fitMode;
    }

    @Nullable
    public ProgressThresholds getScaleMaskProgressThresholds() {
        return this.scaleMaskProgressThresholds;
    }

    @Nullable
    public ProgressThresholds getScaleProgressThresholds() {
        return this.scaleProgressThresholds;
    }

    @ColorInt
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Nullable
    public ProgressThresholds getShapeMaskProgressThresholds() {
        return this.shapeMaskProgressThresholds;
    }

    @ColorInt
    public int getStartContainerColor() {
        return this.startContainerColor;
    }

    public float getStartElevation() {
        return this.startElevation;
    }

    @Nullable
    public ShapeAppearanceModel getStartShapeAppearanceModel() {
        return this.startShapeAppearanceModel;
    }

    @Nullable
    public View getStartView() {
        return this.startView;
    }

    @IdRes
    public int getStartViewId() {
        return this.startViewId;
    }

    public int getTransitionDirection() {
        return this.transitionDirection;
    }

    @Nullable
    public String[] getTransitionProperties() {
        return TRANSITION_PROPS;
    }

    public boolean isDrawDebugEnabled() {
        return this.drawDebugEnabled;
    }

    public boolean isElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    public boolean isHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    public void setAllContainerColors(@ColorInt int i10) {
        this.containerColor = i10;
        this.startContainerColor = i10;
        this.endContainerColor = i10;
    }

    public void setContainerColor(@ColorInt int i10) {
        this.containerColor = i10;
    }

    public void setDrawDebugEnabled(boolean z10) {
        this.drawDebugEnabled = z10;
    }

    public void setDrawingViewId(@IdRes int i10) {
        this.drawingViewId = i10;
    }

    public void setElevationShadowEnabled(boolean z10) {
        this.elevationShadowEnabled = z10;
    }

    public void setEndContainerColor(@ColorInt int i10) {
        this.endContainerColor = i10;
    }

    public void setEndElevation(float f10) {
        this.endElevation = f10;
    }

    public void setEndShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.endShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setEndView(@Nullable View view) {
        this.endView = view;
    }

    public void setEndViewId(@IdRes int i10) {
        this.endViewId = i10;
    }

    public void setFadeMode(int i10) {
        this.fadeMode = i10;
    }

    public void setFadeProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.fadeProgressThresholds = progressThresholds;
    }

    public void setFitMode(int i10) {
        this.fitMode = i10;
    }

    public void setHoldAtEndEnabled(boolean z10) {
        this.holdAtEndEnabled = z10;
    }

    public void setPathMotion(@Nullable PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.pathMotionCustom = true;
    }

    public void setScaleMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.scaleMaskProgressThresholds = progressThresholds;
    }

    public void setScaleProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.scaleProgressThresholds = progressThresholds;
    }

    public void setScrimColor(@ColorInt int i10) {
        this.scrimColor = i10;
    }

    public void setShapeMaskProgressThresholds(@Nullable ProgressThresholds progressThresholds) {
        this.shapeMaskProgressThresholds = progressThresholds;
    }

    public void setStartContainerColor(@ColorInt int i10) {
        this.startContainerColor = i10;
    }

    public void setStartElevation(float f10) {
        this.startElevation = f10;
    }

    public void setStartShapeAppearanceModel(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.startShapeAppearanceModel = shapeAppearanceModel;
    }

    public void setStartView(@Nullable View view) {
        this.startView = view;
    }

    public void setStartViewId(@IdRes int i10) {
        this.startViewId = i10;
    }

    public void setTransitionDirection(int i10) {
        this.transitionDirection = i10;
    }

    public MaterialContainerTransform(@NonNull Context context, boolean z10) {
        boolean z11 = false;
        this.elevationShadowEnabled = Build.VERSION.SDK_INT >= 28 ? true : z11;
        this.startElevation = -1.0f;
        this.endElevation = -1.0f;
        maybeApplyThemeValues(context, z10);
        this.appliedThemeValues = true;
    }
}
