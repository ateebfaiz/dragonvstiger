package d1;

import kotlin.jvm.internal.m;

public final class g implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f21022a;

    public g(Object obj) {
        this.f21022a = obj;
    }

    public Object a() {
        return get();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof g) && m.b(this.f21022a, ((g) obj).f21022a)) {
            return true;
        }
        return false;
    }

    public Object get() {
        return this.f21022a;
    }

    public int hashCode() {
        Object obj = this.f21022a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "ValueProvider(value=" + this.f21022a + ')';
    }
}
