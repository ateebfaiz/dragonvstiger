package com.facebook.react.uimanager;

import com.alibaba.pdns.model.DomainUhfReportModel;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.swmansion.reanimated.layoutReanimation.Snapshot;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    public static final z f3972a = new z();

    public static class a {

        /* renamed from: f  reason: collision with root package name */
        private static final C0056a f3973f = new C0056a((DefaultConstructorMarker) null);

        /* renamed from: a  reason: collision with root package name */
        public double[] f3974a = new double[4];

        /* renamed from: b  reason: collision with root package name */
        public double[] f3975b = new double[3];

        /* renamed from: c  reason: collision with root package name */
        public double[] f3976c = new double[3];

        /* renamed from: d  reason: collision with root package name */
        public double[] f3977d = new double[3];

        /* renamed from: e  reason: collision with root package name */
        public double[] f3978e = new double[3];

        /* renamed from: com.facebook.react.uimanager.z$a$a  reason: collision with other inner class name */
        private static final class C0056a {
            private C0056a() {
            }

            /* access modifiers changed from: private */
            public final void b(double[] dArr) {
                int length = dArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    dArr[i10] = 0.0d;
                }
            }

            public /* synthetic */ C0056a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final void a() {
            C0056a aVar = f3973f;
            aVar.b(this.f3974a);
            aVar.b(this.f3975b);
            aVar.b(this.f3976c);
            aVar.b(this.f3977d);
            aVar.b(this.f3978e);
        }
    }

    private z() {
    }

    public static final void a(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[11] = ((double) -1) / d10;
    }

    public static final void b(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[5] = Math.cos(d10);
        dArr[6] = Math.sin(d10);
        dArr[9] = -Math.sin(d10);
        dArr[10] = Math.cos(d10);
    }

    public static final void c(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[0] = Math.cos(d10);
        dArr[2] = -Math.sin(d10);
        dArr[8] = Math.sin(d10);
        dArr[10] = Math.cos(d10);
    }

    public static final void d(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[0] = Math.cos(d10);
        dArr[1] = Math.sin(d10);
        dArr[4] = -Math.sin(d10);
        dArr[5] = Math.cos(d10);
    }

    public static final void e(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[0] = d10;
    }

    public static final void f(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[5] = d10;
    }

    public static final void g(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[4] = Math.tan(d10);
    }

    public static final void h(double[] dArr, double d10) {
        m.f(dArr, "m");
        dArr[1] = Math.tan(d10);
    }

    public static final void i(double[] dArr, double d10, double d11) {
        m.f(dArr, "m");
        dArr[12] = d10;
        dArr[13] = d11;
    }

    public static final void j(double[] dArr, double d10, double d11, double d12) {
        m.f(dArr, "m");
        dArr[12] = d10;
        dArr[13] = d11;
        dArr[14] = d12;
    }

    public static final void k(double[] dArr, a aVar) {
        boolean z10;
        double[] dArr2 = dArr;
        a aVar2 = aVar;
        m.f(dArr2, Snapshot.TRANSFORM_MATRIX);
        m.f(aVar2, "ctx");
        if (dArr2.length == 16) {
            z10 = true;
        } else {
            z10 = false;
        }
        p5.a.a(z10);
        double[] dArr3 = aVar2.f3974a;
        double[] dArr4 = aVar2.f3975b;
        double[] dArr5 = aVar2.f3976c;
        double[] dArr6 = aVar2.f3977d;
        double[] dArr7 = aVar2.f3978e;
        if (!f3972a.o(dArr2[15])) {
            double[][] dArr8 = new double[4][];
            for (int i10 = 0; i10 < 4; i10++) {
                dArr8[i10] = new double[4];
            }
            double[] dArr9 = new double[16];
            for (int i11 = 0; i11 < 4; i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    int i13 = (i11 * 4) + i12;
                    double d10 = dArr2[i13] / dArr2[15];
                    dArr8[i11][i12] = d10;
                    if (i12 == 3) {
                        d10 = 0.0d;
                    }
                    dArr9[i13] = d10;
                }
            }
            dArr9[15] = 1.0d;
            z zVar = f3972a;
            if (!zVar.o(m(dArr9))) {
                if (!zVar.o(dArr8[0][3]) || !zVar.o(dArr8[1][3]) || !zVar.o(dArr8[2][3])) {
                    q(new double[]{dArr8[0][3], dArr8[1][3], dArr8[2][3], dArr8[3][3]}, t(n(dArr9)), dArr3);
                } else {
                    dArr3[2] = 0.0d;
                    dArr3[1] = 0.0d;
                    dArr3[0] = 0.0d;
                    dArr3[3] = 1.0d;
                }
                for (int i14 = 0; i14 < 3; i14++) {
                    dArr6[i14] = dArr8[3][i14];
                }
                double[][] dArr10 = new double[3][];
                for (int i15 = 0; i15 < 3; i15++) {
                    dArr10[i15] = new double[3];
                }
                for (int i16 = 0; i16 < 3; i16++) {
                    double[] dArr11 = dArr10[i16];
                    double[] dArr12 = dArr8[i16];
                    dArr11[0] = dArr12[0];
                    dArr11[1] = dArr12[1];
                    dArr11[2] = dArr12[2];
                }
                double x10 = x(dArr10[0]);
                dArr4[0] = x10;
                double[] y10 = y(dArr10[0], x10);
                dArr10[0] = y10;
                double w10 = w(y10, dArr10[1]);
                dArr5[0] = w10;
                double[] u10 = u(dArr10[1], dArr10[0], 1.0d, -w10);
                dArr10[1] = u10;
                double x11 = x(u10);
                dArr4[1] = x11;
                dArr10[1] = y(dArr10[1], x11);
                dArr5[0] = dArr5[0] / dArr4[1];
                double w11 = w(dArr10[0], dArr10[2]);
                dArr5[1] = w11;
                double[] u11 = u(dArr10[2], dArr10[0], 1.0d, -w11);
                dArr10[2] = u11;
                double w12 = w(dArr10[1], u11);
                dArr5[2] = w12;
                double[] u12 = u(dArr10[2], dArr10[1], 1.0d, -w12);
                dArr10[2] = u12;
                double x12 = x(u12);
                dArr4[2] = x12;
                double[] y11 = y(dArr10[2], x12);
                dArr10[2] = y11;
                double d11 = dArr5[1];
                double d12 = dArr4[2];
                dArr5[1] = d11 / d12;
                dArr5[2] = dArr5[2] / d12;
                if (w(dArr10[0], v(dArr10[1], y11)) < 0.0d) {
                    for (int i17 = 0; i17 < 3; i17++) {
                        dArr4[i17] = dArr4[i17] * -1.0d;
                        double[] dArr13 = dArr10[i17];
                        dArr13[0] = dArr13[0] * -1.0d;
                        dArr13[1] = dArr13[1] * -1.0d;
                        dArr13[2] = dArr13[2] * -1.0d;
                    }
                }
                double[] dArr14 = dArr10[2];
                dArr7[0] = s((-Math.atan2(dArr14[1], dArr14[2])) * 57.29577951308232d);
                double[] dArr15 = dArr10[2];
                double d13 = dArr15[1];
                double d14 = dArr15[2];
                dArr7[1] = s((-Math.atan2(-dArr15[0], Math.sqrt((d13 * d13) + (d14 * d14)))) * 57.29577951308232d);
                dArr7[2] = s((-Math.atan2(dArr10[1][0], dArr10[0][0])) * 57.29577951308232d);
            }
        }
    }

    public static final double l(double d10) {
        return (d10 * 3.141592653589793d) / ((double) 180);
    }

    public static final double m(double[] dArr) {
        double[] dArr2 = dArr;
        m.f(dArr2, "matrix");
        double d10 = dArr2[0];
        double d11 = dArr2[1];
        double d12 = dArr2[2];
        double d13 = dArr2[3];
        double d14 = dArr2[4];
        double d15 = dArr2[5];
        double d16 = dArr2[6];
        double d17 = dArr2[7];
        double d18 = dArr2[8];
        double d19 = dArr2[9];
        double d20 = dArr2[10];
        double d21 = dArr2[11];
        double d22 = dArr2[12];
        double d23 = dArr2[13];
        double d24 = dArr2[14];
        double d25 = dArr2[15];
        double d26 = d13 * d16;
        double d27 = d12 * d17;
        double d28 = d13 * d15;
        double d29 = d11 * d17;
        double d30 = d12 * d15;
        double d31 = d11 * d16;
        double d32 = d13 * d14;
        double d33 = d17 * d10;
        double d34 = d12 * d14;
        double d35 = d16 * d10;
        double d36 = d11 * d14;
        double d37 = d10 * d15;
        return ((((((((((((((((((((((((d26 * d19) * d22) - ((d27 * d19) * d22)) - ((d28 * d20) * d22)) + ((d29 * d20) * d22)) + ((d30 * d21) * d22)) - ((d31 * d21) * d22)) - ((d26 * d18) * d23)) + ((d27 * d18) * d23)) + ((d32 * d20) * d23)) - ((d33 * d20) * d23)) - ((d34 * d21) * d23)) + ((d35 * d21) * d23)) + ((d28 * d18) * d24)) - ((d29 * d18) * d24)) - ((d32 * d19) * d24)) + ((d33 * d19) * d24)) + ((d36 * d21) * d24)) - ((d21 * d37) * d24)) - ((d30 * d18) * d25)) + ((d31 * d18) * d25)) + ((d34 * d19) * d25)) - ((d35 * d19) * d25)) - ((d36 * d20) * d25)) + (d37 * d20 * d25);
    }

    public static final double[] n(double[] dArr) {
        double[] dArr2 = dArr;
        m.f(dArr2, "matrix");
        double m10 = m(dArr);
        if (f3972a.o(m10)) {
            return dArr2;
        }
        double d10 = dArr2[0];
        double d11 = dArr2[1];
        double d12 = dArr2[2];
        double d13 = dArr2[3];
        double d14 = dArr2[4];
        double d15 = dArr2[5];
        double d16 = dArr2[6];
        double d17 = dArr2[7];
        double d18 = dArr2[8];
        double d19 = dArr2[9];
        double d20 = dArr2[10];
        double d21 = dArr2[11];
        double d22 = dArr2[12];
        double d23 = dArr2[13];
        double d24 = dArr2[14];
        double d25 = dArr2[15];
        double d26 = d16 * d21;
        double d27 = d17 * d20;
        double d28 = d17 * d19;
        double d29 = d15 * d21;
        double d30 = d16 * d19;
        double d31 = d15 * d20;
        double d32 = d13 * d20;
        double d33 = d12 * d21;
        double d34 = d13 * d19;
        double d35 = d11 * d21;
        double d36 = d12 * d19;
        double d37 = d11 * d20;
        double d38 = d12 * d17;
        double d39 = d13 * d16;
        double d40 = d13 * d15;
        double d41 = d11 * d17;
        double d42 = d12 * d15;
        double d43 = d11 * d16;
        double d44 = (d27 * d22) - (d26 * d22);
        double d45 = d17 * d18;
        double d46 = d14 * d21;
        double d47 = d16 * d18;
        double d48 = d14 * d20;
        double d49 = (d33 * d22) - (d32 * d22);
        double d50 = d13 * d18;
        double d51 = d10 * d21;
        double d52 = d12 * d18;
        double d53 = d10 * d20;
        double d54 = d13 * d14;
        double d55 = d17 * d10;
        double d56 = d12 * d14;
        double d57 = d16 * d10;
        double d58 = d15 * d18;
        double d59 = ((((d29 * d22) - (d28 * d22)) + (d45 * d23)) - (d46 * d23)) - (d58 * d25);
        double d60 = d14 * d19;
        double d61 = d11 * d18;
        double d62 = (((d34 * d22) - (d35 * d22)) - (d50 * d23)) + (d51 * d23) + (d61 * d25);
        double d63 = d10 * d19;
        double d64 = d11 * d14;
        double d65 = d10 * d15;
        return new double[]{((((((d26 * d23) - (d27 * d23)) + (d28 * d24)) - (d29 * d24)) - (d30 * d25)) + (d31 * d25)) / m10, ((((((d32 * d23) - (d33 * d23)) - (d34 * d24)) + (d35 * d24)) + (d36 * d25)) - (d37 * d25)) / m10, ((((((d38 * d23) - (d39 * d23)) + (d40 * d24)) - (d41 * d24)) - (d42 * d25)) + (d43 * d25)) / m10, ((((((d39 * d19) - (d38 * d19)) - (d40 * d20)) + (d41 * d20)) + (d42 * d21)) - (d43 * d21)) / m10, ((((d44 - (d45 * d24)) + (d46 * d24)) + (d47 * d25)) - (d48 * d25)) / m10, ((((d49 + (d50 * d24)) - (d51 * d24)) - (d52 * d25)) + (d53 * d25)) / m10, ((((((d39 * d22) - (d38 * d22)) - (d54 * d24)) + (d55 * d24)) + (d56 * d25)) - (d57 * d25)) / m10, ((((((d38 * d18) - (d39 * d18)) + (d54 * d20)) - (d55 * d20)) - (d56 * d21)) + (d57 * d21)) / m10, (d59 + (d60 * d25)) / m10, (d62 - (d63 * d25)) / m10, ((((((d41 * d22) - (d40 * d22)) + (d54 * d23)) - (d55 * d23)) - (d64 * d25)) + (d25 * d65)) / m10, ((((((d40 * d18) - (d41 * d18)) - (d54 * d19)) + (d55 * d19)) + (d64 * d21)) - (d21 * d65)) / m10, ((((((d30 * d22) - (d31 * d22)) - (d47 * d23)) + (d48 * d23)) + (d58 * d24)) - (d60 * d24)) / m10, ((((((d37 * d22) - (d36 * d22)) + (d52 * d23)) - (d53 * d23)) - (d61 * d24)) + (d63 * d24)) / m10, ((((((d42 * d22) - (d22 * d43)) - (d56 * d23)) + (d23 * d57)) + (d64 * d24)) - (d24 * d65)) / m10, ((((((d43 * d18) - (d42 * d18)) + (d56 * d19)) - (d57 * d19)) - (d64 * d20)) + (d65 * d20)) / m10};
    }

    private final boolean o(double d10) {
        if (!Double.isNaN(d10) && Math.abs(d10) < 1.0E-5d) {
            return true;
        }
        return false;
    }

    public static final void p(double[] dArr, double[] dArr2, double[] dArr3) {
        double[] dArr4 = dArr;
        double[] dArr5 = dArr2;
        double[] dArr6 = dArr3;
        m.f(dArr4, "out");
        m.f(dArr5, "a");
        m.f(dArr6, "b");
        double d10 = dArr5[0];
        double d11 = dArr5[1];
        double d12 = dArr5[2];
        double d13 = dArr5[3];
        double d14 = dArr5[4];
        double d15 = dArr5[5];
        double d16 = dArr5[6];
        double d17 = dArr5[7];
        double d18 = dArr5[8];
        double d19 = dArr5[9];
        double d20 = dArr5[10];
        double d21 = dArr5[11];
        double d22 = dArr5[12];
        double d23 = dArr5[13];
        double d24 = dArr5[14];
        double d25 = dArr5[15];
        double d26 = dArr6[0];
        double d27 = dArr6[1];
        double d28 = dArr6[2];
        double d29 = dArr6[3];
        dArr4[0] = (d26 * d10) + (d27 * d14) + (d28 * d18) + (d29 * d22);
        dArr4[1] = (d26 * d11) + (d27 * d15) + (d28 * d19) + (d29 * d23);
        dArr4[2] = (d26 * d12) + (d27 * d16) + (d28 * d20) + (d29 * d24);
        dArr4[3] = (d26 * d13) + (d27 * d17) + (d28 * d21) + (d29 * d25);
        double d30 = dArr6[4];
        double d31 = dArr6[5];
        double d32 = dArr6[6];
        double d33 = dArr6[7];
        dArr4[4] = (d30 * d10) + (d31 * d14) + (d32 * d18) + (d33 * d22);
        dArr4[5] = (d30 * d11) + (d31 * d15) + (d32 * d19) + (d33 * d23);
        dArr4[6] = (d30 * d12) + (d31 * d16) + (d32 * d20) + (d33 * d24);
        dArr4[7] = (d30 * d13) + (d31 * d17) + (d32 * d21) + (d33 * d25);
        double d34 = dArr6[8];
        double d35 = dArr6[9];
        double d36 = dArr6[10];
        double d37 = dArr6[11];
        dArr4[8] = (d34 * d10) + (d35 * d14) + (d36 * d18) + (d37 * d22);
        dArr4[9] = (d34 * d11) + (d35 * d15) + (d36 * d19) + (d37 * d23);
        dArr4[10] = (d34 * d12) + (d35 * d16) + (d36 * d20) + (d37 * d24);
        dArr4[11] = (d34 * d13) + (d35 * d17) + (d36 * d21) + (d37 * d25);
        double d38 = dArr6[12];
        double d39 = dArr6[13];
        double d40 = dArr6[14];
        double d41 = dArr6[15];
        dArr4[12] = (d10 * d38) + (d14 * d39) + (d18 * d40) + (d22 * d41);
        dArr4[13] = (d11 * d38) + (d15 * d39) + (d19 * d40) + (d23 * d41);
        dArr4[14] = (d12 * d38) + (d16 * d39) + (d20 * d40) + (d24 * d41);
        dArr4[15] = (d38 * d13) + (d39 * d17) + (d40 * d21) + (d41 * d25);
    }

    public static final void q(double[] dArr, double[] dArr2, double[] dArr3) {
        double[] dArr4 = dArr;
        double[] dArr5 = dArr2;
        double[] dArr6 = dArr3;
        m.f(dArr4, DomainUhfReportModel.ENCRYPTYPE);
        m.f(dArr5, "m");
        m.f(dArr6, DbParams.KEY_CHANNEL_RESULT);
        double d10 = dArr4[0];
        double d11 = dArr4[1];
        double d12 = dArr4[2];
        double d13 = dArr4[3];
        dArr6[0] = (dArr5[0] * d10) + (dArr5[4] * d11) + (dArr5[8] * d12) + (dArr5[12] * d13);
        dArr6[1] = (dArr5[1] * d10) + (dArr5[5] * d11) + (dArr5[9] * d12) + (dArr5[13] * d13);
        dArr6[2] = (dArr5[2] * d10) + (dArr5[6] * d11) + (dArr5[10] * d12) + (dArr5[14] * d13);
        dArr6[3] = (d10 * dArr5[3]) + (d11 * dArr5[7]) + (d12 * dArr5[11]) + (d13 * dArr5[15]);
    }

    public static final void r(double[] dArr) {
        m.f(dArr, "matrix");
        dArr[14] = 0.0d;
        dArr[13] = 0.0d;
        dArr[12] = 0.0d;
        dArr[11] = 0.0d;
        dArr[9] = 0.0d;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[15] = 1.0d;
        dArr[10] = 1.0d;
        dArr[5] = 1.0d;
        dArr[0] = 1.0d;
    }

    public static final double s(double d10) {
        return ((double) Math.round(d10 * 1000.0d)) * 0.001d;
    }

    public static final double[] t(double[] dArr) {
        double[] dArr2 = dArr;
        m.f(dArr2, "m");
        return new double[]{dArr2[0], dArr2[4], dArr2[8], dArr2[12], dArr2[1], dArr2[5], dArr2[9], dArr2[13], dArr2[2], dArr2[6], dArr2[10], dArr2[14], dArr2[3], dArr2[7], dArr2[11], dArr2[15]};
    }

    public static final double[] u(double[] dArr, double[] dArr2, double d10, double d11) {
        m.f(dArr, "a");
        m.f(dArr2, "b");
        return new double[]{(dArr[0] * d10) + (dArr2[0] * d11), (dArr[1] * d10) + (dArr2[1] * d11), (d10 * dArr[2]) + (d11 * dArr2[2])};
    }

    public static final double[] v(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        m.f(dArr3, "a");
        m.f(dArr4, "b");
        double d10 = dArr3[1];
        double d11 = dArr4[2];
        double d12 = dArr3[2];
        double d13 = dArr4[1];
        double d14 = dArr4[0];
        double d15 = dArr3[0];
        return new double[]{(d10 * d11) - (d12 * d13), (d12 * d14) - (d11 * d15), (d15 * d13) - (d10 * d14)};
    }

    public static final double w(double[] dArr, double[] dArr2) {
        m.f(dArr, "a");
        m.f(dArr2, "b");
        return (dArr[0] * dArr2[0]) + (dArr[1] * dArr2[1]) + (dArr[2] * dArr2[2]);
    }

    public static final double x(double[] dArr) {
        m.f(dArr, "a");
        double d10 = dArr[0];
        double d11 = dArr[1];
        double d12 = (d10 * d10) + (d11 * d11);
        double d13 = dArr[2];
        return Math.sqrt(d12 + (d13 * d13));
    }

    public static final double[] y(double[] dArr, double d10) {
        m.f(dArr, "vector");
        double d11 = (double) 1;
        if (f3972a.o(d10)) {
            d10 = x(dArr);
        }
        double d12 = d11 / d10;
        return new double[]{dArr[0] * d12, dArr[1] * d12, dArr[2] * d12};
    }
}
