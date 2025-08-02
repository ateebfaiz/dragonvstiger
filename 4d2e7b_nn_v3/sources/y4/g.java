package y4;

import g3.b;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: c  reason: collision with root package name */
    public static final a f24930c = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final g f24931d = new g(-1, false);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final g f24932e = new g(-2, false);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final g f24933f = new g(-1, true);

    /* renamed from: a  reason: collision with root package name */
    private final int f24934a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f24935b;

    public static final class a {
        private a() {
        }

        public final g a() {
            return g.f24931d;
        }

        public final g b() {
            return g.f24933f;
        }

        public final g c() {
            return g.f24932e;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private g(int i10, boolean z10) {
        this.f24934a = i10;
        this.f24935b = z10;
    }

    public static final g d() {
        return f24930c.a();
    }

    public static final g e() {
        return f24930c.b();
    }

    public static final g g() {
        return f24930c.c();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f24934a == gVar.f24934a && this.f24935b == gVar.f24935b) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f24935b;
    }

    public final int h() {
        if (!j()) {
            return this.f24934a;
        }
        throw new IllegalStateException("Rotation is set to use EXIF".toString());
    }

    public int hashCode() {
        return b.b(Integer.valueOf(this.f24934a), Boolean.valueOf(this.f24935b));
    }

    public final boolean i() {
        if (this.f24934a != -2) {
            return true;
        }
        return false;
    }

    public final boolean j() {
        if (this.f24934a == -1) {
            return true;
        }
        return false;
    }

    public String toString() {
        b0 b0Var = b0.f709a;
        String format = String.format((Locale) null, "%d defer:%b", Arrays.copyOf(new Object[]{Integer.valueOf(this.f24934a), Boolean.valueOf(this.f24935b)}, 2));
        m.e(format, "format(locale, format, *args)");
        return format;
    }
}
