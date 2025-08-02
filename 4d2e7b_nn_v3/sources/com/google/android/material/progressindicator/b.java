package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

final class b extends e {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f8380l = {0, 1350, 2700, 4050};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f8381m = {667, 2017, 3367, 4717};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f8382n = {1000, 2350, 3700, 5050};

    /* renamed from: o  reason: collision with root package name */
    private static final Property f8383o;

    /* renamed from: p  reason: collision with root package name */
    private static final Property f8384p;

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f8385d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f8386e;

    /* renamed from: f  reason: collision with root package name */
    private final FastOutSlowInInterpolator f8387f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final BaseProgressIndicatorSpec f8388g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8389h = 0;

    /* renamed from: i  reason: collision with root package name */
    private float f8390i;

    /* renamed from: j  reason: collision with root package name */
    private float f8391j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f8392k = null;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            b bVar = b.this;
            int unused = bVar.f8389h = (bVar.f8389h + 4) % b.this.f8388g.indicatorColors.length;
        }
    }

    /* renamed from: com.google.android.material.progressindicator.b$b  reason: collision with other inner class name */
    class C0095b extends AnimatorListenerAdapter {
        C0095b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b.this.a();
            b bVar = b.this;
            Animatable2Compat.AnimationCallback animationCallback = bVar.f8392k;
            if (animationCallback != null) {
                animationCallback.onAnimationEnd(bVar.f8399a);
            }
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(b bVar) {
            return Float.valueOf(bVar.o());
        }

        /* renamed from: b */
        public void set(b bVar, Float f10) {
            bVar.t(f10.floatValue());
        }
    }

    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(b bVar) {
            return Float.valueOf(bVar.p());
        }

        /* renamed from: b */
        public void set(b bVar, Float f10) {
            bVar.u(f10.floatValue());
        }
    }

    static {
        Class<Float> cls = Float.class;
        f8383o = new c(cls, "animationFraction");
        f8384p = new d(cls, "completeEndFraction");
    }

    public b(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f8388g = circularProgressIndicatorSpec;
        this.f8387f = new FastOutSlowInInterpolator();
    }

    /* access modifiers changed from: private */
    public float o() {
        return this.f8390i;
    }

    /* access modifiers changed from: private */
    public float p() {
        return this.f8391j;
    }

    private void q() {
        if (this.f8385d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f8383o, new float[]{0.0f, 1.0f});
            this.f8385d = ofFloat;
            ofFloat.setDuration(5400);
            this.f8385d.setInterpolator((TimeInterpolator) null);
            this.f8385d.setRepeatCount(-1);
            this.f8385d.addListener(new a());
        }
        if (this.f8386e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f8384p, new float[]{0.0f, 1.0f});
            this.f8386e = ofFloat2;
            ofFloat2.setDuration(333);
            this.f8386e.setInterpolator(this.f8387f);
            this.f8386e.addListener(new C0095b());
        }
    }

    private void r(int i10) {
        int i11 = 0;
        while (i11 < 4) {
            float b10 = b(i10, f8382n[i11], 333);
            if (b10 < 0.0f || b10 > 1.0f) {
                i11++;
            } else {
                int i12 = i11 + this.f8389h;
                int[] iArr = this.f8388g.indicatorColors;
                int length = i12 % iArr.length;
                this.f8401c[0] = ArgbEvaluatorCompat.getInstance().evaluate(this.f8387f.getInterpolation(b10), Integer.valueOf(MaterialColors.compositeARGBWithAlpha(iArr[length], this.f8399a.getAlpha())), Integer.valueOf(MaterialColors.compositeARGBWithAlpha(this.f8388g.indicatorColors[(length + 1) % iArr.length], this.f8399a.getAlpha()))).intValue();
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void u(float f10) {
        this.f8391j = f10;
    }

    private void v(int i10) {
        float[] fArr = this.f8400b;
        float f10 = this.f8390i;
        fArr[0] = (f10 * 1520.0f) - 0.21875f;
        fArr[1] = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            float b10 = b(i10, f8380l[i11], 667);
            float[] fArr2 = this.f8400b;
            fArr2[1] = fArr2[1] + (this.f8387f.getInterpolation(b10) * 250.0f);
            float b11 = b(i10, f8381m[i11], 667);
            float[] fArr3 = this.f8400b;
            fArr3[0] = fArr3[0] + (this.f8387f.getInterpolation(b11) * 250.0f);
        }
        float[] fArr4 = this.f8400b;
        float f11 = fArr4[0];
        float f12 = fArr4[1];
        float f13 = f11 + ((f12 - f11) * this.f8391j);
        fArr4[0] = f13;
        fArr4[0] = f13 / 360.0f;
        fArr4[1] = f12 / 360.0f;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        ObjectAnimator objectAnimator = this.f8385d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        s();
    }

    public void d(Animatable2Compat.AnimationCallback animationCallback) {
        this.f8392k = animationCallback;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        ObjectAnimator objectAnimator = this.f8386e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f8399a.isVisible()) {
                this.f8386e.start();
            } else {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        q();
        s();
        this.f8385d.start();
    }

    public void h() {
        this.f8392k = null;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.f8389h = 0;
        this.f8401c[0] = MaterialColors.compositeARGBWithAlpha(this.f8388g.indicatorColors[0], this.f8399a.getAlpha());
        this.f8391j = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void t(float f10) {
        this.f8390i = f10;
        int i10 = (int) (f10 * 5400.0f);
        v(i10);
        r(i10);
        this.f8399a.invalidateSelf();
    }
}
