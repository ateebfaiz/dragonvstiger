package androidx.constraintlayout.motion.utils;

public abstract class CurveFit {
    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE = 0;

    static class a extends CurveFit {

        /* renamed from: a  reason: collision with root package name */
        double f14511a;

        /* renamed from: b  reason: collision with root package name */
        double[] f14512b;

        a(double d10, double[] dArr) {
            this.f14511a = d10;
            this.f14512b = dArr;
        }

        public void getPos(double d10, double[] dArr) {
            double[] dArr2 = this.f14512b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public double getSlope(double d10, int i10) {
            return 0.0d;
        }

        public double[] getTimePoints() {
            return new double[]{this.f14511a};
        }

        public void getPos(double d10, float[] fArr) {
            int i10 = 0;
            while (true) {
                double[] dArr = this.f14512b;
                if (i10 < dArr.length) {
                    fArr[i10] = (float) dArr[i10];
                    i10++;
                } else {
                    return;
                }
            }
        }

        public void getSlope(double d10, double[] dArr) {
            for (int i10 = 0; i10 < this.f14512b.length; i10++) {
                dArr[i10] = 0.0d;
            }
        }

        public double getPos(double d10, int i10) {
            return this.f14512b[i10];
        }
    }

    public static CurveFit get(int i10, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i10 = 2;
        }
        if (i10 == 0) {
            return new MonotonicCurveFit(dArr, dArr2);
        }
        if (i10 != 2) {
            return new LinearCurveFit(dArr, dArr2);
        }
        return new a(dArr[0], dArr2[0]);
    }

    public static CurveFit getArc(int[] iArr, double[] dArr, double[][] dArr2) {
        return new a(iArr, dArr, dArr2);
    }

    public abstract double getPos(double d10, int i10);

    public abstract void getPos(double d10, double[] dArr);

    public abstract void getPos(double d10, float[] fArr);

    public abstract double getSlope(double d10, int i10);

    public abstract void getSlope(double d10, double[] dArr);

    public abstract double[] getTimePoints();
}
