package q4;

import kotlin.collections.j;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import q4.c;

public final class a implements c.b {

    /* renamed from: b  reason: collision with root package name */
    public static final C0321a f23198b = new C0321a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f23199c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f23200d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f23201e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f23202f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final byte[] f23203g = e.a("GIF87a");
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final byte[] f23204h = e.a("GIF89a");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final byte[] f23205i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f23206j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final byte[] f23207k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f23208l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final byte[] f23209m = e.a("ftyp");
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public static final byte[][] f23210n = {e.a("heic"), e.a("heix"), e.a("hevc"), e.a("hevx"), e.a("mif1"), e.a("msf1")};
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public static final byte[] f23211o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public static final byte[] f23212p = {77, 77, 0, 42};
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public static final int f23213q;

    /* renamed from: a  reason: collision with root package name */
    private final int f23214a;

    /* renamed from: q4.a$a  reason: collision with other inner class name */
    public static final class C0321a {
        private C0321a() {
        }

        /* access modifiers changed from: private */
        public final c i(byte[] bArr, int i10) {
            if (!h3.c.h(bArr, 0, i10)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (h3.c.g(bArr, 0)) {
                return b.f23221g;
            } else {
                if (h3.c.f(bArr, 0)) {
                    return b.f23222h;
                }
                if (!h3.c.c(bArr, 0, i10)) {
                    return c.f23230d;
                }
                if (h3.c.b(bArr, 0)) {
                    return b.f23225k;
                }
                if (h3.c.d(bArr, 0)) {
                    return b.f23224j;
                }
                return b.f23223i;
            }
        }

        /* access modifiers changed from: private */
        public final boolean j(byte[] bArr, int i10) {
            if (i10 < a.f23205i.length) {
                return false;
            }
            return e.c(bArr, a.f23205i);
        }

        /* access modifiers changed from: private */
        public final boolean k(byte[] bArr, int i10) {
            if (i10 < a.f23213q || (!e.c(bArr, a.f23211o) && !e.c(bArr, a.f23212p))) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final boolean l(byte[] bArr, int i10) {
            if (i10 < 6) {
                return false;
            }
            if (e.c(bArr, a.f23203g) || e.c(bArr, a.f23204h)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean m(byte[] bArr, int i10) {
            if (i10 < 12 || bArr[3] < 8 || !e.b(bArr, a.f23209m, 4)) {
                return false;
            }
            for (byte[] b10 : a.f23210n) {
                if (e.b(bArr, b10, 8)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean n(byte[] bArr, int i10) {
            if (i10 < a.f23207k.length) {
                return false;
            }
            return e.c(bArr, a.f23207k);
        }

        /* access modifiers changed from: private */
        public final boolean o(byte[] bArr, int i10) {
            if (i10 < a.f23199c.length || !e.c(bArr, a.f23199c)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public final boolean p(byte[] bArr, int i10) {
            if (i10 < a.f23201e.length || !e.c(bArr, a.f23201e)) {
                return false;
            }
            return true;
        }

        public /* synthetic */ C0321a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        byte[] bArr = {-1, -40, -1};
        f23199c = bArr;
        f23200d = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        f23201e = bArr2;
        f23202f = bArr2.length;
        byte[] a10 = e.a("BM");
        f23205i = a10;
        f23206j = a10.length;
        byte[] bArr3 = {0, 0, 1, 0};
        f23207k = bArr3;
        f23208l = bArr3.length;
        byte[] bArr4 = {73, 73, 42, 0};
        f23211o = bArr4;
        f23213q = bArr4.length;
    }

    public a() {
        Comparable O = j.O((Comparable[]) new Integer[]{21, 20, Integer.valueOf(f23200d), Integer.valueOf(f23202f), 6, Integer.valueOf(f23206j), Integer.valueOf(f23208l), 12});
        if (O != null) {
            this.f23214a = ((Number) O).intValue();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public int a() {
        return this.f23214a;
    }

    public c b(byte[] bArr, int i10) {
        m.f(bArr, "headerBytes");
        if (h3.c.h(bArr, 0, i10)) {
            return f23198b.i(bArr, i10);
        }
        C0321a aVar = f23198b;
        if (aVar.o(bArr, i10)) {
            return b.f23216b;
        }
        if (aVar.p(bArr, i10)) {
            return b.f23217c;
        }
        if (aVar.l(bArr, i10)) {
            return b.f23218d;
        }
        if (aVar.j(bArr, i10)) {
            return b.f23219e;
        }
        if (aVar.n(bArr, i10)) {
            return b.f23220f;
        }
        if (aVar.m(bArr, i10)) {
            return b.f23226l;
        }
        if (aVar.k(bArr, i10)) {
            return b.f23227m;
        }
        return c.f23230d;
    }
}
