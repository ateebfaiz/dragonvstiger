package y9;

import java.lang.reflect.Field;
import java.util.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Field f13362a;

    public a(Field field) {
        Objects.requireNonNull(field);
        this.f13362a = field;
    }

    public String toString() {
        return this.f13362a.toString();
    }
}
