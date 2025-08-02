package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class EdgeTreatment {
    /* access modifiers changed from: package-private */
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f10, float f11, @NonNull ShapePath shapePath) {
        getEdgePath(f10, f10 / 2.0f, f11, shapePath);
    }

    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f10, 0.0f);
    }
}
