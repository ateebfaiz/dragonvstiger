package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f10, float f11, float f12) {
        shapePath.reset(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        double d10 = (double) f12;
        double d11 = (double) f11;
        shapePath.lineTo((float) (Math.sin(Math.toRadians((double) f10)) * d10 * d11), (float) (Math.sin(Math.toRadians((double) (90.0f - f10))) * d10 * d11));
    }

    @Deprecated
    public CutCornerTreatment(float f10) {
        this.size = f10;
    }
}
