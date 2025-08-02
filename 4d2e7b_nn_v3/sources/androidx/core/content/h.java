package androidx.core.content;

import android.content.ComponentName;
import androidx.core.util.Predicate;
import androidx.core.util.n;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentName f14884a;

    public /* synthetic */ h(ComponentName componentName) {
        this.f14884a = componentName;
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
        return this.f14884a.equals((ComponentName) obj);
    }
}
