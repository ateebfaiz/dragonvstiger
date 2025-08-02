package o5;

import java.io.InputStream;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f23023a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static final Class f23024b = g.class;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f23025a;

        /* renamed from: b  reason: collision with root package name */
        private int f23026b;

        /* renamed from: c  reason: collision with root package name */
        private int f23027c;

        public final int a() {
            return this.f23026b;
        }

        public final int b() {
            return this.f23027c;
        }

        public final boolean c() {
            return this.f23025a;
        }

        public final void d(int i10) {
            this.f23026b = i10;
        }

        public final void e(int i10) {
            this.f23027c = i10;
        }

        public final void f(boolean z10) {
            this.f23025a = z10;
        }
    }

    private g() {
    }

    public static final int a(int i10) {
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        if (i10 == 3) {
            return 180;
        }
        if (i10 == 6) {
            return 90;
        }
        if (i10 != 8) {
            return 0;
        }
        return 270;
    }

    private final int b(InputStream inputStream, int i10, boolean z10) {
        if (i10 >= 10 && f.a(inputStream, 2, z10) == 3 && f.a(inputStream, 4, z10) == 1) {
            return f.a(inputStream, 2, z10);
        }
        return 0;
    }

    private final int c(InputStream inputStream, int i10, boolean z10, int i11) {
        if (i10 < 14) {
            return 0;
        }
        int a10 = f.a(inputStream, 2, z10);
        int i12 = i10 - 2;
        while (true) {
            int i13 = a10 - 1;
            if (a10 <= 0 || i12 < 12) {
                return 0;
            }
            int i14 = i12 - 2;
            if (f.a(inputStream, 2, z10) == i11) {
                return i14;
            }
            inputStream.skip(10);
            i12 -= 12;
            a10 = i13;
        }
        return 0;
    }

    public static final int d(InputStream inputStream, int i10) {
        m.f(inputStream, "stream");
        a aVar = new a();
        g gVar = f23023a;
        int e10 = gVar.e(inputStream, i10, aVar);
        int b10 = aVar.b() - 8;
        if (e10 == 0 || b10 > e10) {
            return 0;
        }
        inputStream.skip((long) b10);
        return gVar.b(inputStream, gVar.c(inputStream, e10 - b10, aVar.c(), 274), aVar.c());
    }

    private final int e(InputStream inputStream, int i10, a aVar) {
        boolean z10;
        if (i10 <= 8) {
            return 0;
        }
        aVar.d(f.a(inputStream, 4, false));
        if (aVar.a() == 1229531648 || aVar.a() == 1296891946) {
            if (aVar.a() == 1229531648) {
                z10 = true;
            } else {
                z10 = false;
            }
            aVar.f(z10);
            aVar.e(f.a(inputStream, 4, aVar.c()));
            int i11 = i10 - 8;
            if (aVar.b() >= 8 && aVar.b() - 8 <= i11) {
                return i11;
            }
            z2.a.f(f23024b, "Invalid offset");
            return 0;
        }
        z2.a.f(f23024b, "Invalid TIFF header");
        return 0;
    }
}
