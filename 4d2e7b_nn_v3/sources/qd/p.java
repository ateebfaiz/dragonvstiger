package qd;

import java.io.IOException;

public final class p extends vc.a {

    /* renamed from: b  reason: collision with root package name */
    private final o f1927b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1928c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1929d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f1930e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f1931f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f1932g;

    /* renamed from: h  reason: collision with root package name */
    private final b f1933h;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final o f1934a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f1935b = 0;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public byte[] f1936c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f1937d = null;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public byte[] f1938e = null;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public byte[] f1939f = null;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public b f1940g = null;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public byte[] f1941h = null;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public u f1942i = null;

        public b(o oVar) {
            this.f1934a = oVar;
        }

        public p j() {
            return new p(this);
        }

        public b k(b bVar) {
            this.f1940g = bVar;
            return this;
        }

        public b l(long j10) {
            this.f1935b = j10;
            return this;
        }

        public b m(byte[] bArr) {
            this.f1938e = x.c(bArr);
            return this;
        }

        public b n(byte[] bArr) {
            this.f1939f = x.c(bArr);
            return this;
        }

        public b o(byte[] bArr) {
            this.f1937d = x.c(bArr);
            return this;
        }

        public b p(byte[] bArr) {
            this.f1936c = x.c(bArr);
            return this;
        }
    }

    public o a() {
        return this.f1927b;
    }

    public byte[] b() {
        int b10 = this.f1927b.b();
        int c10 = (this.f1927b.c() + 7) / 8;
        byte[] bArr = new byte[(c10 + b10 + b10 + b10 + b10)];
        x.e(bArr, x.p(this.f1928c, c10), 0);
        x.e(bArr, this.f1929d, c10);
        int i10 = c10 + b10;
        x.e(bArr, this.f1930e, i10);
        int i11 = i10 + b10;
        x.e(bArr, this.f1931f, i11);
        x.e(bArr, this.f1932g, i11 + b10);
        try {
            return zd.a.i(bArr, x.o(this.f1933h));
        } catch (IOException e10) {
            e10.printStackTrace();
            throw new RuntimeException("error serializing bds state");
        }
    }

    private p(b bVar) {
        super(true);
        b bVar2;
        o a10 = bVar.f1934a;
        this.f1927b = a10;
        if (a10 != null) {
            int b10 = a10.b();
            byte[] b11 = bVar.f1941h;
            if (b11 == null) {
                this.f1928c = bVar.f1935b;
                byte[] e10 = bVar.f1936c;
                if (e10 == null) {
                    this.f1929d = new byte[b10];
                } else if (e10.length == b10) {
                    this.f1929d = e10;
                } else {
                    throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
                }
                byte[] f10 = bVar.f1937d;
                if (f10 == null) {
                    this.f1930e = new byte[b10];
                } else if (f10.length == b10) {
                    this.f1930e = f10;
                } else {
                    throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
                }
                byte[] g10 = bVar.f1938e;
                if (g10 == null) {
                    this.f1931f = new byte[b10];
                } else if (g10.length == b10) {
                    this.f1931f = g10;
                } else {
                    throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
                }
                byte[] h10 = bVar.f1939f;
                if (h10 == null) {
                    this.f1932g = new byte[b10];
                } else if (h10.length == b10) {
                    this.f1932g = h10;
                } else {
                    throw new IllegalArgumentException("size of root needs to be equal size of digest");
                }
                b i10 = bVar.f1940g;
                if (i10 != null) {
                    this.f1933h = i10;
                    return;
                }
                if (!x.l(a10.c(), bVar.f1935b) || g10 == null || e10 == null) {
                    this.f1933h = new b();
                    return;
                } else {
                    this.f1933h = new b(a10, bVar.f1935b, g10, e10);
                    return;
                }
            } else if (bVar.f1942i != null) {
                int c10 = a10.c();
                int i11 = (c10 + 7) / 8;
                long a11 = x.a(b11, 0, i11);
                this.f1928c = a11;
                if (x.l(c10, a11)) {
                    this.f1929d = x.g(b11, i11, b10);
                    int i12 = i11 + b10;
                    this.f1930e = x.g(b11, i12, b10);
                    int i13 = i12 + b10;
                    this.f1931f = x.g(b11, i13, b10);
                    int i14 = i13 + b10;
                    this.f1932g = x.g(b11, i14, b10);
                    int i15 = i14 + b10;
                    try {
                        bVar2 = (b) x.f(x.g(b11, i15, b11.length - i15));
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    } catch (ClassNotFoundException e12) {
                        e12.printStackTrace();
                    }
                    bVar2.c(bVar.f1942i);
                    this.f1933h = bVar2;
                }
                throw new IllegalArgumentException("index out of bounds");
            } else {
                throw new NullPointerException("xmss == null");
            }
        } else {
            throw new NullPointerException("params == null");
        }
        bVar2 = null;
        bVar2.c(bVar.f1942i);
        this.f1933h = bVar2;
    }
}
