package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i10) {
        if (!typedArray.hasValue(i10)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getBoolean(i10, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getColor(i10, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        ColorStateList colorStateList = typedArray.getColorStateList(i10);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getDimension(i10, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelOffset(i10, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getDimensionPixelSize(i10, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        Drawable drawable = typedArray.getDrawable(i10);
        m.c(drawable);
        return drawable;
    }

    public static final float getFloatOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getFloat(i10, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return f.a(typedArray, i10);
    }

    public static final int getIntOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getInt(i10, 0);
    }

    public static final int getIntegerOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getInteger(i10, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getResourceId(i10, 0);
    }

    public static final String getStringOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        String string = typedArray.getString(i10);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        return typedArray.getTextArray(i10);
    }

    public static final CharSequence getTextOrThrow(TypedArray typedArray, @StyleableRes int i10) {
        checkAttribute(typedArray, i10);
        CharSequence text = typedArray.getText(i10);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(TypedArray typedArray, Function1<? super TypedArray, ? extends R> function1) {
        R invoke = function1.invoke(typedArray);
        typedArray.recycle();
        return invoke;
    }
}
