package androidx.core.content;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.n;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f14882a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Predicate f14883b;

    public /* synthetic */ g(Class cls, Predicate predicate) {
        this.f14882a = cls;
        this.f14883b = predicate;
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
        return IntentSanitizer.Builder.lambda$allowExtra$13(this.f14882a, this.f14883b, obj);
    }
}
