package androidx.constraintlayout.motion.utils;

import com.alibaba.pdns.DNSResolver;
import java.util.Arrays;

class a extends CurveFit {

    /* renamed from: a  reason: collision with root package name */
    private final double[] f14519a;

    /* renamed from: b  reason: collision with root package name */
    C0185a[] f14520b;

    /* renamed from: androidx.constraintlayout.motion.utils.a$a  reason: collision with other inner class name */
    private static class C0185a {

        /* renamed from: s  reason: collision with root package name */
        private static double[] f14521s = new double[91];

        /* renamed from: a  reason: collision with root package name */
        double[] f14522a;

        /* renamed from: b  reason: collision with root package name */
        double f14523b;

        /* renamed from: c  reason: collision with root package name */
        double f14524c;

        /* renamed from: d  reason: collision with root package name */
        double f14525d;

        /* renamed from: e  reason: collision with root package name */
        double f14526e;

        /* renamed from: f  reason: collision with root package name */
        double f14527f;

        /* renamed from: g  reason: collision with root package name */
        double f14528g;

        /* renamed from: h  reason: collision with root package name */
        double f14529h;

        /* renamed from: i  reason: collision with root package name */
        double f14530i;

        /* renamed from: j  reason: collision with root package name */
        double f14531j;

        /* renamed from: k  reason: collision with root package name */
        double f14532k;

        /* renamed from: l  reason: collision with root package name */
        double f14533l;

        /* renamed from: m  reason: collision with root package name */
        double f14534m;

        /* renamed from: n  reason: collision with root package name */
        double f14535n;

        /* renamed from: o  reason: collision with root package name */
        double f14536o;

        /* renamed from: p  reason: collision with root package name */
        double f14537p;

        /* renamed from: q  reason: collision with root package name */
        boolean f14538q;

        /* renamed from: r  reason: collision with root package name */
        boolean f14539r = false;

        C0185a(int i10, double d10, double d11, double d12, double d13, double d14, double d15) {
            int i11;
            double d16;
            double d17;
            int i12 = i10;
            double d18 = d10;
            double d19 = d11;
            double d20 = d12;
            double d21 = d13;
            double d22 = d14;
            double d23 = d15;
            boolean z10 = false;
            int i13 = 1;
            this.f14538q = i12 == 1 ? true : z10;
            this.f14524c = d18;
            this.f14525d = d19;
            this.f14530i = 1.0d / (d19 - d18);
            if (3 == i12) {
                this.f14539r = true;
            }
            double d24 = d22 - d20;
            double d25 = d23 - d21;
            if (this.f14539r || Math.abs(d24) < 0.001d || Math.abs(d25) < 0.001d) {
                this.f14539r = true;
                this.f14526e = d20;
                this.f14527f = d22;
                this.f14528g = d21;
                this.f14529h = d15;
                double hypot = Math.hypot(d25, d24);
                this.f14523b = hypot;
                this.f14535n = hypot * this.f14530i;
                double d26 = this.f14525d;
                double d27 = this.f14524c;
                this.f14533l = d24 / (d26 - d27);
                this.f14534m = d25 / (d26 - d27);
                return;
            }
            this.f14522a = new double[DNSResolver.GOBACK_LOCAL];
            boolean z11 = this.f14538q;
            if (z11) {
                i11 = -1;
            } else {
                i11 = 1;
            }
            this.f14531j = d24 * ((double) i11);
            this.f14532k = d25 * ((double) (!z11 ? -1 : i13));
            if (z11) {
                d16 = d22;
            } else {
                d16 = d20;
            }
            this.f14533l = d16;
            if (z11) {
                d17 = d21;
            } else {
                d17 = d15;
            }
            this.f14534m = d17;
            a(d12, d13, d14, d15);
            this.f14535n = this.f14523b * this.f14530i;
        }

