package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

abstract class d {
    static final TimeInterpolator D = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    static final int[] E = {16842919, 16842910};
    static final int[] F = {16843623, 16842908, 16842910};
    static final int[] G = {16842908, 16842910};
    static final int[] H = {16843623, 16842910};
    static final int[] I = {16842910};
    static final int[] J = new int[0];
    private final RectF A = new RectF();
    private final Matrix B = new Matrix();
    private ViewTreeObserver.OnPreDrawListener C;

    /* renamed from: a  reason: collision with root package name */
    ShapeAppearanceModel f8256a;

    /* renamed from: b  reason: collision with root package name */
    MaterialShapeDrawable f8257b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f8258c;

    /* renamed from: d  reason: collision with root package name */
    c f8259d;

    /* renamed from: e  reason: collision with root package name */
    Drawable f8260e;

    /* renamed from: f  reason: collision with root package name */
    boolean f8261f;

    /* renamed from: g  reason: collision with root package name */
    boolean f8262g = true;

    /* renamed from: h  reason: collision with root package name */
    float f8263h;

    /* renamed from: i  reason: collision with root package name */
    float f8264i;

    /* renamed from: j  reason: collision with root package name */
    float f8265j;

    /* renamed from: k  reason: collision with root package name */
    int f8266k;

    /* renamed from: l  reason: collision with root package name */
    private final StateListAnimator f8267l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Animator f8268m;

    /* renamed from: n  reason: collision with root package name */
    private MotionSpec f8269n;

    /* renamed from: o  reason: collision with root package name */
    private MotionSpec f8270o;

    /* renamed from: p  reason: collision with root package name */
    private float f8271p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f8272q = 1.0f;

    /* renamed from: r  reason: collision with root package name */
    private int f8273r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f8274s = 0;

    /* renamed from: t  reason: collision with root package name */
    private ArrayList f8275t;

    /* renamed from: u  reason: collision with root package name */
    private ArrayList f8276u;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList f8277v;

    /* renamed from: w  reason: collision with root package name */
    final FloatingActionButton f8278w;

    /* renamed from: x  reason: collision with root package name */
    final ShadowViewDelegate f8279x;

    /* renamed from: y  reason: collision with root package name */
    private final Rect f8280y = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private final RectF f8281z = new RectF();

    class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f8282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8283b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k f8284c;

        a(boolean z10, k kVar) {
            this.f8283b = z10;
            this.f8284c = kVar;
        }

        public void onAnimationCancel(Animator animator) {
            this.f8282a = true;
        }

