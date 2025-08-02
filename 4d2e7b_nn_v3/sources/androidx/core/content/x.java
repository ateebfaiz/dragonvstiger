package androidx.core.content;

import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.n;

public final /* synthetic */ class x implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UriMatcher f14924a;

    public /* synthetic */ x(UriMatcher uriMatcher) {
        this.f14924a = uriMatcher;
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
        return UriMatcherCompat.lambda$asPredicate$0(this.f14924a, (Uri) obj);
    }
}
