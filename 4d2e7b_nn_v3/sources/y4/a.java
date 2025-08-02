package y4;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import y2.l;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final b f24890c = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Lazy f24891d = i.b(C0355a.f24894a);

    /* renamed from: a  reason: collision with root package name */
    public final int f24892a;

    /* renamed from: b  reason: collision with root package name */
    public final int f24893b;

    /* renamed from: y4.a$a  reason: collision with other inner class name */
    static final class C0355a extends n implements Function0 {

        /* renamed from: a  reason: collision with root package name */
        public static final C0355a f24894a = new C0355a();

        C0355a() {
            super(0);
        }

        /* renamed from: a */
        public final Pattern invoke() {
            return Pattern.compile("[-/ ]");
        }
    }

    public static final class b {
        private b() {
        }

        private final Pattern d() {
            Object value = a.f24891d.getValue();
            m.e(value, "<get-headerParsingRegEx>(...)");
            return (Pattern) value;
        }

        /* access modifiers changed from: private */
        public final String f(int i10) {
            if (i10 == Integer.MAX_VALUE) {
                return "";
            }
            return String.valueOf(i10);
        }

        public final a b(int i10) {
            boolean z10;
            if (i10 >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            l.b(Boolean.valueOf(z10));
            return new a(i10, Integer.MAX_VALUE);
        }

        public final a c(String str) {
            boolean z10;
            boolean z11;
            boolean z12;
            if (str == null) {
                return null;
            }
            try {
                String[] split = d().split(str);
                if (split.length == 4) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                l.b(Boolean.valueOf(z10));
                l.b(Boolean.valueOf(m.b(split[0], "bytes")));
                String str2 = split[1];
                m.e(str2, "headerParts[1]");
                int parseInt = Integer.parseInt(str2);
                String str3 = split[2];
                m.e(str3, "headerParts[2]");
                int parseInt2 = Integer.parseInt(str3);
                String str4 = split[3];
                m.e(str4, "headerParts[3]");
                int parseInt3 = Integer.parseInt(str4);
                if (parseInt2 > parseInt) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                l.b(Boolean.valueOf(z11));
                if (parseInt3 > parseInt2) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                l.b(Boolean.valueOf(z12));
                if (parseInt2 < parseInt3 - 1) {
                    return new a(parseInt, parseInt2);
                }
                return new a(parseInt, Integer.MAX_VALUE);
            } catch (IllegalArgumentException e10) {
                b0 b0Var = b0.f709a;
                String format = String.format((Locale) null, "Invalid Content-Range header value: \"%s\"", Arrays.copyOf(new Object[]{str}, 1));
                m.e(format, "format(locale, format, *args)");
                throw new IllegalArgumentException(format, e10);
            }
        }

        public final a e(int i10) {
            boolean z10;
            if (i10 > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            l.b(Boolean.valueOf(z10));
            return new a(0, i10);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i10, int i11) {
        this.f24892a = i10;
        this.f24893b = i11;
    }

    public static final a c(int i10) {
        return f24890c.b(i10);
    }

    public static final a e(int i10) {
        return f24890c.e(i10);
    }

    public final boolean b(a aVar) {
        if (aVar != null && this.f24892a <= aVar.f24892a && aVar.f24893b <= this.f24893b) {
            return true;
        }
        return false;
    }

    public final String d() {
        b0 b0Var = b0.f709a;
        b bVar = f24890c;
        String format = String.format((Locale) null, "bytes=%s-%s", Arrays.copyOf(new Object[]{bVar.f(this.f24892a), bVar.f(this.f24893b)}, 2));
        m.e(format, "format(locale, format, *args)");
        return format;
    }

    public boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!m.b(a.class, cls)) {
            return false;
        }
        m.d(obj, "null cannot be cast to non-null type com.facebook.imagepipeline.common.BytesRange");
        a aVar = (a) obj;
        if (this.f24892a == aVar.f24892a && this.f24893b == aVar.f24893b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f24892a * 31) + this.f24893b;
    }

    public String toString() {
        b0 b0Var = b0.f709a;
        b bVar = f24890c;
        String format = String.format((Locale) null, "%s-%s", Arrays.copyOf(new Object[]{bVar.f(this.f24892a), bVar.f(this.f24893b)}, 2));
        m.e(format, "format(locale, format, *args)");
        return format;
    }
}
