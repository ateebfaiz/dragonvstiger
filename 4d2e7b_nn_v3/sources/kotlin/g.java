package kotlin;

import io.jsonwebtoken.JwtParser;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;

public final class g implements Comparable<g> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f12579e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    public static final g f12580f = h.a();

    /* renamed from: a  reason: collision with root package name */
    private final int f12581a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12582b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12583c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12584d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public g(int i10, int i11, int i12) {
        this.f12581a = i10;
        this.f12582b = i11;
        this.f12583c = i12;
        this.f12584d = b(i10, i11, i12);
    }

    private final int b(int i10, int i11, int i12) {
        if (new IntRange(0, 255).b(i10) && new IntRange(0, 255).b(i11) && new IntRange(0, 255).b(i12)) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + JwtParser.SEPARATOR_CHAR + i11 + JwtParser.SEPARATOR_CHAR + i12).toString());
    }

    /* renamed from: a */
    public int compareTo(g gVar) {
        m.f(gVar, "other");
        return this.f12584d - gVar.f12584d;
    }

    public boolean equals(Object obj) {
        g gVar;
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            gVar = (g) obj;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        if (this.f12584d == gVar.f12584d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f12584d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12581a);
        sb2.append(JwtParser.SEPARATOR_CHAR);
        sb2.append(this.f12582b);
        sb2.append(JwtParser.SEPARATOR_CHAR);
        sb2.append(this.f12583c);
        return sb2.toString();
    }
}
