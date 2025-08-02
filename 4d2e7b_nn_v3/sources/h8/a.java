package h8;

import java.util.concurrent.atomic.AtomicReference;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    protected final a f12270a = null;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReference f12271b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f12272c;

    /* renamed from: d  reason: collision with root package name */
    protected final boolean f12273d;

    /* renamed from: e  reason: collision with root package name */
    protected final boolean f12274e;

    /* renamed from: f  reason: collision with root package name */
    protected int[] f12275f;

    /* renamed from: g  reason: collision with root package name */
    protected int f12276g;

    /* renamed from: h  reason: collision with root package name */
    protected int f12277h;

    /* renamed from: i  reason: collision with root package name */
    protected int f12278i;

    /* renamed from: j  reason: collision with root package name */
    protected int f12279j = 0;

    /* renamed from: k  reason: collision with root package name */
    protected int f12280k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f12281l = true;

    /* renamed from: h8.a$a  reason: collision with other inner class name */
    private static final class C0142a {

        /* renamed from: a  reason: collision with root package name */
        public final int f12282a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12283b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12284c;

        /* renamed from: d  reason: collision with root package name */
        public final int[] f12285d;

        /* renamed from: e  reason: collision with root package name */
        public final String[] f12286e;

        /* renamed from: f  reason: collision with root package name */
        public final int f12287f;

        /* renamed from: g  reason: collision with root package name */
        public final int f12288g;

        public C0142a(int i10, int i11, int i12, int[] iArr, String[] strArr, int i13, int i14) {
            this.f12282a = i10;
            this.f12283b = i11;
            this.f12284c = i12;
            this.f12285d = iArr;
            this.f12286e = strArr;
            this.f12287f = i13;
            this.f12288g = i14;
        }

        public static C0142a a(int i10) {
            int i11 = i10 << 3;
            return new C0142a(i10, 0, a.a(i10), new int[i11], new String[(i10 << 1)], i11 - i10, i11);
        }
    }

    private a(int i10, int i11) {
        this.f12272c = i11;
        this.f12273d = false;
        this.f12274e = true;
        int i12 = 16;
        if (i10 >= 16) {
            if (((i10 - 1) & i10) != 0) {
                while (i12 < i10) {
                    i12 += i12;
                }
            }
            this.f12271b = new AtomicReference(C0142a.a(i10));
        }
        i10 = i12;
        this.f12271b = new AtomicReference(C0142a.a(i10));
    }

    static int a(int i10) {
        int i11 = i10 >> 2;
        if (i11 < 64) {
            return 4;
        }
        if (i11 <= 256) {
            return 5;
        }
        if (i11 <= 1024) {
            return 6;
        }
        return 7;
    }

    private final int b() {
        int i10 = this.f12276g;
        return (i10 << 3) - i10;
    }

    public static a c() {
        long currentTimeMillis = System.currentTimeMillis();
        return d((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static a d(int i10) {
        return new a(64, i10);
    }

    public int e() {
        int i10 = this.f12277h;
        int i11 = 0;
        for (int i12 = 3; i12 < i10; i12 += 4) {
            if (this.f12275f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public int f() {
        int i10 = this.f12278i;
        int i11 = 0;
        for (int i12 = this.f12277h + 3; i12 < i10; i12 += 4) {
            if (this.f12275f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public int g() {
        return (this.f12280k - b()) >> 2;
    }

    public int h() {
        int i10 = this.f12278i + 3;
        int i11 = this.f12276g + i10;
        int i12 = 0;
        while (i10 < i11) {
            if (this.f12275f[i10] != 0) {
                i12++;
            }
            i10 += 4;
        }
        return i12;
    }

    public int i() {
        int i10 = this.f12276g << 3;
        int i11 = 0;
        for (int i12 = 3; i12 < i10; i12 += 4) {
            if (this.f12275f[i12] != 0) {
                i11++;
            }
        }
        return i11;
    }

    public String toString() {
        int e10 = e();
        int f10 = f();
        int h10 = h();
        int g10 = g();
        int i10 = i();
        return String.format("[%s: size=%d, hashSize=%d, %d/%d/%d/%d pri/sec/ter/spill (=%s), total:%d]", new Object[]{a.class.getName(), Integer.valueOf(this.f12279j), Integer.valueOf(this.f12276g), Integer.valueOf(e10), Integer.valueOf(f10), Integer.valueOf(h10), Integer.valueOf(g10), Integer.valueOf(e10 + f10 + h10 + g10), Integer.valueOf(i10)});
    }
}
