package androidx.core.util;

public final /* synthetic */ class m implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f15141a;

    public /* synthetic */ m(Predicate predicate) {
        this.f15141a = predicate;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return n.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return n.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return n.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return n.e(this.f15141a, obj);
    }
}
