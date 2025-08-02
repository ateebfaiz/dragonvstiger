package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class g extends e {

    /* renamed from: j  reason: collision with root package name */
    private static final Property f8405j = new b(Float.class, "animationFraction");

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f8406d;

    /* renamed from: e  reason: collision with root package name */
    private FastOutSlowInInterpolator f8407e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final BaseProgressIndicatorSpec f8408f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f8409g = 1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f8410h;

    /* renamed from: i  reason: collision with root package name */
    private float f8411i;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            g gVar = g.this;
            int unused = gVar.f8409g = (gVar.f8409g + 1) % g.this.f8408f.indicatorColors.length;
            boolean unused2 = g.this.f8410h = true;
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(g gVar) {
            return Float.valueOf(gVar.n());
        }

        /* renamed from: b */
        public void set(g gVar, Float f10) {
            gVar.r(f10.floatValue());
        }
    }

    public g(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f8408f = linearProgressIndicatorSpec;
        this.f8407e = new FastOutSlowInInterpolator();
    }

    /* access modifiers changed from: private */
    public float n() {
        return this.f8411i;
    }

    private void o() {
        if (this.f8406d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f8405j, new float[]{0.0f, 1.0f});
            this.f8406d = ofFloat;
            ofFloat.setDuration(333);
            this.f8406d.setInterpolator((TimeInterpolator) null);
            this.f8406d.setRepeatCount(-1);
            this.f8406d.addListener(new a());
        }
    }

    private void p() {
        if (this.f8410h && this.f8400b[3] < 1.0f) {
            int[] iArr = this.f8401c;
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = MaterialColors.compositeARGBWithAlpha(this.f8408f.indicatorColors[this.f8409g], this.f8399a.getAlpha());
            this.f8410h = false;
        }
    }

    private void s(int i10) {
        this.f8400b[0] = 0.0f;
        float b10 = b(i10, 0, 667);
        float[] fArr = this.f8400b;
        float interpolation = this.f8407e.getInterpolation(b10);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f8400b;
        float interpolation2 = this.f8407e.getInterpolation(b10 + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f8400b[5] = 1.0f;
    }

    public void a() {
        ObjectAnimator objectAnimator = this.f8406d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        q();
    }

    public void d(Animatable2Compat.AnimationCallback animationCallback) {
    }

    public void f() {
    }

    public void g() {
        o();
        q();
        this.f8406d.start();
    }

    public void h() {
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f8410h = true;
        this.f8409g = 1;
        Arrays.fill(this.f8401c, MaterialColors.compositeARGBWithAlpha(this.f8408f.indicatorColors[0], this.f8399a.getAlpha()));
    }

    /* access modifiers changed from: package-private */
    public void r(float f10) {
        this.f8411i = f10;
        s((int) (f10 * 333.0f));
        p();
        this.f8399a.invalidateSelf();
    }
}
