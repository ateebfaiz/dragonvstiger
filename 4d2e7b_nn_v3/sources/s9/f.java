package s9;

import io.jsonwebtoken.Header;
import java.io.Serializable;

public final class f implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final f f13001b = new f("JOSE");

    /* renamed from: c  reason: collision with root package name */
    public static final f f13002c = new f("JOSE+JSON");

    /* renamed from: d  reason: collision with root package name */
    public static final f f13003d = new f(Header.JWT_TYPE);

    /* renamed from: a  reason: collision with root package name */
    private final String f13004a;

    public f(String str) {
        if (str != null) {
            this.f13004a = str;
            return;
        }
        throw new IllegalArgumentException("The object type must not be null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f) || !this.f13004a.equalsIgnoreCase(((f) obj).f13004a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f13004a.toLowerCase().hashCode();
    }

    public String toString() {
        return this.f13004a;
    }
}
