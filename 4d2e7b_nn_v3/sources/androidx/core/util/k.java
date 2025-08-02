package androidx.core.util;

public final /* synthetic */ class k implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f15138a;

    public /* synthetic */ k(Object obj) {
        this.f15138a = obj;
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
        return this.f15138a.equals(obj);
    }
}
