package androidx.core.content;

import android.content.ClipData;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;
import androidx.core.util.n;

public final /* synthetic */ class t implements Predicate {
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
        return IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
    }
}
