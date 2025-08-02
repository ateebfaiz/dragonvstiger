package androidx.core.util;

import java.util.Objects;

public abstract /* synthetic */ class n {
    public static Predicate a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new l(predicate, predicate2);
    }

    public static Predicate b(Predicate predicate) {
        return new m(predicate);
    }

    public static Predicate c(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new i(predicate, predicate2);
    }

    public static /* synthetic */ boolean d(Predicate predicate, Predicate predicate2, Object obj) {
        if (!predicate.test(obj) || !predicate2.test(obj)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean e(Predicate predicate, Object obj) {
        return !predicate.test(obj);
    }

    public static /* synthetic */ boolean f(Predicate predicate, Predicate predicate2, Object obj) {
        if (predicate.test(obj) || predicate2.test(obj)) {
            return true;
        }
        return false;
    }

    public static Predicate g(Object obj) {
        if (obj == null) {
            return new j();
        }
        return new k(obj);
    }

    public static Predicate j(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
