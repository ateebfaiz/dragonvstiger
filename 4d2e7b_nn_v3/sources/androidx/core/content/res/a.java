package androidx.core.content.res;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;

abstract class a {

    /* renamed from: a  reason: collision with root package name */
    static final float[][] f14896a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: b  reason: collision with root package name */
    static final float[][] f14897b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: c  reason: collision with root package name */
    static final float[] f14898c = {95.047f, 100.0f, 108.883f};

    /* renamed from: d  reason: collision with root package name */
    static final float[][] f14899d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    static int a(float f10) {
        float f11;
        boolean z10;
        float f12;
        if (f10 < 1.0f) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (f10 > 99.0f) {
            return -1;
        }
        float f13 = (f10 + 16.0f) / 116.0f;
        if (f10 > 8.0f) {
            f11 = f13 * f13 * f13;
        } else {
            f11 = f10 / 903.2963f;
        }
        float f14 = f13 * f13 * f13;
        if (f14 > 0.008856452f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f12 = f14;
        } else {
            f12 = ((f13 * 116.0f) - 16.0f) / 903.2963f;
        }
        if (!z10) {
            f14 = ((f13 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f14898c;
        return ColorUtils.XYZToColor((double) (f12 * fArr[0]), (double) (f11 * fArr[1]), (double) (f14 * fArr[2]));
    }

    static float b(int i10) {
        return c(g(i10));
    }

    static float c(float f10) {
        float f11 = f10 / 100.0f;
        if (f11 <= 0.008856452f) {
            return f11 * 903.2963f;
        }
        return (((float) Math.cbrt((double) f11)) * 116.0f) - 16.0f;
    }

    static float d(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    static float e(int i10) {
        float pow;
        float f10 = ((float) i10) / 255.0f;
        if (f10 <= 0.04045f) {
            pow = f10 / 12.92f;
        } else {
            pow = (float) Math.pow((double) ((f10 + 0.055f) / 1.055f), 2.4000000953674316d);
        }
        return pow * 100.0f;
    }

    static void f(int i10, float[] fArr) {
        float e10 = e(Color.red(i10));
        float e11 = e(Color.green(i10));
        float e12 = e(Color.blue(i10));
        float[][] fArr2 = f14899d;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[0] * e10) + (fArr3[1] * e11) + (fArr3[2] * e12);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[0] * e10) + (fArr4[1] * e11) + (fArr4[2] * e12);
        float[] fArr5 = fArr2[2];
        fArr[2] = (e10 * fArr5[0]) + (e11 * fArr5[1]) + (e12 * fArr5[2]);
    }

    static float g(int i10) {
        float e10 = e(Color.red(i10));
        float e11 = e(Color.green(i10));
        float e12 = e(Color.blue(i10));
        float[] fArr = f14899d[1];
        return (e10 * fArr[0]) + (e11 * fArr[1]) + (e12 * fArr[2]);
    }

    static float h(float f10) {
        float f11;
        if (f10 > 8.0f) {
            f11 = (float) Math.pow((((double) f10) + 16.0d) / 116.0d, 3.0d);
        } else {
            f11 = f10 / 903.2963f;
        }
        return f11 * 100.0f;
    }
}
