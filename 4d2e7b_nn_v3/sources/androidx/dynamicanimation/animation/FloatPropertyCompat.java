package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    static class a extends FloatPropertyCompat {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FloatProperty f15381a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, FloatProperty floatProperty) {
            super(str);
            this.f15381a = floatProperty;
        }

        public float getValue(Object obj) {
            return ((Float) this.f15381a.get(obj)).floatValue();
        }

        public void setValue(Object obj, float f10) {
            this.f15381a.setValue(obj, f10);
        }
    }

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    @RequiresApi(24)
    public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> floatProperty) {
        return new a(floatProperty.getName(), floatProperty);
    }

    public abstract float getValue(T t10);

    public abstract void setValue(T t10, float f10);
}
