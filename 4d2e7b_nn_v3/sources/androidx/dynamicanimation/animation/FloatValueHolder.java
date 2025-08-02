package androidx.dynamicanimation.animation;

public final class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f10) {
        this.mValue = f10;
    }

    public FloatValueHolder(float f10) {
        setValue(f10);
    }
}
