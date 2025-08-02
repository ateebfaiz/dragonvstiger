package androidx.constraintlayout.motion.utils;

import java.util.Arrays;

public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2 = 6.283185307179586d;
    double[] mArea;
    private boolean mNormalized = false;
    float[] mPeriod = new float[0];
    double[] mPosition = new double[0];
    int mType;

    public void addPoint(double d10, float f10) {
        int length = this.mPeriod.length + 1;
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 1;
        }
        this.mPosition = Arrays.copyOf(this.mPosition, length);
        this.mPeriod = Arrays.copyOf(this.mPeriod, length);
        this.mArea = new double[length];
        double[] dArr = this.mPosition;
        System.arraycopy(dArr, binarySearch, dArr, binarySearch + 1, (length - binarySearch) - 1);
        this.mPosition[binarySearch] = d10;
        this.mPeriod[binarySearch] = f10;
        this.mNormalized = false;
    }

    /* access modifiers changed from: package-private */
    public double getDP(double d10) {
        if (d10 <= 0.0d) {
            d10 = 1.0E-5d;
        } else if (d10 >= 1.0d) {
            d10 = 0.999999d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch > 0 || binarySearch == 0) {
            return 0.0d;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.mPeriod;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.mPosition;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = ((double) (f10 - f11)) / (d11 - d12);
        return (d10 * d13) + (((double) f11) - (d13 * d12));
    }

    /* access modifiers changed from: package-private */
    public double getP(double d10) {
        if (d10 < 0.0d) {
            d10 = 0.0d;
        } else if (d10 > 1.0d) {
            d10 = 1.0d;
        }
        int binarySearch = Arrays.binarySearch(this.mPosition, d10);
        if (binarySearch > 0) {
            return 1.0d;
        }
        if (binarySearch == 0) {
            return 0.0d;
        }
        int i10 = -binarySearch;
        int i11 = i10 - 1;
        float[] fArr = this.mPeriod;
        float f10 = fArr[i11];
        int i12 = i10 - 2;
        float f11 = fArr[i12];
        double[] dArr = this.mPosition;
        double d11 = dArr[i11];
        double d12 = dArr[i12];
        double d13 = ((double) (f10 - f11)) / (d11 - d12);
        return this.mArea[i12] + ((((double) f11) - (d13 * d12)) * (d10 - d12)) + ((d13 * ((d10 * d10) - (d12 * d12))) / 2.0d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        return r10 * 2.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001c, code lost:
        return r0 * r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        return r5 * r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getSlope(double r10) {
        /*
            r9 = this;
            int r0 = r9.mType
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            r3 = 4616189618054758400(0x4010000000000000, double:4.0)
            switch(r0) {
                case 1: goto L_0x0060;
                case 2: goto L_0x004c;
                case 3: goto L_0x0047;
                case 4: goto L_0x0040;
                case 5: goto L_0x002c;
                case 6: goto L_0x001d;
                default: goto L_0x0009;
            }
        L_0x0009:
            double r0 = r9.PI2
            double r2 = r9.getDP(r10)
            double r0 = r0 * r2
            double r2 = r9.PI2
            double r10 = r9.getP(r10)
            double r2 = r2 * r10
            double r10 = java.lang.Math.cos(r2)
        L_0x001b:
            double r0 = r0 * r10
            return r0
        L_0x001d:
            double r5 = r9.getDP(r10)
            double r5 = r5 * r3
            double r10 = r9.getP(r10)
            double r10 = r10 * r3
            double r10 = r10 + r1
            double r10 = r10 % r3
            double r10 = r10 - r1
        L_0x002a:
            double r5 = r5 * r10
            return r5
        L_0x002c:
            double r0 = r9.PI2
            double r0 = -r0
            double r2 = r9.getDP(r10)
            double r0 = r0 * r2
            double r2 = r9.PI2
            double r10 = r9.getP(r10)
            double r2 = r2 * r10
            double r10 = java.lang.Math.sin(r2)
            goto L_0x001b
        L_0x0040:
            double r10 = r9.getDP(r10)
            double r10 = -r10
        L_0x0045:
            double r10 = r10 * r1
            return r10
        L_0x0047:
            double r10 = r9.getDP(r10)
            goto L_0x0045
        L_0x004c:
            double r5 = r9.getDP(r10)
            double r5 = r5 * r3
            double r10 = r9.getP(r10)
            double r10 = r10 * r3
            r7 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r10 = r10 + r7
            double r10 = r10 % r3
            double r10 = r10 - r1
            double r10 = java.lang.Math.signum(r10)
            goto L_0x002a
        L_0x0060:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.Oscillator.getSlope(double):double");
    }

    public double getValue(double d10) {
        double abs;
        switch (this.mType) {
            case 1:
                return Math.signum(0.5d - (getP(d10) % 1.0d));
            case 2:
                abs = Math.abs((((getP(d10) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
                break;
            case 3:
                return (((getP(d10) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
            case 4:
                abs = ((getP(d10) * 2.0d) + 1.0d) % 2.0d;
                break;
            case 5:
                return Math.cos(this.PI2 * getP(d10));
            case 6:
                double abs2 = 1.0d - Math.abs(((getP(d10) * 4.0d) % 4.0d) - 2.0d);
                abs = abs2 * abs2;
                break;
            default:
                return Math.sin(this.PI2 * getP(d10));
        }
        return 1.0d - abs;
    }

    public void normalize() {
        double d10 = 0.0d;
        int i10 = 0;
        while (true) {
            float[] fArr = this.mPeriod;
            if (i10 >= fArr.length) {
                break;
            }
            d10 += (double) fArr[i10];
            i10++;
        }
        double d11 = 0.0d;
        int i11 = 1;
        while (true) {
            float[] fArr2 = this.mPeriod;
            if (i11 >= fArr2.length) {
                break;
            }
            int i12 = i11 - 1;
            double[] dArr = this.mPosition;
            d11 += (dArr[i11] - dArr[i12]) * ((double) ((fArr2[i12] + fArr2[i11]) / 2.0f));
            i11++;
        }
        int i13 = 0;
        while (true) {
            float[] fArr3 = this.mPeriod;
            if (i13 >= fArr3.length) {
                break;
            }
            fArr3[i13] = (float) (((double) fArr3[i13]) * (d10 / d11));
            i13++;
        }
        this.mArea[0] = 0.0d;
        int i14 = 1;
        while (true) {
            float[] fArr4 = this.mPeriod;
            if (i14 < fArr4.length) {
                int i15 = i14 - 1;
                double[] dArr2 = this.mPosition;
                double d12 = dArr2[i14] - dArr2[i15];
                double[] dArr3 = this.mArea;
                dArr3[i14] = dArr3[i15] + (d12 * ((double) ((fArr4[i15] + fArr4[i14]) / 2.0f)));
                i14++;
            } else {
                this.mNormalized = true;
                return;
            }
        }
    }

    public void setType(int i10) {
        this.mType = i10;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
