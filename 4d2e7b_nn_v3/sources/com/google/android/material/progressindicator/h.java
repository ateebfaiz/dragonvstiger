package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class h extends e {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f8413l = {533, 567, 850, 750};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f8414m = {1267, 1000, 333, 0};

    /* renamed from: n  reason: collision with root package name */
    private static final Property f8415n = new c(Float.class, "animationFraction");

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f8416d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f8417e;

    /* renamed from: f  reason: collision with root package name */
    private final Interpolator[] f8418f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final BaseProgressIndicatorSpec f8419g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8420h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f8421i;

    /* renamed from: j  reason: collision with root package name */
    private float f8422j;

    /* renamed from: k  reason: collision with root package name */
    Animatable2Compat.AnimationCallback f8423k = null;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            h hVar = h.this;
            int unused = hVar.f8420h = (hVar.f8420h + 1) % h.this.f8419g.indicatorColors.length;
            boolean unused2 = h.this.f8421i = true;
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            h.this.a();
            h hVar = h.this;
            Animatable2Compat.AnimationCallback animationCallback = hVar.f8423k;
            if (animationCallback != null) {
                animationCallback.onAnimationEnd(hVar.f8399a);
            }
        }
    }

    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(h hVar) {
            return Float.valueOf(hVar.n());
        }

        /* renamed from: b */
        public void set(h hVar, Float f10) {
            hVar.r(f10.floatValue());
        }
    }

    public h(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f8419g = linearProgressIndicatorSpec;
        this.f8418f = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    /* access modifiers changed from: private */
    public float n() {
        return this.f8422j;
    }

    private void o() {
        if (this.f8416d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f8415n, new float[]{0.0f, 1.0f});
            this.f8416d = ofFloat;
            ofFloat.setDuration(1800);
            this.f8416d.setInterpolator((TimeInterpolator) null);
            this.f8416d.setRepeatCount(-1);
            this.f8416d.addListener(new a());
        }
        if (this.f8417e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f8415n, new float[]{1.0f});
            this.f8417e = ofFloat2;
            ofFloat2.setDuration(1800);
            this.f8417e.setInterpolator((TimeInterpolator) null);
            this.f8417e.addListener(new b());
        }
    }

    private void p() {
        if (this.f8421i) {
            Arrays.fill(this.f8401c, MaterialColors.compositeARGBWithAlpha(this.f8419g.indicatorColors[this.f8420h], this.f8399a.getAlpha()));
            this.f8421i = false;
        }
    }

    private void s(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            this.f8400b[i11] = Math.max(0.0f, Math.min(1.0f, this.f8418f[i11].getInterpolation(b(i10, f8414m[i11], f8413l[i11]))));
        }
    }

    public void a() {
        ObjectAnimator objectAnimator = this.f8416d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        q();
    }

    public void d(Animatable2Compat.AnimationCallback animationCallback) {
        this.f8423k = animationCallback;
    }

    public void f() {
        ObjectAnimator objectAnimator = this.f8417e;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f8399a.isVisible()) {
                this.f8417e.setFloatValues(new float[]{this.f8422j, 1.0f});
                this.f8417e.setDuration((long) ((1.0f - this.f8422j) * 1800.0f));
                this.f8417e.start();
            }
        }
    }

    public void g() {
        o();
        q();
        this.f8416d.start();
    }

    public void h() {
        this.f8423k = null;
    }

    /* access modifiers changed from: package-private */
    public void q() {
        this.f8420h = 0;
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(this.f8419g.indicatorColors[0], this.f8399a.getAlpha());
        int[] iArr = this.f8401c;
        iArr[0] = compositeARGBWithAlpha;
        iArr[1] = compositeARGBWithAlpha;
    }

    /* access modifiers changed from: package-private */
    public void r(float f10) {
        this.f8422j = f10;
        s((int) (f10 * 1800.0f));
        p();
        this.f8399a.invalidateSelf();
    }
}
