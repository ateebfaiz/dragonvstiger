package y4;

import g3.b;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;

public final class f {

    /* renamed from: e  reason: collision with root package name */
    public static final a f24925e = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f24926a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24927b;

    /* renamed from: c  reason: collision with root package name */
    public final float f24928c;

    /* renamed from: d  reason: collision with root package name */
    public final float f24929d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(int i10, int i11) {
        this(i10, i11, 0.0f, 0.0f, 12, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f24926a == fVar.f24926a && this.f24927b == fVar.f24927b) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return b.a(this.f24926a, this.f24927b);
    }

    public String toString() {
        b0 b0Var = b0.f709a;
        String format = String.format((Locale) null, "%dx%d", Arrays.copyOf(new Object[]{Integer.valueOf(this.f24926a), Integer.valueOf(this.f24927b)}, 2));
        m.e(format, "format(locale, format, *args)");
        return format;
    }

    public f(int i10, int i11, float f10, float f11) {
        this.f24926a = i10;
        this.f24927b = i11;
        this.f24928c = f10;
        this.f24929d = f11;
        if (i10 <= 0) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (i11 <= 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(int i10, int i11, float f10, float f11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, (i12 & 4) != 0 ? 2048.0f : f10, (i12 & 8) != 0 ? 0.6666667f : f11);
    }
}
