package l7;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class n implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private final float f12659a;

    public n(float f10) {
        this.f12659a = f10;
    }

    public static float a(ReadableMap readableMap) {
        if (readableMap.getType("springDamping").equals(ReadableType.Number)) {
            return (float) readableMap.getDouble("springDamping");
        }
        return 0.5f;
    }

    public float getInterpolation(float f10) {
        double pow = Math.pow(2.0d, (double) (-10.0f * f10));
        float f11 = this.f12659a;
        return (float) ((pow * Math.sin(((((double) (f10 - (f11 / 4.0f))) * 3.141592653589793d) * 2.0d) / ((double) f11))) + 1.0d);
    }
}
