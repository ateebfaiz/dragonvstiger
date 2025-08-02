package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

public final class ColorKt {
    public static final int component1(@ColorInt int i10) {
        return (i10 >> 24) & 255;
    }

    public static final int component2(@ColorInt int i10) {
        return (i10 >> 16) & 255;
    }

    public static final int component3(@ColorInt int i10) {
        return (i10 >> 8) & 255;
    }

    public static final int component4(@ColorInt int i10) {
        return i10 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i10, ColorSpace.Named named) {
        return Color.convert(i10, ColorSpace.get(named));
    }

    public static final int getAlpha(@ColorInt int i10) {
        return (i10 >> 24) & 255;
    }

    public static final int getBlue(@ColorInt int i10) {
        return i10 & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final ColorSpace getColorSpace(long j10) {
        return Color.colorSpace(j10);
    }

    public static final int getGreen(@ColorInt int i10) {
        return (i10 >> 8) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(@ColorInt int i10) {
        return Color.luminance(i10);
    }

    public static final int getRed(@ColorInt int i10) {
        return (i10 >> 16) & 255;
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isSrgb(long j10) {
        return Color.isSrgb(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final boolean isWideGamut(long j10) {
        return Color.isWideGamut(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color plus(Color color, Color color2) {
        return ColorUtils.compositeColors(color2, color);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color toColor(@ColorInt int i10) {
        return Color.valueOf(i10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    @ColorInt
    public static final int toColorInt(long j10) {
        return Color.toArgb(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long toColorLong(@ColorInt int i10) {
        return Color.pack(i10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(Color color) {
        return color.getComponent(0);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(Color color) {
        return color.getComponent(1);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(Color color) {
        return color.getComponent(2);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(Color color) {
        return color.getComponent(3);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(@ColorInt int i10, ColorSpace colorSpace) {
        return Color.convert(i10, colorSpace);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getAlpha(long j10) {
        return Color.alpha(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getBlue(long j10) {
        return Color.blue(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getGreen(long j10) {
        return Color.green(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getLuminance(long j10) {
        return Color.luminance(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float getRed(long j10) {
        return Color.red(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color toColor(long j10) {
        return Color.valueOf(j10);
    }

    @ColorInt
    public static final int toColorInt(String str) {
        return Color.parseColor(str);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component1(long j10) {
        return Color.red(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component2(long j10) {
        return Color.green(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component3(long j10) {
        return Color.blue(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final float component4(long j10) {
        return Color.alpha(j10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long j10, ColorSpace.Named named) {
        return Color.convert(j10, ColorSpace.get(named));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final long convertTo(long j10, ColorSpace colorSpace) {
        return Color.convert(j10, colorSpace);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color convertTo(Color color, ColorSpace.Named named) {
        return color.convert(ColorSpace.get(named));
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Color convertTo(Color color, ColorSpace colorSpace) {
        return color.convert(colorSpace);
    }
}
