package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int i10, @IntRange(from = 0, to = 255) int i11) {
        return ColorUtils.setAlphaComponent(i10, (Color.alpha(i10) * i11) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i10) {
        return MaterialAttributes.resolveOrThrow(view, i10);
    }

    @ColorInt
    private static int getColorRole(@ColorInt int i10, @IntRange(from = 0, to = 100) int i11) {
        l c10 = l.c(i10);
        c10.j((float) i11);
        return c10.k();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context context, @ColorInt int i10) {
        return getColorRoles(i10, MaterialAttributes.resolveBoolean(context, R.attr.isLightTheme, true));
    }

    @ColorInt
    public static int harmonize(@ColorInt int i10, @ColorInt int i11) {
        return a.a(i10, i11);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context context, @ColorInt int i10) {
        return harmonize(i10, getColor(context, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int i10) {
        if (i10 == 0 || ColorUtils.calculateLuminance(i10) <= 0.5d) {
            return false;
        }
        return true;
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i10, @AttrRes int i11) {
        return layer(view, i10, i11, 1.0f);
    }

    @ColorInt
    public static int getColor(Context context, @AttrRes int i10, String str) {
        return MaterialAttributes.resolveOrThrow(context, i10, str);
    }

    @ColorInt
    public static int layer(@NonNull View view, @AttrRes int i10, @AttrRes int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return layer(getColor(view, i10), getColor(view, i11), f10);
    }

    @ColorInt
    public static int getColor(@NonNull View view, @AttrRes int i10, @ColorInt int i11) {
        return getColor(view.getContext(), i10, i11);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @AttrRes int i10, @ColorInt int i11) {
        TypedValue resolve = MaterialAttributes.resolve(context, i10);
        return resolve != null ? resolve.data : i11;
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int i10, boolean z10) {
        if (z10) {
            return new ColorRoles(getColorRole(i10, 40), getColorRole(i10, 100), getColorRole(i10, 90), getColorRole(i10, 10));
        }
        return new ColorRoles(getColorRole(i10, 80), getColorRole(i10, 20), getColorRole(i10, TONE_ACCENT_CONTAINER_DARK), getColorRole(i10, 90));
    }

    @ColorInt
    public static int layer(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        return layer(i10, ColorUtils.setAlphaComponent(i11, Math.round(((float) Color.alpha(i11)) * f10)));
    }

    @ColorInt
    public static int layer(@ColorInt int i10, @ColorInt int i11) {
        return ColorUtils.compositeColors(i11, i10);
    }
}
