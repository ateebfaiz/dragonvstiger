package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.u;

public class DimensionPropConverter {
    @Nullable
    public static YogaValue getDimension(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Double) {
            return new YogaValue(((Double) obj).floatValue(), u.POINT);
        }
        if (obj instanceof String) {
            return YogaValue.a((String) obj);
        }
        throw new JSApplicationCausedNativeException("DimensionValue: the value must be a number or string.");
    }
}
