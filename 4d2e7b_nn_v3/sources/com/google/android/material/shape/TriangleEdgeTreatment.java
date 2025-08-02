package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f10, boolean z10) {
        this.size = f10;
        this.inside = z10;
    }

    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        float f13;
        shapePath.lineTo(f11 - (this.size * f12), 0.0f);
        if (this.inside) {
            f13 = this.size;
        } else {
            f13 = -this.size;
        }
        shapePath.lineTo(f11, f13 * f12);
        shapePath.lineTo(f11 + (this.size * f12), 0.0f);
        shapePath.lineTo(f10, 0.0f);
    }
}
