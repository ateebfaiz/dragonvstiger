package androidx.constraintlayout.motion.utils;

public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";
    private double[] mT;
    private double mTotalLength = Double.NaN;
    private double[][] mY;

    public LinearCurveFit(double[] dArr, double[][] dArr2) {
        int length = dArr.length;
        int length2 = dArr2[0].length;
        this.mT = dArr;
        this.mY = dArr2;
        if (length2 > 2) {
            int i10 = 0;
            double d10 = 0.0d;
            while (true) {
                double d11 = d10;
                if (i10 < dArr.length) {
                    double d12 = dArr2[i10][0];
                    if (i10 > 0) {
                        Math.hypot(d12 - d10, d12 - d11);
                    }
                    i10++;
                    d10 = d12;
                } else {
                    this.mTotalLength = 0.0d;
                    return;
                }
            }
        }
    }

    private double getLength2D(double d10) {
        if (Double.isNaN(this.mTotalLength)) {
            return 0.0d;
        }
        double[] dArr = this.mT;
        int length = dArr.length;
        if (d10 <= dArr[0]) {
            return 0.0d;
        }
        int i10 = length - 1;
        if (d10 >= dArr[i10]) {
            return this.mTotalLength;
        }
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        int i11 = 0;
        while (i11 < i10) {
            double[] dArr2 = this.mY[i11];
            double d14 = dArr2[0];
            double d15 = dArr2[1];
            if (i11 > 0) {
                d11 += Math.hypot(d14 - d12, d15 - d13);
            }
            double[] dArr3 = this.mT;
            double d16 = dArr3[i11];
            if (d10 == d16) {
                return d11;
            }
            int i12 = i11 + 1;
            double d17 = dArr3[i12];
            if (d10 < d17) {
                double d18 = (d10 - d16) / (d17 - d16);
                double[][] dArr4 = this.mY;
                double[] dArr5 = dArr4[i11];
                double d19 = dArr5[0];
                double[] dArr6 = dArr4[i12];
                double d20 = 1.0d - d18;
                return d11 + Math.hypot(d15 - ((dArr5[1] * d20) + (dArr6[1] * d18)), d14 - ((d19 * d20) + (dArr6[0] * d18)));
            }
            i11 = i12;
            d12 = d14;
            d13 = d15;
        }
        return 0.0d;
    }

    public void getPos(double d10, double[] dArr) {
        double[] dArr2 = this.mT;
        int length = dArr2.length;
        int i10 = 0;
        int length2 = this.mY[0].length;
        if (d10 <= dArr2[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                dArr[i11] = this.mY[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr2[i12]) {
            while (i10 < length2) {
                dArr[i10] = this.mY[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    dArr[i14] = this.mY[i13][i14];
                }
            }
            double[] dArr3 = this.mT;
            int i15 = i13 + 1;
            double d11 = dArr3[i15];
            if (d10 < d11) {
                double d12 = dArr3[i13];
                double d13 = (d10 - d12) / (d11 - d12);
                while (i10 < length2) {
                    double[][] dArr4 = this.mY;
                    dArr[i10] = (dArr4[i13][i10] * (1.0d - d13)) + (dArr4[i15][i10] * d13);
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        if (r13 >= r4) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getSlope(double r13, double[] r15) {
        /*
            r12 = this;
            double[] r0 = r12.mT
            int r1 = r0.length
            double[][] r2 = r12.mY
            r3 = 0
            r2 = r2[r3]
            int r2 = r2.length
            r4 = r0[r3]
            int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0011
        L_0x000f:
            r13 = r4
            goto L_0x001a
        L_0x0011:
            int r4 = r1 + -1
            r4 = r0[r4]
            int r0 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            goto L_0x000f
        L_0x001a:
            r0 = r3
        L_0x001b:
            int r4 = r1 + -1
            if (r0 >= r4) goto L_0x0041
            double[] r4 = r12.mT
            int r5 = r0 + 1
            r6 = r4[r5]
            int r8 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x003f
            r13 = r4[r0]
            double r6 = r6 - r13
        L_0x002c:
            if (r3 >= r2) goto L_0x0041
            double[][] r13 = r12.mY
            r14 = r13[r0]
            r8 = r14[r3]
            r13 = r13[r5]
            r10 = r13[r3]
            double r10 = r10 - r8
            double r10 = r10 / r6
            r15[r3] = r10
            int r3 = r3 + 1
            goto L_0x002c
        L_0x003f:
            r0 = r5
            goto L_0x001b
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.LinearCurveFit.getSlope(double, double[]):void");
    }

    public double[] getTimePoints() {
        return this.mT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        if (r8 >= r3) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double getSlope(double r8, int r10) {
        /*
            r7 = this;
            double[] r0 = r7.mT
            int r1 = r0.length
            r2 = 0
            r3 = r0[r2]
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x000c
        L_0x000a:
            r8 = r3
            goto L_0x0015
        L_0x000c:
            int r3 = r1 + -1
            r3 = r0[r3]
            int r0 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x0015
            goto L_0x000a
        L_0x0015:
            int r0 = r1 + -1
            if (r2 >= r0) goto L_0x0035
            double[] r0 = r7.mT
            int r3 = r2 + 1
            r4 = r0[r3]
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0033
            r8 = r0[r2]
            double r4 = r4 - r8
            double[][] r8 = r7.mY
            r9 = r8[r2]
            r0 = r9[r10]
            r8 = r8[r3]
            r9 = r8[r10]
            double r9 = r9 - r0
            double r9 = r9 / r4
            return r9
        L_0x0033:
            r2 = r3
            goto L_0x0015
        L_0x0035:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.LinearCurveFit.getSlope(double, int):double");
    }

    public void getPos(double d10, float[] fArr) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i10 = 0;
        int length2 = this.mY[0].length;
        if (d10 <= dArr[0]) {
            for (int i11 = 0; i11 < length2; i11++) {
                fArr[i11] = (float) this.mY[0][i11];
            }
            return;
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            while (i10 < length2) {
                fArr[i10] = (float) this.mY[i12][i10];
                i10++;
            }
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            if (d10 == this.mT[i13]) {
                for (int i14 = 0; i14 < length2; i14++) {
                    fArr[i14] = (float) this.mY[i13][i14];
                }
            }
            double[] dArr2 = this.mT;
            int i15 = i13 + 1;
            double d11 = dArr2[i15];
            if (d10 < d11) {
                double d12 = dArr2[i13];
                double d13 = (d10 - d12) / (d11 - d12);
                while (i10 < length2) {
                    double[][] dArr3 = this.mY;
                    fArr[i10] = (float) ((dArr3[i13][i10] * (1.0d - d13)) + (dArr3[i15][i10] * d13));
                    i10++;
                }
                return;
            }
            i13 = i15;
        }
    }

    public double getPos(double d10, int i10) {
        double[] dArr = this.mT;
        int length = dArr.length;
        int i11 = 0;
        if (d10 <= dArr[0]) {
            return this.mY[0][i10];
        }
        int i12 = length - 1;
        if (d10 >= dArr[i12]) {
            return this.mY[i12][i10];
        }
        while (i11 < i12) {
            double[] dArr2 = this.mT;
            double d11 = dArr2[i11];
            if (d10 == d11) {
                return this.mY[i11][i10];
            }
            int i13 = i11 + 1;
            double d12 = dArr2[i13];
            if (d10 < d12) {
                double d13 = (d10 - d11) / (d12 - d11);
                double[][] dArr3 = this.mY;
                return (dArr3[i11][i10] * (1.0d - d13)) + (dArr3[i13][i10] * d13);
            }
            i11 = i13;
        }
        return 0.0d;
    }
}
