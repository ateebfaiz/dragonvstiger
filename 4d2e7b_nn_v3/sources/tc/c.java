package tc;

import sc.a;
import zd.d;

public abstract class c implements a {

    /* renamed from: o  reason: collision with root package name */
    static final long[] f2104o = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* renamed from: a  reason: collision with root package name */
    private byte[] f2105a = new byte[8];

    /* renamed from: b  reason: collision with root package name */
    private int f2106b = 0;

    /* renamed from: c  reason: collision with root package name */
    private long f2107c;

    /* renamed from: d  reason: collision with root package name */
    private long f2108d;

    /* renamed from: e  reason: collision with root package name */
    protected long f2109e;

    /* renamed from: f  reason: collision with root package name */
    protected long f2110f;

    /* renamed from: g  reason: collision with root package name */
    protected long f2111g;

    /* renamed from: h  reason: collision with root package name */
    protected long f2112h;

    /* renamed from: i  reason: collision with root package name */
    protected long f2113i;

    /* renamed from: j  reason: collision with root package name */
    protected long f2114j;

    /* renamed from: k  reason: collision with root package name */
    protected long f2115k;

    /* renamed from: l  reason: collision with root package name */
    protected long f2116l;

    /* renamed from: m  reason: collision with root package name */
    private long[] f2117m = new long[80];

    /* renamed from: n  reason: collision with root package name */
    private int f2118n;

    protected c() {
        o();
    }

    private long d(long j10, long j11, long j12) {
        return ((~j10) & j12) ^ (j11 & j10);
    }

    private long e(long j10, long j11, long j12) {
        return ((j10 & j12) ^ (j10 & j11)) ^ (j11 & j12);
    }

    private long f(long j10) {
        return (j10 >>> 7) ^ (((j10 << 63) | (j10 >>> 1)) ^ ((j10 << 56) | (j10 >>> 8)));
    }

    private long g(long j10) {
        return (j10 >>> 6) ^ (((j10 << 45) | (j10 >>> 19)) ^ ((j10 << 3) | (j10 >>> 61)));
    }

    private long h(long j10) {
        return ((j10 >>> 39) | (j10 << 25)) ^ (((j10 << 36) | (j10 >>> 28)) ^ ((j10 << 30) | (j10 >>> 34)));
    }

    private long i(long j10) {
        return ((j10 >>> 41) | (j10 << 23)) ^ (((j10 << 50) | (j10 >>> 14)) ^ ((j10 << 46) | (j10 >>> 18)));
    }

    private void j() {
        long j10 = this.f2107c;
        if (j10 > 2305843009213693951L) {
            this.f2108d += j10 >>> 61;
            this.f2107c = j10 & 2305843009213693951L;
        }
    }

    public void k() {
        j();
        long j10 = this.f2107c << 3;
        long j11 = this.f2108d;
        p(Byte.MIN_VALUE);
        while (this.f2106b != 0) {
            p((byte) 0);
        }
        m(j10, j11);
        l();
    }

