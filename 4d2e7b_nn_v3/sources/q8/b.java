package q8;

import java.io.Serializable;
import java.util.Objects;

public final class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    protected final Class f12911a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f12912b;

    /* renamed from: c  reason: collision with root package name */
    protected String f12913c;

    public b(Class cls) {
        this(cls, (String) null);
    }

    public String a() {
        return this.f12913c;
    }

    public Class b() {
        return this.f12911a;
    }

    public boolean c() {
        if (this.f12913c != null) {
            return true;
        }
        return false;
    }

    public void d(String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        this.f12913c = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f12911a != bVar.f12911a || !Objects.equals(this.f12913c, bVar.f12913c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f12912b;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[NamedType, class ");
        sb2.append(this.f12911a.getName());
        sb2.append(", name: ");
        if (this.f12913c == null) {
            str = "null";
        } else {
            str = "'" + this.f12913c + "'";
        }
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }

    public b(Class cls, String str) {
        this.f12911a = cls;
        this.f12912b = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        d(str);
    }
}
