package kotlin.ranges;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class c extends a implements f {

    /* renamed from: e  reason: collision with root package name */
    public static final a f742e = new a((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final c f743f = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(char c10, char c11) {
        super(c10, c11, 1);
    }

    /* renamed from: e */
    public Character getEndInclusive() {
        return Character.valueOf(c());
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(a() == cVar.a() && c() == cVar.c())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public Character getStart() {
        return Character.valueOf(a());
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + c();
    }

    public boolean isEmpty() {
        if (m.g(a(), c()) > 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return a() + ".." + c();
    }
}
