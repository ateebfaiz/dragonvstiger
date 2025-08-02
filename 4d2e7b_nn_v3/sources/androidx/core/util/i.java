package androidx.core.util;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f15136a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f15137b;

    public /* synthetic */ i(Predicate predicate, Predicate predicate2) {
        this.f15136a = predicate;
        this.f15137b = predicate2;
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
        return n.f(this.f15136a, this.f15137b, obj);
    }
}
