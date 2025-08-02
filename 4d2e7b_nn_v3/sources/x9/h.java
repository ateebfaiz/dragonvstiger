package x9;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Objects;

public final class h implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final h f13292b = new h("sig");

    /* renamed from: c  reason: collision with root package name */
    public static final h f13293c = new h("enc");

    /* renamed from: a  reason: collision with root package name */
    private final String f13294a;

    public h(String str) {
        if (str != null) {
            this.f13294a = str;
            return;
        }
        throw new IllegalArgumentException("The key use identifier must not be null");
    }

    public static h b(String str) {
        if (str == null) {
            return null;
        }
        h hVar = f13292b;
        if (str.equals(hVar.a())) {
            return hVar;
        }
        h hVar2 = f13293c;
        if (str.equals(hVar2.a())) {
            return hVar2;
        }
        if (!str.trim().isEmpty()) {
            return new h(str);
        }
        throw new ParseException("JWK use value must not be empty or blank", 0);
    }

    public String a() {
        return this.f13294a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return Objects.equals(this.f13294a, ((h) obj).f13294a);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f13294a});
    }

    public String toString() {
        return a();
    }
}
