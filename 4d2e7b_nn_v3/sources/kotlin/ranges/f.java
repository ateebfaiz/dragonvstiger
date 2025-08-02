package kotlin.ranges;

import kotlin.jvm.internal.m;

public interface f {

    public static final class a {
        public static boolean a(f fVar, Comparable comparable) {
            m.f(comparable, "value");
            if (comparable.compareTo(fVar.getStart()) < 0 || comparable.compareTo(fVar.getEndInclusive()) > 0) {
                return false;
            }
            return true;
        }

        public static boolean b(f fVar) {
            if (fVar.getStart().compareTo(fVar.getEndInclusive()) > 0) {
                return true;
            }
            return false;
        }
    }

    Comparable getEndInclusive();

    Comparable getStart();
}
