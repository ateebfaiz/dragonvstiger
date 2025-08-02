package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import qb.b;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f729a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final c f730b = b.f1852a.b();

    public static final class a extends c implements Serializable {

        /* renamed from: kotlin.random.c$a$a  reason: collision with other inner class name */
        private static final class C0011a implements Serializable {

            /* renamed from: a  reason: collision with root package name */
            public static final C0011a f731a = new C0011a();

            private C0011a() {
            }

            private final Object readResolve() {
                return c.f729a;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Object writeReplace() {
            return C0011a.f731a;
        }

        public int b(int i10) {
            return c.f730b.b(i10);
        }

        public int c() {
            return c.f730b.c();
        }

        public int d(int i10) {
            return c.f730b.d(i10);
        }

        public int e(int i10, int i11) {
            return c.f730b.e(i10, i11);
        }

        private a() {
        }
    }

    public abstract int b(int i10);

    public int c() {
        return b(32);
    }

    public int d(int i10) {
        return e(0, i10);
    }

    public int e(int i10, int i11) {
        int i12;
        int c10;
        int i13;
        d.b(i10, i11);
        int i14 = i11 - i10;
        if (i14 > 0 || i14 == Integer.MIN_VALUE) {
            if (((-i14) & i14) == i14) {
                i12 = b(d.c(i14));
            } else {
                do {
                    c10 = c() >>> 1;
                    i13 = c10 % i14;
                } while ((c10 - i13) + (i14 - 1) < 0);
                i12 = i13;
            }
            return i10 + i12;
        }
        while (true) {
            int c11 = c();
            if (i10 <= c11 && c11 < i11) {
                return c11;
            }
        }
    }
}
