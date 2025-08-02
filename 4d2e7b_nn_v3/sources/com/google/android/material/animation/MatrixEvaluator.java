package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues = new float[9];
    private final Matrix tempMatrix = new Matrix();
    private final float[] tempStartValues = new float[9];

    @NonNull
    public Matrix evaluate(float f10, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.tempEndValues;
            float f11 = fArr[i10];
            float f12 = this.tempStartValues[i10];
            fArr[i10] = f12 + ((f11 - f12) * f10);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
