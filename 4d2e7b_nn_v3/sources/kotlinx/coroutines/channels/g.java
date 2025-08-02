package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

public final class g {

    /* renamed from: b  reason: collision with root package name */
    public static final b f904b = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final c f905c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f906a;

    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f907a;

        public a(Throwable th) {
            this.f907a = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || !m.b(this.f907a, ((a) obj).f907a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.f907a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Closed(" + this.f907a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public final Object a(Throwable th) {
            return g.c(new a(th));
        }

        public final Object b() {
            return g.c(g.f905c);
        }

        public final Object c(Object obj) {
            return g.c(obj);
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ g(Object obj) {
        this.f906a = obj;
    }

    public static final /* synthetic */ g b(Object obj) {
        return new g(obj);
    }

    public static Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof g) && m.b(obj, ((g) obj2).k());
    }

    public static final Throwable e(Object obj) {
        a aVar;
        if (obj instanceof a) {
            aVar = (a) obj;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.f907a;
        }
        return null;
    }

    public static final Object f(Object obj) {
        if (!(obj instanceof c)) {
            return obj;
        }
        return null;
    }

    public static int g(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean h(Object obj) {
        return obj instanceof a;
    }

    public static final boolean i(Object obj) {
        return !(obj instanceof c);
    }

    public static String j(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f906a, obj);
    }

    public int hashCode() {
        return g(this.f906a);
    }

    public final /* synthetic */ Object k() {
        return this.f906a;
    }

    public String toString() {
        return j(this.f906a);
    }
}
