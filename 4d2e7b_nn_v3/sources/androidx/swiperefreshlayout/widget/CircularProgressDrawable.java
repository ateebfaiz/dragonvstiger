package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final int[] COLORS = {ViewCompat.MEASURED_STATE_MASK};
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final c mRing;
    private float mRotation;
    float mRotationCount;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16523a;

        a(c cVar) {
            this.f16523a = cVar;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircularProgressDrawable.this.updateRingColor(floatValue, this.f16523a);
            CircularProgressDrawable.this.applyTransformation(floatValue, this.f16523a, false);
            CircularProgressDrawable.this.invalidateSelf();
        }
    }

    class b implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f16525a;

        b(c cVar) {
            this.f16525a = cVar;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
            CircularProgressDrawable.this.applyTransformation(1.0f, this.f16525a, true);
            this.f16525a.M();
            this.f16525a.v();
            CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
            if (circularProgressDrawable.mFinishing) {
                circularProgressDrawable.mFinishing = false;
                animator.cancel();
                animator.setDuration(1332);
                animator.start();
                this.f16525a.I(false);
                return;
            }
            circularProgressDrawable.mRotationCount += 1.0f;
        }

        public void onAnimationStart(Animator animator) {
            CircularProgressDrawable.this.mRotationCount = 0.0f;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final RectF f16527a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f16528b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f16529c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f16530d;

        /* renamed from: e  reason: collision with root package name */
        float f16531e;

        /* renamed from: f  reason: collision with root package name */
        float f16532f;

        /* renamed from: g  reason: collision with root package name */
        float f16533g;

        /* renamed from: h  reason: collision with root package name */
        float f16534h;

        /* renamed from: i  reason: collision with root package name */
        int[] f16535i;

        /* renamed from: j  reason: collision with root package name */
        int f16536j;

        /* renamed from: k  reason: collision with root package name */
        float f16537k;

        /* renamed from: l  reason: collision with root package name */
        float f16538l;

        /* renamed from: m  reason: collision with root package name */
        float f16539m;

        /* renamed from: n  reason: collision with root package name */
        boolean f16540n;

        /* renamed from: o  reason: collision with root package name */
        Path f16541o;

        /* renamed from: p  reason: collision with root package name */
        float f16542p;

        /* renamed from: q  reason: collision with root package name */
        float f16543q;

        /* renamed from: r  reason: collision with root package name */
        int f16544r;

        /* renamed from: s  reason: collision with root package name */
        int f16545s;

        /* renamed from: t  reason: collision with root package name */
        int f16546t;

        /* renamed from: u  reason: collision with root package name */
        int f16547u;

        c() {
            Paint paint = new Paint();
            this.f16528b = paint;
            Paint paint2 = new Paint();
            this.f16529c = paint2;
            Paint paint3 = new Paint();
            this.f16530d = paint3;
            this.f16531e = 0.0f;
            this.f16532f = 0.0f;
            this.f16533g = 0.0f;
            this.f16534h = 5.0f;
            this.f16542p = 1.0f;
            this.f16546t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public void A(int i10) {
            this.f16530d.setColor(i10);
        }

        /* access modifiers changed from: package-private */
        public void B(float f10) {
            this.f16543q = f10;
        }

        /* access modifiers changed from: package-private */
        public void C(int i10) {
            this.f16547u = i10;
        }

        /* access modifiers changed from: package-private */
        public void D(ColorFilter colorFilter) {
            this.f16528b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void E(int i10) {
            this.f16536j = i10;
            this.f16547u = this.f16535i[i10];
        }

        /* access modifiers changed from: package-private */
        public void F(int[] iArr) {
            this.f16535i = iArr;
            E(0);
        }

        /* access modifiers changed from: package-private */
        public void G(float f10) {
            this.f16532f = f10;
        }

        /* access modifiers changed from: package-private */
        public void H(float f10) {
            this.f16533g = f10;
        }

        /* access modifiers changed from: package-private */
        public void I(boolean z10) {
            if (this.f16540n != z10) {
                this.f16540n = z10;
            }
        }

        /* access modifiers changed from: package-private */
        public void J(float f10) {
            this.f16531e = f10;
        }

        /* access modifiers changed from: package-private */
        public void K(Paint.Cap cap) {
            this.f16528b.setStrokeCap(cap);
        }

        /* access modifiers changed from: package-private */
        public void L(float f10) {
            this.f16534h = f10;
            this.f16528b.setStrokeWidth(f10);
        }

        /* access modifiers changed from: package-private */
        public void M() {
            this.f16537k = this.f16531e;
            this.f16538l = this.f16532f;
            this.f16539m = this.f16533g;
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f16527a;
            float f10 = this.f16543q;
            float f11 = (this.f16534h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                f11 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f16544r) * this.f16542p) / 2.0f, this.f16534h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f11, ((float) rect.centerY()) - f11, ((float) rect.centerX()) + f11, ((float) rect.centerY()) + f11);
            float f12 = this.f16531e;
            float f13 = this.f16533g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f16532f + f13) * 360.0f) - f14;
            this.f16528b.setColor(this.f16547u);
            this.f16528b.setAlpha(this.f16546t);
            float f16 = this.f16534h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f16530d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f16528b);
            b(canvas, f14, f15, rectF);
        }

        /* access modifiers changed from: package-private */
        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f16540n) {
                Path path = this.f16541o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f16541o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f16541o.moveTo(0.0f, 0.0f);
                this.f16541o.lineTo(((float) this.f16544r) * this.f16542p, 0.0f);
                Path path3 = this.f16541o;
                float f12 = this.f16542p;
                path3.lineTo((((float) this.f16544r) * f12) / 2.0f, ((float) this.f16545s) * f12);
                this.f16541o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f16544r) * this.f16542p) / 2.0f), rectF.centerY() + (this.f16534h / 2.0f));
                this.f16541o.close();
                this.f16529c.setColor(this.f16547u);
                this.f16529c.setAlpha(this.f16546t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f16541o, this.f16529c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f16546t;
        }

        /* access modifiers changed from: package-private */
        public float d() {
            return (float) this.f16545s;
        }

        /* access modifiers changed from: package-private */
        public float e() {
            return this.f16542p;
        }

        /* access modifiers changed from: package-private */
        public float f() {
            return (float) this.f16544r;
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return this.f16530d.getColor();
        }

        /* access modifiers changed from: package-private */
        public float h() {
            return this.f16543q;
        }

        /* access modifiers changed from: package-private */
        public int[] i() {
            return this.f16535i;
        }

        /* access modifiers changed from: package-private */
        public float j() {
            return this.f16532f;
        }

        /* access modifiers changed from: package-private */
        public int k() {
            return this.f16535i[l()];
        }

        /* access modifiers changed from: package-private */
        public int l() {
            return (this.f16536j + 1) % this.f16535i.length;
        }

        /* access modifiers changed from: package-private */
        public float m() {
            return this.f16533g;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return this.f16540n;
        }

        /* access modifiers changed from: package-private */
        public float o() {
            return this.f16531e;
        }

        /* access modifiers changed from: package-private */
        public int p() {
            return this.f16535i[this.f16536j];
        }

        /* access modifiers changed from: package-private */
        public float q() {
            return this.f16538l;
        }

        /* access modifiers changed from: package-private */
        public float r() {
            return this.f16539m;
        }

        /* access modifiers changed from: package-private */
        public float s() {
            return this.f16537k;
        }

        /* access modifiers changed from: package-private */
        public Paint.Cap t() {
            return this.f16528b.getStrokeCap();
        }

        /* access modifiers changed from: package-private */
        public float u() {
            return this.f16534h;
        }

        /* access modifiers changed from: package-private */
        public void v() {
            E(l());
        }

        /* access modifiers changed from: package-private */
        public void w() {
            this.f16537k = 0.0f;
            this.f16538l = 0.0f;
            this.f16539m = 0.0f;
            J(0.0f);
            G(0.0f);
            H(0.0f);
        }

        /* access modifiers changed from: package-private */
        public void x(int i10) {
            this.f16546t = i10;
        }

        /* access modifiers changed from: package-private */
        public void y(float f10, float f11) {
            this.f16544r = (int) f10;
            this.f16545s = (int) f11;
        }

        /* access modifiers changed from: package-private */
        public void z(float f10) {
            if (f10 != this.f16542p) {
                this.f16542p = f10;
            }
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        c cVar = new c();
        this.mRing = cVar;
        cVar.F(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float f10, c cVar) {
        updateRingColor(f10, cVar);
        cVar.J(cVar.s() + (((cVar.q() - MIN_PROGRESS_ARC) - cVar.s()) * f10));
        cVar.G(cVar.q());
        cVar.H(cVar.r() + ((((float) (Math.floor((double) (cVar.r() / MAX_PROGRESS_ARC)) + 1.0d)) - cVar.r()) * f10));
    }

    private int evaluateColorChange(float f10, int i10, int i11) {
        int i12 = (i10 >> 24) & 255;
        int i13 = (i10 >> 16) & 255;
        int i14 = (i10 >> 8) & 255;
        int i15 = i10 & 255;
        return ((i12 + ((int) (((float) (((i11 >> 24) & 255) - i12)) * f10))) << 24) | ((i13 + ((int) (((float) (((i11 >> 16) & 255) - i13)) * f10))) << 16) | ((i14 + ((int) (((float) (((i11 >> 8) & 255) - i14)) * f10))) << 8) | (i15 + ((int) (f10 * ((float) ((i11 & 255) - i15)))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f10) {
        this.mRotation = f10;
    }

    private void setSizeParameters(float f10, float f11, float f12, float f13) {
        c cVar = this.mRing;
        float f14 = this.mResources.getDisplayMetrics().density;
        cVar.L(f11 * f14);
        cVar.B(f10 * f14);
        cVar.E(0);
        cVar.y(f12 * f14, f13 * f14);
    }

    private void setupAnimators() {
        c cVar = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new b(cVar));
        this.mAnimator = ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void applyTransformation(float f10, c cVar, boolean z10) {
        float f11;
        float f12;
        if (this.mFinishing) {
            applyFinishTranslation(f10, cVar);
        } else if (f10 != 1.0f || z10) {
            float r10 = cVar.r();
            if (f10 < 0.5f) {
                f11 = cVar.s();
                f12 = (MATERIAL_INTERPOLATOR.getInterpolation(f10 / 0.5f) * 0.79f) + MIN_PROGRESS_ARC + f11;
            } else {
                float s10 = cVar.s() + 0.79f;
                float f13 = s10;
                f11 = s10 - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + MIN_PROGRESS_ARC);
                f12 = f13;
            }
            float f14 = r10 + (RING_ROTATION * f10);
            float f15 = (f10 + this.mRotationCount) * GROUP_FULL_ROTATION;
            cVar.J(f11);
            cVar.G(f12);
            cVar.H(f14);
            setRotation(f15);
        }
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.a(canvas, bounds);
        canvas.restore();
    }

    public int getAlpha() {
        return this.mRing.c();
    }

    public boolean getArrowEnabled() {
        return this.mRing.n();
    }

    public float getArrowHeight() {
        return this.mRing.d();
    }

    public float getArrowScale() {
        return this.mRing.e();
    }

    public float getArrowWidth() {
        return this.mRing.f();
    }

    public int getBackgroundColor() {
        return this.mRing.g();
    }

    public float getCenterRadius() {
        return this.mRing.h();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.i();
    }

    public float getEndTrim() {
        return this.mRing.j();
    }

    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.m();
    }

    public float getStartTrim() {
        return this.mRing.o();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.t();
    }

    public float getStrokeWidth() {
        return this.mRing.u();
    }

    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    public void setAlpha(int i10) {
        this.mRing.x(i10);
        invalidateSelf();
    }

    public void setArrowDimensions(float f10, float f11) {
        this.mRing.y(f10, f11);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z10) {
        this.mRing.I(z10);
        invalidateSelf();
    }

    public void setArrowScale(float f10) {
        this.mRing.z(f10);
        invalidateSelf();
    }

    public void setBackgroundColor(int i10) {
        this.mRing.A(i10);
        invalidateSelf();
    }

    public void setCenterRadius(float f10) {
        this.mRing.B(f10);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.D(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mRing.F(iArr);
        this.mRing.E(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f10) {
        this.mRing.H(f10);
        invalidateSelf();
    }

    public void setStartEndTrim(float f10, float f11) {
        this.mRing.J(f10);
        this.mRing.G(f11);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.mRing.K(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f10) {
        this.mRing.L(f10);
        invalidateSelf();
    }

    public void setStyle(int i10) {
        if (i10 == 0) {
            setSizeParameters(CENTER_RADIUS_LARGE, STROKE_WIDTH_LARGE, 12.0f, 6.0f);
        } else {
            setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void start() {
        this.mAnimator.cancel();
        this.mRing.M();
        if (this.mRing.j() != this.mRing.o()) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666);
            this.mAnimator.start();
            return;
        }
        this.mRing.E(0);
        this.mRing.w();
        this.mAnimator.setDuration(1332);
        this.mAnimator.start();
    }

    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.I(false);
        this.mRing.E(0);
        this.mRing.w();
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void updateRingColor(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.C(evaluateColorChange((f10 - 0.75f) / 0.25f, cVar.p(), cVar.k()));
        } else {
            cVar.C(cVar.p());
        }
    }
}
