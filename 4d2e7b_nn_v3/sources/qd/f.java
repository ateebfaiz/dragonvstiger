package qd;

import qd.n;
import zd.d;

final class f extends n {

    /* renamed from: e  reason: collision with root package name */
    private final int f1881e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1882f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1883g;

    protected static class b extends n.a {
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f1884e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f1885f = 0;

        protected b() {
            super(2);
        }

        /* access modifiers changed from: protected */
        public n k() {
            return new f(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public b e() {
            return this;
        }

        /* access modifiers changed from: protected */
        public b m(int i10) {
            this.f1884e = i10;
            return this;
        }

        /* access modifiers changed from: protected */
        public b n(int i10) {
            this.f1885f = i10;
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] d() {
        byte[] d10 = super.d();
        d.c(this.f1881e, d10, 16);
        d.c(this.f1882f, d10, 20);
        d.c(this.f1883g, d10, 24);
        return d10;
    }

    /* access modifiers changed from: protected */
    public int e() {
        return this.f1882f;
    }

    /* access modifiers changed from: protected */
    public int f() {
        return this.f1883g;
    }

    private f(b bVar) {
        super(bVar);
        this.f1881e = 0;
        this.f1882f = bVar.f1884e;
        this.f1883g = bVar.f1885f;
    }
}
