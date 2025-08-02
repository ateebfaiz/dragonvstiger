package qd;

public final class w extends vc.a {

    /* renamed from: b  reason: collision with root package name */
    private final u f1971b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f1972c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f1973d;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final u f1974a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public byte[] f1975b = null;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public byte[] f1976c = null;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public byte[] f1977d = null;

        public b(u uVar) {
            this.f1974a = uVar;
        }

        public w e() {
            return new w(this);
        }

        public b f(byte[] bArr) {
            this.f1976c = x.c(bArr);
            return this;
        }

        public b g(byte[] bArr) {
            this.f1975b = x.c(bArr);
            return this;
        }
    }

    public u a() {
        return this.f1971b;
    }

    public byte[] b() {
        return x.c(this.f1973d);
    }

    public byte[] c() {
        return x.c(this.f1972c);
    }

    public byte[] d() {
        int c10 = this.f1971b.c();
        byte[] bArr = new byte[(c10 + c10)];
        x.e(bArr, this.f1972c, 0);
        x.e(bArr, this.f1973d, c10);
        return bArr;
    }

    private w(b bVar) {
        super(false);
        u a10 = bVar.f1974a;
        this.f1971b = a10;
        if (a10 != null) {
            int c10 = a10.c();
            byte[] b10 = bVar.f1977d;
            if (b10 != null) {
                if (b10.length == c10 + c10) {
                    this.f1972c = x.g(b10, 0, c10);
                    this.f1973d = x.g(b10, c10, c10);
                    return;
                }
                throw new IllegalArgumentException("public key has wrong size");
            }
            byte[] c11 = bVar.f1975b;
            if (c11 == null) {
                this.f1972c = new byte[c10];
            } else if (c11.length == c10) {
                this.f1972c = c11;
            } else {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            byte[] d10 = bVar.f1976c;
            if (d10 == null) {
                this.f1973d = new byte[c10];
            } else if (d10.length == c10) {
                this.f1973d = d10;
            } else {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }
}
