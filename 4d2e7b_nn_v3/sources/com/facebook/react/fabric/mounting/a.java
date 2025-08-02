package com.facebook.react.fabric.mounting;

import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.yoga.o;

public abstract /* synthetic */ class a {
    static {
        LayoutMetricsConversions.Companion companion = LayoutMetricsConversions.Companion;
    }

    public static float a(int i10) {
        return LayoutMetricsConversions.Companion.getMaxSize(i10);
    }

    public static float b(int i10) {
        return LayoutMetricsConversions.Companion.getMinSize(i10);
    }

    public static o c(float f10, float f11) {
        return LayoutMetricsConversions.Companion.getYogaMeasureMode(f10, f11);
    }

    public static float d(float f10, float f11) {
        return LayoutMetricsConversions.Companion.getYogaSize(f10, f11);
    }
}