    /* access modifiers changed from: protected */
    public void l() {
        j();
        for (int i10 = 16; i10 <= 79; i10++) {
            long[] jArr = this.f2117m;
            long g10 = g(jArr[i10 - 2]);
            long[] jArr2 = this.f2117m;
            jArr[i10] = g10 + jArr2[i10 - 7] + f(jArr2[i10 - 15]) + this.f2117m[i10 - 16];
        }
        long j10 = this.f2109e;
        long j11 = this.f2110f;
        long j12 = this.f2111g;
        long j13 = this.f2112h;
        long j14 = this.f2113i;
        long j15 = this.f2114j;
        long j16 = this.f2115k;
        long j17 = j15;
        long j18 = j13;
        int i11 = 0;
        long j19 = j11;
        long j20 = j12;
        long j21 = j14;
        int i12 = 0;
        long j22 = this.f2116l;
        long j23 = j16;
        long j24 = j10;
        long j25 = j23;
        while (i12 < 10) {
            int i13 = i12;
            long j26 = j21;
            long[] jArr3 = f2104o;
            int i14 = i11 + 1;
            long i15 = j22 + i(j21) + d(j21, j17, j25) + jArr3[i11] + this.f2117m[i11];
            long h10 = i15 + h(j24) + e(j24, j19, j20);
            long j27 = j18 + i15;
            long j28 = j27;
            int i16 = i11 + 2;
            long i17 = j25 + i(j27) + d(j27, j26, j17) + jArr3[i14] + this.f2117m[i14];
            long j29 = h10;
            long j30 = j20 + i17;
            long h11 = i17 + h(h10) + e(h10, j24, j19);
            long i18 = i(j30);
            long j31 = j30;
            long j32 = h11;
            int i19 = i11 + 3;
            long d10 = j17 + i18 + d(j30, j28, j26) + jArr3[i16] + this.f2117m[i16];
            long j33 = j19 + d10;
            long h12 = d10 + h(j32) + e(j32, j29, j24);
            long i20 = i(j33);
            long j34 = j33;
            long j35 = h12;
            int i21 = i11 + 4;
            long d11 = j26 + i20 + d(j33, j31, j28) + jArr3[i19] + this.f2117m[i19];
            long j36 = j24 + d11;
            long h13 = d11 + h(j35) + e(j35, j32, j29);
            long i22 = i(j36);
            long j37 = j36;
            long j38 = h13;
            int i23 = i11 + 5;
            long d12 = j28 + i22 + d(j36, j34, j31) + jArr3[i21] + this.f2117m[i21];
            long j39 = j35;
            long j40 = j35;
            long j41 = j29 + d12;
            long h14 = d12 + h(j38) + e(j38, j39, j32);
            long i24 = i(j41);
            long j42 = j41;
            long j43 = h14;
            int i25 = i11 + 6;
            long d13 = j31 + i24 + d(j41, j37, j34) + jArr3[i23] + this.f2117m[i23];
            long j44 = j32 + d13;
            long h15 = d13 + h(j43) + e(j43, j38, j40);
            long i26 = i(j44);
            j25 = j44;
            long j45 = h15;
            int i27 = i11 + 7;
            long d14 = j34 + i26 + d(j44, j42, j37) + jArr3[i25] + this.f2117m[i25];
            long j46 = j40 + d14;
            long j47 = j43;
            long j48 = j43;
            long j49 = j46;
            long h16 = d14 + h(j45) + e(j45, j47, j38);
            long i28 = i(j49);
            j17 = j49;
            j19 = h16;
            i11 += 8;
            long d15 = j37 + i28 + d(j49, j25, j42) + jArr3[i27] + this.f2117m[i27];
            long h17 = d15 + h(j19) + e(j19, j45, j48);
            i12 = i13 + 1;
            j21 = j38 + d15;
            j20 = j45;
            j22 = j42;
            j18 = j48;
            j24 = h17;
        }
        this.f2109e += j24;
        this.f2110f += j19;
        this.f2111g += j20;
        this.f2112h += j18;
        this.f2113i += j21;
        this.f2114j += j17;
        this.f2115k += j25;
        this.f2116l += j22;
        this.f2118n = 0;
        for (int i29 = 0; i29 < 16; i29++) {
            this.f2117m[i29] = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void m(long j10, long j11) {
        if (this.f2118n > 14) {
            l();
        }
        long[] jArr = this.f2117m;
        jArr[14] = j11;
        jArr[15] = j10;
    }

    /* access modifiers changed from: protected */
    public void n(byte[] bArr, int i10) {
        this.f2117m[this.f2118n] = d.b(bArr, i10);
        int i11 = this.f2118n + 1;
        this.f2118n = i11;
        if (i11 == 16) {
            l();
        }
    }

    public void o() {
        this.f2107c = 0;
        this.f2108d = 0;
        int i10 = 0;
        this.f2106b = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f2105a;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = 0;
            i11++;
        }
        this.f2118n = 0;
        while (true) {
            long[] jArr = this.f2117m;
            if (i10 != jArr.length) {
                jArr[i10] = 0;
                i10++;
            } else {
                return;
            }
        }
    }

    public void p(byte b10) {
        byte[] bArr = this.f2105a;
        int i10 = this.f2106b;
        int i11 = i10 + 1;
        this.f2106b = i11;
        bArr[i10] = b10;
        if (i11 == bArr.length) {
            n(bArr, 0);
            this.f2106b = 0;
        }
        this.f2107c++;
    }

    public void update(byte[] bArr, int i10, int i11) {
        while (this.f2106b != 0 && i11 > 0) {
            p(bArr[i10]);
            i10++;
            i11--;
        }
        while (i11 > this.f2105a.length) {
            n(bArr, i10);
            byte[] bArr2 = this.f2105a;
            i10 += bArr2.length;
            i11 -= bArr2.length;
            this.f2107c += (long) bArr2.length;
        }
        while (i11 > 0) {
            p(bArr[i10]);
            i10++;
            i11--;
        }
    }
}
