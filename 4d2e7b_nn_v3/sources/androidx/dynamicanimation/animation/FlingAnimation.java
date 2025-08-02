package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final a mFlingForce;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private float f15378a = -4.2f;

        /* renamed from: b  reason: collision with root package name */
        private float f15379b;

        /* renamed from: c  reason: collision with root package name */
        private final DynamicAnimation.p f15380c = new DynamicAnimation.p();

        a() {
        }

        public float a(float f10, float f11) {
            return f11 * this.f15378a;
        }

        /* access modifiers changed from: package-private */
        public float b() {
            return this.f15378a / -4.2f;
        }

        public boolean c(float f10, float f11) {
            if (Math.abs(f11) < this.f15379b) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d(float f10) {
            this.f15378a = f10 * -4.2f;
        }

        /* access modifiers changed from: package-private */
        public void e(float f10) {
            this.f15379b = f10 * 62.5f;
        }

        /* access modifiers changed from: package-private */
        public DynamicAnimation.p f(float f10, float f11, long j10) {
            float f12 = (float) j10;
            this.f15380c.f15377b = (float) (((double) f11) * Math.exp((double) ((f12 / 1000.0f) * this.f15378a)));
            DynamicAnimation.p pVar = this.f15380c;
            float f13 = this.f15378a;
            pVar.f15376a = (float) (((double) (f10 - (f11 / f13))) + (((double) (f11 / f13)) * Math.exp((double) ((f13 * f12) / 1000.0f))));
            DynamicAnimation.p pVar2 = this.f15380c;
            if (c(pVar2.f15376a, pVar2.f15377b)) {
                this.f15380c.f15377b = 0.0f;
            }
            return this.f15380c;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        a aVar = new a();
        this.mFlingForce = aVar;
        aVar.e(getValueThreshold());
    }

    /* access modifiers changed from: package-private */
    public float getAcceleration(float f10, float f11) {
        return this.mFlingForce.a(f10, f11);
    }

    public float getFriction() {
        return this.mFlingForce.b();
    }

    /* access modifiers changed from: package-private */
    public boolean isAtEquilibrium(float f10, float f11) {
        if (f10 >= this.mMaxValue || f10 <= this.mMinValue || this.mFlingForce.c(f10, f11)) {
            return true;
        }
        return false;
    }

    public FlingAnimation setFriction(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 > 0.0f) {
            this.mFlingForce.d(f10);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(float f10) {
        this.mFlingForce.e(f10);
    }

    /* access modifiers changed from: package-private */
    public boolean updateValueAndVelocity(long j10) {
        DynamicAnimation.p f10 = this.mFlingForce.f(this.mValue, this.mVelocity, j10);
        float f11 = f10.f15376a;
        this.mValue = f11;
        float f12 = f10.f15377b;
        this.mVelocity = f12;
        float f13 = this.mMinValue;
        if (f11 < f13) {
            this.mValue = f13;
            return true;
        }
        float f14 = this.mMaxValue;
        if (f11 > f14) {
            this.mValue = f14;
            return true;
        } else if (isAtEquilibrium(f11, f12)) {
            return true;
        } else {
            return false;
        }
    }

    public FlingAnimation setMaxValue(float f10) {
        super.setMaxValue(f10);
        return this;
    }

    public FlingAnimation setMinValue(float f10) {
        super.setMinValue(f10);
        return this;
    }

    public FlingAnimation setStartVelocity(float f10) {
        super.setStartVelocity(f10);
        return this;
    }

    public <K> FlingAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
        a aVar = new a();
        this.mFlingForce = aVar;
        aVar.e(getValueThreshold());
    }
}
