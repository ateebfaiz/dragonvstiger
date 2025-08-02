package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TextScale extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f8334a;

        a(TextView textView) {
            this.f8334a = textView;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f8334a.setScaleX(floatValue);
            this.f8334a.setScaleY(floatValue);
        }
    }

    private void captureValues(@NonNull TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view instanceof TextView) {
            transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        float f10;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.view;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        float f11 = 1.0f;
        if (map.get(PROPNAME_SCALE) != null) {
            f10 = ((Float) map.get(PROPNAME_SCALE)).floatValue();
        } else {
            f10 = 1.0f;
        }
        if (map2.get(PROPNAME_SCALE) != null) {
            f11 = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (f10 == f11) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f10, f11});
        ofFloat.addUpdateListener(new a(textView));
        return ofFloat;
    }
}
