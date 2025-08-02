package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

public class Fade extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    class a extends TransitionListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f16611a;

        a(View view) {
            this.f16611a = view;
        }

        public void onTransitionEnd(Transition transition) {
            b0.h(this.f16611a, 1.0f);
            b0.a(this.f16611a);
            transition.removeListener(this);
        }
    }

    private static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f16613a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f16614b = false;

        b(View view) {
            this.f16613a = view;
        }

        public void onAnimationEnd(Animator animator) {
            b0.h(this.f16613a, 1.0f);
            if (this.f16614b) {
                this.f16613a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.f16613a) && this.f16613a.getLayerType() == 0) {
                this.f16614b = true;
                this.f16613a.setLayerType(2, (Paint) null);
            }
        }
    }

    public Fade(int i10) {
        setMode(i10);
    }

    private Animator createAnimation(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        b0.h(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, b0.f16670b, new float[]{f11});
        ofFloat.addListener(new b(view));
        addListener(new a(view));
        return ofFloat;
    }

    private static float getStartAlpha(TransitionValues transitionValues, float f10) {
        Float f11;
        if (transitionValues == null || (f11 = (Float) transitionValues.values.get(PROPNAME_TRANSITION_ALPHA)) == null) {
            return f10;
        }
        return f11.floatValue();
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(b0.c(transitionValues.view)));
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f10 = 0.0f;
        float startAlpha = getStartAlpha(transitionValues, 0.0f);
        if (startAlpha != 1.0f) {
            f10 = startAlpha;
        }
        return createAnimation(view, f10, 1.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        b0.e(view);
        return createAnimation(view, getStartAlpha(transitionValues, 1.0f), 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16697f);
        setMode(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
