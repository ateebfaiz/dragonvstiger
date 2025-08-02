package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class o<T> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f12592b = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final Object f12593a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f12594a;

        public b(Throwable th) {
            m.f(th, "exception");
            this.f12594a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b) || !m.b(this.f12594a, ((b) obj).f12594a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f12594a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f12594a + ')';
        }
    }

    private /* synthetic */ o(Object obj) {
        this.f12593a = obj;
    }

    public static final /* synthetic */ o a(Object obj) {
        return new o(obj);
    }

    public static Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof o) && m.b(obj, ((o) obj2).j());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f12594a;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof b);
    }

    public static String i(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f12593a, obj);
    }

    public int hashCode() {
        return e(this.f12593a);
    }

    public final /* synthetic */ Object j() {
        return this.f12593a;
    }

    public String toString() {
        return i(this.f12593a);
    }
}
