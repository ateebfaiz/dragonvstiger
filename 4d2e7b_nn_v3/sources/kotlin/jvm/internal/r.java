package kotlin.jvm.internal;

public final class r implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Class f720a;

    /* renamed from: b  reason: collision with root package name */
    private final String f721b;

    public r(Class cls, String str) {
        m.f(cls, "jClass");
        m.f(str, "moduleName");
        this.f720a = cls;
        this.f721b = str;
    }

    public Class c() {
        return this.f720a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r) || !m.b(c(), ((r) obj).c())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return c().hashCode();
    }

    public String toString() {
        return c().toString() + " (Kotlin reflection is not available)";
    }
}
