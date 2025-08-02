package qd;

public final class q extends vc.a {

    /* renamed from: b  reason: collision with root package name */
    private final o f1943b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f1944c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1945d;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final o f1946a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public byte[] f1947b = null;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public byte[] f1948c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f1949d = null;

        public b(o oVar) {
            this.f1946a = oVar;
        }

        public q e() {
            return new q(this);
        }

        public b f(byte[] bArr) {
            this.f1948c = x.c(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f1947b = x.c(bArr);
            return this;
        }
    }

    public o a() {
        return this.f1943b;
    }

    public byte[] b() {
        return x.c(this.f1945d);
    }

    public byte[] c() {
        return x.c(this.f1944c);
    }

    public byte[] d() {
        int b10 = this.f1943b.b();
        byte[] bArr = new byte[(b10 + b10)];
        x.e(bArr, this.f1944c, 0);
        x.e(bArr, this.f1945d, b10);
        return bArr;
    }

    private q(b bVar) {
        super(false);
        o a10 = bVar.f1946a;
        this.f1943b = a10;
        if (a10 != null) {
            int b10 = a10.b();
            byte[] b11 = bVar.f1949d;
            if (b11 != null) {
                if (b11.length == b10 + b10) {
                    this.f1944c = x.g(b11, 0, b10);
                    this.f1945d = x.g(b11, b10, b10);
                    return;
                }
                throw new IllegalArgumentException("public key has wrong size");
            }
            byte[] c10 = bVar.f1947b;
            if (c10 == null) {
                this.f1944c = new byte[b10];
            } else if (c10.length == b10) {
                this.f1944c = c10;
            } else {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            byte[] d10 = bVar.f1948c;
            if (d10 == null) {
                this.f1945d = new byte[b10];
            } else if (d10.length == b10) {
                this.f1945d = d10;
            } else {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }
}
