package tc;

import zd.d;

public class e extends a {

    /* renamed from: n  reason: collision with root package name */
    static final int[] f2126n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: d  reason: collision with root package name */
    private int f2127d;

    /* renamed from: e  reason: collision with root package name */
    private int f2128e;

    /* renamed from: f  reason: collision with root package name */
    private int f2129f;

    /* renamed from: g  reason: collision with root package name */
    private int f2130g;

    /* renamed from: h  reason: collision with root package name */
    private int f2131h;

    /* renamed from: i  reason: collision with root package name */
    private int f2132i;

    /* renamed from: j  reason: collision with root package name */
    private int f2133j;

    /* renamed from: k  reason: collision with root package name */
    private int f2134k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f2135l = new int[64];

    /* renamed from: m  reason: collision with root package name */
    private int f2136m;

    public e() {
        h();
    }

    private int j(int i10, int i11, int i12) {
        return ((~i10) & i12) ^ (i11 & i10);
    }

    private int k(int i10, int i11, int i12) {
        return ((i10 & i12) ^ (i10 & i11)) ^ (i11 & i12);
    }

    private int l(int i10) {
        return ((i10 << 10) | (i10 >>> 22)) ^ (((i10 >>> 2) | (i10 << 30)) ^ ((i10 >>> 13) | (i10 << 19)));
    }

    private int m(int i10) {
        return ((i10 << 7) | (i10 >>> 25)) ^ (((i10 >>> 6) | (i10 << 26)) ^ ((i10 >>> 11) | (i10 << 21)));
    }

    private int n(int i10) {
        return (i10 >>> 3) ^ (((i10 >>> 7) | (i10 << 25)) ^ ((i10 >>> 18) | (i10 << 14)));
    }

    private int o(int i10) {
        return (i10 >>> 10) ^ (((i10 >>> 17) | (i10 << 15)) ^ ((i10 >>> 19) | (i10 << 13)));
    }

    public int a(byte[] bArr, int i10) {
        d();
        d.c(this.f2127d, bArr, i10);
        d.c(this.f2128e, bArr, i10 + 4);
        d.c(this.f2129f, bArr, i10 + 8);
        d.c(this.f2130g, bArr, i10 + 12);
        d.c(this.f2131h, bArr, i10 + 16);
        d.c(this.f2132i, bArr, i10 + 20);
        d.c(this.f2133j, bArr, i10 + 24);
        h();
        return 28;
    }

    public int c() {
        return 28;
    }

    /* access modifiers changed from: protected */
    public void e() {
        for (int i10 = 16; i10 <= 63; i10++) {
            int[] iArr = this.f2135l;
            int o10 = o(iArr[i10 - 2]);
            int[] iArr2 = this.f2135l;
            iArr[i10] = o10 + iArr2[i10 - 7] + n(iArr2[i10 - 15]) + this.f2135l[i10 - 16];
        }
        int i11 = this.f2127d;
        int i12 = this.f2128e;
        int i13 = this.f2129f;
        int i14 = this.f2130g;
        int i15 = this.f2131h;
        int i16 = this.f2132i;
        int i17 = this.f2133j;
        int i18 = this.f2134k;
        int i19 = 0;
        for (int i20 = 0; i20 < 8; i20++) {
            int m10 = m(i15) + j(i15, i16, i17);
            int[] iArr3 = f2126n;
            int i21 = i18 + m10 + iArr3[i19] + this.f2135l[i19];
            int i22 = i14 + i21;
            int l10 = i21 + l(i11) + k(i11, i12, i13);
            int i23 = i19 + 1;
            int m11 = i17 + m(i22) + j(i22, i15, i16) + iArr3[i23] + this.f2135l[i23];
            int i24 = i13 + m11;
            int l11 = m11 + l(l10) + k(l10, i11, i12);
            int i25 = i19 + 2;
            int m12 = i16 + m(i24) + j(i24, i22, i15) + iArr3[i25] + this.f2135l[i25];
            int i26 = i12 + m12;
            int l12 = m12 + l(l11) + k(l11, l10, i11);
            int i27 = i19 + 3;
            int m13 = i15 + m(i26) + j(i26, i24, i22) + iArr3[i27] + this.f2135l[i27];
            int i28 = i11 + m13;
            int l13 = m13 + l(l12) + k(l12, l11, l10);
            int i29 = i19 + 4;
            int m14 = i22 + m(i28) + j(i28, i26, i24) + iArr3[i29] + this.f2135l[i29];
            i18 = l10 + m14;
            i14 = m14 + l(l13) + k(l13, l12, l11);
            int i30 = i19 + 5;
            int m15 = i24 + m(i18) + j(i18, i28, i26) + iArr3[i30] + this.f2135l[i30];
            i17 = l11 + m15;
            i13 = m15 + l(i14) + k(i14, l13, l12);
            int i31 = i19 + 6;
            int m16 = i26 + m(i17) + j(i17, i18, i28) + iArr3[i31] + this.f2135l[i31];
            i16 = l12 + m16;
            i12 = m16 + l(i13) + k(i13, i14, l13);
            int i32 = i19 + 7;
            int m17 = i28 + m(i16) + j(i16, i17, i18) + iArr3[i32] + this.f2135l[i32];
            i15 = l13 + m17;
            i11 = m17 + l(i12) + k(i12, i13, i14);
            i19 += 8;
        }
        this.f2127d += i11;
        this.f2128e += i12;
        this.f2129f += i13;
        this.f2130g += i14;
        this.f2131h += i15;
        this.f2132i += i16;
        this.f2133j += i17;
        this.f2134k += i18;
        this.f2136m = 0;
        for (int i33 = 0; i33 < 16; i33++) {
            this.f2135l[i33] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void f(long j10) {
        if (this.f2136m > 14) {
            e();
        }
        int[] iArr = this.f2135l;
        iArr[14] = (int) (j10 >>> 32);
        iArr[15] = (int) j10;
    }

    /* access modifiers changed from: protected */
    public void g(byte[] bArr, int i10) {
        int i11 = (bArr[i10 + 3] & 255) | (bArr[i10] << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
        int[] iArr = this.f2135l;
        int i12 = this.f2136m;
        iArr[i12] = i11;
        int i13 = i12 + 1;
        this.f2136m = i13;
        if (i13 == 16) {
            e();
        }
    }

    public String getAlgorithmName() {
        return "SHA-224";
    }

    public void h() {
        super.h();
        this.f2127d = -1056596264;
        this.f2128e = 914150663;
        this.f2129f = 812702999;
        this.f2130g = -150054599;
        this.f2131h = -4191439;
        this.f2132i = 1750603025;
        this.f2133j = 1694076839;
        this.f2134k = -1090891868;
        this.f2136m = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2135l;
            if (i10 != iArr.length) {
                iArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }
}
