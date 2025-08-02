package tc;

import sc.a;
import zd.d;

public abstract class b implements a {

    /* renamed from: g  reason: collision with root package name */
    private static long[] f2096g = o();

    /* renamed from: h  reason: collision with root package name */
    private static int[] f2097h = n();

    /* renamed from: a  reason: collision with root package name */
    protected long[] f2098a = new long[25];

    /* renamed from: b  reason: collision with root package name */
    protected byte[] f2099b = new byte[192];

    /* renamed from: c  reason: collision with root package name */
    protected int f2100c;

    /* renamed from: d  reason: collision with root package name */
    protected int f2101d;

    /* renamed from: e  reason: collision with root package name */
    protected int f2102e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f2103f;

    public b(int i10) {
        k(i10);
    }

    private void d(byte[] bArr, int i10) {
        int i11 = this.f2100c >> 6;
        for (int i12 = 0; i12 < i11; i12++) {
            long[] jArr = this.f2098a;
            jArr[i12] = jArr[i12] ^ d.f(bArr, i10);
            i10 += 8;
        }
        f();
    }

    private void e() {
        d.j(this.f2098a, 0, this.f2100c >> 6, this.f2099b, 0);
    }

    private void f() {
        for (int i10 = 0; i10 < 24; i10++) {
            v(this.f2098a);
            t(this.f2098a);
            r(this.f2098a);
            j(this.f2098a);
            m(this.f2098a, i10);
        }
    }

