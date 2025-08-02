package androidx.core.content;

import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

public final /* synthetic */ class n implements Predicate {
    public /* synthetic */ Predicate and(Predicate predicate) {
        return androidx.core.util.n.a(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return androidx.core.util.n.b(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return androidx.core.util.n.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return IntentSanitizer.Builder.lambda$new$1((Uri) obj);
    }
}