        public void onAnimationEnd(Animator animator) {
            int i10;
            int unused = d.this.f8274s = 0;
            Animator unused2 = d.this.f8268m = null;
            if (!this.f8282a) {
                FloatingActionButton floatingActionButton = d.this.f8278w;
                boolean z10 = this.f8283b;
                if (z10) {
                    i10 = 8;
                } else {
                    i10 = 4;
                }
                floatingActionButton.internalSetVisibility(i10, z10);
                k kVar = this.f8284c;
                if (kVar != null) {
                    kVar.b();
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            d.this.f8278w.internalSetVisibility(0, this.f8283b);
            int unused = d.this.f8274s = 1;
            Animator unused2 = d.this.f8268m = animator;
            this.f8282a = false;
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f8286a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f8287b;

        b(boolean z10, k kVar) {
            this.f8286a = z10;
            this.f8287b = kVar;
        }

        public void onAnimationEnd(Animator animator) {
            int unused = d.this.f8274s = 0;
            Animator unused2 = d.this.f8268m = null;
            k kVar = this.f8287b;
            if (kVar != null) {
                kVar.a();
            }
        }

        public void onAnimationStart(Animator animator) {
            d.this.f8278w.internalSetVisibility(0, this.f8286a);
            int unused = d.this.f8274s = 2;
            Animator unused2 = d.this.f8268m = animator;
        }
    }

    class c extends MatrixEvaluator {
        c() {
        }

        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            float unused = d.this.f8272q = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.d$d  reason: collision with other inner class name */
    class C0093d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f8290a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f8291b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ float f8292c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ float f8293d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f8294e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ float f8295f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ float f8296g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ Matrix f8297h;

        C0093d(float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix) {
            this.f8290a = f10;
            this.f8291b = f11;
            this.f8292c = f12;
            this.f8293d = f13;
            this.f8294e = f14;
            this.f8295f = f15;
            this.f8296g = f16;
            this.f8297h = matrix;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.f8278w.setAlpha(AnimationUtils.lerp(this.f8290a, this.f8291b, 0.0f, 0.2f, floatValue));
            d.this.f8278w.setScaleX(AnimationUtils.lerp(this.f8292c, this.f8293d, floatValue));
            d.this.f8278w.setScaleY(AnimationUtils.lerp(this.f8294e, this.f8293d, floatValue));
            float unused = d.this.f8272q = AnimationUtils.lerp(this.f8295f, this.f8296g, floatValue);
            d.this.h(AnimationUtils.lerp(this.f8295f, this.f8296g, floatValue), this.f8297h);
            d.this.f8278w.setImageMatrix(this.f8297h);
        }
    }

    class e implements TypeEvaluator {

        /* renamed from: a  reason: collision with root package name */
        FloatEvaluator f8299a = new FloatEvaluator();

        e() {
        }

        /* renamed from: a */
        public Float evaluate(float f10, Float f11, Float f12) {
            float floatValue = this.f8299a.evaluate(f10, f11, f12).floatValue();
            if (floatValue < 0.1f) {
                floatValue = 0.0f;
            }
            return Float.valueOf(floatValue);
        }
    }

    class f implements ViewTreeObserver.OnPreDrawListener {
        f() {
        }

        public boolean onPreDraw() {
            d.this.G();
            return true;
        }
    }

    private class g extends m {
        g() {
            super(d.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return 0.0f;
        }
    }

    private class h extends m {
        h() {
            super(d.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            d dVar = d.this;
            return dVar.f8263h + dVar.f8264i;
        }
    }

    private class i extends m {
        i() {
            super(d.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            d dVar = d.this;
            return dVar.f8263h + dVar.f8265j;
        }
    }

    interface j {
        void a();

        void b();
    }

    interface k {
        void a();

        void b();
    }

    private class l extends m {
        l() {
            super(d.this, (a) null);
        }

        /* access modifiers changed from: protected */
        public float a() {
            return d.this.f8263h;
        }
    }

    private abstract class m extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f8306a;

        /* renamed from: b  reason: collision with root package name */
        private float f8307b;

        /* renamed from: c  reason: collision with root package name */
        private float f8308c;

        private m() {
        }

        /* access modifiers changed from: protected */
        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            d.this.i0((float) ((int) this.f8308c));
            this.f8306a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f10;
            if (!this.f8306a) {
                MaterialShapeDrawable materialShapeDrawable = d.this.f8257b;
                if (materialShapeDrawable == null) {
                    f10 = 0.0f;
                } else {
                    f10 = materialShapeDrawable.getElevation();
                }
                this.f8307b = f10;
                this.f8308c = a();
                this.f8306a = true;
            }
            d dVar = d.this;
            float f11 = this.f8307b;
            dVar.i0((float) ((int) (f11 + ((this.f8308c - f11) * valueAnimator.getAnimatedFraction()))));
        }

        /* synthetic */ m(d dVar, a aVar) {
            this();
        }
    }

    d(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.f8278w = floatingActionButton;
        this.f8279x = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f8267l = stateListAnimator;
        stateListAnimator.addState(E, k(new i()));
        stateListAnimator.addState(F, k(new h()));
        stateListAnimator.addState(G, k(new h()));
        stateListAnimator.addState(H, k(new h()));
        stateListAnimator.addState(I, k(new l()));
        stateListAnimator.addState(J, k(new g()));
        this.f8271p = floatingActionButton.getRotation();
    }

    private boolean c0() {
        if (!ViewCompat.isLaidOut(this.f8278w) || this.f8278w.isInEditMode()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void h(float f10, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f8278w.getDrawable();
        if (drawable != null && this.f8273r != 0) {
            RectF rectF = this.f8281z;
            RectF rectF2 = this.A;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i10 = this.f8273r;
            rectF2.set(0.0f, 0.0f, (float) i10, (float) i10);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i11 = this.f8273r;
            matrix.postScale(f10, f10, ((float) i11) / 2.0f, ((float) i11) / 2.0f);
        }
    }

    private AnimatorSet i(MotionSpec motionSpec, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f8278w, View.ALPHA, new float[]{f10});
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f8278w, View.SCALE_X, new float[]{f11});
        motionSpec.getTiming("scale").apply(ofFloat2);
        j0(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f8278w, View.SCALE_Y, new float[]{f11});
        motionSpec.getTiming("scale").apply(ofFloat3);
        j0(ofFloat3);
        arrayList.add(ofFloat3);
        h(f12, this.B);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.f8278w, new ImageMatrixProperty(), new c(), new Matrix[]{new Matrix(this.B)});
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(float f10, float f11, float f12) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new C0093d(this.f8278w.getAlpha(), f10, this.f8278w.getScaleX(), f11, this.f8278w.getScaleY(), this.f8272q, f12, new Matrix(this.B)));
        arrayList.add(ofFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration((long) MotionUtils.resolveThemeDuration(this.f8278w.getContext(), R.attr.motionDurationLong1, this.f8278w.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(this.f8278w.getContext(), R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private void j0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT == 26) {
            objectAnimator.setEvaluator(new e());
        }
    }

    private ValueAnimator k(m mVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(D);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(mVar);
        valueAnimator.addUpdateListener(mVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private ViewTreeObserver.OnPreDrawListener q() {
        if (this.C == null) {
            this.C = new f();
        }
        return this.C;
    }

    /* access modifiers changed from: package-private */
    public void A() {
        MaterialShapeDrawable materialShapeDrawable = this.f8257b;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.f8278w, materialShapeDrawable);
        }
        if (M()) {
            this.f8278w.getViewTreeObserver().addOnPreDrawListener(q());
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void B();

    /* access modifiers changed from: package-private */
    public void C() {
        ViewTreeObserver viewTreeObserver = this.f8278w.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.C;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.C = null;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void D(int[] iArr);

    /* access modifiers changed from: package-private */
    public abstract void E(float f10, float f11, float f12);

    /* access modifiers changed from: package-private */
    public void F(Rect rect) {
        Preconditions.checkNotNull(this.f8260e, "Didn't initialize content background");
        if (b0()) {
            this.f8279x.setBackgroundDrawable(new InsetDrawable(this.f8260e, rect.left, rect.top, rect.right, rect.bottom));
            return;
        }
        this.f8279x.setBackgroundDrawable(this.f8260e);
    }

    /* access modifiers changed from: package-private */
    public void G() {
        float rotation = this.f8278w.getRotation();
        if (this.f8271p != rotation) {
            this.f8271p = rotation;
            f0();
        }
    }

    /* access modifiers changed from: package-private */
    public void H() {
        ArrayList arrayList = this.f8277v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void I() {
        ArrayList arrayList = this.f8277v;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((j) it.next()).a();
            }
        }
    }

    public void J(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.f8276u;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void K(Animator.AnimatorListener animatorListener) {
        ArrayList arrayList = this.f8275t;
        if (arrayList != null) {
            arrayList.remove(animatorListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(j jVar) {
        ArrayList arrayList = this.f8277v;
        if (arrayList != null) {
            arrayList.remove(jVar);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean M();

    /* access modifiers changed from: package-private */
    public void N(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f8257b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        c cVar = this.f8259d;
        if (cVar != null) {
            cVar.c(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void O(PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.f8257b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    /* access modifiers changed from: package-private */
    public final void P(float f10) {
        if (this.f8263h != f10) {
            this.f8263h = f10;
            E(f10, this.f8264i, this.f8265j);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q(boolean z10) {
        this.f8261f = z10;
    }

    /* access modifiers changed from: package-private */
    public final void R(MotionSpec motionSpec) {
        this.f8270o = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public final void S(float f10) {
        if (this.f8264i != f10) {
            this.f8264i = f10;
            E(this.f8263h, f10, this.f8265j);
        }
    }

    /* access modifiers changed from: package-private */
    public final void T(float f10) {
        this.f8272q = f10;
        Matrix matrix = this.B;
        h(f10, matrix);
        this.f8278w.setImageMatrix(matrix);
    }

    /* access modifiers changed from: package-private */
    public final void U(int i10) {
        if (this.f8273r != i10) {
            this.f8273r = i10;
            g0();
        }
    }

    /* access modifiers changed from: package-private */
    public void V(int i10) {
        this.f8266k = i10;
    }

    /* access modifiers changed from: package-private */
    public final void W(float f10) {
        if (this.f8265j != f10) {
            this.f8265j = f10;
            E(this.f8263h, this.f8264i, f10);
        }
    }

    /* access modifiers changed from: package-private */
    public void X(ColorStateList colorStateList) {
        Drawable drawable = this.f8258c;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(boolean z10) {
        this.f8262g = z10;
        h0();
    }

    /* access modifiers changed from: package-private */
    public final void Z(ShapeAppearanceModel shapeAppearanceModel) {
        this.f8256a = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f8257b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Drawable drawable = this.f8258c;
        if (drawable instanceof Shapeable) {
            ((Shapeable) drawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        c cVar = this.f8259d;
        if (cVar != null) {
            cVar.f(shapeAppearanceModel);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a0(MotionSpec motionSpec) {
        this.f8269n = motionSpec;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean b0();

    /* access modifiers changed from: package-private */
    public final boolean d0() {
        if (!this.f8261f || this.f8278w.getSizeDimension() >= this.f8266k) {
            return true;
        }
        return false;
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f8276u == null) {
            this.f8276u = new ArrayList();
        }
        this.f8276u.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void e0(k kVar, boolean z10) {
        boolean z11;
        AnimatorSet animatorSet;
        float f10;
        float f11;
        if (!y()) {
            Animator animator = this.f8268m;
            if (animator != null) {
                animator.cancel();
            }
            if (this.f8269n == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (c0()) {
                if (this.f8278w.getVisibility() != 0) {
                    float f12 = 0.0f;
                    this.f8278w.setAlpha(0.0f);
                    FloatingActionButton floatingActionButton = this.f8278w;
                    if (z11) {
                        f10 = 0.4f;
                    } else {
                        f10 = 0.0f;
                    }
                    floatingActionButton.setScaleY(f10);
                    FloatingActionButton floatingActionButton2 = this.f8278w;
                    if (z11) {
                        f11 = 0.4f;
                    } else {
                        f11 = 0.0f;
                    }
                    floatingActionButton2.setScaleX(f11);
                    if (z11) {
                        f12 = 0.4f;
                    }
                    T(f12);
                }
                MotionSpec motionSpec = this.f8269n;
                if (motionSpec != null) {
                    animatorSet = i(motionSpec, 1.0f, 1.0f, 1.0f);
                } else {
                    animatorSet = j(1.0f, 1.0f, 1.0f);
                }
                animatorSet.addListener(new b(z10, kVar));
                ArrayList arrayList = this.f8275t;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        animatorSet.addListener((Animator.AnimatorListener) it.next());
                    }
                }
                animatorSet.start();
                return;
            }
            this.f8278w.internalSetVisibility(0, z10);
            this.f8278w.setAlpha(1.0f);
            this.f8278w.setScaleY(1.0f);
            this.f8278w.setScaleX(1.0f);
            T(1.0f);
            if (kVar != null) {
                kVar.a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Animator.AnimatorListener animatorListener) {
        if (this.f8275t == null) {
            this.f8275t = new ArrayList();
        }
        this.f8275t.add(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public abstract void f0();

    /* access modifiers changed from: package-private */
    public void g(j jVar) {
        if (this.f8277v == null) {
            this.f8277v = new ArrayList();
        }
        this.f8277v.add(jVar);
    }

    /* access modifiers changed from: package-private */
    public final void g0() {
        T(this.f8272q);
    }

    /* access modifiers changed from: package-private */
    public final void h0() {
        Rect rect = this.f8280y;
        r(rect);
        F(rect);
        this.f8279x.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* access modifiers changed from: package-private */
    public void i0(float f10) {
        MaterialShapeDrawable materialShapeDrawable = this.f8257b;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f10);
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable l() {
        return this.f8260e;
    }

    /* access modifiers changed from: package-private */
    public abstract float m();

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.f8261f;
    }

    /* access modifiers changed from: package-private */
    public final MotionSpec o() {
        return this.f8270o;
    }

    /* access modifiers changed from: package-private */
    public float p() {
        return this.f8264i;
    }

    /* access modifiers changed from: package-private */
    public void r(Rect rect) {
        int i10;
        float f10;
        if (this.f8261f) {
            i10 = (this.f8266k - this.f8278w.getSizeDimension()) / 2;
        } else {
            i10 = 0;
        }
        if (this.f8262g) {
            f10 = m() + this.f8265j;
        } else {
            f10 = 0.0f;
        }
        int max = Math.max(i10, (int) Math.ceil((double) f10));
        int max2 = Math.max(i10, (int) Math.ceil((double) (f10 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    /* access modifiers changed from: package-private */
    public float s() {
        return this.f8265j;
    }

    /* access modifiers changed from: package-private */
    public final ShapeAppearanceModel t() {
        return this.f8256a;
    }

    /* access modifiers changed from: package-private */
    public final MotionSpec u() {
        return this.f8269n;
    }

    /* access modifiers changed from: package-private */
    public void v(k kVar, boolean z10) {
        int i10;
        AnimatorSet animatorSet;
        if (!x()) {
            Animator animator = this.f8268m;
            if (animator != null) {
                animator.cancel();
            }
            if (c0()) {
                MotionSpec motionSpec = this.f8270o;
                if (motionSpec != null) {
                    animatorSet = i(motionSpec, 0.0f, 0.0f, 0.0f);
                } else {
                    animatorSet = j(0.0f, 0.4f, 0.4f);
                }
                animatorSet.addListener(new a(z10, kVar));
                ArrayList arrayList = this.f8276u;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        animatorSet.addListener((Animator.AnimatorListener) it.next());
                    }
                }
                animatorSet.start();
                return;
            }
            FloatingActionButton floatingActionButton = this.f8278w;
            if (z10) {
                i10 = 8;
            } else {
                i10 = 4;
            }
            floatingActionButton.internalSetVisibility(i10, z10);
            if (kVar != null) {
                kVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void w(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i10);

    /* access modifiers changed from: package-private */
    public boolean x() {
        if (this.f8278w.getVisibility() == 0) {
            if (this.f8274s == 1) {
                return true;
            }
            return false;
        } else if (this.f8274s != 2) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        if (this.f8278w.getVisibility() != 0) {
            if (this.f8274s == 2) {
                return true;
            }
            return false;
        } else if (this.f8274s != 1) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void z();
}
