package nb;

import java.util.Comparator;
import kotlin.jvm.internal.m;

final class e implements Comparator<Comparable<? super Object>> {

    /* renamed from: a  reason: collision with root package name */
    public static final e f1330a = new e();

    private e() {
    }

    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        m.f(comparable, "a");
        m.f(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    public final Comparator reversed() {
        return f.f1331a;
    }
}
