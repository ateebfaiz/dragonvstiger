package com.google.android.material.color;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f8101a = {95.047f, 100.0f, 108.883f};

    public static int a(int i10) {
        return i10 & 255;
    }

    public static float b(float f10) {
        if (f10 <= 0.0031308f) {
            return f10 * 12.92f;
        }
        return (((float) Math.pow((double) f10, 0.4166666567325592d)) * 1.055f) - 0.055f;
    }

    public static int c(int i10) {
        return (i10 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static int d(float f10) {
        boolean z10;
        float f11;
        float f12;
        float f13 = (f10 + 16.0f) / 116.0f;
        float f14 = f13 * f13 * f13;
        if (f14 > 0.008856452f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (f10 > 8.0f) {
            f11 = f14;
        } else {
            f11 = f10 / 903.2963f;
        }
        if (z10) {
            f12 = f14;
        } else {
            f12 = ((f13 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z10) {
            f14 = ((f13 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f8101a;
        return f(new float[]{f12 * fArr[0], f11 * fArr[1], f14 * fArr[2]});
    }

    public static int e(int i10, int i11, int i12) {
        return ((i10 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((i11 & 255) << 8) | (i12 & 255);
    }

    public static int f(float[] fArr) {
        return g(fArr[0], fArr[1], fArr[2]);
    }

    public static int g(float f10, float f11, float f12) {
        float f13 = f10 / 100.0f;
        float f14 = f11 / 100.0f;
        float f15 = f12 / 100.0f;
        float f16 = (3.2406f * f13) + (-1.5372f * f14) + (-0.4986f * f15);
        float f17 = (f13 * 0.0557f) + (f14 * -0.204f) + (f15 * 1.057f);
        return e(Math.max(Math.min(255, Math.round(b(f16) * 255.0f)), 0), Math.max(Math.min(255, Math.round(b((-0.9689f * f13) + (1.8758f * f14) + (0.0415f * f15)) * 255.0f)), 0), Math.max(Math.min(255, Math.round(b(f17) * 255.0f)), 0));
    }

    public static double[] h(int i10) {
        double d10;
        double d11;
        double d12;
        float[] m10 = m(i10);
        float f10 = m10[1];
        float[] fArr = f8101a;
        double d13 = (double) (f10 / fArr[1]);
        if (d13 > 0.008856451679035631d) {
            d10 = Math.cbrt(d13);
        } else {
            d10 = ((d13 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        double d14 = (double) (m10[0] / fArr[0]);
        if (d14 > 0.008856451679035631d) {
            d11 = Math.cbrt(d14);
        } else {
            d11 = ((d14 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        double d15 = (double) (m10[2] / fArr[2]);
        if (d15 > 0.008856451679035631d) {
            d12 = Math.cbrt(d15);
        } else {
            d12 = ((d15 * 903.2962962962963d) + 16.0d) / 116.0d;
        }
        return new double[]{(116.0d * d10) - 16.0d, (d11 - d10) * 500.0d, (d10 - d12) * 200.0d};
    }

    public static float i(float f10) {
        if (f10 <= 0.04045f) {
            return f10 / 12.92f;
        }
        return (float) Math.pow((double) ((f10 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static float j(int i10) {
        return (float) h(i10)[0];
    }

    public static int k(int i10) {
        return (i10 & 16711680) >> 16;
    }

    public static final float[] l() {
        return Arrays.copyOf(f8101a, 3);
    }

    public static float[] m(int i10) {
        float i11 = i(((float) k(i10)) / 255.0f) * 100.0f;
        float i12 = i(((float) c(i10)) / 255.0f) * 100.0f;
        float i13 = i(((float) a(i10)) / 255.0f) * 100.0f;
        return new float[]{(0.41233894f * i11) + (0.35762063f * i12) + (0.18051042f * i13), (0.2126f * i11) + (0.7152f * i12) + (0.0722f * i13), (i11 * 0.01932141f) + (i12 * 0.11916382f) + (i13 * 0.9503448f)};
    }

    public static float n(float f10) {
        float f11;
        if (f10 > 8.0f) {
            f11 = (float) Math.pow((((double) f10) + 16.0d) / 116.0d, 3.0d);
        } else {
            f11 = f10 / 903.2963f;
        }
        return f11 * 100.0f;
    }
}
