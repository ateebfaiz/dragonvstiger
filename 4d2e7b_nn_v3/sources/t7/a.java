package t7;

import android.content.Context;
import android.net.Uri;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static final C0157a f13061e = new C0157a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f13062a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f13063b;

    /* renamed from: c  reason: collision with root package name */
    private final double f13064c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13065d;

    /* renamed from: t7.a$a  reason: collision with other inner class name */
    public static final class C0157a {
        private C0157a() {
        }

        public final a a(Context context) {
            m.f(context, "context");
            return new a(context, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=", 0.0d, 0.0d, 12, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ C0157a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(Context context, String str) {
        this(context, str, 0.0d, 0.0d, 12, (DefaultConstructorMarker) null);
        m.f(context, "context");
    }

    private final Uri a(Context context) {
        this.f13065d = true;
        return c.f13069b.a().g(context, this.f13062a);
    }

    private final Uri b(Context context) {
        try {
            Uri parse = Uri.parse(this.f13062a);
            if (parse.getScheme() == null) {
                parse = a(context);
            }
            m.c(parse);
            return parse;
        } catch (NullPointerException unused) {
            return a(context);
        }
    }

    public static final a e(Context context) {
        return f13061e.a(context);
    }

    public final double c() {
        return this.f13064c;
    }

    public final String d() {
        return this.f13062a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !m.b(getClass(), obj.getClass())) {
            return false;
        }
        a aVar = (a) obj;
        if (Double.compare(aVar.f13064c, this.f13064c) != 0 || g() != aVar.g() || !m.b(f(), aVar.f()) || !m.b(this.f13062a, aVar.f13062a)) {
            return false;
        }
        return true;
    }

    public Uri f() {
        return this.f13063b;
    }

    public boolean g() {
        return this.f13065d;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{f(), this.f13062a, Double.valueOf(this.f13064c), Boolean.valueOf(g())});
    }

    public a(Context context, String str, double d10, double d11) {
        m.f(context, "context");
        this.f13062a = str;
        this.f13063b = b(context);
        this.f13064c = d10 * d11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, String str, double d10, double d11, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i10 & 4) != 0 ? 0.0d : d10, (i10 & 8) != 0 ? 0.0d : d11);
    }
}
