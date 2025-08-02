package com.facebook.react.views.textinput;

import androidx.core.util.Predicate;
import androidx.core.util.n;
import com.facebook.react.views.text.internal.span.ReactUnderlineSpan;

public final /* synthetic */ class g implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactEditText f4328a;

    public /* synthetic */ g(ReactEditText reactEditText) {
        this.f4328a = reactEditText;
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
        return this.f4328a.B((ReactUnderlineSpan) obj);
    }
}
