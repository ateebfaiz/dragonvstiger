package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float offset;
    private final EdgeTreatment other;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f10) {
        this.other = edgeTreatment;
        this.offset = f10;
    }

    /* access modifiers changed from: package-private */
    public boolean forceIntersection() {
        return this.other.forceIntersection();
    }

    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        this.other.getEdgePath(f10, f11 - this.offset, f12, shapePath);
    }
}
