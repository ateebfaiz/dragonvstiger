package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = ((float) Math.tan(Math.toRadians(35.0d)));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
    private float mMaximumTangent = DEFAULT_MAX_TANGENT;
    private float mMinimumHorizontalAngle = 0.0f;
    private float mMinimumHorizontalTangent = 0.0f;
    private float mMinimumVerticalAngle = 0.0f;
    private float mMinimumVerticalTangent = 0.0f;

    public ArcMotion() {
    }

    private static float toTangent(float f10) {
        if (f10 >= 0.0f && f10 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f10 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    public Path getPath(float f10, float f11, float f12, float f13) {
        boolean z10;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        Path path = new Path();
        path.moveTo(f10, f11);
        float f19 = f12 - f10;
        float f20 = f13 - f11;
        float f21 = (f19 * f19) + (f20 * f20);
        float f22 = (f10 + f12) / 2.0f;
        float f23 = (f11 + f13) / 2.0f;
        float f24 = 0.25f * f21;
        if (f11 > f13) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (Math.abs(f19) < Math.abs(f20)) {
            float abs = Math.abs(f21 / (f20 * 2.0f));
            if (z10) {
                f15 = abs + f13;
                f14 = f12;
            } else {
                f15 = abs + f11;
                f14 = f10;
            }
            f16 = this.mMinimumVerticalTangent;
        } else {
            float f25 = f21 / (f19 * 2.0f);
            if (z10) {
                f18 = f11;
                f17 = f25 + f10;
            } else {
                f17 = f12 - f25;
                f18 = f13;
            }
            f16 = this.mMinimumHorizontalTangent;
        }
        float f26 = f24 * f16 * f16;
        float f27 = f22 - f14;
        float f28 = f23 - f15;
        float f29 = (f27 * f27) + (f28 * f28);
        float f30 = this.mMaximumTangent;
        float f31 = f24 * f30 * f30;
        if (f29 >= f26) {
            if (f29 > f31) {
                f26 = f31;
            } else {
                f26 = 0.0f;
            }
        }
        if (f26 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f26 / f29));
            f14 = ((f14 - f22) * sqrt) + f22;
            f15 = f23 + (sqrt * (f15 - f23));
        }
        path.cubicTo((f10 + f14) / 2.0f, (f11 + f15) / 2.0f, (f14 + f12) / 2.0f, (f15 + f13) / 2.0f, f12, f13);
        return path;
    }

    public void setMaximumAngle(float f10) {
        this.mMaximumAngle = f10;
        this.mMaximumTangent = toTangent(f10);
    }

    public void setMinimumHorizontalAngle(float f10) {
        this.mMinimumHorizontalAngle = f10;
        this.mMinimumHorizontalTangent = toTangent(f10);
    }

    public void setMinimumVerticalAngle(float f10) {
        this.mMinimumVerticalAngle = f10;
        this.mMinimumVerticalTangent = toTangent(f10);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, o.f16701j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }
}
