package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f10, float f11, float f12, float f13) {
        if (f11 > f13) {
            return new PointF(f12, f11);
        }
        return new PointF(f10, f13);
    }

    @NonNull
    public Path getPath(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(f10, f11);
        PointF controlPoint = getControlPoint(f10, f11, f12, f13);
        path.quadTo(controlPoint.x, controlPoint.y, f12, f13);
        return path;
    }
}
