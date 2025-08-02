package qd;

import qd.n;
import zd.d;

final class h extends n {

    /* renamed from: e  reason: collision with root package name */
    private final int f1888e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1889f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1890g;

    protected static class b extends n.a {
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f1891e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f1892f = 0;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f1893g = 0;

        protected b() {
            super(1);
        }

        /* access modifiers changed from: protected */
        public n l() {
            return new h(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public b e() {
            return this;
        }

        /* access modifiers changed from: protected */
        public b n(int i10) {
            this.f1891e = i10;
            return this;
        }

        /* access modifiers changed from: protected */
        public b o(int i10) {
            this.f1892f = i10;
            return this;
        }

        /* access modifiers changed from: protected */
        public b p(int i10) {
            this.f1893g = i10;
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] d() {
        byte[] d10 = super.d();
        d.c(this.f1888e, d10, 16);
        d.c(this.f1889f, d10, 20);
        d.c(this.f1890g, d10, 24);
        return d10;
    }

    /* access modifiers changed from: protected */
    public int e() {
        return this.f1888e;
    }

    /* access modifiers changed from: protected */
    public int f() {
        return this.f1889f;
    }

    /* access modifiers changed from: protected */
    public int g() {
        return this.f1890g;
    }

    private h(b bVar) {
        super(bVar);
        this.f1888e = bVar.f1891e;
        this.f1889f = bVar.f1892f;
        this.f1890g = bVar.f1893g;
    }
}
