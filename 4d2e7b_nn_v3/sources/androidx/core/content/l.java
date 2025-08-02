package androidx.core.content;

import android.net.Uri;
import androidx.core.util.Predicate;
import androidx.core.util.n;

public final /* synthetic */ class l implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f14886a;

    public /* synthetic */ l(String str) {
        this.f14886a = str;
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
        return this.f14886a.equals(((Uri) obj).getAuthority());
    }
}
