package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class a implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    protected a(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f10) {
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f10), fArr.length - 2);
        float f11 = this.mStepSize;
        float f12 = (f10 - (((float) min) * f11)) / f11;
        float[] fArr2 = this.mValues;
        float f13 = fArr2[min];
        return f13 + (f12 * (fArr2[min + 1] - f13));
    }
}
