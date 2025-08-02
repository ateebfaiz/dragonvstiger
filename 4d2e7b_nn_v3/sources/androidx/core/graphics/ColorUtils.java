package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import java.util.Objects;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal<double[]> TEMP_ARRAY = new ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    static class a {
        @DoNotInline
        static Color a(Color color, Color color2) {
            if (Objects.equals(color.getModel(), color2.getModel())) {
                if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                    color = color.convert(color2.getColorSpace());
                }
                float[] components = color.getComponents();
                float[] components2 = color2.getComponents();
                float alpha = color.alpha();
                float alpha2 = color2.alpha() * (1.0f - alpha);
                int componentCount = color2.getComponentCount() - 1;
                float f10 = alpha + alpha2;
                components2[componentCount] = f10;
                if (f10 > 0.0f) {
                    alpha /= f10;
                    alpha2 /= f10;
                }
                for (int i10 = 0; i10 < componentCount; i10++) {
                    components2[i10] = (components[i10] * alpha) + (components2[i10] * alpha2);
                }
                return Color.valueOf(components2, color2.getColorSpace());
            }
            throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
        }
    }

    private ColorUtils() {
    }

    @ColorInt
    public static int HSLToColor(@NonNull float[] fArr) {
        int i10;
        int i11;
        int i12;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float f12 = fArr[2];
        float abs = (1.0f - Math.abs((f12 * 2.0f) - 1.0f)) * f11;
        float f13 = f12 - (0.5f * abs);
        float abs2 = (1.0f - Math.abs(((f10 / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f10) / 60) {
            case 0:
                i12 = Math.round((abs + f13) * 255.0f);
                i11 = Math.round((abs2 + f13) * 255.0f);
                i10 = Math.round(f13 * 255.0f);
                break;
            case 1:
                i12 = Math.round((abs2 + f13) * 255.0f);
                i11 = Math.round((abs + f13) * 255.0f);
                i10 = Math.round(f13 * 255.0f);
                break;
            case 2:
                i12 = Math.round(f13 * 255.0f);
                i11 = Math.round((abs + f13) * 255.0f);
                i10 = Math.round((abs2 + f13) * 255.0f);
                break;
            case 3:
                i12 = Math.round(f13 * 255.0f);
                i11 = Math.round((abs2 + f13) * 255.0f);
                i10 = Math.round((abs + f13) * 255.0f);
                break;
            case 4:
                i12 = Math.round((abs2 + f13) * 255.0f);
                i11 = Math.round(f13 * 255.0f);
                i10 = Math.round((abs + f13) * 255.0f);
                break;
            case 5:
            case 6:
                i12 = Math.round((abs + f13) * 255.0f);
                i11 = Math.round(f13 * 255.0f);
                i10 = Math.round((abs2 + f13) * 255.0f);
                break;
            default:
                i10 = 0;
                i12 = 0;
                i11 = 0;
                break;
        }
        return Color.rgb(constrain(i12, 0, 255), constrain(i11, 0, 255), constrain(i10, 0, 255));
    }

    @ColorInt
    public static int LABToColor(@FloatRange(from = 0.0d, to = 100.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11, @FloatRange(from = -128.0d, to = 127.0d) double d12) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d10, d11, d12, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@FloatRange(from = 0.0d, to = 100.0d) double d10, @FloatRange(from = -128.0d, to = 127.0d) double d11, @FloatRange(from = -128.0d, to = 127.0d) double d12, @NonNull double[] dArr) {
        double d13;
        double d14 = (d10 + 16.0d) / 116.0d;
        double d15 = (d11 / 500.0d) + d14;
        double d16 = d14 - (d12 / 200.0d);
        double pow = Math.pow(d15, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d15 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        if (d10 > 7.9996247999999985d) {
            d13 = Math.pow(d14, 3.0d);
        } else {
            d13 = d10 / XYZ_KAPPA;
        }
        double pow2 = Math.pow(d16, 3.0d);
        if (pow2 <= XYZ_EPSILON) {
            pow2 = ((d16 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = d13 * XYZ_WHITE_REFERENCE_Y;
        dArr[2] = pow2 * XYZ_WHITE_REFERENCE_Z;
    }

    @ColorInt
    public static int M3HCTToColor(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f10, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f11, @FloatRange(from = 0.0d, to = 100.0d) float f12) {
        return CamColor.toColor(f10, f11, f12);
    }

    public static void RGBToHSL(@IntRange(from = 0, to = 255) int i10, @IntRange(from = 0, to = 255) int i11, @IntRange(from = 0, to = 255) int i12, @NonNull float[] fArr) {
        float f10;
        float f11;
        float f12 = ((float) i10) / 255.0f;
        float f13 = ((float) i11) / 255.0f;
        float f14 = ((float) i12) / 255.0f;
        float max = Math.max(f12, Math.max(f13, f14));
        float min = Math.min(f12, Math.min(f13, f14));
        float f15 = max - min;
        float f16 = (max + min) / 2.0f;
        if (max == min) {
            f10 = 0.0f;
            f11 = 0.0f;
        } else {
            if (max == f12) {
                f10 = ((f13 - f14) / f15) % 6.0f;
            } else if (max == f13) {
                f10 = ((f14 - f12) / f15) + 2.0f;
            } else {
                f10 = 4.0f + ((f12 - f13) / f15);
            }
            f11 = f15 / (1.0f - Math.abs((2.0f * f16) - 1.0f));
        }
        float f17 = (f10 * 60.0f) % 360.0f;
        if (f17 < 0.0f) {
            f17 += 360.0f;
        }
        fArr[0] = constrain(f17, 0.0f, 360.0f);
        fArr[1] = constrain(f11, 0.0f, 1.0f);
        fArr[2] = constrain(f16, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@IntRange(from = 0, to = 255) int i10, @IntRange(from = 0, to = 255) int i11, @IntRange(from = 0, to = 255) int i12, @NonNull double[] dArr) {
        RGBToXYZ(i10, i11, i12, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@IntRange(from = 0, to = 255) int i10, @IntRange(from = 0, to = 255) int i11, @IntRange(from = 0, to = 255) int i12, @NonNull double[] dArr) {
        double pow;
        double pow2;
        double d10;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d11 = ((double) i10) / 255.0d;
            if (d11 < 0.04045d) {
                pow = d11 / 12.92d;
            } else {
                pow = Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
            }
            double d12 = ((double) i11) / 255.0d;
            if (d12 < 0.04045d) {
                pow2 = d12 / 12.92d;
            } else {
                pow2 = Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
            }
            double d13 = ((double) i12) / 255.0d;
            if (d13 < 0.04045d) {
                d10 = d13 / 12.92d;
            } else {
                d10 = Math.pow((d13 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * d10)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * d10)) * XYZ_WHITE_REFERENCE_Y;
            dArr2[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (d10 * 0.9505d)) * XYZ_WHITE_REFERENCE_Y;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int XYZToColor(@FloatRange(from = 0.0d, to = 95.047d) double d10, @FloatRange(from = 0.0d, to = 100.0d) double d11, @FloatRange(from = 0.0d, to = 108.883d) double d12) {
        double d13;
        double d14;
        double d15;
        double d16 = (((3.2406d * d10) + (-1.5372d * d11)) + (-0.4986d * d12)) / XYZ_WHITE_REFERENCE_Y;
        double d17 = (((-0.9689d * d10) + (1.8758d * d11)) + (0.0415d * d12)) / XYZ_WHITE_REFERENCE_Y;
        double d18 = (((0.0557d * d10) + (-0.204d * d11)) + (1.057d * d12)) / XYZ_WHITE_REFERENCE_Y;
        if (d16 > 0.0031308d) {
            d13 = (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d13 = d16 * 12.92d;
        }
        if (d17 > 0.0031308d) {
            d14 = (Math.pow(d17, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d14 = d17 * 12.92d;
        }
        if (d18 > 0.0031308d) {
            d15 = (Math.pow(d18, 0.4166666666666667d) * 1.055d) - 0.055d;
        } else {
            d15 = d18 * 12.92d;
        }
        return Color.rgb(constrain((int) Math.round(d13 * 255.0d), 0, 255), constrain((int) Math.round(d14 * 255.0d), 0, 255), constrain((int) Math.round(d15 * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@FloatRange(from = 0.0d, to = 95.047d) double d10, @FloatRange(from = 0.0d, to = 100.0d) double d11, @FloatRange(from = 0.0d, to = 108.883d) double d12, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double pivotXyzComponent = pivotXyzComponent(d10 / XYZ_WHITE_REFERENCE_X);
            double pivotXyzComponent2 = pivotXyzComponent(d11 / XYZ_WHITE_REFERENCE_Y);
            double pivotXyzComponent3 = pivotXyzComponent(d12 / XYZ_WHITE_REFERENCE_Z);
            dArr[0] = Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
            dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
            dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int blendARGB(@ColorInt int i10, @ColorInt int i11, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        float f11 = 1.0f - f10;
        return Color.argb((int) ((((float) Color.alpha(i10)) * f11) + (((float) Color.alpha(i11)) * f10)), (int) ((((float) Color.red(i10)) * f11) + (((float) Color.red(i11)) * f10)), (int) ((((float) Color.green(i10)) * f11) + (((float) Color.green(i11)) * f10)), (int) ((((float) Color.blue(i10)) * f11) + (((float) Color.blue(i11)) * f10)));
    }

    public static void blendHSL(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f10, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f11 = 1.0f - f10;
            fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f10);
            fArr3[1] = (fArr[1] * f11) + (fArr2[1] * f10);
            fArr3[2] = (fArr[2] * f11) + (fArr2[2] * f10);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void blendLAB(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d10, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d11 = 1.0d - d10;
            dArr3[0] = (dArr[0] * d11) + (dArr2[0] * d10);
            dArr3[1] = (dArr[1] * d11) + (dArr2[1] * d10);
            dArr3[2] = (dArr[2] * d11) + (dArr2[2] * d10);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double calculateContrast(@ColorInt int i10, @ColorInt int i11) {
        if (Color.alpha(i11) == 255) {
            if (Color.alpha(i10) < 255) {
                i10 = compositeColors(i10, i11);
            }
            double calculateLuminance = calculateLuminance(i10) + 0.05d;
            double calculateLuminance2 = calculateLuminance(i11) + 0.05d;
            return Math.max(calculateLuminance, calculateLuminance2) / Math.min(calculateLuminance, calculateLuminance2);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@ColorInt int i10) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i10, tempDouble3Array);
        return tempDouble3Array[1] / XYZ_WHITE_REFERENCE_Y;
    }

    public static int calculateMinimumAlpha(@ColorInt int i10, @ColorInt int i11, float f10) {
        int i12 = 255;
        if (Color.alpha(i11) == 255) {
            double d10 = (double) f10;
            if (calculateContrast(setAlphaComponent(i10, 255), i11) < d10) {
                return -1;
            }
            int i13 = 0;
            for (int i14 = 0; i14 <= 10 && i12 - i13 > 1; i14++) {
                int i15 = (i13 + i12) / 2;
                if (calculateContrast(setAlphaComponent(i10, i15), i11) < d10) {
                    i13 = i15;
                } else {
                    i12 = i15;
                }
            }
            return i12;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i11));
    }

    @VisibleForTesting
    static float circularInterpolate(float f10, float f11, float f12) {
        if (Math.abs(f11 - f10) > 180.0f) {
            if (f11 > f10) {
                f10 += 360.0f;
            } else {
                f11 += 360.0f;
            }
        }
        return (f10 + ((f11 - f10) * f12)) % 360.0f;
    }

    public static void colorToHSL(@ColorInt int i10, @NonNull float[] fArr) {
        RGBToHSL(Color.red(i10), Color.green(i10), Color.blue(i10), fArr);
    }

    public static void colorToLAB(@ColorInt int i10, @NonNull double[] dArr) {
        RGBToLAB(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    public static void colorToM3HCT(@ColorInt int i10, @Size(3) @NonNull float[] fArr) {
        CamColor.getM3HCTfromColor(i10, fArr);
    }

    public static void colorToXYZ(@ColorInt int i10, @NonNull double[] dArr) {
        RGBToXYZ(Color.red(i10), Color.green(i10), Color.blue(i10), dArr);
    }

    private static int compositeAlpha(int i10, int i11) {
        return 255 - (((255 - i11) * (255 - i10)) / 255);
    }

    public static int compositeColors(@ColorInt int i10, @ColorInt int i11) {
        int alpha = Color.alpha(i11);
        int alpha2 = Color.alpha(i10);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return Color.argb(compositeAlpha, compositeComponent(Color.red(i10), alpha2, Color.red(i11), alpha, compositeAlpha), compositeComponent(Color.green(i10), alpha2, Color.green(i11), alpha, compositeAlpha), compositeComponent(Color.blue(i10), alpha2, Color.blue(i11), alpha, compositeAlpha));
    }

    private static int compositeComponent(int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            return 0;
        }
        return (((i10 * 255) * i11) + ((i12 * i13) * (255 - i11))) / (i14 * 255);
    }

    private static float constrain(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : Math.min(f10, f12);
    }

    public static double distanceEuclidean(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d10) {
        if (d10 > XYZ_EPSILON) {
            return Math.pow(d10, 0.3333333333333333d);
        }
        return ((d10 * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int setAlphaComponent(@ColorInt int i10, @IntRange(from = 0, to = 255) int i11) {
        if (i11 >= 0 && i11 <= 255) {
            return (i10 & ViewCompat.MEASURED_SIZE_MASK) | (i11 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int constrain(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : Math.min(i10, i12);
    }

    @RequiresApi(26)
    @NonNull
    public static Color compositeColors(@NonNull Color color, @NonNull Color color2) {
        return a.a(color, color2);
    }
}
