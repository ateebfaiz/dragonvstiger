package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ComplexDimensionUnit {
    }

    private static class a {
        @DoNotInline
        public static float a(int i10, float f10, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i10, f10, displayMetrics);
        }
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i10, float f10, @NonNull DisplayMetrics displayMetrics) {
        float f11;
        float f12;
        if (Build.VERSION.SDK_INT >= 34) {
            return a.a(i10, f10, displayMetrics);
        }
        if (i10 == 0) {
            return f10;
        }
        if (i10 == 1) {
            float f13 = displayMetrics.density;
            if (f13 == 0.0f) {
                return 0.0f;
            }
            return f10 / f13;
        } else if (i10 != 2) {
            if (i10 == 3) {
                float f14 = displayMetrics.xdpi;
                if (f14 == 0.0f) {
                    return 0.0f;
                }
                f11 = f10 / f14;
                f12 = INCHES_PER_PT;
            } else if (i10 == 4) {
                float f15 = displayMetrics.xdpi;
                if (f15 == 0.0f) {
                    return 0.0f;
                }
                return f10 / f15;
            } else if (i10 == 5) {
                float f16 = displayMetrics.xdpi;
                if (f16 == 0.0f) {
                    return 0.0f;
                }
                f11 = f10 / f16;
                f12 = INCHES_PER_MM;
            } else {
                throw new IllegalArgumentException("Invalid unitToConvertTo " + i10);
            }
            return f11 / f12;
        } else {
            float f17 = displayMetrics.scaledDensity;
            if (f17 == 0.0f) {
                return 0.0f;
            }
            return f10 / f17;
        }
    }

    public static float dpToPx(float f10, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f10, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i10) {
        return i10 & 15;
    }

    public static float pxToDp(float f10, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f10, displayMetrics);
    }

    public static float pxToSp(float f10, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f10, displayMetrics);
    }

    public static float spToPx(float f10, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f10, displayMetrics);
    }
}
