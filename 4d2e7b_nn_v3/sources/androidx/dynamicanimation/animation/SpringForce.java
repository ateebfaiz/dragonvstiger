package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringForce {
    public static final float DAMPING_RATIO_HIGH_BOUNCY = 0.2f;
    public static final float DAMPING_RATIO_LOW_BOUNCY = 0.75f;
    public static final float DAMPING_RATIO_MEDIUM_BOUNCY = 0.5f;
    public static final float DAMPING_RATIO_NO_BOUNCY = 1.0f;
    public static final float STIFFNESS_HIGH = 10000.0f;
    public static final float STIFFNESS_LOW = 200.0f;
    public static final float STIFFNESS_MEDIUM = 1500.0f;
    public static final float STIFFNESS_VERY_LOW = 50.0f;
    private static final double UNSET = Double.MAX_VALUE;
    private static final double VELOCITY_THRESHOLD_MULTIPLIER = 62.5d;
    private double mDampedFreq;
    double mDampingRatio = 0.5d;
    private double mFinalPosition = UNSET;
    private double mGammaMinus;
    private double mGammaPlus;
    private boolean mInitialized = false;
    private final DynamicAnimation.p mMassState = new DynamicAnimation.p();
    double mNaturalFreq = Math.sqrt(1500.0d);
    private double mValueThreshold;
    private double mVelocityThreshold;

    public SpringForce() {
    }

    private void init() {
        if (!this.mInitialized) {
            if (this.mFinalPosition != UNSET) {
                double d10 = this.mDampingRatio;
                if (d10 > 1.0d) {
                    double d11 = this.mNaturalFreq;
                    this.mGammaPlus = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
                    double d12 = this.mDampingRatio;
                    double d13 = this.mNaturalFreq;
                    this.mGammaMinus = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
                } else if (d10 >= 0.0d && d10 < 1.0d) {
                    this.mDampedFreq = this.mNaturalFreq * Math.sqrt(1.0d - (d10 * d10));
                }
                this.mInitialized = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float getAcceleration(float f10, float f11) {
        float finalPosition = f10 - getFinalPosition();
        double d10 = this.mNaturalFreq;
        return (float) (((-(d10 * d10)) * ((double) finalPosition)) - (((d10 * 2.0d) * this.mDampingRatio) * ((double) f11)));
    }

    public float getDampingRatio() {
        return (float) this.mDampingRatio;
    }

    public float getFinalPosition() {
        return (float) this.mFinalPosition;
    }

    public float getStiffness() {
        double d10 = this.mNaturalFreq;
        return (float) (d10 * d10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isAtEquilibrium(float f10, float f11) {
        if (((double) Math.abs(f11)) >= this.mVelocityThreshold || ((double) Math.abs(f10 - getFinalPosition())) >= this.mValueThreshold) {
            return false;
        }
        return true;
    }

    public SpringForce setDampingRatio(@FloatRange(from = 0.0d) float f10) {
        if (f10 >= 0.0f) {
            this.mDampingRatio = (double) f10;
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce setFinalPosition(float f10) {
        this.mFinalPosition = (double) f10;
        return this;
    }

    public SpringForce setStiffness(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 > 0.0f) {
            this.mNaturalFreq = Math.sqrt((double) f10);
            this.mInitialized = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void setValueThreshold(double d10) {
        double abs = Math.abs(d10);
        this.mValueThreshold = abs;
        this.mVelocityThreshold = abs * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    /* access modifiers changed from: package-private */
    public DynamicAnimation.p updateValues(double d10, double d11, long j10) {
        double d12;
        double d13;
        init();
        double d14 = ((double) j10) / 1000.0d;
        double d15 = d10 - this.mFinalPosition;
        double d16 = this.mDampingRatio;
        if (d16 > 1.0d) {
            double d17 = this.mGammaMinus;
            double d18 = this.mGammaPlus;
            double d19 = d15 - (((d17 * d15) - d11) / (d17 - d18));
            double d20 = ((d15 * d17) - d11) / (d17 - d18);
            d13 = (Math.pow(2.718281828459045d, d17 * d14) * d19) + (Math.pow(2.718281828459045d, this.mGammaPlus * d14) * d20);
            double d21 = this.mGammaMinus;
            double pow = d19 * d21 * Math.pow(2.718281828459045d, d21 * d14);
            double d22 = this.mGammaPlus;
            d12 = pow + (d20 * d22 * Math.pow(2.718281828459045d, d22 * d14));
        } else if (d16 == 1.0d) {
            double d23 = this.mNaturalFreq;
            double d24 = d11 + (d23 * d15);
            double d25 = d15 + (d24 * d14);
            d13 = Math.pow(2.718281828459045d, (-d23) * d14) * d25;
            double pow2 = d25 * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * d14);
            double d26 = this.mNaturalFreq;
            d12 = (d24 * Math.pow(2.718281828459045d, (-d26) * d14)) + (pow2 * (-d26));
        } else {
            double d27 = 1.0d / this.mDampedFreq;
            double d28 = this.mNaturalFreq;
            double d29 = d27 * ((d16 * d28 * d15) + d11);
            double pow3 = Math.pow(2.718281828459045d, (-d16) * d28 * d14) * ((Math.cos(this.mDampedFreq * d14) * d15) + (Math.sin(this.mDampedFreq * d14) * d29));
            double d30 = this.mNaturalFreq;
            double d31 = this.mDampingRatio;
            double pow4 = Math.pow(2.718281828459045d, (-d31) * d30 * d14);
            double d32 = this.mDampedFreq;
            double d33 = pow3;
            double sin = (-d32) * d15 * Math.sin(d32 * d14);
            double d34 = this.mDampedFreq;
            d12 = ((-d30) * pow3 * d31) + (pow4 * (sin + (d29 * d34 * Math.cos(d34 * d14))));
            d13 = d33;
        }
        DynamicAnimation.p pVar = this.mMassState;
        pVar.f15376a = (float) (d13 + this.mFinalPosition);
        pVar.f15377b = (float) d12;
        return pVar;
    }

    public SpringForce(float f10) {
        this.mFinalPosition = (double) f10;
    }
}
