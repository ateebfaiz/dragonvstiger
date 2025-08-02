package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f10, float f11, float f12) {
        this.fabMargin = f10;
        this.roundedCornerRadius = f11;
        setCradleVerticalOffset(f12);
        this.horizontalOffset = 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        boolean z10;
        float f13;
        float f14;
        float f15 = f10;
        ShapePath shapePath2 = shapePath;
        float f16 = this.fabDiameter;
        if (f16 == 0.0f) {
            shapePath2.lineTo(f15, 0.0f);
            return;
        }
        float f17 = ((this.fabMargin * 2.0f) + f16) / 2.0f;
        float f18 = f12 * this.roundedCornerRadius;
        float f19 = f11 + this.horizontalOffset;
        float f20 = (this.cradleVerticalOffset * f12) + ((1.0f - f12) * f17);
        if (f20 / f17 >= 1.0f) {
            shapePath2.lineTo(f15, 0.0f);
            return;
        }
        float f21 = this.fabCornerSize;
        float f22 = f21 * f12;
        if (f21 == -1.0f || Math.abs((f21 * 2.0f) - f16) < 0.1f) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        if (!z11) {
            f14 = ROUNDED_CORNER_FAB_OFFSET;
            f13 = 0.0f;
        } else {
            f13 = f20;
            f14 = 0.0f;
        }
        float f23 = f17 + f18;
        float f24 = f13 + f18;
        float sqrt = (float) Math.sqrt((double) ((f23 * f23) - (f24 * f24)));
        float f25 = f19 - sqrt;
        float f26 = f19 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f24)));
        float f27 = (90.0f - degrees) + f14;
        shapePath2.lineTo(f25, 0.0f);
        float f28 = f18 * 2.0f;
        float f29 = degrees;
        shapePath.addArc(f25 - f18, 0.0f, f25 + f18, f28, 270.0f, degrees);
        if (z11) {
            shapePath.addArc(f19 - f17, (-f17) - f13, f19 + f17, f17 - f13, 180.0f - f27, (f27 * 2.0f) - 180.0f);
        } else {
            float f30 = this.fabMargin;
            float f31 = f22 * 2.0f;
            float f32 = f19 - f17;
            shapePath.addArc(f32, -(f22 + f30), f32 + f30 + f31, f30 + f22, 180.0f - f27, ((f27 * 2.0f) - 180.0f) / 2.0f);
            float f33 = f19 + f17;
            float f34 = this.fabMargin;
            shapePath2.lineTo(f33 - ((f34 / 2.0f) + f22), f34 + f22);
            float f35 = this.fabMargin;
            shapePath.addArc(f33 - (f31 + f35), -(f22 + f35), f33, f35 + f22, 90.0f, f27 - 0.049804688f);
        }
        shapePath.addArc(f26 - f18, 0.0f, f26 + f18, f28, 270.0f - f29, f29);
        shapePath2.lineTo(f15, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* access modifiers changed from: package-private */
    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f10) {
        if (f10 >= 0.0f) {
            this.cradleVerticalOffset = f10;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCornerSize(float f10) {
        this.fabCornerSize = f10;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleMargin(float f10) {
        this.fabMargin = f10;
    }

    /* access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f10) {
        this.roundedCornerRadius = f10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f10) {
        this.fabDiameter = f10;
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalOffset(float f10) {
        this.horizontalOffset = f10;
    }
}