    private static boolean g(byte[] bArr) {
        boolean z10;
        byte b10 = bArr[0];
        if ((b10 & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((b10 & 128) != 0) {
            bArr[0] = (byte) ((b10 << 1) ^ 113);
        } else {
            bArr[0] = (byte) (b10 << 1);
        }
        return z10;
    }

    private static void j(long[] jArr) {
        for (int i10 = 0; i10 < 25; i10 += 5) {
            long j10 = jArr[i10];
            int i11 = i10 + 1;
            long j11 = jArr[i11];
            long j12 = ~j11;
            int i12 = i10 + 2;
            long j13 = jArr[i12];
            long j14 = ~j13;
            int i13 = i10 + 3;
            long j15 = jArr[i13];
            long j16 = (j14 & j15) ^ j11;
            long j17 = ~j15;
            int i14 = i10 + 4;
            long j18 = (j12 & j13) ^ j10;
            long j19 = jArr[i14];
            jArr[i10] = j18;
            jArr[i11] = j16;
            jArr[i12] = j13 ^ (j17 & j19);
            jArr[i13] = ((~j19) & j10) ^ j15;
            jArr[i14] = ((~j10) & j11) ^ j19;
        }
    }

    private void k(int i10) {
        if (i10 == 128 || i10 == 224 || i10 == 256 || i10 == 288 || i10 == 384 || i10 == 512) {
            l(1600 - (i10 << 1));
            return;
        }
        throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
    }

    private void l(int i10) {
        if (i10 <= 0 || i10 >= 1600 || i10 % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.f2100c = i10;
        int i11 = 0;
        while (true) {
            long[] jArr = this.f2098a;
            if (i11 < jArr.length) {
                jArr[i11] = 0;
                i11++;
            } else {
                zd.a.k(this.f2099b, (byte) 0);
                this.f2101d = 0;
                this.f2103f = false;
                this.f2102e = (1600 - i10) / 2;
                return;
            }
        }
    }

    private static void m(long[] jArr, int i10) {
        jArr[0] = jArr[0] ^ f2096g[i10];
    }

    private static int[] n() {
        int[] iArr = new int[25];
        int i10 = 0;
        iArr[0] = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < 24) {
            int i13 = i10 + 1;
            iArr[(i11 % 5) + ((i12 % 5) * 5)] = (((i10 + 2) * i13) / 2) % 64;
            int i14 = i12 % 5;
            i12 = ((i11 * 2) + (i12 * 3)) % 5;
            i11 = i14;
            i10 = i13;
        }
        return iArr;
    }

    private static long[] o() {
        long[] jArr = new long[24];
        byte[] bArr = {1};
        for (int i10 = 0; i10 < 24; i10++) {
            jArr[i10] = 0;
            for (int i11 = 0; i11 < 7; i11++) {
                int i12 = (1 << i11) - 1;
                if (g(bArr)) {
                    jArr[i10] = jArr[i10] ^ (1 << i12);
                }
            }
        }
        return jArr;
    }

    private static long p(long j10, int i10) {
        return (j10 >>> (-i10)) | (j10 << i10);
    }

    private void q() {
        byte[] bArr = this.f2099b;
        int i10 = this.f2101d;
        int i11 = i10 >> 3;
        bArr[i11] = (byte) (bArr[i11] | ((byte) ((int) (1 << (i10 & 7)))));
        int i12 = i10 + 1;
        this.f2101d = i12;
        if (i12 == this.f2100c) {
            d(bArr, 0);
            this.f2101d = 0;
        }
        int i13 = this.f2101d;
        int i14 = i13 >> 6;
        int i15 = i13 & 63;
        int i16 = 0;
        for (int i17 = 0; i17 < i14; i17++) {
            long[] jArr = this.f2098a;
            jArr[i17] = jArr[i17] ^ d.f(this.f2099b, i16);
            i16 += 8;
        }
        if (i15 > 0) {
            long[] jArr2 = this.f2098a;
            jArr2[i14] = jArr2[i14] ^ (d.f(this.f2099b, i16) & ((1 << i15) - 1));
        }
        long[] jArr3 = this.f2098a;
        int i18 = (this.f2100c - 1) >> 6;
        jArr3[i18] = jArr3[i18] ^ Long.MIN_VALUE;
        f();
        e();
        this.f2101d = this.f2100c;
        this.f2103f = true;
    }

    private static void r(long[] jArr) {
        long j10 = jArr[1];
        jArr[1] = jArr[6];
        jArr[6] = jArr[9];
        jArr[9] = jArr[22];
        jArr[22] = jArr[14];
        jArr[14] = jArr[20];
        jArr[20] = jArr[2];
        jArr[2] = jArr[12];
        jArr[12] = jArr[13];
        jArr[13] = jArr[19];
        jArr[19] = jArr[23];
        jArr[23] = jArr[15];
        jArr[15] = jArr[4];
        jArr[4] = jArr[24];
        jArr[24] = jArr[21];
        jArr[21] = jArr[8];
        jArr[8] = jArr[16];
        jArr[16] = jArr[5];
        jArr[5] = jArr[3];
        jArr[3] = jArr[18];
        jArr[18] = jArr[17];
        jArr[17] = jArr[11];
        jArr[11] = jArr[7];
        jArr[7] = jArr[10];
        jArr[10] = j10;
    }

    private static void t(long[] jArr) {
        for (int i10 = 1; i10 < 25; i10++) {
            jArr[i10] = p(jArr[i10], f2097h[i10]);
        }
    }

    private static void v(long[] jArr) {
        long j10 = (((jArr[0] ^ jArr[5]) ^ jArr[10]) ^ jArr[15]) ^ jArr[20];
        long j11 = (((jArr[1] ^ jArr[6]) ^ jArr[11]) ^ jArr[16]) ^ jArr[21];
        long j12 = (((jArr[2] ^ jArr[7]) ^ jArr[12]) ^ jArr[17]) ^ jArr[22];
        long j13 = (((jArr[3] ^ jArr[8]) ^ jArr[13]) ^ jArr[18]) ^ jArr[23];
        long j14 = (((jArr[4] ^ jArr[9]) ^ jArr[14]) ^ jArr[19]) ^ jArr[24];
        long p10 = p(j11, 1) ^ j14;
        jArr[0] = jArr[0] ^ p10;
        jArr[5] = jArr[5] ^ p10;
        jArr[10] = jArr[10] ^ p10;
        jArr[15] = jArr[15] ^ p10;
        jArr[20] = jArr[20] ^ p10;
        long p11 = p(j12, 1) ^ j10;
        jArr[1] = jArr[1] ^ p11;
        jArr[6] = jArr[6] ^ p11;
        jArr[11] = jArr[11] ^ p11;
        jArr[16] = jArr[16] ^ p11;
        jArr[21] = p11 ^ jArr[21];
        long j15 = j13;
        long p12 = p(j15, 1) ^ j11;
        jArr[2] = jArr[2] ^ p12;
        jArr[7] = jArr[7] ^ p12;
        jArr[12] = jArr[12] ^ p12;
        jArr[17] = jArr[17] ^ p12;
        jArr[22] = p12 ^ jArr[22];
        long p13 = p(j14, 1) ^ j12;
        jArr[3] = jArr[3] ^ p13;
        jArr[8] = jArr[8] ^ p13;
        jArr[13] = jArr[13] ^ p13;
        jArr[18] = jArr[18] ^ p13;
        jArr[23] = p13 ^ jArr[23];
        long p14 = p(j10, 1) ^ j15;
        jArr[4] = jArr[4] ^ p14;
        jArr[9] = jArr[9] ^ p14;
        jArr[14] = jArr[14] ^ p14;
        jArr[19] = jArr[19] ^ p14;
        jArr[24] = p14 ^ jArr[24];
    }

    public int c() {
        return this.f2102e / 8;
    }

    /* access modifiers changed from: protected */
    public void h(byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = this.f2101d;
        if (i13 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.f2103f) {
            int i14 = i13 >> 3;
            int i15 = this.f2100c >> 3;
            int i16 = 0;
            while (i16 < i11) {
                if (i14 != 0 || i16 > (i12 = i11 - i15)) {
                    int min = Math.min(i15 - i14, i11 - i16);
                    System.arraycopy(bArr, i10 + i16, this.f2099b, i14, min);
                    i14 += min;
                    i16 += min;
                    if (i14 == i15) {
                        d(this.f2099b, 0);
                        i14 = 0;
                    }
                } else {
                    do {
                        d(bArr, i10 + i16);
                        i16 += i15;
                    } while (i16 <= i12);
                }
            }
            this.f2101d = i14 << 3;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    /* access modifiers changed from: protected */
    public void i(int i10, int i11) {
        if (i11 < 1 || i11 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i12 = this.f2101d;
        if (i12 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        } else if (!this.f2103f) {
            this.f2099b[i12 >> 3] = (byte) (i10 & ((1 << i11) - 1));
            this.f2101d = i12 + i11;
        } else {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
    }

    public void s() {
        k(this.f2102e);
    }

    /* access modifiers changed from: protected */
    public void u(byte[] bArr, int i10, long j10) {
        if (!this.f2103f) {
            q();
        }
        long j11 = 0;
        if (j10 % 8 == 0) {
            while (j11 < j10) {
                if (this.f2101d == 0) {
                    f();
                    e();
                    this.f2101d = this.f2100c;
                }
                int min = (int) Math.min((long) this.f2101d, j10 - j11);
                System.arraycopy(this.f2099b, (this.f2100c - this.f2101d) / 8, bArr, ((int) (j11 / 8)) + i10, min / 8);
                this.f2101d -= min;
                j11 += (long) min;
            }
            return;
        }
        throw new IllegalStateException("outputLength not a multiple of 8");
    }

    public void update(byte[] bArr, int i10, int i11) {
        h(bArr, i10, i11);
    }
}
