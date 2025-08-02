package tc;

import com.alibaba.pdns.j;

public class d extends a {

    /* renamed from: d  reason: collision with root package name */
    private int f2119d;

    /* renamed from: e  reason: collision with root package name */
    private int f2120e;

    /* renamed from: f  reason: collision with root package name */
    private int f2121f;

    /* renamed from: g  reason: collision with root package name */
    private int f2122g;

    /* renamed from: h  reason: collision with root package name */
    private int f2123h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f2124i = new int[80];

    /* renamed from: j  reason: collision with root package name */
    private int f2125j;

    public d() {
        h();
    }

    private int j(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    private int k(int i10, int i11, int i12) {
        return (i10 & (i11 | i12)) | (i11 & i12);
    }

    private int l(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public int a(byte[] bArr, int i10) {
        d();
        zd.d.c(this.f2119d, bArr, i10);
        zd.d.c(this.f2120e, bArr, i10 + 4);
        zd.d.c(this.f2121f, bArr, i10 + 8);
        zd.d.c(this.f2122g, bArr, i10 + 12);
        zd.d.c(this.f2123h, bArr, i10 + 16);
        h();
        return 20;
    }

    public int c() {
        return 20;
    }

    /* access modifiers changed from: protected */
    public void e() {
        for (int i10 = 16; i10 < 80; i10++) {
            int[] iArr = this.f2124i;
            int i11 = ((iArr[i10 - 3] ^ iArr[i10 - 8]) ^ iArr[i10 - 14]) ^ iArr[i10 - 16];
            iArr[i10] = (i11 >>> 31) | (i11 << 1);
        }
        int i12 = this.f2119d;
        int i13 = this.f2120e;
        int i14 = this.f2121f;
        int i15 = this.f2122g;
        int i16 = this.f2123h;
        int i17 = 0;
        for (int i18 = 0; i18 < 4; i18++) {
            int j10 = i16 + ((i12 << 5) | (i12 >>> 27)) + j(i13, i14, i15) + this.f2124i[i17] + 1518500249;
            int i19 = (i13 >>> 2) | (i13 << 30);
            int j11 = i15 + ((j10 << 5) | (j10 >>> 27)) + j(i12, i19, i14) + this.f2124i[i17 + 1] + 1518500249;
            int i20 = (i12 >>> 2) | (i12 << 30);
            int j12 = i14 + ((j11 << 5) | (j11 >>> 27)) + j(j10, i20, i19) + this.f2124i[i17 + 2] + 1518500249;
            i16 = (j10 >>> 2) | (j10 << 30);
            int i21 = i17 + 4;
            i13 = i19 + ((j12 << 5) | (j12 >>> 27)) + j(j11, i16, i20) + this.f2124i[i17 + 3] + 1518500249;
            i15 = (j11 >>> 2) | (j11 << 30);
            i17 += 5;
            i12 = i20 + ((i13 << 5) | (i13 >>> 27)) + j(j12, i15, i16) + this.f2124i[i21] + 1518500249;
            i14 = (j12 >>> 2) | (j12 << 30);
        }
        for (int i22 = 0; i22 < 4; i22++) {
            int l10 = i16 + ((i12 << 5) | (i12 >>> 27)) + l(i13, i14, i15) + this.f2124i[i17] + 1859775393;
            int i23 = (i13 >>> 2) | (i13 << 30);
            int l11 = i15 + ((l10 << 5) | (l10 >>> 27)) + l(i12, i23, i14) + this.f2124i[i17 + 1] + 1859775393;
            int i24 = (i12 >>> 2) | (i12 << 30);
            int l12 = i14 + ((l11 << 5) | (l11 >>> 27)) + l(l10, i24, i23) + this.f2124i[i17 + 2] + 1859775393;
            i16 = (l10 >>> 2) | (l10 << 30);
            int i25 = i17 + 4;
            i13 = i23 + ((l12 << 5) | (l12 >>> 27)) + l(l11, i16, i24) + this.f2124i[i17 + 3] + 1859775393;
            i15 = (l11 >>> 2) | (l11 << 30);
            i17 += 5;
            i12 = i24 + ((i13 << 5) | (i13 >>> 27)) + l(l12, i15, i16) + this.f2124i[i25] + 1859775393;
            i14 = (l12 >>> 2) | (l12 << 30);
        }
        for (int i26 = 0; i26 < 4; i26++) {
            int k10 = i16 + (((((i12 << 5) | (i12 >>> 27)) + k(i13, i14, i15)) + this.f2124i[i17]) - 1894007588);
            int i27 = (i13 >>> 2) | (i13 << 30);
            int k11 = i15 + (((((k10 << 5) | (k10 >>> 27)) + k(i12, i27, i14)) + this.f2124i[i17 + 1]) - 1894007588);
            int i28 = (i12 >>> 2) | (i12 << 30);
            int k12 = i14 + (((((k11 << 5) | (k11 >>> 27)) + k(k10, i28, i27)) + this.f2124i[i17 + 2]) - 1894007588);
            i16 = (k10 >>> 2) | (k10 << 30);
            int i29 = i17 + 4;
            i13 = i27 + (((((k12 << 5) | (k12 >>> 27)) + k(k11, i16, i28)) + this.f2124i[i17 + 3]) - 1894007588);
            i15 = (k11 >>> 2) | (k11 << 30);
            i17 += 5;
            i12 = i28 + (((((i13 << 5) | (i13 >>> 27)) + k(k12, i15, i16)) + this.f2124i[i29]) - 1894007588);
            i14 = (k12 >>> 2) | (k12 << 30);
        }
        for (int i30 = 0; i30 <= 3; i30++) {
            int l13 = i16 + (((((i12 << 5) | (i12 >>> 27)) + l(i13, i14, i15)) + this.f2124i[i17]) - 899497514);
            int i31 = (i13 >>> 2) | (i13 << 30);
            int l14 = i15 + (((((l13 << 5) | (l13 >>> 27)) + l(i12, i31, i14)) + this.f2124i[i17 + 1]) - 899497514);
            int i32 = (i12 >>> 2) | (i12 << 30);
            int l15 = i14 + (((((l14 << 5) | (l14 >>> 27)) + l(l13, i32, i31)) + this.f2124i[i17 + 2]) - 899497514);
            i16 = (l13 >>> 2) | (l13 << 30);
            int i33 = i17 + 4;
            i13 = i31 + (((((l15 << 5) | (l15 >>> 27)) + l(l14, i16, i32)) + this.f2124i[i17 + 3]) - 899497514);
            i15 = (l14 >>> 2) | (l14 << 30);
            i17 += 5;
            i12 = i32 + (((((i13 << 5) | (i13 >>> 27)) + l(l15, i15, i16)) + this.f2124i[i33]) - 899497514);
            i14 = (l15 >>> 2) | (l15 << 30);
        }
        this.f2119d += i12;
        this.f2120e += i13;
        this.f2121f += i14;
        this.f2122g += i15;
        this.f2123h += i16;
        this.f2125j = 0;
        for (int i34 = 0; i34 < 16; i34++) {
            this.f2124i[i34] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void f(long j10) {
        if (this.f2125j > 14) {
            e();
        }
        int[] iArr = this.f2124i;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) j10;
    }

    /* access modifiers changed from: protected */
    public void g(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 3] & 255) | (bArr[i10] << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
        int[] iArr = this.f2124i;
        int i12 = this.f2125j;
        iArr[i12] = i11;
        int i13 = i12 + 1;
        this.f2125j = i13;
        if (i13 == 16) {
            e();
        }
    }

    public String getAlgorithmName() {
        return j.f17956c;
    }

    public void h() {
        super.h();
        this.f2119d = 1732584193;
        this.f2120e = -271733879;
        this.f2121f = -1732584194;
        this.f2122g = 271733878;
        this.f2123h = -1009589776;
        this.f2125j = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2124i;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }
}
