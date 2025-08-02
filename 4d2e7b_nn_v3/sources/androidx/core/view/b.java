package androidx.core.view;

import android.content.ClipData;
import androidx.core.util.Predicate;
import androidx.core.util.n;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ java.util.function.Predicate f15253a;

    public /* synthetic */ b(java.util.function.Predicate predicate) {
        this.f15253a = predicate;
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
        return this.f15253a.test((ClipData.Item) obj);
    }
}
