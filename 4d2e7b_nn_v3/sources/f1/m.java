package f1;

import androidx.core.location.LocationRequestCompat;
import com.adjust.sdk.Constants;
import com.google.android.games.paddleboat.GameControllerManager;
import f1.j;
import f1.k;
import java.math.BigDecimal;
import java.util.Arrays;
import okhttp3.HttpUrl;

public abstract class m {
    public static final j.f A = new c();
    public static final k.a B = new d();
    public static final j.f C = new e();
    public static final k.a D = new f();
    public static final j.f E = new g();
    public static final j.f F = new h();
    public static final k.a G = new i();
    public static final j.f H = new j();
    public static final k.a I = new l();
    public static final j.f J = new C0276m();
    public static final j.f K = new n();
    public static final k.a L = new o();
    public static final j.f M = new p();
    public static final k.a N = new q();
    public static final j.f O = new r();
    public static final k.a P = new s();
    static final j.f Q = new t();
    private static final byte[] R = "-2147483648".getBytes();
    private static final byte[] S = "-9223372036854775808".getBytes();
    private static final BigDecimal T = BigDecimal.valueOf(LocationRequestCompat.PASSIVE_INTERVAL);
    private static final BigDecimal U = BigDecimal.valueOf(Long.MIN_VALUE);

    /* renamed from: a  reason: collision with root package name */
    public static final short[] f21455a = new short[0];

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f21456b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final long[] f21457c = new long[0];

    /* renamed from: d  reason: collision with root package name */
    public static final float[] f21458d = new float[0];

    /* renamed from: e  reason: collision with root package name */
    public static final double[] f21459e = new double[0];

    /* renamed from: f  reason: collision with root package name */
    public static final Short f21460f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final Integer f21461g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final Long f21462h = 0L;

    /* renamed from: i  reason: collision with root package name */
    public static final Float f21463i = Float.valueOf(0.0f);

    /* renamed from: j  reason: collision with root package name */
    public static final Double f21464j = Double.valueOf(0.0d);

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f21465k = new int[1000];

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f21466l = {111, 222, 444, 888, 1776};

    /* renamed from: m  reason: collision with root package name */
    private static final int[] f21467m = {50, 100, 200, Constants.MINIMAL_ERROR_STATUS_CODE, 800};

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f21468n = {10000, 1000, 100, 10, 1};

    /* renamed from: o  reason: collision with root package name */
    private static final double[] f21469o = {10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d, 9.999999999999999E22d, 1.0E24d, 1.0E25d, 1.0E26d, 1.0E27d, 1.0E28d, 1.0E29d, 1.0E30d, 1.0E31d, 1.0E32d, 1.0E33d, 1.0E34d, 1.0E35d, 1.0E36d, 1.0E37d, 1.0E38d, 1.0E39d, 1.0E40d, 1.0E41d, 1.0E42d, 1.0E43d, 1.0E44d, 1.0E45d, 1.0E46d, 1.0E47d, 1.0E48d, 1.0E49d, 1.0E50d, 1.0E51d, 1.0E52d, 1.0E53d, 1.0E54d, 1.0E55d, 1.0E56d, 1.0E57d, 1.0E58d, 1.0E59d, 1.0E60d, 1.0E61d, 1.0E62d, 1.0E63d, 1.0E64d, 1.0E65d};

    /* renamed from: p  reason: collision with root package name */
    public static final j.f f21470p = new k();

    /* renamed from: q  reason: collision with root package name */
    public static final j.f f21471q = new u();

    /* renamed from: r  reason: collision with root package name */
    public static final k.a f21472r = new v();

    /* renamed from: s  reason: collision with root package name */
    public static final j.f f21473s = new w();

    /* renamed from: t  reason: collision with root package name */
    public static final k.a f21474t = new x();

    /* renamed from: u  reason: collision with root package name */
    public static final j.f f21475u = new y();

    /* renamed from: v  reason: collision with root package name */
    public static final j.f f21476v = new z();

    /* renamed from: w  reason: collision with root package name */
    public static final k.a f21477w = new a0();

    /* renamed from: x  reason: collision with root package name */
    public static final j.f f21478x = new b0();

    /* renamed from: y  reason: collision with root package name */
    public static final k.a f21479y = new a();

    /* renamed from: z  reason: collision with root package name */
    public static final j.f f21480z = new b();

    class a implements k.a {
        a() {
        }

        /* renamed from: b */
        public void a(k kVar, float[] fArr) {
            m.M(fArr, kVar);
        }
    }

    class a0 implements k.a {
        a0() {
        }

        /* renamed from: b */
        public void a(k kVar, Float f10) {
            m.R(f10, kVar);
        }
    }

    class b implements j.f {
        b() {
        }

        /* renamed from: b */
        public Integer a(j jVar) {
            return Integer.valueOf(m.h(jVar));
        }
    }

    class b0 implements j.f {
        b0() {
        }

