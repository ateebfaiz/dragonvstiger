package qd;

import qd.n;
import zd.d;

final class i extends n {

    /* renamed from: e  reason: collision with root package name */
    private final int f1894e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1895f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1896g;

    protected static class b extends n.a {
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f1897e = 0;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f1898f = 0;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f1899g = 0;

        protected b() {
            super(0);
        }

        /* access modifiers changed from: protected */
        public n l() {
            return new i(this);
        }

        /* access modifiers changed from: protected */
        /* renamed from: m */
        public b e() {
            return this;
        }

        /* access modifiers changed from: protected */
        public b n(int i10) {
            this.f1898f = i10;
            return this;
        }

        /* access modifiers changed from: protected */
        public b o(int i10) {
            this.f1899g = i10;
            return this;
        }

        /* access modifiers changed from: protected */
        public b p(int i10) {
            this.f1897e = i10;
            return this;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] d() {
        byte[] d10 = super.d();
        d.c(this.f1894e, d10, 16);
        d.c(this.f1895f, d10, 20);
        d.c(this.f1896g, d10, 24);
        return d10;
    }

    /* access modifiers changed from: protected */
    public int e() {
        return this.f1895f;
    }

    /* access modifiers changed from: protected */
    public int f() {
        return this.f1896g;
    }

    /* access modifiers changed from: protected */
    public int g() {
        return this.f1894e;
    }

    private i(b bVar) {
        super(bVar);
        this.f1894e = bVar.f1897e;
        this.f1895f = bVar.f1898f;
        this.f1896g = bVar.f1899g;
    }
}
