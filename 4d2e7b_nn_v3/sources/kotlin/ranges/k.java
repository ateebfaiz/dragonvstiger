package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class k extends i implements f {

    /* renamed from: e  reason: collision with root package name */
    public static final a f760e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final k f761f = new k(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(long j10, long j11) {
        super(j10, j11, 1);
    }

    public boolean e(long j10) {
        if (a() > j10 || j10 > c()) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (!(a() == kVar.a() && c() == kVar.c())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public Long getEndInclusive() {
        return Long.valueOf(c());
    }

    /* renamed from: g */
    public Long getStart() {
        return Long.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (a() ^ (a() >>> 32))) + (c() ^ (c() >>> 32)));
    }

    public boolean isEmpty() {
        if (a() > c()) {
            return true;
        }
        return false;
    }

    public String toString() {
        return a() + ".." + c();
    }
}
