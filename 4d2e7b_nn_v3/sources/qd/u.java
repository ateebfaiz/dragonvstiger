package qd;

import sc.a;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    private final t f1952a;

    /* renamed from: b  reason: collision with root package name */
    private final j f1953b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1954c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1955d;

    public u(int i10, a aVar) {
        if (i10 < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        } else if (aVar != null) {
            j jVar = new j(new l(aVar));
            this.f1953b = jVar;
            this.f1954c = i10;
            this.f1955d = a();
            this.f1952a = e.b(b().getAlgorithmName(), c(), g(), jVar.d().c(), i10);
        } else {
            throw new NullPointerException("digest == null");
        }
    }

    private int a() {
        int i10 = 2;
        while (true) {
            int i11 = this.f1954c;
            if (i10 > i11) {
                throw new IllegalStateException("should never happen...");
            } else if ((i11 - i10) % 2 == 0) {
                return i10;
            } else {
                i10++;
            }
        }
    }

    /* access modifiers changed from: protected */
    public a b() {
        return this.f1953b.d().a();
    }

    public int c() {
        return this.f1953b.d().b();
    }

    public int d() {
        return this.f1954c;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1955d;
    }

    /* access modifiers changed from: package-private */
    public j f() {
        return this.f1953b;
    }

    public int g() {
        return this.f1953b.d().d();
    }
}
