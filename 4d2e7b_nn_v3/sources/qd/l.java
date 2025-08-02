package qd;

import sc.a;

final class l {

    /* renamed from: a  reason: collision with root package name */
    private final t f1907a;

    /* renamed from: b  reason: collision with root package name */
    private final a f1908b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1909c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1910d;

    /* renamed from: e  reason: collision with root package name */
    private final int f1911e;

    /* renamed from: f  reason: collision with root package name */
    private final int f1912f;

    /* renamed from: g  reason: collision with root package name */
    private final int f1913g;

    protected l(a aVar) {
        if (aVar != null) {
            this.f1908b = aVar;
            int h10 = x.h(aVar);
            this.f1909c = h10;
            this.f1910d = 16;
            int ceil = (int) Math.ceil(((double) (h10 * 8)) / ((double) x.n(16)));
            this.f1912f = ceil;
            int floor = ((int) Math.floor((double) (x.n((16 - 1) * ceil) / x.n(16)))) + 1;
            this.f1913g = floor;
            int i10 = ceil + floor;
            this.f1911e = i10;
            k b10 = k.b(aVar.getAlgorithmName(), h10, 16, i10);
            this.f1907a = b10;
            if (b10 == null) {
                throw new IllegalArgumentException("cannot find OID for digest algorithm: " + aVar.getAlgorithmName());
            }
            return;
        }
        throw new NullPointerException("digest == null");
    }

    /* access modifiers changed from: protected */
    public a a() {
        return this.f1908b;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return this.f1909c;
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.f1911e;
    }

    /* access modifiers changed from: protected */
    public int d() {
        return this.f1910d;
    }
}
