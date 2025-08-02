package qd;

import zd.d;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    private final int f1915a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1916b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1917c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1918d;

    protected static abstract class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f1919a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f1920b = 0;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f1921c = 0;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f1922d = 0;

        protected a(int i10) {
            this.f1919a = i10;
        }

        /* access modifiers changed from: protected */
        public abstract a e();

        /* access modifiers changed from: protected */
        public a f(int i10) {
            this.f1922d = i10;
            return e();
        }

        /* access modifiers changed from: protected */
        public a g(int i10) {
            this.f1920b = i10;
            return e();
        }

        /* access modifiers changed from: protected */
        public a h(long j10) {
            this.f1921c = j10;
            return e();
        }
    }

    protected n(a aVar) {
        this.f1915a = aVar.f1920b;
        this.f1916b = aVar.f1921c;
        this.f1917c = aVar.f1919a;
        this.f1918d = aVar.f1922d;
    }

    public final int a() {
        return this.f1918d;
    }

    /* access modifiers changed from: protected */
    public final int b() {
        return this.f1915a;
    }

    /* access modifiers changed from: protected */
    public final long c() {
        return this.f1916b;
    }

    /* access modifiers changed from: protected */
    public byte[] d() {
        byte[] bArr = new byte[32];
        d.c(this.f1915a, bArr, 0);
        d.h(this.f1916b, bArr, 4);
        d.c(this.f1917c, bArr, 12);
        d.c(this.f1918d, bArr, 28);
        return bArr;
    }
}