        private void a(double d10, double d11, double d12, double d13) {
            double d14;
            double d15 = d12 - d10;
            double d16 = d11 - d13;
            int i10 = 0;
            double d17 = 0.0d;
            double d18 = 0.0d;
            double d19 = 0.0d;
            while (true) {
                double[] dArr = f14521s;
                if (i10 >= dArr.length) {
                    break;
                }
                double d20 = d17;
                double radians = Math.toRadians((((double) i10) * 90.0d) / ((double) (dArr.length - 1)));
                double sin = Math.sin(radians) * d15;
                double cos = Math.cos(radians) * d16;
                if (i10 > 0) {
                    d14 = Math.hypot(sin - d18, cos - d19) + d20;
                    f14521s[i10] = d14;
                } else {
                    d14 = d20;
                }
                i10++;
                d19 = cos;
                double d21 = sin;
                d17 = d14;
                d18 = d21;
            }
            double d22 = d17;
            this.f14523b = d22;
            int i11 = 0;
            while (true) {
                double[] dArr2 = f14521s;
                if (i11 >= dArr2.length) {
                    break;
                }
                dArr2[i11] = dArr2[i11] / d22;
                i11++;
            }
            int i12 = 0;
            while (true) {
                double[] dArr3 = this.f14522a;
                if (i12 < dArr3.length) {
                    double length = ((double) i12) / ((double) (dArr3.length - 1));
                    int binarySearch = Arrays.binarySearch(f14521s, length);
                    if (binarySearch >= 0) {
                        this.f14522a[i12] = (double) (binarySearch / (f14521s.length - 1));
                    } else if (binarySearch == -1) {
                        this.f14522a[i12] = 0.0d;
                    } else {
                        int i13 = -binarySearch;
                        int i14 = i13 - 2;
                        double[] dArr4 = f14521s;
                        double d23 = dArr4[i14];
                        this.f14522a[i12] = (((double) i14) + ((length - d23) / (dArr4[i13 - 1] - d23))) / ((double) (dArr4.length - 1));
                    }
                    i12++;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public double b() {
            double d10 = this.f14531j * this.f14537p;
            double hypot = this.f14535n / Math.hypot(d10, (-this.f14532k) * this.f14536o);
            if (this.f14538q) {
                d10 = -d10;
            }
            return d10 * hypot;
        }

        /* access modifiers changed from: package-private */
        public double c() {
            double d10 = this.f14531j * this.f14537p;
            double d11 = (-this.f14532k) * this.f14536o;
            double hypot = this.f14535n / Math.hypot(d10, d11);
            if (this.f14538q) {
                return (-d11) * hypot;
            }
            return d11 * hypot;
        }

        public double d(double d10) {
            return this.f14533l;
        }

        public double e(double d10) {
            return this.f14534m;
        }

        public double f(double d10) {
            double d11 = (d10 - this.f14524c) * this.f14530i;
            double d12 = this.f14526e;
            return d12 + (d11 * (this.f14527f - d12));
        }

        public double g(double d10) {
            double d11 = (d10 - this.f14524c) * this.f14530i;
            double d12 = this.f14528g;
            return d12 + (d11 * (this.f14529h - d12));
        }

        /* access modifiers changed from: package-private */
        public double h() {
            return this.f14533l + (this.f14531j * this.f14536o);
        }

        /* access modifiers changed from: package-private */
        public double i() {
            return this.f14534m + (this.f14532k * this.f14537p);
        }

        /* access modifiers changed from: package-private */
        public double j(double d10) {
            if (d10 <= 0.0d) {
                return 0.0d;
            }
            if (d10 >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.f14522a;
            double length = d10 * ((double) (dArr.length - 1));
            int i10 = (int) length;
            double d11 = length - ((double) i10);
            double d12 = dArr[i10];
            return d12 + (d11 * (dArr[i10 + 1] - d12));
        }

        /* access modifiers changed from: package-private */
        public void k(double d10) {
            double d11;
            if (this.f14538q) {
                d11 = this.f14525d - d10;
            } else {
                d11 = d10 - this.f14524c;
            }
            double j10 = j(d11 * this.f14530i) * 1.5707963267948966d;
            this.f14536o = Math.sin(j10);
            this.f14537p = Math.cos(j10);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r5 == 1) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(int[] r25, double[] r26, double[][] r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = r26
            r24.<init>()
            r0.f14519a = r1
            int r2 = r1.length
            r3 = 1
            int r2 = r2 - r3
            androidx.constraintlayout.motion.utils.a$a[] r2 = new androidx.constraintlayout.motion.utils.a.C0185a[r2]
            r0.f14520b = r2
            r2 = 0
            r4 = r2
            r5 = r3
            r6 = r5
        L_0x0014:
            androidx.constraintlayout.motion.utils.a$a[] r7 = r0.f14520b
            int r8 = r7.length
            if (r4 >= r8) goto L_0x004f
            r8 = r25[r4]
            r9 = 3
            if (r8 == 0) goto L_0x002f
            if (r8 == r3) goto L_0x002d
            r10 = 2
            if (r8 == r10) goto L_0x002b
            if (r8 == r9) goto L_0x0026
            goto L_0x0030
        L_0x0026:
            if (r5 != r3) goto L_0x002d
            goto L_0x002b
        L_0x0029:
            r6 = r5
            goto L_0x0030
        L_0x002b:
            r5 = r10
            goto L_0x0029
        L_0x002d:
            r5 = r3
            goto L_0x0029
        L_0x002f:
            r6 = r9
        L_0x0030:
            androidx.constraintlayout.motion.utils.a$a r22 = new androidx.constraintlayout.motion.utils.a$a
            r10 = r1[r4]
            int r23 = r4 + 1
            r12 = r1[r23]
            r8 = r27[r4]
            r14 = r8[r2]
            r16 = r8[r3]
            r8 = r27[r23]
            r18 = r8[r2]
            r20 = r8[r3]
            r8 = r22
            r9 = r6
            r8.<init>(r9, r10, r12, r14, r16, r18, r20)
            r7[r4] = r22
            r4 = r23
            goto L_0x0014
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.a.<init>(int[], double[], double[][]):void");
    }

    public void getPos(double d10, double[] dArr) {
        C0185a[] aVarArr = this.f14520b;
        double d11 = aVarArr[0].f14524c;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > aVarArr[aVarArr.length - 1].f14525d) {
            d10 = aVarArr[aVarArr.length - 1].f14525d;
        }
        int i10 = 0;
        while (true) {
            C0185a[] aVarArr2 = this.f14520b;
            if (i10 < aVarArr2.length) {
                C0185a aVar = aVarArr2[i10];
                if (d10 > aVar.f14525d) {
                    i10++;
                } else if (aVar.f14539r) {
                    dArr[0] = aVar.f(d10);
                    dArr[1] = this.f14520b[i10].g(d10);
                    return;
                } else {
                    aVar.k(d10);
                    dArr[0] = this.f14520b[i10].h();
                    dArr[1] = this.f14520b[i10].i();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void getSlope(double d10, double[] dArr) {
        C0185a[] aVarArr = this.f14520b;
        double d11 = aVarArr[0].f14524c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > aVarArr[aVarArr.length - 1].f14525d) {
            d10 = aVarArr[aVarArr.length - 1].f14525d;
        }
        int i10 = 0;
        while (true) {
            C0185a[] aVarArr2 = this.f14520b;
            if (i10 < aVarArr2.length) {
                C0185a aVar = aVarArr2[i10];
                if (d10 > aVar.f14525d) {
                    i10++;
                } else if (aVar.f14539r) {
                    dArr[0] = aVar.d(d10);
                    dArr[1] = this.f14520b[i10].e(d10);
                    return;
                } else {
                    aVar.k(d10);
                    dArr[0] = this.f14520b[i10].b();
                    dArr[1] = this.f14520b[i10].c();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double[] getTimePoints() {
        return this.f14519a;
    }

    public void getPos(double d10, float[] fArr) {
        C0185a[] aVarArr = this.f14520b;
        double d11 = aVarArr[0].f14524c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > aVarArr[aVarArr.length - 1].f14525d) {
            d10 = aVarArr[aVarArr.length - 1].f14525d;
        }
        int i10 = 0;
        while (true) {
            C0185a[] aVarArr2 = this.f14520b;
            if (i10 < aVarArr2.length) {
                C0185a aVar = aVarArr2[i10];
                if (d10 > aVar.f14525d) {
                    i10++;
                } else if (aVar.f14539r) {
                    fArr[0] = (float) aVar.f(d10);
                    fArr[1] = (float) this.f14520b[i10].g(d10);
                    return;
                } else {
                    aVar.k(d10);
                    fArr[0] = (float) this.f14520b[i10].h();
                    fArr[1] = (float) this.f14520b[i10].i();
                    return;
                }
            } else {
                return;
            }
        }
    }

    public double getSlope(double d10, int i10) {
        C0185a[] aVarArr = this.f14520b;
        int i11 = 0;
        double d11 = aVarArr[0].f14524c;
        if (d10 < d11) {
            d10 = d11;
        }
        if (d10 > aVarArr[aVarArr.length - 1].f14525d) {
            d10 = aVarArr[aVarArr.length - 1].f14525d;
        }
        while (true) {
            C0185a[] aVarArr2 = this.f14520b;
            if (i11 >= aVarArr2.length) {
                return Double.NaN;
            }
            C0185a aVar = aVarArr2[i11];
            if (d10 > aVar.f14525d) {
                i11++;
            } else if (!aVar.f14539r) {
                aVar.k(d10);
                if (i10 == 0) {
                    return this.f14520b[i11].b();
                }
                return this.f14520b[i11].c();
            } else if (i10 == 0) {
                return aVar.d(d10);
            } else {
                return aVar.e(d10);
            }
        }
    }

    public double getPos(double d10, int i10) {
        C0185a[] aVarArr = this.f14520b;
        int i11 = 0;
        double d11 = aVarArr[0].f14524c;
        if (d10 < d11) {
            d10 = d11;
        } else if (d10 > aVarArr[aVarArr.length - 1].f14525d) {
            d10 = aVarArr[aVarArr.length - 1].f14525d;
        }
        while (true) {
            C0185a[] aVarArr2 = this.f14520b;
            if (i11 >= aVarArr2.length) {
                return Double.NaN;
            }
            C0185a aVar = aVarArr2[i11];
            if (d10 > aVar.f14525d) {
                i11++;
            } else if (!aVar.f14539r) {
                aVar.k(d10);
                if (i10 == 0) {
                    return this.f14520b[i11].h();
                }
                return this.f14520b[i11].i();
            } else if (i10 == 0) {
                return aVar.f(d10);
            } else {
                return aVar.g(d10);
            }
        }
    }
}
