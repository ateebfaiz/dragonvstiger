package h8;

import java.util.concurrent.atomic.AtomicReference;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    protected final b f12289a = null;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReference f12290b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f12291c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f12292d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f12293e;

    /* renamed from: f  reason: collision with root package name */
    protected int f12294f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f12295g;

    static final class a {
    }

    /* renamed from: h8.b$b  reason: collision with other inner class name */
    private static final class C0143b {

        /* renamed from: a  reason: collision with root package name */
        final int f12296a;

        /* renamed from: b  reason: collision with root package name */
        final int f12297b;

        /* renamed from: c  reason: collision with root package name */
        final String[] f12298c;

        /* renamed from: d  reason: collision with root package name */
        final a[] f12299d;

        public C0143b(int i10, int i11, String[] strArr, a[] aVarArr) {
            this.f12296a = i10;
            this.f12297b = i11;
            this.f12298c = strArr;
            this.f12299d = aVarArr;
        }

        public static C0143b a(int i10) {
            return new C0143b(0, 0, new String[i10], new a[(i10 >> 1)]);
        }
    }

    private b(int i10) {
        this.f12291c = i10;
        this.f12293e = true;
        this.f12292d = -1;
        this.f12295g = false;
        this.f12294f = 0;
        this.f12290b = new AtomicReference(C0143b.a(64));
    }

    public static b a() {
        long currentTimeMillis = System.currentTimeMillis();
        return b((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static b b(int i10) {
        return new b(i10);
    }
}
