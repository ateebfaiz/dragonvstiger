package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class d {

    /* renamed from: v  reason: collision with root package name */
    private static final float[][] f14654v = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: w  reason: collision with root package name */
    private static final float[][] f14655w = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: a  reason: collision with root package name */
    private int f14656a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f14657b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f14658c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f14659d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f14660e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f14661f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f14662g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private float f14663h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    private float f14664i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f14665j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private boolean f14666k = false;

    /* renamed from: l  reason: collision with root package name */
    private float[] f14667l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    private float f14668m;

    /* renamed from: n  reason: collision with root package name */
    private float f14669n;

    /* renamed from: o  reason: collision with root package name */
    private final MotionLayout f14670o;

    /* renamed from: p  reason: collision with root package name */
    private float f14671p = 4.0f;

    /* renamed from: q  reason: collision with root package name */
    private float f14672q = 1.2f;

    /* renamed from: r  reason: collision with root package name */
    private boolean f14673r = true;

    /* renamed from: s  reason: collision with root package name */
    private float f14674s = 1.0f;

    /* renamed from: t  reason: collision with root package name */
    private int f14675t = 0;

    /* renamed from: u  reason: collision with root package name */
    private float f14676u = 10.0f;

    class a implements View.OnTouchListener {
        a() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    class b implements NestedScrollView.OnScrollChangeListener {
        b() {
        }

        public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
        }
    }

    d(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f14670o = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArray.getIndex(i10);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f14659d = typedArray.getResourceId(index, this.f14659d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i11 = typedArray.getInt(index, this.f14656a);
                this.f14656a = i11;
                float[] fArr = f14654v[i11];
                this.f14663h = fArr[0];
                this.f14662g = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i12 = typedArray.getInt(index, this.f14657b);
                this.f14657b = i12;
                float[] fArr2 = f14655w[i12];
                this.f14664i = fArr2[0];
                this.f14665j = fArr2[1];
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.f14671p = typedArray.getFloat(index, this.f14671p);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.f14672q = typedArray.getFloat(index, this.f14672q);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f14673r = typedArray.getBoolean(index, this.f14673r);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.f14674s = typedArray.getFloat(index, this.f14674s);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.f14676u = typedArray.getFloat(index, this.f14676u);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f14660e = typedArray.getResourceId(index, this.f14660e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f14658c = typedArray.getInt(index, this.f14658c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.f14675t = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f14661f = typedArray.getResourceId(index, 0);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public float a(float f10, float f11) {
        return (f10 * this.f14664i) + (f11 * this.f14665j);
    }

    public int d() {
        return this.f14675t;
    }

    /* access modifiers changed from: package-private */
    public RectF e(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f14661f;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.f14672q;
    }

    public float g() {
        return this.f14671p;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f14673r;
    }

    /* access modifiers changed from: package-private */
    public float i(float f10, float f11) {
        this.f14670o.getAnchorDpDt(this.f14659d, this.f14670o.getProgress(), this.f14663h, this.f14662g, this.f14667l);
        float f12 = this.f14664i;
        if (f12 != 0.0f) {
            float[] fArr = this.f14667l;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f10 * f12) / fArr[0];
        }
        float[] fArr2 = this.f14667l;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f11 * this.f14665j) / fArr2[1];
    }

    /* access modifiers changed from: package-private */
    public RectF j(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i10 = this.f14660e;
        if (i10 == -1 || (findViewById = viewGroup.findViewById(i10)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f14660e;
    }

    /* access modifiers changed from: package-private */
    public void l(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i10, MotionScene motionScene) {
        float f10;
        float f11;
        int i11;
        float f12;
        float f13;
        float f14;
        MotionLayout.MotionTracker motionTracker2 = motionTracker;
        motionTracker2.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f14668m = motionEvent.getRawX();
            this.f14669n = motionEvent.getRawY();
            this.f14666k = false;
        } else if (action == 1) {
            this.f14666k = false;
            motionTracker2.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.f14670o.getProgress();
            int i12 = this.f14659d;
            if (i12 != -1) {
                this.f14670o.getAnchorDpDt(i12, progress, this.f14663h, this.f14662g, this.f14667l);
            } else {
                float min = (float) Math.min(this.f14670o.getWidth(), this.f14670o.getHeight());
                float[] fArr = this.f14667l;
                fArr[1] = this.f14665j * min;
                fArr[0] = min * this.f14664i;
            }
            float f15 = this.f14664i;
            float[] fArr2 = this.f14667l;
            float f16 = fArr2[0];
            float f17 = fArr2[1];
            if (f15 != 0.0f) {
                f10 = xVelocity / f16;
            } else {
                f10 = yVelocity / f17;
            }
            if (!Float.isNaN(f10)) {
                f11 = (f10 / 3.0f) + progress;
            } else {
                f11 = progress;
            }
            if (f11 != 0.0f && f11 != 1.0f && (i11 = this.f14658c) != 3) {
                MotionLayout motionLayout = this.f14670o;
                if (((double) f11) < 0.5d) {
                    f12 = 0.0f;
                } else {
                    f12 = 1.0f;
                }
                motionLayout.touchAnimateTo(i11, f12, f10);
                if (0.0f >= progress || 1.0f <= progress) {
                    this.f14670o.setState(MotionLayout.h.FINISHED);
                }
            } else if (0.0f >= f11 || 1.0f <= f11) {
                this.f14670o.setState(MotionLayout.h.FINISHED);
            }
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.f14669n;
            float rawX = motionEvent.getRawX() - this.f14668m;
            if (Math.abs((this.f14664i * rawX) + (this.f14665j * rawY)) > this.f14676u || this.f14666k) {
                float progress2 = this.f14670o.getProgress();
                if (!this.f14666k) {
                    this.f14666k = true;
                    this.f14670o.setProgress(progress2);
                }
                int i13 = this.f14659d;
                if (i13 != -1) {
                    this.f14670o.getAnchorDpDt(i13, progress2, this.f14663h, this.f14662g, this.f14667l);
                } else {
                    float min2 = (float) Math.min(this.f14670o.getWidth(), this.f14670o.getHeight());
                    float[] fArr3 = this.f14667l;
                    fArr3[1] = this.f14665j * min2;
                    fArr3[0] = min2 * this.f14664i;
                }
                float f18 = this.f14664i;
                float[] fArr4 = this.f14667l;
                if (((double) Math.abs(((f18 * fArr4[0]) + (this.f14665j * fArr4[1])) * this.f14674s)) < 0.01d) {
                    float[] fArr5 = this.f14667l;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                if (this.f14664i != 0.0f) {
                    f13 = rawX / this.f14667l[0];
                } else {
                    f13 = rawY / this.f14667l[1];
                }
                float max = Math.max(Math.min(progress2 + f13, 1.0f), 0.0f);
                if (max != this.f14670o.getProgress()) {
                    this.f14670o.setProgress(max);
                    motionTracker2.computeCurrentVelocity(1000);
                    float xVelocity2 = motionTracker.getXVelocity();
                    float yVelocity2 = motionTracker.getYVelocity();
                    if (this.f14664i != 0.0f) {
                        f14 = xVelocity2 / this.f14667l[0];
                    } else {
                        f14 = yVelocity2 / this.f14667l[1];
                    }
                    this.f14670o.mLastVelocity = f14;
                } else {
                    this.f14670o.mLastVelocity = 0.0f;
                }
                this.f14668m = motionEvent.getRawX();
                this.f14669n = motionEvent.getRawY();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m(float f10, float f11) {
        float f12;
        float progress = this.f14670o.getProgress();
        if (!this.f14666k) {
            this.f14666k = true;
            this.f14670o.setProgress(progress);
        }
        this.f14670o.getAnchorDpDt(this.f14659d, progress, this.f14663h, this.f14662g, this.f14667l);
        float f13 = this.f14664i;
        float[] fArr = this.f14667l;
        if (((double) Math.abs((f13 * fArr[0]) + (this.f14665j * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.f14667l;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f14 = this.f14664i;
        if (f14 != 0.0f) {
            f12 = (f10 * f14) / this.f14667l[0];
        } else {
            f12 = (f11 * this.f14665j) / this.f14667l[1];
        }
        float max = Math.max(Math.min(progress + f12, 1.0f), 0.0f);
        if (max != this.f14670o.getProgress()) {
            this.f14670o.setProgress(max);
        }
    }

    /* access modifiers changed from: package-private */
    public void n(float f10, float f11) {
        float f12;
        boolean z10;
        boolean z11 = false;
        this.f14666k = false;
        float progress = this.f14670o.getProgress();
        this.f14670o.getAnchorDpDt(this.f14659d, progress, this.f14663h, this.f14662g, this.f14667l);
        float f13 = this.f14664i;
        float[] fArr = this.f14667l;
        float f14 = fArr[0];
        float f15 = this.f14665j;
        float f16 = fArr[1];
        float f17 = 0.0f;
        if (f13 != 0.0f) {
            f12 = (f10 * f13) / f14;
        } else {
            f12 = (f11 * f15) / f16;
        }
        if (!Float.isNaN(f12)) {
            progress += f12 / 3.0f;
        }
        if (progress != 0.0f) {
            if (progress != 1.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            int i10 = this.f14658c;
            if (i10 != 3) {
                z11 = true;
            }
            if (z11 && z10) {
                MotionLayout motionLayout = this.f14670o;
                if (((double) progress) >= 0.5d) {
                    f17 = 1.0f;
                }
                motionLayout.touchAnimateTo(i10, f17, f12);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(float f10, float f11) {
        this.f14668m = f10;
        this.f14669n = f11;
    }

    public void p(boolean z10) {
        if (z10) {
            float[][] fArr = f14655w;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = f14654v;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f14655w;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = f14654v;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = f14654v[this.f14656a];
        this.f14663h = fArr5[0];
        this.f14662g = fArr5[1];
        float[] fArr6 = f14655w[this.f14657b];
        this.f14664i = fArr6[0];
        this.f14665j = fArr6[1];
    }

    /* access modifiers changed from: package-private */
    public void q(float f10, float f11) {
        this.f14668m = f10;
        this.f14669n = f11;
        this.f14666k = false;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        View view;
        int i10 = this.f14659d;
        if (i10 != -1) {
            view = this.f14670o.findViewById(i10);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.getName(this.f14670o.getContext(), this.f14659d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new a());
            nestedScrollView.setOnScrollChangeListener(new b());
        }
    }

    public String toString() {
        return this.f14664i + " , " + this.f14665j;
    }
}
