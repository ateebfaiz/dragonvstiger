package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f10, float f11, float f12) {
        shapePath.reset(0.0f, f12 * f11, 180.0f, 180.0f - f10);
        float f13 = f12 * 2.0f * f11;
        shapePath.addArc(0.0f, 0.0f, f13, f13, 180.0f, f10);
    }

    @Deprecated
    public RoundedCornerTreatment(float f10) {
        this.radius = f10;
    }
}
