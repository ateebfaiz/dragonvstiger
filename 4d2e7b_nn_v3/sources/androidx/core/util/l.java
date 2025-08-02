package androidx.core.util;

public final /* synthetic */ class l implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Predicate f15139a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f15140b;

    public /* synthetic */ l(Predicate predicate, Predicate predicate2) {
        this.f15139a = predicate;
        this.f15140b = predicate2;
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
        return n.d(this.f15139a, this.f15140b, obj);
    }
}
