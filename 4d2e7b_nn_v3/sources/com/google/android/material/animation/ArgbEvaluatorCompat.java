package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;

public class ArgbEvaluatorCompat implements TypeEvaluator<Integer> {
    private static final ArgbEvaluatorCompat instance = new ArgbEvaluatorCompat();

    @NonNull
    public static ArgbEvaluatorCompat getInstance() {
        return instance;
    }

    @NonNull
    public Integer evaluate(float f10, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f11 = ((float) ((intValue >> 24) & 255)) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow((double) (((float) ((intValue >> 16) & 255)) / 255.0f), 2.2d);
        float pow2 = (float) Math.pow((double) (((float) ((intValue >> 8) & 255)) / 255.0f), 2.2d);
        float pow3 = (float) Math.pow((double) (((float) (intValue & 255)) / 255.0f), 2.2d);
        float pow4 = (float) Math.pow((double) (((float) ((intValue2 >> 16) & 255)) / 255.0f), 2.2d);
        float pow5 = pow3 + (f10 * (((float) Math.pow((double) (((float) (intValue2 & 255)) / 255.0f), 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow((double) (pow + ((pow4 - pow) * f10)), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round((f11 + (((((float) ((intValue2 >> 24) & 255)) / 255.0f) - f11) * f10)) * 255.0f) << 24) | (Math.round(((float) Math.pow((double) (pow2 + ((((float) Math.pow((double) (((float) ((intValue2 >> 8) & 255)) / 255.0f), 2.2d)) - pow2) * f10)), 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow((double) pow5, 0.45454545454545453d)) * 255.0f));
    }
}
