package com.facebook.react.views.textinput;

import androidx.core.util.Predicate;
import androidx.core.util.n;
import com.facebook.react.views.text.internal.span.ReactStrikethroughSpan;

public final /* synthetic */ class f implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactEditText f4327a;

    public /* synthetic */ f(ReactEditText reactEditText) {
        this.f4327a = reactEditText;
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
        return this.f4327a.A((ReactStrikethroughSpan) obj);
    }
}
