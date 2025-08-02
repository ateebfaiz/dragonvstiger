package y0;

public abstract class d {
    private static float a(float f10) {
        if (f10 <= 0.04045f) {
            return f10 / 12.92f;
        }
        return (float) Math.pow((double) ((f10 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    private static float b(float f10) {
        if (f10 <= 0.0031308f) {
            return f10 * 12.92f;
        }
        return (float) ((Math.pow((double) f10, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f10, int i10, int i11) {
        if (i10 == i11 || f10 <= 0.0f) {
            return i10;
        }
        if (f10 >= 1.0f) {
            return i11;
        }
        float f11 = ((float) ((i10 >> 24) & 255)) / 255.0f;
        float a10 = a(((float) ((i10 >> 16) & 255)) / 255.0f);
        float a11 = a(((float) ((i10 >> 8) & 255)) / 255.0f);
        float a12 = a(((float) (i10 & 255)) / 255.0f);
        float a13 = a(((float) ((i11 >> 16) & 255)) / 255.0f);
        float a14 = a(((float) ((i11 >> 8) & 255)) / 255.0f);
        float a15 = a12 + (f10 * (a(((float) (i11 & 255)) / 255.0f) - a12));
        return (Math.round(b(a10 + ((a13 - a10) * f10)) * 255.0f) << 16) | (Math.round((f11 + (((((float) ((i11 >> 24) & 255)) / 255.0f) - f11) * f10)) * 255.0f) << 24) | (Math.round(b(a11 + ((a14 - a11) * f10)) * 255.0f) << 8) | Math.round(b(a15) * 255.0f);
    }
}
