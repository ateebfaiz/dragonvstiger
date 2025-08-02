package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float UNSET = Float.MAX_VALUE;
    private boolean mEndRequested = false;
    private float mPendingPosition = Float.MAX_VALUE;
    private SpringForce mSpring = null;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    private void sanityCheck() {
        SpringForce springForce = this.mSpring;
        if (springForce != null) {
            double finalPosition = (double) springForce.getFinalPosition();
            if (finalPosition > ((double) this.mMaxValue)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (finalPosition < ((double) this.mMinValue)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public void animateToFinalPosition(float f10) {
        if (isRunning()) {
            this.mPendingPosition = f10;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new SpringForce(f10);
        }
        this.mSpring.setFinalPosition(f10);
        start();
    }

    public boolean canSkipToEnd() {
        if (this.mSpring.mDampingRatio > 0.0d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public float getAcceleration(float f10, float f11) {
        return this.mSpring.getAcceleration(f10, f11);
    }

    public SpringForce getSpring() {
        return this.mSpring;
    }

    /* access modifiers changed from: package-private */
    public boolean isAtEquilibrium(float f10, float f11) {
        return this.mSpring.isAtEquilibrium(f10, f11);
    }

    public SpringAnimation setSpring(SpringForce springForce) {
        this.mSpring = springForce;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(float f10) {
    }

    public void skipToEnd() {
        if (!canSkipToEnd()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.mRunning) {
            this.mEndRequested = true;
        }
    }

    public void start() {
        sanityCheck();
        this.mSpring.setValueThreshold((double) getValueThreshold());
        super.start();
    }

    /* access modifiers changed from: package-private */
    public boolean updateValueAndVelocity(long j10) {
        if (this.mEndRequested) {
            float f10 = this.mPendingPosition;
            if (f10 != Float.MAX_VALUE) {
                this.mSpring.setFinalPosition(f10);
                this.mPendingPosition = Float.MAX_VALUE;
            }
            this.mValue = this.mSpring.getFinalPosition();
            this.mVelocity = 0.0f;
            this.mEndRequested = false;
            return true;
        }
        if (this.mPendingPosition != Float.MAX_VALUE) {
            this.mSpring.getFinalPosition();
            long j11 = j10 / 2;
            DynamicAnimation.p updateValues = this.mSpring.updateValues((double) this.mValue, (double) this.mVelocity, j11);
            this.mSpring.setFinalPosition(this.mPendingPosition);
            this.mPendingPosition = Float.MAX_VALUE;
            DynamicAnimation.p updateValues2 = this.mSpring.updateValues((double) updateValues.f15376a, (double) updateValues.f15377b, j11);
            this.mValue = updateValues2.f15376a;
            this.mVelocity = updateValues2.f15377b;
        } else {
            DynamicAnimation.p updateValues3 = this.mSpring.updateValues((double) this.mValue, (double) this.mVelocity, j10);
            this.mValue = updateValues3.f15376a;
            this.mVelocity = updateValues3.f15377b;
        }
        float max = Math.max(this.mValue, this.mMinValue);
        this.mValue = max;
        float min = Math.min(max, this.mMaxValue);
        this.mValue = min;
        if (!isAtEquilibrium(min, this.mVelocity)) {
            return false;
        }
        this.mValue = this.mSpring.getFinalPosition();
        this.mVelocity = 0.0f;
        return true;
    }

    public <K> SpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k10, floatPropertyCompat);
    }

    public <K> SpringAnimation(K k10, FloatPropertyCompat<K> floatPropertyCompat, float f10) {
        super(k10, floatPropertyCompat);
        this.mSpring = new SpringForce(f10);
    }
}
