package com.facebook.react.views.textinput;

import androidx.core.util.Predicate;
import androidx.core.util.n;
import w7.a;

public final /* synthetic */ class h implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReactEditText f4331a;

    public /* synthetic */ h(ReactEditText reactEditText) {
        this.f4331a = reactEditText;
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
        return this.f4331a.C((a) obj);
    }
}
