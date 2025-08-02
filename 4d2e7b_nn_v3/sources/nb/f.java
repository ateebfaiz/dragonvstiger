package nb;

import java.util.Comparator;
import kotlin.jvm.internal.m;

final class f implements Comparator<Comparable<? super Object>> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f1331a = new f();

    private f() {
    }

    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        m.f(comparable, "a");
        m.f(comparable2, "b");
        return comparable2.compareTo(comparable);
    }

    public final Comparator reversed() {
        return e.f1330a;
    }
}
