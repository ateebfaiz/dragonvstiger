package jb;

import android.graphics.RectF;

public abstract class g {
    public static float[] a(RectF rectF) {
        return new float[]{rectF.centerX(), rectF.centerY()};
    }

    public static float[] b(RectF rectF) {
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.right;
        float f13 = rectF.bottom;
        return new float[]{f10, f11, f12, f11, f12, f13, f10, f13};
    }

    public static float[] c(float[] fArr) {
        return new float[]{(float) Math.sqrt(Math.pow((double) (fArr[0] - fArr[2]), 2.0d) + Math.pow((double) (fArr[1] - fArr[3]), 2.0d)), (float) Math.sqrt(Math.pow((double) (fArr[2] - fArr[4]), 2.0d) + Math.pow((double) (fArr[3] - fArr[5]), 2.0d))};
    }

    public static RectF d(float[] fArr) {
        RectF rectF = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        for (int i10 = 1; i10 < fArr.length; i10 += 2) {
            float round = ((float) Math.round(fArr[i10 - 1] * 10.0f)) / 10.0f;
            float round2 = ((float) Math.round(fArr[i10] * 10.0f)) / 10.0f;
            float f10 = rectF.left;
            if (round < f10) {
                f10 = round;
            }
            rectF.left = f10;
            float f11 = rectF.top;
            if (round2 < f11) {
                f11 = round2;
            }
            rectF.top = f11;
            float f12 = rectF.right;
            if (round <= f12) {
                round = f12;
            }
            rectF.right = round;
            float f13 = rectF.bottom;
            if (round2 <= f13) {
                round2 = f13;
            }
            rectF.bottom = round2;
        }
        rectF.sort();
        return rectF;
    }
}
