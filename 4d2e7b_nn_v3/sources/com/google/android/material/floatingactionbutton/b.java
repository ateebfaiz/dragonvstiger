package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.core.util.Preconditions;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import java.util.ArrayList;
import java.util.List;

abstract class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8232a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ExtendedFloatingActionButton f8233b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f8234c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final a f8235d;

    /* renamed from: e  reason: collision with root package name */
    private MotionSpec f8236e;

    /* renamed from: f  reason: collision with root package name */
    private MotionSpec f8237f;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (((float) Color.alpha(extendedFloatingActionButton.getCurrentTextColor())) / 255.0f) / ((float) Color.alpha(extendedFloatingActionButton.originalTextCsl.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f8233b.originalTextCsl.getDefaultColor())))));
        }

        /* renamed from: b */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f10) {
            int colorForState = extendedFloatingActionButton.originalTextCsl.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f8233b.originalTextCsl.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, ((float) Color.alpha(colorForState)) / 255.0f, f10.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f10.floatValue() == 1.0f) {
                extendedFloatingActionButton.silentlyUpdateTextColor(extendedFloatingActionButton.originalTextCsl);
            } else {
                extendedFloatingActionButton.silentlyUpdateTextColor(valueOf);
            }
        }
    }

    b(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.f8233b = extendedFloatingActionButton;
        this.f8232a = extendedFloatingActionButton.getContext();
        this.f8235d = aVar;
    }

    public void a() {
        this.f8235d.b();
    }

    public void b() {
        this.f8235d.b();
    }

    public MotionSpec e() {
        return this.f8237f;
    }

    public final void g(Animator.AnimatorListener animatorListener) {
        this.f8234c.remove(animatorListener);
    }

    public final void h(Animator.AnimatorListener animatorListener) {
        this.f8234c.add(animatorListener);
    }

    public final void i(MotionSpec motionSpec) {
        this.f8237f = motionSpec;
    }

    public AnimatorSet j() {
        return n(o());
    }

    public final List k() {
        return this.f8234c;
    }

    /* access modifiers changed from: package-private */
    public AnimatorSet n(MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.f8233b, View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.f8233b, View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.f8233b, View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues(Snapshot.WIDTH)) {
            arrayList.add(motionSpec.getAnimator(Snapshot.WIDTH, this.f8233b, ExtendedFloatingActionButton.WIDTH));
        }
        if (motionSpec.hasPropertyValues(Snapshot.HEIGHT)) {
            arrayList.add(motionSpec.getAnimator(Snapshot.HEIGHT, this.f8233b, ExtendedFloatingActionButton.HEIGHT));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", this.f8233b, ExtendedFloatingActionButton.PADDING_START));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", this.f8233b, ExtendedFloatingActionButton.PADDING_END));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.f8233b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec o() {
        MotionSpec motionSpec = this.f8237f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.f8236e == null) {
            this.f8236e = MotionSpec.createFromResource(this.f8232a, c());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.f8236e);
    }

    public void onAnimationStart(Animator animator) {
        this.f8235d.c(animator);
    }
}
