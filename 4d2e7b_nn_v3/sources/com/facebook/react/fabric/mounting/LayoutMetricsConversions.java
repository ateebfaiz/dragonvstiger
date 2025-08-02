package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.uimanager.g0;
import com.facebook.yoga.o;

public interface LayoutMetricsConversions {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final float getMaxSize(int i10) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (mode == 0) {
                return Float.POSITIVE_INFINITY;
            }
            return (float) size;
        }

        public final float getMinSize(int i10) {
            int mode = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (mode == 1073741824) {
                return (float) size;
            }
            return 0.0f;
        }

        public final o getYogaMeasureMode(float f10, float f11) {
            if (f10 == f11) {
                return o.EXACTLY;
            }
            if (Float.isInfinite(f11)) {
                return o.UNDEFINED;
            }
            return o.AT_MOST;
        }

        public final float getYogaSize(float f10, float f11) {
            if (f10 == f11) {
                return g0.d(f11);
            }
            if (Float.isInfinite(f11)) {
                return Float.POSITIVE_INFINITY;
            }
            return g0.d(f11);
        }
    }
}
