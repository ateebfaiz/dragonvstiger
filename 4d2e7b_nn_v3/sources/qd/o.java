package qd;

import sc.a;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final t f1923a;

    /* renamed from: b  reason: collision with root package name */
    private final u f1924b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1925c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1926d;

    public o(int i10, int i11, a aVar) {
        this.f1925c = i10;
        this.f1926d = i11;
        this.f1924b = new u(h(i10, i11), aVar);
        this.f1923a = d.b(a().getAlgorithmName(), b(), f(), e(), c(), i11);
    }

    private static int h(int i10, int i11) {
        if (i10 < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        } else if (i10 % i11 == 0) {
            int i12 = i10 / i11;
            if (i12 != 1) {
                return i12;
            }
            throw new IllegalArgumentException("height / layers must be greater than 1");
        } else {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
    }

    /* access modifiers changed from: protected */
    public a a() {
        return this.f1924b.b();
    }

    public int b() {
        return this.f1924b.c();
    }

    public int c() {
        return this.f1925c;
    }

    public int d() {
        return this.f1926d;
    }

    /* access modifiers changed from: protected */
    public int e() {
        return this.f1924b.f().d().c();
    }

    public int f() {
        return this.f1924b.g();
    }

    /* access modifiers changed from: protected */
    public u g() {
        return this.f1924b;
    }
}
