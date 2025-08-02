package androidx.constraintlayout.motion.utils;

import java.lang.reflect.Array;

public class HyperSpline {
    double[][] mCtl;
    Cubic[][] mCurve;
    double[] mCurveLength;
    int mDimensionality;
    int mPoints;
    double mTotalLength;

    public static class Cubic {
        public static final double HALF = 0.5d;
        public static final double THIRD = 0.3333333333333333d;
        double mA;
        double mB;
        double mC;
        double mD;

        public Cubic(double d10, double d11, double d12, double d13) {
            this.mA = d10;
            this.mB = d11;
            this.mC = d12;
            this.mD = d13;
        }

        public double eval(double d10) {
            return (((((this.mD * d10) + this.mC) * d10) + this.mB) * d10) + this.mA;
        }

        public double vel(double d10) {
            return (((this.mD * 0.3333333333333333d * d10) + (this.mC * 0.5d)) * d10) + this.mB;
        }
    }

    public HyperSpline(double[][] dArr) {
        setup(dArr);
    }

    static Cubic[] calcNaturalCubic(int i10, double[] dArr) {
        int i11 = i10;
        double[] dArr2 = new double[i11];
        double[] dArr3 = new double[i11];
        double[] dArr4 = new double[i11];
        int i12 = i11 - 1;
        int i13 = 0;
        dArr2[0] = 0.5d;
        int i14 = 1;
        for (int i15 = 1; i15 < i12; i15++) {
            dArr2[i15] = 1.0d / (4.0d - dArr2[i15 - 1]);
        }
        int i16 = i11 - 2;
        dArr2[i12] = 1.0d / (2.0d - dArr2[i16]);
        dArr3[0] = (dArr[1] - dArr[0]) * 3.0d * dArr2[0];
        while (i14 < i12) {
            int i17 = i14 + 1;
            int i18 = i14 - 1;
            dArr3[i14] = (((dArr[i17] - dArr[i18]) * 3.0d) - dArr3[i18]) * dArr2[i14];
            i14 = i17;
        }
        double d10 = (((dArr[i12] - dArr[i16]) * 3.0d) - dArr3[i16]) * dArr2[i12];
        dArr3[i12] = d10;
        dArr4[i12] = d10;
        while (i16 >= 0) {
            dArr4[i16] = dArr3[i16] - (dArr2[i16] * dArr4[i16 + 1]);
            i16--;
        }
        Cubic[] cubicArr = new Cubic[i12];
        while (i13 < i12) {
            double d11 = dArr[i13];
            double d12 = dArr4[i13];
            int i19 = i13 + 1;
            double d13 = dArr[i19];
            double d14 = dArr4[i19];
            cubicArr[i13] = new Cubic((double) ((float) d11), d12, (((d13 - d11) * 3.0d) - (d12 * 2.0d)) - d14, ((d11 - d13) * 2.0d) + d12 + d14);
            i13 = i19;
        }
        return cubicArr;
    }

    public double approxLength(Cubic[] cubicArr) {
        int i10;
        Cubic[] cubicArr2 = cubicArr;
        int length = cubicArr2.length;
        double[] dArr = new double[cubicArr2.length];
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        while (true) {
            i10 = 0;
            if (d11 >= 1.0d) {
                break;
            }
            double d13 = 0.0d;
            while (i10 < cubicArr2.length) {
                double d14 = dArr[i10];
                double eval = cubicArr2[i10].eval(d11);
                dArr[i10] = eval;
                double d15 = d14 - eval;
                d13 += d15 * d15;
                i10++;
            }
            if (d11 > 0.0d) {
                d12 += Math.sqrt(d13);
            }
            d11 += 0.1d;
        }
        while (i10 < cubicArr2.length) {
            double d16 = dArr[i10];
            double eval2 = cubicArr2[i10].eval(1.0d);
            dArr[i10] = eval2;
            double d17 = d16 - eval2;
            d10 += d17 * d17;
            i10++;
        }
        return d12 + Math.sqrt(d10);
    }

    public void getPos(double d10, double[] dArr) {
        double d11 = d10 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i10 >= dArr2.length - 1) {
                break;
            }
            double d12 = dArr2[i10];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.mCurve[i11][i10].eval(d11 / this.mCurveLength[i10]);
        }
    }

    public void getVelocity(double d10, double[] dArr) {
        double d11 = d10 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr2 = this.mCurveLength;
            if (i10 >= dArr2.length - 1) {
                break;
            }
            double d12 = dArr2[i10];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i10++;
        }
        for (int i11 = 0; i11 < dArr.length; i11++) {
            dArr[i11] = this.mCurve[i11][i10].vel(d11 / this.mCurveLength[i10]);
        }
    }

    public void setup(double[][] dArr) {
        int i10;
        int length = dArr[0].length;
        this.mDimensionality = length;
        int length2 = dArr.length;
        this.mPoints = length2;
        int[] iArr = new int[2];
        iArr[1] = length2;
        iArr[0] = length;
        this.mCtl = (double[][]) Array.newInstance(Double.TYPE, iArr);
        this.mCurve = new Cubic[this.mDimensionality][];
        for (int i11 = 0; i11 < this.mDimensionality; i11++) {
            for (int i12 = 0; i12 < this.mPoints; i12++) {
                this.mCtl[i11][i12] = dArr[i12][i11];
            }
        }
        int i13 = 0;
        while (true) {
            i10 = this.mDimensionality;
            if (i13 >= i10) {
                break;
            }
            Cubic[][] cubicArr = this.mCurve;
            double[] dArr2 = this.mCtl[i13];
            cubicArr[i13] = calcNaturalCubic(dArr2.length, dArr2);
            i13++;
        }
        this.mCurveLength = new double[(this.mPoints - 1)];
        this.mTotalLength = 0.0d;
        Cubic[] cubicArr2 = new Cubic[i10];
        for (int i14 = 0; i14 < this.mCurveLength.length; i14++) {
            for (int i15 = 0; i15 < this.mDimensionality; i15++) {
                cubicArr2[i15] = this.mCurve[i15][i14];
            }
            double d10 = this.mTotalLength;
            double[] dArr3 = this.mCurveLength;
            double approxLength = approxLength(cubicArr2);
            dArr3[i14] = approxLength;
            this.mTotalLength = d10 + approxLength;
        }
    }

    public HyperSpline() {
    }

    public void getPos(double d10, float[] fArr) {
        double d11 = d10 * this.mTotalLength;
        int i10 = 0;
        while (true) {
            double[] dArr = this.mCurveLength;
            if (i10 >= dArr.length - 1) {
                break;
            }
            double d12 = dArr[i10];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i10++;
        }
        for (int i11 = 0; i11 < fArr.length; i11++) {
            fArr[i11] = (float) this.mCurve[i11][i10].eval(d11 / this.mCurveLength[i10]);
        }
    }

    public double getPos(double d10, int i10) {
        double[] dArr;
        double d11 = d10 * this.mTotalLength;
        int i11 = 0;
        while (true) {
            dArr = this.mCurveLength;
            if (i11 >= dArr.length - 1) {
                break;
            }
            double d12 = dArr[i11];
            if (d12 >= d11) {
                break;
            }
            d11 -= d12;
            i11++;
        }
        return this.mCurve[i10][i11].eval(d11 / dArr[i11]);
    }
}