        /* renamed from: b */
        public float[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                jVar.h();
                return m.g(jVar);
            }
            throw jVar.n("Expecting '[' for float array start");
        }
    }

    class c implements j.f {
        c() {
        }

        /* renamed from: b */
        public Integer a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return Integer.valueOf(m.h(jVar));
        }
    }

    private static class c0 {

        /* renamed from: a  reason: collision with root package name */
        final char[] f21481a;

        /* renamed from: b  reason: collision with root package name */
        final int f21482b;

        c0(char[] cArr, int i10) {
            this.f21481a = cArr;
            this.f21482b = i10;
        }
    }

    class d implements k.a {
        d() {
        }

        /* renamed from: b */
        public void a(k kVar, Integer num) {
            m.S(num, kVar);
        }
    }

    class e implements j.f {
        e() {
        }

        /* renamed from: b */
        public int[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                jVar.h();
                return m.i(jVar);
            }
            throw jVar.n("Expecting '[' for int array start");
        }
    }

    class f implements k.a {
        f() {
        }

        /* renamed from: b */
        public void a(k kVar, int[] iArr) {
            m.N(iArr, kVar);
        }
    }

    class g implements j.f {
        g() {
        }

        /* renamed from: b */
        public Short a(j jVar) {
            return Short.valueOf(m.m(jVar));
        }
    }

    class h implements j.f {
        h() {
        }

        /* renamed from: b */
        public Short a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return Short.valueOf(m.m(jVar));
        }
    }

    class i implements k.a {
        i() {
        }

        /* renamed from: b */
        public void a(k kVar, Short sh) {
            if (sh == null) {
                kVar.n();
            } else {
                m.J(sh.intValue(), kVar);
            }
        }
    }

    class j implements j.f {
        j() {
        }

        /* renamed from: b */
        public short[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                jVar.h();
                return m.n(jVar);
            }
            throw jVar.n("Expecting '[' for short array start");
        }
    }

    class k implements j.f {
        k() {
        }

        /* renamed from: b */
        public Double a(j jVar) {
            return Double.valueOf(m.d(jVar));
        }
    }

    class l implements k.a {
        l() {
        }

        /* renamed from: b */
        public void a(k kVar, short[] sArr) {
            m.P(sArr, kVar);
        }
    }

    /* renamed from: f1.m$m  reason: collision with other inner class name */
    class C0276m implements j.f {
        C0276m() {
        }

        /* renamed from: b */
        public Long a(j jVar) {
            return Long.valueOf(m.j(jVar));
        }
    }

    class n implements j.f {
        n() {
        }

        /* renamed from: b */
        public Long a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return Long.valueOf(m.j(jVar));
        }
    }

    class o implements k.a {
        o() {
        }

        /* renamed from: b */
        public void a(k kVar, Long l10) {
            m.T(l10, kVar);
        }
    }

    class p implements j.f {
        p() {
        }

        /* renamed from: b */
        public long[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                jVar.h();
                return m.k(jVar);
            }
            throw jVar.n("Expecting '[' for long array start");
        }
    }

    class q implements k.a {
        q() {
        }

        /* renamed from: b */
        public void a(k kVar, long[] jArr) {
            m.O(jArr, kVar);
        }
    }

    class r implements j.f {
        r() {
        }

        /* renamed from: b */
        public BigDecimal a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return m.c(jVar);
        }
    }

    class s implements k.a {
        s() {
        }

        /* renamed from: b */
        public void a(k kVar, BigDecimal bigDecimal) {
            m.U(bigDecimal, kVar);
        }
    }

    class t implements j.f {
        t() {
        }

        /* renamed from: b */
        public Number a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return m.l(jVar);
        }
    }

    class u implements j.f {
        u() {
        }

        /* renamed from: b */
        public Double a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return Double.valueOf(m.d(jVar));
        }
    }

    class v implements k.a {
        v() {
        }

        /* renamed from: b */
        public void a(k kVar, Double d10) {
            m.Q(d10, kVar);
        }
    }

    class w implements j.f {
        w() {
        }

        /* renamed from: b */
        public double[] a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            if (jVar.l() == 91) {
                jVar.h();
                return m.e(jVar);
            }
            throw jVar.n("Expecting '[' for double array start");
        }
    }

    class x implements k.a {
        x() {
        }

        /* renamed from: b */
        public void a(k kVar, double[] dArr) {
            m.L(dArr, kVar);
        }
    }

    class y implements j.f {
        y() {
        }

        /* renamed from: b */
        public Float a(j jVar) {
            return Float.valueOf(m.f(jVar));
        }
    }

    class z implements j.f {
        z() {
        }

        /* renamed from: b */
        public Float a(j jVar) {
            if (jVar.K()) {
                return null;
            }
            return Float.valueOf(m.f(jVar));
        }
    }

    static {
        int i10;
        int i11 = 0;
        while (true) {
            int[] iArr = f21465k;
            if (i11 < iArr.length) {
                if (i11 < 10) {
                    i10 = GameControllerManager.DEVICEFLAG_LIGHT_RGB;
                } else if (i11 < 100) {
                    i10 = 16777216;
                } else {
                    i10 = 0;
                }
                iArr[i11] = i10 + (((i11 / 100) + 48) << 16) + ((((i11 / 10) % 10) + 48) << 8) + (i11 % 10) + 48;
                i11++;
            } else {
                return;
            }
        }
    }

    private static BigDecimal A(char[] cArr, int i10, j jVar, boolean z10) {
        int i11;
        int i12;
        char c10;
        int i13 = i10;
        while (i13 > 0 && Character.isWhitespace(cArr[i13 - 1])) {
            i13--;
        }
        if (i13 <= jVar.f21424v) {
            int i14 = 0;
            if (cArr[0] == '-') {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (cArr[i11] != '0' || i13 <= (i12 = i11 + 1) || (c10 = cArr[i12]) < '0' || c10 > '9') {
                try {
                    return new BigDecimal(cArr, 0, i13);
                } catch (NumberFormatException e10) {
                    if (z10) {
                        i14 = 2;
                    }
                    throw jVar.q("Error parsing number", i10 + i14, e10);
                }
            } else {
                if (z10) {
                    i14 = 2;
                }
                throw jVar.p("Leading zero is not allowed. Error parsing number", i10 + i14);
            }
        } else {
            throw jVar.s("Too many digits detected in number", i10, "", "Too many digits detected in number", Integer.valueOf(i13), "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.math.BigDecimal B(byte[] r19, f1.j r20, int r21, int r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            byte r4 = r0[r2]
            r5 = 48
            if (r4 != r5) goto L_0x0010
            r4 = 1
            goto L_0x0011
        L_0x0010:
            r4 = 0
        L_0x0011:
            r8 = 0
            r5 = 32
            r10 = r2
        L_0x0016:
            r11 = 3
            java.lang.String r12 = "Unknown digit"
            java.lang.String r13 = "Leading zero is not allowed"
            r14 = 9
            r15 = 46
            r6 = 69
            r7 = 101(0x65, float:1.42E-43)
            if (r10 >= r3) goto L_0x005d
            byte r5 = r0[r10]
            if (r5 == r15) goto L_0x005d
            if (r5 == r7) goto L_0x005d
            if (r5 != r6) goto L_0x002e
            goto L_0x005d
        L_0x002e:
            int r6 = r5 + -48
            if (r6 < 0) goto L_0x0034
            if (r6 <= r14) goto L_0x0052
        L_0x0034:
            if (r4 == 0) goto L_0x003d
            int r7 = r2 + 1
            if (r10 <= r7) goto L_0x003d
            q(r1, r2, r3, r13)
        L_0x003d:
            if (r10 <= r2) goto L_0x004a
            boolean r7 = r1.a(r10, r3)
            if (r7 == 0) goto L_0x004a
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8)
            return r0
        L_0x004a:
            char r7 = (char) r5
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r(r1, r2, r3, r12, r7)
        L_0x0052:
            long r11 = r8 << r11
            r7 = 1
            long r8 = r8 << r7
            long r11 = r11 + r8
            long r6 = (long) r6
            long r8 = r11 + r6
            int r10 = r10 + 1
            goto L_0x0016
        L_0x005d:
            if (r10 != r2) goto L_0x0066
            java.lang.String r0 = "Digit not found"
            q(r1, r2, r3, r0)
            goto L_0x00f5
        L_0x0066:
            if (r4 == 0) goto L_0x0073
            if (r5 == r15) goto L_0x0073
            int r4 = r2 + 1
            if (r10 <= r4) goto L_0x0073
            q(r1, r2, r3, r13)
            goto L_0x00f5
        L_0x0073:
            if (r10 != r3) goto L_0x007a
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8)
            return r0
        L_0x007a:
            r13 = 45
            if (r5 != r15) goto L_0x00ef
            r15 = 1
            int r10 = r10 + r15
            if (r10 != r3) goto L_0x0087
            java.lang.String r15 = "Number ends with a dot"
            q(r1, r2, r3, r15)
        L_0x0087:
            r15 = r10
        L_0x0088:
            if (r15 >= r3) goto L_0x00b9
            byte r5 = r0[r15]
            if (r5 == r7) goto L_0x00b9
            if (r5 != r6) goto L_0x0091
            goto L_0x00b9
        L_0x0091:
            int r4 = r5 + -48
            if (r4 < 0) goto L_0x0097
            if (r4 <= r14) goto L_0x00ab
        L_0x0097:
            boolean r16 = r1.a(r15, r3)
            if (r16 == 0) goto L_0x00a3
            int r15 = r15 - r10
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8, r15)
            return r0
        L_0x00a3:
            char r14 = (char) r5
            java.lang.Character r14 = java.lang.Character.valueOf(r14)
            r(r1, r2, r3, r12, r14)
        L_0x00ab:
            long r17 = r8 << r11
            r14 = 1
            long r8 = r8 << r14
            long r17 = r17 + r8
            long r8 = (long) r4
            long r8 = r17 + r8
            int r15 = r15 + 1
            r14 = 9
            goto L_0x0088
        L_0x00b9:
            if (r15 != r3) goto L_0x00c2
            int r0 = r3 - r10
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8, r0)
            return r0
        L_0x00c2:
            if (r5 == r7) goto L_0x00ce
            if (r5 != r6) goto L_0x00c7
            goto L_0x00ce
        L_0x00c7:
            int r0 = r3 - r10
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8, r0)
            return r0
        L_0x00ce:
            int r2 = r15 + 1
            byte r4 = r0[r2]
            if (r4 != r13) goto L_0x00d9
            int r0 = y(r0, r1, r2, r3)
            goto L_0x00e8
        L_0x00d9:
            r5 = 43
            if (r4 != r5) goto L_0x00e3
            r4 = 1
            int r0 = C(r0, r1, r2, r3, r4)
            goto L_0x00e8
        L_0x00e3:
            r4 = 0
            int r0 = C(r0, r1, r2, r3, r4)
        L_0x00e8:
            int r15 = r15 - r10
            int r15 = r15 - r0
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8, r15)
            return r0
        L_0x00ef:
            if (r5 == r7) goto L_0x00f3
            if (r5 != r6) goto L_0x00f5
        L_0x00f3:
            r2 = 1
            goto L_0x00fa
        L_0x00f5:
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8)
            return r0
        L_0x00fa:
            int r10 = r10 + r2
            byte r4 = r0[r10]
            if (r4 != r13) goto L_0x0104
            int r0 = y(r0, r1, r10, r3)
            goto L_0x0112
        L_0x0104:
            r5 = 43
            if (r4 != r5) goto L_0x010d
            int r0 = C(r0, r1, r10, r3, r2)
            goto L_0x0112
        L_0x010d:
            r2 = 0
            int r0 = C(r0, r1, r10, r3, r2)
        L_0x0112:
            int r0 = -r0
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r8, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.m.B(byte[], f1.j, int, int):java.math.BigDecimal");
    }

    private static int C(byte[] bArr, j jVar, int i10, int i11, int i12) {
        int i13 = i12 + i10;
        if (i13 == i11) {
            q(jVar, i10, i11, "Digit not found");
        }
        int i14 = i13;
        int i15 = 0;
        while (i14 < i11) {
            int i16 = bArr[i14] - 48;
            if (i16 >= 0 && i16 <= 9) {
                i15 = (i15 << 3) + (i15 << 1) + i16;
                if (i15 < 0) {
                    q(jVar, i10, i11, "Integer overflow detected");
                }
                i14++;
            } else if (i14 > i13 && jVar.a(i14, i11)) {
                return i15;
            } else {
                if (i14 == i11 - 1 && bArr[i14] == 46) {
                    q(jVar, i10, i11, "Number ends with a dot");
                }
                int i17 = i11 - i10;
                BigDecimal A2 = A(jVar.x(i10, i17), i17, jVar, false);
                if (A2.scale() > 0) {
                    r(jVar, i10, i11, "Expecting int but found decimal value", A2);
                }
                return A2.intValue();
            }
        }
        return i15;
    }

    private static Number D(byte[] bArr, j jVar, int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        byte[] bArr2 = bArr;
        j jVar2 = jVar;
        int i14 = i10;
        int i15 = i11;
        if (bArr2[i14] == 48) {
            z10 = true;
        } else {
            z10 = false;
        }
        long j10 = 0;
        byte b10 = 32;
        int i16 = i14;
        while (i16 < i15 && (b10 = bArr2[i16]) != 46 && b10 != 101 && b10 != 69) {
            int i17 = b10 - 48;
            if (i17 < 0 || i17 > 9) {
                if (z10 && i16 > i14 + 1) {
                    q(jVar2, i14, i15, "Leading zero is not allowed");
                }
                if (i16 > i14 && jVar2.a(i16, i15)) {
                    return Long.valueOf(j10);
                }
                int i18 = i15 - i14;
                return V(jVar2.x(i14, i18), i18, jVar2);
            }
            j10 = ((long) i17) + (j10 << 3) + (j10 << 1);
            i16++;
        }
        if (i16 == i14) {
            q(jVar2, i14, i15, "Digit not found");
        } else if (z10 && b10 != 46 && i16 > i14 + 1) {
            q(jVar2, i14, i15, "Leading zero is not allowed");
        } else if (i16 == i15) {
            return Long.valueOf(j10);
        } else {
            if (b10 == 46) {
                int i19 = i16 + 1;
                if (i19 == i15) {
                    q(jVar2, i14, i15, "Number ends with a dot");
                }
                int i20 = i19;
                while (i20 < i15) {
                    b10 = bArr2[i20];
                    if (b10 == 101 || b10 == 69) {
                        break;
                    }
                    int i21 = b10 - 48;
                    if (i21 >= 0 && i21 <= 9) {
                        j10 = (j10 << 3) + (j10 << 1) + ((long) i21);
                        i20++;
                    } else if (jVar2.a(i20, i15)) {
                        return BigDecimal.valueOf(j10, i20 - i19);
                    } else {
                        int i22 = i15 - i14;
                        return V(jVar2.x(i14, i22), i22, jVar2);
                    }
                }
                if (i20 == i15) {
                    return b(BigDecimal.valueOf(j10, i15 - i19), jVar2.f21423u);
                }
                if (b10 != 101 && b10 != 69) {
                    return BigDecimal.valueOf(j10, i15 - i19);
                }
                int i23 = i20 + 1;
                byte b11 = bArr2[i23];
                if (b11 == 45) {
                    i13 = y(bArr2, jVar2, i23, i15);
                } else if (b11 == 43) {
                    i13 = C(bArr2, jVar2, i23, i15, 1);
                } else {
                    i13 = C(bArr2, jVar2, i23, i15, 0);
                }
                return b(BigDecimal.valueOf(j10, (i20 - i19) - i13), jVar2.f21423u);
            } else if (b10 == 101 || b10 == 69) {
                int i24 = i16 + 1;
                byte b12 = bArr2[i24];
                if (b12 == 45) {
                    i12 = y(bArr2, jVar2, i24, i15);
                } else if (b12 == 43) {
                    i12 = C(bArr2, jVar2, i24, i15, 1);
                } else {
                    i12 = C(bArr2, jVar2, i24, i15, 0);
                }
                return b(BigDecimal.valueOf(j10, -i12), jVar2.f21423u);
            }
        }
        return b(BigDecimal.valueOf(j10), jVar2.f21423u);
    }

    private static c0 E(j jVar, int i10) {
        int m10 = jVar.m() - i10;
        char[] x10 = jVar.x(i10, m10);
        while (jVar.m() == jVar.g() && !jVar.k()) {
            jVar.I();
            int g10 = jVar.g();
            int i11 = m10 + g10;
            int i12 = jVar.f21424v;
            if (i11 <= i12) {
                char[] cArr = new char[i11];
                System.arraycopy(x10, 0, cArr, 0, m10);
                System.arraycopy(jVar.x(0, g10), 0, cArr, m10, g10);
                m10 = i11;
                x10 = cArr;
            } else {
                throw jVar.r("Too many digits detected in number", i11, "Number of digits larger than %d. Unable to read number", Integer.valueOf(i12));
            }
        }
        return new c0(x10, m10);
    }

    private static int F(byte[] bArr, int i10, int i11) {
        int i12;
        if (i11 < 0) {
            if (i11 == Integer.MIN_VALUE) {
                int i13 = 0;
                while (true) {
                    byte[] bArr2 = R;
                    if (i13 >= bArr2.length) {
                        return i10 + bArr2.length;
                    }
                    bArr[i10 + i13] = bArr2[i13];
                    i13++;
                }
            } else {
                i11 = -i11;
                bArr[i10] = 45;
                i10++;
            }
        }
        int i14 = i11 / 1000;
        if (i14 == 0) {
            return i10 + X(bArr, f21465k[i11], i10);
        }
        int i15 = i11 - (i14 * 1000);
        int i16 = i14 / 1000;
        if (i16 == 0) {
            int[] iArr = f21465k;
            int i17 = iArr[i15];
            int X = X(bArr, iArr[i14], i10);
            W(bArr, i17, i10 + X);
            return i10 + 3 + X;
        }
        int i18 = i16 / 1000;
        int[] iArr2 = f21465k;
        int i19 = iArr2[i15];
        int i20 = iArr2[i14 - (i16 * 1000)];
        if (i18 == 0) {
            i12 = i10 + X(bArr, iArr2[i16], i10);
        } else {
            bArr[i10] = (byte) (i18 + 48);
            W(bArr, iArr2[i16 - (i18 * 1000)], i10 + 1);
            i12 = i10 + 4;
        }
        W(bArr, i20, i12);
        W(bArr, i19, i12 + 3);
        return i12 + 6;
    }

    private static int G(byte[] bArr, int i10, long j10) {
        int i11;
        if (j10 < 0) {
            if (j10 == Long.MIN_VALUE) {
                int i12 = 0;
                while (true) {
                    byte[] bArr2 = S;
                    if (i12 >= bArr2.length) {
                        return i10 + bArr2.length;
                    }
                    bArr[i10 + i12] = bArr2[i12];
                    i12++;
                }
            } else {
                j10 = -j10;
                bArr[i10] = 45;
                i10++;
            }
        }
        long j11 = j10 / 1000;
        if (j11 == 0) {
            return i10 + X(bArr, f21465k[(int) j10], i10);
        }
        Long.signum(j11);
        int i13 = (int) (j10 - (j11 * 1000));
        long j12 = j11 / 1000;
        if (j12 == 0) {
            int[] iArr = f21465k;
            int i14 = iArr[i13];
            int X = X(bArr, iArr[(int) j11], i10);
            W(bArr, i14, i10 + X);
            return i10 + 3 + X;
        }
        int i15 = (int) (j11 - (j12 * 1000));
        long j13 = j12 / 1000;
        if (j13 == 0) {
            int[] iArr2 = f21465k;
            int i16 = iArr2[i13];
            int i17 = iArr2[i15];
            int X2 = i10 + X(bArr, iArr2[(int) j12], i10);
            W(bArr, i17, X2);
            W(bArr, i16, X2 + 3);
            return X2 + 6;
        }
        int i18 = (int) (j12 - (j13 * 1000));
        int i19 = (int) (j13 / 1000);
        if (i19 == 0) {
            int[] iArr3 = f21465k;
            int i20 = iArr3[i13];
            int i21 = iArr3[i15];
            int i22 = iArr3[i18];
            int X3 = i10 + X(bArr, iArr3[(int) j13], i10);
            W(bArr, i22, X3);
            W(bArr, i21, X3 + 3);
            W(bArr, i20, X3 + 6);
            return X3 + 9;
        }
        int i23 = (int) (j13 - ((long) (i19 * 1000)));
        int i24 = i19 / 1000;
        if (i24 == 0) {
            int[] iArr4 = f21465k;
            int i25 = iArr4[i13];
            int i26 = iArr4[i15];
            int i27 = iArr4[i18];
            int i28 = iArr4[i23];
            int X4 = i10 + X(bArr, iArr4[i19], i10);
            W(bArr, i28, X4);
            W(bArr, i27, X4 + 3);
            W(bArr, i26, X4 + 6);
            W(bArr, i25, X4 + 9);
            return X4 + 12;
        }
        int i29 = i24 / 1000;
        int[] iArr5 = f21465k;
        int i30 = iArr5[i13];
        int i31 = iArr5[i15];
        int i32 = iArr5[i18];
        int i33 = iArr5[i23];
        int i34 = iArr5[i19 - (i24 * 1000)];
        if (i29 == 0) {
            i11 = i10 + X(bArr, iArr5[i24], i10);
        } else {
            bArr[i10] = (byte) (i29 + 48);
            W(bArr, iArr5[i24 - (i29 * 1000)], i10 + 1);
            i11 = i10 + 4;
        }
        W(bArr, i34, i11);
        W(bArr, i33, i11 + 3);
        W(bArr, i32, i11 + 6);
        W(bArr, i31, i11 + 9);
        W(bArr, i30, i11 + 12);
        return i11 + 15;
    }

    public static void H(double d10, k kVar) {
        kVar.m(d10);
    }

    public static void I(float f10, k kVar) {
        if (f10 == Float.POSITIVE_INFINITY) {
            kVar.i("\"Infinity\"");
        } else if (f10 == Float.NEGATIVE_INFINITY) {
            kVar.i("\"-Infinity\"");
        } else if (f10 != f10) {
            kVar.i("\"NaN\"");
        } else {
            kVar.i(Float.toString(f10));
        }
    }

    public static void J(int i10, k kVar) {
        byte[] c10 = kVar.c(11);
        int h10 = kVar.h();
        kVar.a(F(c10, h10, i10) - h10);
    }

    public static void K(long j10, k kVar) {
        byte[] c10 = kVar.c(21);
        int h10 = kVar.h();
        kVar.a(G(c10, h10, j10) - h10);
    }

    public static void L(double[] dArr, k kVar) {
        if (dArr == null) {
            kVar.n();
        } else if (dArr.length == 0) {
            kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            kVar.l((byte) 91);
            H(dArr[0], kVar);
            for (int i10 = 1; i10 < dArr.length; i10++) {
                kVar.l((byte) 44);
                H(dArr[i10], kVar);
            }
            kVar.l((byte) 93);
        }
    }

    public static void M(float[] fArr, k kVar) {
        if (fArr == null) {
            kVar.n();
        } else if (fArr.length == 0) {
            kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            kVar.l((byte) 91);
            I(fArr[0], kVar);
            for (int i10 = 1; i10 < fArr.length; i10++) {
                kVar.l((byte) 44);
                I(fArr[i10], kVar);
            }
            kVar.l((byte) 93);
        }
    }

    public static void N(int[] iArr, k kVar) {
        if (iArr == null) {
            kVar.n();
        } else if (iArr.length == 0) {
            kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            byte[] c10 = kVar.c((iArr.length * 11) + 2);
            int h10 = kVar.h();
            c10[h10] = 91;
            int F2 = F(c10, h10 + 1, iArr[0]);
            for (int i10 = 1; i10 < iArr.length; i10++) {
                c10[F2] = 44;
                F2 = F(c10, F2 + 1, iArr[i10]);
            }
            c10[F2] = 93;
            kVar.a((F2 + 1) - kVar.h());
        }
    }

    public static void O(long[] jArr, k kVar) {
        if (jArr == null) {
            kVar.n();
        } else if (jArr.length == 0) {
            kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            byte[] c10 = kVar.c((jArr.length * 21) + 2);
            int h10 = kVar.h();
            c10[h10] = 91;
            int G2 = G(c10, h10 + 1, jArr[0]);
            for (int i10 = 1; i10 < jArr.length; i10++) {
                c10[G2] = 44;
                G2 = G(c10, G2 + 1, jArr[i10]);
            }
            c10[G2] = 93;
            kVar.a((G2 + 1) - kVar.h());
        }
    }

    public static void P(short[] sArr, k kVar) {
        if (sArr == null) {
            kVar.n();
        } else if (sArr.length == 0) {
            kVar.i(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            kVar.l((byte) 91);
            J(sArr[0], kVar);
            for (int i10 = 1; i10 < sArr.length; i10++) {
                kVar.l((byte) 44);
                J(sArr[i10], kVar);
            }
            kVar.l((byte) 93);
        }
    }

    public static void Q(Double d10, k kVar) {
        if (d10 == null) {
            kVar.n();
        } else {
            H(d10.doubleValue(), kVar);
        }
    }

    public static void R(Float f10, k kVar) {
        if (f10 == null) {
            kVar.n();
        } else {
            I(f10.floatValue(), kVar);
        }
    }

    public static void S(Integer num, k kVar) {
        if (num == null) {
            kVar.n();
        } else {
            J(num.intValue(), kVar);
        }
    }

    public static void T(Long l10, k kVar) {
        if (l10 == null) {
            kVar.n();
        } else {
            K(l10.longValue(), kVar);
        }
    }

    public static void U(BigDecimal bigDecimal, k kVar) {
        if (bigDecimal == null) {
            kVar.n();
        } else {
            kVar.i(bigDecimal.toString());
        }
    }

    private static Number V(char[] cArr, int i10, j jVar) {
        BigDecimal A2 = A(cArr, i10, jVar, false);
        if (A2.scale() == 0 && A2.precision() <= 19) {
            if (A2.signum() == 1) {
                if (A2.compareTo(T) <= 0) {
                    return Long.valueOf(A2.longValue());
                }
            } else if (A2.compareTo(U) >= 0) {
                return Long.valueOf(A2.longValue());
            }
        }
        return b(A2, jVar.f21423u);
    }

    private static void W(byte[] bArr, int i10, int i11) {
        bArr[i11] = (byte) (i10 >> 16);
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11 + 2] = (byte) i10;
    }

    private static int X(byte[] bArr, int i10, int i11) {
        int i12 = i10 >> 24;
        if (i12 == 0) {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 16);
            i11 += 2;
            bArr[i13] = (byte) (i10 >> 8);
        } else if (i12 == 1) {
            bArr[i11] = (byte) (i10 >> 8);
            i11++;
        }
        bArr[i11] = (byte) i10;
        return 3 - i12;
    }

    private static double a(int i10, double d10, int i11) {
        long doubleToRawLongBits = Double.doubleToRawLongBits(d10);
        int i12 = ((int) (doubleToRawLongBits >> 52)) - 1022;
        return Double.longBitsToDouble(doubleToRawLongBits + ((long) (((i10 * f21468n[i11 + 1]) + f21467m[i12]) / f21466l[i12])));
    }

    private static Number b(BigDecimal bigDecimal, j.g gVar) {
        if (gVar == j.g.LONG_AND_BIGDECIMAL) {
            return bigDecimal;
        }
        return Double.valueOf(bigDecimal.doubleValue());
    }

    public static BigDecimal c(j jVar) {
        if (jVar.l() == 34) {
            return A(jVar.f21411i, jVar.u(), jVar, true);
        }
        int I2 = jVar.I();
        int g10 = jVar.g();
        if (g10 == jVar.m()) {
            c0 E2 = E(jVar, I2);
            return A(E2.f21481a, E2.f21482b, jVar, false);
        }
        int i10 = g10 - I2;
        if (i10 > 18) {
            return A(jVar.x(I2, i10), i10, jVar, false);
        }
        byte[] bArr = jVar.f21410h;
        if (bArr[I2] == 45) {
            return x(bArr, jVar, I2, g10);
        }
        return B(bArr, jVar, I2, g10);
    }

    public static double d(j jVar) {
        if (jVar.l() == 34) {
            return t(jVar.E(), (jVar.g() - jVar.g()) - 1, jVar, true);
        }
        int I2 = jVar.I();
        int g10 = jVar.g();
        byte[] bArr = jVar.f21410h;
        if (bArr[I2] == 45) {
            return -s(bArr, jVar, I2, g10, 1);
        }
        return s(bArr, jVar, I2, g10, 0);
    }

    public static double[] e(j jVar) {
        if (jVar.l() == 93) {
            return f21459e;
        }
        double[] dArr = new double[4];
        dArr[0] = d(jVar);
        int i10 = 1;
        while (jVar.h() == 44) {
            jVar.h();
            if (i10 == dArr.length) {
                dArr = Arrays.copyOf(dArr, dArr.length << 1);
            }
            dArr[i10] = d(jVar);
            i10++;
        }
        jVar.d();
        return Arrays.copyOf(dArr, i10);
    }

    public static float f(j jVar) {
        if (jVar.l() == 34) {
            return v(jVar.E(), (jVar.g() - jVar.g()) - 1, jVar, true);
        }
        int I2 = jVar.I();
        int g10 = jVar.g();
        if (g10 == jVar.m()) {
            c0 E2 = E(jVar, I2);
            return v(E2.f21481a, E2.f21482b, jVar, false);
        }
        byte[] bArr = jVar.f21410h;
        if (bArr[I2] == 45) {
            return -u(bArr, jVar, I2, g10, 1);
        }
        return u(bArr, jVar, I2, g10, 0);
    }

    public static float[] g(j jVar) {
        if (jVar.l() == 93) {
            return f21458d;
        }
        float[] fArr = new float[4];
        fArr[0] = f(jVar);
        int i10 = 1;
        while (jVar.h() == 44) {
            jVar.h();
            if (i10 == fArr.length) {
                fArr = Arrays.copyOf(fArr, fArr.length << 1);
            }
            fArr[i10] = f(jVar);
            i10++;
        }
        jVar.d();
        return Arrays.copyOf(fArr, i10);
    }

    public static int h(j jVar) {
        int i10;
        byte b10;
        byte b11;
        if (jVar.l() == 34) {
            int g10 = jVar.g();
            try {
                return A(jVar.E(), (jVar.g() - g10) - 1, jVar, true).intValueExact();
            } catch (ArithmeticException unused) {
                throw jVar.p("Integer overflow detected", jVar.g() - g10);
            }
        } else {
            int I2 = jVar.I();
            int g11 = jVar.g();
            byte[] bArr = jVar.f21410h;
            byte b12 = bArr[I2];
            if (b12 == 45) {
                int i11 = I2 + 2;
                if (g11 > i11 && bArr[I2 + 1] == 48 && (b11 = bArr[i11]) >= 48 && b11 <= 57) {
                    q(jVar, I2, g11, "Leading zero is not allowed");
                }
                return y(bArr, jVar, I2, g11);
            }
            if (b12 == 48 && g11 > (i10 = I2 + 1) && (b10 = bArr[i10]) >= 48 && b10 <= 57) {
                q(jVar, I2, g11, "Leading zero is not allowed");
            }
            return C(bArr, jVar, I2, g11, 0);
        }
    }

    public static int[] i(j jVar) {
        if (jVar.l() == 93) {
            return f21456b;
        }
        int[] iArr = new int[4];
        iArr[0] = h(jVar);
        int i10 = 1;
        while (jVar.h() == 44) {
            jVar.h();
            if (i10 == iArr.length) {
                iArr = Arrays.copyOf(iArr, iArr.length << 1);
            }
            iArr[i10] = h(jVar);
            i10++;
        }
        jVar.d();
        return Arrays.copyOf(iArr, i10);
    }

    public static long j(j jVar) {
        j jVar2 = jVar;
        if (jVar.l() == 34) {
            int g10 = jVar.g();
            try {
                return A(jVar.E(), (jVar.g() - g10) - 1, jVar2, true).longValueExact();
            } catch (ArithmeticException unused) {
                throw jVar2.p("Long overflow detected", jVar.g() - g10);
            }
        } else {
            int I2 = jVar.I();
            int g11 = jVar.g();
            byte[] bArr = jVar2.f21410h;
            byte b10 = bArr[I2];
            char c10 = 3;
            int i10 = 9;
            boolean z10 = false;
            byte b11 = 48;
            if (b10 == 45) {
                int i11 = I2 + 1;
                if (i11 == g11) {
                    q(jVar2, I2, g11, "Digit not found");
                }
                if (bArr[i11] == 48) {
                    z10 = true;
                }
                int i12 = i11;
                long j10 = 0;
                while (i12 < g11) {
                    int i13 = bArr[i12] - 48;
                    if (i13 < 0 || i13 > i10) {
                        if (z10 && i12 > I2 + 2) {
                            q(jVar2, I2, g11, "Leading zero is not allowed");
                        }
                        if (i12 <= i11 || !jVar2.a(i12, g11)) {
                            return w(jVar2, I2, g11);
                        }
                        return j10;
                    }
                    j10 = ((j10 << c10) + (j10 << 1)) - ((long) i13);
                    if (j10 > 0) {
                        q(jVar2, I2, g11, "Long overflow detected");
                    }
                    i12++;
                    c10 = 3;
                    i10 = 9;
                }
                if (z10 && i12 > I2 + 2) {
                    q(jVar2, I2, g11, "Leading zero is not allowed");
                }
                return j10;
            }
            if (I2 == g11) {
                q(jVar2, I2, g11, "Digit not found");
            }
            if (bArr[I2] == 48) {
                z10 = true;
            }
            int i14 = I2;
            long j11 = 0;
            while (i14 < g11) {
                int i15 = bArr[i14] - b11;
                if (i15 < 0 || i15 > 9) {
                    if (z10 && i14 > I2 + 1) {
                        q(jVar2, I2, g11, "Leading zero is not allowed");
                    }
                    if (b10 == 43 && i14 > I2 + 1 && jVar2.a(i14, g11)) {
                        return j11;
                    }
                    if (b10 == 43 || i14 <= I2 || !jVar2.a(i14, g11)) {
                        return w(jVar2, I2, g11);
                    }
                    return j11;
                }
                j11 = (j11 << 3) + (j11 << 1) + ((long) i15);
                if (j11 < 0) {
                    q(jVar2, I2, g11, "Long overflow detected");
                }
                i14++;
                b11 = 48;
            }
            if (z10 && i14 > I2 + 1) {
                q(jVar2, I2, g11, "Leading zero is not allowed");
            }
            return j11;
        }
    }

    public static long[] k(j jVar) {
        if (jVar.l() == 93) {
            return f21457c;
        }
        long[] jArr = new long[4];
        jArr[0] = j(jVar);
        int i10 = 1;
        while (jVar.h() == 44) {
            jVar.h();
            if (i10 == jArr.length) {
                jArr = Arrays.copyOf(jArr, jArr.length << 1);
            }
            jArr[i10] = j(jVar);
            i10++;
        }
        jVar.d();
        return Arrays.copyOf(jArr, i10);
    }

    public static Number l(j jVar) {
        j.g gVar = jVar.f21423u;
        if (gVar == j.g.BIGDECIMAL) {
            return c(jVar);
        }
        if (gVar == j.g.DOUBLE) {
            return Double.valueOf(d(jVar));
        }
        int I2 = jVar.I();
        int g10 = jVar.g();
        if (g10 == jVar.m()) {
            c0 E2 = E(jVar, I2);
            return V(E2.f21481a, E2.f21482b, jVar);
        }
        int i10 = g10 - I2;
        if (i10 > 18) {
            return V(jVar.x(I2, i10), i10, jVar);
        }
        byte[] bArr = jVar.f21410h;
        if (bArr[I2] == 45) {
            return z(bArr, jVar, I2, g10);
        }
        return D(bArr, jVar, I2, g10);
    }

    public static short m(j jVar) {
        int i10;
        if (jVar.l() == 34) {
            int g10 = jVar.g();
            try {
                return A(jVar.E(), (jVar.g() - g10) - 1, jVar, true).shortValueExact();
            } catch (ArithmeticException unused) {
                throw jVar.p("Short overflow detected", jVar.g() - g10);
            }
        } else {
            int I2 = jVar.I();
            int g11 = jVar.g();
            byte[] bArr = jVar.f21410h;
            if (bArr[I2] == 45) {
                i10 = y(bArr, jVar, I2, g11);
            } else {
                i10 = C(bArr, jVar, I2, g11, 0);
            }
            if (i10 >= -32768 && i10 <= 32767) {
                return (short) i10;
            }
            throw jVar.p("Short overflow detected", jVar.g());
        }
    }

    public static short[] n(j jVar) {
        if (jVar.l() == 93) {
            return f21455a;
        }
        short[] sArr = new short[4];
        sArr[0] = (short) h(jVar);
        int i10 = 1;
        while (jVar.h() == 44) {
            jVar.h();
            if (i10 == sArr.length) {
                sArr = Arrays.copyOf(sArr, sArr.length << 1);
            }
            sArr[i10] = (short) h(jVar);
            i10++;
        }
        jVar.d();
        return Arrays.copyOf(sArr, i10);
    }

    private static double o(j jVar, long j10, int i10, double d10, byte[] bArr, int i11, int i12, int i13, int i14) {
        int C2;
        double d11;
        double d12;
        j jVar2 = jVar;
        long j11 = j10;
        byte[] bArr2 = bArr;
        int i15 = i12;
        if (jVar2.f21421s == j.b.EXACT) {
            int i16 = (i15 - i11) - i13;
            return t(jVar.x(i11 + i13, i16), i16, jVar, false);
        }
        int i17 = i14 + 1;
        byte b10 = bArr2[i17];
        if (b10 == 45) {
            C2 = y(bArr2, jVar, i17, i15);
        } else if (b10 == 43) {
            C2 = C(bArr2, jVar, i17, i15, 1);
        } else {
            C2 = C(bArr2, jVar, i17, i15, 0);
        }
        int i18 = C2 - i10;
        if (d10 == 0.0d) {
            if (i18 == 0 || j11 == 0) {
                return (double) j11;
            }
            if (i18 > 0) {
                double[] dArr = f21469o;
                if (i18 < dArr.length) {
                    return ((double) j11) * dArr[i18 - 1];
                }
            }
            if (i18 < 0) {
                int i19 = -i18;
                double[] dArr2 = f21469o;
                if (i19 < dArr2.length) {
                    return ((double) j11) / dArr2[i19 - 1];
                }
            }
            if (jVar2.f21421s != j.b.HIGH) {
                if (i18 > 0 && i18 < 300) {
                    return ((double) j11) * Math.pow(10.0d, (double) i18);
                }
                if (i18 > -300 && i18 < 0) {
                    return ((double) j11) / Math.pow(10.0d, (double) i18);
                }
            }
        } else if (i18 == 0) {
            return ((double) j11) + d10;
        } else {
            if (i18 > 0) {
                double[] dArr3 = f21469o;
                if (i18 < dArr3.length) {
                    double d13 = dArr3[i18 - 1];
                    d11 = d10 * d13;
                    d12 = ((double) j11) * d13;
                    return d11 + d12;
                }
            }
            if (i18 < 0) {
                int i20 = -i18;
                double[] dArr4 = f21469o;
                if (i20 < dArr4.length) {
                    double d14 = dArr4[i20 - 1];
                    d11 = d10 / d14;
                    d12 = ((double) j11) / d14;
                    return d11 + d12;
                }
            }
            if (jVar2.f21421s != j.b.HIGH) {
                if (i18 > 0 && i18 < 300) {
                    return ((double) j11) * Math.pow(10.0d, (double) i18);
                }
                if (i18 > -300 && i18 < 0) {
                    return ((double) j11) / Math.pow(10.0d, (double) i18);
                }
            }
        }
        int i21 = (i15 - i11) - i13;
        return t(jVar.x(i11 + i13, i21), i21, jVar, false);
    }

    private static float p(j jVar, long j10, int i10, byte[] bArr, int i11, int i12) {
        int C2;
        byte b10 = bArr[i12];
        if (b10 == 45) {
            C2 = y(bArr, jVar, i12, i11);
        } else if (b10 == 43) {
            C2 = C(bArr, jVar, i12, i11, 1);
        } else {
            C2 = C(bArr, jVar, i12, i11, 0);
        }
        int i13 = C2 - i10;
        if (i13 == 0 || j10 == 0) {
            return (float) j10;
        }
        if (i13 > 0) {
            double[] dArr = f21469o;
            if (i13 < dArr.length) {
                return (float) (((double) j10) * dArr[i13 - 1]);
            }
        }
        if (i13 < 0) {
            int i14 = -i13;
            double[] dArr2 = f21469o;
            if (i14 < dArr2.length) {
                return (float) (((double) j10) / dArr2[i14 - 1]);
            }
        }
        if (i13 > 0) {
            return Float.POSITIVE_INFINITY;
        }
        return 0.0f;
    }

    static void q(j jVar, int i10, int i11, String str) {
        int i12 = i11 - i10;
        if (i12 > jVar.f21424v) {
            throw jVar.s("Too many digits detected in number", i12, "", "Too many digits detected in number", Integer.valueOf(i11), "");
        }
        throw jVar.s("Error parsing number", i12, "", str, (Object) null, ". Error parsing number");
    }

    static void r(j jVar, int i10, int i11, String str, Object obj) {
        int i12 = i11 - i10;
        if (i12 > jVar.f21424v) {
            throw jVar.s("Too many digits detected in number", i12, "", "Too many digits detected in number", Integer.valueOf(i11), "");
        }
        throw jVar.s("Error parsing number", i12, "", str, obj, ". Error parsing number");
    }

    /* JADX WARNING: Removed duplicated region for block: B:146:0x0138 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static double s(byte[] r23, f1.j r24, int r25, int r26, int r27) {
        /*
            r0 = r24
            r7 = r25
            r8 = r26
            int r1 = r8 - r7
            int r1 = r1 - r27
            int r2 = r0.f21422t
            r3 = 0
            if (r1 <= r2) goto L_0x002f
            int r2 = r24.m()
            if (r8 != r2) goto L_0x0024
            int r1 = r7 + r27
            f1.m$c0 r1 = E(r0, r1)
            char[] r2 = r1.f21481a
            int r1 = r1.f21482b
            double r0 = t(r2, r1, r0, r3)
            return r0
        L_0x0024:
            int r2 = r7 + r27
            char[] r2 = r0.x(r2, r1)
            double r0 = t(r2, r1, r0, r3)
            return r0
        L_0x002f:
            int r2 = r7 + r27
            byte r4 = r23[r2]
            r5 = 48
            if (r4 != r5) goto L_0x0039
            r4 = 1
            goto L_0x003a
        L_0x0039:
            r4 = r3
        L_0x003a:
            r11 = 32
            r13 = r2
            r14 = r11
            r11 = 0
        L_0x0040:
            java.lang.String r15 = "Leading zero is not allowed"
            r16 = 3
            java.lang.String r3 = "Unknown digit"
            r5 = 9
            r9 = 46
            r10 = 69
            r6 = 101(0x65, float:1.42E-43)
            if (r13 >= r8) goto L_0x0088
            byte r14 = r23[r13]
            if (r14 == r9) goto L_0x0088
            if (r14 == r6) goto L_0x0088
            if (r14 != r10) goto L_0x0059
            goto L_0x0088
        L_0x0059:
            int r6 = r14 + -48
            if (r6 < 0) goto L_0x005f
            if (r6 <= r5) goto L_0x007a
        L_0x005f:
            if (r4 == 0) goto L_0x0068
            int r5 = r2 + 1
            if (r13 <= r5) goto L_0x0068
            q(r0, r7, r8, r15)
        L_0x0068:
            if (r13 <= r2) goto L_0x0072
            boolean r5 = r0.a(r13, r8)
            if (r5 == 0) goto L_0x0072
            double r0 = (double) r11
            return r0
        L_0x0072:
            char r5 = (char) r14
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r(r0, r7, r8, r3, r5)
        L_0x007a:
            long r9 = r11 << r16
            r3 = 1
            long r11 = r11 << r3
            long r9 = r9 + r11
            long r5 = (long) r6
            long r11 = r9 + r5
            int r13 = r13 + 1
            r3 = 0
            r5 = 48
            goto L_0x0040
        L_0x0088:
            if (r13 != r2) goto L_0x0091
            java.lang.String r1 = "Digit not found"
            q(r0, r7, r8, r1)
            goto L_0x020b
        L_0x0091:
            if (r4 == 0) goto L_0x009e
            if (r14 == r9) goto L_0x009e
            int r4 = r2 + 1
            if (r13 <= r4) goto L_0x009e
            q(r0, r7, r8, r15)
            goto L_0x020b
        L_0x009e:
            if (r13 != r8) goto L_0x00a2
            double r0 = (double) r11
            return r0
        L_0x00a2:
            if (r14 != r9) goto L_0x0203
            int r4 = r13 + 1
            if (r4 != r8) goto L_0x00ad
            java.lang.String r9 = "Number ends with a dot"
            q(r0, r7, r8, r9)
        L_0x00ad:
            r17 = 0
            int r9 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            r17 = 4831355200913801216(0x430c6bf526340000, double:1.0E15)
            r19 = 4816244402031689728(0x42d6bcc41e900000, double:1.0E14)
            r15 = 56
            if (r9 != 0) goto L_0x00e1
            int r13 = r13 + 16
            byte r14 = r23[r4]
            r9 = 48
            if (r14 != r9) goto L_0x00d3
            if (r8 <= r13) goto L_0x00d3
            char[] r2 = r0.x(r2, r1)
            r3 = 0
            double r0 = t(r2, r1, r0, r3)
            return r0
        L_0x00d3:
            if (r14 >= r15) goto L_0x00dc
            r9 = -1
        L_0x00d6:
            r15 = r14
            r17 = r19
            r14 = r13
            r13 = 1
            goto L_0x00f2
        L_0x00dc:
            r15 = r14
            r9 = 0
        L_0x00de:
            r14 = r13
            r13 = 0
            goto L_0x00f2
        L_0x00e1:
            int r13 = r2 + 16
            byte r9 = r23[r2]
            if (r9 >= r15) goto L_0x00ec
            int r9 = r4 - r13
            int r9 = r9 + 14
            goto L_0x00d6
        L_0x00ec:
            int r9 = r4 - r13
            int r9 = r9 + 15
            r15 = r14
            goto L_0x00de
        L_0x00f2:
            if (r14 >= r8) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r14 = r8
        L_0x00f6:
            r19 = r15
            r15 = r4
        L_0x00f9:
            if (r15 >= r14) goto L_0x0138
            byte r5 = r23[r15]
            if (r5 == r6) goto L_0x013a
            if (r5 != r10) goto L_0x0102
            goto L_0x013a
        L_0x0102:
            int r10 = r5 + -48
            if (r10 < 0) goto L_0x010a
            r6 = 9
            if (r10 <= r6) goto L_0x0124
        L_0x010a:
            boolean r6 = r0.a(r15, r8)
            if (r6 == 0) goto L_0x011a
            double r0 = (double) r11
            double[] r2 = f21469o
            int r15 = r15 - r4
            r6 = 1
            int r15 = r15 - r6
            r3 = r2[r15]
            double r0 = r0 / r3
            return r0
        L_0x011a:
            byte r6 = r23[r15]
            char r6 = (char) r6
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            r(r0, r7, r8, r3, r6)
        L_0x0124:
            long r21 = r11 << r16
            r6 = 1
            long r11 = r11 << r6
            long r21 = r21 + r11
            long r10 = (long) r10
            long r11 = r21 + r10
            int r15 = r15 + 1
            r19 = r5
            r5 = 9
            r6 = 101(0x65, float:1.42E-43)
            r10 = 69
            goto L_0x00f9
        L_0x0138:
            r5 = r19
        L_0x013a:
            if (r15 != r8) goto L_0x0146
            double r0 = (double) r11
            double[] r2 = f21469o
            int r15 = r15 - r4
            r3 = 1
            int r15 = r15 - r3
            r3 = r2[r15]
            double r0 = r0 / r3
            return r0
        L_0x0146:
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x01ee
            r6 = 69
            if (r5 != r6) goto L_0x0150
            goto L_0x01ee
        L_0x0150:
            f1.j$b r4 = r0.f21421s
            f1.j$b r6 = f1.j.b.HIGH
            if (r4 != r6) goto L_0x0160
            char[] r2 = r0.x(r2, r1)
            r4 = 0
            double r0 = t(r2, r1, r0, r4)
            return r0
        L_0x0160:
            r4 = 0
            int r2 = r2 + 18
            if (r2 >= r8) goto L_0x0166
            goto L_0x0167
        L_0x0166:
            r2 = r8
        L_0x0167:
            r1 = r15
        L_0x0168:
            if (r1 >= r2) goto L_0x01a1
            byte r5 = r23[r1]
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x01a1
            r6 = 69
            if (r5 != r6) goto L_0x0175
            goto L_0x01a1
        L_0x0175:
            int r6 = r5 + -48
            r10 = 9
            if (r6 < 0) goto L_0x017d
            if (r6 <= r10) goto L_0x0197
        L_0x017d:
            boolean r14 = r0.a(r1, r8)
            if (r14 == 0) goto L_0x018d
            double r2 = (double) r11
            double r2 = r2 / r17
            int r1 = r1 - r15
            int r1 = r1 - r13
            double r0 = a(r4, r2, r1)
            return r0
        L_0x018d:
            byte r14 = r23[r1]
            char r14 = (char) r14
            java.lang.Character r14 = java.lang.Character.valueOf(r14)
            r(r0, r7, r8, r3, r14)
        L_0x0197:
            int r14 = r4 << 3
            int r4 = r4 << 1
            int r14 = r14 + r4
            int r4 = r14 + r6
            int r1 = r1 + 1
            goto L_0x0168
        L_0x01a1:
            double r2 = (double) r11
            double r2 = r2 / r17
            int r6 = r1 - r15
            int r6 = r6 - r13
            double r10 = a(r4, r2, r6)
            r12 = r1
        L_0x01ac:
            if (r12 >= r8) goto L_0x01bc
            r1 = 48
            if (r5 < r1) goto L_0x01bc
            r2 = 57
            if (r5 > r2) goto L_0x01bc
            int r2 = r12 + 1
            byte r5 = r23[r12]
            r12 = r2
            goto L_0x01ac
        L_0x01bc:
            r1 = 101(0x65, float:1.42E-43)
            if (r5 == r1) goto L_0x01da
            r1 = 69
            if (r5 != r1) goto L_0x01c5
            goto L_0x01da
        L_0x01c5:
            if (r9 <= 0) goto L_0x01cf
            double[] r0 = f21469o
            r1 = 1
            int r9 = r9 - r1
            r1 = r0[r9]
            double r10 = r10 * r1
            return r10
        L_0x01cf:
            r1 = 1
            if (r9 >= 0) goto L_0x01d9
            double[] r0 = f21469o
            int r2 = -r9
            int r2 = r2 - r1
            r1 = r0[r2]
            double r10 = r10 / r1
        L_0x01d9:
            return r10
        L_0x01da:
            r1 = 0
            r0 = r24
            r3 = r9
            r4 = r10
            r6 = r23
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r12
            double r0 = o(r0, r1, r3, r4, r6, r7, r8, r9, r10)
            return r0
        L_0x01ee:
            int r3 = r15 - r4
            r4 = 0
            r0 = r24
            r1 = r11
            r6 = r23
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r15
            double r0 = o(r0, r1, r3, r4, r6, r7, r8, r9, r10)
            return r0
        L_0x0203:
            r1 = r6
            if (r14 == r1) goto L_0x020d
            r1 = 69
            if (r14 != r1) goto L_0x020b
            goto L_0x020d
        L_0x020b:
            double r0 = (double) r11
            return r0
        L_0x020d:
            r3 = 0
            r4 = 0
            r0 = r24
            r1 = r11
            r6 = r23
            r7 = r25
            r8 = r26
            r9 = r27
            r10 = r13
            double r0 = o(r0, r1, r3, r4, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.m.s(byte[], f1.j, int, int, int):double");
    }

    private static double t(char[] cArr, int i10, j jVar, boolean z10) {
        int i11;
        int i12;
        char c10;
        int i13 = i10;
        while (i13 > 0 && Character.isWhitespace(cArr[i13 - 1])) {
            i13--;
        }
        if (i13 <= jVar.f21424v) {
            int i14 = 0;
            if (cArr[0] == '-') {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (cArr[i11] != '0' || i13 <= (i12 = i11 + 1) || (c10 = cArr[i12]) < '0' || c10 > '9') {
                try {
                    return Double.parseDouble(new String(cArr, 0, i13));
                } catch (NumberFormatException e10) {
                    if (z10) {
                        i14 = 2;
                    }
                    throw jVar.q("Error parsing number", i10 + i14, e10);
                }
            } else {
                if (z10) {
                    i14 = 2;
                }
                throw jVar.p("Leading zero is not allowed. Error parsing number", i10 + i14);
            }
        } else {
            throw jVar.s("Too many digits detected in number", i10, "", "Too many digits detected in number", Integer.valueOf(i13), "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float u(byte[] r21, f1.j r22, int r23, int r24, int r25) {
        /*
            r0 = r22
            r1 = r23
            r5 = r24
            int r2 = r1 + r25
            byte r3 = r21[r2]
            r7 = 48
            if (r3 != r7) goto L_0x0010
            r3 = 1
            goto L_0x0011
        L_0x0010:
            r3 = 0
        L_0x0011:
            r10 = 32
            r13 = r2
            r12 = r10
            r10 = 0
        L_0x0017:
            r14 = 3
            java.lang.String r15 = "Unknown digit"
            java.lang.String r7 = "Leading zero is not allowed"
            r8 = 9
            r9 = 46
            r4 = 69
            r6 = 101(0x65, float:1.42E-43)
            if (r13 >= r5) goto L_0x005e
            byte r12 = r21[r13]
            if (r12 == r9) goto L_0x005e
            if (r12 == r6) goto L_0x005e
            if (r12 != r4) goto L_0x002f
            goto L_0x005e
        L_0x002f:
            int r4 = r12 + -48
            if (r4 < 0) goto L_0x0035
            if (r4 <= r8) goto L_0x0050
        L_0x0035:
            if (r3 == 0) goto L_0x003e
            int r6 = r2 + 1
            if (r13 <= r6) goto L_0x003e
            q(r0, r1, r5, r7)
        L_0x003e:
            if (r13 <= r2) goto L_0x0048
            boolean r6 = r0.a(r13, r5)
            if (r6 == 0) goto L_0x0048
            float r0 = (float) r10
            return r0
        L_0x0048:
            char r6 = (char) r12
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            r(r0, r1, r5, r15, r6)
        L_0x0050:
            long r6 = r10 << r14
            r8 = 1
            long r9 = r10 << r8
            long r6 = r6 + r9
            long r8 = (long) r4
            long r10 = r6 + r8
            int r13 = r13 + 1
            r7 = 48
            goto L_0x0017
        L_0x005e:
            if (r13 != r2) goto L_0x0067
            java.lang.String r2 = "Digit not found"
            q(r0, r1, r5, r2)
            goto L_0x0165
        L_0x0067:
            if (r3 == 0) goto L_0x0074
            if (r12 == r9) goto L_0x0074
            int r3 = r2 + 1
            if (r13 <= r3) goto L_0x0074
            q(r0, r1, r5, r7)
            goto L_0x0165
        L_0x0074:
            int r3 = r2 + 18
            if (r13 <= r3) goto L_0x0086
            int r1 = r5 - r1
            int r1 = r1 - r25
            char[] r2 = r0.x(r2, r1)
            r3 = 0
            float r0 = v(r2, r1, r0, r3)
            return r0
        L_0x0086:
            r3 = 0
            if (r13 != r5) goto L_0x008b
            float r0 = (float) r10
            return r0
        L_0x008b:
            if (r12 != r9) goto L_0x0160
            int r7 = r13 + 1
            if (r7 != r5) goto L_0x0096
            java.lang.String r9 = "Number ends with a dot"
            q(r0, r1, r5, r9)
        L_0x0096:
            r16 = 0
            int r9 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r9 != 0) goto L_0x00ad
            int r13 = r13 + 2
        L_0x009e:
            if (r7 >= r5) goto L_0x00a9
            byte r2 = r21[r7]
            r9 = 48
            if (r2 != r9) goto L_0x00a9
            int r7 = r7 + 1
            goto L_0x009e
        L_0x00a9:
            int r2 = r7 + 17
            r9 = r3
            goto L_0x00b1
        L_0x00ad:
            int r2 = r2 + 17
            r13 = r7
            r9 = 1
        L_0x00b1:
            if (r2 >= r5) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            r2 = r5
        L_0x00b5:
            if (r7 >= r2) goto L_0x00f0
            byte r12 = r21[r7]
            if (r12 == r6) goto L_0x00eb
            if (r12 != r4) goto L_0x00be
            goto L_0x00eb
        L_0x00be:
            int r3 = r12 + -48
            if (r3 < 0) goto L_0x00c4
            if (r3 <= r8) goto L_0x00dc
        L_0x00c4:
            boolean r16 = r0.a(r7, r5)
            if (r16 == 0) goto L_0x00d4
            double r0 = (double) r10
            double[] r2 = f21469o
            int r7 = r7 - r13
            int r7 = r7 - r9
            r3 = r2[r7]
            double r0 = r0 / r3
            float r0 = (float) r0
            return r0
        L_0x00d4:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r(r0, r1, r5, r15, r8)
        L_0x00dc:
            long r19 = r10 << r14
            r8 = 1
            long r10 = r10 << r8
            long r19 = r19 + r10
            long r10 = (long) r3
            long r10 = r19 + r10
            int r7 = r7 + 1
            r3 = 0
            r8 = 9
            goto L_0x00b5
        L_0x00eb:
            int r7 = r7 + 1
            r18 = 1
            goto L_0x00f2
        L_0x00f0:
            r18 = 0
        L_0x00f2:
            r1 = 57
            if (r7 != r2) goto L_0x010e
            if (r18 != 0) goto L_0x010e
            int r2 = r7 + 1
            int r2 = r2 - r9
        L_0x00fb:
            if (r7 >= r5) goto L_0x0109
            r3 = 48
            if (r12 < r3) goto L_0x0109
            if (r12 > r1) goto L_0x0109
            int r3 = r7 + 1
            byte r12 = r21[r7]
            r7 = r3
            goto L_0x00fb
        L_0x0109:
            r8 = r7
            r7 = r5
            r5 = r21
            goto L_0x0111
        L_0x010e:
            int r2 = r7 - r9
            goto L_0x0109
        L_0x0111:
            if (r8 != r7) goto L_0x0132
            int r3 = r22.m()
            if (r3 != r7) goto L_0x0132
            int r3 = r22.I()
            int r7 = r22.g()
            byte[] r5 = r0.f21410h
            r8 = r3
        L_0x0124:
            r3 = 48
            if (r8 >= r7) goto L_0x0111
            if (r12 < r3) goto L_0x0111
            if (r12 > r1) goto L_0x0111
            int r9 = r8 + 1
            byte r12 = r5[r8]
            r8 = r9
            goto L_0x0124
        L_0x0132:
            if (r12 == r6) goto L_0x0153
            if (r12 != r4) goto L_0x0137
            goto L_0x0153
        L_0x0137:
            int r2 = r2 - r13
            if (r2 <= 0) goto L_0x0144
            double r0 = (double) r10
            double[] r3 = f21469o
            r4 = 1
            int r2 = r2 - r4
            r2 = r3[r2]
            double r0 = r0 / r2
            float r0 = (float) r0
            return r0
        L_0x0144:
            r4 = 1
            if (r2 >= 0) goto L_0x0151
            double r0 = (double) r10
            double[] r3 = f21469o
            int r2 = -r2
            int r2 = r2 - r4
            r2 = r3[r2]
            double r0 = r0 * r2
            float r0 = (float) r0
            return r0
        L_0x0151:
            float r0 = (float) r10
            return r0
        L_0x0153:
            int r3 = r2 - r13
            r0 = r22
            r1 = r10
            r4 = r5
            r5 = r7
            r6 = r8
            float r0 = p(r0, r1, r3, r4, r5, r6)
            return r0
        L_0x0160:
            if (r12 == r6) goto L_0x0167
            if (r12 != r4) goto L_0x0165
            goto L_0x0167
        L_0x0165:
            float r0 = (float) r10
            return r0
        L_0x0167:
            r3 = 0
            r1 = 1
            int r6 = r13 + 1
            r0 = r22
            r1 = r10
            r4 = r21
            r5 = r24
            float r0 = p(r0, r1, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.m.u(byte[], f1.j, int, int, int):float");
    }

    private static float v(char[] cArr, int i10, j jVar, boolean z10) {
        int i11;
        int i12;
        char c10;
        int i13 = i10;
        while (i13 > 0 && Character.isWhitespace(cArr[i13 - 1])) {
            i13--;
        }
        if (i13 <= jVar.f21424v) {
            int i14 = 0;
            if (cArr[0] == '-') {
                i11 = 1;
            } else {
                i11 = 0;
            }
            if (cArr[i11] != '0' || i13 <= (i12 = i11 + 1) || (c10 = cArr[i12]) < '0' || c10 > '9') {
                try {
                    return Float.parseFloat(new String(cArr, 0, i13));
                } catch (NumberFormatException e10) {
                    if (z10) {
                        i14 = 2;
                    }
                    throw jVar.q("Error parsing number", i10 + i14, e10);
                }
            } else {
                if (z10) {
                    i14 = 2;
                }
                throw jVar.p("Leading zero is not allowed. Error parsing number", i10 + i14);
            }
        } else {
            throw jVar.s("Too many digits detected in number", i10, "", "Too many digits detected in number", Integer.valueOf(i13), "");
        }
    }

    private static long w(j jVar, int i10, int i11) {
        int i12 = i11 - i10;
        char[] x10 = jVar.x(i10, i12);
        if (i12 > 0 && x10[i12 - 1] == '.') {
            q(jVar, i10, i11, "Number ends with a dot");
        }
        BigDecimal A2 = A(x10, i12, jVar, false);
        if (A2.scale() > 0) {
            r(jVar, i10, i11, "Expecting long, but found decimal value ", A2);
        }
        return A2.longValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.math.BigDecimal x(byte[] r20, f1.j r21, int r22, int r23) {
        /*
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            int r4 = r2 + 1
            byte r5 = r0[r4]
            r6 = 48
            if (r5 != r6) goto L_0x0012
            r5 = 1
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            r9 = 0
            r6 = 32
            r11 = r4
        L_0x0018:
            java.lang.String r13 = "Unknown digit"
            java.lang.String r14 = "Leading zero is not allowed"
            r15 = 9
            r7 = 46
            r8 = 69
            r12 = 101(0x65, float:1.42E-43)
            if (r11 >= r3) goto L_0x0062
            byte r6 = r0[r11]
            if (r6 == r7) goto L_0x0062
            if (r6 == r12) goto L_0x0062
            if (r6 != r8) goto L_0x002f
            goto L_0x0062
        L_0x002f:
            int r7 = r6 + -48
            if (r7 < 0) goto L_0x0038
            if (r7 <= r15) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r8 = 3
            goto L_0x0057
        L_0x0038:
            if (r5 == 0) goto L_0x0041
            int r8 = r2 + 2
            if (r11 <= r8) goto L_0x0041
            q(r1, r2, r3, r14)
        L_0x0041:
            if (r11 <= r4) goto L_0x004e
            boolean r8 = r1.a(r11, r3)
            if (r8 == 0) goto L_0x004e
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9)
            return r0
        L_0x004e:
            char r8 = (char) r6
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r(r1, r2, r3, r13, r8)
            goto L_0x0036
        L_0x0057:
            long r12 = r9 << r8
            r8 = 1
            long r9 = r9 << r8
            long r12 = r12 + r9
            long r7 = (long) r7
            long r9 = r12 - r7
            int r11 = r11 + 1
            goto L_0x0018
        L_0x0062:
            if (r11 != r4) goto L_0x006b
            java.lang.String r0 = "Digit not found"
            q(r1, r2, r3, r0)
            goto L_0x0100
        L_0x006b:
            if (r5 == 0) goto L_0x0078
            if (r6 == r7) goto L_0x0078
            int r4 = r2 + 2
            if (r11 <= r4) goto L_0x0078
            q(r1, r2, r3, r14)
            goto L_0x0100
        L_0x0078:
            if (r11 != r3) goto L_0x007f
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9)
            return r0
        L_0x007f:
            r4 = 43
            r5 = 45
            if (r6 != r7) goto L_0x00fa
            r7 = 1
            int r11 = r11 + r7
            if (r11 != r3) goto L_0x008e
            java.lang.String r7 = "Number ends with a dot"
            q(r1, r2, r3, r7)
        L_0x008e:
            r7 = r11
        L_0x008f:
            if (r7 >= r3) goto L_0x00c6
            byte r6 = r0[r7]
            if (r6 == r12) goto L_0x00c6
            if (r6 != r8) goto L_0x0098
            goto L_0x00c6
        L_0x0098:
            int r14 = r6 + -48
            if (r14 < 0) goto L_0x00a1
            if (r14 <= r15) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r15 = 3
            goto L_0x00b6
        L_0x00a1:
            boolean r17 = r1.a(r7, r3)
            if (r17 == 0) goto L_0x00ad
            int r7 = r7 - r11
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9, r7)
            return r0
        L_0x00ad:
            char r15 = (char) r6
            java.lang.Character r15 = java.lang.Character.valueOf(r15)
            r(r1, r2, r3, r13, r15)
            goto L_0x009f
        L_0x00b6:
            long r18 = r9 << r15
            r16 = 1
            long r9 = r9 << r16
            long r18 = r18 + r9
            long r9 = (long) r14
            long r9 = r18 - r9
            int r7 = r7 + 1
            r15 = 9
            goto L_0x008f
        L_0x00c6:
            if (r7 != r3) goto L_0x00cf
            int r0 = r3 - r11
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9, r0)
            return r0
        L_0x00cf:
            if (r6 == r12) goto L_0x00db
            if (r6 != r8) goto L_0x00d4
            goto L_0x00db
        L_0x00d4:
            int r0 = r3 - r11
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9, r0)
            return r0
        L_0x00db:
            int r2 = r7 + 1
            byte r6 = r0[r2]
            if (r6 != r5) goto L_0x00e6
            int r0 = y(r0, r1, r2, r3)
            goto L_0x00f3
        L_0x00e6:
            if (r6 != r4) goto L_0x00ee
            r4 = 1
            int r0 = C(r0, r1, r2, r3, r4)
            goto L_0x00f3
        L_0x00ee:
            r4 = 0
            int r0 = C(r0, r1, r2, r3, r4)
        L_0x00f3:
            int r7 = r7 - r11
            int r7 = r7 - r0
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9, r7)
            return r0
        L_0x00fa:
            if (r6 == r12) goto L_0x00fe
            if (r6 != r8) goto L_0x0100
        L_0x00fe:
            r2 = 1
            goto L_0x0105
        L_0x0100:
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9)
            return r0
        L_0x0105:
            int r11 = r11 + r2
            byte r6 = r0[r11]
            if (r6 != r5) goto L_0x010f
            int r0 = y(r0, r1, r11, r3)
            goto L_0x011b
        L_0x010f:
            if (r6 != r4) goto L_0x0116
            int r0 = C(r0, r1, r11, r3, r2)
            goto L_0x011b
        L_0x0116:
            r2 = 0
            int r0 = C(r0, r1, r11, r3, r2)
        L_0x011b:
            int r0 = -r0
            java.math.BigDecimal r0 = java.math.BigDecimal.valueOf(r9, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: f1.m.x(byte[], f1.j, int, int):java.math.BigDecimal");
    }

    private static int y(byte[] bArr, j jVar, int i10, int i11) {
        int i12 = i10 + 1;
        if (i12 == i11) {
            q(jVar, i10, i11, "Digit not found");
        }
        int i13 = i12;
        int i14 = 0;
        while (i13 < i11) {
            int i15 = bArr[i13] - 48;
            if (i15 >= 0 && i15 <= 9) {
                i14 = ((i14 << 3) + (i14 << 1)) - i15;
                if (i14 > 0) {
                    q(jVar, i10, i11, "Integer overflow detected");
                }
                i13++;
            } else if (i13 > i12 && jVar.a(i13, i11)) {
                return i14;
            } else {
                if (i13 == i11 - 1 && bArr[i13] == 46) {
                    q(jVar, i10, i11, "Number ends with a dot");
                }
                int i16 = i11 - i10;
                BigDecimal A2 = A(jVar.x(i10, i16), i16, jVar, false);
                if (A2.scale() > 0) {
                    r(jVar, i10, i11, "Expecting int but found decimal value", A2);
                }
                return A2.intValue();
            }
        }
        return i14;
    }

    private static Number z(byte[] bArr, j jVar, int i10, int i11) {
        boolean z10;
        int i12;
        int i13;
        byte[] bArr2 = bArr;
        j jVar2 = jVar;
        int i14 = i10;
        int i15 = i11;
        int i16 = i14 + 1;
        if (bArr2[i16] == 48) {
            z10 = true;
        } else {
            z10 = false;
        }
        long j10 = 0;
        byte b10 = 32;
        int i17 = i16;
        while (i17 < i15 && (b10 = bArr2[i17]) != 46 && b10 != 101 && b10 != 69) {
            int i18 = b10 - 48;
            if (i18 < 0 || i18 > 9) {
                if (z10 && i17 > i14 + 2) {
                    q(jVar2, i14, i15, "Leading zero is not allowed");
                }
                if (i17 > i16 && jVar2.a(i17, i15)) {
                    return Long.valueOf(j10);
                }
                int i19 = i15 - i14;
                return V(jVar2.x(i14, i19), i19, jVar2);
            }
            j10 = ((j10 << 3) + (j10 << 1)) - ((long) i18);
            i17++;
        }
        if (i17 == i16) {
            q(jVar2, i14, i15, "Digit not found");
        } else if (z10 && b10 != 46 && i17 > i14 + 2) {
            q(jVar2, i14, i15, "Leading zero is not allowed");
        } else if (i17 == i15) {
            return Long.valueOf(j10);
        } else {
            if (b10 == 46) {
                int i20 = i17 + 1;
                if (i20 == i15) {
                    q(jVar2, i14, i15, "Number ends with a dot");
                }
                int i21 = i20;
                while (i21 < i15) {
                    b10 = bArr2[i21];
                    if (b10 == 101 || b10 == 69) {
                        break;
                    }
                    int i22 = b10 - 48;
                    if (i22 >= 0 && i22 <= 9) {
                        j10 = ((j10 << 3) + (j10 << 1)) - ((long) i22);
                        i21++;
                    } else if (jVar2.a(i21, i15)) {
                        return BigDecimal.valueOf(j10, i21 - i20);
                    } else {
                        int i23 = i15 - i14;
                        return V(jVar2.x(i14, i23), i23, jVar2);
                    }
                }
                if (i21 == i15) {
                    return b(BigDecimal.valueOf(j10, i15 - i20), jVar2.f21423u);
                }
                if (b10 != 101 && b10 != 69) {
                    return b(BigDecimal.valueOf(j10, i15 - i20), jVar2.f21423u);
                }
                int i24 = i21 + 1;
                byte b11 = bArr2[i24];
                if (b11 == 45) {
                    i13 = y(bArr2, jVar2, i24, i15);
                } else if (b11 == 43) {
                    i13 = C(bArr2, jVar2, i24, i15, 1);
                } else {
                    i13 = C(bArr2, jVar2, i24, i15, 0);
                }
                return b(BigDecimal.valueOf(j10, (i21 - i20) - i13), jVar2.f21423u);
            } else if (b10 == 101 || b10 == 69) {
                int i25 = i17 + 1;
                byte b12 = bArr2[i25];
                if (b12 == 45) {
                    i12 = y(bArr2, jVar2, i25, i15);
                } else if (b12 == 43) {
                    i12 = C(bArr2, jVar2, i25, i15, 1);
                } else {
                    i12 = C(bArr2, jVar2, i25, i15, 0);
                }
                return b(BigDecimal.valueOf(j10, -i12), jVar2.f21423u);
            }
        }
        return b(BigDecimal.valueOf(j10), jVar2.f21423u);
    }
}
